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
public interface LiveUserTaskProto {

    public static final class LiveUserTaskCommonRouteModel extends MessageNano {
        private static volatile LiveUserTaskCommonRouteModel[] _emptyArray;
        public String bizId;
        public int bizType;
        public String routeUrl;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveUserTaskCommonRouteBizType {
            public static final int CUSTOM = 2;
            public static final int NEW_USER_REACH = 1;
            public static final int UNKNOWN_USER_TASK_BIZ_TYPE = 0;
        }

        public static LiveUserTaskCommonRouteModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveUserTaskCommonRouteModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveUserTaskCommonRouteModel() {
            clear();
        }

        public final LiveUserTaskCommonRouteModel clear() {
            this.bizType = 0;
            this.bizId = "";
            this.routeUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bizId);
            }
            if (!this.routeUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.routeUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizId);
            }
            return !this.routeUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.routeUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveUserTaskCommonRouteModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.bizType = int32;
                    }
                } else if (tag == 18) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.routeUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveUserTaskCommonRouteModel parseFrom(byte[] bArr) {
            return (LiveUserTaskCommonRouteModel) MessageNano.mergeFrom(new LiveUserTaskCommonRouteModel(), bArr);
        }

        public static LiveUserTaskCommonRouteModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveUserTaskCommonRouteModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveUserTaskCommonRoute extends MessageNano {
        private static volatile LiveUserTaskCommonRoute[] _emptyArray;
        public LiveUserTaskCommonRouteModel[] commonRoute;

        public static LiveUserTaskCommonRoute[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveUserTaskCommonRoute[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveUserTaskCommonRoute() {
            clear();
        }

        public final LiveUserTaskCommonRoute clear() {
            this.commonRoute = LiveUserTaskCommonRouteModel.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveUserTaskCommonRouteModel[] liveUserTaskCommonRouteModelArr = this.commonRoute;
            if (liveUserTaskCommonRouteModelArr != null && liveUserTaskCommonRouteModelArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveUserTaskCommonRouteModel[] liveUserTaskCommonRouteModelArr2 = this.commonRoute;
                    if (i >= liveUserTaskCommonRouteModelArr2.length) {
                        break;
                    }
                    LiveUserTaskCommonRouteModel liveUserTaskCommonRouteModel = liveUserTaskCommonRouteModelArr2[i];
                    if (liveUserTaskCommonRouteModel != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveUserTaskCommonRouteModel);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveUserTaskCommonRouteModel[] liveUserTaskCommonRouteModelArr = this.commonRoute;
            if (liveUserTaskCommonRouteModelArr != null && liveUserTaskCommonRouteModelArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveUserTaskCommonRouteModel[] liveUserTaskCommonRouteModelArr2 = this.commonRoute;
                    if (i >= liveUserTaskCommonRouteModelArr2.length) {
                        break;
                    }
                    LiveUserTaskCommonRouteModel liveUserTaskCommonRouteModel = liveUserTaskCommonRouteModelArr2[i];
                    if (liveUserTaskCommonRouteModel != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveUserTaskCommonRouteModel);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveUserTaskCommonRoute mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveUserTaskCommonRouteModel[] liveUserTaskCommonRouteModelArr = this.commonRoute;
                    int length = liveUserTaskCommonRouteModelArr == null ? 0 : liveUserTaskCommonRouteModelArr.length;
                    LiveUserTaskCommonRouteModel[] liveUserTaskCommonRouteModelArr2 = new LiveUserTaskCommonRouteModel[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.commonRoute, 0, liveUserTaskCommonRouteModelArr2, 0, length);
                    }
                    while (length < liveUserTaskCommonRouteModelArr2.length - 1) {
                        liveUserTaskCommonRouteModelArr2[length] = new LiveUserTaskCommonRouteModel();
                        codedInputByteBufferNano.readMessage(liveUserTaskCommonRouteModelArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveUserTaskCommonRouteModelArr2[length] = new LiveUserTaskCommonRouteModel();
                    codedInputByteBufferNano.readMessage(liveUserTaskCommonRouteModelArr2[length]);
                    this.commonRoute = liveUserTaskCommonRouteModelArr2;
                }
            }
        }

        public static LiveUserTaskCommonRoute parseFrom(byte[] bArr) {
            return (LiveUserTaskCommonRoute) MessageNano.mergeFrom(new LiveUserTaskCommonRoute(), bArr);
        }

        public static LiveUserTaskCommonRoute parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveUserTaskCommonRoute().mergeFrom(codedInputByteBufferNano);
        }
    }
}
