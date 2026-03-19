package com.apm.insight.runtime.a;

import android.content.Context;
import com.apm.insight.CrashType;
import com.apm.insight.entity.Header;
import com.apm.insight.o.s;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class l extends c {
    l(Context context, b bVar, d dVar) {
        super(CrashType.JAVA, context, bVar, dVar);
    }

    @Override // com.apm.insight.runtime.a.c
    public com.apm.insight.entity.a a(int i, com.apm.insight.entity.a aVar) throws JSONException {
        com.apm.insight.entity.a aVarA = super.a(i, aVar);
        if (i == 0) {
            aVarA.a("app_count", (Object) 1);
            aVarA.a("magic_tag", "ss_app_log");
            g(aVarA);
            Header headerA = Header.a(this.b);
            headerA.c();
            aVarA.a(headerA);
            s.a(aVarA, headerA, this.a);
        } else if (i == 1) {
            Header headerI = aVarA.i();
            headerI.d();
            headerI.e();
        } else if (i == 2) {
            Header.a(aVarA.i());
        } else if (i == 5) {
            Header.b(aVarA.i());
        }
        return aVarA;
    }
}
