package ca.da.ca.ia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import ca.da.ca.ja.q;
import ca.da.ca.ja.r;
import ca.da.ca.ja.t;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DbStore.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static final HashMap<String, ca.da.ca.ia.b> d;
    public static final ca.da.ca.ia.b[] e;
    public static final b[] f;
    public final ca.da.ca.da.b a;
    public final a b;
    public String c;

    /* compiled from: DbStore.java */
    public static class a extends SQLiteOpenHelper {
        public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ca.da.ca.ia.b> it = d.d.values().iterator();
                while (it.hasNext()) {
                    String strA = it.next().a();
                    if (strA != null) {
                        sQLiteDatabase.execSQL(strA);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    r.a(th);
                } finally {
                    t.a(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            r.a("onUpgrade, " + i + ", " + i2, (Throwable) null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<ca.da.ca.ia.b> it = d.d.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().e());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    t.a(sQLiteDatabase);
                    onCreate(sQLiteDatabase);
                } catch (Throwable th) {
                }
            }
            t.a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* compiled from: DbStore.java */
    public static class b {
        public String a;
        public int b;
        public int c;

        public final void a(ca.da.ca.ia.b bVar) {
            String strC = bVar.c();
            if (strC == null || strC.length() <= this.b) {
                return;
            }
            this.a = bVar.d();
            this.b = strC.length();
        }

        public String toString() {
            return new StringBuilder(this.c).append("-").append(this.a).append("-").append(this.b).toString();
        }
    }

    static {
        HashMap<String, ca.da.ca.ia.b> map = new HashMap<>();
        d = map;
        map.put("page", new j());
        map.put(Config.LAUNCH, new h());
        map.put("terminate", new m());
        map.put("pack", new i());
        ca.da.ca.ia.b[] bVarArr = {new e(), new g(null, false, null), new f("", new JSONObject())};
        e = bVarArr;
        for (ca.da.ca.ia.b bVar : bVarArr) {
            a(bVar);
        }
        d.put("profile", new k(null, null));
        f = new b[]{new b(), new b(), new b()};
    }

    public d(ca.da.ca.da.b bVar, String str) {
        this.b = new a(bVar.b, str, null, 39);
        this.a = bVar;
    }

    public final String a(String str, String str2, boolean z, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z ? "='" : "!='") + str2 + "' AND _id<=" + j;
    }

    public static void a(ca.da.ca.ia.b bVar) {
        d.put(bVar.e(), bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e2 A[PHI: r10 r14
  0x00e2: PHI (r10v2 android.database.Cursor) = (r10v1 android.database.Cursor), (r10v15 android.database.Cursor), (r10v15 android.database.Cursor) binds: [B:45:0x00e0, B:77:0x00e2, B:78:0x00e2] A[DONT_GENERATE, DONT_INLINE]
  0x00e2: PHI (r14v3 long) = (r14v1 long), (r14v5 long), (r14v5 long) binds: [B:45:0x00e0, B:77:0x00e2, B:78:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r18, android.database.sqlite.SQLiteDatabase r19, java.lang.String r20, boolean r21, org.json.JSONArray[] r22, long[] r23) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ia.d.a(int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, org.json.JSONArray[], long[]):int");
    }

    public final boolean a(String str) {
        r.a(ca.ca.ca.ca.a.a("needLaunch, ").append(this.c).append(", ").append(str).toString());
        if (TextUtils.equals(str, this.c)) {
            return false;
        }
        this.c = str;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<ca.da.ca.ia.i> a(org.json.JSONObject r33) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ia.d.a(org.json.JSONObject):java.util.ArrayList");
    }

    public final JSONObject a(h hVar, JSONObject jSONObject) throws JSONException {
        if (TextUtils.equals(hVar.m, this.a.f.i()) && hVar.l == this.a.f.h()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            t.a(jSONObject2, jSONObject);
            jSONObject2.put("app_version", hVar.m);
            jSONObject2.put("version_code", hVar.l);
            return jSONObject2;
        } catch (JSONException e2) {
            r.a(e2);
            return jSONObject;
        }
    }

    public final void a(JSONObject jSONObject, h hVar, i iVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<i> arrayList, HashMap<String, JSONObject> map) {
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        i iVar2;
        boolean z;
        SQLiteDatabase sQLiteDatabase3;
        i iVar3;
        r.a(ca.ca.ca.ca.a.a("packCurrentData, ").append(hVar.d).toString());
        boolean zA = a(hVar.d);
        int iA = a(0, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
        JSONArray jSONArrayA = a(hVar, map);
        boolean z2 = true;
        if (zA || a(jArr) || jSONArrayA != null) {
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            iVar2 = iVar;
            iVar.a(jSONObject, zA ? hVar : null, null, null, jSONArrayArr, jArr, jSONArrayA);
            if (jSONArrayA == null && iA >= e.length) {
                i iVar4 = (i) iVar.m290clone();
                iVar4.i();
                arrayList.add(iVar4);
            } else {
                a(iVar2, true, sQLiteDatabase2, true);
            }
        } else {
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            iVar2 = iVar;
        }
        int iA2 = iA;
        while (iA2 < e.length) {
            i iVar5 = iVar2;
            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
            boolean z3 = z2;
            iA2 = a(iA2, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
            if (a(jArr2)) {
                z = z3;
                sQLiteDatabase3 = sQLiteDatabase4;
                iVar3 = iVar5;
                iVar.a(jSONObject, a(hVar.d) ? hVar : null, null, null, jSONArrayArr, jArr, null);
                a(iVar3, z, sQLiteDatabase3, z);
            } else {
                z = z3;
                sQLiteDatabase3 = sQLiteDatabase4;
                iVar3 = iVar5;
            }
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase3;
            z2 = z;
            iVar2 = iVar3;
        }
    }

    public final void a(JSONObject jSONObject, h hVar, i iVar, j jVar, m mVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, HashMap<String, JSONObject> map) {
        boolean z;
        SQLiteDatabase sQLiteDatabase2;
        i iVar2;
        boolean z2;
        SQLiteDatabase sQLiteDatabase3;
        r.a(ca.ca.ca.ca.a.a("packHistoryData, ").append(hVar.d).toString());
        JSONArray jSONArrayA = a(hVar, true, mVar, jVar, sQLiteDatabase);
        hVar.n = jSONArrayA.length() == 0;
        int iA = a(0, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
        JSONArray jSONArrayA2 = a(hVar, map);
        if (hVar.n) {
            z = true;
            sQLiteDatabase2 = sQLiteDatabase;
            iVar2 = iVar;
            iVar.a(jSONObject, a(hVar.d) ? hVar : null, null, null, jSONArrayArr, jArr, jSONArrayA2);
        } else {
            z = true;
            sQLiteDatabase2 = sQLiteDatabase;
            iVar2 = iVar;
            iVar.a(jSONObject, null, mVar, jSONArrayA, jSONArrayArr, jArr, jSONArrayA2);
        }
        a(iVar2, z, sQLiteDatabase2, z);
        int iA2 = iA;
        while (iA2 < e.length) {
            i iVar3 = iVar2;
            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
            boolean z3 = z;
            iA2 = a(iA2, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
            if (a(jArr)) {
                z2 = z3;
                sQLiteDatabase3 = sQLiteDatabase4;
                iVar2 = iVar3;
                iVar.a(jSONObject, null, null, null, jSONArrayArr, jArr, null);
                a(iVar2, z2, sQLiteDatabase3, z2);
            } else {
                z2 = z3;
                sQLiteDatabase3 = sQLiteDatabase4;
                iVar2 = iVar3;
            }
            sQLiteDatabase2 = sQLiteDatabase3;
            z = z2;
        }
    }

    public final void a(JSONObject jSONObject, h hVar, m mVar, j jVar, i iVar, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr, long[] jArr) {
        long[] jArr2;
        SQLiteDatabase sQLiteDatabase2;
        i iVar2;
        boolean z;
        boolean z2;
        SQLiteDatabase sQLiteDatabase3;
        i iVar3;
        r.a("packLostData, " + str);
        hVar.d = str;
        iVar.d = str;
        JSONArray jSONArrayA = a(hVar, false, mVar, jVar, sQLiteDatabase);
        int iA = a(0, sQLiteDatabase, str, false, jSONArrayArr, jArr);
        boolean z3 = true;
        boolean z4 = false;
        hVar.n = jSONArrayA.length() == 0;
        if (a(jArr) || !hVar.n) {
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            iVar2 = iVar;
            iVar.a(jSONObject, null, !hVar.n ? mVar : null, hVar.n ? null : jSONArrayA, jSONArrayArr, jArr, null);
            a(iVar2, false, sQLiteDatabase2, true);
        } else {
            jArr2 = jArr;
            sQLiteDatabase2 = sQLiteDatabase;
            iVar2 = iVar;
        }
        int iA2 = iA;
        while (iA2 < e.length) {
            i iVar4 = iVar2;
            SQLiteDatabase sQLiteDatabase4 = sQLiteDatabase2;
            boolean z5 = z4;
            boolean z6 = z3;
            iA2 = a(iA2, sQLiteDatabase, str, false, jSONArrayArr, jArr);
            if (a(jArr2)) {
                z = z6;
                z2 = z5;
                sQLiteDatabase3 = sQLiteDatabase4;
                iVar3 = iVar4;
                iVar.a(jSONObject, null, null, null, jSONArrayArr, jArr, null);
                a(iVar3, z2, sQLiteDatabase3, z);
            } else {
                z = z6;
                z2 = z5;
                sQLiteDatabase3 = sQLiteDatabase4;
                iVar3 = iVar4;
            }
            sQLiteDatabase2 = sQLiteDatabase3;
            z3 = z;
            iVar2 = iVar3;
            jArr2 = jArr;
            z4 = z2;
        }
    }

    public final boolean a(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, HashMap<String, JSONObject> map) {
        h hVar = (h) d.get(Config.LAUNCH);
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                while (cursorRawQuery.moveToNext()) {
                    hVar.a(cursorRawQuery);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        q.a().a(hVar.a, hVar.d, jSONObject);
                    } catch (Throwable th) {
                        r.a(th);
                    }
                    map.put(hVar.d, jSONObject);
                }
                cursorRawQuery.close();
            } catch (Throwable th2) {
                try {
                    r.a(th2);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th3) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th4) {
                            r.a(th4);
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            r.a(th5);
        }
    }

    public final JSONArray a(h hVar, HashMap<String, JSONObject> map) {
        ca.da.ca.ja.l lVar;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObject = map.get(hVar.d);
        JSONArray jSONArray = null;
        if (jSONObject != null && ((jSONArrayOptJSONArray = jSONObject.optJSONArray("item_impression")) == null || jSONArrayOptJSONArray.length() != 0)) {
            jSONArray = jSONArrayOptJSONArray;
        }
        ca.da.ca.ja.l lVar2 = ca.da.ca.ja.i.a;
        if ((lVar2 != null ? lVar2.a() : false) && jSONArray != null && (lVar = ca.da.ca.ja.i.a) != null) {
            lVar.a("item_impression", jSONArray);
        }
        return jSONArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[Catch: all -> 0x0013, TryCatch #1 {all -> 0x0013, blocks: (B:7:0x000f, B:12:0x001a, B:14:0x001e, B:16:0x0022, B:18:0x002a, B:23:0x0032, B:26:0x003c, B:28:0x0048, B:30:0x004c, B:34:0x0055, B:38:0x005d, B:39:0x006a, B:43:0x0072, B:44:0x007d, B:48:0x0085, B:50:0x0092), top: B:63:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092 A[Catch: all -> 0x0013, TRY_LEAVE, TryCatch #1 {all -> 0x0013, blocks: (B:7:0x000f, B:12:0x001a, B:14:0x001e, B:16:0x0022, B:18:0x002a, B:23:0x0032, B:26:0x003c, B:28:0x0048, B:30:0x004c, B:34:0x0055, B:38:0x005d, B:39:0x006a, B:43:0x0072, B:44:0x007d, B:48:0x0085, B:50:0x0092), top: B:63:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(ca.da.ca.ia.i r12, boolean r13, android.database.sqlite.SQLiteDatabase r14, boolean r15) {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            if (r14 != 0) goto Lc
            ca.da.ca.ia.d$a r14 = r11.b
            android.database.sqlite.SQLiteDatabase r14 = r14.getWritableDatabase()
            r2 = r0
            goto Ld
        Lc:
            r2 = r1
        Ld:
            if (r2 == 0) goto L16
            r14.beginTransaction()     // Catch: java.lang.Throwable -> L13
            goto L16
        L13:
            r12 = move-exception
            goto L98
        L16:
            r3 = 0
            if (r15 == 0) goto L55
            ca.da.ca.da.b r15 = r11.a     // Catch: java.lang.Throwable -> L13
            if (r15 == 0) goto L38
            ca.da.ca.fa.g r15 = r15.c     // Catch: java.lang.Throwable -> L13
            if (r15 == 0) goto L38
            ca.da.ca.da.b r15 = r11.a     // Catch: java.lang.Throwable -> L13
            ca.da.ca.fa.g r15 = r15.c     // Catch: java.lang.Throwable -> L13
            boolean r15 = r15.q     // Catch: java.lang.Throwable -> L13
            if (r15 == 0) goto L38
            ca.da.ca.ia.h r15 = r12.s     // Catch: java.lang.Throwable -> L13
            if (r15 == 0) goto L2f
            goto L30
        L2f:
            r0 = r1
        L30:
            if (r0 != 0) goto L38
            java.lang.String r15 = "DbStore:Filter no launch event."
            ca.da.ca.ja.r.a(r15)     // Catch: java.lang.Throwable -> L13
            goto L55
        L38:
            java.lang.String r15 = "pack"
            r0 = 0
            android.content.ContentValues r1 = r12.a(r0)     // Catch: java.lang.Throwable -> L13
            long r5 = r14.insert(r15, r0, r1)     // Catch: java.lang.Throwable -> L13
            int r15 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r15 >= 0) goto L55
            ca.da.ca.ia.h r12 = r12.s     // Catch: java.lang.Throwable -> L13
            if (r12 == 0) goto L4f
            r11.a(r0)     // Catch: java.lang.Throwable -> L13
        L4f:
            if (r2 == 0) goto L54
            ca.da.ca.ja.t.a(r14)
        L54:
            return
        L55:
            long r0 = r12.p     // Catch: java.lang.Throwable -> L13
            int r15 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r15 <= 0) goto L6a
            java.lang.String r6 = "event"
            java.lang.String r7 = r12.d     // Catch: java.lang.Throwable -> L13
            long r9 = r12.p     // Catch: java.lang.Throwable -> L13
            r5 = r11
            r8 = r13
            java.lang.String r15 = r5.a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L13
            r14.execSQL(r15)     // Catch: java.lang.Throwable -> L13
        L6a:
            long r9 = r12.r     // Catch: java.lang.Throwable -> L13
            int r15 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r15 <= 0) goto L7d
            java.lang.String r6 = "eventv3"
            java.lang.String r7 = r12.d     // Catch: java.lang.Throwable -> L13
            r5 = r11
            r8 = r13
            java.lang.String r15 = r5.a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L13
            r14.execSQL(r15)     // Catch: java.lang.Throwable -> L13
        L7d:
            long r7 = r12.x     // Catch: java.lang.Throwable -> L13
            int r15 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r15 <= 0) goto L90
            java.lang.String r4 = "event_misc"
            java.lang.String r5 = r12.d     // Catch: java.lang.Throwable -> L13
            r3 = r11
            r6 = r13
            java.lang.String r12 = r3.a(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L13
            r14.execSQL(r12)     // Catch: java.lang.Throwable -> L13
        L90:
            if (r2 == 0) goto L95
            r14.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L13
        L95:
            if (r2 == 0) goto La0
            goto L9d
        L98:
            ca.da.ca.ja.r.a(r12)     // Catch: java.lang.Throwable -> La1
            if (r2 == 0) goto La0
        L9d:
            ca.da.ca.ja.t.a(r14)
        La0:
            return
        La1:
            r12 = move-exception
            if (r2 == 0) goto La7
            ca.da.ca.ja.t.a(r14)
        La7:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ia.d.a(ca.da.ca.ia.i, boolean, android.database.sqlite.SQLiteDatabase, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0138 A[PHI: r10 r16 r18 r19
  0x0138: PHI (r10v2 android.database.Cursor) = (r10v3 android.database.Cursor), (r10v11 android.database.Cursor), (r10v11 android.database.Cursor) binds: [B:60:0x0136, B:45:0x00fc, B:50:0x010f] A[DONT_GENERATE, DONT_INLINE]
  0x0138: PHI (r16v2 long) = (r16v3 long), (r16v5 long), (r16v5 long) binds: [B:60:0x0136, B:45:0x00fc, B:50:0x010f] A[DONT_GENERATE, DONT_INLINE]
  0x0138: PHI (r18v3 java.lang.String) = (r18v4 java.lang.String), (r18v7 java.lang.String), (r18v7 java.lang.String) binds: [B:60:0x0136, B:45:0x00fc, B:50:0x010f] A[DONT_GENERATE, DONT_INLINE]
  0x0138: PHI (r19v2 java.lang.String) = (r19v3 java.lang.String), (r19v5 java.lang.String), (r19v5 java.lang.String) binds: [B:60:0x0136, B:45:0x00fc, B:50:0x010f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONArray a(ca.da.ca.ia.h r22, boolean r23, ca.da.ca.ia.m r24, ca.da.ca.ia.j r25, android.database.sqlite.SQLiteDatabase r26) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ia.d.a(ca.da.ca.ia.h, boolean, ca.da.ca.ia.m, ca.da.ca.ia.j, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    public ArrayList<i> a() {
        Cursor cursorRawQuery;
        ArrayList<i> arrayList = new ArrayList<>();
        i iVar = (i) d.get("pack");
        try {
            cursorRawQuery = this.b.getWritableDatabase().rawQuery("SELECT * FROM pack ORDER BY _id DESC LIMIT 8", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    iVar = (i) iVar.m290clone();
                    iVar.a(cursorRawQuery);
                    arrayList.add(iVar);
                } catch (Throwable th) {
                    th = th;
                    try {
                        r.a(th);
                        r.a("queryPack, " + arrayList, (Throwable) null);
                        return arrayList;
                    } finally {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
        }
        r.a("queryPack, " + arrayList, (Throwable) null);
        return arrayList;
    }

    public void a(ArrayList<i> arrayList, ArrayList<i> arrayList2, ArrayList<i> arrayList3) {
        SQLiteDatabase sQLiteDatabase = null;
        r.a("setResult, " + arrayList + ", " + arrayList2, (Throwable) null);
        Iterator<i> it = arrayList2.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.b) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                try {
                    Iterator<i> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        i next2 = it2.next();
                        if (arrayList3.contains(next2)) {
                            a(next2, true, writableDatabase, false);
                        } else {
                            writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(next2.a)});
                        }
                    }
                } catch (Throwable th) {
                    r.a(th);
                }
                Iterator<i> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    i next3 = it3.next();
                    if (next3.s != null) {
                        a((String) null);
                    }
                    if (!arrayList3.contains(next3)) {
                        long j = next3.a;
                        int i = next3.m + 1;
                        next3.m = i;
                        writableDatabase.execSQL("UPDATE pack SET _fail=" + i + " WHERE _id=" + j);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = writableDatabase;
                try {
                    r.a(th);
                    writableDatabase = sQLiteDatabase;
                } finally {
                    t.a(sQLiteDatabase);
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(2:59|3)|(6:(5:57|4|(6:7|(1:9)(1:10)|11|(3:67|13|75)(3:66|14|(3:69|16|74)(3:68|17|(3:70|19|73)(1:72)))|71|5)|65|20)|61|44|(2:47|45)|83|84)|27|63|28|(4:31|(3:77|33|82)(3:76|34|(5:78|36|(1:38)(1:39)|40|81)(1:80))|79|29)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r15 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00de, code lost:
    
        ca.da.ca.ja.r.a(r15);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096 A[Catch: all -> 0x00dd, TryCatch #4 {all -> 0x00dd, blocks: (B:28:0x008c, B:29:0x0090, B:31:0x0096, B:33:0x00a6, B:34:0x00bc, B:36:0x00c6, B:38:0x00d2, B:40:0x00d9), top: B:63:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00eb A[Catch: all -> 0x00fd, LOOP:2: B:45:0x00e5->B:47:0x00eb, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x00fd, blocks: (B:44:0x00e1, B:45:0x00e5, B:47:0x00eb), top: B:61:0x00e1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.ArrayList<ca.da.ca.ia.b> r15) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ia.d.a(java.util.ArrayList):void");
    }
}
