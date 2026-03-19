package com.kwai.kanas.vader;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.kwai.kanas.vader.f.i;
import com.kwai.kanas.vader.persistent.LogRecordDatabase;
import com.kwai.kanas.vader.persistent.LogRecordDatabaseLite;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class e {
    private static final long a = 1048576;
    private i b;
    private String c;

    public e(i iVar, String str) {
        this.b = iVar;
        this.c = str;
    }

    LogRecordDatabase a(Context context) {
        RoomDatabase.JournalMode journalModeA = a(context, this.b);
        this.b.e().a("use_mode", "mode: " + journalModeA);
        return (LogRecordDatabase) Room.databaseBuilder(context, LogRecordDatabaseLite.class, this.b.a()).setJournalMode(journalModeA).build();
    }

    b a() {
        return this.b.e();
    }

    com.kwai.kanas.vader.b.b a(Context context, com.kwai.kanas.vader.persistent.e eVar, com.kwai.kanas.vader.e.e eVar2) {
        return new com.kwai.kanas.vader.b.b(context, Channel.REAL_TIME, this.b.e(), this.b.b(), eVar, eVar2, TimeUnit.MILLISECONDS.toMillis(100L));
    }

    com.kwai.kanas.vader.b.b b(Context context, com.kwai.kanas.vader.persistent.e eVar, com.kwai.kanas.vader.e.e eVar2) {
        return new com.kwai.kanas.vader.b.b(context, Channel.HIGH_FREQ, this.b.e(), this.b.c(), eVar, eVar2, TimeUnit.SECONDS.toMillis(5L));
    }

    com.kwai.kanas.vader.b.b c(Context context, com.kwai.kanas.vader.persistent.e eVar, com.kwai.kanas.vader.e.e eVar2) {
        return new com.kwai.kanas.vader.b.b(context, Channel.NORMAL, this.b.e(), this.b.d(), eVar, eVar2, TimeUnit.MINUTES.toMillis(2L));
    }

    String b() {
        return this.c;
    }

    i c() {
        return this.b;
    }

    private static RoomDatabase.JournalMode a(Context context, i iVar) {
        RoomDatabase.JournalMode journalMode = RoomDatabase.JournalMode.AUTOMATIC;
        if (d()) {
            journalMode = RoomDatabase.JournalMode.TRUNCATE;
            String absolutePath = context.getDatabasePath(iVar.a()).getAbsolutePath();
            File file = new File(absolutePath + "-shm");
            File file2 = new File(absolutePath + "-wal");
            boolean z = false;
            boolean z2 = !file.exists() || (file.exists() && file.delete());
            if (!file2.exists() || (file2.exists() && file2.delete())) {
                z = true;
            }
            iVar.e().a("force_delete_wal_files", "shm: " + z2 + ", wal: " + z);
        }
        return journalMode;
    }

    private static boolean d() {
        return Build.VERSION.SDK_INT < 21 && a(Environment.getDataDirectory()) < 1048576;
    }

    private static long a(File file) {
        long blockSizeLong;
        long availableBlocksLong;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT < 18) {
            blockSizeLong = statFs.getBlockSize();
            availableBlocksLong = statFs.getAvailableBlocks();
        } else {
            blockSizeLong = statFs.getBlockSizeLong();
            availableBlocksLong = statFs.getAvailableBlocksLong();
        }
        return blockSizeLong * availableBlocksLong;
    }
}
