package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.api.PromoteInstallManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class aq {
    private static final String a = z.m;
    private static final String b = "__sdk_remote_dl_no_install";
    private static final long c = 3600000;
    private Context d;
    private SharedPreferences e;
    private SharedPreferences.Editor f;
    private au g;
    private PromoteInstallManager.PromoteInstallListener h;
    private int i;
    private long j;

    /* synthetic */ aq(ar arVar) {
        this();
    }

    private static class a {
        private static final aq a = new aq(null);

        private a() {
        }
    }

    public static aq a(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        a.a.b(context, promoteInstallListener);
        return a.a;
    }

    private aq() {
        this.i = 0;
        this.j = 0L;
    }

    private void b(Context context, PromoteInstallManager.PromoteInstallListener promoteInstallListener) {
        this.d = context;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("__sdk_remote_dl_no_install", 0);
        this.e = sharedPreferences;
        this.f = sharedPreferences.edit();
        this.g = au.a(context, a);
        this.h = promoteInstallListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean a() {
        Map<String, ?> all;
        List<String> listA;
        try {
            all = this.e.getAll();
            listA = a((Map<String, Long>) all);
        } catch (Throwable unused) {
        }
        if (listA == null) {
            return false;
        }
        for (int i = 0; i < listA.size(); i++) {
            String str = listA.get(i);
            Object objB = this.g.b(null, "getAdDownLoadInfo", this.d, str);
            if ((objB instanceof JSONObject) && ((JSONObject) objB).length() > 0) {
                Long l = (Long) all.get(str);
                if (a((JSONObject) objB) && System.currentTimeMillis() - l.longValue() < 3600000 && !bv.a(this.d, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<String> a(Map<String, Long> map) {
        if (map == null || map.size() <= 0) {
            PromoteInstallManager.PromoteInstallListener promoteInstallListener = this.h;
            if (promoteInstallListener != null) {
                promoteInstallListener.onFail("暂无可用物料，请稍后再试");
            }
            return null;
        }
        ArrayList arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new ar(this));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((String) ((Map.Entry) it.next()).getKey());
        }
        if (map.get(arrayList2.get(0)).longValue() > this.j || this.i < 3) {
            return arrayList2;
        }
        PromoteInstallManager.PromoteInstallListener promoteInstallListener2 = this.h;
        if (promoteInstallListener2 != null) {
            promoteInstallListener2.onFail("暂无可用物料，请稍后再试");
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
    
        r3 = new com.baidu.mobads.sdk.internal.ap(r7, r16.d, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        if (r17 == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
    
        r0 = new org.json.JSONObject(r7.toString());
        r0.put("install_ts", r8);
        r0 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b5, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d0, code lost:
    
        r0 = r16.h;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d2, code lost:
    
        if (r0 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
    
        r0.onFail("暂无可用物料，请稍后再试");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00da, code lost:
    
        return r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.mobads.sdk.api.IPromoteInstallAdInfo a(boolean r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = 0
            android.content.SharedPreferences r0 = r1.e     // Catch: java.lang.Throwable -> Ld0
            java.util.Map r0 = r0.getAll()     // Catch: java.lang.Throwable -> Ld0
            java.util.List r3 = r1.a(r0)     // Catch: java.lang.Throwable -> Ld0
            if (r3 != 0) goto L10
            return r2
        L10:
            r4 = 0
            r5 = r4
        L12:
            int r6 = r3.size()     // Catch: java.lang.Throwable -> Ld0
            if (r5 >= r6) goto Ld0
            java.lang.Object r6 = r3.get(r5)     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Ld0
            com.baidu.mobads.sdk.internal.au r7 = r1.g     // Catch: java.lang.Throwable -> Ld0
            java.lang.String r8 = "getAdDownLoadInfo"
            r9 = 2
            java.lang.Object[] r10 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> Ld0
            android.content.Context r11 = r1.d     // Catch: java.lang.Throwable -> Ld0
            r10[r4] = r11     // Catch: java.lang.Throwable -> Ld0
            r11 = 1
            r10[r11] = r6     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r7 = r7.b(r2, r8, r10)     // Catch: java.lang.Throwable -> Ld0
            boolean r8 = r7 instanceof org.json.JSONObject     // Catch: java.lang.Throwable -> Ld0
            if (r8 == 0) goto Lc2
            r8 = r7
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch: java.lang.Throwable -> Ld0
            int r8 = r8.length()     // Catch: java.lang.Throwable -> Ld0
            if (r8 <= 0) goto Lc2
            org.json.JSONObject r7 = (org.json.JSONObject) r7     // Catch: java.lang.Throwable -> Ld0
            java.lang.Object r8 = r0.get(r6)     // Catch: java.lang.Throwable -> Ld0
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> Ld0
            boolean r10 = r1.a(r7)     // Catch: java.lang.Throwable -> Ld0
            if (r10 == 0) goto Lb7
            long r12 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld0
            long r14 = r8.longValue()     // Catch: java.lang.Throwable -> Ld0
            long r12 = r12 - r14
            r14 = 3600000(0x36ee80, double:1.7786363E-317)
            int r10 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r10 >= 0) goto Lb7
            android.content.Context r10 = r1.d     // Catch: java.lang.Throwable -> Ld0
            boolean r10 = com.baidu.mobads.sdk.internal.bv.a(r10, r6)     // Catch: java.lang.Throwable -> Ld0
            if (r10 == 0) goto L64
            goto Lb7
        L64:
            com.baidu.mobads.sdk.internal.ap r3 = new com.baidu.mobads.sdk.internal.ap     // Catch: java.lang.Throwable -> Ld0
            android.content.Context r0 = r1.d     // Catch: java.lang.Throwable -> Ld0
            r3.<init>(r7, r0, r1)     // Catch: java.lang.Throwable -> Ld0
            if (r17 == 0) goto L95
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L80 java.lang.Throwable -> Lb5
            java.lang.String r5 = r7.toString()     // Catch: org.json.JSONException -> L80 java.lang.Throwable -> Lb5
            r0.<init>(r5)     // Catch: org.json.JSONException -> L80 java.lang.Throwable -> Lb5
            java.lang.String r5 = "install_ts"
            r0.put(r5, r8)     // Catch: org.json.JSONException -> L80 java.lang.Throwable -> Lb5
            java.lang.String r0 = r0.toString()     // Catch: org.json.JSONException -> L80 java.lang.Throwable -> Lb5
            goto L85
        L80:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb5
            r0 = r2
        L85:
            com.baidu.mobads.sdk.internal.au r5 = r1.g     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r7 = "startInstallDialogActivity"
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch: java.lang.Throwable -> Lb5
            android.content.Context r10 = r1.d     // Catch: java.lang.Throwable -> Lb5
            r9[r4] = r10     // Catch: java.lang.Throwable -> Lb5
            r9[r11] = r0     // Catch: java.lang.Throwable -> Lb5
            r5.b(r2, r7, r9)     // Catch: java.lang.Throwable -> Lb5
        L95:
            int r0 = r1.i     // Catch: java.lang.Throwable -> Lb5
            int r0 = r0 + r11
            r1.i = r0     // Catch: java.lang.Throwable -> Lb5
            r2 = 3
            if (r0 > r2) goto La3
            long r4 = r8.longValue()     // Catch: java.lang.Throwable -> Lb5
            r1.j = r4     // Catch: java.lang.Throwable -> Lb5
        La3:
            android.content.SharedPreferences$Editor r0 = r1.f     // Catch: java.lang.Throwable -> Lb5
            r0.remove(r6)     // Catch: java.lang.Throwable -> Lb5
            android.content.SharedPreferences$Editor r0 = r1.f     // Catch: java.lang.Throwable -> Lb5
            r0.commit()     // Catch: java.lang.Throwable -> Lb5
            com.baidu.mobads.sdk.api.PromoteInstallManager$PromoteInstallListener r0 = r1.h     // Catch: java.lang.Throwable -> Lb5
            if (r0 == 0) goto Lb4
            r0.onSuccess()     // Catch: java.lang.Throwable -> Lb5
        Lb4:
            return r3
        Lb5:
            r2 = r3
            goto Ld0
        Lb7:
            android.content.SharedPreferences$Editor r7 = r1.f     // Catch: java.lang.Throwable -> Ld0
            r7.remove(r6)     // Catch: java.lang.Throwable -> Ld0
            android.content.SharedPreferences$Editor r6 = r1.f     // Catch: java.lang.Throwable -> Ld0
            r6.commit()     // Catch: java.lang.Throwable -> Ld0
            goto Lcc
        Lc2:
            android.content.SharedPreferences$Editor r7 = r1.f     // Catch: java.lang.Throwable -> Ld0
            r7.remove(r6)     // Catch: java.lang.Throwable -> Ld0
            android.content.SharedPreferences$Editor r6 = r1.f     // Catch: java.lang.Throwable -> Ld0
            r6.commit()     // Catch: java.lang.Throwable -> Ld0
        Lcc:
            int r5 = r5 + 1
            goto L12
        Ld0:
            com.baidu.mobads.sdk.api.PromoteInstallManager$PromoteInstallListener r0 = r1.h
            if (r0 == 0) goto Lda
            java.lang.String r3 = "暂无可用物料，请稍后再试"
            r0.onFail(r3)
        Lda:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.aq.a(boolean):com.baidu.mobads.sdk.api.IPromoteInstallAdInfo");
    }

    private boolean a(JSONObject jSONObject) {
        File file = new File(jSONObject.optString(com.baidu.mobads.container.components.command.j.m) + jSONObject.optString("filename"));
        return file.exists() && file.length() > 0;
    }

    public boolean b() {
        Object objB = this.g.b(null, "isInstallPopSwitch", new Object[0]);
        if (objB instanceof Boolean) {
            return ((Boolean) objB).booleanValue();
        }
        return false;
    }

    public int c() {
        Object objB = this.g.b(null, "getInstallPopType", new Object[0]);
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return 0;
    }

    public void a(Context context, String str) {
        this.g.b(null, "handleAdInstall", context, str);
    }
}
