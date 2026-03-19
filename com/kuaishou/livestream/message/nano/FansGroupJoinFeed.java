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
public final class FansGroupJoinFeed extends MessageNano {
    private static volatile FansGroupJoinFeed[] _emptyArray;
    public String deviceHash;
    public String id;
    public int joinSource;
    public long time;
    public UserInfos.UserInfo user;
    public LiveAudienceState userState;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FansGroupJoinSource {
        public static final int FROM_GIFT = 1;
        public static final int FROM_KS_COIN = 2;
        public static final int UNKNOWN_SOURCE = 0;
    }

    public static FansGroupJoinFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FansGroupJoinFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public FansGroupJoinFeed() {
        clear();
    }

    public final FansGroupJoinFeed clear() {
        this.id = "";
        this.user = null;
        this.deviceHash = "";
        this.userState = null;
        this.time = 0L;
        this.joinSource = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.id);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(4, liveAudienceState);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        int i = this.joinSource;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        if (!this.deviceHash.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveAudienceState);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        int i = this.joinSource;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final FansGroupJoinFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 26) {
                this.deviceHash = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                if (this.userState == null) {
                    this.userState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.userState);
            } else if (tag == 40) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.joinSource = int32;
                }
            }
        }
    }

    public static FansGroupJoinFeed parseFrom(byte[] bArr) {
        return (FansGroupJoinFeed) MessageNano.mergeFrom(new FansGroupJoinFeed(), bArr);
    }

    public static FansGroupJoinFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new FansGroupJoinFeed().mergeFrom(codedInputByteBufferNano);
    }
}
