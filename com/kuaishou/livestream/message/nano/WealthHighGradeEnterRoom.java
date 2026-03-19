package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class WealthHighGradeEnterRoom extends MessageNano {
    private static volatile WealthHighGradeEnterRoom[] _emptyArray;
    public String deviceHash;
    public int displayType;
    public LiveAudienceState senderState;
    public UserInfos.UserInfo user;

    @Retention(RetentionPolicy.SOURCE)
    public @interface WealthHighGradeEnterDisplayType {
        public static final int ADVANCED_COOL = 3;
        public static final int COOL = 2;
        public static final int NORMAL = 1;
        public static final int TOP_COOL = 4;
        public static final int UNKNOWN = 0;
    }

    public static WealthHighGradeEnterRoom[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WealthHighGradeEnterRoom[0];
                }
            }
        }
        return _emptyArray;
    }

    public WealthHighGradeEnterRoom() {
        clear();
    }

    public final WealthHighGradeEnterRoom clear() {
        this.user = null;
        this.senderState = null;
        this.displayType = 0;
        this.deviceHash = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(2, liveAudienceState);
        }
        int i = this.displayType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.deviceHash);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveAudienceState);
        }
        int i = this.displayType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        return !this.deviceHash.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.deviceHash) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final WealthHighGradeEnterRoom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 18) {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.displayType = int32;
                }
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.deviceHash = codedInputByteBufferNano.readString();
            }
        }
    }

    public static WealthHighGradeEnterRoom parseFrom(byte[] bArr) {
        return (WealthHighGradeEnterRoom) MessageNano.mergeFrom(new WealthHighGradeEnterRoom(), bArr);
    }

    public static WealthHighGradeEnterRoom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new WealthHighGradeEnterRoom().mergeFrom(codedInputByteBufferNano);
    }
}
