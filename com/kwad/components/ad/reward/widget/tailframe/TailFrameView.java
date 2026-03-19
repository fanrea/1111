package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TailFrameView extends KSFrameLayout {
    private com.kwad.components.ad.reward.widget.tailframe.a GC;
    private g vb;

    public TailFrameView(Context context) {
        super(context);
    }

    public TailFrameView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TailFrameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TailFrameView(Context context, View view) {
        super(context, view);
    }

    public void setCallerContext(g gVar) {
        this.vb = gVar;
    }

    public final void a(com.kwad.components.ad.reward.widget.tailframe.b bVar) {
        this.GC.setCallerContext(this.vb);
        this.GC.a(this.vb.mAdTemplate, this.vb.mReportExtData, bVar);
    }

    public final void a(Context context, boolean z, boolean z2) {
        f(z, z2);
        this.GC.B(context);
        this.GC.f(z, z2);
        addView(this.GC.lw(), -1, -1);
    }

    public final void le() {
        this.GC.le();
    }

    public final void destroy() {
        com.kwad.components.ad.reward.widget.tailframe.a aVar = this.GC;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    private void f(boolean z, boolean z2) {
        if (this.GC != null) {
            return;
        }
        if (z) {
            if (z2) {
                this.GC = new d();
                return;
            } else {
                this.GC = new c();
                return;
            }
        }
        if (z2) {
            this.GC = new b();
        } else {
            this.GC = new a();
        }
    }

    static class d extends com.kwad.components.ad.reward.widget.tailframe.a {
        public d() {
            super(R.layout.ksad_video_tf_view_portrait_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.P(this.mAdTemplate)) {
                this.Gs.setBackground(null);
                this.Gt.setVisibility(8);
                this.mLogoView.setVisibility(8);
            }
            KSImageLoader.loadImage(this.Gt, com.kwad.sdk.core.response.b.a.Y(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class c extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.e {
        private View GG;

        public c() {
            super(R.layout.ksad_video_tf_view_portrait_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.GG = this.Gs.findViewById(R.id.video_cover);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            if (e.P(this.mAdTemplate)) {
                this.GG.setVisibility(8);
                this.mLogoView.setVisibility(8);
                this.Gs.setBackground(null);
            }
            lA();
        }

        private void lA() {
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = com.kwad.sdk.core.response.b.a.bb(this.mAdInfo);
            int i = materialFeatureBb.width;
            int i2 = materialFeatureBb.height;
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(this.Gs.getContext());
            int i3 = (int) (screenWidth * (i2 / i));
            ViewGroup.LayoutParams layoutParams = this.Gt.getLayoutParams();
            layoutParams.width = screenWidth;
            layoutParams.height = i3;
            KSImageLoader.loadImage(this.Gt, materialFeatureBb.coverUrl, this.mAdTemplate);
        }
    }

    static class b extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.e {
        private ImageView GD;
        private ImageView GE;
        private ImageView GF;

        public b() {
            super(R.layout.ksad_video_tf_view_landscape_vertical);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void B(Context context) {
            super.B(context);
            this.GD = (ImageView) this.Gs.findViewById(R.id.ksad_video_thumb_left);
            this.GE = (ImageView) this.Gs.findViewById(R.id.ksad_video_thumb_mid);
            this.GF = (ImageView) this.Gs.findViewById(R.id.ksad_video_thumb_right);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            lA();
        }

        private void lA() {
            KSImageLoader.loadImage(this.GD, com.kwad.sdk.core.response.b.a.Y(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.GE, com.kwad.sdk.core.response.b.a.Y(this.mAdInfo), this.mAdTemplate);
            KSImageLoader.loadImage(this.GF, com.kwad.sdk.core.response.b.a.Y(this.mAdInfo), this.mAdTemplate);
        }
    }

    static class a extends com.kwad.components.ad.reward.widget.tailframe.a implements com.kwad.sdk.widget.e {
        public a() {
            super(R.layout.ksad_video_tf_view_landscape_horizontal);
        }

        @Override // com.kwad.components.ad.reward.widget.tailframe.a
        public final void a(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.components.ad.reward.widget.tailframe.b bVar) {
            super.a(adTemplate, jSONObject, bVar);
            KSImageLoader.loadImage(this.Gt, com.kwad.sdk.core.response.b.a.Y(this.mAdInfo), this.mAdTemplate);
        }
    }
}
