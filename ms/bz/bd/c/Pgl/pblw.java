package ms.bz.bd.c.Pgl;

import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class pblw extends pbly.pgla {
    private static pblw d;

    public static class pgla {
        private long d;
        private String hc;

        public final void d(String str) {
            this.hc = str;
            this.d = System.currentTimeMillis();
        }

        public final void d(String str, int i) {
            pblw pblwVarD = pblw.d();
            if (pblwVarD == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.d;
            pblwVarD.d(jCurrentTimeMillis - j, j, this.hc, str, i);
        }

        public final void hc(String str, int i) {
            pblw pblwVarD = pblw.d();
            if (pblwVarD == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.d;
            pblwVarD.hc(jCurrentTimeMillis - j, j, this.hc, str, i);
        }
    }

    public static synchronized pblw d() {
        return d;
    }

    public static synchronized void d(pblw pblwVar) {
        d = pblwVar;
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (i == 131073) {
            if (str == null || !d(str)) {
                return null;
            }
            return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f654b8", new byte[]{com.sigmob.sdk.archives.tar.e.S, 31});
        }
        if (i == 131074) {
            String[] strArr = (String[]) obj;
            if (str != null && strArr != null && strArr.length != 0) {
                d(str, new JSONObject(strArr[0]), new JSONObject(strArr[1]), new JSONObject(strArr[2]));
            }
        }
        return null;
    }

    public abstract void d(long j, long j2, String str, String str2, int i);

    public abstract void d(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    public abstract boolean d(String str);

    public abstract void hc(long j, long j2, String str, String str2, int i);
}
