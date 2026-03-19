package com.component.a.g.c;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.by;
import com.component.a.f.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class e {
    protected com.baidu.mobads.container.adrequest.j mAdInfo;
    protected Context mAppContext;
    protected a mFlyweight;

    public e(Context context, com.baidu.mobads.container.adrequest.j jVar, a aVar) {
        this.mAppContext = context.getApplicationContext();
        this.mAdInfo = jVar;
        this.mFlyweight = aVar;
    }

    public View onPrepareView(View view, com.component.a.f.e eVar) {
        return null;
    }

    public void onCreateView(com.component.a.f.d dVar) {
    }

    public static View findViewByName(Map<View, com.component.a.f.e> map, String str) {
        return com.component.a.i.n.a(map, str);
    }

    public static <T> T findViewByName(Map<View, com.component.a.f.e> map, String str, Class<T> cls) {
        T t = (T) findViewByName(map, str);
        if (cls != null && cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public Animator initViewAnimation(View view, com.component.a.f.e eVar) {
        return null;
    }

    public void buildJsonAnimator(View view, a.c cVar, com.component.a.f.e eVar, e.C0316e c0316e) {
    }

    public void onClickView(com.component.a.f.d dVar) {
    }

    public void onRootAttach(com.component.a.f.d dVar, ViewGroup viewGroup) {
    }

    public void onCustomEvent(com.component.a.f.d dVar) {
    }

    public void destroy() {
        if (this.mFlyweight != null) {
            this.mFlyweight.c();
        }
    }

    public static class a {
        public com.baidu.mobads.container.components.command.b a;
        private final com.component.a.g.a b;
        private final List<com.baidu.mobads.container.components.command.b> c = new ArrayList();
        private String d;

        public a(com.component.a.g.a aVar) {
            this.b = aVar;
        }

        public by.b a() {
            return this.b.c();
        }

        public int a(int i) {
            com.component.a.i.w wVarD = this.b.d();
            if (wVarD != null) {
                return wVarD.a();
            }
            return i;
        }

        public com.component.a.d.c b() {
            return this.b.e();
        }

        public void a(com.component.a.f.d dVar) {
            this.b.c(dVar);
        }

        public void b(com.component.a.f.d dVar) {
            this.b.d(dVar);
        }

        public void a(String str, com.baidu.mobads.container.components.command.b bVar) {
            this.c.add(bVar);
            a(str);
        }

        private void a(String str) {
            if (this.a == null) {
                this.a = new f(this);
                this.d = com.baidu.mobads.container.b.c.a().a(str, this.a);
            }
        }

        public void c() {
            this.c.clear();
            d();
        }

        private void d() {
            if (!TextUtils.isEmpty(this.d)) {
                com.baidu.mobads.container.b.c.a().a(this.d);
            }
        }
    }
}
