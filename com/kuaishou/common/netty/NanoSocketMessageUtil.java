package com.kuaishou.common.netty;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.netty.function.FunctionWithThrowable;
import com.kuaishou.livestream.message.nano.LiveExtraMessages;
import com.kuaishou.livestream.message.nano.LiveFansGroupMessages;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.socket.nano.SocketMessages;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class NanoSocketMessageUtil {
    private static Map<Integer, FunctionWithThrowable<byte[], ? extends MessageNano, InvalidProtocolBufferNanoException>> parsers = new HashMap();

    static {
        registerType(205, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.1
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSRaceLose.parseFrom(bArr);
            }
        });
        registerType(204, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.2
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSHorseRacing.parseFrom(bArr);
            }
        });
        registerType(1, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.3
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.CSHeartbeat.parseFrom(bArr);
            }
        });
        registerType(4, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.4
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.CSPing.parseFrom(bArr);
            }
        });
        registerType(3, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.5
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.CSError.parseFrom(bArr);
            }
        });
        registerType(200, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.6
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSEnterRoom.parseFrom(bArr);
            }
        });
        registerType(202, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.7
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSUserExit.parseFrom(bArr);
            }
        });
        registerType(201, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.8
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSUserPause.parseFrom(bArr);
            }
        });
        registerType(203, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.9
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSAuthorPushTrafficZero.parseFrom(bArr);
            }
        });
        registerType(206, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.10
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.CSVoipSignal.parseFrom(bArr);
            }
        });
        registerType(307, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.11
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCHorseRacingAck.parseFrom(bArr);
            }
        });
        registerType(101, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.12
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.SCHeartbeatAck.parseFrom(bArr);
            }
        });
        registerType(104, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.13
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.SCPingAck.parseFrom(bArr);
            }
        });
        registerType(105, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.14
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.SCInfo.parseFrom(bArr);
            }
        });
        registerType(102, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.15
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.SCEcho.parseFrom(bArr);
            }
        });
        registerType(103, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.16
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return SocketMessages.SCError.parseFrom(bArr);
            }
        });
        registerType(300, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.17
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCEnterRoomAck.parseFrom(bArr);
            }
        });
        registerType(310, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.18
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCFeedPush.parseFrom(bArr);
            }
        });
        registerType(301, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.19
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCAuthorPause.parseFrom(bArr);
            }
        });
        registerType(302, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.20
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCAuthorResume.parseFrom(bArr);
            }
        });
        registerType(311, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.21
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCAssistantStatus.parseFrom(bArr);
            }
        });
        registerType(320, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.22
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveChatCall.parseFrom(bArr);
            }
        });
        registerType(323, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.23
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveChatReady.parseFrom(bArr);
            }
        });
        registerType(325, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.24
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveChatEnded.parseFrom(bArr);
            }
        });
        registerType(326, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.25
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCRenderingMagicFaceDisable.parseFrom(bArr);
            }
        });
        registerType(327, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.26
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCRenderingMagicFaceEnable.parseFrom(bArr);
            }
        });
        registerType(340, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.27
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveWatchingList.parseFrom(bArr);
            }
        });
        registerType(355, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.28
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCSuspectedViolation.parseFrom(bArr);
            }
        });
        registerType(308, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.29
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCVoipSignal.parseFrom(bArr);
            }
        });
        registerType(SocketMessages.PayloadType.SC_WISH_LIST_OPENED, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.30
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCWishListOpened.parseFrom(bArr);
            }
        });
        registerType(SocketMessages.PayloadType.SC_WISH_LIST_CLOSED, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.31
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCWishListClosed.parseFrom(bArr);
            }
        });
        registerType(521, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.32
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveFansTopOpened.parseFrom(bArr);
            }
        });
        registerType(522, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.33
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveFansTopClosed.parseFrom(bArr);
            }
        });
        registerType(587, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.34
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveDistrictRankInfo.parseFrom(bArr);
            }
        });
        registerType(588, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.35
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveStreamMessages.SCLiveDistrictRankClosed.parseFrom(bArr);
            }
        });
        registerType(595, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.36
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveFansGroupMessages.SCLiveFansGroupStatusChanged.parseFrom(bArr);
            }
        });
        registerType(641, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.37
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveExtraMessages.SCLiveCommonStateSignal.parseFrom(bArr);
            }
        });
        registerType(642, new FunctionWithThrowable<byte[], MessageNano, InvalidProtocolBufferNanoException>() { // from class: com.kuaishou.common.netty.NanoSocketMessageUtil.38
            @Override // com.kuaishou.common.netty.function.FunctionWithThrowable
            public MessageNano apply(byte[] bArr) {
                return LiveExtraMessages.SCLiveCommonPreciseControlSignal.parseFrom(bArr);
            }
        });
    }

    public static void registerType(int i, FunctionWithThrowable<byte[], ? extends MessageNano, InvalidProtocolBufferNanoException> functionWithThrowable) {
        FunctionWithThrowable<byte[], ? extends MessageNano, InvalidProtocolBufferNanoException> functionWithThrowablePut = parsers.put(Integer.valueOf(i), functionWithThrowable);
        if (functionWithThrowablePut == null) {
            return;
        }
        throw new IllegalArgumentException("parser already registered:" + functionWithThrowablePut.getClass().getSimpleName());
    }

    public static boolean hasRegisteredType(int i) {
        return parsers.containsKey(Integer.valueOf(i));
    }

    public static SocketMessages.SocketMessage pack(MessageNano messageNano, int i) {
        SocketMessages.SocketMessage socketMessage = new SocketMessages.SocketMessage();
        socketMessage.payloadType = i;
        socketMessage.compressionType = 1;
        socketMessage.payload = MessageNano.toByteArray(messageNano);
        return socketMessage;
    }

    public static <T extends MessageNano> T unpack(SocketMessages.SocketMessage socketMessage) throws IOException {
        int i = socketMessage.payloadType;
        FunctionWithThrowable<byte[], ? extends MessageNano, InvalidProtocolBufferNanoException> functionWithThrowable = parsers.get(Integer.valueOf(i));
        if (functionWithThrowable != null) {
            try {
                byte[] bArrUngzip = socketMessage.payload;
                if (socketMessage.compressionType == 2) {
                    bArrUngzip = CompressionUtil.ungzip(socketMessage.payload);
                }
                return (T) functionWithThrowable.apply(bArrUngzip);
            } catch (InvalidProtocolBufferNanoException e) {
                throw new RuntimeException(e);
            }
        }
        throw new IllegalArgumentException("Unknown payload type:" + i);
    }
}
