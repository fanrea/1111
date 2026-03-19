package com.bytedance.sdk.djx.core.act;

import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class DJXFragmentContainerActivity extends BaseActivity {
    protected Fragment mFragment;

    protected abstract Fragment createFragment();

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected void initWindow(Window window) {
    }

    DJXFragmentContainerActivity() {
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragment = createFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.djx_fragment_container, this.mFragment).commitAllowingStateLoss();
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_act_fragment_container);
    }
}
