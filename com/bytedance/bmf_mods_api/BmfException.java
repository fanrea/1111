package com.bytedance.bmf_mods_api;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BmfException extends Exception {
    public static final int INPUT_PARAM_INVALID = -100020;
    public static final int NOT_INITIALIZED = -100010;
    private int mCode;

    public BmfException() {
        this.mCode = -1;
    }

    public BmfException(String str) {
        super(str);
        this.mCode = -1;
    }

    public BmfException(int i, String str) {
        super(str);
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
