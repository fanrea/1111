package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCTeamPkRoomOpened extends MessageNano {
    private static volatile SCTeamPkRoomOpened[] _emptyArray;
    public boolean fromEnterRoom;
    public LiveStreamMessages.MicSeatLayoutInfo layoutInfo;
    public String liveStreamId;
    public LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfo;
    public int micSeatsVersion;
    public String pkRoomId;
    public String pkRuleUrl;
    public String voicePartyId;

    public static SCTeamPkRoomOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCTeamPkRoomOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCTeamPkRoomOpened() {
        clear();
    }

    public final SCTeamPkRoomOpened clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkRoomId = "";
        this.pkRuleUrl = "";
        this.micSeatDetailInfo = LiveStreamMessages.MicSeatDetailInfo.emptyArray();
        this.micSeatsVersion = 0;
        this.fromEnterRoom = false;
        this.layoutInfo = null;
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
        if (!this.pkRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.pkRoomId);
        }
        if (!this.pkRuleUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.pkRuleUrl);
        }
        LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
        if (micSeatDetailInfoArr != null && micSeatDetailInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = this.micSeatDetailInfo;
                if (i >= micSeatDetailInfoArr2.length) {
                    break;
                }
                LiveStreamMessages.MicSeatDetailInfo micSeatDetailInfo = micSeatDetailInfoArr2[i];
                if (micSeatDetailInfo != null) {
                    codedOutputByteBufferNano.writeMessage(5, micSeatDetailInfo);
                }
                i++;
            }
        }
        int i2 = this.micSeatsVersion;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        boolean z = this.fromEnterRoom;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        LiveStreamMessages.MicSeatLayoutInfo micSeatLayoutInfo = this.layoutInfo;
        if (micSeatLayoutInfo != null) {
            codedOutputByteBufferNano.writeMessage(8, micSeatLayoutInfo);
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
        if (!this.pkRoomId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.pkRoomId);
        }
        if (!this.pkRuleUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.pkRuleUrl);
        }
        LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
        if (micSeatDetailInfoArr != null && micSeatDetailInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = this.micSeatDetailInfo;
                if (i >= micSeatDetailInfoArr2.length) {
                    break;
                }
                LiveStreamMessages.MicSeatDetailInfo micSeatDetailInfo = micSeatDetailInfoArr2[i];
                if (micSeatDetailInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, micSeatDetailInfo);
                }
                i++;
            }
        }
        int i2 = this.micSeatsVersion;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        boolean z = this.fromEnterRoom;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        LiveStreamMessages.MicSeatLayoutInfo micSeatLayoutInfo = this.layoutInfo;
        return micSeatLayoutInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, micSeatLayoutInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCTeamPkRoomOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.pkRoomId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.pkRuleUrl = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
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
            } else if (tag == 48) {
                this.micSeatsVersion = codedInputByteBufferNano.readUInt32();
            } else if (tag == 56) {
                this.fromEnterRoom = codedInputByteBufferNano.readBool();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.layoutInfo == null) {
                    this.layoutInfo = new LiveStreamMessages.MicSeatLayoutInfo();
                }
                codedInputByteBufferNano.readMessage(this.layoutInfo);
            }
        }
    }

    public static SCTeamPkRoomOpened parseFrom(byte[] bArr) {
        return (SCTeamPkRoomOpened) MessageNano.mergeFrom(new SCTeamPkRoomOpened(), bArr);
    }

    public static SCTeamPkRoomOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCTeamPkRoomOpened().mergeFrom(codedInputByteBufferNano);
    }
}
