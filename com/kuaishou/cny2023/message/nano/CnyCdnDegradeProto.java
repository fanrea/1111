package com.kuaishou.cny2023.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface CnyCdnDegradeProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CdnDegradeEffectLocation {
        public static final int ALL = 5;
        public static final int GIFT_SLOT = 1;
        public static final int LUCKY_STAR = 3;
        public static final int SHARE = 4;
        public static final int UNKNOWN_EFFECT_LOCATION = 0;
        public static final int WATCHING_LIST = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CdnDegradeLevel {
        public static final int DEGRADE_LEVEL_P0 = 1;
        public static final int DEGRADE_LEVEL_P1 = 2;
        public static final int DEGRADE_LEVEL_P2 = 3;
        public static final int UNKOWN_DEGRADE_LEVEL = 0;
    }

    public static final class CdnDegradeConfig extends MessageNano {
        private static volatile CdnDegradeConfig[] _emptyArray;
        public int degradeLevel;
        public String degradeText;
        public String resourceType;

        public static CdnDegradeConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CdnDegradeConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CdnDegradeConfig() {
            clear();
        }

        public final CdnDegradeConfig clear() {
            this.degradeLevel = 0;
            this.resourceType = "";
            this.degradeText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.degradeLevel;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.resourceType.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.resourceType);
            }
            if (!this.degradeText.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.degradeText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.degradeLevel;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.resourceType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.resourceType);
            }
            return !this.degradeText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.degradeText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CdnDegradeConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.degradeLevel = int32;
                    }
                } else if (tag == 18) {
                    this.resourceType = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.degradeText = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CdnDegradeConfig parseFrom(byte[] bArr) {
            return (CdnDegradeConfig) MessageNano.mergeFrom(new CdnDegradeConfig(), bArr);
        }

        public static CdnDegradeConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CdnDegradeConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DegradablePicUrl extends MessageNano {
        private static volatile DegradablePicUrl[] _emptyArray;
        public CdnDegradeConfig cdnDegradeConfig;
        public UserInfos.PicUrl[] picUrl;

        public static DegradablePicUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DegradablePicUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DegradablePicUrl() {
            clear();
        }

        public final DegradablePicUrl clear() {
            this.picUrl = UserInfos.PicUrl.emptyArray();
            this.cdnDegradeConfig = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i++;
                }
            }
            CdnDegradeConfig cdnDegradeConfig = this.cdnDegradeConfig;
            if (cdnDegradeConfig != null) {
                codedOutputByteBufferNano.writeMessage(2, cdnDegradeConfig);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i++;
                }
            }
            CdnDegradeConfig cdnDegradeConfig = this.cdnDegradeConfig;
            return cdnDegradeConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, cdnDegradeConfig) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DegradablePicUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.picUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.picUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.picUrl = picUrlArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.cdnDegradeConfig == null) {
                        this.cdnDegradeConfig = new CdnDegradeConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.cdnDegradeConfig);
                }
            }
        }

        public static DegradablePicUrl parseFrom(byte[] bArr) {
            return (DegradablePicUrl) MessageNano.mergeFrom(new DegradablePicUrl(), bArr);
        }

        public static DegradablePicUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DegradablePicUrl().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DegradableHeadUrlUserInfo extends MessageNano {
        private static volatile DegradableHeadUrlUserInfo[] _emptyArray;
        public CdnDegradeConfig cdnDegradeConfig;
        public UserInfos.UserInfo userInfo;

        public static DegradableHeadUrlUserInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DegradableHeadUrlUserInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DegradableHeadUrlUserInfo() {
            clear();
        }

        public final DegradableHeadUrlUserInfo clear() {
            this.userInfo = null;
            this.cdnDegradeConfig = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            CdnDegradeConfig cdnDegradeConfig = this.cdnDegradeConfig;
            if (cdnDegradeConfig != null) {
                codedOutputByteBufferNano.writeMessage(2, cdnDegradeConfig);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            CdnDegradeConfig cdnDegradeConfig = this.cdnDegradeConfig;
            return cdnDegradeConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, cdnDegradeConfig) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DegradableHeadUrlUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.userInfo == null) {
                        this.userInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfo);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.cdnDegradeConfig == null) {
                        this.cdnDegradeConfig = new CdnDegradeConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.cdnDegradeConfig);
                }
            }
        }

        public static DegradableHeadUrlUserInfo parseFrom(byte[] bArr) {
            return (DegradableHeadUrlUserInfo) MessageNano.mergeFrom(new DegradableHeadUrlUserInfo(), bArr);
        }

        public static DegradableHeadUrlUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DegradableHeadUrlUserInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCCdnDegradeCommandStateSignal extends MessageNano {
        private static volatile SCCdnDegradeCommandStateSignal[] _emptyArray;
        public int cdnDegradeLevel;
        public int[] location;
        public long timestamp;

        public static SCCdnDegradeCommandStateSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCCdnDegradeCommandStateSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCCdnDegradeCommandStateSignal() {
            clear();
        }

        public final SCCdnDegradeCommandStateSignal clear() {
            this.cdnDegradeLevel = 0;
            this.timestamp = 0L;
            this.location = WireFormatNano.EMPTY_INT_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.cdnDegradeLevel;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int[] iArr = this.location;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.location;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(3, iArr2[i2]);
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.cdnDegradeLevel;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int[] iArr = this.location;
            if (iArr == null || iArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i2 = 0;
            int iComputeInt32SizeNoTag = 0;
            while (true) {
                int[] iArr2 = this.location;
                if (i2 < iArr2.length) {
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                    i2++;
                } else {
                    return iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr2.length * 1);
                }
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCCdnDegradeCommandStateSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.cdnDegradeLevel = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    int[] iArr = new int[repeatedFieldArrayLength];
                    int i = 0;
                    for (int i2 = 0; i2 < repeatedFieldArrayLength; i2++) {
                        if (i2 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                            iArr[i] = int32;
                            i++;
                        }
                    }
                    if (i != 0) {
                        int[] iArr2 = this.location;
                        int length = iArr2 == null ? 0 : iArr2.length;
                        if (length == 0 && i == repeatedFieldArrayLength) {
                            this.location = iArr;
                        } else {
                            int[] iArr3 = new int[length + i];
                            if (length != 0) {
                                System.arraycopy(this.location, 0, iArr3, 0, length);
                            }
                            System.arraycopy(iArr, 0, iArr3, length, i);
                            this.location = iArr3;
                        }
                    }
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3 || int322 == 4 || int322 == 5) {
                            i3++;
                        }
                    }
                    if (i3 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr4 = this.location;
                        int length2 = iArr4 == null ? 0 : iArr4.length;
                        int[] iArr5 = new int[i3 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.location, 0, iArr5, 0, length2);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int int323 = codedInputByteBufferNano.readInt32();
                            if (int323 == 0 || int323 == 1 || int323 == 2 || int323 == 3 || int323 == 4 || int323 == 5) {
                                iArr5[length2] = int323;
                                length2++;
                            }
                        }
                        this.location = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(iPushLimit);
                }
            }
        }

        public static SCCdnDegradeCommandStateSignal parseFrom(byte[] bArr) {
            return (SCCdnDegradeCommandStateSignal) MessageNano.mergeFrom(new SCCdnDegradeCommandStateSignal(), bArr);
        }

        public static SCCdnDegradeCommandStateSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCCdnDegradeCommandStateSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
