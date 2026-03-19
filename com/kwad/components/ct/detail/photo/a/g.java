package com.kwad.components.ct.detail.photo.a;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bq;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private View aqR;
    private TextView aqS;
    private TextView aqT;
    private ViewGroup aqU;
    private CtAdTemplate mAdTemplate;
    private Handler mHandler;
    private boolean aqV = false;
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.a.g.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (g.this.aqV) {
                g.this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ct.detail.photo.a.g.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.aqU.setVisibility(8);
                    }
                }, 1000L);
            }
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            if (g.this.aqV) {
                g.this.mHandler.removeCallbacksAndMessages(null);
            }
        }
    };
    private final ViewPager.OnPageChangeListener nb = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.detail.photo.a.g.2
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i, float f, int i2) {
            CtAdTemplate currentData;
            if (g.this.aop.abR == g.this.aok.getRealPosition() || (currentData = g.this.aok.getCurrentData()) == null) {
                return;
            }
            int currentItem = g.this.aok.getCurrentItem();
            if (g.this.aop.abR != (currentItem > i ? g.this.aok.bO(currentItem - 1) : g.this.aok.bO(currentItem + 1))) {
                g.this.zq();
                return;
            }
            if (!com.kwad.components.ct.response.a.a.as(currentData)) {
                currentData = currentItem > i ? g.this.c(currentData) : g.this.b(currentData);
            }
            if (currentData == null || !bq.isEquals(com.kwad.components.ct.response.a.a.aX(currentData), com.kwad.components.ct.response.a.a.aX(g.this.mAdTemplate))) {
                g.this.bx(currentItem > i ? "上一个热点" : "下一个热点");
            } else {
                g.this.zq();
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mHandler = new Handler();
        this.aqU = (ViewGroup) findViewById(R.id.ksad_photo_trend_container);
        this.aqT = (TextView) findViewById(R.id.ksad_content_alliance_trend_title);
        this.aqS = (TextView) findViewById(R.id.ksad_content_alliance_trend_type);
        this.aqR = findViewById(R.id.ksad_trend_feed_margin);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aqR.setVisibility(0);
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aok = this.aop.aok;
        this.aqU.setVisibility(8);
        if (zr()) {
            this.aqV = true;
            this.aop.aoq.add(this.aoQ);
            this.aok.addOnPageChangeListener(this.nb);
            return;
        }
        this.aqV = false;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aqV) {
            this.aop.aoq.remove(this.aoQ);
            this.aok.removeOnPageChangeListener(this.nb);
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(String str) {
        this.aqS.setText(str);
        this.aqT.setText(com.kwad.components.ct.response.a.a.aX(this.mAdTemplate));
        this.aqU.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq() {
        this.aqU.setVisibility(8);
    }

    private boolean zr() {
        CtAdTemplate ctAdTemplateB;
        CtAdTemplate ctAdTemplateC;
        List<CtAdTemplate> data = this.aok.getData();
        return (data == null || data.isEmpty() || ((ctAdTemplateB = b(this.mAdTemplate)) != null && bq.isEquals(com.kwad.components.ct.response.a.a.aX(ctAdTemplateB), com.kwad.components.ct.response.a.a.aX(this.mAdTemplate)) && (ctAdTemplateC = c(this.mAdTemplate)) != null && bq.isEquals(com.kwad.components.ct.response.a.a.aX(ctAdTemplateC), com.kwad.components.ct.response.a.a.aX(this.mAdTemplate)))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CtAdTemplate b(CtAdTemplate ctAdTemplate) {
        CtAdTemplate ctAdTemplate2;
        List<CtAdTemplate> data = this.aok.getData();
        if (data != null && !data.isEmpty()) {
            int iIndexOf = data.indexOf(ctAdTemplate);
            do {
                iIndexOf--;
                if (iIndexOf > 0) {
                    ctAdTemplate2 = data.get(iIndexOf);
                }
            } while (!com.kwad.components.ct.response.a.a.as(ctAdTemplate2));
            return ctAdTemplate2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CtAdTemplate c(CtAdTemplate ctAdTemplate) {
        CtAdTemplate ctAdTemplate2;
        List<CtAdTemplate> data = this.aok.getData();
        if (data != null && !data.isEmpty()) {
            int iIndexOf = data.indexOf(ctAdTemplate);
            do {
                iIndexOf++;
                if (iIndexOf < data.size() - 1) {
                    ctAdTemplate2 = data.get(iIndexOf);
                }
            } while (!com.kwad.components.ct.response.a.a.as(ctAdTemplate2));
            return ctAdTemplate2;
        }
        return null;
    }
}
