package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.bdtracker.l0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class z3 {
    public final x3 a;
    public final e0 b;
    public final y3 c;

    public z3(e0 e0Var, String str) {
        x3 x3Var = new x3(e0Var, str, null, 51);
        this.a = x3Var;
        this.b = e0Var;
        this.c = new y3(e0Var, x3Var);
    }

    public final List<Long> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("local_time_ms")) {
                    try {
                        arrayList.add(Long.valueOf(jSONObjectOptJSONObject.getLong("local_time_ms")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void a() {
        SQLiteDatabase writableDatabase;
        Throwable th;
        try {
            writableDatabase = this.a.getWritableDatabase();
        } catch (Throwable th2) {
            writableDatabase = null;
            th = th2;
        }
        try {
            writableDatabase.beginTransaction();
            for (t3 t3Var : t3.j().values()) {
                if (l0.b.d(t3Var.a())) {
                    writableDatabase.delete(t3Var.f(), null, null);
                }
            }
            writableDatabase.setTransactionSuccessful();
            l0.b.a(writableDatabase);
        } catch (Throwable th3) {
            th = th3;
            try {
                this.b.d.D.error(5, "Clear database failed", th, new Object[0]);
                l2.a(this.b.q, th);
            } finally {
                if (writableDatabase != null) {
                    l0.b.a(writableDatabase);
                }
            }
        }
    }

    public void a(JSONObject jSONObject) {
        d(a(jSONObject.optJSONArray(Config.LAUNCH)));
        d(a(jSONObject.optJSONArray("terminate")));
        d(a(jSONObject.optJSONArray("event_v3")));
    }

    public synchronized void b(List<c4> list) {
        if (list == null) {
            return;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (c4 c4Var : list) {
                if (c4Var.A != 0 && (c4Var.A <= 0 || Math.abs(System.currentTimeMillis() - c4Var.c) <= 2592000000L)) {
                    int i = c4Var.A;
                    if (i > 0) {
                        writableDatabase.execSQL("UPDATE packV2 SET _fail= ? WHERE _id= ?", new Object[]{Integer.valueOf(i), Long.valueOf(c4Var.b)});
                    }
                }
                writableDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(c4Var.b)});
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final List<d4> c(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM page WHERE _app_id= ? and user_unique_id is null order by duration desc", new String[]{str}) : sQLiteDatabase.rawQuery("SELECT * FROM page WHERE _app_id= ? and user_unique_id = ? order by duration desc", new String[]{str, str2});
            while (cursorRawQuery.moveToNext()) {
                d4 d4Var = new d4();
                d4Var.a(cursorRawQuery);
                arrayList.add(d4Var);
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query pages by userId:{} failed", th, str2);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public final void d(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (Long l : list) {
            i2 i2Var = this.b.q;
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (i2Var != null) {
                ((n2) i2Var).a(new x2(jLongValue));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.bytedance.bdtracker.g4> a(java.util.List<com.bytedance.bdtracker.d4> r19, java.util.List<com.bytedance.bdtracker.d4> r20) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.z3.a(java.util.List, java.util.List):java.util.List");
    }

    public synchronized void b(String str, JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        List<h4> listA;
        this.b.d.D.debug(5, "Pack trace events for appId:{} start...", str);
        try {
            writableDatabase = this.a.getWritableDatabase();
            listA = a(writableDatabase, str);
        } catch (Throwable th) {
            this.b.d.D.error(5, "Pack trace events for appId:{} failed", th, str);
            l2.a(this.b.q, th);
        }
        if (listA.isEmpty()) {
            return;
        }
        c4 c4Var = new c4();
        JSONObject jSONObject2 = new JSONObject();
        l0.b.a(jSONObject2, jSONObject);
        jSONObject2.remove("user_unique_id");
        jSONObject2.remove("user_unique_id_type");
        c4Var.y = jSONObject2;
        c4Var.m = str;
        c4Var.x = listA;
        a(writableDatabase, c4Var);
    }

    public synchronized void c(List<e4> list) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            Iterator<e4> it = list.iterator();
            ContentValues contentValuesA = null;
            while (it.hasNext()) {
                contentValuesA = it.next().a(contentValuesA);
                writableDatabase.insert("profile", null, contentValuesA);
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                this.b.d.D.error(5, "Save profiles failed", th, new Object[0]);
                l2.a(this.b.q, th);
                writableDatabase = sQLiteDatabase;
            } finally {
                l0.b.a(sQLiteDatabase);
            }
        }
    }

    public final List<a4> b(SQLiteDatabase sQLiteDatabase, String str, String str2, int i) {
        if (i <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        boolean z = false;
        try {
            cursorRawQuery = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM eventv3 WHERE _app_id= ? and user_unique_id is null limit 0, ?", new String[]{str, String.valueOf(i)}) : sQLiteDatabase.rawQuery("SELECT * FROM eventv3 WHERE _app_id= ? and user_unique_id = ? limit 0, ?", new String[]{str, str2, String.valueOf(i)});
            while (cursorRawQuery.moveToNext()) {
                a4 a4Var = new a4();
                a4Var.a(cursorRawQuery);
                arrayList.add(a4Var);
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query v3 event by uuid:{} for appId:{} failed", th, str2, str);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public final int a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT count(1) FROM " + str + " WHERE " + str2, strArr);
        } catch (Throwable th) {
            try {
                this.b.d.D.error(5, "Count table:{} failed", th, str);
                l2.a(this.b.q, th);
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (cursorRawQuery.moveToNext()) {
            return cursorRawQuery.getInt(0);
        }
        return 0;
    }

    public final List<b4> b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM launch WHERE _app_id= ? and user_unique_id is null", new String[]{str}) : sQLiteDatabase.rawQuery("SELECT * FROM launch WHERE _app_id= ? and user_unique_id = ?", new String[]{str, str2});
            while (cursorRawQuery.moveToNext()) {
                b4 b4Var = new b4();
                b4Var.a(cursorRawQuery);
                arrayList.add(b4Var);
                b4Var.u = !(l0.b.d(b4Var.e) && a(sQLiteDatabase, "page", "session_id = ? LIMIT 1", new String[]{b4Var.e}) > 0);
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query launch by uuid:{} for appId:{} failed", th, str2, str);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public synchronized void a(List<e4> list) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransaction();
            Iterator<e4> it = list.iterator();
            while (it.hasNext()) {
                writableDatabase.delete("profile", "_id=?", new String[]{String.valueOf(it.next().b)});
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int b(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            com.bytedance.bdtracker.x3 r2 = r7.a     // Catch: java.lang.Throwable -> L29
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L29
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L29
            r3[r0] = r8     // Catch: java.lang.Throwable -> L29
            java.lang.String r8 = "SELECT * FROM packV2 WHERE _app_id= ? ORDER BY _id DESC LIMIT 8"
            android.database.Cursor r1 = r2.rawQuery(r8, r3)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L19
            com.bytedance.bdtracker.l0.b.a(r1)
            return r0
        L19:
            r8 = r0
        L1a:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L27
            if (r2 == 0) goto L23
            int r8 = r8 + 1
            goto L1a
        L23:
            com.bytedance.bdtracker.l0.b.a(r1)
            goto L46
        L27:
            r2 = move-exception
            goto L2b
        L29:
            r2 = move-exception
            r8 = r0
        L2b:
            boolean r3 = r2 instanceof android.database.sqlite.SQLiteBlobTooBigException     // Catch: java.lang.Throwable -> L4c
            com.bytedance.bdtracker.e0 r4 = r7.b     // Catch: java.lang.Throwable -> L4c
            com.bytedance.bdtracker.d r4 = r4.d     // Catch: java.lang.Throwable -> L4c
            com.bytedance.applog.log.IAppLogLogger r4 = r4.D     // Catch: java.lang.Throwable -> L4c
            r5 = 5
            java.lang.String r6 = "Query event packs count failed"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4c
            r4.error(r5, r6, r2, r0)     // Catch: java.lang.Throwable -> L4c
            com.bytedance.bdtracker.e0 r0 = r7.b     // Catch: java.lang.Throwable -> L4c
            com.bytedance.bdtracker.i2 r0 = r0.q     // Catch: java.lang.Throwable -> L4c
            com.bytedance.bdtracker.l2.a(r0, r2)     // Catch: java.lang.Throwable -> L4c
            com.bytedance.bdtracker.l0.b.a(r1)
            r0 = r3
        L46:
            if (r0 == 0) goto L4b
            r7.b()
        L4b:
            return r8
        L4c:
            r8 = move-exception
            com.bytedance.bdtracker.l0.b.a(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.z3.b(java.lang.String):int");
    }

    public final Set<String> a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        HashSet hashSet = new HashSet();
        boolean z = false;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT `user_unique_id` FROM " + str + " WHERE _app_id= ?", new String[]{str2});
            while (cursorRawQuery.moveToNext()) {
                hashSet.add(cursorRawQuery.getString(0));
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query uuid set from table:{} for appId:{} failed", th, str, str2);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return hashSet;
    }

    public synchronized boolean a(String str, JSONObject jSONObject) {
        SQLiteDatabase readableDatabase;
        List<g4> list;
        List<w3> list2;
        this.b.d.D.debug(5, "Pack events for appId:{} start...", str);
        try {
            readableDatabase = this.a.getReadableDatabase();
        } catch (Throwable th) {
            this.b.d.D.error(5, "Open db failed", th, new Object[0]);
            l2.a(this.b.q, th);
            readableDatabase = null;
        }
        HashSet<String> hashSet = new HashSet();
        if (readableDatabase != null) {
            hashSet.addAll(a(readableDatabase, Config.LAUNCH, str));
            hashSet.addAll(a(readableDatabase, "page", str));
            hashSet.addAll(a(readableDatabase, "eventv3", str));
            hashSet.addAll(a(readableDatabase, "custom_event", str));
        }
        if (hashSet.isEmpty()) {
            return false;
        }
        HashSet hashSet2 = new HashSet();
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            for (String str2 : hashSet) {
                c4 c4Var = new c4();
                c4Var.m = str;
                JSONObject jSONObject2 = new JSONObject();
                l0.b.a(jSONObject2, jSONObject);
                jSONObject2.remove("ssid");
                jSONObject2.put("user_unique_id", l0.b.c(str2) ? JSONObject.NULL : str2);
                c4Var.y = jSONObject2;
                c4Var.v = b(writableDatabase, str, str2);
                List<d4> listC = c(writableDatabase, str, str2);
                ArrayList arrayList = new ArrayList();
                List<g4> listA = a(listC, arrayList);
                c4Var.u = arrayList;
                c4Var.w = listA;
                c4Var.t = a(writableDatabase, str, str2, c4Var.k());
                int iK = c4Var.k();
                List<w3> list3 = c4Var.t;
                if (list3 != null) {
                    iK -= list3.size();
                }
                c4Var.s = b(writableDatabase, str, str2, iK);
                List<b4> list4 = c4Var.v;
                if (!((list4 == null || list4.isEmpty()) && ((list = c4Var.w) == null || list.isEmpty()) && c4Var.a((Set<String>) null).length() == 0 && ((list2 = c4Var.t) == null || list2.isEmpty()))) {
                    c4Var.m();
                    c4Var.n();
                    if (!this.b.a(jSONObject2)) {
                        this.b.d.D.warn(5, "Register to get ssid by temp header failed.", new Object[0]);
                    } else {
                        this.b.d.D.debug(5, c4Var.toString(), new Object[0]);
                        hashSet2.add(str2);
                        a(writableDatabase, c4Var);
                    }
                }
            }
        } catch (Throwable th2) {
            this.b.d.D.warn(5, "Pack events for appId:{} failed", th2, str);
            l2.a(this.b.q, th2);
        }
        return !hashSet2.isEmpty();
    }

    public final void b() {
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(null);
            if (i > 0 && i <= 8388608) {
                int i2 = i * 2;
                declaredField.setInt(null, i2);
                this.b.d.D.debug("tryIncreaseCursorWindowSize set new curCursorWindowSize = " + i2, new Object[0]);
            } else {
                this.b.d.D.debug("tryIncreaseCursorWindowSize curCursorWindowSize invalid = " + i, new Object[0]);
            }
        } catch (Throwable th) {
            this.b.d.D.error(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
        }
    }

    public final List<w3> a(SQLiteDatabase sQLiteDatabase, String str, String str2, int i) {
        if (i <= 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        boolean z = false;
        try {
            cursorRawQuery = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM custom_event WHERE _app_id= ? and user_unique_id is null limit 0, ?", new String[]{str, String.valueOf(i)}) : sQLiteDatabase.rawQuery("SELECT * FROM custom_event WHERE _app_id= ? and user_unique_id = ? limit 0, ?", new String[]{str, str2, String.valueOf(i)});
            while (cursorRawQuery.moveToNext()) {
                w3 w3Var = new w3();
                w3Var.a(cursorRawQuery);
                arrayList.add(w3Var);
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query custom event by uuid:{} for appId:{} failed", th, str2, str);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public synchronized Map<String, List<e4>> a(String str) {
        HashMap map;
        map = new HashMap();
        Cursor cursorRawQuery = null;
        boolean z = false;
        try {
            cursorRawQuery = this.a.getWritableDatabase().rawQuery("SELECT * FROM profile WHERE _app_id=? ORDER BY _id DESC LIMIT 200", new String[]{str});
            while (cursorRawQuery.moveToNext()) {
                e4 e4Var = new e4();
                e4Var.a(cursorRawQuery);
                String strA = l0.b.a((Object) e4Var.g);
                List arrayList = (List) map.get(strA);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(strA, arrayList);
                }
                arrayList.add(e4Var);
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query profiles for appId:{} failed", th, str);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return map;
    }

    public final List<h4> a(SQLiteDatabase sQLiteDatabase, String str) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM trace WHERE _app_id= ? ", new String[]{str});
            while (cursorRawQuery.moveToNext()) {
                h4 h4Var = new h4();
                h4Var.a(cursorRawQuery);
                arrayList.add(h4Var);
            }
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query trace for appId:{} failed", th, str);
                l2.a(this.b.q, th);
                l0.b.a(cursorRawQuery);
                z = z2;
            } finally {
                l0.b.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public final synchronized void a(SQLiteDatabase sQLiteDatabase, c4 c4Var) {
        try {
            sQLiteDatabase.beginTransaction();
        } finally {
            try {
            } finally {
            }
        }
        if (sQLiteDatabase.insert("packV2", null, c4Var.a((ContentValues) null)) < 0) {
            return;
        }
        List<b4> list = c4Var.v;
        if (list != null) {
            for (b4 b4Var : list) {
                sQLiteDatabase.delete(Config.LAUNCH, "_id = ?", new String[]{String.valueOf(b4Var.b)});
                LogUtils.sendObject("event_pack", b4Var);
            }
        }
        List<d4> list2 = c4Var.u;
        if (list2 != null) {
            for (d4 d4Var : list2) {
                sQLiteDatabase.delete("page", "session_id = ? and page_key = ?", new String[]{String.valueOf(d4Var.e), l0.b.a((Object) d4Var.u)});
                LogUtils.sendObject("event_pack", d4Var);
            }
        }
        List<w3> list3 = c4Var.t;
        if (list3 != null) {
            for (w3 w3Var : list3) {
                sQLiteDatabase.delete("custom_event", "_id = ?", new String[]{String.valueOf(w3Var.b)});
                LogUtils.sendObject("event_pack", w3Var);
            }
        }
        List<a4> list4 = c4Var.s;
        if (list4 != null) {
            for (a4 a4Var : list4) {
                sQLiteDatabase.delete("eventv3", "_id = ?", new String[]{String.valueOf(a4Var.b)});
                LogUtils.sendObject("event_pack", a4Var);
            }
        }
        if (c4Var.x != null) {
            sQLiteDatabase.delete(Config.TRACE_PART, "_app_id= ? ", new String[]{String.valueOf(c4Var.m)});
            Iterator<h4> it = c4Var.x.iterator();
            while (it.hasNext()) {
                LogUtils.sendObject("event_pack", it.next());
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public synchronized void a(String str, String str2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.execSQL("UPDATE launch SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE page SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE eventv3 SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE profile SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE trace SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }
}
