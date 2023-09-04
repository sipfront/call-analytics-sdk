#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class CASCallAnalytics, CASSessionParams, CASConfig, CASRtcpMessage, CASSdpMessage, CASSipMessage, CASStateMessage, CASBaseMessageCompanion, CASBaseMessage, CASRtcpMessageCompanion, CASCall, CASMedia, CASMessageRtcp, CASRtcpMessageBuilder, CASSdpMessageCompanion, CASMessageSdp, CASSdpMessageBuilder, CASSipMessageCompanion, CASMessageSip, CASSipMessageBuilder, CASStateMessageCompanion, CASMessageState, CASStateMessageBuilder, CASKotlinEnumCompanion, CASKotlinEnum<E>, CASCallCompanion, CASKotlinArray<T>, CASMediaCompanion, CASMessageCompanion, CASMessageRtcpCompanion, CASMessageSdpCompanion, CASMessageSipCompanion, CASMessageStateCompanion, CASConfigCompanion, CASConfigBuilder, CASKotlinThrowable, CASKotlinException, CASKotlinRuntimeException, CASKotlinIllegalArgumentException, CASKotlinx_serialization_coreSerializersModule, CASKotlinx_serialization_coreSerialKind, CASKotlinNothing;

@protocol CASProguardKeep, CASMessage, CASKotlinx_serialization_coreKSerializer, CASKotlinComparable, CASEnumValue, CASKotlinx_serialization_coreEncoder, CASKotlinx_serialization_coreSerialDescriptor, CASKotlinx_serialization_coreSerializationStrategy, CASKotlinx_serialization_coreDecoder, CASKotlinx_serialization_coreDeserializationStrategy, CASKotlinIterator, CASKotlinx_serialization_coreCompositeEncoder, CASKotlinAnnotation, CASKotlinx_serialization_coreCompositeDecoder, CASKotlinx_serialization_coreSerializersModuleCollector, CASKotlinKClass, CASKotlinKDeclarationContainer, CASKotlinKAnnotatedElement, CASKotlinKClassifier;

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
 * @note This method converts instances of IllegalStateException, IllegalArgumentException, IOException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendRtcp:(CASRtcpMessage *)rtcp error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(rtcp:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException, IOException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendSdp:(CASSdpMessage *)sdp error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(sdp:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException, IOException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendSip:(CASSipMessage *)sip error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(sip:)")));

/**
 * @note annotations
 *   kotlin.jvm.JvmStatic
 * @note This method converts instances of IllegalStateException, IllegalArgumentException, IOException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (BOOL)sendState:(CASStateMessage *)state error:(NSError * _Nullable * _Nullable)error __attribute__((swift_name("send(state:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SessionParams")))
@interface CASSessionParams : CASBase <CASProguardKeep>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((swift_name("EnumValue")))
@protocol CASEnumValue <CASProguardKeep>
@required
@property (readonly) NSString *value __attribute__((swift_name("value")));
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
- (CASRtcpMessage *)doCopyCallId:(NSString *)callId addressLocal:(NSString *)addressLocal addressRemote:(NSString *)addressRemote addressRemoteDisplayName:(NSString *)addressRemoteDisplayName callDirection:(CASCall *)callDirection audioDirection:(CASMedia *)audioDirection videoDirection:(CASMedia *)videoDirection audioRemoteDirection:(CASMedia *)audioRemoteDirection videoRemoteDirection:(CASMedia *)videoRemoteDirection param:(NSString *)param rxJitter:(double)rxJitter rxPackets:(int64_t)rxPackets rxLost:(int64_t)rxLost rxBytes:(int64_t)rxBytes txPackets:(int64_t)txPackets txBytes:(int64_t)txBytes rtt:(double)rtt type:(CASMessageRtcp *)type clazz:(id)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(callId:addressLocal:addressRemote:addressRemoteDisplayName:callDirection:audioDirection:videoDirection:audioRemoteDirection:videoRemoteDirection:param:rxJitter:rxPackets:rxLost:rxBytes:txPackets:txBytes:rtt:type:clazz:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="accountaor")
*/
@property (readonly) NSString *addressLocal __attribute__((swift_name("addressLocal")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peeruri")
*/
@property (readonly) NSString *addressRemote __attribute__((swift_name("addressRemote")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peerdisplayname")
*/
@property (readonly) NSString *addressRemoteDisplayName __attribute__((swift_name("addressRemoteDisplayName")));

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
- (CASSdpMessage *)doCopyMessage:(NSString *)message type:(CASMessageSdp *)type clazz:(id)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(message:type:clazz:timestamp:)")));
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
- (CASSipMessage *)doCopyMessage:(NSString *)message type:(CASMessageSip *)type clazz:(id)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(message:type:clazz:timestamp:)")));
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
- (CASStateMessage *)doCopyCallId:(NSString * _Nullable)callId addressLocal:(NSString * _Nullable)addressLocal addressRemote:(NSString * _Nullable)addressRemote addressRemoteDisplayName:(NSString * _Nullable)addressRemoteDisplayName callDirection:(CASCall * _Nullable)callDirection audioDirection:(CASMedia *)audioDirection videoDirection:(CASMedia *)videoDirection audioRemoteDirection:(CASMedia *)audioRemoteDirection videoRemoteDirection:(CASMedia *)videoRemoteDirection type:(CASMessageState *)type clazz:(id)clazz timestamp:(double)timestamp __attribute__((swift_name("doCopy(callId:addressLocal:addressRemote:addressRemoteDisplayName:callDirection:audioDirection:videoDirection:audioRemoteDirection:videoRemoteDirection:type:clazz:timestamp:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="accountaor")
*/
@property (readonly) NSString * _Nullable addressLocal __attribute__((swift_name("addressLocal")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peeruri")
*/
@property (readonly) NSString * _Nullable addressRemote __attribute__((swift_name("addressRemote")));

/**
 * @note annotations
 *   kotlinx.serialization.SerialName(value="peerdisplayname")
*/
@property (readonly) NSString * _Nullable addressRemoteDisplayName __attribute__((swift_name("addressRemoteDisplayName")));

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

__attribute__((swift_name("Ktor_ioIOException")))
@interface CASKtor_ioIOException : CASKotlinException
- (instancetype)initWithMessage:(NSString *)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString *)message cause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (instancetype)initWithCause:(CASKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
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

__attribute__((swift_name("KotlinIterator")))
@protocol CASKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
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

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
