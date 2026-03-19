package com.android.gdt.qone.foundation.net.protocol;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum CMD {
    REGISTER(1, 18),
    AUDIT(2, 0),
    APM(3, 13),
    QM_SETTING(4, 1),
    AUDIT_SETTING(5, 0),
    TASK_SETTING(6, 0),
    BEAT(7, 5),
    PWD_CHANGE(8, 0),
    H5_BIND(11, 8),
    GET_OID(13, 3);

    private final int cmd;
    private final int maxBodySize;

    CMD(int i, int i2) {
        this.cmd = i;
        this.maxBodySize = i2;
    }

    public final int a() {
        return this.maxBodySize;
    }

    public final int b() {
        return this.cmd;
    }
}
