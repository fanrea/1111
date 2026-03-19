package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveStickerInfo extends MessageNano {
    private static volatile SCLiveStickerInfo[] _emptyArray;
    public LiveSticker[] sticker;

    public static SCLiveStickerInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveStickerInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveStickerInfo() {
        clear();
    }

    public final SCLiveStickerInfo clear() {
        this.sticker = LiveSticker.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveSticker[] liveStickerArr = this.sticker;
        if (liveStickerArr != null && liveStickerArr.length > 0) {
            int i = 0;
            while (true) {
                LiveSticker[] liveStickerArr2 = this.sticker;
                if (i >= liveStickerArr2.length) {
                    break;
                }
                LiveSticker liveSticker = liveStickerArr2[i];
                if (liveSticker != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveSticker);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveSticker[] liveStickerArr = this.sticker;
        if (liveStickerArr != null && liveStickerArr.length > 0) {
            int i = 0;
            while (true) {
                LiveSticker[] liveStickerArr2 = this.sticker;
                if (i >= liveStickerArr2.length) {
                    break;
                }
                LiveSticker liveSticker = liveStickerArr2[i];
                if (liveSticker != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveSticker);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveStickerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveSticker[] liveStickerArr = this.sticker;
                int length = liveStickerArr == null ? 0 : liveStickerArr.length;
                LiveSticker[] liveStickerArr2 = new LiveSticker[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.sticker, 0, liveStickerArr2, 0, length);
                }
                while (length < liveStickerArr2.length - 1) {
                    liveStickerArr2[length] = new LiveSticker();
                    codedInputByteBufferNano.readMessage(liveStickerArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveStickerArr2[length] = new LiveSticker();
                codedInputByteBufferNano.readMessage(liveStickerArr2[length]);
                this.sticker = liveStickerArr2;
            }
        }
    }

    public static SCLiveStickerInfo parseFrom(byte[] bArr) {
        return (SCLiveStickerInfo) MessageNano.mergeFrom(new SCLiveStickerInfo(), bArr);
    }

    public static SCLiveStickerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveStickerInfo().mergeFrom(codedInputByteBufferNano);
    }
}
