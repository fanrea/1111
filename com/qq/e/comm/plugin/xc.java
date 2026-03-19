package com.qq.e.comm.plugin;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class xc {
    private static final String a = String.valueOf(Integer.MIN_VALUE);
    private static final boolean b;

    /* compiled from: A */
    public interface b<T> {
        void a(boolean z, T t, boolean z2, T t2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences c() {
        return r1.d().a().getSharedPreferences("com_qq_e_sp_exp_cache", 0);
    }

    public static c d() {
        return new c();
    }

    public static boolean e() {
        return b;
    }

    static {
        b = r1.d().f().a("evgfre", 0) == 1;
    }

    public static <T> T a(ku kuVar, T t, T t2, b<T> bVar) {
        T t3;
        boolean zEquals;
        if (t == null) {
            return t2;
        }
        String strValueOf = String.valueOf(t);
        if (t instanceof Integer) {
            int iA = com.qq.e.comm.plugin.b.c().a(kuVar, strValueOf, Integer.MIN_VALUE);
            zEquals = iA != Integer.MIN_VALUE;
            t3 = (T) Integer.valueOf(iA);
        } else {
            com.qq.e.comm.plugin.b bVarC = com.qq.e.comm.plugin.b.c();
            String str = a;
            t3 = (T) bVarC.a(kuVar, strValueOf, str);
            zEquals = true ^ str.equals(t3);
        }
        a(bVar, t, zEquals, t3);
        if (!zEquals) {
            return t2;
        }
        vc.a(strValueOf, String.valueOf(t3));
        return t3;
    }

    public static int a(String str, int i, h4 h4Var) {
        return a(str, i, h4Var, (b<Integer>) null);
    }

    public static int a(String str, int i, tc tcVar) {
        return a(str, i, tcVar, (b<Integer>) null);
    }

    public static String a(String str, String str2, h4 h4Var) {
        return a(str, str2, h4Var, (b<String>) null);
    }

    /* compiled from: A */
    public static class c {
        private SharedPreferences.Editor a;

        private c() {
        }

        public void a() {
            SharedPreferences.Editor editor = this.a;
            if (editor != null) {
                editor.apply();
            }
        }

        private void b() {
            if (this.a == null) {
                this.a = xc.c().edit();
            }
        }

        public c a(h4 h4Var, String str, int i) {
            return a(h4Var, str, i, (b<Integer>) null);
        }

        public c a(h4 h4Var, String str, int i, b<Integer> bVar) {
            return a(h4Var, (String) null, str, i, bVar);
        }

        public c a(h4 h4Var, String str, String str2, int i) {
            return a(h4Var, str, str2, i, (b<Integer>) null);
        }

        public c a(h4 h4Var, String str, String str2, int i, b<Integer> bVar) {
            String strY0 = h4Var.y0();
            int iA = r1.d().f().a(str2, strY0, i);
            if (iA < 10000) {
                if (bVar != null) {
                    bVar.a(false, Integer.valueOf(iA), false, null);
                }
                return this;
            }
            int iA2 = com.qq.e.comm.plugin.b.c().a(h4Var.x0(), String.valueOf(iA), Integer.MIN_VALUE);
            boolean z = iA2 != Integer.MIN_VALUE;
            if (z) {
                b();
                this.a.putInt(xc.b(str2, strY0, str), iA2);
            } else if (Integer.MIN_VALUE != xc.a(str2, str, strY0, Integer.MIN_VALUE, (b<Integer>) null)) {
                b();
                this.a.remove(xc.b(str2, strY0, str));
            }
            if (bVar != null) {
                bVar.a(true, Integer.valueOf(iA), z, Integer.valueOf(iA2));
            }
            return this;
        }

        public c a(h4 h4Var, String str, String str2, String str3) {
            return a(h4Var, str, str2, str3, (b<String>) null);
        }

        public c a(h4 h4Var, String str, String str2, String str3, b<String> bVar) {
            String strY0 = h4Var.y0();
            String strA = r1.d().f().a(str2, strY0, str3);
            if (xc.a((Object) strA)) {
                if (bVar != null) {
                    bVar.a(false, strA, false, null);
                }
                return this;
            }
            String strA2 = com.qq.e.comm.plugin.b.c().a(h4Var.x0(), String.valueOf(strA), xc.a);
            boolean z = !xc.a.equals(strA2);
            if (z) {
                b();
                this.a.putString(xc.b(str2, strY0, str), strA2);
            } else if (!xc.a.equals(xc.a(str2, str, strY0, xc.a, (b<String>) null))) {
                b();
                this.a.remove(xc.b(str2, strY0, str));
            }
            if (bVar != null) {
                bVar.a(true, strA, z, strA2);
            }
            return this;
        }
    }

    public static String a(String str, String str2, tc tcVar) {
        return a(str, str2, tcVar, (b<String>) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, String str3) {
        if (str3 != null) {
            return String.format("%s_%s", str, str3);
        }
        return String.format("%s_%s", str, str2);
    }

    public static boolean a(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() < 10000;
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj) < 10000;
            } catch (NumberFormatException unused) {
            }
        }
        return true;
    }

    private static <T> void a(b<T> bVar, T t, boolean z, T t2) {
        if (bVar != null) {
            bVar.a(true, t, z, t2);
        }
    }

    private static <T> void a(b<T> bVar, T t) {
        if (bVar != null) {
            bVar.a(false, t, false, null);
        }
    }

    public static int a(String str, int i, h4 h4Var, b<Integer> bVar) {
        int iA = r1.d().f().a(h4Var, str, i);
        if (a(Integer.valueOf(iA))) {
            a(bVar, Integer.valueOf(iA));
            return iA;
        }
        return ((Integer) a(h4Var.x0(), Integer.valueOf(iA), Integer.valueOf(i), bVar)).intValue();
    }

    public static int a(String str, int i, tc tcVar, b<Integer> bVar) {
        int iA = r1.d().f().a(str, tcVar.a(), i);
        if (a(Integer.valueOf(iA))) {
            a(bVar, Integer.valueOf(iA));
            return iA;
        }
        return ((Integer) a(com.qq.e.comm.plugin.b.c().a(tcVar), Integer.valueOf(iA), Integer.valueOf(i), bVar)).intValue();
    }

    public static String a(String str, String str2, h4 h4Var, b<String> bVar) {
        String strA = r1.d().f().a(h4Var, str, str2);
        if (a((Object) strA)) {
            a(bVar, strA);
            return strA;
        }
        return (String) a(h4Var.x0(), strA, str2, bVar);
    }

    public static String a(String str, String str2, tc tcVar, b<String> bVar) {
        String strA = r1.d().f().a(str, tcVar.a(), str2);
        if (a((Object) strA)) {
            a(bVar, strA);
            return strA;
        }
        return (String) a(com.qq.e.comm.plugin.b.c().a(tcVar), strA, str2, bVar);
    }

    public static Object a(String str, tc tcVar, JSONObject jSONObject) {
        Object objA = r1.d().f().a(str, tcVar.a(), jSONObject, false, null);
        return a(objA) ? objA : a(com.qq.e.comm.plugin.b.c().a(tcVar), objA, (Object) null, (b<Object>) null);
    }

    @Deprecated
    public static int a(String str, String str2, int i) {
        if (e()) {
            return a(str, i, tc.a(str2));
        }
        return a(str, (String) null, str2, i, true, (ku) null, (b<Integer>) null);
    }

    @Deprecated
    public static int a(String str, String str2, int i, b<Integer> bVar) {
        if (e()) {
            return a(str, i, tc.a(str2), bVar);
        }
        return a(str, (String) null, str2, i, true, (ku) null, bVar);
    }

    private static e2 a(String str) {
        if ("APP".equals(str)) {
            return null;
        }
        try {
            return e2.a(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Deprecated
    public static int a(String str, String str2, String str3, int i) {
        if (e()) {
            return a(str, i, tc.a(str3, a(str2)));
        }
        return a(str, str2, str3, i, true, (ku) null, (b<Integer>) null);
    }

    @Deprecated
    public static int a(String str, String str2, String str3, int i, b<Integer> bVar) {
        if (e()) {
            return a(str, i, tc.a(str3, a(str2)), bVar);
        }
        return a(str, str2, str3, i, true, (ku) null, bVar);
    }

    @Deprecated
    public static int a(String str, String str2, int i, ku kuVar) {
        if (e()) {
            return a(str, i, tc.a(str2));
        }
        return a(str, (String) null, str2, i, false, kuVar, (b<Integer>) null);
    }

    @Deprecated
    public static int a(String str, String str2, int i, ku kuVar, b<Integer> bVar) {
        if (e()) {
            a(str, i, tc.a(str2), bVar);
        }
        return a(str, (String) null, str2, i, false, kuVar, bVar);
    }

    private static int a(String str, String str2, String str3, int i, boolean z, ku kuVar, b<Integer> bVar) {
        int iA;
        int iA2 = r1.d().f().a(str, str3, i);
        if (iA2 < 10000) {
            if (bVar != null) {
                bVar.a(false, Integer.valueOf(iA2), false, null);
            }
            return iA2;
        }
        if (z) {
            iA = c().getInt(b(str, str3, str2), Integer.MIN_VALUE);
        } else {
            iA = com.qq.e.comm.plugin.b.c().a(kuVar, String.valueOf(iA2), Integer.MIN_VALUE);
        }
        boolean z2 = iA != Integer.MIN_VALUE;
        if (bVar != null) {
            bVar.a(true, Integer.valueOf(iA2), z2, Integer.valueOf(iA));
        }
        if (!z2) {
            return i;
        }
        vc.a(String.valueOf(iA2), String.valueOf(iA));
        return iA;
    }

    @Deprecated
    public static String a(String str, String str2, String str3, String str4) {
        if (e()) {
            return a(str, str4, tc.a(str3, a(str2)));
        }
        return a(str, str2, str3, str4, true, (ku) null, (b<String>) null);
    }

    @Deprecated
    public static String a(String str, String str2, String str3, String str4, b<String> bVar) {
        if (e()) {
            return a(str, str4, tc.a(str3, a(str2)), bVar);
        }
        return a(str, str2, str3, str4, true, (ku) null, bVar);
    }

    @Deprecated
    public static String a(String str, String str2, String str3, ku kuVar) {
        if (e()) {
            return a(str, str3, tc.a(str2));
        }
        return a(str, (String) null, str2, str3, false, kuVar, (b<String>) null);
    }

    private static String a(String str, String str2, String str3, String str4, boolean z, ku kuVar, b<String> bVar) {
        String strA;
        String strA2 = r1.d().f().a(str, str3, str4);
        if (a((Object) strA2)) {
            if (bVar != null) {
                bVar.a(false, strA2, false, null);
            }
            return strA2;
        }
        if (z) {
            strA = c().getString(b(str, str3, str2), a);
        } else {
            strA = com.qq.e.comm.plugin.b.c().a(kuVar, strA2, a);
        }
        boolean z2 = !a.equals(strA);
        if (bVar != null) {
            bVar.a(true, strA2, z2, strA);
        }
        if (!z2) {
            return str4;
        }
        vc.a(strA2, strA);
        return strA;
    }
}
