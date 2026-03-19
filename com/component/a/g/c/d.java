package com.component.a.g.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.component.a.g.c.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends e {
    public d(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public View onPrepareView(View view, com.component.a.f.e eVar) {
        if (eVar == null) {
            return super.onPrepareView(view, null);
        }
        String strM = eVar.m("");
        if (TextUtils.equals("barrage_view", strM)) {
            return new com.component.a.a.a(this.mAppContext, eVar);
        }
        if (TextUtils.equals("dynamic_barrage", strM)) {
            return new com.component.a.a.b(this.mAppContext, eVar);
        }
        return super.onPrepareView(view, eVar);
    }
}
