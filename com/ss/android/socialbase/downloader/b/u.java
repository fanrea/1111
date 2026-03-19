package com.ss.android.socialbase.downloader.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.b.b;
import com.ss.android.socialbase.downloader.downloader.sy;
import com.ss.android.socialbase.downloader.mk.tt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u extends b.d implements sy {
    private static volatile SQLiteDatabase hc;
    private volatile boolean an;
    private h b;
    private h c;
    hc d;
    private h u;

    @Override // com.ss.android.socialbase.downloader.b.b
    public List<com.ss.android.socialbase.downloader.h.b> b(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public List<com.ss.android.socialbase.downloader.h.b> c(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b h(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public List<com.ss.android.socialbase.downloader.h.b> hc() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public List<com.ss.android.socialbase.downloader.h.b> hc(String str) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void hc(com.ss.android.socialbase.downloader.h.b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public boolean u() {
        return false;
    }

    public u() {
        this(false);
    }

    public u(boolean z) {
        this.d = null;
        if (z) {
            this.an = false;
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb() {
        if (hc == null) {
            synchronized (u.class) {
                if (hc == null) {
                    try {
                        hc = d.d().getWritableDatabase();
                        this.b = new h(hc, "downloader", com.ss.android.socialbase.downloader.hc.b.d, com.ss.android.socialbase.downloader.hc.b.hc);
                        this.c = new h(hc, "downloadChunk", com.ss.android.socialbase.downloader.hc.b.b, com.ss.android.socialbase.downloader.hc.b.c);
                        this.u = new h(hc, "segments", com.ss.android.socialbase.downloader.hc.b.u, com.ss.android.socialbase.downloader.hc.b.an);
                    } catch (Throwable th) {
                        mq.d(th);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d() {
        d(new SparseArray<>(), new SparseArray<>(), (c) null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.sy
    public void d(final SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArray2, final c cVar) {
        try {
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.1
                /* JADX WARN: Removed duplicated region for block: B:170:0x034a A[PHI: r0
  0x034a: PHI (r0v14 com.ss.android.socialbase.downloader.b.c) = (r0v13 com.ss.android.socialbase.downloader.b.c), (r0v18 com.ss.android.socialbase.downloader.b.c) binds: [B:169:0x0348, B:164:0x033f] A[DONT_GENERATE, DONT_INLINE]] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 886
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.b.u.AnonymousClass1.run():void");
                }
            };
            ExecutorService executorServiceW = com.ss.android.socialbase.downloader.downloader.b.w();
            if (executorServiceW != null) {
                executorServiceW.execute(runnable);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.ss.android.socialbase.downloader.h.b> list) {
        if (list == null) {
            return;
        }
        try {
            for (com.ss.android.socialbase.downloader.h.b bVar : list) {
                if (bVar != null && bVar.nu()) {
                    com.ss.android.socialbase.downloader.e.an.hc(bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void tt() {
        hc.beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(List<com.ss.android.socialbase.downloader.h.b> list, List<Integer> list2, SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray, SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray2, SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArray3) {
        int size = sparseArray.size();
        if (size < 0 || hc == null) {
            return;
        }
        synchronized (hc) {
            try {
                try {
                    tt();
                    if (!list.isEmpty()) {
                        if (com.ss.android.socialbase.downloader.uo.d.b().d("clear_invalid_task_error")) {
                            String[] strArr = new String[list.size()];
                            for (int i = 0; i < list.size(); i++) {
                                strArr[i] = String.valueOf(list.get(i));
                            }
                            String str = "CAST(_id AS TEXT) IN (" + new String(new char[list.size() - 1]).replace("\u0000", "?,") + "?)";
                            hc.delete("downloader", str, strArr);
                            hc.delete("downloadChunk", str, strArr);
                        } else {
                            String strJoin = TextUtils.join(", ", list2);
                            hc.delete("downloader", "_id IN (?)", new String[]{strJoin});
                            hc.delete("downloadChunk", "_id IN (?)", new String[]{strJoin});
                        }
                    }
                    for (int i2 = 0; i2 < size; i2++) {
                        int iKeyAt = sparseArray.keyAt(i2);
                        com.ss.android.socialbase.downloader.h.b bVar = sparseArray.get(iKeyAt);
                        hc.delete("downloader", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                        hc.insert("downloader", null, bVar.u());
                        if (bVar.fj() > 1) {
                            List<com.ss.android.socialbase.downloader.h.hc> listB = b(iKeyAt);
                            if (listB.size() > 0) {
                                hc.delete("downloadChunk", "_id = ?", new String[]{String.valueOf(iKeyAt)});
                                for (com.ss.android.socialbase.downloader.h.hc hcVar : listB) {
                                    hcVar.hc(bVar.h());
                                    hc.insert("downloadChunk", null, hcVar.d());
                                }
                            }
                        }
                    }
                    if (sparseArray2 != null && sparseArray3 != null) {
                        int size2 = sparseArray2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            int iH = sparseArray2.valueAt(i3).h();
                            List<com.ss.android.socialbase.downloader.h.hc> listD = com.ss.android.socialbase.downloader.e.an.d(b(iH));
                            if (listD != null && listD.size() > 0) {
                                sparseArray3.put(iH, listD);
                            }
                        }
                    }
                    hc.setTransactionSuccessful();
                } finally {
                    try {
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public boolean d(int i) {
        try {
            return hc(i) != null;
        } catch (Throwable th) {
            mq.d(th);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b hc(int i) {
        Cursor cursorRawQuery;
        gb();
        if (hc != null) {
            try {
                cursorRawQuery = hc.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "_id"), new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    com.ss.android.socialbase.downloader.h.b bVar = new com.ss.android.socialbase.downloader.h.b(cursorRawQuery);
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    return bVar;
                }
                com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
            } catch (Throwable th2) {
                th = th2;
                try {
                    mq.d(th);
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public List<com.ss.android.socialbase.downloader.h.b> d(String str) {
        gb();
        ArrayList arrayList = new ArrayList();
        if (hc != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = hc.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloader", "url"), new String[]{str});
                if (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.h.b(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    mq.d(th);
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public List<com.ss.android.socialbase.downloader.h.hc> b(int i) {
        ArrayList arrayList = new ArrayList();
        gb();
        if (hc != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = hc.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "downloadChunk", "_id"), new String[]{Integer.toString(i)});
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add(new com.ss.android.socialbase.downloader.h.hc(cursorRawQuery));
                }
                com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
            } catch (Throwable th) {
                try {
                    mq.d(th);
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                } catch (Throwable th2) {
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    throw th2;
                }
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void c(final int i) {
        gb();
        if (hc == null || this.c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.d(i, u.this.c.hc());
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                sQLiteStatement.bindLong(1, i);
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d(final com.ss.android.socialbase.downloader.h.hc hcVar) {
        gb();
        if (hc == null || this.c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.d(hcVar, u.this.c.d());
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void hc(com.ss.android.socialbase.downloader.h.hc hcVar) {
        d(hcVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.ss.android.socialbase.downloader.h.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.d(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.ss.android.socialbase.downloader.h.hc hcVar, SQLiteStatement sQLiteStatement) {
        if (hcVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                hcVar.d(sQLiteStatement);
                sQLiteStatement.executeInsert();
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d(final int i, final int i2, final long j) {
        gb();
        if (i == 0 || i2 < 0 || j < 0 || hc == null || this.c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.d(i, i2, j, u.this.c.b());
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d(final int i, final int i2, final int i3, final long j) {
        gb();
        if (i == 0 || i2 < 0 || i3 < 0 || j < 0 || hc == null || this.c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.d(i, i2, i3, j, u.this.c.b());
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d(final int i, final int i2, final int i3, final int i4) {
        gb();
        if (i == 0 || i3 < 0 || i4 == i2 || i4 < 0 || hc == null || this.c == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u.this.d(i, i2, i3, i4, u.this.c.b());
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2, int i3, int i4, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("chunkIndex", Integer.valueOf(i4));
                hc.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                hc.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2)});
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2, int i3, long j, SQLiteStatement sQLiteStatement) {
        try {
            synchronized (sQLiteStatement) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("curOffset", Long.valueOf(j));
                hc.update("downloadChunk", contentValues, "_id = ? AND chunkIndex = ? AND hostChunkIndex = ?", new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)});
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void hc(com.ss.android.socialbase.downloader.h.b bVar, SQLiteStatement sQLiteStatement) {
        if (bVar == null || sQLiteStatement == null) {
            return;
        }
        try {
            synchronized (sQLiteStatement) {
                bVar.d(sQLiteStatement);
                sQLiteStatement.bindLong(bVar.an() + 1, bVar.h());
                sQLiteStatement.execute();
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b d(int i, int i2) {
        gb();
        if (hc == null) {
            return null;
        }
        int i3 = 10;
        while (hc.isDbLockedByCurrentThread() && i3 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    mq.d(th);
                }
            } catch (Throwable th2) {
                mq.d(th2);
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("chunkCount", Integer.valueOf(i2));
        hc.update("downloader", contentValues, "_id = ? ", new String[]{Integer.toString(i)});
        return null;
    }

    private void b(final com.ss.android.socialbase.downloader.h.b bVar) {
        gb();
        if (hc == null || this.b == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    u uVar = u.this;
                    uVar.d(bVar, uVar.b.d());
                } catch (Throwable th) {
                    mq.d(th);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public boolean d(final com.ss.android.socialbase.downloader.h.b bVar) {
        gb();
        if (bVar == null || hc == null) {
            return false;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.10
            @Override // java.lang.Runnable
            public void run() {
                u.this.c(bVar);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            if (!d(bVar.h())) {
                b(bVar);
                return;
            }
            h hVar = this.b;
            if (hVar == null) {
                return;
            }
            try {
                hc(bVar, hVar.b());
            } catch (Throwable th) {
                mq.d(th);
            }
        } catch (Throwable th2) {
            mq.d(th2);
        }
    }

    private void tc() {
        try {
            if (hc == null || !hc.inTransaction()) {
                return;
            }
            hc.endTransaction();
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public boolean u(int i) {
        h hVar;
        gb();
        if (hc != null && (hVar = this.b) != null) {
            try {
                d(i, hVar.hc());
                return true;
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public boolean an(final int i) {
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.11
            @Override // java.lang.Runnable
            public void run() {
                u.this.u(i);
                u.this.c(i);
                u.this.uo(i);
            }
        });
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void b() {
        gb();
        if (hc == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.this.mk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void mk() {
        try {
            tt();
            hc.delete("downloader", null, null);
            hc.delete("downloadChunk", null, null);
            hc.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                mq.d(th);
            } finally {
                tc();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b d(int i, long j, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 3);
        contentValues.put("totalBytes", Long.valueOf(j));
        contentValues.put("eTag", str);
        if (!TextUtils.isEmpty(str2)) {
            contentValues.put("name", str2);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b d(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 4);
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b hc(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        contentValues.put("curBytes", Long.valueOf(j));
        if (j > 0) {
            contentValues.put("isFirstDownload", (Integer) 0);
        }
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b gb(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 5);
        contentValues.put("isFirstDownload", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b b(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-3));
        contentValues.put("curBytes", Long.valueOf(j));
        contentValues.put("isFirstDownload", (Integer) 0);
        contentValues.put("isFirstSuccess", (Integer) 0);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b c(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-2));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b u(int i, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-4));
        contentValues.put("curBytes", Long.valueOf(j));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b tt(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 1);
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public com.ss.android.socialbase.downloader.h.b tc(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-7));
        update(i, contentValues);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public boolean c() {
        return this.an;
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void hc(int i, List<com.ss.android.socialbase.downloader.h.hc> list) {
        try {
            c(i);
            if (list != null) {
                for (com.ss.android.socialbase.downloader.h.hc hcVar : list) {
                    if (hcVar != null) {
                        d(hcVar);
                        if (hcVar.an()) {
                            Iterator<com.ss.android.socialbase.downloader.h.hc> it = hcVar.h().iterator();
                            while (it.hasNext()) {
                                d(it.next());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    /* renamed from: mk, reason: merged with bridge method [inline-methods] */
    public ArrayList<tt> k(int i) {
        Map<Long, tt> mapMq = mq(i);
        if (mapMq == null || mapMq.isEmpty()) {
            return null;
        }
        return new ArrayList<>(mapMq.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public Map<Long, tt> mq(int i) {
        Cursor cursorRawQuery;
        gb();
        if (hc != null) {
            try {
                cursorRawQuery = hc.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", "segments", "_id"), new String[]{Integer.toString(i)});
            } catch (Throwable th) {
                th = th;
                cursorRawQuery = null;
            }
            try {
                if (cursorRawQuery.moveToNext()) {
                    int columnIndex = cursorRawQuery.getColumnIndex(Config.LAUNCH_INFO);
                    String string = columnIndex >= 0 ? cursorRawQuery.getString(columnIndex) : null;
                    HashMap map = new HashMap();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        tt ttVar = new tt(jSONArray.getJSONObject(i2));
                        map.put(Long.valueOf(ttVar.b()), ttVar);
                    }
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    return map;
                }
                com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
            } catch (Throwable th2) {
                th = th2;
                try {
                    mq.d(th);
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    return null;
                } catch (Throwable th3) {
                    com.ss.android.socialbase.downloader.e.an.d(cursorRawQuery);
                    throw th3;
                }
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public boolean d(int i, Map<Long, tt> map) throws SQLException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        gb();
        if (hc == null) {
            return false;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<Long> it = map.keySet().iterator();
            while (it.hasNext()) {
                jSONArray.put(map.get(Long.valueOf(it.next().longValue())).mk());
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        SQLiteStatement sQLiteStatementC = this.u.c();
        synchronized (sQLiteStatementC) {
            sQLiteStatementC.clearBindings();
            sQLiteStatementC.bindLong(1, i);
            sQLiteStatementC.bindString(2, jSONArray.toString());
            sQLiteStatementC.execute();
        }
        com.ss.android.socialbase.downloader.an.d.hc("SqlDownloadCache", "updateSegments cost=" + com.ss.android.socialbase.downloader.e.an.b(jCurrentTimeMillis));
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.mq
    public void uo(int i) {
        gb();
        if (hc == null) {
            return;
        }
        try {
            d(i, this.u.hc());
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void update(final int i, final ContentValues contentValues) {
        gb();
        if (hc == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.b.b(new Runnable() { // from class: com.ss.android.socialbase.downloader.b.u.3
            @Override // java.lang.Runnable
            public void run() {
                u.this.d(i, contentValues);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, ContentValues contentValues) {
        int i2 = 10;
        while (hc.isDbLockedByCurrentThread() && i2 - 1 >= 0) {
            try {
                try {
                    Thread.sleep(5L);
                } catch (Throwable th) {
                    mq.d(th);
                }
            } catch (Throwable th2) {
                mq.d(th2);
                return;
            }
        }
        try {
            hc.update("downloader", contentValues, "_id = ? ", new String[]{String.valueOf(i)});
        } catch (Throwable th3) {
            mq.d(th3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.b.b
    public void d(hc hcVar) {
        this.d = hcVar;
    }

    public void d(SparseArray<com.ss.android.socialbase.downloader.h.b> sparseArray, SparseArray<List<com.ss.android.socialbase.downloader.h.hc>> sparseArray2) {
        try {
            HashMap mapD = com.ss.android.socialbase.downloader.e.an.d(sparseArray);
            HashMap mapD2 = com.ss.android.socialbase.downloader.e.an.d(sparseArray2);
            hc hcVar = this.d;
            if (hcVar != null) {
                hcVar.d(mapD, mapD2);
            }
        } catch (Throwable unused) {
        }
    }
}
