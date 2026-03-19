package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftPanelItemRefresh extends MessageNano {
    private static volatile SCLiveGiftPanelItemRefresh[] _emptyArray;
    public String giftPanelItem;
    public String giftToken;
    public long itemId;
    public long recoGiftLlsid;
    public String tabId;

    public static SCLiveGiftPanelItemRefresh[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftPanelItemRefresh[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftPanelItemRefresh() {
        clear();
    }

    public final SCLiveGiftPanelItemRefresh clear() {
        this.giftToken = "";
        this.recoGiftLlsid = 0L;
        this.giftPanelItem = "";
        this.tabId = "";
        this.itemId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.giftToken);
        }
        long j = this.recoGiftLlsid;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.giftPanelItem.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.giftPanelItem);
        }
        if (!this.tabId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.tabId);
        }
        long j2 = this.itemId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.giftToken);
        }
        long j = this.recoGiftLlsid;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.giftPanelItem.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.giftPanelItem);
        }
        if (!this.tabId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.tabId);
        }
        long j2 = this.itemId;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftPanelItemRefresh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.giftToken = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.recoGiftLlsid = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.giftPanelItem = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.tabId = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.itemId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveGiftPanelItemRefresh parseFrom(byte[] bArr) {
        return (SCLiveGiftPanelItemRefresh) MessageNano.mergeFrom(new SCLiveGiftPanelItemRefresh(), bArr);
    }

    public static SCLiveGiftPanelItemRefresh parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftPanelItemRefresh().mergeFrom(codedInputByteBufferNano);
    }
}
