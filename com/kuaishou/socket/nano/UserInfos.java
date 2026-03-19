package com.kuaishou.socket.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface UserInfos {

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppType {
        public static final int ANDROID_ANTMAN = 31;
        public static final int ANDROID_CN = 21;
        public static final int ANDROID_GAMEZONE = 30;
        public static final int ANDROID_NEBULA = 22;
        public static final int ANDROID_NEBULA_ANTMAN = 34;
        public static final int ANDROID_SLIDE = 28;
        public static final int ANDROID_THANOS = 29;
        public static final int IOS = 1;
        public static final int IOS_NEBULA = 2;
        public static final int IOS_SLIDE = 8;
        public static final int IOS_THANOS = 9;
        public static final int UNKNOWN_APP_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientId {
        public static final int ANDROID = 2;
        public static final int ANDROID_LIVE_MATE = 9;
        public static final int ANDROID_OPEN_LIVE_SDK = 22;
        public static final int IPHONE = 1;
        public static final int IPHONE_LIVE_MATE = 8;
        public static final int IPHONE_OPEN_LIVE_SDK = 23;
        public static final int NONE = 0;
        public static final int PC = 6;
        public static final int WEB = 3;
        public static final int WECHAT_SMALL_APP = 13;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RoleType {
        public static final int MYSTERY_MAN = 1;
        public static final int UNKNOWN_ROLE = 0;
    }

    public static final class PicUrl extends MessageNano {
        private static volatile PicUrl[] _emptyArray;
        public String cdn;
        public String ip;
        public String url;
        public String urlPattern;

        public static PicUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PicUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PicUrl() {
            clear();
        }

        public final PicUrl clear() {
            this.cdn = "";
            this.url = "";
            this.urlPattern = "";
            this.ip = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.cdn.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.cdn);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            if (!this.urlPattern.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.urlPattern);
            }
            if (!this.ip.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.ip);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.cdn.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
            }
            if (!this.url.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
            }
            if (!this.urlPattern.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.urlPattern);
            }
            return !this.ip.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.ip) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PicUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.cdn = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.url = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.urlPattern = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.ip = codedInputByteBufferNano.readString();
                }
            }
        }

        public static PicUrl parseFrom(byte[] bArr) {
            return (PicUrl) MessageNano.mergeFrom(new PicUrl(), bArr);
        }

        public static PicUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PicUrl().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UserInfo extends MessageNano {
        private static volatile UserInfo[] _emptyArray;
        public String eUid;
        public String encryptUid;
        public EncryptedInfo encryptedInfo;
        public PicUrl[] headUrls;
        public PicUrl[] httpsHeadUrls;
        public String kwaiId;
        public RoleInfo[] roleInfos;
        public String sUserId;
        public String userGender;
        public long userId;
        public String userName;
        public String userText;
        public boolean verified;

        public static UserInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UserInfo() {
            clear();
        }

        public final UserInfo clear() {
            this.userId = 0L;
            this.userName = "";
            this.userGender = "";
            this.userText = "";
            this.headUrls = PicUrl.emptyArray();
            this.verified = false;
            this.sUserId = "";
            this.httpsHeadUrls = PicUrl.emptyArray();
            this.kwaiId = "";
            this.eUid = "";
            this.roleInfos = RoleInfo.emptyArray();
            this.encryptUid = "";
            this.encryptedInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.userName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.userName);
            }
            if (!this.userGender.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.userGender);
            }
            if (!this.userText.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.userText);
            }
            PicUrl[] picUrlArr = this.headUrls;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    PicUrl[] picUrlArr2 = this.headUrls;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl);
                    }
                    i2++;
                }
            }
            boolean z = this.verified;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            if (!this.sUserId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.sUserId);
            }
            PicUrl[] picUrlArr3 = this.httpsHeadUrls;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    PicUrl[] picUrlArr4 = this.httpsHeadUrls;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(8, picUrl2);
                    }
                    i3++;
                }
            }
            if (!this.kwaiId.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.kwaiId);
            }
            if (!this.eUid.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.eUid);
            }
            RoleInfo[] roleInfoArr = this.roleInfos;
            if (roleInfoArr != null && roleInfoArr.length > 0) {
                while (true) {
                    RoleInfo[] roleInfoArr2 = this.roleInfos;
                    if (i >= roleInfoArr2.length) {
                        break;
                    }
                    RoleInfo roleInfo = roleInfoArr2[i];
                    if (roleInfo != null) {
                        codedOutputByteBufferNano.writeMessage(11, roleInfo);
                    }
                    i++;
                }
            }
            if (!this.encryptUid.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.encryptUid);
            }
            EncryptedInfo encryptedInfo = this.encryptedInfo;
            if (encryptedInfo != null) {
                codedOutputByteBufferNano.writeMessage(13, encryptedInfo);
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
            if (!this.userName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.userName);
            }
            if (!this.userGender.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.userGender);
            }
            if (!this.userText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.userText);
            }
            PicUrl[] picUrlArr = this.headUrls;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    PicUrl[] picUrlArr2 = this.headUrls;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            boolean z = this.verified;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
            }
            if (!this.sUserId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.sUserId);
            }
            PicUrl[] picUrlArr3 = this.httpsHeadUrls;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    PicUrl[] picUrlArr4 = this.httpsHeadUrls;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(8, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            if (!this.kwaiId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.kwaiId);
            }
            if (!this.eUid.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.eUid);
            }
            RoleInfo[] roleInfoArr = this.roleInfos;
            if (roleInfoArr != null && roleInfoArr.length > 0) {
                while (true) {
                    RoleInfo[] roleInfoArr2 = this.roleInfos;
                    if (i >= roleInfoArr2.length) {
                        break;
                    }
                    RoleInfo roleInfo = roleInfoArr2[i];
                    if (roleInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, roleInfo);
                    }
                    i++;
                }
            }
            if (!this.encryptUid.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.encryptUid);
            }
            EncryptedInfo encryptedInfo = this.encryptedInfo;
            return encryptedInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(13, encryptedInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.userId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 18:
                        this.userName = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.userGender = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.userText = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        PicUrl[] picUrlArr = this.headUrls;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        PicUrl[] picUrlArr2 = new PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.headUrls, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.headUrls = picUrlArr2;
                        break;
                    case 48:
                        this.verified = codedInputByteBufferNano.readBool();
                        break;
                    case 58:
                        this.sUserId = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        PicUrl[] picUrlArr3 = this.httpsHeadUrls;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        PicUrl[] picUrlArr4 = new PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.httpsHeadUrls, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.httpsHeadUrls = picUrlArr4;
                        break;
                    case 74:
                        this.kwaiId = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.eUid = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        RoleInfo[] roleInfoArr = this.roleInfos;
                        int length3 = roleInfoArr == null ? 0 : roleInfoArr.length;
                        RoleInfo[] roleInfoArr2 = new RoleInfo[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.roleInfos, 0, roleInfoArr2, 0, length3);
                        }
                        while (length3 < roleInfoArr2.length - 1) {
                            roleInfoArr2[length3] = new RoleInfo();
                            codedInputByteBufferNano.readMessage(roleInfoArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        roleInfoArr2[length3] = new RoleInfo();
                        codedInputByteBufferNano.readMessage(roleInfoArr2[length3]);
                        this.roleInfos = roleInfoArr2;
                        break;
                    case 98:
                        this.encryptUid = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        if (this.encryptedInfo == null) {
                            this.encryptedInfo = new EncryptedInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.encryptedInfo);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static UserInfo parseFrom(byte[] bArr) {
            return (UserInfo) MessageNano.mergeFrom(new UserInfo(), bArr);
        }

        public static UserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UserInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class EncryptedInfo extends MessageNano {
        private static volatile EncryptedInfo[] _emptyArray;
        public String encryptedUserId;
        public String encryptedUserName;

        public static EncryptedInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EncryptedInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EncryptedInfo() {
            clear();
        }

        public final EncryptedInfo clear() {
            this.encryptedUserName = "";
            this.encryptedUserId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.encryptedUserName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.encryptedUserName);
            }
            if (!this.encryptedUserId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.encryptedUserId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.encryptedUserName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.encryptedUserName);
            }
            return !this.encryptedUserId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.encryptedUserId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final EncryptedInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.encryptedUserName = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.encryptedUserId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static EncryptedInfo parseFrom(byte[] bArr) {
            return (EncryptedInfo) MessageNano.mergeFrom(new EncryptedInfo(), bArr);
        }

        public static EncryptedInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new EncryptedInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RoleInfo extends MessageNano {
        private static volatile RoleInfo[] _emptyArray;
        public int roleType;

        public static RoleInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RoleInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RoleInfo() {
            clear();
        }

        public final RoleInfo clear() {
            this.roleType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.roleType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.roleType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RoleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.roleType = int32;
                    }
                }
            }
        }

        public static RoleInfo parseFrom(byte[] bArr) {
            return (RoleInfo) MessageNano.mergeFrom(new RoleInfo(), bArr);
        }

        public static RoleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RoleInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
