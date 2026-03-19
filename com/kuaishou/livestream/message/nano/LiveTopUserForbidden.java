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
public interface LiveTopUserForbidden {

    public static final class SCTopUserForbiddenDialog extends MessageNano {
        private static volatile SCTopUserForbiddenDialog[] _emptyArray;
        public int actionType;
        public String button;
        public String desc;
        public String helpRouteUrl;
        public String liveStreamId;
        public String title;
        public long userId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ActionType {
            public static final int DEFAULT = 0;
            public static final int JUMP_TO_PROFILE_EDITOR = 1;
        }

        public static SCTopUserForbiddenDialog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCTopUserForbiddenDialog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCTopUserForbiddenDialog() {
            clear();
        }

        public final SCTopUserForbiddenDialog clear() {
            this.liveStreamId = "";
            this.userId = 0L;
            this.title = "";
            this.desc = "";
            this.button = "";
            this.helpRouteUrl = "";
            this.actionType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.title);
            }
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.desc);
            }
            if (!this.button.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.button);
            }
            if (!this.helpRouteUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.helpRouteUrl);
            }
            int i = this.actionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(7, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.title);
            }
            if (!this.desc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.desc);
            }
            if (!this.button.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.button);
            }
            if (!this.helpRouteUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.helpRouteUrl);
            }
            int i = this.actionType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCTopUserForbiddenDialog mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.userId = codedInputByteBufferNano.readInt64();
                } else if (tag == 26) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.desc = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.button = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.helpRouteUrl = codedInputByteBufferNano.readString();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.actionType = int32;
                    }
                }
            }
        }

        public static SCTopUserForbiddenDialog parseFrom(byte[] bArr) {
            return (SCTopUserForbiddenDialog) MessageNano.mergeFrom(new SCTopUserForbiddenDialog(), bArr);
        }

        public static SCTopUserForbiddenDialog parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCTopUserForbiddenDialog().mergeFrom(codedInputByteBufferNano);
        }
    }
}
