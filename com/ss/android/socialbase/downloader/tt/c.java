package com.ss.android.socialbase.downloader.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class c {
    private double b = -1.0d;
    private int c;
    private final double d;
    private final int hc;

    public c(double d) {
        this.d = d;
        this.hc = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void d(double d) {
        double d2 = 1.0d - this.d;
        int i = this.c;
        if (i > this.hc) {
            this.b = Math.exp((d2 * Math.log(this.b)) + (this.d * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * i) / (i + 1.0d);
            this.b = Math.exp((d3 * Math.log(this.b)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.b = d;
        }
        this.c++;
    }

    public double d() {
        return this.b;
    }
}
