package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryTypeTabView extends a {
    private boolean aCV;
    private f aDL;
    private com.kwad.sdk.lib.widget.b<CtAdTemplate> aDP;
    private ImageView aEL;
    private TextView aEM;
    private volatile boolean aEN;
    private View.OnClickListener aEO;
    private CtPhotoInfo asj;
    private com.kwad.components.core.widget.a.c gR;
    private final com.kwad.sdk.core.j.c gZ;
    private KSFrameLayout kS;
    private CtAdTemplate mAdTemplate;
    private TextView mf;

    @Override // com.kwad.components.ct.entry.view.a
    public int getEntrySourcePos() {
        return 0;
    }

    static /* synthetic */ boolean a(EntryTypeTabView entryTypeTabView, boolean z) {
        entryTypeTabView.aEN = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EE() {
        a(this.mAdTemplate, 0, this.aEL, 3);
    }

    public EntryTypeTabView(Context context) {
        super(context);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.aEN = false;
        this.gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.entry.view.EntryTypeTabView.1
            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void by() {
                if (EntryTypeTabView.this.aEN) {
                    return;
                }
                EntryTypeTabView.a(EntryTypeTabView.this, true);
                if (EntryTypeTabView.this.gR != null) {
                    EntryTypeTabView.this.gR.release();
                }
                EntryTypeTabView.this.EE();
            }
        };
        this.aEO = new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryTypeTabView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i = EntryTypeTabView.this.mf == view ? 2 : 1;
                EntryTypeTabView entryTypeTabView = EntryTypeTabView.this;
                entryTypeTabView.a(entryTypeTabView.mAdTemplate, 0, EntryTypeTabView.this.aEL, i);
            }
        };
    }

    public EntryTypeTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDP = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.aEN = false;
        this.gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.entry.view.EntryTypeTabView.1
            @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
            public final void by() {
                if (EntryTypeTabView.this.aEN) {
                    return;
                }
                EntryTypeTabView.a(EntryTypeTabView.this, true);
                if (EntryTypeTabView.this.gR != null) {
                    EntryTypeTabView.this.gR.release();
                }
                EntryTypeTabView.this.EE();
            }
        };
        this.aEO = new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryTypeTabView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i = EntryTypeTabView.this.mf == view ? 2 : 1;
                EntryTypeTabView entryTypeTabView = EntryTypeTabView.this;
                entryTypeTabView.a(entryTypeTabView.mAdTemplate, 0, EntryTypeTabView.this.aEL, i);
            }
        };
    }

    @Override // com.kwad.components.ct.entry.view.a, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
        this.aDL = new f(this);
    }

    private void init() {
        this.mf = (TextView) findViewById(R.id.ksad_entryitem5_title);
        this.aEL = (ImageView) findViewById(R.id.ksad_entryitem5_thumb);
        this.aEM = (TextView) findViewById(R.id.ksad_entryitem5_like_count);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_entryitem5_container);
        this.kS = kSFrameLayout;
        kSFrameLayout.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        this.kS.setOnClickListener(this.aEO);
        this.mf.setOnClickListener(this.aEO);
        EJ();
    }

    private boolean EF() {
        return this.aCV && ao.isWifiConnected(getContext());
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
            if (!next.needHide) {
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
        EG();
        EI();
        EH();
        return true;
    }

    @Override // com.kwad.components.ct.entry.view.a
    protected List<CtAdTemplate> getRealShowData() {
        return this.aDP;
    }

    private void EG() {
        String str = this.asj.baseInfo.videoDesc;
        if (!TextUtils.isEmpty(str)) {
            this.mf.setText(str);
            g.a(this.mf, getEntryTheme().aDt);
            this.mf.setVisibility(0);
            return;
        }
        this.mf.setVisibility(8);
    }

    private void EH() {
        com.kwad.sdk.core.response.model.b bVarE = com.kwad.components.ct.response.a.c.E(this.asj);
        String url = bVarE.getUrl();
        a(this.aEL, bVarE.getWidth(), bVarE.getHeight());
        com.kwad.sdk.glide.c.cy(getContext()).hh(url).d(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).f(getContext().getResources().getDrawable(R.drawable.ksad_loading_entry)).a(new com.kwad.components.ct.b.a(url, this.mAdTemplate)).b(this.aEL);
    }

    private void a(ImageView imageView, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.kS.getLayoutParams();
        if (i2 >= i) {
            layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), 247.0f);
            layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), 330.0f);
            this.kS.setRatio(1.3333334f);
            if (i2 * 3 >= i * 4) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        } else {
            int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext()) - com.kwad.sdk.c.a.a.a(getContext(), 32.0f);
            layoutParams.width = screenWidth;
            layoutParams.height = (int) ((screenWidth * 16.0f) / 9.0f);
            this.kS.setRatio(0.5625f);
            if (i2 * 16 <= i * 9) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
        this.kS.setLayoutParams(layoutParams);
        com.kwad.sdk.core.d.c.d("EntryType5View", "w*h=" + layoutParams.width + " * " + layoutParams.height);
    }

    private void EI() {
        this.aEM.setText(String.format(getContext().getString(R.string.ksad_entry_tab_like_format), bq.b(com.kwad.components.ct.response.a.c.m((PhotoInfo) this.asj), "0")));
        g.a(this.aEM, getEntryTheme().aDu);
    }

    @Override // com.kwad.components.ct.entry.view.a, com.kwad.sdk.widget.KSLinearLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
        com.kwad.components.ct.e.b.JK().b(this.mAdTemplate, this.aCR.entryId);
    }

    public void setEnableSlideAutoOpen(boolean z) {
        this.aCV = z;
        EJ();
    }

    private void EJ() {
        if (EF() && this.gR == null) {
            com.kwad.components.core.widget.a.c cVar = new com.kwad.components.core.widget.a.c(this.aEL, 60);
            this.gR = cVar;
            cVar.a(this.gZ);
            this.gR.wK();
        }
    }

    @Override // com.kwad.sdk.widget.KSLinearLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.widget.KSLinearLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.core.widget.a.c cVar = this.gR;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
    }

    @Override // com.kwad.components.ct.entry.view.a, com.kwad.components.ct.f.b
    public final void cg(int i) {
        super.cg(i);
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "EntryTypeTabView updateThemeModeUi");
        g.c(this, getEntryTheme().aDq);
        g.a(this.mf, getEntryTheme().aDt);
        g.a(this.aEM, getEntryTheme().aDu);
    }
}
