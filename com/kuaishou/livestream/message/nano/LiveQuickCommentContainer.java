package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveQuickCommentContainer {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveQuickCommentConditionType {
        public static final int NO_SEND_COMMENT = 1;
        public static final int QUICK_COMMENT_CONDITION_TYPE_UNKNOWN = 0;
    }

    public static final class SCLiveQuickCommentContainerOpened extends MessageNano {
        private static volatile SCLiveQuickCommentContainerOpened[] _emptyArray;
        public String bizId;
        public boolean clickDisappear;
        public LiveQuickCommentItem[] comment;
        public long delayDisplayMs;
        public long displayExpireTimestamp;
        public long priority;
        public long slideInternalMs;
        public int[] triggerCondition;

        public static SCLiveQuickCommentContainerOpened[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickCommentContainerOpened[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickCommentContainerOpened() {
            clear();
        }

        public final SCLiveQuickCommentContainerOpened clear() {
            this.bizId = "";
            this.priority = 0L;
            this.comment = LiveQuickCommentItem.emptyArray();
            this.triggerCondition = WireFormatNano.EMPTY_INT_ARRAY;
            this.clickDisappear = false;
            this.slideInternalMs = 0L;
            this.displayExpireTimestamp = 0L;
            this.delayDisplayMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bizId);
            }
            long j = this.priority;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            LiveQuickCommentItem[] liveQuickCommentItemArr = this.comment;
            int i = 0;
            if (liveQuickCommentItemArr != null && liveQuickCommentItemArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveQuickCommentItem[] liveQuickCommentItemArr2 = this.comment;
                    if (i2 >= liveQuickCommentItemArr2.length) {
                        break;
                    }
                    LiveQuickCommentItem liveQuickCommentItem = liveQuickCommentItemArr2[i2];
                    if (liveQuickCommentItem != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveQuickCommentItem);
                    }
                    i2++;
                }
            }
            int[] iArr = this.triggerCondition;
            if (iArr != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.triggerCondition;
                    if (i >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(4, iArr2[i]);
                    i++;
                }
            }
            boolean z = this.clickDisappear;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            long j2 = this.slideInternalMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            long j3 = this.displayExpireTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            long j4 = this.delayDisplayMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizId);
            }
            long j = this.priority;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            LiveQuickCommentItem[] liveQuickCommentItemArr = this.comment;
            int i = 0;
            if (liveQuickCommentItemArr != null && liveQuickCommentItemArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    LiveQuickCommentItem[] liveQuickCommentItemArr2 = this.comment;
                    if (i2 >= liveQuickCommentItemArr2.length) {
                        break;
                    }
                    LiveQuickCommentItem liveQuickCommentItem = liveQuickCommentItemArr2[i2];
                    if (liveQuickCommentItem != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, liveQuickCommentItem);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            int[] iArr2 = this.triggerCondition;
            if (iArr2 != null && iArr2.length > 0) {
                int iComputeInt32SizeNoTag = 0;
                while (true) {
                    iArr = this.triggerCondition;
                    if (i >= iArr.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i]);
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr.length * 1);
            }
            boolean z = this.clickDisappear;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            long j2 = this.slideInternalMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            long j3 = this.displayExpireTimestamp;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            long j4 = this.delayDisplayMs;
            return j4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickCommentContainerOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.priority = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveQuickCommentItem[] liveQuickCommentItemArr = this.comment;
                    int length = liveQuickCommentItemArr == null ? 0 : liveQuickCommentItemArr.length;
                    LiveQuickCommentItem[] liveQuickCommentItemArr2 = new LiveQuickCommentItem[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.comment, 0, liveQuickCommentItemArr2, 0, length);
                    }
                    while (length < liveQuickCommentItemArr2.length - 1) {
                        liveQuickCommentItemArr2[length] = new LiveQuickCommentItem();
                        codedInputByteBufferNano.readMessage(liveQuickCommentItemArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveQuickCommentItemArr2[length] = new LiveQuickCommentItem();
                    codedInputByteBufferNano.readMessage(liveQuickCommentItemArr2[length]);
                    this.comment = liveQuickCommentItemArr2;
                } else if (tag == 32) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                    int[] iArr = new int[repeatedFieldArrayLength2];
                    int i = 0;
                    for (int i2 = 0; i2 < repeatedFieldArrayLength2; i2++) {
                        if (i2 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 0 || int32 == 1) {
                            iArr[i] = int32;
                            i++;
                        }
                    }
                    if (i != 0) {
                        int[] iArr2 = this.triggerCondition;
                        int length2 = iArr2 == null ? 0 : iArr2.length;
                        if (length2 == 0 && i == repeatedFieldArrayLength2) {
                            this.triggerCondition = iArr;
                        } else {
                            int[] iArr3 = new int[length2 + i];
                            if (length2 != 0) {
                                System.arraycopy(this.triggerCondition, 0, iArr3, 0, length2);
                            }
                            System.arraycopy(iArr, 0, iArr3, length2, i);
                            this.triggerCondition = iArr3;
                        }
                    }
                } else if (tag == 34) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 == 0 || int322 == 1) {
                            i3++;
                        }
                    }
                    if (i3 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr4 = this.triggerCondition;
                        int length3 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.triggerCondition, 0, iArr5, 0, length3);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int int323 = codedInputByteBufferNano.readInt32();
                            if (int323 == 0 || int323 == 1) {
                                iArr5[length3] = int323;
                                length3++;
                            }
                        }
                        this.triggerCondition = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag == 40) {
                    this.clickDisappear = codedInputByteBufferNano.readBool();
                } else if (tag == 48) {
                    this.slideInternalMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 56) {
                    this.displayExpireTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.delayDisplayMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveQuickCommentContainerOpened parseFrom(byte[] bArr) {
            return (SCLiveQuickCommentContainerOpened) MessageNano.mergeFrom(new SCLiveQuickCommentContainerOpened(), bArr);
        }

        public static SCLiveQuickCommentContainerOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickCommentContainerOpened().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveQuickCommentItem extends MessageNano {
        private static volatile LiveQuickCommentItem[] _emptyArray;
        public String actionRouter;
        public String displayText;
        public String quickCommentId;

        public static LiveQuickCommentItem[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuickCommentItem[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuickCommentItem() {
            clear();
        }

        public final LiveQuickCommentItem clear() {
            this.displayText = "";
            this.actionRouter = "";
            this.quickCommentId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.displayText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.displayText);
            }
            if (!this.actionRouter.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.actionRouter);
            }
            if (!this.quickCommentId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.quickCommentId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.displayText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.displayText);
            }
            if (!this.actionRouter.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.actionRouter);
            }
            return !this.quickCommentId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.quickCommentId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuickCommentItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.displayText = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.actionRouter = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.quickCommentId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveQuickCommentItem parseFrom(byte[] bArr) {
            return (LiveQuickCommentItem) MessageNano.mergeFrom(new LiveQuickCommentItem(), bArr);
        }

        public static LiveQuickCommentItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuickCommentItem().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveQuickCommentContainerClosed extends MessageNano {
        private static volatile SCLiveQuickCommentContainerClosed[] _emptyArray;
        public String bizId;
        public long liveStreamId;

        public static SCLiveQuickCommentContainerClosed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickCommentContainerClosed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickCommentContainerClosed() {
            clear();
        }

        public final SCLiveQuickCommentContainerClosed clear() {
            this.liveStreamId = 0L;
            this.bizId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.liveStreamId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bizId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.liveStreamId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            return !this.bizId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.bizId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickCommentContainerClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.liveStreamId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bizId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveQuickCommentContainerClosed parseFrom(byte[] bArr) {
            return (SCLiveQuickCommentContainerClosed) MessageNano.mergeFrom(new SCLiveQuickCommentContainerClosed(), bArr);
        }

        public static SCLiveQuickCommentContainerClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickCommentContainerClosed().mergeFrom(codedInputByteBufferNano);
        }
    }
}
