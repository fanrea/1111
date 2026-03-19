package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ItemTag extends MessageNano {
    private static volatile ItemTag[] _emptyArray;
    public String content;
    public String name;
    public String styleKey;
    public String uniqKey;

    public static ItemTag[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ItemTag[0];
                }
            }
        }
        return _emptyArray;
    }

    public ItemTag() {
        clear();
    }

    public final ItemTag clear() {
        this.uniqKey = "";
        this.name = "";
        this.content = "";
        this.styleKey = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.uniqKey.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.uniqKey);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.content);
        }
        if (!this.styleKey.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.styleKey);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.uniqKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.uniqKey);
        }
        if (!this.name.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.content);
        }
        return !this.styleKey.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.styleKey) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ItemTag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.uniqKey = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.name = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.styleKey = codedInputByteBufferNano.readString();
            }
        }
    }

    public static ItemTag parseFrom(byte[] bArr) {
        return (ItemTag) MessageNano.mergeFrom(new ItemTag(), bArr);
    }

    public static ItemTag parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ItemTag().mergeFrom(codedInputByteBufferNano);
    }
}
