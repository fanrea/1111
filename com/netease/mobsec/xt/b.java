package com.netease.mobsec.xt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    public static final String a = a(new char[]{'J', 'H'}, "ɭ̓ʹʠ͛ʐ");
    public static final String b = a(new char[]{244, '`', 155, 184}, "ˈʃʚʁ̶̫");
    public static final String c = a(new char[]{204, 127, 240, 'b'}, "̉ʓ͏ɥɶʗ");
    public static final String d = a(new char[]{30, 242, '3', 0}, "ʏ˿ɟˋʃɞ");

    public static String a(char[] cArr, String str) {
        int length = str.length();
        for (int i = 0; i < cArr.length; i++) {
            char c2 = cArr[i];
            if (c2 > 255) {
                cArr[i] = (char) ((c2 ^ (255 & str.charAt(i % length))) & 65535);
            } else {
                int i2 = ((((((((c2 << 7) | (c2 >> 1)) & 255) + i) & 255) ^ i) & 255) + 170) & 255;
                int i3 = (((((i2 << 7) & 255) ^ ((i2 >> 1) & 255)) & 255) - 86) & 255;
                cArr[i] = (char) ((((((i3 << 5) & 255) | ((i3 >> 3) & 255)) & 255) ^ str.charAt(i % length)) & 255 & 255);
            }
        }
        return new String(cArr);
    }

    public static boolean a() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String line;
        boolean z = true;
        try {
            bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(a(new char[]{'|', 137, 142, 238, 164, '\b', 237, 23, '7', 175, '\'', '`', 151, 'y', 140}, "ˬ͌˦̈ͦʏ"))));
        } catch (Exception unused) {
            bufferedReader2 = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        do {
            try {
                line = bufferedReader3.readLine();
            } catch (Exception unused2) {
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 == null) {
                    return false;
                }
                bufferedReader3 = bufferedReader2;
                z = false;
                bufferedReader3.close();
                return z;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader3;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            if (line == null) {
                z = false;
                break;
            }
            if (!line.contains(a(new char[]{143, 153, ']', 18, 18, Typography.copyright, 'w', 137, 'e', 251, 234, 129, 228, 225, 28, 133}, "ɣːͲʲ͆ʉ")) && !line.contains(a(new char[]{233, 132, 157, 'q', 'x', 164, 217, '|', 165, 'Q', 'R', 197, 'R', 186, 222, Typography.degree}, "̐ɨɴ̙̱̒"))) {
            }
        } while (!line.contains(a(new char[]{'O', '\n', 230, '9', 'q', 211, 127, 'u', Typography.registered, '6', 202, 'r', 30}, "ɥ̲̮˗͔ˢ")));
        try {
            bufferedReader3.close();
        } catch (Exception unused4) {
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0147, code lost:
    
        if (r1.contains(a(new char[]{'Y', '9', '\f'}, "˂ʁʶͣʎ̜")) == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.mobsec.xt.b.b():boolean");
    }
}
