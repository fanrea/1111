package com.component.lottie.d.b;

import com.component.lottie.af;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i implements c {
    private final String a;
    private final a b;
    private final boolean c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a a(int i) {
            switch (i) {
                case 1:
                    return MERGE;
                case 2:
                    return ADD;
                case 3:
                    return SUBTRACT;
                case 4:
                    return INTERSECT;
                case 5:
                    return EXCLUDE_INTERSECTIONS;
                default:
                    return MERGE;
            }
        }
    }

    public i(String str, a aVar, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = z;
    }

    public String a() {
        return this.a;
    }

    public a b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.component.lottie.d.b.c
    public com.component.lottie.a.a.d a(af afVar, com.component.lottie.d.c.a aVar) {
        if (!afVar.c()) {
            com.component.lottie.g.c.b("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new com.component.lottie.a.a.m(this);
    }

    public String toString() {
        return "MergePaths{mode=" + this.b + '}';
    }
}
