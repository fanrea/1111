package com.tencent.turingfd.sdk.ams.au;

import android.os.Process;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobstat.forbes.Config;
import com.tencent.turingfd.sdk.ams.au.Vulpecula;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ComaBerenices {
    public static final Set<String> a;
    public static final String[] b;
    public static final Set<String> c;

    static {
        HashSet hashSet = new HashSet();
        a = hashSet;
        b = new String[0];
        hashSet.add(Cfinally.a(Cfinally.M));
        hashSet.add(Cfinally.a(Cfinally.N));
        hashSet.add(Cfinally.a(Cfinally.O));
        hashSet.add(Cfinally.a(Cfinally.P));
        hashSet.add(Cfinally.a(Cfinally.Q));
        hashSet.add(Cfinally.a(Cfinally.R));
        hashSet.add(Cfinally.a(Cfinally.S));
        hashSet.add(Cfinally.a(Cfinally.T));
        hashSet.add(Cfinally.a(Cfinally.U));
        hashSet.add(Cfinally.a(Cfinally.V));
        hashSet.add(Cfinally.a(Cfinally.W));
        hashSet.add(Cfinally.a(Cfinally.X));
        HashSet hashSet2 = new HashSet();
        c = hashSet2;
        hashSet2.add(Cfinally.a(Cfinally.L));
    }

    public static List<Cthrows> a() {
        Vulpecula.Cdo cdoB;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String[] list = new File("/proc").list();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        char cCharAt = str.charAt(0);
                        if (cCharAt <= '9' && cCharAt >= '0' && (cdoB = Vulpecula.b(Integer.parseInt(str))) != null) {
                            arrayList2.add(cdoB);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        int iMyPid = Process.myPid();
        Iterator it = arrayList2.iterator();
        int i = 0;
        while (it.hasNext()) {
            Vulpecula.Cdo cdo = (Vulpecula.Cdo) it.next();
            if (iMyPid == cdo.a) {
                i = cdo.e;
            }
        }
        if (i != 0 && iMyPid != i) {
            Iterator it2 = arrayList2.iterator();
            String str2 = "";
            while (it2.hasNext()) {
                Vulpecula.Cdo cdo2 = (Vulpecula.Cdo) it2.next();
                if (i == cdo2.a) {
                    str2 = cdo2.d;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                Cthrows cthrows = new Cthrows();
                cthrows.a = Ginkgo.a + Ginkgo.e;
                cthrows.b = str2;
                arrayList3.add(cthrows);
            }
        }
        arrayList.addAll(arrayList3);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Vulpecula.Cdo cdo3 = (Vulpecula.Cdo) it3.next();
            Iterator it4 = ((HashSet) a).iterator();
            while (it4.hasNext()) {
                if (cdo3.d.contains((String) it4.next())) {
                    sb.append(cdo3.d);
                    sb.append(Config.replace);
                }
            }
        }
        String string = sb.toString();
        if (!TextUtils.isEmpty(string)) {
            Cthrows cthrows2 = new Cthrows();
            cthrows2.a = Ginkgo.a + Ginkgo.c;
            cthrows2.b = string.substring(0, string.length() + (-1));
            arrayList4.add(cthrows2);
        }
        arrayList.addAll(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        HashSet hashSet = new HashSet();
        Iterator it5 = arrayList2.iterator();
        int i2 = 0;
        while (it5.hasNext()) {
            Vulpecula.Cdo cdo4 = (Vulpecula.Cdo) it5.next();
            if (cdo4.c == 0 && cdo4.d.startsWith("/") && !cdo4.d.startsWith("/system") && !cdo4.d.startsWith("/dev") && !cdo4.d.startsWith("/sbin") && !cdo4.d.startsWith("/init") && !cdo4.d.startsWith("/vendor") && !cdo4.d.startsWith("/bin") && !cdo4.d.startsWith("/usr") && !cdo4.d.contains("kinguser") && !cdo4.d.endsWith("so")) {
                Iterator it6 = ((HashSet) a).iterator();
                while (true) {
                    if (it6.hasNext()) {
                        if (cdo4.d.contains((String) it6.next())) {
                            break;
                        }
                    } else {
                        Iterator it7 = ((HashSet) c).iterator();
                        while (true) {
                            if (it7.hasNext()) {
                                if (cdo4.d.contains((String) it7.next())) {
                                    break;
                                }
                            } else {
                                hashSet.add(cdo4.d);
                                int i3 = i2 + 1;
                                if (i2 >= 8) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                    }
                }
            }
        }
        if (hashSet.size() > 0) {
            Iterator it8 = hashSet.iterator();
            while (it8.hasNext()) {
                sb2.append((String) it8.next());
                sb2.append("%3B");
            }
            String string2 = sb2.toString();
            Cthrows cthrows3 = new Cthrows();
            cthrows3.a = Ginkgo.a + Ginkgo.d;
            cthrows3.b = string2.substring(0, string2.length() + (-1));
            arrayList5.add(cthrows3);
        }
        arrayList.addAll(arrayList5);
        return arrayList;
    }

    public static String b() {
        StringBuffer stringBuffer = new StringBuffer();
        String strA = a(Cfinally.a(Cfinally.o0), Cfinally.a(Cfinally.C0), "v4");
        if (!TextUtils.isEmpty(strA)) {
            stringBuffer.append(strA);
        }
        String strA2 = a(Cfinally.a(Cfinally.p0), "(.{32}:.{3,4})\\s(.{32}:.{3,4})\\s(.{2})\\s.{8}:.{8}\\s.{2}:.{8}\\s.{8}\\s+(.{4,5})", "v6");
        if (!TextUtils.isEmpty(strA2)) {
            if (!TextUtils.isEmpty(strA)) {
                stringBuffer.append(Config.replace);
            }
            stringBuffer.append(strA2);
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3) {
        String[] strArrSplit;
        String[] strArrSplit2;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String str4 = new String(Cstrictfp.a(str));
            if (TextUtils.isEmpty(str4) || (strArrSplit = str4.split("\n")) == null || strArrSplit.length == 0) {
                strArrSplit = b;
            }
        } catch (Throwable unused) {
            strArrSplit = null;
        }
        if (strArrSplit == null) {
            stringBuffer.append(str3 + ";-1");
            return stringBuffer.toString();
        }
        stringBuffer.append(str3 + ";0");
        new HashMap();
        HashMap map = new HashMap();
        Pattern patternCompile = Pattern.compile(str2);
        for (String str5 : strArrSplit) {
            Matcher matcher = patternCompile.matcher(str5);
            if (matcher.find()) {
                String strTrim = matcher.group(4).trim();
                if ("0A".equals(matcher.group(3)) && (strArrSplit2 = matcher.group(1).split(":")) != null && strArrSplit2.length >= 2) {
                    map.put(strArrSplit2[1], strTrim);
                }
            }
        }
        if (!map.isEmpty()) {
            stringBuffer.append(i.b);
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String str6 = (String) it.next();
                stringBuffer.append((String) map.get(str6));
                stringBuffer.append(":");
                stringBuffer.append(str6);
                if (it.hasNext()) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }
}
