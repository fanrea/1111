package com.kwad.sdk.crash.message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class JavaBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 2317636129771661110L;
    public String mDeclaringClass;
    public boolean mIsCausedBy;
    public boolean mIsNative;
    public boolean mIsTitle;

    public JavaBackTraceElement(String str, int i) {
        super(str, i);
        this.mDeclaringClass = "";
        this.mIsTitle = false;
        this.mIsCausedBy = false;
        this.mIsNative = false;
    }

    public final String getDeclaringClass() {
        return this.mDeclaringClass;
    }

    public final void setDeclaringClass(String str) {
        this.mDeclaringClass = str;
    }

    public final boolean isTitle() {
        return this.mIsTitle;
    }

    public final void setIsTitle(boolean z) {
        this.mIsTitle = z;
    }

    public final boolean isCausedBy() {
        return this.mIsCausedBy;
    }

    public final void setIsCausedBy(boolean z) {
        this.mIsCausedBy = z;
    }

    public final boolean isNative() {
        return this.mIsNative;
    }

    public final void setIsNative(boolean z) {
        this.mIsNative = z;
    }
}
