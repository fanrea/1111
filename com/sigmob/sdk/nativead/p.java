package com.sigmob.sdk.nativead;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ImageUtils;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.windad.WindAdError;
import java.io.File;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class p extends q implements j, com.sigmob.sdk.videoplayer.b {
    public static LinkedList<ViewGroup> e = new LinkedList<>();
    public static long f = 0;
    private com.sigmob.sdk.videoplayer.f h;
    private m i;
    private r j;
    private Bitmap k;
    private Bitmap l;
    private ViewGroup m;
    private Context n;
    private long o;

    /* renamed from: com.sigmob.sdk.nativead.p$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.values().length];
            a = iArr;
            try {
                iArr[h.PREVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.DETAIL_PAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[h.DETAIL_PAGE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public p(Context context) {
        super(context.getApplicationContext());
        this.k = null;
        this.l = null;
        this.n = context.getApplicationContext();
        getVideoAdView().setVideoAdViewListener(this);
        this.m = new RelativeLayout(this.n);
        getVideoAdView().setVideoAdStatusListener(this);
        com.sigmob.sdk.base.blurkit.a.a(this.n);
    }

    private void a(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(Build.VERSION.SDK_INT >= 21 ? 5894 : 4);
    }

    private void a(ViewGroup adContainer) {
        l lVar = null;
        for (int i = 0; i < adContainer.getChildCount(); i++) {
            View childAt = adContainer.getChildAt(i);
            if (childAt instanceof l) {
                lVar = (l) childAt;
            }
        }
        if (lVar == null) {
            return;
        }
        com.sigmob.sdk.base.utils.o.a(lVar);
    }

    private void b(Activity activity) {
        int iAsIntPixels = Dips.asIntPixels(10.0f, this.n);
        int iAsIntPixels2 = Dips.asIntPixels(15.0f, this.n);
        int iA = com.sigmob.sdk.videoplayer.c.a(activity);
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView.getVideoHeight() < videoAdView.getVideoWidth()) {
            activity.setRequestedOrientation(0);
            iAsIntPixels += iA;
        } else {
            iAsIntPixels2 += iA;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoAdView.getBottomLayoutView().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setMargins(Dips.asIntPixels(10.0f, this.n), 0, iAsIntPixels, iAsIntPixels2);
            videoAdView.getBottomLayoutView().setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoAdView.getTopLayoutView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.setMargins(Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(35.0f, this.n), iAsIntPixels, 0);
            videoAdView.getTopLayoutView().setLayoutParams(layoutParams2);
        }
    }

    private void k() {
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoAdView.getBottomLayoutView().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.setMargins(Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(0.0f, this.n), Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(15.0f, this.n));
            videoAdView.getBottomLayoutView().setLayoutParams(layoutParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoAdView.getTopLayoutView().getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.setMargins(Dips.asIntPixels(10.0f, this.n), Dips.asIntPixels(15.0f, this.n), Dips.asIntPixels(10.0f, this.n), 0);
            videoAdView.getTopLayoutView().setLayoutParams(layoutParams2);
        }
    }

    private void l() {
        if (this.i == null) {
            return;
        }
        ViewGroup appContainer = getVideoAdView().getAppContainer();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        appContainer.addView(this.i, layoutParams);
    }

    private void m() {
        Bitmap textureBitmap;
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView == null || (textureBitmap = videoAdView.getTextureBitmap()) == null) {
            return;
        }
        Bitmap bitmapA = com.sigmob.sdk.base.blurkit.a.a().a(textureBitmap, 25);
        videoAdView.getBlurImageView().setImageBitmap(bitmapA);
        videoAdView.getAppContainer().setVisibility(0);
        this.k = textureBitmap;
        this.l = bitmapA;
    }

    private void n() {
        l appInfoView = getAppInfoView();
        if (appInfoView == null) {
            return;
        }
        com.sigmob.sdk.base.utils.o.a(appInfoView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, Dips.asIntPixels(5.0f, this.n));
        layoutParams.addRule(12);
        addView(appInfoView, layoutParams);
    }

    public int a(int width) {
        return Math.min((int) (width / (getVideoAdView().getVideoWidth() == 0 ? getAdUnit().getAdPercent() : (r0.getVideoWidth() * 1.0f) / r0.getVideoHeight())), ClientMetadata.getInstance().getDisplayMetrics().heightPixels / 2);
    }

    @Override // com.sigmob.sdk.nativead.j
    public void a() {
        j sigAdVideoStatusListener = getSigAdVideoStatusListener();
        if (sigAdVideoStatusListener == null) {
            return;
        }
        sigAdVideoStatusListener.a();
    }

    @Override // com.sigmob.sdk.nativead.j
    public void a(long current, long duration) {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().a(current, duration);
        }
        if (current > 0) {
            this.o = duration;
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void a(aa listener) {
        super.a(listener);
        BaseAdUnit adUnit = getAdUnit();
        if (adUnit == null) {
            return;
        }
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        a(this);
        File videoProxyFile = adUnit.getVideoProxyFile();
        videoAdView.setUp((videoProxyFile == null || !videoProxyFile.exists()) ? adUnit.getProxyVideoUrl() : videoProxyFile.getAbsolutePath());
        setUIStyle(h.PREVIEW);
        if (TextUtils.isEmpty(adUnit.getVideoCoverImageUrl())) {
            videoAdView.b(true);
        } else {
            Context contextE = com.sigmob.sdk.b.e();
            if (com.sigmob.sdk.base.utils.n.b(contextE)) {
                ImageManager.with(contextE).load(adUnit.getVideoCoverImageUrl()).into(videoAdView.getThumbView());
            }
        }
        getAppView().a(adUnit.getIconUrl(), adUnit.getTitle(), adUnit.getCTAText());
        videoAdView.setSoundChange(getAdConfig().n());
    }

    @Override // com.sigmob.sdk.nativead.k
    public boolean a(MotionEvent event) {
        m mVar = this.i;
        if (mVar == null || mVar.getParent() == null || this.i.getVisibility() != 0) {
            return false;
        }
        return com.sigmob.sdk.base.utils.o.a(this.i.getCtaView(), event);
    }

    @Override // com.sigmob.sdk.nativead.k, com.sigmob.sdk.videoplayer.b
    public boolean b() {
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView == null) {
            return false;
        }
        if (!e.isEmpty()) {
            videoAdView.u();
            return true;
        }
        if (!e.isEmpty() || videoAdView.x == 0) {
            return false;
        }
        videoAdView.m();
        return true;
    }

    @Override // com.sigmob.sdk.nativead.q, com.sigmob.sdk.nativead.k
    public void c() {
        super.c();
        ImageUtils.recycleBitmap(this.k);
        ImageUtils.recycleBitmap(this.l);
        r rVar = this.j;
        if (rVar != null) {
            rVar.d();
            this.j.i();
            this.j = null;
        }
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            com.sigmob.sdk.base.utils.o.a(this.m);
        }
        com.sigmob.sdk.videoplayer.f fVar = this.h;
        if (fVar != null) {
            com.sigmob.sdk.base.utils.o.a(fVar);
            this.h.setVideoAdViewListener(null);
            this.h.setVideoAdStatusListener(null);
            this.h.setBackClickListener(null);
            this.h.a();
            this.h = null;
        }
    }

    @Override // com.sigmob.sdk.nativead.k
    public void d() {
        super.d();
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView != null) {
            videoAdView.E();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void e() {
        super.e();
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView == null) {
            return;
        }
        videoAdView.C();
    }

    @Override // com.sigmob.sdk.videoplayer.b
    public void f() {
        ViewGroup viewGroup = (ViewGroup) this.m.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.m);
        }
        Activity activityB = com.sigmob.sdk.videoplayer.c.b(e.getLast().getContext());
        if (activityB != null) {
            activityB.getWindow().getDecorView().setSystemUiVisibility(0);
        }
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth() && activityB != null) {
            activityB.setRequestedOrientation(1);
        }
        e.getLast().removeAllViews();
        e.getLast().addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        e.pop();
    }

    @Override // com.sigmob.sdk.videoplayer.b
    public void g() {
        ViewGroup viewGroup = (ViewGroup) this.m.getParent();
        viewGroup.removeView(this.m);
        e.add(viewGroup);
        Activity activityB = com.sigmob.sdk.videoplayer.c.b(viewGroup.getContext());
        if (activityB == null) {
            return;
        }
        ((ViewGroup) activityB.findViewById(R.id.content)).addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        if (getVideoAdView().getVideoHeight() < getVideoAdView().getVideoWidth()) {
            activityB.setRequestedOrientation(6);
        }
    }

    public m getAppView() {
        if (this.i == null) {
            this.i = new m(this.n);
        }
        return this.i;
    }

    public j getSigAdVideoStatusListener() {
        r rVar = this.j;
        if (rVar == null) {
            return null;
        }
        return rVar.g();
    }

    @Override // com.sigmob.sdk.nativead.k
    public r getSigVideoAdController() {
        if (this.j == null) {
            this.j = new s(getVideoAdView());
        }
        return this.j;
    }

    public com.sigmob.sdk.videoplayer.f getVideoAdView() {
        if (this.h == null) {
            this.h = new com.sigmob.sdk.videoplayer.f(this.n);
        }
        return this.h;
    }

    public ViewGroup getVideoContainer() {
        return this.m;
    }

    @Override // com.sigmob.sdk.nativead.q
    public double getVideoDuration() {
        return getVideoAdView() == null ? super.getVideoDuration() : r0.getDuration() / 1000.0f;
    }

    @Override // com.sigmob.sdk.nativead.q
    public double getVideoProgress() {
        return getVideoAdView() == null ? super.getVideoProgress() : ((r0.getCurrentPositionWhenPlaying() * 1.0f) / r0.getDuration()) / 100.0f;
    }

    public int getVideoSurferViewHeight() {
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView == null) {
            return 0;
        }
        return videoAdView.getVideoSurferViewHeight();
    }

    public void h() {
        if (System.currentTimeMillis() - f > 2000 && getVideoAdView().w == 4 && getVideoAdView().x == 1) {
            f = System.currentTimeMillis();
            b();
        }
    }

    @Override // com.sigmob.sdk.nativead.q
    public void i() {
        super.i();
    }

    @Override // com.sigmob.sdk.nativead.q
    public void j() {
        super.j();
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView == null) {
            return;
        }
        videoAdView.D();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoCompleted() {
        if (getSigAdVideoStatusListener() != null) {
            getSigAdVideoStatusListener().onVideoCompleted();
        }
        m();
        if (this.d != h.PREVIEW) {
            if (this.d == h.DETAIL_PAGE) {
                setUIStyle(h.DETAIL_PAGE_END);
            }
        } else {
            if (getAppView().getParent() == null) {
                l();
            }
            getAppView().setVisibility(0);
            getVideoAdView().a(com.sigmob.sdk.videoplayer.e.RETRY, true);
        }
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoError(WindAdError adError) {
        j sigAdVideoStatusListener = getSigAdVideoStatusListener();
        if (sigAdVideoStatusListener == null) {
            return;
        }
        sigAdVideoStatusListener.onVideoError(adError);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoLoad() {
        j sigAdVideoStatusListener = getSigAdVideoStatusListener();
        if (sigAdVideoStatusListener == null) {
            return;
        }
        sigAdVideoStatusListener.onVideoLoad();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoPause() {
        j sigAdVideoStatusListener = getSigAdVideoStatusListener();
        if (sigAdVideoStatusListener == null) {
            return;
        }
        sigAdVideoStatusListener.onVideoPause();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoResume() {
        j sigAdVideoStatusListener = getSigAdVideoStatusListener();
        if (sigAdVideoStatusListener == null) {
            return;
        }
        sigAdVideoStatusListener.onVideoResume();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
    public void onVideoStart() {
        if (getAdUnit() == null) {
            return;
        }
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        m mVar = this.i;
        if (mVar != null) {
            com.sigmob.sdk.base.utils.o.a(mVar);
            videoAdView.getAppContainer().setVisibility(4);
        }
        ImageUtils.recycleBitmap(this.k);
        ImageUtils.recycleBitmap(this.l);
        BaseAdUnit adUnit = getAdUnit();
        if (adUnit != null) {
            adUnit.updateRealAdPercent((videoAdView.getVideoWidth() * 1.0f) / videoAdView.getVideoHeight());
        }
        setUIStyle(this.d == h.DETAIL_PAGE_END ? h.DETAIL_PAGE : this.d);
        j sigAdVideoStatusListener = getSigAdVideoStatusListener();
        if (sigAdVideoStatusListener == null) {
            return;
        }
        sigAdVideoStatusListener.onVideoStart();
    }

    public void setBackClickListener(View.OnClickListener onClickListener) {
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        if (videoAdView == null) {
            return;
        }
        videoAdView.setBackClickListener(onClickListener);
    }

    @Override // com.sigmob.sdk.nativead.q
    public void setUIStyle(h style) {
        if (getAdUnit() == null) {
            return;
        }
        com.sigmob.sdk.videoplayer.f videoAdView = getVideoAdView();
        super.setUIStyle(style);
        int i = AnonymousClass1.a[style.ordinal()];
        if (i == 1) {
            this.m.removeAllViews();
            com.sigmob.sdk.base.utils.o.a(this.m);
            com.sigmob.sdk.base.utils.o.a(getVideoAdView());
            addView(videoAdView, new RelativeLayout.LayoutParams(-1, -1));
            videoAdView.a(com.sigmob.sdk.videoplayer.e.START, videoAdView.w == 0);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.FULLSCREEN, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.VOLUME, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.BIGRETRY, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.RETRY, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.BACK, false);
            videoAdView.setSoundChange(getAdConfig().n());
            if (this.i != null && (videoAdView.w == 6 || videoAdView.w == 7)) {
                if (this.i.getParent() == null) {
                    l();
                }
                this.i.setVisibility(0);
                videoAdView.a(com.sigmob.sdk.videoplayer.e.RETRY, true);
            }
            n();
            return;
        }
        if (i == 2) {
            if (this.i.getParent() != null) {
                this.i.setVisibility(4);
            }
            if (this.m.getChildCount() > 0) {
                this.m.removeAllViews();
            }
            removeView(getVideoAdView());
            this.m.addView(videoAdView, new RelativeLayout.LayoutParams(-1, -1));
            videoAdView.setSoundChange(getAdConfig().o() || com.sigmob.sdk.b.g());
            videoAdView.a(com.sigmob.sdk.videoplayer.e.START, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.FULLSCREEN, true);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.VOLUME, true);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.BIGRETRY, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.RETRY, false);
        } else {
            if (i != 3) {
                return;
            }
            if (this.i.getParent() != null) {
                this.i.setVisibility(4);
            }
            videoAdView.a(com.sigmob.sdk.videoplayer.e.START, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.FULLSCREEN, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.VOLUME, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.RETRY, false);
            videoAdView.a(com.sigmob.sdk.videoplayer.e.BIGRETRY, true);
        }
        videoAdView.a(com.sigmob.sdk.videoplayer.e.BACK, true);
    }
}
