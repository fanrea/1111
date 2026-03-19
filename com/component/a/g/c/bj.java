package com.component.a.g.c;

import android.content.Context;
import android.view.View;
import com.component.a.g.c.e;
import com.component.feed.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bj extends e {
    public bj(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        try {
            if ("gaussianblur_view".equals(eVar.m(""))) {
                com.component.feed.ax axVarA = new ax.a(this.mAppContext).a(ax.b.RoundRect).a(new float[]{15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f, 15.0f}).b(true).b(9.5f).a();
                com.baidu.mobads.container.util.d.d.a(this.mAppContext).b(axVarA, this.mAdInfo.getMainPictureUrl());
                return axVarA;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onPrepareView(view, eVar);
    }
}
