package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveColorTextMessages;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveLineChatMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveLineChatMatchType {
        public static final int MATCH_BY_APPLY_FRIEND = 6;
        public static final int MATCH_BY_AUTHOR_INVITE_FRIEND = 3;
        public static final int MATCH_BY_AUTHOR_INVITE_INTEREST_USER = 4;
        public static final int MATCH_BY_BOTH_IN_POOL = 1;
        public static final int MATCH_BY_PAID_CHAT_INVITE = 5;
        public static final int MATCH_BY_PK_CONTINUE_INVITE = 7;
        public static final int MATCH_BY_RECO_INVITE = 2;
        public static final int UNKNOWN_MATCH_TYPE = 0;
    }

    public static final class SCLiveLineChatInvite extends MessageNano {
        private static volatile SCLiveLineChatInvite[] _emptyArray;
        public String acceptButtonText;
        public long acceptDeadlineTimestamp;
        public long commentNoticeDeadlineTimestamp;
        public UserInfos.UserInfo inviter;
        public String inviterDetailUrl;
        public String inviterLiveStreamId;
        public LiveLineChatInviterLiveStreamInfo inviterLiveStreamInfo;
        public boolean isPaidChatInvite;
        public String lineChatId;
        public String liveStreamId;
        public String paidChatInviteCommentButtonDesc;
        public String paidChatInviteCommentDesc;
        public String paidChatInviteCommentTitle;
        public LiveLineChatPayInfo payInfo;
        public String[] tag;

        public static SCLiveLineChatInvite[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveLineChatInvite[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveLineChatInvite() {
            clear();
        }

        public final SCLiveLineChatInvite clear() {
            this.inviter = null;
            this.acceptDeadlineTimestamp = 0L;
            this.liveStreamId = "";
            this.lineChatId = "";
            this.tag = WireFormatNano.EMPTY_STRING_ARRAY;
            this.payInfo = null;
            this.inviterLiveStreamInfo = null;
            this.acceptButtonText = "";
            this.inviterLiveStreamId = "";
            this.isPaidChatInvite = false;
            this.commentNoticeDeadlineTimestamp = 0L;
            this.paidChatInviteCommentTitle = "";
            this.paidChatInviteCommentDesc = "";
            this.inviterDetailUrl = "";
            this.paidChatInviteCommentButtonDesc = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.inviter;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            long j = this.acceptDeadlineTimestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liveStreamId);
            }
            if (!this.lineChatId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.lineChatId);
            }
            String[] strArr = this.tag;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.tag;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(5, str);
                    }
                    i++;
                }
            }
            LiveLineChatPayInfo liveLineChatPayInfo = this.payInfo;
            if (liveLineChatPayInfo != null) {
                codedOutputByteBufferNano.writeMessage(6, liveLineChatPayInfo);
            }
            LiveLineChatInviterLiveStreamInfo liveLineChatInviterLiveStreamInfo = this.inviterLiveStreamInfo;
            if (liveLineChatInviterLiveStreamInfo != null) {
                codedOutputByteBufferNano.writeMessage(7, liveLineChatInviterLiveStreamInfo);
            }
            if (!this.acceptButtonText.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.acceptButtonText);
            }
            if (!this.inviterLiveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.inviterLiveStreamId);
            }
            boolean z = this.isPaidChatInvite;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            long j2 = this.commentNoticeDeadlineTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j2);
            }
            if (!this.paidChatInviteCommentTitle.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.paidChatInviteCommentTitle);
            }
            if (!this.paidChatInviteCommentDesc.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.paidChatInviteCommentDesc);
            }
            if (!this.inviterDetailUrl.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.inviterDetailUrl);
            }
            if (!this.paidChatInviteCommentButtonDesc.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.paidChatInviteCommentButtonDesc);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.inviter;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            long j = this.acceptDeadlineTimestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
            }
            if (!this.lineChatId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.lineChatId);
            }
            String[] strArr = this.tag;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                int iComputeStringSizeNoTag = 0;
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.tag;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        i2++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
            }
            LiveLineChatPayInfo liveLineChatPayInfo = this.payInfo;
            if (liveLineChatPayInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveLineChatPayInfo);
            }
            LiveLineChatInviterLiveStreamInfo liveLineChatInviterLiveStreamInfo = this.inviterLiveStreamInfo;
            if (liveLineChatInviterLiveStreamInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveLineChatInviterLiveStreamInfo);
            }
            if (!this.acceptButtonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.acceptButtonText);
            }
            if (!this.inviterLiveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.inviterLiveStreamId);
            }
            boolean z = this.isPaidChatInvite;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            long j2 = this.commentNoticeDeadlineTimestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j2);
            }
            if (!this.paidChatInviteCommentTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.paidChatInviteCommentTitle);
            }
            if (!this.paidChatInviteCommentDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.paidChatInviteCommentDesc);
            }
            if (!this.inviterDetailUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.inviterDetailUrl);
            }
            return !this.paidChatInviteCommentButtonDesc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(15, this.paidChatInviteCommentButtonDesc) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveLineChatInvite mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.inviter == null) {
                            this.inviter = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.inviter);
                        break;
                    case 16:
                        this.acceptDeadlineTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 26:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.lineChatId = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        String[] strArr = this.tag;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.tag, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.tag = strArr2;
                        break;
                    case 50:
                        if (this.payInfo == null) {
                            this.payInfo = new LiveLineChatPayInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.payInfo);
                        break;
                    case 58:
                        if (this.inviterLiveStreamInfo == null) {
                            this.inviterLiveStreamInfo = new LiveLineChatInviterLiveStreamInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.inviterLiveStreamInfo);
                        break;
                    case 66:
                        this.acceptButtonText = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.inviterLiveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 80:
                        this.isPaidChatInvite = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.commentNoticeDeadlineTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 98:
                        this.paidChatInviteCommentTitle = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        this.paidChatInviteCommentDesc = codedInputByteBufferNano.readString();
                        break;
                    case 114:
                        this.inviterDetailUrl = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        this.paidChatInviteCommentButtonDesc = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveLineChatInvite parseFrom(byte[] bArr) {
            return (SCLiveLineChatInvite) MessageNano.mergeFrom(new SCLiveLineChatInvite(), bArr);
        }

        public static SCLiveLineChatInvite parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveLineChatInvite().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveLineChatPayInfo extends MessageNano {
        private static volatile LiveLineChatPayInfo[] _emptyArray;
        public String acceptButtonTips;
        public LiveColorTextMessages.LiveColorText[] acceptNotice;
        public boolean highFans;
        public long inviteePayAmount;
        public long inviterPayAmount;
        public String payBudgetPopUpTips;
        public String payNotice;
        public int payType;
        public String payUrl;
        public boolean shopLive;

        public static LiveLineChatPayInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveLineChatPayInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveLineChatPayInfo() {
            clear();
        }

        public final LiveLineChatPayInfo clear() {
            this.acceptButtonTips = "";
            this.payNotice = "";
            this.payType = 0;
            this.inviterPayAmount = 0L;
            this.inviteePayAmount = 0L;
            this.acceptNotice = LiveColorTextMessages.LiveColorText.emptyArray();
            this.payUrl = "";
            this.highFans = false;
            this.shopLive = false;
            this.payBudgetPopUpTips = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.acceptButtonTips.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.acceptButtonTips);
            }
            if (!this.payNotice.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.payNotice);
            }
            int i = this.payType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j = this.inviterPayAmount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.inviteePayAmount;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            LiveColorTextMessages.LiveColorText[] liveColorTextArr = this.acceptNotice;
            if (liveColorTextArr != null && liveColorTextArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveColorTextMessages.LiveColorText[] liveColorTextArr2 = this.acceptNotice;
                    if (i2 >= liveColorTextArr2.length) {
                        break;
                    }
                    LiveColorTextMessages.LiveColorText liveColorText = liveColorTextArr2[i2];
                    if (liveColorText != null) {
                        codedOutputByteBufferNano.writeMessage(6, liveColorText);
                    }
                    i2++;
                }
            }
            if (!this.payUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.payUrl);
            }
            boolean z = this.highFans;
            if (z) {
                codedOutputByteBufferNano.writeBool(8, z);
            }
            boolean z2 = this.shopLive;
            if (z2) {
                codedOutputByteBufferNano.writeBool(9, z2);
            }
            if (!this.payBudgetPopUpTips.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.payBudgetPopUpTips);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.acceptButtonTips.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.acceptButtonTips);
            }
            if (!this.payNotice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.payNotice);
            }
            int i = this.payType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j = this.inviterPayAmount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.inviteePayAmount;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            LiveColorTextMessages.LiveColorText[] liveColorTextArr = this.acceptNotice;
            if (liveColorTextArr != null && liveColorTextArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveColorTextMessages.LiveColorText[] liveColorTextArr2 = this.acceptNotice;
                    if (i2 >= liveColorTextArr2.length) {
                        break;
                    }
                    LiveColorTextMessages.LiveColorText liveColorText = liveColorTextArr2[i2];
                    if (liveColorText != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveColorText);
                    }
                    i2++;
                }
            }
            if (!this.payUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.payUrl);
            }
            boolean z = this.highFans;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
            }
            boolean z2 = this.shopLive;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z2);
            }
            return !this.payBudgetPopUpTips.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.payBudgetPopUpTips) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveLineChatPayInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.acceptButtonTips = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.payNotice = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.payType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.inviterPayAmount = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.inviteePayAmount = codedInputByteBufferNano.readUInt64();
                        break;
                    case 50:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        LiveColorTextMessages.LiveColorText[] liveColorTextArr = this.acceptNotice;
                        int length = liveColorTextArr == null ? 0 : liveColorTextArr.length;
                        LiveColorTextMessages.LiveColorText[] liveColorTextArr2 = new LiveColorTextMessages.LiveColorText[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.acceptNotice, 0, liveColorTextArr2, 0, length);
                        }
                        while (length < liveColorTextArr2.length - 1) {
                            liveColorTextArr2[length] = new LiveColorTextMessages.LiveColorText();
                            codedInputByteBufferNano.readMessage(liveColorTextArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveColorTextArr2[length] = new LiveColorTextMessages.LiveColorText();
                        codedInputByteBufferNano.readMessage(liveColorTextArr2[length]);
                        this.acceptNotice = liveColorTextArr2;
                        break;
                    case 58:
                        this.payUrl = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.highFans = codedInputByteBufferNano.readBool();
                        break;
                    case 72:
                        this.shopLive = codedInputByteBufferNano.readBool();
                        break;
                    case 82:
                        this.payBudgetPopUpTips = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveLineChatPayInfo parseFrom(byte[] bArr) {
            return (LiveLineChatPayInfo) MessageNano.mergeFrom(new LiveLineChatPayInfo(), bArr);
        }

        public static LiveLineChatPayInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveLineChatPayInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveLineChatInviterLiveStreamInfo extends MessageNano {
        private static volatile LiveLineChatInviterLiveStreamInfo[] _emptyArray;
        public String caption;
        public LiveCdnNodeView[] cover;

        public static LiveLineChatInviterLiveStreamInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveLineChatInviterLiveStreamInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveLineChatInviterLiveStreamInfo() {
            clear();
        }

        public final LiveLineChatInviterLiveStreamInfo clear() {
            this.caption = "";
            this.cover = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.caption.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.caption);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.cover;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.cover;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(2, liveCdnNodeView);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.caption.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.caption);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.cover;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.cover;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveCdnNodeView);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveLineChatInviterLiveStreamInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.caption = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.cover;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.cover, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.cover = liveCdnNodeViewArr2;
                }
            }
        }

        public static LiveLineChatInviterLiveStreamInfo parseFrom(byte[] bArr) {
            return (LiveLineChatInviterLiveStreamInfo) MessageNano.mergeFrom(new LiveLineChatInviterLiveStreamInfo(), bArr);
        }

        public static LiveLineChatInviterLiveStreamInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveLineChatInviterLiveStreamInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveLineChatMatched extends MessageNano {
        private static volatile SCLiveLineChatMatched[] _emptyArray;
        public String aryaConfig;
        public String lineChatId;
        public String liveStreamId;

        public static SCLiveLineChatMatched[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveLineChatMatched[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveLineChatMatched() {
            clear();
        }

        public final SCLiveLineChatMatched clear() {
            this.lineChatId = "";
            this.aryaConfig = "";
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.lineChatId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.lineChatId);
            }
            if (!this.aryaConfig.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.aryaConfig);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.lineChatId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.lineChatId);
            }
            if (!this.aryaConfig.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.aryaConfig);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveLineChatMatched mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.lineChatId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.aryaConfig = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveLineChatMatched parseFrom(byte[] bArr) {
            return (SCLiveLineChatMatched) MessageNano.mergeFrom(new SCLiveLineChatMatched(), bArr);
        }

        public static SCLiveLineChatMatched parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveLineChatMatched().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveLineChatReady extends MessageNano {
        private static volatile SCLiveLineChatReady[] _emptyArray;
        public UserInfos.UserInfo counterpartAuthor;
        public long inviterId;
        public String lineChatId;
        public String liveStreamId;
        public int matchType;
        public String socialTips;

        public static SCLiveLineChatReady[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveLineChatReady[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveLineChatReady() {
            clear();
        }

        public final SCLiveLineChatReady clear() {
            this.lineChatId = "";
            this.counterpartAuthor = null;
            this.socialTips = "";
            this.liveStreamId = "";
            this.matchType = 0;
            this.inviterId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.lineChatId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.lineChatId);
            }
            UserInfos.UserInfo userInfo = this.counterpartAuthor;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, userInfo);
            }
            if (!this.socialTips.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.socialTips);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.liveStreamId);
            }
            int i = this.matchType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(5, i);
            }
            long j = this.inviterId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.lineChatId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.lineChatId);
            }
            UserInfos.UserInfo userInfo = this.counterpartAuthor;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
            }
            if (!this.socialTips.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.socialTips);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
            }
            int i = this.matchType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
            }
            long j = this.inviterId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveLineChatReady mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.lineChatId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.counterpartAuthor == null) {
                        this.counterpartAuthor = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.counterpartAuthor);
                } else if (tag == 26) {
                    this.socialTips = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.matchType = int32;
                            break;
                    }
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.inviterId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveLineChatReady parseFrom(byte[] bArr) {
            return (SCLiveLineChatReady) MessageNano.mergeFrom(new SCLiveLineChatReady(), bArr);
        }

        public static SCLiveLineChatReady parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveLineChatReady().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveLineChatEnd extends MessageNano {
        private static volatile SCLiveLineChatEnd[] _emptyArray;
        public int endType;
        public long inviterId;
        public String lineChatId;
        public String liveStreamId;
        public int matchType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveLineChatEndType {
            public static final int ACCEPT_TIMEOUT = 6;
            public static final int ADMIN_PUNISH = 10;
            public static final int AUTHOR_END_OPERATION = 3;
            public static final int AUTHOR_HEARTBEAT_TIMEOUT = 2;
            public static final int CLIENT_ABNORMAL_END = 5;
            public static final int INVITEE_PAY_FAIL = 9;
            public static final int INVITER_PAY_FAIL = 8;
            public static final int LIVE_STREAM_END = 1;
            public static final int READY_TIMEOUT = 4;
            public static final int REJECT_INVITE = 7;
            public static final int UNKNOWN_LINE_CHAT_END_TYPE = 0;
        }

        public static SCLiveLineChatEnd[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveLineChatEnd[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveLineChatEnd() {
            clear();
        }

        public final SCLiveLineChatEnd clear() {
            this.lineChatId = "";
            this.liveStreamId = "";
            this.endType = 0;
            this.matchType = 0;
            this.inviterId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.lineChatId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.lineChatId);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.liveStreamId);
            }
            int i = this.endType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            int i2 = this.matchType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            long j = this.inviterId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.lineChatId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.lineChatId);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
            }
            int i = this.endType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            int i2 = this.matchType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            long j = this.inviterId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveLineChatEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.lineChatId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            this.endType = int32;
                            break;
                    }
                } else if (tag == 32) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    switch (int322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.matchType = int322;
                            break;
                    }
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.inviterId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveLineChatEnd parseFrom(byte[] bArr) {
            return (SCLiveLineChatEnd) MessageNano.mergeFrom(new SCLiveLineChatEnd(), bArr);
        }

        public static SCLiveLineChatEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveLineChatEnd().mergeFrom(codedInputByteBufferNano);
        }
    }
}
