package com.sigmob.sdk.videoAd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private String a;
    private String b;
    private String c;
    private String title;

    public c(String title, String context, String cancel, String close) {
        this.title = title;
        this.a = context;
        this.b = cancel;
        this.c = close;
    }

    public String a() {
        return this.title;
    }

    public void a(String title) {
        this.title = title;
    }

    public String b() {
        return this.a;
    }

    public void b(String context) {
        this.a = context;
    }

    public String c() {
        return this.b;
    }

    public void c(String cancel) {
        this.b = cancel;
    }

    public String d() {
        return this.c;
    }

    public void d(String close) {
        this.c = close;
    }

    public String toString() {
        return "DialogConfig{title='" + this.title + "', context='" + this.a + "', cancelTxt='" + this.b + "', closeTxtl='" + this.c + "'}";
    }
}
