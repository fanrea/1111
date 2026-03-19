package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGuideStrategy extends MessageNano {
    private static volatile SCLiveGuideStrategy[] _emptyArray;
    public String frequencyConfigBizId;
    public int guideFeatureType;
    public int guidePriority;
    public LiveGuideNotice liveGuideNotice;

    public static SCLiveGuideStrategy[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGuideStrategy[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGuideStrategy() {
        clear();
    }

    public final SCLiveGuideStrategy clear() {
        this.guideFeatureType = 0;
        this.guidePriority = 0;
        this.frequencyConfigBizId = "";
        this.liveGuideNotice = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.guideFeatureType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.guidePriority;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        if (!this.frequencyConfigBizId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.frequencyConfigBizId);
        }
        LiveGuideNotice liveGuideNotice = this.liveGuideNotice;
        if (liveGuideNotice != null) {
            codedOutputByteBufferNano.writeMessage(4, liveGuideNotice);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.guideFeatureType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.guidePriority;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        if (!this.frequencyConfigBizId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.frequencyConfigBizId);
        }
        LiveGuideNotice liveGuideNotice = this.liveGuideNotice;
        return liveGuideNotice != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, liveGuideNotice) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGuideStrategy mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.guideFeatureType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.guidePriority = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                this.frequencyConfigBizId = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.liveGuideNotice == null) {
                    this.liveGuideNotice = new LiveGuideNotice();
                }
                codedInputByteBufferNano.readMessage(this.liveGuideNotice);
            }
        }
    }

    public static SCLiveGuideStrategy parseFrom(byte[] bArr) {
        return (SCLiveGuideStrategy) MessageNano.mergeFrom(new SCLiveGuideStrategy(), bArr);
    }

    public static SCLiveGuideStrategy parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGuideStrategy().mergeFrom(codedInputByteBufferNano);
    }
}
