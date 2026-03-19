package com.baidu.mobads.container.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobads.container.util.by;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static final String a = "mobads_aplist_status_new";
    public static final String b = "broadcast_sniff";
    public static final String c = "click_sniff";
    private static final String f = b.class.getSimpleName();
    private static final boolean g = false;
    private static final String h = "n_origin_pkg_encode_";
    private static final String i = "n_iad_index_array";
    private static final String j = "n_index_full_array";
    private static final String k = "n_iad_sniff_result";
    private static final String l = "pkglist";
    private static final String m = "apkInfoTimeout";
    private static final String n = "sniffArrayInterval";
    private static final String o = "needSniff";
    private static final String p = "n_iad_time_stamp";
    private static final String q = "n_iad_apk_info_timeout";
    private static final String r = "n_iad_sniff_array_interval";
    private static final String s = "n_iad_need_sniff_new";
    private static final String t = "lp_reload";
    private static final String u = "switch_mtj_open";
    private static final String v = "mtj_switch";
    private static final String w = "mtj_web_switch";
    private static final String x = "mtj_c_level";
    private static b y;
    private long[] B;
    private String[] C;
    private String[] F;
    private String z;
    long d = 300;
    private boolean A = com.baidu.mobads.container.config.a.a().k();
    private boolean D = false;
    long e = 1;
    private String E = null;
    private List<String> G = new CopyOnWriteArrayList();

    public static b a() {
        if (y == null) {
            synchronized (b.class) {
                if (y == null) {
                    y = new b();
                }
            }
        }
        return y;
    }

    private b() {
        b(f, "create APKStateManager Instance ~");
    }

    private boolean h(Context context) {
        this.A = b(context, s, this.A);
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(PackageManager packageManager, String str, int i2, long j2) throws PackageManager.NameNotFoundException {
        try {
            b(f, "judge pkg :" + str);
            packageManager.getApplicationInfo(str, 0);
            return a(j2, i2);
        } catch (PackageManager.NameNotFoundException e) {
            return b(j2, i2);
        } catch (Exception e2) {
            return b(j2, i2);
        }
    }

    public long a(long j2, int i2) {
        b(f, "setApkInstalled, current state :" + j2 + ", position :" + i2);
        return j2 | (1 << i2);
    }

    private long b(long j2, int i2) {
        b(f, "setApkInstalled, current state :" + j2 + ", position :" + i2);
        return j2 & ((1 << i2) ^ (-1));
    }

    public void a(Context context, boolean z) {
        if (!h(context)) {
            b(f, "Within the sniff switch has no permission");
            return;
        }
        if (this.D) {
            b(f, "During Sniff packages,return current action");
            return;
        }
        int iA = a(context, q, 0);
        if (iA <= 0) {
            iA = 24;
        }
        if (TimeUnit.HOURS.toMillis(iA) > System.currentTimeMillis() - b(context, p) && !z) {
            b(f, "Within the time protection period");
            return;
        }
        this.d = b(context, r);
        if (this.d <= 0) {
            this.d = 300L;
        }
        String[] strArrG = g(context);
        if (strArrG == null || strArrG.length == 0) {
            b(f, "actionToSniff array is null");
            return;
        }
        int iA2 = a(context, i, strArrG.length - 1) + 1;
        this.B = new long[iA2];
        this.C = new String[iA2];
        c cVar = new c(this, strArrG, context);
        this.D = true;
        com.baidu.mobads.container.d.b.a().a(cVar, 2);
    }

    public void a(Context context, String str, String str2, String str3) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sniff_time", str);
            jSONObject.put("sniff_value", str2);
            jSONObject.put("sniff_type", "all_sniff");
            jSONObject.put("send_time", System.currentTimeMillis());
            jSONObject.put("first_sniff", str3);
            by.a.a(context).a(1008).a("subtype", 10086L).a("ext_data", jSONObject.toString()).f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String[] strArr, Context context, int i2) {
        if (i2 >= strArr.length) {
            return;
        }
        this.E = strArr[i2];
        if (TextUtils.isEmpty(this.E)) {
            return;
        }
        this.F = a(this.E);
        for (int i3 = 0; i3 < this.F.length && i3 < 64; i3++) {
            b(f, "actionToProbo : i=" + i2 + ", j=" + i3 + "pkg=" + this.F[i3] + ", state=" + this.e);
        }
        this.e = a(context, this.F);
        this.B[i2] = this.e;
        if (com.baidu.mobads.container.h.a.a().A()) {
            this.C[i2] = b(context, this.F);
        }
    }

    private long a(Context context, String[] strArr) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        int i2 = 0;
        long jA = 1;
        while (i2 < strArr.length && i2 < 64) {
            int i3 = i2 + 1;
            jA = a(packageManager, strArr[i2], i3, jA);
            i2 = i3;
        }
        return jA;
    }

    private String b(Context context, String[] strArr) {
        if (context == null || strArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(1536);
        int iMin = Math.min(strArr.length, 64);
        int i2 = 0;
        while (i2 < iMin) {
            sb.append(d(context, strArr[i2]));
            i2++;
            if (i2 < iMin) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private String d(Context context, String str) {
        try {
            b(f, "judge pkg :" + str);
            PackageInfo packageInfoA = bk.a(context, str, 0);
            if (packageInfoA != null) {
                return (packageInfoA.firstInstallTime / 1000) + "." + (packageInfoA.lastUpdateTime / 1000);
            }
            return com.baidu.mobads.sdk.internal.cm.d;
        } catch (Exception e) {
            e.printStackTrace();
            return com.baidu.mobads.sdk.internal.cm.d;
        }
    }

    public void a(Context context, String str) {
        if (this.G.contains(str) || context == null) {
            return;
        }
        this.G.add(str);
        a(context, str, c);
    }

    public void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            b(f, "SniffByBroadCast pkg or context is null");
        } else {
            if (!h(context)) {
                return;
            }
            com.baidu.mobads.container.d.b.a().a(new d(this, context, str), 2);
        }
    }

    public void b(Context context, String str, String str2, String str3) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sniff_package", str);
            jSONObject.put("sniff_value", str2);
            jSONObject.put("sniff_type", str3);
            jSONObject.put("send_time", System.currentTimeMillis());
            by.a.a(context).a(1008).a("subtype", 10086L).a("ext_data", jSONObject.toString()).f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(Context context) {
        for (int i2 = 0; i2 < this.C.length; i2 += 2) {
            try {
                by.a aVarA = by.a.a(context).a(1008).a("subtype", 10089L).a("userfeedback", u.a(com.baidu.mobads.container.util.f.z.a(context))).a("userfb", u.a(IDManager.getInstance().c(context) + "." + IDManager.getInstance().d(context)));
                aVarA.a("userfeedbackinfo" + i2, u.a(this.C[i2]));
                int i3 = i2 + 1;
                if (i3 < this.C.length) {
                    aVarA.a("userfeedbackinfo" + i3, u.a(this.C[i3]));
                }
                aVarA.f();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public String b(Context context) {
        if (context == null) {
            return null;
        }
        if (!h(context)) {
            return "0";
        }
        if (!TextUtils.isEmpty(this.z)) {
            return this.z;
        }
        this.z = c(context, k);
        a(context, false);
        return this.z;
    }

    public boolean c(Context context) {
        return b(context, t, false);
    }

    public boolean d(Context context) {
        return b(context, "mtj_switch", com.baidu.mobads.container.config.a.a().e());
    }

    public boolean e(Context context) {
        return b(context, w, false);
    }

    public int f(Context context) {
        return a(context, x, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long[] i(Context context) {
        String strB = b(context);
        int iMax = Math.max(a(context, i, 0) + 1, g(context).length);
        long[] jArr = new long[iMax];
        if (TextUtils.isEmpty(strB)) {
            b(f, "getIADArray values is null");
            return jArr;
        }
        try {
            if (strB.contains(",")) {
                String[] strArrSplit = strB.split(",");
                for (int i2 = 0; i2 < iMax; i2++) {
                    jArr[i2] = Long.parseLong(strArrSplit[i2]);
                }
            } else {
                jArr[0] = Long.parseLong(strB);
            }
        } catch (RuntimeException e) {
            bq.a().c(f, "getIADEXArray Exception :" + e.getMessage());
        }
        return jArr;
    }

    public String[] g(Context context) {
        try {
            int iA = a(context, i, -1);
            if (iA == -1) {
                String[] strArr = {com.baidu.mobads.container.config.a.a, com.baidu.mobads.container.config.a.b, com.baidu.mobads.container.config.a.c, com.baidu.mobads.container.config.a.d, com.baidu.mobads.container.config.a.e, com.baidu.mobads.container.config.a.f, com.baidu.mobads.container.config.a.g, com.baidu.mobads.container.config.a.h, com.baidu.mobads.container.config.a.i, com.baidu.mobads.container.config.a.j, com.baidu.mobads.container.config.a.k, com.baidu.mobads.container.config.a.l, com.baidu.mobads.container.config.a.m, com.baidu.mobads.container.config.a.n, com.baidu.mobads.container.config.a.o};
                com.baidu.mobads.container.d.b.a().a(new e(this, strArr, context.getApplicationContext()), 2);
                return strArr;
            }
            int i2 = iA + 1;
            String[] strArr2 = new String[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                strArr2[i3] = c(context, h + i3);
            }
            return strArr2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String[] a(String str) {
        String[] strArr = new String[64];
        if (TextUtils.isEmpty(str)) {
            return strArr;
        }
        String strB = u.b(str);
        if (TextUtils.isEmpty(strB)) {
            return strArr;
        }
        if (strB.contains(",")) {
            return strB.split(",");
        }
        strArr[0] = strB;
        return strArr;
    }

    public void a(Context context, String str, boolean z) {
        JSONObject jSONObject;
        int i2;
        b(f, "dealWithPKGProfile :" + str);
        if (TextUtils.isEmpty(str) || context == null) {
            b(f, "dealWithPKGProfile : origin string is null");
            com.baidu.mobads.container.r.c.b(context);
            return;
        }
        String strB = u.b(str);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject2 = new JSONObject(strB);
            b(f + "1", "本次是否为全量下发" + z);
            int iIntValue = 0;
            if (!z) {
                c(context, t, jSONObject2.optBoolean(t, false));
                boolean zOptBoolean = jSONObject2.optBoolean("mtj_switch", com.baidu.mobads.container.config.a.a().e());
                c(context, "mtj_switch", zOptBoolean);
                boolean zOptBoolean2 = jSONObject2.optBoolean(w, false);
                c(context, w, zOptBoolean2);
                b(context, x, jSONObject2.optInt(x, 0));
                if (zOptBoolean || zOptBoolean2) {
                    com.baidu.mobads.container.r.c.b(context);
                }
                b(context, q, jSONObject2.optInt(m, 0));
                a(context, r, jSONObject2.optLong(n));
                c(context, s, jSONObject2.optBoolean(o, this.A));
            }
            if (!jSONObject2.has(l) || (jSONObject = jSONObject2.getJSONObject(l)) == null) {
                return;
            }
            if (a(context, jSONObject)) {
                bz.a().a(context);
                return;
            }
            Iterator<String> itKeys = jSONObject.keys();
            boolean z2 = false;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                int i3 = Integer.parseInt(next);
                if (i3 >= 0) {
                    arrayList.add(Integer.valueOf(i3));
                    if (!TextUtils.equals(c(context, h + next), jSONObject.optString(next))) {
                        b(context, h + i3, jSONObject.optString(next));
                        z2 = true;
                    }
                }
            }
            b(f, "sort BEFORE KEY:" + arrayList.toString());
            Collections.sort(arrayList);
            b(f, "sort KEY:" + arrayList.toString());
            if (arrayList.size() > 0) {
                iIntValue = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            int iA = a(context, i, -1);
            b(f + "1", "本地与云端索引值对比本地：" + iA + ",云端=" + iIntValue);
            int iMax = Math.max(iIntValue, iA);
            if (a(c(context, h + iMax)).length >= 61) {
                i2 = iMax;
            } else {
                i2 = iMax - 1;
            }
            b(f + "1", "最大充满组数：" + i2);
            b(context, j, i2);
            String[] strArr = new String[iMax + 1];
            b(context, i, iMax);
            b(f, "ready to create int[] size = " + iMax);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                strArr[iIntValue2] = jSONObject.optString(String.valueOf(iIntValue2));
            }
            a(context, p, 0L);
            b(f + "1", "是否有变化：" + z2);
            a(context, z2);
        } catch (IllegalArgumentException e) {
            b(f, "dealWithPKGProfile : IllegalArgumentException");
            e.printStackTrace();
        } catch (RuntimeException e2) {
            b(f, "dealWithPKGProfile : RunTimeException");
            e2.printStackTrace();
        } catch (JSONException e3) {
            b(f, "dealWithPKGProfile :decode json String error");
            e3.printStackTrace();
        } catch (Throwable th) {
            b(f, "dealWithPKGProfile : otherException");
            th.printStackTrace();
        }
    }

    public long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        return context.getSharedPreferences(a, 0).getLong(str, 0L);
    }

    public void a(Context context, String str, long j2) {
        if (context == null || j2 <= 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
        editorEdit.putLong(str, j2);
        editorEdit.apply();
    }

    public String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(a, 0).getString(str, "");
    }

    public void b(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public int a(Context context, String str, int i2) {
        if (context == null) {
            return i2;
        }
        return context.getSharedPreferences(a, 0).getInt(str, i2);
    }

    public void b(Context context, String str, int i2) {
        if (context == null || i2 <= 0) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
        editorEdit.putInt(str, i2);
        editorEdit.apply();
    }

    private boolean b(Context context, String str, boolean z) {
        if (context == null) {
            return z;
        }
        return context.getSharedPreferences(a, 0).getBoolean(str, z);
    }

    private void c(Context context, String str, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(a, 0).edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    private boolean a(Context context, JSONObject jSONObject) {
        int iA;
        boolean z;
        try {
            iA = a(context, j, -1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (iA == -1) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (true) {
            if (!itKeys.hasNext()) {
                z = true;
                break;
            }
            if (Integer.parseInt(itKeys.next()) > iA + 1) {
                z = false;
                break;
            }
        }
        if (!z) {
            if (TextUtils.isEmpty(jSONObject.optString((iA + 1) + "", ""))) {
                b(f + "1", "是否用下发全量true");
                return true;
            }
            b(f + "1", "是否用下发全量false");
            return false;
        }
        b(f + "1", "是否用下发全量false");
        return false;
    }
}
