package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.cny2023.message.nano.CnyCdnDegradeProto;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024EnhanceLikeDisplay extends MessageNano {
    private static volatile SCLiveCny2024EnhanceLikeDisplay[] _emptyArray;
    public CnyCdnDegradeProto.DegradablePicUrl backgroundImage;
    public String bizType;
    public long delayLoadTimeIntervalMillis;
    public long displayDurationMillis;
    public String redirectUrl;

    public static SCLiveCny2024EnhanceLikeDisplay[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024EnhanceLikeDisplay[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024EnhanceLikeDisplay() {
        clear();
    }

    public final SCLiveCny2024EnhanceLikeDisplay clear() {
        this.displayDurationMillis = 0L;
        this.backgroundImage = null;
        this.delayLoadTimeIntervalMillis = 0L;
        this.redirectUrl = "";
        this.bizType = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.displayDurationMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.backgroundImage;
        if (degradablePicUrl != null) {
            codedOutputByteBufferNano.writeMessage(2, degradablePicUrl);
        }
        long j2 = this.delayLoadTimeIntervalMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j2);
        }
        if (!this.redirectUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.redirectUrl);
        }
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.bizType);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.displayDurationMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.backgroundImage;
        if (degradablePicUrl != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, degradablePicUrl);
        }
        long j2 = this.delayLoadTimeIntervalMillis;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j2);
        }
        if (!this.redirectUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.redirectUrl);
        }
        return !this.bizType.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizType) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024EnhanceLikeDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.displayDurationMillis = codedInputByteBufferNano.readInt64();
            } else if (tag == 18) {
                if (this.backgroundImage == null) {
                    this.backgroundImage = new CnyCdnDegradeProto.DegradablePicUrl();
                }
                codedInputByteBufferNano.readMessage(this.backgroundImage);
            } else if (tag == 24) {
                this.delayLoadTimeIntervalMillis = codedInputByteBufferNano.readInt64();
            } else if (tag == 34) {
                this.redirectUrl = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizType = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveCny2024EnhanceLikeDisplay parseFrom(byte[] bArr) {
        return (SCLiveCny2024EnhanceLikeDisplay) MessageNano.mergeFrom(new SCLiveCny2024EnhanceLikeDisplay(), bArr);
    }

    public static SCLiveCny2024EnhanceLikeDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024EnhanceLikeDisplay().mergeFrom(codedInputByteBufferNano);
    }
}
