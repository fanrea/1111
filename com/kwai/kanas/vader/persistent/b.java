package com.kwai.kanas.vader.persistent;

import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class b extends InvalidationTracker {
    @Override // android.arch.persistence.room.InvalidationTracker
    public void refreshVersionsAsync() {
    }

    public b(RoomDatabase roomDatabase, String... strArr) {
        super(roomDatabase, strArr);
    }
}
