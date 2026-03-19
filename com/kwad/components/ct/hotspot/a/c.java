package com.kwad.components.ct.hotspot.a;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.b.d;
import com.kwad.components.ct.home.e;
import com.kwad.components.ct.hotspot.f;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.hotspot.HotspotInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends e {
    private ViewGroup aQe;
    private TextView aQf;
    private TextView aQg;
    private com.kwad.components.ct.hotspot.b aQh;
    private SlidePlayViewPager aok;
    private com.kwad.components.ct.api.a.a.c ayi;
    private final com.kwad.components.ct.hotspot.e aqP = new f() { // from class: com.kwad.components.ct.hotspot.a.c.1
        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void zp() {
            c.this.hide();
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            c.this.show();
        }
    };
    private final com.kwad.components.ct.api.a.a.b ayn = new d() { // from class: com.kwad.components.ct.hotspot.a.c.2
        @Override // com.kwad.components.ct.home.b.d, com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            List<CtAdTemplate> listXc;
            super.c(z, i, i2);
            if (i != 0 || (listXc = c.this.aQh.xc()) == null || listXc.size() <= 0) {
                return;
            }
            c.this.d(com.kwad.components.ct.response.a.a.aY(listXc.get(0)));
            c.this.show();
        }
    };
    private final Runnable aQi = new Runnable() { // from class: com.kwad.components.ct.hotspot.a.c.3
        @Override // java.lang.Runnable
        public final void run() {
            c.this.aQe.setAlpha(1.0f);
            c.this.show();
        }
    };
    private final ViewPager.OnPageChangeListener nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.hotspot.a.c.4
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            int currentItem = c.this.aok.getCurrentItem();
            int i3 = currentItem > i ? currentItem - 1 : currentItem + 1;
            CtAdTemplate ctAdTemplateBR = c.this.aok.bR(currentItem);
            CtAdTemplate ctAdTemplateBR2 = c.this.aok.bR(i3);
            if (ctAdTemplateBR == null || ctAdTemplateBR2 == null) {
                return;
            }
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) && com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                if (bq.isEquals(com.kwad.components.ct.response.a.a.aX(ctAdTemplateBR), com.kwad.components.ct.response.a.a.aX(ctAdTemplateBR2))) {
                    c.this.aQe.setAlpha(1.0f);
                    return;
                } else {
                    float f2 = currentItem > i ? (f - 0.5f) * 2.0f : (0.5f - f) * 2.0f;
                    c.this.aQe.setAlpha(f2 >= 0.0f ? f2 > 1.0f ? 1.0f : f2 : 0.0f);
                    return;
                }
            }
            if (!com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) && !com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                c.this.aQe.setAlpha(0.0f);
                return;
            }
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) && !com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                float f3 = currentItem > i ? (f - 0.5f) * 2.0f : (0.5f - f) * 2.0f;
                c.this.aQe.setAlpha(f3 >= 0.0f ? f3 > 1.0f ? 1.0f : f3 : 0.0f);
            } else {
                if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR) || !com.kwad.components.ct.response.a.a.as(ctAdTemplateBR2)) {
                    return;
                }
                float f4 = currentItem > i ? (0.5f - f) * 2.0f : (f - 0.5f) * 2.0f;
                c.this.aQe.setAlpha(f4 >= 0.0f ? f4 > 1.0f ? 1.0f : f4 : 0.0f);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            CtAdTemplate ctAdTemplateBR = c.this.aok.bR(i);
            if (ctAdTemplateBR == null) {
                return;
            }
            HotspotInfo hotspotInfoAY = com.kwad.components.ct.response.a.a.aY(ctAdTemplateBR);
            CharSequence text = c.this.aQg.getText();
            if (!TextUtils.isEmpty(hotspotInfoAY.name) && !hotspotInfoAY.name.contentEquals(text)) {
                c.this.d(hotspotInfoAY);
                c.this.aQe.setAlpha(0.0f);
            }
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplateBR)) {
                c.this.aQg.post(c.this.aQi);
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aQe = (ViewGroup) findViewById(R.id.ksad_trends_feed_title_info);
        this.aQf = (TextView) findViewById(R.id.ksad_trends_feed_info_text);
        this.aQg = (TextView) findViewById(R.id.ksad_trends_feed_title);
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        IR();
        this.ayi = this.aGP.ayi;
        this.aok = this.aGP.aok;
        this.aQh = (com.kwad.components.ct.hotspot.b) this.ayi.xd();
        this.ayi.a(this.ayn);
        this.aok.addOnPageChangeListener(this.nb);
        this.aGP.aGN.add(this.aqP);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aok.removeOnPageChangeListener(this.nb);
        this.aGP.aGN.remove(this.aqP);
        this.ayi.b(this.ayn);
        this.aQg.removeCallbacks(this.aQi);
    }

    private void IR() {
        int statusBarHeight = this.aGP.aGL + 0;
        if (com.kwad.components.core.u.e.e(getActivity())) {
            statusBarHeight += com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
        }
        if (statusBarHeight > 0) {
            int iJ = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_hot_list_title_margin_top);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aQe.getLayoutParams();
            marginLayoutParams.topMargin = iJ + statusBarHeight;
            this.aQe.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(HotspotInfo hotspotInfo) {
        this.aQg.setText(hotspotInfo.name);
        this.aQf.setText(String.format(this.aQe.getContext().getString(R.string.ksad_trend_title_info_format), Integer.valueOf(hotspotInfo.rank), bq.bD(hotspotInfo.viewCount)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void show() {
        this.aQe.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hide() {
        this.aQe.setVisibility(8);
    }
}
