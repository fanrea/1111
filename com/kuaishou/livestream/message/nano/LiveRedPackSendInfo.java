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
public final class LiveRedPackSendInfo extends MessageNano {
    private static volatile LiveRedPackSendInfo[] _emptyArray;
    public String id;
    public long ksCoin;
    public String liveStreamId;
    public String redPackId;
    public int redPackType;
    public int sendType;
    public UserInfos.UserInfo sendUserInfo;
    public LiveAudienceState sendUserState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SendType {
        public static final int APPEND = 2;
        public static final int SEND = 1;
        public static final int UNKNOWN = 0;
    }

    public static LiveRedPackSendInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveRedPackSendInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveRedPackSendInfo() {
        clear();
    }

    public final LiveRedPackSendInfo clear() {
        this.liveStreamId = "";
        this.redPackId = "";
        this.redPackType = 0;
        this.ksCoin = 0L;
        this.sendUserInfo = null;
        this.sendType = 0;
        this.id = "";
        this.sendUserState = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.redPackId);
        }
        int i = this.redPackType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        long j = this.ksCoin;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        UserInfos.UserInfo userInfo = this.sendUserInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, userInfo);
        }
        int i2 = this.sendType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i2);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.id);
        }
        LiveAudienceState liveAudienceState = this.sendUserState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(8, liveAudienceState);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.redPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.redPackId);
        }
        int i = this.redPackType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        long j = this.ksCoin;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        UserInfos.UserInfo userInfo = this.sendUserInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, userInfo);
        }
        int i2 = this.sendType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
        }
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.id);
        }
        LiveAudienceState liveAudienceState = this.sendUserState;
        return liveAudienceState != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, liveAudienceState) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveRedPackSendInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.redPackId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 != 0 && int32 != 1 && int32 != 2) {
                    switch (int32) {
                    }
                }
                this.redPackType = int32;
            } else if (tag == 32) {
                this.ksCoin = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                if (this.sendUserInfo == null) {
                    this.sendUserInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.sendUserInfo);
            } else if (tag == 48) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.sendType = int322;
                }
            } else if (tag == 58) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.sendUserState == null) {
                    this.sendUserState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.sendUserState);
            }
        }
    }

    public static LiveRedPackSendInfo parseFrom(byte[] bArr) {
        return (LiveRedPackSendInfo) MessageNano.mergeFrom(new LiveRedPackSendInfo(), bArr);
    }

    public static LiveRedPackSendInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveRedPackSendInfo().mergeFrom(codedInputByteBufferNano);
    }
}
