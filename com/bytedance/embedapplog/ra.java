package com.bytedance.embedapplog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ra {
    private static final to[] an;
    static final hc[] b;
    public static final int[] d = {1};
    static final HashMap<String, to> hc = new HashMap<>();
    private final de c;
    private String h;
    private final d u;

    static {
        d(new i());
        d(new dz(true));
        d(new ey());
        d(new nr());
        to[] toVarArr = {new rw(), new nw(null, false, null), new ia("", new JSONObject())};
        an = toVarArr;
        for (int i = 0; i < 3; i++) {
            d(toVarArr[i]);
        }
        b = new hc[]{new hc(), new hc(), new hc()};
    }

    private String d(String str, boolean z) {
        return "SELECT * FROM page WHERE session_id" + (z ? "='" : "!='") + str + "' ORDER BY " + (z ? "session_id," : "") + "duration DESC LIMIT 500";
    }

    private String hc(String str, boolean z) {
        return "DELETE FROM page WHERE session_id" + (z ? "='" : "!='") + str + "'";
    }

    private String d(to toVar, String str, boolean z, int i, int i2) {
        return "SELECT * FROM " + toVar.c() + " WHERE session_id" + (z ? "='" : "!='") + str + "' AND event_type='" + i2 + "' ORDER BY _id LIMIT " + i;
    }

    private String d(String str, int i, String str2, boolean z, long j) {
        return "DELETE FROM " + str + " WHERE session_id" + (z ? "='" : "!='") + str2 + "' AND event_type='" + i + "' AND _id<=" + j;
    }

    private String d(long j, int i) {
        return "UPDATE pack SET _fail=" + i + " WHERE _id=" + j;
    }

    public ra(de deVar) {
        this.u = new d(deVar.hc(), "bd_embed_tea_agent.db", null, 30);
        this.c = deVar;
    }

    private static void d(to toVar) {
        hc.put(toVar.c(), toVar);
    }

    static class hc {
        int b;
        String d;
        int hc;

        hc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void hc() {
            for (hc hcVar : ra.b) {
                hcVar.d = "";
                hcVar.hc = 0;
                hcVar.b = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(to toVar) {
            String strTt = toVar.tt();
            if (strTt == null || strTt.length() <= this.hc) {
                return;
            }
            this.d = toVar.gb();
            this.hc = strTt.length();
        }

        public String toString() {
            return new StringBuilder(this.b).append("-").append(this.d).append("-").append(this.hc).toString();
        }
    }

    private boolean d(String str) {
        um.d("needLaunch, " + this.h + ", " + str);
        if (TextUtils.equals(str, this.h)) {
            return false;
        }
        this.h = str;
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:106|4|5|129|6|125|7|119|8|(9:9|10|(6:107|12|(7:(1:15)|123|16|17|115|18|19)(10:22|102|23|24|(2:26|27)|30|31|(2:33|34)|35|36)|37|117|38)(1:131)|74|121|79|(2:109|81)|86|87)|43|(1:47)|113|51|(6:53|(3:55|111|56)|58|(2:104|60)|65|87)|57|58|(0)|65|87) */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0140 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0165 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.ArrayList<com.bytedance.embedapplog.nr> d(org.json.JSONObject r31) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ra.d(org.json.JSONObject):java.util.ArrayList");
    }

    private void d(JSONObject jSONObject, boolean z, nr nrVar, SQLiteDatabase sQLiteDatabase) {
        for (int i : d) {
            JSONArray[] jSONArrayArr = new JSONArray[3];
            long[] jArr = new long[3];
            int iD = d(0, sQLiteDatabase, nrVar.c, z, i, jSONArrayArr, jArr);
            if (d(jArr)) {
                int i2 = iD;
                while (true) {
                    nrVar.d(jSONObject, null, null, null, jSONArrayArr, jArr, i);
                    d(nrVar, z, sQLiteDatabase, true);
                    int iD2 = i2;
                    while (iD2 < an.length) {
                        iD2 = d(iD2, sQLiteDatabase, nrVar.c, z, i, jSONArrayArr, jArr);
                        if (d(jArr)) {
                            break;
                        }
                    }
                    i2 = iD2;
                }
            }
        }
    }

    private JSONObject d(dz dzVar, JSONObject jSONObject) throws JSONException {
        if (TextUtils.equals(dzVar.uo, this.c.u().b()) && dzVar.mq == this.c.u().hc()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            fv.hc(jSONObject2, jSONObject);
            jSONObject2.put("app_version", dzVar.uo);
            jSONObject2.put("version_code", dzVar.mq);
            return jSONObject2;
        } catch (JSONException e) {
            um.hc(e);
            return jSONObject;
        }
    }

    private void d(JSONObject jSONObject, dz dzVar, nr nrVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList<nr> arrayList) {
        SQLiteDatabase sQLiteDatabase2;
        JSONArray[] jSONArrayArr2;
        long[] jArr2;
        ra raVar;
        JSONObject jSONObject2;
        nr nrVar2;
        int iD;
        um.d("packCurrentData, " + dzVar.c);
        boolean zD = d(dzVar.c);
        int iD2 = d(0, sQLiteDatabase, dzVar.c, true, 0, jSONArrayArr, jArr);
        if (zD || d(jArr)) {
            nrVar.d(jSONObject, zD ? dzVar : null, null, null, jSONArrayArr, jArr, 0);
            if (iD2 >= an.length) {
                nr nrVar3 = (nr) nrVar.clone();
                nrVar3.tc();
                arrayList.add(nrVar3);
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                iD = iD2;
                jArr2 = jArr;
                raVar = this;
                jSONObject2 = jSONObject;
                nrVar2 = nrVar;
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                jSONArrayArr2 = jSONArrayArr;
                jArr2 = jArr;
                raVar = this;
                jSONObject2 = jSONObject;
                nrVar2 = nrVar;
                raVar.d(nrVar2, true, sQLiteDatabase2, true);
                iD = iD2;
            }
        } else {
            sQLiteDatabase2 = sQLiteDatabase;
            jSONArrayArr2 = jSONArrayArr;
            iD = iD2;
            jArr2 = jArr;
            raVar = this;
            jSONObject2 = jSONObject;
            nrVar2 = nrVar;
        }
        while (iD < an.length) {
            iD = raVar.d(iD, sQLiteDatabase2, dzVar.c, true, 0, jSONArrayArr2, jArr2);
            if (raVar.d(jArr2)) {
                nrVar2.d(jSONObject2, raVar.d(dzVar.c) ? dzVar : null, null, null, jSONArrayArr2, jArr2, 0);
                raVar.d(nrVar2, true, sQLiteDatabase2, true);
                iD = iD;
            }
        }
    }

    private void d(JSONObject jSONObject, dz dzVar, nr nrVar, i iVar, ey eyVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr) {
        boolean z;
        boolean z2;
        um.d("packHistoryData, " + dzVar.c);
        JSONArray jSONArrayD = d(dzVar, true, eyVar, iVar, sQLiteDatabase);
        dzVar.k = jSONArrayD.length() == 0;
        int iD = d(0, sQLiteDatabase, dzVar.c, true, 0, jSONArrayArr, jArr);
        if (dzVar.k) {
            nrVar.d(jSONObject, d(dzVar.c) ? dzVar : null, null, null, jSONArrayArr, jArr, 0);
            z = true;
        } else {
            z = true;
            nrVar.d(jSONObject, null, eyVar, jSONArrayD, jSONArrayArr, jArr, 0);
        }
        nr nrVar2 = nrVar;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        while (true) {
            d(nrVar2, z, sQLiteDatabase2, z);
            int iD2 = iD;
            while (iD2 < an.length) {
                z2 = z;
                iD2 = d(iD2, sQLiteDatabase, dzVar.c, true, 0, jSONArrayArr, jArr);
                if (d(jArr)) {
                    break;
                } else {
                    z = z2;
                }
            }
            return;
            nrVar.d(jSONObject, null, null, null, jSONArrayArr, jArr, 0);
            nrVar2 = nrVar;
            sQLiteDatabase2 = sQLiteDatabase;
            iD = iD2;
            z = z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(org.json.JSONObject r17, com.bytedance.embedapplog.dz r18, com.bytedance.embedapplog.ey r19, com.bytedance.embedapplog.i r20, com.bytedance.embedapplog.nr r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, org.json.JSONArray[] r24, long[] r25) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ra.d(org.json.JSONObject, com.bytedance.embedapplog.dz, com.bytedance.embedapplog.ey, com.bytedance.embedapplog.i, com.bytedance.embedapplog.nr, android.database.sqlite.SQLiteDatabase, java.lang.String, org.json.JSONArray[], long[]):void");
    }

    private boolean d(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public void d(nr nrVar, boolean z, SQLiteDatabase sQLiteDatabase, boolean z2) {
        boolean z3;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = this.u.getWritableDatabase();
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Throwable th) {
                try {
                    um.hc(th);
                    if (z3) {
                        fv.d(sQLiteDatabase);
                        return;
                    }
                    return;
                } finally {
                    if (z3) {
                        fv.d(sQLiteDatabase);
                    }
                }
            }
        }
        if (z2 && sQLiteDatabase.insert("pack", null, nrVar.hc((ContentValues) null)) < 0) {
            if (nrVar.rf != null) {
                d((String) null);
            }
            if (z3) {
                return;
            } else {
                return;
            }
        }
        if (nrVar.cb > 0) {
            sQLiteDatabase.execSQL(d(NotificationCompat.CATEGORY_EVENT, nrVar.tc, nrVar.c, z, nrVar.cb));
        }
        if (nrVar.yo > 0) {
            sQLiteDatabase.execSQL(d("eventv3", nrVar.tc, nrVar.c, z, nrVar.yo));
        }
        if (nrVar.sy > 0) {
            sQLiteDatabase.execSQL(d("event_misc", nrVar.tc, nrVar.c, z, nrVar.sy));
        }
        if (z3) {
            sQLiteDatabase.setTransactionSuccessful();
        }
        if (z3) {
            fv.d(sQLiteDatabase);
        }
    }

    private int d(int i, SQLiteDatabase sQLiteDatabase, String str, boolean z, int i2, JSONArray[] jSONArrayArr, long[] jArr) {
        hc.hc();
        int i3 = 0;
        while (i3 < i) {
            jSONArrayArr[i3] = null;
            jArr[i3] = 0;
            i3++;
        }
        int i4 = i3;
        int i5 = 200;
        while (i5 > 0 && i4 < an.length) {
            d(sQLiteDatabase, str, i5, i4, z, jSONArrayArr, jArr, i2);
            int length = jSONArrayArr[i4].length();
            i5 -= length;
            b[i4].b = length;
            if (i5 > 0) {
                i4++;
            }
        }
        for (int i6 = i4 + 1; i6 < jSONArrayArr.length; i6++) {
            jSONArrayArr[i6] = null;
            jArr[i6] = 0;
        }
        return i4;
    }

    private void d(SQLiteDatabase sQLiteDatabase, String str, int i, int i2, boolean z, JSONArray[] jSONArrayArr, long[] jArr, int i3) {
        to toVar = an[i2];
        JSONArray jSONArray = new JSONArray();
        Cursor cursor = null;
        long j = 0;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery(d(toVar, str, z, i, i3), null);
            for (int i4 = 0; cursorRawQuery.moveToNext() && i4 <= 200; i4++) {
                try {
                    toVar.d(cursorRawQuery);
                    b[i2].d(toVar);
                    if (um.hc) {
                        um.d("queryEvent, ".concat(String.valueOf(toVar)), null);
                    }
                    jSONArray.put(toVar.an());
                    if (toVar.d > j) {
                        j = toVar.d;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    try {
                        um.hc(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        jSONArrayArr[i2] = jSONArray;
                        jArr[i2] = j;
                    } finally {
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
        jSONArrayArr[i2] = jSONArray;
        jArr[i2] = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00de A[PHI: r12 r16 r18 r19
  0x00de: PHI (r12v2 android.database.Cursor) = (r12v3 android.database.Cursor), (r12v6 android.database.Cursor) binds: [B:48:0x00dc, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r16v2 long) = (r16v3 long), (r16v5 long) binds: [B:48:0x00dc, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r18v3 java.lang.String) = (r18v4 java.lang.String), (r18v7 java.lang.String) binds: [B:48:0x00dc, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00de: PHI (r19v2 java.lang.String) = (r19v3 java.lang.String), (r19v5 java.lang.String) binds: [B:48:0x00dc, B:38:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONArray d(com.bytedance.embedapplog.dz r22, boolean r23, com.bytedance.embedapplog.ey r24, com.bytedance.embedapplog.i r25, android.database.sqlite.SQLiteDatabase r26) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ra.d(com.bytedance.embedapplog.dz, boolean, com.bytedance.embedapplog.ey, com.bytedance.embedapplog.i, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[DONT_GENERATE, PHI: r3
  0x003b: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v6 android.database.Cursor) binds: [B:15:0x0039, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.ArrayList<com.bytedance.embedapplog.nr> d() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashMap<java.lang.String, com.bytedance.embedapplog.to> r1 = com.bytedance.embedapplog.ra.hc
            java.lang.String r2 = "pack"
            java.lang.Object r1 = r1.get(r2)
            com.bytedance.embedapplog.nr r1 = (com.bytedance.embedapplog.nr) r1
            r2 = 0
            com.bytedance.embedapplog.ra$d r3 = r5.u     // Catch: java.lang.Throwable -> L34
            android.database.sqlite.SQLiteDatabase r3 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> L34
            java.lang.String r4 = "SELECT * FROM pack ORDER BY _id DESC LIMIT 8"
            android.database.Cursor r3 = r3.rawQuery(r4, r2)     // Catch: java.lang.Throwable -> L34
        L1c:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L32
            if (r4 == 0) goto L2f
            com.bytedance.embedapplog.to r1 = r1.clone()     // Catch: java.lang.Throwable -> L32
            com.bytedance.embedapplog.nr r1 = (com.bytedance.embedapplog.nr) r1     // Catch: java.lang.Throwable -> L32
            r1.d(r3)     // Catch: java.lang.Throwable -> L32
            r0.add(r1)     // Catch: java.lang.Throwable -> L32
            goto L1c
        L2f:
            if (r3 == 0) goto L3e
            goto L3b
        L32:
            r1 = move-exception
            goto L36
        L34:
            r1 = move-exception
            r3 = r2
        L36:
            com.bytedance.embedapplog.um.hc(r1)     // Catch: java.lang.Throwable -> L4c
            if (r3 == 0) goto L3e
        L3b:
            r3.close()
        L3e:
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "queryPack, "
            java.lang.String r1 = r3.concat(r1)
            com.bytedance.embedapplog.um.d(r1, r2)
            return r0
        L4c:
            r0 = move-exception
            if (r3 == 0) goto L52
            r3.close()
        L52:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ra.d():java.util.ArrayList");
    }

    public void d(ArrayList<nr> arrayList, ArrayList<nr> arrayList2, ArrayList<nr> arrayList3) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        um.d("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator<nr> it = arrayList2.iterator();
        while (it.hasNext()) {
            nr next = it.next();
            if (!arrayList3.contains(next) && Math.abs(System.currentTimeMillis() - next.hc) > 864000000) {
                arrayList.add(next);
                it.remove();
            }
        }
        try {
            writableDatabase = this.u.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            try {
                Iterator<nr> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    nr next2 = it2.next();
                    if (arrayList3.contains(next2)) {
                        d(next2, true, writableDatabase, false);
                    } else {
                        writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(next2.d)});
                    }
                }
            } catch (Throwable th2) {
                um.hc(th2);
            }
            Iterator<nr> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                nr next3 = it3.next();
                if (next3.rf != null) {
                    d((String) null);
                }
                if (!arrayList3.contains(next3)) {
                    long j = next3.d;
                    int i = next3.uo + 1;
                    next3.uo = i;
                    writableDatabase.execSQL(d(j, i));
                }
            }
            writableDatabase.setTransactionSuccessful();
            fv.d(writableDatabase);
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = writableDatabase;
            try {
                um.hc(th);
            } finally {
                fv.d(sQLiteDatabase);
            }
        }
    }

    public void d(ArrayList<to> arrayList) {
        SQLiteDatabase writableDatabase;
        ArrayList arrayList2 = new ArrayList(4);
        ArrayList arrayList3 = new ArrayList(4);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.u.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            Iterator<to> it = arrayList.iterator();
            ContentValues contentValuesHc = null;
            while (it.hasNext()) {
                to next = it.next();
                String strC = next.c();
                contentValuesHc = next.hc(contentValuesHc);
                next.d = writableDatabase.insert(strC, null, contentValuesHc);
                if (NotificationCompat.CATEGORY_EVENT.equals(next.c())) {
                    arrayList3.add(next);
                } else if ("eventv3".equals(next.c())) {
                    arrayList3.add(next);
                } else if (next instanceof dz) {
                    arrayList2.add((dz) next);
                }
            }
            writableDatabase.setTransactionSuccessful();
            fv.d(writableDatabase);
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                um.hc(th);
            } finally {
                fv.d(sQLiteDatabase);
            }
        }
    }

    static class d extends SQLiteOpenHelper {
        d(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super((Context) new com.bytedance.sdk.openadsdk.api.plugin.d(context), str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<to> it = ra.hc.values().iterator();
                while (it.hasNext()) {
                    String strB = it.next().b();
                    if (strB != null) {
                        sQLiteDatabase.execSQL(strB);
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    um.hc(th);
                } finally {
                    fv.d(sQLiteDatabase);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            um.c("onUpgrade, " + i + ", " + i2, null);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<to> it = ra.hc.values().iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + it.next().c());
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                try {
                    fv.d(sQLiteDatabase);
                    onCreate(sQLiteDatabase);
                } catch (Throwable th) {
                }
            }
            fv.d(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onUpgrade(sQLiteDatabase, i, i2);
        }
    }
}
