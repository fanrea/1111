package com.bytedance.pangle.an;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.alipay.sdk.m.s.a;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.tt;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static int d = 1;
    public static int hc = 2;

    public static SharedPreferences d(Context context) {
        return com.bytedance.sdk.openadsdk.ats.b.d(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    static String[] d(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add(a.n);
        }
        arrayList.add("--instruction-set=" + d());
        if (i == d) {
            if (tt.k()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == hc) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String d() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.an.d(e);
            return null;
        }
    }

    public static String d(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(strSubstring2)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring2) || ".apk".equals(strSubstring2)) {
            return strSubstring.replace(strSubstring2, str2);
        }
        return strSubstring + str2;
    }

    public static String hc(String str) {
        String strSubstring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        return ".dex".equals(strSubstring) ? strSubstring : (".zip".equals(strSubstring) || ".apk".equals(strSubstring)) ? str2 : str + str2;
    }

    public static boolean d(String str, String str2) {
        return d.d(d(str, str2, d));
    }

    public static boolean d(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !gb.d(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str, String... strArr) {
        for (String str2 : strArr) {
            if (!new File(str + File.separator + d(str2)).exists()) {
                return false;
            }
        }
        return true;
    }
}
