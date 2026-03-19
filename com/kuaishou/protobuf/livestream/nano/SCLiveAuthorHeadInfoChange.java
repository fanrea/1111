package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAuthorHeadInfoChange extends MessageNano {
    private static volatile SCLiveAuthorHeadInfoChange[] _emptyArray;
    public int changeType;
    public UserInfos.UserInfo targetUserInfo;
    public String title;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangeType {
        public static final int CAHNGE_BACK_SELF = 2;
        public static final int CAHNGE_TO_OTHER = 1;
        public static final int CHANGE_TO_UNION_OTHER_AFTER = 4;
        public static final int CHANGE_TO_UNION_OTHER_BEFORE = 3;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveAuthorHeadInfoChange[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAuthorHeadInfoChange[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAuthorHeadInfoChange() {
        clear();
    }

    public final SCLiveAuthorHeadInfoChange clear() {
        this.changeType = 0;
        this.targetUserInfo = null;
        this.title = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.changeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        UserInfos.UserInfo userInfo = this.targetUserInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.title);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.changeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        UserInfos.UserInfo userInfo = this.targetUserInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        return !this.title.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.title) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAuthorHeadInfoChange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.changeType = int32;
                }
            } else if (tag == 18) {
                if (this.targetUserInfo == null) {
                    this.targetUserInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.targetUserInfo);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.title = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveAuthorHeadInfoChange parseFrom(byte[] bArr) {
        return (SCLiveAuthorHeadInfoChange) MessageNano.mergeFrom(new SCLiveAuthorHeadInfoChange(), bArr);
    }

    public static SCLiveAuthorHeadInfoChange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAuthorHeadInfoChange().mergeFrom(codedInputByteBufferNano);
    }
}
