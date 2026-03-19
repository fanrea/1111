package ms.bz.bd.c.Pgl;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblv {
    private static final pblv d = new pblv();
    private Context hc;

    public static pblv d() {
        return d;
    }

    public final void d(Context context) {
        this.hc = context != null ? context.getApplicationContext() : null;
    }

    public final Context hc() {
        return this.hc;
    }
}
