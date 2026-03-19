package ms.bz.bd.c.Pgl;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Method;
import java.util.List;
import ms.bz.bd.c.Pgl.pbly;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
final class f0 extends pbly.pgla {
    f0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object d(long j, String str, Object obj) throws Throwable {
        Context contextHc = pblv.d().hc();
        JSONArray jSONArray = new JSONArray();
        AccessibilityManager accessibilityManager = (AccessibilityManager) contextHc.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "46f67d", new byte[]{36, com.sigmob.sdk.archives.tar.e.O, 22, 71, 27, 96, 62, 21, 62, 106, 44, 32, 12}));
        if (accessibilityManager != null) {
            List<AccessibilityServiceInfo> list = null;
            try {
                Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6daa2", new byte[]{117, com.sigmob.sdk.archives.tar.e.I, 3, 60, 80, com.sigmob.sdk.archives.tar.e.N, 116, 22, 57, 61, 119, com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.N, 22, 93, 32, 115, 4, 60, com.sigmob.sdk.archives.tar.e.f789K, 123, 56, 30, 1, 71, 22, 101, 5, 35, 56, 113, com.sigmob.sdk.archives.tar.e.I, 59, 28, 77, com.sigmob.sdk.archives.tar.e.I}), new Class[0]);
                if (declaredMethod != null) {
                    list = (List) declaredMethod.invoke(accessibilityManager, new Object[0]);
                }
            } catch (Throwable unused) {
            }
            if (list == null || list.size() == 0) {
                return jSONArray.toString();
            }
            for (AccessibilityServiceInfo accessibilityServiceInfo : list) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3ac60", new byte[]{112, 39}), accessibilityServiceInfo.eventTypes);
                    jSONObject.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6eb54c", new byte[]{46, 99}), accessibilityServiceInfo.getId());
                    jSONArray.put(jSONObject);
                } catch (Throwable unused2) {
                }
            }
        }
        return jSONArray.toString();
    }
}
