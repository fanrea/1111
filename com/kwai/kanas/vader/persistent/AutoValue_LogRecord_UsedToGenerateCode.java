package com.kwai.kanas.vader.persistent;

import com.alipay.sdk.m.u.i;
import com.kwai.kanas.vader.Channel;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_LogRecord_UsedToGenerateCode extends LogRecord_UsedToGenerateCode {
    private final int channelSeqId;
    private final Channel channelType;
    private final long clientTimestamp;
    private final int customSeqId;
    private final String customType;
    private final byte[] payload;
    private final int seqId;

    AutoValue_LogRecord_UsedToGenerateCode(int i, Channel channel, int i2, String str, int i3, long j, byte[] bArr) {
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

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final int seqId() {
        return this.seqId;
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final Channel channelType() {
        return this.channelType;
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final int channelSeqId() {
        return this.channelSeqId;
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final String customType() {
        return this.customType;
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final int customSeqId() {
        return this.customSeqId;
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final long clientTimestamp() {
        return this.clientTimestamp;
    }

    @Override // com.kwai.kanas.vader.persistent.LogRecord_UsedToGenerateCode
    public final byte[] payload() {
        return this.payload;
    }

    public final String toString() {
        return "LogRecord_UsedToGenerateCode{seqId=" + this.seqId + ", channelType=" + this.channelType + ", channelSeqId=" + this.channelSeqId + ", customType=" + this.customType + ", customSeqId=" + this.customSeqId + ", clientTimestamp=" + this.clientTimestamp + ", payload=" + Arrays.toString(this.payload) + i.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogRecord_UsedToGenerateCode) {
            LogRecord_UsedToGenerateCode logRecord_UsedToGenerateCode = (LogRecord_UsedToGenerateCode) obj;
            if (this.seqId == logRecord_UsedToGenerateCode.seqId() && this.channelType.equals(logRecord_UsedToGenerateCode.channelType()) && this.channelSeqId == logRecord_UsedToGenerateCode.channelSeqId() && this.customType.equals(logRecord_UsedToGenerateCode.customType()) && this.customSeqId == logRecord_UsedToGenerateCode.customSeqId() && this.clientTimestamp == logRecord_UsedToGenerateCode.clientTimestamp()) {
                if (Arrays.equals(this.payload, logRecord_UsedToGenerateCode instanceof AutoValue_LogRecord_UsedToGenerateCode ? ((AutoValue_LogRecord_UsedToGenerateCode) logRecord_UsedToGenerateCode).payload : logRecord_UsedToGenerateCode.payload())) {
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
