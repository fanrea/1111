package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveTabRefreshExtraInfo extends MessageNano {
    private static volatile LiveTabRefreshExtraInfo[] _emptyArray;
    public String bizExtraInfo;
    public int bizType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RefreshTabBizType {
        public static final int TRICKY_PK = 1;
        public static final int UNKNOWN = 0;
    }

    public static LiveTabRefreshExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveTabRefreshExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveTabRefreshExtraInfo() {
        clear();
    }

    public final LiveTabRefreshExtraInfo clear() {
        this.bizType = 0;
        this.bizExtraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.bizType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.bizExtraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.bizExtraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.bizType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        return !this.bizExtraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.bizExtraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveTabRefreshExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.bizType = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizExtraInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveTabRefreshExtraInfo parseFrom(byte[] bArr) {
        return (LiveTabRefreshExtraInfo) MessageNano.mergeFrom(new LiveTabRefreshExtraInfo(), bArr);
    }

    public static LiveTabRefreshExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveTabRefreshExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
