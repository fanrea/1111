package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class e extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L8c
            if (r6 != 0) goto L6
            goto L8c
        L6:
            java.lang.String r0 = "openIdNotifyFlag"
            r1 = 0
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "shouldUpdateId, notifyFlag : "
            java.lang.String r2 = r3.concat(r2)
            com.alipay.sdk.m.i0.f.a(r2)
            r2 = 1
            if (r0 != r2) goto L31
            java.lang.String r0 = "openIdPackage"
            java.lang.String r0 = r6.getStringExtra(r0)
            java.lang.String r5 = r5.getPackageName()
            boolean r5 = android.text.TextUtils.equals(r0, r5)
            if (r5 == 0) goto L49
            goto L48
        L31:
            r3 = 2
            if (r0 != r3) goto L46
            java.lang.String r0 = "openIdPackageList"
            java.util.ArrayList r0 = r6.getStringArrayListExtra(r0)
            if (r0 == 0) goto L49
            java.lang.String r5 = r5.getPackageName()
            boolean r1 = r0.contains(r5)
            goto L49
        L46:
            if (r0 != 0) goto L49
        L48:
            r1 = r2
        L49:
            if (r1 != 0) goto L4c
            return
        L4c:
            java.lang.String r5 = "openIdType"
            java.lang.String r5 = r6.getStringExtra(r5)
            com.alipay.sdk.m.i0.f r6 = com.alipay.sdk.m.i0.f.a()
            java.lang.String r0 = "oaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L62
            com.alipay.sdk.m.i0.a r5 = r6.b
            goto L86
        L62:
            java.lang.String r0 = "vaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L6e
            com.alipay.sdk.m.i0.a r5 = r6.d
            goto L86
        L6e:
            java.lang.String r0 = "aaid"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L79
            com.alipay.sdk.m.i0.a r5 = r6.c
            goto L86
        L79:
            java.lang.String r0 = "udid"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L85
            com.alipay.sdk.m.i0.a r5 = r6.a
            goto L86
        L85:
            r5 = 0
        L86:
            if (r5 != 0) goto L89
            return
        L89:
            r5.b()
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.e.onReceive(android.content.Context, android.content.Intent):void");
    }
}
