package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public static d fk(Context context) {
        return A(context, false);
    }

    private static d A(Context context, boolean z) {
        return b(context, false, false);
    }

    private static d b(Context context, boolean z, boolean z2) {
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String strHP = b.hP(((WifiManager) context.getApplicationContext().getSystemService(com.baidu.mobads.container.util.e.a.a)).getDhcpInfo().gateway);
            String strJm = !z ? a.jm("timeout 5 ip neigh show " + strHP) : "";
            if (z || TextUtils.isEmpty(strJm)) {
                strJm = KwaiIpNeigh.j(strHP, false);
            }
            String strJo = b.jo(strJm);
            return new d(strJo, !TextUtils.isEmpty(strJo), strJm);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }
}
