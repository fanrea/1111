package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveArenaLineChatOpen extends MessageNano {
    private static volatile LiveArenaLineChatOpen[] _emptyArray;
    public int adjustOrderMinIntervalInSeconds;
    public String displayScorePrefix;
    public int playType;
    public String ruleUrl;
    public LiveArenaLineChatStatistic statistic;

    public static LiveArenaLineChatOpen[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveArenaLineChatOpen[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveArenaLineChatOpen() {
        clear();
    }

    public final LiveArenaLineChatOpen clear() {
        this.statistic = null;
        this.ruleUrl = "";
        this.adjustOrderMinIntervalInSeconds = 0;
        this.playType = 0;
        this.displayScorePrefix = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveArenaLineChatStatistic liveArenaLineChatStatistic = this.statistic;
        if (liveArenaLineChatStatistic != null) {
            codedOutputByteBufferNano.writeMessage(1, liveArenaLineChatStatistic);
        }
        if (!this.ruleUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.ruleUrl);
        }
        int i = this.adjustOrderMinIntervalInSeconds;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        int i2 = this.playType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        if (!this.displayScorePrefix.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.displayScorePrefix);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveArenaLineChatStatistic liveArenaLineChatStatistic = this.statistic;
        if (liveArenaLineChatStatistic != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveArenaLineChatStatistic);
        }
        if (!this.ruleUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.ruleUrl);
        }
        int i = this.adjustOrderMinIntervalInSeconds;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        int i2 = this.playType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
        }
        return !this.displayScorePrefix.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.displayScorePrefix) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveArenaLineChatOpen mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.statistic == null) {
                    this.statistic = new LiveArenaLineChatStatistic();
                }
                codedInputByteBufferNano.readMessage(this.statistic);
            } else if (tag == 18) {
                this.ruleUrl = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.adjustOrderMinIntervalInSeconds = codedInputByteBufferNano.readUInt32();
            } else if (tag == 32) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.playType = int32;
                }
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayScorePrefix = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveArenaLineChatOpen parseFrom(byte[] bArr) {
        return (LiveArenaLineChatOpen) MessageNano.mergeFrom(new LiveArenaLineChatOpen(), bArr);
    }

    public static LiveArenaLineChatOpen parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveArenaLineChatOpen().mergeFrom(codedInputByteBufferNano);
    }
}
