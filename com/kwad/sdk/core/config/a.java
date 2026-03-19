package com.kwad.sdk.core.config;

import android.text.TextUtils;
import java.net.URI;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static final String[] bwN = {"gifshow.com", "kuaishou.com", "static.yximgs.com"};

    public static boolean dx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URI(str).getHost();
            if (eL(host)) {
                return true;
            }
            return eM(host);
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean eL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : bwN) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean eM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = e.XK().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
