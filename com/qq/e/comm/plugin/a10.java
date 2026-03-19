package com.qq.e.comm.plugin;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.qq.e.comm.plugin.u00;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class a10<DataType extends u00> {
    private final String a;
    private final String b;
    private final String c;
    private int d = 0;
    private p00 e;
    private a<DataType> f;

    /* compiled from: A */
    interface a<DataType> {
        DataType a(int i, String str);
    }

    a10(String str, a<DataType> aVar) {
        this.a = str;
        this.b = "create table " + str + "(id integer primary key autoincrement,content text not null,ts long not null)";
        this.c = "id not in (select id from " + str + " order by ts desc limit 1000)";
        this.f = aVar;
    }

    public void a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL(this.b);
        this.d = 0;
    }

    public void b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        sQLiteDatabase.execSQL("drop table if exists " + this.a);
        this.d = 0;
    }

    void a(Set<Integer> set) {
        SQLiteDatabase writableDatabase;
        if (set == null || set.size() == 0) {
            return;
        }
        Iterator<Integer> it = set.iterator();
        StringBuilder sb = new StringBuilder("(");
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(",");
            sb.append(it.next());
        }
        sb.append(")");
        SQLiteDatabase sQLiteDatabase = null;
        try {
            writableDatabase = this.e.getWritableDatabase();
        } catch (Throwable unused) {
        }
        try {
            try {
                int iDelete = this.d - writableDatabase.delete(this.a, "id in " + sb.toString(), null);
                this.d = iDelete;
                if (iDelete < 0) {
                    this.d = 0;
                }
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    writableDatabase = sQLiteDatabase;
                    writableDatabase.close();
                }
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused3) {
        }
    }

    List<DataType> b() {
        SQLiteDatabase readableDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            readableDatabase = this.e.getReadableDatabase();
            try {
                cursorQuery = readableDatabase.query(this.a, new String[]{"id", "content"}, null, null, null, null, com.baidu.mobads.container.components.command.j.s);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    while (cursorQuery.moveToNext()) {
                        DataType datatypeA = this.f.a(cursorQuery.getInt(cursorQuery.getColumnIndex("id")), cursorQuery.getString(cursorQuery.getColumnIndex("content")));
                        if (datatypeA != null) {
                            arrayList.add(datatypeA);
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                arrayList.size();
                return arrayList;
            }
        } catch (Throwable unused2) {
            readableDatabase = null;
        }
        try {
            readableDatabase.close();
        } catch (Throwable unused3) {
        }
        arrayList.size();
        return arrayList;
    }

    public long a() {
        return this.d;
    }

    public void a(p00 p00Var) {
        this.e = p00Var;
        this.d = b().size();
    }

    void a(List<DataType> list) {
        SQLiteDatabase writableDatabase;
        if (list == null || list.size() <= 0) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                writableDatabase = this.e.getWritableDatabase();
            } catch (Throwable unused) {
            }
            try {
                writableDatabase.beginTransaction();
                StringBuilder sb = new StringBuilder("insert into ");
                sb.append(this.a);
                sb.append(" (");
                sb.append("content");
                sb.append(", ");
                sb.append(com.baidu.mobads.container.components.command.j.s);
                sb.append(") ");
                DataType datatype = list.get(0);
                sb.append("select '");
                sb.append(datatype.c());
                sb.append("', ");
                sb.append(datatype.b());
                int size = list.size();
                for (int i = 1; i < size; i++) {
                    DataType datatype2 = list.get(i);
                    sb.append(" union all select '");
                    sb.append(datatype2.c());
                    sb.append("', ");
                    sb.append(datatype2.b());
                }
                writableDatabase.execSQL(sb.toString());
                int size2 = list.size() - writableDatabase.delete(this.a, this.c, null);
                list.size();
                writableDatabase.setTransactionSuccessful();
                this.d += size2;
                writableDatabase.endTransaction();
            } catch (Throwable unused2) {
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    writableDatabase = sQLiteDatabase;
                    writableDatabase.close();
                }
                return;
            }
            writableDatabase.close();
        } catch (Throwable unused3) {
        }
    }
}
