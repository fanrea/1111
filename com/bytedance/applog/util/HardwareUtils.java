package com.bytedance.applog.util;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.f4;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HardwareUtils {
    public static final String GLOBAL_CACHE_GET_ANDROID_ID = "Secure.getString_android_id";

    public static class a implements f4.a {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bytedance.bdtracker.f4.a
        public String a() {
            LoggerImpl.global().debug(Collections.singletonList("HardwareUtils"), "[DeviceMeta] Try to get android id by secure.getString", new Object[0]);
            return Settings.Secure.getString(this.a.getContentResolver(), "android_id");
        }
    }

    public static String getOperatorMccMnc(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperator();
        }
        return null;
    }

    public static String getOperatorName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    public static int getScreenOrientation(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0;
        }
        return defaultDisplay.getWidth() <= defaultDisplay.getHeight() ? 1 : 2;
    }

    public static String getSecureAndroidId(Context context) {
        try {
            return f4.a(context).a(GLOBAL_CACHE_GET_ANDROID_ID, new a(context));
        } catch (Throwable th) {
            LoggerImpl.global().error(Collections.singletonList("HardwareUtils"), "Get androidId failed", th, new Object[0]);
            return null;
        }
    }
}
