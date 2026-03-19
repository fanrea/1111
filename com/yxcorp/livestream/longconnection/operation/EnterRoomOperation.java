package com.yxcorp.livestream.longconnection.operation;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.common.netty.client.ConnectionClient;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import com.yxcorp.livestream.longconnection.OnConnectionExceptionListener;
import com.yxcorp.livestream.longconnection.exception.EnterRoomTimeOutException;
import com.yxcorp.livestream.longconnection.handler.SCEnterRoomHandler;
import com.yxcorp.livestream.longconnection.handler.SCErrorHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class EnterRoomOperation implements Runnable {
    private static final int ENTER_ROOM_TIMEOUT = 10000;
    private static final String TAG = "EnterRoomOperation";
    private final LongConnectionContext mContext;

    public EnterRoomOperation(LongConnectionContext longConnectionContext) {
        this.mContext = longConnectionContext;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConnectionClient client = this.mContext.getClient();
        if (client == null) {
            return;
        }
        LiveStreamMessages.CSEnterRoom cSEnterRoom = new LiveStreamMessages.CSEnterRoom();
        cSEnterRoom.token = this.mContext.getLongConnectionParams().getToken();
        cSEnterRoom.clientId = this.mContext.getLongConnectionParams().getClientId();
        cSEnterRoom.deviceId = this.mContext.getLongConnectionParams().getDeviceId();
        cSEnterRoom.isAuthor = this.mContext.getLongConnectionParams().isAuthor();
        cSEnterRoom.isCustodian = this.mContext.getLongConnectionParams().isEscrow();
        cSEnterRoom.isSimpleLive = this.mContext.getLongConnectionParams().isSimpleLive();
        cSEnterRoom.reconnectCount = this.mContext.getLongConnectionParams().getRetryCount();
        cSEnterRoom.lastErrorCode = this.mContext.getLongConnectionParams().getLastErrorCode();
        cSEnterRoom.locale = this.mContext.getLongConnectionParams().getLocale();
        cSEnterRoom.location = this.mContext.getLongConnectionParams().getLocation();
        cSEnterRoom.operator = this.mContext.getLongConnectionParams().getOperator();
        cSEnterRoom.liveStreamId = this.mContext.getLongConnectionParams().getLiveStreamId();
        cSEnterRoom.firstEnter = this.mContext.getLongConnectionParams().isFirstEnterRoom();
        cSEnterRoom.appVer = this.mContext.getLongConnectionParams().getAppVer();
        cSEnterRoom.sys = this.mContext.getLongConnectionParams().getSys();
        cSEnterRoom.sysVer = this.mContext.getLongConnectionParams().getSysVer();
        cSEnterRoom.phoneModel = this.mContext.getLongConnectionParams().getPhoneModel();
        cSEnterRoom.channel = this.mContext.getLongConnectionParams().getChannel();
        cSEnterRoom.expTag = this.mContext.getLongConnectionParams().getExpTag();
        cSEnterRoom.attach = this.mContext.getLongConnectionParams().getAttach();
        cSEnterRoom.appType = this.mContext.getLongConnectionParams().getAppType();
        cSEnterRoom.sourceType = this.mContext.getLongConnectionParams().getLiveStreamStartPlaySourceType();
        cSEnterRoom.broadcastGiftToken = this.mContext.getLongConnectionParams().getBroadcastGiftToken();
        cSEnterRoom.redPackId = this.mContext.getLongConnectionParams().getPushArrowRedPacketId();
        cSEnterRoom.serviceToken = this.mContext.getLongConnectionParams().getServiceToken();
        cSEnterRoom.kpf = this.mContext.getLongConnectionParams().getKpf();
        cSEnterRoom.kpn = this.mContext.getLongConnectionParams().getKpn();
        try {
            cSEnterRoom.authorId = Long.parseLong(this.mContext.getLongConnectionParams().getAnchorId());
        } catch (Exception unused) {
        }
        LiveStreamLogger.debugLog(TAG, cSEnterRoom.toString(), new Object[0]);
        this.mContext.setLastErrorCode(0);
        SocketMessages.SocketMessage socketMessagePack = NanoSocketMessageUtil.pack(cSEnterRoom, 200);
        this.mContext.setMessageLastSendTime(200, SystemClock.elapsedRealtime());
        client.getChannelHandler().getPayloadHandlers().addHandler(300, new SCEnterRoomHandler(this.mContext));
        new SendMessageOperation(this.mContext, socketMessagePack).run();
        this.mContext.getMessageRunnablePipeline().postDelayed(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.EnterRoomOperation.1
            @Override // java.lang.Runnable
            public void run() {
                EnterRoomOperation.this.checkEnterRoomTimeOut();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    void checkEnterRoomTimeOut() {
        Long messageLastSendTime = this.mContext.getMessageLastSendTime(200);
        Long messageLastReceiveTime = this.mContext.getMessageLastReceiveTime(300);
        if (messageLastSendTime == null || SCErrorHandler.isLiveEndError(this.mContext.getLastErrorCode())) {
            return;
        }
        if ((messageLastReceiveTime == null || messageLastReceiveTime.longValue() <= messageLastSendTime.longValue()) && SystemClock.elapsedRealtime() - messageLastSendTime.longValue() >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            this.mContext.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.operation.EnterRoomOperation.2
                @Override // java.lang.Runnable
                public void run() {
                    OnConnectionExceptionListener exceptionListener = EnterRoomOperation.this.mContext.getExceptionListener();
                    if (exceptionListener != null) {
                        exceptionListener.onClientException(new EnterRoomTimeOutException());
                    }
                }
            });
        }
    }
}
