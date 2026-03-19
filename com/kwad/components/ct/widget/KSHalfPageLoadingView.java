package com.kwad.components.ct.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ao;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSHalfPageLoadingView extends FrameLayout implements View.OnClickListener {
    private LottieAnimationView aSa;
    private KSPageLoadingView.a asf;
    private TextView baJ;
    private View baK;

    public KSHalfPageLoadingView(Context context) {
        this(context, null);
    }

    public KSHalfPageLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSHalfPageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(attributeSet);
    }

    private void c(AttributeSet attributeSet) {
        int i;
        inflate(getContext(), R.layout.ksad_content_half_page_loading, this);
        int i2 = R.attr.ksad_light_style;
        int[] iArr = {i2};
        Arrays.sort(iArr);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i2), false);
        typedArrayObtainStyledAttributes.recycle();
        this.baJ = (TextView) findViewById(R.id.ksad_error_tip);
        this.baK = findViewById(R.id.ksad_horizontal_detail_video_related_loading_bg);
        TextView textView = this.baJ;
        Resources resources = getContext().getResources();
        if (z) {
            i = R.color.ksad_hale_page_loading_error_title_light_color;
        } else {
            i = R.color.ksad_hale_page_loading_error_title_dark_color;
        }
        textView.setTextColor(resources.getColor(i));
        this.baJ.setOnClickListener(this);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
        this.aSa = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.aSa.setRepeatCount(-1);
        com.kwad.components.ct.d.a.Jd().b(this.aSa, z);
        setOnClickListener(this);
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        this.asf = aVar;
    }

    public final void hide() {
        setVisibility(8);
    }

    public final void Cu() {
        this.baJ.setVisibility(8);
        this.aSa.setVisibility(0);
        if (!this.aSa.isAnimating()) {
            this.aSa.PZ();
        }
        setVisibility(0);
    }

    private void Jr() {
        if (this.aSa.isAnimating()) {
            this.aSa.Qa();
        }
        this.aSa.setVisibility(8);
    }

    public final void Jt() {
        Jr();
        this.baJ.setText(ae.dB(getContext()));
        this.baJ.setVisibility(0);
        this.baJ.setOnClickListener(this);
        ac.dm(getContext());
        setVisibility(0);
    }

    public final void Ju() {
        Jr();
        this.baJ.setText(ae.dB(getContext()));
        this.baJ.setVisibility(0);
        this.baJ.setOnClickListener(this);
        ac.dn(getContext());
        setVisibility(0);
    }

    public final void Lx() {
        cl(getContext().getString(R.string.ksad_half_page_loading_no_related_tip));
    }

    public final void Ly() {
        cl(getContext().getString(R.string.ksad_half_page_loading_no_comment_tip));
    }

    private void cl(String str) {
        Jr();
        this.baJ.setText(str);
        this.baJ.setVisibility(0);
        this.baJ.setOnClickListener(null);
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.isNetworkConnected(getContext())) {
            KSPageLoadingView.a aVar = this.asf;
            if (aVar != null) {
                aVar.zP();
                return;
            }
            return;
        }
        ac.dm(getContext());
    }

    public final void Lz() {
        this.baK.setVisibility(0);
    }

    public final void LA() {
        this.baK.setVisibility(8);
    }
}
