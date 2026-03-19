package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveGuideIntroductionInfo extends MessageNano {
    private static volatile InteractiveGuideIntroductionInfo[] _emptyArray;
    public boolean hasCloseButton;
    public String title;

    public static InteractiveGuideIntroductionInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveGuideIntroductionInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveGuideIntroductionInfo() {
        clear();
    }

    public final InteractiveGuideIntroductionInfo clear() {
        this.title = "";
        this.hasCloseButton = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        boolean z = this.hasCloseButton;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        boolean z = this.hasCloseButton;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveGuideIntroductionInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.hasCloseButton = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static InteractiveGuideIntroductionInfo parseFrom(byte[] bArr) {
        return (InteractiveGuideIntroductionInfo) MessageNano.mergeFrom(new InteractiveGuideIntroductionInfo(), bArr);
    }

    public static InteractiveGuideIntroductionInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveGuideIntroductionInfo().mergeFrom(codedInputByteBufferNano);
    }
}
