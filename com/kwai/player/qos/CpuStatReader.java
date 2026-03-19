package com.kwai.player.qos;

import android.os.SystemClock;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class CpuStatReader {
    private static final String TAG = "com.kwai.player.qos.CpuStatReader";
    private long lastGuestNicTime;
    private long lastGuestTime;
    private long lastIdleTime;
    private long lastIowaitTime;
    private long lastIrqTime;
    private long lastNiceTime;
    private long lastSoftirqTime;
    private long lastStealTime;
    private long lastSystemTime;
    private long lastUpdateInterval;
    private long lastUpdateTime;
    private long lastUserTime;
    private long[] stats = new long[10];
    private long[] lastStats = new long[10];
    private boolean lastReadSuccess = false;

    public CpuStatReader() {
        update();
    }

    public void update() {
        boolean z;
        this.lastReadSuccess = false;
        if (readSystemStat(this.stats)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i = 0;
            while (true) {
                if (i >= 10) {
                    z = true;
                    break;
                } else {
                    if (this.stats[i] < this.lastStats[i]) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                long[] jArr = this.lastStats;
                long j = jArr[0];
                if (j != 0) {
                    long[] jArr2 = this.stats;
                    this.lastUserTime = jArr2[0] - j;
                    this.lastNiceTime = jArr2[1] - jArr[1];
                    this.lastSystemTime = jArr2[2] - jArr[2];
                    this.lastIdleTime = jArr2[3] - jArr[3];
                    this.lastIowaitTime = jArr2[4] - jArr[4];
                    this.lastIrqTime = jArr2[5] - jArr[5];
                    this.lastSoftirqTime = jArr2[6] - jArr[6];
                    this.lastStealTime = jArr2[7] - jArr[7];
                    this.lastGuestTime = jArr2[8] - jArr[8];
                    this.lastGuestNicTime = jArr2[9] - jArr[9];
                    this.lastReadSuccess = true;
                    this.lastUpdateInterval = jElapsedRealtime - this.lastUpdateTime;
                }
                this.lastUpdateTime = SystemClock.elapsedRealtime();
                System.arraycopy(this.stats, 0, this.lastStats, 0, 10);
            }
        }
    }

    private boolean readSystemStat(long[] jArr) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", t.k);
            String line = randomAccessFile.readLine();
            randomAccessFile.close();
            return parseSystemStat(line, jArr);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean parseSystemStat(String str, long[] jArr) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.split("\\s+");
        for (int i = 1; i <= 10; i++) {
            try {
                jArr[i - 1] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public long getLastUserTime() {
        return this.lastUserTime;
    }

    public long getLastNiceTime() {
        return this.lastNiceTime;
    }

    public long getLastSystemTime() {
        return this.lastSystemTime;
    }

    public long getLastIdleTime() {
        return this.lastIdleTime;
    }

    public long getLastIowaitTime() {
        return this.lastIowaitTime;
    }

    public long getLastIrqTime() {
        return this.lastIrqTime;
    }

    public long getLastSoftirqTime() {
        return this.lastSoftirqTime;
    }

    public long getLastStealTime() {
        return this.lastStealTime;
    }

    public long getLastGuestTime() {
        return this.lastGuestTime;
    }

    public long getLastGuestNicTime() {
        return this.lastGuestNicTime;
    }

    public long getLastUpdateInterval() {
        return this.lastUpdateInterval;
    }

    public long getLastTotalTime() {
        return this.lastUserTime + this.lastNiceTime + this.lastSystemTime + this.lastIdleTime + this.lastIowaitTime + this.lastIrqTime + this.lastSoftirqTime + this.lastStealTime + this.lastGuestTime + this.lastGuestNicTime;
    }

    public boolean getLastReadSuccess() {
        return this.lastReadSuccess;
    }
}
