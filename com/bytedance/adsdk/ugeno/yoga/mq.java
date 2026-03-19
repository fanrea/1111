package com.bytedance.adsdk.ugeno.yoga;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq extends YogaNodeJNIBase {
    protected void finalize() throws Throwable {
        try {
            uo();
        } finally {
            super.finalize();
        }
    }

    public void uo() {
        if (this.d != 0) {
            long j = this.d;
            this.d = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
