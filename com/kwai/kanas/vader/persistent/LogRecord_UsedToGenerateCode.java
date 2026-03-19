package com.kwai.kanas.vader.persistent;

import com.kwai.kanas.vader.Channel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class LogRecord_UsedToGenerateCode {
    public abstract int channelSeqId();

    public abstract Channel channelType();

    public abstract long clientTimestamp();

    public abstract int customSeqId();

    public abstract String customType();

    public abstract byte[] payload();

    public abstract int seqId();

    public static LogRecord_UsedToGenerateCode create(int i, Channel channel, int i2, String str, int i3, long j, byte[] bArr) {
        return new AutoValue_LogRecord_UsedToGenerateCode(i, channel, i2, str, i3, j, bArr);
    }
}
