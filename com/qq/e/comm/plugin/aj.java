package com.qq.e.comm.plugin;

import android.text.TextUtils;
import android.util.Pair;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class aj {
    private static final String n = "kg";
    private static volatile aj o;
    private volatile List<String> b;
    private volatile List<String> c;
    private volatile JSONObject d;
    private volatile long k;
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final int e = r1.d().f().a("iehdc", 2);
    private final AtomicInteger f = new AtomicInteger(0);
    private final AtomicInteger g = new AtomicInteger(0);
    private final AtomicInteger h = new AtomicInteger(0);
    private int i = 0;
    private int j = 0;
    private final Runnable l = new a();
    private volatile int m = -1;

    private aj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:114:0x020a A[Catch: Exception -> 0x025c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x025c, blocks: (B:114:0x020a, B:141:0x0259), top: B:168:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0259 A[Catch: Exception -> 0x025c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x025c, blocks: (B:114:0x020a, B:141:0x0259), top: B:168:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0277 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x027e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a1 A[Catch: Exception -> 0x01be, all -> 0x01d7, TryCatch #19 {Exception -> 0x01be, blocks: (B:66:0x015b, B:71:0x016f, B:73:0x0175, B:75:0x0184, B:76:0x0186, B:78:0x018c, B:80:0x019b, B:83:0x01a1, B:84:0x01b0, B:85:0x01b4), top: B:175:0x0143 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b0 A[Catch: Exception -> 0x01be, all -> 0x01d7, TryCatch #19 {Exception -> 0x01be, blocks: (B:66:0x015b, B:71:0x016f, B:73:0x0175, B:75:0x0184, B:76:0x0186, B:78:0x018c, B:80:0x019b, B:83:0x01a1, B:84:0x01b0, B:85:0x01b4), top: B:175:0x0143 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.aj.g():void");
    }

    private boolean a(JSONObject jSONObject, String str, long j, int i, int i2) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("endpoints");
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i3);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString = jSONObjectOptJSONObject2.optString("ip");
                        if (!TextUtils.isEmpty(strOptString) && k9.a(strOptString)) {
                            arrayList2.add(strOptString);
                        }
                    }
                }
            }
            if ((i2 == 1 || i2 == 2) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("v6Endpoints")) != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i4);
                    if (jSONObjectOptJSONObject3 != null) {
                        String strOptString2 = jSONObjectOptJSONObject3.optString("ip");
                        if (!TextUtils.isEmpty(strOptString2) && k9.a(strOptString2)) {
                            arrayList3.add(strOptString2);
                        }
                    }
                }
                if (!arrayList2.isEmpty() && !arrayList3.isEmpty()) {
                    if (r1.d().f().a("ihdiair", 0) == 1) {
                        arrayList.addAll(arrayList3);
                        arrayList.addAll(arrayList2);
                    } else {
                        arrayList.add(arrayList3.get(0));
                        arrayList.addAll(arrayList2);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(arrayList2);
            }
            if (!arrayList.isEmpty()) {
                h9.c().a(str, arrayList, j, 1);
                return true;
            }
        }
        ri.a(i, 4, null);
        return false;
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            aj.this.g();
        }
    }

    private String d(String str) {
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return strC;
        }
        return "https://" + strC + "/";
    }

    private String c(String str) {
        return (TextUtils.isEmpty(str) || this.d == null) ? "" : this.d.optString(str, "");
    }

    public void b(int i) {
        if (i == 1) {
            this.f.incrementAndGet();
        } else if (i == 2) {
            this.g.incrementAndGet();
        } else {
            if (i != 3) {
                return;
            }
            this.h.incrementAndGet();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0061 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean h(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.lang.String r0 = r5.d(r6)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L13
            return r1
        L13:
            r6.hashCode()
            r6.hashCode()
            int r2 = r6.hashCode()
            r3 = 1
            r4 = -1
            switch(r2) {
                case 99: goto L39;
                case 118: goto L2e;
                case 3484: goto L23;
                default: goto L22;
            }
        L22:
            goto L43
        L23:
            java.lang.String r2 = "mi"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L2c
            goto L43
        L2c:
            r4 = 2
            goto L43
        L2e:
            java.lang.String r2 = "v"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L37
            goto L43
        L37:
            r4 = 1
            goto L43
        L39:
            java.lang.String r2 = "c"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L42
            goto L43
        L42:
            r4 = 0
        L43:
            switch(r4) {
                case 0: goto L59;
                case 1: goto L50;
                case 2: goto L47;
                default: goto L46;
            }
        L46:
            goto L62
        L47:
            java.lang.String r6 = "https://mi.gdt.qq.com/"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L62
            goto L61
        L50:
            java.lang.String r6 = "https://v2.gdt.qq.com/"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L62
            goto L61
        L59:
            java.lang.String r6 = "https://c2.gdt.qq.com/"
            boolean r6 = r0.startsWith(r6)
            if (r6 != 0) goto L62
        L61:
            r1 = 1
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.aj.h(java.lang.String):boolean");
    }

    public static String f(String str) {
        return String.format("%s_%s", "usibd", str);
    }

    private boolean f() {
        return System.currentTimeMillis() - this.k < ((long) r1.d().f().a("iehcdt", 60)) * 1000;
    }

    public int e() {
        return c();
    }

    private int e(String str) {
        int iA = r1.d().f().a("ihdfif", 0);
        if (iA == 1) {
            return 1;
        }
        if (!TextUtils.isEmpty(str) && k9.a(str)) {
            try {
                if ((InetAddress.getByName(str) instanceof Inet6Address) && iA == 2) {
                    return 2;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private int g(String str) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "c":
                return 2;
            case "v":
                return 3;
            case "mi":
                return 1;
            default:
                return 0;
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.f.set(0);
        } else if (i == 2) {
            this.g.set(0);
        } else {
            if (i != 3) {
                return;
            }
            this.h.set(0);
        }
    }

    public void b(String str) {
        b(g(str));
    }

    public static aj b() {
        if (o == null) {
            synchronized (aj.class) {
                if (o == null) {
                    o = new aj();
                }
            }
        }
        return o;
    }

    private int c() {
        if (this.m < 0) {
            this.m = xc.a("iehna", "APP", "", 0);
        }
        return this.m;
    }

    private String d() {
        return c() == 2 ? r1.d().f().b("iehnarh", "https://v3mi.gdt.qq.com/") : "";
    }

    public void a(String str) {
        a(g(str));
    }

    private boolean c(int i) {
        boolean z = true;
        if (i == 1 ? this.f.get() <= this.e : i == 2 ? this.g.get() <= this.e : i != 3 || this.h.get() <= this.e) {
            z = false;
        }
        if (z) {
            cj.b(i, 0, null);
        }
        return z;
    }

    public boolean a(String str, int i, int i2) {
        boolean z = r1.d().f().a(a(str, i2), 0) == 1;
        if (z) {
            if (!z) {
                return false;
            }
        } else if (xc.a(f(str), String.valueOf(i2), "APP", 0) == 1) {
            return false;
        }
        return !c(i) && h(str);
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        try {
            this.d = new JSONObject(r1.d().f().b("iprh", "{\"mi\":\"\",\"c\":\"c3.gdt.qq.com\",\"v\":\"v3.gdt.qq.com\"}"));
            String strOptString = this.d.optString("mi", "");
            if (!TextUtils.isEmpty(strOptString)) {
                arrayList.add(strOptString);
            }
            String strOptString2 = this.d.optString("c", "");
            if (!TextUtils.isEmpty(strOptString2)) {
                arrayList.add(strOptString2);
            }
            String strOptString3 = this.d.optString("v", "");
            if (!TextUtils.isEmpty(strOptString3)) {
                arrayList.add(strOptString3);
            }
        } catch (Exception unused) {
        }
        String strB = r1.d().f().b("ieprh", "pgdt.ugdtimg.com,adsmind.ugdtimg.com,qzs.gdtimg.com");
        if (!TextUtils.isEmpty(strB)) {
            this.c = Arrays.asList(strB.split(","));
            arrayList.addAll(this.c);
        }
        return arrayList;
    }

    public Pair<Boolean, String> a(String str, String str2) {
        str2.hashCode();
        str2.hashCode();
        switch (str2) {
            case "c":
                String strD = d("c");
                if (str.startsWith("https://c2.gdt.qq.com/") && !TextUtils.isEmpty(strD) && !str.startsWith(strD)) {
                    return new Pair<>(Boolean.TRUE, str.replace("https://c2.gdt.qq.com/", strD));
                }
                break;
            case "v":
                String strD2 = d("v");
                if (str.startsWith("https://v2.gdt.qq.com/") && !TextUtils.isEmpty(strD2) && !str.startsWith(strD2)) {
                    return new Pair<>(Boolean.TRUE, str.replace("https://v2.gdt.qq.com/", strD2));
                }
                break;
            case "mi":
                String strD3 = d();
                if (str.startsWith("https://mi.gdt.qq.com/") && !TextUtils.isEmpty(strD3) && !str.startsWith(strD3)) {
                    return new Pair<>(Boolean.TRUE, str.replace("https://mi.gdt.qq.com/", strD3));
                }
                String strD4 = d("mi");
                if (str.startsWith("https://mi.gdt.qq.com/") && !TextUtils.isEmpty(strD4) && !str.startsWith(strD4)) {
                    return new Pair<>(Boolean.TRUE, str.replace("https://mi.gdt.qq.com/", strD4));
                }
                break;
        }
        return new Pair<>(Boolean.FALSE, str);
    }

    private String a(String str, int i) {
        return String.format("%s_%s_%s", "sibdat", str, Integer.valueOf(i));
    }

    public void a(List<String> list, boolean z) throws Throwable {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (this.i == 0) {
            this.i = r1.d().f().a("rhdsct", 4000);
        }
        if (this.j == 0) {
            this.j = r1.d().f().a("rhdsrt", 8000);
        }
        if (this.a.compareAndSet(false, true)) {
            this.b = list;
            if (z) {
                g();
            } else {
                qg.b.submit(this.l);
            }
        }
    }
}
