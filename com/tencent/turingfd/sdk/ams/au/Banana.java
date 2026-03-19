package com.tencent.turingfd.sdk.ams.au;

import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Banana {
    public final String a;
    public final URL b;
    public final String c = "GET";
    public final Map<String, String> d;
    public final int e;
    public final int f;
    public final boolean g;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Banana$do, reason: invalid class name */
    public static class Cdo {
        public final String a;
        public final URL b;
        public final HashMap<String, String> c;
        public int d;
        public int e;
        public boolean f;

        public Cdo(String str) throws MalformedURLException {
            HashMap<String, String> map = new HashMap<>();
            this.c = map;
            this.d = 10000;
            this.e = 10000;
            this.f = true;
            this.a = str;
            this.b = new URL(str);
            map.put("Content-Type", MediaTypeUtils.APPLICATION_JSON);
        }
    }

    public Banana(Cdo cdo) {
        this.a = cdo.a;
        this.b = cdo.b;
        this.d = cdo.c;
        this.e = cdo.d;
        this.f = cdo.e;
        this.g = cdo.f;
    }
}
