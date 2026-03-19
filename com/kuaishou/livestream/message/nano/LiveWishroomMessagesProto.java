package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveWishroomMessagesProto {

    public static final class SCLiveWishroomBulletCommentPushInfos extends MessageNano {
        private static volatile SCLiveWishroomBulletCommentPushInfos[] _emptyArray;
        public LiveWishroomBulletCommentPushInfo[] bulletCommentPushInfo;

        public static SCLiveWishroomBulletCommentPushInfos[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveWishroomBulletCommentPushInfos[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveWishroomBulletCommentPushInfos() {
            clear();
        }

        public final SCLiveWishroomBulletCommentPushInfos clear() {
            this.bulletCommentPushInfo = LiveWishroomBulletCommentPushInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveWishroomBulletCommentPushInfo[] liveWishroomBulletCommentPushInfoArr = this.bulletCommentPushInfo;
            if (liveWishroomBulletCommentPushInfoArr != null && liveWishroomBulletCommentPushInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveWishroomBulletCommentPushInfo[] liveWishroomBulletCommentPushInfoArr2 = this.bulletCommentPushInfo;
                    if (i >= liveWishroomBulletCommentPushInfoArr2.length) {
                        break;
                    }
                    LiveWishroomBulletCommentPushInfo liveWishroomBulletCommentPushInfo = liveWishroomBulletCommentPushInfoArr2[i];
                    if (liveWishroomBulletCommentPushInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveWishroomBulletCommentPushInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveWishroomBulletCommentPushInfo[] liveWishroomBulletCommentPushInfoArr = this.bulletCommentPushInfo;
            if (liveWishroomBulletCommentPushInfoArr != null && liveWishroomBulletCommentPushInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveWishroomBulletCommentPushInfo[] liveWishroomBulletCommentPushInfoArr2 = this.bulletCommentPushInfo;
                    if (i >= liveWishroomBulletCommentPushInfoArr2.length) {
                        break;
                    }
                    LiveWishroomBulletCommentPushInfo liveWishroomBulletCommentPushInfo = liveWishroomBulletCommentPushInfoArr2[i];
                    if (liveWishroomBulletCommentPushInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveWishroomBulletCommentPushInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveWishroomBulletCommentPushInfos mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveWishroomBulletCommentPushInfo[] liveWishroomBulletCommentPushInfoArr = this.bulletCommentPushInfo;
                    int length = liveWishroomBulletCommentPushInfoArr == null ? 0 : liveWishroomBulletCommentPushInfoArr.length;
                    LiveWishroomBulletCommentPushInfo[] liveWishroomBulletCommentPushInfoArr2 = new LiveWishroomBulletCommentPushInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.bulletCommentPushInfo, 0, liveWishroomBulletCommentPushInfoArr2, 0, length);
                    }
                    while (length < liveWishroomBulletCommentPushInfoArr2.length - 1) {
                        liveWishroomBulletCommentPushInfoArr2[length] = new LiveWishroomBulletCommentPushInfo();
                        codedInputByteBufferNano.readMessage(liveWishroomBulletCommentPushInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveWishroomBulletCommentPushInfoArr2[length] = new LiveWishroomBulletCommentPushInfo();
                    codedInputByteBufferNano.readMessage(liveWishroomBulletCommentPushInfoArr2[length]);
                    this.bulletCommentPushInfo = liveWishroomBulletCommentPushInfoArr2;
                }
            }
        }

        public static SCLiveWishroomBulletCommentPushInfos parseFrom(byte[] bArr) {
            return (SCLiveWishroomBulletCommentPushInfos) MessageNano.mergeFrom(new SCLiveWishroomBulletCommentPushInfos(), bArr);
        }

        public static SCLiveWishroomBulletCommentPushInfos parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveWishroomBulletCommentPushInfos().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveWishCountUpdate extends MessageNano {
        private static volatile SCLiveWishCountUpdate[] _emptyArray;
        public String propTypeWishCountMap;
        public long wishTotalCount;

        public static SCLiveWishCountUpdate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveWishCountUpdate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveWishCountUpdate() {
            clear();
        }

        public final SCLiveWishCountUpdate clear() {
            this.wishTotalCount = 0L;
            this.propTypeWishCountMap = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.wishTotalCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.propTypeWishCountMap.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.propTypeWishCountMap);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.wishTotalCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            return !this.propTypeWishCountMap.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.propTypeWishCountMap) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveWishCountUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.wishTotalCount = codedInputByteBufferNano.readUInt64();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.propTypeWishCountMap = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveWishCountUpdate parseFrom(byte[] bArr) {
            return (SCLiveWishCountUpdate) MessageNano.mergeFrom(new SCLiveWishCountUpdate(), bArr);
        }

        public static SCLiveWishCountUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveWishCountUpdate().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveWishroomBulletCommentPushInfo extends MessageNano {
        private static volatile LiveWishroomBulletCommentPushInfo[] _emptyArray;
        public String background;
        public String backgroundDecorationIcon;
        public String content;
        public long likeCount;
        public String likeDisplayCount;
        public String liveStreamId;
        public LiveWishLocation location;
        public boolean manualInput;
        public int propType;
        public String tag;
        public int tagOrder;
        public int tagType;
        public UserInfos.UserInfo userInfo;
        public int visibleStatus;
        public String wishId;
        public long wishNo;

        public static LiveWishroomBulletCommentPushInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveWishroomBulletCommentPushInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveWishroomBulletCommentPushInfo() {
            clear();
        }

        public final LiveWishroomBulletCommentPushInfo clear() {
            this.wishId = "";
            this.userInfo = null;
            this.tag = "";
            this.tagOrder = 0;
            this.tagType = 0;
            this.content = "";
            this.likeCount = 0L;
            this.likeDisplayCount = "";
            this.background = "";
            this.backgroundDecorationIcon = "";
            this.location = null;
            this.manualInput = false;
            this.wishNo = 0L;
            this.visibleStatus = 0;
            this.liveStreamId = "";
            this.propType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.wishId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.wishId);
            }
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, userInfo);
            }
            if (!this.tag.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.tag);
            }
            int i = this.tagOrder;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            int i2 = this.tagType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.content);
            }
            long j = this.likeCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j);
            }
            if (!this.likeDisplayCount.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.likeDisplayCount);
            }
            if (!this.background.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.background);
            }
            if (!this.backgroundDecorationIcon.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.backgroundDecorationIcon);
            }
            LiveWishLocation liveWishLocation = this.location;
            if (liveWishLocation != null) {
                codedOutputByteBufferNano.writeMessage(11, liveWishLocation);
            }
            boolean z = this.manualInput;
            if (z) {
                codedOutputByteBufferNano.writeBool(12, z);
            }
            long j2 = this.wishNo;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j2);
            }
            int i3 = this.visibleStatus;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(14, i3);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.liveStreamId);
            }
            int i4 = this.propType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(16, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.wishId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.wishId);
            }
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
            }
            if (!this.tag.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.tag);
            }
            int i = this.tagOrder;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            int i2 = this.tagType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
            }
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.content);
            }
            long j = this.likeCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j);
            }
            if (!this.likeDisplayCount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.likeDisplayCount);
            }
            if (!this.background.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.background);
            }
            if (!this.backgroundDecorationIcon.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.backgroundDecorationIcon);
            }
            LiveWishLocation liveWishLocation = this.location;
            if (liveWishLocation != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, liveWishLocation);
            }
            boolean z = this.manualInput;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z);
            }
            long j2 = this.wishNo;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j2);
            }
            int i3 = this.visibleStatus;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i3);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.liveStreamId);
            }
            int i4 = this.propType;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(16, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveWishroomBulletCommentPushInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.wishId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        if (this.userInfo == null) {
                            this.userInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.userInfo);
                        break;
                    case 26:
                        this.tag = codedInputByteBufferNano.readString();
                        break;
                    case 32:
                        this.tagOrder = codedInputByteBufferNano.readUInt32();
                        break;
                    case 40:
                        this.tagType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 50:
                        this.content = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.likeCount = codedInputByteBufferNano.readUInt64();
                        break;
                    case 66:
                        this.likeDisplayCount = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.background = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.backgroundDecorationIcon = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        if (this.location == null) {
                            this.location = new LiveWishLocation();
                        }
                        codedInputByteBufferNano.readMessage(this.location);
                        break;
                    case 96:
                        this.manualInput = codedInputByteBufferNano.readBool();
                        break;
                    case 104:
                        this.wishNo = codedInputByteBufferNano.readUInt64();
                        break;
                    case 112:
                        this.visibleStatus = codedInputByteBufferNano.readUInt32();
                        break;
                    case 122:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 128:
                        this.propType = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveWishroomBulletCommentPushInfo parseFrom(byte[] bArr) {
            return (LiveWishroomBulletCommentPushInfo) MessageNano.mergeFrom(new LiveWishroomBulletCommentPushInfo(), bArr);
        }

        public static LiveWishroomBulletCommentPushInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveWishroomBulletCommentPushInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveWishLocation extends MessageNano {
        private static volatile LiveWishLocation[] _emptyArray;
        public String city;
        public double latitude;
        public double longitude;
        public String province;
        public String subLocality;

        public static LiveWishLocation[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveWishLocation[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveWishLocation() {
            clear();
        }

        public final LiveWishLocation clear() {
            this.latitude = 0.0d;
            this.longitude = 0.0d;
            this.province = "";
            this.city = "";
            this.subLocality = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(1, this.latitude);
            }
            if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(2, this.longitude);
            }
            if (!this.province.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.province);
            }
            if (!this.city.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.city);
            }
            if (!this.subLocality.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.subLocality);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(0.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.latitude);
            }
            if (Double.doubleToLongBits(this.longitude) != Double.doubleToLongBits(0.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.longitude);
            }
            if (!this.province.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.province);
            }
            if (!this.city.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.city);
            }
            return !this.subLocality.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.subLocality) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveWishLocation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 9) {
                    this.latitude = codedInputByteBufferNano.readDouble();
                } else if (tag == 17) {
                    this.longitude = codedInputByteBufferNano.readDouble();
                } else if (tag == 26) {
                    this.province = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.city = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.subLocality = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveWishLocation parseFrom(byte[] bArr) {
            return (LiveWishLocation) MessageNano.mergeFrom(new LiveWishLocation(), bArr);
        }

        public static LiveWishLocation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveWishLocation().mergeFrom(codedInputByteBufferNano);
        }
    }
}
