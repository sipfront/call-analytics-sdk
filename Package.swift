// swift-tools-version:5.6
import PackageDescription

let package = Package(
    name: "CallAnalyticsSdk",
    platforms: [
        .iOS(.v14),
        .macOS(.v10_14)
        ],
    products: [
        .library(
            name: "CallAnalyticsSdk",
            targets: ["CallAnalyticsSdk"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "CallAnalyticsSdk",
            path: "CallAnalyticsSdk.xcframework"
        ),
    ]
)