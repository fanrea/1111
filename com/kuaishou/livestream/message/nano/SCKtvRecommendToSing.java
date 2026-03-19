package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKtvRecommendToSing extends MessageNano {
    private static volatile SCKtvRecommendToSing[] _emptyArray;
    public String feedContent;
    public String id;
    public String ktvId;
    public String liveStreamId;
    public String musicIdStr;
    public int musicType;
    public String voicePartyId;

    public static SCKtvRecommendToSing[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKtvRecommendToSing[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKtvRecommendToSing() {
        clear();
    }

    public final SCKtvRecommendToSing clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.ktvId = "";
        this.musicIdStr = "";
        this.musicType = 0;
        this.feedContent = "";
        this.id = "";
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
        if (!this.ktvId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.ktvId);
        }
        if (!this.musicIdStr.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.musicIdStr);
        }
        int i = this.musicType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        if (!this.feedContent.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.feedContent);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.id);
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
        if (!this.ktvId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.ktvId);
        }
        if (!this.musicIdStr.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.musicIdStr);
        }
        int i = this.musicType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        if (!this.feedContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.feedContent);
        }
        return !this.id.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.id) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKtvRecommendToSing mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.ktvId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.musicIdStr = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
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
                    case 10:
                    case 11:
                        this.musicType = int32;
                        break;
                }
            } else if (tag == 50) {
                this.feedContent = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.id = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCKtvRecommendToSing parseFrom(byte[] bArr) {
        return (SCKtvRecommendToSing) MessageNano.mergeFrom(new SCKtvRecommendToSing(), bArr);
    }

    public static SCKtvRecommendToSing parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKtvRecommendToSing().mergeFrom(codedInputByteBufferNano);
    }
}
