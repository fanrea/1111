package com.bytedance.sdk.component.gb.hc.d.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.utils.mq;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class d {
    private static volatile d b;
    private hc d;
    private Context hc;

    public static d d(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context);
                }
            }
        }
        return b;
    }

    private d(Context context) {
        try {
            this.hc = context.getApplicationContext();
            if (this.d == null) {
                this.d = new hc();
            }
        } catch (Throwable unused) {
        }
    }

    private Context getContext() {
        return this.hc;
    }

    public class hc {
        public hc() {
        }

        private SQLiteDatabase d(u uVar) {
            boolean zHc;
            try {
                SQLiteDatabase sQLiteDatabaseD = uVar.hc().d(uVar.getContext());
                if (sQLiteDatabaseD == null || !sQLiteDatabaseD.isOpen()) {
                    return null;
                }
                sQLiteDatabaseD.setLockingEnabled(false);
                return sQLiteDatabaseD;
            } finally {
                if (!zHc) {
                }
            }
        }

        public void d(u uVar, String str) throws SQLException {
            try {
                SQLiteDatabase sQLiteDatabaseD = d(uVar);
                if (sQLiteDatabaseD != null) {
                    sQLiteDatabaseD.execSQL(str);
                }
            } catch (Throwable th) {
                if (hc(uVar)) {
                    throw th;
                }
            }
        }

        public Cursor query(u uVar, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            byte b = 0;
            try {
                SQLiteDatabase sQLiteDatabaseD = d(uVar);
                return sQLiteDatabaseD != null ? sQLiteDatabaseD.query(str, strArr, str2, strArr2, str3, str4, str5) : null;
            } catch (Throwable th) {
                mq.d(th);
                C0277d c0277d = new C0277d();
                if (hc(uVar)) {
                    throw th;
                }
                return c0277d;
            }
        }

        public int update(u uVar, String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseD = d(uVar);
                if (sQLiteDatabaseD != null) {
                    return sQLiteDatabaseD.update(str, contentValues, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                mq.d(e);
                if (hc(uVar)) {
                    throw e;
                }
                return 0;
            }
        }

        public long insert(u uVar, String str, String str2, ContentValues contentValues) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseD = d(uVar);
                if (sQLiteDatabaseD != null) {
                    return sQLiteDatabaseD.insert(str, str2, contentValues);
                }
                return -1L;
            } catch (Exception e) {
                mq.d(e);
                if (hc(uVar)) {
                    throw e;
                }
                return -1L;
            }
        }

        public synchronized void insert(u uVar, String str, String str2, List<com.bytedance.sdk.component.gb.d.hc> list) {
            JSONObject jSONObjectH;
            SQLiteDatabase sQLiteDatabaseD = null;
            try {
                try {
                    sQLiteDatabaseD = d(uVar);
                    if (sQLiteDatabaseD != null) {
                        sQLiteDatabaseD.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < list.size(); i++) {
                            com.bytedance.sdk.component.gb.d.hc hcVar = list.get(i);
                            if (hcVar != null && (jSONObjectH = hcVar.h()) != null) {
                                contentValues.put("id", hcVar.b());
                                String strHc = uVar.c().hc(jSONObjectH.toString());
                                if (!TextUtils.isEmpty(strHc)) {
                                    contentValues.put(com.alipay.sdk.m.p0.b.d, strHc);
                                    contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                    contentValues.put("retry", (Integer) 0);
                                    contentValues.put("encrypt", (Integer) 1);
                                    sQLiteDatabaseD.insert(str, str2, contentValues);
                                }
                                contentValues.clear();
                            }
                        }
                        sQLiteDatabaseD.setTransactionSuccessful();
                        com.bytedance.sdk.component.gb.hc.b.b.d("DBHelper", str + " insert list size=" + list.size(), uVar);
                    }
                } finally {
                    if (sQLiteDatabaseD != null) {
                        sQLiteDatabaseD.endTransaction();
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.gb.hc.b.b.d("DBHelper", str + " insert list error=" + list.size(), uVar);
                mq.d(e);
                if (hc(uVar)) {
                    throw e;
                }
                if (sQLiteDatabaseD != null) {
                    sQLiteDatabaseD.endTransaction();
                }
            }
        }

        public int delete(u uVar, String str, String str2, String[] strArr) throws Exception {
            try {
                SQLiteDatabase sQLiteDatabaseD = d(uVar);
                if (sQLiteDatabaseD != null) {
                    return sQLiteDatabaseD.delete(str, str2, strArr);
                }
                return 0;
            } catch (Exception e) {
                mq.d(e);
                if (hc(uVar)) {
                    throw e;
                }
                return 0;
            }
        }

        private boolean hc(u uVar) {
            SQLiteDatabase sQLiteDatabaseD = d(uVar);
            return sQLiteDatabaseD != null && sQLiteDatabaseD.inTransaction();
        }
    }

    public hc d() {
        return this.d;
    }

    /* renamed from: com.bytedance.sdk.component.gb.hc.d.d.d$d, reason: collision with other inner class name */
    private class C0277d extends AbstractCursor {
        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }

        private C0277d() {
        }
    }
}
