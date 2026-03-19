package com.ss.android.socialbase.downloader.b;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.e.tt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h {
    private SQLiteStatement an;
    private final String[] b;
    private final String[] c;
    private final SQLiteDatabase d;
    private SQLiteStatement gb;
    private SQLiteStatement h;
    private final String hc;
    private SQLiteStatement u;

    public h(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.d = sQLiteDatabase;
        this.hc = str;
        this.b = strArr;
        this.c = strArr2;
    }

    public SQLiteStatement d() throws SQLException {
        if (this.u == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.d.compileStatement(tt.d("INSERT INTO ", this.hc, this.b));
            synchronized (this) {
                if (this.u == null) {
                    this.u = sQLiteStatementCompileStatement;
                }
            }
            if (this.u != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.u;
    }

    public SQLiteStatement hc() throws SQLException {
        if (this.h == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.d.compileStatement(tt.d(this.hc, this.c));
            synchronized (this) {
                if (this.h == null) {
                    this.h = sQLiteStatementCompileStatement;
                }
            }
            if (this.h != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.h;
    }

    public SQLiteStatement b() throws SQLException {
        if (this.an == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.d.compileStatement(tt.d(this.hc, this.b, this.c));
            synchronized (this) {
                if (this.an == null) {
                    this.an = sQLiteStatementCompileStatement;
                }
            }
            if (this.an != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.an;
    }

    public SQLiteStatement c() throws SQLException {
        if (this.gb == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.d.compileStatement(tt.hc(this.hc, this.b, this.c));
            synchronized (this) {
                if (this.gb == null) {
                    this.gb = sQLiteStatementCompileStatement;
                }
            }
            if (this.gb != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.gb;
    }
}
