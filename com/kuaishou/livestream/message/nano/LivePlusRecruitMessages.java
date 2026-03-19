package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePlusRecruitMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecruitRoomUserCommonButtonType {
        public static final int APPLY = 1;
        public static final int BUTTON_TYPE_UNKNOWN = 0;
        public static final int IM_CONSULTING = 2;
        public static final int IS_FULL = 4;
        public static final int WILL_FULL_APPLY = 3;
    }

    public static final class LivePlusRecruitButton extends MessageNano {
        private static volatile LivePlusRecruitButton[] _emptyArray;
        public String audienceButtonJumpUrl;
        public String authorButtonJumpUrl;
        public String authorPanelJumpUrl;
        public String authorPanelPromptConfirm;
        public String authorPanelPromptContent;
        public String authorPanelPromptTitle;
        public String businessParams;
        public boolean canShow;
        public boolean canShowMoreOption;
        public boolean enableOpenRecruit;
        public String liveStreamId;
        public int looperCount;
        public String lottieUrl;
        public UserInfos.PicUrl[] recruitIcon;

        public static LivePlusRecruitButton[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePlusRecruitButton[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePlusRecruitButton() {
            clear();
        }

        public final LivePlusRecruitButton clear() {
            this.liveStreamId = "";
            this.canShow = false;
            this.authorButtonJumpUrl = "";
            this.audienceButtonJumpUrl = "";
            this.authorPanelJumpUrl = "";
            this.recruitIcon = UserInfos.PicUrl.emptyArray();
            this.canShowMoreOption = false;
            this.enableOpenRecruit = false;
            this.authorPanelPromptTitle = "";
            this.authorPanelPromptContent = "";
            this.authorPanelPromptConfirm = "";
            this.looperCount = 0;
            this.lottieUrl = "";
            this.businessParams = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            boolean z = this.canShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            if (!this.authorButtonJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.authorButtonJumpUrl);
            }
            if (!this.audienceButtonJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.audienceButtonJumpUrl);
            }
            if (!this.authorPanelJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.authorPanelJumpUrl);
            }
            UserInfos.PicUrl[] picUrlArr = this.recruitIcon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.recruitIcon;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl);
                    }
                    i++;
                }
            }
            boolean z2 = this.canShowMoreOption;
            if (z2) {
                codedOutputByteBufferNano.writeBool(7, z2);
            }
            boolean z3 = this.enableOpenRecruit;
            if (z3) {
                codedOutputByteBufferNano.writeBool(8, z3);
            }
            if (!this.authorPanelPromptTitle.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.authorPanelPromptTitle);
            }
            if (!this.authorPanelPromptContent.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.authorPanelPromptContent);
            }
            if (!this.authorPanelPromptConfirm.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.authorPanelPromptConfirm);
            }
            int i2 = this.looperCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(12, i2);
            }
            if (!this.lottieUrl.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.lottieUrl);
            }
            if (!this.businessParams.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.businessParams);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            boolean z = this.canShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            if (!this.authorButtonJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.authorButtonJumpUrl);
            }
            if (!this.audienceButtonJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.audienceButtonJumpUrl);
            }
            if (!this.authorPanelJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.authorPanelJumpUrl);
            }
            UserInfos.PicUrl[] picUrlArr = this.recruitIcon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.recruitIcon;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl);
                    }
                    i++;
                }
            }
            boolean z2 = this.canShowMoreOption;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z2);
            }
            boolean z3 = this.enableOpenRecruit;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z3);
            }
            if (!this.authorPanelPromptTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.authorPanelPromptTitle);
            }
            if (!this.authorPanelPromptContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.authorPanelPromptContent);
            }
            if (!this.authorPanelPromptConfirm.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.authorPanelPromptConfirm);
            }
            int i2 = this.looperCount;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i2);
            }
            if (!this.lottieUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.lottieUrl);
            }
            return !this.businessParams.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.businessParams) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePlusRecruitButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.canShow = codedInputByteBufferNano.readBool();
                        break;
                    case 26:
                        this.authorButtonJumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.audienceButtonJumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.authorPanelJumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        UserInfos.PicUrl[] picUrlArr = this.recruitIcon;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.recruitIcon, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.recruitIcon = picUrlArr2;
                        break;
                    case 56:
                        this.canShowMoreOption = codedInputByteBufferNano.readBool();
                        break;
                    case 64:
                        this.enableOpenRecruit = codedInputByteBufferNano.readBool();
                        break;
                    case 74:
                        this.authorPanelPromptTitle = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.authorPanelPromptContent = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.authorPanelPromptConfirm = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        this.looperCount = codedInputByteBufferNano.readInt32();
                        break;
                    case 106:
                        this.lottieUrl = codedInputByteBufferNano.readString();
                        break;
                    case 114:
                        this.businessParams = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LivePlusRecruitButton parseFrom(byte[] bArr) {
            return (LivePlusRecruitButton) MessageNano.mergeFrom(new LivePlusRecruitButton(), bArr);
        }

        public static LivePlusRecruitButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePlusRecruitButton().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LivePlusRecruitAuthorWidget extends MessageNano {
        private static volatile LivePlusRecruitAuthorWidget[] _emptyArray;
        public RecruitWidgetTopLeftAlertInfo alertInfo;
        public String applyCount;
        public RecruitWidgetButtonInfo button;
        public String guideDesc;
        public String guideTitle;
        public String jobId;
        public String jobTitle;
        public String jumpUrl;
        public String liveStreamId;
        public UserInfos.PicUrl[] picture;
        public String salary;
        public int widgetState;

        @Retention(RetentionPolicy.SOURCE)
        public @interface WidgetState {
            public static final int AUTHOR_EXPLAIN = 4;
            public static final int BEGIN = 2;
            public static final int CLOSE = 3;
            public static final int EMPTY = 1;
            public static final int UNKNOWN = 0;
        }

        public static LivePlusRecruitAuthorWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePlusRecruitAuthorWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePlusRecruitAuthorWidget() {
            clear();
        }

        public final LivePlusRecruitAuthorWidget clear() {
            this.liveStreamId = "";
            this.widgetState = 0;
            this.guideTitle = "";
            this.guideDesc = "";
            this.picture = UserInfos.PicUrl.emptyArray();
            this.jobId = "";
            this.jobTitle = "";
            this.salary = "";
            this.applyCount = "";
            this.jumpUrl = "";
            this.button = null;
            this.alertInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            int i = this.widgetState;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            if (!this.guideTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.guideTitle);
            }
            if (!this.guideDesc.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.guideDesc);
            }
            UserInfos.PicUrl[] picUrlArr = this.picture;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picture;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jobId.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.jobId);
            }
            if (!this.jobTitle.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.jobTitle);
            }
            if (!this.salary.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.salary);
            }
            if (!this.applyCount.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.applyCount);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.jumpUrl);
            }
            RecruitWidgetButtonInfo recruitWidgetButtonInfo = this.button;
            if (recruitWidgetButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(11, recruitWidgetButtonInfo);
            }
            RecruitWidgetTopLeftAlertInfo recruitWidgetTopLeftAlertInfo = this.alertInfo;
            if (recruitWidgetTopLeftAlertInfo != null) {
                codedOutputByteBufferNano.writeMessage(12, recruitWidgetTopLeftAlertInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            int i = this.widgetState;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            if (!this.guideTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.guideTitle);
            }
            if (!this.guideDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.guideDesc);
            }
            UserInfos.PicUrl[] picUrlArr = this.picture;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picture;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jobId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.jobId);
            }
            if (!this.jobTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.jobTitle);
            }
            if (!this.salary.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.salary);
            }
            if (!this.applyCount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.applyCount);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.jumpUrl);
            }
            RecruitWidgetButtonInfo recruitWidgetButtonInfo = this.button;
            if (recruitWidgetButtonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, recruitWidgetButtonInfo);
            }
            RecruitWidgetTopLeftAlertInfo recruitWidgetTopLeftAlertInfo = this.alertInfo;
            return recruitWidgetTopLeftAlertInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(12, recruitWidgetTopLeftAlertInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePlusRecruitAuthorWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                            break;
                        } else {
                            this.widgetState = int32;
                            break;
                        }
                        break;
                    case 26:
                        this.guideTitle = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.guideDesc = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        UserInfos.PicUrl[] picUrlArr = this.picture;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.picture, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.picture = picUrlArr2;
                        break;
                    case 50:
                        this.jobId = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.jobTitle = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.salary = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.applyCount = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.jumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        if (this.button == null) {
                            this.button = new RecruitWidgetButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.button);
                        break;
                    case 98:
                        if (this.alertInfo == null) {
                            this.alertInfo = new RecruitWidgetTopLeftAlertInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.alertInfo);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LivePlusRecruitAuthorWidget parseFrom(byte[] bArr) {
            return (LivePlusRecruitAuthorWidget) MessageNano.mergeFrom(new LivePlusRecruitAuthorWidget(), bArr);
        }

        public static LivePlusRecruitAuthorWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePlusRecruitAuthorWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LivePlusRecruitAudienceWidget extends MessageNano {
        private static volatile LivePlusRecruitAudienceWidget[] _emptyArray;
        public RecruitWidgetTopLeftAlertInfo alertInfo;
        public String applyUrl;
        public RecruitWidgetButtonInfo button;
        public String detailUrl;
        public boolean isMultiJob;
        public String jobId;
        public String jobTitle;
        public String liveStreamId;
        public String moreJobButtonText;
        public UserInfos.PicUrl[] picture;
        public String salary;
        public int widgetState;

        @Retention(RetentionPolicy.SOURCE)
        public @interface WidgetState {
            public static final int BEGIN = 1;
            public static final int CLOSE = 2;
            public static final int UNKNOWN = 0;
        }

        public static LivePlusRecruitAudienceWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePlusRecruitAudienceWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePlusRecruitAudienceWidget() {
            clear();
        }

        public final LivePlusRecruitAudienceWidget clear() {
            this.liveStreamId = "";
            this.widgetState = 0;
            this.picture = UserInfos.PicUrl.emptyArray();
            this.jobId = "";
            this.jobTitle = "";
            this.salary = "";
            this.detailUrl = "";
            this.applyUrl = "";
            this.moreJobButtonText = "";
            this.isMultiJob = false;
            this.button = null;
            this.alertInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            int i = this.widgetState;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.picture;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picture;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jobId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.jobId);
            }
            if (!this.jobTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.jobTitle);
            }
            if (!this.salary.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.salary);
            }
            if (!this.detailUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.detailUrl);
            }
            if (!this.applyUrl.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.applyUrl);
            }
            if (!this.moreJobButtonText.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.moreJobButtonText);
            }
            boolean z = this.isMultiJob;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            RecruitWidgetButtonInfo recruitWidgetButtonInfo = this.button;
            if (recruitWidgetButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(11, recruitWidgetButtonInfo);
            }
            RecruitWidgetTopLeftAlertInfo recruitWidgetTopLeftAlertInfo = this.alertInfo;
            if (recruitWidgetTopLeftAlertInfo != null) {
                codedOutputByteBufferNano.writeMessage(12, recruitWidgetTopLeftAlertInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            int i = this.widgetState;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.picture;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picture;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jobId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.jobId);
            }
            if (!this.jobTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.jobTitle);
            }
            if (!this.salary.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.salary);
            }
            if (!this.detailUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.detailUrl);
            }
            if (!this.applyUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.applyUrl);
            }
            if (!this.moreJobButtonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.moreJobButtonText);
            }
            boolean z = this.isMultiJob;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            RecruitWidgetButtonInfo recruitWidgetButtonInfo = this.button;
            if (recruitWidgetButtonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, recruitWidgetButtonInfo);
            }
            RecruitWidgetTopLeftAlertInfo recruitWidgetTopLeftAlertInfo = this.alertInfo;
            return recruitWidgetTopLeftAlertInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(12, recruitWidgetTopLeftAlertInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePlusRecruitAudienceWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            break;
                        } else {
                            this.widgetState = int32;
                            break;
                        }
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        UserInfos.PicUrl[] picUrlArr = this.picture;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.picture, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.picture = picUrlArr2;
                        break;
                    case 34:
                        this.jobId = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.jobTitle = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.salary = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.detailUrl = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.applyUrl = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.moreJobButtonText = codedInputByteBufferNano.readString();
                        break;
                    case 80:
                        this.isMultiJob = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        if (this.button == null) {
                            this.button = new RecruitWidgetButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.button);
                        break;
                    case 98:
                        if (this.alertInfo == null) {
                            this.alertInfo = new RecruitWidgetTopLeftAlertInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.alertInfo);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LivePlusRecruitAudienceWidget parseFrom(byte[] bArr) {
            return (LivePlusRecruitAudienceWidget) MessageNano.mergeFrom(new LivePlusRecruitAudienceWidget(), bArr);
        }

        public static LivePlusRecruitAudienceWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePlusRecruitAudienceWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RecruitWidgetTopLeftAlertInfo extends MessageNano {
        private static volatile RecruitWidgetTopLeftAlertInfo[] _emptyArray;
        public String alertText;
        public String alertTextColor;
        public String backgroundColor;
        public int status;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecruitTopLeftAlertStatus {
            public static final int EXPLAIN = 1;
            public static final int IS_FULL = 3;
            public static final int UNKNOWN = 0;
            public static final int WILL_FULL = 2;
        }

        public static RecruitWidgetTopLeftAlertInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecruitWidgetTopLeftAlertInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RecruitWidgetTopLeftAlertInfo() {
            clear();
        }

        public final RecruitWidgetTopLeftAlertInfo clear() {
            this.alertText = "";
            this.alertTextColor = "";
            this.backgroundColor = "";
            this.status = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.alertText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.alertText);
            }
            if (!this.alertTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.alertTextColor);
            }
            if (!this.backgroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.backgroundColor);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.alertText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.alertText);
            }
            if (!this.alertTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.alertTextColor);
            }
            if (!this.backgroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.backgroundColor);
            }
            int i = this.status;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RecruitWidgetTopLeftAlertInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.alertText = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.alertTextColor = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.backgroundColor = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.status = int32;
                    }
                }
            }
        }

        public static RecruitWidgetTopLeftAlertInfo parseFrom(byte[] bArr) {
            return (RecruitWidgetTopLeftAlertInfo) MessageNano.mergeFrom(new RecruitWidgetTopLeftAlertInfo(), bArr);
        }

        public static RecruitWidgetTopLeftAlertInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RecruitWidgetTopLeftAlertInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRecruitAuthorPanelCondition extends MessageNano {
        private static volatile LiveRecruitAuthorPanelCondition[] _emptyArray;
        public boolean enableExplainPanel;
        public String errorMsg;

        public static LiveRecruitAuthorPanelCondition[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRecruitAuthorPanelCondition[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRecruitAuthorPanelCondition() {
            clear();
        }

        public final LiveRecruitAuthorPanelCondition clear() {
            this.enableExplainPanel = false;
            this.errorMsg = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.enableExplainPanel;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            if (!this.errorMsg.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.errorMsg);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.enableExplainPanel;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            return !this.errorMsg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.errorMsg) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRecruitAuthorPanelCondition mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.enableExplainPanel = codedInputByteBufferNano.readBool();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.errorMsg = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveRecruitAuthorPanelCondition parseFrom(byte[] bArr) {
            return (LiveRecruitAuthorPanelCondition) MessageNano.mergeFrom(new LiveRecruitAuthorPanelCondition(), bArr);
        }

        public static LiveRecruitAuthorPanelCondition parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRecruitAuthorPanelCondition().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRecruitPanelDisplay extends MessageNano {
        private static volatile LiveRecruitPanelDisplay[] _emptyArray;
        public LiveRecruitPanelButton[] audienceButtonList;
        public LiveRecruitPanelButton[] authorButtonList;
        public int authorErrorCode;
        public String authorErrorMsg;
        public boolean isMultiJob;
        public String jobId;
        public String jobImageJumpUrl;
        public UserInfos.PicUrl[] jobInfoImageUrl;
        public String moreJobButtonText;
        public String moreJobButtonUrl;
        public String templateId;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveRecruitPanelDisplayErrorCode {
            public static final int OTHER = 2;
            public static final int SUCCESS = 1;
            public static final int UNKNOWN = 0;
        }

        public static LiveRecruitPanelDisplay[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRecruitPanelDisplay[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRecruitPanelDisplay() {
            clear();
        }

        public final LiveRecruitPanelDisplay clear() {
            this.authorErrorCode = 0;
            this.authorErrorMsg = "";
            this.jobInfoImageUrl = UserInfos.PicUrl.emptyArray();
            this.authorButtonList = LiveRecruitPanelButton.emptyArray();
            this.audienceButtonList = LiveRecruitPanelButton.emptyArray();
            this.jobImageJumpUrl = "";
            this.jobId = "";
            this.templateId = "";
            this.moreJobButtonText = "";
            this.moreJobButtonUrl = "";
            this.isMultiJob = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.authorErrorCode;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.authorErrorMsg.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.authorErrorMsg);
            }
            UserInfos.PicUrl[] picUrlArr = this.jobInfoImageUrl;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.jobInfoImageUrl;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i3++;
                }
            }
            LiveRecruitPanelButton[] liveRecruitPanelButtonArr = this.authorButtonList;
            if (liveRecruitPanelButtonArr != null && liveRecruitPanelButtonArr.length > 0) {
                int i4 = 0;
                while (true) {
                    LiveRecruitPanelButton[] liveRecruitPanelButtonArr2 = this.authorButtonList;
                    if (i4 >= liveRecruitPanelButtonArr2.length) {
                        break;
                    }
                    LiveRecruitPanelButton liveRecruitPanelButton = liveRecruitPanelButtonArr2[i4];
                    if (liveRecruitPanelButton != null) {
                        codedOutputByteBufferNano.writeMessage(4, liveRecruitPanelButton);
                    }
                    i4++;
                }
            }
            LiveRecruitPanelButton[] liveRecruitPanelButtonArr3 = this.audienceButtonList;
            if (liveRecruitPanelButtonArr3 != null && liveRecruitPanelButtonArr3.length > 0) {
                while (true) {
                    LiveRecruitPanelButton[] liveRecruitPanelButtonArr4 = this.audienceButtonList;
                    if (i2 >= liveRecruitPanelButtonArr4.length) {
                        break;
                    }
                    LiveRecruitPanelButton liveRecruitPanelButton2 = liveRecruitPanelButtonArr4[i2];
                    if (liveRecruitPanelButton2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, liveRecruitPanelButton2);
                    }
                    i2++;
                }
            }
            if (!this.jobImageJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.jobImageJumpUrl);
            }
            if (!this.jobId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.jobId);
            }
            if (!this.templateId.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.templateId);
            }
            if (!this.moreJobButtonText.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.moreJobButtonText);
            }
            if (!this.moreJobButtonUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.moreJobButtonUrl);
            }
            boolean z = this.isMultiJob;
            if (z) {
                codedOutputByteBufferNano.writeBool(11, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.authorErrorCode;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.authorErrorMsg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.authorErrorMsg);
            }
            UserInfos.PicUrl[] picUrlArr = this.jobInfoImageUrl;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.jobInfoImageUrl;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            LiveRecruitPanelButton[] liveRecruitPanelButtonArr = this.authorButtonList;
            if (liveRecruitPanelButtonArr != null && liveRecruitPanelButtonArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    LiveRecruitPanelButton[] liveRecruitPanelButtonArr2 = this.authorButtonList;
                    if (i4 >= liveRecruitPanelButtonArr2.length) {
                        break;
                    }
                    LiveRecruitPanelButton liveRecruitPanelButton = liveRecruitPanelButtonArr2[i4];
                    if (liveRecruitPanelButton != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(4, liveRecruitPanelButton);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            LiveRecruitPanelButton[] liveRecruitPanelButtonArr3 = this.audienceButtonList;
            if (liveRecruitPanelButtonArr3 != null && liveRecruitPanelButtonArr3.length > 0) {
                while (true) {
                    LiveRecruitPanelButton[] liveRecruitPanelButtonArr4 = this.audienceButtonList;
                    if (i2 >= liveRecruitPanelButtonArr4.length) {
                        break;
                    }
                    LiveRecruitPanelButton liveRecruitPanelButton2 = liveRecruitPanelButtonArr4[i2];
                    if (liveRecruitPanelButton2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveRecruitPanelButton2);
                    }
                    i2++;
                }
            }
            if (!this.jobImageJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.jobImageJumpUrl);
            }
            if (!this.jobId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.jobId);
            }
            if (!this.templateId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.templateId);
            }
            if (!this.moreJobButtonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.moreJobButtonText);
            }
            if (!this.moreJobButtonUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.moreJobButtonUrl);
            }
            boolean z = this.isMultiJob;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(11, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRecruitPanelDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.authorErrorCode = codedInputByteBufferNano.readUInt32();
                        break;
                    case 18:
                        this.authorErrorMsg = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        UserInfos.PicUrl[] picUrlArr = this.jobInfoImageUrl;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.jobInfoImageUrl, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.jobInfoImageUrl = picUrlArr2;
                        break;
                    case 34:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        LiveRecruitPanelButton[] liveRecruitPanelButtonArr = this.authorButtonList;
                        int length2 = liveRecruitPanelButtonArr == null ? 0 : liveRecruitPanelButtonArr.length;
                        LiveRecruitPanelButton[] liveRecruitPanelButtonArr2 = new LiveRecruitPanelButton[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.authorButtonList, 0, liveRecruitPanelButtonArr2, 0, length2);
                        }
                        while (length2 < liveRecruitPanelButtonArr2.length - 1) {
                            liveRecruitPanelButtonArr2[length2] = new LiveRecruitPanelButton();
                            codedInputByteBufferNano.readMessage(liveRecruitPanelButtonArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        liveRecruitPanelButtonArr2[length2] = new LiveRecruitPanelButton();
                        codedInputByteBufferNano.readMessage(liveRecruitPanelButtonArr2[length2]);
                        this.authorButtonList = liveRecruitPanelButtonArr2;
                        break;
                    case 42:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        LiveRecruitPanelButton[] liveRecruitPanelButtonArr3 = this.audienceButtonList;
                        int length3 = liveRecruitPanelButtonArr3 == null ? 0 : liveRecruitPanelButtonArr3.length;
                        LiveRecruitPanelButton[] liveRecruitPanelButtonArr4 = new LiveRecruitPanelButton[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.audienceButtonList, 0, liveRecruitPanelButtonArr4, 0, length3);
                        }
                        while (length3 < liveRecruitPanelButtonArr4.length - 1) {
                            liveRecruitPanelButtonArr4[length3] = new LiveRecruitPanelButton();
                            codedInputByteBufferNano.readMessage(liveRecruitPanelButtonArr4[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        liveRecruitPanelButtonArr4[length3] = new LiveRecruitPanelButton();
                        codedInputByteBufferNano.readMessage(liveRecruitPanelButtonArr4[length3]);
                        this.audienceButtonList = liveRecruitPanelButtonArr4;
                        break;
                    case 50:
                        this.jobImageJumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.jobId = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.templateId = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.moreJobButtonText = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.moreJobButtonUrl = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        this.isMultiJob = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveRecruitPanelDisplay parseFrom(byte[] bArr) {
            return (LiveRecruitPanelDisplay) MessageNano.mergeFrom(new LiveRecruitPanelDisplay(), bArr);
        }

        public static LiveRecruitPanelDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRecruitPanelDisplay().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRecruitPanelButton extends MessageNano {
        private static volatile LiveRecruitPanelButton[] _emptyArray;
        public String borderColor;
        public String jumpUrl;
        public String text;
        public String textColor;
        public int type;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ButtonType {
            public static final int APPLY = 3;
            public static final int EDIT_JOB = 1;
            public static final int IM_CONSULTING = 4;
            public static final int IS_FULL = 6;
            public static final int SWITCH_JOB = 2;
            public static final int UNKNOWN = 0;
            public static final int WILL_FULL_APPLY = 5;
        }

        public static LiveRecruitPanelButton[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRecruitPanelButton[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRecruitPanelButton() {
            clear();
        }

        public final LiveRecruitPanelButton clear() {
            this.type = 0;
            this.text = "";
            this.jumpUrl = "";
            this.textColor = "";
            this.borderColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.text);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.jumpUrl);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.textColor);
            }
            if (!this.borderColor.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.borderColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.textColor);
            }
            return !this.borderColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.borderColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRecruitPanelButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.type = int32;
                            break;
                    }
                } else if (tag == 18) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.textColor = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.borderColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveRecruitPanelButton parseFrom(byte[] bArr) {
            return (LiveRecruitPanelButton) MessageNano.mergeFrom(new LiveRecruitPanelButton(), bArr);
        }

        public static LiveRecruitPanelButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRecruitPanelButton().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRecruitAudiencePanelClose extends MessageNano {
        private static volatile LiveRecruitAudiencePanelClose[] _emptyArray;
        public String liveStreamId;

        public static LiveRecruitAudiencePanelClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRecruitAudiencePanelClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRecruitAudiencePanelClose() {
            clear();
        }

        public final LiveRecruitAudiencePanelClose clear() {
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRecruitAudiencePanelClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveRecruitAudiencePanelClose parseFrom(byte[] bArr) {
            return (LiveRecruitAudiencePanelClose) MessageNano.mergeFrom(new LiveRecruitAudiencePanelClose(), bArr);
        }

        public static LiveRecruitAudiencePanelClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRecruitAudiencePanelClose().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RecruitWidgetButtonInfo extends MessageNano {
        private static volatile RecruitWidgetButtonInfo[] _emptyArray;
        public String backgroundColor;
        public String buttonText;
        public String buttonTextColor;
        public String buttonUrl;
        public int type;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecruitWidgetButtonType {
            public static final int APPLY_PANEL = 1;
            public static final int IMMEDIATELY_ADD = 4;
            public static final int IM_CONSULTING = 5;
            public static final int IS_FULL = 6;
            public static final int SELECT_JOB = 3;
            public static final int SWITCH_JOB = 2;
            public static final int UNKNOWN = 0;
        }

        public static RecruitWidgetButtonInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecruitWidgetButtonInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RecruitWidgetButtonInfo() {
            clear();
        }

        public final RecruitWidgetButtonInfo clear() {
            this.buttonText = "";
            this.buttonUrl = "";
            this.type = 0;
            this.backgroundColor = "";
            this.buttonTextColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.buttonText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.buttonText);
            }
            if (!this.buttonUrl.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.buttonUrl);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!this.backgroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.backgroundColor);
            }
            if (!this.buttonTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.buttonTextColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.buttonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.buttonText);
            }
            if (!this.buttonUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.buttonUrl);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!this.backgroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.backgroundColor);
            }
            return !this.buttonTextColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.buttonTextColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RecruitWidgetButtonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.buttonText = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.buttonUrl = codedInputByteBufferNano.readString();
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
                            this.type = int32;
                            break;
                    }
                } else if (tag == 34) {
                    this.backgroundColor = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.buttonTextColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RecruitWidgetButtonInfo parseFrom(byte[] bArr) {
            return (RecruitWidgetButtonInfo) MessageNano.mergeFrom(new RecruitWidgetButtonInfo(), bArr);
        }

        public static RecruitWidgetButtonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RecruitWidgetButtonInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LivePlusRecruitCommonWidgetCloseMessage extends MessageNano {
        private static volatile LivePlusRecruitCommonWidgetCloseMessage[] _emptyArray;
        public int widgetType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecruitCommonWidgetType {
            public static final int QUESTIONNAIRE_TEMP_INDICATOR = 1;
            public static final int UNKNOWN = 0;
        }

        public static LivePlusRecruitCommonWidgetCloseMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePlusRecruitCommonWidgetCloseMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePlusRecruitCommonWidgetCloseMessage() {
            clear();
        }

        public final LivePlusRecruitCommonWidgetCloseMessage clear() {
            this.widgetType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.widgetType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.widgetType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePlusRecruitCommonWidgetCloseMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.widgetType = int32;
                    }
                }
            }
        }

        public static LivePlusRecruitCommonWidgetCloseMessage parseFrom(byte[] bArr) {
            return (LivePlusRecruitCommonWidgetCloseMessage) MessageNano.mergeFrom(new LivePlusRecruitCommonWidgetCloseMessage(), bArr);
        }

        public static LivePlusRecruitCommonWidgetCloseMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePlusRecruitCommonWidgetCloseMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RecruitExplainPanelDisplay extends MessageNano {
        private static volatile RecruitExplainPanelDisplay[] _emptyArray;
        public int status;
        public String templateData;
        public String templateId;
        public long templateVersionCode;
        public String viewKey;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecruitExplainPanelDisplayStatus {
            public static final int CLOSE = 2;
            public static final int OPEN = 1;
            public static final int UNKNOWN = 0;
        }

        public static RecruitExplainPanelDisplay[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecruitExplainPanelDisplay[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RecruitExplainPanelDisplay() {
            clear();
        }

        public final RecruitExplainPanelDisplay clear() {
            this.templateId = "";
            this.viewKey = "";
            this.templateVersionCode = 0L;
            this.templateData = "";
            this.status = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.templateId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.templateId);
            }
            if (!this.viewKey.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.viewKey);
            }
            long j = this.templateVersionCode;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            if (!this.templateData.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.templateData);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(5, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.templateId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.templateId);
            }
            if (!this.viewKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.viewKey);
            }
            long j = this.templateVersionCode;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
            }
            if (!this.templateData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.templateData);
            }
            int i = this.status;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RecruitExplainPanelDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.templateId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.viewKey = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.templateVersionCode = codedInputByteBufferNano.readInt64();
                } else if (tag == 34) {
                    this.templateData = codedInputByteBufferNano.readString();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.status = int32;
                    }
                }
            }
        }

        public static RecruitExplainPanelDisplay parseFrom(byte[] bArr) {
            return (RecruitExplainPanelDisplay) MessageNano.mergeFrom(new RecruitExplainPanelDisplay(), bArr);
        }

        public static RecruitExplainPanelDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RecruitExplainPanelDisplay().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RecruitRoomCommonTKSignal extends MessageNano {
        private static volatile RecruitRoomCommonTKSignal[] _emptyArray;
        public int status;
        public String templateData;
        public String templateId;
        public long templateVersionCode;
        public String viewKey;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecruitRoomCommonTKSignalStatus {
            public static final int CLOSE = 2;
            public static final int OPEN = 1;
            public static final int UNKNOWN = 0;
        }

        public static RecruitRoomCommonTKSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RecruitRoomCommonTKSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RecruitRoomCommonTKSignal() {
            clear();
        }

        public final RecruitRoomCommonTKSignal clear() {
            this.templateId = "";
            this.viewKey = "";
            this.templateVersionCode = 0L;
            this.templateData = "";
            this.status = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.templateId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.templateId);
            }
            if (!this.viewKey.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.viewKey);
            }
            long j = this.templateVersionCode;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            if (!this.templateData.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.templateData);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(5, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.templateId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.templateId);
            }
            if (!this.viewKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.viewKey);
            }
            long j = this.templateVersionCode;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
            }
            if (!this.templateData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.templateData);
            }
            int i = this.status;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RecruitRoomCommonTKSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.templateId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.viewKey = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.templateVersionCode = codedInputByteBufferNano.readInt64();
                } else if (tag == 34) {
                    this.templateData = codedInputByteBufferNano.readString();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.status = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static RecruitRoomCommonTKSignal parseFrom(byte[] bArr) {
            return (RecruitRoomCommonTKSignal) MessageNano.mergeFrom(new RecruitRoomCommonTKSignal(), bArr);
        }

        public static RecruitRoomCommonTKSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RecruitRoomCommonTKSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
