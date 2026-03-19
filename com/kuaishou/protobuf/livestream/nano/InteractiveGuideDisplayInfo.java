package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveGuideDisplayInfo extends MessageNano {
    private static volatile InteractiveGuideDisplayInfo[] _emptyArray;
    public InteractiveGuideDisplayContent[] displayContent;
    public long picRotationDurationMs;
    public int style;

    @Retention(RetentionPolicy.SOURCE)
    public @interface InteractiveGuideDisplayStyle {
        public static final int MULTI_PIC_WITH_AGGREGATION = 7;
        public static final int MULTI_PIC_WITH_BEHIND_ROTATION = 6;
        public static final int MULTI_PIC_WITH_ROTATION = 4;
        public static final int SINGLE_PIC = 1;
        public static final int SINGLE_PIC_WITH_CIRCLE = 3;
        public static final int SINGLE_PIC_WITH_ROTATION = 2;
        public static final int SINGLE_PIC_WITH_ROTATION_AND_GUIDE_INFO = 5;
        public static final int UNKNOWN = 0;
    }

    public static InteractiveGuideDisplayInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveGuideDisplayInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveGuideDisplayInfo() {
        clear();
    }

    public final InteractiveGuideDisplayInfo clear() {
        this.displayContent = InteractiveGuideDisplayContent.emptyArray();
        this.style = 0;
        this.picRotationDurationMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveGuideDisplayContent[] interactiveGuideDisplayContentArr = this.displayContent;
        if (interactiveGuideDisplayContentArr != null && interactiveGuideDisplayContentArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveGuideDisplayContent[] interactiveGuideDisplayContentArr2 = this.displayContent;
                if (i >= interactiveGuideDisplayContentArr2.length) {
                    break;
                }
                InteractiveGuideDisplayContent interactiveGuideDisplayContent = interactiveGuideDisplayContentArr2[i];
                if (interactiveGuideDisplayContent != null) {
                    codedOutputByteBufferNano.writeMessage(1, interactiveGuideDisplayContent);
                }
                i++;
            }
        }
        int i2 = this.style;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        long j = this.picRotationDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveGuideDisplayContent[] interactiveGuideDisplayContentArr = this.displayContent;
        if (interactiveGuideDisplayContentArr != null && interactiveGuideDisplayContentArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveGuideDisplayContent[] interactiveGuideDisplayContentArr2 = this.displayContent;
                if (i >= interactiveGuideDisplayContentArr2.length) {
                    break;
                }
                InteractiveGuideDisplayContent interactiveGuideDisplayContent = interactiveGuideDisplayContentArr2[i];
                if (interactiveGuideDisplayContent != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveGuideDisplayContent);
                }
                i++;
            }
        }
        int i2 = this.style;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        long j = this.picRotationDurationMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveGuideDisplayInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                InteractiveGuideDisplayContent[] interactiveGuideDisplayContentArr = this.displayContent;
                int length = interactiveGuideDisplayContentArr == null ? 0 : interactiveGuideDisplayContentArr.length;
                InteractiveGuideDisplayContent[] interactiveGuideDisplayContentArr2 = new InteractiveGuideDisplayContent[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.displayContent, 0, interactiveGuideDisplayContentArr2, 0, length);
                }
                while (length < interactiveGuideDisplayContentArr2.length - 1) {
                    interactiveGuideDisplayContentArr2[length] = new InteractiveGuideDisplayContent();
                    codedInputByteBufferNano.readMessage(interactiveGuideDisplayContentArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveGuideDisplayContentArr2[length] = new InteractiveGuideDisplayContent();
                codedInputByteBufferNano.readMessage(interactiveGuideDisplayContentArr2[length]);
                this.displayContent = interactiveGuideDisplayContentArr2;
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.style = int32;
                        break;
                }
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.picRotationDurationMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static InteractiveGuideDisplayInfo parseFrom(byte[] bArr) {
        return (InteractiveGuideDisplayInfo) MessageNano.mergeFrom(new InteractiveGuideDisplayInfo(), bArr);
    }

    public static InteractiveGuideDisplayInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveGuideDisplayInfo().mergeFrom(codedInputByteBufferNano);
    }
}
