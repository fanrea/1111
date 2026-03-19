package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.plugin.lx;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b5 {
    private static final String a = "b5";
    private static final Map<String, String> b = new HashMap();
    private static final Set<String> c = new HashSet();
    private static final boolean d;

    /* compiled from: A */
    private static class d {
        static final Handler a;

        static {
            HandlerThread handlerThread = new HandlerThread("gdt_c2s_b_thread");
            handlerThread.start();
            a = new Handler(handlerThread.getLooper());
        }
    }

    static {
        d = r1.d().f().a("tnmri", 0) == 1;
    }

    public static void d(String str, Object obj) {
        d.a.post(new c(str, obj));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ h4 c;
        final /* synthetic */ String d;
        final /* synthetic */ f5 e;
        final /* synthetic */ Object f;

        a(int i, int i2, h4 h4Var, String str, f5 f5Var, Object obj) {
            this.a = i;
            this.b = i2;
            this.c = h4Var;
            this.d = str;
            this.e = f5Var;
            this.f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            b5.a(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ h4 e;
        final /* synthetic */ f5 f;
        final /* synthetic */ Object g;
        final /* synthetic */ String h;

        b(int i, int i2, String str, String str2, h4 h4Var, f5 f5Var, Object obj, String str3) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
            this.e = h4Var;
            this.f = f5Var;
            this.g = obj;
            this.h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b5.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }
    }

    private static String a(String str) {
        String strReplaceAll;
        String strA = a30.a(str, "sdk_version", su.c());
        try {
            strReplaceAll = URLEncoder.encode(r1.d().b().d(), "utf-8").replaceAll("\\+", "%20");
        } catch (Exception unused) {
            strReplaceAll = "";
        }
        return a30.a(strA, "app_version", strReplaceAll);
    }

    private static String b(Map<String, Object> map, String str) {
        if (map == null) {
            return "";
        }
        Object obj = map.get(str);
        return obj instanceof String ? (String) obj : "";
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ Object b;

        c(String str, Object obj) {
            this.a = str;
            this.b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strB = b5.b(this.a, this.b);
            String unused = b5.a;
            b5.c.remove(strB);
        }
    }

    private static boolean c(String str, Object obj) {
        return c.contains(b(str, obj));
    }

    private static void c(int i, int i2, String str, String str2, h4 h4Var, f5 f5Var, Object obj, String str3) {
        d.a.post(new b(i, i2, str, str2, h4Var, f5Var, obj, str3));
    }

    private static boolean c() {
        return r1.d().f().a("skcbwollt", 0) == 1;
    }

    private static int a(Map<String, Object> map, String str) {
        if (map == null) {
            return -1;
        }
        Object obj = map.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, int i2, String str, String str2, h4 h4Var, f5 f5Var, Object obj, String str3) {
        b10.a(1408005, f5Var, 0);
        boolean z = i2 == 2;
        if (!z && c() && c(str2, obj)) {
            return;
        }
        if (z) {
            a(str2, i, str3);
        } else if (h4Var != null) {
            a(h4Var.W(), str, i, i2);
        }
        c.add(b(str2, obj));
    }

    public static String b(String str) {
        return b.remove(str);
    }

    private static void b(int i, int i2, h4 h4Var, String str, f5 f5Var, Object obj) {
        d.a.post(new a(i, i2, h4Var, str, f5Var, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, Object obj) {
        return str + obj.hashCode();
    }

    public static String a(LoadAdParams loadAdParams) {
        String str;
        if (loadAdParams == null) {
            a(1, "no LoadAdParams");
            return "";
        }
        if (loadAdParams.getDevExtra() == null) {
            a(2, "no DevExtra");
            return "";
        }
        try {
            str = (String) loadAdParams.getDevExtra().get("thrmei");
        } catch (Throwable unused) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            a(3, "no thrmei");
            return "";
        }
        try {
            String[] strArrSplit = str.split(Config.replace);
            if (strArrSplit.length < 4) {
                a(5, str);
                return "";
            }
            return strArrSplit[3];
        } catch (Throwable unused2) {
            a(4, str);
            return "";
        }
    }

    public static String a(int i) throws lx.d {
        return lx.a(String.valueOf(i));
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            b.put(str, a(i));
        } catch (lx.d e) {
            e.getMessage();
        }
    }

    public static void a(String str, String str2, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strA = a(i);
            if (TextUtils.isEmpty(str2)) {
                str2 = "%24%7BAUCTION_SEAT_ID%7D";
            }
            zt.a(a(str.replace("%24%7BAUCTION_PRICE%7D", strA).replace("%24%7BAUCTION_SEAT_ID%7D", str2).replace("%24%7BAUCTION_LOSS%7D", String.valueOf(i2))), true);
        } catch (lx.d e) {
            e.getMessage();
        }
    }

    public static void a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strA = a(i);
            zt.a(a(str.replace("%24%7BAUCTION_PRICE%7D", strA).replace("%24%7BHIGHEST_LOSS_PRICE%7D", a(i2))), true);
        } catch (lx.d e) {
            e.getMessage();
        }
    }

    public static void a(int i, int i2, String str, String str2, h4 h4Var, f5 f5Var, Object obj) {
        c(i, i2, str, str2, h4Var, f5Var, obj, null);
    }

    public static void a(Map<String, Object> map, String str, h4 h4Var, f5 f5Var, Object obj) {
        a(map, str, h4Var, f5Var, obj, (String) null);
    }

    public static void a(Map<String, Object> map, String str, h4 h4Var, f5 f5Var, Object obj, String str2) {
        c(a(map, IBidding.WIN_PRICE), a(map, IBidding.LOSS_REASON), b(map, IBidding.ADN_ID), str, h4Var, f5Var, obj, str2);
    }

    public static void a(int i, h4 h4Var, String str, f5 f5Var, Object obj) {
        b(i, -1, h4Var, str, f5Var, obj);
    }

    public static void a(Map<String, Object> map, h4 h4Var, String str, f5 f5Var, Object obj) {
        b(a(map, IBidding.EXPECT_COST_PRICE), a(map, IBidding.HIGHEST_LOSS_PRICE), h4Var, str, f5Var, obj);
    }

    public static void a(int i, int i2, h4 h4Var, String str, f5 f5Var, Object obj) {
        b10.a(1408004, f5Var);
        if (c() && c(str, obj)) {
            return;
        }
        if (h4Var != null) {
            a(h4Var.e1(), i, i2);
        }
        c.add(b(str, obj));
    }

    private static void a(String str, int i, String str2) {
        String strA = a30.a(a30.a(a30.a("https://win.gdt.qq.com/win_notice.fcg?viewid=1", "position_id", str), "loss", String.valueOf(2)), "mrqid", str2);
        try {
            strA = a30.a(strA, "win_price", a(i));
        } catch (lx.d e) {
            e.getMessage();
        }
        zt.a(a(strA), true);
    }

    private static void a(int i, String str) {
        if (d) {
            b10.a(1408006, null, 0, Integer.valueOf(i), new ja().a("data", str));
        }
    }
}
