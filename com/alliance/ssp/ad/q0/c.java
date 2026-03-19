package com.alliance.ssp.ad.q0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.o0.h;

/* compiled from: RewardVideoTipDialog.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c extends a {
    public TextView h;
    public String i;

    public c(Context context) {
        super(context);
        this.h = null;
        this.i = null;
    }

    @Override // com.alliance.ssp.ad.q0.a, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_nmssp_reward_video_verify_dialog, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_nm_reward_video_tip);
        this.h = textView;
        if (textView != null && !TextUtils.isEmpty(this.i)) {
            this.h.setText(this.i);
        }
        FrameLayout frameLayout = this.a;
        if (frameLayout != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.height = h.a(getContext(), 137.0f);
            this.a.setLayoutParams(layoutParams);
            this.a.removeAllViews();
            this.a.addView(viewInflate);
        }
    }
}
