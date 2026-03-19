package com.bytedance.pangle.u;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.tt;
import com.bytedance.sdk.openadsdk.api.an;
import java.io.File;
import java.io.FileFilter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static File b;
    private static File d;
    private static File hc;

    private static void u() {
        if (d == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), "pangle" + tt.b);
            d = file;
            d(file);
        }
    }

    public static String d(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    private static String d(String... strArr) {
        u();
        File file = d;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return d(file);
    }

    public static String d() {
        u();
        return d.getPath();
    }

    public static String hc() {
        Application appApplication = Zeus.getAppApplication();
        if (hc == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + tt.hc);
            }
            hc = downloadDir;
        }
        return d(hc);
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (b == null) {
            b = new File(appApplication.getFilesDir(), ".pangle" + tt.d);
        }
        return d(b);
    }

    public static String c() {
        File externalFilesDir;
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!com.component.c.c.a.equals(Environment.getExternalStorageState()) || (externalFilesDir = appApplication.getExternalFilesDir(".pangle" + tt.hc)) == null) {
                return null;
            }
            return d(externalFilesDir);
        } catch (Exception e) {
            an.d(e);
            return null;
        }
    }

    public static String d(String str, int i) {
        u();
        File file = d;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String d(String str) {
        return d(str);
    }

    public static String hc(String str, int i) {
        return new File(d(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String b(String str, int i) {
        return com.bytedance.pangle.util.tt.k() ? d(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.bytedance.pangle.an.hc.d()) : d(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String c(String str, int i) {
        return d(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String u(String str, int i) {
        return new File(d(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String an(String str, int i) {
        return new File(d(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String h(String str, int i) {
        return new File(d(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String gb(String str, int i) {
        return com.bytedance.pangle.util.tt.k() ? d(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.bytedance.pangle.an.hc.d()) : d(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String tt(String str, int i) {
        return d(str, "version-".concat(String.valueOf(i)), "secondary-dexes");
    }

    public static boolean tc(String str, int i) {
        return new File(d() + File.separator + str + File.separator + "version-" + i).exists();
    }

    public static String d(String str, int i, String str2) {
        return new File(d(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }

    public static File[] mk(String str, int i) {
        String strD = d(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return new File(strD).listFiles(new FileFilter() { // from class: com.bytedance.pangle.u.b.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String mq(String str, int i) {
        return new File(d(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }
}
