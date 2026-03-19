package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GzoneAuthorTaskProgressNotice extends MessageNano {
    private static volatile GzoneAuthorTaskProgressNotice[] _emptyArray;
    public long displayDurationMs;
    public String noticeText;
    public int noticeType;

    public static GzoneAuthorTaskProgressNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneAuthorTaskProgressNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneAuthorTaskProgressNotice() {
        clear();
    }

    public final GzoneAuthorTaskProgressNotice clear() {
        this.noticeType = 0;
        this.noticeText = "";
        this.displayDurationMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.noticeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.noticeText.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.noticeText);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.noticeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.noticeText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.noticeText);
        }
        long j = this.displayDurationMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneAuthorTaskProgressNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.noticeType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.noticeText = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayDurationMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static GzoneAuthorTaskProgressNotice parseFrom(byte[] bArr) {
        return (GzoneAuthorTaskProgressNotice) MessageNano.mergeFrom(new GzoneAuthorTaskProgressNotice(), bArr);
    }

    public static GzoneAuthorTaskProgressNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneAuthorTaskProgressNotice().mergeFrom(codedInputByteBufferNano);
    }
}
