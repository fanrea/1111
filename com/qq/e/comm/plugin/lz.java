package com.qq.e.comm.plugin;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lz {
    private static String d;
    private static Boolean e;
    private static boolean f;
    private static String h;
    public static final String a = m10.a("YXJtNjQtdjhh");
    private static final String b = m10.a("YXJtZWFiaS12N2E");
    public static final String c = m10.a("YXJtZWFiaQ");
    private static int g = 0;

    public static String b() throws Throwable {
        if (h == null) {
            int iA = a("/proc/" + Process.myTid() + "/exe");
            if (iA == 3) {
                h = c;
                g = 3;
            } else if (iA == 40) {
                h = c;
                g = 1;
            } else if (iA == 62) {
                h = a;
                g = 4;
            } else if (iA != 183) {
                h = "unknown";
                g = 999;
            } else {
                h = a;
                g = 2;
            }
        }
        return h;
    }

    public static boolean c() {
        Boolean bool = e;
        if (bool != null) {
            return bool.booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 23 && Process.is64Bit()) {
            f = true;
            e = Boolean.TRUE;
            return true;
        }
        if (i >= 23) {
            e = Boolean.FALSE;
            return false;
        }
        f = false;
        boolean zEquals = TextUtils.equals(b(), a);
        e = Boolean.valueOf(zEquals);
        return zEquals;
    }

    public static void d() {
        String strA = a();
        String strB = b();
        ja jaVar = new ja();
        jaVar.a("data", strA);
        jaVar.a("data2", strB);
        if (!f) {
            if (TextUtils.equals(strA, strB)) {
                return;
            }
            b10.a(9130033, null, Integer.valueOf(g), null, jaVar);
        } else {
            String str = a;
            if (!TextUtils.equals(strA, str)) {
                b10.a(9130032, null, 5, null, jaVar);
            }
            if (TextUtils.equals(strB, str)) {
                return;
            }
            b10.a(9130032, null, Integer.valueOf(g), null, jaVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private static int a(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile((String) str, com.kuaishou.weapon.p0.t.k);
                    try {
                        randomAccessFile.seek(18L);
                        int i = randomAccessFile.read();
                        randomAccessFile.close();
                        str = i;
                    } catch (Exception e2) {
                        e = e2;
                        randomAccessFile2 = randomAccessFile;
                        e.toString();
                        str = 0;
                        str = 0;
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        return str;
                    } catch (Throwable th) {
                        th = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (IOException unused2) {
        }
        return str;
    }

    private static String a() throws IOException {
        if (d == null) {
            try {
                String line = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (!TextUtils.isEmpty(line)) {
                    if (line.contains("x86")) {
                        d = "x86";
                    } else {
                        String str = a;
                        if (line.contains(str)) {
                            d = str;
                        } else {
                            String str2 = b;
                            if (line.contains(str2)) {
                                d = str2;
                            } else {
                                d = c;
                            }
                        }
                    }
                } else {
                    d = c;
                }
            } catch (Exception e2) {
                e2.toString();
                d = c;
            }
        }
        return d;
    }
}
