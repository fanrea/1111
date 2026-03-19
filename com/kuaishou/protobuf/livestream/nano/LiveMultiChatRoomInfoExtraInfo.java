package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiChatRoomInfoExtraInfo extends MessageNano {
    private static volatile LiveMultiChatRoomInfoExtraInfo[] _emptyArray;
    public int theme;
    public LiveMultiChatUserLabel[] userLabel;

    public static LiveMultiChatRoomInfoExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiChatRoomInfoExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiChatRoomInfoExtraInfo() {
        clear();
    }

    public final LiveMultiChatRoomInfoExtraInfo clear() {
        this.userLabel = LiveMultiChatUserLabel.emptyArray();
        this.theme = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveMultiChatUserLabel[] liveMultiChatUserLabelArr = this.userLabel;
        if (liveMultiChatUserLabelArr != null && liveMultiChatUserLabelArr.length > 0) {
            int i = 0;
            while (true) {
                LiveMultiChatUserLabel[] liveMultiChatUserLabelArr2 = this.userLabel;
                if (i >= liveMultiChatUserLabelArr2.length) {
                    break;
                }
                LiveMultiChatUserLabel liveMultiChatUserLabel = liveMultiChatUserLabelArr2[i];
                if (liveMultiChatUserLabel != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveMultiChatUserLabel);
                }
                i++;
            }
        }
        int i2 = this.theme;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveMultiChatUserLabel[] liveMultiChatUserLabelArr = this.userLabel;
        if (liveMultiChatUserLabelArr != null && liveMultiChatUserLabelArr.length > 0) {
            int i = 0;
            while (true) {
                LiveMultiChatUserLabel[] liveMultiChatUserLabelArr2 = this.userLabel;
                if (i >= liveMultiChatUserLabelArr2.length) {
                    break;
                }
                LiveMultiChatUserLabel liveMultiChatUserLabel = liveMultiChatUserLabelArr2[i];
                if (liveMultiChatUserLabel != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveMultiChatUserLabel);
                }
                i++;
            }
        }
        int i2 = this.theme;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiChatRoomInfoExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveMultiChatUserLabel[] liveMultiChatUserLabelArr = this.userLabel;
                int length = liveMultiChatUserLabelArr == null ? 0 : liveMultiChatUserLabelArr.length;
                LiveMultiChatUserLabel[] liveMultiChatUserLabelArr2 = new LiveMultiChatUserLabel[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userLabel, 0, liveMultiChatUserLabelArr2, 0, length);
                }
                while (length < liveMultiChatUserLabelArr2.length - 1) {
                    liveMultiChatUserLabelArr2[length] = new LiveMultiChatUserLabel();
                    codedInputByteBufferNano.readMessage(liveMultiChatUserLabelArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveMultiChatUserLabelArr2[length] = new LiveMultiChatUserLabel();
                codedInputByteBufferNano.readMessage(liveMultiChatUserLabelArr2[length]);
                this.userLabel = liveMultiChatUserLabelArr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.theme = int32;
                }
            }
        }
    }

    public static LiveMultiChatRoomInfoExtraInfo parseFrom(byte[] bArr) {
        return (LiveMultiChatRoomInfoExtraInfo) MessageNano.mergeFrom(new LiveMultiChatRoomInfoExtraInfo(), bArr);
    }

    public static LiveMultiChatRoomInfoExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiChatRoomInfoExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
