# Call Analytics SDK

This optional library allows for Sipfront tests to provide additional data and
statistics by extracting it during your apps runtime and transmitting  to our servers.

Data that is currently obtained:

- SIP messages
- SDP messages
- RTCP messages
- Call state messages

Call Analytics SDK supports extracting this data in various ways and will be expanded in the future

## Supported Platforms

* Android
* Java
* JavaScript (Browser, NodeJs)
* iOS (Arm64, X64, Arm64-Simulator)
* MacOS (Arm64, X64)

## Requirements

* Android 5.0+ (API level 21+) and Java 8+
* iOS 14.1

## Setup

### with Gradle

You can import the dependency without specifying the platform and Gradle will pick the correct
version for your project
```kotlin
implementation 'com.sipfront.sdk:call-analytics:1.0.2'
```

#### Setup specifying Platform

You can also specify the platform, which especially makes sense for Android where a release and
debug build of the library is available
```kotlin
implementation 'com.sipfront.sdk:call-analytics-android:1.0.2'        //Android release
implementation 'com.sipfront.sdk:call-analytics-android-debug:1.0.2'  //Android debug
implementation 'com.sipfront.sdk:call-analytics-jvm:1.0.2'            //Java
implementation 'com.sipfront.sdk:call-analytics-js:1.0.2'             //JavaScript
```

You can find a list of all [supported platforms here](https://central.sonatype.com/namespace/com.sipfront.sdk)

#### Android Release/Debug BuildTypes

- Release: No debug logs, obfuscated and shrunk for small filesize. Recommended for most use cases
- Debug: With debug logs, not obfuscated or shrunk

#### Exclude Call Analytics SDK from release builds of your app

Even though Call Analytics SDK will fail to initialise outside of Sipfront tests and thus wont send any
data to our servers it makes sense to exclude our SDK from your release builds in order to optimize
your apps size
```kotlin
// Include only in debug builds
debugImplementation 'com.sipfront.sdk:call-analytics:1.0.2'
// Or include only in a custom build flavor
customFlavorImplementation 'com.sipfront.sdk:call-analytics:1.0.2'
```

### with CocoaPods

Add the following pod to your Podfile and build your project

```
pod 'CallAnalyticsSdk', '~> 1.0.2'
```

To import the library

```
import CallAnalyticsSdk
```

### with downloadable XCFramework

We also provide with each release tag a downloadable XCFramework which you can manually add to your iOS/Mac project


## Using Call Analytics SDK

#### Initialize Call Analytics SDK

When the app is started in a Sipfront test it will provide credentials and other required
information to the app at app start. You initialize the Sdk in your app by providing this data
to the Sdk at app start

<details open>
  <summary><b>Android</b></summary>

```kotlin
// In onCreate() of your apps Launcher Activity add this code
override fun onCreate(savedInstanceState: Bundle?) {
    if (savedInstanceState == null) {
        try {
            val initialized = CallAnalytics.init(
                // custom Intent arguments provided to app by Sipfront test
                SessionParams(intent),
                // optional configuration
                Config.Builder()
                    .enableDebugLogs(enable = true)
                    .build()
            )
            if(initialized) {
                Log.i("CallAnalytics initialized")
            }
        } catch (e: Exception) {
            Log.e("Could not initialise CallAnalytics, cause: ${e.message}")
        }
    }
}
```
</details>

<details>
  <summary><b>iOS</b></summary>

```swift
// In init() of your SwiftUI.App
struct MyApp: SwiftUI.App {
    init() {
        do {
            let initialized = try CallAnalytics.shared.initialize(
                params: SessionParams(),
                // optional configuration of Sdk
                config: Config.Builder()
                    .enableDebugLogs(true)
                    .trustAllCerts(true)
                    .build()
            )
            if initialized {
                Logger.info("CallAnalytics initialized")
            }
        } catch {
            Logger.notifications.error("CallAnalytics init error: \(error)")
        }
    }
}
```
</details>

#### Initialize Call Analytics SDK with Config

```kotlin
CallAnalytics.init(
    intent,
    Config.Builder()
        .enableLogParser(true)    // enables automatic parsing of Logs for SIP/SDP messages
        .enableDebugLogs(true)    // enables debug logging
        .trustAllCerts(true)      // accepts all certs on SDK HTTPs requests if true
        .build()
)
```

#### Sending For SIP or SDP

Using CallAnalytics.sendSip() or CallAnalytics.sendSdp()

<details open>
  <summary><b>Android</b></summary>

```kotlin
CallAnalytics.sendSip(
    SdpMessage.Builder()
        .message(message = sipMessage)
        .type(type = MessageType.Sip.INCOMING)
        .build()
)
```
</details>

<details>
  <summary><b>iOS</b></summary>

```swift
do {
    try CallAnalytics.shared.send(sip: SipMessage.Builder()
        .message(sipMessage)
        .type(MessageSip.incoming)
        .build())
} catch {
    Logger.notifications.error("CallAnalytics request error: \(error)")
}
```
</details>

Alternatively SDK supports parsing from app logs (can be enabled with SipfrontSdkConfig)

#### Sending RTCP

Using CallAnalytics.sendRtcp()

<details open>
  <summary><b>Android</b></summary>

```kotlin
CallAnalytics.sendRtcp(
    RtcpMessage.Builder()
        .callId(callId)
        .callDirection(CallDirection.INCOMING)
        .addressLocal("+4912311111")
        .addressRemote("+4912322222")
        .displayNameRemote("John Doe")
        .audioDirection(MediaDirection.SEND_RECEIVE)
        .rtt(rtt)             //round trip time in milliseconds
        .rxJitter(jitter)     //jitter in milliseconds
        .rxLost(lost)         //lost packets total
        .rxBytes(bytes)       //bytes received total
        .rxPackets(packets)   //packets received total
        .txBytes(bytes)       //bytes sent total
        .txPackets(packets)   //packets sent total
        .build()
)
```
</details>

<details>
<summary><b>iOS</b></summary>

```swift
do {
    try CallAnalytics.shared.send(rtcp: RtcpMessage.Builder()
        .address(local: "+4912311111")
        .address(remote: "+4912322222")
        .displayName(remote: "John Doe")
        .audio(direction: Media.sendOnly)
        .video(direction: Media.receiveOnly)
        .call(id: "MyCallId")
        .call(direction: Call.incoming)
        .rtt(1.0)           //round trip time in milliseconds
        .rx(lost: 0)        //lost packets total
        .rx(bytes: 99)      //bytes received total
        .rx(packets: 9)     //packets received total
        .rx(jitter: 9)      //jitter in milliseconds
        .tx(packets: 10)    //packets sent total
        .tx(bytes: 100)     //bytes sent total
        .build())
} catch {
    Logger.notifications.error("CallAnalytics request error: \(error)")
}
```
</details>

#### Sending Call States

Using CallAnalytics.sendState()

<details open>
  <summary><b>Android</b></summary>

```kotlin
CallAnalytics.sendState(
    StateMessage.Builder()
        .type(type = MessageType.State.CALL_ESTABLISHED)
        .callId(id = callId)
        .callDirection(direction = CallDirection.OUTGOING)
        .addressLocal(address = "+4912311111")
        .addressRemote(address = "+4912322222")
        .displayNameRemote(displayName = "John Doe")
        .audioDirection(direction = MediaDirection.SEND_RECEIVE)
)
```
</details>

<details>
<summary><b>iOS</b></summary>

```swift
do {
    try CallAnalytics.shared.send(state: StateMessage.Builder()
        .type(MessageState.callEstablished)
        .address(local: "+4912311111")
        .address(remote: "+4912322222")
        .displayName(remote: "John Doe")
        .audio(direction: Media.sendOnly)
        .video(direction: Media.receiveOnly)
        .call(id: "MyCallId")
        .call(direction: Call.incoming)
        .build())
} catch {
    Logger.notifications.error("CallAnalytics request error: \(error)")
}
```
</details>

## License

```
MIT License

Copyright (c) 2023 Sipfront

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
