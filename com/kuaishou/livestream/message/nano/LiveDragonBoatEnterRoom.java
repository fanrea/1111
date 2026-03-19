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
public final class LiveDragonBoatEnterRoom extends MessageNano {
    private static volatile LiveDragonBoatEnterRoom[] _emptyArray;
    public int activityType;
    public LiveAudienceState senderState;
    public int type;
    public UserInfos.UserInfo user;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DragonBoatEnterRoomDisplayType {
        public static final int DRAGON_BOAT_TYPE = 2;
        public static final int RICE_PUDDING_TYPE = 1;
        public static final int UNKNOW_DISPLAY_TYPE = 0;
    }

    public static LiveDragonBoatEnterRoom[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveDragonBoatEnterRoom[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveDragonBoatEnterRoom() {
        clear();
    }

    public final LiveDragonBoatEnterRoom clear() {
        this.user = null;
        this.senderState = null;
        this.type = 0;
        this.activityType = 0;
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
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        int i2 = this.activityType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
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
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        int i2 = this.activityType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveDragonBoatEnterRoom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.type = int32;
                }
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.activityType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveDragonBoatEnterRoom parseFrom(byte[] bArr) {
        return (LiveDragonBoatEnterRoom) MessageNano.mergeFrom(new LiveDragonBoatEnterRoom(), bArr);
    }

    public static LiveDragonBoatEnterRoom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveDragonBoatEnterRoom().mergeFrom(codedInputByteBufferNano);
    }
}
