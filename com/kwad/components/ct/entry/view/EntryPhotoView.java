package com.kwad.components.ct.entry.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.ct.entry.view.d;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.widget.WebpAnimationImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.glide.f;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.load.engine.h;
import com.kwad.sdk.glide.load.i;
import com.kwad.sdk.glide.load.resource.bitmap.g;
import com.kwad.sdk.glide.load.resource.bitmap.o;
import com.kwad.sdk.glide.request.a.e;
import com.kwad.sdk.glide.webp.decoder.WebpFrameCacheStrategy;
import com.kwad.sdk.glide.webp.decoder.k;
import com.kwad.sdk.glide.webp.decoder.n;
import com.kwad.sdk.glide.webp.decoder.p;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EntryPhotoView extends KSFrameLayout implements View.OnClickListener {
    private static final aj.a aDV = new aj.a();
    private WebpAnimationImageView aDW;
    private e aDX;
    private RoundAngleImageView aDY;
    private TextView aDZ;
    private com.kwad.components.ct.response.model.a.a aEa;
    private boolean aEb;
    private boolean aEc;
    private View aEd;
    private String aEe;
    private com.kwad.components.core.widget.a.c aEf;
    private int aEg;
    private ViewStub aEh;
    private RoundAngleImageView aEi;
    private ImageView aEj;
    private TextView aEk;
    private TextView aEl;
    private boolean aEm;
    private RelativeLayout aEn;
    private com.kwad.components.ct.entry.b.a aEo;
    private com.kwad.components.core.widget.a.c aEp;
    private Runnable aEq;
    private d.a aEr;
    private EntryAdConvertButton aEs;
    private volatile boolean aEt;
    private volatile boolean aEu;
    private int abR;
    private ImageView akD;
    private CtPhotoInfo asj;
    private CtAdTemplate azr;
    private KsAppDownloadListener fJ;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAttachedToWindow;
    private Presenter mPresenter;
    private TextView mTitleTv;

    static /* synthetic */ boolean a(EntryPhotoView entryPhotoView, boolean z) {
        entryPhotoView.aEm = true;
        return true;
    }

    public EntryPhotoView(Context context) {
        super(context);
        this.aEg = 1;
        this.aEm = false;
        this.aEt = false;
        this.aEu = false;
    }

    public EntryPhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aEg = 1;
        this.aEm = false;
        this.aEt = false;
        this.aEu = false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        bB();
    }

    private void bB() {
        WebpAnimationImageView webpAnimationImageView = (WebpAnimationImageView) findViewById(R.id.ksad_entryitem_photocover);
        this.aDW = webpAnimationImageView;
        webpAnimationImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_background);
        this.aDY = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        this.aDZ = (TextView) findViewById(R.id.ksad_entryitem_lickcount);
        this.aEd = findViewById(R.id.ksad_entryitem_lookmore);
        this.mTitleTv = (TextView) findViewById(R.id.ksad_entryitem_title);
        this.akD = (ImageView) findViewById(R.id.ksad_entryitem_playbtn);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_entryitem_ad_bottom_viewstub);
        this.aEh = viewStub;
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.1
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                EntryPhotoView.a(EntryPhotoView.this, true);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (EntryPhotoView.this.aEo != null) {
                    EntryPhotoView.this.aEo.p(EntryPhotoView.this, 1);
                }
            }
        });
    }

    private static Presenter bI() {
        return new Presenter();
    }

    private com.kwad.components.ct.entry.b.a Em() {
        com.kwad.components.ct.entry.b.a aVar = new com.kwad.components.ct.entry.b.a();
        aVar.mAdTemplate = this.azr;
        aVar.aCR = this.aEa;
        if (this.aEr != null) {
            aVar.aDp.add(this.aEr);
        }
        return aVar;
    }

    public void setOnEntryClickListener(d.a aVar) {
        com.kwad.components.ct.entry.b.a aVar2;
        if (this.aEr != null && (aVar2 = this.aEo) != null) {
            aVar2.aDp.remove(this.aEr);
        }
        this.aEr = aVar;
        com.kwad.components.ct.entry.b.a aVar3 = this.aEo;
        if (aVar3 != null) {
            aVar3.aDp.add(aVar);
        }
    }

    public final void p(boolean z, boolean z2) {
        this.aEb = z;
        this.aEc = true;
        Ew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean En() {
        com.kwad.components.core.widget.a.c cVar;
        return this.aEb && ((this.aEc && com.kwad.components.ct.entry.a.b.Ea()) || ((cVar = this.aEf) != null && cVar.ai()));
    }

    public final void a(CtAdTemplate ctAdTemplate, com.kwad.components.ct.response.model.a.a aVar) {
        this.aEa = aVar;
        this.azr = ctAdTemplate;
        reset();
        if (com.kwad.components.ct.response.a.a.eH(this.azr)) {
            this.mAdInfo = com.kwad.components.ct.response.a.a.eP(this.azr);
            Ep();
        } else {
            this.asj = com.kwad.components.ct.response.a.a.ay(this.azr);
            initContentView();
        }
        Eo();
    }

    private void Eo() {
        if (!this.mIsAttachedToWindow || this.azr == null || this.aEa == null) {
            return;
        }
        if (this.aEo == null) {
            this.aEo = Em();
        }
        this.mPresenter.K(this.aEo);
    }

    private void Ep() {
        this.aDZ.setVisibility(8);
        this.mTitleTv.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        if (this.aEc) {
            Ew();
        }
        Eq();
        Er();
        Ex();
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo) && this.mApkDownloadHelper == null) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.azr);
            this.mApkDownloadHelper = cVar;
            cVar.b(getAppDownloadListener());
        }
    }

    private void Eq() {
        this.mTitleTv.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EntryPhotoView.this.y(24, 108);
            }
        });
        this.aDW.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EntryPhotoView.this.y(83, 108);
            }
        });
        this.aDY.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EntryPhotoView.this.y(83, 108);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i, int i2) {
        if (com.kwad.components.ct.response.a.a.eH(this.azr) && com.kwad.components.ct.entry.a.b.DZ()) {
            this.azr.mIsFromContent = true;
            com.kwad.sdk.core.adlog.c.r(this.azr, i);
            com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.azr).b(this.mApkDownloadHelper).aG(2).aq(true).aF(i2).d(getTouchCoords()).as(true).a(new a.b() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.9
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    EntryPhotoView.this.azr.mHasEntryAdClick = true;
                }
            }));
        } else {
            com.kwad.components.ct.entry.b.a aVar = this.aEo;
            if (aVar != null) {
                aVar.p(this, 1);
            }
        }
    }

    private void initContentView() {
        if (this.asj == null) {
            return;
        }
        Er();
        long jM = com.kwad.components.ct.response.a.c.m((PhotoInfo) this.asj);
        this.aDZ.setVisibility(0);
        this.aDZ.setText(bq.b(jM, "0"));
        com.kwad.sdk.core.d.c.d("EntryPhotoView", "videoDescPos=" + this.aEa.aVh + " videoDesc=" + this.asj.baseInfo.videoDesc);
        if (this.aEa.aVh == 1 && !TextUtils.isEmpty(this.asj.baseInfo.videoDesc)) {
            this.mTitleTv.setVisibility(0);
            this.mTitleTv.setText(this.asj.baseInfo.videoDesc);
        } else {
            this.mTitleTv.setVisibility(8);
        }
    }

    private void Er() {
        setBackgroundImageView(com.kwad.components.ct.response.a.a.be(this.azr));
        Es();
        Et();
    }

    private void Es() {
        if (DX()) {
            this.aDW.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.aDW.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 0.0f));
        } else {
            this.aDW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.aDW.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        }
    }

    private void Et() {
        i<Bitmap> gVar;
        String strAT = com.kwad.components.ct.response.a.a.aT(this.azr);
        boolean z = this.aEb && !TextUtils.isEmpty(strAT) && FrameSequence.isEnable();
        if (!z) {
            strAT = com.kwad.components.ct.response.a.a.aE(this.azr);
        }
        com.kwad.sdk.core.d.c.d("EntryPhotoView", "coverUrl=" + strAT);
        f fVarA = com.kwad.sdk.glide.c.cy(getContext()).hh(strAT).d(getResources().getDrawable(R.drawable.ksad_loading_entry)).e(getResources().getDrawable(R.drawable.ksad_loading_entry)).f(getResources().getDrawable(R.drawable.ksad_loading_entry)).a(new com.kwad.components.ct.b.a(strAT, this.azr));
        if (z) {
            if (DX()) {
                gVar = new o();
            } else {
                gVar = new g();
            }
            fVarA = (f) fVarA.b(gVar).a(k.class, new n(gVar)).b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e<WebpFrameCacheStrategy>>) com.kwad.sdk.glide.webp.decoder.o.caY, (com.kwad.sdk.glide.load.e<WebpFrameCacheStrategy>) WebpFrameCacheStrategy.caT).b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e<p>>) com.kwad.sdk.glide.webp.decoder.o.caZ, (com.kwad.sdk.glide.load.e<p>) p.cbi).a(h.bTs);
        }
        if (this.aDX == null) {
            this.aDX = new com.kwad.sdk.glide.request.a.d(this.aDW).autoStartAnimatable(En());
        }
        fVarA.b((f) this.aDX);
    }

    private void setBackgroundImageView(String str) {
        if (DX()) {
            this.aDY.setVisibility(0);
            com.kwad.sdk.core.d.c.d("EntryPhotoView", "blurBackgroundUrl=" + str);
            com.kwad.sdk.glide.c.cy(getContext()).hh(str).d(getContext().getResources().getDrawable(R.drawable.ksad_blur_def_bg)).e(getContext().getResources().getDrawable(R.drawable.ksad_blur_def_bg)).f(getContext().getResources().getDrawable(R.drawable.ksad_blur_def_bg)).a(new com.kwad.components.ct.b.a(str, this.azr)).b(this.aDY);
            return;
        }
        this.aDY.setVisibility(8);
    }

    private boolean DX() {
        com.kwad.sdk.core.response.model.b bVarAC = com.kwad.components.ct.response.a.a.aC(this.azr);
        return com.kwad.components.ct.entry.a.b.DX() && bVarAC.getHeight() * 3 < bVarAC.getWidth() * 4;
    }

    public void setPlayBtnRes(int i) {
        this.akD.setImageResource(i);
    }

    public final void Eu() {
        if (this.aDW == null || !En()) {
            return;
        }
        Drawable drawable = this.aDW.getDrawable();
        if (drawable instanceof k) {
            k kVar = (k) drawable;
            if (kVar.isRunning()) {
                return;
            }
            kVar.start();
        }
    }

    public final void Ev() {
        WebpAnimationImageView webpAnimationImageView = this.aDW;
        if (webpAnimationImageView != null) {
            Drawable drawable = webpAnimationImageView.getDrawable();
            if (drawable instanceof k) {
                k kVar = (k) drawable;
                if (kVar.isRunning()) {
                    kVar.stop();
                }
            }
        }
    }

    public final void s(int i, String str) {
        this.abR = i;
        this.aEe = str;
    }

    public void setLikeViewPos(int i) {
        if (i == 0) {
            this.aDZ.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.aDZ.setVisibility(0);
            ((FrameLayout.LayoutParams) this.aDZ.getLayoutParams()).gravity = 83;
        } else {
            if (i != 2) {
                return;
            }
            this.aDZ.setVisibility(0);
            ((FrameLayout.LayoutParams) this.aDZ.getLayoutParams()).gravity = 85;
        }
    }

    public int getPosition() {
        return this.abR;
    }

    public String getEntryId() {
        return this.aEe;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
        if (com.kwad.components.ct.response.a.a.eH(this.azr) && this.aEm) {
            com.kwad.components.core.u.b.tq().a(this.azr, null, null);
        }
        com.kwad.components.ct.e.b.JK().b(this.azr, this.aEe);
    }

    public CtAdTemplate getTemplateData() {
        return this.azr;
    }

    private void reset() {
        this.aEd.setVisibility(8);
        this.aDZ.setVisibility(0);
        this.akD.setVisibility(0);
        this.aEh.setVisibility(8);
    }

    public void setLookMoreVisible(boolean z) {
        if (z) {
            this.aEd.setVisibility(0);
            this.aDZ.setVisibility(8);
            this.akD.setVisibility(8);
            this.mTitleTv.setVisibility(8);
            return;
        }
        this.aEd.setVisibility(8);
        this.aDZ.setVisibility(0);
        this.akD.setVisibility(0);
        this.mTitleTv.setVisibility(0);
        if (com.kwad.components.ct.response.a.a.eH(this.azr)) {
            this.aDZ.setVisibility(8);
        } else {
            this.aDZ.setVisibility(0);
        }
    }

    private void Ew() {
        com.kwad.sdk.core.d.c.d("EntryPhotoView", "initWebpObserve");
        if (this.aEb && this.aEc && com.kwad.components.ct.entry.a.b.Ea() && this.aEf == null) {
            com.kwad.components.core.widget.a.c cVar = new com.kwad.components.core.widget.a.c(this, 100);
            this.aEf = cVar;
            cVar.a(new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.10
                @Override // com.kwad.sdk.core.j.c
                public final void by() {
                    boolean zEn = EntryPhotoView.this.En();
                    if (EntryPhotoView.this.aDX != null) {
                        EntryPhotoView.this.aDX.autoStartAnimatable(zEn);
                    }
                    if (zEn) {
                        EntryPhotoView.this.Eu();
                    } else {
                        EntryPhotoView.this.Ev();
                    }
                }

                @Override // com.kwad.sdk.core.j.c
                public final void bz() {
                    if (EntryPhotoView.this.aDX != null) {
                        EntryPhotoView.this.aDX.autoStartAnimatable(false);
                    }
                    EntryPhotoView.this.Ev();
                }
            });
            if (this.mIsAttachedToWindow) {
                this.aEf.wK();
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        this.mIsAttachedToWindow = true;
        if (this.mPresenter == null) {
            this.mPresenter = bI();
        }
        this.mPresenter.ak(this);
        Eo();
        com.kwad.components.core.widget.a.c cVar = this.aEf;
        if (cVar != null) {
            cVar.wK();
        }
        if (En()) {
            Eu();
        } else {
            Ev();
        }
        com.kwad.components.core.widget.a.c cVar2 = this.aEp;
        if (cVar2 != null) {
            cVar2.wK();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        this.mIsAttachedToWindow = false;
        this.mPresenter.destroy();
        com.kwad.components.ct.entry.b.a aVar = this.aEo;
        if (aVar != null) {
            aVar.release();
        }
        release();
    }

    private void release() {
        com.kwad.components.core.widget.a.c cVar = this.aEf;
        if (cVar != null) {
            cVar.wL();
        }
        Ev();
        com.kwad.components.core.widget.a.c cVar2 = this.aEp;
        if (cVar2 != null) {
            cVar2.wL();
        }
    }

    public void setAdShowStyle(int i) {
        this.aEg = i;
    }

    private void Ex() {
        Ey();
        if (this.aEg == 2) {
            ch(44);
            z(28, 28);
            b(28, 12, 88);
            setAdMarkView(14);
            setAdTextView(12);
            return;
        }
        ch(40);
        z(22, 22);
        b(24, 10, 76);
        setAdMarkView(12);
        setAdTextView(10);
    }

    private void Ey() {
        if (!this.aEm) {
            this.aEh.inflate();
        }
        this.aEh.setVisibility(0);
        this.aEh.setClickable(true);
        this.aEh.setOnClickListener(this);
        this.aEn = (RelativeLayout) findViewById(R.id.ksad_entryitem_ad_layout);
        this.aEi = (RoundAngleImageView) findViewById(R.id.ksad_entryitem_ad_app_icon);
        this.aEk = (TextView) findViewById(R.id.ksad_entryitem_ad_btn);
        this.aEs = (EntryAdConvertButton) findViewById(R.id.ksad_entryitem_ad_btn_container);
        this.aEl = (TextView) findViewById(R.id.ksad_entryitem_ad_text);
        this.aEj = (ImageView) findViewById(R.id.ksad_entryitem_ad_mark);
    }

    private void z(int i, int i2) {
        this.aEi.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        ViewGroup.LayoutParams layoutParams = this.aEi.getLayoutParams();
        layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), i);
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i2);
        this.aEi.setClickable(true);
        this.aEi.setOnClickListener(this);
        com.kwad.sdk.glide.c.cy(getContext()).hh(com.kwad.components.ct.response.a.a.bf(this.azr)).d(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).e(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon)).a(new com.kwad.components.ct.b.a(com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), this.azr)).b(this.aEi);
    }

    private void ch(int i) {
        ViewGroup.LayoutParams layoutParams = this.aEn.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i);
        this.aEn.setClickable(true);
        this.aEn.setOnClickListener(this);
    }

    private void a(TextView textView, int i, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i);
        textView.setClickable(true);
        textView.setOnClickListener(this);
        textView.setTextSize(i2);
        textView.setMaxWidth(com.kwad.sdk.c.a.a.a(getContext(), i3));
        textView.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
    }

    private void b(int i, int i2, int i3) {
        a(this.aEk, i, i2, i3);
        setSelectedAdButton(this.azr.mHasEntryAdClick);
        this.aEq = new Runnable() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.11
            @Override // java.lang.Runnable
            public final void run() {
                EntryPhotoView.this.setSelectedAdButton(true);
                if (EntryPhotoView.this.aEu) {
                    return;
                }
                EntryPhotoView.this.Ez();
            }
        };
        com.kwad.components.core.widget.a.c cVar = new com.kwad.components.core.widget.a.c(this.aEs, 30);
        this.aEp = cVar;
        cVar.a(new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.12
            @Override // com.kwad.sdk.core.j.c
            public final void by() {
                if (EntryPhotoView.this.aEs == null || EntryPhotoView.this.aEt) {
                    return;
                }
                EntryPhotoView.this.aEt = true;
                if (EntryPhotoView.this.azr.mHasEntryAdClick) {
                    EntryPhotoView.this.setSelectedAdButton(true);
                    if (EntryPhotoView.this.aEu) {
                        return;
                    }
                    EntryPhotoView.this.Ez();
                    return;
                }
                EntryPhotoView.this.aEs.removeCallbacks(EntryPhotoView.this.aEq);
                EntryPhotoView.this.aEs.postDelayed(EntryPhotoView.this.aEq, 1300L);
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                if (EntryPhotoView.this.aEs != null && EntryPhotoView.this.aEt) {
                    EntryPhotoView.this.aEt = false;
                    EntryPhotoView entryPhotoView = EntryPhotoView.this;
                    entryPhotoView.setSelectedAdButton(entryPhotoView.azr.mHasEntryAdClick);
                    EntryPhotoView.this.EA();
                    EntryPhotoView.this.aEs.removeCallbacks(EntryPhotoView.this.aEq);
                }
            }
        });
        com.kwad.components.core.widget.a.c cVar2 = this.aEp;
        if (cVar2 != null) {
            cVar2.wK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        EntryAdConvertButton entryAdConvertButton;
        if (!com.kwad.components.ct.entry.a.b.DY() || (entryAdConvertButton = this.aEs) == null) {
            return;
        }
        entryAdConvertButton.ly();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EA() {
        if (this.aEs != null) {
            com.kwad.sdk.core.d.c.d("EntryPhotoView", "stopAdConvertBtnAnim");
            this.aEs.lz();
        }
    }

    private void setAdMarkView(final int i) {
        final KsLogoView ksLogoView = new KsLogoView(getContext(), true);
        ksLogoView.aQ(this.azr);
        ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.2
            @Override // com.kwad.components.core.widget.KsLogoView.a
            public final void bJ() {
                EntryPhotoView.this.aEj.post(new bh() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.2.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        Bitmap bitmapA = KsLogoView.a(ksLogoView);
                        int iA = com.kwad.sdk.c.a.a.a(EntryPhotoView.this.getContext(), i);
                        int width = (bitmapA.getWidth() * iA) / bitmapA.getHeight();
                        float height = iA / bitmapA.getHeight();
                        Matrix matrix = new Matrix();
                        matrix.postScale(height, height);
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(EntryPhotoView.this.getContext().getResources(), Bitmap.createBitmap(bitmapA, 0, 0, bitmapA.getWidth(), bitmapA.getHeight(), matrix, true));
                        bitmapDrawable.setBounds(0, 0, width, iA);
                        EntryPhotoView.this.aEj.setImageDrawable(bitmapDrawable);
                    }
                });
            }
        });
        ksLogoView.aQ(this.azr);
    }

    private void setAdTextView(int i) {
        this.aEl.setTextSize(i);
        String strAL = com.kwad.components.ct.response.a.a.aL(this.azr);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(this.azr)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        this.aEl.setText(strAL);
        this.aEl.setClickable(true);
        this.aEl.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectedAdButton(boolean z) {
        com.kwad.sdk.core.d.c.d("EntryPhotoView", "setButtonBackground selected=" + z);
        EntryAdConvertButton entryAdConvertButton = this.aEs;
        if (entryAdConvertButton != null) {
            entryAdConvertButton.setSelected(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(String str) {
        com.kwad.sdk.core.d.c.d("EntryPhotoView", "updateConvertBtnText txt=" + str);
        if (this.aEu) {
            EA();
        } else if (this.aEt) {
            Ez();
        }
        this.aEk.setText(str);
        ViewGroup.LayoutParams layoutParams = this.aEk.getLayoutParams();
        layoutParams.width = -2;
        this.aEk.setLayoutParams(layoutParams);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.3
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    EntryPhotoView.this.aEu = false;
                    EntryPhotoView entryPhotoView = EntryPhotoView.this;
                    entryPhotoView.bL(com.kwad.sdk.core.response.b.a.aH(entryPhotoView.mAdInfo));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    EntryPhotoView.this.aEu = false;
                    EntryPhotoView.this.bL("继续下载");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    EntryPhotoView.this.aEu = true;
                    EntryPhotoView.this.bL("下载中..." + i + "%");
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    EntryPhotoView.this.aEu = false;
                    EntryPhotoView entryPhotoView = EntryPhotoView.this;
                    entryPhotoView.bL(com.kwad.sdk.core.response.b.a.cB(entryPhotoView.azr));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    EntryPhotoView.this.aEu = false;
                    EntryPhotoView entryPhotoView = EntryPhotoView.this;
                    entryPhotoView.bL(com.kwad.sdk.core.response.b.a.aH(entryPhotoView.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    EntryPhotoView.this.aEu = false;
                    EntryPhotoView entryPhotoView = EntryPhotoView.this;
                    entryPhotoView.bL(com.kwad.sdk.core.response.b.a.ae(entryPhotoView.mAdInfo));
                }
            };
        }
        return this.fJ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        com.kwad.sdk.core.d.c.d("EntryPhotoView", "onClick v=" + view);
        if (view == this.aEi) {
            i = 55;
        } else if (view == this.aEl) {
            i = 82;
        } else if (view == this.aEk || view == this.aEs) {
            i = 83;
        } else {
            i = view == this.aEn ? 35 : 0;
        }
        this.azr.mIsFromContent = true;
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.azr).b(this.mApkDownloadHelper).aG(2).aq(true).aF(i).d(getTouchCoords()).as(true).a(new a.b() { // from class: com.kwad.components.ct.entry.view.EntryPhotoView.4
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                EntryPhotoView.this.azr.mHasEntryAdClick = true;
            }
        }));
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public aj.a getTouchCoords() {
        return aDV;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            aj.a aVar = aDV;
            aVar.ac(getWidth(), getHeight());
            aVar.p(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            aDV.q(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
