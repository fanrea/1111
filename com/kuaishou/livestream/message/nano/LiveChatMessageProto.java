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
public interface LiveChatMessageProto {

    public static final class LiveChatUserApplyInfoFeed extends MessageNano {
        private static volatile LiveChatUserApplyInfoFeed[] _emptyArray;
        public String id;
        public boolean isGuestSupportMultiChat;
        public int mediaTypeValue;
        public long sortRank;
        public UserInfos.UserInfo user;
        public LiveAudienceState userState;

        public static LiveChatUserApplyInfoFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveChatUserApplyInfoFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveChatUserApplyInfoFeed() {
            clear();
        }

        public final LiveChatUserApplyInfoFeed clear() {
            this.id = "";
            this.user = null;
            this.sortRank = 0L;
            this.isGuestSupportMultiChat = false;
            this.mediaTypeValue = 0;
            this.userState = null;
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
            long j = this.sortRank;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            boolean z = this.isGuestSupportMultiChat;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            int i = this.mediaTypeValue;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i);
            }
            LiveAudienceState liveAudienceState = this.userState;
            if (liveAudienceState != null) {
                codedOutputByteBufferNano.writeMessage(6, liveAudienceState);
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
            long j = this.sortRank;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            boolean z = this.isGuestSupportMultiChat;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
            }
            int i = this.mediaTypeValue;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
            }
            LiveAudienceState liveAudienceState = this.userState;
            return liveAudienceState != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, liveAudienceState) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveChatUserApplyInfoFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.isGuestSupportMultiChat = codedInputByteBufferNano.readBool();
                } else if (tag == 40) {
                    this.mediaTypeValue = codedInputByteBufferNano.readUInt32();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.userState == null) {
                        this.userState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.userState);
                }
            }
        }

        public static LiveChatUserApplyInfoFeed parseFrom(byte[] bArr) {
            return (LiveChatUserApplyInfoFeed) MessageNano.mergeFrom(new LiveChatUserApplyInfoFeed(), bArr);
        }

        public static LiveChatUserApplyInfoFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveChatUserApplyInfoFeed().mergeFrom(codedInputByteBufferNano);
        }
    }
}
