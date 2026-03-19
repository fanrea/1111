package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveConditionRedPackClose extends MessageNano {
    private static volatile SCLiveConditionRedPackClose[] _emptyArray;
    public String liveStreamId;
    public int redPackBizType;
    public String redPackId;
    public int redPackType;

    public static SCLiveConditionRedPackClose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveConditionRedPackClose[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveConditionRedPackClose() {
        clear();
    }

    public final SCLiveConditionRedPackClose clear() {
        this.liveStreamId = "";
        this.redPackType = 0;
        this.redPackId = "";
        this.redPackBizType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.redPackId);
        }
        int i2 = this.redPackBizType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.redPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.redPackId);
        }
        int i2 = this.redPackBizType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveConditionRedPackClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 != 0 && int32 != 1 && int32 != 2) {
                    switch (int32) {
                    }
                }
                this.redPackType = int32;
            } else if (tag == 26) {
                this.redPackId = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.redPackBizType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveConditionRedPackClose parseFrom(byte[] bArr) {
        return (SCLiveConditionRedPackClose) MessageNano.mergeFrom(new SCLiveConditionRedPackClose(), bArr);
    }

    public static SCLiveConditionRedPackClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveConditionRedPackClose().mergeFrom(codedInputByteBufferNano);
    }
}
