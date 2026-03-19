package com.bytedance.sdk.djx.model;

import android.view.View;
import com.bytedance.sdk.djx.IDJXReportDelegate;
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaAdCustomProvider;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaListener;
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaDetailConfig {
    private IDJXDramaAdCustomProvider mAdCustomProvider;
    private IDJXAdListener mAdListener;
    private final DJXDramaUnlockAdMode mAdMode;
    private View.OnClickListener mCloseListener;
    private final int mFreeSet;
    private IDJXDramaListener mListener;
    private final IDJXDramaUnlockListener mUnlockListener;
    private IDJXReportDelegate mReportDelegate = null;
    private boolean mInfiniteScrollEnabled = true;
    private boolean mHideRewardDialog = false;
    private boolean mHideBack = false;
    private boolean mHideTopInfo = false;
    private boolean mHideBottomInfo = false;
    private boolean mHideMore = false;
    private int mScriptTipsTopMargin = -1;
    private int mIcpTipsBottomMargin = -1;
    private int mBottomOffset = -1;
    private int mTopOffset = -1;
    private boolean mHideCellularToast = false;
    private boolean mHideLikeButton = false;
    private boolean mHideFavorButton = false;
    private boolean mHideDoubleClickLike = false;
    private boolean mHideLongClickSpeed = false;

    private DJXDramaDetailConfig(DJXDramaUnlockAdMode dJXDramaUnlockAdMode, int i, IDJXDramaUnlockListener iDJXDramaUnlockListener) {
        this.mAdMode = dJXDramaUnlockAdMode;
        this.mFreeSet = i;
        this.mUnlockListener = iDJXDramaUnlockListener;
    }

    public static DJXDramaDetailConfig obtain(DJXDramaUnlockAdMode dJXDramaUnlockAdMode, int i, IDJXDramaUnlockListener iDJXDramaUnlockListener) {
        return new DJXDramaDetailConfig(dJXDramaUnlockAdMode, i, iDJXDramaUnlockListener);
    }

    public DJXDramaDetailConfig hideBack(boolean z, View.OnClickListener onClickListener) {
        this.mHideBack = z;
        this.mCloseListener = onClickListener;
        return this;
    }

    public DJXDramaDetailConfig hideTopInfo(boolean z) {
        this.mHideTopInfo = z;
        return this;
    }

    public DJXDramaDetailConfig hideBottomInfo(boolean z) {
        this.mHideBottomInfo = z;
        return this;
    }

    public DJXDramaDetailConfig hideRewardDialog(boolean z) {
        this.mHideRewardDialog = z;
        return this;
    }

    public DJXDramaDetailConfig hideMore(boolean z) {
        this.mHideMore = z;
        return this;
    }

    public DJXDramaDetailConfig listener(IDJXDramaListener iDJXDramaListener) {
        this.mListener = iDJXDramaListener;
        return this;
    }

    public DJXDramaDetailConfig hideCellularToast(boolean z) {
        this.mHideCellularToast = z;
        return this;
    }

    public DJXDramaDetailConfig setBottomOffset(int i) {
        this.mBottomOffset = i;
        return this;
    }

    public DJXDramaDetailConfig infiniteScrollEnabled(boolean z) {
        this.mInfiniteScrollEnabled = z;
        return this;
    }

    public DJXDramaDetailConfig setScriptTipsTopMargin(int i) {
        this.mScriptTipsTopMargin = i;
        return this;
    }

    public DJXDramaDetailConfig adListener(IDJXAdListener iDJXAdListener) {
        this.mAdListener = iDJXAdListener;
        return this;
    }

    public DJXDramaDetailConfig setCustomReport(IDJXReportDelegate iDJXReportDelegate) {
        this.mReportDelegate = iDJXReportDelegate;
        return this;
    }

    public IDJXDramaAdCustomProvider getAdCustomProvider() {
        return this.mAdCustomProvider;
    }

    public DJXDramaDetailConfig adCustomProvider(IDJXDramaAdCustomProvider iDJXDramaAdCustomProvider) {
        this.mAdCustomProvider = iDJXDramaAdCustomProvider;
        return this;
    }

    public DJXDramaDetailConfig setTopOffset(int i) {
        this.mTopOffset = i;
        return this;
    }

    public DJXDramaDetailConfig setIcpTipsBottomMargin(int i) {
        this.mIcpTipsBottomMargin = i;
        return this;
    }

    public DJXDramaDetailConfig hideLikeButton(boolean z) {
        this.mHideLikeButton = z;
        return this;
    }

    public DJXDramaDetailConfig hideFavorButton(boolean z) {
        this.mHideFavorButton = z;
        return this;
    }

    public DJXDramaDetailConfig hideDoubleClick(boolean z) {
        this.mHideDoubleClickLike = z;
        return this;
    }

    public DJXDramaDetailConfig hideLongClickSpeed(boolean z) {
        this.mHideLongClickSpeed = z;
        return this;
    }

    public int getIcpTipsBottomMargin() {
        return this.mIcpTipsBottomMargin;
    }

    public int getTopOffset() {
        return this.mTopOffset;
    }

    public DJXDramaUnlockAdMode getAdMode() {
        return this.mAdMode;
    }

    public int getFreeSet() {
        return this.mFreeSet;
    }

    public IDJXDramaListener getListener() {
        return this.mListener;
    }

    public IDJXAdListener getAdListener() {
        return this.mAdListener;
    }

    public IDJXDramaUnlockListener getUnlockListener() {
        return this.mUnlockListener;
    }

    public boolean isHideRewardDialog() {
        return this.mHideRewardDialog;
    }

    public boolean isHideBack() {
        return this.mHideBack;
    }

    public boolean isHideTopInfo() {
        return this.mHideTopInfo;
    }

    public boolean isHideBottomInfo() {
        return this.mHideBottomInfo;
    }

    public boolean isHideMore() {
        return this.mHideMore;
    }

    public boolean isInfiniteScrollEnabled() {
        return this.mInfiniteScrollEnabled;
    }

    public int getScriptTipsTopMargin() {
        return this.mScriptTipsTopMargin;
    }

    public int getBottomOffset() {
        return this.mBottomOffset;
    }

    public boolean isHideCellularToast() {
        return this.mHideCellularToast;
    }

    public IDJXReportDelegate getReportDelegate() {
        return this.mReportDelegate;
    }

    public View.OnClickListener getCloseListener() {
        return this.mCloseListener;
    }

    public boolean isHideLikeButton() {
        return this.mHideLikeButton;
    }

    public boolean isHideDoubleClick() {
        return this.mHideDoubleClickLike;
    }

    public boolean ismHideLongClickSpeed() {
        return this.mHideLongClickSpeed;
    }

    public boolean isHideFavorButton() {
        return this.mHideFavorButton;
    }

    public String toString() {
        return "DJXDramaDetailConfig{adMode='" + this.mAdMode + ", freeSet=" + this.mFreeSet + ", listener=" + this.mListener + ", adListener=" + this.mAdListener + "\n, hideBack=" + this.mHideBack + ", hideTitle=" + this.mHideTopInfo + ", hideMore=" + this.mHideMore + ", hideBottomInfo=" + this.mHideBottomInfo + ", infiniteScrollEnabled=" + this.mInfiniteScrollEnabled + ", scriptTipsTopMargin=" + this.mScriptTipsTopMargin + ", icpTipsBottomMargin=" + this.mIcpTipsBottomMargin + ", bottomOffset=" + this.mBottomOffset + ", hideCellularToast=" + this.mHideCellularToast + ", closeListener=" + this.mCloseListener + '}';
    }
}
