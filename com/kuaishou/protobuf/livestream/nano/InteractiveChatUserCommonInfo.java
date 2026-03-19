package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatUserCommonInfo extends MessageNano {
    private static volatile InteractiveChatUserCommonInfo[] _emptyArray;
    public int mediaType;
    public boolean muteState;

    public static InteractiveChatUserCommonInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatUserCommonInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatUserCommonInfo() {
        clear();
    }

    public final InteractiveChatUserCommonInfo clear() {
        this.muteState = false;
        this.mediaType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.muteState;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        int i = this.mediaType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.muteState;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        int i = this.mediaType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatUserCommonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.muteState = codedInputByteBufferNano.readBool();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.mediaType = int32;
                }
            }
        }
    }

    public static InteractiveChatUserCommonInfo parseFrom(byte[] bArr) {
        return (InteractiveChatUserCommonInfo) MessageNano.mergeFrom(new InteractiveChatUserCommonInfo(), bArr);
    }

    public static InteractiveChatUserCommonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatUserCommonInfo().mergeFrom(codedInputByteBufferNano);
    }
}
