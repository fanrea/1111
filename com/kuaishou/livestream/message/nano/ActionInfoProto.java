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
public final class ActionInfoProto extends MessageNano {
    private static volatile ActionInfoProto[] _emptyArray;
    public int actionType;
    public String actionUrl;
    public String ext;
    public int interactType;
    public RequestInfo requestInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionType {
        public static final int HTTP = 2;
        public static final int SCHEMA = 1;
        public static final int UNKNOWN_ACTION_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InteractType {
        public static final int LIGHT_STREAMER = 1;
        public static final int UNKNOWN_INTERACT_TYPE = 0;
    }

    public static ActionInfoProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ActionInfoProto[0];
                }
            }
        }
        return _emptyArray;
    }

    public ActionInfoProto() {
        clear();
    }

    public final ActionInfoProto clear() {
        this.actionType = 0;
        this.actionUrl = "";
        this.interactType = 0;
        this.ext = "";
        this.requestInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.actionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.actionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.actionUrl);
        }
        int i2 = this.interactType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.ext);
        }
        RequestInfo requestInfo = this.requestInfo;
        if (requestInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, requestInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.actionType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.actionUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.actionUrl);
        }
        int i2 = this.interactType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        if (!this.ext.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.ext);
        }
        RequestInfo requestInfo = this.requestInfo;
        return requestInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, requestInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ActionInfoProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.actionType = int32;
                }
            } else if (tag == 18) {
                this.actionUrl = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1) {
                    this.interactType = int322;
                }
            } else if (tag == 34) {
                this.ext = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.requestInfo == null) {
                    this.requestInfo = new RequestInfo();
                }
                codedInputByteBufferNano.readMessage(this.requestInfo);
            }
        }
    }

    public static ActionInfoProto parseFrom(byte[] bArr) {
        return (ActionInfoProto) MessageNano.mergeFrom(new ActionInfoProto(), bArr);
    }

    public static ActionInfoProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ActionInfoProto().mergeFrom(codedInputByteBufferNano);
    }
}
