package com.android.gdt.qone.shell.sdkinfo;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum UserInfoType {
    TYPE_APP_KEY(0),
    TYPE_NET_WORK_TYPE(1),
    TYPE_SDK_VERSION(2),
    TYPE_APP_VERSION(3),
    TYPE_CHANNEL_ID(4),
    TYPE_USER_ID_PARAM(5),
    TYPE_OS_VERSION(6),
    TYPE_Q16(7),
    TYPE_Q36(8),
    TYPE_MODEL(9),
    TYPE_PRE_AUDIT_STATE(10),
    TYPE_OZ(11),
    MAX_TYPE_SIZE(12);

    private int value;

    UserInfoType(int i) {
        this.value = i;
    }

    public final int a() {
        return this.value;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return String.valueOf(this.value);
    }
}
