#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class CASCallAnalytics, CASSessionParams, CASConfig, CASRtcpMessage, CASSdpMessage, CASSipMessage, CASStateMessage, CASSipfrontIntent, CASKotlinEnumCompanion, CASKotlinEnum<E>, CASSipfrontIntentExtra, CASKotlinArray<T>, CASDispatcherProviderCompanion, CASKotlinx_coroutines_coreCoroutineDispatcher, CASOsFamily, CASPlatform, CASLog, CASKermitLogger, CASBaseMessageCompanion, CASBaseMessage, CASRtcpMessageCompanion, CASCall, CASMedia, CASMessageRtcp, CASMessageClass, CASRtcpMessageBuilder, CASSdpMessageCompanion, CASMessageSdp, CASSdpMessageBuilder, CASSipMessageCompanion, CASMessageSip, CASSipMessageBuilder, CASStateMessageCompanion, CASMessageState, CASStateMessageBuilder, CASCallCompanion, CASMediaCompanion, CASMessageClassCompanion, CASMessageCompanion, CASMessageRtcpCompanion, CASMessageSdpCompanion, CASMessageSipCompanion, CASMessageStateCompanion, CASConfigCompanion, CASConfigBuilder, CASKermit_coreLogWriter, CASKotlinThrowable, CASKotlinException, CASKotlinRuntimeException, CASKotlinIllegalArgumentException, CASKotlinAbstractCoroutineContextElement, CASKotlinx_coroutines_coreCoroutineDispatcherKey, CASKermit_coreSeverity, CASKermit_coreBaseLogger, CASKermitLoggerCompanion, CASKotlinx_serialization_coreSerializersModule, CASKotlinx_serialization_coreSerialKind, CASKotlinNothing, CASKtor_client_coreHttpRequestData, CASKtor_client_coreHttpResponseData, CASKtor_client_coreHttpClient, CASKtor_client_coreHttpClientEngineConfig, CASKotlinAbstractCoroutineContextKey<B, E>, CASKotlinIllegalStateException, CASKtor_httpUrl, CASKtor_httpHttpMethod, CASKtor_httpOutgoingContent, CASKtor_httpHttpStatusCode, CASKtor_utilsGMTDate, CASKtor_httpHttpProtocolVersion, CASKtor_client_coreHttpClientConfig<T>, CASKtor_eventsEvents, CASKtor_client_coreHttpReceivePipeline, CASKtor_client_coreHttpRequestPipeline, CASKtor_client_coreHttpResponsePipeline, CASKtor_client_coreHttpSendPipeline, CASKtor_client_coreProxyConfig, CASKtor_httpUrlCompanion, CASKtor_httpURLProtocol, CASKtor_httpHttpMethodCompanion, CASKtor_utilsAttributeKey<T>, CASKtor_httpContentType, CASKotlinCancellationException, CASKtor_httpHttpStatusCodeCompanion, CASKtor_utilsGMTDateCompanion, CASKtor_utilsWeekDay, CASKtor_utilsMonth, CASKtor_httpHttpProtocolVersionCompanion, CASKtor_eventsEventDefinition<T>, CASKtor_utilsPipelinePhase, CASKtor_utilsPipeline<TSubject, TContext>, CASKtor_client_coreHttpReceivePipelinePhases, CASKtor_client_coreHttpResponse, CASKotlinUnit, CASKtor_client_coreHttpRequestPipelinePhases, CASKtor_client_coreHttpRequestBuilder, CASKtor_client_coreHttpResponsePipelinePhases, CASKtor_client_coreHttpResponseContainer, CASKtor_client_coreHttpClientCall, CASKtor_client_coreHttpSendPipelinePhases, CASKtor_httpURLProtocolCompanion, CASKtor_httpHeaderValueParam, CASKtor_httpHeaderValueWithParametersCompanion, CASKtor_httpHeaderValueWithParameters, CASKtor_httpContentTypeCompanion, CASKtor_utilsWeekDayCompanion, CASKtor_utilsMonthCompanion, CASKtor_httpHeadersBuilder, CASKtor_client_coreHttpRequestBuilderCompanion, CASKtor_httpURLBuilder, CASKtor_utilsTypeInfo, CASKtor_client_coreHttpClientCallCompanion, CASKtor_ioMemory, CASKtor_ioChunkBuffer, CASKotlinByteArray, CASKtor_ioBuffer, CASKtor_ioByteReadPacket, CASKtor_utilsStringValuesBuilderImpl, CASKtor_httpURLBuilderCompanion, CASKtor_ioMemoryCompanion, CASKtor_ioBufferCompanion, CASKtor_ioChunkBufferCompanion, CASKotlinByteIterator, CASKtor_ioInputCompanion, CASKtor_ioInput, CASKtor_ioByteReadPacketCompanion, CASKotlinKTypeProjection, CASKotlinKVariance, CASKotlinKTypeProjectionCompanion;

@protocol CASProguardKeep, CASKotlinComparable, CASMessage, CASKotlinx_serialization_coreKSerializer, CASEnumValue, CASKotlinx_serialization_coreEncoder, CASKotlinx_serialization_coreSerialDescriptor, CASKotlinx_serialization_coreSerializationStrategy, CASKotlinx_serialization_coreDecoder, CASKotlinx_serialization_coreDeserializationStrategy, CASKtor_client_coreHttpClientEngine, CASKotlinIterator, CASKotlinCoroutineContextKey, CASKotlinCoroutineContextElement, CASKotlinCoroutineContext, CASKotlinContinuation, CASKotlinContinuationInterceptor, CASKotlinx_coroutines_coreRunnable, CASKermit_coreLoggerConfig, CASKermit_coreMutableLoggerConfig, CASKotlinx_serialization_coreCompositeEncoder, CASKotlinAnnotation, CASKotlinx_serialization_coreCompositeDecoder, CASKtor_client_coreHttpClientEngineCapability, CASKotlinx_coroutines_coreCoroutineScope, CASKtor_ioCloseable, CASKotlinx_serialization_coreSerializersModuleCollector, CASKotlinKClass, CASKtor_httpHeaders, CASKotlinx_coroutines_coreJob, CASKtor_utilsAttributes, CASKotlinKDeclarationContainer, CASKotlinKAnnotatedElement, CASKotlinKClassifier, CASKtor_httpParameters, CASKotlinMapEntry, CASKtor_utilsStringValues, CASKotlinx_coroutines_coreChildHandle, CASKotlinx_coroutines_coreChildJob, CASKotlinx_coroutines_coreDisposableHandle, CASKotlinSequence, CASKotlinx_coroutines_coreSelectClause0, CASKtor_client_coreHttpClientPlugin, CASKotlinSuspendFunction2, CASKotlinx_coroutines_coreParentJob, CASKotlinx_coroutines_coreSelectInstance, CASKotlinx_coroutines_coreSelectClause, CASKotlinFunction, CASKtor_httpHttpMessage, CASKtor_ioByteReadChannel, CASKtor_httpHttpMessageBuilder, CASKtor_client_coreHttpRequest, CASKtor_ioReadSession, CASKotlinSuspendFunction1, CASKotlinAppendable, CASKtor_utilsStringValuesBuilder, CASKtor_httpParametersBuilder, CASKotlinKType, CASKtor_ioObjectPool;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface CASBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface CASBase (CASBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface CASMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface CASMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorCASKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface CASNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface CASByte : CASNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface CASUByte : CASNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface CASShort : CASNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface CASUShort : CASNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface CASInt : CASNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface CASUInt : CASNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface CASLong : CASNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface CASULong : CASNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface CASFloat : CASNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface CASDouble : CASNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface CASBoolean : CASNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((swift_name("ProguardKeep")))
@protocol CASProguardKeep
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CallAnalytics")))
@interface CASCallAnalytics : CASBase <CASProguardKeep>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)callAnalytics __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASCallAnalytics *shared __attribute__((swift_name("shared")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException, SerializationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)initializeParams:(CASSessionParams *)params config:(CASConfig *)config error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("initialize(params:config:)"))) __attribute__((swift_error(nonnull_error)));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (BOOL)isInitialized __attribute__((swift_name("isInitialized()")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendRtcp:(CASRtcpMessage *)rtcp error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(rtcp:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendSdp:(CASSdpMessage *)sdp error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(sdp:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendSip:(CASSipMessage *)sip error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(sip:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendState:(CASStateMessage *)state error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(state:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SessionParams")))
@interface CASSessionParams : CASBase <CASProguardKeep>
- (instancetype)initWithJson:(NSString *)json __attribute__((swift_name("init(json:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SipfrontIntent")))
@interface CASSipfrontIntent : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)sipfrontIntent __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASSipfrontIntent *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol CASKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface CASKotlinEnum<E> : CASBase <CASKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SipfrontIntent.Extra")))
@interface CASSipfrontIntentExtra : CASKotlinEnum<CASSipfrontIntentExtra *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) CASSipfrontIntentExtra *config __attribute__((swift_name("config")));
+ (CASKotlinArray<CASSipfrontIntentExtra *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASSipfrontIntentExtra *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("EnumValue")))
@protocol CASEnumValue <CASProguardKeep>
@required
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DispatcherProvider")))
@interface CASDispatcherProvider : CASBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) CASDispatcherProviderCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DispatcherProvider.Companion")))
@interface CASDispatcherProviderCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASDispatcherProviderCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKotlinx_coroutines_coreCoroutineDispatcher *IO __attribute__((swift_name("IO")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("OsFamily")))
@interface CASOsFamily : CASKotlinEnum<CASOsFamily *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) CASOsFamily *unknown __attribute__((swift_name("unknown")));
@property (class, readonly) CASOsFamily *macosx __attribute__((swift_name("macosx")));
@property (class, readonly) CASOsFamily *ios __attribute__((swift_name("ios")));
@property (class, readonly) CASOsFamily *javascript __attribute__((swift_name("javascript")));
@property (class, readonly) CASOsFamily *java __attribute__((swift_name("java")));
@property (class, readonly) CASOsFamily *linux __attribute__((swift_name("linux")));
@property (class, readonly) CASOsFamily *windows __attribute__((swift_name("windows")));
@property (class, readonly) CASOsFamily *android __attribute__((swift_name("android")));
@property (class, readonly) CASOsFamily *wasm __attribute__((swift_name("wasm")));
@property (class, readonly) CASOsFamily *tvos __attribute__((swift_name("tvos")));
@property (class, readonly) CASOsFamily *watchos __attribute__((swift_name("watchos")));
+ (CASKotlinArray<CASOsFamily *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASOsFamily *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Platform")))
@interface CASPlatform : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)platform __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASPlatform *shared __attribute__((swift_name("shared")));
- (NSString *)getBuildType __attribute__((swift_name("getBuildType()")));
- (NSString *)getDeviceModel __attribute__((swift_name("getDeviceModel()")));
- (CASOsFamily *)getOsFamily __attribute__((swift_name("getOsFamily()")));
- (NSString *)getOsVersion __attribute__((swift_name("getOsVersion()")));
- (BOOL)isDebug __attribute__((swift_name("isDebug()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Log")))
@interface CASLog : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)log __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASLog *shared __attribute__((swift_name("shared")));
- (CASKermitLogger * _Nullable)debug __attribute__((swift_name("debug()")));
- (CASKermitLogger *)release_ __attribute__((swift_name("release()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((swift_name("BaseMessage")))
@interface CASBaseMessage : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) CASBaseMessageCompanion *companion __attribute__((swift_name("companion")));
@property (readonly) double timestamp __attribute__((swift_name("timestamp")));
@property (readonly) id<CASMessage> type __attribute__((swift_name("type")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="RtcpMessage")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RtcpMessage")))
@interface CASRtcpMessage : CASBaseMessage
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) CASRtcpMessageCompanion *companion __attribute__((swift_name("companion")));
- (CASRtcpMessage *)doCopyCallId:(NSString *)callId addresslocal:(NSString *)addresslocal addressremote:(NSString *)addressremote addressRemoteDisplayName:(NSString *)addressRemoteDisplayName callDirection:(CASCall *)callDirection audioDirection:(CASMedia *)audioDirection videoDirection:(CASMedia *)videoDirection audioRemoteDirection:(CASMedia *)audioRemoteDirection videoRemoteDirection:(CASMedia *)videoRemoteDirection param:(NSString *)param rxJitter:(double)rxJitter rxPackets:(int64_t)rxPackets rxLost:(int64_t)rxLost rxBytes:(int64_t)rxBytes txPackets:(int64_t)txPackets txBytes:(int64_t)txBytes rtt:(double)rtt type:(CASMessageRtcp *)type clazz:(CASMessageClass *)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(callId:addresslocal:addressremote:addressRemoteDisplayName:callDirection:audioDirection:videoDirection:audioRemoteDirection:videoRemoteDirection:param:rxJitter:rxPackets:rxLost:rxBytes:txPackets:txBytes:rtt:type:clazz:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peerdisplayname")
*/
@property (readonly) NSString *addressRemoteDisplayName __attribute__((swift_name("addressRemoteDisplayName")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="accountaor")
*/
@property (readonly) NSString *addresslocal __attribute__((swift_name("addresslocal")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peeruri")
*/
@property (readonly) NSString *addressremote __attribute__((swift_name("addressremote")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="audiodir")
*/
@property (readonly) CASMedia *audioDirection __attribute__((swift_name("audioDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="remoteaudiodir")
*/
@property (readonly) CASMedia *audioRemoteDirection __attribute__((swift_name("audioRemoteDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="direction")
*/
@property (readonly) CASCall *callDirection __attribute__((swift_name("callDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="id")
*/
@property (readonly) NSString *callId __attribute__((swift_name("callId")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="param")
*/
@property (readonly) NSString *param __attribute__((swift_name("param")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) double rtt __attribute__((swift_name("rtt")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) int64_t rxBytes __attribute__((swift_name("rxBytes")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) double rxJitter __attribute__((swift_name("rxJitter")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) int64_t rxLost __attribute__((swift_name("rxLost")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) int64_t rxPackets __attribute__((swift_name("rxPackets")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="timestamp")
*/
@property (readonly) double timestamp __attribute__((swift_name("timestamp")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) int64_t txBytes __attribute__((swift_name("txBytes")));

/**
 * @note annotations
 *   kotlinx.serialization.Transient
*/
@property (readonly) int64_t txPackets __attribute__((swift_name("txPackets")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="type")
*/
@property (readonly) CASMessageRtcp *type __attribute__((swift_name("type")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="videodir")
*/
@property (readonly) CASMedia *videoDirection __attribute__((swift_name("videoDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="remotevideodir")
*/
@property (readonly) CASMedia *videoRemoteDirection __attribute__((swift_name("videoRemoteDirection")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RtcpMessage.Builder")))
@interface CASRtcpMessageBuilder : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (CASRtcpMessageBuilder *)addressLocal:(NSString *)local __attribute__((swift_name("address(local:)")));
- (CASRtcpMessageBuilder *)addressRemote:(NSString *)remote __attribute__((swift_name("address(remote:)")));
- (CASRtcpMessageBuilder *)audioDirection:(CASMedia *)direction __attribute__((swift_name("audio(direction:)")));

/**
 * @note This method converts instances of IllegalStateException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (CASRtcpMessage * _Nullable)buildAndReturnError:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("build()")));
- (CASRtcpMessageBuilder *)callDirection:(CASCall *)direction __attribute__((swift_name("call(direction:)")));
- (CASRtcpMessageBuilder *)callId:(NSString *)id __attribute__((swift_name("call(id:)")));
- (CASRtcpMessageBuilder *)displayNameRemote:(NSString *)remote __attribute__((swift_name("displayName(remote:)")));
- (CASRtcpMessageBuilder *)rtt_:(double)__ __attribute__((swift_name("rtt(_:)")));
- (CASRtcpMessageBuilder *)rxBytes:(int64_t)bytes __attribute__((swift_name("rx(bytes:)")));
- (CASRtcpMessageBuilder *)rxJitter:(double)jitter __attribute__((swift_name("rx(jitter:)")));
- (CASRtcpMessageBuilder *)rxLost:(int64_t)lost __attribute__((swift_name("rx(lost:)")));
- (CASRtcpMessageBuilder *)rxPackets:(int64_t)packets __attribute__((swift_name("rx(packets:)")));
- (CASRtcpMessageBuilder *)txBytes:(int64_t)bytes __attribute__((swift_name("tx(bytes:)")));
- (CASRtcpMessageBuilder *)txPackets:(int64_t)packets __attribute__((swift_name("tx(packets:)")));
- (CASRtcpMessageBuilder *)videoDirection:(CASMedia *)direction __attribute__((swift_name("video(direction:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RtcpMessage.Companion")))
@interface CASRtcpMessageCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASRtcpMessageCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="SdpMessage")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SdpMessage")))
@interface CASSdpMessage : CASBaseMessage
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) CASSdpMessageCompanion *companion __attribute__((swift_name("companion")));
- (CASSdpMessage *)doCopyMessage:(NSString *)message type:(CASMessageSdp *)type clazz:(CASMessageClass *)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(message:type:clazz:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="param")
*/
@property (readonly) NSString *message __attribute__((swift_name("message")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="timestamp")
*/
@property (readonly) double timestamp __attribute__((swift_name("timestamp")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="type")
*/
@property (readonly) CASMessageSdp *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SdpMessage.Builder")))
@interface CASSdpMessageBuilder : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of IllegalStateException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (CASSdpMessage * _Nullable)buildAndReturnError:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("build()")));
- (CASSdpMessageBuilder *)message_:(NSString *)__ __attribute__((swift_name("message(_:)")));
- (CASSdpMessageBuilder *)type_:(CASMessageSdp *)__ __attribute__((swift_name("type(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SdpMessage.Companion")))
@interface CASSdpMessageCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASSdpMessageCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="SipMessage")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SipMessage")))
@interface CASSipMessage : CASBaseMessage
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) CASSipMessageCompanion *companion __attribute__((swift_name("companion")));
- (CASSipMessage *)doCopyMessage:(NSString *)message type:(CASMessageSip *)type clazz:(CASMessageClass *)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(message:type:clazz:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="param")
*/
@property (readonly) NSString *message __attribute__((swift_name("message")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="timestamp")
*/
@property (readonly) double timestamp __attribute__((swift_name("timestamp")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="type")
*/
@property (readonly) CASMessageSip *type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SipMessage.Builder")))
@interface CASSipMessageBuilder : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));

/**
 * @note This method converts instances of IllegalStateException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (CASSipMessage * _Nullable)buildAndReturnError:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("build()")));
- (CASSipMessageBuilder *)message_:(NSString *)__ __attribute__((swift_name("message(_:)")));
- (CASSipMessageBuilder *)type_:(CASMessageSip *)__ __attribute__((swift_name("type(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SipMessage.Companion")))
@interface CASSipMessageCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASSipMessageCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
 *   kotlinx.serialization.SerialName(value="StateMessage")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StateMessage")))
@interface CASStateMessage : CASBaseMessage
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) CASStateMessageCompanion *companion __attribute__((swift_name("companion")));
- (CASStateMessage *)doCopyCallId:(NSString * _Nullable)callId addresslocal:(NSString * _Nullable)addresslocal addressremote:(NSString * _Nullable)addressremote addressRemoteDisplayName:(NSString * _Nullable)addressRemoteDisplayName callDirection:(CASCall * _Nullable)callDirection audioDirection:(CASMedia *)audioDirection videoDirection:(CASMedia *)videoDirection audioRemoteDirection:(CASMedia *)audioRemoteDirection videoRemoteDirection:(CASMedia *)videoRemoteDirection type:(CASMessageState *)type clazz:(CASMessageClass *)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(callId:addresslocal:addressremote:addressRemoteDisplayName:callDirection:audioDirection:videoDirection:audioRemoteDirection:videoRemoteDirection:type:clazz:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peerdisplayname")
*/
@property (readonly) NSString * _Nullable addressRemoteDisplayName __attribute__((swift_name("addressRemoteDisplayName")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="accountaor")
*/
@property (readonly) NSString * _Nullable addresslocal __attribute__((swift_name("addresslocal")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peeruri")
*/
@property (readonly) NSString * _Nullable addressremote __attribute__((swift_name("addressremote")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="audiodir")
*/
@property (readonly) CASMedia *audioDirection __attribute__((swift_name("audioDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="remoteaudiodir")
*/
@property (readonly) CASMedia *audioRemoteDirection __attribute__((swift_name("audioRemoteDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="direction")
*/
@property (readonly) CASCall * _Nullable callDirection __attribute__((swift_name("callDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="id")
*/
@property (readonly) NSString * _Nullable callId __attribute__((swift_name("callId")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="timestamp")
*/
@property (readonly) double timestamp __attribute__((swift_name("timestamp")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="type")
*/
@property (readonly) CASMessageState *type __attribute__((swift_name("type")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="videodir")
*/
@property (readonly) CASMedia *videoDirection __attribute__((swift_name("videoDirection")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="remotevideodir")
*/
@property (readonly) CASMedia *videoRemoteDirection __attribute__((swift_name("videoRemoteDirection")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StateMessage.Builder")))
@interface CASStateMessageBuilder : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (CASStateMessageBuilder *)addressLocal:(NSString *)local __attribute__((swift_name("address(local:)")));
- (CASStateMessageBuilder *)addressRemote:(NSString *)remote __attribute__((swift_name("address(remote:)")));
- (CASStateMessageBuilder *)audioDirection:(CASMedia *)direction __attribute__((swift_name("audio(direction:)")));

/**
 * @note This method converts instances of IllegalStateException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (CASStateMessage * _Nullable)buildAndReturnError:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("build()")));
- (CASStateMessageBuilder *)callDirection:(CASCall *)direction __attribute__((swift_name("call(direction:)")));
- (CASStateMessageBuilder *)callId:(NSString *)id __attribute__((swift_name("call(id:)")));
- (CASStateMessageBuilder *)displayNameRemote:(NSString *)remote __attribute__((swift_name("displayName(remote:)")));
- (CASStateMessageBuilder *)type_:(CASMessageState *)__ __attribute__((swift_name("type(_:)")));
- (CASStateMessageBuilder *)videoDirection:(CASMedia *)direction __attribute__((swift_name("video(direction:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("StateMessage.Companion")))
@interface CASStateMessageCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASStateMessageCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/CallDirectionSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Call")))
@interface CASCall : CASKotlinEnum<CASCall *> <CASEnumValue>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASCallCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASCall *incoming __attribute__((swift_name("incoming")));
@property (class, readonly) CASCall *outgoing __attribute__((swift_name("outgoing")));
@property (class, readonly) CASCall *none __attribute__((swift_name("none")));
+ (CASKotlinArray<CASCall *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASCall *> *entries __attribute__((swift_name("entries")));
- (CASCall *)invert __attribute__((swift_name("invert()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Call.Companion")))
@interface CASCallCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASCallCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/MediaDirectionSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Media")))
@interface CASMedia : CASKotlinEnum<CASMedia *> <CASEnumValue>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASMediaCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASMedia *sendReceive __attribute__((swift_name("sendReceive")));
@property (class, readonly) CASMedia *receiveOnly __attribute__((swift_name("receiveOnly")));
@property (class, readonly) CASMedia *sendOnly __attribute__((swift_name("sendOnly")));
@property (class, readonly) CASMedia *inactive __attribute__((swift_name("inactive")));
+ (CASKotlinArray<CASMedia *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASMedia *> *entries __attribute__((swift_name("entries")));
- (CASMedia *)toRemote __attribute__((swift_name("toRemote()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Media.Companion")))
@interface CASMediaCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMediaCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/MessageClassSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageClass")))
@interface CASMessageClass : CASKotlinEnum<CASMessageClass *> <CASEnumValue>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASMessageClassCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASMessageClass *trace __attribute__((swift_name("trace")));
@property (class, readonly) CASMessageClass *call __attribute__((swift_name("call")));
@property (class, readonly) CASMessageClass *rtcp __attribute__((swift_name("rtcp")));
@property (class, readonly) CASMessageClass *create __attribute__((swift_name("create")));
@property (class, readonly) CASMessageClass *shutdown __attribute__((swift_name("shutdown")));
@property (class, readonly) CASMessageClass *exit __attribute__((swift_name("exit")));
@property (class, readonly) CASMessageClass *registering __attribute__((swift_name("registering")));
@property (class, readonly) CASMessageClass *unregistering __attribute__((swift_name("unregistering")));
@property (class, readonly) CASMessageClass *register_ __attribute__((swift_name("register_")));
@property (class, readonly) CASMessageClass *other __attribute__((swift_name("other")));
+ (CASKotlinArray<CASMessageClass *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASMessageClass *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageClass.Companion")))
@interface CASMessageClassCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMessageClassCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end

__attribute__((swift_name("Message")))
@protocol CASMessage <CASEnumValue>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageCompanion")))
@interface CASMessageCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMessageCompanion *shared __attribute__((swift_name("shared")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/RtcpSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageRtcp")))
@interface CASMessageRtcp : CASKotlinEnum<CASMessageRtcp *> <CASMessage>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASMessageRtcpCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASMessageRtcp *rtcp __attribute__((swift_name("rtcp")));
+ (CASKotlinArray<CASMessageRtcp *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASMessageRtcp *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageRtcp.Companion")))
@interface CASMessageRtcpCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMessageRtcpCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/SdpSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageSdp")))
@interface CASMessageSdp : CASKotlinEnum<CASMessageSdp *> <CASMessage>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASMessageSdpCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASMessageSdp *outgoing __attribute__((swift_name("outgoing")));
@property (class, readonly) CASMessageSdp *incoming __attribute__((swift_name("incoming")));
+ (CASKotlinArray<CASMessageSdp *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASMessageSdp *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageSdp.Companion")))
@interface CASMessageSdpCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMessageSdpCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/SipSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageSip")))
@interface CASMessageSip : CASKotlinEnum<CASMessageSip *> <CASMessage>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASMessageSipCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASMessageSip *outgoing __attribute__((swift_name("outgoing")));
@property (class, readonly) CASMessageSip *incoming __attribute__((swift_name("incoming")));
+ (CASKotlinArray<CASMessageSip *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASMessageSip *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageSip.Companion")))
@interface CASMessageSipCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMessageSipCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=com/sipfront/sdk/json/serializer/StateSerializer))
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageState")))
@interface CASMessageState : CASKotlinEnum<CASMessageState *> <CASMessage>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASMessageStateCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASMessageState *create __attribute__((swift_name("create")));
@property (class, readonly) CASMessageState *register_ __attribute__((swift_name("register_")));
@property (class, readonly) CASMessageState *registering __attribute__((swift_name("registering")));
@property (class, readonly) CASMessageState *unregistering __attribute__((swift_name("unregistering")));
@property (class, readonly) CASMessageState *shutdown __attribute__((swift_name("shutdown")));
@property (class, readonly) CASMessageState *exit __attribute__((swift_name("exit")));
@property (class, readonly) CASMessageState *callIncoming __attribute__((swift_name("callIncoming")));
@property (class, readonly) CASMessageState *callOutgoing __attribute__((swift_name("callOutgoing")));
@property (class, readonly) CASMessageState *callRinging __attribute__((swift_name("callRinging")));
@property (class, readonly) CASMessageState *callEstablished __attribute__((swift_name("callEstablished")));
@property (class, readonly) CASMessageState *callRtpEstablished __attribute__((swift_name("callRtpEstablished")));
@property (class, readonly) CASMessageState *callEndedLocal __attribute__((swift_name("callEndedLocal")));
@property (class, readonly) CASMessageState *callEndedRemote __attribute__((swift_name("callEndedRemote")));
@property (class, readonly) CASMessageState *callRejected __attribute__((swift_name("callRejected")));
@property (class, readonly) CASMessageState *callFailed __attribute__((swift_name("callFailed")));
@property (class, readonly) CASMessageState *callClosed __attribute__((swift_name("callClosed")));
@property (class, readonly) CASMessageState *callInProgress __attribute__((swift_name("callInProgress")));
+ (CASKotlinArray<CASMessageState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASMessageState *> *entries __attribute__((swift_name("entries")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("MessageState.Companion")))
@interface CASMessageStateCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASMessageStateCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("BaseMessage.Companion")))
@interface CASBaseMessageCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASBaseMessageCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializerTypeParamsSerializers:(CASKotlinArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeParamsSerializers __attribute__((swift_name("serializer(typeParamsSerializers:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Config")))
@interface CASConfig : CASBase <CASProguardKeep>
@property (class, readonly, getter=companion) CASConfigCompanion *companion __attribute__((swift_name("companion")));
- (CASConfig *)doCopyEnablePjsua:(BOOL)enablePjsua enableLogParser:(BOOL)enableLogParser enableDebugLogs:(BOOL)enableDebugLogs trustAllCerts:(BOOL)trustAllCerts __attribute__((swift_name("doCopy(enablePjsua:enableLogParser:enableDebugLogs:trustAllCerts:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL enableDebugLogs __attribute__((swift_name("enableDebugLogs")));
@property (readonly) BOOL enableLogParser __attribute__((swift_name("enableLogParser")));
@property (readonly) BOOL trustAllCerts __attribute__((swift_name("trustAllCerts")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Config.Builder")))
@interface CASConfigBuilder : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (CASConfig *)build __attribute__((swift_name("build()")));
- (CASConfigBuilder *)enableDebugLogs_:(BOOL)__ __attribute__((swift_name("enableDebugLogs(_:)")));
- (CASConfigBuilder *)trustAllCerts_:(BOOL)__ __attribute__((swift_name("trustAllCerts(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Config.Companion")))
@interface CASConfigCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASConfigCompanion *shared __attribute__((swift_name("shared")));
- (id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol CASKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<CASKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<CASKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol CASKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<CASKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<CASKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol CASKotlinx_serialization_coreKSerializer <CASKotlinx_serialization_coreSerializationStrategy, CASKotlinx_serialization_coreDeserializationStrategy>
@required
@end

__attribute__((swift_name("EnumValueSerializer")))
@interface CASEnumValueSerializer<T> : CASBase <CASKotlinx_serialization_coreKSerializer, CASProguardKeep>
- (instancetype)initWithEnumValues:(CASKotlinArray<T> *)enumValues __attribute__((swift_name("init(enumValues:)"))) __attribute__((objc_designated_initializer));
- (T)deserializeDecoder:(id<CASKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
- (void)serializeEncoder:(id<CASKotlinx_serialization_coreEncoder>)encoder value:(T)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<CASKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("DnsResolve_appleKt")))
@interface CASDnsResolve_appleKt : CASBase
+ (NSString * _Nullable)resolveCnameServer:(NSString *)server __attribute__((swift_name("resolveCname(server:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UUID_appleKt")))
@interface CASUUID_appleKt : CASBase
+ (NSString *)randomUUID __attribute__((swift_name("randomUUID()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Log_appleKt")))
@interface CASLog_appleKt : CASBase
+ (CASKermit_coreLogWriter *)getLogWriter __attribute__((swift_name("getLogWriter()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("LogParser_iosKt")))
@interface CASLogParser_iosKt : CASBase
+ (void)processLogsProcessLogLine:(void (^)(NSString *))processLogLine __attribute__((swift_name("processLogs(processLogLine:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("HttpConfig_appleKt")))
@interface CASHttpConfig_appleKt : CASBase
+ (id<CASKtor_client_coreHttpClientEngine>)getHttpClientEngineTrustAllCerts:(BOOL)trustAllCerts customSSLAlpn:(NSString * _Nullable)customSSLAlpn __attribute__((swift_name("getHttpClientEngine(trustAllCerts:customSSLAlpn:)")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface CASKotlinThrowable : CASBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (CASKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) CASKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface CASKotlinException : CASKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface CASKotlinRuntimeException : CASKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface CASKotlinIllegalStateException : CASKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalArgumentException")))
@interface CASKotlinIllegalArgumentException : CASKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationException")))
@interface CASKotlinx_serialization_coreSerializationException : CASKotlinIllegalArgumentException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface CASKotlinEnumCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface CASKotlinArray<T> : CASBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(CASInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<CASKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinCoroutineContext")))
@protocol CASKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<CASKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<CASKotlinCoroutineContextElement> _Nullable)getKey:(id<CASKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<CASKotlinCoroutineContext>)minusKeyKey:(id<CASKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<CASKotlinCoroutineContext>)plusContext:(id<CASKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol CASKotlinCoroutineContextElement <CASKotlinCoroutineContext>
@required
@property (readonly) id<CASKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinAbstractCoroutineContextElement")))
@interface CASKotlinAbstractCoroutineContextElement : CASBase <CASKotlinCoroutineContextElement>
- (instancetype)initWithKey:(id<CASKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer));
@property (readonly) id<CASKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinContinuationInterceptor")))
@protocol CASKotlinContinuationInterceptor <CASKotlinCoroutineContextElement>
@required
- (id<CASKotlinContinuation>)interceptContinuationContinuation:(id<CASKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (void)releaseInterceptedContinuationContinuation:(id<CASKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher")))
@interface CASKotlinx_coroutines_coreCoroutineDispatcher : CASKotlinAbstractCoroutineContextElement <CASKotlinContinuationInterceptor>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithKey:(id<CASKotlinCoroutineContextKey>)key __attribute__((swift_name("init(key:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKotlinx_coroutines_coreCoroutineDispatcherKey *companion __attribute__((swift_name("companion")));
- (void)dispatchContext:(id<CASKotlinCoroutineContext>)context block:(id<CASKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatch(context:block:)")));
- (void)dispatchYieldContext:(id<CASKotlinCoroutineContext>)context block:(id<CASKotlinx_coroutines_coreRunnable>)block __attribute__((swift_name("dispatchYield(context:block:)")));
- (id<CASKotlinContinuation>)interceptContinuationContinuation:(id<CASKotlinContinuation>)continuation __attribute__((swift_name("interceptContinuation(continuation:)")));
- (BOOL)isDispatchNeededContext:(id<CASKotlinCoroutineContext>)context __attribute__((swift_name("isDispatchNeeded(context:)")));

/**
 * @note annotations
 *   kotlinx.coroutines.ExperimentalCoroutinesApi
*/
- (CASKotlinx_coroutines_coreCoroutineDispatcher *)limitedParallelismParallelism:(int32_t)parallelism __attribute__((swift_name("limitedParallelism(parallelism:)")));
- (CASKotlinx_coroutines_coreCoroutineDispatcher *)plusOther:(CASKotlinx_coroutines_coreCoroutineDispatcher *)other __attribute__((swift_name("plus(other:)"))) __attribute__((unavailable("Operator '+' on two CoroutineDispatcher objects is meaningless. CoroutineDispatcher is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The dispatcher to the right of `+` just replaces the dispatcher to the left.")));
- (void)releaseInterceptedContinuationContinuation:(id<CASKotlinContinuation>)continuation __attribute__((swift_name("releaseInterceptedContinuation(continuation:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Kermit_coreBaseLogger")))
@interface CASKermit_coreBaseLogger : CASBase
- (instancetype)initWithConfig:(id<CASKermit_coreLoggerConfig>)config __attribute__((swift_name("init(config:)"))) __attribute__((objc_designated_initializer));
- (void)logSeverity:(CASKermit_coreSeverity *)severity tag:(NSString *)tag throwable:(CASKotlinThrowable * _Nullable)throwable message:(NSString *)message __attribute__((swift_name("log(severity:tag:throwable:message:)")));
- (void)logBlockSeverity:(CASKermit_coreSeverity *)severity tag:(NSString *)tag throwable:(CASKotlinThrowable * _Nullable)throwable message:(NSString *(^)(void))message __attribute__((swift_name("logBlock(severity:tag:throwable:message:)")));
- (void)processLogSeverity:(CASKermit_coreSeverity *)severity tag:(NSString *)tag throwable:(CASKotlinThrowable * _Nullable)throwable message:(NSString *)message __attribute__((swift_name("processLog(severity:tag:throwable:message:)")));
@property (readonly) id<CASKermit_coreLoggerConfig> config __attribute__((swift_name("config")));
@property (readonly) id<CASKermit_coreMutableLoggerConfig> mutableConfig __attribute__((swift_name("mutableConfig")));
@end

__attribute__((swift_name("KermitLogger")))
@interface CASKermitLogger : CASKermit_coreBaseLogger
- (instancetype)initWithConfig:(id<CASKermit_coreLoggerConfig>)config tag:(NSString *)tag __attribute__((swift_name("init(config:tag:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithConfig:(id<CASKermit_coreLoggerConfig>)config __attribute__((swift_name("init(config:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKermitLoggerCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)aMessageString:(NSString *)messageString throwable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag __attribute__((swift_name("a(messageString:throwable:tag:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)aThrowable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag message:(NSString *(^)(void))message __attribute__((swift_name("a(throwable:tag:message:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)dMessageString:(NSString *)messageString throwable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag __attribute__((swift_name("d(messageString:throwable:tag:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)dThrowable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag message:(NSString *(^)(void))message __attribute__((swift_name("d(throwable:tag:message:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)eMessageString:(NSString *)messageString throwable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag __attribute__((swift_name("e(messageString:throwable:tag:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)eThrowable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag message:(NSString *(^)(void))message __attribute__((swift_name("e(throwable:tag:message:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)iMessageString:(NSString *)messageString throwable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag __attribute__((swift_name("i(messageString:throwable:tag:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)iThrowable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag message:(NSString *(^)(void))message __attribute__((swift_name("i(throwable:tag:message:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)vMessageString:(NSString *)messageString throwable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag __attribute__((swift_name("v(messageString:throwable:tag:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)vThrowable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag message:(NSString *(^)(void))message __attribute__((swift_name("v(throwable:tag:message:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)wMessageString:(NSString *)messageString throwable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag __attribute__((swift_name("w(messageString:throwable:tag:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmOverloads
*/
- (void)wThrowable:(CASKotlinThrowable * _Nullable)throwable tag:(NSString *)tag message:(NSString *(^)(void))message __attribute__((swift_name("w(throwable:tag:message:)")));
- (CASKermitLogger *)withTagTag:(NSString *)tag __attribute__((swift_name("withTag(tag:)")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol CASKotlinx_serialization_coreEncoder
@required
- (id<CASKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<CASKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<CASKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<CASKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<CASKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) CASKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol CASKotlinx_serialization_coreSerialDescriptor
@required

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSArray<id<CASKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<CASKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSArray<id<CASKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) CASKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol CASKotlinx_serialization_coreDecoder
@required
- (id<CASKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<CASKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (CASKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<CASKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<CASKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) CASKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kermit_coreLogWriter")))
@interface CASKermit_coreLogWriter : CASBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)isLoggableTag:(NSString *)tag severity:(CASKermit_coreSeverity *)severity __attribute__((swift_name("isLoggable(tag:severity:)")));
- (void)logSeverity:(CASKermit_coreSeverity *)severity message:(NSString *)message tag:(NSString *)tag throwable:(CASKotlinThrowable * _Nullable)throwable __attribute__((swift_name("log(severity:message:tag:throwable:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol CASKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<CASKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end

__attribute__((swift_name("Ktor_ioCloseable")))
@protocol CASKtor_ioCloseable
@required
- (void)close __attribute__((swift_name("close()")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientEngine")))
@protocol CASKtor_client_coreHttpClientEngine <CASKotlinx_coroutines_coreCoroutineScope, CASKtor_ioCloseable>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeData:(CASKtor_client_coreHttpRequestData *)data completionHandler:(void (^)(CASKtor_client_coreHttpResponseData * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(data:completionHandler:)")));
- (void)installClient:(CASKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
@property (readonly) CASKtor_client_coreHttpClientEngineConfig *config __attribute__((swift_name("config")));
@property (readonly) CASKotlinx_coroutines_coreCoroutineDispatcher *dispatcher __attribute__((swift_name("dispatcher")));
@property (readonly) NSSet<id<CASKtor_client_coreHttpClientEngineCapability>> *supportedCapabilities __attribute__((swift_name("supportedCapabilities")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol CASKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol CASKotlinCoroutineContextKey
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinContinuation")))
@protocol CASKotlinContinuation
@required
- (void)resumeWithResult:(id _Nullable)result __attribute__((swift_name("resumeWith(result:)")));
@property (readonly) id<CASKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
 *   kotlin.ExperimentalStdlibApi
*/
__attribute__((swift_name("KotlinAbstractCoroutineContextKey")))
@interface CASKotlinAbstractCoroutineContextKey<B, E> : CASBase <CASKotlinCoroutineContextKey>
- (instancetype)initWithBaseKey:(id<CASKotlinCoroutineContextKey>)baseKey safeCast:(E _Nullable (^)(id<CASKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.ExperimentalStdlibApi
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineDispatcher.Key")))
@interface CASKotlinx_coroutines_coreCoroutineDispatcherKey : CASKotlinAbstractCoroutineContextKey<id<CASKotlinContinuationInterceptor>, CASKotlinx_coroutines_coreCoroutineDispatcher *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithBaseKey:(id<CASKotlinCoroutineContextKey>)baseKey safeCast:(id<CASKotlinCoroutineContextElement> _Nullable (^)(id<CASKotlinCoroutineContextElement>))safeCast __attribute__((swift_name("init(baseKey:safeCast:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)key __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKotlinx_coroutines_coreCoroutineDispatcherKey *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreRunnable")))
@protocol CASKotlinx_coroutines_coreRunnable
@required
- (void)run __attribute__((swift_name("run()")));
@end

__attribute__((swift_name("Kermit_coreLoggerConfig")))
@protocol CASKermit_coreLoggerConfig
@required
@property (readonly) NSArray<CASKermit_coreLogWriter *> *logWriterList __attribute__((swift_name("logWriterList")));
@property (readonly) CASKermit_coreSeverity *minSeverity __attribute__((swift_name("minSeverity")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kermit_coreSeverity")))
@interface CASKermit_coreSeverity : CASKotlinEnum<CASKermit_coreSeverity *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) CASKermit_coreSeverity *verbose __attribute__((swift_name("verbose")));
@property (class, readonly) CASKermit_coreSeverity *debug __attribute__((swift_name("debug")));
@property (class, readonly) CASKermit_coreSeverity *info __attribute__((swift_name("info")));
@property (class, readonly) CASKermit_coreSeverity *warn __attribute__((swift_name("warn")));
@property (class, readonly) CASKermit_coreSeverity *error __attribute__((swift_name("error")));
@property (class, readonly) CASKermit_coreSeverity *assert __attribute__((swift_name("assert")));
+ (CASKotlinArray<CASKermit_coreSeverity *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASKermit_coreSeverity *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((swift_name("Kermit_coreMutableLoggerConfig")))
@protocol CASKermit_coreMutableLoggerConfig <CASKermit_coreLoggerConfig>
@required
- (void)setLogWriterList:(NSArray<CASKermit_coreLogWriter *> *)value __attribute__((swift_name("setLogWriterList(_:)")));
- (void)setMinSeverity:(CASKermit_coreSeverity *)value __attribute__((swift_name("setMinSeverity(_:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KermitLogger.Companion")))
@interface CASKermitLoggerCompanion : CASKermitLogger
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithConfig:(id<CASKermit_coreLoggerConfig>)config tag:(NSString *)tag __attribute__((swift_name("init(config:tag:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKermitLoggerCompanion *shared __attribute__((swift_name("shared")));
- (void)addLogWriterLogWriter:(CASKotlinArray<CASKermit_coreLogWriter *> *)logWriter __attribute__((swift_name("addLogWriter(logWriter:)")));
- (void)setLogWritersLogWriter:(CASKotlinArray<CASKermit_coreLogWriter *> *)logWriter __attribute__((swift_name("setLogWriters(logWriter:)")));
- (void)setLogWritersLogWriters:(NSArray<CASKermit_coreLogWriter *> *)logWriters __attribute__((swift_name("setLogWriters(logWriters:)")));
- (void)setMinSeveritySeverity:(CASKermit_coreSeverity *)severity __attribute__((swift_name("setMinSeverity(severity:)")));
- (void)setTagTag:(NSString *)tag __attribute__((swift_name("setTag(tag:)")));
@property (readonly) NSString *tag __attribute__((swift_name("tag")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol CASKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<CASKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<CASKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<CASKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) CASKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface CASKotlinx_serialization_coreSerializersModule : CASBase

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<CASKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<CASKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<CASKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<CASKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<CASKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<CASKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<CASKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<CASKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol CASKotlinAnnotation
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface CASKotlinx_serialization_coreSerialKind : CASBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol CASKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<CASKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<CASKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<CASKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<CASKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) CASKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface CASKotlinNothing : CASBase
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface CASKotlinCancellationException : CASKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestData")))
@interface CASKtor_client_coreHttpRequestData : CASBase
- (instancetype)initWithUrl:(CASKtor_httpUrl *)url method:(CASKtor_httpHttpMethod *)method headers:(id<CASKtor_httpHeaders>)headers body:(CASKtor_httpOutgoingContent *)body executionContext:(id<CASKotlinx_coroutines_coreJob>)executionContext attributes:(id<CASKtor_utilsAttributes>)attributes __attribute__((swift_name("init(url:method:headers:body:executionContext:attributes:)"))) __attribute__((objc_designated_initializer));
- (id _Nullable)getCapabilityOrNullKey:(id<CASKtor_client_coreHttpClientEngineCapability>)key __attribute__((swift_name("getCapabilityOrNull(key:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<CASKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) CASKtor_httpOutgoingContent *body __attribute__((swift_name("body")));
@property (readonly) id<CASKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) id<CASKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) CASKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) CASKtor_httpUrl *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseData")))
@interface CASKtor_client_coreHttpResponseData : CASBase
- (instancetype)initWithStatusCode:(CASKtor_httpHttpStatusCode *)statusCode requestTime:(CASKtor_utilsGMTDate *)requestTime headers:(id<CASKtor_httpHeaders>)headers version:(CASKtor_httpHttpProtocolVersion *)version body:(id)body callContext:(id<CASKotlinCoroutineContext>)callContext __attribute__((swift_name("init(statusCode:requestTime:headers:version:body:callContext:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id body __attribute__((swift_name("body")));
@property (readonly) id<CASKotlinCoroutineContext> callContext __attribute__((swift_name("callContext")));
@property (readonly) id<CASKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) CASKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) CASKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) CASKtor_httpHttpStatusCode *statusCode __attribute__((swift_name("statusCode")));
@property (readonly) CASKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClient")))
@interface CASKtor_client_coreHttpClient : CASBase <CASKotlinx_coroutines_coreCoroutineScope, CASKtor_ioCloseable>
- (instancetype)initWithEngine:(id<CASKtor_client_coreHttpClientEngine>)engine userConfig:(CASKtor_client_coreHttpClientConfig<CASKtor_client_coreHttpClientEngineConfig *> *)userConfig __attribute__((swift_name("init(engine:userConfig:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (CASKtor_client_coreHttpClient *)configBlock:(void (^)(CASKtor_client_coreHttpClientConfig<id> *))block __attribute__((swift_name("config(block:)")));
- (BOOL)isSupportedCapability:(id<CASKtor_client_coreHttpClientEngineCapability>)capability __attribute__((swift_name("isSupported(capability:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<CASKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) id<CASKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property (readonly) id<CASKtor_client_coreHttpClientEngine> engine __attribute__((swift_name("engine")));
@property (readonly) CASKtor_client_coreHttpClientEngineConfig *engineConfig __attribute__((swift_name("engineConfig")));
@property (readonly) CASKtor_eventsEvents *monitor __attribute__((swift_name("monitor")));
@property (readonly) CASKtor_client_coreHttpReceivePipeline *receivePipeline __attribute__((swift_name("receivePipeline")));
@property (readonly) CASKtor_client_coreHttpRequestPipeline *requestPipeline __attribute__((swift_name("requestPipeline")));
@property (readonly) CASKtor_client_coreHttpResponsePipeline *responsePipeline __attribute__((swift_name("responsePipeline")));
@property (readonly) CASKtor_client_coreHttpSendPipeline *sendPipeline __attribute__((swift_name("sendPipeline")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientEngineConfig")))
@interface CASKtor_client_coreHttpClientEngineConfig : CASBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property BOOL pipelining __attribute__((swift_name("pipelining")));
@property CASKtor_client_coreProxyConfig * _Nullable proxy __attribute__((swift_name("proxy")));
@property int32_t threadsCount __attribute__((swift_name("threadsCount")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientEngineCapability")))
@protocol CASKtor_client_coreHttpClientEngineCapability
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol CASKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<CASKotlinKClass>)kClass provider:(id<CASKotlinx_serialization_coreKSerializer> (^)(NSArray<id<CASKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<CASKotlinKClass>)kClass serializer:(id<CASKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<CASKotlinKClass>)baseClass actualClass:(id<CASKotlinKClass>)actualClass actualSerializer:(id<CASKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<CASKotlinKClass>)baseClass defaultDeserializerProvider:(id<CASKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<CASKotlinKClass>)baseClass defaultDeserializerProvider:(id<CASKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<CASKotlinKClass>)baseClass defaultSerializerProvider:(id<CASKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol CASKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol CASKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol CASKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol CASKotlinKClass <CASKotlinKDeclarationContainer, CASKotlinKAnnotatedElement, CASKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl")))
@interface CASKtor_httpUrl : CASBase
@property (class, readonly, getter=companion) CASKtor_httpUrlCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *encodedFragment __attribute__((swift_name("encodedFragment")));
@property (readonly) NSString * _Nullable encodedPassword __attribute__((swift_name("encodedPassword")));
@property (readonly) NSString *encodedPath __attribute__((swift_name("encodedPath")));
@property (readonly) NSString *encodedPathAndQuery __attribute__((swift_name("encodedPathAndQuery")));
@property (readonly) NSString *encodedQuery __attribute__((swift_name("encodedQuery")));
@property (readonly) NSString * _Nullable encodedUser __attribute__((swift_name("encodedUser")));
@property (readonly) NSString *fragment __attribute__((swift_name("fragment")));
@property (readonly) NSString *host __attribute__((swift_name("host")));
@property (readonly) id<CASKtor_httpParameters> parameters __attribute__((swift_name("parameters")));
@property (readonly) NSString * _Nullable password __attribute__((swift_name("password")));
@property (readonly) NSArray<NSString *> *pathSegments __attribute__((swift_name("pathSegments")));
@property (readonly) int32_t port __attribute__((swift_name("port")));
@property (readonly) CASKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property (readonly) int32_t specifiedPort __attribute__((swift_name("specifiedPort")));
@property (readonly) BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property (readonly) NSString * _Nullable user __attribute__((swift_name("user")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod")))
@interface CASKtor_httpHttpMethod : CASBase
- (instancetype)initWithValue:(NSString *)value __attribute__((swift_name("init(value:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_httpHttpMethodCompanion *companion __attribute__((swift_name("companion")));
- (CASKtor_httpHttpMethod *)doCopyValue:(NSString *)value __attribute__((swift_name("doCopy(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Ktor_utilsStringValues")))
@protocol CASKtor_utilsStringValues
@required
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<CASKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (void)forEachBody:(void (^)(NSString *, NSArray<NSString *> *))body __attribute__((swift_name("forEach(body:)")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end

__attribute__((swift_name("Ktor_httpHeaders")))
@protocol CASKtor_httpHeaders <CASKtor_utilsStringValues>
@required
@end

__attribute__((swift_name("Ktor_httpOutgoingContent")))
@interface CASKtor_httpOutgoingContent : CASBase
- (id _Nullable)getPropertyKey:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getProperty(key:)")));
- (void)setPropertyKey:(CASKtor_utilsAttributeKey<id> *)key value:(id _Nullable)value __attribute__((swift_name("setProperty(key:value:)")));
- (id<CASKtor_httpHeaders> _Nullable)trailers __attribute__((swift_name("trailers()")));
@property (readonly) CASLong * _Nullable contentLength __attribute__((swift_name("contentLength")));
@property (readonly) CASKtor_httpContentType * _Nullable contentType __attribute__((swift_name("contentType")));
@property (readonly) id<CASKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@property (readonly) CASKtor_httpHttpStatusCode * _Nullable status __attribute__((swift_name("status")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreJob")))
@protocol CASKotlinx_coroutines_coreJob <CASKotlinCoroutineContextElement>
@required
- (id<CASKotlinx_coroutines_coreChildHandle>)attachChildChild:(id<CASKotlinx_coroutines_coreChildJob>)child __attribute__((swift_name("attachChild(child:)")));
- (void)cancelCause:(CASKotlinCancellationException * _Nullable)cause __attribute__((swift_name("cancel(cause:)")));
- (CASKotlinCancellationException *)getCancellationException __attribute__((swift_name("getCancellationException()")));
- (id<CASKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionOnCancelling:(BOOL)onCancelling invokeImmediately:(BOOL)invokeImmediately handler:(void (^)(CASKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(onCancelling:invokeImmediately:handler:)")));
- (id<CASKotlinx_coroutines_coreDisposableHandle>)invokeOnCompletionHandler:(void (^)(CASKotlinThrowable * _Nullable))handler __attribute__((swift_name("invokeOnCompletion(handler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)joinWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("join(completionHandler:)")));
- (id<CASKotlinx_coroutines_coreJob>)plusOther_:(id<CASKotlinx_coroutines_coreJob>)other __attribute__((swift_name("plus(other_:)"))) __attribute__((unavailable("Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")));
- (BOOL)start __attribute__((swift_name("start()")));
@property (readonly) id<CASKotlinSequence> children __attribute__((swift_name("children")));
@property (readonly) BOOL isActive __attribute__((swift_name("isActive")));
@property (readonly) BOOL isCancelled __attribute__((swift_name("isCancelled")));
@property (readonly) BOOL isCompleted __attribute__((swift_name("isCompleted")));
@property (readonly) id<CASKotlinx_coroutines_coreSelectClause0> onJoin __attribute__((swift_name("onJoin")));

/**
 * @note annotations
 *   kotlinx.coroutines.ExperimentalCoroutinesApi
*/
@property (readonly) id<CASKotlinx_coroutines_coreJob> _Nullable parent __attribute__((swift_name("parent")));
@end

__attribute__((swift_name("Ktor_utilsAttributes")))
@protocol CASKtor_utilsAttributes
@required
- (id)computeIfAbsentKey:(CASKtor_utilsAttributeKey<id> *)key block:(id (^)(void))block __attribute__((swift_name("computeIfAbsent(key:block:)")));
- (BOOL)containsKey:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("contains(key:)")));
- (id)getKey_:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("get(key_:)")));
- (id _Nullable)getOrNullKey:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("getOrNull(key:)")));
- (void)putKey:(CASKtor_utilsAttributeKey<id> *)key value:(id)value __attribute__((swift_name("put(key:value:)")));
- (void)removeKey:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("remove(key:)")));
- (id)takeKey:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("take(key:)")));
- (id _Nullable)takeOrNullKey:(CASKtor_utilsAttributeKey<id> *)key __attribute__((swift_name("takeOrNull(key:)")));
@property (readonly) NSArray<CASKtor_utilsAttributeKey<id> *> *allKeys __attribute__((swift_name("allKeys")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode")))
@interface CASKtor_httpHttpStatusCode : CASBase <CASKotlinComparable>
- (instancetype)initWithValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("init(value:description:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_httpHttpStatusCodeCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(CASKtor_httpHttpStatusCode *)other __attribute__((swift_name("compareTo(other:)")));
- (CASKtor_httpHttpStatusCode *)doCopyValue:(int32_t)value description:(NSString *)description __attribute__((swift_name("doCopy(value:description:)")));
- (CASKtor_httpHttpStatusCode *)descriptionValue:(NSString *)value __attribute__((swift_name("description(value:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *description_ __attribute__((swift_name("description_")));
@property (readonly) int32_t value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate")))
@interface CASKtor_utilsGMTDate : CASBase <CASKotlinComparable>
@property (class, readonly, getter=companion) CASKtor_utilsGMTDateCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(CASKtor_utilsGMTDate *)other __attribute__((swift_name("compareTo(other:)")));
- (CASKtor_utilsGMTDate *)doCopySeconds:(int32_t)seconds minutes:(int32_t)minutes hours:(int32_t)hours dayOfWeek:(CASKtor_utilsWeekDay *)dayOfWeek dayOfMonth:(int32_t)dayOfMonth dayOfYear:(int32_t)dayOfYear month:(CASKtor_utilsMonth *)month year:(int32_t)year timestamp:(int64_t)timestamp __attribute__((swift_name("doCopy(seconds:minutes:hours:dayOfWeek:dayOfMonth:dayOfYear:month:year:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t dayOfMonth __attribute__((swift_name("dayOfMonth")));
@property (readonly) CASKtor_utilsWeekDay *dayOfWeek __attribute__((swift_name("dayOfWeek")));
@property (readonly) int32_t dayOfYear __attribute__((swift_name("dayOfYear")));
@property (readonly) int32_t hours __attribute__((swift_name("hours")));
@property (readonly) int32_t minutes __attribute__((swift_name("minutes")));
@property (readonly) CASKtor_utilsMonth *month __attribute__((swift_name("month")));
@property (readonly) int32_t seconds __attribute__((swift_name("seconds")));
@property (readonly) int64_t timestamp __attribute__((swift_name("timestamp")));
@property (readonly) int32_t year __attribute__((swift_name("year")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion")))
@interface CASKtor_httpHttpProtocolVersion : CASBase
- (instancetype)initWithName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("init(name:major:minor:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_httpHttpProtocolVersionCompanion *companion __attribute__((swift_name("companion")));
- (CASKtor_httpHttpProtocolVersion *)doCopyName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("doCopy(name:major:minor:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t major __attribute__((swift_name("major")));
@property (readonly) int32_t minor __attribute__((swift_name("minor")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientConfig")))
@interface CASKtor_client_coreHttpClientConfig<T> : CASBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (CASKtor_client_coreHttpClientConfig<T> *)clone __attribute__((swift_name("clone()")));
- (void)engineBlock:(void (^)(T))block __attribute__((swift_name("engine(block:)")));
- (void)installClient:(CASKtor_client_coreHttpClient *)client __attribute__((swift_name("install(client:)")));
- (void)installPlugin:(id<CASKtor_client_coreHttpClientPlugin>)plugin configure:(void (^)(id))configure __attribute__((swift_name("install(plugin:configure:)")));
- (void)installKey:(NSString *)key block:(void (^)(CASKtor_client_coreHttpClient *))block __attribute__((swift_name("install(key:block:)")));
- (void)plusAssignOther:(CASKtor_client_coreHttpClientConfig<T> *)other __attribute__((swift_name("plusAssign(other:)")));
@property BOOL developmentMode __attribute__((swift_name("developmentMode")));
@property BOOL expectSuccess __attribute__((swift_name("expectSuccess")));
@property BOOL followRedirects __attribute__((swift_name("followRedirects")));
@property BOOL useDefaultTransformers __attribute__((swift_name("useDefaultTransformers")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_eventsEvents")))
@interface CASKtor_eventsEvents : CASBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)raiseDefinition:(CASKtor_eventsEventDefinition<id> *)definition value:(id _Nullable)value __attribute__((swift_name("raise(definition:value:)")));
- (id<CASKotlinx_coroutines_coreDisposableHandle>)subscribeDefinition:(CASKtor_eventsEventDefinition<id> *)definition handler:(void (^)(id _Nullable))handler __attribute__((swift_name("subscribe(definition:handler:)")));
- (void)unsubscribeDefinition:(CASKtor_eventsEventDefinition<id> *)definition handler:(void (^)(id _Nullable))handler __attribute__((swift_name("unsubscribe(definition:handler:)")));
@end

__attribute__((swift_name("Ktor_utilsPipeline")))
@interface CASKtor_utilsPipeline<TSubject, TContext> : CASBase
- (instancetype)initWithPhase:(CASKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<CASKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhases:(CASKotlinArray<CASKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer));
- (void)addPhasePhase:(CASKtor_utilsPipelinePhase *)phase __attribute__((swift_name("addPhase(phase:)")));
- (void)afterIntercepted __attribute__((swift_name("afterIntercepted()")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)executeContext:(TContext)context subject:(TSubject)subject completionHandler:(void (^)(TSubject _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("execute(context:subject:completionHandler:)")));
- (void)insertPhaseAfterReference:(CASKtor_utilsPipelinePhase *)reference phase:(CASKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseAfter(reference:phase:)")));
- (void)insertPhaseBeforeReference:(CASKtor_utilsPipelinePhase *)reference phase:(CASKtor_utilsPipelinePhase *)phase __attribute__((swift_name("insertPhaseBefore(reference:phase:)")));
- (void)interceptPhase:(CASKtor_utilsPipelinePhase *)phase block:(id<CASKotlinSuspendFunction2>)block __attribute__((swift_name("intercept(phase:block:)")));
- (NSArray<id<CASKotlinSuspendFunction2>> *)interceptorsForPhasePhase:(CASKtor_utilsPipelinePhase *)phase __attribute__((swift_name("interceptorsForPhase(phase:)")));
- (void)mergeFrom:(CASKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("merge(from:)")));
- (void)mergePhasesFrom:(CASKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("mergePhases(from:)")));
- (void)resetFromFrom:(CASKtor_utilsPipeline<TSubject, TContext> *)from __attribute__((swift_name("resetFrom(from:)")));
@property (readonly) id<CASKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@property (readonly, getter=isEmpty_) BOOL isEmpty __attribute__((swift_name("isEmpty")));
@property (readonly) NSArray<CASKtor_utilsPipelinePhase *> *items __attribute__((swift_name("items")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline")))
@interface CASKtor_client_coreHttpReceivePipeline : CASKtor_utilsPipeline<CASKtor_client_coreHttpResponse *, CASKotlinUnit *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(CASKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<CASKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(CASKotlinArray<CASKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_client_coreHttpReceivePipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline")))
@interface CASKtor_client_coreHttpRequestPipeline : CASKtor_utilsPipeline<id, CASKtor_client_coreHttpRequestBuilder *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(CASKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<CASKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(CASKotlinArray<CASKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_client_coreHttpRequestPipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline")))
@interface CASKtor_client_coreHttpResponsePipeline : CASKtor_utilsPipeline<CASKtor_client_coreHttpResponseContainer *, CASKtor_client_coreHttpClientCall *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(CASKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<CASKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(CASKotlinArray<CASKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_client_coreHttpResponsePipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline")))
@interface CASKtor_client_coreHttpSendPipeline : CASKtor_utilsPipeline<id, CASKtor_client_coreHttpRequestBuilder *>
- (instancetype)initWithDevelopmentMode:(BOOL)developmentMode __attribute__((swift_name("init(developmentMode:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithPhase:(CASKtor_utilsPipelinePhase *)phase interceptors:(NSArray<id<CASKotlinSuspendFunction2>> *)interceptors __attribute__((swift_name("init(phase:interceptors:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (instancetype)initWithPhases:(CASKotlinArray<CASKtor_utilsPipelinePhase *> *)phases __attribute__((swift_name("init(phases:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_client_coreHttpSendPipelinePhases *companion __attribute__((swift_name("companion")));
@property (readonly) BOOL developmentMode __attribute__((swift_name("developmentMode")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreProxyConfig")))
@interface CASKtor_client_coreProxyConfig : CASBase
- (instancetype)initWithUrl:(CASKtor_httpUrl *)url __attribute__((swift_name("init(url:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) CASKtor_httpUrl *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpUrl.Companion")))
@interface CASKtor_httpUrlCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpUrlCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("Ktor_httpParameters")))
@protocol CASKtor_httpParameters <CASKtor_utilsStringValues>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol")))
@interface CASKtor_httpURLProtocol : CASBase
- (instancetype)initWithName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("init(name:defaultPort:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_httpURLProtocolCompanion *companion __attribute__((swift_name("companion")));
- (CASKtor_httpURLProtocol *)doCopyName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("doCopy(name:defaultPort:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t defaultPort __attribute__((swift_name("defaultPort")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpMethod.Companion")))
@interface CASKtor_httpHttpMethodCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpHttpMethodCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_httpHttpMethod *)parseMethod:(NSString *)method __attribute__((swift_name("parse(method:)")));
@property (readonly) NSArray<CASKtor_httpHttpMethod *> *DefaultMethods __attribute__((swift_name("DefaultMethods")));
@property (readonly) CASKtor_httpHttpMethod *Delete __attribute__((swift_name("Delete")));
@property (readonly) CASKtor_httpHttpMethod *Get __attribute__((swift_name("Get")));
@property (readonly) CASKtor_httpHttpMethod *Head __attribute__((swift_name("Head")));
@property (readonly) CASKtor_httpHttpMethod *Options __attribute__((swift_name("Options")));
@property (readonly) CASKtor_httpHttpMethod *Patch __attribute__((swift_name("Patch")));
@property (readonly) CASKtor_httpHttpMethod *Post __attribute__((swift_name("Post")));
@property (readonly) CASKtor_httpHttpMethod *Put __attribute__((swift_name("Put")));
@end

__attribute__((swift_name("KotlinMapEntry")))
@protocol CASKotlinMapEntry
@required
@property (readonly) id _Nullable key __attribute__((swift_name("key")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsAttributeKey")))
@interface CASKtor_utilsAttributeKey<T> : CASBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((swift_name("Ktor_httpHeaderValueWithParameters")))
@interface CASKtor_httpHeaderValueWithParameters : CASBase
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<CASKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_httpHeaderValueWithParametersCompanion *companion __attribute__((swift_name("companion")));
- (NSString * _Nullable)parameterName:(NSString *)name __attribute__((swift_name("parameter(name:)")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) NSString *content __attribute__((swift_name("content")));
@property (readonly) NSArray<CASKtor_httpHeaderValueParam *> *parameters __attribute__((swift_name("parameters")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType")))
@interface CASKtor_httpContentType : CASKtor_httpHeaderValueWithParameters
- (instancetype)initWithContentType:(NSString *)contentType contentSubtype:(NSString *)contentSubtype parameters:(NSArray<CASKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(contentType:contentSubtype:parameters:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithContent:(NSString *)content parameters:(NSArray<CASKtor_httpHeaderValueParam *> *)parameters __attribute__((swift_name("init(content:parameters:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_httpContentTypeCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)matchPattern:(CASKtor_httpContentType *)pattern __attribute__((swift_name("match(pattern:)")));
- (BOOL)matchPattern_:(NSString *)pattern __attribute__((swift_name("match(pattern_:)")));
- (CASKtor_httpContentType *)withParameterName:(NSString *)name value:(NSString *)value __attribute__((swift_name("withParameter(name:value:)")));
- (CASKtor_httpContentType *)withoutParameters __attribute__((swift_name("withoutParameters()")));
@property (readonly) NSString *contentSubtype __attribute__((swift_name("contentSubtype")));
@property (readonly) NSString *contentType __attribute__((swift_name("contentType")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreDisposableHandle")))
@protocol CASKotlinx_coroutines_coreDisposableHandle
@required
- (void)dispose __attribute__((swift_name("dispose()")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreChildHandle")))
@protocol CASKotlinx_coroutines_coreChildHandle <CASKotlinx_coroutines_coreDisposableHandle>
@required
- (BOOL)childCancelledCause:(CASKotlinThrowable *)cause __attribute__((swift_name("childCancelled(cause:)")));
@property (readonly) id<CASKotlinx_coroutines_coreJob> _Nullable parent __attribute__((swift_name("parent")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreChildJob")))
@protocol CASKotlinx_coroutines_coreChildJob <CASKotlinx_coroutines_coreJob>
@required
- (void)parentCancelledParentJob:(id<CASKotlinx_coroutines_coreParentJob>)parentJob __attribute__((swift_name("parentCancelled(parentJob:)")));
@end

__attribute__((swift_name("KotlinSequence")))
@protocol CASKotlinSequence
@required
- (id<CASKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause")))
@protocol CASKotlinx_coroutines_coreSelectClause
@required
@property (readonly) id clauseObject __attribute__((swift_name("clauseObject")));
@property (readonly) CASKotlinUnit *(^(^ _Nullable onCancellationConstructor)(id<CASKotlinx_coroutines_coreSelectInstance>, id _Nullable, id _Nullable))(CASKotlinThrowable *) __attribute__((swift_name("onCancellationConstructor")));
@property (readonly) id _Nullable (^processResFunc)(id, id _Nullable, id _Nullable) __attribute__((swift_name("processResFunc")));
@property (readonly) void (^regFunc)(id, id<CASKotlinx_coroutines_coreSelectInstance>, id _Nullable) __attribute__((swift_name("regFunc")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSelectClause0")))
@protocol CASKotlinx_coroutines_coreSelectClause0 <CASKotlinx_coroutines_coreSelectClause>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpStatusCode.Companion")))
@interface CASKtor_httpHttpStatusCodeCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpHttpStatusCodeCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_httpHttpStatusCode *)fromValueValue:(int32_t)value __attribute__((swift_name("fromValue(value:)")));
@property (readonly) CASKtor_httpHttpStatusCode *Accepted __attribute__((swift_name("Accepted")));
@property (readonly) CASKtor_httpHttpStatusCode *BadGateway __attribute__((swift_name("BadGateway")));
@property (readonly) CASKtor_httpHttpStatusCode *BadRequest __attribute__((swift_name("BadRequest")));
@property (readonly) CASKtor_httpHttpStatusCode *Conflict __attribute__((swift_name("Conflict")));
@property (readonly) CASKtor_httpHttpStatusCode *Continue __attribute__((swift_name("Continue")));
@property (readonly) CASKtor_httpHttpStatusCode *Created __attribute__((swift_name("Created")));
@property (readonly) CASKtor_httpHttpStatusCode *ExpectationFailed __attribute__((swift_name("ExpectationFailed")));
@property (readonly) CASKtor_httpHttpStatusCode *FailedDependency __attribute__((swift_name("FailedDependency")));
@property (readonly) CASKtor_httpHttpStatusCode *Forbidden __attribute__((swift_name("Forbidden")));
@property (readonly) CASKtor_httpHttpStatusCode *Found __attribute__((swift_name("Found")));
@property (readonly) CASKtor_httpHttpStatusCode *GatewayTimeout __attribute__((swift_name("GatewayTimeout")));
@property (readonly) CASKtor_httpHttpStatusCode *Gone __attribute__((swift_name("Gone")));
@property (readonly) CASKtor_httpHttpStatusCode *InsufficientStorage __attribute__((swift_name("InsufficientStorage")));
@property (readonly) CASKtor_httpHttpStatusCode *InternalServerError __attribute__((swift_name("InternalServerError")));
@property (readonly) CASKtor_httpHttpStatusCode *LengthRequired __attribute__((swift_name("LengthRequired")));
@property (readonly) CASKtor_httpHttpStatusCode *Locked __attribute__((swift_name("Locked")));
@property (readonly) CASKtor_httpHttpStatusCode *MethodNotAllowed __attribute__((swift_name("MethodNotAllowed")));
@property (readonly) CASKtor_httpHttpStatusCode *MovedPermanently __attribute__((swift_name("MovedPermanently")));
@property (readonly) CASKtor_httpHttpStatusCode *MultiStatus __attribute__((swift_name("MultiStatus")));
@property (readonly) CASKtor_httpHttpStatusCode *MultipleChoices __attribute__((swift_name("MultipleChoices")));
@property (readonly) CASKtor_httpHttpStatusCode *NoContent __attribute__((swift_name("NoContent")));
@property (readonly) CASKtor_httpHttpStatusCode *NonAuthoritativeInformation __attribute__((swift_name("NonAuthoritativeInformation")));
@property (readonly) CASKtor_httpHttpStatusCode *NotAcceptable __attribute__((swift_name("NotAcceptable")));
@property (readonly) CASKtor_httpHttpStatusCode *NotFound __attribute__((swift_name("NotFound")));
@property (readonly) CASKtor_httpHttpStatusCode *NotImplemented __attribute__((swift_name("NotImplemented")));
@property (readonly) CASKtor_httpHttpStatusCode *NotModified __attribute__((swift_name("NotModified")));
@property (readonly) CASKtor_httpHttpStatusCode *OK __attribute__((swift_name("OK")));
@property (readonly) CASKtor_httpHttpStatusCode *PartialContent __attribute__((swift_name("PartialContent")));
@property (readonly) CASKtor_httpHttpStatusCode *PayloadTooLarge __attribute__((swift_name("PayloadTooLarge")));
@property (readonly) CASKtor_httpHttpStatusCode *PaymentRequired __attribute__((swift_name("PaymentRequired")));
@property (readonly) CASKtor_httpHttpStatusCode *PermanentRedirect __attribute__((swift_name("PermanentRedirect")));
@property (readonly) CASKtor_httpHttpStatusCode *PreconditionFailed __attribute__((swift_name("PreconditionFailed")));
@property (readonly) CASKtor_httpHttpStatusCode *Processing __attribute__((swift_name("Processing")));
@property (readonly) CASKtor_httpHttpStatusCode *ProxyAuthenticationRequired __attribute__((swift_name("ProxyAuthenticationRequired")));
@property (readonly) CASKtor_httpHttpStatusCode *RequestHeaderFieldTooLarge __attribute__((swift_name("RequestHeaderFieldTooLarge")));
@property (readonly) CASKtor_httpHttpStatusCode *RequestTimeout __attribute__((swift_name("RequestTimeout")));
@property (readonly) CASKtor_httpHttpStatusCode *RequestURITooLong __attribute__((swift_name("RequestURITooLong")));
@property (readonly) CASKtor_httpHttpStatusCode *RequestedRangeNotSatisfiable __attribute__((swift_name("RequestedRangeNotSatisfiable")));
@property (readonly) CASKtor_httpHttpStatusCode *ResetContent __attribute__((swift_name("ResetContent")));
@property (readonly) CASKtor_httpHttpStatusCode *SeeOther __attribute__((swift_name("SeeOther")));
@property (readonly) CASKtor_httpHttpStatusCode *ServiceUnavailable __attribute__((swift_name("ServiceUnavailable")));
@property (readonly) CASKtor_httpHttpStatusCode *SwitchProxy __attribute__((swift_name("SwitchProxy")));
@property (readonly) CASKtor_httpHttpStatusCode *SwitchingProtocols __attribute__((swift_name("SwitchingProtocols")));
@property (readonly) CASKtor_httpHttpStatusCode *TemporaryRedirect __attribute__((swift_name("TemporaryRedirect")));
@property (readonly) CASKtor_httpHttpStatusCode *TooEarly __attribute__((swift_name("TooEarly")));
@property (readonly) CASKtor_httpHttpStatusCode *TooManyRequests __attribute__((swift_name("TooManyRequests")));
@property (readonly) CASKtor_httpHttpStatusCode *Unauthorized __attribute__((swift_name("Unauthorized")));
@property (readonly) CASKtor_httpHttpStatusCode *UnprocessableEntity __attribute__((swift_name("UnprocessableEntity")));
@property (readonly) CASKtor_httpHttpStatusCode *UnsupportedMediaType __attribute__((swift_name("UnsupportedMediaType")));
@property (readonly) CASKtor_httpHttpStatusCode *UpgradeRequired __attribute__((swift_name("UpgradeRequired")));
@property (readonly) CASKtor_httpHttpStatusCode *UseProxy __attribute__((swift_name("UseProxy")));
@property (readonly) CASKtor_httpHttpStatusCode *VariantAlsoNegotiates __attribute__((swift_name("VariantAlsoNegotiates")));
@property (readonly) CASKtor_httpHttpStatusCode *VersionNotSupported __attribute__((swift_name("VersionNotSupported")));
@property (readonly) NSArray<CASKtor_httpHttpStatusCode *> *allStatusCodes __attribute__((swift_name("allStatusCodes")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsGMTDate.Companion")))
@interface CASKtor_utilsGMTDateCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_utilsGMTDateCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_utilsGMTDate *START __attribute__((swift_name("START")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay")))
@interface CASKtor_utilsWeekDay : CASKotlinEnum<CASKtor_utilsWeekDay *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_utilsWeekDayCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASKtor_utilsWeekDay *monday __attribute__((swift_name("monday")));
@property (class, readonly) CASKtor_utilsWeekDay *tuesday __attribute__((swift_name("tuesday")));
@property (class, readonly) CASKtor_utilsWeekDay *wednesday __attribute__((swift_name("wednesday")));
@property (class, readonly) CASKtor_utilsWeekDay *thursday __attribute__((swift_name("thursday")));
@property (class, readonly) CASKtor_utilsWeekDay *friday __attribute__((swift_name("friday")));
@property (class, readonly) CASKtor_utilsWeekDay *saturday __attribute__((swift_name("saturday")));
@property (class, readonly) CASKtor_utilsWeekDay *sunday __attribute__((swift_name("sunday")));
+ (CASKotlinArray<CASKtor_utilsWeekDay *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth")))
@interface CASKtor_utilsMonth : CASKotlinEnum<CASKtor_utilsMonth *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_utilsMonthCompanion *companion __attribute__((swift_name("companion")));
@property (class, readonly) CASKtor_utilsMonth *january __attribute__((swift_name("january")));
@property (class, readonly) CASKtor_utilsMonth *february __attribute__((swift_name("february")));
@property (class, readonly) CASKtor_utilsMonth *march __attribute__((swift_name("march")));
@property (class, readonly) CASKtor_utilsMonth *april __attribute__((swift_name("april")));
@property (class, readonly) CASKtor_utilsMonth *may __attribute__((swift_name("may")));
@property (class, readonly) CASKtor_utilsMonth *june __attribute__((swift_name("june")));
@property (class, readonly) CASKtor_utilsMonth *july __attribute__((swift_name("july")));
@property (class, readonly) CASKtor_utilsMonth *august __attribute__((swift_name("august")));
@property (class, readonly) CASKtor_utilsMonth *september __attribute__((swift_name("september")));
@property (class, readonly) CASKtor_utilsMonth *october __attribute__((swift_name("october")));
@property (class, readonly) CASKtor_utilsMonth *november __attribute__((swift_name("november")));
@property (class, readonly) CASKtor_utilsMonth *december __attribute__((swift_name("december")));
+ (CASKotlinArray<CASKtor_utilsMonth *> *)values __attribute__((swift_name("values()")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHttpProtocolVersion.Companion")))
@interface CASKtor_httpHttpProtocolVersionCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpHttpProtocolVersionCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_httpHttpProtocolVersion *)fromValueName:(NSString *)name major:(int32_t)major minor:(int32_t)minor __attribute__((swift_name("fromValue(name:major:minor:)")));
- (CASKtor_httpHttpProtocolVersion *)parseValue:(id)value __attribute__((swift_name("parse(value:)")));
@property (readonly) CASKtor_httpHttpProtocolVersion *HTTP_1_0 __attribute__((swift_name("HTTP_1_0")));
@property (readonly) CASKtor_httpHttpProtocolVersion *HTTP_1_1 __attribute__((swift_name("HTTP_1_1")));
@property (readonly) CASKtor_httpHttpProtocolVersion *HTTP_2_0 __attribute__((swift_name("HTTP_2_0")));
@property (readonly) CASKtor_httpHttpProtocolVersion *QUIC __attribute__((swift_name("QUIC")));
@property (readonly) CASKtor_httpHttpProtocolVersion *SPDY_3 __attribute__((swift_name("SPDY_3")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientPlugin")))
@protocol CASKtor_client_coreHttpClientPlugin
@required
- (void)installPlugin:(id)plugin scope:(CASKtor_client_coreHttpClient *)scope __attribute__((swift_name("install(plugin:scope:)")));
- (id)prepareBlock:(void (^)(id))block __attribute__((swift_name("prepare(block:)")));
@property (readonly) CASKtor_utilsAttributeKey<id> *key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("Ktor_eventsEventDefinition")))
@interface CASKtor_eventsEventDefinition<T> : CASBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsPipelinePhase")))
@interface CASKtor_utilsPipelinePhase : CASBase
- (instancetype)initWithName:(NSString *)name __attribute__((swift_name("init(name:)"))) __attribute__((objc_designated_initializer));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((swift_name("KotlinFunction")))
@protocol CASKotlinFunction
@required
@end

__attribute__((swift_name("KotlinSuspendFunction2")))
@protocol CASKotlinSuspendFunction2 <CASKotlinFunction>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 p2:(id _Nullable)p2 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:p2:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpReceivePipeline.Phases")))
@interface CASKtor_client_coreHttpReceivePipelinePhases : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_client_coreHttpReceivePipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_utilsPipelinePhase *After __attribute__((swift_name("After")));
@property (readonly) CASKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) CASKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@end

__attribute__((swift_name("Ktor_httpHttpMessage")))
@protocol CASKtor_httpHttpMessage
@required
@property (readonly) id<CASKtor_httpHeaders> headers __attribute__((swift_name("headers")));
@end

__attribute__((swift_name("Ktor_client_coreHttpResponse")))
@interface CASKtor_client_coreHttpResponse : CASBase <CASKtor_httpHttpMessage, CASKotlinx_coroutines_coreCoroutineScope>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) CASKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) id<CASKtor_ioByteReadChannel> content __attribute__((swift_name("content")));
@property (readonly) CASKtor_utilsGMTDate *requestTime __attribute__((swift_name("requestTime")));
@property (readonly) CASKtor_utilsGMTDate *responseTime __attribute__((swift_name("responseTime")));
@property (readonly) CASKtor_httpHttpStatusCode *status __attribute__((swift_name("status")));
@property (readonly) CASKtor_httpHttpProtocolVersion *version __attribute__((swift_name("version")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinUnit")))
@interface CASKotlinUnit : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)unit __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKotlinUnit *shared __attribute__((swift_name("shared")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestPipeline.Phases")))
@interface CASKtor_client_coreHttpRequestPipelinePhases : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_client_coreHttpRequestPipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) CASKtor_utilsPipelinePhase *Render __attribute__((swift_name("Render")));
@property (readonly) CASKtor_utilsPipelinePhase *Send __attribute__((swift_name("Send")));
@property (readonly) CASKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@property (readonly) CASKtor_utilsPipelinePhase *Transform __attribute__((swift_name("Transform")));
@end

__attribute__((swift_name("Ktor_httpHttpMessageBuilder")))
@protocol CASKtor_httpHttpMessageBuilder
@required
@property (readonly) CASKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder")))
@interface CASKtor_client_coreHttpRequestBuilder : CASBase <CASKtor_httpHttpMessageBuilder>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@property (class, readonly, getter=companion) CASKtor_client_coreHttpRequestBuilderCompanion *companion __attribute__((swift_name("companion")));
- (CASKtor_client_coreHttpRequestData *)build __attribute__((swift_name("build()")));
- (id _Nullable)getCapabilityOrNullKey:(id<CASKtor_client_coreHttpClientEngineCapability>)key __attribute__((swift_name("getCapabilityOrNull(key:)")));
- (void)setAttributesBlock:(void (^)(id<CASKtor_utilsAttributes>))block __attribute__((swift_name("setAttributes(block:)")));
- (void)setCapabilityKey:(id<CASKtor_client_coreHttpClientEngineCapability>)key capability:(id)capability __attribute__((swift_name("setCapability(key:capability:)")));
- (CASKtor_client_coreHttpRequestBuilder *)takeFromBuilder:(CASKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFrom(builder:)")));
- (CASKtor_client_coreHttpRequestBuilder *)takeFromWithExecutionContextBuilder:(CASKtor_client_coreHttpRequestBuilder *)builder __attribute__((swift_name("takeFromWithExecutionContext(builder:)")));
- (void)urlBlock:(void (^)(CASKtor_httpURLBuilder *, CASKtor_httpURLBuilder *))block __attribute__((swift_name("url(block:)")));
@property (readonly) id<CASKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property id body __attribute__((swift_name("body")));
@property CASKtor_utilsTypeInfo * _Nullable bodyType __attribute__((swift_name("bodyType")));
@property (readonly) id<CASKotlinx_coroutines_coreJob> executionContext __attribute__((swift_name("executionContext")));
@property (readonly) CASKtor_httpHeadersBuilder *headers __attribute__((swift_name("headers")));
@property CASKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) CASKtor_httpURLBuilder *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponsePipeline.Phases")))
@interface CASKtor_client_coreHttpResponsePipelinePhases : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_client_coreHttpResponsePipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_utilsPipelinePhase *After __attribute__((swift_name("After")));
@property (readonly) CASKtor_utilsPipelinePhase *Parse __attribute__((swift_name("Parse")));
@property (readonly) CASKtor_utilsPipelinePhase *Receive __attribute__((swift_name("Receive")));
@property (readonly) CASKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@property (readonly) CASKtor_utilsPipelinePhase *Transform __attribute__((swift_name("Transform")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpResponseContainer")))
@interface CASKtor_client_coreHttpResponseContainer : CASBase
- (instancetype)initWithExpectedType:(CASKtor_utilsTypeInfo *)expectedType response:(id)response __attribute__((swift_name("init(expectedType:response:)"))) __attribute__((objc_designated_initializer));
- (CASKtor_client_coreHttpResponseContainer *)doCopyExpectedType:(CASKtor_utilsTypeInfo *)expectedType response:(id)response __attribute__((swift_name("doCopy(expectedType:response:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) CASKtor_utilsTypeInfo *expectedType __attribute__((swift_name("expectedType")));
@property (readonly) id response __attribute__((swift_name("response")));
@end

__attribute__((swift_name("Ktor_client_coreHttpClientCall")))
@interface CASKtor_client_coreHttpClientCall : CASBase <CASKotlinx_coroutines_coreCoroutineScope>
- (instancetype)initWithClient:(CASKtor_client_coreHttpClient *)client requestData:(CASKtor_client_coreHttpRequestData *)requestData responseData:(CASKtor_client_coreHttpResponseData *)responseData __attribute__((swift_name("init(client:requestData:responseData:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithClient:(CASKtor_client_coreHttpClient *)client __attribute__((swift_name("init(client:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_client_coreHttpClientCallCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)bodyInfo:(CASKtor_utilsTypeInfo *)info completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("body(info:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)bodyNullableInfo:(CASKtor_utilsTypeInfo *)info completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("bodyNullable(info:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)getResponseContentWithCompletionHandler:(void (^)(id<CASKtor_ioByteReadChannel> _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("getResponseContent(completionHandler:)")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) BOOL allowDoubleReceive __attribute__((swift_name("allowDoubleReceive")));
@property (readonly) id<CASKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) CASKtor_client_coreHttpClient *client __attribute__((swift_name("client")));
@property (readonly) id<CASKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@property id<CASKtor_client_coreHttpRequest> request __attribute__((swift_name("request")));
@property CASKtor_client_coreHttpResponse *response __attribute__((swift_name("response")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpSendPipeline.Phases")))
@interface CASKtor_client_coreHttpSendPipelinePhases : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)phases __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_client_coreHttpSendPipelinePhases *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_utilsPipelinePhase *Before __attribute__((swift_name("Before")));
@property (readonly) CASKtor_utilsPipelinePhase *Engine __attribute__((swift_name("Engine")));
@property (readonly) CASKtor_utilsPipelinePhase *Monitoring __attribute__((swift_name("Monitoring")));
@property (readonly) CASKtor_utilsPipelinePhase *Receive __attribute__((swift_name("Receive")));
@property (readonly) CASKtor_utilsPipelinePhase *State __attribute__((swift_name("State")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol.Companion")))
@interface CASKtor_httpURLProtocolCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpURLProtocolCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_httpURLProtocol *)createOrDefaultName:(NSString *)name __attribute__((swift_name("createOrDefault(name:)")));
@property (readonly) CASKtor_httpURLProtocol *HTTP __attribute__((swift_name("HTTP")));
@property (readonly) CASKtor_httpURLProtocol *HTTPS __attribute__((swift_name("HTTPS")));
@property (readonly) CASKtor_httpURLProtocol *SOCKS __attribute__((swift_name("SOCKS")));
@property (readonly) CASKtor_httpURLProtocol *WS __attribute__((swift_name("WS")));
@property (readonly) CASKtor_httpURLProtocol *WSS __attribute__((swift_name("WSS")));
@property (readonly) NSDictionary<NSString *, CASKtor_httpURLProtocol *> *byName __attribute__((swift_name("byName")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueParam")))
@interface CASKtor_httpHeaderValueParam : CASBase
- (instancetype)initWithName:(NSString *)name value:(NSString *)value __attribute__((swift_name("init(name:value:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithName:(NSString *)name value:(NSString *)value escapeValue:(BOOL)escapeValue __attribute__((swift_name("init(name:value:escapeValue:)"))) __attribute__((objc_designated_initializer));
- (CASKtor_httpHeaderValueParam *)doCopyName:(NSString *)name value:(NSString *)value escapeValue:(BOOL)escapeValue __attribute__((swift_name("doCopy(name:value:escapeValue:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL escapeValue __attribute__((swift_name("escapeValue")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeaderValueWithParameters.Companion")))
@interface CASKtor_httpHeaderValueWithParametersCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpHeaderValueWithParametersCompanion *shared __attribute__((swift_name("shared")));
- (id _Nullable)parseValue:(NSString *)value init:(id _Nullable (^)(NSString *, NSArray<CASKtor_httpHeaderValueParam *> *))init __attribute__((swift_name("parse(value:init:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpContentType.Companion")))
@interface CASKtor_httpContentTypeCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpContentTypeCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_httpContentType *)parseValue:(NSString *)value __attribute__((swift_name("parse(value:)")));
@property (readonly) CASKtor_httpContentType *Any __attribute__((swift_name("Any")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreParentJob")))
@protocol CASKotlinx_coroutines_coreParentJob <CASKotlinx_coroutines_coreJob>
@required
- (CASKotlinCancellationException *)getChildJobCancellationCause __attribute__((swift_name("getChildJobCancellationCause()")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSelectInstance")))
@protocol CASKotlinx_coroutines_coreSelectInstance
@required
- (void)disposeOnCompletionDisposableHandle:(id<CASKotlinx_coroutines_coreDisposableHandle>)disposableHandle __attribute__((swift_name("disposeOnCompletion(disposableHandle:)")));
- (void)selectInRegistrationPhaseInternalResult:(id _Nullable)internalResult __attribute__((swift_name("selectInRegistrationPhase(internalResult:)")));
- (BOOL)trySelectClauseObject:(id)clauseObject result:(id _Nullable)result __attribute__((swift_name("trySelect(clauseObject:result:)")));
@property (readonly) id<CASKotlinCoroutineContext> context __attribute__((swift_name("context")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsWeekDay.Companion")))
@interface CASKtor_utilsWeekDayCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_utilsWeekDayCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_utilsWeekDay *)fromOrdinal:(int32_t)ordinal __attribute__((swift_name("from(ordinal:)")));
- (CASKtor_utilsWeekDay *)fromValue:(NSString *)value __attribute__((swift_name("from(value:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsMonth.Companion")))
@interface CASKtor_utilsMonthCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_utilsMonthCompanion *shared __attribute__((swift_name("shared")));
- (CASKtor_utilsMonth *)fromOrdinal:(int32_t)ordinal __attribute__((swift_name("from(ordinal:)")));
- (CASKtor_utilsMonth *)fromValue:(NSString *)value __attribute__((swift_name("from(value:)")));
@end

__attribute__((swift_name("Ktor_ioByteReadChannel")))
@protocol CASKtor_ioByteReadChannel
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)awaitContentWithCompletionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("awaitContent(completionHandler:)")));
- (BOOL)cancelCause_:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("cancel(cause_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)discardMax:(int64_t)max completionHandler:(void (^)(CASLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("discard(max:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)peekToDestination:(CASKtor_ioMemory *)destination destinationOffset:(int64_t)destinationOffset offset:(int64_t)offset min:(int64_t)min max:(int64_t)max completionHandler:(void (^)(CASLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("peekTo(destination:destinationOffset:offset:min:max:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(CASKtor_ioChunkBuffer *)dst completionHandler:(void (^)(CASInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(CASKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length completionHandler:(void (^)(CASInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler:)")));
- (int32_t)readAvailableMin:(int32_t)min block:(void (^)(CASKtor_ioBuffer *))block __attribute__((swift_name("readAvailable(min:block:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(void *)dst offset:(int32_t)offset length:(int32_t)length completionHandler_:(void (^)(CASInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readAvailableDst:(void *)dst offset:(int64_t)offset length:(int64_t)length completionHandler__:(void (^)(CASInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readAvailable(dst:offset:length:completionHandler__:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readBooleanWithCompletionHandler:(void (^)(CASBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readBoolean(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readByteWithCompletionHandler:(void (^)(CASByte * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readByte(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readDoubleWithCompletionHandler:(void (^)(CASDouble * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readDouble(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFloatWithCompletionHandler:(void (^)(CASFloat * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readFloat(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(CASKtor_ioChunkBuffer *)dst n:(int32_t)n completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:n:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(CASKotlinByteArray *)dst offset:(int32_t)offset length:(int32_t)length completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(void *)dst offset:(int32_t)offset length:(int32_t)length completionHandler_:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler_:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readFullyDst:(void *)dst offset:(int64_t)offset length:(int64_t)length completionHandler__:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readFully(dst:offset:length:completionHandler__:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readIntWithCompletionHandler:(void (^)(CASInt * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readInt(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readLongWithCompletionHandler:(void (^)(CASLong * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readLong(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readPacketSize:(int32_t)size completionHandler:(void (^)(CASKtor_ioByteReadPacket * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readPacket(size:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readRemainingLimit:(int64_t)limit completionHandler:(void (^)(CASKtor_ioByteReadPacket * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readRemaining(limit:completionHandler:)")));
- (void)readSessionConsumer:(void (^)(id<CASKtor_ioReadSession>))consumer __attribute__((swift_name("readSession(consumer:)"))) __attribute__((deprecated("Use read { } instead.")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readShortWithCompletionHandler:(void (^)(CASShort * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readShort(completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readSuspendableSessionConsumer:(id<CASKotlinSuspendFunction1>)consumer completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("readSuspendableSession(consumer:completionHandler:)"))) __attribute__((deprecated("Use read { } instead.")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readUTF8LineLimit:(int32_t)limit completionHandler:(void (^)(NSString * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("readUTF8Line(limit:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)readUTF8LineToOut:(id<CASKotlinAppendable>)out limit:(int32_t)limit completionHandler:(void (^)(CASBoolean * _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("readUTF8LineTo(out:limit:completionHandler:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@property (readonly) CASKotlinThrowable * _Nullable closedCause __attribute__((swift_name("closedCause")));
@property (readonly) BOOL isClosedForRead __attribute__((swift_name("isClosedForRead")));
@property (readonly) BOOL isClosedForWrite __attribute__((swift_name("isClosedForWrite")));
@property (readonly) int64_t totalBytesRead __attribute__((swift_name("totalBytesRead")));
@end

__attribute__((swift_name("Ktor_utilsStringValuesBuilder")))
@protocol CASKtor_utilsStringValuesBuilder
@required
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<CASKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<CASKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<CASKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<CASKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));
@end

__attribute__((swift_name("Ktor_utilsStringValuesBuilderImpl")))
@interface CASKtor_utilsStringValuesBuilderImpl : CASBase <CASKtor_utilsStringValuesBuilder>
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer));
- (void)appendName:(NSString *)name value:(NSString *)value __attribute__((swift_name("append(name:value:)")));
- (void)appendAllStringValues:(id<CASKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendAll(stringValues:)")));
- (void)appendAllName:(NSString *)name values:(id)values __attribute__((swift_name("appendAll(name:values:)")));
- (void)appendMissingStringValues:(id<CASKtor_utilsStringValues>)stringValues __attribute__((swift_name("appendMissing(stringValues:)")));
- (void)appendMissingName:(NSString *)name values:(id)values __attribute__((swift_name("appendMissing(name:values:)")));
- (id<CASKtor_utilsStringValues>)build __attribute__((swift_name("build()")));
- (void)clear __attribute__((swift_name("clear()")));
- (BOOL)containsName:(NSString *)name __attribute__((swift_name("contains(name:)")));
- (BOOL)containsName:(NSString *)name value:(NSString *)value __attribute__((swift_name("contains(name:value:)")));
- (NSSet<id<CASKotlinMapEntry>> *)entries __attribute__((swift_name("entries()")));
- (NSString * _Nullable)getName:(NSString *)name __attribute__((swift_name("get(name:)")));
- (NSArray<NSString *> * _Nullable)getAllName:(NSString *)name __attribute__((swift_name("getAll(name:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (NSSet<NSString *> *)names __attribute__((swift_name("names()")));
- (void)removeName:(NSString *)name __attribute__((swift_name("remove(name:)")));
- (BOOL)removeName:(NSString *)name value:(NSString *)value __attribute__((swift_name("remove(name:value:)")));
- (void)removeKeysWithNoEntries __attribute__((swift_name("removeKeysWithNoEntries()")));
- (void)setName:(NSString *)name value:(NSString *)value __attribute__((swift_name("set(name:value:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateNameName:(NSString *)name __attribute__((swift_name("validateName(name:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateValueValue:(NSString *)value __attribute__((swift_name("validateValue(value:)")));
@property (readonly) BOOL caseInsensitiveName __attribute__((swift_name("caseInsensitiveName")));

/**
 * @note This property has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
@property (readonly) CASMutableDictionary<NSString *, NSMutableArray<NSString *> *> *values __attribute__((swift_name("values")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpHeadersBuilder")))
@interface CASKtor_httpHeadersBuilder : CASKtor_utilsStringValuesBuilderImpl
- (instancetype)initWithSize:(int32_t)size __attribute__((swift_name("init(size:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCaseInsensitiveName:(BOOL)caseInsensitiveName size:(int32_t)size __attribute__((swift_name("init(caseInsensitiveName:size:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
- (id<CASKtor_httpHeaders>)build __attribute__((swift_name("build()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateNameName:(NSString *)name __attribute__((swift_name("validateName(name:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)validateValueValue:(NSString *)value __attribute__((swift_name("validateValue(value:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpRequestBuilder.Companion")))
@interface CASKtor_client_coreHttpRequestBuilderCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_client_coreHttpRequestBuilderCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder")))
@interface CASKtor_httpURLBuilder : CASBase
- (instancetype)initWithProtocol:(CASKtor_httpURLProtocol *)protocol host:(NSString *)host port:(int32_t)port user:(NSString * _Nullable)user password:(NSString * _Nullable)password pathSegments:(NSArray<NSString *> *)pathSegments parameters:(id<CASKtor_httpParameters>)parameters fragment:(NSString *)fragment trailingQuery:(BOOL)trailingQuery __attribute__((swift_name("init(protocol:host:port:user:password:pathSegments:parameters:fragment:trailingQuery:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_httpURLBuilderCompanion *companion __attribute__((swift_name("companion")));
- (CASKtor_httpUrl *)build __attribute__((swift_name("build()")));
- (NSString *)buildString __attribute__((swift_name("buildString()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property NSString *encodedFragment __attribute__((swift_name("encodedFragment")));
@property id<CASKtor_httpParametersBuilder> encodedParameters __attribute__((swift_name("encodedParameters")));
@property NSString * _Nullable encodedPassword __attribute__((swift_name("encodedPassword")));
@property NSArray<NSString *> *encodedPathSegments __attribute__((swift_name("encodedPathSegments")));
@property NSString * _Nullable encodedUser __attribute__((swift_name("encodedUser")));
@property NSString *fragment __attribute__((swift_name("fragment")));
@property NSString *host __attribute__((swift_name("host")));
@property (readonly) id<CASKtor_httpParametersBuilder> parameters __attribute__((swift_name("parameters")));
@property NSString * _Nullable password __attribute__((swift_name("password")));
@property NSArray<NSString *> *pathSegments __attribute__((swift_name("pathSegments")));
@property int32_t port __attribute__((swift_name("port")));
@property CASKtor_httpURLProtocol *protocol __attribute__((swift_name("protocol")));
@property BOOL trailingQuery __attribute__((swift_name("trailingQuery")));
@property NSString * _Nullable user __attribute__((swift_name("user")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_utilsTypeInfo")))
@interface CASKtor_utilsTypeInfo : CASBase
- (instancetype)initWithType:(id<CASKotlinKClass>)type reifiedType:(id<CASKotlinKType>)reifiedType kotlinType:(id<CASKotlinKType> _Nullable)kotlinType __attribute__((swift_name("init(type:reifiedType:kotlinType:)"))) __attribute__((objc_designated_initializer));
- (CASKtor_utilsTypeInfo *)doCopyType:(id<CASKotlinKClass>)type reifiedType:(id<CASKotlinKType>)reifiedType kotlinType:(id<CASKotlinKType> _Nullable)kotlinType __attribute__((swift_name("doCopy(type:reifiedType:kotlinType:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<CASKotlinKType> _Nullable kotlinType __attribute__((swift_name("kotlinType")));
@property (readonly) id<CASKotlinKType> reifiedType __attribute__((swift_name("reifiedType")));
@property (readonly) id<CASKotlinKClass> type __attribute__((swift_name("type")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_client_coreHttpClientCall.Companion")))
@interface CASKtor_client_coreHttpClientCallCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_client_coreHttpClientCallCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_utilsAttributeKey<id> *CustomResponse __attribute__((swift_name("CustomResponse"))) __attribute__((unavailable("This is going to be removed. Please file a ticket with clarification why and what for do you need it.")));
@end

__attribute__((swift_name("Ktor_client_coreHttpRequest")))
@protocol CASKtor_client_coreHttpRequest <CASKtor_httpHttpMessage, CASKotlinx_coroutines_coreCoroutineScope>
@required
@property (readonly) id<CASKtor_utilsAttributes> attributes __attribute__((swift_name("attributes")));
@property (readonly) CASKtor_client_coreHttpClientCall *call __attribute__((swift_name("call")));
@property (readonly) CASKtor_httpOutgoingContent *content __attribute__((swift_name("content")));
@property (readonly) CASKtor_httpHttpMethod *method __attribute__((swift_name("method")));
@property (readonly) CASKtor_httpUrl *url __attribute__((swift_name("url")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioMemory")))
@interface CASKtor_ioMemory : CASBase
- (instancetype)initWithPointer:(void *)pointer size:(int64_t)size __attribute__((swift_name("init(pointer:size:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKtor_ioMemoryCompanion *companion __attribute__((swift_name("companion")));
- (void)doCopyToDestination:(CASKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length destinationOffset:(int32_t)destinationOffset __attribute__((swift_name("doCopyTo(destination:offset:length:destinationOffset:)")));
- (void)doCopyToDestination:(CASKtor_ioMemory *)destination offset:(int64_t)offset length:(int64_t)length destinationOffset_:(int64_t)destinationOffset __attribute__((swift_name("doCopyTo(destination:offset:length:destinationOffset_:)")));
- (int8_t)loadAtIndex:(int32_t)index __attribute__((swift_name("loadAt(index:)")));
- (int8_t)loadAtIndex_:(int64_t)index __attribute__((swift_name("loadAt(index_:)")));
- (CASKtor_ioMemory *)sliceOffset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("slice(offset:length:)")));
- (CASKtor_ioMemory *)sliceOffset:(int64_t)offset length_:(int64_t)length __attribute__((swift_name("slice(offset:length_:)")));
- (void)storeAtIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("storeAt(index:value:)")));
- (void)storeAtIndex:(int64_t)index value_:(int8_t)value __attribute__((swift_name("storeAt(index:value_:)")));
@property (readonly) void *pointer __attribute__((swift_name("pointer")));
@property (readonly) int64_t size __attribute__((swift_name("size")));
@property (readonly) int32_t size32 __attribute__((swift_name("size32")));
@end

__attribute__((swift_name("Ktor_ioBuffer")))
@interface CASKtor_ioBuffer : CASBase
- (instancetype)initWithMemory:(CASKtor_ioMemory *)memory __attribute__((swift_name("init(memory:)"))) __attribute__((objc_designated_initializer)) __attribute__((deprecated("\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")));
@property (class, readonly, getter=companion) CASKtor_ioBufferCompanion *companion __attribute__((swift_name("companion")));
- (void)commitWrittenCount:(int32_t)count __attribute__((swift_name("commitWritten(count:)")));
- (void)discardExactCount:(int32_t)count __attribute__((swift_name("discardExact(count:)")));
- (CASKtor_ioBuffer *)duplicate __attribute__((swift_name("duplicate()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)duplicateToCopy:(CASKtor_ioBuffer *)copy __attribute__((swift_name("duplicateTo(copy:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (void)reserveEndGapEndGap:(int32_t)endGap __attribute__((swift_name("reserveEndGap(endGap:)")));
- (void)reserveStartGapStartGap:(int32_t)startGap __attribute__((swift_name("reserveStartGap(startGap:)")));
- (void)reset __attribute__((swift_name("reset()")));
- (void)resetForRead __attribute__((swift_name("resetForRead()")));
- (void)resetForWrite __attribute__((swift_name("resetForWrite()")));
- (void)resetForWriteLimit:(int32_t)limit __attribute__((swift_name("resetForWrite(limit:)")));
- (void)rewindCount:(int32_t)count __attribute__((swift_name("rewind(count:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (int32_t)tryPeekByte __attribute__((swift_name("tryPeekByte()")));
- (int32_t)tryReadByte __attribute__((swift_name("tryReadByte()")));
- (void)writeByteValue:(int8_t)value __attribute__((swift_name("writeByte(value:)")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@property (readonly) int32_t endGap __attribute__((swift_name("endGap")));
@property (readonly) int32_t limit __attribute__((swift_name("limit")));
@property (readonly) CASKtor_ioMemory *memory __attribute__((swift_name("memory")));
@property (readonly) int32_t readPosition __attribute__((swift_name("readPosition")));
@property (readonly) int32_t readRemaining __attribute__((swift_name("readRemaining")));
@property (readonly) int32_t startGap __attribute__((swift_name("startGap")));
@property (readonly) int32_t writePosition __attribute__((swift_name("writePosition")));
@property (readonly) int32_t writeRemaining __attribute__((swift_name("writeRemaining")));
@end

__attribute__((swift_name("Ktor_ioChunkBuffer")))
@interface CASKtor_ioChunkBuffer : CASKtor_ioBuffer
- (instancetype)initWithMemory:(CASKtor_ioMemory *)memory origin:(CASKtor_ioChunkBuffer * _Nullable)origin parentPool:(id<CASKtor_ioObjectPool> _Nullable)parentPool __attribute__((swift_name("init(memory:origin:parentPool:)"))) __attribute__((objc_designated_initializer)) __attribute__((deprecated("\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")));
- (instancetype)initWithMemory:(CASKtor_ioMemory *)memory __attribute__((swift_name("init(memory:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_ioChunkBufferCompanion *companion __attribute__((swift_name("companion")));
- (CASKtor_ioChunkBuffer * _Nullable)cleanNext __attribute__((swift_name("cleanNext()")));
- (CASKtor_ioChunkBuffer *)duplicate __attribute__((swift_name("duplicate()")));
- (void)releasePool:(id<CASKtor_ioObjectPool>)pool __attribute__((swift_name("release(pool:)")));
- (void)reset __attribute__((swift_name("reset()")));
@property (getter=next_) CASKtor_ioChunkBuffer * _Nullable next __attribute__((swift_name("next")));
@property (readonly) CASKtor_ioChunkBuffer * _Nullable origin __attribute__((swift_name("origin")));
@property (readonly) int32_t referenceCount __attribute__((swift_name("referenceCount")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface CASKotlinByteArray : CASBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(CASByte *(^)(CASInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (CASKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("Ktor_ioInput")))
@interface CASKtor_ioInput : CASBase <CASKtor_ioCloseable>
- (instancetype)initWithHead:(CASKtor_ioChunkBuffer *)head remaining:(int64_t)remaining pool:(id<CASKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:remaining:pool:)"))) __attribute__((objc_designated_initializer)) __attribute__((deprecated("\n    We're migrating to the new kotlinx-io library.\n    This declaration is deprecated and will be removed in Ktor 4.0.0\n    If you have any problems with migration, please contact us in \n    https://youtrack.jetbrains.com/issue/KTOR-6030/Migrate-to-new-kotlinx.io-library\n    ")));
@property (class, readonly, getter=companion) CASKtor_ioInputCompanion *companion __attribute__((swift_name("companion")));
- (BOOL)canRead __attribute__((swift_name("canRead()")));
- (void)close __attribute__((swift_name("close()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)closeSource __attribute__((swift_name("closeSource()")));
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (int64_t)discardN_:(int64_t)n __attribute__((swift_name("discard(n_:)")));
- (void)discardExactN:(int32_t)n __attribute__((swift_name("discardExact(n:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (CASKtor_ioChunkBuffer * _Nullable)fill __attribute__((swift_name("fill()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (int32_t)fillDestination:(CASKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("fill(destination:offset:length:)")));
- (BOOL)hasBytesN:(int32_t)n __attribute__((swift_name("hasBytes(n:)")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)markNoMoreChunksAvailable __attribute__((swift_name("markNoMoreChunksAvailable()")));
- (int64_t)peekToDestination:(CASKtor_ioMemory *)destination destinationOffset:(int64_t)destinationOffset offset:(int64_t)offset min:(int64_t)min max:(int64_t)max __attribute__((swift_name("peekTo(destination:destinationOffset:offset:min:max:)")));
- (int32_t)peekToBuffer:(CASKtor_ioChunkBuffer *)buffer __attribute__((swift_name("peekTo(buffer:)")));
- (int8_t)readByte __attribute__((swift_name("readByte()")));
- (NSString *)readTextMin:(int32_t)min max:(int32_t)max __attribute__((swift_name("readText(min:max:)")));
- (int32_t)readTextOut:(id<CASKotlinAppendable>)out min:(int32_t)min max:(int32_t)max __attribute__((swift_name("readText(out:min:max:)")));
- (NSString *)readTextExactExactCharacters:(int32_t)exactCharacters __attribute__((swift_name("readTextExact(exactCharacters:)")));
- (void)readTextExactOut:(id<CASKotlinAppendable>)out exactCharacters:(int32_t)exactCharacters __attribute__((swift_name("readTextExact(out:exactCharacters:)")));
- (void)release_ __attribute__((swift_name("release()")));
- (int32_t)tryPeek __attribute__((swift_name("tryPeek()")));
@property (readonly) BOOL endOfInput __attribute__((swift_name("endOfInput")));
@property (readonly) id<CASKtor_ioObjectPool> pool __attribute__((swift_name("pool")));
@property (readonly) int64_t remaining __attribute__((swift_name("remaining")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioByteReadPacket")))
@interface CASKtor_ioByteReadPacket : CASKtor_ioInput
- (instancetype)initWithHead:(CASKtor_ioChunkBuffer *)head pool:(id<CASKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:pool:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithHead:(CASKtor_ioChunkBuffer *)head remaining:(int64_t)remaining pool:(id<CASKtor_ioObjectPool>)pool __attribute__((swift_name("init(head:remaining:pool:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly, getter=companion) CASKtor_ioByteReadPacketCompanion *companion __attribute__((swift_name("companion")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (void)closeSource __attribute__((swift_name("closeSource()")));
- (CASKtor_ioByteReadPacket *)doCopy __attribute__((swift_name("doCopy()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (CASKtor_ioChunkBuffer * _Nullable)fill __attribute__((swift_name("fill()")));

/**
 * @note This method has protected visibility in Kotlin source and is intended only for use by subclasses.
*/
- (int32_t)fillDestination:(CASKtor_ioMemory *)destination offset:(int32_t)offset length:(int32_t)length __attribute__((swift_name("fill(destination:offset:length:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Ktor_ioReadSession")))
@protocol CASKtor_ioReadSession
@required
- (int32_t)discardN:(int32_t)n __attribute__((swift_name("discard(n:)")));
- (CASKtor_ioChunkBuffer * _Nullable)requestAtLeast:(int32_t)atLeast __attribute__((swift_name("request(atLeast:)")));
@property (readonly) int32_t availableForRead __attribute__((swift_name("availableForRead")));
@end

__attribute__((swift_name("KotlinSuspendFunction1")))
@protocol CASKotlinSuspendFunction1 <CASKotlinFunction>
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeP1:(id _Nullable)p1 completionHandler:(void (^)(id _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(p1:completionHandler:)")));
@end

__attribute__((swift_name("KotlinAppendable")))
@protocol CASKotlinAppendable
@required
- (id<CASKotlinAppendable>)appendValue:(unichar)value __attribute__((swift_name("append(value:)")));
- (id<CASKotlinAppendable>)appendValue_:(id _Nullable)value __attribute__((swift_name("append(value_:)")));
- (id<CASKotlinAppendable>)appendValue:(id _Nullable)value startIndex:(int32_t)startIndex endIndex:(int32_t)endIndex __attribute__((swift_name("append(value:startIndex:endIndex:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLBuilder.Companion")))
@interface CASKtor_httpURLBuilderCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_httpURLBuilderCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((swift_name("Ktor_httpParametersBuilder")))
@protocol CASKtor_httpParametersBuilder <CASKtor_utilsStringValuesBuilder>
@required
@end

__attribute__((swift_name("KotlinKType")))
@protocol CASKotlinKType
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
@property (readonly) NSArray<CASKotlinKTypeProjection *> *arguments __attribute__((swift_name("arguments")));

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
@property (readonly) id<CASKotlinKClassifier> _Nullable classifier __attribute__((swift_name("classifier")));
@property (readonly) BOOL isMarkedNullable __attribute__((swift_name("isMarkedNullable")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioMemory.Companion")))
@interface CASKtor_ioMemoryCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_ioMemoryCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_ioMemory *Empty __attribute__((swift_name("Empty")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioBuffer.Companion")))
@interface CASKtor_ioBufferCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_ioBufferCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_ioBuffer *Empty __attribute__((swift_name("Empty")));
@property (readonly) int32_t ReservedSize __attribute__((swift_name("ReservedSize")));
@end

__attribute__((swift_name("Ktor_ioObjectPool")))
@protocol CASKtor_ioObjectPool <CASKtor_ioCloseable>
@required
- (id)borrow __attribute__((swift_name("borrow()")));
- (void)dispose __attribute__((swift_name("dispose()")));
- (void)recycleInstance:(id)instance __attribute__((swift_name("recycle(instance:)")));
@property (readonly) int32_t capacity __attribute__((swift_name("capacity")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioChunkBuffer.Companion")))
@interface CASKtor_ioChunkBufferCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_ioChunkBufferCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_ioChunkBuffer *Empty __attribute__((swift_name("Empty")));
@property (readonly) id<CASKtor_ioObjectPool> EmptyPool __attribute__((swift_name("EmptyPool")));
@property (readonly) id<CASKtor_ioObjectPool> Pool __attribute__((swift_name("Pool")));
@end

__attribute__((swift_name("KotlinByteIterator")))
@interface CASKotlinByteIterator : CASBase <CASKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (CASByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioInput.Companion")))
@interface CASKtor_ioInputCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_ioInputCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_ioByteReadPacket.Companion")))
@interface CASKtor_ioByteReadPacketCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKtor_ioByteReadPacketCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) CASKtor_ioByteReadPacket *Empty __attribute__((swift_name("Empty")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKTypeProjection")))
@interface CASKotlinKTypeProjection : CASBase
- (instancetype)initWithVariance:(CASKotlinKVariance * _Nullable)variance type:(id<CASKotlinKType> _Nullable)type __attribute__((swift_name("init(variance:type:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) CASKotlinKTypeProjectionCompanion *companion __attribute__((swift_name("companion")));
- (CASKotlinKTypeProjection *)doCopyVariance:(CASKotlinKVariance * _Nullable)variance type:(id<CASKotlinKType> _Nullable)type __attribute__((swift_name("doCopy(variance:type:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) id<CASKotlinKType> _Nullable type __attribute__((swift_name("type")));
@property (readonly) CASKotlinKVariance * _Nullable variance __attribute__((swift_name("variance")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKVariance")))
@interface CASKotlinKVariance : CASKotlinEnum<CASKotlinKVariance *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) CASKotlinKVariance *invariant __attribute__((swift_name("invariant")));
@property (class, readonly) CASKotlinKVariance *in __attribute__((swift_name("in")));
@property (class, readonly) CASKotlinKVariance *out __attribute__((swift_name("out")));
+ (CASKotlinArray<CASKotlinKVariance *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<CASKotlinKVariance *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinKTypeProjection.Companion")))
@interface CASKotlinKTypeProjectionCompanion : CASBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) CASKotlinKTypeProjectionCompanion *shared __attribute__((swift_name("shared")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (CASKotlinKTypeProjection *)contravariantType:(id<CASKotlinKType>)type __attribute__((swift_name("contravariant(type:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (CASKotlinKTypeProjection *)covariantType:(id<CASKotlinKType>)type __attribute__((swift_name("covariant(type:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
*/
- (CASKotlinKTypeProjection *)invariantType:(id<CASKotlinKType>)type __attribute__((swift_name("invariant(type:)")));
@property (readonly) CASKotlinKTypeProjection *STAR __attribute__((swift_name("STAR")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
