package com.android.gdt.qone.w;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.gdt.qone.ar.d;
import com.android.gdt.qone.uin.U;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c {
    public static final c p = new c();
    public long b;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String m;
    public String n;
    public long c = 0;
    public final Object l = new Object();
    public Enumeration o = null;
    public final Context a = d.h().a();

    public static String e() {
        int iIndexOf;
        File file = new File("/");
        if (file.listFiles() == null) {
            return "";
        }
        for (File file2 : file.listFiles()) {
            String name = file2.getName();
            if (name.startsWith("init.") && name.endsWith(".environment.rc") && (iIndexOf = name.indexOf(".environment.rc")) > 5) {
                return name.substring(5, iIndexOf);
            }
        }
        return "";
    }

    public static synchronized c h() {
        return p;
    }

    public static boolean q() {
        return Process.myUid() / KSTubeParamInner.FREE_ALL != 0;
    }

    public final boolean a() {
        Intent intentRegisterReceiver;
        try {
            intentRegisterReceiver = this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable th) {
            com.android.gdt.qone.af.c.a(th);
        }
        boolean z = (intentRegisterReceiver.getIntExtra("status", -1) == 5) && (intentRegisterReceiver.getIntExtra("plugged", -1) == 1);
        TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
        return z || (telephonyManager == null || telephonyManager.getPhoneType() == 0);
    }

    public final synchronized String b() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String string = "";
        Context context = this.a;
        if (context == null) {
            return "";
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            com.android.gdt.qone.af.c.a(e);
        }
        String lowerCase = string != null ? string.toLowerCase() : "";
        this.d = lowerCase;
        return lowerCase;
    }

    public final synchronized String c() {
        String str = this.j;
        if (str != null) {
            return str;
        }
        String str2 = Build.MODEL;
        this.j = str2;
        return str2;
    }

    public final synchronized void d() {
    }

    public final String g() {
        try {
            UiModeManager uiModeManager = (UiModeManager) this.a.getSystemService("uimode");
            if (uiModeManager == null && a()) {
                return "TV";
            }
            int currentModeType = uiModeManager.getCurrentModeType();
            return r() ? "TV" : currentModeType == 6 ? "WATCH" : currentModeType == 3 ? "CAR" : currentModeType == 5 ? "APPLIANCE" : currentModeType == 7 ? "VR" : (this.a.getResources().getConfiguration().screenLayout & 15) >= 3 ? "Pad" : "Phone";
        } catch (Throwable th) {
            if (a()) {
                return "TV";
            }
            com.android.gdt.qone.af.c.a(th);
            return "Phone";
        }
    }

    public final synchronized String i() {
        String hostAddress;
        Enumeration<InetAddress> inetAddresses;
        if (this.i == null) {
            Enumeration enumerationL = l();
            if (enumerationL != null) {
                loop0: while (true) {
                    if (!enumerationL.hasMoreElements()) {
                        hostAddress = "0.0.0.0";
                        break;
                    }
                    NetworkInterface networkInterface = (NetworkInterface) enumerationL.nextElement();
                    if (networkInterface != null && (inetAddresses = networkInterface.getInetAddresses()) != null) {
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                                hostAddress = inetAddressNextElement.getHostAddress();
                                break loop0;
                            }
                        }
                    }
                }
            } else {
                hostAddress = "0.0.0.0";
            }
            this.i = hostAddress;
        }
        return this.i;
    }

    public final synchronized void j() {
    }

    public final String k() {
        synchronized (this) {
            if (this.f == null) {
                t();
            }
        }
        String str = this.f;
        return str == null ? "" : str;
    }

    public final synchronized Enumeration l() {
        if (this.o == null) {
            try {
                this.o = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException e) {
                com.android.gdt.qone.af.c.a(e);
            }
        }
        return this.o;
    }

    public final synchronized String m() {
        if (this.m == null) {
            this.m = U.d();
        }
        return this.m;
    }

    public final synchronized String n() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = "Android " + Build.VERSION.RELEASE + ",level " + Build.VERSION.SDK;
        this.e = str2;
        return str2;
    }

    public final String o() {
        String str;
        synchronized (this.l) {
            if (TextUtils.isEmpty(this.k)) {
                this.k = U.a(this.a);
            }
            str = this.k;
        }
        return str;
    }

    public final String p() {
        String str;
        synchronized (this.l) {
            if (TextUtils.isEmpty(this.k)) {
                this.k = U.b(this.a);
            }
            str = this.k;
        }
        return str;
    }

    public final boolean r() {
        try {
        } catch (Throwable th) {
            com.android.gdt.qone.af.c.a(th);
        }
        if (((UiModeManager) this.a.getSystemService("uimode")).getCurrentModeType() == 4) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            if (!this.a.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                if (!this.a.getPackageManager().hasSystemFeature("android.software.leanback")) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final synchronized boolean s() {
        return this.g;
    }

    public final synchronized void t() {
        String strA = com.android.gdt.qone.ac.a.a();
        if (strA.equals(this.f)) {
            this.g = false;
        } else {
            this.g = true;
            this.f = strA;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String f() {
        /*
            java.lang.String r0 = "1#"
            java.lang.String r1 = ""
            java.lang.String r2 = e()     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "/proc/self/mountinfo"
            r4 = 4096(0x1000, float:5.74E-42)
            java.lang.String r3 = com.android.gdt.qone.ae.b.a(r4, r3)     // Catch: java.lang.Throwable -> L60
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L18
        L16:
            r3 = r1
            goto L3b
        L18:
            java.lang.String r4 = "/lxc_container/"
            boolean r4 = r3.contains(r4)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L23
            java.lang.String r3 = "lxc"
            goto L3b
        L23:
            java.lang.String r4 = "/proc/self/cpuset"
            r5 = 1024(0x400, float:1.435E-42)
            java.lang.String r4 = com.android.gdt.qone.ae.b.a(r5, r4)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = "/docker"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L60
            if (r5 == 0) goto L16
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> L60
            if (r3 == 0) goto L16
            java.lang.String r3 = "docker"
        L3b:
            boolean r4 = r2.isEmpty()     // Catch: java.lang.Throwable -> L60
            if (r4 != 0) goto L45
            java.lang.String r1 = r0.concat(r2)     // Catch: java.lang.Throwable -> L60
        L45:
            boolean r0 = r3.isEmpty()     // Catch: java.lang.Throwable -> L60
            if (r0 != 0) goto L64
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r0.<init>()     // Catch: java.lang.Throwable -> L60
            r0.append(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = "2#"
            r0.append(r2)     // Catch: java.lang.Throwable -> L60
            r0.append(r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r0.toString()     // Catch: java.lang.Throwable -> L60
            goto L64
        L60:
            r0 = move-exception
            com.android.gdt.qone.af.c.a(r0)
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.w.c.f():java.lang.String");
    }
}
