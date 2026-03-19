package com.style.widget.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.a.d;
import com.style.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends j {
    public a(Context context, d dVar) {
        super(context, dVar);
        q();
        r();
        e();
        h();
        s();
        if (x()) {
            n();
        } else {
            j();
            l();
            f();
        }
        a();
    }

    @Override // com.style.widget.j
    public void q() {
        if (this.x != null && this.x.getContainerHeight() > 0 && this.x.getContainerWidth() > 0 && this.x != null) {
            this.e = this.x.getContainerWidth() / this.x.getContainerHeight();
        }
    }

    @Override // com.style.widget.j
    public void r() {
        if (this.x == null) {
            return;
        }
        this.W = new ImageView(this.w);
        a(this.W, 10000, this.x.getIconUrl());
        this.ah = new TextView(this.w);
        this.ah.setMaxLines(1);
        this.ah.setId(10001);
        this.ah.setEllipsize(TextUtils.TruncateAt.END);
        this.ah.setTextColor(this.aX);
        this.ah.setText(this.x.getTitle());
        this.ar = new ImageView(this.w);
        a(this.ar, 10002, this.x.getMultiPicUrls().get(0));
        this.aA = new ImageView(this.w);
        a(this.aA, 10003, this.x.getMultiPicUrls().get(1));
        this.aH = new ImageView(this.w);
        a(this.aH, 10004, this.x.getMultiPicUrls().get(2));
        this.aw = 42;
        this.az = 0;
        this.aE = 42;
        this.aF = 2;
        this.aG = 0;
        this.aL = 42;
        this.aM = 2;
        if (x()) {
            this.aw = 0;
        }
    }
}
