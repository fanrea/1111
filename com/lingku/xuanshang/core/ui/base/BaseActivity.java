package com.lingku.xuanshang.core.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;
import java.util.ArrayList;
import java.util.Stack;
import lkxssdk.d.b;
import lkxssdk.e.f;
import lkxssdk.e.g;
import lkxssdk.e.h;
import lkxssdk.e.i;
import lkxssdk.e.q;
import lkxssdk.e.r;
import lkxssdk.e.t;
import lkxssdk.e.y;
import lkxssdk.i.a;
import lkxssdk.j.c;
import lkxssdk.l.v;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class BaseActivity extends Activity implements b, c {
    public static BaseActivity a;
    public a b;
    public y c;

    @Override // lkxssdk.j.c
    public void a(String str) {
    }

    @Override // lkxssdk.j.c
    public void a(boolean z, String str) {
    }

    public void b(String str) {
        if (this.c == null) {
            this.c = new y(this);
        }
        this.c.a(str, true, true);
    }

    public void g() {
        y yVar = this.c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a aVar = this.b;
        if (aVar != null) {
            WebViewWrapper webViewWrapper = (WebViewWrapper) aVar;
            v vVar = webViewWrapper.l;
            if (vVar != null && i == 10000) {
                if (i2 == -1) {
                    ValueCallback<Uri> valueCallback = vVar.b;
                    if (valueCallback != null) {
                        if (intent != null) {
                            valueCallback.onReceiveValue(intent.getData());
                        } else {
                            valueCallback.onReceiveValue(null);
                        }
                        vVar.b = null;
                    }
                    ValueCallback<Uri[]> valueCallback2 = vVar.c;
                    if (valueCallback2 != null) {
                        if (intent != null) {
                            valueCallback2.onReceiveValue(new Uri[]{intent.getData()});
                        } else {
                            valueCallback2.onReceiveValue(null);
                        }
                        vVar.c = null;
                    }
                } else if (i2 == 0) {
                    vVar.a();
                }
            }
            t tVar = webViewWrapper.n;
            if (tVar == null || i != 50000) {
                return;
            }
            lkxssdk.h0.c.b("pic  111");
            if (i2 != -1) {
                i.b().getClass();
                i.a = null;
                return;
            }
            if (i.b().n.size() > 0) {
                lkxssdk.h0.c.b("pic  222");
                if (!i.b().l) {
                    tVar.a.b("视频压缩中...");
                    new g(new h(null, 1000, 100), i.b().n, new r(tVar)).start();
                    return;
                }
                lkxssdk.h0.c.b("pic  333");
                if (!TextUtils.isEmpty(tVar.e) && tVar.d == null) {
                    Resources resources = tVar.a.getResources();
                    e eVarA = e.a();
                    BitmapFactory.decodeResource(resources, eVarA.b.getResources().getIdentifier("lkxs_water", "drawable", eVarA.c));
                }
                h hVar = new h(tVar.d, i.b().f, i.b().g);
                ArrayList<String> arrayList = i.b().n;
                boolean z = i.b().m;
                q qVar = new q(tVar);
                hVar.f = z;
                hVar.e = "";
                new f(hVar, arrayList, qVar).start();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        y yVar = this.c;
        if (yVar == null || !yVar.f) {
            a aVar = this.b;
            if (aVar == null) {
                d();
                return;
            }
            WebViewWrapper webViewWrapper = (WebViewWrapper) aVar;
            if (webViewWrapper.g) {
                webViewWrapper.a("wapBackPressed", "{}");
            } else {
                webViewWrapper.a.d();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Stack<BaseActivity> stack = lkxssdk.d.a.a;
        if (stack != null && !stack.contains(this)) {
            lkxssdk.d.a.a.add(this);
        }
        if (getClass().getSimpleName().equals("MainActivity")) {
            a = this;
        } else {
            Stack<BaseActivity> stack2 = lkxssdk.d.a.a;
            if (stack2 != null && !stack2.contains(this)) {
                lkxssdk.d.a.a.add(this);
            }
        }
        if (f() > 0) {
            setContentView(f());
        }
        a(bundle);
        b();
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Stack<BaseActivity> stack = lkxssdk.d.a.a;
        if (stack != null && stack.contains(this)) {
            lkxssdk.d.a.a.remove(this);
        }
        e();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        super.setContentView(i);
        lkxssdk.a.a.a(this, -1);
    }
}
