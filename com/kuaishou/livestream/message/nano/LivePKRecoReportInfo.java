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
public final class LivePKRecoReportInfo extends MessageNano {
    private static volatile LivePKRecoReportInfo[] _emptyArray;
    public int infoType;
    public LivePKRecoRealShow realShow;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EnumInfoType {
        public static final int INVITE_REALSHOW = 1;
        public static final int UNKNOWN = 0;
    }

    public static LivePKRecoReportInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePKRecoReportInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePKRecoReportInfo() {
        clear();
    }

    public final LivePKRecoReportInfo clear() {
        this.infoType = 0;
        this.realShow = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.infoType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        LivePKRecoRealShow livePKRecoRealShow = this.realShow;
        if (livePKRecoRealShow != null) {
            codedOutputByteBufferNano.writeMessage(2, livePKRecoRealShow);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.infoType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        LivePKRecoRealShow livePKRecoRealShow = this.realShow;
        return livePKRecoRealShow != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, livePKRecoRealShow) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePKRecoReportInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.infoType = int32;
                }
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.realShow == null) {
                    this.realShow = new LivePKRecoRealShow();
                }
                codedInputByteBufferNano.readMessage(this.realShow);
            }
        }
    }

    public static LivePKRecoReportInfo parseFrom(byte[] bArr) {
        return (LivePKRecoReportInfo) MessageNano.mergeFrom(new LivePKRecoReportInfo(), bArr);
    }

    public static LivePKRecoReportInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePKRecoReportInfo().mergeFrom(codedInputByteBufferNano);
    }
}
