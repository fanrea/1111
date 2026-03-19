package com.qq.e.comm.plugin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qb extends SQLiteOpenHelper {
    private static volatile qb a;

    private qb(Context context) {
        super(new ba(context), "ea_data.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists t_events(id integer primary key autoincrement,aid text,adt integer,pid text,tid text,eid integer not null,erc integer,enc integer,pt integer,rt integer,ct integer,teid text,ts integer not null,nt integer not null,prid text,adext text,vd integer not null default 0,extra text)");
        sQLiteDatabase.execSQL("create table if not exists t_agg(id integer primary key autoincrement,adt integer,pid text,eid integer not null,erc integer,enc integer,pt integer,rt integer,ct integer,teid text,ts integer not null,va1 integer not null default 0,va2 integer not null default 0,nt integer not null,prid text,adext text,vd integer not null default 0,extra text)");
        sQLiteDatabase.execSQL("create table if not exists t_results(id integer primary key autoincrement,k text,v text,ph text,ts integer not null,extra text)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i != 1) {
            return;
        }
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("alter table t_events add column prid text");
            sQLiteDatabase.execSQL("alter table t_events add column vd integer not null default 0");
            sQLiteDatabase.execSQL("alter table t_events add column adext text");
            sQLiteDatabase.execSQL("alter table t_agg add column prid text");
            sQLiteDatabase.execSQL("alter table t_agg add column vd integer not null default 0");
            sQLiteDatabase.execSQL("alter table t_agg add column adext text");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                th.getMessage();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    int b(qc qcVar) {
        try {
            return (int) getWritableDatabase().insert("t_events", null, a(qcVar));
        } catch (Throwable th) {
            th.getMessage();
            return -1;
        }
    }

    private ContentValues a(qc qcVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("eid", Integer.valueOf(qcVar.c()));
        contentValues.put("erc", Integer.valueOf(qcVar.g()));
        contentValues.put("enc", Integer.valueOf(qcVar.f()));
        contentValues.put(com.baidu.mobads.container.components.command.j.s, Long.valueOf(System.currentTimeMillis()));
        f5 f5VarA = qcVar.a();
        if (f5VarA != null) {
            contentValues.put(Config.PLATFORM_TYPE, Integer.valueOf(f5VarA.f()));
            contentValues.put("rt", Integer.valueOf(f5VarA.g()));
            contentValues.put(Config.EXCEPTION_CRASH_TYPE, Integer.valueOf(f5VarA.d()));
            contentValues.put("aid", f5VarA.c());
            contentValues.put(com.baidu.mobads.container.landingpage.aq.b, Integer.valueOf(f5VarA.b()));
            contentValues.put("pid", f5VarA.e());
            contentValues.put("tid", f5VarA.i());
            contentValues.put("teid", f5VarA.h());
            h4 h4VarA = f5VarA.a();
            if (h4VarA != null) {
                contentValues.put("prid", h4VarA.A0());
                contentValues.put("vd", Integer.valueOf(h4VarA.W0()));
                contentValues.put("adext", h4VarA.T());
            }
        }
        contentValues.put("nt", Integer.valueOf(r1.d().c().p().b()));
        ja jaVarB = qcVar.b();
        if (jaVarB != null) {
            contentValues.put("extra", jaVarB.toString());
        }
        return contentValues;
    }

    JSONArray b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONArray();
        }
        try {
            return a(getReadableDatabase().rawQuery(str, null));
        } catch (Throwable th) {
            th.getMessage();
            return new JSONArray();
        }
    }

    private ContentValues a(JSONObject jSONObject) {
        ContentValues contentValues = new ContentValues();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof Integer) {
                Integer num = (Integer) objOpt;
                num.intValue();
                contentValues.put(next, num);
            } else if (objOpt instanceof Long) {
                Long l = (Long) objOpt;
                l.longValue();
                contentValues.put(next, l);
            } else if (objOpt instanceof String) {
                contentValues.put(next, (String) objOpt);
            } else if (objOpt instanceof Float) {
                contentValues.put(next, (Float) objOpt);
            } else if (objOpt instanceof Double) {
                contentValues.put(next, (Double) objOpt);
            }
        }
        return contentValues;
    }

    int a(String str, String str2) {
        try {
            return getWritableDatabase().delete(str, str2, null);
        } catch (Throwable th) {
            th.getMessage();
            return -1;
        }
    }

    int a(int[] iArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                String[] strArr = {"t_events", "t_agg", "t_results"};
                if (iArr == null || iArr.length <= 0) {
                    for (int i = 0; i < 3; i++) {
                        writableDatabase.delete(strArr[i], null, null);
                    }
                } else {
                    int iMin = Math.min(iArr.length, 3);
                    for (int i2 = 0; i2 < iMin; i2++) {
                        if (iArr[i2] > 0) {
                            writableDatabase.delete(strArr[i2], "ts<" + k20.a(1 - iArr[i2]), null);
                        }
                    }
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return 0;
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    th.getMessage();
                } finally {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int a(String str) {
        try {
            getWritableDatabase().execSQL(str);
            return 0;
        } catch (Throwable th) {
            th.getMessage();
            return -1;
        }
    }

    int a(String str, JSONArray jSONArray) {
        SQLiteDatabase writableDatabase;
        int length = jSONArray.length();
        if (length <= 0) {
            return -1;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            long jInsert = -1;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    jInsert = writableDatabase.insert(str, null, a(jSONObjectOptJSONObject));
                }
            }
            writableDatabase.setTransactionSuccessful();
            int i2 = (int) jInsert;
            writableDatabase.endTransaction();
            return i2;
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = writableDatabase;
            try {
                th.getMessage();
                return -1;
            } finally {
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            }
        }
    }

    int a(String str, String str2, String str3, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("k", str);
            contentValues.put("v", str2);
            contentValues.put("ph", str3);
            contentValues.put(com.baidu.mobads.container.components.command.j.s, Long.valueOf(j));
            return (int) writableDatabase.insert("t_results", null, contentValues);
        } catch (Throwable th) {
            th.getMessage();
            return -1;
        }
    }

    private JSONArray a(Cursor cursor) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        if (cursor == null) {
            return jSONArray;
        }
        if (!cursor.moveToFirst()) {
            cursor.close();
            return jSONArray;
        }
        do {
            jn jnVar = new jn();
            int columnCount = cursor.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                String columnName = cursor.getColumnName(i);
                int type = cursor.getType(i);
                if (type == 1) {
                    jnVar.a(columnName, cursor.getLong(i));
                } else if (type == 2) {
                    jnVar.a(columnName, cursor.getDouble(i));
                } else if (type == 3) {
                    jnVar.a(columnName, cursor.getString(i));
                }
            }
            jSONArray.put(jnVar.a());
        } while (cursor.moveToNext());
        cursor.close();
        return jSONArray;
    }

    static qb a(Context context) {
        if (a == null) {
            synchronized (qb.class) {
                if (a == null) {
                    a = new qb(context);
                }
            }
        }
        return a;
    }
}
