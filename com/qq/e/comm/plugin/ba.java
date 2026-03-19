package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ba extends ContextWrapper {
    private String a;

    public ba(Context context) {
        this(context, "gdt_database");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        File filesDir = getFilesDir();
        if (filesDir != null) {
            if (this.a != null) {
                File file = new File(filesDir, this.a);
                if (file.exists() || file.mkdir()) {
                    filesDir = file;
                }
            }
            File file2 = new File(filesDir, str);
            if (!file2.exists()) {
                try {
                    if (!file2.createNewFile()) {
                        file2 = super.getDatabasePath(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    file2 = super.getDatabasePath(str);
                }
            }
            if (file2 != null) {
                file2.getPath();
            }
            toString();
            return file2;
        }
        File databasePath = super.getDatabasePath(str);
        if (databasePath != null) {
            databasePath.getPath();
        }
        return databasePath;
    }

    public ba(Context context, String str) {
        super(context);
        this.a = str;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return openOrCreateDatabase(str, i, cursorFactory, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase;
        int i2 = ((i & 8) == 0 || Build.VERSION.SDK_INT < 16) ? 268435456 : 805306368;
        if (Build.VERSION.SDK_INT >= 11) {
            File databasePath = getDatabasePath(str);
            sQLiteDatabaseOpenOrCreateDatabase = databasePath != null ? SQLiteDatabase.openDatabase(databasePath.getPath(), cursorFactory, i2, databaseErrorHandler) : null;
        } else {
            sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
        }
        if (sQLiteDatabaseOpenOrCreateDatabase != null) {
            sQLiteDatabaseOpenOrCreateDatabase.getPath();
        }
        return sQLiteDatabaseOpenOrCreateDatabase;
    }
}
