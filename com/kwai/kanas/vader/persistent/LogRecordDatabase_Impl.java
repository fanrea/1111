package com.kwai.kanas.vader.persistent;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.util.TableInfo;
import androidx.room.RoomMasterTable;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LogRecordDatabase_Impl extends LogRecordDatabase {
    private volatile c a;

    @Override // android.arch.persistence.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) { // from class: com.kwai.kanas.vader.persistent.LogRecordDatabase_Impl.1
            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `LogRecord` (`seqId` INTEGER NOT NULL, `channelType` INTEGER, `channelSeqId` INTEGER NOT NULL, `customType` TEXT, `customSeqId` INTEGER NOT NULL, `clientTimestamp` INTEGER NOT NULL, `payload` BLOB, PRIMARY KEY(`seqId`))");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"64640e8f49f2ab22a365168d1c43248c\")");
            }

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `LogRecord`");
            }

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (LogRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = LogRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LogRecordDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                LogRecordDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                LogRecordDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (LogRecordDatabase_Impl.this.mCallbacks != null) {
                    int size = LogRecordDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) LogRecordDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // android.arch.persistence.room.RoomOpenHelper.Delegate
            public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(7);
                map.put("seqId", new TableInfo.Column("seqId", "INTEGER", true, 1));
                map.put("channelType", new TableInfo.Column("channelType", "INTEGER", false, 0));
                map.put("channelSeqId", new TableInfo.Column("channelSeqId", "INTEGER", true, 0));
                map.put("customType", new TableInfo.Column("customType", "TEXT", false, 0));
                map.put("customSeqId", new TableInfo.Column("customSeqId", "INTEGER", true, 0));
                map.put("clientTimestamp", new TableInfo.Column("clientTimestamp", "INTEGER", true, 0));
                map.put("payload", new TableInfo.Column("payload", "BLOB", false, 0));
                TableInfo tableInfo = new TableInfo("LogRecord", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "LogRecord");
                if (tableInfo.equals(tableInfo2)) {
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle LogRecord(com.kuaishou.android.vader.persistent.LogRecord).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
        }, "64640e8f49f2ab22a365168d1c43248c", "37bd463662d268bd865deefeee81239b")).build());
    }

    @Override // android.arch.persistence.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, "LogRecord");
    }

    @Override // android.arch.persistence.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `LogRecord`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecordDatabase
    public c a() {
        c cVar;
        if (this.a != null) {
            return this.a;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new d(this);
            }
            cVar = this.a;
        }
        return cVar;
    }
}
