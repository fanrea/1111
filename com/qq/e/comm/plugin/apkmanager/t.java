package com.qq.e.comm.plugin.apkmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.qq.e.comm.plugin.ba;
import com.qq.e.comm.plugin.r1;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class t extends SQLiteOpenHelper {
    private static volatile t b;
    private static SQLiteDatabase c;
    private AtomicInteger a;

    private t(Context context) {
        super(new ba(context), "GDTSDK.db", (SQLiteDatabase.CursorFactory) null, 10);
        this.a = new AtomicInteger();
    }

    static t a(Context context) {
        if (b == null) {
            synchronized (t.class) {
                if (b == null) {
                    b = new t(context);
                }
            }
        }
        return b;
    }

    public int b(ApkDownloadTask apkDownloadTask) {
        SQLiteDatabase writableDatabase;
        int iDelete = 0;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable unused) {
            writableDatabase = null;
        }
        try {
            iDelete = writableDatabase.delete("tasks", "id=?", new String[]{String.valueOf(apkDownloadTask.t())});
            a(writableDatabase, (Cursor) null);
        } catch (Throwable unused2) {
            a(writableDatabase, (Cursor) null);
            return iDelete;
        }
        return iDelete;
    }

    public int c(ApkDownloadTask apkDownloadTask) {
        SQLiteDatabase writableDatabase;
        int iT = apkDownloadTask.t();
        if (iT <= 0) {
            if (apkDownloadTask.o() == 1) {
                return a(apkDownloadTask);
            }
            return 0;
        }
        try {
            writableDatabase = getWritableDatabase();
            try {
                int iUpdate = writableDatabase.update("tasks", a(apkDownloadTask, false), "id=?", new String[]{String.valueOf(iT)});
                a(writableDatabase, (Cursor) null);
                return iUpdate;
            } catch (Throwable unused) {
                a(writableDatabase, (Cursor) null);
                return 0;
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
    }

    public List<ApkDownloadTask> d() {
        return b("(4)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        if (this.a.incrementAndGet() == 1) {
            c = super.getReadableDatabase();
        }
        return c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        if (this.a.incrementAndGet() == 1) {
            c = super.getWritableDatabase();
        }
        return c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table tasks(id integer primary key autoincrement,ad_id text not null,ad_type integer,pos_id text not null,trace_id text,target_id text not null,click_id text not null,url text not null unique,name text not null,pkg text not null,tracer text,icon text not null,create_time integer not null,is_returned integer,title text,description text,network integer not null,status integer not null,fail_reason text,launch_param text,delay_download integer not null,manual_paused integer not null,progress integer not null,total_size integer not null)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        if (i2 == 10) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tasks");
            onCreate(sQLiteDatabase);
        }
    }

    private ApkDownloadTask b(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        String string = cursor.getString(cursor.getColumnIndex("target_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("click_id"));
        String string3 = cursor.getString(cursor.getColumnIndex("icon"));
        String string4 = cursor.getString(cursor.getColumnIndex("url"));
        String string5 = cursor.getString(cursor.getColumnIndex("name"));
        String string6 = cursor.getString(cursor.getColumnIndex(Config.INPUT_DEF_PKG));
        long j = cursor.getLong(cursor.getColumnIndex("create_time"));
        int i = cursor.getInt(cursor.getColumnIndex("is_returned"));
        ApkDownloadTask apkDownloadTask = new ApkDownloadTask(cursor.getString(cursor.getColumnIndex(IDJXAd.AD_CODE_ID)), cursor.getInt(cursor.getColumnIndex("ad_type")), cursor.getString(cursor.getColumnIndex("pos_id")), cursor.getString(cursor.getColumnIndex(PointParamKey.TRACE_ID)), string, string2, string3, string4, string5, string6, new Bundle(), r1.d().c().p().b(), j, cursor.getInt(cursor.getColumnIndex("status")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("description")));
        apkDownloadTask.e(cursor.getString(cursor.getColumnIndex("tracer")));
        apkDownloadTask.d(cursor.getInt(cursor.getColumnIndex("id")));
        apkDownloadTask.f(cursor.getString(cursor.getColumnIndex("fail_reason")));
        apkDownloadTask.a("totalSize", cursor.getLong(cursor.getColumnIndex("total_size")));
        apkDownloadTask.a("progress", cursor.getInt(cursor.getColumnIndex("progress")));
        apkDownloadTask.a(i != 0);
        String string7 = cursor.getString(cursor.getColumnIndex("launch_param"));
        try {
            JSONObject jSONObject = TextUtils.isEmpty(string7) ? null : new JSONObject(string7);
            if (jSONObject != null) {
                apkDownloadTask.a(jSONObject);
                apkDownloadTask.a("appInstall", jSONObject.optBoolean("appInstall", true));
            }
        } catch (JSONException unused) {
        }
        return apkDownloadTask;
    }

    public int a(ApkDownloadTask apkDownloadTask) {
        SQLiteDatabase writableDatabase;
        long jInsert = -1;
        try {
            writableDatabase = getWritableDatabase();
            try {
                jInsert = writableDatabase.insert("tasks", null, a(apkDownloadTask, true));
                if (jInsert > 0) {
                    apkDownloadTask.d((int) jInsert);
                }
                a(writableDatabase, (Cursor) null);
            } catch (Throwable unused) {
                a(writableDatabase, (Cursor) null);
                return (int) jInsert;
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        return (int) jInsert;
    }

    public ApkDownloadTask c(int i) {
        return a("id", i + "");
    }

    public List<ApkDownloadTask> c() {
        return b("(4,32,16)");
    }

    private ContentValues a(ApkDownloadTask apkDownloadTask, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("target_id", apkDownloadTask.q());
        contentValues.put("click_id", apkDownloadTask.c());
        contentValues.put("url", apkDownloadTask.s());
        contentValues.put("name", apkDownloadTask.p());
        contentValues.put(Config.INPUT_DEF_PKG, apkDownloadTask.r());
        contentValues.put("icon", apkDownloadTask.k());
        contentValues.put("create_time", Long.valueOf(apkDownloadTask.e()));
        contentValues.put("is_returned", Boolean.valueOf(apkDownloadTask.y()));
        contentValues.put("title", apkDownloadTask.u());
        contentValues.put("description", apkDownloadTask.g());
        contentValues.put(PointCategory.NETWORK, Integer.valueOf(apkDownloadTask.d()));
        contentValues.put("status", Integer.valueOf(apkDownloadTask.o()));
        contentValues.put("fail_reason", apkDownloadTask.d("failReason"));
        String strD = apkDownloadTask.d("launchParam");
        if (strD == null) {
            strD = "";
        }
        contentValues.put("launch_param", strD);
        contentValues.put(IDJXAd.AD_CODE_ID, apkDownloadTask.a());
        contentValues.put("ad_type", Integer.valueOf(apkDownloadTask.b()));
        contentValues.put("pos_id", apkDownloadTask.m());
        contentValues.put(PointParamKey.TRACE_ID, apkDownloadTask.w());
        contentValues.put("delay_download", (Integer) 0);
        contentValues.put("manual_paused", Integer.valueOf(apkDownloadTask.b("manualPause")));
        long jC = apkDownloadTask.c("totalSize");
        if (z || jC > 0) {
            contentValues.put("total_size", Long.valueOf(jC));
        }
        if (!TextUtils.isEmpty(apkDownloadTask.h())) {
            contentValues.put("tracer", apkDownloadTask.h());
        }
        contentValues.put("progress", Integer.valueOf(apkDownloadTask.b("progress")));
        return contentValues;
    }

    public ApkDownloadTask b(int i) {
        return a(i, "(32,16)");
    }

    public List<ApkDownloadTask> b() {
        return b("(8)");
    }

    private List<ApkDownloadTask> b(String str) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            readableDatabase = getReadableDatabase();
        } catch (Throwable unused) {
            cursor = null;
        }
        try {
            cursorRawQuery = readableDatabase.rawQuery("select * from tasks where status in " + str, null);
            while (a(cursorRawQuery)) {
                arrayList.add(b(cursorRawQuery));
            }
        } catch (Throwable unused2) {
            cursor = cursorRawQuery;
            cursorRawQuery = readableDatabase;
            readableDatabase = cursorRawQuery;
            cursorRawQuery = cursor;
            a(readableDatabase, cursorRawQuery);
            return arrayList;
        }
        a(readableDatabase, cursorRawQuery);
        return arrayList;
    }

    public int a(String str, int i) {
        SQLiteDatabase writableDatabase;
        int iUpdate = 0;
        try {
            writableDatabase = getWritableDatabase();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(i));
                iUpdate = writableDatabase.update("tasks", contentValues, "pkg=?", new String[]{str});
                a(writableDatabase, (Cursor) null);
            } catch (Throwable unused) {
                a(writableDatabase, (Cursor) null);
                return iUpdate;
            }
        } catch (Throwable unused2) {
            writableDatabase = null;
        }
        return iUpdate;
    }

    private boolean a(Cursor cursor) {
        return cursor.getCount() > 0 && !cursor.isLast();
    }

    public ApkDownloadTask a(int i) {
        return a(i, "(4)");
    }

    public List<ApkDownloadTask> a() {
        return b("(8,1)");
    }

    private ApkDownloadTask a(int i, String str) {
        Cursor cursorRawQuery;
        SQLiteDatabase readableDatabase;
        try {
            readableDatabase = getReadableDatabase();
            try {
                cursorRawQuery = readableDatabase.rawQuery("select * from tasks where id =? and status in " + str, new String[]{String.valueOf(i)});
                try {
                    if (a(cursorRawQuery)) {
                        ApkDownloadTask apkDownloadTaskB = b(cursorRawQuery);
                        a(readableDatabase, cursorRawQuery);
                        return apkDownloadTaskB;
                    }
                    a(readableDatabase, cursorRawQuery);
                    return null;
                } catch (Throwable unused) {
                    a(readableDatabase, cursorRawQuery);
                    return null;
                }
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        } catch (Throwable unused3) {
            cursorRawQuery = null;
            readableDatabase = null;
        }
    }

    public ApkDownloadTask a(String str) {
        return a(Config.INPUT_DEF_PKG, str);
    }

    private ApkDownloadTask a(String str, String str2) {
        Cursor cursorRawQuery;
        SQLiteDatabase readableDatabase;
        try {
            readableDatabase = getReadableDatabase();
            try {
                cursorRawQuery = readableDatabase.rawQuery("select * from tasks where " + str + "=?", new String[]{str2});
                try {
                    if (a(cursorRawQuery)) {
                        ApkDownloadTask apkDownloadTaskB = b(cursorRawQuery);
                        a(readableDatabase, cursorRawQuery);
                        return apkDownloadTaskB;
                    }
                    a(readableDatabase, cursorRawQuery);
                    return null;
                } catch (Throwable unused) {
                    a(readableDatabase, cursorRawQuery);
                    return null;
                }
            } catch (Throwable unused2) {
                cursorRawQuery = null;
            }
        } catch (Throwable unused3) {
            cursorRawQuery = null;
            readableDatabase = null;
        }
    }

    private synchronized void a(SQLiteDatabase sQLiteDatabase, Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (sQLiteDatabase != null && this.a.decrementAndGet() == 0) {
            sQLiteDatabase.close();
        }
    }
}
