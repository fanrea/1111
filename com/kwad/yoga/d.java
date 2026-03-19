package com.kwad.yoga;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends YogaNodeJNIBase {
    public d() {
    }

    public d(a aVar) {
        super(aVar);
    }

    protected final void finalize() throws Throwable {
        try {
            jh();
        } finally {
            super.finalize();
        }
    }

    private void jh() {
        if (this.mNativePointer != 0) {
            long j = this.mNativePointer;
            this.mNativePointer = 0L;
            YogaNative.jni_YGNodeFree(j);
        }
    }
}
