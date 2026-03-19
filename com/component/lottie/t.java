package com.component.lottie;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t {
    private Map<String, List<com.component.lottie.d.c.g>> c;
    private Map<String, ax> d;
    private Map<String, com.component.lottie.d.c> e;
    private List<com.component.lottie.d.g> f;
    private com.component.lottie.b.e<com.component.lottie.d.d> g;
    private com.component.lottie.b.b<com.component.lottie.d.c.g> h;
    private List<com.component.lottie.d.c.g> i;
    private Rect j;
    private float k;
    private float l;
    private float m;
    private boolean n;
    private final be a = new be();
    private final HashSet<String> b = new HashSet<>();
    private int o = 0;

    public void a(Rect rect, float f, float f2, float f3, List<com.component.lottie.d.c.g> list, com.component.lottie.b.b<com.component.lottie.d.c.g> bVar, Map<String, List<com.component.lottie.d.c.g>> map, Map<String, ax> map2, com.component.lottie.b.e<com.component.lottie.d.d> eVar, Map<String, com.component.lottie.d.c> map3, List<com.component.lottie.d.g> list2) {
        this.j = rect;
        this.k = f;
        this.l = f2;
        this.m = f3;
        this.i = list;
        this.h = bVar;
        this.c = map;
        this.d = map2;
        this.g = eVar;
        this.e = map3;
        this.f = list2;
    }

    public void a(String str) {
        com.component.lottie.g.c.b(str);
        this.b.add(str);
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void a(int i) {
        this.o += i;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.o;
    }

    public ArrayList<String> c() {
        return new ArrayList<>(Arrays.asList((String[]) this.b.toArray(new String[this.b.size()])));
    }

    public void b(boolean z) {
        this.a.a(z);
    }

    public be d() {
        return this.a;
    }

    public com.component.lottie.d.c.g a(long j) {
        return this.h.a(j);
    }

    public Rect e() {
        return this.j;
    }

    public float f() {
        return (long) ((p() / this.m) * 1000.0f);
    }

    public float g() {
        return this.k;
    }

    public float h() {
        return this.l;
    }

    public float a(float f) {
        return com.component.lottie.g.f.a(this.k, this.l, f);
    }

    public float b(float f) {
        return (f - this.k) / (this.l - this.k);
    }

    public float i() {
        return this.m;
    }

    public List<com.component.lottie.d.c.g> j() {
        return this.i;
    }

    public List<com.component.lottie.d.c.g> b(String str) {
        return this.c.get(str);
    }

    public com.component.lottie.b.e<com.component.lottie.d.d> k() {
        return this.g;
    }

    public Map<String, com.component.lottie.d.c> l() {
        return this.e;
    }

    public List<com.component.lottie.d.g> m() {
        return this.f;
    }

    public com.component.lottie.d.g c(String str) {
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            com.component.lottie.d.g gVar = this.f.get(i);
            if (gVar.a(str)) {
                return gVar;
            }
        }
        return null;
    }

    public boolean n() {
        return !this.d.isEmpty();
    }

    public Map<String, ax> o() {
        return this.d;
    }

    public float p() {
        return this.l - this.k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.component.lottie.d.c.g> it = this.i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().a("\t"));
        }
        return sb.toString();
    }

    public boolean q() {
        if (n()) {
            Iterator<String> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                if (!this.d.get(it.next()).g()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public Bitmap a(String str, Bitmap bitmap) {
        ax axVar = this.d.get(str);
        if (axVar != null) {
            Bitmap bitmapF = axVar.f();
            if (bitmap != null) {
                bitmap = com.component.lottie.g.g.a(bitmap, axVar.a(), axVar.b());
            }
            axVar.a(bitmap);
            return bitmapF;
        }
        return null;
    }

    public void a(b bVar) {
        if (n() && bVar != null) {
            Iterator<String> it = this.d.keySet().iterator();
            while (it.hasNext()) {
                ax axVar = this.d.get(it.next());
                if (axVar != null && !axVar.g()) {
                    axVar.a(bVar.a(axVar));
                }
            }
        }
    }
}
