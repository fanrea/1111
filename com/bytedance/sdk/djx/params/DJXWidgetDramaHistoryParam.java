package com.bytedance.sdk.djx.params;

import com.bytedance.sdk.djx.IDJXDramaDetailDelegate;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDrawListener;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXWidgetDramaHistoryParam extends DJXWidgetParam {
    public final DJXDramaDetailConfig mDramaDetailConfig;
    public int mHeight;
    public IDJXAdListener mIDJXDramaAdListener;
    public IDJXDramaListener mIDJXDramaListener;
    public IDJXDrawListener mIDJXDrawListener;
    public String mScene;
    public int mWidth;
    public PageType mPageType = PageType.USER_HOME_PAGE;
    public boolean mHideCloseIcon = false;
    public IDJXDramaDetailDelegate mEnterDelegate = null;

    public enum PageType {
        USER_HOME_PAGE,
        USER_FAVORITE_VIDEO_PAGE,
        USER_FOCUS_PAGE,
        USER_DRAMA_HISTORY_PAGE
    }

    private DJXWidgetDramaHistoryParam(DJXDramaDetailConfig dJXDramaDetailConfig) {
        this.mDramaDetailConfig = dJXDramaDetailConfig;
    }

    public static DJXWidgetDramaHistoryParam obtain(DJXDramaDetailConfig dJXDramaDetailConfig) {
        return new DJXWidgetDramaHistoryParam(dJXDramaDetailConfig);
    }

    public DJXWidgetDramaHistoryParam setEnterDelegate(IDJXDramaDetailDelegate iDJXDramaDetailDelegate) {
        this.mEnterDelegate = iDJXDramaDetailDelegate;
        return this;
    }

    public DJXWidgetDramaHistoryParam hideCloseIcon(boolean z) {
        this.mHideCloseIcon = z;
        return this;
    }

    public DJXWidgetDramaHistoryParam height(int i) {
        this.mHeight = i;
        return this;
    }

    public DJXWidgetDramaHistoryParam scene(String str) {
        this.mScene = str;
        return this;
    }

    public DJXWidgetDramaHistoryParam listener(IDJXDrawListener iDJXDrawListener) {
        this.mIDJXDrawListener = iDJXDrawListener;
        return this;
    }

    public DJXWidgetDramaHistoryParam pageType(PageType pageType) {
        this.mPageType = pageType;
        return this;
    }

    public DJXWidgetDramaHistoryParam width(int i) {
        this.mWidth = i;
        return this;
    }

    public DJXWidgetDramaHistoryParam dramaListener(IDJXDramaListener iDJXDramaListener) {
        this.mIDJXDramaListener = iDJXDramaListener;
        return this;
    }

    public DJXWidgetDramaHistoryParam dramaAdListener(IDJXAdListener iDJXAdListener) {
        this.mIDJXDramaAdListener = iDJXAdListener;
        return this;
    }

    public String toString() {
        return "mHideCloseIcon = " + this.mHideCloseIcon + ", mPageType = " + this.mPageType + ", mWidth = " + this.mWidth + ", mHeight = " + this.mHeight;
    }
}
