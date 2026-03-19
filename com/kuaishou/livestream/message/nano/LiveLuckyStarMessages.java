package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveLuckyStarMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LuckyStarAbnormalEndType {
        public static final int LUCKY_STAR_AUDIT_REJECTED = 1;
        public static final int UNKNOWN_ABNORMAL_END_TYPE = 0;
    }

    public static final class SCLuckyStarStarted extends MessageNano {
        private static volatile SCLuckyStarStarted[] _emptyArray;
        public LiveCdnNodeView[] dynamicCountDownIcon;
        public LiveCdnNodeView[] dynamicShakeIcon;
        public LiveCdnNodeView[] liteAuthorInfoAreaIcon;
        public LiveCdnNodeView[] liteStaticIcon;
        public String luckyStarId;
        public long maxAdvanceRequestRollUserMillis;
        public long openDeadline;
        public LiveCdnNodeView[] staticIcon;
        public int type;
        public boolean useNewUi;
        public long widgetDisappearTime;

        public static SCLuckyStarStarted[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLuckyStarStarted[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLuckyStarStarted() {
            clear();
        }

        public final SCLuckyStarStarted clear() {
            this.luckyStarId = "";
            this.openDeadline = 0L;
            this.type = 0;
            this.maxAdvanceRequestRollUserMillis = 0L;
            this.useNewUi = false;
            this.widgetDisappearTime = 0L;
            this.staticIcon = LiveCdnNodeView.emptyArray();
            this.dynamicCountDownIcon = LiveCdnNodeView.emptyArray();
            this.dynamicShakeIcon = LiveCdnNodeView.emptyArray();
            this.liteStaticIcon = LiveCdnNodeView.emptyArray();
            this.liteAuthorInfoAreaIcon = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.luckyStarId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.luckyStarId);
            }
            long j = this.openDeadline;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j2 = this.maxAdvanceRequestRollUserMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            boolean z = this.useNewUi;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            long j3 = this.widgetDisappearTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.staticIcon;
            int i2 = 0;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.staticIcon;
                    if (i3 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(7, liveCdnNodeView);
                    }
                    i3++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr3 = this.dynamicCountDownIcon;
            if (liveCdnNodeViewArr3 != null && liveCdnNodeViewArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr4 = this.dynamicCountDownIcon;
                    if (i4 >= liveCdnNodeViewArr4.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView2 = liveCdnNodeViewArr4[i4];
                    if (liveCdnNodeView2 != null) {
                        codedOutputByteBufferNano.writeMessage(8, liveCdnNodeView2);
                    }
                    i4++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr5 = this.dynamicShakeIcon;
            if (liveCdnNodeViewArr5 != null && liveCdnNodeViewArr5.length > 0) {
                int i5 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr6 = this.dynamicShakeIcon;
                    if (i5 >= liveCdnNodeViewArr6.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView3 = liveCdnNodeViewArr6[i5];
                    if (liveCdnNodeView3 != null) {
                        codedOutputByteBufferNano.writeMessage(9, liveCdnNodeView3);
                    }
                    i5++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr7 = this.liteStaticIcon;
            if (liveCdnNodeViewArr7 != null && liveCdnNodeViewArr7.length > 0) {
                int i6 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr8 = this.liteStaticIcon;
                    if (i6 >= liveCdnNodeViewArr8.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView4 = liveCdnNodeViewArr8[i6];
                    if (liveCdnNodeView4 != null) {
                        codedOutputByteBufferNano.writeMessage(10, liveCdnNodeView4);
                    }
                    i6++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr9 = this.liteAuthorInfoAreaIcon;
            if (liveCdnNodeViewArr9 != null && liveCdnNodeViewArr9.length > 0) {
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr10 = this.liteAuthorInfoAreaIcon;
                    if (i2 >= liveCdnNodeViewArr10.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView5 = liveCdnNodeViewArr10[i2];
                    if (liveCdnNodeView5 != null) {
                        codedOutputByteBufferNano.writeMessage(11, liveCdnNodeView5);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.luckyStarId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.luckyStarId);
            }
            long j = this.openDeadline;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j2 = this.maxAdvanceRequestRollUserMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            boolean z = this.useNewUi;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            long j3 = this.widgetDisappearTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.staticIcon;
            int i2 = 0;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.staticIcon;
                    if (i3 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                    if (liveCdnNodeView != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, liveCdnNodeView);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr3 = this.dynamicCountDownIcon;
            if (liveCdnNodeViewArr3 != null && liveCdnNodeViewArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr4 = this.dynamicCountDownIcon;
                    if (i4 >= liveCdnNodeViewArr4.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView2 = liveCdnNodeViewArr4[i4];
                    if (liveCdnNodeView2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(8, liveCdnNodeView2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr5 = this.dynamicShakeIcon;
            if (liveCdnNodeViewArr5 != null && liveCdnNodeViewArr5.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr6 = this.dynamicShakeIcon;
                    if (i5 >= liveCdnNodeViewArr6.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView3 = liveCdnNodeViewArr6[i5];
                    if (liveCdnNodeView3 != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(9, liveCdnNodeView3);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr7 = this.liteStaticIcon;
            if (liveCdnNodeViewArr7 != null && liveCdnNodeViewArr7.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr8 = this.liteStaticIcon;
                    if (i6 >= liveCdnNodeViewArr8.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView4 = liveCdnNodeViewArr8[i6];
                    if (liveCdnNodeView4 != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(10, liveCdnNodeView4);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr9 = this.liteAuthorInfoAreaIcon;
            if (liveCdnNodeViewArr9 != null && liveCdnNodeViewArr9.length > 0) {
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr10 = this.liteAuthorInfoAreaIcon;
                    if (i2 >= liveCdnNodeViewArr10.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView5 = liveCdnNodeViewArr10[i2];
                    if (liveCdnNodeView5 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, liveCdnNodeView5);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLuckyStarStarted mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.luckyStarId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.openDeadline = codedInputByteBufferNano.readUInt64();
                        break;
                    case 24:
                        this.type = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.maxAdvanceRequestRollUserMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.useNewUi = codedInputByteBufferNano.readBool();
                        break;
                    case 48:
                        this.widgetDisappearTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 58:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        LiveCdnNodeView[] liveCdnNodeViewArr = this.staticIcon;
                        int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.staticIcon, 0, liveCdnNodeViewArr2, 0, length);
                        }
                        while (length < liveCdnNodeViewArr2.length - 1) {
                            liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        this.staticIcon = liveCdnNodeViewArr2;
                        break;
                    case 66:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        LiveCdnNodeView[] liveCdnNodeViewArr3 = this.dynamicCountDownIcon;
                        int length2 = liveCdnNodeViewArr3 == null ? 0 : liveCdnNodeViewArr3.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr4 = new LiveCdnNodeView[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.dynamicCountDownIcon, 0, liveCdnNodeViewArr4, 0, length2);
                        }
                        while (length2 < liveCdnNodeViewArr4.length - 1) {
                            liveCdnNodeViewArr4[length2] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        liveCdnNodeViewArr4[length2] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr4[length2]);
                        this.dynamicCountDownIcon = liveCdnNodeViewArr4;
                        break;
                    case 74:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        LiveCdnNodeView[] liveCdnNodeViewArr5 = this.dynamicShakeIcon;
                        int length3 = liveCdnNodeViewArr5 == null ? 0 : liveCdnNodeViewArr5.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr6 = new LiveCdnNodeView[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.dynamicShakeIcon, 0, liveCdnNodeViewArr6, 0, length3);
                        }
                        while (length3 < liveCdnNodeViewArr6.length - 1) {
                            liveCdnNodeViewArr6[length3] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        liveCdnNodeViewArr6[length3] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr6[length3]);
                        this.dynamicShakeIcon = liveCdnNodeViewArr6;
                        break;
                    case 82:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        LiveCdnNodeView[] liveCdnNodeViewArr7 = this.liteStaticIcon;
                        int length4 = liveCdnNodeViewArr7 == null ? 0 : liveCdnNodeViewArr7.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr8 = new LiveCdnNodeView[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.liteStaticIcon, 0, liveCdnNodeViewArr8, 0, length4);
                        }
                        while (length4 < liveCdnNodeViewArr8.length - 1) {
                            liveCdnNodeViewArr8[length4] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr8[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        liveCdnNodeViewArr8[length4] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr8[length4]);
                        this.liteStaticIcon = liveCdnNodeViewArr8;
                        break;
                    case 90:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        LiveCdnNodeView[] liveCdnNodeViewArr9 = this.liteAuthorInfoAreaIcon;
                        int length5 = liveCdnNodeViewArr9 == null ? 0 : liveCdnNodeViewArr9.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr10 = new LiveCdnNodeView[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.liteAuthorInfoAreaIcon, 0, liveCdnNodeViewArr10, 0, length5);
                        }
                        while (length5 < liveCdnNodeViewArr10.length - 1) {
                            liveCdnNodeViewArr10[length5] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr10[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        liveCdnNodeViewArr10[length5] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr10[length5]);
                        this.liteAuthorInfoAreaIcon = liveCdnNodeViewArr10;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLuckyStarStarted parseFrom(byte[] bArr) {
            return (SCLuckyStarStarted) MessageNano.mergeFrom(new SCLuckyStarStarted(), bArr);
        }

        public static SCLuckyStarStarted parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLuckyStarStarted().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLuckyStarOpened extends MessageNano {
        private static volatile SCLuckyStarOpened[] _emptyArray;
        public String luckyStarId;
        public long requestMaxDelayMillis;
        public boolean useNewUi;

        public static SCLuckyStarOpened[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLuckyStarOpened[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLuckyStarOpened() {
            clear();
        }

        public final SCLuckyStarOpened clear() {
            this.luckyStarId = "";
            this.requestMaxDelayMillis = 0L;
            this.useNewUi = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.luckyStarId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.luckyStarId);
            }
            long j = this.requestMaxDelayMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            boolean z = this.useNewUi;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.luckyStarId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.luckyStarId);
            }
            long j = this.requestMaxDelayMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            boolean z = this.useNewUi;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLuckyStarOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.luckyStarId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.requestMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.useNewUi = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static SCLuckyStarOpened parseFrom(byte[] bArr) {
            return (SCLuckyStarOpened) MessageNano.mergeFrom(new SCLuckyStarOpened(), bArr);
        }

        public static SCLuckyStarOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLuckyStarOpened().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLuckyStarAbnormalEnd extends MessageNano {
        private static volatile SCLuckyStarAbnormalEnd[] _emptyArray;
        public String endReason;
        public int endType;
        public String luckyStarId;

        public static SCLuckyStarAbnormalEnd[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLuckyStarAbnormalEnd[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLuckyStarAbnormalEnd() {
            clear();
        }

        public final SCLuckyStarAbnormalEnd clear() {
            this.luckyStarId = "";
            this.endType = 0;
            this.endReason = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.luckyStarId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.luckyStarId);
            }
            int i = this.endType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            if (!this.endReason.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.endReason);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.luckyStarId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.luckyStarId);
            }
            int i = this.endType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            return !this.endReason.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.endReason) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLuckyStarAbnormalEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.luckyStarId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.endType = int32;
                    }
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.endReason = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLuckyStarAbnormalEnd parseFrom(byte[] bArr) {
            return (SCLuckyStarAbnormalEnd) MessageNano.mergeFrom(new SCLuckyStarAbnormalEnd(), bArr);
        }

        public static SCLuckyStarAbnormalEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLuckyStarAbnormalEnd().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLuckyStarParticipantStatus extends MessageNano {
        private static volatile SCLuckyStarParticipantStatus[] _emptyArray;
        public String displayText;
        public String luckyStarId;
        public int status;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LuckyStarParticipantStatus {
            public static final int PARTICIPATED = 2;
            public static final int REQUIREMENT_ACHIEVED = 1;
            public static final int UNKNOWN_PARTICIPANT_STATUS = 0;
        }

        public static SCLuckyStarParticipantStatus[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLuckyStarParticipantStatus[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLuckyStarParticipantStatus() {
            clear();
        }

        public final SCLuckyStarParticipantStatus clear() {
            this.status = 0;
            this.displayText = "";
            this.luckyStarId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.displayText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.displayText);
            }
            if (!this.luckyStarId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.luckyStarId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.displayText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.displayText);
            }
            return !this.luckyStarId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.luckyStarId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLuckyStarParticipantStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.status = int32;
                    }
                } else if (tag == 18) {
                    this.displayText = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.luckyStarId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLuckyStarParticipantStatus parseFrom(byte[] bArr) {
            return (SCLuckyStarParticipantStatus) MessageNano.mergeFrom(new SCLuckyStarParticipantStatus(), bArr);
        }

        public static SCLuckyStarParticipantStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLuckyStarParticipantStatus().mergeFrom(codedInputByteBufferNano);
        }
    }
}
