package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import com.qq.e.comm.plugin.sh;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ph implements jm {
    private final rh a;
    private final nh b;
    private final oh c;
    private Context d;
    private final boolean e;
    private final String f;
    private boolean g;
    private sh h;

    public ph(Context context, String str, boolean z) throws JSONException {
        oh ohVar;
        oh ohVarA;
        rh rhVar = new rh();
        this.a = rhVar;
        rhVar.a(this);
        this.b = new nh();
        this.e = z;
        this.f = str;
        if (z && !TextUtils.isEmpty(str)) {
            ohVarA = r50.a().a(context, str);
        } else {
            try {
                ohVar = new oh(context);
            } catch (Resources.NotFoundException unused) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 21 && i < 23) {
                    ohVar = new oh(context.createConfigurationContext(new Configuration()));
                } else {
                    ohVar = new oh(context.getApplicationContext());
                }
            }
            ohVarA = ohVar;
        }
        if (ohVarA != null) {
            ohVarA.a(this.a);
            ohVarA.a(this.b);
        }
        this.c = ohVarA;
    }

    @Override // com.qq.e.comm.plugin.jm
    public void d() {
        this.g = true;
        if (this.e) {
            r50.a().a(this.c, this.f);
        } else {
            this.c.destroy();
        }
    }

    @Override // com.qq.e.comm.plugin.jm
    public void loadUrl(String str) {
        this.c.loadUrl(str);
        sh shVar = this.h;
        if (shVar instanceof sh.a) {
            ((sh.a) shVar).a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.jm
    public bm b() {
        return this.c.b();
    }

    @Override // com.qq.e.comm.plugin.jm
    public boolean canGoBack() {
        return this.c.canGoBack();
    }

    @Override // com.qq.e.comm.plugin.jm
    public void goBack() {
        this.c.goBack();
    }

    @Override // com.qq.e.comm.plugin.jm
    public boolean canGoBackOrForward(int i) {
        return this.c.canGoBackOrForward(i);
    }

    @Override // com.qq.e.comm.plugin.t50
    public void a(String str) {
        a(str, null);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void setFocusable(boolean z) {
        this.c.setFocusable(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void setFocusableInTouchMode(boolean z) {
        this.c.setFocusableInTouchMode(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void f(boolean z) {
        this.c.f(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public u50 c() {
        return this.c.c();
    }

    @Override // com.qq.e.comm.plugin.jm
    public void addJavascriptInterface(Object obj, String str) {
        this.c.addJavascriptInterface(obj, str);
    }

    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.jm
    public Context getContext() {
        Context context = this.d;
        if (context != null) {
            return context;
        }
        oh ohVar = this.c;
        if (ohVar != null && ohVar.getContext() != null) {
            return this.c.getContext();
        }
        return r1.d().a();
    }

    @Override // com.qq.e.comm.plugin.jm
    public String e() {
        WebSettings settings;
        oh ohVar = this.c;
        if (ohVar == null || (settings = ohVar.getSettings()) == null) {
            return null;
        }
        return settings.getUserAgentString();
    }

    @Override // com.qq.e.comm.plugin.jm
    public void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        oh ohVar = this.c;
        if (ohVar == null) {
            return;
        }
        try {
            ohVar.getClass().getMethod("onResume", new Class[0]).invoke(this.c, null);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.jm
    public void c(boolean z) {
        this.a.a(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void onPause() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        oh ohVar = this.c;
        if (ohVar == null) {
            return;
        }
        try {
            ohVar.getClass().getMethod("onPause", new Class[0]).invoke(this.c, null);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.t50
    public void a(String str, ValueCallback<String> valueCallback) {
        if (this.c.j()) {
            return;
        }
        try {
            this.c.a(str, valueCallback);
        } catch (Exception unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.jm
    public void e(boolean z) {
        this.a.b(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void b(boolean z) {
        this.c.b(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public View a() {
        return this.c;
    }

    @Override // com.qq.e.comm.plugin.jm
    public void d(boolean z) {
        oh ohVar = this.c;
        if (ohVar == null) {
            return;
        }
        ohVar.d(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(e eVar) {
        this.c.a(eVar);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(m mVar) {
        this.c.a(mVar);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(f fVar) {
        this.c.a(fVar);
    }

    public void a(h4 h4Var) {
        this.a.a(h4Var);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(int i) {
        this.a.a(i);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(Context context) {
        this.d = context;
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(boolean z) {
        this.c.setHorizontalScrollBarEnabled(z);
        this.c.setVerticalScrollBarEnabled(z);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(bm bmVar) {
        this.a.a(bmVar);
        this.b.a(bmVar);
        this.c.a(bmVar);
    }

    @Override // com.qq.e.comm.plugin.jm
    public void a(sh shVar) {
        this.h = shVar;
        this.a.a(shVar);
        this.b.a(shVar);
    }
}
