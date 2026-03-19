package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.cs;
import com.baidu.mobads.sdk.internal.ct;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class CpuAdView extends RelativeLayout {
    private ct mAdProd;

    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        cs csVar = new cs(context);
        this.mAdProd = new ct(context, csVar, str, i, cPUWebAdRequestParam);
        addView(csVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        cs csVar = new cs(context);
        ct ctVar = new ct(context, csVar, str, i, cPUWebAdRequestParam);
        this.mAdProd = ctVar;
        ctVar.a(cpuAdViewInternalStatusListener);
        addView(csVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        View viewW = this.mAdProd.w();
        if (viewW instanceof WebView) {
            ((WebView) viewW).onResume();
        }
    }

    public void onPause() {
        View viewW = this.mAdProd.w();
        if (viewW instanceof WebView) {
            ((WebView) viewW).onPause();
        }
    }

    public void onDestroy() {
        View viewW = this.mAdProd.w();
        if (viewW instanceof WebView) {
            ((WebView) viewW).destroy();
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    protected boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void requestData() {
        ct ctVar = this.mAdProd;
        if (ctVar != null) {
            ctVar.a();
        }
    }
}
