package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPkOpMicSeats extends MessageNano {
    private static volatile SCLiveVoicePartyPkOpMicSeats[] _emptyArray;
    public boolean enableVideoPk;
    public LiveStreamMessages.MicSeatLayoutInfo layoutInfo;
    public String liveStreamId;
    public LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfo;
    public String opLiveStreamId;
    public LiveVoicePartyOpMicSeatUpdatableInfo[] opMicSeatUpdatableInfo;
    public String opVoicePartyId;
    public String pkId;
    public String voicePartyId;

    public static SCLiveVoicePartyPkOpMicSeats[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkOpMicSeats[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkOpMicSeats() {
        clear();
    }

    public final SCLiveVoicePartyPkOpMicSeats clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkId = "";
        this.micSeatDetailInfo = LiveStreamMessages.MicSeatDetailInfo.emptyArray();
        this.layoutInfo = null;
        this.enableVideoPk = false;
        this.opMicSeatUpdatableInfo = LiveVoicePartyOpMicSeatUpdatableInfo.emptyArray();
        this.opLiveStreamId = "";
        this.opVoicePartyId = "";
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
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.pkId);
        }
        LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
        int i = 0;
        if (micSeatDetailInfoArr != null && micSeatDetailInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = this.micSeatDetailInfo;
                if (i2 >= micSeatDetailInfoArr2.length) {
                    break;
                }
                LiveStreamMessages.MicSeatDetailInfo micSeatDetailInfo = micSeatDetailInfoArr2[i2];
                if (micSeatDetailInfo != null) {
                    codedOutputByteBufferNano.writeMessage(4, micSeatDetailInfo);
                }
                i2++;
            }
        }
        LiveStreamMessages.MicSeatLayoutInfo micSeatLayoutInfo = this.layoutInfo;
        if (micSeatLayoutInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, micSeatLayoutInfo);
        }
        boolean z = this.enableVideoPk;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        LiveVoicePartyOpMicSeatUpdatableInfo[] liveVoicePartyOpMicSeatUpdatableInfoArr = this.opMicSeatUpdatableInfo;
        if (liveVoicePartyOpMicSeatUpdatableInfoArr != null && liveVoicePartyOpMicSeatUpdatableInfoArr.length > 0) {
            while (true) {
                LiveVoicePartyOpMicSeatUpdatableInfo[] liveVoicePartyOpMicSeatUpdatableInfoArr2 = this.opMicSeatUpdatableInfo;
                if (i >= liveVoicePartyOpMicSeatUpdatableInfoArr2.length) {
                    break;
                }
                LiveVoicePartyOpMicSeatUpdatableInfo liveVoicePartyOpMicSeatUpdatableInfo = liveVoicePartyOpMicSeatUpdatableInfoArr2[i];
                if (liveVoicePartyOpMicSeatUpdatableInfo != null) {
                    codedOutputByteBufferNano.writeMessage(7, liveVoicePartyOpMicSeatUpdatableInfo);
                }
                i++;
            }
        }
        if (!this.opLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.opLiveStreamId);
        }
        if (!this.opVoicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.opVoicePartyId);
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
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.pkId);
        }
        LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr = this.micSeatDetailInfo;
        int i = 0;
        if (micSeatDetailInfoArr != null && micSeatDetailInfoArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                LiveStreamMessages.MicSeatDetailInfo[] micSeatDetailInfoArr2 = this.micSeatDetailInfo;
                if (i2 >= micSeatDetailInfoArr2.length) {
                    break;
                }
                LiveStreamMessages.MicSeatDetailInfo micSeatDetailInfo = micSeatDetailInfoArr2[i2];
                if (micSeatDetailInfo != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, micSeatDetailInfo);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveStreamMessages.MicSeatLayoutInfo micSeatLayoutInfo = this.layoutInfo;
        if (micSeatLayoutInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, micSeatLayoutInfo);
        }
        boolean z = this.enableVideoPk;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        LiveVoicePartyOpMicSeatUpdatableInfo[] liveVoicePartyOpMicSeatUpdatableInfoArr = this.opMicSeatUpdatableInfo;
        if (liveVoicePartyOpMicSeatUpdatableInfoArr != null && liveVoicePartyOpMicSeatUpdatableInfoArr.length > 0) {
            while (true) {
                LiveVoicePartyOpMicSeatUpdatableInfo[] liveVoicePartyOpMicSeatUpdatableInfoArr2 = this.opMicSeatUpdatableInfo;
                if (i >= liveVoicePartyOpMicSeatUpdatableInfoArr2.length) {
                    break;
                }
                LiveVoicePartyOpMicSeatUpdatableInfo liveVoicePartyOpMicSeatUpdatableInfo = liveVoicePartyOpMicSeatUpdatableInfoArr2[i];
                if (liveVoicePartyOpMicSeatUpdatableInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveVoicePartyOpMicSeatUpdatableInfo);
                }
                i++;
            }
        }
        if (!this.opLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.opLiveStreamId);
        }
        return !this.opVoicePartyId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.opVoicePartyId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkOpMicSeats mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
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
            } else if (tag == 42) {
                if (this.layoutInfo == null) {
                    this.layoutInfo = new LiveStreamMessages.MicSeatLayoutInfo();
                }
                codedInputByteBufferNano.readMessage(this.layoutInfo);
            } else if (tag == 48) {
                this.enableVideoPk = codedInputByteBufferNano.readBool();
            } else if (tag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                LiveVoicePartyOpMicSeatUpdatableInfo[] liveVoicePartyOpMicSeatUpdatableInfoArr = this.opMicSeatUpdatableInfo;
                int length2 = liveVoicePartyOpMicSeatUpdatableInfoArr == null ? 0 : liveVoicePartyOpMicSeatUpdatableInfoArr.length;
                LiveVoicePartyOpMicSeatUpdatableInfo[] liveVoicePartyOpMicSeatUpdatableInfoArr2 = new LiveVoicePartyOpMicSeatUpdatableInfo[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.opMicSeatUpdatableInfo, 0, liveVoicePartyOpMicSeatUpdatableInfoArr2, 0, length2);
                }
                while (length2 < liveVoicePartyOpMicSeatUpdatableInfoArr2.length - 1) {
                    liveVoicePartyOpMicSeatUpdatableInfoArr2[length2] = new LiveVoicePartyOpMicSeatUpdatableInfo();
                    codedInputByteBufferNano.readMessage(liveVoicePartyOpMicSeatUpdatableInfoArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                liveVoicePartyOpMicSeatUpdatableInfoArr2[length2] = new LiveVoicePartyOpMicSeatUpdatableInfo();
                codedInputByteBufferNano.readMessage(liveVoicePartyOpMicSeatUpdatableInfoArr2[length2]);
                this.opMicSeatUpdatableInfo = liveVoicePartyOpMicSeatUpdatableInfoArr2;
            } else if (tag == 66) {
                this.opLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 74) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.opVoicePartyId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveVoicePartyPkOpMicSeats parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkOpMicSeats) MessageNano.mergeFrom(new SCLiveVoicePartyPkOpMicSeats(), bArr);
    }

    public static SCLiveVoicePartyPkOpMicSeats parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkOpMicSeats().mergeFrom(codedInputByteBufferNano);
    }
}
