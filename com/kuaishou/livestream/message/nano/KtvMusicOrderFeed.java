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
public final class KtvMusicOrderFeed extends MessageNano {
    private static volatile KtvMusicOrderFeed[] _emptyArray;
    public String deviceHash;
    public String id;
    public String musicName;
    public long sortRank;
    public long time;
    public UserInfos.UserInfo user;
    public LiveAudienceState userState;

    public static KtvMusicOrderFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new KtvMusicOrderFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public KtvMusicOrderFeed() {
        clear();
    }

    public final KtvMusicOrderFeed clear() {
        this.id = "";
        this.user = null;
        this.deviceHash = "";
        this.userState = null;
        this.musicName = "";
        this.sortRank = 0L;
        this.time = 0L;
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
        if (!this.musicName.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.musicName);
        }
        long j = this.sortRank;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        long j2 = this.time;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j2);
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
        if (!this.musicName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.musicName);
        }
        long j = this.sortRank;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        long j2 = this.time;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final KtvMusicOrderFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 42) {
                this.musicName = codedInputByteBufferNano.readString();
            } else if (tag == 48) {
                this.sortRank = codedInputByteBufferNano.readUInt64();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.time = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static KtvMusicOrderFeed parseFrom(byte[] bArr) {
        return (KtvMusicOrderFeed) MessageNano.mergeFrom(new KtvMusicOrderFeed(), bArr);
    }

    public static KtvMusicOrderFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new KtvMusicOrderFeed().mergeFrom(codedInputByteBufferNano);
    }
}
