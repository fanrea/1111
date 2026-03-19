package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class v5 {
    private static Map<Integer, String> a;
    private static Integer b;
    public static Double c;
    private static volatile String[] e;
    private static int d = new Random(System.currentTimeMillis()).nextInt(100);
    private static final Map<String, List<iv>> f = new ConcurrentHashMap();

    public static boolean a(double d2) {
        return d2 == 0.0d;
    }

    public static boolean b(double d2) {
        return d2 > 0.0d && d2 < 1.0d;
    }

    public static boolean c(h4 h4Var) {
        int iA = a("vcrp");
        return (iA == 4 || iA == 5) && h4Var.W0() >= a(h4Var) && b(h4Var);
    }

    public static boolean d(h4 h4Var) {
        int iA = a("vcrp");
        return (iA == 3 || iA == 5 || iA == 6) && h4Var.W0() >= a(h4Var) && b(h4Var);
    }

    public static boolean e(h4 h4Var) {
        return a("vcrp") == 6 && h4Var.W0() >= a(h4Var) && b(h4Var);
    }

    public static String b(String str) {
        if (a == null) {
            HashMap map = new HashMap();
            a = map;
            map.put(1, "BASE");
            a.put(2, "AA");
            a.put(3, "AB");
            a.put(4, "AC");
            a.put(5, "AD");
            a.put(6, "AE");
            a.put(100, "AX");
            a.put(101, "AY");
            a.put(102, "AZ");
        }
        return a.get(Integer.valueOf(a(str)));
    }

    public static boolean b() throws NumberFormatException {
        int i;
        if (e == null) {
            a();
        }
        if (e != null && e.length > 0) {
            try {
                String[] strArr = e;
                Date date = new Date();
                int hours = date.getHours();
                int minutes = date.getMinutes();
                for (String str : strArr) {
                    int iIndexOf = str.indexOf("-");
                    int iIndexOf2 = str.indexOf(":");
                    if (iIndexOf > 0 && iIndexOf2 > 0) {
                        int i2 = Integer.parseInt(str.substring(0, iIndexOf));
                        int i3 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                        if (hours >= i2 && hours <= i3) {
                            String strSubstring = str.substring(iIndexOf2 + 1);
                            int iIndexOf3 = strSubstring.indexOf("-");
                            if (iIndexOf3 > 0) {
                                int i4 = Integer.parseInt(strSubstring.substring(0, iIndexOf3));
                                i = (((Integer.parseInt(strSubstring.substring(iIndexOf3 + 1)) - i4) * (((hours - i2) * 60) + minutes)) / (((i3 - i2) + 1) * 60)) + i4;
                            } else {
                                i = Integer.parseInt(strSubstring);
                            }
                            return i > d;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return false;
    }

    public static boolean b(h4 h4Var) {
        String strA = r1.d().f().a(h4Var, "vatime", "0:00-23:59");
        if (TextUtils.isEmpty(strA)) {
            return true;
        }
        Map<String, List<iv>> map = f;
        List<iv> listA = map.get(strA);
        if (listA == null) {
            listA = k20.a(strA);
            map.put(strA, listA);
        }
        if (listA.size() <= 0) {
            return true;
        }
        return k20.a(listA);
    }

    public static String a(String str, e2 e2Var) {
        StringBuilder sb = new StringBuilder(Config.replace);
        sb.append(e2Var.d());
        if (!TextUtils.isEmpty(str)) {
            sb.append(Config.replace);
            sb.append(str);
        }
        String strB = b("vcrn");
        if (!TextUtils.isEmpty(strB)) {
            sb.append("_EXP_");
            sb.append(strB);
        }
        return sb.toString();
    }

    private static int a(h4 h4Var) {
        return xc.a("sldd", h4Var.y0(), 0, h4Var.x0());
    }

    public static double a(double d2, int i) {
        if (i == 0) {
            return d2;
        }
        if (c == null) {
            double dA = r1.d().f().a("stdd", 20);
            Double.isNaN(dA);
            c = Double.valueOf(dA * 1.0d);
        }
        double dDoubleValue = c.doubleValue();
        double d3 = i;
        Double.isNaN(d3);
        return Math.min(d2, dDoubleValue / d3);
    }

    public static int a(String str) {
        Integer numValueOf = Integer.valueOf(r1.d().f().a(str, 0));
        b = numValueOf;
        if (numValueOf.intValue() < 10000) {
            return b.intValue();
        }
        Integer numValueOf2 = Integer.valueOf(b.c().a(String.valueOf(b), 0));
        b = numValueOf2;
        return numValueOf2.intValue();
    }

    private static synchronized void a() {
        if (e == null) {
            String strC = r1.d().f().c("addrupd");
            if (TextUtils.isEmpty(strC)) {
                e = new String[0];
                return;
            }
            try {
                e = strC.split(",");
            } catch (Exception unused) {
            }
        }
    }
}
