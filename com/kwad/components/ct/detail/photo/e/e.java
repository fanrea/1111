package com.kwad.components.ct.detail.photo.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ct.detail.photo.widget.VerticalMarqueeTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends LinearLayout {
    private TextView awr;
    private VerticalMarqueeTextView aws;
    private ImageView dZ;
    private View.OnClickListener hy;

    public e(Context context) {
        this(context, null);
    }

    private e(Context context, AttributeSet attributeSet) {
        super(context, null);
        initView();
    }

    private void initView() {
        m.a(getContext(), R.layout.ksad_content_alliance_photo_more_button_2, this, true);
        this.dZ = (ImageView) findViewById(R.id.ksad_photo_more_button);
        this.awr = (TextView) findViewById(R.id.ksad_photo_more_text_origin);
        this.aws = (VerticalMarqueeTextView) findViewById(R.id.ksad_photo_more_text);
        b.a(this.dZ, new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.e.e.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.hy != null) {
                    e.this.hy.onClick(e.this);
                }
            }
        });
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.hy = onClickListener;
    }

    public final void BB() {
        this.awr.setVisibility(0);
        this.aws.setVisibility(8);
        this.aws.BB();
    }
}
