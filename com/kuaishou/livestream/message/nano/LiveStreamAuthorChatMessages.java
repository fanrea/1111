package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveShopMessages;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveStreamAuthorChatMessages {

    public static final class AuthorChatPlayerInfo extends MessageNano {
        private static volatile AuthorChatPlayerInfo[] _emptyArray;
        public String displayDistance;
        public double distance;
        public String liveStreamId;
        public UserInfos.UserInfo player;

        public static AuthorChatPlayerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuthorChatPlayerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuthorChatPlayerInfo() {
            clear();
        }

        public final AuthorChatPlayerInfo clear() {
            this.player = null;
            this.liveStreamId = "";
            this.distance = 0.0d;
            this.displayDistance = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.player;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.liveStreamId);
            }
            if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(3, this.distance);
            }
            if (!this.displayDistance.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.displayDistance);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.player;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
            }
            if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(0.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.distance);
            }
            return !this.displayDistance.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.displayDistance) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuthorChatPlayerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.player == null) {
                        this.player = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.player);
                } else if (tag == 18) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 25) {
                    this.distance = codedInputByteBufferNano.readDouble();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.displayDistance = codedInputByteBufferNano.readString();
                }
            }
        }

        public static AuthorChatPlayerInfo parseFrom(byte[] bArr) {
            return (AuthorChatPlayerInfo) MessageNano.mergeFrom(new AuthorChatPlayerInfo(), bArr);
        }

        public static AuthorChatPlayerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuthorChatPlayerInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCAuthorChatReady extends MessageNano {
        private static volatile SCAuthorChatReady[] _emptyArray;
        public AuthorChatPlayerInfo anotherAuthorInfo;
        public String authorChatId;
        public LiveShopMessages.LiveInteractiveRoomShopCartStatus shopCartStatus;

        public static SCAuthorChatReady[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCAuthorChatReady[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCAuthorChatReady() {
            clear();
        }

        public final SCAuthorChatReady clear() {
            this.authorChatId = "";
            this.anotherAuthorInfo = null;
            this.shopCartStatus = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.authorChatId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.authorChatId);
            }
            AuthorChatPlayerInfo authorChatPlayerInfo = this.anotherAuthorInfo;
            if (authorChatPlayerInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, authorChatPlayerInfo);
            }
            LiveShopMessages.LiveInteractiveRoomShopCartStatus liveInteractiveRoomShopCartStatus = this.shopCartStatus;
            if (liveInteractiveRoomShopCartStatus != null) {
                codedOutputByteBufferNano.writeMessage(3, liveInteractiveRoomShopCartStatus);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.authorChatId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.authorChatId);
            }
            AuthorChatPlayerInfo authorChatPlayerInfo = this.anotherAuthorInfo;
            if (authorChatPlayerInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, authorChatPlayerInfo);
            }
            LiveShopMessages.LiveInteractiveRoomShopCartStatus liveInteractiveRoomShopCartStatus = this.shopCartStatus;
            return liveInteractiveRoomShopCartStatus != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveInteractiveRoomShopCartStatus) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCAuthorChatReady mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.authorChatId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.anotherAuthorInfo == null) {
                        this.anotherAuthorInfo = new AuthorChatPlayerInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.anotherAuthorInfo);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.shopCartStatus == null) {
                        this.shopCartStatus = new LiveShopMessages.LiveInteractiveRoomShopCartStatus();
                    }
                    codedInputByteBufferNano.readMessage(this.shopCartStatus);
                }
            }
        }

        public static SCAuthorChatReady parseFrom(byte[] bArr) {
            return (SCAuthorChatReady) MessageNano.mergeFrom(new SCAuthorChatReady(), bArr);
        }

        public static SCAuthorChatReady parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCAuthorChatReady().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCAuthorChatEnd extends MessageNano {
        private static volatile SCAuthorChatEnd[] _emptyArray;
        public String authorChatId;
        public String endLiveStreamId;
        public int endType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AuthorChatEndType {
            public static final int AUTHOR_CHAT_END = 2;
            public static final int INVITEE_REJECT = 4;
            public static final int LIVESTREAM_END = 1;
            public static final int LIVESTREAM_HTTP_HEARTBEAT_TIMEOUT = 3;
            public static final int MANUAL_CLOSE = 6;
            public static final int PEER_TIMEOUT = 5;
            public static final int UNKNOWN_AUTHOR_CHAT_END_TYPE = 0;
        }

        public static SCAuthorChatEnd[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCAuthorChatEnd[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCAuthorChatEnd() {
            clear();
        }

        public final SCAuthorChatEnd clear() {
            this.authorChatId = "";
            this.endType = 0;
            this.endLiveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.authorChatId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.authorChatId);
            }
            int i = this.endType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            if (!this.endLiveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.endLiveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.authorChatId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.authorChatId);
            }
            int i = this.endType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            return !this.endLiveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.endLiveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCAuthorChatEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.authorChatId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.endType = int32;
                            break;
                    }
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.endLiveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCAuthorChatEnd parseFrom(byte[] bArr) {
            return (SCAuthorChatEnd) MessageNano.mergeFrom(new SCAuthorChatEnd(), bArr);
        }

        public static SCAuthorChatEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCAuthorChatEnd().mergeFrom(codedInputByteBufferNano);
        }
    }
}
