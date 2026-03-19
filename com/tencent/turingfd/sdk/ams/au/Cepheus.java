package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.baidu.mobstat.forbes.Config;
import com.tencent.turingfd.sdk.ams.au.Cstrictfp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cepheus {
    public static String a(Context context) {
        BufferedReader bufferedReader;
        int i;
        System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        try {
            String packageName = context.getPackageName();
            Pattern patternCompile = Pattern.compile("^/data/user/\\d+/" + packageName);
            String str = context.getApplicationInfo().nativeLibraryDir;
            bufferedReader = new BufferedReader(new FileReader(Cfinally.a(Cfinally.n)));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String strA = a(line, packageName, patternCompile, str);
                    if (strA != null) {
                        hashSet.add(strA);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        Auriga.a(bufferedReader);
        Pattern[] patternArrA = Avocado.a();
        Iterator it = hashSet.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length = patternArrA.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (patternArrA[i].matcher(str2).find()) {
                    it.remove();
                    break;
                }
                i++;
            }
        }
        if (hashSet.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            i++;
            sb.append((String) it2.next());
            if (i >= 8) {
                break;
            }
            if (it2.hasNext()) {
                sb.append(Config.replace);
            }
        }
        return sb.toString();
    }

    public static String a() {
        try {
            File file = new File("/system/lib");
            if (file.canRead()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getName().contains("rockchip")) {
                        return file2.getAbsolutePath();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String a(String str, String str2, Pattern pattern, String str3) throws IOException {
        int iIndexOf;
        String canonicalPath;
        boolean zEndsWith = str.endsWith(".so");
        boolean z = !zEndsWith && str.endsWith(".jar");
        if ((!zEndsWith && !z) || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        String strTrim = str.substring(iIndexOf).trim();
        if (!strTrim.startsWith("/data/")) {
            return null;
        }
        if (zEndsWith && str3 != null && strTrim.startsWith(str3)) {
            return null;
        }
        String str4 = "/data/data/" + str2 + "/";
        if (strTrim.startsWith(str4)) {
            return null;
        }
        if (strTrim.startsWith("/data/app/" + str2) || pattern.matcher(strTrim).find()) {
            return null;
        }
        if (zEndsWith) {
            File file = new File(str4 + "lib");
            HashMap<String, Cstrictfp.Cdo> map = Cstrictfp.a;
            try {
                canonicalPath = file.getCanonicalPath();
            } catch (IOException unused) {
                canonicalPath = null;
            }
            if (canonicalPath == null || strTrim.startsWith(canonicalPath)) {
                return null;
            }
        }
        return strTrim;
    }
}
