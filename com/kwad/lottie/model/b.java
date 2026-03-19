package com.kwad.lottie.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public final String bmW;
    public final double bmX;
    final int bmY;
    public final int bmZ;
    final double bna;
    public final double bnb;
    public final double bnc;
    public final boolean bnd;
    public final int color;
    public final int strokeColor;
    public final String text;

    public b(String str, String str2, double d, int i, int i2, double d2, double d3, int i3, int i4, double d4, boolean z) {
        this.text = str;
        this.bmW = str2;
        this.bmX = d;
        this.bmY = i;
        this.bmZ = i2;
        this.bna = d2;
        this.bnb = d3;
        this.color = i3;
        this.strokeColor = i4;
        this.bnc = d4;
        this.bnd = z;
    }

    public final int hashCode() {
        int iHashCode = (((((int) ((((this.text.hashCode() * 31) + this.bmW.hashCode()) * 31) + this.bmX)) * 31) + this.bmY) * 31) + this.bmZ;
        long jDoubleToLongBits = Double.doubleToLongBits(this.bna);
        return (((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
