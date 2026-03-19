package com.sigmob.sdk.base.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.ReflectionUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o extends g {
    private static float b = 10.0f;
    private static final float c = 1.0f;
    private final com.sigmob.sdk.base.views.b a;
    private a d;

    public interface a {
        void onWebViewClick(MotionEvent downEvent, MotionEvent upEvent);
    }

    class b implements View.OnTouchListener {
        MotionEvent a;
        private boolean c;

        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                this.c = true;
                this.a = MotionEvent.obtain(event);
            } else {
                if (action != 1 || !this.c) {
                    return false;
                }
                this.c = false;
                if (o.this.d != null) {
                    o.this.d.onWebViewClick(this.a, event);
                }
            }
            return false;
        }
    }

    private o(Context context, String adLogoUrl, boolean showAdLogo, boolean invisible_ad_label) {
        super(context);
        j();
        try {
            ReflectionUtil.MethodBuilder methodBuilder = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.n.D, 2)));
            methodBuilder.addParam(Boolean.TYPE, true);
            methodBuilder.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ReflectionUtil.MethodBuilder methodBuilder2 = new ReflectionUtil.MethodBuilder(getSettings(), new String(Base64.decode(com.sigmob.sdk.base.n.F, 2)));
            methodBuilder2.addParam(Boolean.TYPE, true);
            methodBuilder2.execute();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(true);
        setBackgroundColor(0);
        if (showAdLogo) {
            ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            com.sigmob.sdk.base.views.b bVar = new com.sigmob.sdk.base.views.b(getContext().getApplicationContext(), 1);
            this.a = bVar;
            bVar.a(adLogoUrl);
            bVar.b(com.sigmob.sdk.base.k.h());
            addView(bVar, layoutParams);
        } else {
            this.a = null;
        }
        setOnTouchListener(new b());
    }

    public static o a(final Context context, final String adLogoUrl, boolean showAdLogo, boolean invisible_ad_label) {
        Preconditions.NoThrow.checkNotNull(context);
        return new o(context, adLogoUrl, showAdLogo, invisible_ad_label);
    }

    private void j() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    void a(String data) {
        File fileB = com.sigmob.sdk.base.utils.i.b(data, Md5Util.md5(data) + ".html");
        if (fileB == null || TextUtils.isEmpty(fileB.getAbsolutePath())) {
            loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://localhost/", data, "text/html", "utf-8", null);
        } else {
            loadUrl(UriUtils.FILE_PREFIX + fileB.getAbsolutePath());
        }
    }

    @Override // com.sigmob.sdk.base.views.g, android.webkit.WebView
    public void destroy() {
        SigmobLog.d("CreativeWebView destroy() callSigmobLog.d( \"CreativeWebView destroy() called\");ed");
        super.destroy();
        removeAllViews();
    }

    public void setLogoClickListener(View.OnClickListener listener) {
        com.sigmob.sdk.base.views.b bVar = this.a;
        if (bVar != null) {
            bVar.setOnClickListener(listener);
        }
    }

    public void setWebViewClickListener(a webViewClickListener) {
        this.d = webViewClickListener;
    }
}
