package com.fendasz.moku.diandian.commons;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class MokuDianActivity extends BaseBackActivity {
    private static final String TAG = "Moku_dian_Activity=>";

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
        super.initRightView(mokuIconTextView);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        super.initLeftView(textView);
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitleCenterLayout(RelativeLayout relativeLayout) {
        super.initTitleCenterLayout(relativeLayout);
    }
}
