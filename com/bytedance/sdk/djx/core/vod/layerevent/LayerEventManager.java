package com.bytedance.sdk.djx.core.vod.layerevent;

import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.djx.utils.WeakHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class LayerEventManager implements WeakHandler.IHandler {
    private static final int WHAT_EVENT = 111;
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private Listener mListener;

    public interface Listener {
        void onLayerEvent(LayerEvent layerEvent);
    }

    public static LayerEventManager build() {
        return new LayerEventManager();
    }

    private LayerEventManager() {
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void send(LayerEvent layerEvent) {
        WeakHandler weakHandler = this.mHandler;
        weakHandler.sendMessage(weakHandler.obtainMessage(111, layerEvent));
    }

    public void handleMsg(Message message) {
        if (this.mListener != null && message.what == 111 && (message.obj instanceof LayerEvent)) {
            this.mListener.onLayerEvent((LayerEvent) message.obj);
        }
    }
}
