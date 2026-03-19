package ca.da.ca.ba;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import ca.da.ca.c;
import ca.da.ca.i;
import ca.da.ca.ja.m;
import ca.da.ca.ja.r;
import ca.da.ca.ja.t;
import com.apm.applog.AppLog;
import com.apm.applog.UriConfig;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.apm.common.utility.NetworkUtils;
import com.bytedance.apm.common.utility.UIUtils;
import com.bytedance.applog.util.SensitiveUtils;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: ApiParamsUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static volatile c a;
    public static final a[] b = {new a("aid", "aid", String.class), new a("google_aid", "google_aid", String.class), new a("carrier", "carrier", String.class), new a("mcc_mnc", "mcc_mnc", String.class), new a("sim_region", "sim_region", String.class), new a(com.baidu.mobads.upgrade.remote.gray.c.l, com.baidu.mobads.upgrade.remote.gray.c.l, String.class), new a("bd_did", "bd_did", String.class), new a("install_id", Config.IID, String.class), new a("clientudid", "clientudid", String.class), new a("app_name", "app_name", String.class), new a("app_version", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, String.class), new a("version_code", "version_code", Integer.class), new a("manifest_version_code", "manifest_version_code", Integer.class), new a("update_version_code", "update_version_code", Integer.class), new a("sdk_version_code", "sdk_version_code", Integer.class)};

    /* compiled from: ApiParamsUtil.java */
    public static class a {
        public final String a;
        public final String b;
        public final Class c;

        public a(String str, String str2, Class cls) {
            this.a = str;
            this.b = str2;
            this.c = cls;
        }
    }

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, i iVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderBuildUpon = uri.buildUpon();
        HashMap map = new HashMap();
        a(context, jSONObject, z, map, iVar);
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (!queryParameterNames.contains(str2) && !TextUtils.isEmpty(str3)) {
                builderBuildUpon.appendQueryParameter(str2, (String) entry.getValue());
            }
        }
        return builderBuildUpon.build().toString();
    }

    public static void a(Context context, JSONObject jSONObject, boolean z, Map<String, String> map, i iVar) {
        if (context == null || map == null || iVar == null) {
            return;
        }
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        map.put("device_platform", "android");
        if (z) {
            map.put("ssmix", "a");
        }
        String screenResolution = UIUtils.getScreenResolution(context);
        if (!TextUtils.isEmpty(screenResolution)) {
            map.put("resolution", screenResolution);
        }
        int dpi = UIUtils.getDpi(context);
        if (dpi > 0) {
            map.put("dpi", String.valueOf(dpi));
        }
        map.put("device_type", Build.MODEL);
        map.put("device_brand", Build.BRAND);
        map.put("language", context.getResources().getConfiguration().locale.getLanguage());
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("os_version", t.a());
        String networkAccessType = NetworkUtils.getNetworkAccessType(NetworkUtils.getNetworkTypeFast(context));
        if (!TextUtils.isEmpty(networkAccessType)) {
            map.put("ac", networkAccessType);
        }
        int i = 0;
        while (true) {
            a[] aVarArr = b;
            if (i >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i];
            Object objA = a(jSONObject, aVar.a, null, aVar.c);
            if (objA != null) {
                map.put(aVar.b, objA.toString());
            }
            i++;
        }
        String str = (String) a(jSONObject, "tweaked_channel", "", String.class);
        if (TextUtils.isEmpty(str)) {
            str = (String) a(jSONObject, "channel", "", String.class);
        }
        if (!TextUtils.isEmpty(str)) {
            map.put("channel", str);
        }
        String str2 = (String) a(jSONObject, "cdid", null, String.class);
        if (!TextUtils.isEmpty(str2)) {
            map.put("cdid", str2);
        }
        boolean zA = m.a(context);
        if (iVar == i.L0) {
            if (zA) {
                String str3 = (String) a(jSONObject, "mc", null, String.class);
                String str4 = (String) a(jSONObject, "udid", null, String.class);
                if (!TextUtils.isEmpty(str3)) {
                    map.put(SensitiveUtils.KEY_MAC, str3);
                }
                if (t.a(str4)) {
                    map.put("uuid", str4);
                }
            }
            String str5 = (String) a(jSONObject, SensitiveUtils.KEY_ALIYUN_UUID, null, String.class);
            if (!TextUtils.isEmpty(str5)) {
                map.put(SensitiveUtils.KEY_ALIYUN_UUID, str5);
            }
        }
        String str6 = (String) a(jSONObject, SensitiveUtils.KEY_BUILD_SERIAL, null, String.class);
        if (!TextUtils.isEmpty(str6)) {
            map.put(SensitiveUtils.KEY_BUILD_SERIAL, str6);
        }
        if (iVar == i.L0) {
            String str7 = (String) a(jSONObject, "openudid", null, String.class);
            if (!TextUtils.isEmpty(str7)) {
                map.put("openudid", str7);
            }
        }
        ca.da.ca.a appContext = AppLog.getAppContext();
        if (appContext != null) {
            map.put("aid", String.valueOf(appContext.k()));
            String strE = appContext.e();
            if (TextUtils.isEmpty(strE)) {
                strE = appContext.d();
            }
            if (!TextUtils.isEmpty(strE)) {
                map.put("channel", strE);
            }
            String strF = appContext.f();
            if (!TextUtils.isEmpty(strF)) {
                map.put("app_name", strF);
            }
            map.put("version_code", String.valueOf(appContext.g()));
            String strB = appContext.b();
            if (!TextUtils.isEmpty(strB)) {
                map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, strB);
            }
            map.put("manifest_version_code", String.valueOf(appContext.m()));
            map.put("update_version_code", String.valueOf(appContext.a()));
            String strJ = appContext.j();
            if (!TextUtils.isEmpty(strJ)) {
                map.put("ab_version", strJ);
            }
            String strC = appContext.c();
            if (!TextUtils.isEmpty(strC)) {
                map.put("ab_client", strC);
            }
            String strI = appContext.i();
            if (!TextUtils.isEmpty(strI)) {
                map.put("ab_group", strI);
            }
            String strH = appContext.h();
            if (!TextUtils.isEmpty(strH)) {
                map.put("ab_feature", strH);
            }
            long jL = appContext.l();
            if (jL > 0) {
                map.put("abflag", String.valueOf(jL));
            }
        }
        if (AppLog.isNewUserMode(context)) {
            map.putAll(ca.da.ca.ha.a.a(context).c);
        }
    }

    public static String[] a(ca.da.ca.da.b bVar, JSONObject jSONObject, boolean z) {
        UriConfig uriConfigC = bVar.c();
        String[] realUris = z ? uriConfigC.getRealUris() : uriConfigC.getSendUris();
        int length = realUris.length;
        String[] strArr = new String[length];
        boolean encryptAndCompress = AppLog.getEncryptAndCompress();
        for (int i = 0; i < length; i++) {
            strArr[i] = realUris[i];
            if (encryptAndCompress) {
                strArr[i] = ca.ca.ca.ca.a.a(new StringBuilder(), strArr[i], "?tt_data=a");
            }
            String strA = a((Context) bVar.b, jSONObject, strArr[i], true, i.L1);
            strArr[i] = strA;
            String[] strArr2 = ca.da.ca.ba.a.d;
            if (!TextUtils.isEmpty(strA)) {
                Uri uri = Uri.parse(strA);
                HashMap map = new HashMap(strArr2.length);
                for (String str : strArr2) {
                    String queryParameter = uri.getQueryParameter(str);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        map.put(str, queryParameter);
                    }
                }
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.clearQuery();
                for (String str2 : map.keySet()) {
                    builderBuildUpon.appendQueryParameter(str2, (String) map.get(str2));
                }
                strA = builderBuildUpon.build().toString();
            }
            strArr[i] = strA;
        }
        return strArr;
    }

    public static <T> T a(JSONObject jSONObject, String str, T t, Class<T> cls) {
        T tCast;
        Object objOpt = jSONObject.opt(str);
        if (objOpt == null || cls == null) {
            tCast = null;
        } else {
            try {
                tCast = cls.cast(objOpt);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return tCast == null ? t : tCast;
    }
}
