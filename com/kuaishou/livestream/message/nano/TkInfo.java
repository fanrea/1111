package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TkInfo extends MessageNano {
    private static volatile TkInfo[] _emptyArray;
    public String templateData;
    public String templateId;
    public int templateVersionCode;
    public String viewKey;

    public static TkInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TkInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public TkInfo() {
        clear();
    }

    public final TkInfo clear() {
        this.templateId = "";
        this.templateVersionCode = 0;
        this.viewKey = "";
        this.templateData = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.templateId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.templateId);
        }
        int i = this.templateVersionCode;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.viewKey.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.viewKey);
        }
        if (!this.templateData.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.templateData);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.templateId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.templateId);
        }
        int i = this.templateVersionCode;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.viewKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.viewKey);
        }
        return !this.templateData.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.templateData) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TkInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.templateId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.templateVersionCode = codedInputByteBufferNano.readInt32();
            } else if (tag == 26) {
                this.viewKey = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.templateData = codedInputByteBufferNano.readString();
            }
        }
    }

    public static TkInfo parseFrom(byte[] bArr) {
        return (TkInfo) MessageNano.mergeFrom(new TkInfo(), bArr);
    }

    public static TkInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TkInfo().mergeFrom(codedInputByteBufferNano);
    }
}
