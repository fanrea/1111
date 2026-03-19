package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveGuideButton extends MessageNano {
    private static volatile InteractiveGuideButton[] _emptyArray;
    public String backgroundColor;
    public String clickAction;
    public String content;

    public static InteractiveGuideButton[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveGuideButton[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveGuideButton() {
        clear();
    }

    public final InteractiveGuideButton clear() {
        this.content = "";
        this.clickAction = "";
        this.backgroundColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.content);
        }
        if (!this.clickAction.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.clickAction);
        }
        if (!this.backgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.backgroundColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
        }
        if (!this.clickAction.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.clickAction);
        }
        return !this.backgroundColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.backgroundColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveGuideButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.clickAction = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.backgroundColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static InteractiveGuideButton parseFrom(byte[] bArr) {
        return (InteractiveGuideButton) MessageNano.mergeFrom(new InteractiveGuideButton(), bArr);
    }

    public static InteractiveGuideButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveGuideButton().mergeFrom(codedInputByteBufferNano);
    }
}
