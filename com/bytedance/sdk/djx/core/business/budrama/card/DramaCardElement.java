package com.bytedance.sdk.djx.core.business.budrama.card;

import android.view.View;
import com.bytedance.sdk.djx.core.business.base.ElementProxy;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.params.DJXWidgetDramaCardParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaCardElement extends ElementProxy {
    private static final String TAG = "DramaCardElement";
    private final DramaDetail mDramaDetail;
    private final DJXWidgetDramaCardParams mParams;
    private DJXDramaCardView mView;

    public DramaCardElement(DramaDetail dramaDetail, DJXWidgetDramaCardParams dJXWidgetDramaCardParams) {
        this.mDramaDetail = dramaDetail;
        this.mParams = dJXWidgetDramaCardParams;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public Drama getDrama() {
        return this.mDramaDetail.getDrama();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public View getView() {
        if (this.mView == null) {
            this.mView = DJXDramaCardView.createDramaCard(InnerManager.getContext(), this.mParams, this.mDramaDetail);
        }
        return this.mView;
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public void reportShow(long j) {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            return;
        }
        dJXDramaCardView.reportShow(j);
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public void start() {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            LG.e(TAG, "start: view is null, plz invoke IDJXElement#getView first");
        } else {
            dJXDramaCardView.start();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public void pause() {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            LG.e(TAG, "pause: view is null, plz invoke IDJXElement#getView first");
        } else {
            dJXDramaCardView.pause();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public void stop() {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            LG.e(TAG, "stop: view is null, plz invoke IDJXElement#getView first");
        } else {
            dJXDramaCardView.stop();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public Boolean isPlaying() {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            LG.e(TAG, "isPlaying: view is null, plz invoke IDJXElement#getView first");
            return null;
        }
        return dJXDramaCardView.isPlaying();
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public void setMute(boolean z) {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            LG.e(TAG, "setMute: view is null, plz invoke IDJXElement#getView first");
        } else {
            dJXDramaCardView.setMute(z);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public void destroy() {
        DJXDramaCardView dJXDramaCardView = this.mView;
        if (dJXDramaCardView == null) {
            LG.e(TAG, "destroy: view is null, plz invoke IDJXElement#getView first");
        } else {
            dJXDramaCardView.destroy();
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.base.ElementProxy, com.bytedance.sdk.djx.IDJXElement
    public long getGid() {
        return this.mDramaDetail.getGroupId();
    }
}
