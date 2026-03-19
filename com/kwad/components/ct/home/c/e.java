package com.kwad.components.ct.home.c;

import android.os.Message;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.cb;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e extends com.kwad.components.ct.home.e implements cb.a {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static boolean aJY = false;
    private TextView aJZ;
    private String aKa;
    private long aKb;
    private SlidePlayViewPager aok;
    private bw ayZ;
    private cb dC;
    private final ViewPager.OnPageChangeListener nj = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ct.home.c.e.1
        @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i) {
            CtAdTemplate currentData = e.this.aok.getCurrentData();
            if (currentData == null) {
                return;
            }
            if (!com.kwad.components.ct.response.a.a.as(currentData)) {
                e.this.ayZ.aqq();
                e.this.aA();
                if (e.aJY) {
                    e.this.ah(0L);
                    return;
                }
                return;
            }
            if (e.aJY) {
                e eVar = e.this;
                eVar.ah(eVar.ayZ.getTime());
            }
        }
    };
    private final com.kwad.components.ct.detail.listener.a amS = new com.kwad.components.ct.detail.listener.b() { // from class: com.kwad.components.ct.home.c.e.2
        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate) {
            if (!com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                e.this.ayZ.aqq();
                e.this.aA();
                if (e.aJY) {
                    e.this.ah(0L);
                    return;
                }
                return;
            }
            if (e.this.ayZ.AI()) {
                e.this.ayZ.AG();
            } else {
                e.this.ayZ.startTiming();
            }
            e.this.az();
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void b(int i, CtAdTemplate ctAdTemplate) {
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                e.this.ayZ.AH();
                e.this.aA();
            }
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void c(int i, CtAdTemplate ctAdTemplate) {
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                e.this.ayZ.AG();
                e.this.az();
            }
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void d(int i, CtAdTemplate ctAdTemplate) {
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                e.this.ayZ.AH();
                e.this.aA();
            }
        }

        @Override // com.kwad.components.ct.detail.listener.b, com.kwad.components.ct.detail.listener.a
        public final void a(int i, CtAdTemplate ctAdTemplate, int i2, int i3) {
            if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
                e.this.ayZ.AH();
                e.this.aA();
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dC = new cb(this);
        this.ayZ = new bw();
    }

    @Override // com.kwad.components.ct.home.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aKb = com.kwad.components.ct.home.config.b.aa(this.aGP.mSceneImpl.posId);
        boolean zXi = com.kwad.components.ct.a.b.xi();
        aJY = zXi;
        if (zXi) {
            ViewGroup viewGroup = (ViewGroup) this.aGP.aGE.getView();
            TextView textView = new TextView(getContext());
            this.aJZ = textView;
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            this.aJZ.setTextSize(20.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = 40;
            viewGroup.addView(this.aJZ, layoutParams);
        }
        SlidePlayViewPager slidePlayViewPager = this.aGP.aok;
        this.aok = slidePlayViewPager;
        slidePlayViewPager.addOnPageChangeListener(this.nj);
        com.kwad.components.ct.detail.listener.c.zh().a(this.amS);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aok.removeOnPageChangeListener(this.nj);
        com.kwad.components.ct.detail.listener.c.zh().b(this.amS);
        aA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        this.dC.removeMessages(1);
        this.dC.sendEmptyMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aA() {
        this.dC.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        GG();
        this.dC.sendEmptyMessageDelayed(1, 1000L);
    }

    private void GG() {
        if (aJY) {
            ah(this.ayZ.getTime());
        }
        if (this.ayZ.getTime() > this.aKb) {
            GH();
        }
    }

    private void GH() {
        List<T> listXc;
        int iIndexOf;
        CtAdTemplate ctAdTemplate;
        CtAdTemplate currentData = this.aok.getCurrentData();
        if (currentData == null || com.kwad.components.ct.response.a.a.eH(currentData) || this.aok.getSourceType() != 0 || (listXc = this.aGP.ayi.xc()) == 0 || listXc.isEmpty() || (iIndexOf = listXc.indexOf(currentData)) == -1 || iIndexOf == listXc.size() - 1) {
            return;
        }
        int i = iIndexOf + 1;
        CtAdTemplate ctAdTemplate2 = (CtAdTemplate) listXc.get(i);
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate2) || com.kwad.components.ct.response.a.a.av(ctAdTemplate2) || ctAdTemplate2.mContentPvReported || ctAdTemplate2.mHasSelected) {
            return;
        }
        if (aJY) {
            this.aKa = d(listXc, "before change:");
        }
        while (true) {
            i++;
            if (i >= listXc.size()) {
                return;
            }
            ctAdTemplate = (CtAdTemplate) listXc.get(i);
            if (!ctAdTemplate.mPvReported && !ctAdTemplate.mHasSelected && (com.kwad.components.ct.response.a.a.eH(ctAdTemplate) || com.kwad.components.ct.response.a.a.av(ctAdTemplate))) {
                break;
            }
        }
        this.aok.a(currentData, ctAdTemplate, 1, 0);
        if (aJY) {
            ac.ae(getContext(), "插入了广告");
            com.kwad.sdk.core.d.c.d("HomeAdLoadPresenter", this.aKa);
            com.kwad.sdk.core.d.c.d("HomeAdLoadPresenter", d(listXc, "after  change:"));
            com.kwad.sdk.core.d.c.d("HomeAdLoadPresenter", "changed template: " + ctAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(long j) {
        TextView textView = this.aJZ;
        if (textView != null) {
            textView.setText("视频" + (this.aok.getRealPosition() + 1) + "\nserverPosition=" + (this.aok.getCurrentData().getServerPosition() + 1) + "\nposition=" + (this.aok.getCurrentData().getShowPosition() + 1) + "\ntime:" + j);
        }
    }

    private static String d(List<CtAdTemplate> list, String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < list.size(); i++) {
            sb.append(i).append(com.kwad.components.ct.response.a.a.as(list.get(i)) ? "photo" : "ad").append(list.get(i).getShowPosition()).append("-");
        }
        return sb.toString();
    }
}
