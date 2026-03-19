package com.alliance.ssp.ad.q;

import com.alliance.ssp.ad.d0.e;
import com.alliance.ssp.ad.http.HttpException;

/* compiled from: BaseAction.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class b<T> {
    public com.alliance.ssp.ad.p.a<T> a;

    public b(com.alliance.ssp.ad.p.a<T> aVar) {
        this.a = aVar;
    }

    public abstract T a(String str);

    public final void a() {
        e.a.submit(new a(this).a);
    }

    public abstract void a(HttpException httpException);

    public abstract void a(T t);
}
