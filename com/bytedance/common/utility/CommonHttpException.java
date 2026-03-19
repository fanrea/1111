package com.bytedance.common.utility;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class CommonHttpException extends Exception {
    private int mResponseCode;

    public CommonHttpException(int i, String str) {
        super(str);
        this.mResponseCode = i;
    }

    public int getResponseCode() {
        return this.mResponseCode;
    }
}
