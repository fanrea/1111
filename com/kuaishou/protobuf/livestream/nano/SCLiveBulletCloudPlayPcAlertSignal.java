package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletCloudPlayPcAlertSignal extends MessageNano {
    private static volatile SCLiveBulletCloudPlayPcAlertSignal[] _emptyArray;
    public long authorId;
    public String toastMessage;

    public static SCLiveBulletCloudPlayPcAlertSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletCloudPlayPcAlertSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletCloudPlayPcAlertSignal() {
        clear();
    }

    public final SCLiveBulletCloudPlayPcAlertSignal clear() {
        this.authorId = 0L;
        this.toastMessage = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.toastMessage.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.toastMessage);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        return !this.toastMessage.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.toastMessage) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletCloudPlayPcAlertSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.toastMessage = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveBulletCloudPlayPcAlertSignal parseFrom(byte[] bArr) {
        return (SCLiveBulletCloudPlayPcAlertSignal) MessageNano.mergeFrom(new SCLiveBulletCloudPlayPcAlertSignal(), bArr);
    }

    public static SCLiveBulletCloudPlayPcAlertSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletCloudPlayPcAlertSignal().mergeFrom(codedInputByteBufferNano);
    }
}
