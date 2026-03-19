package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class eu {
    private final File a;
    private final File b;

    public eu(File file, File file2) {
        this.a = file;
        this.b = file2;
    }

    private void b(int i) {
        b10.b(9120037, null, Integer.valueOf(i));
    }

    boolean a(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        if (file.equals(this.a) || gu.a(this.a, file)) {
            return file2.equals(this.b) || gu.a(this.b, file2);
        }
        return false;
    }

    boolean a(int i) {
        try {
            if (this.b.exists() && this.a.exists()) {
                String strA = a(this.b);
                if (TextUtils.isEmpty(strA)) {
                    b(1);
                    return false;
                }
                String[] strArrSplit = strA.split("#####");
                if (strArrSplit.length == 2) {
                    if (i != a(strArrSplit[0], 0)) {
                        return false;
                    }
                    if (y30.a().a(strArrSplit[1], this.a)) {
                        return true;
                    }
                    b(2);
                    return false;
                }
                b(3);
            }
            return false;
        } catch (Throwable unused) {
            b(4);
            return false;
        }
    }

    private int a(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v3 */
    private String a(File file) throws Throwable {
        if (file != 0) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            String string = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return string;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        file = 0;
                        if (file != 0) {
                            try {
                                file.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }
}
