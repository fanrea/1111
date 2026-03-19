package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alipay.sdk.m.u.i;
import java.net.InetAddress;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Scorpius {
    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return (byte) -1;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                return (byte) -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return (byte) 0;
            }
            if (activeNetworkInfo.getType() != 0) {
                return (byte) 3;
            }
            if (Proxy.getDefaultHost() == null) {
                return Proxy.getHost(context) != null ? (byte) 2 : (byte) 1;
            }
            return (byte) 2;
        } catch (Throwable th) {
            String message = th.getMessage();
            return (message == null || !message.contains("ACCESS_NETWORK_STATE")) ? (byte) -3 : (byte) -2;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            String message = th.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE");
        }
    }

    public static String a() {
        Context context;
        Context context2;
        Long lValueOf;
        Long lValueOf2;
        String string;
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            return null;
        }
        synchronized (Ccase.class) {
            context = Ccase.a;
        }
        Network activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetwork();
        if (activeNetwork == null || i < 21) {
            return null;
        }
        try {
            synchronized (Ccase.class) {
                context2 = Ccase.a;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Object objA = Apple.a(networkCapabilities.getClass(), "mTransportTypes", networkCapabilities);
            long j = 0;
            if (objA instanceof Long) {
                lValueOf = (Long) objA;
            } else {
                long j2 = 0;
                for (int i2 = 0; i2 < 64; i2++) {
                    if (networkCapabilities.hasTransport(i2)) {
                        j2 |= 1 << i2;
                    }
                }
                lValueOf = Long.valueOf(j2);
            }
            sb.append(lValueOf);
            sb.append(",");
            Object objA2 = Apple.a(networkCapabilities.getClass(), "mNetworkCapabilities", networkCapabilities);
            if (objA2 instanceof Long) {
                lValueOf2 = (Long) objA2;
            } else {
                for (int i3 = 0; i3 < 64; i3++) {
                    if (networkCapabilities.hasCapability(i3)) {
                        j |= 1 << i3;
                    }
                }
                lValueOf2 = Long.valueOf(j);
            }
            sb.append(lValueOf2);
            LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
            if (linkProperties == null) {
                string = sb.toString();
            } else {
                String interfaceName = linkProperties.getInterfaceName();
                int i4 = Date.a;
                if (interfaceName == null) {
                    interfaceName = "";
                }
                String strReplace = interfaceName.replace(",", "").replace(i.b, "");
                sb.append(",");
                sb.append(strReplace);
                sb.append(",");
                List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                if (!Cimport.a(linkAddresses)) {
                    for (int i5 = 0; i5 < linkAddresses.size(); i5++) {
                        sb.append(linkAddresses.get(i5).getAddress().getHostAddress());
                        if (i5 != linkAddresses.size() - 1) {
                            sb.append(i.b);
                        }
                    }
                }
                sb.append(",");
                List<InetAddress> dnsServers = linkProperties.getDnsServers();
                if (!Cimport.a(dnsServers)) {
                    for (int i6 = 0; i6 < dnsServers.size(); i6++) {
                        sb.append(dnsServers.get(i6).getHostAddress());
                        if (i6 != dnsServers.size() - 1) {
                            sb.append(i.b);
                        }
                    }
                }
                string = sb.toString();
            }
            return string;
        } catch (Throwable unused) {
            return null;
        }
    }
}
