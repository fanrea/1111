package com.kwad.framework.filedownloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobstat.forbes.Config;
import com.kwad.framework.filedownloader.b.a;
import com.kwad.framework.filedownloader.f.f;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d implements com.kwad.framework.filedownloader.b.a {
    private static boolean bew = false;
    private final e bex = new e(com.kwad.framework.filedownloader.f.c.OV());
    private SQLiteDatabase bey;

    @Override // com.kwad.framework.filedownloader.b.a
    public final void dl(int i) {
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void dq(int i) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0048 */
    @Override // com.kwad.framework.filedownloader.b.a
    public final com.kwad.framework.filedownloader.d.c dm(int i) throws Throwable {
        Cursor cursorRawQuery;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                cursorRawQuery = Nr().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download", "_id"), new String[]{Integer.toString(i)});
            } catch (SQLiteException e) {
                e = e;
                cursorRawQuery = null;
            } catch (Exception e2) {
                e = e2;
                cursorRawQuery = null;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                throw th;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    com.kwad.framework.filedownloader.d.c cVarD = d(cursorRawQuery);
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                    return cVarD;
                }
            } catch (SQLiteException e3) {
                e = e3;
                a(i, e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                return null;
            } catch (Exception e4) {
                e = e4;
                printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
                return null;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
            return null;
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
            throw th;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final List<com.kwad.framework.filedownloader.d.a> dn(int i) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = Nr().rawQuery(f.c("SELECT * FROM %s WHERE %s = ?", "ksad_file_download_connection", "id"), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
                    aVar.setId(i);
                    aVar.setIndex(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("connectionIndex")));
                    aVar.setStartOffset(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("startOffset")));
                    aVar.av(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("currentOffset")));
                    aVar.aw(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("endOffset")));
                    arrayList.add(aVar);
                }
            } catch (SQLiteException e) {
                a(i, e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
            return arrayList;
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorRawQuery);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    /* renamed from: do */
    public final void mo454do(int i) throws SQLException {
        try {
            Nr().execSQL("DELETE FROM ksad_file_download_connection WHERE id = " + i);
        } catch (SQLiteException e) {
            printStackTrace(e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(com.kwad.framework.filedownloader.d.a aVar) throws SQLException {
        if (aVar != null) {
            try {
                Nr().insert("ksad_file_download_connection", null, aVar.Ot());
            } catch (SQLiteException e) {
                a(aVar.getId(), e);
            } catch (Exception e2) {
                printStackTrace(e2);
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, int i2, long j) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("currentOffset", Long.valueOf(j));
        try {
            Nr().update("ksad_file_download_connection", contentValues, "id = ? AND connectionIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void C(int i, int i2) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("connectionCount", Integer.valueOf(i2));
        try {
            Nr().update("ksad_file_download", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    private void d(com.kwad.framework.filedownloader.d.c cVar) throws SQLException {
        try {
            Nr().insert("ksad_file_download", null, cVar.Ot());
        } catch (SQLiteException e) {
            cVar.cA(e.toString());
            cVar.d((byte) -1);
            a(cVar.getId(), e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void b(com.kwad.framework.filedownloader.d.c cVar) throws SQLException {
        if (cVar == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "update but model == null!", new Object[0]);
            return;
        }
        if (dm(cVar.getId()) != null) {
            try {
                Nr().update("ksad_file_download", cVar.Ot(), "_id = ? ", new String[]{String.valueOf(cVar.getId())});
                return;
            } catch (SQLiteException e) {
                cVar.cA(e.toString());
                cVar.d((byte) -1);
                a(cVar.getId(), e);
                return;
            } catch (Exception e2) {
                printStackTrace(e2);
                return;
            }
        }
        d(cVar);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final boolean dp(int i) {
        try {
            return Nr().delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(i)}) != 0;
        } catch (SQLiteException e) {
            printStackTrace(e);
            return false;
        } catch (Exception e2) {
            printStackTrace(e2);
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void clear() throws SQLException {
        try {
            Nr().delete("ksad_file_download", null, null);
        } catch (SQLiteException e) {
            a(e);
        }
        try {
            Nr().delete("ksad_file_download_connection", null, null);
        } catch (SQLiteException e2) {
            a(e2);
        }
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, String str, long j, long j2, int i2) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sofar", Long.valueOf(j));
        contentValues.put(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(j2));
        contentValues.put("etag", str);
        contentValues.put("connectionCount", Integer.valueOf(i2));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, long j, String str, String str2) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 2);
        contentValues.put(Config.EXCEPTION_MEMORY_TOTAL, Long.valueOf(j));
        contentValues.put("etag", str);
        contentValues.put("filename", str2);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void f(int i, long j) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) 3);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th, long j) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) -1);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void a(int i, Throwable th) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("errMsg", th.toString());
        contentValues.put("status", (Byte) (byte) 5);
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void g(int i, long j) {
        dp(i);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final void h(int i, long j) throws SQLException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Byte) (byte) -2);
        contentValues.put("sofar", Long.valueOf(j));
        a(i, contentValues);
    }

    @Override // com.kwad.framework.filedownloader.b.a
    public final a.InterfaceC0552a Np() {
        return new a(null, null);
    }

    public final a.InterfaceC0552a a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
        return new a(sparseArray, sparseArray2);
    }

    private void a(int i, ContentValues contentValues) throws SQLException {
        try {
            Nr().update("ksad_file_download", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            a(i, e);
        } catch (Exception e2) {
            printStackTrace(e2);
        }
    }

    public class a implements a.InterfaceC0552a {
        private b beA;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> bem;
        private final SparseArray<List<com.kwad.framework.filedownloader.d.a>> ben;
        private final SparseArray<com.kwad.framework.filedownloader.d.c> bez = new SparseArray<>();

        a(SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray, SparseArray<List<com.kwad.framework.filedownloader.d.a>> sparseArray2) {
            this.bem = sparseArray;
            this.ben = sparseArray2;
        }

        @Override // java.lang.Iterable
        public final Iterator<com.kwad.framework.filedownloader.d.c> iterator() {
            b bVar = d.this.new b();
            this.beA = bVar;
            return bVar;
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0552a
        public final void Nq() throws SQLException {
            b bVar = this.beA;
            if (bVar != null) {
                bVar.Nq();
            }
            try {
                SQLiteDatabase sQLiteDatabaseNr = d.this.Nr();
                if (sQLiteDatabaseNr == null) {
                    return;
                }
                int size = this.bez.size();
                try {
                    if (size < 0) {
                        return;
                    }
                    try {
                        sQLiteDatabaseNr.beginTransaction();
                        for (int i = 0; i < size; i++) {
                            int iKeyAt = this.bez.keyAt(i);
                            com.kwad.framework.filedownloader.d.c cVar = this.bez.get(iKeyAt);
                            sQLiteDatabaseNr.delete("ksad_file_download", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                            sQLiteDatabaseNr.insert("ksad_file_download", null, cVar.Ot());
                            if (cVar.Oy() > 1) {
                                List<com.kwad.framework.filedownloader.d.a> listDn = d.this.dn(iKeyAt);
                                if (listDn.size() > 0) {
                                    sQLiteDatabaseNr.delete("ksad_file_download_connection", "id = ?", new String[]{String.valueOf(iKeyAt)});
                                    for (com.kwad.framework.filedownloader.d.a aVar : listDn) {
                                        aVar.setId(cVar.getId());
                                        sQLiteDatabaseNr.insert("ksad_file_download_connection", null, aVar.Ot());
                                    }
                                }
                            }
                        }
                        SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.bem;
                        if (sparseArray != null && this.ben != null) {
                            synchronized (sparseArray) {
                                int size2 = this.bem.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int id = this.bem.valueAt(i2).getId();
                                    List<com.kwad.framework.filedownloader.d.a> listDn2 = d.this.dn(id);
                                    if (listDn2 != null && listDn2.size() > 0) {
                                        synchronized (this.ben) {
                                            this.ben.put(id, listDn2);
                                        }
                                    }
                                }
                            }
                        }
                        sQLiteDatabaseNr.setTransactionSuccessful();
                        if (sQLiteDatabaseNr != null) {
                            try {
                                sQLiteDatabaseNr.endTransaction();
                            } catch (Exception e) {
                                d.printStackTrace(e);
                            }
                        }
                    } catch (SQLiteException e2) {
                        d.this.a(e2);
                        if (sQLiteDatabaseNr != null) {
                            try {
                                sQLiteDatabaseNr.endTransaction();
                            } catch (Exception e3) {
                                d.printStackTrace(e3);
                            }
                        }
                    } catch (Exception e4) {
                        d.printStackTrace(e4);
                        if (sQLiteDatabaseNr != null) {
                            try {
                                sQLiteDatabaseNr.endTransaction();
                            } catch (Exception e5) {
                                d.printStackTrace(e5);
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabaseNr != null) {
                        try {
                            sQLiteDatabaseNr.endTransaction();
                        } catch (Exception e6) {
                            d.printStackTrace(e6);
                        }
                    }
                    throw th;
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0552a
        public final void c(com.kwad.framework.filedownloader.d.c cVar) {
            SparseArray<com.kwad.framework.filedownloader.d.c> sparseArray = this.bem;
            if (sparseArray != null) {
                synchronized (sparseArray) {
                    this.bem.put(cVar.getId(), cVar);
                }
            }
        }

        @Override // com.kwad.framework.filedownloader.b.a.InterfaceC0552a
        public final void a(int i, com.kwad.framework.filedownloader.d.c cVar) {
            this.bez.put(i, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SQLiteDatabase Nr() {
        if (this.bey == null) {
            this.bey = this.bex.getWritableDatabase();
        }
        return this.bey;
    }

    class b implements Iterator<com.kwad.framework.filedownloader.d.c> {
        private Cursor beC;
        private final List<Integer> beD = new ArrayList();
        private int beE;

        b() throws SQLException {
            try {
                this.beC = d.this.Nr().query("ksad_file_download", null, null, null, null, null, null);
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            try {
                Cursor cursor = this.beC;
                if (cursor != null) {
                    return cursor.moveToNext();
                }
                return false;
            } catch (Throwable th) {
                d.printStackTrace(th);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.Iterator
        /* renamed from: Ns, reason: merged with bridge method [inline-methods] */
        public com.kwad.framework.filedownloader.d.c next() {
            com.kwad.framework.filedownloader.d.c cVarD = d.d(this.beC);
            this.beE = cVarD.getId();
            return cVarD;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.beD.add(Integer.valueOf(this.beE));
        }

        final void Nq() throws SQLException {
            Cursor cursor = this.beC;
            if (cursor == null) {
                return;
            }
            cursor.close();
            if (this.beD.isEmpty()) {
                return;
            }
            String strJoin = TextUtils.join(", ", this.beD);
            if (com.kwad.framework.filedownloader.f.d.bhj) {
                com.kwad.framework.filedownloader.f.d.c(this, "delete %s", strJoin);
            }
            try {
                SQLiteDatabase sQLiteDatabaseNr = d.this.Nr();
                sQLiteDatabaseNr.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download", "_id", strJoin));
                sQLiteDatabaseNr.execSQL(f.c("DELETE FROM %s WHERE %s IN (%s);", "ksad_file_download_connection", "id", strJoin));
            } catch (SQLiteException e) {
                d.this.a(e);
            } catch (Exception e2) {
                d.printStackTrace(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.kwad.framework.filedownloader.d.c d(Cursor cursor) {
        com.kwad.framework.filedownloader.d.c cVar = new com.kwad.framework.filedownloader.d.c();
        if (cursor == null) {
            return cVar;
        }
        cVar.setId(cursor.getInt(cursor.getColumnIndex("_id")));
        cVar.setUrl(cursor.getString(cursor.getColumnIndex("url")));
        cVar.g(cursor.getString(cursor.getColumnIndex("path")), cursor.getShort(cursor.getColumnIndex("pathAsDirectory")) == 1);
        cVar.d((byte) cursor.getShort(cursor.getColumnIndex("status")));
        cVar.ax(cursor.getLong(cursor.getColumnIndex("sofar")));
        cVar.az(cursor.getLong(cursor.getColumnIndex(Config.EXCEPTION_MEMORY_TOTAL)));
        cVar.cA(cursor.getString(cursor.getColumnIndex("errMsg")));
        cVar.cz(cursor.getString(cursor.getColumnIndex("etag")));
        cVar.cB(cursor.getString(cursor.getColumnIndex("filename")));
        cVar.dF(cursor.getInt(cursor.getColumnIndex("connectionCount")));
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SQLiteException sQLiteException) throws SQLException {
        a(-1, sQLiteException);
    }

    private void a(int i, SQLiteException sQLiteException) throws SQLException {
        if (sQLiteException instanceof SQLiteFullException) {
            if (i != -1) {
                dp(i);
                mo454do(i);
            }
            k(sQLiteException);
            bew = true;
            return;
        }
        printStackTrace(sQLiteException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printStackTrace(Throwable th) {
        k(th);
    }

    private static void k(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }
}
