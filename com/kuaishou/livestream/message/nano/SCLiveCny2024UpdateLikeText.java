package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.cny2023.message.nano.CnyCdnDegradeProto;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024UpdateLikeText extends MessageNano {
    private static volatile SCLiveCny2024UpdateLikeText[] _emptyArray;
    public long delayLoadTimeIntervalMillis;
    public long displayDurationMillis;
    public CnyCdnDegradeProto.DegradablePicUrl icon;
    public boolean needShow;
    public String redirectUrl;
    public String text;

    public static SCLiveCny2024UpdateLikeText[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024UpdateLikeText[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024UpdateLikeText() {
        clear();
    }

    public final SCLiveCny2024UpdateLikeText clear() {
        this.needShow = false;
        this.text = "";
        this.icon = null;
        this.delayLoadTimeIntervalMillis = 0L;
        this.redirectUrl = "";
        this.displayDurationMillis = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.needShow;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.text);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.icon;
        if (degradablePicUrl != null) {
            codedOutputByteBufferNano.writeMessage(3, degradablePicUrl);
        }
        long j = this.delayLoadTimeIntervalMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(4, j);
        }
        if (!this.redirectUrl.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.redirectUrl);
        }
        long j2 = this.displayDurationMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.needShow;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.icon;
        if (degradablePicUrl != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, degradablePicUrl);
        }
        long j = this.delayLoadTimeIntervalMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j);
        }
        if (!this.redirectUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.redirectUrl);
        }
        long j2 = this.displayDurationMillis;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(6, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024UpdateLikeText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.needShow = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                if (this.icon == null) {
                    this.icon = new CnyCdnDegradeProto.DegradablePicUrl();
                }
                codedInputByteBufferNano.readMessage(this.icon);
            } else if (tag == 32) {
                this.delayLoadTimeIntervalMillis = codedInputByteBufferNano.readInt64();
            } else if (tag == 42) {
                this.redirectUrl = codedInputByteBufferNano.readString();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayDurationMillis = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static SCLiveCny2024UpdateLikeText parseFrom(byte[] bArr) {
        return (SCLiveCny2024UpdateLikeText) MessageNano.mergeFrom(new SCLiveCny2024UpdateLikeText(), bArr);
    }

    public static SCLiveCny2024UpdateLikeText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024UpdateLikeText().mergeFrom(codedInputByteBufferNano);
    }
}
