package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHotspotSimpleInfo extends MessageNano {
    private static volatile LiveHotspotSimpleInfo[] _emptyArray;
    public String hotspotId;
    public String rankTitle;

    public static LiveHotspotSimpleInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHotspotSimpleInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHotspotSimpleInfo() {
        clear();
    }

    public final LiveHotspotSimpleInfo clear() {
        this.hotspotId = "";
        this.rankTitle = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.hotspotId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.hotspotId);
        }
        if (!this.rankTitle.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.rankTitle);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.hotspotId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.hotspotId);
        }
        return !this.rankTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.rankTitle) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHotspotSimpleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.hotspotId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.rankTitle = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveHotspotSimpleInfo parseFrom(byte[] bArr) {
        return (LiveHotspotSimpleInfo) MessageNano.mergeFrom(new LiveHotspotSimpleInfo(), bArr);
    }

    public static LiveHotspotSimpleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHotspotSimpleInfo().mergeFrom(codedInputByteBufferNano);
    }
}
