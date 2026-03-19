package com.baidu.mobads.container.rewardvideo;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.component.a.g.c.aa;
import com.component.a.g.c.br;
import com.component.a.g.c.m;
import com.component.a.g.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j extends d.c {
    final /* synthetic */ NativeRewardActivity a;

    j(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        this.a.onViewCreate(view, str, str2);
        if (this.a.mSharedMediator != null) {
            this.a.mSharedMediator.a(view, str2);
        }
        if ("video_view".equals(str2) && (view instanceof com.component.a.d.c) && this.a.x != null) {
            this.a.h = true;
            ((RelativeLayout) view).addView(this.a.x, new RelativeLayout.LayoutParams(-1, -1));
            this.a.x.e();
            this.a.x.c(this.a.Q);
            this.a.x.a(new k(this));
            this.a.x.a(this.a.D);
            this.a.x.b(this.a.z);
            if (!this.a.ai) {
                this.a.x.d();
                return;
            } else {
                this.a.x.a(true);
                return;
            }
        }
        if ("close_view".equals(str2)) {
            if (view != null) {
                this.a.q = view;
                com.component.a.i.f fVarA = com.component.a.i.f.a(view);
                if (fVarA != null) {
                    this.a.o = this.a.a(fVarA.b(), "rvideo_delay_close", 0);
                    this.a.p = this.a.a(fVarA.b(), "close_type", 0);
                    this.a.aU = 1 == this.a.a(fVarA.b(), "px_close", 0);
                    this.a.aV = this.a.a(fVarA.b(), "px_close_w", 1) > 0 ? this.a.a(fVarA.b(), "px_close_w", 1) : this.a.aV;
                    this.a.aW = this.a.a(fVarA.b(), "px_close_h", 1) > 0 ? this.a.a(fVarA.b(), "px_close_h", 1) : this.a.aW;
                    if (this.a.aU) {
                        this.a.c(com.baidu.mobads.container.o.j.b("pixel_click_view") + com.baidu.mobads.container.o.j.a + this.a.aV + com.baidu.mobads.container.o.j.a + this.a.aW);
                    }
                }
                this.a.a(this.a.q, 4);
                return;
            }
            return;
        }
        if ("skip_view".equals(str2)) {
            if (view != null) {
                this.a.mSkipView = view;
                com.component.a.i.f fVarA2 = com.component.a.i.f.a(view);
                if (fVarA2 != null) {
                    this.a.aO = this.a.a(fVarA2.b(), "dis_frt", 0);
                }
                if (this.a.r > 0) {
                    this.a.a(this.a.mSkipView, 4);
                    return;
                } else {
                    this.a.showSkipView();
                    return;
                }
            }
            return;
        }
        if ("mute_view".equals(str2)) {
            if (view instanceof ImageView) {
                this.a.j = (ImageView) view;
                com.component.b.a.a().a(this.a.j, this.a.z ? "ic_white_voice_mute" : "ic_white_voice");
                return;
            }
            return;
        }
        if (view instanceof com.component.a.a.d) {
            if (com.component.a.i.f.a(view, "rvideo_dl_hint", 0) == 1) {
                this.a.aA = (com.component.a.a.d) view;
            }
            if (TextUtils.equals(this.a.at, str)) {
                this.a.av = (com.component.a.a.d) view;
                return;
            }
            return;
        }
        if ("rvideo_tail_retain_view".equals(str2)) {
            if (view instanceof com.component.a.d.c) {
                this.a.m = (RelativeLayout) view;
                this.a.a(this.a.m, 4);
                this.a.mDialogManager.a((com.component.a.d.c) this.a.m, 10);
                return;
            }
            return;
        }
        if ("rvideo_front_retain_view".equals(str2)) {
            if (view instanceof com.component.a.d.c) {
                this.a.k = (RelativeLayout) view;
                this.a.a(this.a.k, 4);
                this.a.mDialogManager.a((com.component.a.d.c) this.a.k, 10);
                return;
            }
            return;
        }
        if ("front_retain_single_exit".equals(str2)) {
            if (this.a.isLastPage()) {
                this.a.a(view, 0);
                return;
            } else {
                this.a.a(view, 4);
                return;
            }
        }
        if ("front_retain_exit_play".equals(str2)) {
            if (!this.a.isLastPage()) {
                this.a.a(view, 0);
                return;
            } else {
                this.a.a(view, 4);
                return;
            }
        }
        if ("tail_view".equals(str2)) {
            this.a.s = view;
            this.a.a(this.a.s, 4);
            return;
        }
        if ("tail_view_video".equals(str2)) {
            if (view instanceof com.component.a.d.c) {
                this.a.t = (ViewGroup) view;
                return;
            }
            return;
        }
        if ("tail_render".equals(str2)) {
            if (view instanceof com.baidu.mobads.container.ax) {
                this.a.i = (com.baidu.mobads.container.ax) view;
                return;
            }
            return;
        }
        if ("front_retain_remain_time".equals(str2)) {
            if (view instanceof TextView) {
                this.a.am = (TextView) view;
                return;
            }
            return;
        }
        if ("rvideo_countdown_view".equals(str2)) {
            if (view instanceof TextView) {
                this.a.an = (TextView) view;
                com.component.a.i.f fVarA3 = com.component.a.i.f.a(view);
                if (fVarA3 != null) {
                    this.a.mIsShowRewardCountdownTips = this.a.a(fVarA3.b(), "reward_tips", 0);
                    return;
                }
                return;
            }
            return;
        }
        if ("egg_countdown_remain_time".equals(str2)) {
            if (view instanceof TextView) {
                this.a.ak = (TextView) view;
            }
            this.a.al = com.component.a.i.f.c(view).o(this.a.al);
            return;
        }
        if ("egg_countdown".equals(str2)) {
            this.a.aj = view;
            com.component.a.i.f fVarA4 = com.component.a.i.f.a(view);
            if (fVarA4 != null) {
                this.a.mIsShowRewardCountdownTips = this.a.a(fVarA4.b(), "reward_tips", 0);
                return;
            }
            return;
        }
        if ("egg_countdown_lottie".equals(str2)) {
            if (view instanceof com.component.a.a.f) {
                this.a.mEggLottieView = (com.component.a.a.f) view;
                return;
            }
            return;
        }
        if ("segmented_countdown_text".equals(str2)) {
            if ((view instanceof m.b) && view.getVisibility() == 0) {
                this.a.mRewardCountdownView = (m.b) view;
                if (this.a.ai) {
                    this.a.mRewardCountdownView.a(true);
                    return;
                }
                return;
            }
            return;
        }
        if ("segmented_countdown_gift".equals(str2)) {
            if ((view instanceof m.b) && view.getVisibility() == 0 && this.a.mRewardCountdownView == null) {
                this.a.mRewardCountdownView = (m.b) view;
                if (this.a.ai) {
                    this.a.mRewardCountdownView.a(true);
                    return;
                }
                return;
            }
            return;
        }
        if ("shake_view".equals(str2)) {
            if (view instanceof com.baidu.mobads.container.s.ab) {
                com.baidu.mobads.container.s.ab abVar = (com.baidu.mobads.container.s.ab) view;
                this.a.mNativeShakeView = abVar;
                this.a.mNativeShakeView.setVisibility(4);
                if (abVar.b()) {
                    this.a.c(com.baidu.mobads.container.o.j.a(str2, view));
                }
                this.a.mNativeShakeView.j();
                if (this.a.mNativeShakeView.b()) {
                    this.a.bi.a(new l(this), this.a.mNativeShakeView.d());
                    this.a.bi.a(new m(this), this.a.mNativeShakeView.d() + this.a.mNativeShakeView.e());
                    return;
                }
                return;
            }
            return;
        }
        if (com.component.a.g.c.bm.c.equals(str2)) {
            if (view instanceof com.baidu.mobads.container.s.ab) {
                com.baidu.mobads.container.s.ab abVar2 = (com.baidu.mobads.container.s.ab) view;
                this.a.ao = abVar2;
                this.a.ao.j();
                if (abVar2.b()) {
                    this.a.c(com.baidu.mobads.container.o.j.a(str2, view));
                    return;
                }
                return;
            }
            return;
        }
        if ("guide_slide".equals(str2) && (view instanceof br.a)) {
            this.a.ap = (br.a) view;
            this.a.ap.setVisibility(8);
            this.a.f(1);
            this.a.controlSkipViewLevel();
            return;
        }
        if ("flip_card".equals(str2) && (view instanceof aa.c)) {
            this.a.aq = (aa.c) view;
            this.a.mDialogManager.a(this.a.aq, 5);
            this.a.c(com.baidu.mobads.container.o.j.l(str2, com.component.a.i.f.c(view)));
            return;
        }
        if ("answer_card".equals(str2) && (view instanceof aa.a)) {
            this.a.ar = (aa.a) view;
            this.a.mDialogManager.a(this.a.ar, 5);
            this.a.c(com.baidu.mobads.container.o.j.k(str2, com.component.a.i.f.c(view)));
            return;
        }
        if ("atmosphere_view".equals(str2) && (view instanceof com.component.a.a.f)) {
            this.a.aB = (com.component.a.a.f) view;
            this.a.aB.setVisibility(8);
            if (com.component.a.i.f.c(view).e(0) == 1) {
                this.a.c(com.baidu.mobads.container.o.j.c(str2, view));
                int iA = com.component.a.i.f.a(view, "delay_time", 15000);
                this.a.aB.i(com.component.a.i.f.a(view, com.baidu.mobads.container.adrequest.n.m, 5000));
                this.a.bi.a(new n(this), iA);
                return;
            }
            return;
        }
        if ("bubble_widget".equals(str2) && view != null) {
            this.a.aC = view;
            this.a.aC.setVisibility(8);
            if (com.component.a.i.f.c(view).e(0) == 1) {
                this.a.c(com.baidu.mobads.container.o.j.g(str2, view));
                int iA2 = com.component.a.i.f.a(view, "delay_time", 3000);
                int iA3 = com.component.a.i.f.a(view, com.baidu.mobads.container.adrequest.n.m, 9000);
                this.a.bi.a(new o(this), iA2);
                this.a.bi.a(new p(this), iA2 + iA3);
                return;
            }
            return;
        }
        if ("dynamic_barrage".equals(str2) && (view instanceof com.component.a.a.b)) {
            this.a.aD = (com.component.a.a.b) view;
            this.a.c(com.baidu.mobads.container.o.j.h(str2, view));
            return;
        }
        if (TextUtils.equals("segmented_countdown_first_text_hint", str2) && (view instanceof com.component.a.d.c)) {
            this.a.aw = (com.component.a.d.c) view;
            return;
        }
        if (TextUtils.equals("segmented_countdown_text_hint_text", str2) && (view instanceof com.component.a.a.q)) {
            this.a.ax = (com.component.a.a.q) view;
            return;
        }
        if ("click_reward".equals(str2) && (view instanceof aa.b)) {
            this.a.as = (aa.b) view;
            this.a.mDialogManager.a(this.a.as, 5);
            this.a.G();
            this.a.c(com.baidu.mobads.container.o.j.o(str2, com.component.a.i.f.c(view)));
            return;
        }
        if (view instanceof aa.j) {
            aa.j jVar = (aa.j) view;
            this.a.ay.add(jVar);
            this.a.mDialogManager.a(jVar, 5);
            if ("interact_front_pack_rain".equals(str2)) {
                this.a.c(com.baidu.mobads.container.o.j.l(str2, view));
                return;
            }
            if ("interact_front_flip_card".equals(str2)) {
                this.a.c(com.baidu.mobads.container.o.j.l(str2, view));
                return;
            }
            if ("interact_front_lucky_bag".equals(str2)) {
                this.a.c(com.baidu.mobads.container.o.j.i(str2, view));
                return;
            } else if ("interact_back_welfare".equals(str2)) {
                this.a.c(com.baidu.mobads.container.o.j.j(str2, view));
                return;
            } else {
                if ("interact_back_coupon".equals(str2)) {
                    this.a.c(com.baidu.mobads.container.o.j.m(str2, view));
                    return;
                }
                return;
            }
        }
        if ("coupon_float".equals(str2) && view != null) {
            this.a.aE = view;
            this.a.c(com.baidu.mobads.container.o.j.a(this.a.mAdInstanceInfo.getOriginJsonObject(), str2, view));
            return;
        }
        if ("dc_view".equals(str2) && (view instanceof m.a)) {
            this.a.az = (m.a) view;
            if (this.a.ai) {
                this.a.az.a(true);
            }
            if (com.baidu.mobads.container.o.j.b(view)) {
                this.a.c(com.baidu.mobads.container.o.j.b(str2) + com.baidu.mobads.container.o.j.a + this.a.az.a() + com.baidu.mobads.container.o.j.a + this.a.az.b());
                return;
            }
            return;
        }
        if (com.baidu.mobads.container.components.command.j.I.equals(str2)) {
            TextView textView = (TextView) view;
            if (textView != null) {
                textView.post(new q(this, textView));
                return;
            }
            return;
        }
        if ("notice_view".equals(str2)) {
            this.a.ba = view;
            com.component.a.i.f fVarA5 = com.component.a.i.f.a(view);
            if (fVarA5 != null) {
                this.a.aY = this.a.a(fVarA5.b(), com.baidu.mobads.container.adrequest.n.m, this.a.aY);
            }
            com.baidu.mobads.container.util.cf.a(this.a.ba, new r(this));
            if (this.a.aY != -1 && this.a.ba != null) {
                this.a.bi.a(new s(this), this.a.aY + 2300);
                return;
            }
            return;
        }
        if ("close_countdown_view".equals(str2) && (view instanceof TextView)) {
            if ((com.component.a.i.f.a(view) != null ? com.component.a.i.f.c(view).e(0) : -1) == 1) {
                this.a.aS = (TextView) view;
                this.a.a(this.a.aS, 4);
                return;
            } else {
                this.a.a(this.a.aS, 8);
                return;
            }
        }
        if (str != null && str.contains("big_white_finger_content") && view != null) {
            this.a.c(com.baidu.mobads.container.o.j.d("big_white_finger", view));
        } else if ("one_purchase".equals(str2)) {
            this.a.c(com.baidu.mobads.container.o.j.n(str2, view));
        } else if ("coupon_discount".equals(str2)) {
            this.a.c(com.baidu.mobads.container.o.j.o(str2, view));
        }
    }

    @Override // com.component.a.g.d.c
    public void a(com.component.a.f.d dVar) {
        JSONObject originJsonObject;
        super.a(dVar);
        if (com.component.a.g.c.bm.h.equals(dVar.d()) && this.a.mAdInstanceInfo != null && (originJsonObject = this.a.mAdInstanceInfo.getOriginJsonObject()) != null) {
            this.a.a(dVar.e(), originJsonObject.optBoolean("use_dialog_frame", false), dVar);
        }
    }
}
