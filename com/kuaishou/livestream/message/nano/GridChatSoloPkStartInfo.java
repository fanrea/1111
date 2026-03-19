package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GridChatSoloPkStartInfo extends MessageNano {
    private static volatile GridChatSoloPkStartInfo[] _emptyArray;
    public String liveStreamId;
    public String pkId;
    public GridChatSoloPKStatisticInfo statisticInfo;
    public String voicePartyId;

    public static GridChatSoloPkStartInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GridChatSoloPkStartInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public GridChatSoloPkStartInfo() {
        clear();
    }

    public final GridChatSoloPkStartInfo clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkId = "";
        this.statisticInfo = null;
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
            codedOutputByteBufferNano.writeString(4, this.pkId);
        }
        GridChatSoloPKStatisticInfo gridChatSoloPKStatisticInfo = this.statisticInfo;
        if (gridChatSoloPKStatisticInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, gridChatSoloPKStatisticInfo);
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
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.pkId);
        }
        GridChatSoloPKStatisticInfo gridChatSoloPKStatisticInfo = this.statisticInfo;
        return gridChatSoloPKStatisticInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, gridChatSoloPKStatisticInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GridChatSoloPkStartInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.statisticInfo == null) {
                    this.statisticInfo = new GridChatSoloPKStatisticInfo();
                }
                codedInputByteBufferNano.readMessage(this.statisticInfo);
            }
        }
    }

    public static GridChatSoloPkStartInfo parseFrom(byte[] bArr) {
        return (GridChatSoloPkStartInfo) MessageNano.mergeFrom(new GridChatSoloPkStartInfo(), bArr);
    }

    public static GridChatSoloPkStartInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GridChatSoloPkStartInfo().mergeFrom(codedInputByteBufferNano);
    }
}
