package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHotProgrammeInfo extends MessageNano {
    private static volatile LiveHotProgrammeInfo[] _emptyArray;
    public long hotValue;
    public long itemId;
    public String text;

    public static LiveHotProgrammeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHotProgrammeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHotProgrammeInfo() {
        clear();
    }

    public final LiveHotProgrammeInfo clear() {
        this.itemId = 0L;
        this.text = "";
        this.hotValue = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.itemId;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.text);
        }
        long j2 = this.hotValue;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.itemId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
        }
        long j2 = this.hotValue;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHotProgrammeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.itemId = codedInputByteBufferNano.readInt64();
            } else if (tag == 18) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.hotValue = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static LiveHotProgrammeInfo parseFrom(byte[] bArr) {
        return (LiveHotProgrammeInfo) MessageNano.mergeFrom(new LiveHotProgrammeInfo(), bArr);
    }

    public static LiveHotProgrammeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHotProgrammeInfo().mergeFrom(codedInputByteBufferNano);
    }
}
