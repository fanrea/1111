package com.baidu.mobads.container.util.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.cb;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String a = c.class.getSimpleName();
    private static final String b = "android.hardware.usb.action.USB_STATE";
    private static volatile c c;
    private boolean d;
    private boolean e;
    private boolean f;
    private Context g;
    private bq h = bq.a();
    private BroadcastReceiver i = new d(this);

    private c(Context context) {
        this.g = context.getApplicationContext();
        f();
    }

    public static c a(Context context) {
        if (c == null) {
            synchronized (c.class) {
                if (c == null && context != null) {
                    c = new c(context);
                }
            }
        }
        return c;
    }

    public boolean a() {
        if (ab.f(this.g)) {
            return !TextUtils.isEmpty(System.getProperty("http.proxyHost"));
        }
        return false;
    }

    public boolean b() {
        if (this.e) {
            return this.d;
        }
        this.d = e() != null;
        this.e = true;
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    private String e() {
        String str = System.getenv("PATH");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : str.split(":")) {
            String str3 = str2 + "/su";
            if (new File(str3).exists()) {
                this.h.a(a, "path:" + str3 + " is exists");
                return str3;
            }
        }
        return null;
    }

    private void f() {
        this.h.a(a, "listenUsb: register");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
        intentFilter.addAction(b);
        new com.component.c.b(this.g).a(this.i, intentFilter);
        this.h.a(a, "listenUsb: registered");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context) {
        try {
            return cb.a(context);
        } catch (Exception e) {
            return false;
        }
    }
}
