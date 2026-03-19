package com.component.a.e.e;

import com.baidu.mobads.annotation.remote.template.SmartOptJson;
import com.component.a.g.g;
import com.component.a.i.n;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements g.a {
    private int a;

    public void a(int i) {
        this.a = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @Override // com.component.a.g.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L3f
            java.lang.String r2 = "opt_style"
            boolean r2 = r6.contains(r2)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L3f
            java.lang.String r2 = "_(\\d+)_?(\\d+)?$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch: java.lang.Throwable -> L41
            java.util.regex.Matcher r6 = r2.matcher(r6)     // Catch: java.lang.Throwable -> L41
            boolean r2 = r6.find()     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L3f
            java.lang.String r2 = r6.group(r0)     // Catch: java.lang.Throwable -> L41
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L41
            r3 = 2
            java.lang.String r4 = r6.group(r3)     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L3a
            java.lang.String r6 = r6.group(r3)     // Catch: java.lang.Throwable -> L3d
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.Throwable -> L3d
            r1 = r6
        L3a:
            r6 = r1
            r1 = r2
            goto L40
        L3d:
            r6 = move-exception
            goto L43
        L3f:
            r6 = 0
        L40:
            goto L50
        L41:
            r6 = move-exception
            r2 = 0
        L43:
            com.baidu.mobads.container.util.bq r3 = com.baidu.mobads.container.util.bq.a()
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r6
            r3.d(r0)
            r1 = r2
            r6 = 0
        L50:
            java.lang.String r6 = r5.a(r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.e.e.b.a(java.lang.String):java.lang.String");
    }

    @Override // com.component.a.g.g.a
    public JSONObject a() {
        return n.b(b(this.a));
    }

    public String b(int i) {
        return a(i, 0);
    }

    public String a(int i, int i2) {
        SmartOptJson smartOptJson = new SmartOptJson();
        switch (i) {
            case 28:
                if (i2 == 1) {
                    return smartOptJson.getOptStyle28v1();
                }
                if (i2 == 2) {
                    return smartOptJson.getOptStyle28v2();
                }
                if (i2 == 3) {
                    return smartOptJson.getOptStyle28v3();
                }
                return smartOptJson.getOptStyle28();
            case 29:
                if (i2 == 1) {
                    return smartOptJson.getOptStyle29v1();
                }
                return smartOptJson.getOptStyle29();
            case 30:
                return smartOptJson.getOptStyle30();
            case 31:
            case 32:
            case 38:
            case 39:
            case 40:
            default:
                return "";
            case 33:
                if (i2 == 1) {
                    return smartOptJson.getOptStyle33v1();
                }
                if (i2 == 2) {
                    return smartOptJson.getOptStyle33v2();
                }
                if (i2 == 3) {
                    return smartOptJson.getOptStyle33v3();
                }
                if (i2 == 4) {
                    return smartOptJson.getOptStyle33v4();
                }
                return smartOptJson.getOptStyle33();
            case 34:
                return smartOptJson.getOptStyle34();
            case 35:
                return smartOptJson.getOptStyle35();
            case 36:
                return smartOptJson.getOptStyle36();
            case 37:
                return smartOptJson.getOptStyle37();
            case 41:
            case 42:
                if (i2 == 1) {
                    return smartOptJson.getOptStyle41v1();
                }
                if (i2 == 2) {
                    return smartOptJson.getOptStyle41v2();
                }
                return smartOptJson.getOptStyle41();
        }
    }
}
