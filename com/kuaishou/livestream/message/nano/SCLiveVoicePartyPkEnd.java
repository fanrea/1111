package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPkEnd extends MessageNano {
    private static volatile SCLiveVoicePartyPkEnd[] _emptyArray;
    public long endByAuthorId;
    public int endType;
    public LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfo;
    public int micSeatsVersion;
    public long operatorId;
    public String pkId;
    public long time;
    public String voicePartyId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveVoicePartyPkEndType {
        public static final int AUTHOR_END_PENALTY = 3;
        public static final int AUTHOR_END_VOTE = 2;
        public static final int CANCEL_INVITE_END = 8;
        public static final int LIVESTREAM_END = 4;
        public static final int NORMAL_END = 1;
        public static final int REJECTED_END = 7;
        public static final int REJECTED_MODE_NOT_SUPPORT = 9;
        public static final int TIMEOUT_NOT_ACCEPT = 6;
        public static final int TIMEOUT_NOT_READY = 5;
        public static final int UNKNOWN_VOICE_PARTY_PK_END_TYPE = 0;
    }

    public static SCLiveVoicePartyPkEnd[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkEnd[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkEnd() {
        clear();
    }

    public final SCLiveVoicePartyPkEnd clear() {
        this.pkId = "";
        this.time = 0L;
        this.endType = 0;
        this.endByAuthorId = 0L;
        this.micSeatDetailInfo = LiveStreamMessages.MicSeatDetailInfo.emptyArray();
        this.micSeatsVersion = 0;
        this.voicePartyId = "";
        this.operatorId = 0L;
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
        int i = this.endType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        long j2 = this.endByAuthorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
        if (micSeatDetailInfoArr != null && micSeatDetailInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = this.micSeatDetailInfo;
                if (i2 >= micSeatDetailInfoArr2.length) {
                    break;
                }
                LiveStreamMessages.MicSeatDetailInfo micSeatDetailInfo = micSeatDetailInfoArr2[i2];
                if (micSeatDetailInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, micSeatDetailInfo);
                }
                i2++;
            }
        }
        int i3 = this.micSeatsVersion;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.voicePartyId);
        }
        long j3 = this.operatorId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
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
        int i = this.endType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        long j2 = this.endByAuthorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
        if (micSeatDetailInfoArr != null && micSeatDetailInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = this.micSeatDetailInfo;
                if (i2 >= micSeatDetailInfoArr2.length) {
                    break;
                }
                LiveStreamMessages.MicSeatDetailInfo micSeatDetailInfo = micSeatDetailInfoArr2[i2];
                if (micSeatDetailInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, micSeatDetailInfo);
                }
                i2++;
            }
        }
        int i3 = this.micSeatsVersion;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.voicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.voicePartyId);
        }
        long j3 = this.operatorId;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.time = codedInputByteBufferNano.readUInt64();
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
                    case 8:
                    case 9:
                        this.endType = int32;
                        break;
                }
            } else if (tag == 40) {
                this.endByAuthorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
                int length = micSeatDetailInfoArr == null ? 0 : micSeatDetailInfoArr.length;
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = new LiveStreamMessages.MicSeatDetailInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.micSeatDetailInfo, 0, micSeatDetailInfoArr2, 0, length);
                }
                while (length < micSeatDetailInfoArr2.length - 1) {
                    micSeatDetailInfoArr2[length] = new LiveStreamMessages.MicSeatDetailInfo();
                    codedInputByteBufferNano.readMessage(micSeatDetailInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                micSeatDetailInfoArr2[length] = new LiveStreamMessages.MicSeatDetailInfo();
                codedInputByteBufferNano.readMessage(micSeatDetailInfoArr2[length]);
                this.micSeatDetailInfo = micSeatDetailInfoArr2;
            } else if (tag == 56) {
                this.micSeatsVersion = codedInputByteBufferNano.readUInt32();
            } else if (tag == 66) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag != 72) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.operatorId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveVoicePartyPkEnd parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkEnd) MessageNano.mergeFrom(new SCLiveVoicePartyPkEnd(), bArr);
    }

    public static SCLiveVoicePartyPkEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkEnd().mergeFrom(codedInputByteBufferNano);
    }
}
