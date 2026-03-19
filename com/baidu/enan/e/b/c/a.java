package com.baidu.enan.e.b.c;

import android.text.TextUtils;
import com.baidu.enan.f.b;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a() {
        String strB;
        try {
            strB = b();
            try {
                return TextUtils.isEmpty(strB) ? c() : strB;
            } catch (Throwable th) {
                th = th;
                com.baidu.enan.f.a.a(th);
                return strB;
            }
        } catch (Throwable th2) {
            th = th2;
            strB = "";
        }
    }

    private static String b() {
        try {
            DataInputStream dataInputStream = new DataInputStream(Runtime.getRuntime().exec(b.a("Y2F0IC9wcm9jL3ZlcnNpb24=")).getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    dataInputStream.close();
                    return stringBuffer.toString();
                }
                stringBuffer.append(line.replace("\r", "").replace("\n", "").replace("\r\n", ""));
            }
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    private static String c() {
        BufferedReader bufferedReader;
        try {
            String strA = b.a("L3Byb2MvdmVyc2lvbg==");
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
