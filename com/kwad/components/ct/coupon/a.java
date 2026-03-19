package com.kwad.components.ct.coupon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.proxy.i;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bg;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.ct.coupon.bridge.d;
import com.kwad.components.ct.coupon.bridge.f;
import com.kwad.components.ct.coupon.model.CouponStatusInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.cc;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends i {
    private ImageView Pd;
    private LinearLayout amr;
    private com.kwad.components.core.webview.a.b ams;
    private TextView amt;
    private LinearLayout amu;
    private TextView amv;
    private com.kwad.components.ct.coupon.bridge.d amw;
    private com.kwad.components.ct.coupon.bridge.c amx;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private KsAdWebView gz;
    private Context mContext;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener = new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.ct.coupon.a.1
        @Override // com.kwad.sdk.core.webview.d.a.b
        public final void b(WebCloseStatus webCloseStatus) {
            a.this.finish();
        }
    };
    private com.kwad.components.ct.coupon.bridge.a.a amy = new com.kwad.components.ct.coupon.bridge.a.a() { // from class: com.kwad.components.ct.coupon.a.3
        @Override // com.kwad.components.ct.coupon.bridge.a.a
        public final void a(CouponStatusInfo couponStatusInfo) {
            if (couponStatusInfo != null) {
                b.xo().b(couponStatusInfo);
                b.xo().bn(true);
                b.xo().xr();
            }
        }
    };
    private am.b gG = new am.b() { // from class: com.kwad.components.ct.coupon.a.4
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "onAdFrameValid=" + aVar);
            a.this.gz.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private at.b gI = new at.b() { // from class: com.kwad.components.ct.coupon.a.5
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            com.kwad.sdk.core.d.c.i("ActiveWebViewActivityImpl", "updatePageStatus mPageState: " + aVar);
        }
    };
    private com.kwad.components.ct.coupon.bridge.a.b amz = new com.kwad.components.ct.coupon.bridge.a.b() { // from class: com.kwad.components.ct.coupon.a.6
        @Override // com.kwad.components.ct.coupon.bridge.a.b
        public final void a(d.b bVar) {
            if (bVar == null || bVar.ang != 1) {
                a.this.amu.setVisibility(8);
                return;
            }
            a.this.amt.setText(bVar.anh);
            a.this.amv.setText(bVar.ani);
            a.this.amu.setVisibility(0);
        }
    };

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "ActiveWebViewActivityImpl";
    }

    public static void a(Context context, com.kwad.components.core.webview.a.b bVar) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.c.g(BaseFragmentActivity.FragmentActivity6.class, a.class);
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity6.class);
        intent.putExtra("KEY_WEB_VIEW_PARAMS", bVar.toJson().toString());
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = m.wrapContextIfNeed(getActivity());
            if (xn()) {
                getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_activity_active_webview);
                fy();
                xm();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void xm() {
        this.amu = (LinearLayout) findViewById(R.id.ksad_kwad_titlebar);
        this.amt = (TextView) findViewById(R.id.ksad_kwad_titlebar_title);
        TextView textView = (TextView) findViewById(R.id.ksad_kwad_titlebar_right_btn);
        this.amv = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.coupon.a.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.amw != null) {
                    a.this.amw.xO();
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.ksad_kwad_titlebar_back_btn);
        this.Pd = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.coupon.a.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.onBackPressed();
            }
        });
    }

    private boolean xn() {
        String stringExtra = getIntent().getStringExtra("KEY_WEB_VIEW_PARAMS");
        com.kwad.components.core.webview.a.b bVar = new com.kwad.components.core.webview.a.b();
        this.ams = bVar;
        try {
            bVar.parseJson(new JSONObject(stringExtra));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            this.ams = null;
        }
        return this.ams != null;
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void fy() {
        this.amr = (LinearLayout) findViewById(R.id.ksad_kwad_active_webview_container);
        this.gz = (KsAdWebView) findViewById(R.id.ksad_kwad_active_webview);
        bh();
        pj();
    }

    private void bh() {
        this.gC = new com.kwad.sdk.core.webview.b();
        this.gC.mScreenOrientation = !aq.apb() ? 1 : 0;
        this.gC.bLv = null;
        this.gC.Vu = this.amr;
        this.gC.UO = this.gz;
    }

    private void pj() {
        bj();
        this.gz.setBackgroundColor(0);
        this.gz.setVisibility(0);
    }

    private void bj() {
        com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "setupJsBridge");
        bk();
        cc.b(this.gz);
        this.gz.setClientConfig(this.gz.getClientConfig().b(getWebErrorListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.gz);
        this.gB = aVar;
        a(aVar);
        this.gz.addJavascriptInterface(this.gB, "KwaiAd");
        this.gz.loadUrl(getUrl());
    }

    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ct.coupon.a.9
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
            }
        };
    }

    private String getUrl() {
        String str = this.ams.url;
        com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "getUrl url=" + str);
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strBN = com.kwad.components.ct.home.config.c.FX().bN(str);
        if (TextUtils.isEmpty(strBN)) {
            return str;
        }
        File fileP = e.P(this.mContext, strBN);
        if (!fileP.exists()) {
            return str;
        }
        String string = Uri.fromFile(fileP).toString();
        com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "getUrl preloadUrl=" + string);
        return string;
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView != null) {
            ksAdWebView.clearHistory();
            this.gz.clearCache(false);
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "registerWebCardHandler");
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new am(this.gC, this.gG));
        aVar.a(new at(this.gI, getUrl()));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new aa(this.mWebCardCloseListener));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(new bg(this.gC));
        com.kwad.components.ct.coupon.bridge.c cVar = new com.kwad.components.ct.coupon.bridge.c();
        this.amx = cVar;
        aVar.a(cVar);
        com.kwad.components.ct.coupon.bridge.d dVar = new com.kwad.components.ct.coupon.bridge.d(this.amz);
        this.amw = dVar;
        aVar.a(dVar);
        aVar.a(new com.kwad.components.ct.coupon.bridge.b(this.mContext));
        aVar.a(new com.kwad.components.ct.coupon.bridge.a(this.ams));
        aVar.a(new f(this.amy));
        aVar.a(new ar(new ar.a() { // from class: com.kwad.components.ct.coupon.a.10
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                a.a(a.this.amr.getContext(), bVar);
                com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "onOpenNewPage ");
            }
        }));
        aVar.a(new ar(new ar.a() { // from class: com.kwad.components.ct.coupon.a.2
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                a.a(a.this.amr.getContext(), bVar);
                com.kwad.sdk.core.d.c.d("ActiveWebViewActivityImpl", "onOpenNewPage ");
            }
        }));
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStart() {
        super.onStart();
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        com.kwad.components.ct.coupon.bridge.c cVar = this.amx;
        if (cVar != null) {
            cVar.onPagePause();
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onStop() {
        super.onStop();
        com.kwad.components.ct.coupon.bridge.c cVar = this.amx;
        if (cVar != null) {
            cVar.xM();
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            com.kwad.components.ct.coupon.bridge.c cVar = this.amx;
            if (cVar != null) {
                cVar.onPageDestroy();
            }
            KsAdWebView ksAdWebView = this.gz;
            if (ksAdWebView != null) {
                ksAdWebView.release();
                this.gz = null;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onRestart() {
        super.onRestart();
        com.kwad.components.ct.coupon.bridge.c cVar = this.amx;
        if (cVar != null) {
            cVar.xN();
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        KsAdWebView ksAdWebView = this.gz;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.gz.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
