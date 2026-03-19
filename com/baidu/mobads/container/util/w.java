package com.baidu.mobads.container.util;

import android.text.TextUtils;
import android.webkit.WebView;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w {
    private static final String a = w.class.getSimpleName();
    private ArrayList<a> b = new ArrayList<>();
    private int c = -1;
    private WebView d;

    static class a {
        private String a;
        private String b;
        private int c = -1;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.c--;
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(String str) {
            if (this.b != null) {
                return this.b.equals(str);
            }
            return str == null;
        }
    }

    public void a(WebView webView) {
        this.d = webView;
    }

    public void a() {
        synchronized (this) {
            this.d = null;
            this.c = -1;
            this.b.clear();
        }
    }

    public void a(String str, boolean z) {
        WebView.HitTestResult hitTestResult;
        if (this.d == null || z || TextUtils.isEmpty(str)) {
            return;
        }
        if ((this.c > -1 && str.equals(this.b.get(this.c).a)) || (hitTestResult = this.d.getHitTestResult()) == null) {
            return;
        }
        String extra = hitTestResult.getExtra();
        synchronized (this) {
            if (!a(extra)) {
                this.b.get(this.c).a(str);
            } else {
                this.b.add(new a(str, extra));
                this.c++;
            }
        }
    }

    public void b() {
        int i;
        if (this.d == null) {
            bq.a().b(a, "go back with a null mView.");
            return;
        }
        synchronized (this) {
            if (!this.b.isEmpty()) {
                i = this.b.get(this.c).c;
            } else {
                i = 0;
            }
            this.d.goBackOrForward(i);
            this.b.remove(this.c);
            this.c--;
        }
    }

    public boolean c() {
        int i;
        return !this.b.isEmpty() && (i = this.b.get(this.c).c) < 0 && this.d.canGoBackOrForward(i);
    }

    private boolean a(String str) {
        if (this.b.isEmpty()) {
            return true;
        }
        try {
            return !this.b.get(this.c).b(str);
        } catch (Exception e) {
            return true;
        }
    }
}
