package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatCall extends MessageNano {
    private static volatile SCInteractiveChatCall[] _emptyArray;
    public boolean autoAccept;
    public InteractiveChatBizIdentity bizIdentity;
    public UserInfos.UserInfo caller;
    public InteractiveChatUserInfoIdentity callerIdentity;
    public long countdownMs;
    public InteractiveChatUserInfoIdentity[] currentUser;
    public String extraInfo;
    public boolean fromMatch;
    public InteractiveChatUserInfoIdentity[] guest;
    public Map<Long, String> inviteeId2OperationId;
    public String reservationId;
    public long timestamp;

    public static SCInteractiveChatCall[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatCall[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatCall() {
        clear();
    }

    public final SCInteractiveChatCall clear() {
        this.bizIdentity = null;
        this.caller = null;
        this.countdownMs = 0L;
        this.guest = InteractiveChatUserInfoIdentity.emptyArray();
        this.extraInfo = "";
        this.timestamp = 0L;
        this.callerIdentity = null;
        this.currentUser = InteractiveChatUserInfoIdentity.emptyArray();
        this.fromMatch = false;
        this.autoAccept = false;
        this.inviteeId2OperationId = null;
        this.reservationId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        UserInfos.UserInfo userInfo = this.caller;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        long j = this.countdownMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
        int i = 0;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i2 = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.guest;
                if (i2 >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = interactiveChatUserInfoIdentityArr2[i2];
                if (interactiveChatUserInfoIdentity != null) {
                    codedOutputByteBufferNano.writeMessage(4, interactiveChatUserInfoIdentity);
                }
                i2++;
            }
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.extraInfo);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.callerIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            codedOutputByteBufferNano.writeMessage(7, interactiveChatUserInfoIdentity2);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr3 = this.currentUser;
        if (interactiveChatUserInfoIdentityArr3 != null && interactiveChatUserInfoIdentityArr3.length > 0) {
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr4 = this.currentUser;
                if (i >= interactiveChatUserInfoIdentityArr4.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity3 = interactiveChatUserInfoIdentityArr4[i];
                if (interactiveChatUserInfoIdentity3 != null) {
                    codedOutputByteBufferNano.writeMessage(8, interactiveChatUserInfoIdentity3);
                }
                i++;
            }
        }
        boolean z = this.fromMatch;
        if (z) {
            codedOutputByteBufferNano.writeBool(9, z);
        }
        boolean z2 = this.autoAccept;
        if (z2) {
            codedOutputByteBufferNano.writeBool(10, z2);
        }
        Map<Long, String> map = this.inviteeId2OperationId;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 11, 4, 9);
        }
        if (!this.reservationId.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.reservationId);
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
        UserInfos.UserInfo userInfo = this.caller;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        long j = this.countdownMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
        int i = 0;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.guest;
                if (i2 >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = interactiveChatUserInfoIdentityArr2[i2];
                if (interactiveChatUserInfoIdentity != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, interactiveChatUserInfoIdentity);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.extraInfo);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.callerIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, interactiveChatUserInfoIdentity2);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr3 = this.currentUser;
        if (interactiveChatUserInfoIdentityArr3 != null && interactiveChatUserInfoIdentityArr3.length > 0) {
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr4 = this.currentUser;
                if (i >= interactiveChatUserInfoIdentityArr4.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity3 = interactiveChatUserInfoIdentityArr4[i];
                if (interactiveChatUserInfoIdentity3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, interactiveChatUserInfoIdentity3);
                }
                i++;
            }
        }
        boolean z = this.fromMatch;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
        }
        boolean z2 = this.autoAccept;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z2);
        }
        Map<Long, String> map = this.inviteeId2OperationId;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 11, 4, 9);
        }
        return !this.reservationId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.reservationId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatCall mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.bizIdentity == null) {
                        this.bizIdentity = new InteractiveChatBizIdentity();
                    }
                    codedInputByteBufferNano.readMessage(this.bizIdentity);
                    break;
                case 18:
                    if (this.caller == null) {
                        this.caller = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.caller);
                    break;
                case 24:
                    this.countdownMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
                    int length = interactiveChatUserInfoIdentityArr == null ? 0 : interactiveChatUserInfoIdentityArr.length;
                    InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = new InteractiveChatUserInfoIdentity[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.guest, 0, interactiveChatUserInfoIdentityArr2, 0, length);
                    }
                    while (length < interactiveChatUserInfoIdentityArr2.length - 1) {
                        interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                        codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                    codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                    this.guest = interactiveChatUserInfoIdentityArr2;
                    break;
                case 42:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    if (this.callerIdentity == null) {
                        this.callerIdentity = new InteractiveChatUserInfoIdentity();
                    }
                    codedInputByteBufferNano.readMessage(this.callerIdentity);
                    break;
                case 66:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr3 = this.currentUser;
                    int length2 = interactiveChatUserInfoIdentityArr3 == null ? 0 : interactiveChatUserInfoIdentityArr3.length;
                    InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr4 = new InteractiveChatUserInfoIdentity[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.currentUser, 0, interactiveChatUserInfoIdentityArr4, 0, length2);
                    }
                    while (length2 < interactiveChatUserInfoIdentityArr4.length - 1) {
                        interactiveChatUserInfoIdentityArr4[length2] = new InteractiveChatUserInfoIdentity();
                        codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    interactiveChatUserInfoIdentityArr4[length2] = new InteractiveChatUserInfoIdentity();
                    codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr4[length2]);
                    this.currentUser = interactiveChatUserInfoIdentityArr4;
                    break;
                case 72:
                    this.fromMatch = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.autoAccept = codedInputByteBufferNano.readBool();
                    break;
                case 90:
                    this.inviteeId2OperationId = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.inviteeId2OperationId, mapFactory, 4, 9, null, 8, 18);
                    break;
                case 98:
                    this.reservationId = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCInteractiveChatCall parseFrom(byte[] bArr) {
        return (SCInteractiveChatCall) MessageNano.mergeFrom(new SCInteractiveChatCall(), bArr);
    }

    public static SCInteractiveChatCall parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatCall().mergeFrom(codedInputByteBufferNano);
    }
}
