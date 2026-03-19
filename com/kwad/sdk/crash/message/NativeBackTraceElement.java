package com.kwad.sdk.crash.message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class NativeBackTraceElement extends BackTraceElement {
    private static final long serialVersionUID = 8646793782725084250L;
    public String mBuildId;
    public String mPc;

    public NativeBackTraceElement(String str, int i) {
        super(str, i);
        this.mBuildId = "";
        this.mPc = "";
    }

    public final String getBuildId() {
        return this.mBuildId;
    }

    public final void setBuildId(String str) {
        this.mBuildId = str;
    }

    public final String getPc() {
        return this.mPc;
    }

    public final void setPc(String str) {
        this.mPc = str;
    }
}
