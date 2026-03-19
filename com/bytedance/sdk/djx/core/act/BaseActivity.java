package com.bytedance.sdk.djx.core.act;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.djx.core.business.web.WebViewTweaker;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import com.bytedance.sdk.djx.utils.DJXSdkUtils;
import com.bytedance.sdk.djx.utils.ZeusUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseActivity extends AppCompatActivity {
    protected View mContentView;
    protected FrameLayout mOtherLayout;

    protected abstract Object getLayoutId();

    protected abstract void initWindow(Window window);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (DJXSdkUtils.isRunningPlugin() != isPluginActivity()) {
            super.onCreate(null);
            finish();
            return;
        }
        super.onCreate(bundle);
        initWindow(getWindow());
        Object layoutId = getLayoutId();
        if (layoutId instanceof View) {
            this.mContentView = (View) layoutId;
        } else {
            this.mContentView = LayoutInflater.from(this).inflate(((Integer) layoutId).intValue(), (ViewGroup) null, false);
        }
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(this.mContentView, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this);
        this.mOtherLayout = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        setContentView(frameLayout);
    }

    protected void addOtherView(View view) {
        FrameLayout frameLayout;
        if (view == null || (frameLayout = this.mOtherLayout) == null) {
            return;
        }
        frameLayout.addView(view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ToastUtil.cancelAll(this);
    }

    protected void clearAllWebView(WebView... webViewArr) {
        if (webViewArr != null) {
            for (WebView webView : webViewArr) {
                if (webView != null) {
                    try {
                        WebViewTweaker.tweakPauseIfFinishing(this, webView);
                        WebViewTweaker.clearWebviewOnDestroy(webView);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    protected void replaceFragment(int i, Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(i, fragment).commitAllowingStateLoss();
    }

    protected boolean isPluginActivity() {
        return ZeusUtils.getPluginClassLoader(DJXSdkUtils.getPluginPackageName()) == getClassLoader();
    }
}
