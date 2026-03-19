package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveRedPackGrabInfo extends MessageNano {
    private static volatile LiveRedPackGrabInfo[] _emptyArray;
    public UserInfos.UserInfo grabUserInfo;
    public LiveAudienceState grabUserState;
    public String id;
    public long ksCoin;
    public String liveStreamId;
    public String redPackId;
    public int redPackType;
    public UserInfos.UserInfo sendUserInfo;

    public static LiveRedPackGrabInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveRedPackGrabInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveRedPackGrabInfo() {
        clear();
    }

    public final LiveRedPackGrabInfo clear() {
        this.liveStreamId = "";
        this.redPackId = "";
        this.redPackType = 0;
        this.ksCoin = 0L;
        this.sendUserInfo = null;
        this.grabUserInfo = null;
        this.id = "";
        this.grabUserState = null;
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
        UserInfos.UserInfo userInfo2 = this.grabUserInfo;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(6, userInfo2);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.id);
        }
        LiveAudienceState liveAudienceState = this.grabUserState;
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
        UserInfos.UserInfo userInfo2 = this.grabUserInfo;
        if (userInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, userInfo2);
        }
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.id);
        }
        LiveAudienceState liveAudienceState = this.grabUserState;
        return liveAudienceState != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, liveAudienceState) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveRedPackGrabInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 50) {
                if (this.grabUserInfo == null) {
                    this.grabUserInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.grabUserInfo);
            } else if (tag == 58) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.grabUserState == null) {
                    this.grabUserState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.grabUserState);
            }
        }
    }

    public static LiveRedPackGrabInfo parseFrom(byte[] bArr) {
        return (LiveRedPackGrabInfo) MessageNano.mergeFrom(new LiveRedPackGrabInfo(), bArr);
    }

    public static LiveRedPackGrabInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveRedPackGrabInfo().mergeFrom(codedInputByteBufferNano);
    }
}
