package com.kwad.components.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KsLogoView extends LinearLayout {
    private boolean ale;
    TextView alf;
    ImageView alg;
    private a alh;
    private SimpleImageLoadingListener jr;

    public interface a {
        void bJ();
    }

    public TextView getTextView() {
        return this.alf;
    }

    public ImageView getIcon() {
        return this.alg;
    }

    public KsLogoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public KsLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsLogoView(Context context, AttributeSet attributeSet, int i) {
        super(m.wrapContextIfNeed(context), attributeSet, i);
        this.jr = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.wG();
                if (KsLogoView.this.alh != null) {
                    KsLogoView.this.alh.bJ();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.alh != null) {
                    KsLogoView.this.alh.bJ();
                }
            }
        };
        init();
    }

    public KsLogoView(Context context, boolean z) {
        super(m.wrapContextIfNeed(context));
        this.jr = new SimpleImageLoadingListener() { // from class: com.kwad.components.core.widget.KsLogoView.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                KsLogoView.this.wG();
                if (KsLogoView.this.alh != null) {
                    KsLogoView.this.alh.bJ();
                }
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                if (KsLogoView.this.alh != null) {
                    KsLogoView.this.alh.bJ();
                }
            }
        };
        if (z) {
            setBackground(getResources().getDrawable(R.drawable.ksad_splash_logo_bg));
        }
        init();
    }

    private void init() {
        m.inflate(getContext(), R.layout.ksad_logo_layout, this);
        this.alf = (TextView) findViewById(R.id.ksad_logo_text);
        this.alg = (ImageView) findViewById(R.id.ksad_logo_icon);
        boolean z = getBackground() == null;
        this.ale = z;
        if (z) {
            this.alg.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_gray));
            this.alf.setTextColor(-6513508);
        } else {
            this.alg.setImageDrawable(getResources().getDrawable(R.drawable.ksad_logo_white));
            this.alf.setTextColor(-1711276033);
        }
    }

    public final void aQ(AdTemplate adTemplate) {
        View viewFindViewById = findViewById(R.id.ksad_logo_container);
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        String str = this.ale ? adInfoEP.adBaseInfo.adGrayMarkIcon : adInfoEP.adBaseInfo.adMarkIcon;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(adInfoEP.adBaseInfo.adSourceDescription)) {
            this.alf.setVisibility(0);
            this.alf.setText(com.kwad.sdk.core.response.b.a.aG(adInfoEP));
            this.alg.setVisibility(0);
            wG();
            a aVar = this.alh;
            if (aVar != null) {
                aVar.bJ();
            }
        } else {
            if (!TextUtils.isEmpty(adInfoEP.adBaseInfo.adSourceDescription)) {
                this.alf.setText(com.kwad.sdk.core.response.b.a.aG(adInfoEP));
                this.alf.setVisibility(0);
            } else {
                this.alf.setVisibility(8);
                this.alf.setText("");
            }
            if (!TextUtils.isEmpty(str)) {
                KSImageLoader.loadFeeImage(this.alg, str, adTemplate, this.jr);
                this.alg.setVisibility(0);
            } else {
                this.alg.setVisibility(8);
                this.alg.setImageDrawable(null);
                a aVar2 = this.alh;
                if (aVar2 != null) {
                    aVar2.bJ();
                }
            }
        }
        viewFindViewById.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wG() {
        this.alg.setImageDrawable(getContext().getResources().getDrawable(this.ale ? R.drawable.ksad_logo_gray : R.drawable.ksad_logo_white));
    }

    public void setLogoLoadFinishListener(a aVar) {
        this.alh = aVar;
    }

    public static Bitmap a(KsLogoView ksLogoView) {
        TextView textView = ksLogoView.getTextView();
        int iCeil = ((ksLogoView.getVisibility() != 0 || textView.getText() == null || textView.getText().length() <= 0) ? 0 : ((int) Math.ceil(textView.getPaint().measureText(textView.getText().toString()))) + textView.getPaddingLeft() + textView.getPaddingRight()) + (ksLogoView.getIcon().getVisibility() == 0 ? com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 18.0f) : 0);
        int iA = com.kwad.sdk.c.a.a.a(ksLogoView.getContext(), 16.0f);
        ksLogoView.measure(iCeil, iA);
        ksLogoView.layout(0, 0, iCeil, iA);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ksLogoView.getWidth(), ksLogoView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0);
        ksLogoView.draw(canvas);
        return bitmapCreateBitmap;
    }
}
