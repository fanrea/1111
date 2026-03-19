package com.yxcorp.livestream.longconnection.operation;

import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.common.netty.client.ConnectionClient;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import com.kuaishou.socket.nano.SocketMessages;
import com.yxcorp.livestream.longconnection.LiveStreamLogger;
import com.yxcorp.livestream.longconnection.LongConnectionContext;
import com.yxcorp.livestream.longconnection.handler.SCHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class HorseRaceOperation implements Runnable {
    private static final String TAG = "HorseRaceOperation";
    final Runnable mCallback;
    final LongConnectionContext mContext;
    private final String mHorseTag;

    public HorseRaceOperation(LongConnectionContext longConnectionContext, String str, Runnable runnable) {
        this.mContext = longConnectionContext;
        this.mCallback = runnable;
        this.mHorseTag = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ConnectionClient client = this.mContext.getClient();
        if (client == null) {
            LiveStreamLogger.debugLog(TAG, "HorseRaceOperationOnNullClient", new Object[0]);
            return;
        }
        LiveStreamMessages.CSHorseRacing cSHorseRacing = new LiveStreamMessages.CSHorseRacing();
        cSHorseRacing.clientId = 2;
        cSHorseRacing.deviceId = this.mContext.getLongConnectionParams().getDeviceId();
        cSHorseRacing.isAuthor = this.mContext.getLongConnectionParams().isAuthor();
        cSHorseRacing.locale = this.mContext.getLongConnectionParams().getLocale();
        cSHorseRacing.operator = this.mContext.getLongConnectionParams().getOperator();
        cSHorseRacing.liveStreamId = this.mContext.getLongConnectionParams().getLiveStreamId();
        cSHorseRacing.appVer = this.mContext.getLongConnectionParams().getAppVer();
        cSHorseRacing.horseTag = this.mHorseTag;
        cSHorseRacing.clientVisitorId = this.mContext.getLongConnectionParams().getUserId();
        cSHorseRacing.latitude = this.mContext.getLongConnectionParams().getLatitude();
        cSHorseRacing.longitude = this.mContext.getLongConnectionParams().getLongitude();
        LiveStreamLogger.debugLog(TAG, "Send CSHorseRacing, liveStreamId: " + cSHorseRacing.liveStreamId, new Object[0]);
        SocketMessages.SocketMessage socketMessagePack = NanoSocketMessageUtil.pack(cSHorseRacing, 204);
        client.getChannelHandler().getPayloadHandlers().addHandler(307, new SCHandler<LiveStreamMessages.SCHorseRacingAck>(this.mContext) { // from class: com.yxcorp.livestream.longconnection.operation.HorseRaceOperation.1
            @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
            public void handleMessage(LiveStreamMessages.SCHorseRacingAck sCHorseRacingAck) {
                LiveStreamLogger.debugLog(HorseRaceOperation.TAG, "receive SCHorseRacingAck", "msg", sCHorseRacingAck);
                if (HorseRaceOperation.this.mCallback != null) {
                    HorseRaceOperation.this.mCallback.run();
                }
            }
        });
        new SendMessageOperation(this.mContext, socketMessagePack).run();
    }
}
