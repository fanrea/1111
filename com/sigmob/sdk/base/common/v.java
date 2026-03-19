package com.sigmob.sdk.base.common;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.exceptions.IntentNotResolvableException;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.v;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.LinkAction;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class v extends i {
    com.sigmob.sdk.base.views.g f;
    private int g;
    private BaseAdUnit h;
    private RelativeLayout i;
    private TextView j;
    private ImageView k;
    private String l;

    /* renamed from: com.sigmob.sdk.base.common.v$1, reason: invalid class name */
    class AnonymousClass1 extends com.sigmob.sdk.base.l {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setUrl(str);
            }
        }

        @Override // com.sigmob.sdk.base.l, android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            ac.a("h5_error", "landpage", errorCode, failingUrl + " error:" + description, (WindAdRequest) null, (LoadAdRequest) null, v.this.h, (ac.a) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            SigmobLog.i("onReceivedError:" + error.toString());
            if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT < 23) {
                return;
            }
            ac.a("h5_error", "landpage", 0, request.getUrl() + " error:" + ((Object) error.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, v.this.h, (ac.a) null);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            if (Build.VERSION.SDK_INT >= 21) {
                ac.a("h5_error", "landpage", errorResponse.getStatusCode(), request.getUrl().toString(), (WindAdRequest) null, (LoadAdRequest) null, v.this.h, (ac.a) null);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            String message;
            Context context;
            Uri uri;
            String scheme;
            String host;
            try {
                context = view.getContext();
                uri = Uri.parse(url);
                scheme = uri.getScheme();
                host = uri.getHost();
            } catch (IntentNotResolvableException e) {
                message = e.getMessage();
                SigmobLog.e(message);
                return true;
            } catch (Throwable th) {
                message = th.getMessage();
                SigmobLog.e(message);
                return true;
            }
            if (StringUtil.scheme().equalsIgnoreCase(scheme) && !TextUtils.isEmpty(host) && ("track".equals(host) || "active".equals(host))) {
                String queryParameter = uri.getQueryParameter("data");
                String queryParameter2 = uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                    final String str = new String(Base64.decode(queryParameter, 0), "utf-8");
                    ac.a(host, queryParameter2, v.this.h, new ac.a() { // from class: com.sigmob.sdk.base.common.v$1$$ExternalSyntheticLambda0
                        @Override // com.sigmob.sdk.base.common.ac.a
                        public final void onAddExtra(Object obj) {
                            v.AnonymousClass1.a(str, obj);
                        }
                    });
                }
                return true;
            }
            if (TextUtils.isEmpty(scheme)) {
                SigmobLog.i("load Url: " + url);
            } else {
                LinkAction linkActionA = com.sigmob.sdk.videoplayer.c.a(v.this.h.getAdLinkActions(), uri);
                if (linkActionA == null) {
                    linkActionA = com.sigmob.sdk.videoplayer.c.a(v.this.h.getSlotAdLinkActions(), uri);
                }
                if (linkActionA != null && linkActionA.redirect_count.intValue() <= v.this.h.getRedirectCount(uri)) {
                    return true;
                }
                if (host == null || host.equalsIgnoreCase("hapjs.org") || (!scheme.equalsIgnoreCase(com.alipay.sdk.m.l.a.r) && !scheme.equalsIgnoreCase("https"))) {
                    v.this.h.addRedirectCount(uri);
                    t.a(context, uri, (host == null || !host.equalsIgnoreCase("hapjs.org")) ? t.a(context, uri, v.this.h.getMarketPackageNameList()) : com.sigmob.sdk.b.a());
                    ac.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", v.this.h, "1", url, v.this.l);
                    return true;
                }
            }
            view.loadUrl(url);
            return true;
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.v$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public v(Activity activity, BaseAdUnit baseAdUnit, Bundle intentExtras, Bundle savedInstanceState, String mBroadcastIdentifier, j baseAdViewControllerListener) {
        super(activity, mBroadcastIdentifier, baseAdViewControllerListener);
        this.h = baseAdUnit;
        if (baseAdUnit != null) {
            n().requestWindowFeature(8);
        } else {
            a(IntentActions.ACTION_INTERSTITIAL_FAIL);
            k().a();
        }
    }

    private void a() {
        if (this.f == null) {
            try {
                com.sigmob.sdk.base.views.g gVar = new com.sigmob.sdk.base.views.g(n());
                this.f = gVar;
                gVar.setScrollBarStyle(0);
                this.f.setAdUnit(this.h);
                this.f.setWebViewClient(new AnonymousClass1());
                this.f.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.common.v.2
                    @Override // android.webkit.WebChromeClient
                    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        if (AnonymousClass4.a[consoleMessage.messageLevel().ordinal()] != 1) {
                            return false;
                        }
                        SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                        ac.a("h5_error", "landpage", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, v.this.h, (ac.a) null);
                        return false;
                    }

                    @Override // android.webkit.WebChromeClient
                    public void onReceivedTitle(WebView view, String title) {
                        if (title == null || title.isEmpty() || title.startsWith(com.alipay.sdk.m.l.a.r) || title.length() > 10) {
                            if (v.this.j != null) {
                                v.this.j.setVisibility(8);
                            }
                        } else if (v.this.j != null) {
                            v.this.j.setVisibility(0);
                            v.this.j.setText(title);
                        }
                    }
                });
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                this.d.a();
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout = new LinearLayout(n());
        linearLayout.addView(this.f, 0, layoutParams);
        this.d.onSetContentView(linearLayout);
        if (!this.h.isDisable_download_listener()) {
            this.f.setDownloadListener(new DownloadListener() { // from class: com.sigmob.sdk.base.common.v$$ExternalSyntheticLambda0
                @Override // android.webkit.DownloadListener
                public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                    this.f$0.a(str, str2, str3, str4, j);
                }
            });
        }
        this.f.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.base.common.v.3
            MotionEvent a = null;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                SigmobLog.d(event.toString());
                if (event.getAction() == 0) {
                    this.a = MotionEvent.obtain(event);
                    return false;
                }
                if (event.getAction() != 1) {
                    return false;
                }
                MotionEvent motionEvent = this.a;
                if (motionEvent == null) {
                    v.this.l = SigMacroCommon.getCoordinate(event, event, true);
                    return false;
                }
                v.this.l = SigMacroCommon.getCoordinate(motionEvent, event, true);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setCoordinate(str);
        }
    }

    private void a(String subCategory, String cate, BaseAdUnit adUnit, final String coordinate) {
        ac.a(cate, subCategory, adUnit, new ac.a() { // from class: com.sigmob.sdk.base.common.v$$ExternalSyntheticLambda1
            @Override // com.sigmob.sdk.base.common.ac.a
            public final void onAddExtra(Object obj) {
                v.a(coordinate, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, long j) {
        o.a(str, this.h);
        ac.a(com.sigmob.sdk.base.a.LAND_PAGE, "click", this.h, "0", str, this.l);
        SigmobLog.d("onDownloadStart() called with: url = [" + str + "], userAgent = [" + str2 + "], contentDisposition = [" + str3 + "], mimetype = [" + str4 + "], contentLength = [" + j + "]");
    }

    private void p() {
        if (this.i == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            int iDipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.a);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
            layoutParams2.addRule(15);
            layoutParams2.addRule(9);
            int i = iDipsToIntPixels / 2;
            layoutParams2.setMargins(i, i, 0, 0);
            ImageView imageView = new ImageView(this.a);
            this.k = imageView;
            imageView.setImageBitmap(com.sigmob.sdk.base.views.s.BACK.a());
            this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.k.setClickable(true);
            this.k.setId(ClientMetadata.generateViewId());
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.common.v$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
            RelativeLayout relativeLayout = new RelativeLayout(l());
            this.i = relativeLayout;
            relativeLayout.setLayoutParams(layoutParams);
            this.i.setBackgroundColor(-1);
            this.i.addView(this.k, layoutParams2);
            TextView textView = new TextView(this.a);
            this.j = textView;
            textView.setTextColor(-16777216);
            this.j.setTextSize(18.0f);
            this.j.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(13);
            this.i.addView(this.j, layoutParams3);
        }
    }

    private void q() {
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(-1, -1, 17);
        ActionBar actionBar = n().getActionBar();
        if (actionBar == null) {
            return;
        }
        p();
        actionBar.setCustomView(this.i, layoutParams);
        actionBar.setDisplayOptions(16);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Bundle outState) {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void e() {
        int iC = com.sigmob.sdk.base.k.c();
        if (iC > 0) {
            n().getTheme().applyStyle(iC, true);
        }
        n().getWindow().addFlags(1024);
        q();
        a();
        String strMacroProcess = this.h.getMacroCommon().macroProcess(this.h.getMaterial().landing_page);
        String landUrl = this.h.getLandUrl();
        if (TextUtils.isEmpty(landUrl)) {
            this.f.loadUrl(strMacroProcess);
        } else {
            this.f.loadUrl(landUrl);
        }
        a(IntentActions.ACTION_LANDPAGE_SHOW);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void f() {
    }

    @Override // com.sigmob.sdk.base.common.i
    public void g() {
        com.sigmob.sdk.base.views.g gVar = this.f;
        if (gVar != null) {
            gVar.resumeTimers();
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public void h() {
        a(IntentActions.ACTION_LANDPAGE_DISMISS);
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setOnClickListener(null);
            this.k = null;
        }
        com.sigmob.sdk.base.views.g gVar = this.f;
        if (gVar != null) {
            gVar.destroy();
            this.f = null;
        }
        super.h();
    }

    @Override // com.sigmob.sdk.base.common.i
    public void i() {
        if (j()) {
            k().a();
        }
    }

    @Override // com.sigmob.sdk.base.common.i
    public boolean j() {
        if (!this.f.canGoBack()) {
            return true;
        }
        this.f.goBack();
        return false;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void o() {
    }
}
