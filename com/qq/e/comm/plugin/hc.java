package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.qq.e.comm.plugin.fq;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class hc implements ek {
    private final dk a;
    private final jm b;
    private boolean c;
    private fq.a d;
    private ObjectAnimator e;

    public hc(dk dkVar, jm jmVar) {
        this.a = dkVar;
        this.b = jmVar;
        a(dkVar);
    }

    /* compiled from: A */
    class a implements fq.a {
        a() {
        }

        @Override // com.qq.e.comm.plugin.fq.a
        public void a(View view, String str) {
            hc.this.a(view, str);
        }

        @Override // com.qq.e.comm.plugin.fq.a
        public void b() {
            hc.this.c();
        }
    }

    void c() {
        fq.a aVar = this.d;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* compiled from: A */
    class b extends fz {
        b() {
        }

        @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
        public void c(String str) {
            super.c(str);
            if (hc.this.a != null) {
                hc.this.a.e();
            }
        }

        @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh
        public void a(int i, String str, String str2) {
            super.a(i, str, str2);
            if (hc.this.a != null) {
                hc.this.a.a(str2);
            }
        }

        @Override // com.qq.e.comm.plugin.fz, com.qq.e.comm.plugin.sh.a
        public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Uri url;
            super.a(webView, webResourceRequest, webResourceResponse);
            String string = (Build.VERSION.SDK_INT < 21 || webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? "" : url.toString();
            if (hc.this.a != null) {
                hc.this.a.a(string);
            }
        }
    }

    private void d() {
        this.b.a(new b());
    }

    @Override // com.qq.e.comm.plugin.ek
    public void dismiss() {
        if (a() == null || !this.c) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(a(), (Property<View, Float>) View.ALPHA, 0.0f);
        this.e = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(700L);
        this.e.addListener(new c());
        this.e.start();
    }

    /* compiled from: A */
    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            View viewA = hc.this.a();
            if (viewA != null) {
                viewA.setAlpha(1.0f);
                hc.this.b();
            }
            hc.this.e = null;
        }
    }

    @Override // com.qq.e.comm.plugin.ek
    public boolean show() {
        View viewA;
        dk dkVar = this.a;
        if (dkVar != null) {
            dkVar.f();
            if (this.a.d() && (viewA = a()) != null) {
                ObjectAnimator objectAnimator = this.e;
                if (objectAnimator != null) {
                    objectAnimator.cancel();
                }
                viewA.setVisibility(0);
                this.c = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        View viewA = a();
        if (viewA != null) {
            viewA.setVisibility(4);
        }
        this.c = false;
    }

    @Override // com.qq.e.comm.plugin.ek
    public void destroy() {
        this.b.d();
        dk dkVar = this.a;
        if (dkVar != null) {
            dkVar.destroy();
        }
    }

    @Override // com.qq.e.comm.plugin.ek
    public void loadUrl(String str) {
        this.b.loadUrl(str);
    }

    @Override // com.qq.e.comm.plugin.ek
    public View a() {
        return this.b.a();
    }

    private void a(dk dkVar) {
        a(dkVar.b());
        d();
        View viewA = a();
        if (viewA != null) {
            viewA.setBackgroundColor(0);
        }
        b();
    }

    void a(View view, String str) {
        fq.a aVar = this.d;
        if (aVar != null) {
            aVar.a(view, str);
        }
    }

    private void a(h4 h4Var) {
        bm bmVarB = this.b.b();
        if (bmVarB == null) {
            return;
        }
        bmVarB.a("videoService", new hq(h4Var, new a()));
    }

    @Override // com.qq.e.comm.plugin.ek
    public void a(fq.a aVar) {
        this.d = aVar;
    }
}
