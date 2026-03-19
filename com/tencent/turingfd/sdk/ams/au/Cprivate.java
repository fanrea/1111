package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.private, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Cprivate extends Equuleus implements Cloneable {
    public static Map<String, String> h = null;
    public static Map<Integer, Integer> i = null;
    public static Map<String, String> j = null;
    public static final /* synthetic */ boolean m = true;
    public long a = 0;
    public boolean b = true;
    public long c = 0;
    public Map<String, String> d = null;
    public Map<Integer, Integer> e = null;
    public long f = 0;
    public Map<String, String> g = null;

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Eridanus eridanus) throws UnsupportedEncodingException {
        eridanus.a(this.a, 0);
        eridanus.a(this.b ? (byte) 1 : (byte) 0, 1);
        eridanus.a(this.c, 2);
        eridanus.a((Map) this.d, 3);
        eridanus.a((Map) this.e, 4);
        eridanus.a(this.f, 5);
        Map<String, String> map = this.g;
        if (map != null) {
            eridanus.a((Map) map, 6);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Cprivate cprivate = (Cprivate) obj;
        return GalacticCore.a(this.a, cprivate.a) && this.b == cprivate.b && GalacticCore.a(this.c, cprivate.c) && this.d.equals(cprivate.d) && this.e.equals(cprivate.e) && GalacticCore.a(this.f, cprivate.f) && this.g.equals(cprivate.g);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Draco draco) {
        this.a = draco.a(this.a, 0, true);
        this.b = draco.a(this.b, 1, true);
        this.c = draco.a(this.c, 2, true);
        this.d = (Map) draco.a((Draco) h, 3, true);
        this.e = (Map) draco.a((Draco) i, 4, true);
        this.f = draco.a(this.f, 5, true);
        this.g = (Map) draco.a((Draco) j, 6, false);
    }

    static {
        HashMap map = new HashMap();
        h = map;
        map.put("", "");
        i = new HashMap();
        i.put(0, 0);
        HashMap map2 = new HashMap();
        j = map2;
        map2.put("", "");
    }
}
