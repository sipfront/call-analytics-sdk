Pod::Spec.new do |spec|
    spec.name                     = 'CallAnalyticsSdk'
    spec.version                  = '1.0.5'
    spec.homepage                 = 'https://sipfront.com'
    spec.source                   = { :git => 'https://github.com/sipfront/call-analytics-sdk.git', :tag => 'v1.0.5' }
    spec.authors                  = { 'Dominik Ridjic' => 'dominik.ridjic@gmail.com' }
    spec.license                  = { :type => 'MIT', :file => 'LICENSE' }
    spec.summary                  = 'Call Analytics SDK for Sipfront Automated Tests'
    spec.vendored_frameworks      = 'CallAnalyticsSdk.xcframework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '14.1'
                
                
                
                
end