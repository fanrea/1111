package com.baidu.mobads.container.components.a;

import android.app.Activity;
import com.baidu.mobads.container.util.ay;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j extends com.baidu.mobads.container.d.a<Void> implements com.baidu.mobads.container.components.b.e {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private final List<i> d;
    private volatile int e;
    private long f;
    private boolean g;
    private final long h;
    private long i;
    private boolean j;

    public j() {
        super("BdAdForegroundTimer");
        this.d = new ArrayList();
        this.e = 0;
        this.f = 1000L;
        this.g = false;
        this.h = 5000L;
        this.i = 5000L;
        this.j = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.container.d.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void a() {
        if (this.d.isEmpty()) {
            c();
            return null;
        }
        if (c(this.f)) {
            return null;
        }
        Iterator<i> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().a(this.f, this.j)) {
                it.remove();
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void a(Activity activity) {
        this.j = true;
        this.i = 0L;
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void b(Activity activity) {
        this.j = false;
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void c(Activity activity) {
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void d(Activity activity) {
        if (this.g && g(activity)) {
            f();
        }
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void e(Activity activity) {
        if (this.g && g(activity)) {
            e();
        }
    }

    @Override // com.baidu.mobads.container.components.b.e
    public void f(Activity activity) {
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(i iVar) {
        this.d.add(iVar);
        d();
    }

    public void b(i iVar) {
        this.d.remove(iVar);
    }

    private void d() {
        if (this.e == 0 || this.e == 2) {
            com.baidu.mobads.container.d.b.a().a(this, 0L, this.f, TimeUnit.MILLISECONDS);
            this.e = 1;
        }
    }

    private void e() {
        if (this.e == 2) {
            com.baidu.mobads.container.d.b.a().a(this, 0L, this.f, TimeUnit.MILLISECONDS);
            this.e = 1;
        }
    }

    private void f() {
        if (this.e == 1) {
            a_();
        }
        this.e = 2;
    }

    public void c() {
        if (this.e == 1) {
            a_();
            this.e = 0;
        }
    }

    private boolean c(long j) {
        if (this.i < 5000) {
            this.i += j;
        }
        return this.i < 5000;
    }

    private boolean g(Activity activity) {
        if (activity != null) {
            String name = activity.getClass().getName();
            return ay.a.equals(name) || ay.b.equals(name) || ay.c.equals(name);
        }
        return false;
    }
}
