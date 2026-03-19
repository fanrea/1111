package com.kwad.components.core.c;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static volatile a Pi;
    private final SQLiteDatabase Pg;
    private ConcurrentHashMap<String, e> Ph = new ConcurrentHashMap<>();

    public static a oh() {
        if (Pi == null) {
            synchronized (a.class) {
                if (Pi == null) {
                    try {
                        Pi = new a(ServiceProvider.anu());
                    } catch (SQLiteException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        Pi = null;
                    }
                }
            }
        }
        return Pi;
    }

    private a(Context context) {
        this.Pg = new C0459a(context).getWritableDatabase();
    }

    public final List<h> a(String str, long j, int i) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            cursorRawQuery = this.Pg.rawQuery("select  * from ksad_ad_cache where posId=? order by createTime desc", new String[]{str});
        } catch (Exception e) {
            e = e;
            cursorRawQuery = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        try {
            try {
                List<h> listA = h.a(cursorRawQuery);
                if (listA != null) {
                    StringBuilder sb = new StringBuilder("(posId = " + str + ") AND (");
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (h hVar : listA) {
                        i2++;
                        if (i2 > i) {
                            sb.append(" creativeId = ");
                            sb.append(hVar.oA());
                            if (i2 == listA.size()) {
                                sb.append(")");
                            } else {
                                sb.append(" OR");
                            }
                        } else if (hVar.oy() >= j) {
                            arrayList.add(hVar);
                        }
                    }
                    if (i2 > i) {
                        this.Pg.delete("ksad_ad_cache", sb.toString(), new String[0]);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return arrayList;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorRawQuery;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        }
    }

    public final void l(List<h> list) {
        b(list, "ksad_ad_cache");
    }

    public final void w(long j) {
        try {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "deleteCachedAdByCreativeId result: " + this.Pg.delete("ksad_ad_cache", "creativeId=?", new String[]{String.valueOf(j)}));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final void oi() {
        try {
            this.Pg.delete("ksad_ad_cache", "expireTime<?", new String[]{String.valueOf(System.currentTimeMillis() / 1000)});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final e ai(String str) throws Throwable {
        Cursor cursorRawQuery;
        e eVar;
        ConcurrentHashMap<String, e> concurrentHashMap = this.Ph;
        if (concurrentHashMap != null && (eVar = concurrentHashMap.get(str)) != null) {
            com.kwad.sdk.core.d.c.d("AdCacheDBManager", "findCacheStrategyList from cache, posId: " + str);
            return eVar;
        }
        Cursor cursor = null;
        try {
            cursorRawQuery = this.Pg.rawQuery("select  * from ksad_ad_cache_strategy where posId=?", new String[]{str});
        } catch (Exception e) {
            e = e;
            cursorRawQuery = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            throw th;
        }
        try {
            try {
                List<e> listA = e.a(cursorRawQuery);
                if (listA != null && listA.size() > 0) {
                    e eVar2 = listA.get(0);
                    this.Ph.put(str, eVar2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return eVar2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorRawQuery;
                com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        return null;
    }

    public final void oj() {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.Pg.rawQuery("select  * from ksad_ad_cache_strategy", null);
            List<e> listA = e.a(cursorRawQuery);
            if (listA != null && !listA.isEmpty()) {
                for (e eVar : listA) {
                    com.kwad.sdk.core.d.c.d("AdCacheDBManager", "readCacheStrategyList:" + eVar.oo());
                    this.Ph.put(eVar.oo(), eVar);
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    public final void a(final e eVar) {
        this.Ph.put(eVar.oo(), eVar);
        GlobalThreadPools.acm().execute(new Runnable() { // from class: com.kwad.components.core.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.b(Collections.singletonList(eVar), "ksad_ad_cache_strategy");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends i> void b(List<T> list, String str) {
        try {
            try {
                this.Pg.beginTransaction();
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        com.kwad.sdk.core.d.c.d("AdCacheDBManager", "insertData: " + str + ", rowId: " + this.Pg.insertWithOnConflict(str, null, it.next().os(), 5));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
                this.Pg.setTransactionSuccessful();
                SQLiteDatabase sQLiteDatabase = this.Pg;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.c.printStackTrace(e2);
                    }
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.c.printStackTrace(e3);
                SQLiteDatabase sQLiteDatabase2 = this.Pg;
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.endTransaction();
                    } catch (Exception e4) {
                        com.kwad.sdk.core.d.c.printStackTrace(e4);
                    }
                }
            }
        } catch (Throwable th) {
            SQLiteDatabase sQLiteDatabase3 = this.Pg;
            if (sQLiteDatabase3 != null) {
                try {
                    sQLiteDatabase3.endTransaction();
                } catch (Exception e5) {
                    com.kwad.sdk.core.d.c.printStackTrace(e5);
                }
            }
            throw th;
        }
    }

    /* renamed from: com.kwad.components.core.c.a$a, reason: collision with other inner class name */
    static class C0459a extends SQLiteOpenHelper {
        private static int Pl = 1;
        private String Pm;
        private String Pn;

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public C0459a(Context context) {
            super(context, "ksadcache.db", (SQLiteDatabase.CursorFactory) null, Pl);
            this.Pm = "CREATE TABLE IF NOT EXISTS ksad_ad_cache (creativeId VARCHAR PRIMARY KEY NOT NULL, posId TEXT, adJson TEXT, ecpm INTEGER, playAgainJson TEXT, adSenseJson TEXT, createTime INTEGER, expireTime INTEGER)";
            this.Pn = "CREATE TABLE IF NOT EXISTS ksad_ad_cache_strategy(posId VARCHAR PRIMARY KEY NOT NULL, cacheSize INTEGER, cacheSecond INTEGER, strategyCode INTEGER, enable INTEGER)";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(this.Pm);
            sQLiteDatabase.execSQL(this.Pn);
        }
    }
}
