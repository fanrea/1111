package com.kwad.components.ct.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.ae;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends FrameLayout {
    private boolean aZB;
    private String aZC;
    private TextView aZD;
    private LottieAnimationView ayp;

    public b(Context context) {
        super(context);
        initView();
    }

    public b(Context context, boolean z) {
        super(context);
        this.aZB = z;
        initView();
    }

    public b(Context context, boolean z, String str) {
        super(context);
        this.aZB = true;
        this.aZC = str;
        initView();
    }

    private void initView() {
        int i;
        inflate(getContext(), R.layout.ksad_content_page_load_more, this);
        TextView textView = (TextView) findViewById(R.id.ksad_loading_tip);
        this.aZD = textView;
        Resources resources = getContext().getResources();
        if (this.aZB) {
            i = R.color.ksad_hale_page_loading_error_title_light_color;
        } else {
            i = R.color.ksad_hale_page_loading_error_title_dark_color;
        }
        textView.setTextColor(resources.getColor(i));
        this.ayp = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
        com.kwad.components.ct.d.a.Jd().b(this.ayp, this.aZB);
        this.ayp.setRepeatMode(1);
        this.ayp.setRepeatCount(-1);
    }

    public final void Cu() {
        if (!this.ayp.isAnimating()) {
            this.ayp.PZ();
        }
        this.ayp.setVisibility(0);
        this.aZD.setVisibility(8);
    }

    private void Ci() {
        if (this.ayp.isAnimating()) {
            this.ayp.Qa();
        }
        this.ayp.setVisibility(8);
    }

    public final void ce(boolean z) {
        String strDr;
        Ci();
        if (!z && !e.isShowTips() && TextUtils.isEmpty(this.aZC)) {
            this.aZD.setVisibility(8);
            return;
        }
        TextView textView = this.aZD;
        if (z) {
            strDr = getContext().getString(R.string.ksad_page_load_more_tip);
        } else if (TextUtils.isEmpty(this.aZC)) {
            strDr = ae.dr(getContext());
        } else {
            strDr = this.aZC;
        }
        textView.setText(strDr);
        this.aZD.setVisibility(0);
    }
}
