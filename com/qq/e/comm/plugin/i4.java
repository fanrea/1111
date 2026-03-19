package com.qq.e.comm.plugin;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
final class i4 {
    static void a(h4 h4Var, JSONObject jSONObject) {
        h4Var.b = jSONObject.optString("cl");
        h4Var.c = jSONObject.optString("txt");
        h4Var.d = jSONObject.optString("title");
        h4Var.e = jSONObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
        h4Var.f = jSONObject.optString("img");
        h4Var.g = jSONObject.optString("img2");
        h4Var.h = jSONObject.optInt("pic_width");
        h4Var.i = jSONObject.optInt("pic_height");
        h4Var.j = jSONObject.optString("apurl");
        h4Var.k = jSONObject.optString("v_apurl");
        h4Var.l = jSONObject.optString("rl");
        h4Var.m = jSONObject.optString("customizedpingurl");
        h4Var.n = jSONObject.optInt("producttype");
        h4Var.o = jSONObject.optInt("dest_type");
        h4Var.q = jSONObject.optString("landing_page_report_url");
        h4Var.r = jSONObject.optString("traceid");
        h4Var.s = jSONObject.optString(NetworkDefine.PARAM_TOKEN);
        h4Var.t = jSONObject.optString("netlog_traceid");
        h4Var.v = jSONObject.optInt("app_landing_page") == 1;
        h4Var.w = jSONObject.optInt("alpdl") == 1;
        h4Var.x = jSONObject.optString("template_id");
        h4Var.y = jSONObject.optInt("template_width");
        h4Var.z = jSONObject.optInt("template_height");
        h4Var.B = jSONObject.optString("video_tracking_url");
        h4Var.F = jSONObject.optInt(SplashAd.KEY_BIDFAIL_ECPM, -1);
        h4Var.G = jSONObject.optString("ecpm_level");
        h4Var.I = jSONObject.optInt("buyingtype", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ssp_ext");
        if (jSONObjectOptJSONObject != null) {
            h4Var.J = new l00(jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("component");
        if (jSONObjectOptJSONObject2 != null) {
            h4Var.O = new d7(jSONObjectOptJSONObject2);
        }
        h4Var.P = jSONObject.optInt("sub_type");
        h4Var.Q = jSONObject.optString("video");
        h4Var.R = jSONObject.optBoolean("is_vhd");
        h4Var.S = jSONObject.optInt("v_type", 0);
        h4Var.T = jSONObject.optInt("video_width");
        h4Var.U = jSONObject.optInt("video_height");
        h4Var.V = jSONObject.optInt("video_duration");
        h4Var.W = xv.a(jSONObject.optJSONArray("report_url"));
        h4Var.X = xv.a(jSONObject.optJSONArray("report_url_sdk"));
        h4Var.Y = nt.b(jSONObject.optJSONArray("click_mo_url"));
        h4Var.Z = nt.b(jSONObject.optJSONArray("click_mo_url_sdk"));
        h4Var.b0 = jSONObject.optString("video_widget_url");
        h4Var.c0 = jSONObject.optString("button_txt");
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("app_state_txt");
        if (jSONObjectOptJSONObject3 != null) {
            h4Var.d0 = new q3(jSONObjectOptJSONObject3);
        }
        h4Var.e0 = jSONObject.optString("compliance_button_txt");
        h4Var.f0 = jSONObject.optInt("mini_program_type");
        h4Var.g0 = jSONObject.optString("customized_invoke_url");
        h4Var.i0 = jSONObject.optInt("app_store") == 1;
        h4Var.j0 = jSONObject.optString("productid");
        h4Var.k0 = new ku(jSONObject.optJSONObject("posCfg"));
        h4Var.m0 = nt.b(jSONObject.optJSONArray("screenshot_url_list"));
        h4Var.n0 = jSONObject.optString("app_info_url");
        h4Var.o0 = jSONObject.optInt("bxg_restrict") == 1;
        h4Var.p0 = jSONObject.optBoolean("is_fullscreen");
        h4Var.q0 = jSONObject.optString("local_trace_id");
        h4Var.s0 = jSONObject.optInt("ad_expire");
        h4Var.t0 = jSONObject.optString("ip_ping_url");
        h4Var.u0 = jSONObject.optString("requrl");
        h4Var.v0 = jSONObject.optString("wechat_canvas_ext_info");
        h4Var.w0 = jSONObject.optString("wxappid");
        h4Var.x0 = jSONObject.optInt("is_reward_ad") == 1;
        h4Var.y0 = jSONObject.optString("ssv_report_url");
        h4Var.z0 = jSONObject.optString("nurl");
        h4Var.A0 = jSONObject.optString("lurl");
        h4Var.B0 = jSONObject.optInt("interactive_type");
        h4Var.C0 = jSONObject.optLong("support_mf");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("tpl_info_native");
        if (jSONObjectOptJSONObject4 != null) {
            h4Var.E0 = new yq(jSONObjectOptJSONObject4);
        }
        h4Var.F0 = jSONObject.optInt("cpsf");
        h4Var.G0 = jSONObject.optDouble("dr");
        h4Var.H0 = jSONObject.optString("complaint_url");
        h4Var.I0 = jSONObject.optString("quick_app_link");
        h4Var.J0 = jSONObject.optInt("custom_click_logic");
        h4Var.K0 = jSONObject.optInt("isml") == 1;
        h4Var.L0 = jSONObject.optString("ext3");
        h4Var.M0 = jSONObject.optInt("ad_index");
        h4Var.N0 = jSONObject.optInt("prld");
        h4Var.O0 = jSONObject.optJSONObject("reward_content");
        h4Var.P0 = jSONObject.optJSONArray("acr_list");
        h4Var.Q0 = jSONObject.optInt("click_jump_type") == 1;
        h4Var.R0 = jSONObject.optString("landing_page_url");
        h4Var.S0 = jSONObject.optString("package_url");
        h4Var.T0 = jSONObject.optString("wx_scheme_dstlink");
        h4Var.U0 = jSONObject.optString("landing_page");
        h4Var.W0 = jSONObject.optJSONObject("ctrl_config");
        h4Var.X0 = jSONObject.optJSONArray("consult_question");
        h4Var.a1 = jSONObject.optInt("is_retention_ad") == 1;
        h4Var.v1 = jSONObject.optLong("adCachedTime");
    }
}
