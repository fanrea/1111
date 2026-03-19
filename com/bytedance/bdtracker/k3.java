package com.bytedance.bdtracker;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.profile.UserProfileCallback;
import com.pandora.common.Constants;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class k3 {
    public static final String[] a = {"aid", Constants.APPLog.APP_REGION, "os", "package", "app_version", "sdk_version", "os_version", "device_model", "resolution", "language", "timezone", "access", "display_name", "channel", "carrier", "app_language", "app_region", "tz_name", "tz_offset", "install_id", "openudid", "mcc_mnc", Config.ROM, "manifest_version_code", "device_manufacturer", "clientudid", "sig_hash", "display_density", "os_api", "update_version_code", "density_dpi", "version_code", "sim_serial_number", "release_build", "udid", "cpu_abi", "google_aid"};
    public static final String[] b = {"setOnce", "synchronize"};
    public static final int[] c = {-1, -1};
    public static final long[] d = {-1, -1};

    public static class a implements UserProfileCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ UserProfileCallback c;

        public a(int i, JSONObject jSONObject, UserProfileCallback userProfileCallback) {
            this.a = i;
            this.b = jSONObject;
            this.c = userProfileCallback;
        }

        @Override // com.bytedance.applog.profile.UserProfileCallback
        public void onFail(int i) {
            this.c.onFail(i);
        }

        @Override // com.bytedance.applog.profile.UserProfileCallback
        public void onSuccess() {
            k3.c[this.a] = this.b.toString().hashCode();
            k3.d[this.a] = System.currentTimeMillis();
            this.c.onSuccess();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0123 A[Catch: JSONException -> 0x013c, TryCatch #2 {JSONException -> 0x013c, blocks: (B:40:0x0112, B:42:0x011c, B:44:0x0123, B:45:0x0138, B:37:0x00fe, B:39:0x010d), top: B:66:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.bytedance.bdtracker.e0 r25, int r26, org.json.JSONObject r27, com.bytedance.applog.profile.UserProfileCallback r28, android.os.Handler r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.k3.a(com.bytedance.bdtracker.e0, int, org.json.JSONObject, com.bytedance.applog.profile.UserProfileCallback, android.os.Handler, boolean):void");
    }
}
