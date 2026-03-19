package com.kwad.components.ct.detail.b;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.profile.home.model.ProfileResultData;
import com.kwad.components.ct.profile.home.model.UserProfile;
import com.kwad.components.ct.request.r;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private static AccelerateDecelerateInterpolator ayq = new AccelerateDecelerateInterpolator();
    private View aoO;
    private SlidePlayViewPager aok;
    private List<com.kwad.sdk.widget.swipe.a> aot;
    private com.kwad.components.ct.detail.e.a aoz;
    private boolean asX;
    private com.kwad.sdk.widget.swipe.c avG;
    private View axN;
    private View axO;
    private RecyclerView axP;
    private TextView axQ;
    private int axR;
    private View axS;
    private ImageView axT;
    private TextView axU;
    private TextView axV;
    private int axX;
    private int axY;
    private int axZ;
    private int aya;
    private int ayb;
    private int ayc;
    private Float ayd;
    private int aye;
    private int ayf;
    private View ayg;
    private boolean ayh;
    private com.kwad.components.ct.api.a.a.c ayi;
    private boolean ayj;
    private View ayo;
    private LottieAnimationView ayp;
    private CtAdTemplate mAdTemplate;
    private l<r, ProfileResultData> mNetworking;
    private float axW = 1.0f;
    private final com.kwad.sdk.m.a.b ayk = new com.kwad.sdk.m.a.b() { // from class: com.kwad.components.ct.detail.b.d.8
        @Override // com.kwad.sdk.m.a.b
        public final boolean onBackPressed() {
            if (d.this.aok.getSourceType() == 0 || d.this.avG == null || !d.this.avG.aqZ()) {
                return false;
            }
            d.this.avG.ara();
            return true;
        }
    };
    private SlidePlayTouchViewPager.a ayl = new SlidePlayTouchViewPager.a() { // from class: com.kwad.components.ct.detail.b.d.9
        @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.a
        public final void Cp() {
        }

        @Override // com.kwad.components.ct.detail.viewpager.SlidePlayTouchViewPager.a
        public final void Cq() {
            d.this.ayj = true;
        }
    };
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.d.10
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            d.this.bA(true);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            d.this.bA(true);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            d.this.bA(false);
        }
    };
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.d.11
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            d.this.ayh = true;
            d.this.Cl();
            if (d.this.avG != null) {
                d.this.avG.a(d.this.aym);
            }
            if (d.this.aok.getSourceType() == 1) {
                com.kwad.sdk.lib.widget.a.d dVar = (com.kwad.sdk.lib.widget.a.d) d.this.axP.getAdapter();
                if (dVar != null) {
                    com.kwad.components.ct.home.d.b bVar = (com.kwad.components.ct.home.d.b) dVar.getAdapter();
                    com.kwad.components.ct.home.d.c cVarHa = bVar.Ha();
                    d.this.ayi.b(bVar.Hb(), d.this.mAdTemplate);
                    bVar.S(d.this.ayg);
                    bVar.a(d.this.mAdTemplate, d.this.aoz);
                    cVarHa.v(d.this.mAdTemplate);
                    com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "scrollVerticallyToPosition becomesAttachedOnPageSelected");
                    d.this.axP.removeCallbacks(d.this.ayr);
                    d.this.axP.removeCallbacks(d.this.ays);
                    d.this.axP.post(d.this.ayr);
                    cVarHa.a(d.this.ayn);
                    d.this.axP.addOnScrollListener(d.this.asg);
                }
                com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "becomesAttachedOnPageSelected mPosition" + d.this.aop.abR + "--mSourceType=PROFILE--headerFooterAdapter=" + dVar);
            } else {
                com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "becomesAttachedOnPageSelected mPosition" + d.this.aop.abR + "--mSourceType=FEED--headerFooterAdapter=" + d.this.axP.getAdapter());
            }
            d.this.ayj = false;
            d.this.aok.a(d.this.ayl);
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            d.this.ayh = false;
            if (d.this.avG.aqY() == d.this.aym) {
                d.this.avG.a((com.kwad.sdk.widget.swipe.a) null);
            }
            d.this.axP.removeCallbacks(d.this.ayr);
            com.kwad.sdk.lib.widget.a.d dVar = (com.kwad.sdk.lib.widget.a.d) d.this.axP.getAdapter();
            if (dVar != null) {
                com.kwad.components.ct.home.d.b bVar = (com.kwad.components.ct.home.d.b) dVar.getAdapter();
                com.kwad.components.ct.home.d.c cVarHa = bVar.Ha();
                if (d.this.aok.getSourceType() == 0) {
                    if (d.this.ayo != null) {
                        dVar.removeFooterView(d.this.ayo);
                        d.this.ayp.Qa();
                        d.a(d.this, (View) null);
                    }
                    cVarHa.b(d.this.ayn);
                    cVarHa.release();
                    bVar.rT();
                    d.this.axP.removeOnScrollListener(d.this.asg);
                    d.this.axP.setAdapter(null);
                    d.this.aeI.removeCallbacksAndMessages(null);
                } else {
                    cVarHa.b(d.this.ayn);
                    cVarHa.release();
                }
            }
            com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "becomesDetachedOnPageSelected mPosition" + d.this.aop.abR + "--mSourceType=" + d.this.aok.getSourceType() + "--headerFooterAdapter=" + d.this.axP.getAdapter());
            d.this.aok.b(d.this.ayl);
        }
    };
    private final com.kwad.sdk.widget.swipe.a aym = new com.kwad.sdk.widget.swipe.a() { // from class: com.kwad.components.ct.detail.b.d.12
        @Override // com.kwad.sdk.widget.swipe.a
        public final float m(float f) {
            if (d.this.ayd == null) {
                d dVar = d.this;
                dVar.ayd = Float.valueOf(dVar.axO.getTranslationX());
            }
            if (d.this.ayd.floatValue() == 0.0f) {
                if (f < 0.0f) {
                    return 0.0f;
                }
                return Math.min(1.0f, (Math.abs(f) * 1.0f) / d.this.ayc);
            }
            if (f > 0.0f) {
                return 1.0f;
            }
            return Math.max(0.0f, 1.0f - ((Math.abs(f) * 1.0f) / d.this.ayc));
        }

        @Override // com.kwad.sdk.widget.swipe.a
        public final void j(float f) {
            if (d.this.ayh) {
                if (d.this.axP.getAdapter() == null) {
                    d.this.Cf();
                }
                d.this.axW = f;
                d.this.k(f);
                if (f == 1.0f) {
                    d.this.axS.setVisibility(8);
                } else {
                    d.this.axS.setVisibility(0);
                }
                Iterator it = d.this.aot.iterator();
                while (it.hasNext()) {
                    ((com.kwad.sdk.widget.swipe.a) it.next()).j(f);
                }
            }
        }

        @Override // com.kwad.sdk.widget.swipe.a
        public final void n(float f) {
            if (d.this.ayh) {
                Iterator it = d.this.aot.iterator();
                while (it.hasNext()) {
                    ((com.kwad.sdk.widget.swipe.a) it.next()).n(f);
                }
            }
        }

        @Override // com.kwad.sdk.widget.swipe.a
        public final void o(float f) {
            if (d.this.ayh) {
                d.this.Ck();
                ag.dD(d.this.getContext());
                d.this.aok.setEnabled(false);
                Iterator it = d.this.aot.iterator();
                while (it.hasNext()) {
                    ((com.kwad.sdk.widget.swipe.a) it.next()).o(f);
                }
            }
        }

        @Override // com.kwad.sdk.widget.swipe.a
        public final void p(float f) {
            if (d.this.ayh) {
                d.this.ayd = null;
                d.this.axW = f;
                com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "updateFeed onSwipeFinish mPosition" + d.this.aop.abR + "--mSourceType=" + d.this.aok.getSourceType());
                d.this.Cj();
                Iterator it = d.this.aot.iterator();
                while (it.hasNext()) {
                    ((com.kwad.sdk.widget.swipe.a) it.next()).p(f);
                }
                if (f == 0.0f) {
                    com.kwad.components.ct.e.b.JK().X(d.this.mAdTemplate);
                }
                if (f == 1.0f) {
                    d.this.axS.setVisibility(8);
                } else {
                    d.this.axS.setVisibility(0);
                }
            }
        }
    };
    private com.kwad.components.ct.api.a.a.b ayn = new com.kwad.components.ct.api.a.a.b() { // from class: com.kwad.components.ct.detail.b.d.13
        @Override // com.kwad.components.ct.api.a.a.b
        public final void a(boolean z, boolean z2, int i, int i2) {
            if (z2) {
                d.this.Ch();
            }
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void c(boolean z, int i, int i2) {
            com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "updateFeed onFinishLoading mPosition" + d.this.aop.abR + "--mSourceType=" + d.this.aok.getSourceType());
            if (z) {
                d.this.Ce();
                d.this.Cj();
                d.this.axP.removeCallbacks(d.this.ayr);
                d.this.axP.removeCallbacks(d.this.ays);
                d.this.axP.post(d.this.ays);
            } else {
                d.this.Ce();
                d.this.Cj();
            }
            d.this.Ci();
        }

        @Override // com.kwad.components.ct.api.a.a.b
        public final void onError(int i, String str) {
            d.this.Ci();
            com.kwad.components.ct.home.d.c cVarHa = ((com.kwad.components.ct.home.d.b) ((com.kwad.sdk.lib.widget.a.d) d.this.axP.getAdapter()).getAdapter()).Ha();
            if (d.this.ayj || cVarHa.isEmpty()) {
                if (com.kwad.sdk.core.network.e.bCw.errorCode == i) {
                    ac.dm(d.this.getContext());
                } else if (com.kwad.sdk.core.network.e.bCI.errorCode != i) {
                    ac.dn(d.this.getContext());
                } else if (com.kwad.sdk.core.config.e.isShowTips()) {
                    ac.m462do(d.this.getContext());
                }
            }
        }
    };
    private Runnable ayr = new Runnable() { // from class: com.kwad.components.ct.detail.b.d.2
        @Override // java.lang.Runnable
        public final void run() {
            d.this.bB(true);
        }
    };
    private Runnable ays = new Runnable() { // from class: com.kwad.components.ct.detail.b.d.3
        @Override // java.lang.Runnable
        public final void run() {
            d.this.bB(false);
        }
    };
    private RecyclerView.OnScrollListener asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.detail.b.d.4
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                d.this.c(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (i > 0 || i2 > 0) {
                d.this.c(recyclerView);
            }
        }
    };
    private Handler aeI = new Handler();

    static /* synthetic */ View a(d dVar, View view) {
        dVar.ayo = null;
        return null;
    }

    static /* synthetic */ boolean e(d dVar, boolean z) {
        dVar.asX = false;
        return false;
    }

    private void a(KsFragment ksFragment, j jVar) {
        if (this.aoO != null) {
            return;
        }
        View view = ksFragment.getParentFragment().getView();
        this.aoO = view;
        this.axN = view.findViewById(R.id.ksad_home_content_layout);
        this.aok = (SlidePlayViewPager) this.aoO.findViewById(R.id.ksad_slide_play_view_pager);
        this.axR = R.id.ksad_content_home_author_id;
        this.axQ = (TextView) this.aoO.findViewById(R.id.ksad_home_profile_title);
        this.axS = this.aoO.findViewById(R.id.ksad_home_profile_bottom_layout);
        this.axT = (ImageView) this.aoO.findViewById(R.id.ksad_home_profile_author_icon);
        this.axU = (TextView) this.aoO.findViewById(R.id.ksad_home_profile_author_name);
        this.axV = (TextView) this.aoO.findViewById(R.id.ksad_home_profile_author_photo_count);
        this.axO = this.aoO.findViewById(R.id.ksad_home_profile_layout);
        this.axP = (RecyclerView) this.aoO.findViewById(R.id.ksad_home_profile_recycler_view);
        this.ayc = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_slide_profile_width);
        this.axZ = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_slide_profile_margin);
        this.aya = this.ayc;
        this.aye = com.kwad.sdk.c.a.a.a(getContext(), 5.0f);
        this.ayf = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_slide_profile_item_height) + this.aye;
        this.avG = jVar.avG;
        this.ayi = jVar.ayi;
        if (this.axP.getLayoutManager() == null) {
            this.axP.setLayoutManager(new LinearLayoutManager(this.axP.getContext()));
            this.axP.setItemAnimator(null);
            this.axP.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.kwad.components.ct.detail.b.d.1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public final void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
                    rect.set(0, recyclerView.getChildAdapterPosition(view2) == 0 ? 0 : d.this.aye, 0, 0);
                }
            });
        }
        this.axT.setOnClickListener(this);
        this.axU.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ayg = findViewById(R.id.ksad_video_control_button);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        a(this.aop.aoy, this.aop.aol);
        this.aeI.post(new bh() { // from class: com.kwad.components.ct.detail.b.d.7
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                d dVar = d.this;
                dVar.axX = dVar.aoO.getWidth();
                d dVar2 = d.this;
                dVar2.axY = dVar2.aoO.getHeight();
                d.this.ayb = (int) (((((r0.axX - d.this.axZ) - d.this.aya) * 1.0f) / d.this.axX) * d.this.axY);
                com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "mScaledHeight=" + d.this.ayb + "--mHomeFragmentWidth" + d.this.axX + "--mHomeFragmentHeight=" + d.this.axY);
                if (d.this.axP.getHeight() != d.this.ayb) {
                    ViewGroup.LayoutParams layoutParams = d.this.axP.getLayoutParams();
                    layoutParams.height = d.this.ayb;
                    d.this.axP.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = d.this.axS.getLayoutParams();
                    layoutParams2.height = (d.this.axY - d.this.ayb) / 2;
                    d.this.axS.setLayoutParams(layoutParams2);
                }
            }
        });
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aot = this.aop.aot;
        this.aop.aoq.add(this.aoQ);
        this.axW = this.aok.getSourceType() == 1 ? 0.0f : 1.0f;
        com.kwad.components.ct.detail.e.a aVar = this.aop.aoz;
        this.aoz = aVar;
        if (aVar != null) {
            aVar.c(this.mVideoPlayStateListener);
        }
        this.aop.aol.aFo.addBackPressable(this.ayk, 0);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
        com.kwad.components.ct.detail.e.a aVar = this.aoz;
        if (aVar != null) {
            aVar.d(this.mVideoPlayStateListener);
        }
        this.aop.aol.aFo.removeBackPressable(this.ayk);
        Cm();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.axP.removeCallbacks(this.ayr);
        this.axP.removeCallbacks(this.ays);
        this.aeI.removeCallbacksAndMessages(null);
        Cm();
        com.kwad.sdk.lib.widget.a.d dVar = (com.kwad.sdk.lib.widget.a.d) this.axP.getAdapter();
        if (dVar != null) {
            com.kwad.components.ct.home.d.b bVar = (com.kwad.components.ct.home.d.b) dVar.getAdapter();
            com.kwad.components.ct.home.d.c cVarHa = bVar.Ha();
            cVarHa.b(this.ayn);
            cVarHa.release();
            bVar.rT();
            this.axP.removeOnScrollListener(this.asg);
            this.axP.setAdapter(null);
            LottieAnimationView lottieAnimationView = this.ayp;
            if (lottieAnimationView != null) {
                lottieAnimationView.Qa();
            }
        }
        try {
            k(1.0f);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        com.kwad.components.ct.api.a.a.c cVar = this.ayi;
        if (cVar.a(cVar.xd())) {
            this.aok.a(this.mAdTemplate, 0, false);
        }
        this.aok.setEnabled(true);
        this.aok.b(this.ayl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        com.kwad.sdk.lib.widget.a.d dVar = (com.kwad.sdk.lib.widget.a.d) this.axP.getAdapter();
        if (dVar != null) {
            ((com.kwad.components.ct.home.d.b) dVar.getAdapter()).a(this.mAdTemplate, this.ayg, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        com.kwad.components.ct.home.d.b bVar = (com.kwad.components.ct.home.d.b) ((com.kwad.sdk.lib.widget.a.d) this.axP.getAdapter()).getAdapter();
        bVar.aC(bVar.Ha().xc());
        bVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf() {
        com.kwad.sdk.core.d.c.d("DetailProfileSlidePresenter", "updateProfileFeed mPosition" + this.aop.abR + "--mSourceType=" + this.aok.getSourceType());
        com.kwad.components.ct.home.d.c cVar = new com.kwad.components.ct.home.d.c(this.mAdTemplate.mAdScene);
        cVar.v(this.mAdTemplate);
        com.kwad.components.ct.home.d.b bVar = new com.kwad.components.ct.home.d.b(this.aop.aoy.getParentFragment(), this.axP, this.aok);
        bVar.S(this.ayg);
        bVar.a(this.mAdTemplate, this.aoz);
        bVar.aC(cVar.xc());
        bVar.a(cVar);
        com.kwad.sdk.lib.widget.a.d dVar = new com.kwad.sdk.lib.widget.a.d(bVar);
        View viewCg = Cg();
        this.ayo = viewCg;
        if (!dVar.ad(viewCg)) {
            dVar.addFooterView(this.ayo);
        }
        dVar.d(this.axP);
        this.axP.setAdapter(dVar);
        cVar.a(this.ayn);
        this.axP.addOnScrollListener(this.asg);
        cVar.refresh(0);
    }

    private View Cg() {
        View view = this.ayo;
        if (view != null) {
            return view;
        }
        View viewA = com.kwad.sdk.c.a.a.a((ViewGroup) this.axP, R.layout.ksad_content_slide_home_profile_loading_more, false);
        this.ayo = viewA;
        this.ayp = (LottieAnimationView) viewA.findViewById(R.id.ksad_loading_lottie);
        com.kwad.components.ct.d.a.Jd().b(this.ayp, false);
        this.ayp.setRepeatMode(1);
        this.ayp.setRepeatCount(-1);
        return this.ayo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        if (this.ayo == null) {
            return;
        }
        this.ayp.PZ();
        this.ayp.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        if (this.ayo == null) {
            return;
        }
        this.ayp.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(final float f) {
        this.axO.setTranslationX(this.ayc * f);
        if (this.axX > 0) {
            l(f);
        } else {
            this.aeI.post(new bh() { // from class: com.kwad.components.ct.detail.b.d.14
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    d.this.l(f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(float f) {
        int width = this.aoO.getWidth();
        this.axX = width;
        if (width > 0) {
            this.axN.setPivotX(((this.axZ * 1.0f) / (r1 + this.ayc)) * width);
            float f2 = 1.0f - (((this.ayc + this.axZ) * (1.0f - f)) / this.axX);
            try {
                this.axN.setScaleX(f2);
                this.axN.setScaleY(f2);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        float f = this.axW;
        if (f == 1.0f) {
            com.kwad.components.ct.api.a.a.c cVar = this.ayi;
            if (cVar.a(cVar.xd())) {
                this.mAdTemplate.mIsLeftSlipStatus = 0;
                this.aok.a(this.mAdTemplate, 0, false);
            }
            this.aok.setEnabled(true);
            return;
        }
        if (f == 0.0f) {
            com.kwad.components.ct.home.d.b bVar = (com.kwad.components.ct.home.d.b) ((com.kwad.sdk.lib.widget.a.d) this.axP.getAdapter()).getAdapter();
            com.kwad.components.ct.home.d.c cVarHa = bVar.Ha();
            if (cVarHa.isEmpty()) {
                return;
            }
            if (this.ayi.a(cVarHa)) {
                this.mAdTemplate.mIsLeftSlipStatus = 1;
                bVar.cv(this.ayi.aX(this.mAdTemplate));
                this.aok.a(this.mAdTemplate, 1, false);
            } else {
                com.kwad.components.ct.detail.viewpager.b adapter = this.aok.getAdapter();
                List<CtAdTemplate> listXc = this.ayi.xc();
                CtAdTemplate ctAdTemplate = this.mAdTemplate;
                adapter.a(listXc, ctAdTemplate, 1, this.ayi.aX(ctAdTemplate), false);
            }
            if (cVarHa.xc().size() <= 1) {
                this.aok.setEnabled(false);
            } else {
                this.aok.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        int iIndexOf;
        com.kwad.sdk.lib.widget.a.d dVar = (com.kwad.sdk.lib.widget.a.d) this.axP.getAdapter();
        if (dVar == null || (iIndexOf = ((com.kwad.components.ct.home.d.b) dVar.getAdapter()).akS().indexOf(this.mAdTemplate)) == -1) {
            return;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.axP.getLayoutManager();
        int height = this.axP.getHeight();
        if (!z) {
            int i = this.ayf;
            linearLayoutManager.scrollToPositionWithOffset(iIndexOf, ((height - i) / 2) - (iIndexOf != 0 ? this.aye + ((height % i) / 2) : 0));
            return;
        }
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iIndexOf);
        if (viewFindViewByPosition != null) {
            this.axP.smoothScrollBy(0, o(viewFindViewByPosition, height), ayq);
            return;
        }
        int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (iIndexOf < iFindFirstVisibleItemPosition) {
            this.axP.smoothScrollBy(0, ((-(iFindFirstVisibleItemPosition - iIndexOf)) * this.ayf) + o(linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition), height), ayq);
        } else if (iIndexOf > iFindLastVisibleItemPosition) {
            this.axP.smoothScrollBy(0, ((iIndexOf - iFindLastVisibleItemPosition) * this.ayf) + o(linearLayoutManager.findViewByPosition(iFindLastVisibleItemPosition), height), ayq);
        }
    }

    private static int o(View view, int i) {
        if (view == null) {
            return 0;
        }
        return view.getTop() - ((i - (view.getBottom() - view.getTop())) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(RecyclerView recyclerView) {
        com.kwad.components.ct.home.d.b bVar = (com.kwad.components.ct.home.d.b) ((com.kwad.sdk.lib.widget.a.d) this.axP.getAdapter()).getAdapter();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        com.kwad.components.ct.home.d.c cVarHa = bVar.Ha();
        if (layoutManager.getChildCount() <= 0 || !b(cVarHa)) {
            return;
        }
        if (((RecyclerView.LayoutParams) layoutManager.getChildAt(layoutManager.getChildCount() - 1).getLayoutParams()).getViewAdapterPosition() >= bVar.getItemCount() - 1) {
            cVarHa.bk(false);
        }
    }

    private static boolean b(com.kwad.components.ct.api.a.a.a aVar) {
        return (aVar == null || aVar.xc() == null || aVar.xc().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        SceneImpl sceneImpl;
        final long jE = com.kwad.components.ct.response.a.c.e(this.mAdTemplate.photoInfo);
        String str = (String) this.axV.getTag(this.axR);
        if ((TextUtils.isEmpty(str) || !str.equals(String.valueOf(jE))) && !this.asX && this.ayh && (sceneImpl = this.mAdTemplate.mAdScene) != null) {
            this.asX = true;
            final ImpInfo impInfo = new ImpInfo(sceneImpl);
            impInfo.pageScene = sceneImpl.getPageScene();
            l<r, ProfileResultData> lVar = new l<r, ProfileResultData>() { // from class: com.kwad.components.ct.detail.b.d.5
                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ BaseResultData parseData(String str2) {
                    return bB(str2);
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                /* renamed from: Cn, reason: merged with bridge method [inline-methods] */
                public r createRequest() {
                    return new r(impInfo, jE);
                }

                private static ProfileResultData bB(String str2) {
                    JSONObject jSONObject = new JSONObject(str2);
                    ProfileResultData profileResultData = new ProfileResultData();
                    profileResultData.parseJson(jSONObject);
                    return profileResultData;
                }
            };
            this.mNetworking = lVar;
            lVar.request(new com.kwad.sdk.core.network.o<r, ProfileResultData>() { // from class: com.kwad.components.ct.detail.b.d.6
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str2) {
                    Co();
                }

                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                    a((ProfileResultData) baseResultData);
                }

                private void a(final ProfileResultData profileResultData) {
                    d.this.aeI.post(new bh() { // from class: com.kwad.components.ct.detail.b.d.6.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            d.this.a(profileResultData.userProfile);
                            d.e(d.this, false);
                        }
                    });
                }

                private void Co() {
                    d.e(d.this, false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cl() {
        long jE = com.kwad.components.ct.response.a.c.e(this.mAdTemplate.photoInfo);
        String str = (String) this.axS.getTag(this.axR);
        if (TextUtils.isEmpty(str) || !str.equals(String.valueOf(jE))) {
            KSImageLoader.loadCircleIconWithoutStroke(this.axT, com.kwad.components.ct.response.a.a.bf(this.mAdTemplate), getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon_2));
            this.axS.setTag(this.axR, String.valueOf(jE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UserProfile userProfile) {
        long jE = com.kwad.components.ct.response.a.c.e(this.mAdTemplate.photoInfo);
        if (jE == userProfile.authorId) {
            this.axQ.setText(bA(userProfile.authorGender));
            this.axU.setText(userProfile.authorName);
            this.axV.setText("作品 " + bq.bB(userProfile.ownerCount.publicPhotoCount));
            this.axV.setTag(this.axR, String.valueOf(jE));
        }
    }

    private void Cm() {
        l<r, ProfileResultData> lVar = this.mNetworking;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    private static String bA(String str) {
        return "M".equalsIgnoreCase(str) ? "他的作品" : "F".equalsIgnoreCase(str) ? "她的作品" : "ta的作品";
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.sdk.c.a.a.Wl()) {
            return;
        }
        if (view == this.axT || view == this.axU) {
            AF();
        }
    }

    private void AF() {
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl != null) {
            BV();
            ProfileHomeParam profileHomeParam = new ProfileHomeParam();
            profileHomeParam.mEntryScene = sceneImpl.entryScene;
            profileHomeParam.mCurrentPhotoId = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
            profileHomeParam.mAdTemplate = this.mAdTemplate;
            com.kwad.components.ct.profile.home.a.a(getContext(), profileHomeParam);
            this.mAdTemplate.mIsNotNeedAvatarGuider = true;
        }
    }

    private void BV() {
        com.kwad.components.ct.e.b.JK().c(this.mAdTemplate, 5, 3);
    }
}
