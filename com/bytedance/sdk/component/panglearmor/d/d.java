package com.bytedance.sdk.component.panglearmor.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.d.hc.an;
import com.bytedance.sdk.openadsdk.api.plugin.hc;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static d d;
    private long hc = 0;

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d dVar = new d();
                    d = dVar;
                    dVar.hc = 0L;
                }
            }
        }
        return d;
    }

    private boolean hc() {
        return new SecureRandom().nextInt(10) == 1;
    }

    @DungeonFlag
    private boolean b() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.hc = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.hc >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return hc();
        }
        if (i != 0 || this.hc < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return hc();
    }

    public synchronized JSONObject d(Context context, String str) {
        String strHc;
        JSONObject jSONObject = new JSONObject();
        try {
            strHc = hc(context);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strHc) && b()) {
            File file = new File(strHc);
            if (file.exists()) {
                jSONObject = d(file, context, str);
            }
            return jSONObject;
        }
        return null;
    }

    @DungeonFlag
    private JSONObject d(File file, Context context, String str) throws JSONException {
        JSONObject jSONObjectD = an.d(file);
        File fileD = hc.d(context);
        if (fileD != null) {
            an.d(jSONObjectD, "files", d(!TextUtils.isEmpty(str) ? hc.d(context).getParent() : hc.d(context).getPath()), false);
            File parentFile = fileD.getParentFile();
            if (parentFile != null) {
                List<String> listD = d((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/shared_prefs");
                List<String> listD2 = d((!TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath()) + "/databases");
                an.d(jSONObjectD, "prefs", listD, false);
                an.d(jSONObjectD, "databases", listD2, false);
            }
        }
        try {
            JSONObject jSONObjectD2 = d(context);
            if (jSONObjectD2 != null && jSONObjectD2.length() > 0) {
                jSONObjectD.put("manifest", jSONObjectD2);
            }
            jSONObjectD.put("rt", this.hc);
            jSONObjectD.put("path", str);
        } catch (JSONException unused) {
        }
        return jSONObjectD;
    }

    private List<String> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String hc(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }
}
