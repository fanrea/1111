package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveInteractiveGuideClose extends MessageNano {
    private static volatile SCLiveInteractiveGuideClose[] _emptyArray;
    public InteractiveGuideClose[] guideClose;

    public static SCLiveInteractiveGuideClose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveInteractiveGuideClose[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveInteractiveGuideClose() {
        clear();
    }

    public final SCLiveInteractiveGuideClose clear() {
        this.guideClose = InteractiveGuideClose.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveGuideClose[] interactiveGuideCloseArr = this.guideClose;
        if (interactiveGuideCloseArr != null && interactiveGuideCloseArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveGuideClose[] interactiveGuideCloseArr2 = this.guideClose;
                if (i >= interactiveGuideCloseArr2.length) {
                    break;
                }
                InteractiveGuideClose interactiveGuideClose = interactiveGuideCloseArr2[i];
                if (interactiveGuideClose != null) {
                    codedOutputByteBufferNano.writeMessage(1, interactiveGuideClose);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveGuideClose[] interactiveGuideCloseArr = this.guideClose;
        if (interactiveGuideCloseArr != null && interactiveGuideCloseArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveGuideClose[] interactiveGuideCloseArr2 = this.guideClose;
                if (i >= interactiveGuideCloseArr2.length) {
                    break;
                }
                InteractiveGuideClose interactiveGuideClose = interactiveGuideCloseArr2[i];
                if (interactiveGuideClose != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveGuideClose);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveInteractiveGuideClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                InteractiveGuideClose[] interactiveGuideCloseArr = this.guideClose;
                int length = interactiveGuideCloseArr == null ? 0 : interactiveGuideCloseArr.length;
                InteractiveGuideClose[] interactiveGuideCloseArr2 = new InteractiveGuideClose[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.guideClose, 0, interactiveGuideCloseArr2, 0, length);
                }
                while (length < interactiveGuideCloseArr2.length - 1) {
                    interactiveGuideCloseArr2[length] = new InteractiveGuideClose();
                    codedInputByteBufferNano.readMessage(interactiveGuideCloseArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveGuideCloseArr2[length] = new InteractiveGuideClose();
                codedInputByteBufferNano.readMessage(interactiveGuideCloseArr2[length]);
                this.guideClose = interactiveGuideCloseArr2;
            }
        }
    }

    public static SCLiveInteractiveGuideClose parseFrom(byte[] bArr) {
        return (SCLiveInteractiveGuideClose) MessageNano.mergeFrom(new SCLiveInteractiveGuideClose(), bArr);
    }

    public static SCLiveInteractiveGuideClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveInteractiveGuideClose().mergeFrom(codedInputByteBufferNano);
    }
}
