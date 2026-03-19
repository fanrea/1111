package com.bytedance.sdk.djx.core.business.base;

import android.view.View;
import com.bytedance.sdk.djx.IDJXElement;
import com.bytedance.sdk.djx.model.Drama;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class ElementProxy implements IDJXElement {
    @Override // com.bytedance.sdk.djx.IDJXElement
    public void destroy() {
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public Drama getDrama() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public long getGid() {
        return -1L;
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public String getTitle() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public abstract View getView();

    @Override // com.bytedance.sdk.djx.IDJXElement
    public Boolean isPlaying() {
        return null;
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public void pause() {
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public void refresh() {
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public void reportShow(long j) {
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public void setMute(boolean z) {
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public void start() {
    }

    @Override // com.bytedance.sdk.djx.IDJXElement
    public void stop() {
    }
}
