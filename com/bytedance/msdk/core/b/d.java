package com.bytedance.msdk.core.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private int an;
    private double b;
    private double c;
    private double d;
    private double hc;
    private String mk;
    private String tc;
    private String u;
    private int h = 0;
    private int gb = 0;
    private int tt = 0;

    public d(double d, double d2, double d3, double d4, int i, String str) {
        this.d = d;
        this.hc = d2;
        this.b = d3;
        this.c = d4;
        this.u = str;
        this.an = i;
    }

    public String toString() {
        return "adnName = " + this.tc + " adnRit = " + this.mk + ", send = " + this.h + ", fill = " + this.gb + ", show = " + this.tt + " localSsr = " + this.d + ", serviceSsr = " + this.b + ", localSrr = " + this.hc + ", serviceSrr = " + this.c + ", opt = " + this.u + ", condition = " + this.an + ", compareBehaviorSsr = " + c() + ", compareBehaviorSrr = " + u() + ", checkBehaviorRule = " + d();
    }

    public boolean d() {
        return c();
    }

    private boolean c() {
        return d(this.d, this.b);
    }

    private boolean u() {
        return d(this.hc, this.c);
    }

    private boolean d(double d, double d2) {
        String str = this.u;
        str.hashCode();
        switch (str) {
            case "1":
                if (d > d2) {
                }
                break;
            case "2":
                if (d < d2) {
                }
                break;
            case "3":
                if (d >= d2) {
                }
                break;
            case "4":
                if (d <= d2) {
                }
                break;
            case "5":
                if (d == d2) {
                }
                break;
        }
        return true;
    }

    public double hc() {
        return this.d;
    }

    public double b() {
        return this.hc;
    }

    public void d(int i) {
        this.h = i;
    }

    public void hc(int i) {
        this.gb = i;
    }

    public void b(int i) {
        this.tt = i;
    }

    public void d(String str) {
        this.tc = str;
    }

    public void hc(String str) {
        this.mk = str;
    }
}
