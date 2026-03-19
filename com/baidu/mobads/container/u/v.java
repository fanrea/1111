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
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class v extends com.baidu.mobads.container.k {
    protected static final String a = "XPureStaticImageAdContainer";
    public static final int b = 16;
    public static final int c = 17;
    public static final String d = "#000000";
    protected ImageView e;
    private Bitmap f;
    private int g;
    private boolean h;
    private String i;
    private int j;

    public v(com.baidu.mobads.container.adrequest.t tVar) {
        super(tVar);
        this.g = 16;
        this.h = true;
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
        this.i = jVarQ.getMainPictureUrl();
        if (com.baidu.mobads.container.util.d.d.a(this.mAppContext).g(this.i)) {
            start();
            return;
        }
        try {
            loadMaterialForURLString(this.i, new w(this, jVarQ));
        } catch (Exception e) {
            processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, "StaticImage,Exception " + e.toString(), com.baidu.mobads.container.components.k.b.L);
        }
    }

    @Override // com.baidu.mobads.container.k
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStopOnUIThread() {
        try {
            this.mAdLogger.b(a, "doStopOnUIThread");
            if (this.e != null && this.mAdContainerCxt.v().indexOfChild(this.e) >= 0) {
                this.mAdLogger.b(a, "doStopOnUIThread release imageView");
                this.mAdContainerCxt.v().removeView(this.e);
            }
            if (this.f != null) {
                this.f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.k
    public void stop() {
        this.mAdState = 2;
        super.stop();
    }

    @Override // com.baidu.mobads.container.k
    public void destroy() {
        this.e = null;
        super.destroy();
    }

    @Override // com.baidu.mobads.container.k
    protected void doStartOnUIThread() {
        this.isSendValidSplashImpressionLoged.set(false);
        if (this.mAdState != 2) {
            boolean z = true;
            try {
                JSONObject jSONObjectW = this.mAdContainerCxt.w();
                this.g = jSONObjectW.optInt("bitmapDisplayMode", 16);
                this.h = jSONObjectW.optBoolean("Display_Down_Info", true);
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
                if (this.g == 0) {
                    this.g = 16;
                }
                com.baidu.mobads.container.adrequest.j jVarQ = this.mAdContainerCxt.q();
                if (a(jVarQ.getOriginJsonObject()) == 0) {
                    this.g = 17;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(2, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                this.e = new ImageView(this.mAdContainerCxt.t());
                this.e.setVisibility(0);
                this.e.setOnClickListener(new x(this));
                this.e.setOnTouchListener(new y(this));
                this.e.setLayoutParams(layoutParams);
                a(this.e);
                this.e.setDrawingCacheEnabled(true);
                if (this.f != null && !this.f.isRecycled()) {
                    this.e.setImageBitmap(this.f);
                    this.e.setBackgroundResource(0);
                } else if (this.mAppContext != null && this.mAdInstanceInfo != null) {
                    String mainPictureUrl = this.mAdInstanceInfo.getMainPictureUrl();
                    z zVar = new z(this);
                    zVar.a(mainPictureUrl);
                    com.baidu.mobads.container.util.d.d.a(this.mAppContext).a(this.e, mainPictureUrl, zVar);
                }
                this.mAdContainerCxt.v().addView(this.e);
                this.e.requestLayout();
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
                this.h = originJsonObject2.optInt("dl_info_view", this.h ? 1 : 0) == 1;
                this.mPopDialogIfDl = originJsonObject2.optInt("dl_dialog", this.mPopDialogIfDl ? 1 : 0) == 1;
                this.j = this.mLimitRegionClick ? 1 : 0;
                this.j = originJsonObject2.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, this.j);
                this.mLimitRegionClick = this.j == 1;
                int iOptInt = originJsonObject2.optInt(com.baidu.mobads.container.k.CC_REGION_CLICK, this.mDisplayClickButton ? 2 : 0);
                if (iOptInt != 1 && iOptInt != 2) {
                    z = false;
                }
                this.mDisplayClickButton = z;
                JSONObject jSONObjectA = new com.baidu.mobads.container.components.i.a(this.mAppContext, originJsonObject2).a("skip_btn");
                if (jSONObjectA != null && (jSONObjectA.optInt("gravity") & 2) == 2) {
                    this.mExtraBottomMargin = bv.a(this.mAppContext, 28.0f);
                }
                displayVersion4DebugMode();
                if (!addMixInteractView()) {
                    if (clickRegionUsed()) {
                        addMantle();
                    }
                    addSlideView();
                    addActionView();
                    addShakeView();
                }
                addAppSmallLogo();
                doAddProgressView();
                addBubbleView();
                addAtmosphereView();
                addLawText();
                addDspId(this.mAdContainerCxt.v(), 0);
                if (this.h && !this.mPopDialogIfDl) {
                    addDownloadDescT(originJsonObject2, bv.a(this.mAppContext, 13.0f));
                }
                this.e.requestFocus();
            } catch (Exception e2) {
                this.mAdLogger.a(a, e2);
                processAdError(com.baidu.mobads.container.c.a.MCACHE_FETCH_FAILED, "exception=" + Log.getStackTraceString(e2));
            }
            com.baidu.mobads.container.d.b.a().a(new aa(this));
            return;
        }
        this.mAdLogger.a("XPureStaticImageAdContainer: ad state is stopped, so can not show ad");
    }

    @Override // com.baidu.mobads.container.k
    public Bitmap getCloseBitmap() {
        if (this.e != null) {
            return ((BitmapDrawable) this.e.getDrawable()).getBitmap();
        }
        return super.getCloseBitmap();
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

    private void a(ImageView imageView) {
        switch (this.g) {
            case 16:
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                getSplashTransition().a(ImageView.ScaleType.FIT_XY);
                break;
            case 17:
                if (imageView != null) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                getSplashTransition().a(ImageView.ScaleType.CENTER_CROP);
                break;
        }
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
        double d2 = iM;
        Double.isNaN(d2);
        int i2 = (int) (0.067d * d2);
        Double.isNaN(d2);
        int i3 = (int) (d2 * 0.029d);
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

    @Override // com.baidu.mobads.container.k
    protected int getSplashLogType() {
        return 1;
    }
}
