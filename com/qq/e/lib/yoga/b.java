package com.qq.e.lib.yoga;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            q();
        } finally {
            super.finalize();
        }
    }

    public void q() {
        long j = this.d;
        if (j != 0) {
            this.d = 0L;
            YogaNative.jni_YGNodeDeallocateJNI(j);
        }
    }
}
