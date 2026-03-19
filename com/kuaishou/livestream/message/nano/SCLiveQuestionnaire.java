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
public final class SCLiveQuestionnaire extends MessageNano {
    private static volatile SCLiveQuestionnaire[] _emptyArray;
    public int bizType;
    public boolean isTest;
    public int priority;
    public String questionnaireId;
    public long userWatchMaxDurationMs;
    public long userWatchMinDurationMs;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveQuestionnaireBizType {
        public static final int DEFAULT = 0;
        public static final int RECRUIT = 1;
    }

    public static SCLiveQuestionnaire[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveQuestionnaire[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveQuestionnaire() {
        clear();
    }

    public final SCLiveQuestionnaire clear() {
        this.questionnaireId = "";
        this.userWatchMinDurationMs = 0L;
        this.userWatchMaxDurationMs = 0L;
        this.isTest = false;
        this.bizType = 0;
        this.priority = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.questionnaireId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.questionnaireId);
        }
        long j = this.userWatchMinDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.userWatchMaxDurationMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        boolean z = this.isTest;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        int i = this.bizType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        int i2 = this.priority;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.questionnaireId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.questionnaireId);
        }
        long j = this.userWatchMinDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.userWatchMaxDurationMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        boolean z = this.isTest;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        int i = this.bizType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        int i2 = this.priority;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveQuestionnaire mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.questionnaireId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.userWatchMinDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.userWatchMaxDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.isTest = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.bizType = codedInputByteBufferNano.readUInt32();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.priority = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveQuestionnaire parseFrom(byte[] bArr) {
        return (SCLiveQuestionnaire) MessageNano.mergeFrom(new SCLiveQuestionnaire(), bArr);
    }

    public static SCLiveQuestionnaire parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveQuestionnaire().mergeFrom(codedInputByteBufferNano);
    }
}
