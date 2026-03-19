package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j {
    public static final String a = "__sdk_remote_dl_2";
    public static final String b = "__sdk_pasys_pkgs_2";
    public static final String c = "__sdk_remote_dl_no_install";
    public static final String d = "__sdk_remote_dl_dialog";
    public static final String e = "dl";
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 2;
    public static final int i = 3;
    public static final int j = 4;
    public static final int k = -1;
    public static final int l = 5;
    public static final int m = 100;
    public static final String n = "NONE";
    public static final String o = "DOWNLOADING";
    public static final String p = "DOWNLOADED";
    public static final String q = "INSTALLED";
    public static final String r = "DONE";
    public static final String s = "DOWNLOAD_FAILED";
    public static final String t = "INSTALLED_BY_OTHER";
    private static final String u = "AdDownloadApkUtils";

    public static int a(Context context, String str, String str2) throws JSONException {
        SPUtils sPUtils = new SPUtils(context, b);
        int i2 = -1;
        if (str != null && !"".equals(str)) {
            boolean z = false;
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(sPUtils.getString("pkgs", "{}")).optJSONObject(str);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.optBoolean("a", false)) {
                        return 100;
                    }
                }
            } catch (Exception e2) {
                com.baidu.mobads.container.l.g.h(u).f(e2.getMessage());
            }
            try {
                SPUtils sPUtils2 = new SPUtils(context, a);
                JSONObject jSONObject = new JSONObject(sPUtils2.getString(str + com.baidu.mobads.container.components.command.j.b + com.baidu.mobads.container.components.command.j.b(), "{}"));
                int iOptInt = jSONObject.optInt("dl", -1);
                try {
                    String strOptString = jSONObject.optString("filename", null);
                    if (strOptString != null) {
                        File file = new File(bw.i(context) + strOptString);
                        if (iOptInt == 3) {
                            if (!file.exists() || file.length() == 0) {
                                z = true;
                            } else {
                                long jOptLong = jSONObject.optLong(com.baidu.mobads.container.components.command.j.i, -1L);
                                if (jOptLong != -1) {
                                    if (Math.abs(jOptLong - file.length()) >= 2) {
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                iOptInt = 5;
                                try {
                                    jSONObject.put("dl", 5);
                                    sPUtils2.putString(str, jSONObject.toString());
                                } catch (Exception e3) {
                                    e = e3;
                                    i2 = 5;
                                    com.baidu.mobads.container.l.g.h(u).f(e.getMessage());
                                    return i2;
                                }
                            }
                        }
                    }
                    return iOptInt;
                } catch (Exception e4) {
                    e = e4;
                    i2 = iOptInt;
                }
            } catch (Exception e5) {
                e = e5;
            }
        }
        return i2;
    }

    public static String b(Context context, String str, String str2) {
        String str3 = "NONE";
        try {
            int iA = a(context, str, str2);
            boolean zB = b(context, str);
            switch (iA) {
                case 0:
                case 1:
                    return zB ? t : o;
                case 2:
                case 4:
                    return zB ? t : s;
                case 3:
                    return zB ? q : p;
                case 5:
                    if (zB) {
                        str3 = r;
                    }
                    return str3;
                case 100:
                    return r;
                default:
                    if (zB) {
                        str3 = t;
                    }
                    return str3;
            }
        } catch (Exception e2) {
            return "NONE";
        }
    }

    public static String a(Context context, String str) {
        try {
            String string = context.getSharedPreferences(a, 0).getString(str + com.baidu.mobads.container.components.command.j.b + com.baidu.mobads.container.components.command.j.b(), "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                String strOptString = jSONObject.optString(com.baidu.mobads.container.components.command.j.m);
                String strOptString2 = jSONObject.optString("filename");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    return strOptString + strOptString2;
                }
            }
        } catch (Exception e2) {
            bq.a().a(e2);
        }
        return "";
    }

    public static boolean b(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return str.equals(applicationInfo.packageName);
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean a(Context context) {
        return x.a(context).a() >= 24 && t.e(context) >= 24;
    }

    private static Uri a(Context context, File file) {
        try {
            return t.a(context, context.getPackageName() + ".bd.provider", file);
        } catch (Exception e2) {
            return null;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (!a(context) || c(context)) {
                return true;
            }
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                if (c(context, bw.a(externalFilesDir.getPath()))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean c(Context context) {
        File fileC;
        return x.a(context).a() <= 28 && bl.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && bl.a("permission_storage") && (fileC = com.component.c.c.c()) != null && c(context, bw.a(fileC.getPath()));
    }

    private static boolean c(Context context, String str) {
        if (!a(context)) {
            return true;
        }
        try {
            File file = new File(str + "t");
            if (!file.exists()) {
                file.mkdir();
            }
            return a(context, file) != null;
        } catch (Exception e2) {
            bq.a().c(e2);
            return false;
        }
    }

    public static void a(Context context, File file, com.baidu.mobads.container.components.command.j jVar) {
        try {
            t.c(context, file);
            com.baidu.mobads.container.components.f.c cVarA = com.baidu.mobads.container.components.f.c.a();
            cVarA.a(new com.baidu.mobads.container.components.f.b(context, jVar));
            cVarA.b();
        } catch (Throwable th) {
            bq.a().d(th);
        }
    }
}
