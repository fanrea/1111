package com.kuaishou.security.kste.export;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSTEResult {
    private byte[] result;
    private Code retCode;

    public enum Code {
        INVOKE_OK(0),
        INVOKE_FAIL(1),
        INVOKE_TIMEOUT(2),
        INVOKE_OFFLINE(3),
        INVOKE_PARAM_INVALID(4);

        private final int value;

        Code(int i) {
            this.value = i;
        }
    }

    public KSTEResult(Code code, byte[] bArr) {
        this.retCode = code;
        this.result = bArr;
    }

    public byte[] getResult() {
        return this.result;
    }

    public Code getRetCode() {
        return this.retCode;
    }

    public void setResult(byte[] bArr) {
        this.result = bArr;
    }

    public void setRetCode(Code code) {
        this.retCode = code;
    }
}
