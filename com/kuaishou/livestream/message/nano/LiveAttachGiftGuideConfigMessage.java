package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveAttachGiftGuideConfigMessage extends MessageNano {
    private static volatile LiveAttachGiftGuideConfigMessage[] _emptyArray;
    public Map<Integer, String> attachGiftActivityInfo;
    public int[] attachGiftIdList;
    public LiveAttachFastGiftConfigMessage[] attachGiftIds;
    public String giftToken;
    public String recoGiftLlsid;

    public static final class LiveAttachFastGiftConfigMessage extends MessageNano {
        private static volatile LiveAttachFastGiftConfigMessage[] _emptyArray;
        public boolean enableDefaultSelectNotNotify;
        public int giftId;
        public String notNotifyText;
        public String[] sendGiftMsgKeys;

        public static LiveAttachFastGiftConfigMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAttachFastGiftConfigMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAttachFastGiftConfigMessage() {
            clear();
        }

        public final LiveAttachFastGiftConfigMessage clear() {
            this.giftId = 0;
            this.sendGiftMsgKeys = WireFormatNano.EMPTY_STRING_ARRAY;
            this.notNotifyText = "";
            this.enableDefaultSelectNotNotify = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            String[] strArr = this.sendGiftMsgKeys;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.sendGiftMsgKeys;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(2, str);
                    }
                    i2++;
                }
            }
            if (!this.notNotifyText.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.notNotifyText);
            }
            boolean z = this.enableDefaultSelectNotNotify;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            String[] strArr = this.sendGiftMsgKeys;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.sendGiftMsgKeys;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            if (!this.notNotifyText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.notNotifyText);
            }
            boolean z = this.enableDefaultSelectNotNotify;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAttachFastGiftConfigMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    String[] strArr = this.sendGiftMsgKeys;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.sendGiftMsgKeys, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.sendGiftMsgKeys = strArr2;
                } else if (tag == 26) {
                    this.notNotifyText = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enableDefaultSelectNotNotify = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveAttachFastGiftConfigMessage parseFrom(byte[] bArr) {
            return (LiveAttachFastGiftConfigMessage) MessageNano.mergeFrom(new LiveAttachFastGiftConfigMessage(), bArr);
        }

        public static LiveAttachFastGiftConfigMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAttachFastGiftConfigMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static LiveAttachGiftGuideConfigMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveAttachGiftGuideConfigMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveAttachGiftGuideConfigMessage() {
        clear();
    }

    public final LiveAttachGiftGuideConfigMessage clear() {
        this.recoGiftLlsid = "";
        this.attachGiftIdList = WireFormatNano.EMPTY_INT_ARRAY;
        this.attachGiftActivityInfo = null;
        this.giftToken = "";
        this.attachGiftIds = LiveAttachFastGiftConfigMessage.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.recoGiftLlsid.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.recoGiftLlsid);
        }
        int[] iArr = this.attachGiftIdList;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.attachGiftIdList;
                if (i2 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(2, iArr2[i2]);
                i2++;
            }
        }
        Map<Integer, String> map = this.attachGiftActivityInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 13, 9);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.giftToken);
        }
        LiveAttachFastGiftConfigMessage[] liveAttachFastGiftConfigMessageArr = this.attachGiftIds;
        if (liveAttachFastGiftConfigMessageArr != null && liveAttachFastGiftConfigMessageArr.length > 0) {
            while (true) {
                LiveAttachFastGiftConfigMessage[] liveAttachFastGiftConfigMessageArr2 = this.attachGiftIds;
                if (i >= liveAttachFastGiftConfigMessageArr2.length) {
                    break;
                }
                LiveAttachFastGiftConfigMessage liveAttachFastGiftConfigMessage = liveAttachFastGiftConfigMessageArr2[i];
                if (liveAttachFastGiftConfigMessage != null) {
                    codedOutputByteBufferNano.writeMessage(5, liveAttachFastGiftConfigMessage);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int[] iArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.recoGiftLlsid.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.recoGiftLlsid);
        }
        int[] iArr2 = this.attachGiftIdList;
        int i = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i2 = 0;
            int iComputeInt32SizeNoTag = 0;
            while (true) {
                iArr = this.attachGiftIdList;
                if (i2 >= iArr.length) {
                    break;
                }
                iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i2]);
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr.length * 1);
        }
        Map<Integer, String> map = this.attachGiftActivityInfo;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 3, 13, 9);
        }
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.giftToken);
        }
        LiveAttachFastGiftConfigMessage[] liveAttachFastGiftConfigMessageArr = this.attachGiftIds;
        if (liveAttachFastGiftConfigMessageArr != null && liveAttachFastGiftConfigMessageArr.length > 0) {
            while (true) {
                LiveAttachFastGiftConfigMessage[] liveAttachFastGiftConfigMessageArr2 = this.attachGiftIds;
                if (i >= liveAttachFastGiftConfigMessageArr2.length) {
                    break;
                }
                LiveAttachFastGiftConfigMessage liveAttachFastGiftConfigMessage = liveAttachFastGiftConfigMessageArr2[i];
                if (liveAttachFastGiftConfigMessage != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveAttachFastGiftConfigMessage);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveAttachGiftGuideConfigMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.recoGiftLlsid = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                int[] iArr = this.attachGiftIdList;
                int length = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.attachGiftIdList, 0, iArr2, 0, length);
                }
                while (length < iArr2.length - 1) {
                    iArr2[length] = codedInputByteBufferNano.readInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readInt32();
                this.attachGiftIdList = iArr2;
            } else if (tag == 18) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readInt32();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.attachGiftIdList;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.attachGiftIdList, 0, iArr4, 0, length2);
                }
                while (length2 < iArr4.length) {
                    iArr4[length2] = codedInputByteBufferNano.readInt32();
                    length2++;
                }
                this.attachGiftIdList = iArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag == 26) {
                this.attachGiftActivityInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.attachGiftActivityInfo, mapFactory, 13, 9, null, 8, 18);
            } else if (tag == 34) {
                this.giftToken = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                LiveAttachFastGiftConfigMessage[] liveAttachFastGiftConfigMessageArr = this.attachGiftIds;
                int length3 = liveAttachFastGiftConfigMessageArr == null ? 0 : liveAttachFastGiftConfigMessageArr.length;
                LiveAttachFastGiftConfigMessage[] liveAttachFastGiftConfigMessageArr2 = new LiveAttachFastGiftConfigMessage[repeatedFieldArrayLength2 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.attachGiftIds, 0, liveAttachFastGiftConfigMessageArr2, 0, length3);
                }
                while (length3 < liveAttachFastGiftConfigMessageArr2.length - 1) {
                    liveAttachFastGiftConfigMessageArr2[length3] = new LiveAttachFastGiftConfigMessage();
                    codedInputByteBufferNano.readMessage(liveAttachFastGiftConfigMessageArr2[length3]);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                liveAttachFastGiftConfigMessageArr2[length3] = new LiveAttachFastGiftConfigMessage();
                codedInputByteBufferNano.readMessage(liveAttachFastGiftConfigMessageArr2[length3]);
                this.attachGiftIds = liveAttachFastGiftConfigMessageArr2;
            }
        }
    }

    public static LiveAttachGiftGuideConfigMessage parseFrom(byte[] bArr) {
        return (LiveAttachGiftGuideConfigMessage) MessageNano.mergeFrom(new LiveAttachGiftGuideConfigMessage(), bArr);
    }

    public static LiveAttachGiftGuideConfigMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveAttachGiftGuideConfigMessage().mergeFrom(codedInputByteBufferNano);
    }
}
