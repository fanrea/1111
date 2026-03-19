package com.style.widget.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.style.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends j {
    public a(Context context, AbstractData abstractData) {
        super(context, abstractData);
        q();
        r();
        e();
        h();
        s();
        a();
        if (x()) {
            n();
            return;
        }
        j();
        l();
        f();
    }

    @Override // com.style.widget.j
    public void r() {
        if (this.x == null) {
            return;
        }
        this.W = new ImageView(this.w);
        a(this.W, 10000, this.x.getIconUrl());
        this.ah = new TextView(this.w);
        this.ah.setId(10001);
        this.ah.setMaxLines(1);
        this.ah.setEllipsize(TextUtils.TruncateAt.END);
        this.ah.setTextColor(this.aX);
        this.ah.setText(this.x.getTitle());
        this.ar = new ImageView(this.w);
        a(this.ar, 10002, this.x.getImageUrl());
    }
}
