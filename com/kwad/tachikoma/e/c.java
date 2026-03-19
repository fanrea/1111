package com.kwad.tachikoma.e;

import android.database.Cursor;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c extends TKBaseNativeModule {
    private Cursor dY;

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void setCursor(Cursor cursor) {
        this.dY = cursor;
    }

    public final int getCount() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public final int getPosition() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return 0;
        }
        return cursor.getPosition();
    }

    public final int getColumnCount() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return 0;
        }
        return cursor.getColumnCount();
    }

    public final int getColumnIndex(String str) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return -1;
        }
        return cursor.getColumnIndex(str);
    }

    public final String getColumnName(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return cursor.getColumnName(i);
    }

    public final boolean moveToFirst() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToFirst();
    }

    public final boolean moveToLast() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToLast();
    }

    public final boolean moveToNext() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToNext();
    }

    public final boolean moveToPrevious() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return false;
        }
        return cursor.moveToPrevious();
    }

    public final void close() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return;
        }
        cursor.close();
    }

    public final boolean isClosed() {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return true;
        }
        return cursor.isClosed();
    }

    public final Short bR(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i));
    }

    public final Integer bS(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i));
    }

    public final String bT(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return String.valueOf(cursor.getLong(i));
    }

    public final Float bU(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i));
    }

    public final Double bV(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i));
    }

    public final String getString(int i) {
        Cursor cursor = this.dY;
        if (cursor == null) {
            return null;
        }
        return cursor.getString(i);
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        try {
            if (this.dY == null || this.dY.isClosed()) {
                return;
            }
            this.dY.close();
        } catch (Throwable unused) {
        }
    }
}
