package com.style.widget;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class r implements View.OnClickListener {
    final /* synthetic */ j a;

    r(j jVar) {
        this.a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        com.style.widget.b.i.a(this.a.w, this.a.x.getPowerUrl()).a();
    }
}
