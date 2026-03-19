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
public final class SCLiveVoicePartyPkInvitation extends MessageNano {
    private static volatile SCLiveVoicePartyPkInvitation[] _emptyArray;
    public int invitationSource;
    public long inviteEndTime;
    public UserInfos.UserInfo inviter;
    public String pkId;
    public long queryIntervalMillis;
    public long time;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveVoicePartyPkInvitationSource {
        public static final int FRIEND = 1;
        public static final int RECO_USER = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveVoicePartyPkInvitation[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkInvitation[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkInvitation() {
        clear();
    }

    public final SCLiveVoicePartyPkInvitation clear() {
        this.pkId = "";
        this.time = 0L;
        this.inviter = null;
        this.queryIntervalMillis = 0L;
        this.inviteEndTime = 0L;
        this.invitationSource = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        UserInfos.UserInfo userInfo = this.inviter;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo);
        }
        long j2 = this.queryIntervalMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        long j3 = this.inviteEndTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        int i = this.invitationSource;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        UserInfos.UserInfo userInfo = this.inviter;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
        }
        long j2 = this.queryIntervalMillis;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        long j3 = this.inviteEndTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        int i = this.invitationSource;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkInvitation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                if (this.inviter == null) {
                    this.inviter = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.inviter);
            } else if (tag == 32) {
                this.queryIntervalMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.inviteEndTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.invitationSource = int32;
                }
            }
        }
    }

    public static SCLiveVoicePartyPkInvitation parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkInvitation) MessageNano.mergeFrom(new SCLiveVoicePartyPkInvitation(), bArr);
    }

    public static SCLiveVoicePartyPkInvitation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkInvitation().mergeFrom(codedInputByteBufferNano);
    }
}
