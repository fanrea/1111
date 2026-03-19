package com.baidu.enan.e.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {

    public static class a {
        public int a;
        public String b;
        public String c;

        public a(int i, String str, String str2) {
            this.a = i;
            this.b = str;
            this.c = str2;
        }

        public String toString() {
            return "CommandResult{result=" + this.a + ", successMsg='" + this.b + "', errorMsg='" + this.c + "'}";
        }
    }

    public static a a(String str, boolean z) {
        return a(new String[]{str}, z, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0101, code lost:
    
        if (r10 == null) goto L107;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0158 A[Catch: IOException -> 0x014f, TRY_LEAVE, TryCatch #4 {IOException -> 0x014f, blocks: (B:95:0x014b, B:99:0x0153, B:101:0x0158), top: B:127:0x014b }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0164 A[PHI: r0 r1 r3 r5 r9 r10 r11
  0x0164: PHI (r0v5 'e' ??) = (r0v2 'e' ??), (r0v3 'e' ??), (r0v10 'e' ??) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0164: PHI (r1v9 int) = (r1v4 int), (r1v6 int), (r1v14 int) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0164: PHI (r3v6 java.io.BufferedReader) = (r3v3 java.io.BufferedReader), (r3v4 java.io.BufferedReader), (r3v11 java.io.BufferedReader) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0164: PHI (r5v6 java.io.BufferedReader) = (r5v3 java.io.BufferedReader), (r5v4 java.io.BufferedReader), (r5v12 java.io.BufferedReader) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0164: PHI (r9v15 java.lang.String) = (r9v8 java.lang.String), (r9v11 java.lang.String), (r9v22 java.lang.String) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0164: PHI (r10v10 java.lang.Process) = (r10v6 java.lang.Process), (r10v7 java.lang.Process), (r10v13 java.lang.Process) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]
  0x0164: PHI (r11v10 java.lang.String) = (r11v5 java.lang.String), (r11v7 java.lang.String), (r11v14 java.lang.String) binds: [B:88:0x013c, B:105:0x0162, B:63:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0186 A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x014b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012d A[Catch: IOException -> 0x0129, TryCatch #8 {IOException -> 0x0129, blocks: (B:78:0x0125, B:82:0x012d, B:84:0x0132), top: B:132:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0132 A[Catch: IOException -> 0x0129, TRY_LEAVE, TryCatch #8 {IOException -> 0x0129, blocks: (B:78:0x0125, B:82:0x012d, B:84:0x0132), top: B:132:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0153 A[Catch: IOException -> 0x014f, TryCatch #4 {IOException -> 0x014f, blocks: (B:95:0x014b, B:99:0x0153, B:101:0x0158), top: B:127:0x014b }] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.enan.e.d.c.a a(java.lang.String[] r9, boolean r10, boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.e.d.c.a(java.lang.String[], boolean, boolean):com.baidu.enan.e.d.c$a");
    }
}
