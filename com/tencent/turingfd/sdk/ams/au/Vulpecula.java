package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Vulpecula {

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Vulpecula$do, reason: invalid class name */
    public static class Cdo {
        public int a;
        public int b;
        public int c;
        public String d;
        public int e;

        public Cdo(int i, int i2, String str, int i3, String str2, int i4) {
            this.a = i;
            this.b = i2;
            this.d = str;
            this.c = i3;
            this.e = i4;
        }

        public String toString() {
            return "" + String.format("% 6d", Integer.valueOf(this.a)) + "    " + String.format("% 6d", Integer.valueOf(this.b)) + "    " + String.format("% 6d", Integer.valueOf(this.c)) + "    " + this.d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.turingfd.sdk.ams.au.Vulpecula.Cdo b(int r12) throws java.lang.NumberFormatException {
        /*
            r0 = 0
            r1 = -1
            java.lang.String r2 = a(r12)     // Catch: java.lang.Throwable -> L9c
            r3 = 1
            r4 = 0
            if (r12 == r1) goto L24
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L9a
            java.util.Locale r6 = java.util.Locale.SIMPLIFIED_CHINESE     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = "/proc/%d/status"
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9a
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L9a
            r8[r4] = r9     // Catch: java.lang.Throwable -> L9a
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch: java.lang.Throwable -> L9a
            byte[] r6 = com.tencent.turingfd.sdk.ams.au.Cstrictfp.a(r6)     // Catch: java.lang.Throwable -> L9a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9a
            goto L37
        L24:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L9a
            java.util.Locale r6 = java.util.Locale.SIMPLIFIED_CHINESE     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = "/proc/self/status"
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L9a
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)     // Catch: java.lang.Throwable -> L9a
            byte[] r6 = com.tencent.turingfd.sdk.ams.au.Cstrictfp.a(r6)     // Catch: java.lang.Throwable -> L9a
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L9a
        L37:
            java.util.HashMap r6 = new java.util.HashMap     // Catch: java.lang.Throwable -> L9a
            r6.<init>()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r7 = "\n"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L9a
            int r7 = r5.length     // Catch: java.lang.Throwable -> L9a
            r8 = 0
        L44:
            if (r8 >= r7) goto L65
            r9 = r5[r8]     // Catch: java.lang.Throwable -> L9a
            java.lang.String r10 = ":"
            java.lang.String[] r9 = r9.split(r10)     // Catch: java.lang.Throwable -> L9a
            int r10 = r9.length     // Catch: java.lang.Throwable -> L9a
            r11 = 2
            if (r10 >= r11) goto L53
            goto L62
        L53:
            r10 = r9[r4]     // Catch: java.lang.Throwable -> L9a
            java.lang.String r10 = r10.trim()     // Catch: java.lang.Throwable -> L9a
            r9 = r9[r3]     // Catch: java.lang.Throwable -> L9a
            java.lang.String r9 = r9.trim()     // Catch: java.lang.Throwable -> L9a
            r6.put(r10, r9)     // Catch: java.lang.Throwable -> L9a
        L62:
            int r8 = r8 + 1
            goto L44
        L65:
            java.lang.String r3 = "PPid"
            java.lang.Object r3 = r6.get(r3)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L9a
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r5 = "Uid"
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L98
            java.lang.String r7 = "\\s+"
            java.lang.String[] r5 = r5.split(r7)     // Catch: java.lang.Throwable -> L98
            r4 = r5[r4]     // Catch: java.lang.Throwable -> L98
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "TracerPid"
            java.lang.Object r5 = r6.get(r5)     // Catch: java.lang.Throwable -> L96
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L96
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> L96
            r8 = r2
            r7 = r3
            r9 = r4
            r11 = r5
            goto La4
        L96:
            goto La0
        L98:
            goto L9f
        L9a:
            goto L9e
        L9c:
            r2 = r0
        L9e:
            r3 = -1
        L9f:
            r4 = -1
        La0:
            r8 = r2
            r7 = r3
            r9 = r4
            r11 = -1
        La4:
            if (r8 == 0) goto Lb3
            if (r7 == r1) goto Lb3
            if (r9 != r1) goto Lab
            goto Lb3
        Lab:
            com.tencent.turingfd.sdk.ams.au.Vulpecula$do r0 = new com.tencent.turingfd.sdk.ams.au.Vulpecula$do
            r10 = 0
            r5 = r0
            r6 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Vulpecula.b(int):com.tencent.turingfd.sdk.ams.au.Vulpecula$do");
    }

    public static String a(int i) {
        byte[] bArrA;
        try {
            Locale locale = Locale.SIMPLIFIED_CHINESE;
            byte[] bArrA2 = Cstrictfp.a(String.format(locale, "/proc/%d/cmdline", Integer.valueOf(i)), 100);
            String str = bArrA2 != null ? new String(bArrA2, 0, a(bArrA2, 0, (char) 0)) : "";
            if (!TextUtils.isEmpty(str) || (bArrA = Cstrictfp.a(String.format(locale, "/proc/%d/status", Integer.valueOf(i)), 150)) == null) {
                return str;
            }
            int iA = a(bArrA, 7, '\n');
            return iA == 0 ? "" : new String(bArrA, 6, iA - 6);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int a(byte[] bArr, int i, char c) {
        int i2;
        int i3 = i - 1;
        while (true) {
            i2 = i3 + 1;
            if (i3 >= bArr.length) {
                return 0;
            }
            if (i2 == bArr.length || bArr[i2] == c) {
                break;
            }
            i3 = i2;
        }
        return i2;
    }
}
