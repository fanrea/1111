package com.component.a.g.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.container.util.ab;
import com.component.a.f.e;
import com.component.a.g.c.e;
import com.style.widget.marketing.RemoteMarketingTextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k extends e {
    private static final String a = "fb_app_name";
    private static final String b = "fb_jxtj";
    private static final String c = "fb_temp_a";
    private static final String d = "fb_desc";
    private static final String e = "fb_icon";
    private static final String f = "fb_buyer";
    private static final String g = "fb_comments";
    private static final String h = "fb_version";
    private static final String i = "fb_big_pic";
    private static final String j = "fb_blur";
    private static final String k = "cta_name";
    private static final String l = "super_view";
    private static final String m = "fd_close";
    private static final String n = "fb_dl_pub";
    private static final String o = "fb_dl_pri";
    private static final String p = "fb_dl_per";
    private static final String q = "fb_dl_ver";
    private static final String r = "fb_dl_fun";
    private static final String s = "fb_app_name_smart2";

    public k(Context context, com.baidu.mobads.container.adrequest.j jVar, e.a aVar) {
        super(context, jVar, aVar);
    }

    @Override // com.component.a.g.c.e
    public void onCreateView(com.component.a.f.d dVar) throws JSONException {
        String strS;
        JSONObject jSONObjectF;
        String strOptString;
        JSONArray jSONArrayOptJSONArray;
        e.i iVarG;
        super.onCreateView(dVar);
        if (dVar == null) {
            return;
        }
        View viewE = dVar.e();
        com.component.a.f.e eVarF = dVar.f();
        if (eVarF == null) {
            strS = null;
        } else {
            strS = eVarF.s("");
        }
        if (this.mAdInfo != null && viewE != null && !TextUtils.isEmpty(strS)) {
            if (TextUtils.equals(strS, a)) {
                a(viewE, a());
            } else if (TextUtils.equals(strS, d)) {
                if (TextUtils.isEmpty(this.mAdInfo.getDescription())) {
                    a(viewE, this.mAdInfo.getTitle());
                }
            } else if (TextUtils.equals(strS, e)) {
                if (TextUtils.isEmpty(this.mAdInfo.getIconUrl()) && (viewE instanceof ImageView)) {
                    String mainPictureUrl = this.mAdInfo.getMainPictureUrl();
                    if (!TextUtils.isEmpty(mainPictureUrl)) {
                        com.baidu.mobads.container.util.d.d.a(this.mAppContext).a((ImageView) viewE, mainPictureUrl);
                        Drawable background = viewE.getBackground();
                        if (background instanceof ShapeDrawable) {
                            ((ShapeDrawable) background).getPaint().setAlpha(255);
                        }
                    } else {
                        com.component.b.a.a().a((ImageView) viewE, "ic_fallback");
                    }
                }
            } else if (TextUtils.equals(strS, s)) {
                if (TextUtils.isEmpty(this.mAdInfo.getAppName())) {
                    a(viewE, "智能优选");
                }
            } else if (TextUtils.equals(strS, g)) {
                int iA = a(RemoteRewardActivity.JSON_BANNER_COMMENTS_ID, 0);
                if (iA <= 0) {
                    a(viewE, String.valueOf(com.baidu.mobads.container.util.ab.a(1000, 10000)));
                } else if (iA >= 10000) {
                    a(viewE, a(iA));
                }
            } else if (TextUtils.equals(strS, h)) {
                if (viewE instanceof com.component.a.a.q) {
                    int iC = 20;
                    if (eVarF != null && (iVarG = eVarF.g()) != null) {
                        iC = iVarG.c(20);
                    }
                    a((com.component.a.a.q) viewE, iC);
                }
            } else if (TextUtils.equals(strS, i)) {
                if (TextUtils.isEmpty(this.mAdInfo.getMainPictureUrl()) && (viewE instanceof ImageView)) {
                    JSONObject originJsonObject = this.mAdInfo.getOriginJsonObject();
                    if (originJsonObject == null || (jSONArrayOptJSONArray = originJsonObject.optJSONArray("morepics")) == null || jSONArrayOptJSONArray.length() <= 0) {
                        strOptString = "";
                    } else {
                        strOptString = jSONArrayOptJSONArray.optString(0);
                    }
                    if (!TextUtils.isEmpty(strOptString)) {
                        com.baidu.mobads.container.util.d.d.a(this.mAppContext).a((ImageView) viewE, strOptString);
                    } else {
                        viewE.setVisibility(8);
                    }
                }
            } else if (TextUtils.equals(strS, c)) {
                String strA = a();
                if (strA.length() > 11) {
                    strA = strA.substring(0, 10) + "...";
                }
                a(viewE, strA);
            } else if (TextUtils.equals(strS, b)) {
                String appName = this.mAdInfo.getAppName();
                if (TextUtils.isEmpty(appName)) {
                    appName = "精选推荐";
                }
                a(viewE, appName);
            } else if (TextUtils.equals(strS, j)) {
                a(viewE, eVarF);
            } else if (eVarF != null && TextUtils.equals(l, eVarF.s(""))) {
                com.component.a.d.c cVarB = this.mFlyweight.b();
                if (cVarB != null) {
                    cVarB.a(viewE, eVarF, this.mFlyweight.a(-2));
                }
            } else if (TextUtils.equals(strS, f)) {
                a(viewE, a(this.mAdInfo.getBuyer()));
            } else if (TextUtils.equals(strS, q) && viewE != null) {
                if (this.mAdInfo != null && this.mAdInfo.getOriginJsonObject() != null && TextUtils.isEmpty(this.mAdInfo.getOriginJsonObject().optString("app_version", ""))) {
                    viewE.setVisibility(8);
                }
            } else if (TextUtils.equals(strS, n) && viewE != null) {
                if (this.mAdInfo != null && this.mAdInfo.getOriginJsonObject() != null && TextUtils.isEmpty(this.mAdInfo.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.I, ""))) {
                    viewE.setVisibility(8);
                }
            } else if (TextUtils.equals(strS, o) && viewE != null) {
                if (this.mAdInfo != null && this.mAdInfo.getOriginJsonObject() != null && TextUtils.isEmpty(this.mAdInfo.getOriginJsonObject().optString("privacy_link", ""))) {
                    viewE.setVisibility(8);
                }
            } else if (TextUtils.equals(strS, p) && viewE != null) {
                if (this.mAdInfo != null && this.mAdInfo.getOriginJsonObject() != null && TextUtils.isEmpty(this.mAdInfo.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.L, ""))) {
                    viewE.setVisibility(8);
                }
            } else if (TextUtils.equals(strS, r) && viewE != null) {
                if (this.mAdInfo != null && this.mAdInfo.getOriginJsonObject() != null && TextUtils.isEmpty(this.mAdInfo.getOriginJsonObject().optString(com.baidu.mobads.container.components.command.j.M, ""))) {
                    viewE.setVisibility(8);
                }
            } else if (TextUtils.equals(strS, m) && eVarF != null && (jSONObjectF = eVarF.f()) != null) {
                try {
                    jSONObjectF.put("click", "close");
                } catch (JSONException e2) {
                }
            }
        }
        try {
            if (this.mAdInfo != null && viewE != null && eVarF != null && k.equals(eVarF.s(""))) {
                String actRefinedText = this.mAdInfo.getActRefinedText();
                if (!TextUtils.isEmpty(actRefinedText)) {
                    if (viewE instanceof TextView) {
                        ((TextView) viewE).setText(actRefinedText);
                    }
                } else if ("act_text_view".equals(eVarF.m("")) && (viewE instanceof TextView)) {
                    ((TextView) viewE).setText(b());
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private String a() {
        String appName = this.mAdInfo.getAppName();
        String description = this.mAdInfo.getDescription();
        String title = this.mAdInfo.getTitle();
        return TextUtils.isEmpty(appName) ? (TextUtils.isEmpty(description) || TextUtils.isEmpty(title) || description.equals(title)) ? "精选推荐" : title : ((TextUtils.isEmpty(description) && appName.equals(title)) || appName.equals(description)) ? "精选推荐" : appName;
    }

    private void a(View view, String str) {
        if (view instanceof TextView) {
            ((TextView) view).setText(str);
        } else if (view instanceof RemoteMarketingTextView) {
            ((RemoteMarketingTextView) view).setTitleContent(str);
        }
    }

    private void a(com.component.a.a.q qVar, int i2) {
        try {
            qVar.getViewTreeObserver().addOnPreDrawListener(new l(this, qVar, i2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String a(String str, String str2) {
        JSONObject originJsonObject;
        if (this.mAdInfo != null && (originJsonObject = this.mAdInfo.getOriginJsonObject()) != null) {
            return originJsonObject.optString(str, str2);
        }
        return str2;
    }

    public static String a(String str) {
        try {
            long j2 = Long.parseLong(str);
            int length = str.length();
            if (j2 > 100000 && length > 5) {
                return str.substring(length - 4, length);
            }
            return "";
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
            return "";
        }
    }

    private int a(String str, int i2) {
        if (this.mAdInfo != null) {
            JSONObject originJsonObject = this.mAdInfo.getOriginJsonObject();
            long jOptLong = originJsonObject != null ? originJsonObject.optLong(str, i2) : i2;
            if (jOptLong > 2147483647L) {
                jOptLong = i2;
            }
            return (int) jOptLong;
        }
        return i2;
    }

    private String a(int i2) {
        String str;
        if (i2 < 10000) {
            return String.valueOf(i2);
        }
        int i3 = i2 / 1000;
        if (i3 < 10000) {
            str = "w";
        } else {
            i3 /= 1000;
            if (i3 < 1000) {
                str = "kw";
            } else {
                return "100kw+";
            }
        }
        int i4 = i3 / 10;
        int i5 = i3 % 10;
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        if (i5 > 0 && sb.length() + str.length() < 4) {
            sb.append(".").append(i5);
        }
        sb.append(str);
        return sb.toString();
    }

    private String b() {
        ab.a aVarA = com.baidu.mobads.container.util.ab.a(this.mAppContext, this.mAdInfo);
        if (aVarA == ab.a.DEEP_LINK) {
            return "立即点击 跳转应用";
        }
        if (aVarA == ab.a.APP_DOWNLOAD) {
            return "立即点击 下载应用";
        }
        return "立即点击 查看详情";
    }

    private void a(View view, com.component.a.f.e eVar) {
        e.f fVarH;
        Integer numA;
        try {
            if (TextUtils.isEmpty(this.mAdInfo.getMainPictureUrl()) && (view instanceof ImageView) && (fVarH = eVar.h()) != null && fVarH.a().optInt("blur", 0) > 0 && (numA = com.component.b.a.a().a("bg_blur_white")) != null) {
                ((ImageView) view).setImageResource(numA.intValue());
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.util.bq.a().a(th);
        }
    }
}
