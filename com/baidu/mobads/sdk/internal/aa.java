package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobstat.forbes.Config;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class aa {
    private static final String a = "LoadRemoteDex";
    private static aa i;
    private IXAdContainerFactory b;
    private bp c;
    private Runnable f;
    private Context g;
    private boolean k;
    private int d = 5000;
    private Handler e = new Handler(Looper.getMainLooper());
    private bu h = bu.a();
    private AtomicBoolean j = new AtomicBoolean(false);

    public interface a {
        public static final int a = 1;
        public static final int b = 2;

        void onFailure();

        void onSuccess();
    }

    public static aa a() {
        if (i == null) {
            synchronized (aa.class) {
                if (i == null) {
                    i = new aa();
                }
            }
        }
        return i;
    }

    private aa() {
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.h.c(a, "init Context is null,error");
            return;
        }
        this.g = context.getApplicationContext();
        s.a().a(aVar);
        if (this.b != null) {
            k();
        } else {
            if (this.j.get()) {
                return;
            }
            f();
        }
    }

    public Context b() {
        return this.g;
    }

    public IXAdContainerFactory c() {
        if (this.g == null) {
            return null;
        }
        if (this.b == null && !this.j.get()) {
            f();
        }
        return this.b;
    }

    private void f() {
        this.j.set(true);
        if (ao.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bp bpVar = new bp(Class.forName(z.aO, true, getClass().getClassLoader()), this.g);
                this.c = bpVar;
                this.b = bpVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f = new ab(this);
        j();
        if (h.a == null) {
            synchronized (ca.class) {
                if (h.a == null) {
                    h.a = new ca(this.g);
                }
            }
        }
        if (this.b != null) {
            k();
            return;
        }
        if (h.a != null) {
            this.h.a(a, "start load apk");
            try {
                h.a.a(new ac(this));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        this.h.a(a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
    }

    private void i() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.removeCallbacks(runnable);
        }
        this.f = null;
    }

    private void j() {
        Runnable runnable = this.f;
        if (runnable != null) {
            this.e.postDelayed(runnable, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.j.set(false);
        bn.a(this.g);
        i();
        s.a().a(1);
        co.a(this.g).b();
        co.a(this.g).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.h.a(a, "加载dex失败原因=" + str);
        this.j.set(false);
        i();
        s.a().a(2);
    }

    public String d() {
        return this.b != null ? Config.replace + this.b.getRemoteVersion() : "";
    }

    public boolean e() {
        return this.k;
    }
}
