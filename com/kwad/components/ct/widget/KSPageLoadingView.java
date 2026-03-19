package com.kwad.components.ct.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSPageLoadingView extends KSFrameLayout implements View.OnClickListener {
    private LottieAnimationView aGt;
    private TextView aRY;
    private TextView aRZ;
    private TextView aZA;
    protected boolean aZB;
    private View aZy;
    private ImageView aZz;
    private a asf;
    private LottieAnimationView baL;
    private SceneImpl mSceneImpl;

    public interface a {
        void zP();
    }

    public KSPageLoadingView(Context context) {
        super(context);
        c(null);
    }

    public KSPageLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
    }

    public KSPageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(attributeSet);
    }

    private void c(AttributeSet attributeSet) {
        inflate(getContext(), R.layout.ksad_content_page_loading, this);
        this.aZB = d(attributeSet);
        View viewFindViewById = findViewById(R.id.ksad_error_container);
        this.aZy = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_error_img);
        this.aZz = imageView;
        imageView.setVisibility(0);
        this.aRY = (TextView) findViewById(R.id.ksad_error_title);
        this.aRZ = (TextView) findViewById(R.id.ksad_error_sub_title);
        TextView textView = (TextView) findViewById(R.id.ksad_error_retry_btn);
        this.aZA = textView;
        textView.setOnClickListener(this);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_center_loading_anim);
        this.aGt = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.aGt.setRepeatCount(-1);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.ksad_other_loading_anim);
        this.baL = lottieAnimationView2;
        lottieAnimationView2.setRepeatMode(1);
        this.baL.setRepeatCount(-1);
        Ke();
    }

    protected final void Ke() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View view = this.aZy;
        Resources resources = getContext().getResources();
        if (this.aZB) {
            i = R.color.ksad_page_loading_error_container_light_color;
        } else {
            i = R.color.ksad_page_loading_error_container_dark_color;
        }
        view.setBackgroundColor(resources.getColor(i));
        TextView textView = this.aRY;
        Resources resources2 = getContext().getResources();
        if (this.aZB) {
            i2 = R.color.ksad_page_loading_error_title_light_color;
        } else {
            i2 = R.color.ksad_page_loading_error_title_dark_color;
        }
        textView.setTextColor(resources2.getColor(i2));
        TextView textView2 = this.aRZ;
        Resources resources3 = getContext().getResources();
        if (this.aZB) {
            i3 = R.color.ksad_page_loading_error_sub_title_light_color;
        } else {
            i3 = R.color.ksad_page_loading_error_sub_title_dark_color;
        }
        textView2.setTextColor(resources3.getColor(i3));
        TextView textView3 = this.aZA;
        Resources resources4 = getContext().getResources();
        if (this.aZB) {
            i4 = R.color.ksad_page_loading_error_retry_light_color;
        } else {
            i4 = R.color.ksad_page_loading_error_retry_dark_color;
        }
        textView3.setTextColor(resources4.getColor(i4));
        TextView textView4 = this.aZA;
        if (this.aZB) {
            i5 = R.drawable.ksad_page_loading_error_retry_light_bg;
        } else {
            i5 = R.drawable.ksad_page_loading_error_retry_dark_bg;
        }
        textView4.setBackgroundResource(i5);
        com.kwad.components.ct.d.a.Jd().b(this.aGt, this.aZB);
        com.kwad.components.ct.d.a.Jd().b(this.baL, this.aZB);
    }

    protected boolean d(AttributeSet attributeSet) {
        int i = R.attr.ksad_light_style;
        int[] iArr = {i};
        Arrays.sort(iArr);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i), false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    public void setScene(SceneImpl sceneImpl) {
        this.mSceneImpl = sceneImpl;
    }

    public void setRetryClickListener(a aVar) {
        this.asf = aVar;
    }

    public final void hide() {
        setVisibility(8);
    }

    public final void Fi() {
        LE();
        Js();
        this.aGt.setVisibility(0);
        if (!this.aGt.isAnimating()) {
            this.aGt.PZ();
        }
        setVisibility(0);
    }

    private void Fj() {
        if (this.aGt.isAnimating()) {
            this.aGt.Qa();
        }
        this.aGt.setVisibility(8);
    }

    public final void cc(boolean z) {
        int i;
        Fj();
        LE();
        ImageView imageView = this.aZz;
        Resources resources = getContext().getResources();
        if (this.aZB) {
            i = R.drawable.ksad_page_loading_network_error;
        } else {
            i = R.drawable.ksad_content_network_error;
        }
        imageView.setImageDrawable(resources.getDrawable(i));
        String strDv = ae.dv(getContext());
        this.aRY.setText(strDv);
        this.aRY.setVisibility(0);
        this.aRZ.setText(ae.dw(getContext()));
        this.aRZ.setVisibility(0);
        this.aZA.setText(ae.dA(getContext()));
        this.aZA.setVisibility(0);
        this.aZy.setVisibility(0);
        if (z) {
            ac.dm(getContext());
        }
        setVisibility(0);
        com.kwad.components.ct.e.b.JK().d(this.mSceneImpl, strDv);
    }

    public final void cd(boolean z) {
        Fj();
        LE();
        ImageLoaderProxy.INSTANCE.load(this.aZz, com.kwad.sdk.core.network.idc.a.aaw().fu(this.aZB ? "https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_page_loading_data_error.png" : "https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_no_data_img.png"), new com.kwad.components.core.e.a());
        String strDy = ae.dy(getContext());
        this.aRY.setText(strDy);
        this.aRY.setVisibility(0);
        this.aRZ.setText(ae.dz(getContext()));
        this.aRZ.setVisibility(0);
        this.aZA.setText(ae.dA(getContext()));
        this.aZA.setVisibility(0);
        this.aZy.setVisibility(0);
        if (z) {
            ac.dn(getContext());
        }
        setVisibility(0);
        com.kwad.components.ct.e.b.JK().d(this.mSceneImpl, strDy);
    }

    public final void Lg() {
        Fj();
        LE();
        ImageLoaderProxy.INSTANCE.load(this.aZz, com.kwad.sdk.core.network.idc.a.aaw().fu(this.aZB ? "https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_page_loading_data_limit_error.png" : "https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_no_video_img.png"), new com.kwad.components.core.e.a());
        String string = getContext().getString(R.string.ksad_page_loading_data_limit_error_title);
        this.aRY.setText(string);
        this.aRY.setVisibility(0);
        this.aRZ.setVisibility(8);
        this.aZA.setVisibility(8);
        this.aZy.setVisibility(0);
        setVisibility(0);
        com.kwad.components.ct.e.b.JK().d(this.mSceneImpl, string);
    }

    public final void LB() {
        Fj();
        LE();
        ImageLoaderProxy.INSTANCE.load(this.aZz, com.kwad.sdk.core.network.idc.a.aaw().fu(this.aZB ? "https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_page_loading_data_limit_error.png" : "https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_no_video_img.png"), new com.kwad.components.core.e.a());
        String string = getContext().getString(R.string.ksad_page_loading_no_more_data_error_title);
        this.aRY.setText(string);
        this.aRY.setVisibility(0);
        this.aRZ.setVisibility(8);
        this.aZA.setVisibility(8);
        this.aZy.setVisibility(0);
        setVisibility(0);
        com.kwad.components.ct.e.b.JK().d(this.mSceneImpl, string);
    }

    public final void LC() {
        Fj();
        LE();
        ImageLoaderProxy.INSTANCE.load(this.aZz, com.kwad.sdk.core.network.idc.a.aaw().fu("https://static.yximgs.com/udata/pkg/KSAdSDK/ksad_no_video_img.png"), new com.kwad.components.core.e.a());
        String string = getContext().getString(R.string.ksad_video_no_found);
        this.aRY.setText(string);
        this.aRY.setVisibility(0);
        this.aRZ.setText(getContext().getString(R.string.ksad_click_to_next_video));
        this.aRZ.setVisibility(0);
        this.aZA.setText(getContext().getString(R.string.ksad_watch_next_video));
        this.aZA.setVisibility(0);
        this.aZy.setVisibility(0);
        setVisibility(0);
        com.kwad.components.ct.e.b.JK().d(this.mSceneImpl, string);
    }

    private void Js() {
        this.aZy.setVisibility(8);
    }

    public final void LD() {
        Js();
        Fj();
        if (!this.baL.isAnimating()) {
            this.baL.PZ();
        }
        this.baL.setVisibility(0);
        setVisibility(0);
    }

    private void LE() {
        if (this.baL.isAnimating()) {
            this.baL.Qa();
        }
        this.baL.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.aZA) {
            return;
        }
        if (ao.isNetworkConnected(getContext())) {
            a aVar = this.asf;
            if (aVar != null) {
                aVar.zP();
                return;
            }
            return;
        }
        ac.dm(getContext());
    }
}
