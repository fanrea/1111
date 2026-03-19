package com.bytedance.sdk.component.hc.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e {
    public d an;
    public tc b;
    public String c;
    private String d;
    private String hc;
    public byte[] u;

    public enum d {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public e() {
    }

    public String d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public e(tc tcVar, String str, d dVar) {
        this.b = tcVar;
        this.c = str;
        this.an = dVar;
    }

    public e(tc tcVar, byte[] bArr, String str, String str2, d dVar) {
        this.b = tcVar;
        this.u = bArr;
        this.hc = str;
        this.d = str2;
        this.an = dVar;
    }

    public e(tc tcVar, byte[] bArr, d dVar) {
        this.b = tcVar;
        this.u = bArr;
        this.an = dVar;
    }

    public static e d(tc tcVar, String str) {
        return new e(tcVar, str, d.STRING_TYPE);
    }

    public static e d(tc tcVar, byte[] bArr) {
        return new e(tcVar, bArr, d.BYTE_ARRAY_TYPE);
    }

    public static e d(tc tcVar, byte[] bArr, String str, String str2) {
        return new e(tcVar, bArr, str, str2, d.FILE_TYPE);
    }
}
