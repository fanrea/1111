package com.qq.e.comm.plugin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import com.qq.e.comm.plugin.a10;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class p00 extends SQLiteOpenHelper {
    private static volatile p00 b;
    private Map<String, a10> a;

    private p00(Context context) {
        super(new ba(context), "gdt_stat.db", (SQLiteDatabase.CursorFactory) null, 2);
        HashMap map = new HashMap(5);
        this.a = map;
        map.put(NotificationCompat.CATEGORY_EVENT, new a10(NotificationCompat.CATEGORY_EVENT, new a()));
        this.a.put("performance", new a10("performance", new b()));
    }

    /* compiled from: A */
    class a implements a10.a<r00> {
        a() {
        }

        @Override // com.qq.e.comm.plugin.a10.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public r00 a(int i, String str) {
            return s00.a(i, str);
        }
    }

    /* compiled from: A */
    class b implements a10.a<v00> {
        b() {
        }

        @Override // com.qq.e.comm.plugin.a10.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public v00 a(int i, String str) {
            return w00.a(i, str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    public void c() {
        Iterator<a10> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<a10> it = this.a.values().iterator();
            while (it.hasNext()) {
                it.next().b(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused) {
            sQLiteDatabase.endTransaction();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator<a10> it = this.a.values().iterator();
            while (it.hasNext()) {
                it.next().a(sQLiteDatabase);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable unused) {
            sQLiteDatabase.endTransaction();
        }
    }

    a10 b() {
        return this.a.get("performance");
    }

    a10 a() {
        return this.a.get(NotificationCompat.CATEGORY_EVENT);
    }

    public static p00 a(Context context) {
        if (b == null) {
            synchronized (p00.class) {
                if (b == null) {
                    b = new p00(context);
                }
            }
        }
        return b;
    }
}
