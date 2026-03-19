package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MultiPKSignalCommonInfo extends MessageNano {
    private static volatile MultiPKSignalCommonInfo[] _emptyArray;
    public String chatId;
    public String pkId;
    public long timestamp;

    public static MultiPKSignalCommonInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MultiPKSignalCommonInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public MultiPKSignalCommonInfo() {
        clear();
    }

    public final MultiPKSignalCommonInfo clear() {
        this.timestamp = 0L;
        this.pkId = "";
        this.chatId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.pkId);
        }
        if (!this.chatId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.chatId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.pkId);
        }
        return !this.chatId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.chatId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MultiPKSignalCommonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.chatId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static MultiPKSignalCommonInfo parseFrom(byte[] bArr) {
        return (MultiPKSignalCommonInfo) MessageNano.mergeFrom(new MultiPKSignalCommonInfo(), bArr);
    }

    public static MultiPKSignalCommonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MultiPKSignalCommonInfo().mergeFrom(codedInputByteBufferNano);
    }
}
