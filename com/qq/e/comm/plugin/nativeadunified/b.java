package com.qq.e.comm.plugin.nativeadunified;

import android.view.View;
import com.qq.e.comm.plugin.callback.biz.ClickCallback;
import com.qq.e.comm.plugin.cz;
import com.qq.e.comm.plugin.f5;
import com.qq.e.comm.plugin.fr;
import com.qq.e.comm.plugin.j6;
import com.qq.e.comm.plugin.kr;
import com.qq.e.comm.plugin.l6;
import com.qq.e.comm.plugin.x5;
import com.qq.e.comm.plugin.zv;
import com.qq.e.comm.util.GDTLogger;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class b implements View.OnClickListener {
    private e a;
    private fr b;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar = this.a;
        if (!eVar.a(eVar.e, view)) {
            GDTLogger.e("点击失败，点击的view不在NativeAdContainer中");
            return;
        }
        String strO = this.a.O();
        l6 l6VarA = new l6.b(this.b).a(strO).a();
        cz czVar = new cz(view.getContext());
        czVar.a(this.b);
        j6.b(l6VarA, czVar);
        zv.a(this.a.e, this.b, strO, view, new kr());
        this.a.a(105, new Object[0]);
        ((ClickCallback) x5.b(this.b.s0(), ClickCallback.class)).O().a();
        i.a(f5.a(this.b));
    }

    public b(e eVar, fr frVar) {
        this.b = frVar;
        this.a = eVar;
    }
}
