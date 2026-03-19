package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bf {
    private static String cmU;
    private static File cmV;

    private static boolean apA() {
        try {
            if (com.component.c.c.a.equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    public static String ev(Context context) {
        if (!TextUtils.isEmpty(cmU)) {
            return cmU;
        }
        String path = null;
        if (apA()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    path = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getFilesDir().getPath();
        }
        String str = path + File.separator + "ksadsdk";
        cmU = str;
        return str;
    }

    public static File ew(Context context) {
        File file = cmV;
        if (file != null) {
            return file;
        }
        String path = null;
        if (apA()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    path = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getCacheDir().getPath();
        }
        File file2 = new File(path + File.separator + "ksadsdk");
        cmV = file2;
        if (!file2.exists()) {
            cmV.mkdirs();
        }
        return cmV;
    }

    public static File ex(Context context) {
        File file = new File(ev(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ey(Context context) {
        File file = new File(ev(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File ez(Context context) {
        String strEv;
        if (com.kwad.framework.a.a.qr.booleanValue()) {
            strEv = ev(context);
        } else {
            strEv = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(strEv + File.separator + "ksadlog");
    }

    public static String eA(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : filesDir.getPath() + File.separator + "ksadsdk";
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return eA(context) + File.separator + "ksad/download/js";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        return eA(context) + File.separator + "ksad/download/js" + File.separator + str;
    }

    public static String eB(Context context) {
        return ew(context).getPath() + "/cookie";
    }
}
