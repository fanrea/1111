package com.style.widget.d;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.style.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c extends j {
    public c(Context context, AbstractData abstractData) {
        super(context, abstractData);
        q();
        r();
        e();
        h();
        s();
    }

    @Override // com.style.widget.j
    public void q() {
        if (this.x != null && this.x.getContainerHeight() > 0 && this.x.getContainerWidth() > 0 && this.x != null) {
            this.a = this.x.getContainerWidth() / this.x.getContainerHeight();
        }
    }

    @Override // com.style.widget.j
    public void r() {
        if (this.x == null) {
            return;
        }
        this.ar = new ImageView(this.w);
        a(this.ar, 10002, this.x.getImageUrl());
        this.ah = new TextView(this.w);
        this.ah.setId(10001);
        this.ah.setMaxLines(2);
        this.ah.setEllipsize(TextUtils.TruncateAt.END);
        this.ah.setTextColor(this.aX);
        this.ah.setText(this.x.getTitle());
    }
}
