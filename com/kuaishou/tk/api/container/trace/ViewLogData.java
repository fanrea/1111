package com.kuaishou.tk.api.container.trace;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class ViewLogData {
    private long mBeginCreateViewTime;
    private long mBeginRenderTime;
    private long mEndCreateViewTime;
    private long mEndRenderTime;
    private String mViewKey = "";
    private boolean mIsFirstTimeCreateView = false;

    public String getViewKey() {
        return this.mViewKey;
    }

    public void setViewKey(String str) {
        this.mViewKey = str;
    }

    public void setIsFirstTimeCreateView(boolean z) {
        this.mIsFirstTimeCreateView = z;
    }

    public boolean getIsFirstTimeCreateView() {
        return this.mIsFirstTimeCreateView;
    }

    public long getBeginRenderTime() {
        return this.mBeginRenderTime;
    }

    public void setBeginRenderTime() {
        this.mBeginRenderTime = System.currentTimeMillis();
    }

    public long getEndRenderTime() {
        return this.mEndRenderTime;
    }

    public void setEndRenderTime() {
        this.mEndRenderTime = System.currentTimeMillis();
    }

    public long getBeginCreateViewTime() {
        return this.mBeginCreateViewTime;
    }

    public void setBeginCreateViewTime() {
        this.mBeginCreateViewTime = System.currentTimeMillis();
    }

    public long getEndCreateViewTime() {
        return this.mEndCreateViewTime;
    }

    public void setEndCreateViewTime() {
        this.mEndCreateViewTime = System.currentTimeMillis();
    }
}
