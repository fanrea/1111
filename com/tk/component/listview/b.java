package com.tk.component.listview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.al;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean h(al.i iVar) {
        return iVar instanceof LinearLayoutManager ? ((LinearLayoutManager) iVar).getOrientation() == 1 : !(iVar instanceof StaggeredGridLayoutManager) || ((StaggeredGridLayoutManager) iVar).getOrientation() == 1;
    }
}
