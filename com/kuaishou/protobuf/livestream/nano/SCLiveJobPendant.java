package com.kuaishou.protobuf.livestream.nano;

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
public final class SCLiveJobPendant extends MessageNano {
    private static volatile SCLiveJobPendant[] _emptyArray;
    public long activityId;
    public LiveJobPendantAnimateIconInfo animateIconInfo;
    public long autoEndTime;
    public String[] barBackgroundColors;
    public long barCountdownTime;
    public String barText;
    public String barTextColor;
    public int barType;
    public String clickUrl;
    public UserInfos.PicUrl[] icon;
    public UserInfos.PicUrl[] iconV2;
    public boolean isClose;
    public long[] planIds;
    public int status;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveJobBarType {
        public static final int COUNTDOWN = 2;
        public static final int STATIC = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveJobPendant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveJobPendant[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveJobPendant() {
        clear();
    }

    public final SCLiveJobPendant clear() {
        this.icon = UserInfos.PicUrl.emptyArray();
        this.clickUrl = "";
        this.barBackgroundColors = WireFormatNano.EMPTY_STRING_ARRAY;
        this.barType = 0;
        this.barText = "";
        this.barCountdownTime = 0L;
        this.barTextColor = "";
        this.autoEndTime = 0L;
        this.isClose = false;
        this.status = 0;
        this.activityId = 0L;
        this.iconV2 = UserInfos.PicUrl.emptyArray();
        this.animateIconInfo = null;
        this.planIds = WireFormatNano.EMPTY_LONG_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(1, picUrl);
                }
                i2++;
            }
        }
        if (!this.clickUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.clickUrl);
        }
        String[] strArr = this.barBackgroundColors;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.barBackgroundColors;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i3++;
            }
        }
        int i4 = this.barType;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i4);
        }
        if (!this.barText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.barText);
        }
        long j = this.barCountdownTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        if (!this.barTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.barTextColor);
        }
        long j2 = this.autoEndTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        boolean z = this.isClose;
        if (z) {
            codedOutputByteBufferNano.writeBool(9, z);
        }
        int i5 = this.status;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i5);
        }
        long j3 = this.activityId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j3);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.iconV2;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.iconV2;
                if (i6 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i6];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(12, picUrl2);
                }
                i6++;
            }
        }
        LiveJobPendantAnimateIconInfo liveJobPendantAnimateIconInfo = this.animateIconInfo;
        if (liveJobPendantAnimateIconInfo != null) {
            codedOutputByteBufferNano.writeMessage(13, liveJobPendantAnimateIconInfo);
        }
        long[] jArr = this.planIds;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.planIds;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(14, jArr2[i]);
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.clickUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.clickUrl);
        }
        String[] strArr = this.barBackgroundColors;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.barBackgroundColors;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
        }
        int i5 = this.barType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i5);
        }
        if (!this.barText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.barText);
        }
        long j = this.barCountdownTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        if (!this.barTextColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.barTextColor);
        }
        long j2 = this.autoEndTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        boolean z = this.isClose;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
        }
        int i6 = this.status;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i6);
        }
        long j3 = this.activityId;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j3);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.iconV2;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i7 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.iconV2;
                if (i7 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i7];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(12, picUrl2);
                }
                i7++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        LiveJobPendantAnimateIconInfo liveJobPendantAnimateIconInfo = this.animateIconInfo;
        if (liveJobPendantAnimateIconInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, liveJobPendantAnimateIconInfo);
        }
        long[] jArr = this.planIds;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeUInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.planIds;
            if (i < jArr2.length) {
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i]);
                i++;
            } else {
                return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveJobPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.icon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.icon = picUrlArr2;
                    break;
                case 18:
                    this.clickUrl = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.barBackgroundColors;
                    int length2 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.barBackgroundColors, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    this.barBackgroundColors = strArr2;
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.barType = int32;
                        break;
                    }
                    break;
                case 42:
                    this.barText = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.barCountdownTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    this.barTextColor = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.autoEndTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.isClose = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.status = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.activityId = codedInputByteBufferNano.readUInt64();
                    break;
                case 98:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    UserInfos.PicUrl[] picUrlArr3 = this.iconV2;
                    int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.iconV2, 0, picUrlArr4, 0, length3);
                    }
                    while (length3 < picUrlArr4.length - 1) {
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr4[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                    this.iconV2 = picUrlArr4;
                    break;
                case 106:
                    if (this.animateIconInfo == null) {
                        this.animateIconInfo = new LiveJobPendantAnimateIconInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.animateIconInfo);
                    break;
                case 112:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 112);
                    long[] jArr = this.planIds;
                    int length4 = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.planIds, 0, jArr2, 0, length4);
                    }
                    while (length4 < jArr2.length - 1) {
                        jArr2[length4] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    jArr2[length4] = codedInputByteBufferNano.readUInt64();
                    this.planIds = jArr2;
                    break;
                case 114:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.planIds;
                    int length5 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.planIds, 0, jArr4, 0, length5);
                    }
                    while (length5 < jArr4.length) {
                        jArr4[length5] = codedInputByteBufferNano.readUInt64();
                        length5++;
                    }
                    this.planIds = jArr4;
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

    public static SCLiveJobPendant parseFrom(byte[] bArr) {
        return (SCLiveJobPendant) MessageNano.mergeFrom(new SCLiveJobPendant(), bArr);
    }

    public static SCLiveJobPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveJobPendant().mergeFrom(codedInputByteBufferNano);
    }
}
