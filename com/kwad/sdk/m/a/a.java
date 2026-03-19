package com.kwad.sdk.m.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private final List<b> cjH = new ArrayList();

    public final boolean onBackPressed() {
        Iterator<b> it = this.cjH.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.cjH.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.cjH.add(i, bVar);
        }
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.cjH.remove(bVar);
        }
    }
}
