package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static Context bGa;
    private static String bNx;

    public static void init(Context context, String str) {
        bGa = context;
        bNx = str;
        bNx = w.ad(context, "kwad_ex");
    }

    public static File aeo() {
        File file;
        if (!TextUtils.isEmpty(bNx)) {
            file = new File(bNx);
        } else {
            Context contextVS = bGa;
            if (contextVS == null) {
                contextVS = ServiceProvider.anu();
            }
            if (contextVS == null) {
                try {
                    contextVS = z.VS();
                } catch (Throwable unused) {
                }
            }
            file = contextVS != null ? new File(getDataDir(contextVS), "kwad_ex") : null;
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File aep() {
        return new File(aeo(), "java_crash/dump");
    }

    private static File getDataDir(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = Build.VERSION.SDK_INT >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static File aeq() {
        return new File(aeo(), "anr_log/dump");
    }

    public static File aer() {
        return new File(aeo(), "native_crash_log/dump");
    }

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }
}
