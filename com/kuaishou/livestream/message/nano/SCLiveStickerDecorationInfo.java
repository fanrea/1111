package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveStickerDecorationInfo extends MessageNano {
    private static volatile SCLiveStickerDecorationInfo[] _emptyArray;
    public String groupId;
    public LiveSticker sticker;

    public static SCLiveStickerDecorationInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveStickerDecorationInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveStickerDecorationInfo() {
        clear();
    }

    public final SCLiveStickerDecorationInfo clear() {
        this.groupId = "";
        this.sticker = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.groupId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.groupId);
        }
        LiveSticker liveSticker = this.sticker;
        if (liveSticker != null) {
            codedOutputByteBufferNano.writeMessage(2, liveSticker);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.groupId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.groupId);
        }
        LiveSticker liveSticker = this.sticker;
        return liveSticker != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, liveSticker) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveStickerDecorationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.groupId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.sticker == null) {
                    this.sticker = new LiveSticker();
                }
                codedInputByteBufferNano.readMessage(this.sticker);
            }
        }
    }

    public static SCLiveStickerDecorationInfo parseFrom(byte[] bArr) {
        return (SCLiveStickerDecorationInfo) MessageNano.mergeFrom(new SCLiveStickerDecorationInfo(), bArr);
    }

    public static SCLiveStickerDecorationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveStickerDecorationInfo().mergeFrom(codedInputByteBufferNano);
    }
}
