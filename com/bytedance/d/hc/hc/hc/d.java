package com.bytedance.d.hc.hc.hc;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.sdk.component.utils.mq;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d<T> {
    protected final String d = "_id";
    protected final String hc;

    protected abstract ContentValues d(T t);

    protected abstract HashMap<String, String> d();

    protected d(String str) {
        this.hc = str;
    }

    public void d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append(this.hc).append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapD = d();
            if (mapD != null) {
                for (String str : mapD.keySet()) {
                    sb.append(str).append(" ").append(mapD.get(str)).append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase == null || t == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.hc, null, d((d<T>) t));
        } catch (Exception e) {
            tc.hc(e);
        }
    }
}
