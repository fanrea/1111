package lkxssdk.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class a {
    public final lkxssdk.o.a a;
    public j b;
    public g c;
    public boolean d;

    public a(lkxssdk.o.a aVar) throws lkxssdk.n.f {
        int iA = aVar.a();
        if (iA < 21 || (iA & 3) != 1) {
            throw lkxssdk.n.f.a();
        }
        this.a = aVar;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.a.b(i2, i) : this.a.b(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void a() {
        int i = 0;
        while (i < this.a.a) {
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                lkxssdk.o.a aVar = this.a;
                if (i3 < aVar.b) {
                    if (aVar.b(i, i3) != this.a.b(i3, i)) {
                        this.a.a(i3, i);
                        this.a.a(i, i3);
                    }
                    i3++;
                }
            }
            i = i2;
        }
    }

    public g b() throws lkxssdk.n.f {
        g gVar = this.c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int i3 = this.a.b;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iA = a(i6, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        if (gVarA == null) {
            gVarA = g.a(iA3 ^ 21522, iA ^ 21522);
        }
        this.c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw lkxssdk.n.f.a();
    }

    public j c() throws lkxssdk.n.f {
        j jVar = this.b;
        if (jVar != null) {
            return jVar;
        }
        int i = this.a.b;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return j.b(i2);
        }
        int i3 = i - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        j jVarA = j.a(iA2);
        if (jVarA != null && jVarA.b() == i) {
            this.b = jVarA;
            return jVarA;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        j jVarA2 = j.a(iA);
        if (jVarA2 == null || jVarA2.b() != i) {
            throw lkxssdk.n.f.a();
        }
        this.b = jVarA2;
        return jVarA2;
    }

    public void d() {
        if (this.c == null) {
            return;
        }
        c cVar = c.values()[this.c.c];
        lkxssdk.o.a aVar = this.a;
        cVar.a(aVar, aVar.b);
    }
}
