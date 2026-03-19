package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GridChatSoloPkBangsInfo extends MessageNano {
    private static volatile GridChatSoloPkBangsInfo[] _emptyArray;
    public String content;
    public long expireTimestamp;

    public static GridChatSoloPkBangsInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GridChatSoloPkBangsInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public GridChatSoloPkBangsInfo() {
        clear();
    }

    public final GridChatSoloPkBangsInfo clear() {
        this.content = "";
        this.expireTimestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.content);
        }
        long j = this.expireTimestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
        }
        long j = this.expireTimestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GridChatSoloPkBangsInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.expireTimestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static GridChatSoloPkBangsInfo parseFrom(byte[] bArr) {
        return (GridChatSoloPkBangsInfo) MessageNano.mergeFrom(new GridChatSoloPkBangsInfo(), bArr);
    }

    public static GridChatSoloPkBangsInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GridChatSoloPkBangsInfo().mergeFrom(codedInputByteBufferNano);
    }
}
