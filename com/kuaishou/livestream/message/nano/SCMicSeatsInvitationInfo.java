package com.kuaishou.livestream.message.nano;

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
public final class SCMicSeatsInvitationInfo extends MessageNano {
    private static volatile SCMicSeatsInvitationInfo[] _emptyArray;
    public String aryaConfig;
    public String deviceId;
    public int friendshipType;
    public long guestUserId;
    public int invitationType;
    public UserInfos.UserInfo inviter;
    public String[] inviterTag;
    public String liveStreamId;
    public int micSeatId;
    public String token;
    public String voicePartyId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FriendshipType {
        public static final int AUDIENCE = 3;
        public static final int FANS = 1;
        public static final int FRIEND = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCMicSeatsInvitationInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMicSeatsInvitationInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMicSeatsInvitationInfo() {
        clear();
    }

    public final SCMicSeatsInvitationInfo clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.guestUserId = 0L;
        this.aryaConfig = "";
        this.invitationType = 0;
        this.token = "";
        this.friendshipType = 0;
        this.micSeatId = 0;
        this.inviter = null;
        this.inviterTag = WireFormatNano.EMPTY_STRING_ARRAY;
        this.deviceId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.voicePartyId);
        }
        long j = this.guestUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.aryaConfig.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.aryaConfig);
        }
        int i = this.invitationType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        if (!this.token.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.token);
        }
        int i2 = this.friendshipType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i2);
        }
        int i3 = this.micSeatId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        UserInfos.UserInfo userInfo = this.inviter;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(9, userInfo);
        }
        String[] strArr = this.inviterTag;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.inviterTag;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(10, str);
                }
                i4++;
            }
        }
        if (!this.deviceId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.deviceId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
        }
        long j = this.guestUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.aryaConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.aryaConfig);
        }
        int i = this.invitationType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        if (!this.token.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.token);
        }
        int i2 = this.friendshipType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i2);
        }
        int i3 = this.micSeatId;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        UserInfos.UserInfo userInfo = this.inviter;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, userInfo);
        }
        String[] strArr = this.inviterTag;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int iComputeStringSizeNoTag = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.inviterTag;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i4];
                if (str != null) {
                    i5++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i5 * 1);
        }
        return !this.deviceId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.deviceId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMicSeatsInvitationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.voicePartyId = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.guestUserId = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.aryaConfig = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.invitationType = int32;
                        break;
                    }
                    break;
                case 50:
                    this.token = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3) {
                        break;
                    } else {
                        this.friendshipType = int322;
                        break;
                    }
                case 64:
                    this.micSeatId = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    if (this.inviter == null) {
                        this.inviter = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.inviter);
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    String[] strArr = this.inviterTag;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.inviterTag, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.inviterTag = strArr2;
                    break;
                case 90:
                    this.deviceId = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCMicSeatsInvitationInfo parseFrom(byte[] bArr) {
        return (SCMicSeatsInvitationInfo) MessageNano.mergeFrom(new SCMicSeatsInvitationInfo(), bArr);
    }

    public static SCMicSeatsInvitationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMicSeatsInvitationInfo().mergeFrom(codedInputByteBufferNano);
    }
}
