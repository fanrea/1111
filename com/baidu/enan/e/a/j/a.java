package com.baidu.enan.e.a.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.alipay.sdk.m.u.i;
import com.baidu.enan.f.b;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.google.android.material.timepicker.TimeModel;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return b(context);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static String b(Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (string == null) {
                string = ILogConst.CACHE_PLAY_REASON_NULL;
            }
            String str = "1-" + string + i.b;
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                String str2 = str + "2-";
                int i = -1;
                for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                    String packageName = inputMethodInfo.getPackageName();
                    if (packageName == null) {
                        packageName = ILogConst.CACHE_PLAY_REASON_NULL;
                    }
                    String settingsActivity = inputMethodInfo.getSettingsActivity();
                    if (settingsActivity == null) {
                        settingsActivity = ILogConst.CACHE_PLAY_REASON_NULL;
                    }
                    if (packageManager != null && !ILogConst.CACHE_PLAY_REASON_NULL.equals(packageName) && !ILogConst.CACHE_PLAY_REASON_NULL.equals(settingsActivity) && (activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, settingsActivity), 0)) != null) {
                        i = activityInfo.launchMode;
                    }
                    str2 = str2 + packageName + "-" + settingsActivity + "-" + String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i)) + i.b;
                }
                return str2;
            }
            return str;
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }
}
