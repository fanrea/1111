package com.kwad.components.core.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.d;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b<T extends AdResultData, R extends AdTemplate> extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.sdk.core.j.c {
    public a akg;
    private long akh;
    private com.kwad.sdk.core.j.b fa;
    private com.kwad.components.core.widget.a.c gR;
    public AdInfo mAdInfo;
    protected T mAdResultData;
    public R mAdTemplate;
    public Context mContext;
    private bw mTimerHelper;
    protected boolean qI;

    public interface a {
        void onAdClicked();

        void onAdShow();

        void onDislikeClicked();

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    protected abstract void bB();

    public void by() {
    }

    public void bz() {
    }

    public void cv() {
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    static /* synthetic */ long a(b bVar, long j) {
        long j2 = bVar.akh + j;
        bVar.akh = j2;
        return j2;
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        if (com.kwad.sdk.core.config.e.YU()) {
            return;
        }
        setBackgroundColor(-1);
    }

    private void initView() {
        m.inflate(this.mContext, getLayoutId(), this);
        setRatio(getHWRatio());
        bB();
        this.gR = new com.kwad.components.core.widget.a.c(this, 70);
    }

    public final boolean fv() {
        return (this.mAdInfo.status == 2 || this.mAdInfo.status == 3) ? false : true;
    }

    public void d(T t) {
        this.mAdResultData = t;
        R r = (R) com.kwad.sdk.core.response.b.c.s(t);
        this.mAdTemplate = r;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(r);
        a(this);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void af() {
        super.af();
        this.gR.wL();
        this.gR.b(this);
        cv();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void ae() {
        super.ae();
        this.gR.a(this);
        this.gR.a(this.fa);
        this.gR.wK();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        a aVar = this.akg;
        if (aVar != null) {
            aVar.onDownloadTipsDialogDismiss();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        a aVar = this.akg;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    public void setInnerAdInteractionListener(a aVar) {
        this.akg = aVar;
    }

    public void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.fa = bVar;
    }

    public bw getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bw();
        }
        return this.mTimerHelper;
    }

    public long getStayTime() {
        return this.akh + getTimerHelper().getTime();
    }

    private void a(ViewGroup viewGroup) {
        if (!com.kwad.sdk.core.config.e.Yx() && com.kwad.sdk.core.config.e.Yw() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0500a() { // from class: com.kwad.components.core.widget.b.1
                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void ae() {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void onWindowFocusChanged(boolean z) {
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void af() {
                    if (b.this.mAdTemplate.mPvReported && b.this.qI) {
                        long jAqq = b.this.getTimerHelper().aqq();
                        b.a(b.this, jAqq);
                        com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jAqq, (JSONObject) null);
                        b.this.qI = false;
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void c(View view) {
                    if (!b.this.mAdTemplate.mPvReported && b.this.akg != null) {
                        b.this.qI = true;
                        b.this.aa();
                        b.this.getTimerHelper().startTiming();
                    }
                    if (!b.this.qI) {
                        b.this.getTimerHelper().startTiming();
                    }
                    b.this.qI = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0500a
                public final void aD() {
                    if (b.this.mAdTemplate.mPvReported && b.this.qI) {
                        long jAqq = b.this.getTimerHelper().aqq();
                        b.a(b.this, jAqq);
                        com.kwad.sdk.core.adlog.c.a(b.this.mAdTemplate, jAqq, (JSONObject) null);
                        b.this.qI = false;
                    }
                }
            });
            aVar.ww();
            return;
        }
        d dVarB = b(viewGroup);
        if (dVarB == null) {
            dVarB = new d(viewGroup.getContext(), viewGroup);
            viewGroup.addView(dVarB);
        }
        dVarB.setViewCallback(new d.a() { // from class: com.kwad.components.core.widget.b.2
            @Override // com.kwad.components.core.widget.d.a
            public final void fx() {
                b.this.aa();
            }
        });
        dVarB.setNeedCheckingShow(true);
    }

    private static d b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof d) {
                return (d) childAt;
            }
        }
        return null;
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    protected void aa() {
        a aVar;
        if (!this.mAdTemplate.mPvReported && (aVar = this.akg) != null) {
            aVar.onAdShow();
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        a.C0576a c0576a = new a.C0576a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
        if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
            feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
        }
        c0576a.templateId = String.valueOf(feedTypeFromInt.getType());
        c0576a.bvk = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        bVar.b(c0576a);
        bVar.G(getHeight(), getWidth());
        com.kwad.components.core.u.b.tq().a(this.mAdTemplate, null, bVar);
    }

    public final void c(com.kwad.sdk.core.adlog.c.b bVar) {
        bVar.f(getTouchCoords());
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, bVar, (JSONObject) null);
        a aVar = this.akg;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void wx() {
        a aVar = this.akg;
        if (aVar != null) {
            aVar.onAdClicked();
        }
    }

    public final void bg(int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.oz = i;
        a.C0576a c0576a = new a.C0576a();
        FeedType feedTypeFromInt = FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
        c0576a.templateId = String.valueOf(feedTypeFromInt.getType());
        c0576a.bvk = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
        aVar.QY = c0576a;
        if (this.mAdTemplate.swipeAngle != 0) {
            aVar.bwJ = this.mAdTemplate.swipeAngle;
        }
        if (getTouchCoords() != null) {
            aVar.oB = getTouchCoords();
        }
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, aVar, (JSONObject) null);
        a aVar2 = this.akg;
        if (aVar2 != null) {
            aVar2.onAdClicked();
        }
    }

    public final void wy() {
        com.kwad.sdk.core.adlog.c.cg(this.mAdTemplate);
        a aVar = this.akg;
        if (aVar != null) {
            aVar.onDislikeClicked();
        }
    }
}
