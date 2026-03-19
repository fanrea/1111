package com.kwad.components.ad.reward.n;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p extends s implements View.OnClickListener {
    private ImageView EZ;
    private TextView Fa;
    private TextView Fb;
    private TextView Fc;
    private TextView Fd;
    private TextView Fe;
    private TextView Ff;
    private TextView Fg;
    private com.kwad.components.ad.reward.g vb;

    public p(com.kwad.components.ad.reward.g gVar) {
        this.vb = gVar;
    }

    public final void h(ViewGroup viewGroup) {
        if (this.vb.mContext.getResources().getConfiguration().orientation == 2) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub_landscape, R.id.ksad_live_end_page_layout_root_landscape);
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_end_page_stub, R.id.ksad_live_end_page_layout_root);
        }
        initView();
    }

    private void initView() {
        if (this.xM == null) {
            return;
        }
        if (this.vb.mContext.getResources().getConfiguration().orientation == 2) {
            this.EZ = (ImageView) this.xM.findViewById(R.id.ksad_live_end_page_author_icon_landscape);
            this.Fa = (TextView) this.xM.findViewById(R.id.ksad_author_name_txt_landscape);
            this.Fb = (TextView) this.xM.findViewById(R.id.ksad_live_end_detail_watch_person_count_landscape);
            this.Fc = (TextView) this.xM.findViewById(R.id.ksad_live_end_detail_like_person_count_landscape);
            this.Fd = (TextView) this.xM.findViewById(R.id.ksad_live_end_detail_watch_time_landscape);
            this.Fe = (TextView) this.xM.findViewById(R.id.ksad_live_end_bottom_title_landscape);
            this.Ff = (TextView) this.xM.findViewById(R.id.ksad_live_end_bottom_action_btn_landscape);
            this.Fg = (TextView) this.xM.findViewById(R.id.ksad_live_end_bottom_des_btn_landscape);
        } else {
            this.EZ = (ImageView) this.xM.findViewById(R.id.ksad_live_end_page_author_icon);
            this.Fa = (TextView) this.xM.findViewById(R.id.ksad_author_name_txt);
            this.Fb = (TextView) this.xM.findViewById(R.id.ksad_live_end_detail_watch_person_count);
            this.Fc = (TextView) this.xM.findViewById(R.id.ksad_live_end_detail_like_person_count);
            this.Fd = (TextView) this.xM.findViewById(R.id.ksad_live_end_detail_watch_time);
            this.Fe = (TextView) this.xM.findViewById(R.id.ksad_live_end_bottom_title);
            this.Ff = (TextView) this.xM.findViewById(R.id.ksad_live_end_bottom_action_btn);
            this.Fg = (TextView) this.xM.findViewById(R.id.ksad_live_end_bottom_des_btn);
        }
        this.Ff.setOnClickListener(this);
        this.Fg.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    protected final void a(r rVar) throws Resources.NotFoundException {
        super.a(rVar);
        k(rVar.getAdTemplate());
    }

    private void k(AdTemplate adTemplate) throws Resources.NotFoundException {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        KSImageLoader.loadCircleIcon(this.EZ, com.kwad.sdk.core.response.b.a.cC(adInfoEP), this.EZ.getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        this.Fa.setText(com.kwad.sdk.core.response.b.a.cz(adInfoEP));
    }

    private static String r(long j) {
        long j2 = (j / 3600000) % 24;
        long j3 = (j / 60000) % 60;
        long j4 = (j / 1000) % 60;
        return j2 > 0 ? String.format("%02d:%02d:%02d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)) : String.format("%02d:%02d", Long.valueOf(j3), Long.valueOf(j4));
    }

    public final void a(com.kwad.components.ad.reward.g gVar, AdLiveEndResultData.AdLivePushEndInfo adLivePushEndInfo, long j) throws Resources.NotFoundException {
        this.Fc.setText(adLivePushEndInfo.mDisplayLikeUserCount);
        this.Fd.setText(r(adLivePushEndInfo.mLiveDuration));
        this.Fb.setText(adLivePushEndInfo.mDisplayWatchingUserCount);
        if (gVar.tI) {
            String str = String.format("再停留%s秒，即可获得奖励", Integer.valueOf((int) (Math.max(com.kwad.sdk.core.response.b.a.ai(com.kwad.sdk.core.response.b.e.eP(gVar.mAdTemplate)) - j, 0L) / 1000)));
            SpannableString spannableString = new SpannableString(str);
            int color = hT().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = str.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.Fe.setText(spannableString);
            return;
        }
        this.Fe.setText("内容很精彩，不要错过哦");
    }

    public final void ah(int i) throws Resources.NotFoundException {
        TextView textView = this.Fe;
        if (textView != null) {
            if (i > 0) {
                if (this.vb.tI) {
                    String str = String.format("再停留%s秒，即可获得奖励", Integer.valueOf(i));
                    SpannableString spannableString = new SpannableString(str);
                    int color = hT().getResources().getColor(R.color.ksad_reward_main_color);
                    spannableString.setSpan(new ForegroundColorSpan(color), 3, 6, 18);
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                    int length = str.length();
                    spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
                    this.Fe.setText(spannableString);
                    return;
                }
                this.Fe.setText("已获得奖励");
                return;
            }
            textView.setText("已获得奖励");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.eY(24);
        if (view.equals(this.Ff)) {
            this.vb.a(2, view.getContext(), 38, 1, 0L, false, bVar);
        } else if (view.equals(this.Fg)) {
            this.vb.a(2, view.getContext(), 37, 1, 0L, false, bVar);
        }
    }
}
