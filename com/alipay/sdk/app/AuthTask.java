package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class AuthTask {
    public static final Object c = h.class;
    public Activity a;
    public com.alipay.sdk.m.x.a b;

    public class a implements h.f {
        public a() {
        }

        @Override // com.alipay.sdk.m.u.h.f
        public void a() {
            AuthTask.this.a();
        }

        @Override // com.alipay.sdk.m.u.h.f
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.a = activity;
        b.d().a(this.a);
        this.b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.k);
    }

    private h.f b() {
        return new a();
    }

    private void c() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.s.a(this.a, str, com.alipay.sdk.m.k.b.n), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.m.s.a aVar;
        aVar = new com.alipay.sdk.m.s.a(this.a, str, "authV2");
        return l.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf A[Catch: all -> 0x014c, PHI: r9
  0x00cf: PHI (r9v12 java.lang.String) = (r9v2 java.lang.String), (r9v14 java.lang.String) binds: [B:16:0x00cd, B:9:0x0072] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:8:0x0020, B:18:0x00d8, B:17:0x00cf, B:21:0x00e4, B:23:0x0138, B:24:0x0141, B:25:0x014b, B:15:0x007b, B:7:0x001a, B:14:0x0078), top: B:32:0x0003, inners: #0 }] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.app.Activity, android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String innerAuth(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.alipay.sdk.m.x.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.app.Activity r4, java.lang.String r5, com.alipay.sdk.m.s.a r6) {
        /*
            r3 = this;
            r3.c()
            r0 = 0
            com.alipay.sdk.m.q.a r1 = new com.alipay.sdk.m.q.a     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            r1.<init>()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            com.alipay.sdk.m.p.b r4 = r1.a(r6, r4, r5)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            org.json.JSONObject r4 = r4.c()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            java.util.List r4 = com.alipay.sdk.m.r.b.a(r4)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            r3.a()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            r5 = 0
        L26:
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            if (r5 >= r1) goto L4b
            java.lang.Object r1 = r4.get(r5)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            com.alipay.sdk.m.r.b r1 = (com.alipay.sdk.m.r.b) r1     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            com.alipay.sdk.m.r.a r1 = r1.a()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            com.alipay.sdk.m.r.a r2 = com.alipay.sdk.m.r.a.WapPay     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            if (r1 != r2) goto L48
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            com.alipay.sdk.m.r.b r4 = (com.alipay.sdk.m.r.b) r4     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            java.lang.String r4 = r3.a(r6, r4)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L58
            r3.a()
            return r4
        L48:
            int r5 = r5 + 1
            goto L26
        L4b:
            r3.a()
            goto L6c
        L4f:
            r4 = move-exception
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            com.alipay.sdk.m.k.a.a(r6, r5, r1, r4)     // Catch: java.lang.Throwable -> L87
            goto L69
        L58:
            r4 = move-exception
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch: java.lang.Throwable -> L87
            int r5 = r5.b()     // Catch: java.lang.Throwable -> L87
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.b(r5)     // Catch: java.lang.Throwable -> L87
            java.lang.String r0 = "net"
            com.alipay.sdk.m.k.a.a(r6, r0, r4)     // Catch: java.lang.Throwable -> L87
            r0 = r5
        L69:
            r3.a()
        L6c:
            if (r0 != 0) goto L78
            com.alipay.sdk.m.j.c r4 = com.alipay.sdk.m.j.c.FAILED
            int r4 = r4.b()
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r4)
        L78:
            int r4 = r0.b()
            java.lang.String r5 = r0.a()
            java.lang.String r6 = ""
            java.lang.String r4 = com.alipay.sdk.m.j.b.a(r4, r5, r6)
            return r4
        L87:
            r4 = move-exception
            r3.a()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.b(android.app.Activity, java.lang.String, com.alipay.sdk.m.s.a):java.lang.String");
    }

    private String a(Activity activity, String str, com.alipay.sdk.m.s.a aVar) {
        String strA = aVar.a(str);
        List<a.b> listJ = com.alipay.sdk.m.m.a.z().j();
        if (!com.alipay.sdk.m.m.a.z().g || listJ == null) {
            listJ = com.alipay.sdk.m.j.a.d;
        }
        if (n.a(aVar, (Context) this.a, listJ, true)) {
            h hVar = new h(activity, aVar, b());
            String strA2 = hVar.a(strA, false);
            hVar.a();
            if (!TextUtils.equals(strA2, h.i) && !TextUtils.equals(strA2, h.j)) {
                return TextUtils.isEmpty(strA2) ? com.alipay.sdk.m.j.b.a() : strA2;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return b(activity, strA, aVar);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return b(activity, strA, aVar);
    }

    private String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] strArrC = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrC[0]);
        Intent intent = new Intent(this.a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0059a.a(aVar, intent);
        this.a.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String strD = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.j.b.a() : strD;
    }
}
