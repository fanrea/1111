package com.bytedance.sdk.component.tt.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends c {
    public File d;
    public File hc;

    public hc(mq mqVar) {
        super(mqVar);
    }

    public void d(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.d = new File(str, str2);
        this.hc = new File(str, str2 + ".temp");
    }

    public void d(final com.bytedance.sdk.component.tt.d.d dVar) {
        File file = this.d;
        if (file == null || this.hc == null) {
            if (dVar != null) {
                dVar.d(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.d.length() != 0 && dVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.tt.hc hcVar = new com.bytedance.sdk.component.tt.hc(true, 200, "Success", null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            hcVar.d(this.d);
            dVar.d(this, hcVar);
            return;
        }
        long length = this.hc.length();
        final long j = length >= 0 ? length : 0L;
        k.d dVar2 = new k.d();
        dVar2.d((Object) hc());
        hc("Range", "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.an)) {
            dVar.d(this, new IOException("Url is Empty"));
            return;
        }
        try {
            dVar2.d(this.an);
            d(dVar2);
            this.b.d(dVar2.d().hc()).d(new com.bytedance.sdk.component.hc.d.b() { // from class: com.bytedance.sdk.component.tt.hc.hc.1
                @Override // com.bytedance.sdk.component.hc.d.b
                public void onFailure(com.bytedance.sdk.component.hc.d.hc hcVar2, IOException iOException) {
                    com.bytedance.sdk.component.tt.d.d dVar3 = dVar;
                    if (dVar3 != null) {
                        dVar3.d(hc.this, iOException);
                    }
                    hc.this.u();
                }

                /* JADX WARN: Removed duplicated region for block: B:117:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:138:0x0193 A[EDGE_INSN: B:138:0x0193->B:69:0x0193 BREAK  A[LOOP:1: B:53:0x0159->B:66:0x018a], SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:56:0x0163  */
                /* JADX WARN: Removed duplicated region for block: B:71:0x0198 A[Catch: all -> 0x018e, TryCatch #10 {all -> 0x018e, blocks: (B:57:0x016b, B:59:0x0171, B:64:0x017e, B:71:0x0198, B:74:0x01a4, B:76:0x01ae, B:78:0x01ba, B:80:0x01c8, B:81:0x01d7, B:82:0x01e4, B:86:0x0201), top: B:134:0x016b }] */
                /* JADX WARN: Removed duplicated region for block: B:82:0x01e4 A[Catch: all -> 0x018e, TryCatch #10 {all -> 0x018e, blocks: (B:57:0x016b, B:59:0x0171, B:64:0x017e, B:71:0x0198, B:74:0x01a4, B:76:0x01ae, B:78:0x01ba, B:80:0x01c8, B:81:0x01d7, B:82:0x01e4, B:86:0x0201), top: B:134:0x016b }] */
                /* JADX WARN: Removed duplicated region for block: B:84:0x01fd  */
                /* JADX WARN: Removed duplicated region for block: B:85:0x0200  */
                @Override // com.bytedance.sdk.component.hc.d.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResponse(com.bytedance.sdk.component.hc.d.hc r20, com.bytedance.sdk.component.hc.d.cb r21) throws java.io.IOException {
                    /*
                        Method dump skipped, instructions count: 594
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tt.hc.hc.AnonymousClass1.onResponse(com.bytedance.sdk.component.hc.d.hc, com.bytedance.sdk.component.hc.d.cb):void");
                }
            });
        } catch (IllegalArgumentException unused) {
            dVar.d(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0223 A[EDGE_INSN: B:205:0x0223->B:88:0x0223 BREAK  A[LOOP:1: B:72:0x01e4->B:85:0x0219], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0228 A[Catch: all -> 0x0220, TryCatch #0 {all -> 0x0220, blocks: (B:76:0x01fa, B:78:0x0202, B:83:0x020d, B:90:0x0228, B:98:0x0240, B:100:0x0248, B:102:0x0252, B:104:0x025c, B:109:0x026a, B:114:0x0283, B:118:0x0298, B:95:0x0236), top: B:169:0x01fa }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0236 A[Catch: all -> 0x0220, TryCatch #0 {all -> 0x0220, blocks: (B:76:0x01fa, B:78:0x0202, B:83:0x020d, B:90:0x0228, B:98:0x0240, B:100:0x0248, B:102:0x0252, B:104:0x025c, B:109:0x026a, B:114:0x0283, B:118:0x0298, B:95:0x0236), top: B:169:0x01fa }] */
    @Override // com.bytedance.sdk.component.tt.hc.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.tt.hc d() {
        /*
            Method dump skipped, instructions count: 839
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tt.hc.hc.d():com.bytedance.sdk.component.tt.hc");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean an(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long h(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean gb(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            this.d.delete();
        } catch (Throwable unused) {
        }
        try {
            this.hc.delete();
        } catch (Throwable unused2) {
        }
    }
}
