package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import ms.bz.bd.c.Pgl.pblk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class a1 {
    private static volatile a1 b = null;
    public static volatile boolean d = true;
    public static String hc;
    private pblk c;
    private String u = null;

    final class pgla implements pblk.pblb {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblk.pblb
        public final void d(String str) {
            a1.this.u = str;
        }
    }

    private a1(Context context) {
        try {
            this.c = new pblk(new pgla());
            if (!d || Build.VERSION.SDK_INT > 32) {
                return;
            }
            this.c.d(context);
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b802bc", new byte[]{124, 47, 64});
        }
    }

    public static a1 d(Context context) {
        if (b == null) {
            synchronized (a1.class) {
                if (b == null) {
                    b = new a1(context);
                }
            }
        }
        return b;
    }

    public final String d() {
        String str = hc;
        return str != null ? str : this.u;
    }
}
