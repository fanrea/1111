package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatUserLeaveInfo extends MessageNano {
    private static volatile SCInteractiveChatUserLeaveInfo[] _emptyArray;
    public InteractiveChatBizIdentity bizIdentity;
    public String extraInfo;
    public long leaveInfoVersion;
    public int leaveReason;
    public InteractiveChatRoomInfo roomInfo;
    public long timestamp;
    public InteractiveChatUserInfoIdentity[] userInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LeaveReason {
        public static final int APPLY_CANCEL = 6;
        public static final int ARYA_STOP = 5;
        public static final int CALL_CANCEL = 3;
        public static final int CLEAN_UP = 2;
        public static final int FORCE_LEAVE = 1;
        public static final int INITIATIVE_LEAVE = 4;
        public static final int INVITEE_REJECT = 7;
        public static final int UNKNOWN = 0;
    }

    public static SCInteractiveChatUserLeaveInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatUserLeaveInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatUserLeaveInfo() {
        clear();
    }

    public final SCInteractiveChatUserLeaveInfo clear() {
        this.bizIdentity = null;
        this.userInfo = InteractiveChatUserInfoIdentity.emptyArray();
        this.leaveReason = 0;
        this.extraInfo = "";
        this.timestamp = 0L;
        this.roomInfo = null;
        this.leaveInfoVersion = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.userInfo;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.userInfo;
                if (i >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = interactiveChatUserInfoIdentityArr2[i];
                if (interactiveChatUserInfoIdentity != null) {
                    codedOutputByteBufferNano.writeMessage(2, interactiveChatUserInfoIdentity);
                }
                i++;
            }
        }
        int i2 = this.leaveReason;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        InteractiveChatRoomInfo interactiveChatRoomInfo = this.roomInfo;
        if (interactiveChatRoomInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, interactiveChatRoomInfo);
        }
        long j2 = this.leaveInfoVersion;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatBizIdentity);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.userInfo;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.userInfo;
                if (i >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = interactiveChatUserInfoIdentityArr2[i];
                if (interactiveChatUserInfoIdentity != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatUserInfoIdentity);
                }
                i++;
            }
        }
        int i2 = this.leaveReason;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        InteractiveChatRoomInfo interactiveChatRoomInfo = this.roomInfo;
        if (interactiveChatRoomInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, interactiveChatRoomInfo);
        }
        long j2 = this.leaveInfoVersion;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatUserLeaveInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.bizIdentity == null) {
                    this.bizIdentity = new InteractiveChatBizIdentity();
                }
                codedInputByteBufferNano.readMessage(this.bizIdentity);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.userInfo;
                int length = interactiveChatUserInfoIdentityArr == null ? 0 : interactiveChatUserInfoIdentityArr.length;
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = new InteractiveChatUserInfoIdentity[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userInfo, 0, interactiveChatUserInfoIdentityArr2, 0, length);
                }
                while (length < interactiveChatUserInfoIdentityArr2.length - 1) {
                    interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                    codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                this.userInfo = interactiveChatUserInfoIdentityArr2;
            } else if (tag == 24) {
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
                        this.leaveReason = int32;
                        break;
                }
            } else if (tag == 34) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                if (this.roomInfo == null) {
                    this.roomInfo = new InteractiveChatRoomInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomInfo);
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.leaveInfoVersion = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCInteractiveChatUserLeaveInfo parseFrom(byte[] bArr) {
        return (SCInteractiveChatUserLeaveInfo) MessageNano.mergeFrom(new SCInteractiveChatUserLeaveInfo(), bArr);
    }

    public static SCInteractiveChatUserLeaveInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatUserLeaveInfo().mergeFrom(codedInputByteBufferNano);
    }
}
