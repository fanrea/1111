package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.e.a;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Almond {
    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && networkInterface.getName().matches("tun\\d+")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        List<WifiConfiguration> configuredNetworks;
        String str;
        Object objA;
        Object objA2;
        int i = Build.VERSION.SDK_INT;
        if (i < 14) {
            return (TextUtils.isEmpty(Proxy.getHost(context)) || Proxy.getPort(context) == -1) ? false : true;
        }
        if (!TextUtils.isEmpty(System.getProperty("http.proxyHost")) && !TextUtils.equals(System.getProperty("http.proxyPort"), "-1")) {
            return true;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(a.a);
        if (UrsaMajor.a(context, g.d) != 0) {
            return false;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {
                Object objInvoke = null;
                try {
                    configuredNetworks = wifiManager.getConfiguredNetworks();
                } catch (Throwable unused) {
                    configuredNetworks = null;
                }
                if (configuredNetworks != null) {
                    int networkId = connectionInfo.getNetworkId();
                    Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        WifiConfiguration next = it.next();
                        if (next.networkId == networkId) {
                            if (i < 21) {
                                objA = Apricot.a((Class<?>) WifiConfiguration.class, "proxySettings", next);
                                str = "android.net.wifi.WifiConfiguration$ProxySettings";
                            } else {
                                try {
                                    Method methodA = Apricot.a((Class<?>) WifiConfiguration.class, "getProxySettings", (Class<?>[]) new Class[0]);
                                    if (methodA != null) {
                                        objInvoke = methodA.invoke(next, new Object[0]);
                                    }
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                str = "android.net.IpConfiguration$ProxySettings";
                                objA = objInvoke;
                            }
                            Object objA3 = Apricot.a(str, "STATIC");
                            if (objA3 != null && objA3 == objA) {
                                return true;
                            }
                            if (i < 19 || (objA2 = Apricot.a(str, "PAC")) == null || objA2 != objA) {
                                break;
                            }
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}
