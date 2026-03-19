package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UpdateRoomConfig extends MessageNano {
    private static volatile UpdateRoomConfig[] _emptyArray;
    public SessionConfig[] sessionConfig;

    public static UpdateRoomConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdateRoomConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public UpdateRoomConfig() {
        clear();
    }

    public final UpdateRoomConfig clear() {
        this.sessionConfig = SessionConfig.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        SessionConfig[] sessionConfigArr = this.sessionConfig;
        if (sessionConfigArr != null && sessionConfigArr.length > 0) {
            int i = 0;
            while (true) {
                SessionConfig[] sessionConfigArr2 = this.sessionConfig;
                if (i >= sessionConfigArr2.length) {
                    break;
                }
                SessionConfig sessionConfig = sessionConfigArr2[i];
                if (sessionConfig != null) {
                    codedOutputByteBufferNano.writeMessage(1, sessionConfig);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        SessionConfig[] sessionConfigArr = this.sessionConfig;
        if (sessionConfigArr != null && sessionConfigArr.length > 0) {
            int i = 0;
            while (true) {
                SessionConfig[] sessionConfigArr2 = this.sessionConfig;
                if (i >= sessionConfigArr2.length) {
                    break;
                }
                SessionConfig sessionConfig = sessionConfigArr2[i];
                if (sessionConfig != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sessionConfig);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UpdateRoomConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                SessionConfig[] sessionConfigArr = this.sessionConfig;
                int length = sessionConfigArr == null ? 0 : sessionConfigArr.length;
                SessionConfig[] sessionConfigArr2 = new SessionConfig[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.sessionConfig, 0, sessionConfigArr2, 0, length);
                }
                while (length < sessionConfigArr2.length - 1) {
                    sessionConfigArr2[length] = new SessionConfig();
                    codedInputByteBufferNano.readMessage(sessionConfigArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                sessionConfigArr2[length] = new SessionConfig();
                codedInputByteBufferNano.readMessage(sessionConfigArr2[length]);
                this.sessionConfig = sessionConfigArr2;
            }
        }
    }

    public static UpdateRoomConfig parseFrom(byte[] bArr) {
        return (UpdateRoomConfig) MessageNano.mergeFrom(new UpdateRoomConfig(), bArr);
    }

    public static UpdateRoomConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UpdateRoomConfig().mergeFrom(codedInputByteBufferNano);
    }
}
