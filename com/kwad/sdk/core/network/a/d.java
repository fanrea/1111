package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String strHt = com.kwad.sdk.ip.direct.a.ht(str);
        if (!TextUtils.isEmpty(strHt)) {
            List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName(strHt));
            if (listAsList == null || listAsList.isEmpty()) {
                return SYSTEM.lookup(str);
            }
            com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "inetAddresses:" + listAsList);
            return listAsList;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        return SYSTEM.lookup(str);
    }
}
