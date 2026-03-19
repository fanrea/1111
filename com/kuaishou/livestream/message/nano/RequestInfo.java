package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class RequestInfo extends MessageNano {
    private static volatile RequestInfo[] _emptyArray;
    public String bizName;
    public String params;
    public String path;

    public static RequestInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RequestInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public RequestInfo() {
        clear();
    }

    public final RequestInfo clear() {
        this.path = "";
        this.params = "";
        this.bizName = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.path.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.path);
        }
        if (!this.params.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.params);
        }
        if (!this.bizName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.bizName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.path.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.path);
        }
        if (!this.params.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.params);
        }
        return !this.bizName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.bizName) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final RequestInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.path = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.params = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizName = codedInputByteBufferNano.readString();
            }
        }
    }

    public static RequestInfo parseFrom(byte[] bArr) {
        return (RequestInfo) MessageNano.mergeFrom(new RequestInfo(), bArr);
    }

    public static RequestInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new RequestInfo().mergeFrom(codedInputByteBufferNano);
    }
}
