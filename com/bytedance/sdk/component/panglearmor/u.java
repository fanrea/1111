package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static volatile boolean d = false;

    public static void d(Context context) {
        if (d || context == null) {
            return;
        }
        hc(context);
        b(context);
        c(context);
        u(context);
        d = true;
    }

    private static void hc(Context context) {
        boolean booleanExtra;
        Intent intentRegisterReceiver;
        double intExtra = -0.1d;
        try {
            intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (intentRegisterReceiver != null) {
            booleanExtra = intentRegisterReceiver.getBooleanExtra("present", false);
            try {
                intExtra = intentRegisterReceiver.getIntExtra("temperature", -1) / 10.0d;
            } catch (Throwable unused2) {
            }
        } else {
            booleanExtra = true;
        }
        an.d(1006, new Object[]{Boolean.valueOf(booleanExtra), Double.valueOf(intExtra)});
    }

    private static void b(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            an.d(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(Camera.getNumberOfCameras())});
            return;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        int i = -1;
        int i2 = -2;
        if (cameraManager != null) {
            try {
                int i3 = 0;
                int i4 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int iIntValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (iIntValue == 0) {
                        i3++;
                    } else if (iIntValue == 1) {
                        i4++;
                    }
                }
                i = i3;
                i2 = i4;
            } catch (Throwable unused) {
                i2 = -1;
            }
        } else {
            i = -2;
        }
        an.d(1007, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static void c(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        an.d(1008, new Object[]{Boolean.valueOf(configuration == null || !(configuration.touchscreen == 1 || configuration.touchscreen == 0))});
    }

    private static void u(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        an.d(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }
}
