package com.bytedance.sdk.djx.params;

import com.bytedance.sdk.djx.IDJXDramaDetailDelegate;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaHomeListener;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXWidgetDramaHomeParams extends DJXWidgetParam {
    public DJXDramaDetailConfig mDetailConfig;
    public boolean mShowChangeBtn = true;
    public boolean mShowPageTitle = true;
    public boolean mShowBackBtn = true;
    public int mTopDramaId = 0;
    public List<String> mTopDramaIds = null;
    public int mTopOffset = -1;
    public IDJXDramaHomeListener mListener = null;
    public IDJXDramaDetailDelegate mEnterDelegate = null;
    public IDJXAdListener mDJXHomeAdListener = null;

    public DJXWidgetDramaHomeParams setEnterDelegate(IDJXDramaDetailDelegate iDJXDramaDetailDelegate) {
        this.mEnterDelegate = iDJXDramaDetailDelegate;
        return this;
    }

    public DJXWidgetDramaHomeParams topDramaId(int i) {
        this.mTopDramaId = i;
        return this;
    }

    public DJXWidgetDramaHomeParams showChangeBtn(boolean z) {
        this.mShowChangeBtn = z;
        return this;
    }

    public DJXWidgetDramaHomeParams showPageTitle(boolean z) {
        this.mShowPageTitle = z;
        return this;
    }

    public DJXWidgetDramaHomeParams showBackBtn(boolean z) {
        this.mShowBackBtn = z;
        return this;
    }

    public DJXWidgetDramaHomeParams setTopOffset(int i) {
        this.mTopOffset = i;
        return this;
    }

    public DJXWidgetDramaHomeParams listener(IDJXDramaHomeListener iDJXDramaHomeListener) {
        this.mListener = iDJXDramaHomeListener;
        return this;
    }

    public static DJXWidgetDramaHomeParams obtain(DJXDramaDetailConfig dJXDramaDetailConfig) {
        return new DJXWidgetDramaHomeParams(dJXDramaDetailConfig);
    }

    private DJXWidgetDramaHomeParams(DJXDramaDetailConfig dJXDramaDetailConfig) {
        this.mDetailConfig = dJXDramaDetailConfig;
    }

    public String toString() {
        return "DJXWidgetDramaHomeParams{, topDramaID=" + this.mTopDramaId + ", showChangeBtn=" + this.mShowChangeBtn + ", showPageTitle=" + this.mShowPageTitle + ", showBackBtn=" + this.mShowBackBtn + '}';
    }
}
