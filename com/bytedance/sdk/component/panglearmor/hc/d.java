package com.bytedance.sdk.component.panglearmor.hc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.panglearmor.an;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static volatile d d;
    private ConnectivityManager b;
    private volatile int c = -1;
    private volatile int hc;
    private TelephonyManager u;

    public d() {
        this.b = null;
        this.u = null;
        Context contextC = an.c();
        if (contextC != null) {
            this.b = (ConnectivityManager) contextC.getSystemService("connectivity");
            this.u = (TelephonyManager) contextC.getSystemService("phone");
        }
        d((int) (((u.d().b() / 1000) / 60) / 60));
    }

    public static d d() {
        if (d == null) {
            synchronized (d.class) {
                if (d == null) {
                    d = new d();
                }
            }
        }
        return d;
    }

    private static boolean d(ConnectivityManager connectivityManager) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void d(int i) {
        if (i <= 0) {
            this.hc = 1;
        } else if (i > 168) {
            this.hc = 168;
        } else {
            this.hc = i;
        }
    }

    public int[] hc() {
        int[] iArr = new int[this.hc];
        LinkedList<JSONObject> linkedListD = hc.d().d("sp_net");
        if (linkedListD != null && linkedListD.size() > 0) {
            int iOptLong = (int) (((linkedListD.getLast().optLong("t", 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = linkedListD.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long jOptLong = next.optLong("t", 0L);
                int iOptInt = next.optInt("val", 0);
                int i = iOptLong - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.hc) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int[] b() {
        int[] iArr = new int[this.hc];
        LinkedList<JSONObject> linkedListD = hc.d().d("sp_screen");
        if (linkedListD != null && linkedListD.size() > 0) {
            int iCurrentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            Iterator<JSONObject> it = linkedListD.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long jOptLong = next.optLong("t", 0L);
                int iOptInt = next.optInt("val", 0);
                int i = iCurrentTimeMillis - ((int) (((jOptLong / 1000) / 60) / 60));
                if (i >= 0 && i < this.hc) {
                    iArr[i] = iOptInt;
                }
            }
        }
        return iArr;
    }

    public int c() {
        this.c = an();
        return this.c;
    }

    private int an() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.b;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.b.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.b.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean zHasTransport = networkCapabilities.hasTransport(0);
                        boolean zHasTransport2 = networkCapabilities.hasTransport(1);
                        if (d(this.b) && zHasTransport2) {
                            return 3;
                        }
                        if (zHasTransport2) {
                            return 1;
                        }
                        return zHasTransport ? 2 : 0;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return d(this.b) ? 3 : 1;
                    }
                    if (type == 0) {
                        return 2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public int u() {
        TelephonyManager telephonyManager = this.u;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }
}
