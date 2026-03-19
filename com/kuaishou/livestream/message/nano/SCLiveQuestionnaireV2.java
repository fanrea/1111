package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveQuestionnaireV2 extends MessageNano {
    private static volatile SCLiveQuestionnaireV2[] _emptyArray;
    public String liveStreamId;
    public int requestDelayMs;
    public int triggerType;

    public static SCLiveQuestionnaireV2[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveQuestionnaireV2[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveQuestionnaireV2() {
        clear();
    }

    public final SCLiveQuestionnaireV2 clear() {
        this.liveStreamId = "";
        this.triggerType = 0;
        this.requestDelayMs = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.triggerType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        int i2 = this.requestDelayMs;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.triggerType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        int i2 = this.requestDelayMs;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveQuestionnaireV2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.triggerType = codedInputByteBufferNano.readUInt32();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.requestDelayMs = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveQuestionnaireV2 parseFrom(byte[] bArr) {
        return (SCLiveQuestionnaireV2) MessageNano.mergeFrom(new SCLiveQuestionnaireV2(), bArr);
    }

    public static SCLiveQuestionnaireV2 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveQuestionnaireV2().mergeFrom(codedInputByteBufferNano);
    }
}
