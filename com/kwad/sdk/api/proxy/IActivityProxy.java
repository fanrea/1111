package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class IActivityProxy implements IComponentProxy {
    private Activity mActivity;

    @KsAdSdkDynamicApi
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @KsAdSdkDynamicApi
    public void onApplyThemeResource(Resources.Theme theme, int i, boolean z) {
    }

    @KsAdSdkDynamicApi
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
    }

    @KsAdSdkDynamicApi
    public void onConfigurationChanged(Configuration configuration) {
    }

    @KsAdSdkDynamicApi
    protected void onCreate(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    protected void onDestroy() {
    }

    @KsAdSdkDynamicApi
    public void onNewIntent(Intent intent) {
    }

    @KsAdSdkDynamicApi
    public void onPause() {
    }

    @KsAdSdkDynamicApi
    protected void onPostCreate(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    public void onPostResume() {
    }

    @KsAdSdkDynamicApi
    protected void onPreCreate(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    public void onPreDestroy() {
    }

    @KsAdSdkDynamicApi
    public void onPrePause() {
    }

    @KsAdSdkDynamicApi
    public void onPreResume() {
    }

    @KsAdSdkDynamicApi
    public void onPreSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    public void onPreStart() {
    }

    @KsAdSdkDynamicApi
    public void onPreStop() {
    }

    @KsAdSdkDynamicApi
    public void onRestart() {
    }

    @KsAdSdkDynamicApi
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    public void onResume() {
    }

    @KsAdSdkDynamicApi
    public void onSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    public void onStart() {
    }

    @KsAdSdkDynamicApi
    public void onStop() {
    }

    @KsAdSdkDynamicApi
    public void onTitleChanged(CharSequence charSequence, int i) {
    }

    @KsAdSdkDynamicApi
    public void onUserLeaveHint() {
    }

    void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @KsAdSdkDynamicApi
    @Deprecated
    public Activity getActivity() {
        return this.mActivity;
    }

    @KsAdSdkDynamicApi
    public Intent getIntent() {
        return this.mActivity.getIntent();
    }

    @KsAdSdkDynamicApi
    public void setContentView(int i) {
        this.mActivity.setContentView(i);
    }

    @KsAdSdkDynamicApi
    public void setContentView(View view) {
        this.mActivity.setContentView(view);
    }

    @KsAdSdkDynamicApi
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActivity.setContentView(view, layoutParams);
    }

    @KsAdSdkDynamicApi
    public <T extends View> T findViewById(int i) {
        return (T) this.mActivity.findViewById(i);
    }

    @KsAdSdkDynamicApi
    public void finish() {
        this.mActivity.finish();
    }

    @KsAdSdkDynamicApi
    public void overridePendingTransition(int i, int i2) {
        this.mActivity.overridePendingTransition(i, i2);
    }

    @KsAdSdkDynamicApi
    public Window getWindow() {
        return this.mActivity.getWindow();
    }

    @KsAdSdkDynamicApi
    public void onBackPressed() {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            try {
                ((BaseProxyActivity) activity).superOnBackPressed();
            } catch (Exception unused) {
            }
        } else {
            if (activity instanceof BaseProxyFragmentActivity) {
                try {
                    ((BaseProxyFragmentActivity) activity).superOnBackPressed();
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
        }
    }

    @KsAdSdkDynamicApi
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyDown(i, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyDown(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyLongPress(i, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyLongPress(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyUp(i, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyUp(i, keyEvent);
        }
        throw new RuntimeException(this.mActivity + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }
}
