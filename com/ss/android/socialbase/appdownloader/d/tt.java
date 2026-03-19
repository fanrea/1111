package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class tt extends d {
    private String c;
    private String u;

    public tt(Context context, com.ss.android.socialbase.downloader.uo.d dVar, String str, String str2, String str3) {
        super(context, dVar, str);
        this.c = str2;
        this.u = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    @Override // com.ss.android.socialbase.appdownloader.d.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Intent hc() {
        /*
            r10 = this;
            com.ss.android.socialbase.downloader.uo.d r0 = r10.hc
            java.lang.String r1 = "s"
            java.lang.String r0 = r0.b(r1)
            com.ss.android.socialbase.downloader.uo.d r1 = r10.hc
            java.lang.String r2 = "ak"
            java.lang.String r1 = r1.b(r2)
            java.lang.String r1 = com.ss.android.socialbase.appdownloader.an.b.d(r1, r0)
            com.ss.android.socialbase.downloader.uo.d r2 = r10.hc
            java.lang.String r3 = "am"
            java.lang.String r2 = r2.b(r3)
            java.lang.String r2 = com.ss.android.socialbase.appdownloader.an.b.d(r2, r0)
            com.ss.android.socialbase.downloader.uo.d r3 = r10.hc
            java.lang.String r4 = "an"
            java.lang.String r3 = r3.b(r4)
            java.lang.String r3 = com.ss.android.socialbase.appdownloader.an.b.d(r3, r0)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto Ld2
            java.lang.String r4 = ","
            java.lang.String[] r6 = r3.split(r4)
            int r6 = r6.length
            r7 = 2
            if (r6 == r7) goto L3f
            goto Ld2
        L3f:
            java.lang.String[] r3 = r3.split(r4)
            com.ss.android.socialbase.downloader.uo.d r6 = r10.hc
            java.lang.String r8 = "al"
            java.lang.String r6 = r6.b(r8)
            java.lang.String r6 = com.ss.android.socialbase.appdownloader.an.b.d(r6, r0)
            com.ss.android.socialbase.downloader.uo.d r8 = r10.hc
            java.lang.String r9 = "ao"
            java.lang.String r8 = r8.b(r9)
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.an.b.d(r8, r0)
            boolean r8 = android.text.TextUtils.isEmpty(r0)
            if (r8 != 0) goto Ld2
            java.lang.String[] r8 = r0.split(r4)
            int r8 = r8.length
            if (r8 == r7) goto L69
            goto Ld2
        L69:
            java.lang.String[] r0 = r0.split(r4)
            com.ss.android.socialbase.downloader.uo.d r4 = r10.hc
            java.lang.String r7 = "download_dir"
            org.json.JSONObject r4 = r4.c(r7)
            r7 = 1
            r8 = 0
            if (r4 == 0) goto Lac
            java.lang.String r5 = "dir_name"
            java.lang.String r4 = r4.optString(r5)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L98
            java.lang.String r5 = "%s"
            boolean r5 = r4.contains(r5)
            if (r5 == 0) goto L98
            java.lang.Object[] r5 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L98
            java.lang.String r9 = r10.u     // Catch: java.lang.Throwable -> L98
            r5[r8] = r9     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L98
            goto L9a
        L98:
            java.lang.String r4 = r10.u
        L9a:
            r5 = r4
            int r4 = r5.length()
            r9 = 255(0xff, float:3.57E-43)
            if (r4 <= r9) goto Lac
            int r4 = r5.length()
            int r4 = r4 - r9
            java.lang.String r5 = r6.substring(r4)
        Lac:
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r1)
            r1 = r0[r8]
            r0 = r0[r7]
            r4.putExtra(r1, r0)
            java.lang.String r0 = r10.c
            r4.putExtra(r2, r0)
            r4.putExtra(r6, r5)
            r0 = r3[r8]
            r1 = r3[r7]
            int r1 = java.lang.Integer.parseInt(r1)
            r4.putExtra(r0, r1)
            r0 = 268468224(0x10008000, float:2.5342157E-29)
            r4.addFlags(r0)
            return r4
        Ld2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.d.tt.hc():android.content.Intent");
    }
}
