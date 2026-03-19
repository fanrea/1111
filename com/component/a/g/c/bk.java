package com.component.a.g.c;

import android.content.Context;
import android.view.View;
import com.component.a.g.c.e;
import com.style.widget.viewpager2.PagerIndicatorView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bk extends e {
    private static final String a = "indicator_view";

    public bk(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar != null && a.equals(eVar.m(""))) {
            return new PagerIndicatorView(this.mAppContext, eVar).setIndicatorStyle(3).setProgressMode(true);
        }
        return super.onPrepareView(view, eVar);
    }
}
