package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class j {
    private static File bsu;
    private static final String bsv;

    static {
        bsv = PT() ? "dynamic_apk" : "dynamic.apk";
    }

    private static boolean PT() {
        return Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32;
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!(file.exists() && file.isDirectory()) && com.kwad.sdk.api.a.qr.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    private static File bm(Context context) {
        if (bsu == null) {
            bsu = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return bsu;
    }

    static File C(Context context, String str) {
        return new File(bm(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    static String D(Context context, String str) {
        return i(new File(bm(context), "apk-" + str)).getPath();
    }

    static File E(Context context, String str) {
        return i(new File(bm(context), "apk-" + str));
    }

    static String F(Context context, String str) {
        return new File(D(context, str), bsv).getPath();
    }

    static String G(Context context, String str) {
        return i(new File(D(context, str), "dex")).getPath();
    }

    static String H(Context context, String str) {
        return i(new File(D(context, str), "libs")).getPath();
    }

    static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    static void I(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.j.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] fileArrListFiles = j.E(context, str).getParentFile().listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                        return;
                    }
                    for (File file : fileArrListFiles) {
                        if (i.S(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            j.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
