package com.bytedance.msdk.api.c;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq {
    private String[] an;
    private boolean b;
    private boolean c;
    private boolean d;
    private Map<String, String> gb;
    private String h;
    private int hc;
    private String tt;
    private int[] u;

    private mq(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
        this.u = dVar.u;
        this.an = dVar.an;
        this.h = dVar.h;
        this.gb = dVar.gb;
        this.tt = dVar.tt;
    }

    public static class d {
        private boolean d = false;
        private int hc = 0;
        private boolean b = true;
        private boolean c = false;
        private int[] u = {4, 3, 5};
        private String[] an = new String[0];
        private String h = "";
        private final Map<String, String> gb = new HashMap();
        private String tt = "";

        public d d(boolean z) {
            this.d = z;
            return this;
        }

        public d d(int i) {
            this.hc = i;
            return this;
        }

        public d hc(boolean z) {
            this.b = z;
            return this;
        }

        public d d(int... iArr) {
            this.u = iArr;
            return this;
        }

        public d d(String str) {
            this.h = str;
            return this;
        }

        public d d(Map<String, String> map) {
            this.gb.putAll(map);
            return this;
        }

        public d hc(String str) {
            this.tt = str;
            return this;
        }

        public mq d() {
            return new mq(this);
        }
    }

    public boolean d() {
        return this.d;
    }

    public int hc() {
        return this.hc;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public int[] u() {
        return this.u;
    }

    public String[] an() {
        return this.an;
    }

    public String h() {
        return this.h;
    }

    public Map<String, String> gb() {
        return this.gb;
    }

    public String tt() {
        return this.tt;
    }
}
