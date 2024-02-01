package com.sipfront.sdk.utils

@ExperimentalJsExport
internal actual fun randomUUID(): String {
    val crypto = js("window.crypto || window.msCrypto") // For older IE browsers

    // New method that only updated Browsers support
    if (js("typeof crypto.randomUUID === 'function'") as Boolean) {
        return crypto.randomUUID().toString()
    }

    // Fallback 1
    if (js("typeof crypto.getRandomValues === 'function'") as Boolean) {
        val arr = ByteArray(16)
        crypto.getRandomValues(arr)
        // Adjust version and variant bits according to UUID v4 specifications
        arr[6] = (arr[6].toInt() and 0x0f or 0x40).toByte() // Version 4
        arr[8] = (arr[8].toInt() and 0x3f or 0x80).toByte() // Variant 10

        return arr.joinToString("") { byte -> byte.toHexString() }
            .replace(Regex("^(.{8})(.{4})(.{4})(.{4})(.{12})$"), "$1-$2-$3-$4-$5")
    }

    // Fallback 2
    val chars = "0123456789abcdef"
    return (1..32).map {
        if (it == 13) '4' else chars.random()
    }
        .joinToString("")
        .replace(Regex("^(.{8})(.{4})(.{4})(.{4})(.{12})$"), "$1-$2-$3-$4-$5")

}

private fun Byte.toHexString(): String {
    val intVal = this.toInt() and 0xFF
    return intVal.toString(16).padStart(2, '0')
}