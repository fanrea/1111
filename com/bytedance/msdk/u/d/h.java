package com.bytedance.msdk.u.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static final Object b = new Object();
    private d d;
    private Context hc;

    h(Context context) {
        try {
            this.hc = context == null ? com.bytedance.msdk.core.hc.getContext() : context.getApplicationContext();
            if (this.d == null) {
                this.d = new d();
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.hc;
        return context == null ? com.bytedance.msdk.core.hc.getContext() : context;
    }

    public class d {
        private SQLiteDatabase hc = null;

        public d() {
        }

        private void hc() {
            try {
                synchronized (h.b) {
                    SQLiteDatabase sQLiteDatabase = this.hc;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new gb(h.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.hc = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                mq.d(th);
                b();
            }
        }

        public SQLiteDatabase d() {
            hc();
            return this.hc;
        }

        private boolean b() {
            SQLiteDatabase sQLiteDatabase = this.hc;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }
    }

    public d d() {
        return this.d;
    }
}
