package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiChatStart extends MessageNano {
    private static volatile LiveMultiChatStart[] _emptyArray;
    public boolean enableGuestGift;
    public boolean enableUpdateLayoutTheme;
    public int theme;

    public static LiveMultiChatStart[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiChatStart[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiChatStart() {
        clear();
    }

    public final LiveMultiChatStart clear() {
        this.enableUpdateLayoutTheme = false;
        this.theme = 0;
        this.enableGuestGift = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.enableUpdateLayoutTheme;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        int i = this.theme;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        boolean z2 = this.enableGuestGift;
        if (z2) {
            codedOutputByteBufferNano.writeBool(3, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enableUpdateLayoutTheme;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        int i = this.theme;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        boolean z2 = this.enableGuestGift;
        return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiChatStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.enableUpdateLayoutTheme = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.theme = int32;
                }
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableGuestGift = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveMultiChatStart parseFrom(byte[] bArr) {
        return (LiveMultiChatStart) MessageNano.mergeFrom(new LiveMultiChatStart(), bArr);
    }

    public static LiveMultiChatStart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiChatStart().mergeFrom(codedInputByteBufferNano);
    }
}
