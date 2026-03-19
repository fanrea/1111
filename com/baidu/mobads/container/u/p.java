package com.baidu.mobads.container.u;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.bk;
import com.baidu.mobads.container.util.bv;
import com.component.a.g.a;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class p extends com.baidu.mobads.container.k {
    protected static final String a = "XExpressSplashAdContainer";
    public static final String b = "#000000";
    private RelativeLayout c;
    private boolean d;
    private ImageView e;
    private String f;
    private int g;

    public p(com.baidu.mobads.container.adrequest.t tVar) {
        super(tVar);
        this.d = true;
    }

    @Override // com.baidu.mobads.container.k
    protected void resetAdContainerName() {
        this.mAdContainerName = a;
    }

    @Override // com.baidu.mobads.container.k
    public void load() {
        super.load();
        com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
        com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(jVarQ.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_START);
        this.f = jVarQ.getMainPictureUrl();
        boolean zG = com.baidu.mobads.container.util.d.d.a(this.mAppContext).g(this.f);
        if (!TextUtils.isEmpty(b())) {
            com.baidu.mobads.container.util.d.d.a(this.mAppContext).e(b());
        }
        if (zG) {
            start();
            return;
        }
        try {
            loadMaterialForURLString(this.f, new q(this, jVarQ));
        } catch (Exception e) {
            processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, "StaticImage,Exception " + e.toString(), com.baidu.mobads.container.components.k.b.L);
        }
    }

    @Override // com.baidu.mobads.container.k
    protected Bitmap getCloseBitmap() {
        if (this.e != null) {
            return ((BitmapDrawable) this.e.getDrawable()).getBitmap();
        }
        return super.getCloseBitmap();
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStopOnUIThread() {
        this.mAdLogger.b(a, "doStopOnUIThread");
        if (this.c != null && this.mAdContainerCxt.v().indexOfChild(this.c) >= 0) {
            this.mAdContainerCxt.v().removeView(this.c);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void stop() {
        this.mAdState = 2;
        super.stop();
    }

    @Override // com.baidu.mobads.container.k
    public void destroy() {
        this.c = null;
        super.destroy();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        this.isSendValidSplashImpressionLoged.set(false);
        if (this.mAdState != 2) {
            boolean z = true;
            try {
                JSONObject jSONObjectW = this.mAdContainerCxt.w();
                this.d = jSONObjectW.optBoolean("Display_Down_Info", true);
                this.mPopDialogIfDl = jSONObjectW.optBoolean("popDialogIfDl", false);
                this.mLimitRegionClick = jSONObjectW.optBoolean("limitRegionClick", false);
                this.mDisplayClickButton = jSONObjectW.optBoolean(com.baidu.mobads.container.k.DISPLAY_CLICK_BUTTON, false);
                this.mShakeLogoSize = jSONObjectW.optInt("shakeLogoSize", 60);
                this.mTwistLogoHeightDp = jSONObjectW.optInt("twistLogoHeightDp", 67);
                this.mTwistBgColor = jSONObjectW.optInt("twistBgColor", -16777216);
            } catch (Exception e) {
                this.mAdLogger.a(a, e);
            }
            try {
                handleBottomView();
                com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(2, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                this.c = new RelativeLayout(this.mAdContainerCxt.t());
                this.c.setVisibility(0);
                this.c.setLayoutParams(layoutParams);
                this.c.setDrawingCacheEnabled(true);
                this.mAdContainerCxt.v().addView(this.c);
                a(this.c);
                this.c.requestLayout();
                JSONObject originJsonObject = jVarQ.getOriginJsonObject();
                String strOptString = originJsonObject.optString("tit");
                String strOptString2 = originJsonObject.optString("subtitle");
                String strOptString3 = originJsonObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
                String strTrim = strOptString.trim();
                String strTrim2 = strOptString2.trim();
                String strTrim3 = strOptString3.trim();
                if (!TextUtils.isEmpty(strTrim) || !TextUtils.isEmpty(strTrim2) || !TextUtils.isEmpty(strTrim3)) {
                    a(strOptString, strOptString2, strOptString3);
                }
                JSONObject originJsonObject2 = this.mAdContainerCxt.q().getOriginJsonObject();
                this.d = originJsonObject2.optInt("dl_info_view", this.d ? 1 : 0) == 1;
                this.mPopDialogIfDl = originJsonObject2.optInt("dl_dialog", this.mPopDialogIfDl ? 1 : 0) == 1;
                this.mLimitRegionClick = originJsonObject2.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, this.mLimitRegionClick ? 1 : 0) == 1;
                int iOptInt = originJsonObject2.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, this.mDisplayClickButton ? 2 : 0);
                if (iOptInt != 1 && iOptInt != 2) {
                    z = false;
                }
                this.mDisplayClickButton = z;
                JSONObject jSONObjectA = new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject2).a("skip_btn");
                if (jSONObjectA != null && (jSONObjectA.optInt("gravity") & 2) == 2) {
                    this.mExtraBottomMargin = bv.a(this.mAppContext, 28.0f);
                }
                if (!addMixInteractView()) {
                    if (clickRegionUsed()) {
                        addMantle();
                    }
                    addSlideView();
                    addActionView();
                    addShakeView();
                }
                addAtmosphereView();
                addBubbleView();
                doAddProgressView();
                if (this.d && !this.mPopDialogIfDl) {
                    addDownloadDescT(originJsonObject2, bv.a(this.mAppContext, 13.0f));
                }
                addLawText();
                addDspId(this.mAdContainerCxt.v(), 0);
                addAppSmallLogo();
                displayVersion4DebugMode();
                this.c.requestFocus();
            } catch (Exception e2) {
                this.mAdLogger.a(a, e2);
                processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, "exception=" + Log.getStackTraceString(e2));
            }
            com.baidu.mobads.container.d.b.a().a(new r(this));
            return;
        }
        this.mAdLogger.a("XPureStaticImageAdContainer: ad state is stopped, so can not show ad");
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
        sendRsplashExpClickLog(1);
        checkAPO(bk.C);
    }

    private void a(String str, String str2, String str3) {
        RelativeLayout relativeLayout = new RelativeLayout(this.mAdContainerCxt.t());
        int iM = this.mAdContainerCxt.m();
        double dN = this.mAdContainerCxt.n();
        Double.isNaN(dN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (dN * 0.218d));
        layoutParams.addRule(12);
        this.mAdContainerCxt.v().addView(relativeLayout, layoutParams);
        a(relativeLayout, -16777216, 0);
        double dM = this.mAdContainerCxt.m();
        Double.isNaN(dM);
        int i = (int) (dM * 0.027d);
        double d = iM;
        Double.isNaN(d);
        int i2 = (int) (0.067d * d);
        Double.isNaN(d);
        int i3 = (int) (d * 0.029d);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        layoutParams2.setMargins(i2, 0, i3, i);
        TextView textView = new TextView(this.mAdContainerCxt.t());
        textView.setText(str3);
        SpannableString spannableString = new SpannableString(textView.getText());
        spannableString.setSpan(new AbsoluteSizeSpan((iM * 32) / 1080), 0, textView.getText().length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, textView.getText().length(), 33);
        textView.setText(spannableString);
        textView.setId(1);
        relativeLayout.addView(textView, layoutParams2);
        TextView textView2 = new TextView(this.mAdContainerCxt.t());
        textView2.setText(str);
        SpannableString spannableString2 = new SpannableString(textView2.getText());
        spannableString2.setSpan(new AbsoluteSizeSpan((iM * 55) / 1080), 0, textView2.getText().length(), 33);
        spannableString2.setSpan(new StyleSpan(1), 0, textView2.getText().length(), 33);
        spannableString2.setSpan(new ForegroundColorSpan(-1), 0, textView2.getText().length(), 33);
        textView2.setText(spannableString2);
        textView2.setId(2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, textView.getId());
        int i4 = i / 2;
        layoutParams3.setMargins(i2, 0, i3, i4);
        textView2.setClickable(true);
        relativeLayout.addView(textView2, layoutParams3);
        TextView textView3 = new TextView(this.mAdContainerCxt.t());
        if (!TextUtils.isEmpty(str2)) {
            textView3.setText("  " + str2 + "  ");
        } else {
            textView3.setText("");
        }
        SpannableString spannableString3 = new SpannableString(textView3.getText());
        spannableString3.setSpan(new AbsoluteSizeSpan((iM * 30) / 1080), 0, textView3.getText().length(), 33);
        spannableString3.setSpan(new StyleSpan(1), 0, textView3.getText().length(), 33);
        spannableString3.setSpan(new ForegroundColorSpan(-16777216), 0, textView3.getText().length(), 33);
        spannableString3.setSpan(new BackgroundColorSpan(-1), 0, textView3.getText().length(), 33);
        textView3.setText(spannableString3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(2, textView2.getId());
        layoutParams4.setMargins(i2, 0, i3, i4);
        textView3.setClickable(true);
        relativeLayout.addView(textView3, layoutParams4);
    }

    public void a(View view, int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{i, i2});
        gradientDrawable.setShape(0);
        view.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.baidu.mobads.container.k, com.baidu.mobads.container.util.cn
    public void dispose() {
        super.dispose();
    }

    @Override // com.baidu.mobads.container.k
    protected int getSplashLogType() {
        return 1;
    }

    public void a(RelativeLayout relativeLayout) {
        try {
            com.component.a.g.d dVar = new com.component.a.g.d(this, this.mAdInstanceInfo);
            dVar.a(new a.C0317a().a(new s(this, this, this.mAdInstanceInfo)));
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.b.a.l, new com.component.a.f.e(a()).l(""));
            com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_START);
            if (dVar.a(relativeLayout, a(), new t(this)) == null) {
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_FAILED);
            } else {
                com.baidu.mobads.container.components.h.c.f.a(this.mAppContext).a(this.mAdInstanceInfo.getUniqueId(), com.baidu.mobads.container.components.h.a.AD_EVENT_RENDER_TEMPLATE_SUCCESS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JSONObject a() {
        return com.component.a.i.n.b(n.a);
    }

    public String b() {
        if (this.mAdInstanceInfo != null) {
            try {
                JSONObject originJsonObject = this.mAdInstanceInfo.getOriginJsonObject();
                if (originJsonObject != null) {
                    return originJsonObject.optString("bg_pic", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
