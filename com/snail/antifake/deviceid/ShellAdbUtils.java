package com.snail.antifake.deviceid;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ShellAdbUtils {
    public static final String COMMAND_EXIT = "exit\n";
    public static final String COMMAND_LINE_END = "\n";
    public static final String COMMAND_SH = "sh";
    public static final String COMMAND_SU = "su";

    private ShellAdbUtils() {
        throw new AssertionError();
    }

    public static boolean checkRootPermission() {
        return execCommand("echo root", true, false).result == 0;
    }

    public static CommandResult execCommand(String str, boolean z) {
        return execCommand(new String[]{str}, z, true);
    }

    public static CommandResult execCommand(List<String> list, boolean z) {
        return execCommand(list == null ? null : (String[]) list.toArray(new String[0]), z, true);
    }

    public static CommandResult execCommand(String[] strArr, boolean z) {
        return execCommand(strArr, z, true);
    }

    public static CommandResult execCommand(String str, boolean z, boolean z2) {
        return execCommand(new String[]{str}, z, z2);
    }

    public static CommandResult execCommand(List<String> list, boolean z, boolean z2) {
        return execCommand(list == null ? null : (String[]) list.toArray(new String[0]), z, z2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:149|13|(3:15|(2:17|174)(2:18|173)|19)|172|20|(18:22|164|23|160|24|168|25|(3:161|26|(1:28)(1:175))|(2:29|(1:31)(0))|60|(1:62)|(1:64)|(1:69)|121|(1:123)(1:124)|(1:127)|128|129)(1:59)|153|60|(0)|(0)|(0)|121|(0)(0)|(0)|128|129) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e5, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e6, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0150 A[Catch: IOException -> 0x014c, TryCatch #7 {IOException -> 0x014c, blocks: (B:109:0x0148, B:113:0x0150, B:115:0x0155), top: B:147:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0155 A[Catch: IOException -> 0x014c, TRY_LEAVE, TryCatch #7 {IOException -> 0x014c, blocks: (B:109:0x0148, B:113:0x0150, B:115:0x0155), top: B:147:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e A[PHI: r1 r2 r3 r4 r5 r9 r10
  0x015e: PHI (r1v8 java.lang.Object) = (r1v5 java.lang.Object), (r1v9 java.lang.Object) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r2v5 int) = (r2v3 int), (r2v6 int) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r3v13 java.io.DataOutputStream) = (r3v11 java.io.DataOutputStream), (r3v14 java.io.DataOutputStream) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r4v10 java.io.BufferedReader) = (r4v8 java.io.BufferedReader), (r4v11 java.io.BufferedReader) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r5v7 ??) = (r5v5 ??), (r5v8 ??) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r9v13 java.lang.StringBuilder) = (r9v11 java.lang.StringBuilder), (r9v14 java.lang.StringBuilder) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]
  0x015e: PHI (r10v11 java.lang.Process) = (r10v9 java.lang.Process), (r10v12 java.lang.Process) binds: [B:101:0x0138, B:118:0x015c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0188 A[Catch: IOException -> 0x0184, TryCatch #16 {IOException -> 0x0184, blocks: (B:133:0x0180, B:137:0x0188, B:139:0x018d), top: B:155:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018d A[Catch: IOException -> 0x0184, TRY_LEAVE, TryCatch #16 {IOException -> 0x0184, blocks: (B:133:0x0180, B:137:0x0188, B:139:0x018d), top: B:155:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dc A[Catch: IOException -> 0x00e5, TryCatch #13 {IOException -> 0x00e5, blocks: (B:60:0x00d7, B:62:0x00dc, B:64:0x00e1), top: B:153:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e1 A[Catch: IOException -> 0x00e5, TRY_LEAVE, TryCatch #13 {IOException -> 0x00e5, blocks: (B:60:0x00d7, B:62:0x00dc, B:64:0x00e1), top: B:153:0x00d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012c A[Catch: IOException -> 0x0128, TryCatch #12 {IOException -> 0x0128, blocks: (B:92:0x0124, B:96:0x012c, B:98:0x0131), top: B:151:0x0124 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0131 A[Catch: IOException -> 0x0128, TRY_LEAVE, TryCatch #12 {IOException -> 0x0128, blocks: (B:92:0x0124, B:96:0x012c, B:98:0x0131), top: B:151:0x0124 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.snail.antifake.deviceid.ShellAdbUtils.CommandResult execCommand(java.lang.String[] r8, boolean r9, boolean r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.snail.antifake.deviceid.ShellAdbUtils.execCommand(java.lang.String[], boolean, boolean):com.snail.antifake.deviceid.ShellAdbUtils$CommandResult");
    }

    public static class CommandResult {
        public String errorMsg;
        public int result;
        public String successMsg;

        public CommandResult(int i) {
            this.result = i;
        }

        public CommandResult(int i, String str, String str2) {
            this.result = i;
            this.successMsg = str;
            this.errorMsg = str2;
        }
    }
}
