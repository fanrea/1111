package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveInteractiveGuide extends MessageNano {
    private static volatile SCLiveInteractiveGuide[] _emptyArray;
    public InteractiveGuide[] guide;

    public static SCLiveInteractiveGuide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveInteractiveGuide[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveInteractiveGuide() {
        clear();
    }

    public final SCLiveInteractiveGuide clear() {
        this.guide = InteractiveGuide.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveGuide[] interactiveGuideArr = this.guide;
        if (interactiveGuideArr != null && interactiveGuideArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveGuide[] interactiveGuideArr2 = this.guide;
                if (i >= interactiveGuideArr2.length) {
                    break;
                }
                InteractiveGuide interactiveGuide = interactiveGuideArr2[i];
                if (interactiveGuide != null) {
                    codedOutputByteBufferNano.writeMessage(1, interactiveGuide);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveGuide[] interactiveGuideArr = this.guide;
        if (interactiveGuideArr != null && interactiveGuideArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveGuide[] interactiveGuideArr2 = this.guide;
                if (i >= interactiveGuideArr2.length) {
                    break;
                }
                InteractiveGuide interactiveGuide = interactiveGuideArr2[i];
                if (interactiveGuide != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveGuide);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveInteractiveGuide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                InteractiveGuide[] interactiveGuideArr = this.guide;
                int length = interactiveGuideArr == null ? 0 : interactiveGuideArr.length;
                InteractiveGuide[] interactiveGuideArr2 = new InteractiveGuide[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.guide, 0, interactiveGuideArr2, 0, length);
                }
                while (length < interactiveGuideArr2.length - 1) {
                    interactiveGuideArr2[length] = new InteractiveGuide();
                    codedInputByteBufferNano.readMessage(interactiveGuideArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveGuideArr2[length] = new InteractiveGuide();
                codedInputByteBufferNano.readMessage(interactiveGuideArr2[length]);
                this.guide = interactiveGuideArr2;
            }
        }
    }

    public static SCLiveInteractiveGuide parseFrom(byte[] bArr) {
        return (SCLiveInteractiveGuide) MessageNano.mergeFrom(new SCLiveInteractiveGuide(), bArr);
    }

    public static SCLiveInteractiveGuide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveInteractiveGuide().mergeFrom(codedInputByteBufferNano);
    }
}
