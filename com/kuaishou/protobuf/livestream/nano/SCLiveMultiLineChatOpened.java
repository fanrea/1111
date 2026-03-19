package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiLineChatOpened extends MessageNano {
    private static volatile SCLiveMultiLineChatOpened[] _emptyArray;
    public int chatMode;
    public String chatModeStartExtra;
    public boolean disableInviteOtherUser;
    public String disableInviteOtherUserToastText;
    public LiveMultiLineChatLastPkInfo lastPkInfo;
    public String multiLineChatId;
    public ScoreLineChatEntranceConfig scoreLineChatEntranceConfig;
    public LiveRevenueDeliverySellingChatInfo sellingChatInfo;
    public String subModeId;
    public Map<Long, LiveMultiLineChatUserExtraInfo> userExtraInfo;
    public long version;
    public String wishGiftPanelUrl;

    public static final class ScoreLineChatEntranceConfig extends MessageNano {
        private static volatile ScoreLineChatEntranceConfig[] _emptyArray;
        public boolean enableWishGiftBattleHeaderViewEntrance;
        public boolean enableWishGiftBattlePlayListTopButton;
        public String wishGiftPanelUrl;

        public static ScoreLineChatEntranceConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScoreLineChatEntranceConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ScoreLineChatEntranceConfig() {
            clear();
        }

        public final ScoreLineChatEntranceConfig clear() {
            this.wishGiftPanelUrl = "";
            this.enableWishGiftBattleHeaderViewEntrance = false;
            this.enableWishGiftBattlePlayListTopButton = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.wishGiftPanelUrl.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.wishGiftPanelUrl);
            }
            boolean z = this.enableWishGiftBattleHeaderViewEntrance;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            boolean z2 = this.enableWishGiftBattlePlayListTopButton;
            if (z2) {
                codedOutputByteBufferNano.writeBool(3, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.wishGiftPanelUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.wishGiftPanelUrl);
            }
            boolean z = this.enableWishGiftBattleHeaderViewEntrance;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            boolean z2 = this.enableWishGiftBattlePlayListTopButton;
            return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ScoreLineChatEntranceConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.wishGiftPanelUrl = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.enableWishGiftBattleHeaderViewEntrance = codedInputByteBufferNano.readBool();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enableWishGiftBattlePlayListTopButton = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static ScoreLineChatEntranceConfig parseFrom(byte[] bArr) {
            return (ScoreLineChatEntranceConfig) MessageNano.mergeFrom(new ScoreLineChatEntranceConfig(), bArr);
        }

        public static ScoreLineChatEntranceConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ScoreLineChatEntranceConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static SCLiveMultiLineChatOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiLineChatOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiLineChatOpened() {
        clear();
    }

    public final SCLiveMultiLineChatOpened clear() {
        this.multiLineChatId = "";
        this.chatMode = 0;
        this.chatModeStartExtra = "";
        this.userExtraInfo = null;
        this.disableInviteOtherUser = false;
        this.disableInviteOtherUserToastText = "";
        this.version = 0L;
        this.wishGiftPanelUrl = "";
        this.lastPkInfo = null;
        this.sellingChatInfo = null;
        this.subModeId = "";
        this.scoreLineChatEntranceConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.multiLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.multiLineChatId);
        }
        int i = this.chatMode;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.chatModeStartExtra.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.chatModeStartExtra);
        }
        Map<Long, LiveMultiLineChatUserExtraInfo> map = this.userExtraInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 4, 11);
        }
        boolean z = this.disableInviteOtherUser;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        if (!this.disableInviteOtherUserToastText.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.disableInviteOtherUserToastText);
        }
        long j = this.version;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j);
        }
        if (!this.wishGiftPanelUrl.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.wishGiftPanelUrl);
        }
        LiveMultiLineChatLastPkInfo liveMultiLineChatLastPkInfo = this.lastPkInfo;
        if (liveMultiLineChatLastPkInfo != null) {
            codedOutputByteBufferNano.writeMessage(9, liveMultiLineChatLastPkInfo);
        }
        LiveRevenueDeliverySellingChatInfo liveRevenueDeliverySellingChatInfo = this.sellingChatInfo;
        if (liveRevenueDeliverySellingChatInfo != null) {
            codedOutputByteBufferNano.writeMessage(10, liveRevenueDeliverySellingChatInfo);
        }
        if (!this.subModeId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.subModeId);
        }
        ScoreLineChatEntranceConfig scoreLineChatEntranceConfig = this.scoreLineChatEntranceConfig;
        if (scoreLineChatEntranceConfig != null) {
            codedOutputByteBufferNano.writeMessage(12, scoreLineChatEntranceConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.multiLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.multiLineChatId);
        }
        int i = this.chatMode;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.chatModeStartExtra.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.chatModeStartExtra);
        }
        Map<Long, LiveMultiLineChatUserExtraInfo> map = this.userExtraInfo;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 4, 4, 11);
        }
        boolean z = this.disableInviteOtherUser;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        if (!this.disableInviteOtherUserToastText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.disableInviteOtherUserToastText);
        }
        long j = this.version;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j);
        }
        if (!this.wishGiftPanelUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.wishGiftPanelUrl);
        }
        LiveMultiLineChatLastPkInfo liveMultiLineChatLastPkInfo = this.lastPkInfo;
        if (liveMultiLineChatLastPkInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveMultiLineChatLastPkInfo);
        }
        LiveRevenueDeliverySellingChatInfo liveRevenueDeliverySellingChatInfo = this.sellingChatInfo;
        if (liveRevenueDeliverySellingChatInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, liveRevenueDeliverySellingChatInfo);
        }
        if (!this.subModeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.subModeId);
        }
        ScoreLineChatEntranceConfig scoreLineChatEntranceConfig = this.scoreLineChatEntranceConfig;
        return scoreLineChatEntranceConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(12, scoreLineChatEntranceConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiLineChatOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.multiLineChatId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.chatMode = int32;
                            break;
                    }
                case 26:
                    this.chatModeStartExtra = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.userExtraInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.userExtraInfo, mapFactory, 4, 11, new LiveMultiLineChatUserExtraInfo(), 8, 18);
                    break;
                case 40:
                    this.disableInviteOtherUser = codedInputByteBufferNano.readBool();
                    break;
                case 50:
                    this.disableInviteOtherUserToastText = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.version = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    this.wishGiftPanelUrl = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    if (this.lastPkInfo == null) {
                        this.lastPkInfo = new LiveMultiLineChatLastPkInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.lastPkInfo);
                    break;
                case 82:
                    if (this.sellingChatInfo == null) {
                        this.sellingChatInfo = new LiveRevenueDeliverySellingChatInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sellingChatInfo);
                    break;
                case 90:
                    this.subModeId = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    if (this.scoreLineChatEntranceConfig == null) {
                        this.scoreLineChatEntranceConfig = new ScoreLineChatEntranceConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.scoreLineChatEntranceConfig);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveMultiLineChatOpened parseFrom(byte[] bArr) {
        return (SCLiveMultiLineChatOpened) MessageNano.mergeFrom(new SCLiveMultiLineChatOpened(), bArr);
    }

    public static SCLiveMultiLineChatOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiLineChatOpened().mergeFrom(codedInputByteBufferNano);
    }
}
