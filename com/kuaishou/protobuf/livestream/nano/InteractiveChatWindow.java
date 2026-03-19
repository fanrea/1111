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
public final class InteractiveChatWindow extends MessageNano {
    private static volatile InteractiveChatWindow[] _emptyArray;
    public int channelType;
    public int[] consumer;
    public int cropMode;
    public int height;
    public int resourceId;
    public long userId;
    public int width;
    public int windowId;
    public int x;
    public int y;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChannelType {
        public static final int EXTERNAL = 2;
        public static final int INTERNAL = 1;
        public static final int UNKNOWN_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConsumerType {
        public static final int DIRECTOR = 2;
        public static final int RENDER = 1;
        public static final int RTC = 3;
        public static final int UNKNOWN_CONSUMER_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CropMode {
        public static final int FILL = 2;
        public static final int FIT = 1;
        public static final int UNKNOWN = 0;
    }

    public static InteractiveChatWindow[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatWindow[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatWindow() {
        clear();
    }

    public final InteractiveChatWindow clear() {
        this.windowId = 0;
        this.userId = 0L;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.cropMode = 0;
        this.channelType = 0;
        this.resourceId = 0;
        this.consumer = WireFormatNano.EMPTY_INT_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.windowId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        int i2 = this.x;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i2);
        }
        int i3 = this.y;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i4 = this.width;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i4);
        }
        int i5 = this.height;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i5);
        }
        int i6 = this.cropMode;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i6);
        }
        int i7 = this.channelType;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i7);
        }
        int i8 = this.resourceId;
        if (i8 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i8);
        }
        int[] iArr = this.consumer;
        if (iArr != null && iArr.length > 0) {
            int i9 = 0;
            while (true) {
                int[] iArr2 = this.consumer;
                if (i9 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(10, iArr2[i9]);
                i9++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.windowId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        int i2 = this.x;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
        }
        int i3 = this.y;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i4 = this.width;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
        }
        int i5 = this.height;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
        }
        int i6 = this.cropMode;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i6);
        }
        int i7 = this.channelType;
        if (i7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i7);
        }
        int i8 = this.resourceId;
        if (i8 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i8);
        }
        int[] iArr = this.consumer;
        if (iArr == null || iArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int i9 = 0;
        int iComputeInt32SizeNoTag = 0;
        while (true) {
            int[] iArr2 = this.consumer;
            if (i9 < iArr2.length) {
                iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i9]);
                i9++;
            } else {
                return iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatWindow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.windowId = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.userId = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.x = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.y = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.width = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.height = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.cropMode = int32;
                        break;
                    }
                case 64:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.channelType = int322;
                        break;
                    }
                    break;
                case 72:
                    this.resourceId = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
                    int[] iArr = new int[repeatedFieldArrayLength];
                    int i = 0;
                    for (int i2 = 0; i2 < repeatedFieldArrayLength; i2++) {
                        if (i2 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int int323 = codedInputByteBufferNano.readInt32();
                        if (int323 == 0 || int323 == 1 || int323 == 2 || int323 == 3) {
                            iArr[i] = int323;
                            i++;
                        }
                    }
                    if (i == 0) {
                        break;
                    } else {
                        int[] iArr2 = this.consumer;
                        int length = iArr2 == null ? 0 : iArr2.length;
                        if (length == 0 && i == repeatedFieldArrayLength) {
                            this.consumer = iArr;
                            break;
                        } else {
                            int[] iArr3 = new int[length + i];
                            if (length != 0) {
                                System.arraycopy(this.consumer, 0, iArr3, 0, length);
                            }
                            System.arraycopy(iArr, 0, iArr3, length, i);
                            this.consumer = iArr3;
                            break;
                        }
                    }
                case 82:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int int324 = codedInputByteBufferNano.readInt32();
                        if (int324 == 0 || int324 == 1 || int324 == 2 || int324 == 3) {
                            i3++;
                        }
                    }
                    if (i3 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr4 = this.consumer;
                        int length2 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i3 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.consumer, 0, iArr5, 0, length2);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int int325 = codedInputByteBufferNano.readInt32();
                            if (int325 == 0 || int325 == 1 || int325 == 2 || int325 == 3) {
                                iArr5[length2] = int325;
                                length2++;
                            }
                        }
                        this.consumer = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static InteractiveChatWindow parseFrom(byte[] bArr) {
        return (InteractiveChatWindow) MessageNano.mergeFrom(new InteractiveChatWindow(), bArr);
    }

    public static InteractiveChatWindow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatWindow().mergeFrom(codedInputByteBufferNano);
    }
}
