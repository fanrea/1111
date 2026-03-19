package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.SocketMessages;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveLocalLifeExplainCardSignal extends MessageNano {
    private static volatile SCLiveLocalLifeExplainCardSignal[] _emptyArray;
    public String actionUrl;
    public String anchorUrl;
    public String audienceUrl;
    public String authorRole;
    public int availableTimes;
    public String bizDataId;
    public String bizId;
    public String bizType;
    public long breakUpTime;
    public String bundleInfo;
    public String buttonText;
    public String calendarWightUrl;
    public boolean closeAudienceExplainForever;
    public String encryptionLiveStreamId;
    public String ext;
    public String extParams;
    public UserInfos.PicUrl[] icon;
    public ItemBizTagChannel itemBizTagChannel;
    public int itemTypeCode;
    public String marketingCampaignJson;
    public String originPrice;
    public String priceText;
    public String productId;
    public long promotionId;
    public long promotionStageIdx;
    public SCLiveLocalLifeExplainCardPromotionStageInfo[] promotionStages;
    public long promotionTemplateId;
    public int queryApiType;
    public long sales;
    public long salesLimit;
    public long serverTime;
    public boolean showAudienceInit;
    public boolean showClose;
    public IntroducingHide showHideController;
    public int signalType;
    public String singlePrice;
    public String source;
    public boolean stateButtonClickStatus;
    public String stateText;
    public String subTitle;
    public String suffixText;
    public String symbol;
    public ItemBizTag[] tagList;
    public String title;
    public TkInfo tkInfo;
    public UserInfos.PicUrl[] topLeftIcon;
    public UserInfos.PicUrl[] topLeftIconSecond;
    public int topLeftStyle;
    public String topLeftTips;
    public String topLeftTipsSecond;
    public String traceTag;
    public Map<String, String> trackingParamMap;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SignalType {
        public static final int DELETE = 0;
        public static final int SHOW = 1;
        public static final int SHOW_WHITE_BOARD = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TLStyle {
        public static final int EXPLAINING = 0;
        public static final int RUSH = 1;
    }

    public static SCLiveLocalLifeExplainCardSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveLocalLifeExplainCardSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveLocalLifeExplainCardSignal() {
        clear();
    }

    public final SCLiveLocalLifeExplainCardSignal clear() {
        this.signalType = 0;
        this.title = "";
        this.icon = UserInfos.PicUrl.emptyArray();
        this.actionUrl = "";
        this.buttonText = "";
        this.topLeftTips = "";
        this.topLeftIcon = UserInfos.PicUrl.emptyArray();
        this.showClose = false;
        this.bundleInfo = "";
        this.ext = "";
        this.bizType = "";
        this.subTitle = "";
        this.symbol = "";
        this.productId = "";
        this.closeAudienceExplainForever = false;
        this.bizId = "";
        this.priceText = "";
        this.stateText = "";
        this.source = "";
        this.anchorUrl = "";
        this.audienceUrl = "";
        this.topLeftTipsSecond = "";
        this.topLeftIconSecond = UserInfos.PicUrl.emptyArray();
        this.topLeftStyle = 0;
        this.queryApiType = 0;
        this.promotionStages = SCLiveLocalLifeExplainCardPromotionStageInfo.emptyArray();
        this.promotionStageIdx = 0L;
        this.bizDataId = "";
        this.authorRole = "";
        this.promotionId = 0L;
        this.promotionTemplateId = 0L;
        this.traceTag = "";
        this.tagList = ItemBizTag.emptyArray();
        this.breakUpTime = 0L;
        this.stateButtonClickStatus = false;
        this.itemBizTagChannel = null;
        this.trackingParamMap = null;
        this.showAudienceInit = false;
        this.tkInfo = null;
        this.serverTime = 0L;
        this.availableTimes = 0;
        this.encryptionLiveStreamId = "";
        this.calendarWightUrl = "";
        this.itemTypeCode = 0;
        this.suffixText = "";
        this.marketingCampaignJson = "";
        this.sales = 0L;
        this.salesLimit = 0L;
        this.originPrice = "";
        this.singlePrice = "";
        this.extParams = "";
        this.showHideController = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.signalType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.title);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
        if (!this.actionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.actionUrl);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.buttonText);
        }
        if (!this.topLeftTips.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.topLeftTips);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.topLeftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.topLeftIcon;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl2);
                }
                i4++;
            }
        }
        boolean z = this.showClose;
        if (z) {
            codedOutputByteBufferNano.writeBool(8, z);
        }
        if (!this.bundleInfo.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.bundleInfo);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.ext);
        }
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.bizType);
        }
        if (!this.subTitle.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.subTitle);
        }
        if (!this.symbol.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.symbol);
        }
        if (!this.productId.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.productId);
        }
        boolean z2 = this.closeAudienceExplainForever;
        if (z2) {
            codedOutputByteBufferNano.writeBool(15, z2);
        }
        if (!this.bizId.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.bizId);
        }
        if (!this.priceText.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.priceText);
        }
        if (!this.stateText.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.stateText);
        }
        if (!this.source.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.source);
        }
        if (!this.anchorUrl.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.anchorUrl);
        }
        if (!this.audienceUrl.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.audienceUrl);
        }
        if (!this.topLeftTipsSecond.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.topLeftTipsSecond);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.topLeftIconSecond;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int i5 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.topLeftIconSecond;
                if (i5 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i5];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(23, picUrl3);
                }
                i5++;
            }
        }
        int i6 = this.topLeftStyle;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(24, i6);
        }
        int i7 = this.queryApiType;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeInt32(29, i7);
        }
        SCLiveLocalLifeExplainCardPromotionStageInfo[] sCLiveLocalLifeExplainCardPromotionStageInfoArr = this.promotionStages;
        if (sCLiveLocalLifeExplainCardPromotionStageInfoArr != null && sCLiveLocalLifeExplainCardPromotionStageInfoArr.length > 0) {
            int i8 = 0;
            while (true) {
                SCLiveLocalLifeExplainCardPromotionStageInfo[] sCLiveLocalLifeExplainCardPromotionStageInfoArr2 = this.promotionStages;
                if (i8 >= sCLiveLocalLifeExplainCardPromotionStageInfoArr2.length) {
                    break;
                }
                SCLiveLocalLifeExplainCardPromotionStageInfo sCLiveLocalLifeExplainCardPromotionStageInfo = sCLiveLocalLifeExplainCardPromotionStageInfoArr2[i8];
                if (sCLiveLocalLifeExplainCardPromotionStageInfo != null) {
                    codedOutputByteBufferNano.writeMessage(30, sCLiveLocalLifeExplainCardPromotionStageInfo);
                }
                i8++;
            }
        }
        long j = this.promotionStageIdx;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(31, j);
        }
        if (!this.bizDataId.equals("")) {
            codedOutputByteBufferNano.writeString(32, this.bizDataId);
        }
        if (!this.authorRole.equals("")) {
            codedOutputByteBufferNano.writeString(33, this.authorRole);
        }
        long j2 = this.promotionId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(34, j2);
        }
        long j3 = this.promotionTemplateId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(35, j3);
        }
        if (!this.traceTag.equals("")) {
            codedOutputByteBufferNano.writeString(36, this.traceTag);
        }
        ItemBizTag[] itemBizTagArr = this.tagList;
        if (itemBizTagArr != null && itemBizTagArr.length > 0) {
            while (true) {
                ItemBizTag[] itemBizTagArr2 = this.tagList;
                if (i2 >= itemBizTagArr2.length) {
                    break;
                }
                ItemBizTag itemBizTag = itemBizTagArr2[i2];
                if (itemBizTag != null) {
                    codedOutputByteBufferNano.writeMessage(37, itemBizTag);
                }
                i2++;
            }
        }
        long j4 = this.breakUpTime;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(38, j4);
        }
        boolean z3 = this.stateButtonClickStatus;
        if (z3) {
            codedOutputByteBufferNano.writeBool(39, z3);
        }
        ItemBizTagChannel itemBizTagChannel = this.itemBizTagChannel;
        if (itemBizTagChannel != null) {
            codedOutputByteBufferNano.writeMessage(40, itemBizTagChannel);
        }
        Map<String, String> map = this.trackingParamMap;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 41, 9, 9);
        }
        boolean z4 = this.showAudienceInit;
        if (z4) {
            codedOutputByteBufferNano.writeBool(42, z4);
        }
        TkInfo tkInfo = this.tkInfo;
        if (tkInfo != null) {
            codedOutputByteBufferNano.writeMessage(43, tkInfo);
        }
        long j5 = this.serverTime;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(44, j5);
        }
        int i9 = this.availableTimes;
        if (i9 != 0) {
            codedOutputByteBufferNano.writeUInt32(45, i9);
        }
        if (!this.encryptionLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(46, this.encryptionLiveStreamId);
        }
        if (!this.calendarWightUrl.equals("")) {
            codedOutputByteBufferNano.writeString(47, this.calendarWightUrl);
        }
        int i10 = this.itemTypeCode;
        if (i10 != 0) {
            codedOutputByteBufferNano.writeUInt32(48, i10);
        }
        if (!this.suffixText.equals("")) {
            codedOutputByteBufferNano.writeString(49, this.suffixText);
        }
        if (!this.marketingCampaignJson.equals("")) {
            codedOutputByteBufferNano.writeString(50, this.marketingCampaignJson);
        }
        long j6 = this.sales;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(51, j6);
        }
        long j7 = this.salesLimit;
        if (j7 != 0) {
            codedOutputByteBufferNano.writeUInt64(52, j7);
        }
        if (!this.originPrice.equals("")) {
            codedOutputByteBufferNano.writeString(53, this.originPrice);
        }
        if (!this.singlePrice.equals("")) {
            codedOutputByteBufferNano.writeString(54, this.singlePrice);
        }
        if (!this.extParams.equals("")) {
            codedOutputByteBufferNano.writeString(55, this.extParams);
        }
        IntroducingHide introducingHide = this.showHideController;
        if (introducingHide != null) {
            codedOutputByteBufferNano.writeMessage(56, introducingHide);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.signalType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
        if (!this.actionUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.actionUrl);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.buttonText);
        }
        if (!this.topLeftTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.topLeftTips);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.topLeftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.topLeftIcon;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(7, picUrl2);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        boolean z = this.showClose;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
        }
        if (!this.bundleInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.bundleInfo);
        }
        if (!this.ext.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.ext);
        }
        if (!this.bizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.bizType);
        }
        if (!this.subTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.subTitle);
        }
        if (!this.symbol.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.symbol);
        }
        if (!this.productId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.productId);
        }
        boolean z2 = this.closeAudienceExplainForever;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z2);
        }
        if (!this.bizId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.bizId);
        }
        if (!this.priceText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.priceText);
        }
        if (!this.stateText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.stateText);
        }
        if (!this.source.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.source);
        }
        if (!this.anchorUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.anchorUrl);
        }
        if (!this.audienceUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.audienceUrl);
        }
        if (!this.topLeftTipsSecond.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.topLeftTipsSecond);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.topLeftIconSecond;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i5 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.topLeftIconSecond;
                if (i5 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i5];
                if (picUrl3 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(23, picUrl3);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        int i6 = this.topLeftStyle;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(24, i6);
        }
        int i7 = this.queryApiType;
        if (i7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(29, i7);
        }
        SCLiveLocalLifeExplainCardPromotionStageInfo[] sCLiveLocalLifeExplainCardPromotionStageInfoArr = this.promotionStages;
        if (sCLiveLocalLifeExplainCardPromotionStageInfoArr != null && sCLiveLocalLifeExplainCardPromotionStageInfoArr.length > 0) {
            int iComputeMessageSize4 = iComputeSerializedSize;
            int i8 = 0;
            while (true) {
                SCLiveLocalLifeExplainCardPromotionStageInfo[] sCLiveLocalLifeExplainCardPromotionStageInfoArr2 = this.promotionStages;
                if (i8 >= sCLiveLocalLifeExplainCardPromotionStageInfoArr2.length) {
                    break;
                }
                SCLiveLocalLifeExplainCardPromotionStageInfo sCLiveLocalLifeExplainCardPromotionStageInfo = sCLiveLocalLifeExplainCardPromotionStageInfoArr2[i8];
                if (sCLiveLocalLifeExplainCardPromotionStageInfo != null) {
                    iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(30, sCLiveLocalLifeExplainCardPromotionStageInfo);
                }
                i8++;
            }
            iComputeSerializedSize = iComputeMessageSize4;
        }
        long j = this.promotionStageIdx;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(31, j);
        }
        if (!this.bizDataId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(32, this.bizDataId);
        }
        if (!this.authorRole.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(33, this.authorRole);
        }
        long j2 = this.promotionId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(34, j2);
        }
        long j3 = this.promotionTemplateId;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(35, j3);
        }
        if (!this.traceTag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(36, this.traceTag);
        }
        ItemBizTag[] itemBizTagArr = this.tagList;
        if (itemBizTagArr != null && itemBizTagArr.length > 0) {
            while (true) {
                ItemBizTag[] itemBizTagArr2 = this.tagList;
                if (i2 >= itemBizTagArr2.length) {
                    break;
                }
                ItemBizTag itemBizTag = itemBizTagArr2[i2];
                if (itemBizTag != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(37, itemBizTag);
                }
                i2++;
            }
        }
        long j4 = this.breakUpTime;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(38, j4);
        }
        boolean z3 = this.stateButtonClickStatus;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(39, z3);
        }
        ItemBizTagChannel itemBizTagChannel = this.itemBizTagChannel;
        if (itemBizTagChannel != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(40, itemBizTagChannel);
        }
        Map<String, String> map = this.trackingParamMap;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 41, 9, 9);
        }
        boolean z4 = this.showAudienceInit;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(42, z4);
        }
        TkInfo tkInfo = this.tkInfo;
        if (tkInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(43, tkInfo);
        }
        long j5 = this.serverTime;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(44, j5);
        }
        int i9 = this.availableTimes;
        if (i9 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(45, i9);
        }
        if (!this.encryptionLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(46, this.encryptionLiveStreamId);
        }
        if (!this.calendarWightUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(47, this.calendarWightUrl);
        }
        int i10 = this.itemTypeCode;
        if (i10 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(48, i10);
        }
        if (!this.suffixText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(49, this.suffixText);
        }
        if (!this.marketingCampaignJson.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(50, this.marketingCampaignJson);
        }
        long j6 = this.sales;
        if (j6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(51, j6);
        }
        long j7 = this.salesLimit;
        if (j7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(52, j7);
        }
        if (!this.originPrice.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(53, this.originPrice);
        }
        if (!this.singlePrice.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(54, this.singlePrice);
        }
        if (!this.extParams.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(55, this.extParams);
        }
        IntroducingHide introducingHide = this.showHideController;
        return introducingHide != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(56, introducingHide) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveLocalLifeExplainCardSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.signalType = int32;
                        break;
                    }
                case 18:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.icon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.icon = picUrlArr2;
                    break;
                case 34:
                    this.actionUrl = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.buttonText = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.topLeftTips = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr3 = this.topLeftIcon;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.topLeftIcon, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.topLeftIcon = picUrlArr4;
                    break;
                case 64:
                    this.showClose = codedInputByteBufferNano.readBool();
                    break;
                case 74:
                    this.bundleInfo = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.ext = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.bizType = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.subTitle = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.symbol = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.productId = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.closeAudienceExplainForever = codedInputByteBufferNano.readBool();
                    break;
                case 130:
                    this.bizId = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.priceText = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.stateText = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.source = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.anchorUrl = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.audienceUrl = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.topLeftTipsSecond = codedInputByteBufferNano.readString();
                    break;
                case 186:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                    UserInfos.PicUrl[] picUrlArr5 = this.topLeftIconSecond;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.topLeftIconSecond, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.topLeftIconSecond = picUrlArr6;
                    break;
                case 192:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1) {
                        break;
                    } else {
                        this.topLeftStyle = int322;
                        break;
                    }
                    break;
                case 232:
                    this.queryApiType = codedInputByteBufferNano.readInt32();
                    break;
                case 242:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 242);
                    SCLiveLocalLifeExplainCardPromotionStageInfo[] sCLiveLocalLifeExplainCardPromotionStageInfoArr = this.promotionStages;
                    int length4 = sCLiveLocalLifeExplainCardPromotionStageInfoArr == null ? 0 : sCLiveLocalLifeExplainCardPromotionStageInfoArr.length;
                    SCLiveLocalLifeExplainCardPromotionStageInfo[] sCLiveLocalLifeExplainCardPromotionStageInfoArr2 = new SCLiveLocalLifeExplainCardPromotionStageInfo[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.promotionStages, 0, sCLiveLocalLifeExplainCardPromotionStageInfoArr2, 0, length4);
                    }
                    while (length4 < sCLiveLocalLifeExplainCardPromotionStageInfoArr2.length - 1) {
                        sCLiveLocalLifeExplainCardPromotionStageInfoArr2[length4] = new SCLiveLocalLifeExplainCardPromotionStageInfo();
                        codedInputByteBufferNano.readMessage(sCLiveLocalLifeExplainCardPromotionStageInfoArr2[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    sCLiveLocalLifeExplainCardPromotionStageInfoArr2[length4] = new SCLiveLocalLifeExplainCardPromotionStageInfo();
                    codedInputByteBufferNano.readMessage(sCLiveLocalLifeExplainCardPromotionStageInfoArr2[length4]);
                    this.promotionStages = sCLiveLocalLifeExplainCardPromotionStageInfoArr2;
                    break;
                case 248:
                    this.promotionStageIdx = codedInputByteBufferNano.readUInt64();
                    break;
                case 258:
                    this.bizDataId = codedInputByteBufferNano.readString();
                    break;
                case 266:
                    this.authorRole = codedInputByteBufferNano.readString();
                    break;
                case 272:
                    this.promotionId = codedInputByteBufferNano.readUInt64();
                    break;
                case 280:
                    this.promotionTemplateId = codedInputByteBufferNano.readUInt64();
                    break;
                case 290:
                    this.traceTag = codedInputByteBufferNano.readString();
                    break;
                case 298:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 298);
                    ItemBizTag[] itemBizTagArr = this.tagList;
                    int length5 = itemBizTagArr == null ? 0 : itemBizTagArr.length;
                    ItemBizTag[] itemBizTagArr2 = new ItemBizTag[repeatedFieldArrayLength5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.tagList, 0, itemBizTagArr2, 0, length5);
                    }
                    while (length5 < itemBizTagArr2.length - 1) {
                        itemBizTagArr2[length5] = new ItemBizTag();
                        codedInputByteBufferNano.readMessage(itemBizTagArr2[length5]);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    itemBizTagArr2[length5] = new ItemBizTag();
                    codedInputByteBufferNano.readMessage(itemBizTagArr2[length5]);
                    this.tagList = itemBizTagArr2;
                    break;
                case 304:
                    this.breakUpTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 312:
                    this.stateButtonClickStatus = codedInputByteBufferNano.readBool();
                    break;
                case 322:
                    if (this.itemBizTagChannel == null) {
                        this.itemBizTagChannel = new ItemBizTagChannel();
                    }
                    codedInputByteBufferNano.readMessage(this.itemBizTagChannel);
                    break;
                case 330:
                    this.trackingParamMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.trackingParamMap, mapFactory, 9, 9, null, 10, 18);
                    break;
                case 336:
                    this.showAudienceInit = codedInputByteBufferNano.readBool();
                    break;
                case 346:
                    if (this.tkInfo == null) {
                        this.tkInfo = new TkInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.tkInfo);
                    break;
                case 352:
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 360:
                    this.availableTimes = codedInputByteBufferNano.readUInt32();
                    break;
                case 370:
                    this.encryptionLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 378:
                    this.calendarWightUrl = codedInputByteBufferNano.readString();
                    break;
                case 384:
                    this.itemTypeCode = codedInputByteBufferNano.readUInt32();
                    break;
                case 394:
                    this.suffixText = codedInputByteBufferNano.readString();
                    break;
                case 402:
                    this.marketingCampaignJson = codedInputByteBufferNano.readString();
                    break;
                case 408:
                    this.sales = codedInputByteBufferNano.readUInt64();
                    break;
                case 416:
                    this.salesLimit = codedInputByteBufferNano.readUInt64();
                    break;
                case 426:
                    this.originPrice = codedInputByteBufferNano.readString();
                    break;
                case SocketMessages.PayloadType.SC_MIC_SEATS_INVITATION /* 434 */:
                    this.singlePrice = codedInputByteBufferNano.readString();
                    break;
                case SocketMessages.PayloadType.SC_BET_CLOSED /* 442 */:
                    this.extParams = codedInputByteBufferNano.readString();
                    break;
                case 450:
                    if (this.showHideController == null) {
                        this.showHideController = new IntroducingHide();
                    }
                    codedInputByteBufferNano.readMessage(this.showHideController);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveLocalLifeExplainCardSignal parseFrom(byte[] bArr) {
        return (SCLiveLocalLifeExplainCardSignal) MessageNano.mergeFrom(new SCLiveLocalLifeExplainCardSignal(), bArr);
    }

    public static SCLiveLocalLifeExplainCardSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveLocalLifeExplainCardSignal().mergeFrom(codedInputByteBufferNano);
    }
}
