package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ItemBizTagChannel extends MessageNano {
    private static volatile ItemBizTagChannel[] _emptyArray;
    public ItemTagPosition[] tagPositionList;

    public static ItemBizTagChannel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ItemBizTagChannel[0];
                }
            }
        }
        return _emptyArray;
    }

    public ItemBizTagChannel() {
        clear();
    }

    public final ItemBizTagChannel clear() {
        this.tagPositionList = ItemTagPosition.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        ItemTagPosition[] itemTagPositionArr = this.tagPositionList;
        if (itemTagPositionArr != null && itemTagPositionArr.length > 0) {
            int i = 0;
            while (true) {
                ItemTagPosition[] itemTagPositionArr2 = this.tagPositionList;
                if (i >= itemTagPositionArr2.length) {
                    break;
                }
                ItemTagPosition itemTagPosition = itemTagPositionArr2[i];
                if (itemTagPosition != null) {
                    codedOutputByteBufferNano.writeMessage(1, itemTagPosition);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        ItemTagPosition[] itemTagPositionArr = this.tagPositionList;
        if (itemTagPositionArr != null && itemTagPositionArr.length > 0) {
            int i = 0;
            while (true) {
                ItemTagPosition[] itemTagPositionArr2 = this.tagPositionList;
                if (i >= itemTagPositionArr2.length) {
                    break;
                }
                ItemTagPosition itemTagPosition = itemTagPositionArr2[i];
                if (itemTagPosition != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemTagPosition);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ItemBizTagChannel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                ItemTagPosition[] itemTagPositionArr = this.tagPositionList;
                int length = itemTagPositionArr == null ? 0 : itemTagPositionArr.length;
                ItemTagPosition[] itemTagPositionArr2 = new ItemTagPosition[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.tagPositionList, 0, itemTagPositionArr2, 0, length);
                }
                while (length < itemTagPositionArr2.length - 1) {
                    itemTagPositionArr2[length] = new ItemTagPosition();
                    codedInputByteBufferNano.readMessage(itemTagPositionArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                itemTagPositionArr2[length] = new ItemTagPosition();
                codedInputByteBufferNano.readMessage(itemTagPositionArr2[length]);
                this.tagPositionList = itemTagPositionArr2;
            }
        }
    }

    public static ItemBizTagChannel parseFrom(byte[] bArr) {
        return (ItemBizTagChannel) MessageNano.mergeFrom(new ItemBizTagChannel(), bArr);
    }

    public static ItemBizTagChannel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ItemBizTagChannel().mergeFrom(codedInputByteBufferNano);
    }
}
