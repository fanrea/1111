package com.kwad.sdk.p;

import android.content.Context;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class a {
    private static File bsu;

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
        if (file.exists()) {
            file.isDirectory();
        }
        return file;
    }

    private static File bm(Context context) {
        if (bsu == null) {
            bsu = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return bsu;
    }

    private static String D(Context context, String str) {
        return i(new File(bm(context), "apk-" + str)).getPath();
    }

    static String F(Context context, String str) {
        File file = new File(D(context, str), "dynamic.apk");
        if (file.exists()) {
            return file.getPath();
        }
        return new File(D(context, str), "dynamic_apk").getPath();
    }
}
