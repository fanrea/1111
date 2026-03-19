package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftCommonRoute extends MessageNano {
    private static volatile SCLiveGiftCommonRoute[] _emptyArray;
    public long executeDeadlineTime;
    public String liveStreamId;
    public boolean needBreakCombo;
    public String routeUrl;

    public static SCLiveGiftCommonRoute[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftCommonRoute[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftCommonRoute() {
        clear();
    }

    public final SCLiveGiftCommonRoute clear() {
        this.routeUrl = "";
        this.executeDeadlineTime = 0L;
        this.liveStreamId = "";
        this.needBreakCombo = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.routeUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.routeUrl);
        }
        long j = this.executeDeadlineTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveStreamId);
        }
        boolean z = this.needBreakCombo;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.routeUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.routeUrl);
        }
        long j = this.executeDeadlineTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
        }
        boolean z = this.needBreakCombo;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftCommonRoute mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.routeUrl = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.executeDeadlineTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.needBreakCombo = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCLiveGiftCommonRoute parseFrom(byte[] bArr) {
        return (SCLiveGiftCommonRoute) MessageNano.mergeFrom(new SCLiveGiftCommonRoute(), bArr);
    }

    public static SCLiveGiftCommonRoute parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftCommonRoute().mergeFrom(codedInputByteBufferNano);
    }
}
