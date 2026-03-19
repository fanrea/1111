package com.baidu.mobads.container.x.a;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.s.ap;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.ce;
import com.baidu.mobads.container.util.cm;
import com.component.player.AdVideoViewListener;
import com.component.player.w;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends ap {
    private static boolean g;
    AtomicInteger a;
    int b;
    private com.component.player.c c;
    private boolean f;
    private Handler h;
    private Runnable i;
    private AdVideoViewListener.a j;
    private AdVideoViewListener.b k;
    private AdVideoViewListener l;

    public a(t tVar) {
        super(tVar);
        this.f = true;
        this.a = new AtomicInteger(0);
        this.b = 0;
        this.h = new Handler();
        this.i = new b(this);
        this.j = new g(this);
        this.k = new h(this);
        this.l = new j(this);
    }

    private void e() {
        try {
            this.c = new com.component.player.c(this.mAppContext);
            if (a(this.mAdContainerCxt.q().getOriginJsonObject()) != 0) {
                this.c.a(2);
            } else {
                this.c.a(7);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
            layoutParams.addRule(13);
            layoutParams.addRule(2, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            if (this.mAdContainerCxt.v() != null) {
                this.mAdContainerCxt.v().addView(this.c, layoutParams);
            }
            this.c.a(this.l);
            this.c.a(this.j);
            this.c.a(this.k);
            this.c.e();
            this.c.i();
            this.c.b(true);
            this.c.a(this.d.getVideoUrl());
            this.c.setOnClickListener(new d(this));
        } catch (Exception e) {
            closeAd("video_container_excepiton_constructor_" + e.toString());
        }
    }

    @Override // com.baidu.mobads.container.s.ap, com.baidu.mobads.container.k
    public void load() {
        try {
            super.load();
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.d.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_START);
            ce.b(this.d, null);
            e();
            start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        this.isSendValidSplashImpressionLoged.set(false);
        try {
            handleBottomView();
            if (this.c != null) {
                this.c.d();
                com.baidu.mobads.container.adrequest.j jVar = this.d;
                t tVar = this.mAdContainerCxt;
                double dG = this.c.g();
                Double.isNaN(dG);
                ce.a(jVar, tVar, 0, dG / 1000.0d);
            }
            JSONObject jSONObjectW = this.mAdContainerCxt.w();
            JSONObject originJsonObject = this.mAdContainerCxt.q().getOriginJsonObject();
            this.f = jSONObjectW.optBoolean("Display_Down_Info", true);
            this.f = originJsonObject.optInt("dl_info_view", this.f ? 1 : 0) == 1;
            this.mPopDialogIfDl = jSONObjectW.optBoolean("popDialogIfDl", false);
            this.mPopDialogIfDl = originJsonObject.optInt("dl_dialog", this.mPopDialogIfDl ? 1 : 0) == 1;
            this.mLimitRegionClick = jSONObjectW.optBoolean("limitRegionClick", false);
            this.mLimitRegionClick = originJsonObject.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, this.mLimitRegionClick ? 1 : 0) == 1;
            this.mDisplayClickButton = jSONObjectW.optBoolean(com.baidu.mobads.container.k.DISPLAY_CLICK_BUTTON, false);
            int iOptInt = originJsonObject.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, this.mDisplayClickButton ? 2 : 0);
            this.mDisplayClickButton = iOptInt == 1 || iOptInt == 2;
            JSONObject jSONObjectA = new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject).a("skip_btn");
            if (jSONObjectA != null && (jSONObjectA.optInt("gravity") & 2) == 2) {
                this.mExtraBottomMargin = bv.a(this.mAppContext, 28.0f);
            }
            this.mShakeLogoSize = jSONObjectW.optInt("shakeLogoSize", 60);
            this.mTwistLogoHeightDp = jSONObjectW.optInt("twistLogoHeightDp", 67);
            this.mTwistBgColor = jSONObjectW.optInt("twistBgColor", -16777216);
            i();
        } catch (Throwable th) {
            closeAd("video_container_excepiton_doStartOnUIThread_" + th.toString());
        }
    }

    @Override // com.baidu.mobads.container.k
    public Bitmap getCloseBitmap() {
        long jG;
        if (this.c == null) {
            jG = 1;
        } else {
            if (this.c.c instanceof TextureView) {
                return ((TextureView) this.c.c).getBitmap();
            }
            jG = this.c.g();
            if (jG == 0) {
                jG = this.c.l();
            }
        }
        return w.a().b(this.mAppContext, this.d.getVideoUrl(), jG);
    }

    @Override // com.baidu.mobads.container.k
    public void onAttachedToWindow() {
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        c();
    }

    @Override // com.baidu.mobads.container.k
    public void onWindowVisibilityChanged(int i) {
    }

    @Override // com.baidu.mobads.container.k
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            com.baidu.mobads.container.util.h.a(new e(this));
            if (this.c != null) {
                this.c.b();
                if (!this.clickSkip) {
                    double dF = f();
                    Double.isNaN(dF);
                    double d = dF / 1000.0d;
                    double d2 = this.b;
                    Double.isNaN(d2);
                    ce.a(d, d2 / 1000.0d, this.d, this.mAdContainerCxt, 0, this.reasonValue);
                    this.reasonValue = 7;
                    this.b = f();
                    return;
                }
                return;
            }
            return;
        }
        com.baidu.mobads.container.util.h.a(new f(this));
        if (this.c != null) {
            this.c.c();
            com.baidu.mobads.container.adrequest.j jVar = this.d;
            t tVar = this.mAdContainerCxt;
            double dF2 = f();
            Double.isNaN(dF2);
            ce.a(jVar, tVar, 0, dF2 / 1000.0d);
        }
    }

    private int f() {
        if (this.c == null) {
            return 0;
        }
        return this.c.g();
    }

    protected void b() {
        g = true;
        this.h.postDelayed(this.i, 200L);
    }

    protected void c() {
        g = false;
        if (this.i != null) {
            this.h.removeCallbacks(this.i);
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        g = false;
    }

    @Override // com.baidu.mobads.container.k
    public void closeAd(String str) {
        if ("user_close".equals(str) || "completion".equals(str) || "video_onError".equals(str)) {
            if ("user_close".equals(str)) {
                this.reasonValue = 6;
            } else if ("completion".equals(str)) {
                this.reasonValue = 5;
            } else if ("video_onError".equals(str)) {
                this.reasonValue = 7;
            }
            double dF = f();
            Double.isNaN(dF);
            double d = dF / 1000.0d;
            double d2 = this.b;
            Double.isNaN(d2);
            ce.a(d, d2 / 1000.0d, this.d, this.mAdContainerCxt, 0, this.reasonValue);
            this.reasonValue = 7;
        }
        c();
        super.closeAd(str);
    }

    @Override // com.baidu.mobads.container.k
    protected void resetAdContainerName() {
    }

    @Override // com.baidu.mobads.container.k
    protected void doLoadOnUIThread() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.a.incrementAndGet() == 2) {
                com.baidu.mobads.container.d.b.a().a(new i(this));
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.mobads.container.k
    public View getAdView() {
        return this.c;
    }

    @Override // com.baidu.mobads.container.s.ap, com.baidu.mobads.container.k
    public void destroy() {
        this.c = null;
        super.destroy();
    }

    @Override // com.baidu.mobads.container.k
    public void handlePause(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adDownloadWindow", 1));
        }
        this.reasonValue = 1;
        com.baidu.mobads.container.util.h.a(new k(this));
    }

    @Override // com.baidu.mobads.container.k
    public void handleResume(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar != null && this.mAdContainerCxt != null) {
            this.mAdContainerCxt.s().dispatchEvent(new cm("adDownloadWindow", 0));
        }
        this.reasonValue = 7;
        com.baidu.mobads.container.util.h.a(new c(this));
    }

    @Override // com.baidu.mobads.container.k
    public void onAdClick(com.baidu.mobads.container.adrequest.j jVar, View view) {
        checkAPO(bk.f741K);
        com.baidu.mobads.container.v.a.a(this.mAdContainerCxt, 9, false, 4, 424, this.showRecord, "2");
    }

    private int a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optInt("allow_stretch", 1);
            } catch (Throwable th) {
                return 1;
            }
        }
        return 1;
    }

    private boolean j() {
        File file;
        String localCreativeURL = this.d.getLocalCreativeURL();
        if (TextUtils.isEmpty(localCreativeURL)) {
            file = null;
        } else {
            file = new File(localCreativeURL);
        }
        return file != null && file.exists();
    }

    @Override // com.baidu.mobads.container.k
    protected void onSplashAdClick(String str, com.baidu.mobads.container.o.b bVar) {
        this.reasonValue = 1;
    }

    @Override // com.baidu.mobads.container.k
    protected int getSplashLogType() {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        by.a aVarA = by.a.a(this.mAppContext).a(602).a(this.mAdContainerCxt.z()).c(this.mAdContainerCxt.k()).b(this.mAdContainerCxt.l()).a("reason", str).a(cm.V, str2).a(this.d);
        if (this.c != null) {
            aVarA.a(this.c.j().g());
        }
        aVarA.f();
    }
}
