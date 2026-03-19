package com.kwad.components.ct.profile.home;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.lib.desigin.CustomActionBarBehavior;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ProfileHomeTitleBarBehavior extends CustomActionBarBehavior {
    private static final String TAG = "ProfileHomeTitleBarBehavior";
    private ImageView mLeftBackNormal;
    private ImageView mLeftBackShadow;
    private ImageView mRightMoreNormal;
    private ImageView mRightMoreShadow;
    private TextView mTitleTv;

    public ProfileHomeTitleBarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    public void initView(RelativeLayout relativeLayout) {
        if (this.mLeftBackNormal == null) {
            this.mLeftBackNormal = (ImageView) relativeLayout.findViewById(R.id.ksad_profile_left_back_normal);
        }
        if (this.mLeftBackShadow == null) {
            this.mLeftBackShadow = (ImageView) relativeLayout.findViewById(R.id.ksad_profile_left_back_shadow);
        }
        if (this.mTitleTv == null) {
            this.mTitleTv = (TextView) relativeLayout.findViewById(R.id.ksad_profile_title);
        }
        if (this.mRightMoreNormal == null) {
            this.mRightMoreNormal = (ImageView) relativeLayout.findViewById(R.id.ksad_profile_right_more_normal);
        }
        if (this.mRightMoreShadow == null) {
            this.mRightMoreShadow = (ImageView) relativeLayout.findViewById(R.id.ksad_profile_right_more_shadow);
        }
    }

    @Override // com.kwad.sdk.lib.desigin.CustomActionBarBehavior
    public void onActionBarHeightChanged(RelativeLayout relativeLayout, float f) {
        com.kwad.sdk.core.d.c.i(TAG, "onActionBarHeightChanged: ratio: " + f);
        super.onActionBarHeightChanged(relativeLayout, f);
        float fTransRatio = transRatio(0.13f, 1.0f, f);
        float f2 = 1.0f - fTransRatio;
        this.mLeftBackShadow.setAlpha(f2);
        this.mLeftBackNormal.setAlpha(fTransRatio);
        this.mTitleTv.setAlpha(transRatio(0.58f, 1.0f, f));
        this.mRightMoreShadow.setAlpha(f2);
        this.mRightMoreNormal.setAlpha(fTransRatio);
    }
}
