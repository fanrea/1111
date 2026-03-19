package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveArenaLineChatStatistic extends MessageNano {
    private static volatile SCLiveArenaLineChatStatistic[] _emptyArray;
    public String arenaLineChatId;
    public String liveStreamId;
    public String multiLineChatId;
    public LiveArenaLineChatStatistic statistic;

    public static SCLiveArenaLineChatStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveArenaLineChatStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveArenaLineChatStatistic() {
        clear();
    }

    public final SCLiveArenaLineChatStatistic clear() {
        this.liveStreamId = "";
        this.multiLineChatId = "";
        this.arenaLineChatId = "";
        this.statistic = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.multiLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.multiLineChatId);
        }
        if (!this.arenaLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.arenaLineChatId);
        }
        LiveArenaLineChatStatistic liveArenaLineChatStatistic = this.statistic;
        if (liveArenaLineChatStatistic != null) {
            codedOutputByteBufferNano.writeMessage(4, liveArenaLineChatStatistic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.multiLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.multiLineChatId);
        }
        if (!this.arenaLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.arenaLineChatId);
        }
        LiveArenaLineChatStatistic liveArenaLineChatStatistic = this.statistic;
        return liveArenaLineChatStatistic != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, liveArenaLineChatStatistic) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveArenaLineChatStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.multiLineChatId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.arenaLineChatId = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.statistic == null) {
                    this.statistic = new LiveArenaLineChatStatistic();
                }
                codedInputByteBufferNano.readMessage(this.statistic);
            }
        }
    }

    public static SCLiveArenaLineChatStatistic parseFrom(byte[] bArr) {
        return (SCLiveArenaLineChatStatistic) MessageNano.mergeFrom(new SCLiveArenaLineChatStatistic(), bArr);
    }

    public static SCLiveArenaLineChatStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveArenaLineChatStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
