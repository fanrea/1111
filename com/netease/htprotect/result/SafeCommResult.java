package com.netease.htprotect.result;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class SafeCommResult {
    public static final int SC_ALG_ERROR = -7;
    public static final int SC_BUFF_MALLOC_ERROR = -98;
    public static final int SC_CLOSED = -202;
    public static final int SC_CODE_OK = 0;
    public static final int SC_DATA_DECRYPT_ERROR = -6;
    public static final int SC_DATA_TAMPERED = -5;
    public static final int SC_FILE_IS_BROKEN = -2;
    public static final int SC_FILE_NOTEXIST = -1;
    public static final int SC_INSIDE_ERROR = -99;
    public static final int SC_NOT_INIT = -201;
    public static final int SC_PARAM_ERROR = -4;
    public static final int SC_PROTOCOL_VERSION_ERROR = -3;
    public static final int SC_TIMEOUT = -8;
    public byte[] decResult;
    public byte[] encBytes;
    public String encResult;
    public int ret;

    public SafeCommResult() {
        this.ret = 0;
        this.decResult = null;
    }

    public SafeCommResult(int i) {
        this.ret = 0;
        this.decResult = new byte[i];
    }

    public SafeCommResult(int i, boolean z) {
        this.ret = 0;
        this.decResult = null;
        if (z) {
            return;
        }
        this.encBytes = new byte[i];
    }
}
