package com.baidu.enan.e.c.e;

import com.baidu.enan.f.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a() {
        try {
            return b();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static String b() {
        BufferedReader bufferedReader;
        try {
            String strA = b.a("L3Byb2MvbmV0L3VuaXg=");
            File file = new File(strA);
            if (!file.exists()) {
                com.baidu.enan.f.a.a(strA + " does not exist");
            }
            if (!file.canRead()) {
                com.baidu.enan.f.a.a("No permission to read " + strA);
                return "";
            }
            StringBuilder sb = new StringBuilder();
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line).append("\n");
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.baidu.enan.f.a.a(th);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    com.baidu.enan.f.a.a(th2);
                                }
                            }
                            return "";
                        } finally {
                        }
                    }
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Throwable th3) {
                    com.baidu.enan.f.a.a(th3);
                }
                return string;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            com.baidu.enan.f.a.a(th5);
        }
    }
}
