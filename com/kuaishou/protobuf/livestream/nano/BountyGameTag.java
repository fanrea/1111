package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BountyGameTag extends MessageNano {
    private static volatile BountyGameTag[] _emptyArray;
    public String tagBackgroundColor;
    public String tagText;
    public String tagTextColor;

    public static BountyGameTag[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BountyGameTag[0];
                }
            }
        }
        return _emptyArray;
    }

    public BountyGameTag() {
        clear();
    }

    public final BountyGameTag clear() {
        this.tagText = "";
        this.tagBackgroundColor = "";
        this.tagTextColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.tagText.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.tagText);
        }
        if (!this.tagBackgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.tagBackgroundColor);
        }
        if (!this.tagTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.tagTextColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.tagText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.tagText);
        }
        if (!this.tagBackgroundColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.tagBackgroundColor);
        }
        return !this.tagTextColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.tagTextColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BountyGameTag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.tagText = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.tagBackgroundColor = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.tagTextColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static BountyGameTag parseFrom(byte[] bArr) {
        return (BountyGameTag) MessageNano.mergeFrom(new BountyGameTag(), bArr);
    }

    public static BountyGameTag parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BountyGameTag().mergeFrom(codedInputByteBufferNano);
    }
}
