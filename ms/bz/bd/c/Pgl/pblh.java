package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.util.HashMap;
import java.util.regex.Pattern;
import okio.Utf8;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pblh {
    private static final String d = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "d5091b", new byte[]{69, 37, com.sigmob.sdk.archives.tar.e.P, 78, 11, 102, 116, 27, 115});
    private static final String hc = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7b0627", new byte[]{14, 97, 81, 70, 26, 33, 38, 70});
    private static final String b = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7a875a", new byte[]{0, 102, 74, 87, 31, 100, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.Q});
    private static final String c = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "4248f2", new byte[]{com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.f789K});
    private static final String u = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "b3baeb", new byte[]{123, 38});
    private static final String an = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "da47ac", new byte[]{115, 119});
    private static final String h = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "136059", new byte[]{45, com.sigmob.sdk.archives.tar.e.H, 93});
    private static final String gb = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "53231e", new byte[]{41, 56, 79});
    private static final String tt = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "9091ce", new byte[]{43, 61, com.sigmob.sdk.archives.tar.e.S, 64});
    private static final FileFilter tc = new pgla();

    final class pgla implements FileFilter {
        pgla() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60064c", new byte[]{36, 34, 86, 121, 91, 57, 108, 44}), file.getName());
        }
    }

    private static int b() {
        try {
            return new File((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "53512a", new byte[]{107, 34, 95, 86, 66, 114, com.sigmob.sdk.archives.tar.e.f789K, 4, 109, 98, 33, 34, 9, 86, 20, 101, 34, 23, 105, 46, 39, 33, com.sigmob.sdk.archives.tar.e.Q, 10})).listFiles(tc).length;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String d() {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap<String, String> mapHc = hc();
            jSONObject.put(tt, b());
            String str3 = null;
            try {
                str = mapHc.get(d);
            } catch (Throwable unused) {
                str = null;
            }
            jSONObject.put(c, str == null ? "" : str.trim());
            try {
                str2 = mapHc.get(hc);
            } catch (Throwable unused2) {
                str2 = null;
            }
            jSONObject.put(u, str2 == null ? "" : str2.trim());
            jSONObject.put(h, d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "932a51", new byte[]{com.sigmob.sdk.archives.tar.e.T, 34, com.sigmob.sdk.archives.tar.e.S, 6, 69, 34, Utf8.REPLACEMENT_BYTE, 4, 106, com.sigmob.sdk.archives.tar.e.J, 45, 34, 14, 6, 19, com.sigmob.sdk.archives.tar.e.M, 46, 23, 110, 126, 43, 33, 84, 90, 9, com.sigmob.sdk.archives.tar.e.N, 47, 66, 44, com.sigmob.sdk.archives.tar.e.J, 56, 36, 71, 7, 15, com.sigmob.sdk.archives.tar.e.O, 117, 17, 115, 36, 33, Utf8.REPLACEMENT_BYTE, 71, 26, com.sigmob.sdk.archives.tar.e.M, 43, 59, 10, 92, com.sigmob.sdk.archives.tar.e.O, 58, com.sigmob.sdk.archives.tar.e.L, 80})));
            jSONObject.put(gb, d((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "81a9e0", new byte[]{102, 32, 11, 94, 21, 35, 62, 6, 57, 106, 44, 32, 93, 94, 67, com.sigmob.sdk.archives.tar.e.L, 47, 21, 61, 38, 42, 35, 7, 2, 89, com.sigmob.sdk.archives.tar.e.O, 46, 64, 127, 106, 57, 38, 20, 95, 95, com.sigmob.sdk.archives.tar.e.N, 116, 19, 32, 124, 32, 61, 20, 66, 101, 42, com.sigmob.sdk.archives.tar.e.J, 30, 15, 111, 59, com.sigmob.sdk.archives.tar.e.N, 3})));
            try {
                str3 = mapHc.get(b);
            } catch (Throwable unused3) {
            }
            jSONObject.put(an, str3 == null ? "" : str3.trim());
        } catch (Throwable unused4) {
        }
        String string = jSONObject.toString();
        return TextUtils.isEmpty(string) ? (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "672691", new byte[]{60, 40}) : string.trim();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String d(java.lang.String r10) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L3a
            boolean r10 = r3.exists()     // Catch: java.lang.Throwable -> L3a
            if (r10 != 0) goto L23
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.String r8 = "7d202f"
            byte[] r9 = new byte[r1]     // Catch: java.lang.Throwable -> L3a
            r10 = 118(0x76, float:1.65E-43)
            r9[r0] = r10     // Catch: java.lang.Throwable -> L3a
            java.lang.Object r10 = com.volcengine.mobsecBiz.matrix.pgla.a(r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L3a
            return r10
        L23:
            java.io.FileReader r10 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            r10.<init>(r3)     // Catch: java.lang.Throwable -> L3a
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L3c
            r3.close()     // Catch: java.lang.Throwable -> L34
        L34:
            r10.close()     // Catch: java.lang.Throwable -> L44
            goto L44
        L38:
            r3 = r2
            goto L3c
        L3a:
            r10 = r2
            r3 = r10
        L3c:
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.lang.Throwable -> L41
        L41:
            if (r10 == 0) goto L44
            goto L34
        L44:
            if (r2 != 0) goto L5b
            byte[] r8 = new byte[r1]
            r10 = 112(0x70, float:1.57E-43)
            r8[r0] = r10
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            r5 = 0
            java.lang.String r7 = "17fbff"
            java.lang.Object r10 = com.volcengine.mobsecBiz.matrix.pgla.a(r3, r4, r5, r7, r8)
            java.lang.String r10 = (java.lang.String) r10
            return r10
        L5b:
            java.lang.String r10 = r2.trim()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblh.d(java.lang.String):java.lang.String");
    }

    private static HashMap<String, String> hc() {
        FileReader fileReader;
        HashMap<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "97b2d1", new byte[]{com.sigmob.sdk.archives.tar.e.T, 37, 3, 73, com.sigmob.sdk.archives.tar.e.S, 105, 57, 6, 38, 107, 38, com.sigmob.sdk.archives.tar.e.f789K, 30}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] strArrSplit = line.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "69fbe5", new byte[]{125}), 2);
                            if (strArrSplit.length >= 2) {
                                String strTrim = strArrSplit[0].trim();
                                String strTrim2 = strArrSplit[1].trim();
                                if (map.get(strTrim) == null) {
                                    map.put(strTrim, strTrim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return map;
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
        }
        return map;
    }
}
