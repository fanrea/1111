package com.qq.e.comm.constants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);

    private int a;

    LoginType(int i) {
        this.a = i;
        ordinal();
    }

    public int getValue() {
        return this.a;
    }
}
