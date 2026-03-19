package com.android.gdt.qone.s;

import android.util.Base64;
import com.android.gdt.qone.af.c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class b {
    public static final ConcurrentHashMap a;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        a = concurrentHashMap;
        concurrentHashMap.put(a.a("bGVkb20udG5lY25ldC5zeXM=", concurrentHashMap, a.a("aWVtaXEubml3LnRuZWNuZXQuc3lz", concurrentHashMap, a.a("c2oudG5pcnByZWduaWYvdHNldGFsL2Jldy1rZHNpZW1pcS9pZW1pcS9tb2MucXEuZWxpZmNpdGF0cy8vOnNwdHRo", concurrentHashMap, a.a("Y3JTZElub2NhZWI=", concurrentHashMap, a.a("S0RTaWVtaVEua2RzLmllbWlxLnRuZWNuZXQubW9j", concurrentHashMap, a.a("dHNvaC5kbGl1Yi5vcg==", concurrentHashMap, a.a("ZW1hbi50Y3Vkb3JwLm9y", concurrentHashMap, a.a("cmVydXRjYWZ1bmFtLnRjdWRvcnAub3I=", concurrentHashMap, a.a("bGV2ZWxfaXBhX3RzcmlmLnRjdWRvcnAub3I=", concurrentHashMap, a.a("ZWNpdmVkLnRjdWRvcnAub3I=", concurrentHashMap, a.a("ZG5hcmIudGN1ZG9ycC5vcg==", concurrentHashMap, a.a("ZHJhb2IudGN1ZG9ycC5vcg==", concurrentHashMap, a.a("ZElkaW9yZG5h", concurrentHashMap, a.a("aWVtaVFldGFkcHU=", concurrentHashMap, a.a("ZGlj", concurrentHashMap, a.a("Y2Ft", concurrentHashMap, a.a("aXNtaQ==", concurrentHashMap, a.a("aWVtaQ==", concurrentHashMap, a.a("ZGlhbw==", concurrentHashMap, a.a("MnZfaWVtaXE=", concurrentHashMap, a.a("MV9JRU1JUV9OT0NBRUI=", concurrentHashMap, a.a("QVRHTkVEX0lFTUlR", concurrentHashMap, a.a("NjNpZW1pcQ==", concurrentHashMap, a.a("aWVtaXE=", concurrentHashMap, 0, 1), 2), 3), 4), 5), 6), 7), 8), 9), 10), 11), 12), 13), 14), 15), 16), 17), 18), 19), 20), 21), 22), 23), 24), a("ZGl1Zy50bmVjbmV0LnN5cw=="));
    }

    public static String a(String str) {
        try {
            return new StringBuilder(new String(Base64.decode(str, 2))).reverse().toString();
        } catch (Exception e) {
            c.a(e);
            return "";
        }
    }

    public static String a(int i) {
        String str = (String) a.get(Integer.valueOf(i));
        return str == null ? "" : str;
    }
}
