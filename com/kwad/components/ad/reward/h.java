package com.kwad.components.ad.reward;

import aegon.chrome.net.NetError;
import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.RewardTaskStepView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.core.proxy.j {
    private static String uC = "进阶奖励还差 %s 步到手，\n确认放弃吗？";
    private static String uD = "再观看%ss可获得基础奖励，\n确认放弃吗？";
    private AdTemplate mAdTemplate;
    private a uB;

    public interface a extends com.kwad.components.core.webview.tachikoma.f.c {
        void hl();

        void i(int i, int i2);
    }

    public static class b implements a {
        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void G(boolean z) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void he() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void hl() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hm() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.f.c
        public void hn() {
        }

        @Override // com.kwad.components.ad.reward.h.a
        public void i(int i, int i2) {
        }
    }

    public static c g(String str, int i) {
        return c.h(str, i);
    }

    public static c a(g gVar, String str) {
        int i;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.components.ad.reward.l.b.a aVar = gVar.uc;
        com.kwad.components.ad.reward.l.a.a aVar2 = gVar.ud;
        int i2 = gVar.ue;
        boolean zK = com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eP(adTemplate)));
        int i3 = 0;
        if (zK || com.kwad.sdk.core.response.b.e.P(adTemplate)) {
            int iAf = (int) com.kwad.sdk.core.response.b.a.af(adInfoEP);
            int iM = com.kwad.sdk.core.response.b.a.M(adInfoEP);
            if (iAf > iM) {
                iAf = iM;
            }
            long playDuration = gVar.tu.getPlayDuration();
            if (playDuration < (iAf * 1000) + NetError.ERR_DNS_MALFORMED_RESPONSE && (i = (int) (iAf - ((playDuration / 1000.0f) + 0.5f))) >= 0) {
                i3 = i;
            }
        }
        if (zK && aVar != null) {
            return c.a(aVar, adTemplate, String.valueOf(i3));
        }
        if (com.kwad.sdk.core.response.b.e.P(adTemplate) && aVar2 != null) {
            return c.a(aVar2, adTemplate, String.valueOf(i3));
        }
        if (com.kwad.components.ad.reward.a.b.i(adInfoEP)) {
            return c.h(adInfoEP);
        }
        if (com.kwad.sdk.core.response.b.a.ct(adInfoEP) == 1 && com.kwad.components.ad.reward.a.b.hN() == 1) {
            return c.a(adInfoEP, i2);
        }
        if (adTemplate.isNativeRewardPreview) {
            return c.h(str, i2);
        }
        if (com.kwad.sdk.core.response.b.a.df(adInfoEP)) {
            return c.c(adTemplate, i2);
        }
        if (com.kwad.sdk.core.response.b.a.cE(adTemplate)) {
            return c.d(adTemplate, i2);
        }
        if (com.kwad.components.ad.reward.a.b.hH() == 1) {
            return c.n(i2);
        }
        return c.G(str);
    }

    public static h a(Activity activity, AdTemplate adTemplate, c cVar, a aVar) {
        h hVar = new h();
        Bundle bundle = new Bundle();
        bundle.putString("key_params_json", cVar.toJson().toString());
        bundle.putString("key_template_json", adTemplate.toJson().toString());
        hVar.setArguments(bundle);
        hVar.a(aVar);
        hVar.show(activity.getFragmentManager(), "videoCloseDialog");
        return hVar;
    }

    private void a(a aVar) {
        this.uB = aVar;
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewA;
        Bundle arguments = getArguments();
        String string = arguments.getString("key_params_json");
        try {
            String string2 = arguments.getString("key_template_json");
            AdTemplate adTemplate = new AdTemplate();
            this.mAdTemplate = adTemplate;
            adTemplate.parseJson(new JSONObject(string2));
        } catch (Throwable unused) {
        }
        c cVarH = c.H(string);
        int style = cVarH.getStyle();
        if (style == 1) {
            viewA = a(this, layoutInflater, viewGroup, cVarH, this.mAdTemplate, this.uB);
        } else if (style == 2) {
            viewA = b(this, layoutInflater, viewGroup, cVarH, this.mAdTemplate, this.uB);
        } else if (style == 4) {
            viewA = c(this, layoutInflater, viewGroup, cVarH, this.mAdTemplate, this.uB);
            com.kwad.components.core.u.l.a(new com.kwad.components.core.widget.f(), (ViewGroup) viewA);
        } else if (style == 5) {
            com.kwad.components.ad.reward.n.j jVar = new com.kwad.components.ad.reward.n.j(this, this.mAdTemplate, layoutInflater, viewGroup, this.uB);
            jVar.a(cVarH);
            viewA = jVar.hT();
        } else if (style == 6) {
            viewA = a(this, layoutInflater, viewGroup, cVarH, this.uB);
        } else if (style == 8) {
            com.kwad.components.ad.reward.n.m mVar = new com.kwad.components.ad.reward.n.m(this, this.mAdTemplate, layoutInflater, viewGroup, this.uB);
            mVar.a(cVarH);
            viewA = mVar.hT();
        } else {
            viewA = a((DialogFragment) this, layoutInflater, viewGroup, cVarH, this.uB);
        }
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.ad.reward.h.1
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4 && keyEvent.getAction() == 0;
            }
        });
        return viewA;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Window window = getDialog().getWindow();
        if (window == null) {
            return;
        }
        getDialog().setCanceledOnTouchOutside(false);
        window.setLayout(-1, -1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        a aVar = this.uB;
        if (aVar != null) {
            aVar.he();
        }
    }

    private static View a(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_title)).setText(cVar.getTitle());
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_close_btn);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_continue_btn);
        textView.setText(cVar.ho());
        textView2.setText(cVar.hp());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hn();
                }
            }
        });
        return viewInflate;
    }

    private View a(final h hVar, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_video_close_extend_dialog, viewGroup, false);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_play_time_tips)).setText(f(viewInflate.getContext(), cVar.uO));
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_deny);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_close_extend_dialog_btn_continue);
        textView.setText(cVar.ho());
        textView2.setText(cVar.hp());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hVar.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hn();
                }
            }
        });
        return viewInflate;
    }

    private static SpannableString f(Context context, String str) {
        SpannableString spannableString = new SpannableString("再看" + str + "秒，即可获得奖励");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(com.kwad.sdk.c.a.a.getColor(context, R.color.ksad_reward_main_color));
        StyleSpan styleSpan = new StyleSpan(1);
        int length = spannableString.length();
        spannableString.setSpan(foregroundColorSpan, 2, length - 7, 34);
        spannableString.setSpan(foregroundColorSpan2, length - 2, length, 34);
        spannableString.setSpan(styleSpan, 0, length, 34);
        return spannableString;
    }

    private static View a(com.kwad.components.ad.reward.l.a aVar, final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar2) throws Resources.NotFoundException {
        String str;
        int i;
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_task_launch_app_dialog, viewGroup, false);
        if (aVar instanceof com.kwad.components.ad.reward.l.b.a) {
            com.kwad.components.ad.reward.l.b.a.a((com.kwad.components.ad.reward.l.b.a) aVar, viewInflate.getContext(), adTemplate);
        }
        ((RewardTaskStepView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_steps)).a(aVar.kE(), cVar.uL);
        KSImageLoader.loadAppIcon((ImageView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_icon), cVar.hs(), adTemplate, 12);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_abandon);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_continue);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ksad_reward_task_dialog_title);
        String string = new StringBuilder().append(aVar.kF()).toString();
        String str2 = cVar.uL;
        boolean zEquals = "0".equals(str2);
        if (zEquals) {
            str = String.format(uC, string);
        } else {
            str = String.format(uD, str2);
        }
        int iIndexOf = zEquals ? str.indexOf(string) : str.indexOf(str2);
        if (iIndexOf < 0) {
            textView3.setText(str);
        } else {
            if (zEquals) {
                i = iIndexOf + 1;
            } else {
                i = str2.length() > 1 ? iIndexOf + 3 : iIndexOf + 2;
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(viewInflate.getContext().getResources().getColor(R.color.ksad_reward_main_color));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, iIndexOf, i, 17);
            textView3.setText(spannableString);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.G(false);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.hn();
                }
            }
        });
        return viewInflate;
    }

    private static View a(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hq(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View b(DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, a aVar) {
        return a(cVar.hr(), dialogFragment, layoutInflater, viewGroup, cVar, adTemplate, aVar);
    }

    private static View c(final DialogFragment dialogFragment, LayoutInflater layoutInflater, ViewGroup viewGroup, c cVar, AdTemplate adTemplate, final a aVar) {
        View viewInflate = layoutInflater.inflate(R.layout.ksad_reward_order_dialog, viewGroup, false);
        KSImageLoader.loadImage((KSCornerImageView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_icon), cVar.iconUrl, adTemplate);
        ((TextView) viewInflate.findViewById(R.id.ksad_reward_order_dialog_desc)).setText(cVar.getTitle());
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_close).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hn();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_view_detail).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.hl();
                }
            }
        });
        viewInflate.findViewById(R.id.ksad_reward_order_dialog_btn_deny).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.h.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialogFragment.dismiss();
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.G(false);
                }
            }
        });
        return viewInflate;
    }

    public static class c extends com.kwad.sdk.core.response.a.a {
        public String iconUrl;
        public int style;
        public String title;
        public String uI;
        public String uJ;
        public String uK;
        public String uL;
        public String uM;
        public String uN;
        public String uO;
        public com.kwad.components.ad.reward.l.b.a uc;
        public com.kwad.components.ad.reward.l.a.a ud;

        private c() {
        }

        static c G(String str) {
            c cVar = new c();
            cVar.style = 0;
            cVar.title = str;
            cVar.uI = "关闭广告";
            cVar.uJ = "继续观看";
            return cVar;
        }

        static c n(long j) {
            c cVar = new c();
            cVar.style = 6;
            cVar.uI = "残忍离开";
            cVar.uJ = "留下看看";
            if (j > 0) {
                cVar.I(String.valueOf(j));
            } else {
                cVar.I(null);
            }
            return cVar;
        }

        static c c(AdTemplate adTemplate, long j) {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.iconUrl = com.kwad.sdk.core.response.b.a.cC(adInfoEP);
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.uM = com.kwad.sdk.core.response.b.a.cz(adInfoEP);
            cVar.uN = com.kwad.sdk.core.response.b.a.aw(adInfoEP);
            cVar.uI = "放弃奖励";
            cVar.uJ = "继续观看";
            cVar.uK = com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            return cVar;
        }

        static c d(AdTemplate adTemplate, long j) {
            AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfoDS = com.kwad.sdk.core.response.b.b.dS(adTemplate);
            c cVar = new c();
            cVar.style = 8;
            cVar.iconUrl = merchantLiveReservationInfoDS.userHeadUrl;
            cVar.title = String.format("再看%s秒，可获得奖励", Long.valueOf(j));
            cVar.uM = merchantLiveReservationInfoDS.title;
            cVar.uI = "放弃奖励";
            cVar.uJ = "继续观看";
            cVar.uK = com.kwad.sdk.core.response.b.a.aH(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            return cVar;
        }

        public static c h(String str, int i) {
            c cVar = new c();
            cVar.style = 6;
            cVar.title = str;
            cVar.uI = "残忍离开";
            cVar.uJ = "留下看看";
            if (i > 0) {
                cVar.uO = String.valueOf(i);
            }
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.l.b.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 1;
            cVar.uc = aVar;
            cVar.uL = str;
            cVar.iconUrl = com.kwad.sdk.core.response.b.a.cC(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            return cVar;
        }

        static c a(com.kwad.components.ad.reward.l.a.a aVar, AdTemplate adTemplate, String str) {
            c cVar = new c();
            cVar.style = 2;
            cVar.ud = aVar;
            cVar.uL = str;
            cVar.iconUrl = com.kwad.sdk.core.response.b.a.cC(com.kwad.sdk.core.response.b.e.eP(adTemplate));
            return cVar;
        }

        static c h(AdInfo adInfo) {
            c cVar = new c();
            cVar.style = 4;
            AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfo);
            cVar.title = com.kwad.sdk.core.response.b.a.aw(adInfo);
            cVar.iconUrl = adProductInfoDj.getIcon();
            return cVar;
        }

        public static c a(AdInfo adInfo, long j) {
            c cVar = new c();
            cVar.style = 5;
            AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfo);
            cVar.uM = com.kwad.sdk.core.response.b.a.aw(adInfo);
            String name = adProductInfoDj.getName();
            cVar.title = name;
            if (TextUtils.isEmpty(name)) {
                cVar.title = com.kwad.sdk.core.response.b.a.aA(adInfo);
            }
            cVar.iconUrl = adProductInfoDj.getIcon();
            if (j > 0) {
                cVar.I(String.valueOf(j));
            } else {
                cVar.I(null);
            }
            return cVar;
        }

        public static c H(String str) {
            c cVar = new c();
            try {
                cVar.parseJson(new JSONObject(str));
            } catch (JSONException unused) {
            }
            return cVar;
        }

        public final int getStyle() {
            return this.style;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String ho() {
            return TextUtils.isEmpty(this.uI) ? "关闭广告" : this.uI;
        }

        public final String hp() {
            return TextUtils.isEmpty(this.uJ) ? "继续观看" : this.uJ;
        }

        public final com.kwad.components.ad.reward.l.b.a hq() {
            return this.uc;
        }

        public final com.kwad.components.ad.reward.l.a.a hr() {
            return this.ud;
        }

        public final String hs() {
            return this.iconUrl;
        }

        public final String ht() {
            return this.uM;
        }

        public final String hu() {
            return this.uN;
        }

        public final String hv() {
            return TextUtils.isEmpty(this.uO) ? "" : String.format("再看%s秒，可获得优惠", this.uO);
        }

        private void I(String str) {
            this.uO = str;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mLaunchAppTask");
            if (jSONObjectOptJSONObject != null) {
                if (this.uc == null) {
                    this.uc = new com.kwad.components.ad.reward.l.b.a();
                }
                this.uc.parseJson(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mLandPageOpenTask");
            if (jSONObjectOptJSONObject2 != null) {
                if (this.ud == null) {
                    this.ud = new com.kwad.components.ad.reward.l.a.a();
                }
                this.ud.parseJson(jSONObjectOptJSONObject2);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            com.kwad.components.ad.reward.l.b.a aVar = this.uc;
            if (aVar != null) {
                aa.a(jSONObject, "mLaunchAppTask", aVar);
            }
            com.kwad.components.ad.reward.l.a.a aVar2 = this.ud;
            if (aVar2 != null) {
                aa.a(jSONObject, "mLandPageOpenTask", aVar2);
            }
        }
    }
}
