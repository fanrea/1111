package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GzoneAuthorCommonNotice extends MessageNano {
    private static volatile GzoneAuthorCommonNotice[] _emptyArray;
    public GzoneCommonNoticeButton button;
    public String content;
    public long displayDurationMs;
    public String extraInfo;
    public int type;

    public static GzoneAuthorCommonNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneAuthorCommonNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneAuthorCommonNotice() {
        clear();
    }

    public final GzoneAuthorCommonNotice clear() {
        this.type = 0;
        this.content = "";
        this.button = null;
        this.displayDurationMs = 0L;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.content);
        }
        GzoneCommonNoticeButton gzoneCommonNoticeButton = this.button;
        if (gzoneCommonNoticeButton != null) {
            codedOutputByteBufferNano.writeMessage(3, gzoneCommonNoticeButton);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.content);
        }
        GzoneCommonNoticeButton gzoneCommonNoticeButton = this.button;
        if (gzoneCommonNoticeButton != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gzoneCommonNoticeButton);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneAuthorCommonNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.type = int32;
                }
            } else if (tag == 18) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                if (this.button == null) {
                    this.button = new GzoneCommonNoticeButton();
                }
                codedInputByteBufferNano.readMessage(this.button);
            } else if (tag == 32) {
                this.displayDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.extraInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static GzoneAuthorCommonNotice parseFrom(byte[] bArr) {
        return (GzoneAuthorCommonNotice) MessageNano.mergeFrom(new GzoneAuthorCommonNotice(), bArr);
    }

    public static GzoneAuthorCommonNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneAuthorCommonNotice().mergeFrom(codedInputByteBufferNano);
    }
}
