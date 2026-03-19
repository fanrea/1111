package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveExtraMessages;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveShopMessages {

    public static final class SCShopMerchantStartPlayNotice extends MessageNano {
        private static volatile SCShopMerchantStartPlayNotice[] _emptyArray;
        public int[] allowSourceType;
        public String confirmText;
        public String liveStreamId;
        public String popWindowText;
        public String titleText;

        public static SCShopMerchantStartPlayNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCShopMerchantStartPlayNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCShopMerchantStartPlayNotice() {
            clear();
        }

        public final SCShopMerchantStartPlayNotice clear() {
            this.liveStreamId = "";
            this.popWindowText = "";
            this.allowSourceType = WireFormatNano.EMPTY_INT_ARRAY;
            this.confirmText = "";
            this.titleText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.popWindowText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.popWindowText);
            }
            int[] iArr = this.allowSourceType;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.allowSourceType;
                    if (i >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(3, iArr2[i]);
                    i++;
                }
            }
            if (!this.confirmText.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.confirmText);
            }
            if (!this.titleText.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.titleText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.popWindowText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.popWindowText);
            }
            int[] iArr2 = this.allowSourceType;
            if (iArr2 != null && iArr2.length > 0) {
                int i = 0;
                int iComputeInt32SizeNoTag = 0;
                while (true) {
                    iArr = this.allowSourceType;
                    if (i >= iArr.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i]);
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr.length * 1);
            }
            if (!this.confirmText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.confirmText);
            }
            return !this.titleText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.titleText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCShopMerchantStartPlayNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.popWindowText = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    int[] iArr = new int[repeatedFieldArrayLength];
                    int i = 0;
                    for (int i2 = 0; i2 < repeatedFieldArrayLength; i2++) {
                        if (i2 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
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
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                            case 58:
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                            case 63:
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                            case 76:
                            case 77:
                            case 78:
                            case 79:
                            case 80:
                            case 81:
                            case 82:
                            case 83:
                            case 84:
                            case 85:
                            case 86:
                            case 87:
                            case 88:
                            case 89:
                            case 90:
                            case 91:
                            case 92:
                            case 93:
                            case 94:
                            case 95:
                            case 96:
                            case 97:
                            case 98:
                            case 99:
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                            case 110:
                            case 111:
                            case 112:
                            case 113:
                            case 114:
                            case 115:
                            case 116:
                            case 117:
                            case 118:
                            case 119:
                            case 120:
                            case 121:
                            case 122:
                            case 123:
                            case 124:
                            case 125:
                            case 126:
                            case 127:
                            case 128:
                            case 129:
                            case 130:
                            case 131:
                                iArr[i] = int32;
                                i++;
                                break;
                        }
                    }
                    if (i != 0) {
                        int[] iArr2 = this.allowSourceType;
                        int length = iArr2 == null ? 0 : iArr2.length;
                        if (length == 0 && i == repeatedFieldArrayLength) {
                            this.allowSourceType = iArr;
                        } else {
                            int[] iArr3 = new int[length + i];
                            if (length != 0) {
                                System.arraycopy(this.allowSourceType, 0, iArr3, 0, length);
                            }
                            System.arraycopy(iArr, 0, iArr3, length, i);
                            this.allowSourceType = iArr3;
                        }
                    }
                } else if (tag == 26) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        switch (codedInputByteBufferNano.readInt32()) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                            case 58:
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                            case 63:
                            case 64:
                            case 65:
                            case 66:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                            case 76:
                            case 77:
                            case 78:
                            case 79:
                            case 80:
                            case 81:
                            case 82:
                            case 83:
                            case 84:
                            case 85:
                            case 86:
                            case 87:
                            case 88:
                            case 89:
                            case 90:
                            case 91:
                            case 92:
                            case 93:
                            case 94:
                            case 95:
                            case 96:
                            case 97:
                            case 98:
                            case 99:
                            case 100:
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 106:
                            case 107:
                            case 108:
                            case 109:
                            case 110:
                            case 111:
                            case 112:
                            case 113:
                            case 114:
                            case 115:
                            case 116:
                            case 117:
                            case 118:
                            case 119:
                            case 120:
                            case 121:
                            case 122:
                            case 123:
                            case 124:
                            case 125:
                            case 126:
                            case 127:
                            case 128:
                            case 129:
                            case 130:
                            case 131:
                                i3++;
                                break;
                        }
                    }
                    if (i3 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr4 = this.allowSourceType;
                        int length2 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i3 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.allowSourceType, 0, iArr5, 0, length2);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int int322 = codedInputByteBufferNano.readInt32();
                            switch (int322) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 88:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 111:
                                case 112:
                                case 113:
                                case 114:
                                case 115:
                                case 116:
                                case 117:
                                case 118:
                                case 119:
                                case 120:
                                case 121:
                                case 122:
                                case 123:
                                case 124:
                                case 125:
                                case 126:
                                case 127:
                                case 128:
                                case 129:
                                case 130:
                                case 131:
                                    iArr5[length2] = int322;
                                    length2++;
                                    break;
                            }
                        }
                        this.allowSourceType = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag == 34) {
                    this.confirmText = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.titleText = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCShopMerchantStartPlayNotice parseFrom(byte[] bArr) {
            return (SCShopMerchantStartPlayNotice) MessageNano.mergeFrom(new SCShopMerchantStartPlayNotice(), bArr);
        }

        public static SCShopMerchantStartPlayNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCShopMerchantStartPlayNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShopState extends MessageNano {
        private static volatile SCLiveShopState[] _emptyArray;
        public LiveExtraMessages.LiveCommonAbstractSignal state;

        public static SCLiveShopState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShopState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShopState() {
            clear();
        }

        public final SCLiveShopState clear() {
            this.state = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = this.state;
            if (liveCommonAbstractSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonAbstractSignal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = this.state;
            return liveCommonAbstractSignal != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonAbstractSignal) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShopState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.state == null) {
                        this.state = new LiveExtraMessages.LiveCommonAbstractSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.state);
                }
            }
        }

        public static SCLiveShopState parseFrom(byte[] bArr) {
            return (SCLiveShopState) MessageNano.mergeFrom(new SCLiveShopState(), bArr);
        }

        public static SCLiveShopState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShopState().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShopAction extends MessageNano {
        private static volatile SCLiveShopAction[] _emptyArray;
        public LiveExtraMessages.LiveCommonAbstractSignal action;

        public static SCLiveShopAction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShopAction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShopAction() {
            clear();
        }

        public final SCLiveShopAction clear() {
            this.action = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            if (liveCommonAbstractSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonAbstractSignal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            return liveCommonAbstractSignal != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonAbstractSignal) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShopAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.action == null) {
                        this.action = new LiveExtraMessages.LiveCommonAbstractSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.action);
                }
            }
        }

        public static SCLiveShopAction parseFrom(byte[] bArr) {
            return (SCLiveShopAction) MessageNano.mergeFrom(new SCLiveShopAction(), bArr);
        }

        public static SCLiveShopAction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShopAction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShopAction extends MessageNano {
        private static volatile LiveShopAction[] _emptyArray;
        public LiveExtraMessages.LiveCommonAbstractSignal action;

        public static LiveShopAction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShopAction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShopAction() {
            clear();
        }

        public final LiveShopAction clear() {
            this.action = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            if (liveCommonAbstractSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonAbstractSignal);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveExtraMessages.LiveCommonAbstractSignal liveCommonAbstractSignal = this.action;
            return liveCommonAbstractSignal != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonAbstractSignal) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShopAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.action == null) {
                        this.action = new LiveExtraMessages.LiveCommonAbstractSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.action);
                }
            }
        }

        public static LiveShopAction parseFrom(byte[] bArr) {
            return (LiveShopAction) MessageNano.mergeFrom(new LiveShopAction(), bArr);
        }

        public static LiveShopAction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShopAction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveInteractiveRoomShopCartStatus extends MessageNano {
        private static volatile LiveInteractiveRoomShopCartStatus[] _emptyArray;
        public LiveShopCartHiddenReason[] forbiddenUserWithHiddenReason;
        public boolean hiddenShopCart;

        public static LiveInteractiveRoomShopCartStatus[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveInteractiveRoomShopCartStatus[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveInteractiveRoomShopCartStatus() {
            clear();
        }

        public final LiveInteractiveRoomShopCartStatus clear() {
            this.hiddenShopCart = false;
            this.forbiddenUserWithHiddenReason = LiveShopCartHiddenReason.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.hiddenShopCart;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            LiveShopCartHiddenReason[] liveShopCartHiddenReasonArr = this.forbiddenUserWithHiddenReason;
            if (liveShopCartHiddenReasonArr != null && liveShopCartHiddenReasonArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveShopCartHiddenReason[] liveShopCartHiddenReasonArr2 = this.forbiddenUserWithHiddenReason;
                    if (i >= liveShopCartHiddenReasonArr2.length) {
                        break;
                    }
                    LiveShopCartHiddenReason liveShopCartHiddenReason = liveShopCartHiddenReasonArr2[i];
                    if (liveShopCartHiddenReason != null) {
                        codedOutputByteBufferNano.writeMessage(2, liveShopCartHiddenReason);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.hiddenShopCart;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            LiveShopCartHiddenReason[] liveShopCartHiddenReasonArr = this.forbiddenUserWithHiddenReason;
            if (liveShopCartHiddenReasonArr != null && liveShopCartHiddenReasonArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveShopCartHiddenReason[] liveShopCartHiddenReasonArr2 = this.forbiddenUserWithHiddenReason;
                    if (i >= liveShopCartHiddenReasonArr2.length) {
                        break;
                    }
                    LiveShopCartHiddenReason liveShopCartHiddenReason = liveShopCartHiddenReasonArr2[i];
                    if (liveShopCartHiddenReason != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveShopCartHiddenReason);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveInteractiveRoomShopCartStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.hiddenShopCart = codedInputByteBufferNano.readBool();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    LiveShopCartHiddenReason[] liveShopCartHiddenReasonArr = this.forbiddenUserWithHiddenReason;
                    int length = liveShopCartHiddenReasonArr == null ? 0 : liveShopCartHiddenReasonArr.length;
                    LiveShopCartHiddenReason[] liveShopCartHiddenReasonArr2 = new LiveShopCartHiddenReason[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.forbiddenUserWithHiddenReason, 0, liveShopCartHiddenReasonArr2, 0, length);
                    }
                    while (length < liveShopCartHiddenReasonArr2.length - 1) {
                        liveShopCartHiddenReasonArr2[length] = new LiveShopCartHiddenReason();
                        codedInputByteBufferNano.readMessage(liveShopCartHiddenReasonArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveShopCartHiddenReasonArr2[length] = new LiveShopCartHiddenReason();
                    codedInputByteBufferNano.readMessage(liveShopCartHiddenReasonArr2[length]);
                    this.forbiddenUserWithHiddenReason = liveShopCartHiddenReasonArr2;
                }
            }
        }

        public static LiveInteractiveRoomShopCartStatus parseFrom(byte[] bArr) {
            return (LiveInteractiveRoomShopCartStatus) MessageNano.mergeFrom(new LiveInteractiveRoomShopCartStatus(), bArr);
        }

        public static LiveInteractiveRoomShopCartStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveInteractiveRoomShopCartStatus().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShopCartHiddenReason extends MessageNano {
        private static volatile LiveShopCartHiddenReason[] _emptyArray;
        public int hiddenType;
        public long userId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ShopCartHiddenType {
            public static final int HIGH_ACU = 2;
            public static final int LOW_DSR = 1;
            public static final int PEER_HIGH_ACU = 4;
            public static final int PEER_LOW_DSR = 3;
            public static final int UNKNOWN_SHOP_CART_HIDDEN_TYPE = 0;
        }

        public static LiveShopCartHiddenReason[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShopCartHiddenReason[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShopCartHiddenReason() {
            clear();
        }

        public final LiveShopCartHiddenReason clear() {
            this.userId = 0L;
            this.hiddenType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.hiddenType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.hiddenType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShopCartHiddenReason mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                        this.hiddenType = int32;
                    }
                }
            }
        }

        public static LiveShopCartHiddenReason parseFrom(byte[] bArr) {
            return (LiveShopCartHiddenReason) MessageNano.mergeFrom(new LiveShopCartHiddenReason(), bArr);
        }

        public static LiveShopCartHiddenReason parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShopCartHiddenReason().mergeFrom(codedInputByteBufferNano);
        }
    }
}
