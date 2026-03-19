package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.o0O0O;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManager;
import com.volcengine.mobsecBiz.metasec.ml.PglMSManagerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import okio.Utf8;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class n0 {
    private static final ConcurrentHashMap b = new ConcurrentHashMap();
    private static CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    public static final /* synthetic */ int d = 0;
    private static volatile boolean hc = false;

    public interface pgla {
        Map<String, String> getFeatureHash(String str, byte[] bArr);

        String getToken();

        void report(String str);

        void setBDDeviceID(String str);

        void setCollectMode(int i);

        void setDeviceID(String str);

        void setInstallID(String str);
    }

    protected n0() {
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "03a485", new byte[]{46, Utf8.REPLACEMENT_BYTE, 32, 69, 23, 45, 33, 6, 22, 109, 47, 56, 1, 72, 71, com.sigmob.sdk.archives.tar.e.N, 60, 25, com.sigmob.sdk.archives.tar.e.M, 106, 97, 124, 95, 13, 71});
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((PglITokenObserver) it.next()).onTokenLoaded(str);
        }
    }

    public static synchronized void d(String str) {
        if (pblv.d().hc() != null) {
            pblu pbluVar = (pblu) b.get(str);
            if (hc(str) != null && pbluVar != null) {
                c.addAll(pbluVar.p);
                PglMSManager pglMSManager = PglMSManagerUtils.get(str);
                if (pglMSManager != null) {
                    pglMSManager.report((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3856e8", new byte[]{29, com.sigmob.sdk.archives.tar.e.f789K, 72, 75, 78, 16, 34, 28, 116, 105, com.sigmob.sdk.archives.tar.e.H, 46}));
                }
            }
        }
    }

    public static synchronized m0 hc(String str) {
        if (str == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "45d9c4", new byte[]{36, 39, 7, 100, com.sigmob.sdk.archives.tar.e.R, 99, 58, 1, 38, 125, 101, com.sigmob.sdk.archives.tar.e.M, 18, 13, 79, 38, 35}));
        }
        if (!hc) {
            return null;
        }
        int i = pbly.d;
        Object objA = com.volcengine.mobsecBiz.matrix.pgla.a(67108866, 0, 0L, str, (Object) null);
        if (objA == null) {
            return null;
        }
        pblu pbluVar = (pblu) b.get(str);
        if (pbluVar == null) {
            return null;
        }
        return new m0(pbluVar, pblv.d().hc(), ((Long) objA).longValue());
    }

    public static synchronized boolean d(Context context, pblu pbluVar) {
        if (context == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "074801", new byte[]{34, 58, 73, com.sigmob.sdk.archives.tar.e.S, 10, 62, 39, 86, 102, com.sigmob.sdk.archives.tar.e.T, com.sigmob.sdk.archives.tar.e.L, 57, 67, 12, 1, 41, 39, 86, com.sigmob.sdk.archives.tar.e.T, 109, 97, 59, 82, 64, 3}));
        }
        if (pbluVar == null) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1649cb", new byte[]{35, 59, 73, 75, 85, 114, 114, 20, 106, 124, 44, com.sigmob.sdk.archives.tar.e.H, 7, 67, com.sigmob.sdk.archives.tar.e.Q, 97, 114, 21, 96, 41, 46, 33, 75, 65}));
        }
        String str = pbluVar.a;
        String str2 = (str == null || str.length() <= 0) ? pbluVar.g : pbluVar.a;
        if (str2 == null || str2.length() <= 0) {
            throw new NullPointerException((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1497c9", new byte[]{33, 38, 90, 106, com.sigmob.sdk.archives.tar.e.R, 110, Utf8.REPLACEMENT_BYTE, 0, 123, 115, 96, com.sigmob.sdk.archives.tar.e.L, 79, 3, 79, 43, 38}));
        }
        if (!hc) {
            synchronized (n0.class) {
                if (!hc) {
                    d(context);
                    hc = true;
                }
            }
        }
        if (b.containsKey(str2)) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(pblu.a(pbluVar.a));
        jSONArray.put(pblu.a(pbluVar.h));
        jSONArray.put(pblu.a(pbluVar.g));
        jSONArray.put(pblu.a(pbluVar.i));
        jSONArray.put(pblu.a(n1.d()));
        jSONArray.put(pblu.a(pbluVar.b));
        jSONArray.put(pblu.a(pbluVar.c));
        jSONArray.put(pblu.a(pbluVar.d));
        jSONArray.put(pblu.a(pbluVar.e));
        jSONArray.put(pblu.a(pbluVar.f));
        jSONArray.put(String.valueOf(pbluVar.k));
        jSONArray.put(String.valueOf(pbluVar.l));
        jSONArray.put(String.valueOf(pbluVar.m));
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, String> entry : pbluVar.n.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                jSONArray2.put(pblu.a(entry.getKey()));
                jSONArray2.put(pblu.a(entry.getValue()));
            }
        }
        jSONArray.put(jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (Map.Entry entry2 : pbluVar.o.entrySet()) {
            if (!TextUtils.isEmpty((CharSequence) entry2.getKey())) {
                if (((String) entry2.getKey()).equals("kOA1") && TextUtils.equals((CharSequence) entry2.getValue(), "1")) {
                    a1.d = false;
                    a1.hc = pbluVar.j;
                }
                jSONArray3.put(pblu.a(entry2.getKey()));
                jSONArray3.put(pblu.a(entry2.getValue()));
            }
        }
        jSONArray.put(jSONArray3);
        String string = jSONArray.toString();
        int i = pbly.d;
        if (!((Boolean) com.volcengine.mobsecBiz.matrix.pgla.a(67108865, 0, 0L, string, (Object) null)).booleanValue()) {
            return false;
        }
        b.put(str2, pbluVar);
        return true;
    }

    static synchronized void d(Context context) {
        if (!hc) {
            Context applicationContext = context.getApplicationContext();
            pblv.d().d(applicationContext);
            e1.d(applicationContext);
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a3d8a5", new byte[]{62, 60, 4});
            pbly.d(o0O0O.Ooo.f416O8, new j());
            pbly.d(16777217, new u());
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "955618", new byte[]{102, 58, 66});
            pbly.d(o0O0O.Ooo.f418o0o0, new f0());
            pbly.d(o0O0O.Ooo.Oo0, new g0());
            pbly.d(o0O0O.Ooo.f415O, new h0());
            pbly.d(o0O0O.Ooo.f420o0O0O, new i0());
            pbly.d(o0O0O.Ooo.f421, new j0());
            pbly.d(o0O0O.Ooo.f41400oOOo, new k0());
            pbly.d(16777226, new l0());
            pbly.d(16777228, new pblz());
            pbly.d(InputDeviceCompat.SOURCE_JOYSTICK, new a());
            pbly.d(16777233, new b());
            pbly.d(16777235, new c());
            pbly.d(16777238, new d());
            pbly.d(16777239, new e());
            pbly.d(16777241, new f());
            pbly.d(16777242, new g());
            pbly.d(16777243, new h());
            pbly.d(16777244, new i());
            pbly.d(16777245, new k());
            pbly.d(16777246, new l());
            pbly.d(16777247, new m());
            pbly.d(16777248, new n());
            pbly.d(16777249, new o());
            pbly.d(16777250, new p());
            pbly.d(16777251, new q());
            pbly.d(16777240, new r());
            pbly.d(16777252, new s());
            pbly.d(16777253, new t());
            pbly.d(16777254, new v());
            pbly.d(16777255, new w());
            pbly.d(16777256, new x());
            pbly.d(16777257, new y());
            pbly.d(16777258, new z());
            pbly.d(16777259, new a0());
            pbly.d(16777261, new b0());
            pbly.d(16777266, new c0());
            pbly.d(16777272, new d0());
            pbly.d(33554435, new e0());
            v0.d();
            w0.d();
            com.volcengine.mobsecBiz.matrix.pgla.a(o0O0O.Ooo.f418o0o0, 0, 0L, (String) null, applicationContext);
            hc = true;
        }
    }
}
