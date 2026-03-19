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
public final class TestActionSignalFeed extends MessageNano {
    private static volatile TestActionSignalFeed[] _emptyArray;
    public String content;
    public String deviceHash;
    public String id;
    public LiveAudienceState senderState;
    public long sortRank;
    public long time;
    public UserInfos.UserInfo user;

    public static TestActionSignalFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TestActionSignalFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public TestActionSignalFeed() {
        clear();
    }

    public final TestActionSignalFeed clear() {
        this.id = "";
        this.user = null;
        this.time = 0L;
        this.content = "";
        this.sortRank = 0L;
        this.deviceHash = "";
        this.senderState = null;
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
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.content);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(7, liveAudienceState);
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
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.content);
        }
        long j2 = this.sortRank;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        if (!this.deviceHash.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        return liveAudienceState != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, liveAudienceState) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TestActionSignalFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.sortRank = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                this.deviceHash = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            }
        }
    }

    public static TestActionSignalFeed parseFrom(byte[] bArr) {
        return (TestActionSignalFeed) MessageNano.mergeFrom(new TestActionSignalFeed(), bArr);
    }

    public static TestActionSignalFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TestActionSignalFeed().mergeFrom(codedInputByteBufferNano);
    }
}
