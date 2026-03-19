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
public interface LiveUserTaskStatusChangeProto {

    public static final class LiveUserTaskStatusChange extends MessageNano {
        private static volatile LiveUserTaskStatusChange[] _emptyArray;
        public long activityId;
        public long authorId;
        public long cycleNo;
        public boolean isCycle;
        public String jumpUrl;
        public long liveStreamId;
        public long taskId;
        public int taskStatus;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveUserTaskStatus {
            public static final int TASK_FINISHED = 1;
            public static final int UNKNOWN = 0;
        }

        public static LiveUserTaskStatusChange[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveUserTaskStatusChange[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveUserTaskStatusChange() {
            clear();
        }

        public final LiveUserTaskStatusChange clear() {
            this.liveStreamId = 0L;
            this.authorId = 0L;
            this.activityId = 0L;
            this.taskId = 0L;
            this.isCycle = false;
            this.cycleNo = 0L;
            this.jumpUrl = "";
            this.taskStatus = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.liveStreamId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.authorId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.activityId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            long j4 = this.taskId;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j4);
            }
            boolean z = this.isCycle;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            long j5 = this.cycleNo;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j5);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.jumpUrl);
            }
            int i = this.taskStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(8, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.liveStreamId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.authorId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.activityId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            long j4 = this.taskId;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
            }
            boolean z = this.isCycle;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            long j5 = this.cycleNo;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j5);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.jumpUrl);
            }
            int i = this.taskStatus;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveUserTaskStatusChange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.liveStreamId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.authorId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.taskId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.isCycle = codedInputByteBufferNano.readBool();
                } else if (tag == 48) {
                    this.cycleNo = codedInputByteBufferNano.readUInt64();
                } else if (tag == 58) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.taskStatus = int32;
                    }
                }
            }
        }

        public static LiveUserTaskStatusChange parseFrom(byte[] bArr) {
            return (LiveUserTaskStatusChange) MessageNano.mergeFrom(new LiveUserTaskStatusChange(), bArr);
        }

        public static LiveUserTaskStatusChange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveUserTaskStatusChange().mergeFrom(codedInputByteBufferNano);
        }
    }
}
