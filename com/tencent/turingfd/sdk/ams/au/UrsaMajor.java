package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class UrsaMajor {
    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    public static boolean a() {
        Context context;
        int i = Build.VERSION.SDK_INT;
        if (i < 16) {
            return true;
        }
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        if (a(context, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        if (i >= 29) {
            return Environment.isExternalStorageLegacy();
        }
        return true;
    }
}
