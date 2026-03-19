package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.bdtracker.f5;
import com.bytedance.bdtracker.n5;
import com.bytedance.bdtracker.t4;
import com.bytedance.dr.OaidApi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b<SERVICE> implements OaidApi {
    public final String a;
    public final f5<Boolean> b = new a();

    public class a extends f5<Boolean> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.f5
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf(t4.a((Context) objArr[0], b.this.a));
        }
    }

    public b(String str) {
        this.a = str;
    }

    public abstract Intent a(Context context);

    public abstract n5.b<SERVICE, String> a();

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        String str = (String) new n5(context, a(context), a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OaidApi.a aVar = new OaidApi.a();
        aVar.a = str;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }
}
