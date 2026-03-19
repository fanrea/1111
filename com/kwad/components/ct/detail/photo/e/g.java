package com.kwad.components.ct.detail.photo.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends LinearLayout {
    private TextView arI;
    private ImageView dZ;
    private View.OnClickListener hy;

    public g(Context context) {
        this(context, null);
    }

    private g(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.dZ = null;
        this.arI = null;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_comment_button_2, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_photo_comment_button);
        this.dZ = imageView;
        b.a(imageView, new View.OnClickListener() { // from class: com.kwad.components.ct.detail.photo.e.g.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (g.this.hy != null) {
                    g.this.hy.onClick(g.this);
                }
            }
        });
        this.arI = (TextView) findViewById(R.id.ksad_photo_comment_count_text);
    }

    public final void setCommentCount(long j) {
        this.arI.setText(bq.b(j, "评论"));
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.hy = onClickListener;
    }
}
