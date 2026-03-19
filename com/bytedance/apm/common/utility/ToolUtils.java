package com.bytedance.apm.common.utility;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.io.IOUtils;
import com.bytedance.apm.common.utility.reflect.Reflect;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ToolUtils {
    private static String sCurrentProcessName = null;
    private static int sIsHmOs = -1;

    public static String getCurrentProcessName() throws IOException {
        if (!TextUtils.isEmpty(sCurrentProcessName)) {
            return sCurrentProcessName;
        }
        String currentProcessNameByApplication = getCurrentProcessNameByApplication();
        sCurrentProcessName = currentProcessNameByApplication;
        if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
            return sCurrentProcessName;
        }
        String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
        sCurrentProcessName = currentProcessNameByActivityThread;
        if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
            return sCurrentProcessName;
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurrentProcessName = curProcessNameFromProc;
        return curProcessNameFromProc;
    }

    private static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static String getCurrentProcessNameByActivityThread() {
        try {
            return (String) Reflect.on("android.app.ActivityThread").call("currentProcessName").get();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getCurProcessNameFromProc() throws IOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i = bufferedReader.read();
                    if (i > 0) {
                        sb.append((char) i);
                    } else {
                        String string = sb.toString();
                        IOUtils.close(bufferedReader);
                        return string;
                    }
                }
            } catch (Throwable unused) {
                IOUtils.close(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean isHarmonyOs() {
        int i = sIsHmOs;
        if (i != -1) {
            return i == 1;
        }
        try {
            if (Class.forName("ohos.utils.system.SystemCapability") != null) {
                sIsHmOs = 1;
            } else {
                sIsHmOs = 0;
            }
        } catch (Throwable unused) {
            sIsHmOs = 0;
        }
        return sIsHmOs == 1;
    }
}
