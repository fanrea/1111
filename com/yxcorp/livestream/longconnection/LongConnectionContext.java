package com.yxcorp.livestream.longconnection;

import android.os.Handler;
import android.os.Looper;
import com.google.protobuf.nano.MessageNano;
import com.kuaishou.common.netty.NanoSocketMessageUtil;
import com.kuaishou.common.netty.client.ConnectionClient;
import com.kuaishou.common.netty.client.handler.ClientNanoPayloadHandlers;
import com.yxcorp.livestream.longconnection.LongConnectionParams;
import com.yxcorp.livestream.longconnection.handler.SCHandler;
import com.yxcorp.livestream.longconnection.handler.SCHeartbeatHandler;
import com.yxcorp.livestream.longconnection.operation.HeartbeatOperation;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LongConnectionContext {
    private static final long DEFAULT_HEARTBEAT_INTERVAL = 60000;
    private static final int DEFAULT_MAX_RECONNECT_LATENCY = 5000;
    private static final int DEFAULT_MIN_RECONNECT_LATENCY = 5000;
    public static final int LIVESTREAM_ADMIN_STOP = 603;
    public static final int LIVESTREAM_AUTH_FAILD = 60;
    public static final int LIVESTREAM_LIVING_END = 601;
    public static final int LIVESTREAM_LIVING_END_BY_REMOTE = 607;
    public static final int LIVESTREAM_NEW_ONE_OPENED = 611;
    public static final int LIVESTREAM_QUOTA_OUT = 602;
    public static final int LIVESTREAM_SERVER_BUSY = 608;
    private static final String TAG = "LongConnectionContext";
    private static Random sRandom = new Random();
    private ConnectionClient mClient;
    private LongConnectionParams.ServerUriInfo mCurrentServerUriInfo;
    private OnConnectionExceptionListener mExceptionListener;
    public HeartbeatListener mHeartbeatListener;
    private HeartbeatOperation mHeartbeatOperation;
    private LiveInfoListener mInfoListener;
    private int mLastErrorCode;
    private LongConnectionParams mLongConnectionParams;
    public LiveMessageListener mMessageListener;
    private RunnablePipeline mMessageRunnablePipeline;
    private long mMinReconnectLatency = 5000;
    private long mMaxReconnectLatency = 5000;
    private long mHeartbeatInterval = 60000;
    private Map<Integer, Long> mMessageLastSendTimeMap = new ConcurrentHashMap();
    private Map<Integer, Long> mMessageLastReceiveTimeMap = new ConcurrentHashMap();
    private Handler mUiHandler = new Handler(Looper.getMainLooper());
    private Map<Integer, SCMessageListenerGroup> mMessageListenerMap = new ConcurrentHashMap();

    public <T extends MessageNano> void registerSCMessageListener(int i, Class<T> cls, SCMessageListener<T> sCMessageListener) {
        SCMessageListenerGroup sCMessageListenerGroup = this.mMessageListenerMap.get(Integer.valueOf(i));
        if (sCMessageListenerGroup == null) {
            sCMessageListenerGroup = new SCMessageListenerGroup(cls);
            this.mMessageListenerMap.put(Integer.valueOf(i), sCMessageListenerGroup);
        }
        sCMessageListenerGroup.remove(sCMessageListener);
        sCMessageListenerGroup.add(sCMessageListener);
    }

    public <T extends MessageNano> void unregisterSCMessageListener(int i, SCMessageListener<T> sCMessageListener) {
        SCMessageListenerGroup sCMessageListenerGroup = this.mMessageListenerMap.get(Integer.valueOf(i));
        if (sCMessageListenerGroup != null) {
            sCMessageListenerGroup.remove(sCMessageListener);
        }
    }

    public <T extends MessageNano> void clearSCMessageListener() {
        this.mMessageListenerMap.clear();
        this.mUiHandler.removeCallbacksAndMessages(null);
    }

    public Random getRandom() {
        return sRandom;
    }

    public int getLastErrorCode() {
        return this.mLastErrorCode;
    }

    public void setLastErrorCode(int i) {
        this.mLastErrorCode = i;
    }

    public long getHeartbeatInterval() {
        return this.mHeartbeatInterval;
    }

    public long getNextConnectLatency() {
        return this.mMinReconnectLatency + ((long) ((this.mMaxReconnectLatency - r0) * sRandom.nextFloat()));
    }

    public void updateLatency(long j, long j2, long j3) {
        this.mMinReconnectLatency = j;
        this.mMaxReconnectLatency = j2;
        this.mHeartbeatInterval = j3;
    }

    public void setMessageLastSendTime(int i, long j) {
        this.mMessageLastSendTimeMap.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public Long getMessageLastSendTime(int i) {
        return this.mMessageLastSendTimeMap.get(Integer.valueOf(i));
    }

    public void setMessageLastReceiveTime(int i, long j) {
        this.mMessageLastReceiveTimeMap.put(Integer.valueOf(i), Long.valueOf(j));
    }

    public Long getMessageLastReceiveTime(int i) {
        return this.mMessageLastReceiveTimeMap.get(Integer.valueOf(i));
    }

    public LongConnectionParams getLongConnectionParams() {
        return this.mLongConnectionParams;
    }

    void setLongConnectionParams(LongConnectionParams longConnectionParams) {
        this.mLongConnectionParams = longConnectionParams;
    }

    public OnConnectionExceptionListener getExceptionListener() {
        return this.mExceptionListener;
    }

    void setExceptionListener(OnConnectionExceptionListener onConnectionExceptionListener) {
        this.mExceptionListener = onConnectionExceptionListener;
    }

    public LiveInfoListener getInfoListener() {
        return this.mInfoListener;
    }

    void setInfoListener(LiveInfoListener liveInfoListener) {
        this.mInfoListener = liveInfoListener;
    }

    void setMessageListener(LiveMessageListener liveMessageListener) {
        this.mMessageListener = liveMessageListener;
    }

    public LiveMessageListener getMessageListener() {
        return this.mMessageListener;
    }

    public void setHeartbeatListener(HeartbeatListener heartbeatListener) {
        this.mHeartbeatListener = heartbeatListener;
    }

    public HeartbeatListener getHeartbeatListener() {
        return this.mHeartbeatListener;
    }

    public void setClient(ConnectionClient connectionClient) {
        ConnectionClient connectionClient2 = this.mClient;
        if (connectionClient2 != null && connectionClient == null) {
            try {
                connectionClient2.close();
            } finally {
                try {
                } finally {
                }
            }
        }
        this.mClient = connectionClient;
    }

    public ConnectionClient getClient() {
        return this.mClient;
    }

    void setMessageRunnablePipeline(RunnablePipeline runnablePipeline) {
        this.mMessageRunnablePipeline = runnablePipeline;
    }

    public LongConnectionParams.ServerUriInfo getCurrentServerUriInfo() {
        return this.mCurrentServerUriInfo;
    }

    public void setCurrentServerUriInfo(LongConnectionParams.ServerUriInfo serverUriInfo) {
        this.mCurrentServerUriInfo = serverUriInfo;
    }

    public RunnablePipeline getMessageRunnablePipeline() {
        return this.mMessageRunnablePipeline;
    }

    public Handler getUiHandler() {
        return this.mUiHandler;
    }

    public void submitOperation(Runnable runnable) {
        getMessageRunnablePipeline().post(runnable);
    }

    public void startHeartbeat() {
        SCHeartbeatHandler sCHeartbeatHandler = new SCHeartbeatHandler();
        getClient().getChannelHandler().getPayloadHandlers().addHandler(101, sCHeartbeatHandler);
        HeartbeatOperation heartbeatOperation = this.mHeartbeatOperation;
        if (heartbeatOperation != null) {
            this.mMessageRunnablePipeline.remove(heartbeatOperation);
        }
        sCHeartbeatHandler.setHeartbeatAckListener(new HeartbeatAckListener() { // from class: com.yxcorp.livestream.longconnection.LongConnectionContext.1
            @Override // com.yxcorp.livestream.longconnection.HeartbeatAckListener
            public void onHeartbeatAckReceived(long j, long j2) {
                LiveStreamLogger.debugLog(LongConnectionContext.TAG, "receiveHeartbeatAck serverTimestamp: " + j + ", clientTimestamp: " + j2, new Object[0]);
                if (LongConnectionContext.this.mHeartbeatListener != null) {
                    LongConnectionContext.this.mHeartbeatListener.onHeartbeatAckReceived(j, j2);
                }
            }
        });
        this.mHeartbeatOperation = new HeartbeatOperation(this, sCHeartbeatHandler);
        this.mMessageRunnablePipeline.post(this.mHeartbeatOperation);
    }

    public void retryHeartbeat() {
        this.mMessageRunnablePipeline.postDelayed(this.mHeartbeatOperation, getHeartbeatInterval());
    }

    public void stopHeartbeat() {
        this.mMessageRunnablePipeline.remove(this.mHeartbeatOperation);
    }

    public void registerHandlers() {
        ConnectionClient connectionClient = this.mClient;
        if (connectionClient == null || connectionClient.getChannelHandler() == null) {
            return;
        }
        ClientNanoPayloadHandlers payloadHandlers = this.mClient.getChannelHandler().getPayloadHandlers();
        for (final Map.Entry<Integer, SCMessageListenerGroup> entry : this.mMessageListenerMap.entrySet()) {
            SCMessageListenerGroup value = entry.getValue();
            if (!NanoSocketMessageUtil.hasRegisteredType(entry.getKey().intValue())) {
                NanoSocketMessageUtil.registerType(entry.getKey().intValue(), new MessageNanoParser(value.mClazz));
            }
            payloadHandlers.addHandler(entry.getKey().intValue(), new SCHandler<MessageNano>(this) { // from class: com.yxcorp.livestream.longconnection.LongConnectionContext.2
                @Override // com.yxcorp.livestream.longconnection.handler.SCHandler
                public void handleMessage(final MessageNano messageNano) {
                    LongConnectionContext.this.getUiHandler().post(new Runnable() { // from class: com.yxcorp.livestream.longconnection.LongConnectionContext.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SCMessageListenerGroup sCMessageListenerGroup = (SCMessageListenerGroup) LongConnectionContext.this.mMessageListenerMap.get(entry.getKey());
                            if (sCMessageListenerGroup != null) {
                                sCMessageListenerGroup.onMessageReceived(messageNano);
                            }
                        }
                    });
                }
            });
        }
    }
}
