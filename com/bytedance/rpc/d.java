package com.bytedance.rpc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RpcDataBuilder.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private Map<String, String> a = new HashMap(4);
    private Map<String, String> b = new HashMap(4);
    private List<com.bytedance.rpc.serialize.c> c = new ArrayList(2);
    private Map<String, String> d = new HashMap(4);
    private Map<String, File> e = new HashMap(4);

    public d a(byte[] bArr, String str) {
        this.c.clear();
        return a(bArr, str, null);
    }

    public d a(byte[] bArr, String str, String str2) {
        return a(bArr, str, str2, null);
    }

    public d a(byte[] bArr, String str, String str2, String str3) {
        this.c.add(new com.bytedance.rpc.serialize.c(bArr, str, str2, str3));
        return this;
    }

    public d a(String str, String str2) {
        com.bytedance.sdk.djx.proguard3.c.b.a(this.a, str, str2);
        return this;
    }

    public d a(Map<String, String> map) {
        com.bytedance.sdk.djx.proguard3.c.b.a(this.a, map);
        return this;
    }

    public d b(Map<String, String> map) {
        com.bytedance.sdk.djx.proguard3.c.b.a(this.b, map);
        return this;
    }

    public d c(Map<String, String> map) {
        com.bytedance.sdk.djx.proguard3.c.b.a(this.d, map);
        return this;
    }

    public d d(Map<String, File> map) {
        if (map != null && map.size() > 0) {
            this.e.putAll(map);
        }
        return this;
    }

    public a a() {
        return new a();
    }

    d a(com.bytedance.rpc.serialize.c cVar) {
        this.c.clear();
        if (cVar != null) {
            this.c.add(cVar);
        }
        return this;
    }

    d a(a aVar) {
        a(aVar.a);
        b(aVar.b);
        d(aVar.e);
        c(aVar.d);
        if (aVar.c.size() > 1 || (aVar.c.size() == 1 && ((com.bytedance.rpc.serialize.c) aVar.c.get(0)).c() > 0)) {
            this.c.addAll(aVar.c);
        }
        return this;
    }

    Map<String, String> b() {
        return this.a;
    }

    Map<String, String> c() {
        return this.b;
    }

    Map<String, String> d() {
        return this.d;
    }

    /* compiled from: RpcDataBuilder.java */
    public static class a {
        private Map<String, String> a;
        private Map<String, String> b;
        private List<com.bytedance.rpc.serialize.c> c;
        private Map<String, String> d;
        private Map<String, File> e;

        private a(d dVar) {
            this.a = dVar.a;
            this.b = dVar.b;
            this.c = dVar.c;
            this.d = dVar.d;
            this.e = dVar.e;
        }

        public Map<String, String> a() {
            return this.a;
        }

        public Map<String, String> b() {
            return this.b;
        }

        public List<com.bytedance.rpc.serialize.c> c() {
            return this.c;
        }

        public String toString() {
            return "SerializerData{mHeaders=" + this.a + ", mQueries=" + this.b + ", mData=" + this.c + ", mFields=" + this.d + ", mFiles=" + this.e + '}';
        }
    }
}
