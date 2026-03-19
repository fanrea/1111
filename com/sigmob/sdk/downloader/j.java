package com.sigmob.sdk.downloader;

import com.just.agentweb.AgentWebPermissions;
import com.sigmob.sdk.downloader.core.connection.a;
import java.io.IOException;
import java.net.ProtocolException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j {
    public static final int a = 10;
    static final int b = 307;
    static final int c = 308;

    public static String a(a.InterfaceC0732a connected, int responseCode) throws IOException {
        String strC = connected.c(AgentWebPermissions.ACTION_LOCATION);
        if (strC != null) {
            return strC;
        }
        throw new ProtocolException("Response code is " + responseCode + " but can't find Location field");
    }

    public static boolean a(int code) {
        return code == 301 || code == 302 || code == 303 || code == 300 || code == 307 || code == 308;
    }
}
