package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.u.r;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private ViewGroup DU;
    private ImageView Pe;
    private WindowManager WX;
    private com.kwad.components.core.page.splitLandingPage.a.a WY;
    private FrameLayout WZ;
    private FrameLayout Xa;
    private f Xb;
    private final WindowManager.LayoutParams Xc = new WindowManager.LayoutParams();
    private InterfaceC0482a Xd;
    private com.kwad.sdk.core.video.videoview.a ed;
    private a.InterfaceC0593a em;
    private ImageView jF;
    private Context mContext;

    /* renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0482a {
        boolean rX();
    }

    public final void a(InterfaceC0482a interfaceC0482a) {
        this.Xd = interfaceC0482a;
    }

    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
        this.mContext = contextWrapContextIfNeed;
        this.WY = aVar;
        WindowManager windowManager = (WindowManager) contextWrapContextIfNeed.getSystemService("window");
        this.WX = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.DU = viewGroup;
        this.WZ = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.Xa = (FrameLayout) this.DU.findViewById(R.id.ksad_video_container);
        this.jF = (ImageView) this.DU.findViewById(R.id.ksad_video_first_frame_container);
        this.Pe = (ImageView) this.DU.findViewById(R.id.ksad_split_mini_close_btn);
        this.WZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float Xe = 0.0f;
            float Xf = 0.0f;
            float top = 0.0f;
            float left = 0.0f;
            long Xg = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.Xc == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Xe = motionEvent.getRawX();
                    this.Xf = motionEvent.getRawY();
                    this.left = a.this.Xc.x;
                    this.top = a.this.Xc.y;
                    this.Xg = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.Xe + " actionDownX " + this.Xe);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.Xe;
                        float rawY = motionEvent.getRawY() - this.Xf;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.Xc.x = (int) (this.left + rawX);
                            a.this.Xc.y = (int) (this.top + rawY);
                            if (a.this.WX != null) {
                                try {
                                    a.this.WX.updateViewLayout(a.this.DU, a.this.Xc);
                                } catch (Exception e) {
                                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                                    c.printStackTraceOnly(e);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.Xe;
                        float rawY2 = motionEvent.getRawY() - this.Xf;
                        float fElapsedRealtime = SystemClock.elapsedRealtime() - this.Xg;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && fElapsedRealtime > 30.0f && fElapsedRealtime < 300.0f && a.this.Xd != null && a.this.WY != null && com.kwad.sdk.core.response.b.a.aJ(e.eP(a.this.WY.getAdTemplate()))) {
                            a.this.Xd.rX();
                        }
                    }
                }
                return true;
            }
        });
    }

    public final void rW() {
        this.Xb.af();
    }

    public final boolean isVisible() {
        return this.DU.getAlpha() > 0.0f;
    }

    public final boolean rZ() {
        if (this.WY == null || this.WX == null) {
            return false;
        }
        c(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.WY.getAdTemplate().mIsAudioEnable).build());
        AdInfo adInfoEP = e.eP(this.WY.getAdTemplate());
        int iS = com.kwad.sdk.core.response.b.a.S(adInfoEP);
        int iR = com.kwad.sdk.core.response.b.a.R(adInfoEP);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (iS > iR) {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.top = rect.bottom - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
        } else {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.top = rect.bottom - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
        }
        rect.left -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        rect.right -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Xc.type = 1003;
        this.Xc.flags = 8;
        this.Xc.gravity = 51;
        this.Xc.format = 1;
        this.Xc.width = displayMetrics.widthPixels;
        this.Xc.height = displayMetrics.heightPixels;
        this.Xc.x = rect.left;
        this.Xc.y = rect.top;
        this.Xc.width = (rect.right - rect.left) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Xc.height = (rect.bottom - rect.top) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.DU.setPivotX((rect.left * displayMetrics.widthPixels) / ((rect.left + displayMetrics.widthPixels) - rect.right));
        this.DU.setPivotY((rect.top * displayMetrics.heightPixels) / ((rect.top + displayMetrics.heightPixels) - rect.bottom));
        this.DU.setAlpha(0.0f);
        if (this.WX != null) {
            try {
                if (this.DU.getWindowToken() == null) {
                    this.WX.addView(this.DU, this.Xc);
                }
            } catch (Exception e) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e);
                c.printStackTraceOnly(e);
            }
        }
        this.Pe.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.rW();
                a.this.aL(false).start();
            }
        });
        return true;
    }

    private void c(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        final AdTemplate adTemplate = this.WY.getAdTemplate();
        AdInfo adInfoEP = e.eP(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.bA(adInfoEP).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, adTemplate);
            this.jF.setVisibility(0);
        } else {
            this.jF.setVisibility(8);
        }
        String strL = com.kwad.sdk.core.response.b.a.L(adInfoEP);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVarFW = AdVideoPlayerViewCache.getInstance().fW(strL);
        this.ed = aVarFW;
        if (aVarFW == null) {
            this.ed = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.ad(adInfoEP);
            this.ed.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).ew(e.eR(adTemplate)).ex(h.e(e.eQ(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).WR(), null);
            a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
                public final com.kwad.sdk.core.video.a.c aw() {
                    int i = Build.VERSION.SDK_INT;
                    return null;
                }
            };
            this.em = interfaceC0593a;
            this.ed.setExternalPlayerListener(interfaceC0593a);
            this.ed.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            f fVar = new f(this.mContext, adTemplate, this.ed, ksAdVideoPlayConfig);
            this.Xb = fVar;
            fVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.ed.setController(this.Xb);
            this.Xb.setAutoRelease(false);
        } else {
            f fVar2 = (f) aVarFW.getController();
            this.Xb = fVar2;
            fVar2.setAutoRelease(false);
            this.Xb.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.ed.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.ed.getParent() != null) {
            ((ViewGroup) this.ed.getParent()).removeView(this.ed);
        }
        if (this.Xa.getTag() != null) {
            FrameLayout frameLayout = this.Xa;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Xa.setTag(null);
        }
        this.Xa.addView(this.ed);
        this.Xa.setTag(this.ed);
        this.Xb.setAlpha(0.01f);
        this.Xb.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.4
            @Override // com.kwad.components.core.video.a.c
            public final void au() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                a.this.rW();
                a.this.aL(false).start();
            }
        });
    }

    public final void sa() {
        com.kwad.sdk.core.video.videoview.a aVar = this.ed;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Xb.ur();
    }

    public final Animator aL(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(r.h(this.DU, z), r.h(this.jF, z));
        return animatorSet;
    }
}
