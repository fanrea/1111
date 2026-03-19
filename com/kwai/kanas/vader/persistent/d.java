package com.kwai.kanas.vader.persistent;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.kwai.kanas.vader.Channel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class d implements c {
    private final RoomDatabase a;
    private final EntityInsertionAdapter b;
    private final EntityDeletionOrUpdateAdapter c;
    private final SharedSQLiteStatement d;
    private final SharedSQLiteStatement e;

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new EntityInsertionAdapter<LogRecord>(roomDatabase) { // from class: com.kwai.kanas.vader.persistent.d.1
            @Override // android.arch.persistence.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `LogRecord`(`seqId`,`channelType`,`channelSeqId`,`customType`,`customSeqId`,`clientTimestamp`,`payload`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // android.arch.persistence.room.EntityInsertionAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LogRecord logRecord) {
                supportSQLiteStatement.bindLong(1, logRecord.seqId());
                supportSQLiteStatement.bindLong(2, com.kwai.kanas.vader.a.a(logRecord.channelType()));
                supportSQLiteStatement.bindLong(3, logRecord.channelSeqId());
                if (logRecord.customType() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, logRecord.customType());
                }
                supportSQLiteStatement.bindLong(5, logRecord.customSeqId());
                supportSQLiteStatement.bindLong(6, logRecord.clientTimestamp());
                if (logRecord.payload() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindBlob(7, logRecord.payload());
                }
            }
        };
        this.c = new EntityDeletionOrUpdateAdapter<LogRecord>(roomDatabase) { // from class: com.kwai.kanas.vader.persistent.d.2
            @Override // android.arch.persistence.room.EntityDeletionOrUpdateAdapter, android.arch.persistence.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `LogRecord` WHERE `seqId` = ?";
            }

            @Override // android.arch.persistence.room.EntityDeletionOrUpdateAdapter
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void bind(SupportSQLiteStatement supportSQLiteStatement, LogRecord logRecord) {
                supportSQLiteStatement.bindLong(1, logRecord.seqId());
            }
        };
        this.d = new SharedSQLiteStatement(roomDatabase) { // from class: com.kwai.kanas.vader.persistent.d.3
            @Override // android.arch.persistence.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LogRecord WHERE clientTimestamp <= ?";
            }
        };
        this.e = new SharedSQLiteStatement(roomDatabase) { // from class: com.kwai.kanas.vader.persistent.d.4
            @Override // android.arch.persistence.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM LogRecord";
            }
        };
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public void a(List<LogRecord> list) {
        this.a.beginTransaction();
        try {
            this.b.insert((Iterable) list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public void a(LogRecord logRecord) {
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter) logRecord);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public void b(List<LogRecord> list) {
        this.a.beginTransaction();
        try {
            this.c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public void b(LogRecord logRecord) {
        this.a.beginTransaction();
        try {
            this.c.handle(logRecord);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int a(long j) {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.d.acquire();
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.bindLong(1, j);
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.d.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public void g() {
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.e.acquire();
        this.a.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.e.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int a() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT count(*) from LogRecord", 0);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int b() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT max(seqId) from LogRecord", 0);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int c() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT min(seqId) from LogRecord", 0);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public long d() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT min(clientTimestamp) from LogRecord", 0);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getLong(0) : 0L;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public List<LogRecord> e() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord", 0);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("seqId");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("channelType");
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("channelSeqId");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("customType");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("customSeqId");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("clientTimestamp");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("payload");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new LogRecord(cursorQuery.getInt(columnIndexOrThrow), com.kwai.kanas.vader.a.a(cursorQuery.getInt(columnIndexOrThrow2)), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getBlob(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public List<LogRecord> a(int i) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("seqId");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("channelType");
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("channelSeqId");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("customType");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("customSeqId");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("clientTimestamp");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("payload");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new LogRecord(cursorQuery.getInt(columnIndexOrThrow), com.kwai.kanas.vader.a.a(cursorQuery.getInt(columnIndexOrThrow2)), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getBlob(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public List<LogRecord> a(Channel channel, int i, int i2, int i3) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM LogRecord WHERE channelType = ? AND channelSeqId >= ? AND channelSeqId < ? LIMIT ?", 4);
        roomSQLiteQueryAcquire.bindLong(1, com.kwai.kanas.vader.a.a(channel));
        roomSQLiteQueryAcquire.bindLong(2, i);
        roomSQLiteQueryAcquire.bindLong(3, i2);
        roomSQLiteQueryAcquire.bindLong(4, i3);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("seqId");
            int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("channelType");
            int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("channelSeqId");
            int columnIndexOrThrow4 = cursorQuery.getColumnIndexOrThrow("customType");
            int columnIndexOrThrow5 = cursorQuery.getColumnIndexOrThrow("customSeqId");
            int columnIndexOrThrow6 = cursorQuery.getColumnIndexOrThrow("clientTimestamp");
            int columnIndexOrThrow7 = cursorQuery.getColumnIndexOrThrow("payload");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new LogRecord(cursorQuery.getInt(columnIndexOrThrow), com.kwai.kanas.vader.a.a(cursorQuery.getInt(columnIndexOrThrow2)), cursorQuery.getInt(columnIndexOrThrow3), cursorQuery.getString(columnIndexOrThrow4), cursorQuery.getInt(columnIndexOrThrow5), cursorQuery.getLong(columnIndexOrThrow6), cursorQuery.getBlob(columnIndexOrThrow7)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int f() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT max(seqId) FROM LogRecord", 0);
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int a(Channel channel) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT max(channelSeqId) FROM LogRecord WHERE channelType = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, com.kwai.kanas.vader.a.a(channel));
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.kwai.kanas.vader.persistent.c
    public int a(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT max(customType) FROM LogRecord WHERE customType = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        Cursor cursorQuery = this.a.query(roomSQLiteQueryAcquire);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
