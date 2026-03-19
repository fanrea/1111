package com.kwad.components.ct.detail.photo.newui.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ct.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends LinearLayout {
    private TextView arI;
    private ImageView dZ;

    public a(Context context) {
        this(context, null);
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.dZ = null;
        this.arI = null;
        initView();
    }

    private void initView() {
        m.a(getContext(), R.layout.ksad_content_alliance_func_button_2, this, true);
        this.dZ = (ImageView) findViewById(R.id.ksad_photo_func_button_image);
        this.arI = (TextView) findViewById(R.id.ksad_photo_func_button_text);
    }

    public final void setImageViewMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dZ.getLayoutParams();
        layoutParams.leftMargin = i;
        this.dZ.setLayoutParams(layoutParams);
    }

    public final void setButtonImageResource(int i) {
        g.a(this.dZ, i);
    }

    public final void setButtonImageDrawable(Drawable drawable) {
        this.dZ.setImageDrawable(drawable);
    }

    public final void setButtonText(String str) {
        this.arI.setText(str);
    }
}
