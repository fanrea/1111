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
public final class SCLiveOfficialProgrammeDumpAudience extends MessageNano {
    private static volatile SCLiveOfficialProgrammeDumpAudience[] _emptyArray;
    public int dumpType;
    public long maxDelayMs;
    public long minDelayMs;
    public int notDumpPercent;
    public String officialLiveStreamId;
    public String showLiveStreamId;
    public String tagId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DumpType {
        public static final int ALL_USER = 1;
        public static final int ONLY_TAG_USER = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveOfficialProgrammeDumpAudience[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOfficialProgrammeDumpAudience[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOfficialProgrammeDumpAudience() {
        clear();
    }

    public final SCLiveOfficialProgrammeDumpAudience clear() {
        this.dumpType = 0;
        this.showLiveStreamId = "";
        this.officialLiveStreamId = "";
        this.minDelayMs = 0L;
        this.maxDelayMs = 0L;
        this.notDumpPercent = 0;
        this.tagId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.dumpType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.showLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.showLiveStreamId);
        }
        if (!this.officialLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.officialLiveStreamId);
        }
        long j = this.minDelayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.maxDelayMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        int i2 = this.notDumpPercent;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        if (!this.tagId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.tagId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.dumpType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.showLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.showLiveStreamId);
        }
        if (!this.officialLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.officialLiveStreamId);
        }
        long j = this.minDelayMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.maxDelayMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        int i2 = this.notDumpPercent;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        return !this.tagId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.tagId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOfficialProgrammeDumpAudience mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.dumpType = int32;
                }
            } else if (tag == 18) {
                this.showLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.officialLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.minDelayMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.maxDelayMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.notDumpPercent = codedInputByteBufferNano.readUInt32();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.tagId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveOfficialProgrammeDumpAudience parseFrom(byte[] bArr) {
        return (SCLiveOfficialProgrammeDumpAudience) MessageNano.mergeFrom(new SCLiveOfficialProgrammeDumpAudience(), bArr);
    }

    public static SCLiveOfficialProgrammeDumpAudience parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOfficialProgrammeDumpAudience().mergeFrom(codedInputByteBufferNano);
    }
}
