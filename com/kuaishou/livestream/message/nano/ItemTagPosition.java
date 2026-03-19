package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ItemTagPosition extends MessageNano {
    private static volatile ItemTagPosition[] _emptyArray;
    public String code;
    public String desc;
    public ItemTag[] itemTag;

    public static ItemTagPosition[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ItemTagPosition[0];
                }
            }
        }
        return _emptyArray;
    }

    public ItemTagPosition() {
        clear();
    }

    public final ItemTagPosition clear() {
        this.code = "";
        this.desc = "";
        this.itemTag = ItemTag.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.code.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.code);
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.desc);
        }
        ItemTag[] itemTagArr = this.itemTag;
        if (itemTagArr != null && itemTagArr.length > 0) {
            int i = 0;
            while (true) {
                ItemTag[] itemTagArr2 = this.itemTag;
                if (i >= itemTagArr2.length) {
                    break;
                }
                ItemTag itemTag = itemTagArr2[i];
                if (itemTag != null) {
                    codedOutputByteBufferNano.writeMessage(3, itemTag);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.code.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.code);
        }
        if (!this.desc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.desc);
        }
        ItemTag[] itemTagArr = this.itemTag;
        if (itemTagArr != null && itemTagArr.length > 0) {
            int i = 0;
            while (true) {
                ItemTag[] itemTagArr2 = this.itemTag;
                if (i >= itemTagArr2.length) {
                    break;
                }
                ItemTag itemTag = itemTagArr2[i];
                if (itemTag != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, itemTag);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ItemTagPosition mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.code = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.desc = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                ItemTag[] itemTagArr = this.itemTag;
                int length = itemTagArr == null ? 0 : itemTagArr.length;
                ItemTag[] itemTagArr2 = new ItemTag[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.itemTag, 0, itemTagArr2, 0, length);
                }
                while (length < itemTagArr2.length - 1) {
                    itemTagArr2[length] = new ItemTag();
                    codedInputByteBufferNano.readMessage(itemTagArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                itemTagArr2[length] = new ItemTag();
                codedInputByteBufferNano.readMessage(itemTagArr2[length]);
                this.itemTag = itemTagArr2;
            }
        }
    }

    public static ItemTagPosition parseFrom(byte[] bArr) {
        return (ItemTagPosition) MessageNano.mergeFrom(new ItemTagPosition(), bArr);
    }

    public static ItemTagPosition parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ItemTagPosition().mergeFrom(codedInputByteBufferNano);
    }
}
