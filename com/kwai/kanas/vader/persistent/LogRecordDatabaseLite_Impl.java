package com.kwai.kanas.vader.persistent;

import android.arch.persistence.room.InvalidationTracker;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LogRecordDatabaseLite_Impl extends LogRecordDatabase_Impl {
    @Override // com.kwai.kanas.vader.persistent.LogRecordDatabase_Impl, android.arch.persistence.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new b(this, "");
    }
}
