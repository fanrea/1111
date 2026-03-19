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
public final class SCMicSeatsVideoOpenInvitation extends MessageNano {
    private static volatile SCMicSeatsVideoOpenInvitation[] _emptyArray;
    public int friendshipType;
    public long guestId;
    public UserInfos.UserInfo inviter;
    public String liveStreamId;
    public String voicePartyId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FriendshipType {
        public static final int AUDIENCE = 3;
        public static final int FANS = 1;
        public static final int FRIEND = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCMicSeatsVideoOpenInvitation[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMicSeatsVideoOpenInvitation[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMicSeatsVideoOpenInvitation() {
        clear();
    }

    public final SCMicSeatsVideoOpenInvitation clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.guestId = 0L;
        this.inviter = null;
        this.friendshipType = 0;
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
        long j = this.guestId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        UserInfos.UserInfo userInfo = this.inviter;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo);
        }
        int i = this.friendshipType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
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
        long j = this.guestId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        UserInfos.UserInfo userInfo = this.inviter;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
        }
        int i = this.friendshipType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMicSeatsVideoOpenInvitation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.guestId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                if (this.inviter == null) {
                    this.inviter = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.inviter);
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.friendshipType = int32;
                }
            }
        }
    }

    public static SCMicSeatsVideoOpenInvitation parseFrom(byte[] bArr) {
        return (SCMicSeatsVideoOpenInvitation) MessageNano.mergeFrom(new SCMicSeatsVideoOpenInvitation(), bArr);
    }

    public static SCMicSeatsVideoOpenInvitation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMicSeatsVideoOpenInvitation().mergeFrom(codedInputByteBufferNano);
    }
}
