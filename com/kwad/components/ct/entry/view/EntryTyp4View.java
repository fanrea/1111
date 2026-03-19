package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryTyp4View extends a {
    private com.kwad.sdk.lib.widget.b<CtAdTemplate> aDP;
    private RoundAngleImageView aDY;
    private RoundAngleImageView aEH;
    private TextView aEI;
    private View.OnClickListener aEJ;
    private com.kwad.components.ct.entry.b.a aEo;
    private CtPhotoInfo asj;
    private CtAdTemplate mAdTemplate;
    private boolean mIsAttachedToWindow;
    private Presenter mPresenter;
    private TextView mf;

    public EntryTyp4View(Context context) {
        super(context);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.aEJ = new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (EntryTyp4View.this.aEo != null) {
                    EntryTyp4View.this.aEo.p(view, 1);
                }
            }
        };
    }

    public EntryTyp4View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.aEJ = new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryTyp4View.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (EntryTyp4View.this.aEo != null) {
                    EntryTyp4View.this.aEo.p(view, 1);
                }
            }
        };
    }

    @Override // com.kwad.components.ct.entry.view.a, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        this.mf = (TextView) findViewById(R.id.ksad_entryitem4_title);
        this.aDY = (RoundAngleImageView) findViewById(R.id.ksad_entryitem4_background);
        this.aEH = (RoundAngleImageView) findViewById(R.id.ksad_entryitem4_thumb);
        this.aDY.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        this.aEI = (TextView) findViewById(R.id.ksad_entryitem4_duration);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_entryitem4_container);
        ratioFrameLayout.setRatio(0.5600000023841858d);
        ratioFrameLayout.setOnClickListener(this.aEJ);
        this.mf.setOnClickListener(this.aEJ);
    }

    private static Presenter bI() {
        return new Presenter();
    }

    private com.kwad.components.ct.entry.b.a Em() {
        com.kwad.components.ct.entry.b.a aVar = new com.kwad.components.ct.entry.b.a();
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.aCR = this.aCR;
        aVar.aDp.add(n(0, this.mAdTemplate));
        return aVar;
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected final boolean El() {
        this.aDP.clear();
        Iterator<CtAdTemplate> it = this.aCR.aVj.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CtAdTemplate next = it.next();
            if (!next.needHide && !com.kwad.components.ct.response.a.a.eH(next)) {
                this.aDP.add(next);
                break;
            }
        }
        if (this.aDP.size() > 0) {
            CtAdTemplate ctAdTemplate = this.aDP.get(0);
            this.mAdTemplate = ctAdTemplate;
            this.asj = ctAdTemplate.photoInfo;
        } else {
            this.mAdTemplate = null;
        }
        if (this.mAdTemplate == null) {
            return false;
        }
        if (this.aCR.aVg == 1 && !TextUtils.isEmpty(this.asj.baseInfo.videoDesc)) {
            this.mf.setText(this.asj.baseInfo.videoDesc);
            g.a(this.mf, getEntryTheme().aDt);
            this.mf.setVisibility(0);
        } else {
            this.mf.setVisibility(8);
        }
        String strAP = bv.aP(this.asj.videoInfo.duration);
        if (this.aCR.aVg == 1) {
            this.aEI.setText(strAP);
            this.aEI.setVisibility(0);
        } else {
            this.aEI.setVisibility(8);
        }
        if (DX()) {
            this.aEH.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.aEH.setRadius(0.0f);
            this.aDY.setVisibility(0);
            String strB = com.kwad.components.ct.response.a.c.b(this.asj);
            com.kwad.sdk.glide.c.cy(this.aDY.getContext()).hh(strB).d(getContext().getResources().getDrawable(R.drawable.ksad_blur_def_bg)).e(getContext().getResources().getDrawable(R.drawable.ksad_blur_def_bg)).f(getContext().getResources().getDrawable(R.drawable.ksad_blur_def_bg)).a(new com.kwad.components.ct.b.a(strB, this.mAdTemplate)).b(this.aDY);
            com.kwad.sdk.core.d.c.d("EntryTyp4View", "blurBackgroundUrl=" + strB + " blurCoverUrl=" + this.asj.coverInfo.blurCoverUrl);
        } else {
            this.aEH.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aEH.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
            this.aDY.setVisibility(8);
        }
        String url = com.kwad.components.ct.response.a.c.E(this.asj).getUrl();
        com.kwad.sdk.glide.c.cy(this.aEH.getContext()).hh(url).d(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).e(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).f(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a(new com.kwad.components.ct.b.a(url, this.mAdTemplate)).b(this.aEH);
        Eo();
        return true;
    }

    private void Eo() {
        if (!this.mIsAttachedToWindow || this.mAdTemplate == null || this.aCR == null) {
            return;
        }
        if (this.aEo == null) {
            this.aEo = Em();
        }
        this.mPresenter.K(this.aEo);
    }

    @Override // com.kwad.components.ct.entry.view.a, com.kwad.sdk.widget.KSLinearLayout
    public final void ae() {
        this.mIsAttachedToWindow = true;
        super.ae();
        if (this.mPresenter == null) {
            this.mPresenter = bI();
        }
        this.mPresenter.ak(this);
        Eo();
    }

    @Override // com.kwad.components.ct.entry.view.a, com.kwad.sdk.widget.KSLinearLayout
    public final void af() {
        this.mIsAttachedToWindow = false;
        super.af();
        this.mPresenter.destroy();
        com.kwad.components.ct.entry.b.a aVar = this.aEo;
        if (aVar != null) {
            aVar.release();
        }
    }

    private boolean DX() {
        com.kwad.sdk.core.response.model.b bVarE = com.kwad.components.ct.response.a.c.E(this.asj);
        return bVarE.getHeight() * 16 > bVarE.getWidth() * 9;
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected List<CtAdTemplate> getRealShowData() {
        return this.aDP;
    }

    @Override // com.kwad.components.ct.entry.view.a, com.kwad.sdk.widget.KSLinearLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
        com.kwad.components.ct.e.b.JK().b(this.mAdTemplate, this.aCR.entryId);
    }

    @Override // com.kwad.components.ct.entry.view.a
    public String getEntrySourceDesc() {
        if (TextUtils.isEmpty(this.aCR.aVb)) {
            this.aCR.aVb = "快手推荐";
        }
        StringBuilder sb = new StringBuilder();
        if (this.aCR.aVc != 0) {
            sb.append(this.aCR.aVb);
            sb.append("   ");
        }
        if (this.aCR.aVi != 0) {
            sb.append(bq.b(this.asj.baseInfo.commentCount, "0")).append(" 评论");
        }
        return sb.toString();
    }

    @Override // com.kwad.components.ct.entry.view.a
    public int getEntrySourcePos() {
        int entrySourcePos = super.getEntrySourcePos();
        return entrySourcePos == 0 ? this.aCR.aVi : entrySourcePos;
    }

    @Override // com.kwad.components.ct.entry.view.a, com.kwad.components.ct.f.b
    public final void cg(int i) {
        super.cg(i);
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "EntryTyp4View updateThemeModeUi");
        g.a(this.mf, getEntryTheme().aDt);
    }
}
