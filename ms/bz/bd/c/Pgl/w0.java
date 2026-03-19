package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class w0 {

    final class pblb extends pbly.pgla {
        pblb() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            a1.d(pblv.d().hc());
            return null;
        }
    }

    final class pblc extends pbly.pgla {
        pblc() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return a1.d(pblv.d().hc()).d();
        }
    }

    final class pbld extends pbly.pgla {
        pbld() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return j1.hc(pblv.d().hc());
        }
    }

    final class pble extends pbly.pgla {
        pble() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return i1.d(pblv.d().hc());
        }
    }

    final class pblf extends pbly.pgla {
        pblf() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return Config.EVENT_NEXT_PAGENAME;
        }
    }

    final class pblg extends pbly.pgla {
        pblg() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return Config.EVENT_NEXT_PAGENAME;
        }
    }

    final class pblh extends pbly.pgla {
        pblh() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return h1.d(pblv.d().hc());
        }
    }

    final class pbli extends pbly.pgla {
        pbli() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return h1.hc(pblv.d().hc());
        }
    }

    final class pblj extends pbly.pgla {
        pblj() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblh.d();
        }
    }

    final class pblk extends pbly.pgla {
        pblk() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return k1.d(pblv.d().hc());
        }
    }

    final class pbll extends pbly.pgla {
        pbll() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sbAppend;
            String strTrim = "0";
            String strTrim2 = ILogConst.CACHE_PLAY_REASON_NULL;
            try {
                WifiInfo connectionInfo = ((WifiManager) pblv.d().hc().getSystemService(com.baidu.mobads.container.util.e.a.a)).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pbla.d("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pbla.d("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pbla.d("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strD = q1.d(str3);
                        String strD2 = q1.d(str2);
                        String strD3 = q1.d(string);
                        StringBuilder sbAppend2 = new StringBuilder().append((strD2 == null || strD2.length() <= 0) ? ILogConst.CACHE_PLAY_REASON_NULL : strD2.trim()).append("[<!>]");
                        if (strD != null && strD.length() > 0) {
                            strTrim2 = strD.trim();
                        }
                        sbAppend = sbAppend2.append(strTrim2).append("[<!>]");
                        if (strD3 != null && strD3.length() > 0) {
                            strTrim = strD3.trim();
                        }
                    } catch (Throwable unused) {
                        String strD4 = q1.d(str3);
                        String strD5 = q1.d(str2);
                        String strD6 = q1.d(null);
                        StringBuilder sbAppend3 = new StringBuilder().append((strD5 == null || strD5.length() <= 0) ? ILogConst.CACHE_PLAY_REASON_NULL : strD5.trim()).append("[<!>]");
                        if (strD4 != null && strD4.length() > 0) {
                            strTrim2 = strD4.trim();
                        }
                        sbAppend = sbAppend3.append(strTrim2).append("[<!>]");
                        if (strD6 != null && strD6.length() > 0) {
                            strTrim = strD6.trim();
                        }
                        return sbAppend.append(strTrim).append("[<!>]").toString().trim();
                    }
                } catch (Throwable unused2) {
                    str3 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
                str3 = null;
            }
            return sbAppend.append(strTrim).append("[<!>]").toString().trim();
        }
    }

    final class pblm extends pbly.pgla {
        pblm() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return j1.d(pblv.d().hc());
        }
    }

    final class pgla extends pbly.pgla {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pbly.pgla
        public final Object d(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void d() {
        pbly.d(268435457, new pble());
        pbly.d(268435458, new pblf());
        pbly.d(268435459, new pblg());
        pbly.d(268435460, new pblh());
        pbly.d(268435461, new pbli());
        pbly.d(268435462, new pblj());
        pbly.d(268435463, new pblk());
        pbly.d(268435464, new pbll());
        pbly.d(268435465, new pblm());
        pbly.d(268435466, new pgla());
        pbly.d(268435467, new pblb());
        pbly.d(268435468, new pblc());
        pbly.d(268435469, new pbld());
    }
}
