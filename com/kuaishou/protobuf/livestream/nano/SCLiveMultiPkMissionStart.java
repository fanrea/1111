package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkMissionStart extends MessageNano {
    private static volatile SCLiveMultiPkMissionStart[] _emptyArray;
    public long authorId;
    public long liveStreamId;
    public String multiPkId;
    public LiveMultiPkMissionConfig pkMissionConfig;
    public LiveMultiPkMissionStartConfig pkMissionStartConfig;
    public long timestamp;

    public static SCLiveMultiPkMissionStart[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkMissionStart[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkMissionStart() {
        clear();
    }

    public final SCLiveMultiPkMissionStart clear() {
        this.authorId = 0L;
        this.liveStreamId = 0L;
        this.timestamp = 0L;
        this.multiPkId = "";
        this.pkMissionConfig = null;
        this.pkMissionStartConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.liveStreamId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.multiPkId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.multiPkId);
        }
        LiveMultiPkMissionConfig liveMultiPkMissionConfig = this.pkMissionConfig;
        if (liveMultiPkMissionConfig != null) {
            codedOutputByteBufferNano.writeMessage(5, liveMultiPkMissionConfig);
        }
        LiveMultiPkMissionStartConfig liveMultiPkMissionStartConfig = this.pkMissionStartConfig;
        if (liveMultiPkMissionStartConfig != null) {
            codedOutputByteBufferNano.writeMessage(6, liveMultiPkMissionStartConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.liveStreamId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        if (!this.multiPkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.multiPkId);
        }
        LiveMultiPkMissionConfig liveMultiPkMissionConfig = this.pkMissionConfig;
        if (liveMultiPkMissionConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveMultiPkMissionConfig);
        }
        LiveMultiPkMissionStartConfig liveMultiPkMissionStartConfig = this.pkMissionStartConfig;
        return liveMultiPkMissionStartConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, liveMultiPkMissionStartConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkMissionStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.liveStreamId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.multiPkId = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                if (this.pkMissionConfig == null) {
                    this.pkMissionConfig = new LiveMultiPkMissionConfig();
                }
                codedInputByteBufferNano.readMessage(this.pkMissionConfig);
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.pkMissionStartConfig == null) {
                    this.pkMissionStartConfig = new LiveMultiPkMissionStartConfig();
                }
                codedInputByteBufferNano.readMessage(this.pkMissionStartConfig);
            }
        }
    }

    public static SCLiveMultiPkMissionStart parseFrom(byte[] bArr) {
        return (SCLiveMultiPkMissionStart) MessageNano.mergeFrom(new SCLiveMultiPkMissionStart(), bArr);
    }

    public static SCLiveMultiPkMissionStart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkMissionStart().mergeFrom(codedInputByteBufferNano);
    }
}
