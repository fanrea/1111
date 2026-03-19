package com.bykv.vk.component.ttvideo.mediakit.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DNSServerIP {
    private static final String TAG = "DNSServerIP";
    private static final int UPDATE_PEROID = 300000;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;

    public static void updateDNSServerIP() {
        if (System.currentTimeMillis() - mServerIPTime < 300000) {
            return;
        }
        AVMDLThreadPool.addExecuteTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.mediakit.net.DNSServerIP.1
            @Override // java.lang.Runnable
            public void run() throws UnknownHostException {
                try {
                    InetAddress byName = InetAddress.getByName("whoami.akamai.net");
                    if (byName != null) {
                        String unused = DNSServerIP.mServerIP = byName.getHostAddress();
                        long unused2 = DNSServerIP.mServerIPTime = System.currentTimeMillis();
                    }
                } catch (UnknownHostException unused3) {
                }
            }
        });
    }

    public static String getDNSServerIP() {
        updateDNSServerIP();
        return mServerIP;
    }
}
