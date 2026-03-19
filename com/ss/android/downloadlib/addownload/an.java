package com.ss.android.downloadlib.addownload;

import android.net.Uri;
import android.text.TextUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class an {
    private final ConcurrentHashMap<String, String> d;
    private final ConcurrentHashMap<String, String> hc;

    public static class d {
        private static an d = new an();
    }

    public static an d() {
        return d.d;
    }

    private an() {
        this.d = new ConcurrentHashMap<>();
        this.hc = new ConcurrentHashMap<>();
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.hc.containsKey(str2)) {
            return;
        }
        this.hc.put(str2, str);
    }

    public String d(String str) {
        if (TextUtils.isEmpty(str) || this.hc.isEmpty() || !this.hc.containsKey(str)) {
            return null;
        }
        String strB = b(str);
        if (this.d.containsValue(strB)) {
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strB)) {
                    String str2 = this.hc.get(entry.getKey());
                    this.hc.put(str, str2);
                    if (!this.d.containsKey(str)) {
                        this.d.put(str, strB);
                    }
                    return str2;
                }
            }
        }
        return this.hc.get(str);
    }

    public String d(com.ss.android.d.d.b.b bVar) throws NoSuchAlgorithmException {
        String strB = b(bVar.d());
        if (strB == null || TextUtils.isEmpty(strB)) {
            return null;
        }
        String strU = com.ss.android.socialbase.downloader.e.an.u(strB + bVar.he());
        this.hc.put(bVar.d(), strU);
        return strU;
    }

    private String b(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.d.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
            return null;
        }
    }

    public void hc(String str) {
        Iterator<Map.Entry<String, String>> it = this.hc.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.d.remove(next.getKey());
            }
        }
    }
}
