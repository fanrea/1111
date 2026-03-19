package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar hC;
    private View hD;
    private Context mContext;

    public DrawDownloadProgressBar(Context context) {
        super(context);
        B(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawDownloadProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_download_bar, this);
        this.hC = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        View viewFindViewById = findViewById(R.id.ksad_download_progress_cover);
        this.hD = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public void setTextSize(int i) {
        this.hC.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), i));
    }

    public void setTextColor(int i) {
        this.hC.setTextColor(i);
    }

    public final void e(String str, int i) {
        if (i == 0 || i == getMax()) {
            this.hD.setVisibility(0);
        } else {
            this.hD.setVisibility(8);
        }
        this.hC.e(str, i);
    }

    public int getMax() {
        return this.hC.getMax();
    }
}
