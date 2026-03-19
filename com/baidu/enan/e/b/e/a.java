package com.baidu.enan.e.b.e;

import android.util.Pair;
import com.baidu.enan.f.b;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static Pair<String, String> a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(b.a("L3Byb2MvY3B1aW5mbw==")));
            String strTrim = "";
            String strTrim2 = strTrim;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.startsWith("Hardware")) {
                        String[] strArrSplit = line.split(":", 2);
                        if (strArrSplit.length == 2) {
                            strTrim = strArrSplit[1].trim();
                        }
                    }
                    if (line.startsWith("Processor")) {
                        String[] strArrSplit2 = line.split(":", 2);
                        if (strArrSplit2.length == 2) {
                            strTrim2 = strArrSplit2[1].trim();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.baidu.enan.f.a.a(th);
                        return new Pair<>("", "");
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th2) {
                                com.baidu.enan.f.a.a(th2);
                            }
                        }
                    }
                }
            }
            Pair<String, String> pair = new Pair<>(strTrim, strTrim2);
            try {
                bufferedReader.close();
            } catch (Throwable th3) {
                com.baidu.enan.f.a.a(th3);
            }
            return pair;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }
}
