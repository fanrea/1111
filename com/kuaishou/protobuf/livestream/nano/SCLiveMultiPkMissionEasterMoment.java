package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkMissionEasterMoment extends MessageNano {
    private static volatile SCLiveMultiPkMissionEasterMoment[] _emptyArray;
    public long authorId;
    public LiveMultiPkMissionBaseShowConfig baseShowConfig;
    public LiveMultiPkMissionEasterMomentConfig easterMomentConfig;
    public LiveMultiPkMissionEasterMomentResult easterMomentResult;
    public long liveStreamId;
    public String multiPkId;
    public long timestamp;

    public static SCLiveMultiPkMissionEasterMoment[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkMissionEasterMoment[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkMissionEasterMoment() {
        clear();
    }

    public final SCLiveMultiPkMissionEasterMoment clear() {
        this.authorId = 0L;
        this.liveStreamId = 0L;
        this.timestamp = 0L;
        this.multiPkId = "";
        this.easterMomentConfig = null;
        this.easterMomentResult = null;
        this.baseShowConfig = null;
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
        LiveMultiPkMissionEasterMomentConfig liveMultiPkMissionEasterMomentConfig = this.easterMomentConfig;
        if (liveMultiPkMissionEasterMomentConfig != null) {
            codedOutputByteBufferNano.writeMessage(5, liveMultiPkMissionEasterMomentConfig);
        }
        LiveMultiPkMissionEasterMomentResult liveMultiPkMissionEasterMomentResult = this.easterMomentResult;
        if (liveMultiPkMissionEasterMomentResult != null) {
            codedOutputByteBufferNano.writeMessage(6, liveMultiPkMissionEasterMomentResult);
        }
        LiveMultiPkMissionBaseShowConfig liveMultiPkMissionBaseShowConfig = this.baseShowConfig;
        if (liveMultiPkMissionBaseShowConfig != null) {
            codedOutputByteBufferNano.writeMessage(7, liveMultiPkMissionBaseShowConfig);
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
        LiveMultiPkMissionEasterMomentConfig liveMultiPkMissionEasterMomentConfig = this.easterMomentConfig;
        if (liveMultiPkMissionEasterMomentConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveMultiPkMissionEasterMomentConfig);
        }
        LiveMultiPkMissionEasterMomentResult liveMultiPkMissionEasterMomentResult = this.easterMomentResult;
        if (liveMultiPkMissionEasterMomentResult != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveMultiPkMissionEasterMomentResult);
        }
        LiveMultiPkMissionBaseShowConfig liveMultiPkMissionBaseShowConfig = this.baseShowConfig;
        return liveMultiPkMissionBaseShowConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, liveMultiPkMissionBaseShowConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkMissionEasterMoment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.easterMomentConfig == null) {
                    this.easterMomentConfig = new LiveMultiPkMissionEasterMomentConfig();
                }
                codedInputByteBufferNano.readMessage(this.easterMomentConfig);
            } else if (tag == 50) {
                if (this.easterMomentResult == null) {
                    this.easterMomentResult = new LiveMultiPkMissionEasterMomentResult();
                }
                codedInputByteBufferNano.readMessage(this.easterMomentResult);
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.baseShowConfig == null) {
                    this.baseShowConfig = new LiveMultiPkMissionBaseShowConfig();
                }
                codedInputByteBufferNano.readMessage(this.baseShowConfig);
            }
        }
    }

    public static SCLiveMultiPkMissionEasterMoment parseFrom(byte[] bArr) {
        return (SCLiveMultiPkMissionEasterMoment) MessageNano.mergeFrom(new SCLiveMultiPkMissionEasterMoment(), bArr);
    }

    public static SCLiveMultiPkMissionEasterMoment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkMissionEasterMoment().mergeFrom(codedInputByteBufferNano);
    }
}
