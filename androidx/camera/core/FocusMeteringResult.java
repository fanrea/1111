package androidx.camera.core;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class FocusMeteringResult {
    private boolean mIsFocusSuccessful;

    public static FocusMeteringResult emptyInstance() {
        return new FocusMeteringResult(false);
    }

    public static FocusMeteringResult create(boolean z) {
        return new FocusMeteringResult(z);
    }

    private FocusMeteringResult(boolean z) {
        this.mIsFocusSuccessful = z;
    }

    public boolean isFocusSuccessful() {
        return this.mIsFocusSuccessful;
    }
}
