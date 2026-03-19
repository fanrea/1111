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
public final class SCVoicePartyEnterRoomNotice extends MessageNano {
    private static volatile SCVoicePartyEnterRoomNotice[] _emptyArray;
    public UserInfos.UserInfo author;
    public int level;
    public String liveStreamId;
    public int source;
    public int subLevel;
    public UserInfos.UserInfo user;
    public LiveAudienceState userState;
    public String voicePartyId;

    public static SCVoicePartyEnterRoomNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCVoicePartyEnterRoomNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCVoicePartyEnterRoomNotice() {
        clear();
    }

    public final SCVoicePartyEnterRoomNotice clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.author = null;
        this.user = null;
        this.source = 0;
        this.userState = null;
        this.level = 0;
        this.subLevel = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.voicePartyId);
        }
        UserInfos.UserInfo userInfo = this.author;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.user;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo2);
        }
        int i = this.source;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(6, liveAudienceState);
        }
        int i2 = this.level;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i2);
        }
        int i3 = this.subLevel;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
        }
        UserInfos.UserInfo userInfo = this.author;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.user;
        if (userInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo2);
        }
        int i = this.source;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveAudienceState);
        }
        int i2 = this.level;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i2);
        }
        int i3 = this.subLevel;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCVoicePartyEnterRoomNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                if (this.author == null) {
                    this.author = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.author);
            } else if (tag == 34) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 40) {
                this.source = codedInputByteBufferNano.readUInt32();
            } else if (tag == 50) {
                if (this.userState == null) {
                    this.userState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.userState);
            } else if (tag == 56) {
                this.level = codedInputByteBufferNano.readInt32();
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.subLevel = codedInputByteBufferNano.readInt32();
            }
        }
    }

    public static SCVoicePartyEnterRoomNotice parseFrom(byte[] bArr) {
        return (SCVoicePartyEnterRoomNotice) MessageNano.mergeFrom(new SCVoicePartyEnterRoomNotice(), bArr);
    }

    public static SCVoicePartyEnterRoomNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCVoicePartyEnterRoomNotice().mergeFrom(codedInputByteBufferNano);
    }
}
