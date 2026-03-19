package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveChatApplyUserCntUpdate extends MessageNano {
    private static volatile SCLiveChatApplyUserCntUpdate[] _emptyArray;
    public long applyUserCnt;
    public String liveStreamId;

    public static SCLiveChatApplyUserCntUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveChatApplyUserCntUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveChatApplyUserCntUpdate() {
        clear();
    }

    public final SCLiveChatApplyUserCntUpdate clear() {
        this.liveStreamId = "";
        this.applyUserCnt = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        long j = this.applyUserCnt;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        long j = this.applyUserCnt;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveChatApplyUserCntUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.applyUserCnt = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveChatApplyUserCntUpdate parseFrom(byte[] bArr) {
        return (SCLiveChatApplyUserCntUpdate) MessageNano.mergeFrom(new SCLiveChatApplyUserCntUpdate(), bArr);
    }

    public static SCLiveChatApplyUserCntUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveChatApplyUserCntUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
