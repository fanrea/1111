package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveEncourageTreasureBoxRewardCartoon extends MessageNano {
    private static volatile SCLiveEncourageTreasureBoxRewardCartoon[] _emptyArray;
    public long rewardAmount;
    public int showSeconds;
    public long taskId;
    public String text;

    public static SCLiveEncourageTreasureBoxRewardCartoon[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveEncourageTreasureBoxRewardCartoon[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveEncourageTreasureBoxRewardCartoon() {
        clear();
    }

    public final SCLiveEncourageTreasureBoxRewardCartoon clear() {
        this.taskId = 0L;
        this.rewardAmount = 0L;
        this.text = "";
        this.showSeconds = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.taskId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.rewardAmount;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.text);
        }
        int i = this.showSeconds;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.taskId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.rewardAmount;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.text);
        }
        int i = this.showSeconds;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveEncourageTreasureBoxRewardCartoon mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.taskId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.rewardAmount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.showSeconds = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveEncourageTreasureBoxRewardCartoon parseFrom(byte[] bArr) {
        return (SCLiveEncourageTreasureBoxRewardCartoon) MessageNano.mergeFrom(new SCLiveEncourageTreasureBoxRewardCartoon(), bArr);
    }

    public static SCLiveEncourageTreasureBoxRewardCartoon parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveEncourageTreasureBoxRewardCartoon().mergeFrom(codedInputByteBufferNano);
    }
}
