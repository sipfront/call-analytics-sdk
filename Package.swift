import PackageDescription

let package = Package(
    name: "CallAnalyticsSdk",
    products: [
        .library(
            name: "CallAnalyticsSdk",
            targets: ["CallAnalyticsSdk"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "CallAnalyticsSdk",
            path: "./CallAnalyticsSdk.xcframework"
        ),
    ]
)