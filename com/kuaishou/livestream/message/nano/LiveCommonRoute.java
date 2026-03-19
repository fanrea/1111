package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCommonRoute extends MessageNano {
    private static volatile LiveCommonRoute[] _emptyArray;
    public long executeDeadlineTime;
    public long executeTime;
    public String liveStreamId;
    public LiveCommonRoutePopupStrategy popupStrategy;
    public long randomDelayTime;
    public String routeUrl;

    public static LiveCommonRoute[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCommonRoute[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCommonRoute() {
        clear();
    }

    public final LiveCommonRoute clear() {
        this.routeUrl = "";
        this.executeTime = 0L;
        this.executeDeadlineTime = 0L;
        this.randomDelayTime = 0L;
        this.liveStreamId = "";
        this.popupStrategy = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.routeUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.routeUrl);
        }
        long j = this.executeTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.executeDeadlineTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        long j3 = this.randomDelayTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.liveStreamId);
        }
        LiveCommonRoutePopupStrategy liveCommonRoutePopupStrategy = this.popupStrategy;
        if (liveCommonRoutePopupStrategy != null) {
            codedOutputByteBufferNano.writeMessage(6, liveCommonRoutePopupStrategy);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.routeUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.routeUrl);
        }
        long j = this.executeTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.executeDeadlineTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        long j3 = this.randomDelayTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.liveStreamId);
        }
        LiveCommonRoutePopupStrategy liveCommonRoutePopupStrategy = this.popupStrategy;
        return liveCommonRoutePopupStrategy != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, liveCommonRoutePopupStrategy) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCommonRoute mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.routeUrl = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.executeTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.executeDeadlineTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.randomDelayTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.popupStrategy == null) {
                    this.popupStrategy = new LiveCommonRoutePopupStrategy();
                }
                codedInputByteBufferNano.readMessage(this.popupStrategy);
            }
        }
    }

    public static LiveCommonRoute parseFrom(byte[] bArr) {
        return (LiveCommonRoute) MessageNano.mergeFrom(new LiveCommonRoute(), bArr);
    }

    public static LiveCommonRoute parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCommonRoute().mergeFrom(codedInputByteBufferNano);
    }
}
