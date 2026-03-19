package com.tk.component.listview.c.a;

import android.support.v7.widget.aj;
import android.support.v7.widget.al;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements a {
    @Override // com.tk.component.listview.c.a.a
    public final int a(al.i iVar, View view, aj ajVar, float f) {
        return a(iVar, view, ajVar, a(iVar, ajVar, f));
    }

    @Override // com.tk.component.listview.c.a.a
    public final int a(al.i iVar, View view, aj ajVar, int i) {
        if (ajVar == null) {
            return 0;
        }
        return c(iVar, ajVar, view) - i;
    }

    private static int c(al.i iVar, View view) {
        if (iVar.dm()) {
            return (al.i.an(view) - al.i.ao(view)) / 2;
        }
        return (al.i.al(view) - al.i.am(view)) / 2;
    }

    @Override // com.tk.component.listview.c.a.a
    public final int a(al.i iVar, aj ajVar, float f) {
        int end;
        if (ajVar == null) {
            return 0;
        }
        if (iVar.getClipToPadding()) {
            end = ajVar.dL() + (ajVar.dN() / 2);
        } else {
            end = ajVar.getEnd() / 2;
        }
        return Math.round(end + f);
    }

    @Override // com.tk.component.listview.c.a.a
    public final int c(al.i iVar, aj ajVar, View view) {
        return ajVar.L(view) + (ajVar.P(view) / 2) + c(iVar, view);
    }
}
