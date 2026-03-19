package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveStickerWarningInfo extends MessageNano {
    private static volatile SCLiveStickerWarningInfo[] _emptyArray;
    public String content;
    public String liveStreamId;
    public String title;

    public static SCLiveStickerWarningInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveStickerWarningInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveStickerWarningInfo() {
        clear();
    }

    public final SCLiveStickerWarningInfo clear() {
        this.title = "";
        this.content = "";
        this.liveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.content);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveStreamId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.content);
        }
        return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveStickerWarningInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.liveStreamId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveStickerWarningInfo parseFrom(byte[] bArr) {
        return (SCLiveStickerWarningInfo) MessageNano.mergeFrom(new SCLiveStickerWarningInfo(), bArr);
    }

    public static SCLiveStickerWarningInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveStickerWarningInfo().mergeFrom(codedInputByteBufferNano);
    }
}
