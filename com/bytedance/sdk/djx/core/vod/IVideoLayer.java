package com.bytedance.sdk.djx.core.vod;

import android.view.View;
import com.bytedance.sdk.djx.core.vod.layerevent.LayerEvent;
import com.bytedance.sdk.djx.core.vod.layerevent.LayerEventManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IVideoLayer extends IVideoListener {
    void attach(IVideoController iVideoController, LayerEventManager layerEventManager);

    View getView();

    void onLayerEvent(LayerEvent layerEvent);
}
