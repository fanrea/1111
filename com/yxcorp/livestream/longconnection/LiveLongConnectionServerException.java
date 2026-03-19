package com.yxcorp.livestream.longconnection;

import com.yxcorp.gifshow.exception.ServerException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveLongConnectionServerException extends ServerException {
    public final long mMaxDelayMs;
    public final long mMinDelayMs;

    public LiveLongConnectionServerException(int i, int i2, String str, long j, long j2) {
        super(i, i2, str);
        this.mMinDelayMs = j;
        this.mMaxDelayMs = j2;
    }
}
