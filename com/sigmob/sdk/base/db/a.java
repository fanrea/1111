package com.sigmob.sdk.base.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;
import com.czhj.sdk.common.Database.SQLiteBuider;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.sigmob.sdk.base.utils.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends SQLiteOpenHelper {
    public static final String a = "ads";
    public static final String b = "file_reference";
    public static final String c = "trigger_insert";
    public static final String d = "trigger_delete";
    public static final String e = "tracks";
    public static final String f = "adload_event";
    public static final String g = "adload_cache_event";
    public static final String h = "adload_ready_event";
    public static final String i = "wind.db";
    public static final long j = -2;
    public static final long k = -1;
    private static final int l = 11;
    private static String m = "CREATE TABLE ads ( endcard_md5 text  ,video_md5 text  ,ad blob  ,ad_source_channel text  ,ad_type integer  ,create_time integer  ,crid text  ,load_id text  ,adTrackersMap blob  ,adslot_id text  ,camp_id text  ,request_id text , primary key ( crid ,adslot_id) ); \n";
    private static String n = "CREATE TRIGGER trigger_insert after insert on ads begin insert or replace into file_reference (crid,adslot_id,video_md5,endcard_md5) values(new.crid,new.adslot_id,new.video_md5,new.endcard_md5) ; end; \n";
    private static String o = "CREATE TRIGGER trigger_delete after delete on ads begin delete from file_reference where crid = old.crid  and adslot_id == old.adslot_id; end;\n";
    private static String p = "CREATE TABLE file_reference ( endcard_md5 blob  ,video_md5 blob  ,crid text  ,adslot_id text  , primary key ( crid ,adslot_id ) );\n";
    private static String q = "CREATE TABLE tracks ( id integer primary key AUTOINCREMENT ,retryNum integer   ,source text   ,event text   ,request_id text   ,url text   ,timestamp integer   );\n";
    private static String r = "CREATE TABLE adload_event ( id integer primary key AUTOINCREMENT , adslot_id text  , error_code integer ,timestamp integer  );\n";
    private static String s = "CREATE TABLE adload_cache_event (  adslot_id text primary key, media_request_count integer ,media_ready_count integer ,pre_req_time integer , req_interval_time integer ,req_pool_size integer); \n";
    private static String t = "CREATE TABLE adload_ready_event (  adslot_id text primary key, media_request_count integer ,media_ready_count integer ); \n";
    private static final long u = -6;
    private static final long v = -5;
    private static final long w = -4;
    private static final long x = 0;
    private static a y;
    private static SQLiteDatabase z;

    /* renamed from: com.sigmob.sdk.base.db.a$a, reason: collision with other inner class name */
    public interface InterfaceC0729a {
        void a();

        void a(Throwable e);
    }

    private a(final Context context) {
        super(context, i, (SQLiteDatabase.CursorFactory) null, 11);
    }

    private static long a(SQLiteDatabase db) {
        if (db == null) {
            return u;
        }
        if (!db.isOpen()) {
            return v;
        }
        if (db.isReadOnly()) {
            return w;
        }
        return 0L;
    }

    public static a a() {
        return y;
    }

    public static synchronized void a(final Context context) {
        if (y == null) {
            y = new a(context);
        }
    }

    private void a(final SQLiteDatabase database, final String field, final String table) throws SQLException {
        database.execSQL("alter table " + table + " drop column " + field);
    }

    private void a(final SQLiteDatabase database, final String field, final String type, final String table) throws SQLException {
        database.execSQL("alter table " + table + " add " + field + " " + type);
    }

    private void b(SQLiteDatabase database) throws SQLException {
        database.execSQL("DROP TABLE IF EXISTS ads");
        database.execSQL("DROP TABLE IF EXISTS file_reference");
        database.execSQL("DROP TABLE IF EXISTS tracks");
        database.execSQL("DROP TABLE IF EXISTS adload_event");
        database.execSQL("DROP TABLE IF EXISTS adload_cache_event");
        database.execSQL("DROP TABLE IF EXISTS adload_ready_event");
        database.execSQL("DROP TRIGGER IF EXISTS trigger_insert");
        database.execSQL("DROP TRIGGER IF EXISTS trigger_delete");
        i.i();
        onCreate(database);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:3:0x0004, B:4:0x000d, B:6:0x0017, B:8:0x002d, B:21:0x0060, B:9:0x0031, B:11:0x0035, B:12:0x003b, B:14:0x003f, B:15:0x0049, B:17:0x004d, B:18:0x0057, B:20:0x005b, B:22:0x0063), top: B:56:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void b(android.database.sqlite.SQLiteDatabase r5, com.czhj.sdk.common.Database.SQLiteBuider.Insert r6, com.sigmob.sdk.base.db.a.InterfaceC0729a r7) {
        /*
            r5.beginTransaction()
            r0 = 1
            java.lang.String r1 = r6.getSql()     // Catch: java.lang.Throwable -> L7b
            android.database.sqlite.SQLiteStatement r1 = r5.compileStatement(r1)     // Catch: java.lang.Throwable -> L7b
            r2 = r0
        Ld:
            java.util.List r3 = r6.getColumns()     // Catch: java.lang.Throwable -> L7b
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L7b
            if (r2 > r3) goto L63
            java.util.List r3 = r6.getColumns()     // Catch: java.lang.Throwable -> L7b
            int r4 = r2 + (-1)
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L7b
            java.util.Map r4 = r6.getValues()     // Catch: java.lang.Throwable -> L7b
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.Throwable -> L7b
            if (r3 != 0) goto L31
        L2d:
            r1.bindNull(r2)     // Catch: java.lang.Throwable -> L7b
            goto L60
        L31:
            boolean r4 = r3 instanceof java.lang.String     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L3b
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L7b
            r1.bindString(r2, r3)     // Catch: java.lang.Throwable -> L7b
            goto L60
        L3b:
            boolean r4 = r3 instanceof java.lang.Double     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L49
            java.lang.Double r3 = (java.lang.Double) r3     // Catch: java.lang.Throwable -> L7b
            double r3 = r3.doubleValue()     // Catch: java.lang.Throwable -> L7b
            r1.bindDouble(r2, r3)     // Catch: java.lang.Throwable -> L7b
            goto L60
        L49:
            boolean r4 = r3 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L57
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Throwable -> L7b
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L7b
            r1.bindLong(r2, r3)     // Catch: java.lang.Throwable -> L7b
            goto L60
        L57:
            boolean r4 = r3 instanceof byte[]     // Catch: java.lang.Throwable -> L7b
            if (r4 == 0) goto L2d
            byte[] r3 = (byte[]) r3     // Catch: java.lang.Throwable -> L7b
            r1.bindBlob(r2, r3)     // Catch: java.lang.Throwable -> L7b
        L60:
            int r2 = r2 + 1
            goto Ld
        L63:
            r1.execute()     // Catch: java.lang.Throwable -> L7b
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7b
            r5.endTransaction()     // Catch: java.lang.Throwable -> L6d
            goto L9a
        L6d:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r6)
            if (r7 == 0) goto L9a
            r7.a(r5)
            goto L9a
        L7b:
            r6 = move-exception
            java.lang.String r0 = r6.getMessage()     // Catch: java.lang.Throwable -> La2
            com.czhj.sdk.logger.SigmobLog.e(r0)     // Catch: java.lang.Throwable -> La2
            if (r7 == 0) goto L88
            r7.a(r6)     // Catch: java.lang.Throwable -> La2
        L88:
            r5.endTransaction()     // Catch: java.lang.Throwable -> L8c
            goto L99
        L8c:
            r5 = move-exception
            java.lang.String r6 = r5.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r6)
            if (r7 == 0) goto L99
            r7.a(r5)
        L99:
            r0 = 0
        L9a:
            if (r0 == 0) goto La1
            if (r7 == 0) goto La1
            r7.a()
        La1:
            return
        La2:
            r6 = move-exception
            r5.endTransaction()     // Catch: java.lang.Throwable -> La7
            goto Lb4
        La7:
            r5 = move-exception
            java.lang.String r0 = r5.getMessage()
            com.czhj.sdk.logger.SigmobLog.e(r0)
            if (r7 == 0) goto Lb4
            r7.a(r5)
        Lb4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.db.a.b(android.database.sqlite.SQLiteDatabase, com.czhj.sdk.common.Database.SQLiteBuider$Insert, com.sigmob.sdk.base.db.a$a):void");
    }

    public void a(final SQLiteDatabase sqLiteDatabase, final SQLiteBuider.Insert insert, final InterfaceC0729a callBack) {
        ThreadPoolFactory.getFixIOExecutor().submit(new Runnable() { // from class: com.sigmob.sdk.base.db.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.b(sqLiteDatabase, insert, callBack);
            }
        });
    }

    public void a(SQLiteDatabase sqLiteDatabase, String sql, InterfaceC0729a callBack) {
        sqLiteDatabase.beginTransaction();
        boolean z2 = false;
        try {
            sqLiteDatabase.execSQL(sql, new Object[0]);
            sqLiteDatabase.setTransactionSuccessful();
            z2 = true;
        } finally {
            try {
                if (z2) {
                    return;
                } else {
                    return;
                }
            } finally {
            }
        }
        if (z2 || callBack == null) {
            return;
        }
        callBack.a();
    }

    public void b() throws SQLException {
        b(getWritableDatabase());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(final SQLiteDatabase sqLiteDatabase) throws SQLException {
        sqLiteDatabase.execSQL(r);
        sqLiteDatabase.execSQL(s);
        sqLiteDatabase.execSQL(t);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) throws SQLException {
        Log.w(a.class.getName(), "Downgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        b(database);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (Build.VERSION.SDK_INT >= 16) {
            setWriteAheadLoggingEnabled(true);
        } else {
            db.enableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) throws SQLException {
        Log.w(a.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        b(database);
    }
}
