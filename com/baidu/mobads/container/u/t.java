package com.baidu.mobads.container.u;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.component.a.g.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class t extends d.c {
    final /* synthetic */ p a;

    t(p pVar) {
        this.a = pVar;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        if ("splash_ad_image".equals(str2) && (view instanceof ImageView)) {
            this.a.e = (ImageView) view;
            this.a.e.setOnTouchListener(new u(this));
        }
        if ("splash_bg".equals(str2) && (view instanceof ImageView)) {
            ImageView imageView = (ImageView) view;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            String strB = this.a.b();
            if (TextUtils.isEmpty(strB) || com.baidu.mobads.container.util.d.d.a(this.a.mAppContext).b(imageView, strB) == null) {
                com.component.b.a.a().a(imageView, "bg_hot_recommendation");
            }
        }
    }
}
