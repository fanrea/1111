package com.component.lottie;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class x implements Callable<bb<t>> {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ String b;

    x(JSONObject jSONObject, String str) {
        this.a = jSONObject;
        this.b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public bb<t> call() {
        return u.b(this.a, this.b);
    }
}
