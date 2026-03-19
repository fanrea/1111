package com.bytedance.bmf;

import androidx.core.location.LocationRequestCompat;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public enum Timestamp {
    UNSET(-1),
    BMF_PAUSE(9223372036854775802L),
    EOF(9223372036854775804L),
    EOS(9223372036854775805L),
    INF_SRC(9223372036854775806L),
    DONE(LocationRequestCompat.PASSIVE_INTERVAL);

    private long value;

    Timestamp(long value) {
        this.value = value;
    }

    public long getValue() {
        return this.value;
    }
}
