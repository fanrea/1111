package com.bytedance.adsdk.lottie.model;

import android.graphics.PointF;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public float an;
    public float b;
    public d c;
    public String d;
    public int gb;
    public float h;
    public String hc;
    public boolean mk;
    public PointF mq;
    public float tc;
    public int tt;
    public int u;
    public PointF uo;

    public enum d {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public hc(String str, String str2, float f, d dVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        d(str, str2, f, dVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public hc() {
    }

    public void d(String str, String str2, float f, d dVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.d = str;
        this.hc = str2;
        this.b = f;
        this.c = dVar;
        this.u = i;
        this.an = f2;
        this.h = f3;
        this.gb = i2;
        this.tt = i3;
        this.tc = f4;
        this.mk = z;
        this.mq = pointF;
        this.uo = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.d.hashCode() * 31) + this.hc.hashCode()) * 31) + this.b)) * 31) + this.c.ordinal()) * 31) + this.u;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.an);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.gb;
    }
}
