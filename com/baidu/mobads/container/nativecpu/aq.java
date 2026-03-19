package com.baidu.mobads.container.nativecpu;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ t b;

    aq(t tVar, a aVar) {
        this.b = tVar;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        com.style.widget.b.i.a(this.b.a, this.a.getPowerUrl()).a();
    }
}
