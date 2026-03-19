package com.baidu.mobads.container.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraManager;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mobads.container.util.by;
import com.pandora.common.utils.Times;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ai extends BroadcastReceiver {
    private static final String A = "ec";
    private static final String B = "ir";
    private static volatile ai a = null;
    private static final String d = "mobads_events";
    private static final int e = 86400;
    private static final long f = 86400000;
    private static final String g = "local_time";
    private static final String j = "screenchange";
    private static final String k = "scc";
    private static final String m = "eu";
    private static final String n = "ed";
    private static final String o = "vc";
    private static final String p = "voc";
    private static final String q = "android.media.VOLUME_CHANGED_ACTION";
    private static final String r = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static final String s = "lc";
    private static final String t = "sc";
    private static final String u = "in";
    private static final String v = "hs";
    private static final String w = "cm";
    private static final String x = "cc";
    private static final String y = "d1";
    private static final String z = "d2";
    private Context b;
    private com.baidu.mobads.container.b.a.a c;
    private long h;
    private long i = 0;
    private int l = -1;

    private ai(Context context) {
        this.h = 0L;
        this.b = context;
        this.c = new com.baidu.mobads.container.b.a.a(context.getApplicationContext(), d);
        long jLongValue = this.c.b(g).longValue();
        if (jLongValue <= 0) {
            this.h = System.currentTimeMillis();
            a(this.h);
        } else {
            this.h = jLongValue;
            b(context);
        }
        c();
    }

    public static ai a(Context context) {
        if (context != null && a == null) {
            synchronized (ai.class) {
                if (a == null) {
                    a = new ai(context);
                }
            }
        }
        return a;
    }

    public void a() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            intentFilter.addAction(q);
            new com.component.c.b(this.b).a(this, intentFilter);
        } catch (Throwable th) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            com.baidu.mobads.container.d.b.a().a(new aj(this, intent, context));
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Context context) {
        try {
            if (this.c == null) {
                this.c = new com.baidu.mobads.container.b.a.a(this.b.getApplicationContext(), d);
            }
            b(context);
            this.c.a(str, Long.valueOf(this.c.b(str).longValue() + 1));
        } catch (Throwable th) {
        }
    }

    private void a(long j2) {
        try {
            this.c.a(g, Long.valueOf(j2));
        } catch (Throwable th) {
        }
    }

    private void b(Context context) {
        try {
            if ((this.i == 0 || this.i <= System.currentTimeMillis()) && !a(this.h, System.currentTimeMillis())) {
                com.baidu.mobads.container.d.b.a().a(new ak(this, context));
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        ai aiVar;
        CameraManager cameraManager;
        DhcpInfo dhcpInfo;
        try {
            long jLongValue = this.c.b(j).longValue();
            try {
                by.a aVarA = by.a.a(context).a(455).a(k, "" + jLongValue).a(m, "" + this.c.b(m).longValue()).a("ed", "" + this.c.b("ed").longValue()).a(p, "" + this.c.b(p).longValue()).a(o, "" + this.c.b(o).longValue()).a(s, "" + this.c.b(s).longValue()).a(k, "" + jLongValue).a(v, "" + d()).a(x, "" + Runtime.getRuntime().availableProcessors());
                String strF = f();
                if (!TextUtils.isEmpty(strF)) {
                    aVarA.a(w, u.a(strF));
                }
                WifiManager wifiManager = (WifiManager) context.getSystemService(com.baidu.mobads.container.util.e.a.a);
                if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
                    aiVar = this;
                } else {
                    aiVar = this;
                    try {
                        aVarA.a(y, u.a(aiVar.a(dhcpInfo.dns1)));
                        aVarA.a(z, u.a(aiVar.a(dhcpInfo.dns2)));
                    } catch (Throwable th) {
                        return;
                    }
                }
                if (x.a(aiVar.b).a() >= 21 && (cameraManager = (CameraManager) context.getSystemService("camera")) != null) {
                    aVarA.a(A, "" + cameraManager.getCameraIdList().length);
                }
                if (e()) {
                    aVarA.a(B, "1");
                } else {
                    aVarA.a(B, "0");
                }
                aVarA.a("sc", u.a(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso()));
                Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
                StringBuilder sb = new StringBuilder();
                while (it.hasNext()) {
                    sb.append(it.next().getPackageName()).append(com.alipay.sdk.m.s.a.n);
                }
                aVarA.a(u, u.a(sb.toString()));
                aVarA.f();
            } catch (Throwable th2) {
            }
        } catch (Throwable th3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.c.a(j, (Long) 0L);
            this.c.a(m, (Long) 0L);
            this.c.a("ed", (Long) 0L);
            this.c.a(p, (Long) 0L);
            this.c.a(o, (Long) 0L);
            this.c.a(s, (Long) 0L);
            this.h = System.currentTimeMillis();
            a(this.h);
            c();
        } catch (Throwable th) {
        }
    }

    private boolean a(long j2, long j3) {
        long j4 = j2 - j3;
        return j4 < 86400000 && j4 > -86400000 && b(j2) == b(j3);
    }

    private long b(long j2) {
        return (j2 + TimeZone.getDefault().getOffset(j2)) / 86400000;
    }

    public void a(Context context, Intent intent) {
        int intExtra = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
        try {
            if (this.c == null) {
                this.c = new com.baidu.mobads.container.b.a.a(this.b.getApplicationContext(), d);
            }
            if (intExtra > this.l && this.l != -1) {
                a(m, context);
            } else if (intExtra < this.l) {
                a("ed", context);
            }
            this.l = intExtra;
        } catch (Throwable th) {
        }
    }

    private void c() {
        try {
            if (this.h > 0) {
                this.i = (new SimpleDateFormat(Times.YYYY_MM_DD).parse(new SimpleDateFormat(Times.YYYY_MM_DD, Locale.getDefault()).format(new Date())).getTime() + 86400000) - 1;
            }
        } catch (Throwable th) {
        }
    }

    private int d() {
        try {
            Configuration configuration = this.b.getResources().getConfiguration();
            if (configuration.touchscreen != 3) {
                if (configuration.touchscreen != 2) {
                    return 0;
                }
            }
            return 1;
        } catch (Throwable th) {
            return 1;
        }
    }

    private String a(int i) {
        StringBuilder sbAppend = new StringBuilder().append(i & 255).append(".");
        int i2 = i >>> 8;
        StringBuilder sbAppend2 = sbAppend.append(i2 & 255).append(".");
        int i3 = i2 >>> 8;
        return sbAppend2.append(i3 & 255).append(".").append((i3 >>> 8) & 255).toString();
    }

    private boolean e() {
        try {
            return new File("/system/bin/su").exists();
        } catch (Throwable th) {
            return false;
        }
    }

    private String f() {
        String strTrim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    strTrim = "";
                    break;
                }
                if (line.startsWith("Hardware")) {
                    strTrim = line.split(":")[1].trim();
                    break;
                }
            }
            bufferedReader.close();
            return strTrim;
        } catch (Throwable th) {
            return "";
        }
    }
}
