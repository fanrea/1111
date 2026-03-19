package com.kwad.components.ad.j;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bs;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {

    public static class a extends com.kwad.sdk.commercial.c.a {
        public String NF = bs.apY();
        public String NG = bs.aqa();
        public String NH = bs.getOsVersion();
        public String NI = bs.aqg();
        public String NJ = be.getDeviceId();
        public String NK;
        public String NL;
        public int status;
    }

    public static void ak(Context context) {
        context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("content://com.kwad.kwadsdk.adFileProvider/ksad_external_files_path/Download/test.apk"), "application/vnd.android.package-archive");
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller installers size: " + listQueryIntentActivities.size());
        if (listQueryIntentActivities.size() <= 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller info: " + resolveInfo);
                jSONArray.put(resolveInfo.activityInfo.packageName);
            }
            String string = jSONArray.toString();
            a aVar = new a();
            aVar.status = 2;
            aVar.NL = string;
            com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportDeviceLocalInstaller: " + aVar.toJson());
            com.kwad.sdk.commercial.b.u(aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public static void al(Context context) {
        String strB = b(context, "SP_OPEN_FILE_RECORD", "");
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportInstallerCheckRecord start installCheckRecord: " + strB);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        a aVar = new a();
        aVar.status = 1;
        aVar.NK = strB;
        com.kwad.sdk.core.d.c.d("InstallerCheckReport", "reportInstallerCheckRecord report msg:" + aVar.toJson());
        com.kwad.sdk.commercial.b.u(aVar);
        g(context, "SP_OPEN_FILE_RECORD");
    }

    private static String b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static void g(Context context, String str) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
