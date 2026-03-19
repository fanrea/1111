package ca.da.ca.ga;

import ca.da.ca.fa.g;

/* compiled from: CongestionController.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static final long[][] h = {new long[]{120000, 0, 12}, new long[]{120000, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};
    public String a;
    public g b;
    public int c;
    public int d;
    public int e;
    public long f;
    public long g;

    public a(String str, g gVar) {
        this.b = gVar;
        this.a = str;
        this.c = 0;
        if (System.currentTimeMillis() - gVar.e.getLong(ca.ca.ca.ca.a.a(new StringBuilder(), this.a, "downgrade_time"), 0L) < 10800000) {
            this.c = this.b.e.getInt(this.a + "downgrade_index", 0);
        } else {
            this.b.e.edit().remove(this.a + "downgrade_time").remove(this.a + "downgrade_index").apply();
        }
    }

    public final boolean a() {
        return this.b.b.isCongestionControlEnable();
    }
}
