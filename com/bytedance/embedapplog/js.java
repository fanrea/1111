package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.ic;
import com.bytedance.embedapplog.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
abstract class js<SERVICE> implements ic {
    private final String d;
    private gv<Boolean> hc = new gv<Boolean>() { // from class: com.bytedance.embedapplog.js.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.gv
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean d(Object... objArr) {
            return Boolean.valueOf(oc.d((Context) objArr[0], js.this.d));
        }
    };

    protected abstract Intent b(Context context);

    protected abstract tc.hc<SERVICE, String> d();

    js(String str) {
        this.d = str;
    }

    @Override // com.bytedance.embedapplog.ic
    public boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return this.hc.hc(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        return d((String) new tc(context, b(context), d()).d());
    }

    private ic.d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ic.d dVar = new ic.d();
        dVar.hc = str;
        return dVar;
    }
}
