package com.baidu.mobads.sdk.internal.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements IOAdEventListener {

    /* renamed from: com.baidu.mobads.sdk.internal.b.a$a, reason: collision with other inner class name */
    public static class C0144a {
        public static final String A = "ic_white_cross";
        public static final String B = "ic_gray_complaints";
        public static final String C = "ic_gray_low_quality";
        public static final String D = "ic_gray_repeat";
        public static final String E = "ic_gray_unlike";
        public static final String F = "ic_white_ad_logo_gray_bg";
        public static final String G = "ic_white_bqt_logo_gray_bg";
        public static final String H = "ic_white_shake_gesture";
        public static final String I = "ic_arrow_up";
        public static final String J = "ic_blue_no_ad";

        /* renamed from: K, reason: collision with root package name */
        public static final String f745K = "ic_fallback_gray";
        public static final String L = "ic_gift_box";
        public static final String M = "ic_gift_ribbon";
        public static final String N = "ic_gold_star";
        public static final String O = "ic_gray_left_quot";
        public static final String P = "ic_gray_right_quot";
        public static final String Q = "ic_gray_star";
        public static final String R = "ic_half_gold_star";
        public static final String S = "ic_orange_cross";
        public static final String T = "ic_twist_phone";
        public static final String U = "ic_white_answer_error";
        public static final String V = "ic_white_answer_right";
        public static final String W = "ic_white_ad_logo";
        public static final String X = "ic_white_cross_in_circle";
        public static final String Y = "ic_black_arrow_left";
        public static final String Z = "ic_black_three_points";
        public static final String a = "rsp_big_red_heart";
        public static final String aA = "ic_white_three_points";
        public static final String aB = "ic_white_voice";
        public static final String aC = "ic_white_voice_mute";
        public static final String aD = "ic_white_pause_gray_round";
        public static final String aE = "ic_yellow_dl_black_bg";
        public static final String aF = "ic_yellow_lp_black_bg";
        public static final String aa = "ic_gray_ad";
        public static final String ab = "ic_gray_ad_logo";
        public static final String ac = "ic_gray_bqt_logo";
        public static final String ad = "ic_gray_cross_black_round";
        public static final String ae = "ic_gray_cross_white_oval";
        public static final String af = "ic_gray_logo";
        public static final String ag = "ic_slide_arrow_duplicate";
        public static final String ah = "ic_slide_arrow_point";
        public static final String ai = "ic_white_ad_gray_bg";
        public static final String aj = "ic_white_arrow_left";
        public static final String ak = "ic_white_arrow_right";
        public static final String al = "ic_white_bqt_gray_bg";
        public static final String am = "ic_white_bqt_logo";
        public static final String an = "ic_white_comments";
        public static final String ao = "ic_white_cross_circle_shadow";
        public static final String ap = "ic_white_finger_shadow";
        public static final String aq = "ic_white_logo";
        public static final String ar = "ic_white_logo_gray_bg";
        public static final String as = "ic_white_replay";
        public static final String at = "ic_white_replay_gray_round";
        public static final String au = "ic_white_speed075";
        public static final String av = "ic_white_speed100";
        public static final String aw = "ic_white_speed125";
        public static final String ax = "ic_white_speed150";
        public static final String ay = "ic_white_speed175";
        public static final String az = "ic_white_speed200";
        public static final String b = "rsp_small_red_heart";
        public static final String c = "bg_blur_white";
        public static final String d = "bg_app_icon";
        public static final String e = "bg_hot_recommendation";
        public static final String f = "bg_black_round_rectangle";
        public static final String g = "bg_red_rectangle";
        public static final String h = "bg_red_circle";
        public static final String i = "bg_red_ribbon_rectangle";
        public static final String j = "bg_red_ribbon_circle";
        public static final String k = "ic_video_play";
        public static final String l = "ic_stars";
        public static final String m = "ic_fallback";
        public static final String n = "ic_guide_circle";
        public static final String o = "ic_guide_finger";
        public static final String p = "ic_white_play";
        public static final String q = "ic_white_pause";
        public static final String r = "ic_white_apo";
        public static final String s = "ic_white_dl";
        public static final String t = "ic_white_link";
        public static final String u = "ic_white_fullscreen_shrink";
        public static final String v = "ic_white_fullscreen_stretch";
        public static final String w = "ic_black_cross";
        public static final String x = "ic_white_cross_dark_round";
        public static final String y = "ic_gray_cross";
        public static final String z = "ic_light_gray_cross";
    }

    private Integer b(String str) {
        return null;
    }

    private Integer c(String str) {
        return null;
    }

    private Integer d(String str) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            String type = iOAdEvent.getType();
            Map<String, Object> data = iOAdEvent.getData();
            String str = (String) data.get("name");
            Integer numD = null;
            if ("drawable".equals(type)) {
                numD = a(str);
            } else if ("layout".equals(type)) {
                numD = b(str);
            } else if (TypedValues.Custom.S_STRING.equals(type)) {
                numD = c(str);
            } else if ("style".equals(type)) {
                numD = d(str);
            }
            data.put("id", numD);
        }
    }

    private Integer a(String str) {
        if ("bg_blur_white".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_blur_white);
        }
        if ("bg_app_icon".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_app_icon);
        }
        if ("bg_hot_recommendation".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_hot_recommendation);
        }
        if ("bg_black_round_rectangle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_black_round_rectangle);
        }
        if ("bg_red_rectangle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_rect);
        }
        if ("bg_red_circle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_circle);
        }
        if ("bg_red_ribbon_rectangle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_rect);
        }
        if ("bg_red_ribbon_circle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_bg_red_ribbon_circle);
        }
        if ("ic_video_play".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_video_play);
        }
        if ("ic_stars".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_stars);
        }
        if ("ic_fallback".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback);
        }
        if ("ic_guide_circle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_circle);
        }
        if ("ic_guide_finger".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_guide_finger);
        }
        if ("ic_white_play".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_play);
        }
        if ("ic_white_pause".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause);
        }
        if ("ic_white_apo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_apo);
        }
        if ("ic_white_dl".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_dl);
        }
        if ("ic_white_link".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_link);
        }
        if ("ic_white_fullscreen_shrink".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_shrink);
        }
        if ("ic_white_fullscreen_stretch".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_fullscreen_stretch);
        }
        if ("ic_black_cross".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_cross);
        }
        if ("ic_white_cross_dark_round".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_dark_round);
        }
        if ("rsp_big_red_heart".equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_big_red_heart);
        }
        if ("rsp_small_red_heart".equals(str)) {
            return Integer.valueOf(R.drawable.bd_rsp_small_red_heart);
        }
        if ("ic_gray_cross".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross);
        }
        if ("ic_light_gray_cross".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_light_gray_cross);
        }
        if ("ic_white_cross".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross);
        }
        if ("ic_gray_complaints".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_complaints);
        }
        if ("ic_gray_low_quality".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_low_quality);
        }
        if ("ic_gray_repeat".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_repeat);
        }
        if ("ic_gray_unlike".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_unlike);
        }
        if ("ic_white_ad_logo_gray_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo_gray_bg);
        }
        if ("ic_white_bqt_logo_gray_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo_gray_bg);
        }
        if ("ic_white_shake_gesture".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_shake_gesture);
        }
        if ("ic_arrow_up".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_arrow_up);
        }
        if ("ic_blue_no_ad".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_blue_no_ad);
        }
        if ("ic_fallback_gray".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_fallback_gray);
        }
        if ("ic_gift_box".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_box);
        }
        if ("ic_gift_ribbon".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gift_ribbon);
        }
        if ("ic_gold_star".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gold_star);
        }
        if ("ic_gray_left_quot".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_left_quot);
        }
        if ("ic_gray_right_quot".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_right_quot);
        }
        if ("ic_gray_star".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_star);
        }
        if ("ic_half_gold_star".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_half_gold_star);
        }
        if ("ic_orange_cross".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_orange_cross);
        }
        if ("ic_twist_phone".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_twist_phone);
        }
        if ("ic_white_ad_logo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_logo);
        }
        if ("ic_white_answer_error".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_error);
        }
        if ("ic_white_answer_right".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_answer_right);
        }
        if ("ic_white_cross_in_circle".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_in_circle);
        }
        if ("ic_black_arrow_left".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_arrow_left);
        }
        if ("ic_black_three_points".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_black_three_points);
        }
        if ("ic_gray_ad".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad);
        }
        if ("ic_gray_ad_logo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_ad_logo);
        }
        if ("ic_gray_bqt_logo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_bqt_logo);
        }
        if ("ic_gray_cross_black_round".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_black_round);
        }
        if ("ic_gray_cross_white_oval".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_cross_white_oval);
        }
        if ("ic_gray_logo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_gray_logo);
        }
        if ("ic_slide_arrow_duplicate".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_duplicate);
        }
        if ("ic_slide_arrow_point".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_slide_arrow_point);
        }
        if ("ic_white_ad_gray_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_ad_gray_bg);
        }
        if ("ic_white_arrow_left".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_left);
        }
        if ("ic_white_arrow_right".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_arrow_right);
        }
        if ("ic_white_bqt_gray_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_gray_bg);
        }
        if ("ic_white_bqt_logo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_bqt_logo);
        }
        if ("ic_white_comments".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_comments);
        }
        if ("ic_white_cross_circle_shadow".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_cross_circle_shadow);
        }
        if ("ic_white_finger_shadow".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_finger_shadow);
        }
        if ("ic_white_logo".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo);
        }
        if ("ic_white_logo_gray_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_logo_gray_bg);
        }
        if ("ic_white_pause_gray_round".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_pause_gray_round);
        }
        if ("ic_white_replay".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay);
        }
        if ("ic_white_replay_gray_round".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_replay_gray_round);
        }
        if ("ic_white_speed075".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed075);
        }
        if ("ic_white_speed100".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed100);
        }
        if ("ic_white_speed125".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed125);
        }
        if ("ic_white_speed150".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed150);
        }
        if ("ic_white_speed175".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed175);
        }
        if ("ic_white_speed200".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_speed200);
        }
        if ("ic_white_three_points".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_three_points);
        }
        if ("ic_white_voice".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice);
        }
        if ("ic_white_voice_mute".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_white_voice_mute);
        }
        if ("ic_yellow_dl_black_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_dl_black_bg);
        }
        if ("ic_yellow_lp_black_bg".equals(str)) {
            return Integer.valueOf(R.drawable.bd_ic_yellow_lp_black_bg);
        }
        return null;
    }
}
