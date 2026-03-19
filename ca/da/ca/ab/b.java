package ca.da.ca.ab;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import ca.da.ca.ja.r;
import com.apm.applog.AppLog;
import com.baidu.mobstat.forbes.Config;
import com.pandora.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserProfileHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static final String[] a = {"aid", Constants.APPLog.APP_REGION, "os", "package", "app_version", "sdk_version", "os_version", "device_model", "resolution", "language", "timezone", "access", "display_name", "channel", "carrier", "app_language", "app_region", "tz_name", "tz_offset", "install_id", "openudid", "mcc_mnc", Config.ROM, "manifest_version_code", "device_manufacturer", "clientudid", "sig_hash", "display_density", "os_api", "update_version_code", "density_dpi", "version_code", "sim_serial_number", "release_build", "udid", "cpu_abi", "google_aid", "is_harmony_os"};
    public static final String[] b = {"setOnce", "synchronize"};
    public static final int[] c = {-1, -1};
    public static final long[] d = {-1, -1};

    public static void a(ca.da.ca.da.b bVar, int i, JSONObject jSONObject, ca.da.ca.ab.a aVar, Handler handler, boolean z) {
        boolean z2;
        JSONObject jSONObject2;
        if (z) {
            z2 = true;
        } else {
            boolean z3 = System.currentTimeMillis() - d[i] > 60000;
            z2 = (jSONObject == null || c[i] == jSONObject.toString().hashCode()) ? false : true;
            r.a("exec " + i + ", " + z3 + ", " + z2, (Throwable) null);
            if (!z3) {
                if (aVar != null) {
                    ((a) aVar).a(4);
                    return;
                }
                return;
            }
        }
        if (!z2) {
            if (aVar != null) {
                ((a) aVar).a();
                return;
            }
            return;
        }
        Context context = AppLog.getContext();
        String strOptString = bVar.f.d.optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
        String strA = bVar.f.a();
        String profileUri = bVar.c().getProfileUri();
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strA) || TextUtils.isEmpty(profileUri)) {
            if (aVar != null) {
                ((a) aVar).a(3);
                return;
            }
            return;
        }
        String str = profileUri + String.format("/service/api/v3/userprofile/%s/%s", strA, b[i]);
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObjectD = bVar.f.d();
            try {
                jSONObject2 = new JSONObject(jSONObjectD, a);
                jSONObject2.put("sdk_version", jSONObjectD.opt("sdk_version").toString());
                jSONObject2.put("tz_offset", jSONObjectD.opt("tz_offset").toString());
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject2 = new JSONObject();
            }
            jSONObject3.put("header", jSONObject2);
            jSONObject3.put("profile", jSONObject);
            JSONObject jSONObjectD2 = bVar.f.d();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(com.baidu.mobads.upgrade.remote.gray.c.l, jSONObjectD2.opt(com.baidu.mobads.upgrade.remote.gray.c.l));
            jSONObject4.put("user_id", jSONObjectD2.opt("user_id"));
            jSONObject4.put("ssid", jSONObjectD2.opt("ssid"));
            jSONObject3.put("user", jSONObject4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e eVar = new e(str, strA, jSONObject3.toString(), new a(i, jSONObject, aVar), context);
        if (handler != null) {
            handler.post(eVar);
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r.a((Throwable) null);
        }
        eVar.run();
    }

    /* compiled from: UserProfileHelper.java */
    public static class a implements ca.da.ca.ab.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ ca.da.ca.ab.a c;

        public a(int i, JSONObject jSONObject, ca.da.ca.ab.a aVar) {
            this.a = i;
            this.b = jSONObject;
            this.c = aVar;
        }

        public void a() {
            b.c[this.a] = this.b.toString().hashCode();
            b.d[this.a] = System.currentTimeMillis();
            ((a) this.c).a();
        }

        public void a(int i) {
            ((a) this.c).a(i);
        }
    }
}
