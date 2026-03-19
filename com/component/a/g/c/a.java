package com.component.a.g.c;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.component.a.g.c.e;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends e {
    private String a;
    private ImageView b;
    private ImageView c;

    public a(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) {
        super.onCreateView(dVar);
        if (dVar == null) {
            return;
        }
        com.component.a.f.e eVarF = dVar.f();
        if (TextUtils.equals("ad_logo", eVarF.m(""))) {
            a(eVarF);
            Map<View, com.component.a.f.e> mapA = com.component.a.i.n.a(dVar.e());
            for (View view : mapA.keySet()) {
                com.component.a.f.e eVar = mapA.get(view);
                if (TextUtils.equals("ad_logo_image", eVar.m(""))) {
                    this.b = (ImageView) view;
                }
                if (TextUtils.equals("ad_logo_text", eVar.m(""))) {
                    this.c = (ImageView) view;
                }
            }
            a();
        }
    }

    private void a() {
        if (!TextUtils.isEmpty(this.a)) {
            if (this.b != null) {
                this.b.setOnClickListener(new b(this));
            }
            if (this.c != null) {
                this.c.setOnClickListener(new c(this));
            }
        }
    }

    protected void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strE = com.baidu.mobads.container.util.o.e(str);
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("privacy_link", strE);
                com.baidu.mobads.container.util.h.a(this.mAppContext, intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(com.component.a.f.e eVar) {
        this.a = eVar.c().optString("des_url", com.baidu.mobads.container.adrequest.h.g);
    }
}
