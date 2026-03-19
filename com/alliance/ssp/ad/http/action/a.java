package com.alliance.ssp.ad.http.action;

import com.alliance.ssp.ad.http.HttpException;
import com.alliance.ssp.ad.http.action.BaseNetAction;

/* compiled from: MonitorAction.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends BaseNetAction<String> {
    public String f;

    public a(String str, com.alliance.ssp.ad.p.a<String> aVar, String str2, boolean z, BaseNetAction.Method method) {
        super(z, str2, aVar, method);
        this.f = str;
    }

    @Override // com.alliance.ssp.ad.q.b
    public Object a(String str) {
        return str;
    }

    @Override // com.alliance.ssp.ad.q.b
    public void a(Object obj) {
        String str = (String) obj;
        com.alliance.ssp.ad.p.a<T> aVar = this.a;
        if (aVar != 0) {
            aVar.a(str);
        }
    }

    @Override // com.alliance.ssp.ad.http.action.BaseNetAction
    public String b() {
        return this.f;
    }

    @Override // com.alliance.ssp.ad.q.b
    public void a(HttpException httpException) {
        com.alliance.ssp.ad.p.a<T> aVar = this.a;
        if (aVar != 0) {
            aVar.a(httpException.getErrorCode(), httpException.getMessage());
        }
    }
}
