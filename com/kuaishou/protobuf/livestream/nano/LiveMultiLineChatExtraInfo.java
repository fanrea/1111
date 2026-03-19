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
public final class LiveMultiLineChatExtraInfo extends MessageNano {
    private static volatile LiveMultiLineChatExtraInfo[] _emptyArray;
    public int chatMode;
    public boolean disableInviteOtherUser;
    public String disableInviteOtherUserToastText;
    public boolean enableWishList;
    public LiveMultiLineChatLastPkInfo lastPkInfo;
    public String multiLineChatId;
    public SCLiveMultiLineChatOpened multiLineChatOpened;
    public LiveRevenueDeliverySellingChatInfo sellingChatInfo;
    public String subModeExtraInfo;
    public Map<Long, LiveMultiLineChatUserExtraInfo> userExtraInfo;

    public static LiveMultiLineChatExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiLineChatExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiLineChatExtraInfo() {
        clear();
    }

    public final LiveMultiLineChatExtraInfo clear() {
        this.userExtraInfo = null;
        this.disableInviteOtherUser = false;
        this.disableInviteOtherUserToastText = "";
        this.enableWishList = false;
        this.chatMode = 0;
        this.subModeExtraInfo = "";
        this.multiLineChatOpened = null;
        this.lastPkInfo = null;
        this.multiLineChatId = "";
        this.sellingChatInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Long, LiveMultiLineChatUserExtraInfo> map = this.userExtraInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 4, 11);
        }
        boolean z = this.disableInviteOtherUser;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        if (!this.disableInviteOtherUserToastText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.disableInviteOtherUserToastText);
        }
        boolean z2 = this.enableWishList;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        int i = this.chatMode;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        if (!this.subModeExtraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.subModeExtraInfo);
        }
        SCLiveMultiLineChatOpened sCLiveMultiLineChatOpened = this.multiLineChatOpened;
        if (sCLiveMultiLineChatOpened != null) {
            codedOutputByteBufferNano.writeMessage(7, sCLiveMultiLineChatOpened);
        }
        LiveMultiLineChatLastPkInfo liveMultiLineChatLastPkInfo = this.lastPkInfo;
        if (liveMultiLineChatLastPkInfo != null) {
            codedOutputByteBufferNano.writeMessage(8, liveMultiLineChatLastPkInfo);
        }
        if (!this.multiLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.multiLineChatId);
        }
        LiveRevenueDeliverySellingChatInfo liveRevenueDeliverySellingChatInfo = this.sellingChatInfo;
        if (liveRevenueDeliverySellingChatInfo != null) {
            codedOutputByteBufferNano.writeMessage(10, liveRevenueDeliverySellingChatInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Map<Long, LiveMultiLineChatUserExtraInfo> map = this.userExtraInfo;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 4, 11);
        }
        boolean z = this.disableInviteOtherUser;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        if (!this.disableInviteOtherUserToastText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.disableInviteOtherUserToastText);
        }
        boolean z2 = this.enableWishList;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        int i = this.chatMode;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        if (!this.subModeExtraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.subModeExtraInfo);
        }
        SCLiveMultiLineChatOpened sCLiveMultiLineChatOpened = this.multiLineChatOpened;
        if (sCLiveMultiLineChatOpened != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, sCLiveMultiLineChatOpened);
        }
        LiveMultiLineChatLastPkInfo liveMultiLineChatLastPkInfo = this.lastPkInfo;
        if (liveMultiLineChatLastPkInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveMultiLineChatLastPkInfo);
        }
        if (!this.multiLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.multiLineChatId);
        }
        LiveRevenueDeliverySellingChatInfo liveRevenueDeliverySellingChatInfo = this.sellingChatInfo;
        return liveRevenueDeliverySellingChatInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, liveRevenueDeliverySellingChatInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiLineChatExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.userExtraInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.userExtraInfo, mapFactory, 4, 11, new LiveMultiLineChatUserExtraInfo(), 8, 18);
                    break;
                case 16:
                    this.disableInviteOtherUser = codedInputByteBufferNano.readBool();
                    break;
                case 26:
                    this.disableInviteOtherUserToastText = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.enableWishList = codedInputByteBufferNano.readBool();
                    break;
                case 40:
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
                case 50:
                    this.subModeExtraInfo = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    if (this.multiLineChatOpened == null) {
                        this.multiLineChatOpened = new SCLiveMultiLineChatOpened();
                    }
                    codedInputByteBufferNano.readMessage(this.multiLineChatOpened);
                    break;
                case 66:
                    if (this.lastPkInfo == null) {
                        this.lastPkInfo = new LiveMultiLineChatLastPkInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.lastPkInfo);
                    break;
                case 74:
                    this.multiLineChatId = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.sellingChatInfo == null) {
                        this.sellingChatInfo = new LiveRevenueDeliverySellingChatInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sellingChatInfo);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveMultiLineChatExtraInfo parseFrom(byte[] bArr) {
        return (LiveMultiLineChatExtraInfo) MessageNano.mergeFrom(new LiveMultiLineChatExtraInfo(), bArr);
    }

    public static LiveMultiLineChatExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiLineChatExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
