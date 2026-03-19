package com.baidu.enan.e.a.f;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.enan.f.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return b(context) ? "1" : "0";
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static boolean b(Context context) {
        try {
            List<String> listC = c(context);
            if (listC != null && listC.size() != 0) {
                Iterator<String> it = listC.iterator();
                while (it.hasNext()) {
                    if (a(it.next())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    private static List<String> c(Context context) throws IOException {
        BufferedReader bufferedReader;
        String[] strArrSplit;
        ArrayList arrayList = new ArrayList();
        FileReader fileReader = null;
        try {
            try {
                File file = new File("/proc/" + Process.myPid() + "/maps");
                if (file.exists()) {
                    FileReader fileReader2 = new FileReader(file);
                    try {
                        bufferedReader = new BufferedReader(fileReader2);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (line.endsWith(".apk") && (strArrSplit = line.split(" ")) != null && strArrSplit.length > 0) {
                                    String str = strArrSplit[strArrSplit.length - 1];
                                    if (!TextUtils.isEmpty(str) && !str.contains(context.getPackageName()) && !str.startsWith("/system/") && !str.startsWith("/vendor/") && !arrayList.contains(str)) {
                                        arrayList.add(str);
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileReader = fileReader2;
                                try {
                                    b.a(th);
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException e) {
                                            b.a(e);
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    return arrayList;
                                } finally {
                                }
                            }
                        }
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } else {
                    bufferedReader = null;
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e2) {
                        b.a(e2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e3) {
            b.a(e3);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0050 -> B:40:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            boolean r5 = r2.exists()     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            if (r5 != 0) goto Le
            return r1
        Le:
            java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L42
        L18:
            java.util.zip.ZipEntry r0 = r5.getNextEntry()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L54
            if (r0 == 0) goto L3a
            boolean r2 = r0.isDirectory()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L54
            if (r2 != 0) goto L18
            java.lang.String r0 = r0.getName()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L54
            java.lang.String r2 = ".*(assets/xposed_init)$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L54
            java.util.regex.Matcher r0 = r2.matcher(r0)     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L54
            boolean r0 = r0.matches()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L54
            if (r0 == 0) goto L18
            r0 = 1
            r1 = 1
        L3a:
            r5.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L3e:
            r0 = move-exception
            goto L46
        L40:
            r5 = move-exception
            goto L58
        L42:
            r5 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
        L46:
            com.baidu.enan.f.b.a(r0)     // Catch: java.lang.Throwable -> L54
            if (r5 == 0) goto L53
            r5.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r5 = move-exception
            com.baidu.enan.f.b.a(r5)
        L53:
            return r1
        L54:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
        L58:
            if (r0 == 0) goto L62
            r0.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            com.baidu.enan.f.b.a(r0)
        L62:
            goto L64
        L63:
            throw r5
        L64:
            goto L63
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.enan.e.a.f.a.a(java.lang.String):boolean");
    }
}
