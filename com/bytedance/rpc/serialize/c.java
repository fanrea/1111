package com.bytedance.rpc.serialize;

/* compiled from: ByteType.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private String a;
    private String b;
    private String c;
    private byte[] d;

    public c(byte[] bArr, String str) {
        this(bArr, str, null);
    }

    public c(byte[] bArr, String str, String str2) {
        this(bArr, str, str2, null);
    }

    public c(byte[] bArr, String str, String str2, String str3) {
        this.d = bArr == null ? com.bytedance.sdk.djx.proguard3.c.d.c : bArr;
        this.b = str == null ? "" : str;
        this.a = str2 == null ? "" : str2;
        this.c = str3 == null ? "" : str3;
    }

    public byte[] a() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.d.length;
    }
}
