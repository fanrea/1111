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
public final class SCLivePartyPlayStatus extends MessageNano {
    private static volatile SCLivePartyPlayStatus[] _emptyArray;
    public String appId;
    public String appUrl;
    public long maxPreloadTimeMillis;
    public int playStatus;
    public String roomCode;
    public long version;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayStatus {
        public static final int START = 1;
        public static final int STOP = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLivePartyPlayStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePartyPlayStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePartyPlayStatus() {
        clear();
    }

    public final SCLivePartyPlayStatus clear() {
        this.playStatus = 0;
        this.roomCode = "";
        this.appId = "";
        this.appUrl = "";
        this.maxPreloadTimeMillis = 0L;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.playStatus;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.roomCode.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomCode);
        }
        if (!this.appId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.appId);
        }
        if (!this.appUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.appUrl);
        }
        long j = this.maxPreloadTimeMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        long j2 = this.version;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.playStatus;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.roomCode.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roomCode);
        }
        if (!this.appId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.appId);
        }
        if (!this.appUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.appUrl);
        }
        long j = this.maxPreloadTimeMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        long j2 = this.version;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePartyPlayStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.playStatus = int32;
                }
            } else if (tag == 18) {
                this.roomCode = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.appId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.appUrl = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.maxPreloadTimeMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLivePartyPlayStatus parseFrom(byte[] bArr) {
        return (SCLivePartyPlayStatus) MessageNano.mergeFrom(new SCLivePartyPlayStatus(), bArr);
    }

    public static SCLivePartyPlayStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePartyPlayStatus().mergeFrom(codedInputByteBufferNano);
    }
}
