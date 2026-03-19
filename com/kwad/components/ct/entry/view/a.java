package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ct.entry.view.d;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.KSLinearLayout;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends KSLinearLayout implements d, com.kwad.components.ct.f.b {
    protected com.kwad.components.ct.response.model.a.a aCR;
    private TextView aDI;
    protected com.kwad.sdk.widget.a aDJ;
    private KsEntryElement.OnFeedClickListener aDK;
    private f aDL;
    private d.b aDM;

    protected abstract boolean El();

    public String getEntrySourceDesc() {
        return null;
    }

    protected abstract List<CtAdTemplate> getRealShowData();

    public int getSourceRightMargin() {
        return 0;
    }

    public a(Context context) {
        super(context);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void Ek() {
        g.c(this, getEntryTheme().aDq);
        int iA = com.kwad.sdk.c.a.a.a(getContext(), 5.0f);
        if (this.aDI == null) {
            TextView textView = new TextView(getContext());
            this.aDI = textView;
            textView.setTextSize(10.0f);
            g.a(this.aDI, getEntryTheme().aDr);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 3;
            layoutParams.topMargin = iA;
            layoutParams.rightMargin = getSourceRightMargin();
            this.aDI.setLayoutParams(layoutParams);
            addView(this.aDI);
        }
        if (this.aDJ == null) {
            com.kwad.sdk.widget.a aVar = new com.kwad.sdk.widget.a(getContext());
            this.aDJ = aVar;
            aVar.setGravity(16);
            this.aDJ.setTextSize(18.0f);
            g.a(this.aDJ, getEntryTheme().aDs);
            this.aDJ.setCompoundDrawablePadding(com.kwad.sdk.c.a.a.a(getContext(), 2.0f));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 8.0f);
            this.aDJ.setLayoutParams(layoutParams2);
            this.aDJ.setMaxEms(15);
            this.aDJ.setMaxLines(1);
            Drawable drawable = g.getDrawable(getContext(), getEntryTheme().aDv);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.aDJ.setCompoundDrawables(null, null, drawable, null);
            this.aDJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    List<CtAdTemplate> realShowData = a.this.getRealShowData();
                    if (realShowData.size() <= 0) {
                        return;
                    }
                    int size = realShowData.size() - 1;
                    a.this.a(realShowData.get(size), size, view, 2);
                }
            });
            addView(this.aDJ, 0);
        }
    }

    public int getEntrySourcePos() {
        return this.aCR.aVc;
    }

    public int getEntryTitlePos() {
        return this.aCR.aVf;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "EntryTypeTabView onFinishInflate");
        Ek();
        this.aDL = new f(this);
    }

    protected com.kwad.components.ct.entry.c.a getEntryTheme() {
        return (com.kwad.components.ct.entry.c.a) ((com.kwad.components.ct.entry.c.b) com.kwad.components.ct.f.d.Kb().a(com.kwad.components.ct.entry.c.b.class)).Ec();
    }

    @Override // com.kwad.components.ct.entry.view.d
    public final boolean b(com.kwad.components.ct.response.model.a.a aVar) {
        this.aCR = aVar;
        aqP();
        if (this.aCR == null) {
            removeAllViews();
            return false;
        }
        boolean zEl = El();
        String entrySourceDesc = getEntrySourceDesc();
        if (entrySourceDesc != null) {
            this.aDI.setText(entrySourceDesc);
        } else {
            if (TextUtils.isEmpty(aVar.aVb)) {
                aVar.aVb = "来自 快手推荐";
            }
            this.aDI.setText(aVar.aVb);
        }
        int entrySourcePos = getEntrySourcePos();
        if (entrySourcePos == 0) {
            this.aDI.setVisibility(8);
        } else if (entrySourcePos == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aDI.getLayoutParams();
            layoutParams.gravity = 3;
            this.aDI.setLayoutParams(layoutParams);
            this.aDI.setVisibility(0);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aDI.getLayoutParams();
            layoutParams2.gravity = 5;
            this.aDI.setLayoutParams(layoutParams2);
            this.aDI.setVisibility(0);
        }
        if (getEntryTitlePos() == 1 && !TextUtils.isEmpty(this.aCR.aVe)) {
            this.aDJ.setText(this.aCR.aVe);
            this.aDJ.setVisibility(0);
        } else {
            this.aDJ.setVisibility(8);
        }
        return zEl;
    }

    @Override // com.kwad.components.ct.entry.view.d
    public void setOnFeedClickListener(KsEntryElement.OnFeedClickListener onFeedClickListener) {
        this.aDK = onFeedClickListener;
    }

    @Override // com.kwad.sdk.widget.KSLinearLayout, com.kwad.sdk.widget.m
    public void E(View view) {
        super.E(view);
        com.kwad.components.ct.e.b.JK().c(this.aCR);
    }

    protected final void a(CtAdTemplate ctAdTemplate, int i, View view, int i2) {
        if (this.aDK == null) {
            return;
        }
        com.kwad.components.ct.response.model.cached.a aVar = new com.kwad.components.ct.response.model.cached.a(this.aCR);
        n.fl(ctAdTemplate);
        aVar.bf(ctAdTemplate);
        com.kwad.components.ct.entry.b.a(aVar);
        com.kwad.components.ct.e.b.JK().a(ctAdTemplate, this.aCR.entryId, i2);
        this.aDK.handleFeedClick(this.aCR.aVa, i, view);
    }

    protected final void b(CtAdTemplate ctAdTemplate, int i, View view, int i2) {
        if (this.aDK == null) {
            return;
        }
        com.kwad.components.ct.response.model.cached.a aVar = new com.kwad.components.ct.response.model.cached.a(this.aCR);
        aVar.bf(ctAdTemplate);
        com.kwad.components.ct.entry.b.a(aVar);
        com.kwad.components.ct.e.b.JK().a(this.aCR, i2);
        this.aDK.handleFeedClick(this.aCR.aVa, i, view);
    }

    public void cg(int i) {
        g.c(this, getEntryTheme().aDq);
        g.a(this.aDI, getEntryTheme().aDr);
        com.kwad.sdk.widget.a aVar = this.aDJ;
        if (aVar != null) {
            g.a(aVar, getEntryTheme().aDs);
            Drawable drawable = g.getDrawable(getContext(), getEntryTheme().aDv);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.aDJ.setCompoundDrawables(null, null, drawable, null);
        }
    }

    @Override // com.kwad.sdk.widget.KSLinearLayout
    public void ae() {
        super.ae();
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "EntryTypeTabView onAttachedToWindow");
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.widget.KSLinearLayout
    public void af() {
        super.af();
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "EntryTypeTabView onDetachedFromWindow");
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
        d.b bVar = this.aDM;
        if (bVar != null) {
            bVar.onDetachedFromWindow();
        }
    }

    @Override // com.kwad.components.ct.entry.view.d
    public void setOnDetachListener(d.b bVar) {
        this.aDM = bVar;
    }

    protected final d.a n(final int i, final CtAdTemplate ctAdTemplate) {
        return new d.a() { // from class: com.kwad.components.ct.entry.view.a.2
            @Override // com.kwad.components.ct.entry.view.d.a
            public final void q(View view, int i2) {
                a.this.a(ctAdTemplate, i, view, i2);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchStartTemporaryDetach() {
        if (com.kwad.components.ct.entry.a.b.Eb()) {
            super.dispatchStartTemporaryDetach();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchFinishTemporaryDetach() {
        if (com.kwad.components.ct.entry.a.b.Eb()) {
            super.dispatchFinishTemporaryDetach();
        }
    }
}
