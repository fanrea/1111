package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Cantaloupe extends Equuleus implements Cloneable {
    public static Cprivate d = new Cprivate();
    public static final /* synthetic */ boolean e = true;
    public int a = 0;
    public Cprivate b = null;
    public long c = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Eridanus eridanus) {
        eridanus.a(this.a, 0);
        Cprivate cprivate = this.b;
        if (cprivate != null) {
            eridanus.a((Equuleus) cprivate, 1);
        }
        eridanus.a(this.c, 2);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (e) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Cantaloupe cantaloupe = (Cantaloupe) obj;
        return GalacticCore.a(this.a, cantaloupe.a) && this.b.equals(cantaloupe.b) && GalacticCore.a(this.c, cantaloupe.c);
    }

    public int hashCode() throws Exception {
        try {
            throw new Exception("");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Draco draco) {
        this.a = draco.a(this.a, 0, true);
        this.b = (Cprivate) draco.a((Equuleus) d, 1, false);
        this.c = draco.a(this.c, 2, true);
    }
}
