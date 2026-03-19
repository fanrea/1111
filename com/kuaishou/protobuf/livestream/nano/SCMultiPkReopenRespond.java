package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCMultiPkReopenRespond extends MessageNano {
    private static volatile SCMultiPkReopenRespond[] _emptyArray;
    public String chatId;
    public String pkId;
    public int pkReopenType;
    public int status;
    public String tip;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReopenRespondStatus {
        public static final int REJECT = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCMultiPkReopenRespond[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMultiPkReopenRespond[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMultiPkReopenRespond() {
        clear();
    }

    public final SCMultiPkReopenRespond clear() {
        this.pkId = "";
        this.status = 0;
        this.tip = "";
        this.chatId = "";
        this.pkReopenType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.tip.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.tip);
        }
        if (!this.chatId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.chatId);
        }
        int i2 = this.pkReopenType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.tip.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.tip);
        }
        if (!this.chatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.chatId);
        }
        int i2 = this.pkReopenType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMultiPkReopenRespond mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.status = int32;
                }
            } else if (tag == 26) {
                this.tip = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.chatId = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.pkReopenType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCMultiPkReopenRespond parseFrom(byte[] bArr) {
        return (SCMultiPkReopenRespond) MessageNano.mergeFrom(new SCMultiPkReopenRespond(), bArr);
    }

    public static SCMultiPkReopenRespond parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMultiPkReopenRespond().mergeFrom(codedInputByteBufferNano);
    }
}
