package com.tencent.turingfd.sdk.ams.au;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Fig extends Equuleus {
    public static ArrayList<Filbert> e;
    public long a = 0;
    public int b = 0;
    public ArrayList<Filbert> c = null;
    public int d = 0;

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Eridanus eridanus) throws UnsupportedEncodingException {
        eridanus.a(this.a, 0);
        eridanus.a(this.b, 1);
        eridanus.a((Collection) this.c, 2);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Equuleus
    public void a(Draco draco) {
        this.a = draco.a(this.a, 0, true);
        this.b = draco.a(this.b, 1, true);
        if (e == null) {
            ArrayList<Filbert> arrayList = new ArrayList<>();
            e = arrayList;
            arrayList.add(new Filbert());
        }
        this.c = (ArrayList) draco.a((Draco) e, 2, true);
    }
}
