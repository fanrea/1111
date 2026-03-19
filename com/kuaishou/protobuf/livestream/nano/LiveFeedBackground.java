package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveFeedBackground extends MessageNano {
    private static volatile LiveFeedBackground[] _emptyArray;
    public String iconPath;
    public String resPackId;

    public static LiveFeedBackground[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveFeedBackground[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveFeedBackground() {
        clear();
    }

    public final LiveFeedBackground clear() {
        this.resPackId = "";
        this.iconPath = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.resPackId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.resPackId);
        }
        if (!this.iconPath.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.iconPath);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.resPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.resPackId);
        }
        return !this.iconPath.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.iconPath) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveFeedBackground mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.resPackId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.iconPath = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveFeedBackground parseFrom(byte[] bArr) {
        return (LiveFeedBackground) MessageNano.mergeFrom(new LiveFeedBackground(), bArr);
    }

    public static LiveFeedBackground parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveFeedBackground().mergeFrom(codedInputByteBufferNano);
    }
}
