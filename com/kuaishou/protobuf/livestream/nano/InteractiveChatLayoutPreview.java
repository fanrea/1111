package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatLayoutPreview extends MessageNano {
    private static volatile InteractiveChatLayoutPreview[] _emptyArray;
    public InteractiveChatLayoutPreviewGroup[] previewGroups;

    public static InteractiveChatLayoutPreview[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatLayoutPreview[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatLayoutPreview() {
        clear();
    }

    public final InteractiveChatLayoutPreview clear() {
        this.previewGroups = InteractiveChatLayoutPreviewGroup.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatLayoutPreviewGroup[] interactiveChatLayoutPreviewGroupArr = this.previewGroups;
        if (interactiveChatLayoutPreviewGroupArr != null && interactiveChatLayoutPreviewGroupArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatLayoutPreviewGroup[] interactiveChatLayoutPreviewGroupArr2 = this.previewGroups;
                if (i >= interactiveChatLayoutPreviewGroupArr2.length) {
                    break;
                }
                InteractiveChatLayoutPreviewGroup interactiveChatLayoutPreviewGroup = interactiveChatLayoutPreviewGroupArr2[i];
                if (interactiveChatLayoutPreviewGroup != null) {
                    codedOutputByteBufferNano.writeMessage(1, interactiveChatLayoutPreviewGroup);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatLayoutPreviewGroup[] interactiveChatLayoutPreviewGroupArr = this.previewGroups;
        if (interactiveChatLayoutPreviewGroupArr != null && interactiveChatLayoutPreviewGroupArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatLayoutPreviewGroup[] interactiveChatLayoutPreviewGroupArr2 = this.previewGroups;
                if (i >= interactiveChatLayoutPreviewGroupArr2.length) {
                    break;
                }
                InteractiveChatLayoutPreviewGroup interactiveChatLayoutPreviewGroup = interactiveChatLayoutPreviewGroupArr2[i];
                if (interactiveChatLayoutPreviewGroup != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatLayoutPreviewGroup);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatLayoutPreview mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                InteractiveChatLayoutPreviewGroup[] interactiveChatLayoutPreviewGroupArr = this.previewGroups;
                int length = interactiveChatLayoutPreviewGroupArr == null ? 0 : interactiveChatLayoutPreviewGroupArr.length;
                InteractiveChatLayoutPreviewGroup[] interactiveChatLayoutPreviewGroupArr2 = new InteractiveChatLayoutPreviewGroup[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.previewGroups, 0, interactiveChatLayoutPreviewGroupArr2, 0, length);
                }
                while (length < interactiveChatLayoutPreviewGroupArr2.length - 1) {
                    interactiveChatLayoutPreviewGroupArr2[length] = new InteractiveChatLayoutPreviewGroup();
                    codedInputByteBufferNano.readMessage(interactiveChatLayoutPreviewGroupArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveChatLayoutPreviewGroupArr2[length] = new InteractiveChatLayoutPreviewGroup();
                codedInputByteBufferNano.readMessage(interactiveChatLayoutPreviewGroupArr2[length]);
                this.previewGroups = interactiveChatLayoutPreviewGroupArr2;
            }
        }
    }

    public static InteractiveChatLayoutPreview parseFrom(byte[] bArr) {
        return (InteractiveChatLayoutPreview) MessageNano.mergeFrom(new InteractiveChatLayoutPreview(), bArr);
    }

    public static InteractiveChatLayoutPreview parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatLayoutPreview().mergeFrom(codedInputByteBufferNano);
    }
}
