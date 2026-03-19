package com.apm.insight.log.a;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class b {
    private static final int a = 9;
    private static long b;
    private static long c;
    private static ArrayList<String> d;
    private static String e;

    static class a {
        public File a;
        public long b;

        public a(File file, long j) {
            this.a = file;
            this.b = j;
        }
    }

    static File[] a(String str, String str2, String str3, long j, long j2, int i) {
        b = j;
        c = j2;
        e = null;
        d = null;
        if (j > j2) {
            e = "time interval is invalid";
            return new File[0];
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            e = "log dir not exists";
            return new File[0];
        }
        String strReplace = !TextUtils.isEmpty(str2) ? str2.replace(':', SignatureImpl.SEP) : str2;
        Pattern patternCompile = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__" + (TextUtils.isEmpty(strReplace) ? "\\S+" : Pattern.quote(strReplace)) + "__" + (TextUtils.isEmpty(str3) ? "\\S+" : Pattern.quote(str3)) + "\\.vlog$");
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList arrayList2 = i > 0 ? new ArrayList() : null;
        File[] fileArrListFiles = file.listFiles(new c(arrayList, patternCompile, j2, j, arrayList2));
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            e = "log file not found";
            d = arrayList;
        }
        if (i <= 0) {
            return fileArrListFiles == null ? new File[0] : fileArrListFiles;
        }
        Collections.sort(arrayList2, new d());
        int iMin = Math.min(i, arrayList2.size());
        File[] fileArr = new File[iMin];
        for (int i2 = 0; i2 < iMin; i2++) {
            fileArr[i2] = ((a) arrayList2.get(i2)).a;
        }
        return fileArr;
    }

    static HashMap<String, String> a() {
        HashMap<String, String> map = new HashMap<>();
        map.put("start", Long.toString(b));
        map.put(PointCategory.END, Long.toString(c));
        map.put("reason", e);
        if (d != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = d.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.endsWith(".alog.hot")) {
                    next = next.substring(0, next.length() - a);
                }
                sb.append(next).append(i.b);
            }
            map.put(n.z, sb.toString());
        }
        e = null;
        d = null;
        return map;
    }
}
