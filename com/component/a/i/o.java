package com.component.a.i;

import android.view.View;
import java.util.Comparator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements Comparator<View> {
    final /* synthetic */ boolean a;

    o(boolean z) {
        this.a = z;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(View view, View view2) {
        long id = view.getId();
        long id2 = view2.getId();
        if ((id > id2) ^ this.a) {
            return -1;
        }
        return ((id > id2 ? 1 : (id == id2 ? 0 : -1)) < 0) ^ this.a ? 1 : 0;
    }
}
