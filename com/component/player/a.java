package com.component.player;

import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public String l = "";
    public int m = 0;
    public String n = "";
    public int o = 0;
    public boolean p = false;
    public int q = 0;
    public int r = 0;
    public int s = 0;
    public boolean t = false;
    public int u = 0;

    public void a(String str, int i, int i2) {
        h();
        this.a = System.currentTimeMillis();
        this.n = str;
        this.p = i == 2;
        this.q = i2;
        this.o = i;
    }

    public void a() {
        if (this.b == 0) {
            this.b = System.currentTimeMillis();
        }
    }

    void b() {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
    }

    void c() {
        this.d = System.currentTimeMillis();
        this.u++;
    }

    void d() {
        this.e = System.currentTimeMillis();
    }

    void a(int i) {
        if (this.f == 0) {
            this.f = System.currentTimeMillis();
        }
        this.s = i;
    }

    void e() {
        this.g = System.currentTimeMillis();
    }

    void b(int i) {
        this.h = System.currentTimeMillis();
        this.r = i;
    }

    void f() {
        this.i = System.currentTimeMillis();
    }

    void c(int i) {
        this.j = System.currentTimeMillis();
        this.r = i;
    }

    void a(String str) {
        this.k = System.currentTimeMillis();
        this.l = str;
    }

    public void a(int i, float f) {
        this.r = i;
    }

    public void a(boolean z) {
        this.t = z;
    }

    public HashMap<String, String> g() {
        HashMap<String, String> map = new HashMap<>();
        map.put("ca_type", "" + this.o);
        if (this.b > 0) {
            map.put("p_time", "" + (this.b - this.a));
        }
        if (this.f > 0) {
            map.put("r_time", "" + (this.f - this.c));
        }
        map.put("v_dur", "" + (this.s / 1000));
        map.put("v_pos", "" + (this.r / 1000));
        if (this.k > 0) {
            map.put("err_msg", this.l);
        }
        map.put("buf_cnt", "" + this.u);
        map.put("scene", "" + this.q);
        return map;
    }

    public void h() {
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = "";
        this.m = 0;
        this.r = 0;
        this.s = 0;
        this.t = false;
        this.u = 0;
        this.p = false;
        this.o = 0;
        this.b = 0L;
        this.a = 0L;
    }
}
