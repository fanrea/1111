package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024EnhancePendantDisplay extends MessageNano {
    private static volatile SCLiveCny2024EnhancePendantDisplay[] _emptyArray;
    public String bizType;
    public int displayCount;
    public String pendantBizType;

    public static SCLiveCny2024EnhancePendantDisplay[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024EnhancePendantDisplay[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024EnhancePendantDisplay() {
        clear();
    }

    public final SCLiveCny2024EnhancePendantDisplay clear() {
        this.bizType = "";
        this.displayCount = 0;
        this.pendantBizType = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.bizType);
        }
        int i = this.displayCount;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.pendantBizType.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.pendantBizType);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.bizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizType);
        }
        int i = this.displayCount;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        return !this.pendantBizType.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.pendantBizType) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024EnhancePendantDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.bizType = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.displayCount = codedInputByteBufferNano.readInt32();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.pendantBizType = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveCny2024EnhancePendantDisplay parseFrom(byte[] bArr) {
        return (SCLiveCny2024EnhancePendantDisplay) MessageNano.mergeFrom(new SCLiveCny2024EnhancePendantDisplay(), bArr);
    }

    public static SCLiveCny2024EnhancePendantDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024EnhancePendantDisplay().mergeFrom(codedInputByteBufferNano);
    }
}
