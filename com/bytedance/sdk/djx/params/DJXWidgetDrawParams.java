package com.bytedance.sdk.djx.params;

import android.view.View;
import com.bytedance.sdk.djx.IDJXDramaDetailDelegate;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDrawListener;
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DJXWidgetDrawParams {
    public static final int APPEND = 2;
    private static final float DEFAULT_REPORT_TOP_PADDING = 64.0f;
    public static final int DRAW_CHANNEL_TYPE_RECOMMEND = 1;
    public static final int DRAW_CHANNEL_TYPE_RECOMMEND_THEATER = 3;
    public static final int DRAW_CHANNEL_TYPE_THEATER = 2;
    public static final int DRAW_CONTENT_TYPE_ONLY_DRAMA = 1;
    public static final int PROGRESS_BAR_STYLE_DARK = 2;
    public static final int PROGRESS_BAR_STYLE_LIGHT = 1;
    public static final int REFRESH = 1;
    public String mAdCodeId;
    public IDJXAdListener mAdListener;
    public int mAdOffset;
    public View.OnClickListener mCloseListener;
    public String mCustomCategory;
    public DJXDramaDetailConfig mDetailConfig;
    public IDJXDramaListener mDetailListener;
    public IDJXDrawListener mListener;
    public String mNativeAdCodeId;
    public int mBottomOffset = -1;
    public int mTitleTopMargin = -1;
    public int mTitleLeftMargin = -1;
    public int mTitleRightMargin = -1;
    public int mDrawContentType = 1;
    public int mDrawChannelType = 1;
    public boolean mIsHideChannelName = false;
    public boolean mIsHideDramaInfo = false;
    public boolean mIsHideDramaEnter = false;
    public boolean mIsHideLikeButton = false;
    public boolean mIsHideDoubleClickLike = false;
    public boolean mIsHideLongClickSpeed = false;
    public boolean mIsHideFavorButton = false;
    public boolean mEnableRefresh = true;
    public boolean mIsHideClose = false;
    public boolean mIsShowGuide = true;
    public int mProgressBarStyle = 1;
    public float mReportTopPadding = DEFAULT_REPORT_TOP_PADDING;
    public int mDramaFree = 1;
    public long mTopDramaId = -1;
    public IDJXDramaDetailDelegate mEnterDelegate = null;

    public static DJXWidgetDrawParams obtain() {
        return new DJXWidgetDrawParams();
    }

    private DJXWidgetDrawParams() {
    }

    public DJXWidgetDrawParams setEnterDelegate(IDJXDramaDetailDelegate iDJXDramaDetailDelegate) {
        this.mEnterDelegate = iDJXDramaDetailDelegate;
        return this;
    }

    public DJXWidgetDrawParams adCodeId(String str) {
        this.mAdCodeId = str;
        return this;
    }

    public DJXWidgetDrawParams nativeAdCodeId(String str) {
        this.mNativeAdCodeId = str;
        return this;
    }

    public DJXWidgetDrawParams adOffset(int i) {
        this.mAdOffset = i;
        return this;
    }

    public DJXWidgetDrawParams hideClose(boolean z, View.OnClickListener onClickListener) {
        this.mIsHideClose = z;
        this.mCloseListener = onClickListener;
        return this;
    }

    public DJXWidgetDrawParams showGuide(boolean z) {
        this.mIsShowGuide = z;
        return this;
    }

    public DJXWidgetDrawParams enableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    public DJXWidgetDrawParams listener(IDJXDrawListener iDJXDrawListener) {
        this.mListener = iDJXDrawListener;
        return this;
    }

    public DJXWidgetDrawParams dramaListener(IDJXDramaListener iDJXDramaListener) {
        this.mDetailListener = iDJXDramaListener;
        return this;
    }

    public DJXWidgetDrawParams adListener(IDJXAdListener iDJXAdListener) {
        this.mAdListener = iDJXAdListener;
        return this;
    }

    public DJXWidgetDrawParams customCategory(String str) {
        this.mCustomCategory = str;
        return this;
    }

    public DJXWidgetDrawParams progressBarStyle(int i) {
        this.mProgressBarStyle = i;
        return this;
    }

    @Deprecated
    public DJXWidgetDrawParams reportTopPadding(float f) {
        this.mReportTopPadding = f;
        return this;
    }

    public DJXWidgetDrawParams bottomOffset(int i) {
        this.mBottomOffset = i;
        return this;
    }

    public DJXWidgetDrawParams titleTopMargin(int i) {
        this.mTitleTopMargin = i;
        return this;
    }

    public DJXWidgetDrawParams titleLeftMargin(int i) {
        this.mTitleLeftMargin = i;
        return this;
    }

    public DJXWidgetDrawParams titleRightMargin(int i) {
        this.mTitleRightMargin = i;
        return this;
    }

    public DJXWidgetDrawParams drawContentType(int i) {
        if (!DevInfo.getPrivacyController().isTeenagerMode()) {
            this.mDrawContentType = i;
        }
        return this;
    }

    public DJXWidgetDrawParams drawChannelType(int i) {
        this.mDrawChannelType = i;
        return this;
    }

    public DJXWidgetDrawParams hideChannelName(boolean z) {
        this.mIsHideChannelName = z;
        return this;
    }

    public DJXWidgetDrawParams hideDramaInfo(boolean z) {
        this.mIsHideDramaInfo = z;
        return this;
    }

    public DJXWidgetDrawParams hideDramaEnter(boolean z) {
        this.mIsHideDramaEnter = z;
        return this;
    }

    public DJXWidgetDrawParams detailConfig(DJXDramaDetailConfig dJXDramaDetailConfig) {
        this.mDetailConfig = dJXDramaDetailConfig;
        return this;
    }

    public DJXWidgetDrawParams dramaFree(int i) {
        this.mDramaFree = Math.max(i, 1);
        return this;
    }

    public DJXWidgetDrawParams topDramaId(long j) {
        this.mTopDramaId = j;
        return this;
    }

    public DJXWidgetDrawParams hideLikeButton(boolean z) {
        this.mIsHideLikeButton = z;
        return this;
    }

    public DJXWidgetDrawParams hideDoubleClickLike(boolean z) {
        this.mIsHideDoubleClickLike = z;
        return this;
    }

    public DJXWidgetDrawParams hideLongClickSpeed(boolean z) {
        this.mIsHideLongClickSpeed = z;
        return this;
    }

    public DJXWidgetDrawParams hideFavorButton(boolean z) {
        this.mIsHideFavorButton = z;
        return this;
    }

    public String toString() {
        return "DJXWidgetDrawParams{mAdOffset=" + this.mAdOffset + ", mBottomOffset=" + this.mBottomOffset + ", mTitleTopMargin=" + this.mTitleTopMargin + ", mTitleLeftMargin=" + this.mTitleLeftMargin + ", mTitleRightMargin=" + this.mTitleRightMargin + ", mDrawContentType=" + this.mDrawContentType + ", mDrawChannelType=" + this.mDrawChannelType + ", mIsHideChannelName=" + this.mIsHideChannelName + ", mEnableRefresh=" + this.mEnableRefresh + ", mIsHideClose=" + this.mIsHideClose + ", mIsShowGuide=" + this.mIsShowGuide + ", mCloseListener=" + this.mCloseListener + ", mListener=" + this.mListener + ", mAdListener=" + this.mAdListener + ", mCustomCategory='" + this.mCustomCategory + ", mProgressBarStyle=" + this.mProgressBarStyle + ", mReportTopPadding=" + this.mReportTopPadding + ", mReportTopPadding=" + this.mReportTopPadding + '}';
    }
}
