package com.bytedance.sdk.djx.core.act;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaDetailFragment;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.StatusBarUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaDetailActivity extends BaseActivity {
    private static final String TAG = "DJXDramaDetailActivity";
    private static DJXWidgetDramaDetailParams sParams;
    private DJXDramaDetailFragment mDramaDetailFragment;
    private DJXWidgetDramaDetailParams mParams;

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        overridePendingTransition(R.anim.djx_anim_right_in, R.anim.djx_anim_no_anim);
        super.onCreate(bundle);
        try {
            getWindow().addFlags(128);
        } catch (Throwable unused) {
        }
        initData();
        initDrawFragment();
        if (this.mDramaDetailFragment != null) {
            replaceFragment(R.id.djx_drama_play_frame, this.mDramaDetailFragment.getFragment());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.uiMode & 48;
        if (i == 16) {
            LG.e(TAG, "onConfigurationChanged: uiMode = UI_MODE_NIGHT_NO");
        } else {
            if (i != 32) {
                return;
            }
            LG.e(TAG, "onConfigurationChanged: uiMode = UI_MODE_NIGHT_YES");
        }
    }

    private void initData() {
        this.mParams = sParams;
        cleanData();
    }

    private void cleanData() {
        sParams = null;
    }

    private void initDrawFragment() {
        this.mDramaDetailFragment = DJXDramaDetailFragment.obtain(this.mParams);
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected void initWindow(Window window) {
        try {
            Window window2 = getWindow();
            if (window2 == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (Build.VERSION.SDK_INT >= 28) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            getWindow().setAttributes(attributes);
            StatusBarUtil.setLightMode(this);
            StatusBarUtil.setTransparentForWindow(this);
            StatusBarUtil.setColor(this, 0);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity
    protected Object getLayoutId() {
        return Integer.valueOf(R.layout.djx_act_drama_play);
    }

    @Override // com.bytedance.sdk.djx.core.act.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DJXDramaDetailFragment dJXDramaDetailFragment = this.mDramaDetailFragment;
        if (dJXDramaDetailFragment != null) {
            dJXDramaDetailFragment.destroy();
        }
    }

    public static void startWithParams(DJXWidgetDramaDetailParams dJXWidgetDramaDetailParams) {
        sParams = dJXWidgetDramaDetailParams;
        Context context = InnerManager.getContext();
        Intent intent = new Intent(context, (Class<?>) DJXDramaDetailActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
