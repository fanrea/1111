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
public final class LiveFansTopOrderHelpBuyFeed extends MessageNano {
    private static volatile LiveFansTopOrderHelpBuyFeed[] _emptyArray;
    public long authorId;
    public String id;
    public String liveStreamId;
    public UserInfos.UserInfo user;
    public long userId;
    public LiveAudienceState userState;

    public static LiveFansTopOrderHelpBuyFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveFansTopOrderHelpBuyFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveFansTopOrderHelpBuyFeed() {
        clear();
    }

    public final LiveFansTopOrderHelpBuyFeed clear() {
        this.userId = 0L;
        this.user = null;
        this.liveStreamId = "";
        this.authorId = 0L;
        this.userState = null;
        this.id = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveStreamId);
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(5, liveAudienceState);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.id);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveAudienceState);
        }
        return !this.id.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.id) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveFansTopOrderHelpBuyFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 26) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                if (this.userState == null) {
                    this.userState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.userState);
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.id = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveFansTopOrderHelpBuyFeed parseFrom(byte[] bArr) {
        return (LiveFansTopOrderHelpBuyFeed) MessageNano.mergeFrom(new LiveFansTopOrderHelpBuyFeed(), bArr);
    }

    public static LiveFansTopOrderHelpBuyFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveFansTopOrderHelpBuyFeed().mergeFrom(codedInputByteBufferNano);
    }
}
