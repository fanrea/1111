package com.alliance.ssp.ad.r;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DownLoaderManger.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public static String h = Environment.getExternalStorageDirectory() + "/azhong";
    public static f i;
    public a a;
    public SQLiteDatabase b;
    public j c;
    public com.alliance.ssp.ad.t.a e;
    public Map<String, g> d = new HashMap();
    public Map<String, e> f = new HashMap();
    public String g = "";

    public f(a aVar, j jVar) {
        this.a = aVar;
        this.c = jVar;
        this.b = aVar.getWritableDatabase();
    }

    public void a(String str, String str2) {
        if (this.f.containsKey(str)) {
            e eVar = this.f.get(str);
            if (!eVar.isAlive()) {
                this.f.remove(str);
                return;
            }
            j jVar = this.c;
            synchronized (eVar) {
                eVar.e = jVar;
                eVar.i = new d(eVar, eVar.g, jVar);
            }
            return;
        }
        this.g = str2;
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        this.b = writableDatabase;
        this.d.put(str, this.a.a(writableDatabase, str));
        e eVar2 = new e(this.d.get(str), this.a, this.c, this.g, i.e);
        this.f.put(str, eVar2);
        eVar2.start();
    }

    public void a(String str) {
        this.d.get(str).e = true;
    }

    public void a(g gVar) {
        a aVar = this.a;
        SQLiteDatabase sQLiteDatabase = this.b;
        aVar.getClass();
        Cursor cursorQuery = sQLiteDatabase.query(n.z, null, "url = ?", new String[]{gVar.b}, null, null, null, null);
        boolean zMoveToNext = cursorQuery.moveToNext();
        cursorQuery.close();
        if (!zMoveToNext) {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            this.b = writableDatabase;
            this.a.getClass();
            ContentValues contentValues = new ContentValues();
            contentValues.put("fileName", gVar.a);
            contentValues.put("url", gVar.b);
            contentValues.put("length", Integer.valueOf(gVar.c));
            contentValues.put("finished", Integer.valueOf(gVar.d));
            writableDatabase.insert(n.z, null, contentValues);
            this.d.put(gVar.b, gVar);
            return;
        }
        SQLiteDatabase writableDatabase2 = this.a.getWritableDatabase();
        this.b = writableDatabase2;
        g gVarA = this.a.a(writableDatabase2, gVar.b);
        if (this.d.containsKey(gVar.b)) {
            return;
        }
        this.d.put(gVar.b, gVarA);
    }
}
