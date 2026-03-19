package com.component.c;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private final Context a;

    public b(Context context) {
        this.a = context.getApplicationContext();
    }

    public ActivityManager a() {
        return (ActivityManager) this.a.getSystemService("activity");
    }

    public WindowManager b() {
        return (WindowManager) this.a.getSystemService("window");
    }

    public SensorManager c() {
        return (SensorManager) this.a.getSystemService("sensor");
    }

    public NotificationManager d() {
        return (NotificationManager) this.a.getSystemService("notification");
    }

    public PowerManager e() {
        return (PowerManager) this.a.getSystemService("power");
    }

    public TelephonyManager f() {
        return (TelephonyManager) this.a.getSystemService("phone");
    }

    public ConnectivityManager g() {
        return (ConnectivityManager) this.a.getSystemService("connectivity");
    }

    public KeyguardManager h() {
        return (KeyguardManager) this.a.getSystemService("keyguard");
    }

    public AudioManager i() {
        return (AudioManager) this.a.getSystemService("audio");
    }

    public WifiManager j() {
        return (WifiManager) this.a.getSystemService(com.baidu.mobads.container.util.e.a.a);
    }

    public CameraManager k() {
        if (Build.VERSION.SDK_INT >= 21) {
            return (CameraManager) this.a.getSystemService("camera");
        }
        return null;
    }

    public InputMethodManager l() {
        return (InputMethodManager) this.a.getSystemService("input_method");
    }

    public Intent a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            return this.a.registerReceiver(broadcastReceiver, intentFilter, 2);
        }
        return this.a.registerReceiver(broadcastReceiver, intentFilter);
    }

    public Intent b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (Build.VERSION.SDK_INT >= 33) {
            return this.a.registerReceiver(broadcastReceiver, intentFilter, 4);
        }
        return this.a.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        this.a.unregisterReceiver(broadcastReceiver);
    }
}
