package com.kuaishou.kwaishop.live.assistant.protobuf.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKwaishopLiveAssistantDataPanelEntryState extends MessageNano {
    private static volatile SCKwaishopLiveAssistantDataPanelEntryState[] _emptyArray;
    public String dataEntryTitle;
    public String dataPanelUrl;
    public boolean isShowDataEntry;
    public long orderGmv;

    public static SCKwaishopLiveAssistantDataPanelEntryState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKwaishopLiveAssistantDataPanelEntryState[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKwaishopLiveAssistantDataPanelEntryState() {
        clear();
    }

    public final SCKwaishopLiveAssistantDataPanelEntryState clear() {
        this.isShowDataEntry = false;
        this.orderGmv = 0L;
        this.dataPanelUrl = "";
        this.dataEntryTitle = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isShowDataEntry;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.orderGmv;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        if (!this.dataPanelUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.dataPanelUrl);
        }
        if (!this.dataEntryTitle.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.dataEntryTitle);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isShowDataEntry;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.orderGmv;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        if (!this.dataPanelUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.dataPanelUrl);
        }
        return !this.dataEntryTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.dataEntryTitle) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKwaishopLiveAssistantDataPanelEntryState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isShowDataEntry = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.orderGmv = codedInputByteBufferNano.readInt64();
            } else if (tag == 26) {
                this.dataPanelUrl = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.dataEntryTitle = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCKwaishopLiveAssistantDataPanelEntryState parseFrom(byte[] bArr) {
        return (SCKwaishopLiveAssistantDataPanelEntryState) MessageNano.mergeFrom(new SCKwaishopLiveAssistantDataPanelEntryState(), bArr);
    }

    public static SCKwaishopLiveAssistantDataPanelEntryState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKwaishopLiveAssistantDataPanelEntryState().mergeFrom(codedInputByteBufferNano);
    }
}
