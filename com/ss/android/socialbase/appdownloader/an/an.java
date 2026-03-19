package com.ss.android.socialbase.appdownloader.an;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.mq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private static Boolean d;

    public static boolean d() {
        Boolean bool = d;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static synchronized void d(Context context) {
        if (d == null) {
            d = Boolean.valueOf((hc() || hc(context) || b(context) || !c(context) || b() || u(context)) ? false : true);
        }
    }

    public static boolean hc() {
        if (c() == 0) {
            return true;
        }
        return u();
    }

    public static boolean hc(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private static int c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, d("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str == null || !"0".equals(str)) ? 1 : 0;
    }

    private static boolean u() {
        String[] strArr = {d("2f7362696e2f7375"), d("2f73797374656d2f62696e2f7375"), d("2f73797374656d2f7862696e2f7375"), d("2f646174612f6c6f63616c2f7862696e2f7375"), d("2f646174612f6c6f63616c2f62696e2f7375"), d("2f73797374656d2f73642f7862696e2f7375"), d("2f73797374656d2f62696e2f6661696c736166652f7375"), d("2f646174612f6c6f63616c2f7375")};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    public static boolean c(Context context) {
        int simState;
        try {
            simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        } catch (Throwable unused) {
        }
        return (simState == 1 || simState == 0) ? false : true;
    }

    public static boolean b() throws UnknownHostException {
        try {
            InetAddress.getByName(d("3132372e302e302e31"));
            new Socket(d("3132372e302e302e31"), Integer.parseInt(d("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean u(Context context) {
        return an() || an(context);
    }

    private static boolean an() throws IOException {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(d("636f6d2e73617572696b2e737562737472617465")) || str.contains(d("58706f7365644272696467652e6a6172")) || str.contains(d("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean an(Context context) {
        List listAsList = Arrays.asList(d("64652e726f62762e616e64726f69642e78706f736564"), d("636f6d2e746f706a6f686e77752e6d616769736b"), d("696f2e76612e6578706f736564"), d("636f6d2e77696e642e636f74746572"), d("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), d("6d652e7765697368752e657870"), d("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e) {
                mq.d(e);
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }

    private static String d(String str) {
        return com.ss.android.socialbase.downloader.e.an.d(str);
    }
}
