package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.HashMap;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class t0 extends pbly.pgla {
    t0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(long j, String str, Object obj) throws Throwable {
        String string;
        Context contextHc = pblv.d().hc();
        ApplicationInfo applicationInfo = contextHc.getPackageManager().getApplicationInfo(contextHc.getPackageName(), 0);
        String str2 = applicationInfo.sourceDir;
        if (str2 == null) {
            str2 = applicationInfo.publicSourceDir;
        }
        HashMap mapD = pblc.d(str2);
        String string2 = "";
        String str3 = (mapD == null || !mapD.containsKey(1903654775)) ? "" : (String) mapD.get(1903654775);
        if (str3 != null && str3.length() > 0) {
            JSONObject jSONObject = new JSONObject(str3);
            try {
                string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "70bbbb", new byte[]{43, com.sigmob.sdk.archives.tar.e.O, 5, 23, 98, 96, 57, 20, 61, com.sigmob.sdk.archives.tar.e.M, 25, com.sigmob.sdk.archives.tar.e.I, 25, 23, com.sigmob.sdk.archives.tar.e.Q, 123, com.sigmob.sdk.archives.tar.e.I, 29}));
            } catch (JSONException unused) {
                string = "";
            }
            StringBuilder sbAppend = new StringBuilder().append(string).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06e739", new byte[]{122}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e412d9", new byte[]{102, com.sigmob.sdk.archives.tar.e.f789K, 78, 67, 90, 61, 99, 42, 98, 119, 125, 58, 70}));
            } catch (JSONException unused2) {
            }
            string2 = sbAppend.append(string2).toString();
        }
        return string2.length() == 0 ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "53d452", new byte[]{10, 62, 25, 69}) : string2;
    }
}
