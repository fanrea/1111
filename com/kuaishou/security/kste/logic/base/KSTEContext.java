package com.kuaishou.security.kste.logic.base;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSTEContext {
    public static boolean bInterpLoadStatus = false;
    public static boolean bNeedUpdateBitcode = true;

    public enum Mode {
        SYNC(0),
        ASYNC(1);

        private final int value;

        Mode(int i) {
            this.value = i;
        }

        public final int getIntValue() {
            return this.value;
        }
    }
}
