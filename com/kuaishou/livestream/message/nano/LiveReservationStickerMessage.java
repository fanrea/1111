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
public interface LiveReservationStickerMessage {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveReservationActivityType {
        public static final int OFFICIAL_NIGHTS = 1;
        public static final int UNKNOWN_RESERVATION_ACTIVITY_TYPE = 0;
    }

    public static final class SCLiveReservationStickerUpdate extends MessageNano {
        private static volatile SCLiveReservationStickerUpdate[] _emptyArray;
        public long authorId;
        public LiveCdnNodeView[] buttonIcon;
        public boolean disableCancelReservation;
        public LiveCdnNodeView[] displayBackgroundUrl;
        public String displayDay;
        public String displayReservedUserCount;
        public String displayReservedUserCountSuffix;
        public String displayTime;
        public boolean enableDisplayReserveButton;
        public LiveCdnNodeView[] refreshingAlreadyReservation;
        public LiveCdnNodeView[] refreshingButtonIcon;
        public LiveCdnNodeView[] refreshingDisplayBackgroundUrl;
        public int reservationActivityType;
        public String reservationId;
        public long reservedUserCount;

        public static SCLiveReservationStickerUpdate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveReservationStickerUpdate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveReservationStickerUpdate() {
            clear();
        }

        public final SCLiveReservationStickerUpdate clear() {
            this.reservationId = "";
            this.displayTime = "";
            this.displayDay = "";
            this.reservedUserCount = 0L;
            this.displayReservedUserCount = "";
            this.displayReservedUserCountSuffix = "";
            this.enableDisplayReserveButton = false;
            this.disableCancelReservation = false;
            this.displayBackgroundUrl = LiveCdnNodeView.emptyArray();
            this.reservationActivityType = 0;
            this.authorId = 0L;
            this.buttonIcon = LiveCdnNodeView.emptyArray();
            this.refreshingButtonIcon = LiveCdnNodeView.emptyArray();
            this.refreshingDisplayBackgroundUrl = LiveCdnNodeView.emptyArray();
            this.refreshingAlreadyReservation = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.reservationId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.reservationId);
            }
            if (!this.displayTime.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.displayTime);
            }
            if (!this.displayDay.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.displayDay);
            }
            long j = this.reservedUserCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.displayReservedUserCount.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.displayReservedUserCount);
            }
            if (!this.displayReservedUserCountSuffix.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.displayReservedUserCountSuffix);
            }
            boolean z = this.enableDisplayReserveButton;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            boolean z2 = this.disableCancelReservation;
            if (z2) {
                codedOutputByteBufferNano.writeBool(8, z2);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.displayBackgroundUrl;
            int i = 0;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.displayBackgroundUrl;
                    if (i2 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i2];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(9, liveCdnNodeView);
                    }
                    i2++;
                }
            }
            int i3 = this.reservationActivityType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(10, i3);
            }
            long j2 = this.authorId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j2);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr3 = this.buttonIcon;
            if (liveCdnNodeViewArr3 != null && liveCdnNodeViewArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr4 = this.buttonIcon;
                    if (i4 >= liveCdnNodeViewArr4.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView2 = liveCdnNodeViewArr4[i4];
                    if (liveCdnNodeView2 != null) {
                        codedOutputByteBufferNano.writeMessage(12, liveCdnNodeView2);
                    }
                    i4++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr5 = this.refreshingButtonIcon;
            if (liveCdnNodeViewArr5 != null && liveCdnNodeViewArr5.length > 0) {
                int i5 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr6 = this.refreshingButtonIcon;
                    if (i5 >= liveCdnNodeViewArr6.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView3 = liveCdnNodeViewArr6[i5];
                    if (liveCdnNodeView3 != null) {
                        codedOutputByteBufferNano.writeMessage(13, liveCdnNodeView3);
                    }
                    i5++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr7 = this.refreshingDisplayBackgroundUrl;
            if (liveCdnNodeViewArr7 != null && liveCdnNodeViewArr7.length > 0) {
                int i6 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr8 = this.refreshingDisplayBackgroundUrl;
                    if (i6 >= liveCdnNodeViewArr8.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView4 = liveCdnNodeViewArr8[i6];
                    if (liveCdnNodeView4 != null) {
                        codedOutputByteBufferNano.writeMessage(14, liveCdnNodeView4);
                    }
                    i6++;
                }
            }
            LiveCdnNodeView[] liveCdnNodeViewArr9 = this.refreshingAlreadyReservation;
            if (liveCdnNodeViewArr9 != null && liveCdnNodeViewArr9.length > 0) {
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr10 = this.refreshingAlreadyReservation;
                    if (i >= liveCdnNodeViewArr10.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView5 = liveCdnNodeViewArr10[i];
                    if (liveCdnNodeView5 != null) {
                        codedOutputByteBufferNano.writeMessage(15, liveCdnNodeView5);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.reservationId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.reservationId);
            }
            if (!this.displayTime.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.displayTime);
            }
            if (!this.displayDay.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayDay);
            }
            long j = this.reservedUserCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.displayReservedUserCount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayReservedUserCount);
            }
            if (!this.displayReservedUserCountSuffix.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.displayReservedUserCountSuffix);
            }
            boolean z = this.enableDisplayReserveButton;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            boolean z2 = this.disableCancelReservation;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z2);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.displayBackgroundUrl;
            int i = 0;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.displayBackgroundUrl;
                    if (i2 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i2];
                    if (liveCdnNodeView != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(9, liveCdnNodeView);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            int i3 = this.reservationActivityType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i3);
            }
            long j2 = this.authorId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j2);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr3 = this.buttonIcon;
            if (liveCdnNodeViewArr3 != null && liveCdnNodeViewArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr4 = this.buttonIcon;
                    if (i4 >= liveCdnNodeViewArr4.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView2 = liveCdnNodeViewArr4[i4];
                    if (liveCdnNodeView2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(12, liveCdnNodeView2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr5 = this.refreshingButtonIcon;
            if (liveCdnNodeViewArr5 != null && liveCdnNodeViewArr5.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr6 = this.refreshingButtonIcon;
                    if (i5 >= liveCdnNodeViewArr6.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView3 = liveCdnNodeViewArr6[i5];
                    if (liveCdnNodeView3 != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(13, liveCdnNodeView3);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr7 = this.refreshingDisplayBackgroundUrl;
            if (liveCdnNodeViewArr7 != null && liveCdnNodeViewArr7.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr8 = this.refreshingDisplayBackgroundUrl;
                    if (i6 >= liveCdnNodeViewArr8.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView4 = liveCdnNodeViewArr8[i6];
                    if (liveCdnNodeView4 != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(14, liveCdnNodeView4);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            LiveCdnNodeView[] liveCdnNodeViewArr9 = this.refreshingAlreadyReservation;
            if (liveCdnNodeViewArr9 != null && liveCdnNodeViewArr9.length > 0) {
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr10 = this.refreshingAlreadyReservation;
                    if (i >= liveCdnNodeViewArr10.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView5 = liveCdnNodeViewArr10[i];
                    if (liveCdnNodeView5 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, liveCdnNodeView5);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveReservationStickerUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.reservationId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.displayTime = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.displayDay = codedInputByteBufferNano.readString();
                        break;
                    case 32:
                        this.reservedUserCount = codedInputByteBufferNano.readUInt64();
                        break;
                    case 42:
                        this.displayReservedUserCount = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.displayReservedUserCountSuffix = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.enableDisplayReserveButton = codedInputByteBufferNano.readBool();
                        break;
                    case 64:
                        this.disableCancelReservation = codedInputByteBufferNano.readBool();
                        break;
                    case 74:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        LiveCdnNodeView[] liveCdnNodeViewArr = this.displayBackgroundUrl;
                        int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.displayBackgroundUrl, 0, liveCdnNodeViewArr2, 0, length);
                        }
                        while (length < liveCdnNodeViewArr2.length - 1) {
                            liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        this.displayBackgroundUrl = liveCdnNodeViewArr2;
                        break;
                    case 80:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1) {
                            break;
                        } else {
                            this.reservationActivityType = int32;
                            break;
                        }
                        break;
                    case 88:
                        this.authorId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 98:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        LiveCdnNodeView[] liveCdnNodeViewArr3 = this.buttonIcon;
                        int length2 = liveCdnNodeViewArr3 == null ? 0 : liveCdnNodeViewArr3.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr4 = new LiveCdnNodeView[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.buttonIcon, 0, liveCdnNodeViewArr4, 0, length2);
                        }
                        while (length2 < liveCdnNodeViewArr4.length - 1) {
                            liveCdnNodeViewArr4[length2] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        liveCdnNodeViewArr4[length2] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr4[length2]);
                        this.buttonIcon = liveCdnNodeViewArr4;
                        break;
                    case 106:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        LiveCdnNodeView[] liveCdnNodeViewArr5 = this.refreshingButtonIcon;
                        int length3 = liveCdnNodeViewArr5 == null ? 0 : liveCdnNodeViewArr5.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr6 = new LiveCdnNodeView[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.refreshingButtonIcon, 0, liveCdnNodeViewArr6, 0, length3);
                        }
                        while (length3 < liveCdnNodeViewArr6.length - 1) {
                            liveCdnNodeViewArr6[length3] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        liveCdnNodeViewArr6[length3] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr6[length3]);
                        this.refreshingButtonIcon = liveCdnNodeViewArr6;
                        break;
                    case 114:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                        LiveCdnNodeView[] liveCdnNodeViewArr7 = this.refreshingDisplayBackgroundUrl;
                        int length4 = liveCdnNodeViewArr7 == null ? 0 : liveCdnNodeViewArr7.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr8 = new LiveCdnNodeView[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.refreshingDisplayBackgroundUrl, 0, liveCdnNodeViewArr8, 0, length4);
                        }
                        while (length4 < liveCdnNodeViewArr8.length - 1) {
                            liveCdnNodeViewArr8[length4] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr8[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        liveCdnNodeViewArr8[length4] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr8[length4]);
                        this.refreshingDisplayBackgroundUrl = liveCdnNodeViewArr8;
                        break;
                    case 122:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                        LiveCdnNodeView[] liveCdnNodeViewArr9 = this.refreshingAlreadyReservation;
                        int length5 = liveCdnNodeViewArr9 == null ? 0 : liveCdnNodeViewArr9.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr10 = new LiveCdnNodeView[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.refreshingAlreadyReservation, 0, liveCdnNodeViewArr10, 0, length5);
                        }
                        while (length5 < liveCdnNodeViewArr10.length - 1) {
                            liveCdnNodeViewArr10[length5] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr10[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        liveCdnNodeViewArr10[length5] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr10[length5]);
                        this.refreshingAlreadyReservation = liveCdnNodeViewArr10;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveReservationStickerUpdate parseFrom(byte[] bArr) {
            return (SCLiveReservationStickerUpdate) MessageNano.mergeFrom(new SCLiveReservationStickerUpdate(), bArr);
        }

        public static SCLiveReservationStickerUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveReservationStickerUpdate().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveReservationStickerInfo extends MessageNano {
        private static volatile SCLiveReservationStickerInfo[] _emptyArray;
        public SCLiveReservationStickerUpdate[] reservationSticker;

        public static SCLiveReservationStickerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveReservationStickerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveReservationStickerInfo() {
            clear();
        }

        public final SCLiveReservationStickerInfo clear() {
            this.reservationSticker = SCLiveReservationStickerUpdate.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            SCLiveReservationStickerUpdate[] sCLiveReservationStickerUpdateArr = this.reservationSticker;
            if (sCLiveReservationStickerUpdateArr != null && sCLiveReservationStickerUpdateArr.length > 0) {
                int i = 0;
                while (true) {
                    SCLiveReservationStickerUpdate[] sCLiveReservationStickerUpdateArr2 = this.reservationSticker;
                    if (i >= sCLiveReservationStickerUpdateArr2.length) {
                        break;
                    }
                    SCLiveReservationStickerUpdate sCLiveReservationStickerUpdate = sCLiveReservationStickerUpdateArr2[i];
                    if (sCLiveReservationStickerUpdate != null) {
                        codedOutputByteBufferNano.writeMessage(1, sCLiveReservationStickerUpdate);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            SCLiveReservationStickerUpdate[] sCLiveReservationStickerUpdateArr = this.reservationSticker;
            if (sCLiveReservationStickerUpdateArr != null && sCLiveReservationStickerUpdateArr.length > 0) {
                int i = 0;
                while (true) {
                    SCLiveReservationStickerUpdate[] sCLiveReservationStickerUpdateArr2 = this.reservationSticker;
                    if (i >= sCLiveReservationStickerUpdateArr2.length) {
                        break;
                    }
                    SCLiveReservationStickerUpdate sCLiveReservationStickerUpdate = sCLiveReservationStickerUpdateArr2[i];
                    if (sCLiveReservationStickerUpdate != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sCLiveReservationStickerUpdate);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveReservationStickerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    SCLiveReservationStickerUpdate[] sCLiveReservationStickerUpdateArr = this.reservationSticker;
                    int length = sCLiveReservationStickerUpdateArr == null ? 0 : sCLiveReservationStickerUpdateArr.length;
                    SCLiveReservationStickerUpdate[] sCLiveReservationStickerUpdateArr2 = new SCLiveReservationStickerUpdate[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.reservationSticker, 0, sCLiveReservationStickerUpdateArr2, 0, length);
                    }
                    while (length < sCLiveReservationStickerUpdateArr2.length - 1) {
                        sCLiveReservationStickerUpdateArr2[length] = new SCLiveReservationStickerUpdate();
                        codedInputByteBufferNano.readMessage(sCLiveReservationStickerUpdateArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sCLiveReservationStickerUpdateArr2[length] = new SCLiveReservationStickerUpdate();
                    codedInputByteBufferNano.readMessage(sCLiveReservationStickerUpdateArr2[length]);
                    this.reservationSticker = sCLiveReservationStickerUpdateArr2;
                }
            }
        }

        public static SCLiveReservationStickerInfo parseFrom(byte[] bArr) {
            return (SCLiveReservationStickerInfo) MessageNano.mergeFrom(new SCLiveReservationStickerInfo(), bArr);
        }

        public static SCLiveReservationStickerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveReservationStickerInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveReservationStickerClose extends MessageNano {
        private static volatile SCLiveReservationStickerClose[] _emptyArray;
        public boolean stickerClose;

        public static SCLiveReservationStickerClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveReservationStickerClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveReservationStickerClose() {
            clear();
        }

        public final SCLiveReservationStickerClose clear() {
            this.stickerClose = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.stickerClose;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.stickerClose;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveReservationStickerClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.stickerClose = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static SCLiveReservationStickerClose parseFrom(byte[] bArr) {
            return (SCLiveReservationStickerClose) MessageNano.mergeFrom(new SCLiveReservationStickerClose(), bArr);
        }

        public static SCLiveReservationStickerClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveReservationStickerClose().mergeFrom(codedInputByteBufferNano);
        }
    }
}
