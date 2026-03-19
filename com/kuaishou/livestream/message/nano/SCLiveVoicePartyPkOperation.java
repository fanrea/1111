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
public final class SCLiveVoicePartyPkOperation extends MessageNano {
    private static volatile SCLiveVoicePartyPkOperation[] _emptyArray;
    public long authorId;
    public boolean enableVideoPk;
    public long inviteEndTime;
    public UserInfos.UserInfo invitee;
    public String opVoicePartyId;
    public int operationResult;
    public int operationRole;
    public int operationType;
    public String pkId;
    public long queryIntervalMillis;
    public long time;
    public long userId;
    public String voicePartyId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveVoicePartyPkOperationResult {
        public static final int FAIL = 2;
        public static final int SUCCESS = 1;
        public static final int UNKNOWN_OPERATION_RESULT = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveVoicePartyPkOperationRole {
        public static final int ASSISTANT = 2;
        public static final int AUTHOR = 1;
        public static final int UNKNOWN_OPERATION_ROLE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveVoicePartyPkOperationType {
        public static final int ACCEPT = 2;
        public static final int CANCEL = 3;
        public static final int INVITE = 1;
        public static final int REJECT = 4;
        public static final int UNKNOWN_OPERATION_TYPE = 0;
    }

    public static SCLiveVoicePartyPkOperation[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkOperation[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkOperation() {
        clear();
    }

    public final SCLiveVoicePartyPkOperation clear() {
        this.pkId = "";
        this.time = 0L;
        this.operationType = 0;
        this.operationRole = 0;
        this.userId = 0L;
        this.authorId = 0L;
        this.voicePartyId = "";
        this.invitee = null;
        this.queryIntervalMillis = 0L;
        this.inviteEndTime = 0L;
        this.opVoicePartyId = "";
        this.enableVideoPk = false;
        this.operationResult = 0;
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
        int i = this.operationType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        int i2 = this.operationRole;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        long j2 = this.userId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.authorId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.voicePartyId);
        }
        UserInfos.UserInfo userInfo = this.invitee;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(8, userInfo);
        }
        long j4 = this.queryIntervalMillis;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j4);
        }
        long j5 = this.inviteEndTime;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j5);
        }
        if (!this.opVoicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.opVoicePartyId);
        }
        boolean z = this.enableVideoPk;
        if (z) {
            codedOutputByteBufferNano.writeBool(12, z);
        }
        int i3 = this.operationResult;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i3);
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
        int i = this.operationType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        int i2 = this.operationRole;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
        }
        long j2 = this.userId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.authorId;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        if (!this.voicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.voicePartyId);
        }
        UserInfos.UserInfo userInfo = this.invitee;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, userInfo);
        }
        long j4 = this.queryIntervalMillis;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j4);
        }
        long j5 = this.inviteEndTime;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j5);
        }
        if (!this.opVoicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.opVoicePartyId);
        }
        boolean z = this.enableVideoPk;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z);
        }
        int i3 = this.operationResult;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(13, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkOperation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.pkId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                        break;
                    } else {
                        this.operationType = int32;
                        break;
                    }
                case 32:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.operationRole = int322;
                        break;
                    }
                case 40:
                    this.userId = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.authorId = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    this.voicePartyId = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.invitee == null) {
                        this.invitee = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.invitee);
                    break;
                case 72:
                    this.queryIntervalMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    this.inviteEndTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 90:
                    this.opVoicePartyId = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.enableVideoPk = codedInputByteBufferNano.readBool();
                    break;
                case 104:
                    int int323 = codedInputByteBufferNano.readInt32();
                    if (int323 != 0 && int323 != 1 && int323 != 2) {
                        break;
                    } else {
                        this.operationResult = int323;
                        break;
                    }
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveVoicePartyPkOperation parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkOperation) MessageNano.mergeFrom(new SCLiveVoicePartyPkOperation(), bArr);
    }

    public static SCLiveVoicePartyPkOperation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkOperation().mergeFrom(codedInputByteBufferNano);
    }
}
