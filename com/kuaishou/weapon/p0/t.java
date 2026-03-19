package com.kuaishou.weapon.p0;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class t {
    private static t E = null;
    public static final String a = "k";
    public static final String b = "p";
    public static final String c = "v";
    public static final String d = "l";
    public static final String e = "i";
    public static final String f = "a";
    public static final String g = "s";
    public static final String h = "n";
    public static final String i = "u";
    public static final String j = "c";
    public static final String k = "r";
    public static final String l = "b";
    public static final String m = "m";
    public static final String n = "el";
    public static final String o = "ail";
    public static final String p = "aps";
    public static final String q = "dp";
    public static final String r = "pcn";
    public static final String s = "pst";
    public static final String t = "d";
    public static final String u = "at";
    public static final String v = "dm";
    public static final String w = "rm";
    public static final String x = "pc";
    public static final String y = "cbl";
    private a B;
    private SQLiteDatabase C;
    private Context D;
    private int z = 1;
    private String A = "create table wp(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,el INTEGER,c INTEGER,r INTEGER,aps INTEGER,dp TEXT,pcn TEXT,b TEXT,m TEXT,ail BLOB,pst INTEGER,d INTEGER,at INTEGER,dm TEXT,rm INTEGER,l TEXT,pc INTEGER DEFAULT -1,a TEXT,cbl INTEGER)";

    class a extends SQLiteOpenHelper {
        public a(Context context) {
            super(context, bi.p, (SQLiteDatabase.CursorFactory) null, t.this.z);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(t.this.A);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i >= 3 || i2 < 3) {
                return;
            }
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE wp ADD COLUMN pc INTEGER  DEFAULT -1");
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused2) {
            }
        }
    }

    private t(Context context) {
        this.D = context.getApplicationContext();
        this.B = new a(context.getApplicationContext());
        try {
            if (context.getFilesDir().getParentFile().exists()) {
                this.C = this.B.getWritableDatabase();
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized t a(Context context) {
        if (E == null) {
            E = new t(context);
        }
        return E;
    }

    public long a(s sVar) {
        long jInsert = 0;
        if (sVar == null) {
            return 0L;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", Integer.valueOf(sVar.b));
        contentValues.put(p, Integer.valueOf(sVar.p));
        contentValues.put("p", sVar.c);
        contentValues.put("a", sVar.e);
        contentValues.put("l", sVar.h);
        contentValues.put("v", sVar.d);
        contentValues.put(q, sVar.n);
        contentValues.put("a", sVar.e);
        contentValues.put(r, sVar.o);
        contentValues.put(s, Long.valueOf(sVar.s));
        contentValues.put(w, Integer.valueOf(sVar.w));
        contentValues.put("at", Integer.valueOf(sVar.q));
        contentValues.put("pc", Integer.valueOf(sVar.x));
        contentValues.put(y, Integer.valueOf(sVar.y ? 1 : 0));
        if (!TextUtils.isEmpty(sVar.j)) {
            contentValues.put(v, sVar.j);
        }
        try {
            if (b(sVar.a)) {
                jInsert = this.C.update(bi.q, contentValues, "k=" + sVar.a, null);
            } else {
                contentValues.put("k", Integer.valueOf(sVar.a));
                jInsert = this.C.insert(bi.q, null, contentValues);
            }
        } catch (Throwable unused) {
        }
        return jInsert;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b4 A[PHI: r1
  0x00b4: PHI (r1v2 android.database.Cursor) = (r1v1 android.database.Cursor), (r1v4 android.database.Cursor) binds: [B:20:0x00b2, B:15:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.kuaishou.weapon.p0.s> a() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.C     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "wp"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lab
            if (r1 == 0) goto La2
        L15:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> Lac
            if (r2 == 0) goto La2
            com.kuaishou.weapon.p0.s r2 = new com.kuaishou.weapon.p0.s     // Catch: java.lang.Throwable -> Lac
            r2.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> Lac
            r2.a = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> Lac
            r2.c = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> Lac
            r2.e = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> Lac
            r2.h = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> Lac
            r2.d = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "pst"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            long r3 = r1.getLong(r3)     // Catch: java.lang.Throwable -> Lac
            r2.s = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "d"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> Lac
            r2.t = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "rm"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> Lac
            r2.w = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "pc"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> Lac
            r2.x = r3     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "cbl"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lac
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> Lac
            r4 = 1
            if (r3 != r4) goto L9a
            goto L9b
        L9a:
            r4 = 0
        L9b:
            r2.y = r4     // Catch: java.lang.Throwable -> Lac
            r0.add(r2)     // Catch: java.lang.Throwable -> Lac
            goto L15
        La2:
            if (r1 == 0) goto Lb7
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb7
            goto Lb4
        Lab:
            r1 = 0
        Lac:
            if (r1 == 0) goto Lb7
            boolean r2 = r1.isClosed()
            if (r2 != 0) goto Lb7
        Lb4:
            r1.close()
        Lb7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.a():java.util.List");
    }

    public s a(int i2) {
        s sVar;
        Cursor cursor = null;
        sVar = null;
        s sVar2 = null;
        try {
            Cursor cursorQuery = this.C.query(bi.q, null, "k=" + i2, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.a = i2;
                            sVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                            sVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                            sVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                            sVar.h = cursorQuery.getString(cursorQuery.getColumnIndex("l"));
                            sVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                            sVar.n = cursorQuery.getString(cursorQuery.getColumnIndex(q));
                            sVar.p = cursorQuery.getInt(cursorQuery.getColumnIndex(p));
                            sVar.o = cursorQuery.getString(cursorQuery.getColumnIndex(r));
                            sVar.q = cursorQuery.getInt(cursorQuery.getColumnIndex("at"));
                            sVar.s = cursorQuery.getLong(cursorQuery.getColumnIndex(s));
                            sVar.t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                            sVar.w = cursorQuery.getInt(cursorQuery.getColumnIndex(w));
                            sVar.j = cursorQuery.getString(cursorQuery.getColumnIndex(v));
                            sVar.x = cursorQuery.getInt(cursorQuery.getColumnIndex("pc"));
                            boolean z = true;
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = cursorQuery;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return sVar2;
            }
            cursorQuery.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[PHI: r8 r10
  0x0034: PHI (r8v2 boolean) = (r8v0 boolean), (r8v4 boolean) binds: [B:15:0x003f, B:10:0x0032] A[DONT_GENERATE, DONT_INLINE]
  0x0034: PHI (r10v3 android.database.Cursor) = (r10v2 android.database.Cursor), (r10v5 android.database.Cursor) binds: [B:15:0x003f, B:10:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(int r10) {
        /*
            r9 = this;
            java.lang.String r1 = "wp"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.C     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            java.lang.String r4 = "k="
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r10 = r3.append(r10)     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = r10.toString()     // Catch: java.lang.Throwable -> L38
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L2c
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L39
            if (r0 <= 0) goto L2c
            r0 = 1
            r8 = r0
        L2c:
            if (r10 == 0) goto L42
            boolean r0 = r10.isClosed()
            if (r0 != 0) goto L42
        L34:
            r10.close()
            goto L42
        L38:
            r10 = 0
        L39:
            if (r10 == 0) goto L42
            boolean r0 = r10.isClosed()
            if (r0 != 0) goto L42
            goto L34
        L42:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.b(int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[PHI: r1 r11
  0x003b: PHI (r1v2 int) = (r1v0 int), (r1v4 int) binds: [B:16:0x0046, B:11:0x0039] A[DONT_GENERATE, DONT_INLINE]
  0x003b: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:16:0x0046, B:11:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L3f
            java.lang.String r3 = "wp"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L3f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L3f
            java.lang.StringBuilder r11 = r5.append(r11)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r5 = r11.toString()     // Catch: java.lang.Throwable -> L3f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3f
            if (r11 == 0) goto L33
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L33
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L40
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L40
            r1 = r0
        L33:
            if (r11 == 0) goto L49
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L49
        L3b:
            r11.close()
            goto L49
        L3f:
            r11 = 0
        L40:
            if (r11 == 0) goto L49
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L49
            goto L3b
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.c(int):int");
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.C.delete(bi.q, "p=?", new String[]{str});
        } catch (Throwable unused) {
        }
    }

    public void b() {
        ArrayList<s> arrayList = new ArrayList();
        for (s sVar : a()) {
            if (!dn.a(sVar.e)) {
                arrayList.add(sVar);
            }
        }
        try {
            r rVarA = r.a();
            for (s sVar2 : arrayList) {
                if (rVarA != null) {
                    rVarA.a(sVar2.e);
                }
                this.C.delete(bi.q, "k=" + sVar2.a, null);
                if (r.b != null && !r.b.contains(Integer.valueOf(sVar2.a))) {
                    dn.c(this.D.getFilesDir().getCanonicalPath() + bi.j + sVar2.a);
                }
                if (rVarA.b() != null && rVarA.b().get(sVar2.c) != null) {
                    dn.c(this.D.getFileStreamPath(sVar2.c).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[PHI: r1 r11
  0x003e: PHI (r1v2 boolean) = (r1v0 boolean), (r1v4 boolean) binds: [B:18:0x0049, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]
  0x003e: PHI (r11v3 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:18:0x0049, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.C     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "wp"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            java.lang.String r6 = "k="
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L42
            java.lang.StringBuilder r11 = r5.append(r11)     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = r11.toString()     // Catch: java.lang.Throwable -> L42
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L42
            if (r11 == 0) goto L36
            boolean r2 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L36
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L43
            int r0 = r11.getInt(r0)     // Catch: java.lang.Throwable -> L43
            r2 = 1
            if (r0 != r2) goto L36
            r1 = r2
        L36:
            if (r11 == 0) goto L4c
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4c
        L3e:
            r11.close()
            goto L4c
        L42:
            r11 = 0
        L43:
            if (r11 == 0) goto L4c
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L4c
            goto L3e
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.t.d(int):boolean");
    }

    public int a(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(i, Integer.valueOf(i3));
            return this.C.update(bi.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void b(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("n", Integer.valueOf(i3));
            this.C.update(bi.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("n", (Integer) 0);
        try {
            this.C.update(bi.q, contentValues, "n=-1", null);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(i, (Integer) 0);
        try {
            this.C.update(bi.q, contentValues, "u=1", null);
        } catch (Throwable unused) {
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pc", Integer.valueOf(i3));
            this.C.update(bi.q, contentValues, "k=" + i2, null);
        } catch (Throwable unused) {
        }
    }

    public s b(String str) {
        s sVar;
        Cursor cursor = null;
        sVar = null;
        s sVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            boolean z = true;
            Cursor cursorQuery = this.C.query(bi.q, null, "p=?", new String[]{str}, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        sVar = new s();
                        try {
                            sVar.a = cursorQuery.getInt(cursorQuery.getColumnIndex("k"));
                            sVar.b = cursorQuery.getInt(cursorQuery.getColumnIndex("n"));
                            sVar.c = cursorQuery.getString(cursorQuery.getColumnIndex("p"));
                            sVar.e = cursorQuery.getString(cursorQuery.getColumnIndex("a"));
                            sVar.h = cursorQuery.getString(cursorQuery.getColumnIndex("l"));
                            sVar.d = cursorQuery.getString(cursorQuery.getColumnIndex("v"));
                            sVar.n = cursorQuery.getString(cursorQuery.getColumnIndex(q));
                            sVar.p = cursorQuery.getInt(cursorQuery.getColumnIndex(p));
                            sVar.o = cursorQuery.getString(cursorQuery.getColumnIndex(r));
                            sVar.q = cursorQuery.getInt(cursorQuery.getColumnIndex("at"));
                            sVar.s = cursorQuery.getLong(cursorQuery.getColumnIndex(s));
                            sVar.t = cursorQuery.getInt(cursorQuery.getColumnIndex("d"));
                            sVar.w = cursorQuery.getInt(cursorQuery.getColumnIndex(w));
                            sVar.j = cursorQuery.getString(cursorQuery.getColumnIndex(v));
                            sVar.x = cursorQuery.getInt(cursorQuery.getColumnIndex("pc"));
                            if (cursorQuery.getInt(cursorQuery.getColumnIndex(y)) != 1) {
                                z = false;
                            }
                            sVar.y = z;
                            sVar2 = sVar;
                        } catch (Throwable unused) {
                            cursor = cursorQuery;
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return sVar;
                        }
                    }
                } catch (Throwable unused2) {
                    sVar = null;
                }
            }
            if (cursorQuery == null || cursorQuery.isClosed()) {
                return sVar2;
            }
            cursorQuery.close();
            return sVar2;
        } catch (Throwable unused3) {
            sVar = null;
        }
    }
}
