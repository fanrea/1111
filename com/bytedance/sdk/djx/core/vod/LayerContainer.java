package com.bytedance.sdk.djx.core.vod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.djx.core.vod.layerevent.LayerEvent;
import com.bytedance.sdk.djx.core.vod.layerevent.LayerEventManager;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class LayerContainer extends FrameLayout implements IVideoLayer {
    private IVideoController mController;
    private LayerEventManager mEventManager;
    private final List<IVideoLayer> mLayerList;

    @Override // com.bytedance.sdk.djx.core.vod.IVideoLayer
    public View getView() {
        return this;
    }

    protected void init(Context context) {
    }

    public LayerContainer(Context context) {
        super(context);
        this.mLayerList = new LinkedList();
        init(context);
    }

    public LayerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLayerList = new LinkedList();
        init(context);
    }

    public LayerContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLayerList = new LinkedList();
        init(context);
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoLayer
    public void attach(IVideoController iVideoController, LayerEventManager layerEventManager) {
        this.mController = iVideoController;
        this.mEventManager = layerEventManager;
    }

    public void addLayer(IVideoLayer iVideoLayer) {
        if (iVideoLayer != null) {
            this.mLayerList.add(iVideoLayer);
            iVideoLayer.attach(this.mController, this.mEventManager);
            if (iVideoLayer.getView() != null) {
                addView(iVideoLayer.getView(), new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoLayer
    public void onLayerEvent(LayerEvent layerEvent) {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onLayerEvent(layerEvent);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onPrepared() {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onPrepared();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onRenderFirstFrame() {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onRenderFirstFrame();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onError(int i, String str, Throwable th) {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onError(i, str, th);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onCompletion() {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onCompletion();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onInfo(int i, int i2) {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onInfo(i, i2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onVideoSizeChanged(int i, int i2) {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onVideoSizeChanged(i, i2);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoListener
    public void onDurationChange(long j) {
        List<IVideoLayer> list = this.mLayerList;
        if (list != null) {
            for (IVideoLayer iVideoLayer : list) {
                if (iVideoLayer != null) {
                    iVideoLayer.onDurationChange(j);
                }
            }
        }
    }
}
