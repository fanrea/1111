package com.bytedance.msdk.api;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private String an;
    private String b;
    private String c;
    private String cb;
    private int d;
    private String e;
    private String gb;
    private int h;
    private String hc;
    private String k;
    private String mk;
    private String mq;
    private String tc;
    private String tt;
    private String u;
    private String uo;
    private final Map<String, String> w = new HashMap();

    public void d(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.w.clear();
        this.w.putAll(map);
    }

    public Map<String, String> d() {
        return this.w;
    }

    public String hc() {
        return this.tc;
    }

    public void d(String str) {
        this.tc = str;
    }

    public String b() {
        return this.mk;
    }

    public void hc(String str) {
        this.mk = str;
    }

    public String c() {
        return this.mq;
    }

    public void b(String str) {
        this.mq = str;
    }

    public String u() {
        return this.uo;
    }

    public void c(String str) {
        this.uo = str;
    }

    public String an() {
        return this.k;
    }

    public void u(String str) {
        this.k = str;
    }

    public String h() {
        return this.e;
    }

    public void an(String str) {
        this.e = str;
    }

    public String gb() {
        return this.cb;
    }

    public void h(String str) {
        this.cb = str;
    }

    public String tt() {
        return this.hc;
    }

    public void gb(String str) {
        this.hc = str;
    }

    public String tc() {
        return this.b;
    }

    public void tt(String str) {
        this.b = str;
    }

    public void d(int i) {
        this.d = i;
    }

    public String mk() {
        return this.c;
    }

    public void tc(String str) {
        this.c = str;
    }

    public String mq() {
        return TextUtils.isEmpty(this.b) ? this.hc : this.b;
    }

    public String uo() {
        return this.an;
    }

    public void mk(String str) {
        this.an = str;
    }

    public String k() {
        return this.u;
    }

    public void mq(String str) {
        this.u = str;
    }

    public int e() {
        return this.h;
    }

    public void hc(int i) {
        this.h = i;
    }

    public String cb() {
        return this.gb;
    }

    public void uo(String str) {
        this.gb = str;
    }

    public String w() {
        return this.tt;
    }

    public void k(String str) {
        this.tt = str;
    }

    public String toString() {
        return "{mSdkNum='" + this.d + "', mSlotId='" + this.c + "', mLevelTag='" + this.u + "', mEcpm=" + this.an + ", mReqBiddingType=" + this.h + "', mRequestId=" + this.tt + ", mSubRitType=" + this.mk + '}';
    }
}
