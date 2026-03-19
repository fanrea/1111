package com.android.gdt.qone.u;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.gdt.qone.ao.j;
import com.android.gdt.qone.sdk.S.DataFormatter;
import com.sigmob.sdk.base.n;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c extends AsyncTask {
    public final j a;
    public final String b;
    public final Bundle c;

    public c(j jVar, String str, Bundle bundle) {
        this.a = jVar;
        this.b = str;
        this.c = bundle;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        j jVar = this.a;
        String str = this.b;
        synchronized (jVar) {
            String string = bundle.getString("appKey");
            String string2 = bundle.getString(n.l);
            String string3 = bundle.getString("spread_data");
            String str2 = j.f;
            DataFormatter dataFormatterA = com.android.gdt.qone.ao.c.a(string3, str2);
            boolean zA = jVar.a(dataFormatterA.a(), string, string2);
            boolean z = jVar.e.a().size() > dataFormatterA.a().size();
            com.android.gdt.qone.af.c.b("SpreadQM", "%s%s received broadcast from %s%s|data = %s|,needReply:%b ", jVar.a, jVar.b, string, string2, dataFormatterA, Boolean.valueOf(zA || z));
            if (TextUtils.isEmpty(str) && (zA || z)) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("spread_data", com.android.gdt.qone.ao.c.a(jVar.e, str2));
                bundle2.putString("appKey", jVar.a);
                bundle2.putString(n.l, jVar.b);
                a.a("com.qone.qm.spread", string2, bundle2);
                com.android.gdt.qone.af.c.b("SpreadQM", "%s%s reply broadcast to %s", jVar.a, jVar.b, string2);
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
    }
}
