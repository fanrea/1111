package com.tachikoma.lottie.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class DocumentData {
    public final String KE;
    public final String KF;
    public final double KG;
    public final Justification KH;
    public final int KI;
    public final double KJ;
    public final double KK;
    public final double KL;
    public final boolean KM;
    public final int color;
    public final int strokeColor;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, double d, Justification justification, int i, double d2, double d3, int i2, int i3, double d4, boolean z) {
        this.KE = str;
        this.KF = str2;
        this.KG = d;
        this.KH = justification;
        this.KI = i;
        this.KJ = d2;
        this.KK = d3;
        this.color = i2;
        this.strokeColor = i3;
        this.KL = d4;
        this.KM = z;
    }

    public final int hashCode() {
        double dHashCode = ((this.KE.hashCode() * 31) + this.KF.hashCode()) * 31;
        double d = this.KG;
        Double.isNaN(dHashCode);
        int iOrdinal = (((((int) (dHashCode + d)) * 31) + this.KH.ordinal()) * 31) + this.KI;
        long jDoubleToLongBits = Double.doubleToLongBits(this.KJ);
        return (((iOrdinal * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.color;
    }
}
