package com.bytedance.sdk.component.b.hc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class gb {
    public static final gb an;
    public static final gb b;
    public static final gb c;
    public static final gb cb;
    static final Comparator<String> d;
    public static final gb e;
    public static final gb gb;
    public static final gb h;
    public static final gb hc;
    public static final gb k;
    public static final gb mk;
    public static final gb mq;
    public static final gb tc;
    public static final gb tt;
    public static final gb u;
    public static final gb uo;
    private static final Map<String, gb> yo;
    final String w;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.b.hc.gb.1
            @Override // java.util.Comparator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int iMin = Math.min(str.length(), str2.length());
                for (int i = 4; i < iMin; i++) {
                    char cCharAt = str.charAt(i);
                    char cCharAt2 = str2.charAt(i);
                    if (cCharAt != cCharAt2) {
                        return cCharAt < cCharAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        d = comparator;
        yo = new TreeMap(comparator);
        hc = d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        b = d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        c = d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        u = d("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        an = d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        h = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        gb = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        tt = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        tc = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        mk = d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        mq = d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        uo = d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        k = d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        e = d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        cb = d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public static synchronized gb d(String str) {
        gb gbVar;
        Map<String, gb> map = yo;
        gbVar = map.get(str);
        if (gbVar == null) {
            gbVar = new gb(str);
            map.put(str, gbVar);
        }
        return gbVar;
    }

    static List<gb> d(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(d(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private gb(String str) {
        str.getClass();
        this.w = str;
    }

    private static gb d(String str, int i) {
        return d(str);
    }

    public String d() {
        return this.w;
    }

    public String toString() {
        return this.w;
    }
}
