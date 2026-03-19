package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkCritMoment extends MessageNano {
    private static volatile LiveMultiPkCritMoment[] _emptyArray;
    public long critMomentEndTime;
    public long critMomentId;
    public long critMomentStartTime;
    public String multiPkBandText;
    public String multiPkId;
    public LiveMultiPkQuickGiftPanelConfig quickGiftPanelConfig;
    public int showAnimationEndIntervalSecond;
    public long timestamp;

    public static LiveMultiPkCritMoment[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkCritMoment[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkCritMoment() {
        clear();
    }

    public final LiveMultiPkCritMoment clear() {
        this.critMomentStartTime = 0L;
        this.critMomentEndTime = 0L;
        this.multiPkBandText = "";
        this.showAnimationEndIntervalSecond = 0;
        this.timestamp = 0L;
        this.multiPkId = "";
        this.critMomentId = 0L;
        this.quickGiftPanelConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.critMomentStartTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.critMomentEndTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        if (!this.multiPkBandText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.multiPkBandText);
        }
        int i = this.showAnimationEndIntervalSecond;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.multiPkId.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.multiPkId);
        }
        long j4 = this.critMomentId;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j4);
        }
        LiveMultiPkQuickGiftPanelConfig liveMultiPkQuickGiftPanelConfig = this.quickGiftPanelConfig;
        if (liveMultiPkQuickGiftPanelConfig != null) {
            codedOutputByteBufferNano.writeMessage(8, liveMultiPkQuickGiftPanelConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.critMomentStartTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.critMomentEndTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        if (!this.multiPkBandText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.multiPkBandText);
        }
        int i = this.showAnimationEndIntervalSecond;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.multiPkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.multiPkId);
        }
        long j4 = this.critMomentId;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
        }
        LiveMultiPkQuickGiftPanelConfig liveMultiPkQuickGiftPanelConfig = this.quickGiftPanelConfig;
        return liveMultiPkQuickGiftPanelConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, liveMultiPkQuickGiftPanelConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkCritMoment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.critMomentStartTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.critMomentEndTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.multiPkBandText = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.showAnimationEndIntervalSecond = codedInputByteBufferNano.readUInt32();
            } else if (tag == 40) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                this.multiPkId = codedInputByteBufferNano.readString();
            } else if (tag == 56) {
                this.critMomentId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.quickGiftPanelConfig == null) {
                    this.quickGiftPanelConfig = new LiveMultiPkQuickGiftPanelConfig();
                }
                codedInputByteBufferNano.readMessage(this.quickGiftPanelConfig);
            }
        }
    }

    public static LiveMultiPkCritMoment parseFrom(byte[] bArr) {
        return (LiveMultiPkCritMoment) MessageNano.mergeFrom(new LiveMultiPkCritMoment(), bArr);
    }

    public static LiveMultiPkCritMoment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkCritMoment().mergeFrom(codedInputByteBufferNano);
    }
}
