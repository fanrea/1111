package com.baidu.mobads.container.u;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.util.bv;
import com.component.a.d.b;
import com.component.a.d.c;
import com.component.a.g.d;
import com.component.feed.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d extends d.c {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        if ("splash_trans_card_root".equals(str2) && (view instanceof com.component.a.d.c)) {
            this.a.q = (com.component.a.d.c) view;
            this.a.q.addOnAttachStateChangeListener(new e(this));
            ax axVar = new ax(this.a.c);
            axVar.setImageBitmap(com.component.a.i.f.c((View) this.a.q).a("@res/inter_close"));
            axVar.setOnClickListener(new f(this));
            int iA = bv.a(this.a.c, 26.0f);
            c.a aVar = new c.a(iA, iA);
            int id = this.a.r.getId();
            switch (this.a.l) {
                case 1:
                    aVar.bottomMargin = bv.a(this.a.c, 13.0f);
                    aVar.addRule(2, id);
                    aVar.addRule(7, id);
                    break;
                case 2:
                default:
                    aVar.rightMargin = bv.a(this.a.c, 15.0f);
                    aVar.topMargin = bv.a(this.a.c, 15.0f);
                    aVar.addRule(6, id);
                    aVar.addRule(7, id);
                    break;
                case 3:
                    aVar.topMargin = bv.a(this.a.c, 19.0f);
                    aVar.addRule(3, id);
                    aVar.addRule(14);
                    break;
            }
            this.a.q.addView(axVar, aVar);
            this.a.d.addDspId(this.a.q, 17);
            return;
        }
        if ("splash_trans_card_view".equals(str2) && (view instanceof com.component.a.d.c)) {
            this.a.r = (com.component.a.d.c) view;
            this.a.r.setVisibility(4);
            return;
        }
        if ("splash_trans_card_image_container".equals(str2) && (view instanceof com.component.a.d.c)) {
            this.a.s = (com.component.a.d.c) view;
            if (this.a.n) {
                this.a.x = this.a.d.createSplashShakeView(50, 2, 1, 2, false);
                this.a.x.a(new g(this));
                c.a aVar2 = new c.a(0, 0);
                aVar2.addRule(10);
                aVar2.addRule(14);
                b.C0314b c0314bA = aVar2.a();
                c0314bA.b = 0.7f;
                c0314bA.a = 1.0f;
                c0314bA.h = 0.1f;
                this.a.s.addView(this.a.x, aVar2);
                return;
            }
            return;
        }
        if ("splash_trans_card_icon".equals(str2) && (view instanceof ax)) {
            this.a.t = (ax) view;
            if (this.a.t.a() == null) {
                this.a.t.setImageBitmap(com.component.a.i.f.c((View) this.a.t).a("@res/fallback_icon"));
                return;
            }
            return;
        }
        if ("splash_trans_card_appname".equals(str2) && (view instanceof com.component.a.a.q)) {
            this.a.u = (com.component.a.a.q) view;
            return;
        }
        if ("splash_trans_card_title".equals(str2) && (view instanceof com.component.a.a.q)) {
            this.a.v = (com.component.a.a.q) view;
            if (TextUtils.isEmpty(this.a.v.getText())) {
                this.a.v.setText("点击下方按钮，了解更多内容详情");
                return;
            }
            return;
        }
        if ("splash_trans_card_button".equals(str2) && (view instanceof com.component.a.a.d)) {
            this.a.w = (com.component.a.a.d) view;
        }
    }
}
