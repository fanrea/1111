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
public final class SCLiveSmallPlayBottomUpdate extends MessageNano {
    private static volatile SCLiveSmallPlayBottomUpdate[] _emptyArray;
    public int action;
    public String backgroundColor;
    public String buttonText;
    public String buttonTextColor;
    public String jumpUrl;
    public String logParams;
    public long version;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SmallPlayBottomUpdate {
        public static final int CLOSE = 2;
        public static final int OPEN = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveSmallPlayBottomUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveSmallPlayBottomUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveSmallPlayBottomUpdate() {
        clear();
    }

    public final SCLiveSmallPlayBottomUpdate clear() {
        this.action = 0;
        this.jumpUrl = "";
        this.buttonText = "";
        this.buttonTextColor = "";
        this.backgroundColor = "";
        this.version = 0L;
        this.logParams = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.action;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.jumpUrl);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.buttonText);
        }
        if (!this.buttonTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.buttonTextColor);
        }
        if (!this.backgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.backgroundColor);
        }
        long j = this.version;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        if (!this.logParams.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.logParams);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.action;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.jumpUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.jumpUrl);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.buttonText);
        }
        if (!this.buttonTextColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonTextColor);
        }
        if (!this.backgroundColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.backgroundColor);
        }
        long j = this.version;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        return !this.logParams.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.logParams) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveSmallPlayBottomUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.action = int32;
                }
            } else if (tag == 18) {
                this.jumpUrl = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.buttonText = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.buttonTextColor = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.backgroundColor = codedInputByteBufferNano.readString();
            } else if (tag == 48) {
                this.version = codedInputByteBufferNano.readUInt64();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.logParams = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveSmallPlayBottomUpdate parseFrom(byte[] bArr) {
        return (SCLiveSmallPlayBottomUpdate) MessageNano.mergeFrom(new SCLiveSmallPlayBottomUpdate(), bArr);
    }

    public static SCLiveSmallPlayBottomUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveSmallPlayBottomUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
