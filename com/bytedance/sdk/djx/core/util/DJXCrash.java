package com.bytedance.sdk.djx.core.util;

import android.content.Context;
import com.bytedance.sdk.djx.DJXSdk;
import com.bytedance.sdk.djx.utils.FileUtil;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.PluginCrashHandler;
import com.bytedance.sdk.djx.utils.SP;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXCrash implements Thread.UncaughtExceptionHandler {
    private static final int CRASH_COUNT_MAX = 3;
    private static final String FILE_NAME_CRASH_COUNT = "djx_crash.pro";
    private static final String KEY_CRASH_COUNT = "count";
    private static final String KEY_CRASH_LAST_TIME = "last_time";
    private static final String TAG = "DJXCrash";
    private Thread.UncaughtExceptionHandler mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    private String mDirectory;

    public static DJXCrash register() {
        return new DJXCrash();
    }

    private DJXCrash() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        initPath();
    }

    private void initPath() {
        Context context = InnerManager.getContext();
        if (context == null) {
            return;
        }
        try {
            this.mDirectory = FileUtil.getCrashCache(context).getAbsolutePath();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean zContains = false;
        String string = null;
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
            if (string != null) {
                zContains = string.contains(DJXSdk.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (zContains) {
            PluginCrashHandler.handleCrash(string, thread);
            handlerException(thread, th);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e A[Catch: all -> 0x0120, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0120, blocks: (B:3:0x000c, B:9:0x001c, B:13:0x002e, B:16:0x0043, B:18:0x0049, B:20:0x004f, B:52:0x00ec), top: B:68:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void handlerException(java.lang.Thread r20, java.lang.Throwable r21) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.util.DJXCrash.handlerException(java.lang.Thread, java.lang.Throwable):void");
    }

    private void cleanLocalData() {
        SP.cleanNativeKV();
    }
}
