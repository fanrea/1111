package com.kwad.sdk.core.report;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class d implements l<e> {
    protected c bEB;
    private static final String[] bEz = {"count(*)"};
    private static boolean bEA = false;

    protected abstract String abg();

    protected abstract String[] abh();

    protected abstract e f(Cursor cursor);

    protected abstract String getTag();

    public d(c cVar) {
        a(cVar);
    }

    private void a(c cVar) {
        this.bEB = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.l
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized void q(e eVar) {
        if (bEA) {
            Log.d(getTag(), "write = " + eVar);
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("actionId", eVar.actionId);
            contentValues.put("aLog", eVar.toJson().toString());
            try {
                this.bEB.getReadableDatabase().insert(abg(), null, contentValues);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized long size() {
        long j;
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.bEB.getReadableDatabase().query(abg(), bEz, null, null, null, null, null);
            cursorQuery.moveToFirst();
            j = cursorQuery.getLong(0);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            j = 0;
        } finally {
        }
        return j;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized List<e> fq(int i) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.bEB.getReadableDatabase().query(abg(), abh(), null, null, null, null, null, "0,200");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(f(cursorQuery));
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.c.printStackTrace(e2);
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.core.report.l
    public final synchronized void ak(List<e> list) {
        if (bEA) {
            Log.d(getTag(), "delete size= " + list.size());
        }
        SQLiteDatabase readableDatabase = null;
        try {
            try {
                readableDatabase = this.bEB.getReadableDatabase();
                readableDatabase.beginTransaction();
                Iterator<e> it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
                readableDatabase.setTransactionSuccessful();
            } finally {
                if (readableDatabase != null) {
                    try {
                        readableDatabase.endTransaction();
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
            if (readableDatabase != null) {
                try {
                    readableDatabase.endTransaction();
                } catch (Exception e3) {
                    com.kwad.sdk.core.d.c.printStackTrace(e3);
                }
            }
        }
    }

    private synchronized void c(e eVar) {
        if (bEA) {
            Log.d(getTag(), "deleteAction action = " + eVar);
        }
        try {
            this.bEB.getReadableDatabase().delete(abg(), "actionId=?", new String[]{eVar.actionId});
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
