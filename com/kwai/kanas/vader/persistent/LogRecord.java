package com.kwai.kanas.vader.persistent;

import com.alipay.sdk.m.u.i;
import com.kwai.kanas.vader.Channel;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LogRecord {
    private final int channelSeqId;
    private final Channel channelType;
    private final long clientTimestamp;
    private final int customSeqId;
    private final String customType;
    private final byte[] payload;
    private final int seqId;

    public LogRecord(int i, Channel channel, int i2, String str, int i3, long j, byte[] bArr) {
        this.seqId = i;
        if (channel == null) {
            throw new NullPointerException("Null channelType");
        }
        this.channelType = channel;
        this.channelSeqId = i2;
        if (str == null) {
            throw new NullPointerException("Null customType");
        }
        this.customType = str;
        this.customSeqId = i3;
        this.clientTimestamp = j;
        if (bArr == null) {
            throw new NullPointerException("Null payload");
        }
        this.payload = bArr;
    }

    public final int seqId() {
        return this.seqId;
    }

    public final Channel channelType() {
        return this.channelType;
    }

    public final int channelSeqId() {
        return this.channelSeqId;
    }

    public final String customType() {
        return this.customType;
    }

    public final int customSeqId() {
        return this.customSeqId;
    }

    public final long clientTimestamp() {
        return this.clientTimestamp;
    }

    public final byte[] payload() {
        return this.payload;
    }

    public final String toString() {
        return "LogRecord_UsedToGenerateCode{seqId=" + this.seqId + ", channelType=" + this.channelType + ", channelId=" + this.channelSeqId + ", customType=" + this.customType + ", customId=" + this.customSeqId + ", clientTimestamp=" + this.clientTimestamp + ", payload=" + Arrays.toString(this.payload) + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogRecord) {
            LogRecord logRecord = (LogRecord) obj;
            if (this.seqId == logRecord.seqId() && this.channelType.equals(logRecord.channelType()) && this.channelSeqId == logRecord.channelSeqId() && this.customType.equals(logRecord.customType()) && this.customSeqId == logRecord.customSeqId() && this.clientTimestamp == logRecord.clientTimestamp()) {
                if (Arrays.equals(this.payload, logRecord instanceof LogRecord ? logRecord.payload : logRecord.payload())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((this.seqId ^ 1000003) * 1000003) ^ this.channelType.hashCode()) * 1000003) ^ this.channelSeqId) * 1000003) ^ this.customType.hashCode()) * 1000003) ^ this.customSeqId) * 1000003;
        long j = this.clientTimestamp;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ Arrays.hashCode(this.payload);
    }
}
