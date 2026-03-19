package com.qq.e.comm.plugin;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.io.File;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class b9 {
    private final File a = gu.h();
    private JSONObject b;

    public b9() {
        a();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[PHI: r2
  0x005d: PHI (r2v1 int) = (r2v0 int), (r2v3 int) binds: [B:19:0x004a, B:26:0x005c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.qq.e.comm.plugin.yq a(int r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 4
            r1 = 0
            r2 = 2
            if (r6 != r0) goto L1a
            com.qq.e.comm.plugin.r1 r6 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.vx r6 = r6.f()
            java.lang.String r7 = "iafld"
            java.lang.String r0 = ""
            java.lang.String r6 = r6.b(r7, r0)
            java.lang.String r6 = com.qq.e.comm.plugin.n8.a(r6)
            goto L65
        L1a:
            org.json.JSONObject r0 = r5.b
            r3 = 5
            if (r0 == 0) goto L45
            if (r6 != r2) goto L28
            java.lang.String r0 = "md"
            java.io.File r0 = r5.a(r0)
            goto L32
        L28:
            if (r6 != r3) goto L31
            java.lang.String r0 = "wxcs"
            java.io.File r0 = r5.a(r0)
            goto L32
        L31:
            r0 = r1
        L32:
            if (r0 != 0) goto L35
            return r1
        L35:
            java.io.File r4 = new java.io.File
            r4.<init>(r0, r7)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L45
            java.lang.String r0 = com.qq.e.comm.plugin.gu.d(r4)
            goto L46
        L45:
            r0 = r1
        L46:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L5d
            r4 = 3
            if (r6 != r2) goto L55
            java.lang.String r6 = com.qq.e.comm.plugin.n8.b(r7)
        L53:
            r2 = 3
            goto L5e
        L55:
            if (r6 != r3) goto L5c
            java.lang.String r6 = com.qq.e.comm.plugin.n8.c()
            goto L53
        L5c:
            r2 = 3
        L5d:
            r6 = r0
        L5e:
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 == 0) goto L65
            return r1
        L65:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> L70
            r7.<init>(r6)     // Catch: org.json.JSONException -> L70
            com.qq.e.comm.plugin.yq r6 = new com.qq.e.comm.plugin.yq     // Catch: org.json.JSONException -> L70
            r6.<init>(r7, r2)     // Catch: org.json.JSONException -> L70
            return r6
        L70:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.b9.a(int, java.lang.String):com.qq.e.comm.plugin.yq");
    }

    /* compiled from: A */
    class a extends l0 {
        a(File file, String str, boolean z) {
            super(file, str, z);
        }

        @Override // com.qq.e.comm.plugin.l0
        void a(JSONObject jSONObject, boolean z) {
            b9.this.b = jSONObject;
            b9.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        JSONObject jSONObject = this.b;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        a(this.b.optString(LiveConfigKey.MEDIUM), a(LiveConfigKey.MEDIUM));
        a(this.b.optString("wxcs"), a("wxcs"));
    }

    /* compiled from: A */
    class b extends l0 {
        final /* synthetic */ File f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(File file, String str, boolean z, File file2) {
            super(file, str, z);
            this.f = file2;
        }

        @Override // com.qq.e.comm.plugin.l0
        public void a(JSONObject jSONObject, boolean z) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    gu.b(new File(this.f, next), jSONObject.optString(next));
                } catch (Exception unused) {
                }
            }
        }
    }

    private void a() {
        new a(this.a, r1.d().f().b("tplou", ""), true).b();
    }

    private void a(String str, File file) {
        new b(file, str, false, file).b();
    }

    private File a(String str) {
        return new File(this.a, str + "_fb");
    }
}
