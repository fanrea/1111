package com.baidu.mobads.container.g;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.s.ap;
import com.baidu.mobads.container.util.SPUtils;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bv;
import java.io.FileInputStream;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class i extends ap {
    protected FileInputStream a;
    protected SPUtils b;
    protected com.baidu.mobads.container.adrequest.j c;
    private boolean f;
    private d g;

    public i(t tVar) {
        super(tVar);
        this.f = true;
        this.b = new SPUtils(this.mAppContext, com.baidu.mobads.container.h.c);
        this.c = tVar.q();
    }

    @Override // com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = "XGifAdContainer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            this.a = new FileInputStream(str);
        } catch (Exception e) {
        }
        start();
    }

    @Override // com.baidu.mobads.container.s.ap, com.baidu.mobads.container.k
    public void load() {
        super.load();
        com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
        com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVarQ.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_START);
        String localCreativeURL = jVarQ.getLocalCreativeURL();
        if (!TextUtils.isEmpty(localCreativeURL)) {
            a(localCreativeURL);
            return;
        }
        String mainPictureUrl = jVarQ.getMainPictureUrl();
        try {
            if (!com.baidu.mobads.container.util.d.d.a(this.mAppContext).g(mainPictureUrl)) {
                loadMaterialForURLString(mainPictureUrl, new j(this, jVarQ));
            } else {
                a(com.baidu.mobads.container.util.d.d.a(this.mAppContext).c(mainPictureUrl));
            }
        } catch (Throwable th) {
            processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, "gif渲染失败", com.baidu.mobads.container.components.k.b.L);
        }
    }

    @Override // com.baidu.mobads.container.k
    protected Bitmap getCloseBitmap() {
        if (this.g != null) {
            return this.g.a();
        }
        return super.getCloseBitmap();
    }

    @Override // com.baidu.mobads.container.k
    public void doLoadOnUIThread() {
    }

    @Override // com.baidu.mobads.container.k
    public void resize(int i, int i2) {
    }

    @Override // com.baidu.mobads.container.k
    public void pause() {
    }

    @Override // com.baidu.mobads.container.k
    public void resume() {
    }

    @Override // com.baidu.mobads.container.k
    public void stop() {
        this.mAdState = 2;
        doStopOnUIThread();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        try {
            this.isSendValidSplashImpressionLoged.set(false);
            if (this.mAdState != 2) {
                handleBottomView();
                this.g = new d(this.mAdContainerCxt.t(), new k(this));
                this.g.a(this.a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(2, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                this.g.setLayoutParams(layoutParams);
                RelativeLayout relativeLayoutV = this.mAdContainerCxt.v();
                if (relativeLayoutV != null) {
                    relativeLayoutV.setOnTouchListener(new l(this));
                    this.g.a(relativeLayoutV.getWidth(), relativeLayoutV.getHeight());
                }
                this.g.b(255);
                this.g.setOnClickListener(new m(this));
                this.g.e();
                this.mAdContainerCxt.v().addView(this.g);
                this.g.requestLayout();
                JSONObject originJsonObject = this.mAdContainerCxt.q().getOriginJsonObject();
                JSONObject jSONObjectW = this.mAdContainerCxt.w();
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
                this.g.a = new n(this, originJsonObject);
                displayVersion4DebugMode();
                return;
            }
            this.mAdLogger.a("XGifAdContainer: ad state is stopped, so can not show ad");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.k
    public void handlePause(com.baidu.mobads.container.adrequest.j jVar) {
        super.handlePause(jVar);
    }

    @Override // com.baidu.mobads.container.k
    public void handleResume(com.baidu.mobads.container.adrequest.j jVar) {
        super.handleResume(jVar);
    }

    @Override // com.baidu.mobads.container.k
    public void onAdClick(com.baidu.mobads.container.adrequest.j jVar, View view) {
        com.baidu.mobads.container.v.a.a(this.mAdContainerCxt, 9, false, 3, 424, this.showRecord, "2");
        checkAPO(bk.E);
    }

    @Override // com.baidu.mobads.container.k, com.baidu.mobads.container.util.cn
    public void dispose() {
    }

    @Override // com.baidu.mobads.container.k
    protected int getSplashLogType() {
        return 3;
    }
}
