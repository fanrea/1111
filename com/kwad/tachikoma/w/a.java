package com.kwad.tachikoma.w;

import android.content.Context;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.tachikoma.l.c;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.e;
import com.tk.core.o.o;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends e<BaseKsWebView> {
    private float CB;
    private float CC;
    private float CD;
    private float CE;
    private g FA;
    private final Map<String, com.kwad.tachikoma.l.e> Ft;
    private g Fu;
    private g Fv;
    private g Fw;
    private g Fx;
    private g Fy;
    private g Fz;
    private BaseKsWebView.DeepLinkListener mDeeplinkListener;
    private BaseKsWebView.WebLoadListener mWebLoadListener;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ft = new HashMap();
        this.mWebLoadListener = new BaseKsWebView.WebLoadListener() { // from class: com.kwad.tachikoma.w.a.1
            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.WebLoadListener
            public final void onReceivedHttpError(int i, String str, String str2) {
                if (a.this.Fv != null) {
                    a.this.Fv.call(null, Integer.valueOf(i), str, str2);
                }
            }

            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.WebLoadListener
            public final void onPageStart() {
                if (a.this.Fw != null) {
                    a.this.Fw.call(null, new Object[0]);
                }
            }

            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.WebLoadListener
            public final void onPageFinished() {
                if (a.this.Fu != null) {
                    a.this.Fu.call(null, new Object[0]);
                }
            }

            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.WebLoadListener
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (a.this.Fx != null) {
                    Object objCall = a.this.Fx.call(null, str);
                    if (objCall instanceof Boolean) {
                        return ((Boolean) objCall).booleanValue();
                    }
                }
                return false;
            }

            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.WebLoadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (a.this.Fy != null) {
                    a.this.Fy.call(null, str, str2, str3, str4, Long.valueOf(j));
                }
            }
        };
        this.mDeeplinkListener = new BaseKsWebView.DeepLinkListener() { // from class: com.kwad.tachikoma.w.a.2
            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.DeepLinkListener
            public final void onSuccess() {
                if (a.this.Fz != null) {
                    a.this.Fz.call(null, new Object[0]);
                }
            }

            @Override // com.kwad.components.offline.api.core.webview.BaseKsWebView.DeepLinkListener
            public final void onFailed() {
                if (a.this.FA != null) {
                    a.this.FA.call(null, new Object[0]);
                }
            }
        };
        getView().setWebLoadListener(this.mWebLoadListener);
        getView().setDeeplinkListener(this.mDeeplinkListener);
        getView().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public BaseKsWebView n(Context context) {
        BaseKsWebView baseKsWebViewCreateWebView = OfflineHostProvider.getApi().webview().createWebView(com.kwad.tachikoma.e.hP().hQ().wrapper().unwrapContextIfNeed(context));
        baseKsWebViewCreateWebView.setContextUniqId(pO().hashCode());
        return baseKsWebViewCreateWebView;
    }

    @Override // com.tk.core.component.e
    public final void bY(int i) {
        this.CB = o.eb(i);
        float f = this.CB;
        this.CC = f;
        this.CD = f;
        this.CE = this.CC;
        getView().setRadius(this.CB, this.CC, this.CE, this.CD);
    }

    @Override // com.tk.core.component.e
    public final void bZ(int i) {
        this.CB = o.eb(i);
        getView().setRadius(this.CB, this.CC, this.CE, this.CD);
    }

    @Override // com.tk.core.component.e
    public final void ca(int i) {
        this.CC = o.eb(i);
        getView().setRadius(this.CB, this.CC, this.CE, this.CD);
    }

    @Override // com.tk.core.component.e
    public final void cb(int i) {
        this.CD = o.eb(i);
        getView().setRadius(this.CB, this.CC, this.CE, this.CD);
    }

    @Override // com.tk.core.component.e
    public final void cc(int i) {
        this.CE = o.eb(i);
        getView().setRadius(this.CB, this.CC, this.CE, this.CD);
    }

    public final void setAdCacheId(int i, String str) {
        getView().setAdCacheId(i, str);
    }

    public final void setAdTemplateString(String str) {
        getView().setAdTemplateString(str);
    }

    public final void setEnableWebCache(boolean z) {
        getView().setEnableWebCache(z);
    }

    public final void a(V8Object v8Object, String str) {
        com.kwad.tachikoma.l.e eVar = (com.kwad.tachikoma.l.e) getNativeModule(v8Object);
        eVar.pL();
        getView().addJavascriptInterface(eVar, str);
        this.Ft.put(str, eVar);
        eVar.a(new c() { // from class: com.kwad.tachikoma.w.a.3
            @Override // com.kwad.tachikoma.l.c
            public final void callJS(String str2) {
                a.this.getView().callJs(str2);
            }
        });
    }

    public final void callJS(String str) {
        getView().callJs(str);
    }

    public final void m(String str, String str2) {
        getView().callJs(str, str2);
    }

    public final void loadUrl(String str) {
        getView().setRadius(this.CB, this.CC, this.CE, this.CD);
        getView().loadUrl(str);
    }

    public final void B(V8Function v8Function) {
        g gVar = this.Fw;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fw = new g(v8Function, pO());
    }

    public final void C(V8Function v8Function) {
        g gVar = this.Fu;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fu = new g(v8Function, pO());
    }

    public final void D(V8Function v8Function) {
        g gVar = this.Fv;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fv = new g(v8Function, pO());
    }

    public final void E(V8Function v8Function) {
        g gVar = this.Fy;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fy = new g(v8Function, pO());
    }

    public final void F(V8Function v8Function) {
        g gVar = this.Fx;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fx = new g(v8Function, pO());
    }

    public final void G(V8Function v8Function) {
        g gVar = this.Fz;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fz = new g(v8Function, pO());
    }

    public final void H(V8Function v8Function) {
        g gVar = this.FA;
        if (gVar != null) {
            gVar.destroy();
        }
        this.FA = new g(v8Function, pO());
    }

    public final void setDeeplinkEnabled(boolean z) {
        getView().setDeeplinkEnabled(z);
    }

    public final void setInnerDownloadEnabled(boolean z) {
        getView().setInnerDownloadEnabled(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        getView().setJavaScriptEnabled(z);
    }

    public final void setAllowFileAccess(boolean z) {
        getView().setAllowFileAccess(z);
    }

    public final void setAllowContentAccess(boolean z) {
        getView().setAllowContentAccess(z);
    }

    public final void setTextZoom(int i) {
        getView().setTextZoom(i);
    }

    public final void setAllowFileAccessFromFileURLs(boolean z) {
        getView().setAllowFileAccessFromFileURLs(z);
    }

    public final void setAllowUniversalAccessFromFileURLs(boolean z) {
        getView().setAllowUniversalAccessFromFileURLs(z);
    }

    public final void setMixedContentMode(int i) {
        getView().setMixedContentMode(i);
    }

    public final void setDebugEnabled(boolean z) {
        getView().setDebugEnabled(z);
    }

    public final void setSaveEnabled(boolean z) {
        getView().setSaveEnabled(z);
    }

    public final void setCacheMode(int i) {
        getView().setCacheMode(i);
    }

    public final void N(boolean z) {
        getView().setEnableScroll(z);
    }

    public final boolean canGoBack() {
        return getView().canGoBack();
    }

    public final boolean canGoForward() {
        return getView().canGoForward();
    }

    public final void goBack() {
        getView().goBack();
    }

    public final void goForward() {
        getView().goForward();
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        try {
            getView().destroy();
        } catch (Throwable unused) {
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        g gVar = this.Fw;
        if (gVar != null) {
            gVar.destroy();
        }
        g gVar2 = this.Fu;
        if (gVar2 != null) {
            gVar2.destroy();
        }
        g gVar3 = this.Fv;
        if (gVar3 != null) {
            gVar3.destroy();
        }
        g gVar4 = this.Fy;
        if (gVar4 != null) {
            gVar4.destroy();
        }
        g gVar5 = this.Fx;
        if (gVar5 != null) {
            gVar5.destroy();
        }
        g gVar6 = this.Fz;
        if (gVar6 != null) {
            gVar6.destroy();
        }
        g gVar7 = this.FA;
        if (gVar7 != null) {
            gVar7.destroy();
        }
    }
}
