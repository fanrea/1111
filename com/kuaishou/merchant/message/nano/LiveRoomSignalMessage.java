package com.kuaishou.merchant.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRoomSignalMessage {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ActivityType {
        public static final int FIXED_RED_PACK = 2;
        public static final int NORMAL_RED_PACK = 1;
        public static final int UNKNOWN_ACTIVITY_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AuthorRedPackageStatus {
        public static final int COUPOEN_EXPIRE = 4;
        public static final int COUPON_AVAILABLE = 1;
        public static final int COUPON_CANCEL = 3;
        public static final int COUPON_STOCK_EMPTY = 2;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangeType {
        public static final int BARGAIN_CHANGE = 6;
        public static final int END_RECORD = 3;
        public static final int ITEM_INFO_CHANGE = 4;
        public static final int OFF_SALE = 1;
        public static final int ON_SALE = 0;
        public static final int SPECIFIC_ITEM_ON_SALE = 5;
        public static final int START_RECORD = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Currency {
        public static final int CNY = 0;
        public static final int KSCOIN = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ItemVolumeChangeType {
        public static final int HOT_VOLUME_REFRESH = 1;
        public static final int UNKNOWN_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RetrievePriceType {
        public static final int FROM_API_FALLBACK_SIGNAL = 1;
        public static final int FROM_SIGNAL = 2;
        public static final int UNKNOWN_RETRIEVE_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SCKwaishopPendantStatus {
        public static final int END = 2;
        public static final int INIT = 0;
        public static final int INITIALIZE = 3;
        public static final int UPDATE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScKwaishopLiveShopPendantBalanceType {
        public static final int NONE = 0;
        public static final int RANDOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SendTimeType {
        public static final int PERIOD = 0;
        public static final int TIMESTAMP = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WelfareItemSoldStatus {
        public static final int WELFARE_CAN_NOT_PURCHASE = 0;
        public static final int WELFARE_CAN_PURCHASE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WelfareItemType {
        public static final int WELFARE_BUY = 1;
        public static final int WELFARE_INVALID = 0;
    }

    public static final class LiveItemChangeSignal extends MessageNano {
        private static volatile LiveItemChangeSignal[] _emptyArray;
        public int changeType;
        public long dispersionTime;
        public int displayIntervalMillis;
        public ItemBubbleTitle itemBubbleTitle;
        public ItemInfo[] itemInfo;
        public int onSalesNum;
        public RetrievePriceDTO retrievePriceDto;
        public boolean shouldRequest;
        public long timeStamp;
        public int upperShelfNum;

        public static LiveItemChangeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveItemChangeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveItemChangeSignal() {
            clear();
        }

        public final LiveItemChangeSignal clear() {
            this.itemInfo = ItemInfo.emptyArray();
            this.onSalesNum = 0;
            this.changeType = 0;
            this.displayIntervalMillis = 0;
            this.upperShelfNum = 0;
            this.timeStamp = 0L;
            this.dispersionTime = 0L;
            this.shouldRequest = false;
            this.retrievePriceDto = null;
            this.itemBubbleTitle = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo[] itemInfoArr = this.itemInfo;
            if (itemInfoArr != null && itemInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    ItemInfo[] itemInfoArr2 = this.itemInfo;
                    if (i >= itemInfoArr2.length) {
                        break;
                    }
                    ItemInfo itemInfo = itemInfoArr2[i];
                    if (itemInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, itemInfo);
                    }
                    i++;
                }
            }
            int i2 = this.onSalesNum;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.changeType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i3);
            }
            int i4 = this.displayIntervalMillis;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            int i5 = this.upperShelfNum;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i5);
            }
            long j = this.timeStamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            long j2 = this.dispersionTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j2);
            }
            boolean z = this.shouldRequest;
            if (z) {
                codedOutputByteBufferNano.writeBool(8, z);
            }
            RetrievePriceDTO retrievePriceDTO = this.retrievePriceDto;
            if (retrievePriceDTO != null) {
                codedOutputByteBufferNano.writeMessage(9, retrievePriceDTO);
            }
            ItemBubbleTitle itemBubbleTitle = this.itemBubbleTitle;
            if (itemBubbleTitle != null) {
                codedOutputByteBufferNano.writeMessage(10, itemBubbleTitle);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo[] itemInfoArr = this.itemInfo;
            if (itemInfoArr != null && itemInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    ItemInfo[] itemInfoArr2 = this.itemInfo;
                    if (i >= itemInfoArr2.length) {
                        break;
                    }
                    ItemInfo itemInfo = itemInfoArr2[i];
                    if (itemInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
                    }
                    i++;
                }
            }
            int i2 = this.onSalesNum;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.changeType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
            }
            int i4 = this.displayIntervalMillis;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
            }
            int i5 = this.upperShelfNum;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i5);
            }
            long j = this.timeStamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            long j2 = this.dispersionTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j2);
            }
            boolean z = this.shouldRequest;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
            }
            RetrievePriceDTO retrievePriceDTO = this.retrievePriceDto;
            if (retrievePriceDTO != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, retrievePriceDTO);
            }
            ItemBubbleTitle itemBubbleTitle = this.itemBubbleTitle;
            return itemBubbleTitle != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, itemBubbleTitle) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveItemChangeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        ItemInfo[] itemInfoArr = this.itemInfo;
                        int length = itemInfoArr == null ? 0 : itemInfoArr.length;
                        ItemInfo[] itemInfoArr2 = new ItemInfo[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.itemInfo, 0, itemInfoArr2, 0, length);
                        }
                        while (length < itemInfoArr2.length - 1) {
                            itemInfoArr2[length] = new ItemInfo();
                            codedInputByteBufferNano.readMessage(itemInfoArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        itemInfoArr2[length] = new ItemInfo();
                        codedInputByteBufferNano.readMessage(itemInfoArr2[length]);
                        this.itemInfo = itemInfoArr2;
                        break;
                    case 16:
                        this.onSalesNum = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        int int32 = codedInputByteBufferNano.readInt32();
                        switch (int32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.changeType = int32;
                                break;
                        }
                    case 32:
                        this.displayIntervalMillis = codedInputByteBufferNano.readUInt32();
                        break;
                    case 40:
                        this.upperShelfNum = codedInputByteBufferNano.readUInt32();
                        break;
                    case 48:
                        this.timeStamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.dispersionTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.shouldRequest = codedInputByteBufferNano.readBool();
                        break;
                    case 74:
                        if (this.retrievePriceDto == null) {
                            this.retrievePriceDto = new RetrievePriceDTO();
                        }
                        codedInputByteBufferNano.readMessage(this.retrievePriceDto);
                        break;
                    case 82:
                        if (this.itemBubbleTitle == null) {
                            this.itemBubbleTitle = new ItemBubbleTitle();
                        }
                        codedInputByteBufferNano.readMessage(this.itemBubbleTitle);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveItemChangeSignal parseFrom(byte[] bArr) {
            return (LiveItemChangeSignal) MessageNano.mergeFrom(new LiveItemChangeSignal(), bArr);
        }

        public static LiveItemChangeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveItemChangeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ItemBubbleTitle extends MessageNano {
        private static volatile ItemBubbleTitle[] _emptyArray;
        public String desc;
        public String iconUrl;

        public static ItemBubbleTitle[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ItemBubbleTitle[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ItemBubbleTitle() {
            clear();
        }

        public final ItemBubbleTitle clear() {
            this.iconUrl = "";
            this.desc = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.iconUrl.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.iconUrl);
            }
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.desc);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.iconUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.iconUrl);
            }
            return !this.desc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.desc) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ItemBubbleTitle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.iconUrl = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.desc = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ItemBubbleTitle parseFrom(byte[] bArr) {
            return (ItemBubbleTitle) MessageNano.mergeFrom(new ItemBubbleTitle(), bArr);
        }

        public static ItemBubbleTitle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ItemBubbleTitle().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ItemInfo extends MessageNano {
        private static volatile ItemInfo[] _emptyArray;
        public String appletJumpUrl;
        public String buttonDesc;
        public String buttonText;
        public UserInfos.PicUrl[] buyButtonImageUrl;
        public String[] buyButtonUrlList;
        public int currency;
        public String extraMap;
        public UserInfos.PicUrl[] imageUrl;
        public ItemCurrency itemCurrency;
        public String itemId;
        public String[] itemUrlList;
        public String jumpUrl;
        public String originPrice;
        public String price;
        public String pricePrefix;
        public String priceSuffix;
        public long saleEndTime;
        public int saleType;
        public int[] showIcon;
        public int sourceType;
        public String title;

        public static ItemInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ItemInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ItemInfo() {
            clear();
        }

        public final ItemInfo clear() {
            this.itemId = "";
            this.imageUrl = UserInfos.PicUrl.emptyArray();
            this.title = "";
            this.price = "";
            this.showIcon = WireFormatNano.EMPTY_INT_ARRAY;
            this.jumpUrl = "";
            this.saleType = 0;
            this.extraMap = "";
            this.originPrice = "";
            this.pricePrefix = "";
            this.currency = 0;
            this.priceSuffix = "";
            this.itemUrlList = WireFormatNano.EMPTY_STRING_ARRAY;
            this.appletJumpUrl = "";
            this.saleEndTime = 0L;
            this.buyButtonUrlList = WireFormatNano.EMPTY_STRING_ARRAY;
            this.buyButtonImageUrl = UserInfos.PicUrl.emptyArray();
            this.sourceType = 0;
            this.buttonText = "";
            this.buttonDesc = "";
            this.itemCurrency = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            UserInfos.PicUrl[] picUrlArr = this.imageUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.title);
            }
            if (!this.price.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.price);
            }
            int[] iArr = this.showIcon;
            if (iArr != null && iArr.length > 0) {
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.showIcon;
                    if (i3 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt32(5, iArr2[i3]);
                    i3++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.jumpUrl);
            }
            int i4 = this.saleType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i4);
            }
            if (!this.extraMap.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.extraMap);
            }
            if (!this.originPrice.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.originPrice);
            }
            if (!this.pricePrefix.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.pricePrefix);
            }
            int i5 = this.currency;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(11, i5);
            }
            if (!this.priceSuffix.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.priceSuffix);
            }
            String[] strArr = this.itemUrlList;
            if (strArr != null && strArr.length > 0) {
                int i6 = 0;
                while (true) {
                    String[] strArr2 = this.itemUrlList;
                    if (i6 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i6];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(13, str);
                    }
                    i6++;
                }
            }
            if (!this.appletJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.appletJumpUrl);
            }
            long j = this.saleEndTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(15, j);
            }
            String[] strArr3 = this.buyButtonUrlList;
            if (strArr3 != null && strArr3.length > 0) {
                int i7 = 0;
                while (true) {
                    String[] strArr4 = this.buyButtonUrlList;
                    if (i7 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i7];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(16, str2);
                    }
                    i7++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.buyButtonImageUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.buyButtonImageUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(17, picUrl2);
                    }
                    i++;
                }
            }
            int i8 = this.sourceType;
            if (i8 != 0) {
                codedOutputByteBufferNano.writeUInt32(18, i8);
            }
            if (!this.buttonText.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.buttonText);
            }
            if (!this.buttonDesc.equals("")) {
                codedOutputByteBufferNano.writeString(20, this.buttonDesc);
            }
            ItemCurrency itemCurrency = this.itemCurrency;
            if (itemCurrency != null) {
                codedOutputByteBufferNano.writeMessage(21, itemCurrency);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            UserInfos.PicUrl[] picUrlArr = this.imageUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.title);
            }
            if (!this.price.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.price);
            }
            int[] iArr2 = this.showIcon;
            if (iArr2 != null && iArr2.length > 0) {
                int i3 = 0;
                int iComputeUInt32SizeNoTag = 0;
                while (true) {
                    iArr = this.showIcon;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i3]);
                    i3++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr.length * 1);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.jumpUrl);
            }
            int i4 = this.saleType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i4);
            }
            if (!this.extraMap.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.extraMap);
            }
            if (!this.originPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.originPrice);
            }
            if (!this.pricePrefix.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.pricePrefix);
            }
            int i5 = this.currency;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i5);
            }
            if (!this.priceSuffix.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.priceSuffix);
            }
            String[] strArr = this.itemUrlList;
            if (strArr != null && strArr.length > 0) {
                int i6 = 0;
                int iComputeStringSizeNoTag = 0;
                int i7 = 0;
                while (true) {
                    String[] strArr2 = this.itemUrlList;
                    if (i6 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i6];
                    if (str != null) {
                        i7++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i7 * 1);
            }
            if (!this.appletJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.appletJumpUrl);
            }
            long j = this.saleEndTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j);
            }
            String[] strArr3 = this.buyButtonUrlList;
            if (strArr3 != null && strArr3.length > 0) {
                int i8 = 0;
                int iComputeStringSizeNoTag2 = 0;
                int i9 = 0;
                while (true) {
                    String[] strArr4 = this.buyButtonUrlList;
                    if (i8 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i8];
                    if (str2 != null) {
                        i9++;
                        iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                    }
                    i8++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag2 + (i9 * 2);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.buyButtonImageUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.buyButtonImageUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, picUrl2);
                    }
                    i++;
                }
            }
            int i10 = this.sourceType;
            if (i10 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i10);
            }
            if (!this.buttonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.buttonText);
            }
            if (!this.buttonDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.buttonDesc);
            }
            ItemCurrency itemCurrency = this.itemCurrency;
            return itemCurrency != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(21, itemCurrency) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ItemInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.itemId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        UserInfos.PicUrl[] picUrlArr = this.imageUrl;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.imageUrl, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.imageUrl = picUrlArr2;
                        break;
                    case 26:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.price = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
                        int[] iArr = this.showIcon;
                        int length2 = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.showIcon, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length - 1) {
                            iArr2[length2] = codedInputByteBufferNano.readUInt32();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        this.showIcon = iArr2;
                        break;
                    case 42:
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readUInt32();
                            i++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.showIcon;
                        int length3 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.showIcon, 0, iArr4, 0, length3);
                        }
                        while (length3 < iArr4.length) {
                            iArr4[length3] = codedInputByteBufferNano.readUInt32();
                            length3++;
                        }
                        this.showIcon = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                        break;
                    case 50:
                        this.jumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.saleType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 66:
                        this.extraMap = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.originPrice = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.pricePrefix = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1) {
                            break;
                        } else {
                            this.currency = int32;
                            break;
                        }
                        break;
                    case 98:
                        this.priceSuffix = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        String[] strArr = this.itemUrlList;
                        int length4 = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength3 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.itemUrlList, 0, strArr2, 0, length4);
                        }
                        while (length4 < strArr2.length - 1) {
                            strArr2[length4] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        strArr2[length4] = codedInputByteBufferNano.readString();
                        this.itemUrlList = strArr2;
                        break;
                    case 114:
                        this.appletJumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 120:
                        this.saleEndTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 130:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                        String[] strArr3 = this.buyButtonUrlList;
                        int length5 = strArr3 == null ? 0 : strArr3.length;
                        String[] strArr4 = new String[repeatedFieldArrayLength4 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.buyButtonUrlList, 0, strArr4, 0, length5);
                        }
                        while (length5 < strArr4.length - 1) {
                            strArr4[length5] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        strArr4[length5] = codedInputByteBufferNano.readString();
                        this.buyButtonUrlList = strArr4;
                        break;
                    case 138:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                        UserInfos.PicUrl[] picUrlArr3 = this.buyButtonImageUrl;
                        int length6 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength5 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.buyButtonImageUrl, 0, picUrlArr4, 0, length6);
                        }
                        while (length6 < picUrlArr4.length - 1) {
                            picUrlArr4[length6] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        picUrlArr4[length6] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length6]);
                        this.buyButtonImageUrl = picUrlArr4;
                        break;
                    case 144:
                        this.sourceType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 154:
                        this.buttonText = codedInputByteBufferNano.readString();
                        break;
                    case 162:
                        this.buttonDesc = codedInputByteBufferNano.readString();
                        break;
                    case 170:
                        if (this.itemCurrency == null) {
                            this.itemCurrency = new ItemCurrency();
                        }
                        codedInputByteBufferNano.readMessage(this.itemCurrency);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static ItemInfo parseFrom(byte[] bArr) {
            return (ItemInfo) MessageNano.mergeFrom(new ItemInfo(), bArr);
        }

        public static ItemInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ItemInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ItemCurrency extends MessageNano {
        private static volatile ItemCurrency[] _emptyArray;
        public String currencyContent;
        public int currencyPosition;

        public static ItemCurrency[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ItemCurrency[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ItemCurrency() {
            clear();
        }

        public final ItemCurrency clear() {
            this.currencyPosition = 0;
            this.currencyContent = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.currencyPosition;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.currencyContent.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.currencyContent);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.currencyPosition;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            return !this.currencyContent.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.currencyContent) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ItemCurrency mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.currencyPosition = codedInputByteBufferNano.readUInt32();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.currencyContent = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ItemCurrency parseFrom(byte[] bArr) {
            return (ItemCurrency) MessageNano.mergeFrom(new ItemCurrency(), bArr);
        }

        public static ItemCurrency parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ItemCurrency().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SeckillStartSignal extends MessageNano {
        private static volatile SeckillStartSignal[] _emptyArray;
        public int displayIntervalMillis;
        public ItemInfo item;
        public String seckillId;

        public static SeckillStartSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SeckillStartSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SeckillStartSignal() {
            clear();
        }

        public final SeckillStartSignal clear() {
            this.seckillId = "";
            this.item = null;
            this.displayIntervalMillis = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.seckillId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.seckillId);
            }
            ItemInfo itemInfo = this.item;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, itemInfo);
            }
            int i = this.displayIntervalMillis;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.seckillId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.seckillId);
            }
            ItemInfo itemInfo = this.item;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, itemInfo);
            }
            int i = this.displayIntervalMillis;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SeckillStartSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.seckillId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.item == null) {
                        this.item = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.item);
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.displayIntervalMillis = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SeckillStartSignal parseFrom(byte[] bArr) {
            return (SeckillStartSignal) MessageNano.mergeFrom(new SeckillStartSignal(), bArr);
        }

        public static SeckillStartSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SeckillStartSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveItemVolumeChangeSignal extends MessageNano {
        private static volatile LiveItemVolumeChangeSignal[] _emptyArray;
        public int changeType;
        public int displayIntervalMillis;
        public String itemId;
        public ItemInfo itemInfo;
        public int lastVolume;
        public int volume;

        public static LiveItemVolumeChangeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveItemVolumeChangeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveItemVolumeChangeSignal() {
            clear();
        }

        public final LiveItemVolumeChangeSignal clear() {
            this.itemId = "";
            this.volume = 0;
            this.itemInfo = null;
            this.changeType = 0;
            this.lastVolume = 0;
            this.displayIntervalMillis = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            int i = this.volume;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, itemInfo);
            }
            int i2 = this.changeType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            int i3 = this.lastVolume;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i3);
            }
            int i4 = this.displayIntervalMillis;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            int i = this.volume;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, itemInfo);
            }
            int i2 = this.changeType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            int i3 = this.lastVolume;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
            }
            int i4 = this.displayIntervalMillis;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveItemVolumeChangeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.volume = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 32) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.changeType = int32;
                    }
                } else if (tag == 40) {
                    this.lastVolume = codedInputByteBufferNano.readUInt32();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.displayIntervalMillis = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveItemVolumeChangeSignal parseFrom(byte[] bArr) {
            return (LiveItemVolumeChangeSignal) MessageNano.mergeFrom(new LiveItemVolumeChangeSignal(), bArr);
        }

        public static LiveItemVolumeChangeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveItemVolumeChangeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveLotteryOpenSignal extends MessageNano {
        private static volatile LiveLotteryOpenSignal[] _emptyArray;
        public int displayIntervalMillis;
        public ItemInfo itemInfo;
        public long openTimeMills;

        public static LiveLotteryOpenSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveLotteryOpenSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveLotteryOpenSignal() {
            clear();
        }

        public final LiveLotteryOpenSignal clear() {
            this.itemInfo = null;
            this.displayIntervalMillis = 0;
            this.openTimeMills = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            int i = this.displayIntervalMillis;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j = this.openTimeMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            int i = this.displayIntervalMillis;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j = this.openTimeMills;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveLotteryOpenSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 16) {
                    this.displayIntervalMillis = codedInputByteBufferNano.readUInt32();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.openTimeMills = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveLotteryOpenSignal parseFrom(byte[] bArr) {
            return (LiveLotteryOpenSignal) MessageNano.mergeFrom(new LiveLotteryOpenSignal(), bArr);
        }

        public static LiveLotteryOpenSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveLotteryOpenSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveGeneralCouponSignal extends MessageNano {
        private static volatile LiveGeneralCouponSignal[] _emptyArray;
        public String couponId;
        public GeneralCouponInfo couponInfo;
        public String couponLink;
        public int displayIntervalMillis;
        public boolean isNegative;
        public int pendSourceType;
        public int randomTimeMills;
        public int requestDelaySecond;
        public boolean shouldRequest;
        public int subType;
        public String title;

        public static LiveGeneralCouponSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveGeneralCouponSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveGeneralCouponSignal() {
            clear();
        }

        public final LiveGeneralCouponSignal clear() {
            this.couponId = "";
            this.isNegative = false;
            this.subType = 0;
            this.displayIntervalMillis = 0;
            this.title = "";
            this.shouldRequest = false;
            this.requestDelaySecond = 0;
            this.couponInfo = null;
            this.randomTimeMills = 0;
            this.couponLink = "";
            this.pendSourceType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.couponId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.couponId);
            }
            boolean z = this.isNegative;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            int i = this.subType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            int i2 = this.displayIntervalMillis;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.title);
            }
            boolean z2 = this.shouldRequest;
            if (z2) {
                codedOutputByteBufferNano.writeBool(6, z2);
            }
            int i3 = this.requestDelaySecond;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i3);
            }
            GeneralCouponInfo generalCouponInfo = this.couponInfo;
            if (generalCouponInfo != null) {
                codedOutputByteBufferNano.writeMessage(8, generalCouponInfo);
            }
            int i4 = this.randomTimeMills;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(9, i4);
            }
            if (!this.couponLink.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.couponLink);
            }
            int i5 = this.pendSourceType;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(11, i5);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.couponId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.couponId);
            }
            boolean z = this.isNegative;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            int i = this.subType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            int i2 = this.displayIntervalMillis;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.title);
            }
            boolean z2 = this.shouldRequest;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z2);
            }
            int i3 = this.requestDelaySecond;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
            }
            GeneralCouponInfo generalCouponInfo = this.couponInfo;
            if (generalCouponInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, generalCouponInfo);
            }
            int i4 = this.randomTimeMills;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i4);
            }
            if (!this.couponLink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.couponLink);
            }
            int i5 = this.pendSourceType;
            return i5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(11, i5) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveGeneralCouponSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.couponId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.isNegative = codedInputByteBufferNano.readBool();
                        break;
                    case 24:
                        this.subType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.displayIntervalMillis = codedInputByteBufferNano.readUInt32();
                        break;
                    case 42:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.shouldRequest = codedInputByteBufferNano.readBool();
                        break;
                    case 56:
                        this.requestDelaySecond = codedInputByteBufferNano.readUInt32();
                        break;
                    case 66:
                        if (this.couponInfo == null) {
                            this.couponInfo = new GeneralCouponInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.couponInfo);
                        break;
                    case 72:
                        this.randomTimeMills = codedInputByteBufferNano.readUInt32();
                        break;
                    case 82:
                        this.couponLink = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        this.pendSourceType = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveGeneralCouponSignal parseFrom(byte[] bArr) {
            return (LiveGeneralCouponSignal) MessageNano.mergeFrom(new LiveGeneralCouponSignal(), bArr);
        }

        public static LiveGeneralCouponSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveGeneralCouponSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class GeneralCouponInfo extends MessageNano {
        private static volatile GeneralCouponInfo[] _emptyArray;
        public String btnText;
        public String couponName;
        public String couponPrice;
        public int currency;
        public String endTime;
        public String useConditionTitle;
        public String useRangeTitle;

        public static GeneralCouponInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GeneralCouponInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GeneralCouponInfo() {
            clear();
        }

        public final GeneralCouponInfo clear() {
            this.couponName = "";
            this.couponPrice = "";
            this.useConditionTitle = "";
            this.useRangeTitle = "";
            this.endTime = "";
            this.currency = 0;
            this.btnText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.couponName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.couponName);
            }
            if (!this.couponPrice.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.couponPrice);
            }
            if (!this.useConditionTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.useConditionTitle);
            }
            if (!this.useRangeTitle.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.useRangeTitle);
            }
            if (!this.endTime.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.endTime);
            }
            int i = this.currency;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i);
            }
            if (!this.btnText.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.btnText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.couponName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.couponName);
            }
            if (!this.couponPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.couponPrice);
            }
            if (!this.useConditionTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.useConditionTitle);
            }
            if (!this.useRangeTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.useRangeTitle);
            }
            if (!this.endTime.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.endTime);
            }
            int i = this.currency;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i);
            }
            return !this.btnText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.btnText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final GeneralCouponInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.couponName = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.couponPrice = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.useConditionTitle = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.useRangeTitle = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.endTime = codedInputByteBufferNano.readString();
                } else if (tag == 56) {
                    this.currency = codedInputByteBufferNano.readUInt32();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.btnText = codedInputByteBufferNano.readString();
                }
            }
        }

        public static GeneralCouponInfo parseFrom(byte[] bArr) {
            return (GeneralCouponInfo) MessageNano.mergeFrom(new GeneralCouponInfo(), bArr);
        }

        public static GeneralCouponInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GeneralCouponInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveItemPriceChangeSignal extends MessageNano {
        private static volatile LiveItemPriceChangeSignal[] _emptyArray;
        public int displayIntervalMillis;
        public ItemInfo itemInfo;
        public String popTitle;

        public static LiveItemPriceChangeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveItemPriceChangeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveItemPriceChangeSignal() {
            clear();
        }

        public final LiveItemPriceChangeSignal clear() {
            this.itemInfo = null;
            this.displayIntervalMillis = 0;
            this.popTitle = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            int i = this.displayIntervalMillis;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            if (!this.popTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.popTitle);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            int i = this.displayIntervalMillis;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            return !this.popTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.popTitle) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveItemPriceChangeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 16) {
                    this.displayIntervalMillis = codedInputByteBufferNano.readUInt32();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.popTitle = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveItemPriceChangeSignal parseFrom(byte[] bArr) {
            return (LiveItemPriceChangeSignal) MessageNano.mergeFrom(new LiveItemPriceChangeSignal(), bArr);
        }

        public static LiveItemPriceChangeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveItemPriceChangeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSandeapyInfoSignal extends MessageNano {
        private static volatile LiveSandeapyInfoSignal[] _emptyArray;
        public int giftId;
        public ItemInfo itemInfo;
        public int[] priceRange;

        public static LiveSandeapyInfoSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSandeapyInfoSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSandeapyInfoSignal() {
            clear();
        }

        public final LiveSandeapyInfoSignal clear() {
            this.itemInfo = null;
            this.giftId = 0;
            this.priceRange = WireFormatNano.EMPTY_INT_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int[] iArr = this.priceRange;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.priceRange;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt32(3, iArr2[i2]);
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int[] iArr = this.priceRange;
            if (iArr == null || iArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i2 = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                int[] iArr2 = this.priceRange;
                if (i2 < iArr2.length) {
                    iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i2]);
                    i2++;
                } else {
                    return iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
                }
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSandeapyInfoSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 16) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    int[] iArr = this.priceRange;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.priceRange, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.priceRange = iArr2;
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.priceRange;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.priceRange, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.priceRange = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                }
            }
        }

        public static LiveSandeapyInfoSignal parseFrom(byte[] bArr) {
            return (LiveSandeapyInfoSignal) MessageNano.mergeFrom(new LiveSandeapyInfoSignal(), bArr);
        }

        public static LiveSandeapyInfoSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSandeapyInfoSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSandeapyBidRefreshSignal extends MessageNano {
        private static volatile LiveSandeapyBidRefreshSignal[] _emptyArray;
        public int giftId;
        public ItemInfo itemInfo;
        public int[] priceRange;
        public int totalBidder;

        public static LiveSandeapyBidRefreshSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSandeapyBidRefreshSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSandeapyBidRefreshSignal() {
            clear();
        }

        public final LiveSandeapyBidRefreshSignal clear() {
            this.itemInfo = null;
            this.giftId = 0;
            this.priceRange = WireFormatNano.EMPTY_INT_ARRAY;
            this.totalBidder = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int[] iArr = this.priceRange;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.priceRange;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt32(3, iArr2[i2]);
                    i2++;
                }
            }
            int i3 = this.totalBidder;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int[] iArr2 = this.priceRange;
            if (iArr2 != null && iArr2.length > 0) {
                int i2 = 0;
                int iComputeUInt32SizeNoTag = 0;
                while (true) {
                    iArr = this.priceRange;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i2]);
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr.length * 1);
            }
            int i3 = this.totalBidder;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSandeapyBidRefreshSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 16) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    int[] iArr = this.priceRange;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.priceRange, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.priceRange = iArr2;
                } else if (tag == 26) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.priceRange;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.priceRange, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.priceRange = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.totalBidder = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveSandeapyBidRefreshSignal parseFrom(byte[] bArr) {
            return (LiveSandeapyBidRefreshSignal) MessageNano.mergeFrom(new LiveSandeapyBidRefreshSignal(), bArr);
        }

        public static LiveSandeapyBidRefreshSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSandeapyBidRefreshSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSandeapyDealSignal extends MessageNano {
        private static volatile LiveSandeapyDealSignal[] _emptyArray;
        public String itemId;
        public String jumpUrl;
        public String message;

        public static LiveSandeapyDealSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSandeapyDealSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSandeapyDealSignal() {
            clear();
        }

        public final LiveSandeapyDealSignal clear() {
            this.message = "";
            this.itemId = "";
            this.jumpUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.message.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.message);
            }
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.itemId);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.jumpUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.message.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.message);
            }
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.itemId);
            }
            return !this.jumpUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSandeapyDealSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.message = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSandeapyDealSignal parseFrom(byte[] bArr) {
            return (LiveSandeapyDealSignal) MessageNano.mergeFrom(new LiveSandeapyDealSignal(), bArr);
        }

        public static LiveSandeapyDealSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSandeapyDealSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSandeapyCloseSignal extends MessageNano {
        private static volatile LiveSandeapyCloseSignal[] _emptyArray;
        public String itemId;

        public static LiveSandeapyCloseSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSandeapyCloseSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSandeapyCloseSignal() {
            clear();
        }

        public final LiveSandeapyCloseSignal clear() {
            this.itemId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.itemId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.itemId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSandeapyCloseSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.itemId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSandeapyCloseSignal parseFrom(byte[] bArr) {
            return (LiveSandeapyCloseSignal) MessageNano.mergeFrom(new LiveSandeapyCloseSignal(), bArr);
        }

        public static LiveSandeapyCloseSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSandeapyCloseSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSandeapyItemStatusSignal extends MessageNano {
        private static volatile LiveSandeapyItemStatusSignal[] _emptyArray;
        public String itemId;
        public int status;

        public static LiveSandeapyItemStatusSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSandeapyItemStatusSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSandeapyItemStatusSignal() {
            clear();
        }

        public final LiveSandeapyItemStatusSignal clear() {
            this.itemId = "";
            this.status = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            int i = this.status;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSandeapyItemStatusSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.status = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveSandeapyItemStatusSignal parseFrom(byte[] bArr) {
            return (LiveSandeapyItemStatusSignal) MessageNano.mergeFrom(new LiveSandeapyItemStatusSignal(), bArr);
        }

        public static LiveSandeapyItemStatusSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSandeapyItemStatusSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSandeapyNegativeSignal extends MessageNano {
        private static volatile LiveSandeapyNegativeSignal[] _emptyArray;
        public String itemId;

        public static LiveSandeapyNegativeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSandeapyNegativeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSandeapyNegativeSignal() {
            clear();
        }

        public final LiveSandeapyNegativeSignal clear() {
            this.itemId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.itemId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.itemId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSandeapyNegativeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.itemId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSandeapyNegativeSignal parseFrom(byte[] bArr) {
            return (LiveSandeapyNegativeSignal) MessageNano.mergeFrom(new LiveSandeapyNegativeSignal(), bArr);
        }

        public static LiveSandeapyNegativeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSandeapyNegativeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AskRecordMessage extends MessageNano {
        private static volatile AskRecordMessage[] _emptyArray;
        public long displayIntervalMillis;
        public boolean openAnimation;
        public long totalNumber;

        public static AskRecordMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AskRecordMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AskRecordMessage() {
            clear();
        }

        public final AskRecordMessage clear() {
            this.totalNumber = 0L;
            this.displayIntervalMillis = 0L;
            this.openAnimation = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.totalNumber;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.displayIntervalMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            boolean z = this.openAnimation;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.totalNumber;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.displayIntervalMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            boolean z = this.openAnimation;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AskRecordMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.totalNumber = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.displayIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.openAnimation = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static AskRecordMessage parseFrom(byte[] bArr) {
            return (AskRecordMessage) MessageNano.mergeFrom(new AskRecordMessage(), bArr);
        }

        public static AskRecordMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AskRecordMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantUserEnterRoomSignal extends MessageNano {
        private static volatile MerchantUserEnterRoomSignal[] _emptyArray;
        public ItemInfo itemInfo;

        public static MerchantUserEnterRoomSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantUserEnterRoomSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantUserEnterRoomSignal() {
            clear();
        }

        public final MerchantUserEnterRoomSignal clear() {
            this.itemInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            return itemInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, itemInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantUserEnterRoomSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                }
            }
        }

        public static MerchantUserEnterRoomSignal parseFrom(byte[] bArr) {
            return (MerchantUserEnterRoomSignal) MessageNano.mergeFrom(new MerchantUserEnterRoomSignal(), bArr);
        }

        public static MerchantUserEnterRoomSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantUserEnterRoomSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveBuyingNoticeSignal extends MessageNano {
        private static volatile LiveBuyingNoticeSignal[] _emptyArray;
        public String bulletText;

        public static LiveBuyingNoticeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveBuyingNoticeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveBuyingNoticeSignal() {
            clear();
        }

        public final LiveBuyingNoticeSignal clear() {
            this.bulletText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bulletText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bulletText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.bulletText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.bulletText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveBuyingNoticeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.bulletText = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveBuyingNoticeSignal parseFrom(byte[] bArr) {
            return (LiveBuyingNoticeSignal) MessageNano.mergeFrom(new LiveBuyingNoticeSignal(), bArr);
        }

        public static LiveBuyingNoticeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveBuyingNoticeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantFlowWelfareActivityCreateSignal extends MessageNano {
        private static volatile MerchantFlowWelfareActivityCreateSignal[] _emptyArray;
        public String activityId;
        public long amount;
        public long countDownReqTime;
        public long displayTimeSec;
        public int fixedRedpackAmount;
        public int fixedRedpackCount;
        public String liveStreamId;
        public long openTime;
        public boolean personalized;
        public long scatterTimeMills;
        public String token;
        public int type;
        public UserInfos.PicUrl[] userIcon;
        public long userId;
        public String userName;

        public static MerchantFlowWelfareActivityCreateSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantFlowWelfareActivityCreateSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantFlowWelfareActivityCreateSignal() {
            clear();
        }

        public final MerchantFlowWelfareActivityCreateSignal clear() {
            this.userName = "";
            this.userId = 0L;
            this.userIcon = UserInfos.PicUrl.emptyArray();
            this.liveStreamId = "";
            this.activityId = "";
            this.amount = 0L;
            this.scatterTimeMills = 0L;
            this.displayTimeSec = 0L;
            this.personalized = false;
            this.token = "";
            this.countDownReqTime = 0L;
            this.type = 0;
            this.openTime = 0L;
            this.fixedRedpackCount = 0;
            this.fixedRedpackAmount = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.userName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.userName);
            }
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            UserInfos.PicUrl[] picUrlArr = this.userIcon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.userIcon;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i++;
                }
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.activityId);
            }
            long j2 = this.amount;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            long j3 = this.scatterTimeMills;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            long j4 = this.displayTimeSec;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            boolean z = this.personalized;
            if (z) {
                codedOutputByteBufferNano.writeBool(9, z);
            }
            if (!this.token.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.token);
            }
            long j5 = this.countDownReqTime;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j5);
            }
            int i2 = this.type;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(12, i2);
            }
            long j6 = this.openTime;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j6);
            }
            int i3 = this.fixedRedpackCount;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(14, i3);
            }
            int i4 = this.fixedRedpackAmount;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(15, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.userName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.userName);
            }
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            UserInfos.PicUrl[] picUrlArr = this.userIcon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.userIcon;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i++;
                }
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.activityId);
            }
            long j2 = this.amount;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            long j3 = this.scatterTimeMills;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            long j4 = this.displayTimeSec;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
            }
            boolean z = this.personalized;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
            }
            if (!this.token.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.token);
            }
            long j5 = this.countDownReqTime;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j5);
            }
            int i2 = this.type;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i2);
            }
            long j6 = this.openTime;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j6);
            }
            int i3 = this.fixedRedpackCount;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i3);
            }
            int i4 = this.fixedRedpackAmount;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(15, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantFlowWelfareActivityCreateSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.userName = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.userId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        UserInfos.PicUrl[] picUrlArr = this.userIcon;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.userIcon, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.userIcon = picUrlArr2;
                        break;
                    case 34:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.activityId = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.amount = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.scatterTimeMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.displayTimeSec = codedInputByteBufferNano.readUInt64();
                        break;
                    case 72:
                        this.personalized = codedInputByteBufferNano.readBool();
                        break;
                    case 82:
                        this.token = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        this.countDownReqTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 96:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            break;
                        } else {
                            this.type = int32;
                            break;
                        }
                    case 104:
                        this.openTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 112:
                        this.fixedRedpackCount = codedInputByteBufferNano.readUInt32();
                        break;
                    case 120:
                        this.fixedRedpackAmount = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static MerchantFlowWelfareActivityCreateSignal parseFrom(byte[] bArr) {
            return (MerchantFlowWelfareActivityCreateSignal) MessageNano.mergeFrom(new MerchantFlowWelfareActivityCreateSignal(), bArr);
        }

        public static MerchantFlowWelfareActivityCreateSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantFlowWelfareActivityCreateSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantFlowWelfareActivityCloseSignal extends MessageNano {
        private static volatile MerchantFlowWelfareActivityCloseSignal[] _emptyArray;
        public String activityId;
        public String liveStreamId;

        public static MerchantFlowWelfareActivityCloseSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantFlowWelfareActivityCloseSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantFlowWelfareActivityCloseSignal() {
            clear();
        }

        public final MerchantFlowWelfareActivityCloseSignal clear() {
            this.liveStreamId = "";
            this.activityId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.activityId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
            }
            return !this.activityId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.activityId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantFlowWelfareActivityCloseSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 34) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.activityId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static MerchantFlowWelfareActivityCloseSignal parseFrom(byte[] bArr) {
            return (MerchantFlowWelfareActivityCloseSignal) MessageNano.mergeFrom(new MerchantFlowWelfareActivityCloseSignal(), bArr);
        }

        public static MerchantFlowWelfareActivityCloseSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantFlowWelfareActivityCloseSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantFlowGatherPopularityUpdateSignal extends MessageNano {
        private static volatile MerchantFlowGatherPopularityUpdateSignal[] _emptyArray;
        public long carouselDisplayMills;
        public boolean isReqServer;
        public GatherPopularityItemInfo[] itemInfo;
        public long scatterTimeMills;

        public static MerchantFlowGatherPopularityUpdateSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantFlowGatherPopularityUpdateSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantFlowGatherPopularityUpdateSignal() {
            clear();
        }

        public final MerchantFlowGatherPopularityUpdateSignal clear() {
            this.itemInfo = GatherPopularityItemInfo.emptyArray();
            this.scatterTimeMills = 0L;
            this.isReqServer = false;
            this.carouselDisplayMills = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            GatherPopularityItemInfo[] gatherPopularityItemInfoArr = this.itemInfo;
            if (gatherPopularityItemInfoArr != null && gatherPopularityItemInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    GatherPopularityItemInfo[] gatherPopularityItemInfoArr2 = this.itemInfo;
                    if (i >= gatherPopularityItemInfoArr2.length) {
                        break;
                    }
                    GatherPopularityItemInfo gatherPopularityItemInfo = gatherPopularityItemInfoArr2[i];
                    if (gatherPopularityItemInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, gatherPopularityItemInfo);
                    }
                    i++;
                }
            }
            long j = this.scatterTimeMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            boolean z = this.isReqServer;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            long j2 = this.carouselDisplayMills;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            GatherPopularityItemInfo[] gatherPopularityItemInfoArr = this.itemInfo;
            if (gatherPopularityItemInfoArr != null && gatherPopularityItemInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    GatherPopularityItemInfo[] gatherPopularityItemInfoArr2 = this.itemInfo;
                    if (i >= gatherPopularityItemInfoArr2.length) {
                        break;
                    }
                    GatherPopularityItemInfo gatherPopularityItemInfo = gatherPopularityItemInfoArr2[i];
                    if (gatherPopularityItemInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gatherPopularityItemInfo);
                    }
                    i++;
                }
            }
            long j = this.scatterTimeMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            boolean z = this.isReqServer;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            long j2 = this.carouselDisplayMills;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantFlowGatherPopularityUpdateSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    GatherPopularityItemInfo[] gatherPopularityItemInfoArr = this.itemInfo;
                    int length = gatherPopularityItemInfoArr == null ? 0 : gatherPopularityItemInfoArr.length;
                    GatherPopularityItemInfo[] gatherPopularityItemInfoArr2 = new GatherPopularityItemInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.itemInfo, 0, gatherPopularityItemInfoArr2, 0, length);
                    }
                    while (length < gatherPopularityItemInfoArr2.length - 1) {
                        gatherPopularityItemInfoArr2[length] = new GatherPopularityItemInfo();
                        codedInputByteBufferNano.readMessage(gatherPopularityItemInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    gatherPopularityItemInfoArr2[length] = new GatherPopularityItemInfo();
                    codedInputByteBufferNano.readMessage(gatherPopularityItemInfoArr2[length]);
                    this.itemInfo = gatherPopularityItemInfoArr2;
                } else if (tag == 16) {
                    this.scatterTimeMills = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.isReqServer = codedInputByteBufferNano.readBool();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.carouselDisplayMills = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static MerchantFlowGatherPopularityUpdateSignal parseFrom(byte[] bArr) {
            return (MerchantFlowGatherPopularityUpdateSignal) MessageNano.mergeFrom(new MerchantFlowGatherPopularityUpdateSignal(), bArr);
        }

        public static MerchantFlowGatherPopularityUpdateSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantFlowGatherPopularityUpdateSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class GatherPopularityItemInfo extends MessageNano {
        private static volatile GatherPopularityItemInfo[] _emptyArray;
        public String desc;
        public UserInfos.PicUrl[] imageUrl;
        public boolean isLive;
        public String itemId;
        public String[] itemUrlList;
        public String jumpUrl;
        public String price;
        public String priceDesc;
        public UserInfos.PicUrl[] tagCdnUrl;
        public String tagImageUrl;
        public String title;

        public static GatherPopularityItemInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GatherPopularityItemInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GatherPopularityItemInfo() {
            clear();
        }

        public final GatherPopularityItemInfo clear() {
            this.imageUrl = UserInfos.PicUrl.emptyArray();
            this.title = "";
            this.price = "";
            this.desc = "";
            this.itemId = "";
            this.priceDesc = "";
            this.isLive = false;
            this.jumpUrl = "";
            this.itemUrlList = WireFormatNano.EMPTY_STRING_ARRAY;
            this.tagImageUrl = "";
            this.tagCdnUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.imageUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.price.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.price);
            }
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.desc);
            }
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.itemId);
            }
            if (!this.priceDesc.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.priceDesc);
            }
            boolean z = this.isLive;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.jumpUrl);
            }
            String[] strArr = this.itemUrlList;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.itemUrlList;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(9, str);
                    }
                    i3++;
                }
            }
            if (!this.tagImageUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.tagImageUrl);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.tagCdnUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.tagCdnUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(11, picUrl2);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.imageUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.price.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.price);
            }
            if (!this.desc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.desc);
            }
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.itemId);
            }
            if (!this.priceDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.priceDesc);
            }
            boolean z = this.isLive;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.jumpUrl);
            }
            String[] strArr = this.itemUrlList;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                int iComputeStringSizeNoTag = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.itemUrlList;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        i4++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
            }
            if (!this.tagImageUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.tagImageUrl);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.tagCdnUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.tagCdnUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, picUrl2);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final GatherPopularityItemInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        UserInfos.PicUrl[] picUrlArr = this.imageUrl;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.imageUrl, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.imageUrl = picUrlArr2;
                        break;
                    case 18:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.price = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.desc = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.itemId = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.priceDesc = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.isLive = codedInputByteBufferNano.readBool();
                        break;
                    case 66:
                        this.jumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        String[] strArr = this.itemUrlList;
                        int length2 = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.itemUrlList, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        this.itemUrlList = strArr2;
                        break;
                    case 82:
                        this.tagImageUrl = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UserInfos.PicUrl[] picUrlArr3 = this.tagCdnUrl;
                        int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.tagCdnUrl, 0, picUrlArr4, 0, length3);
                        }
                        while (length3 < picUrlArr4.length - 1) {
                            picUrlArr4[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        this.tagCdnUrl = picUrlArr4;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static GatherPopularityItemInfo parseFrom(byte[] bArr) {
            return (GatherPopularityItemInfo) MessageNano.mergeFrom(new GatherPopularityItemInfo(), bArr);
        }

        public static GatherPopularityItemInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GatherPopularityItemInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantFlowSpreadYellowCarSignal extends MessageNano {
        private static volatile MerchantFlowSpreadYellowCarSignal[] _emptyArray;
        public long advanceTimeMillis;
        public long fixedTimeMillis;
        public int timeType;

        public static MerchantFlowSpreadYellowCarSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantFlowSpreadYellowCarSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantFlowSpreadYellowCarSignal() {
            clear();
        }

        public final MerchantFlowSpreadYellowCarSignal clear() {
            this.timeType = 0;
            this.advanceTimeMillis = 0L;
            this.fixedTimeMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.timeType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.advanceTimeMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.fixedTimeMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.timeType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.advanceTimeMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.fixedTimeMillis;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantFlowSpreadYellowCarSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.timeType = int32;
                    }
                } else if (tag == 16) {
                    this.advanceTimeMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.fixedTimeMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static MerchantFlowSpreadYellowCarSignal parseFrom(byte[] bArr) {
            return (MerchantFlowSpreadYellowCarSignal) MessageNano.mergeFrom(new MerchantFlowSpreadYellowCarSignal(), bArr);
        }

        public static MerchantFlowSpreadYellowCarSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantFlowSpreadYellowCarSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SurveyChoice extends MessageNano {
        private static volatile SurveyChoice[] _emptyArray;
        public String choiceDesc;
        public int choiceValue;

        public static SurveyChoice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SurveyChoice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SurveyChoice() {
            clear();
        }

        public final SurveyChoice clear() {
            this.choiceDesc = "";
            this.choiceValue = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.choiceDesc.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.choiceDesc);
            }
            int i = this.choiceValue;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.choiceDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.choiceDesc);
            }
            int i = this.choiceValue;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SurveyChoice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.choiceDesc = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.choiceValue = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SurveyChoice parseFrom(byte[] bArr) {
            return (SurveyChoice) MessageNano.mergeFrom(new SurveyChoice(), bArr);
        }

        public static SurveyChoice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SurveyChoice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SurveyClientPushInfoSignal extends MessageNano {
        private static volatile SurveyClientPushInfoSignal[] _emptyArray;
        public SurveyChoice[] choice;
        public int closeDuration;
        public String description;
        public long id;
        public String liveStreamId;
        public long researchId;
        public String title;

        public static SurveyClientPushInfoSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SurveyClientPushInfoSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SurveyClientPushInfoSignal() {
            clear();
        }

        public final SurveyClientPushInfoSignal clear() {
            this.id = 0L;
            this.title = "";
            this.description = "";
            this.choice = SurveyChoice.emptyArray();
            this.closeDuration = 0;
            this.researchId = 0L;
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.description.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.description);
            }
            SurveyChoice[] surveyChoiceArr = this.choice;
            if (surveyChoiceArr != null && surveyChoiceArr.length > 0) {
                int i = 0;
                while (true) {
                    SurveyChoice[] surveyChoiceArr2 = this.choice;
                    if (i >= surveyChoiceArr2.length) {
                        break;
                    }
                    SurveyChoice surveyChoice = surveyChoiceArr2[i];
                    if (surveyChoice != null) {
                        codedOutputByteBufferNano.writeMessage(4, surveyChoice);
                    }
                    i++;
                }
            }
            int i2 = this.closeDuration;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            long j2 = this.researchId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.description.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.description);
            }
            SurveyChoice[] surveyChoiceArr = this.choice;
            if (surveyChoiceArr != null && surveyChoiceArr.length > 0) {
                int i = 0;
                while (true) {
                    SurveyChoice[] surveyChoiceArr2 = this.choice;
                    if (i >= surveyChoiceArr2.length) {
                        break;
                    }
                    SurveyChoice surveyChoice = surveyChoiceArr2[i];
                    if (surveyChoice != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, surveyChoice);
                    }
                    i++;
                }
            }
            int i2 = this.closeDuration;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
            }
            long j2 = this.researchId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SurveyClientPushInfoSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.description = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    SurveyChoice[] surveyChoiceArr = this.choice;
                    int length = surveyChoiceArr == null ? 0 : surveyChoiceArr.length;
                    SurveyChoice[] surveyChoiceArr2 = new SurveyChoice[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.choice, 0, surveyChoiceArr2, 0, length);
                    }
                    while (length < surveyChoiceArr2.length - 1) {
                        surveyChoiceArr2[length] = new SurveyChoice();
                        codedInputByteBufferNano.readMessage(surveyChoiceArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    surveyChoiceArr2[length] = new SurveyChoice();
                    codedInputByteBufferNano.readMessage(surveyChoiceArr2[length]);
                    this.choice = surveyChoiceArr2;
                } else if (tag == 40) {
                    this.closeDuration = codedInputByteBufferNano.readUInt32();
                } else if (tag == 48) {
                    this.researchId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SurveyClientPushInfoSignal parseFrom(byte[] bArr) {
            return (SurveyClientPushInfoSignal) MessageNano.mergeFrom(new SurveyClientPushInfoSignal(), bArr);
        }

        public static SurveyClientPushInfoSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SurveyClientPushInfoSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AuthorGeneralNoticeSignal extends MessageNano {
        private static volatile AuthorGeneralNoticeSignal[] _emptyArray;
        public String buttonText;
        public String description;
        public UserInfos.PicUrl[] iconUrl;
        public String liveStreamId;
        public String title;

        public static AuthorGeneralNoticeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuthorGeneralNoticeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuthorGeneralNoticeSignal() {
            clear();
        }

        public final AuthorGeneralNoticeSignal clear() {
            this.liveStreamId = "";
            this.title = "";
            this.description = "";
            this.buttonText = "";
            this.iconUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.description.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.description);
            }
            if (!this.buttonText.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.buttonText);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.description.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.description);
            }
            if (!this.buttonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonText);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuthorGeneralNoticeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.description = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.buttonText = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.iconUrl = picUrlArr2;
                }
            }
        }

        public static AuthorGeneralNoticeSignal parseFrom(byte[] bArr) {
            return (AuthorGeneralNoticeSignal) MessageNano.mergeFrom(new AuthorGeneralNoticeSignal(), bArr);
        }

        public static AuthorGeneralNoticeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuthorGeneralNoticeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRoomUserGuideSignal extends MessageNano {
        private static volatile LiveRoomUserGuideSignal[] _emptyArray;
        public int durationMills;
        public String liveStreamId;
        public String title;
        public int type;

        public static LiveRoomUserGuideSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRoomUserGuideSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRoomUserGuideSignal() {
            clear();
        }

        public final LiveRoomUserGuideSignal clear() {
            this.title = "";
            this.durationMills = 0;
            this.type = 0;
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.title);
            }
            int i = this.durationMills;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.type;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
            }
            int i = this.durationMills;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.type;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRoomUserGuideSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.durationMills = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveRoomUserGuideSignal parseFrom(byte[] bArr) {
            return (LiveRoomUserGuideSignal) MessageNano.mergeFrom(new LiveRoomUserGuideSignal(), bArr);
        }

        public static LiveRoomUserGuideSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRoomUserGuideSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class WelfareItemStockProgressMessage extends MessageNano {
        private static volatile WelfareItemStockProgressMessage[] _emptyArray;
        public String activityId;
        public String itemId;
        public long originalStock;
        public int soldStatus;
        public long soldStock;
        public int welfareItemType;

        public static WelfareItemStockProgressMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new WelfareItemStockProgressMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public WelfareItemStockProgressMessage() {
            clear();
        }

        public final WelfareItemStockProgressMessage clear() {
            this.itemId = "";
            this.activityId = "";
            this.originalStock = 0L;
            this.soldStock = 0L;
            this.soldStatus = 0;
            this.welfareItemType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            long j = this.originalStock;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.soldStock;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            int i = this.soldStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(5, i);
            }
            int i2 = this.welfareItemType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            long j = this.originalStock;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.soldStock;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            int i = this.soldStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
            }
            int i2 = this.welfareItemType;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final WelfareItemStockProgressMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.originalStock = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.soldStock = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.soldStatus = int32;
                    }
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1) {
                        this.welfareItemType = int322;
                    }
                }
            }
        }

        public static WelfareItemStockProgressMessage parseFrom(byte[] bArr) {
            return (WelfareItemStockProgressMessage) MessageNano.mergeFrom(new WelfareItemStockProgressMessage(), bArr);
        }

        public static WelfareItemStockProgressMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new WelfareItemStockProgressMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SellerRankSignal extends MessageNano {
        private static volatile SellerRankSignal[] _emptyArray;
        public boolean inRank;
        public int jumpTabId;
        public int pendantStatus;
        public String rankPendantName;
        public SellerRankStrategy sellerRankStrategy;
        public SellerRankStyle sellerRankStyle;
        public SellerTabRank[] sellerTabRank;

        public static SellerRankSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SellerRankSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SellerRankSignal() {
            clear();
        }

        public final SellerRankSignal clear() {
            this.jumpTabId = 0;
            this.rankPendantName = "";
            this.sellerTabRank = SellerTabRank.emptyArray();
            this.sellerRankStyle = null;
            this.sellerRankStrategy = null;
            this.pendantStatus = 0;
            this.inRank = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.jumpTabId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.rankPendantName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.rankPendantName);
            }
            SellerTabRank[] sellerTabRankArr = this.sellerTabRank;
            if (sellerTabRankArr != null && sellerTabRankArr.length > 0) {
                int i2 = 0;
                while (true) {
                    SellerTabRank[] sellerTabRankArr2 = this.sellerTabRank;
                    if (i2 >= sellerTabRankArr2.length) {
                        break;
                    }
                    SellerTabRank sellerTabRank = sellerTabRankArr2[i2];
                    if (sellerTabRank != null) {
                        codedOutputByteBufferNano.writeMessage(3, sellerTabRank);
                    }
                    i2++;
                }
            }
            SellerRankStyle sellerRankStyle = this.sellerRankStyle;
            if (sellerRankStyle != null) {
                codedOutputByteBufferNano.writeMessage(4, sellerRankStyle);
            }
            SellerRankStrategy sellerRankStrategy = this.sellerRankStrategy;
            if (sellerRankStrategy != null) {
                codedOutputByteBufferNano.writeMessage(5, sellerRankStrategy);
            }
            int i3 = this.pendantStatus;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i3);
            }
            boolean z = this.inRank;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.jumpTabId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.rankPendantName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.rankPendantName);
            }
            SellerTabRank[] sellerTabRankArr = this.sellerTabRank;
            if (sellerTabRankArr != null && sellerTabRankArr.length > 0) {
                int i2 = 0;
                while (true) {
                    SellerTabRank[] sellerTabRankArr2 = this.sellerTabRank;
                    if (i2 >= sellerTabRankArr2.length) {
                        break;
                    }
                    SellerTabRank sellerTabRank = sellerTabRankArr2[i2];
                    if (sellerTabRank != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sellerTabRank);
                    }
                    i2++;
                }
            }
            SellerRankStyle sellerRankStyle = this.sellerRankStyle;
            if (sellerRankStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, sellerRankStyle);
            }
            SellerRankStrategy sellerRankStrategy = this.sellerRankStrategy;
            if (sellerRankStrategy != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, sellerRankStrategy);
            }
            int i3 = this.pendantStatus;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
            }
            boolean z = this.inRank;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SellerRankSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.jumpTabId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.rankPendantName = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    SellerTabRank[] sellerTabRankArr = this.sellerTabRank;
                    int length = sellerTabRankArr == null ? 0 : sellerTabRankArr.length;
                    SellerTabRank[] sellerTabRankArr2 = new SellerTabRank[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.sellerTabRank, 0, sellerTabRankArr2, 0, length);
                    }
                    while (length < sellerTabRankArr2.length - 1) {
                        sellerTabRankArr2[length] = new SellerTabRank();
                        codedInputByteBufferNano.readMessage(sellerTabRankArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sellerTabRankArr2[length] = new SellerTabRank();
                    codedInputByteBufferNano.readMessage(sellerTabRankArr2[length]);
                    this.sellerTabRank = sellerTabRankArr2;
                } else if (tag == 34) {
                    if (this.sellerRankStyle == null) {
                        this.sellerRankStyle = new SellerRankStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.sellerRankStyle);
                } else if (tag == 42) {
                    if (this.sellerRankStrategy == null) {
                        this.sellerRankStrategy = new SellerRankStrategy();
                    }
                    codedInputByteBufferNano.readMessage(this.sellerRankStrategy);
                } else if (tag == 48) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.pendantStatus = int32;
                    }
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.inRank = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static SellerRankSignal parseFrom(byte[] bArr) {
            return (SellerRankSignal) MessageNano.mergeFrom(new SellerRankSignal(), bArr);
        }

        public static SellerRankSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SellerRankSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SellerTabRank extends MessageNano {
        private static volatile SellerTabRank[] _emptyArray;
        public String displayRank;
        public boolean hasData;
        public String hintContent;
        public UserInfos.PicUrl[] labelIcon;
        public long rank;
        public int tabId;

        public static SellerTabRank[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SellerTabRank[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SellerTabRank() {
            clear();
        }

        public final SellerTabRank clear() {
            this.tabId = 0;
            this.hasData = false;
            this.rank = 0L;
            this.displayRank = "";
            this.hintContent = "";
            this.labelIcon = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.tabId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            boolean z = this.hasData;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            long j = this.rank;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.displayRank.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.displayRank);
            }
            if (!this.hintContent.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.hintContent);
            }
            UserInfos.PicUrl[] picUrlArr = this.labelIcon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.labelIcon;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.tabId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            boolean z = this.hasData;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            long j = this.rank;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.displayRank.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayRank);
            }
            if (!this.hintContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.hintContent);
            }
            UserInfos.PicUrl[] picUrlArr = this.labelIcon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.labelIcon;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SellerTabRank mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.tabId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.hasData = codedInputByteBufferNano.readBool();
                } else if (tag == 24) {
                    this.rank = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    this.displayRank = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.hintContent = codedInputByteBufferNano.readString();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr = this.labelIcon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.labelIcon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.labelIcon = picUrlArr2;
                }
            }
        }

        public static SellerTabRank parseFrom(byte[] bArr) {
            return (SellerTabRank) MessageNano.mergeFrom(new SellerTabRank(), bArr);
        }

        public static SellerTabRank parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SellerTabRank().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SellerRankStyle extends MessageNano {
        private static volatile SellerRankStyle[] _emptyArray;
        public String backgroundEndColor;
        public String backgroundStartColor;
        public UserInfos.PicUrl[] headIcon;
        public int styleVersion;
        public UserInfos.PicUrl[] tailIcon;

        public static SellerRankStyle[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SellerRankStyle[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SellerRankStyle() {
            clear();
        }

        public final SellerRankStyle clear() {
            this.headIcon = UserInfos.PicUrl.emptyArray();
            this.tailIcon = UserInfos.PicUrl.emptyArray();
            this.backgroundStartColor = "";
            this.backgroundEndColor = "";
            this.styleVersion = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.headIcon;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.headIcon;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.tailIcon;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.tailIcon;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl2);
                    }
                    i++;
                }
            }
            if (!this.backgroundStartColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.backgroundStartColor);
            }
            if (!this.backgroundEndColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.backgroundEndColor);
            }
            int i3 = this.styleVersion;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.headIcon;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.headIcon;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.tailIcon;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.tailIcon;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                    }
                    i++;
                }
            }
            if (!this.backgroundStartColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.backgroundStartColor);
            }
            if (!this.backgroundEndColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.backgroundEndColor);
            }
            int i3 = this.styleVersion;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SellerRankStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.headIcon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.headIcon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.headIcon = picUrlArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr3 = this.tailIcon;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.tailIcon, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.tailIcon = picUrlArr4;
                } else if (tag == 26) {
                    this.backgroundStartColor = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.backgroundEndColor = codedInputByteBufferNano.readString();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.styleVersion = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SellerRankStyle parseFrom(byte[] bArr) {
            return (SellerRankStyle) MessageNano.mergeFrom(new SellerRankStyle(), bArr);
        }

        public static SellerRankStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SellerRankStyle().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SellerRankStrategy extends MessageNano {
        private static volatile SellerRankStrategy[] _emptyArray;
        public int userGuideDayMaxCount;
        public int userGuideIntervalMillis;
        public int userGuideRoomMaxCount;
        public long[] userGuideUpdateDelayMillis;

        public static SellerRankStrategy[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SellerRankStrategy[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SellerRankStrategy() {
            clear();
        }

        public final SellerRankStrategy clear() {
            this.userGuideUpdateDelayMillis = WireFormatNano.EMPTY_LONG_ARRAY;
            this.userGuideRoomMaxCount = 0;
            this.userGuideDayMaxCount = 0;
            this.userGuideIntervalMillis = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long[] jArr = this.userGuideUpdateDelayMillis;
            if (jArr != null && jArr.length > 0) {
                int i = 0;
                while (true) {
                    long[] jArr2 = this.userGuideUpdateDelayMillis;
                    if (i >= jArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt64(1, jArr2[i]);
                    i++;
                }
            }
            int i2 = this.userGuideRoomMaxCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.userGuideDayMaxCount;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.userGuideIntervalMillis;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            long[] jArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            long[] jArr2 = this.userGuideUpdateDelayMillis;
            if (jArr2 != null && jArr2.length > 0) {
                int i = 0;
                int iComputeUInt64SizeNoTag = 0;
                while (true) {
                    jArr = this.userGuideUpdateDelayMillis;
                    if (i >= jArr.length) {
                        break;
                    }
                    iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
            }
            int i2 = this.userGuideRoomMaxCount;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.userGuideDayMaxCount;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.userGuideIntervalMillis;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SellerRankStrategy mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    long[] jArr = this.userGuideUpdateDelayMillis;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.userGuideUpdateDelayMillis, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.userGuideUpdateDelayMillis = jArr2;
                } else if (tag == 10) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.userGuideUpdateDelayMillis;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.userGuideUpdateDelayMillis, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.userGuideUpdateDelayMillis = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag == 16) {
                    this.userGuideRoomMaxCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.userGuideDayMaxCount = codedInputByteBufferNano.readUInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.userGuideIntervalMillis = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SellerRankStrategy parseFrom(byte[] bArr) {
            return (SellerRankStrategy) MessageNano.mergeFrom(new SellerRankStrategy(), bArr);
        }

        public static SellerRankStrategy parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SellerRankStrategy().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UserPic extends MessageNano {
        private static volatile UserPic[] _emptyArray;
        public UserInfos.PicUrl[] picUrlList;

        public static UserPic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserPic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UserPic() {
            clear();
        }

        public final UserPic clear() {
            this.picUrlList = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.picUrlList;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrlList;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.picUrlList;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrlList;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UserPic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.picUrlList;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.picUrlList, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.picUrlList = picUrlArr2;
                }
            }
        }

        public static UserPic parseFrom(byte[] bArr) {
            return (UserPic) MessageNano.mergeFrom(new UserPic(), bArr);
        }

        public static UserPic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UserPic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class WelfareBargainProgressMessage extends MessageNano {
        private static volatile WelfareBargainProgressMessage[] _emptyArray;
        public String activityId;
        public int bargainCount;
        public String bargainSummary;
        public String itemId;
        public int itemStatus;
        public String leftPrice;
        public int originalStock;
        public int progress;
        public int soldStock;
        public UserPic[] userIcon;

        public static WelfareBargainProgressMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new WelfareBargainProgressMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public WelfareBargainProgressMessage() {
            clear();
        }

        public final WelfareBargainProgressMessage clear() {
            this.itemId = "";
            this.activityId = "";
            this.originalStock = 0;
            this.soldStock = 0;
            this.leftPrice = "";
            this.bargainSummary = "";
            this.progress = 0;
            this.bargainCount = 0;
            this.userIcon = UserPic.emptyArray();
            this.itemStatus = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            int i = this.originalStock;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            int i2 = this.soldStock;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.leftPrice.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.leftPrice);
            }
            if (!this.bargainSummary.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.bargainSummary);
            }
            int i3 = this.progress;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i3);
            }
            int i4 = this.bargainCount;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i4);
            }
            UserPic[] userPicArr = this.userIcon;
            if (userPicArr != null && userPicArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UserPic[] userPicArr2 = this.userIcon;
                    if (i5 >= userPicArr2.length) {
                        break;
                    }
                    UserPic userPic = userPicArr2[i5];
                    if (userPic != null) {
                        codedOutputByteBufferNano.writeMessage(9, userPic);
                    }
                    i5++;
                }
            }
            int i6 = this.itemStatus;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeUInt32(10, i6);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            int i = this.originalStock;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            int i2 = this.soldStock;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            if (!this.leftPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.leftPrice);
            }
            if (!this.bargainSummary.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.bargainSummary);
            }
            int i3 = this.progress;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
            }
            int i4 = this.bargainCount;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i4);
            }
            UserPic[] userPicArr = this.userIcon;
            if (userPicArr != null && userPicArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UserPic[] userPicArr2 = this.userIcon;
                    if (i5 >= userPicArr2.length) {
                        break;
                    }
                    UserPic userPic = userPicArr2[i5];
                    if (userPic != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, userPic);
                    }
                    i5++;
                }
            }
            int i6 = this.itemStatus;
            return i6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i6) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final WelfareBargainProgressMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.itemId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.activityId = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.originalStock = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.soldStock = codedInputByteBufferNano.readUInt32();
                        break;
                    case 42:
                        this.leftPrice = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.bargainSummary = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.progress = codedInputByteBufferNano.readUInt32();
                        break;
                    case 64:
                        this.bargainCount = codedInputByteBufferNano.readUInt32();
                        break;
                    case 74:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        UserPic[] userPicArr = this.userIcon;
                        int length = userPicArr == null ? 0 : userPicArr.length;
                        UserPic[] userPicArr2 = new UserPic[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.userIcon, 0, userPicArr2, 0, length);
                        }
                        while (length < userPicArr2.length - 1) {
                            userPicArr2[length] = new UserPic();
                            codedInputByteBufferNano.readMessage(userPicArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        userPicArr2[length] = new UserPic();
                        codedInputByteBufferNano.readMessage(userPicArr2[length]);
                        this.userIcon = userPicArr2;
                        break;
                    case 80:
                        this.itemStatus = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static WelfareBargainProgressMessage parseFrom(byte[] bArr) {
            return (WelfareBargainProgressMessage) MessageNano.mergeFrom(new WelfareBargainProgressMessage(), bArr);
        }

        public static WelfareBargainProgressMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new WelfareBargainProgressMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveKwaishopShareRedPackSignal extends MessageNano {
        private static volatile LiveKwaishopShareRedPackSignal[] _emptyArray;
        public String amountColor;
        public String animationPicUrl;
        public String displayAwardAmount;
        public String displayUnit;
        public long hiddenDelayMillis;
        public String id;
        public boolean isShow;
        public int redPackType;
        public long requestAnimationMaxDelayMillis;
        public String title;
        public String titleColor;
        public String widgetBackgroundUrl;

        public static LiveKwaishopShareRedPackSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveKwaishopShareRedPackSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveKwaishopShareRedPackSignal() {
            clear();
        }

        public final LiveKwaishopShareRedPackSignal clear() {
            this.id = "";
            this.displayAwardAmount = "";
            this.displayUnit = "";
            this.title = "";
            this.isShow = false;
            this.hiddenDelayMillis = 0L;
            this.redPackType = 0;
            this.animationPicUrl = "";
            this.requestAnimationMaxDelayMillis = 0L;
            this.widgetBackgroundUrl = "";
            this.amountColor = "";
            this.titleColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            if (!this.displayAwardAmount.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.displayAwardAmount);
            }
            if (!this.displayUnit.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.displayUnit);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.title);
            }
            boolean z = this.isShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            long j = this.hiddenDelayMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            int i = this.redPackType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i);
            }
            if (!this.animationPicUrl.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.animationPicUrl);
            }
            long j2 = this.requestAnimationMaxDelayMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j2);
            }
            if (!this.widgetBackgroundUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.widgetBackgroundUrl);
            }
            if (!this.amountColor.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.amountColor);
            }
            if (!this.titleColor.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.titleColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            if (!this.displayAwardAmount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.displayAwardAmount);
            }
            if (!this.displayUnit.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayUnit);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.title);
            }
            boolean z = this.isShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            long j = this.hiddenDelayMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            int i = this.redPackType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i);
            }
            if (!this.animationPicUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.animationPicUrl);
            }
            long j2 = this.requestAnimationMaxDelayMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j2);
            }
            if (!this.widgetBackgroundUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.widgetBackgroundUrl);
            }
            if (!this.amountColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.amountColor);
            }
            return !this.titleColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.titleColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveKwaishopShareRedPackSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.id = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.displayAwardAmount = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.displayUnit = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.isShow = codedInputByteBufferNano.readBool();
                        break;
                    case 48:
                        this.hiddenDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.redPackType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 66:
                        this.animationPicUrl = codedInputByteBufferNano.readString();
                        break;
                    case 72:
                        this.requestAnimationMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 82:
                        this.widgetBackgroundUrl = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.amountColor = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.titleColor = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveKwaishopShareRedPackSignal parseFrom(byte[] bArr) {
            return (LiveKwaishopShareRedPackSignal) MessageNano.mergeFrom(new LiveKwaishopShareRedPackSignal(), bArr);
        }

        public static LiveKwaishopShareRedPackSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveKwaishopShareRedPackSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AuctionBidInfo extends MessageNano {
        private static volatile AuctionBidInfo[] _emptyArray;
        public int bidCount;
        public String bidPrice;
        public UserInfos.PicUrl[] headUrls;
        public long userId;
        public String userName;

        public static AuctionBidInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuctionBidInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuctionBidInfo() {
            clear();
        }

        public final AuctionBidInfo clear() {
            this.userId = 0L;
            this.userName = "";
            this.headUrls = UserInfos.PicUrl.emptyArray();
            this.bidPrice = "";
            this.bidCount = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.userName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.userName);
            }
            UserInfos.PicUrl[] picUrlArr = this.headUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.headUrls;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i++;
                }
            }
            if (!this.bidPrice.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bidPrice);
            }
            int i2 = this.bidCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.userName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.userName);
            }
            UserInfos.PicUrl[] picUrlArr = this.headUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.headUrls;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i++;
                }
            }
            if (!this.bidPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bidPrice);
            }
            int i2 = this.bidCount;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuctionBidInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.userName = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.headUrls;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.headUrls, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.headUrls = picUrlArr2;
                } else if (tag == 34) {
                    this.bidPrice = codedInputByteBufferNano.readString();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bidCount = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static AuctionBidInfo parseFrom(byte[] bArr) {
            return (AuctionBidInfo) MessageNano.mergeFrom(new AuctionBidInfo(), bArr);
        }

        public static AuctionBidInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuctionBidInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AuctionInfoSignal extends MessageNano {
        private static volatile AuctionInfoSignal[] _emptyArray;
        public AuctionBidInfo[] bidInfos;
        public int bidPersonCount;
        public String bidRule;
        public String bidStartPrice;
        public String comment;
        public int delayDurationSecond;
        public int delayEndDurationSecond;
        public long duration;
        public String endPrice;
        public long endTime;
        public boolean hasAuctionSuspendFeature;
        public boolean hasEnableDelayEndDuration;
        public long id;
        public ItemInfo itemInfo;
        public boolean needQueryActivityLabel;
        public String nowPrice;
        public long orderId;
        public long orderOverTimeMillis;
        public int priceIncrement;
        public long realEndTime;
        public long requestDelayMills;
        public int requestDelaySecond;
        public long startTime;
        public String toPayUrl;
        public String toastSpeechcraft;
        public boolean useComment;
        public UserInfos.PicUrl[] userHeadUrl;
        public long userId;
        public String userName;

        public static AuctionInfoSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuctionInfoSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuctionInfoSignal() {
            clear();
        }

        public final AuctionInfoSignal clear() {
            this.id = 0L;
            this.itemInfo = null;
            this.startTime = 0L;
            this.duration = 0L;
            this.endTime = 0L;
            this.bidStartPrice = "";
            this.priceIncrement = 0;
            this.bidRule = "";
            this.delayEndDurationSecond = 0;
            this.delayDurationSecond = 0;
            this.requestDelaySecond = 0;
            this.nowPrice = "";
            this.bidInfos = AuctionBidInfo.emptyArray();
            this.bidPersonCount = 0;
            this.endPrice = "";
            this.toPayUrl = "";
            this.userHeadUrl = UserInfos.PicUrl.emptyArray();
            this.userId = 0L;
            this.userName = "";
            this.orderOverTimeMillis = 0L;
            this.orderId = 0L;
            this.toastSpeechcraft = "";
            this.useComment = false;
            this.comment = "";
            this.needQueryActivityLabel = false;
            this.requestDelayMills = 0L;
            this.hasAuctionSuspendFeature = false;
            this.hasEnableDelayEndDuration = false;
            this.realEndTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, itemInfo);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            long j3 = this.duration;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j3);
            }
            long j4 = this.endTime;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j4);
            }
            if (!this.bidStartPrice.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.bidStartPrice);
            }
            int i = this.priceIncrement;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i);
            }
            if (!this.bidRule.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.bidRule);
            }
            int i2 = this.delayEndDurationSecond;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(9, i2);
            }
            int i3 = this.delayDurationSecond;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(10, i3);
            }
            int i4 = this.requestDelaySecond;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(11, i4);
            }
            if (!this.nowPrice.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.nowPrice);
            }
            AuctionBidInfo[] auctionBidInfoArr = this.bidInfos;
            int i5 = 0;
            if (auctionBidInfoArr != null && auctionBidInfoArr.length > 0) {
                int i6 = 0;
                while (true) {
                    AuctionBidInfo[] auctionBidInfoArr2 = this.bidInfos;
                    if (i6 >= auctionBidInfoArr2.length) {
                        break;
                    }
                    AuctionBidInfo auctionBidInfo = auctionBidInfoArr2[i6];
                    if (auctionBidInfo != null) {
                        codedOutputByteBufferNano.writeMessage(13, auctionBidInfo);
                    }
                    i6++;
                }
            }
            int i7 = this.bidPersonCount;
            if (i7 != 0) {
                codedOutputByteBufferNano.writeUInt32(14, i7);
            }
            if (!this.endPrice.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.endPrice);
            }
            if (!this.toPayUrl.equals("")) {
                codedOutputByteBufferNano.writeString(16, this.toPayUrl);
            }
            UserInfos.PicUrl[] picUrlArr = this.userHeadUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.userHeadUrl;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(17, picUrl);
                    }
                    i5++;
                }
            }
            long j5 = this.userId;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(18, j5);
            }
            if (!this.userName.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.userName);
            }
            long j6 = this.orderOverTimeMillis;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(20, j6);
            }
            long j7 = this.orderId;
            if (j7 != 0) {
                codedOutputByteBufferNano.writeUInt64(21, j7);
            }
            if (!this.toastSpeechcraft.equals("")) {
                codedOutputByteBufferNano.writeString(22, this.toastSpeechcraft);
            }
            boolean z = this.useComment;
            if (z) {
                codedOutputByteBufferNano.writeBool(23, z);
            }
            if (!this.comment.equals("")) {
                codedOutputByteBufferNano.writeString(24, this.comment);
            }
            boolean z2 = this.needQueryActivityLabel;
            if (z2) {
                codedOutputByteBufferNano.writeBool(25, z2);
            }
            long j8 = this.requestDelayMills;
            if (j8 != 0) {
                codedOutputByteBufferNano.writeUInt64(26, j8);
            }
            boolean z3 = this.hasAuctionSuspendFeature;
            if (z3) {
                codedOutputByteBufferNano.writeBool(27, z3);
            }
            boolean z4 = this.hasEnableDelayEndDuration;
            if (z4) {
                codedOutputByteBufferNano.writeBool(28, z4);
            }
            long j9 = this.realEndTime;
            if (j9 != 0) {
                codedOutputByteBufferNano.writeUInt64(29, j9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, itemInfo);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            long j3 = this.duration;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
            }
            long j4 = this.endTime;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j4);
            }
            if (!this.bidStartPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.bidStartPrice);
            }
            int i = this.priceIncrement;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i);
            }
            if (!this.bidRule.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.bidRule);
            }
            int i2 = this.delayEndDurationSecond;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i2);
            }
            int i3 = this.delayDurationSecond;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i3);
            }
            int i4 = this.requestDelaySecond;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i4);
            }
            if (!this.nowPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.nowPrice);
            }
            AuctionBidInfo[] auctionBidInfoArr = this.bidInfos;
            int i5 = 0;
            if (auctionBidInfoArr != null && auctionBidInfoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    AuctionBidInfo[] auctionBidInfoArr2 = this.bidInfos;
                    if (i6 >= auctionBidInfoArr2.length) {
                        break;
                    }
                    AuctionBidInfo auctionBidInfo = auctionBidInfoArr2[i6];
                    if (auctionBidInfo != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(13, auctionBidInfo);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            int i7 = this.bidPersonCount;
            if (i7 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i7);
            }
            if (!this.endPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.endPrice);
            }
            if (!this.toPayUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.toPayUrl);
            }
            UserInfos.PicUrl[] picUrlArr = this.userHeadUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.userHeadUrl;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, picUrl);
                    }
                    i5++;
                }
            }
            long j5 = this.userId;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(18, j5);
            }
            if (!this.userName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.userName);
            }
            long j6 = this.orderOverTimeMillis;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(20, j6);
            }
            long j7 = this.orderId;
            if (j7 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(21, j7);
            }
            if (!this.toastSpeechcraft.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.toastSpeechcraft);
            }
            boolean z = this.useComment;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, z);
            }
            if (!this.comment.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(24, this.comment);
            }
            boolean z2 = this.needQueryActivityLabel;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, z2);
            }
            long j8 = this.requestDelayMills;
            if (j8 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(26, j8);
            }
            boolean z3 = this.hasAuctionSuspendFeature;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(27, z3);
            }
            boolean z4 = this.hasEnableDelayEndDuration;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(28, z4);
            }
            long j9 = this.realEndTime;
            return j9 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(29, j9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuctionInfoSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.id = codedInputByteBufferNano.readUInt64();
                        break;
                    case 18:
                        if (this.itemInfo == null) {
                            this.itemInfo = new ItemInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.itemInfo);
                        break;
                    case 24:
                        this.startTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 32:
                        this.duration = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.endTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 50:
                        this.bidStartPrice = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.priceIncrement = codedInputByteBufferNano.readUInt32();
                        break;
                    case 66:
                        this.bidRule = codedInputByteBufferNano.readString();
                        break;
                    case 72:
                        this.delayEndDurationSecond = codedInputByteBufferNano.readUInt32();
                        break;
                    case 80:
                        this.delayDurationSecond = codedInputByteBufferNano.readUInt32();
                        break;
                    case 88:
                        this.requestDelaySecond = codedInputByteBufferNano.readUInt32();
                        break;
                    case 98:
                        this.nowPrice = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        AuctionBidInfo[] auctionBidInfoArr = this.bidInfos;
                        int length = auctionBidInfoArr == null ? 0 : auctionBidInfoArr.length;
                        AuctionBidInfo[] auctionBidInfoArr2 = new AuctionBidInfo[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.bidInfos, 0, auctionBidInfoArr2, 0, length);
                        }
                        while (length < auctionBidInfoArr2.length - 1) {
                            auctionBidInfoArr2[length] = new AuctionBidInfo();
                            codedInputByteBufferNano.readMessage(auctionBidInfoArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        auctionBidInfoArr2[length] = new AuctionBidInfo();
                        codedInputByteBufferNano.readMessage(auctionBidInfoArr2[length]);
                        this.bidInfos = auctionBidInfoArr2;
                        break;
                    case 112:
                        this.bidPersonCount = codedInputByteBufferNano.readUInt32();
                        break;
                    case 122:
                        this.endPrice = codedInputByteBufferNano.readString();
                        break;
                    case 130:
                        this.toPayUrl = codedInputByteBufferNano.readString();
                        break;
                    case 138:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                        UserInfos.PicUrl[] picUrlArr = this.userHeadUrl;
                        int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.userHeadUrl, 0, picUrlArr2, 0, length2);
                        }
                        while (length2 < picUrlArr2.length - 1) {
                            picUrlArr2[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        this.userHeadUrl = picUrlArr2;
                        break;
                    case 144:
                        this.userId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 154:
                        this.userName = codedInputByteBufferNano.readString();
                        break;
                    case 160:
                        this.orderOverTimeMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 168:
                        this.orderId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 178:
                        this.toastSpeechcraft = codedInputByteBufferNano.readString();
                        break;
                    case 184:
                        this.useComment = codedInputByteBufferNano.readBool();
                        break;
                    case 194:
                        this.comment = codedInputByteBufferNano.readString();
                        break;
                    case 200:
                        this.needQueryActivityLabel = codedInputByteBufferNano.readBool();
                        break;
                    case 208:
                        this.requestDelayMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 216:
                        this.hasAuctionSuspendFeature = codedInputByteBufferNano.readBool();
                        break;
                    case 224:
                        this.hasEnableDelayEndDuration = codedInputByteBufferNano.readBool();
                        break;
                    case 232:
                        this.realEndTime = codedInputByteBufferNano.readUInt64();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static AuctionInfoSignal parseFrom(byte[] bArr) {
            return (AuctionInfoSignal) MessageNano.mergeFrom(new AuctionInfoSignal(), bArr);
        }

        public static AuctionInfoSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuctionInfoSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaiLiveShopAuction extends MessageNano {
        private static volatile SCKwaiLiveShopAuction[] _emptyArray;
        public long displayIntervalMillis;
        public String endPrice;
        public ItemInfo itemInfo;
        public long orderId;
        public long orderOverTimeMillis;
        public String toPayUrl;

        public static SCKwaiLiveShopAuction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaiLiveShopAuction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaiLiveShopAuction() {
            clear();
        }

        public final SCKwaiLiveShopAuction clear() {
            this.itemInfo = null;
            this.endPrice = "";
            this.toPayUrl = "";
            this.orderOverTimeMillis = 0L;
            this.displayIntervalMillis = 0L;
            this.orderId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            if (!this.endPrice.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.endPrice);
            }
            if (!this.toPayUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.toPayUrl);
            }
            long j = this.orderOverTimeMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.displayIntervalMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.orderId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            if (!this.endPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.endPrice);
            }
            if (!this.toPayUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.toPayUrl);
            }
            long j = this.orderOverTimeMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.displayIntervalMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.orderId;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaiLiveShopAuction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 18) {
                    this.endPrice = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.toPayUrl = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.orderOverTimeMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.displayIntervalMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.orderId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCKwaiLiveShopAuction parseFrom(byte[] bArr) {
            return (SCKwaiLiveShopAuction) MessageNano.mergeFrom(new SCKwaiLiveShopAuction(), bArr);
        }

        public static SCKwaiLiveShopAuction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaiLiveShopAuction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AuthorRedPackageMessage extends MessageNano {
        private static volatile AuthorRedPackageMessage[] _emptyArray;
        public int canGrabCount;
        public int price;
        public String redPackageId;
        public long requestAnimationMaxDelayMillis;
        public int status;

        public static AuthorRedPackageMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuthorRedPackageMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuthorRedPackageMessage() {
            clear();
        }

        public final AuthorRedPackageMessage clear() {
            this.redPackageId = "";
            this.status = 0;
            this.price = 0;
            this.canGrabCount = 0;
            this.requestAnimationMaxDelayMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.redPackageId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.redPackageId);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            int i2 = this.price;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            int i3 = this.canGrabCount;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i3);
            }
            long j = this.requestAnimationMaxDelayMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.redPackageId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.redPackageId);
            }
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            int i2 = this.price;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            int i3 = this.canGrabCount;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
            }
            long j = this.requestAnimationMaxDelayMillis;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuthorRedPackageMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.redPackageId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                        this.status = int32;
                    }
                } else if (tag == 24) {
                    this.price = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.canGrabCount = codedInputByteBufferNano.readUInt32();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.requestAnimationMaxDelayMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static AuthorRedPackageMessage parseFrom(byte[] bArr) {
            return (AuthorRedPackageMessage) MessageNano.mergeFrom(new AuthorRedPackageMessage(), bArr);
        }

        public static AuthorRedPackageMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuthorRedPackageMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLivePendant extends MessageNano {
        private static volatile SCKwaishopLivePendant[] _emptyArray;
        public CallbackTimeComponent callbackTimeComponent;
        public CarouselComponent[] carouselComponent;
        public PendantComponent[] component;
        public long displayMills;
        public Map<String, String> extraMap;
        public boolean isRandomServer;
        public String liveStreamId;
        public int pendSourceType;
        public String pendantLink;
        public int pendantType;
        public long randomDelayMills;

        public static SCKwaishopLivePendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLivePendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLivePendant() {
            clear();
        }

        public final SCKwaishopLivePendant clear() {
            this.pendantType = 0;
            this.displayMills = 0L;
            this.component = PendantComponent.emptyArray();
            this.pendantLink = "";
            this.pendSourceType = 0;
            this.extraMap = null;
            this.liveStreamId = "";
            this.randomDelayMills = 0L;
            this.carouselComponent = CarouselComponent.emptyArray();
            this.isRandomServer = false;
            this.callbackTimeComponent = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i = this.pendantType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.displayMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            PendantComponent[] pendantComponentArr = this.component;
            int i2 = 0;
            if (pendantComponentArr != null && pendantComponentArr.length > 0) {
                int i3 = 0;
                while (true) {
                    PendantComponent[] pendantComponentArr2 = this.component;
                    if (i3 >= pendantComponentArr2.length) {
                        break;
                    }
                    PendantComponent pendantComponent = pendantComponentArr2[i3];
                    if (pendantComponent != null) {
                        codedOutputByteBufferNano.writeMessage(3, pendantComponent);
                    }
                    i3++;
                }
            }
            if (!this.pendantLink.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.pendantLink);
            }
            int i4 = this.pendSourceType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i4);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 6, 9, 9);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.liveStreamId);
            }
            long j2 = this.randomDelayMills;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            CarouselComponent[] carouselComponentArr = this.carouselComponent;
            if (carouselComponentArr != null && carouselComponentArr.length > 0) {
                while (true) {
                    CarouselComponent[] carouselComponentArr2 = this.carouselComponent;
                    if (i2 >= carouselComponentArr2.length) {
                        break;
                    }
                    CarouselComponent carouselComponent = carouselComponentArr2[i2];
                    if (carouselComponent != null) {
                        codedOutputByteBufferNano.writeMessage(9, carouselComponent);
                    }
                    i2++;
                }
            }
            boolean z = this.isRandomServer;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            CallbackTimeComponent callbackTimeComponent = this.callbackTimeComponent;
            if (callbackTimeComponent != null) {
                codedOutputByteBufferNano.writeMessage(11, callbackTimeComponent);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.pendantType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.displayMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            PendantComponent[] pendantComponentArr = this.component;
            int i2 = 0;
            if (pendantComponentArr != null && pendantComponentArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    PendantComponent[] pendantComponentArr2 = this.component;
                    if (i3 >= pendantComponentArr2.length) {
                        break;
                    }
                    PendantComponent pendantComponent = pendantComponentArr2[i3];
                    if (pendantComponent != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, pendantComponent);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.pendantLink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.pendantLink);
            }
            int i4 = this.pendSourceType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 6, 9, 9);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.liveStreamId);
            }
            long j2 = this.randomDelayMills;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
            }
            CarouselComponent[] carouselComponentArr = this.carouselComponent;
            if (carouselComponentArr != null && carouselComponentArr.length > 0) {
                while (true) {
                    CarouselComponent[] carouselComponentArr2 = this.carouselComponent;
                    if (i2 >= carouselComponentArr2.length) {
                        break;
                    }
                    CarouselComponent carouselComponent = carouselComponentArr2[i2];
                    if (carouselComponent != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, carouselComponent);
                    }
                    i2++;
                }
            }
            boolean z = this.isRandomServer;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            CallbackTimeComponent callbackTimeComponent = this.callbackTimeComponent;
            return callbackTimeComponent != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(11, callbackTimeComponent) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLivePendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.pendantType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 16:
                        this.displayMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        PendantComponent[] pendantComponentArr = this.component;
                        int length = pendantComponentArr == null ? 0 : pendantComponentArr.length;
                        PendantComponent[] pendantComponentArr2 = new PendantComponent[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.component, 0, pendantComponentArr2, 0, length);
                        }
                        while (length < pendantComponentArr2.length - 1) {
                            pendantComponentArr2[length] = new PendantComponent();
                            codedInputByteBufferNano.readMessage(pendantComponentArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        pendantComponentArr2[length] = new PendantComponent();
                        codedInputByteBufferNano.readMessage(pendantComponentArr2[length]);
                        this.component = pendantComponentArr2;
                        break;
                    case 34:
                        this.pendantLink = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.pendSourceType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 50:
                        this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                        break;
                    case 58:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.randomDelayMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 74:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        CarouselComponent[] carouselComponentArr = this.carouselComponent;
                        int length2 = carouselComponentArr == null ? 0 : carouselComponentArr.length;
                        CarouselComponent[] carouselComponentArr2 = new CarouselComponent[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.carouselComponent, 0, carouselComponentArr2, 0, length2);
                        }
                        while (length2 < carouselComponentArr2.length - 1) {
                            carouselComponentArr2[length2] = new CarouselComponent();
                            codedInputByteBufferNano.readMessage(carouselComponentArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        carouselComponentArr2[length2] = new CarouselComponent();
                        codedInputByteBufferNano.readMessage(carouselComponentArr2[length2]);
                        this.carouselComponent = carouselComponentArr2;
                        break;
                    case 80:
                        this.isRandomServer = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        if (this.callbackTimeComponent == null) {
                            this.callbackTimeComponent = new CallbackTimeComponent();
                        }
                        codedInputByteBufferNano.readMessage(this.callbackTimeComponent);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCKwaishopLivePendant parseFrom(byte[] bArr) {
            return (SCKwaishopLivePendant) MessageNano.mergeFrom(new SCKwaishopLivePendant(), bArr);
        }

        public static SCKwaishopLivePendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLivePendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PendantComponent extends MessageNano {
        private static volatile PendantComponent[] _emptyArray;
        public int componentBizType;
        public int componentCode;
        public String componentPayload;
        public int componentPriority;

        public static PendantComponent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PendantComponent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PendantComponent() {
            clear();
        }

        public final PendantComponent clear() {
            this.componentCode = 0;
            this.componentPayload = "";
            this.componentBizType = 0;
            this.componentPriority = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.componentCode;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.componentPayload.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.componentPayload);
            }
            int i2 = this.componentBizType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            int i3 = this.componentPriority;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.componentCode;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.componentPayload.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.componentPayload);
            }
            int i2 = this.componentBizType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            int i3 = this.componentPriority;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PendantComponent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.componentCode = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.componentPayload = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.componentBizType = codedInputByteBufferNano.readUInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.componentPriority = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static PendantComponent parseFrom(byte[] bArr) {
            return (PendantComponent) MessageNano.mergeFrom(new PendantComponent(), bArr);
        }

        public static PendantComponent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PendantComponent().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CarouselComponent extends MessageNano {
        private static volatile CarouselComponent[] _emptyArray;
        public long carouselMills;
        public int carouselType;
        public PendantComponent[] component;

        public static CarouselComponent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CarouselComponent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CarouselComponent() {
            clear();
        }

        public final CarouselComponent clear() {
            this.carouselType = 0;
            this.carouselMills = 0L;
            this.component = PendantComponent.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.carouselType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.carouselMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            PendantComponent[] pendantComponentArr = this.component;
            if (pendantComponentArr != null && pendantComponentArr.length > 0) {
                int i2 = 0;
                while (true) {
                    PendantComponent[] pendantComponentArr2 = this.component;
                    if (i2 >= pendantComponentArr2.length) {
                        break;
                    }
                    PendantComponent pendantComponent = pendantComponentArr2[i2];
                    if (pendantComponent != null) {
                        codedOutputByteBufferNano.writeMessage(3, pendantComponent);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.carouselType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.carouselMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            PendantComponent[] pendantComponentArr = this.component;
            if (pendantComponentArr != null && pendantComponentArr.length > 0) {
                int i2 = 0;
                while (true) {
                    PendantComponent[] pendantComponentArr2 = this.component;
                    if (i2 >= pendantComponentArr2.length) {
                        break;
                    }
                    PendantComponent pendantComponent = pendantComponentArr2[i2];
                    if (pendantComponent != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pendantComponent);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CarouselComponent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.carouselType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.carouselMills = codedInputByteBufferNano.readUInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    PendantComponent[] pendantComponentArr = this.component;
                    int length = pendantComponentArr == null ? 0 : pendantComponentArr.length;
                    PendantComponent[] pendantComponentArr2 = new PendantComponent[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.component, 0, pendantComponentArr2, 0, length);
                    }
                    while (length < pendantComponentArr2.length - 1) {
                        pendantComponentArr2[length] = new PendantComponent();
                        codedInputByteBufferNano.readMessage(pendantComponentArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    pendantComponentArr2[length] = new PendantComponent();
                    codedInputByteBufferNano.readMessage(pendantComponentArr2[length]);
                    this.component = pendantComponentArr2;
                }
            }
        }

        public static CarouselComponent parseFrom(byte[] bArr) {
            return (CarouselComponent) MessageNano.mergeFrom(new CarouselComponent(), bArr);
        }

        public static CarouselComponent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CarouselComponent().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AdPicUrl extends MessageNano {
        private static volatile AdPicUrl[] _emptyArray;
        public String cdn;
        public String url;

        public static AdPicUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AdPicUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AdPicUrl() {
            clear();
        }

        public final AdPicUrl clear() {
            this.cdn = "";
            this.url = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.cdn.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.cdn);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.cdn.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
            }
            return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AdPicUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.cdn = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.url = codedInputByteBufferNano.readString();
                }
            }
        }

        public static AdPicUrl parseFrom(byte[] bArr) {
            return (AdPicUrl) MessageNano.mergeFrom(new AdPicUrl(), bArr);
        }

        public static AdPicUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AdPicUrl().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MassRedPackSection extends MessageNano {
        private static volatile MassRedPackSection[] _emptyArray;
        public String activityId;
        public int afterTime;
        public int aheadTime;
        public String sectionId;
        public long time;

        public static MassRedPackSection[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MassRedPackSection[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MassRedPackSection() {
            clear();
        }

        public final MassRedPackSection clear() {
            this.time = 0L;
            this.activityId = "";
            this.sectionId = "";
            this.aheadTime = 0;
            this.afterTime = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            if (!this.sectionId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.sectionId);
            }
            int i = this.aheadTime;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            int i2 = this.afterTime;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.time;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            if (!this.sectionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.sectionId);
            }
            int i = this.aheadTime;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            int i2 = this.afterTime;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MassRedPackSection mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.time = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.sectionId = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.aheadTime = codedInputByteBufferNano.readUInt32();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.afterTime = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static MassRedPackSection parseFrom(byte[] bArr) {
            return (MassRedPackSection) MessageNano.mergeFrom(new MassRedPackSection(), bArr);
        }

        public static MassRedPackSection parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MassRedPackSection().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MassRedPackSignal extends MessageNano {
        private static volatile MassRedPackSignal[] _emptyArray;
        public String activityId;
        public AdPicUrl[] adPicUrl;
        public String coverTitle;
        public long endTime;
        public AdPicUrl[] noticePic;
        public boolean open;
        public MassRedPackSection[] sections;

        public static MassRedPackSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MassRedPackSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MassRedPackSignal() {
            clear();
        }

        public final MassRedPackSignal clear() {
            this.open = false;
            this.sections = MassRedPackSection.emptyArray();
            this.endTime = 0L;
            this.adPicUrl = AdPicUrl.emptyArray();
            this.coverTitle = "";
            this.noticePic = AdPicUrl.emptyArray();
            this.activityId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.open;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            MassRedPackSection[] massRedPackSectionArr = this.sections;
            int i = 0;
            if (massRedPackSectionArr != null && massRedPackSectionArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MassRedPackSection[] massRedPackSectionArr2 = this.sections;
                    if (i2 >= massRedPackSectionArr2.length) {
                        break;
                    }
                    MassRedPackSection massRedPackSection = massRedPackSectionArr2[i2];
                    if (massRedPackSection != null) {
                        codedOutputByteBufferNano.writeMessage(2, massRedPackSection);
                    }
                    i2++;
                }
            }
            long j = this.endTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            AdPicUrl[] adPicUrlArr = this.adPicUrl;
            if (adPicUrlArr != null && adPicUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    AdPicUrl[] adPicUrlArr2 = this.adPicUrl;
                    if (i3 >= adPicUrlArr2.length) {
                        break;
                    }
                    AdPicUrl adPicUrl = adPicUrlArr2[i3];
                    if (adPicUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, adPicUrl);
                    }
                    i3++;
                }
            }
            if (!this.coverTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.coverTitle);
            }
            AdPicUrl[] adPicUrlArr3 = this.noticePic;
            if (adPicUrlArr3 != null && adPicUrlArr3.length > 0) {
                while (true) {
                    AdPicUrl[] adPicUrlArr4 = this.noticePic;
                    if (i >= adPicUrlArr4.length) {
                        break;
                    }
                    AdPicUrl adPicUrl2 = adPicUrlArr4[i];
                    if (adPicUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, adPicUrl2);
                    }
                    i++;
                }
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.activityId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.open;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            MassRedPackSection[] massRedPackSectionArr = this.sections;
            int i = 0;
            if (massRedPackSectionArr != null && massRedPackSectionArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    MassRedPackSection[] massRedPackSectionArr2 = this.sections;
                    if (i2 >= massRedPackSectionArr2.length) {
                        break;
                    }
                    MassRedPackSection massRedPackSection = massRedPackSectionArr2[i2];
                    if (massRedPackSection != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, massRedPackSection);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            long j = this.endTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            AdPicUrl[] adPicUrlArr = this.adPicUrl;
            if (adPicUrlArr != null && adPicUrlArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    AdPicUrl[] adPicUrlArr2 = this.adPicUrl;
                    if (i3 >= adPicUrlArr2.length) {
                        break;
                    }
                    AdPicUrl adPicUrl = adPicUrlArr2[i3];
                    if (adPicUrl != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(4, adPicUrl);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            if (!this.coverTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.coverTitle);
            }
            AdPicUrl[] adPicUrlArr3 = this.noticePic;
            if (adPicUrlArr3 != null && adPicUrlArr3.length > 0) {
                while (true) {
                    AdPicUrl[] adPicUrlArr4 = this.noticePic;
                    if (i >= adPicUrlArr4.length) {
                        break;
                    }
                    AdPicUrl adPicUrl2 = adPicUrlArr4[i];
                    if (adPicUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, adPicUrl2);
                    }
                    i++;
                }
            }
            return !this.activityId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.activityId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MassRedPackSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.open = codedInputByteBufferNano.readBool();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    MassRedPackSection[] massRedPackSectionArr = this.sections;
                    int length = massRedPackSectionArr == null ? 0 : massRedPackSectionArr.length;
                    MassRedPackSection[] massRedPackSectionArr2 = new MassRedPackSection[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.sections, 0, massRedPackSectionArr2, 0, length);
                    }
                    while (length < massRedPackSectionArr2.length - 1) {
                        massRedPackSectionArr2[length] = new MassRedPackSection();
                        codedInputByteBufferNano.readMessage(massRedPackSectionArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    massRedPackSectionArr2[length] = new MassRedPackSection();
                    codedInputByteBufferNano.readMessage(massRedPackSectionArr2[length]);
                    this.sections = massRedPackSectionArr2;
                } else if (tag == 24) {
                    this.endTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    AdPicUrl[] adPicUrlArr = this.adPicUrl;
                    int length2 = adPicUrlArr == null ? 0 : adPicUrlArr.length;
                    AdPicUrl[] adPicUrlArr2 = new AdPicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.adPicUrl, 0, adPicUrlArr2, 0, length2);
                    }
                    while (length2 < adPicUrlArr2.length - 1) {
                        adPicUrlArr2[length2] = new AdPicUrl();
                        codedInputByteBufferNano.readMessage(adPicUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    adPicUrlArr2[length2] = new AdPicUrl();
                    codedInputByteBufferNano.readMessage(adPicUrlArr2[length2]);
                    this.adPicUrl = adPicUrlArr2;
                } else if (tag == 42) {
                    this.coverTitle = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    AdPicUrl[] adPicUrlArr3 = this.noticePic;
                    int length3 = adPicUrlArr3 == null ? 0 : adPicUrlArr3.length;
                    AdPicUrl[] adPicUrlArr4 = new AdPicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.noticePic, 0, adPicUrlArr4, 0, length3);
                    }
                    while (length3 < adPicUrlArr4.length - 1) {
                        adPicUrlArr4[length3] = new AdPicUrl();
                        codedInputByteBufferNano.readMessage(adPicUrlArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    adPicUrlArr4[length3] = new AdPicUrl();
                    codedInputByteBufferNano.readMessage(adPicUrlArr4[length3]);
                    this.noticePic = adPicUrlArr4;
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.activityId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static MassRedPackSignal parseFrom(byte[] bArr) {
            return (MassRedPackSignal) MessageNano.mergeFrom(new MassRedPackSignal(), bArr);
        }

        public static MassRedPackSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MassRedPackSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MassRedPackNoticeSignal extends MessageNano {
        private static volatile MassRedPackNoticeSignal[] _emptyArray;
        public AdPicUrl[] noticePic;
        public boolean open;

        public static MassRedPackNoticeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MassRedPackNoticeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MassRedPackNoticeSignal() {
            clear();
        }

        public final MassRedPackNoticeSignal clear() {
            this.open = false;
            this.noticePic = AdPicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.open;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            AdPicUrl[] adPicUrlArr = this.noticePic;
            if (adPicUrlArr != null && adPicUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    AdPicUrl[] adPicUrlArr2 = this.noticePic;
                    if (i >= adPicUrlArr2.length) {
                        break;
                    }
                    AdPicUrl adPicUrl = adPicUrlArr2[i];
                    if (adPicUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, adPicUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.open;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            AdPicUrl[] adPicUrlArr = this.noticePic;
            if (adPicUrlArr != null && adPicUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    AdPicUrl[] adPicUrlArr2 = this.noticePic;
                    if (i >= adPicUrlArr2.length) {
                        break;
                    }
                    AdPicUrl adPicUrl = adPicUrlArr2[i];
                    if (adPicUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, adPicUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MassRedPackNoticeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.open = codedInputByteBufferNano.readBool();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    AdPicUrl[] adPicUrlArr = this.noticePic;
                    int length = adPicUrlArr == null ? 0 : adPicUrlArr.length;
                    AdPicUrl[] adPicUrlArr2 = new AdPicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.noticePic, 0, adPicUrlArr2, 0, length);
                    }
                    while (length < adPicUrlArr2.length - 1) {
                        adPicUrlArr2[length] = new AdPicUrl();
                        codedInputByteBufferNano.readMessage(adPicUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    adPicUrlArr2[length] = new AdPicUrl();
                    codedInputByteBufferNano.readMessage(adPicUrlArr2[length]);
                    this.noticePic = adPicUrlArr2;
                }
            }
        }

        public static MassRedPackNoticeSignal parseFrom(byte[] bArr) {
            return (MassRedPackNoticeSignal) MessageNano.mergeFrom(new MassRedPackNoticeSignal(), bArr);
        }

        public static MassRedPackNoticeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MassRedPackNoticeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SeckillWidgetSignal extends MessageNano {
        private static volatile SeckillWidgetSignal[] _emptyArray;
        public long endShowTime;
        public int iconType;
        public String itemId;
        public boolean open;
        public long startTime;

        public static SeckillWidgetSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SeckillWidgetSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SeckillWidgetSignal() {
            clear();
        }

        public final SeckillWidgetSignal clear() {
            this.open = false;
            this.iconType = 0;
            this.startTime = 0L;
            this.endShowTime = 0L;
            this.itemId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.open;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            int i = this.iconType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.endShowTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.itemId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.open;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            int i = this.iconType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j = this.startTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.endShowTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            return !this.itemId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.itemId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SeckillWidgetSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.open = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.iconType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.endShowTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.itemId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SeckillWidgetSignal parseFrom(byte[] bArr) {
            return (SeckillWidgetSignal) MessageNano.mergeFrom(new SeckillWidgetSignal(), bArr);
        }

        public static SeckillWidgetSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SeckillWidgetSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveGeneralCouponSignal extends MessageNano {
        private static volatile SCLiveGeneralCouponSignal[] _emptyArray;
        public LiveGeneralCouponSignal liveGeneralCouponSignal;
        public String liveStreamId;

        public static SCLiveGeneralCouponSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveGeneralCouponSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveGeneralCouponSignal() {
            clear();
        }

        public final SCLiveGeneralCouponSignal clear() {
            this.liveGeneralCouponSignal = null;
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveGeneralCouponSignal liveGeneralCouponSignal = this.liveGeneralCouponSignal;
            if (liveGeneralCouponSignal != null) {
                codedOutputByteBufferNano.writeMessage(1, liveGeneralCouponSignal);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveGeneralCouponSignal liveGeneralCouponSignal = this.liveGeneralCouponSignal;
            if (liveGeneralCouponSignal != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveGeneralCouponSignal);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveGeneralCouponSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.liveGeneralCouponSignal == null) {
                        this.liveGeneralCouponSignal = new LiveGeneralCouponSignal();
                    }
                    codedInputByteBufferNano.readMessage(this.liveGeneralCouponSignal);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveGeneralCouponSignal parseFrom(byte[] bArr) {
            return (SCLiveGeneralCouponSignal) MessageNano.mergeFrom(new SCLiveGeneralCouponSignal(), bArr);
        }

        public static SCLiveGeneralCouponSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveGeneralCouponSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveRichPendant extends MessageNano {
        private static volatile SCKwaishopLiveRichPendant[] _emptyArray;
        public String liveStreamId;
        public int pendSourceType;
        public Map<String, String> richExtraMap;
        public String richPendantContent;
        public long richPendantDisplayMills;
        public String richPendantId;
        public String richPendantJumpUrl;
        public String richPendantTitle;
        public int richPendantType;

        public static SCKwaishopLiveRichPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveRichPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveRichPendant() {
            clear();
        }

        public final SCKwaishopLiveRichPendant clear() {
            this.richPendantId = "";
            this.richPendantType = 0;
            this.richPendantTitle = "";
            this.richPendantContent = "";
            this.richPendantJumpUrl = "";
            this.richPendantDisplayMills = 0L;
            this.richExtraMap = null;
            this.pendSourceType = 0;
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.richPendantId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.richPendantId);
            }
            int i = this.richPendantType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            if (!this.richPendantTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.richPendantTitle);
            }
            if (!this.richPendantContent.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.richPendantContent);
            }
            if (!this.richPendantJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.richPendantJumpUrl);
            }
            long j = this.richPendantDisplayMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            Map<String, String> map = this.richExtraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 7, 9, 9);
            }
            int i2 = this.pendSourceType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i2);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.richPendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.richPendantId);
            }
            int i = this.richPendantType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            if (!this.richPendantTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.richPendantTitle);
            }
            if (!this.richPendantContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.richPendantContent);
            }
            if (!this.richPendantJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.richPendantJumpUrl);
            }
            long j = this.richPendantDisplayMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            Map<String, String> map = this.richExtraMap;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 7, 9, 9);
            }
            int i2 = this.pendSourceType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i2);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveRichPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.richPendantId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.richPendantType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.richPendantTitle = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.richPendantContent = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.richPendantJumpUrl = codedInputByteBufferNano.readString();
                } else if (tag == 48) {
                    this.richPendantDisplayMills = codedInputByteBufferNano.readUInt64();
                } else if (tag == 58) {
                    this.richExtraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.richExtraMap, mapFactory, 9, 9, null, 10, 18);
                } else if (tag == 64) {
                    this.pendSourceType = codedInputByteBufferNano.readUInt32();
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCKwaishopLiveRichPendant parseFrom(byte[] bArr) {
            return (SCKwaishopLiveRichPendant) MessageNano.mergeFrom(new SCKwaishopLiveRichPendant(), bArr);
        }

        public static SCKwaishopLiveRichPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveRichPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MarketingPushLiveAction extends MessageNano {
        private static volatile MarketingPushLiveAction[] _emptyArray;
        public String businessType;
        public Map<String, String> extraMap;
        public int randomTimeMills;

        public static MarketingPushLiveAction[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MarketingPushLiveAction[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MarketingPushLiveAction() {
            clear();
        }

        public final MarketingPushLiveAction clear() {
            this.businessType = "";
            this.randomTimeMills = 0;
            this.extraMap = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.businessType.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.businessType);
            }
            int i = this.randomTimeMills;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.businessType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.businessType);
            }
            int i = this.randomTimeMills;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            Map<String, String> map = this.extraMap;
            return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 3, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MarketingPushLiveAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.businessType = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.randomTimeMills = codedInputByteBufferNano.readUInt32();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static MarketingPushLiveAction parseFrom(byte[] bArr) {
            return (MarketingPushLiveAction) MessageNano.mergeFrom(new MarketingPushLiveAction(), bArr);
        }

        public static MarketingPushLiveAction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MarketingPushLiveAction().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RetrievePriceDTO extends MessageNano {
        private static volatile RetrievePriceDTO[] _emptyArray;
        public long scatterTimeMills;
        public int type;

        public static RetrievePriceDTO[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RetrievePriceDTO[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RetrievePriceDTO() {
            clear();
        }

        public final RetrievePriceDTO clear() {
            this.type = 0;
            this.scatterTimeMills = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.scatterTimeMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
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
            long j = this.scatterTimeMills;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RetrievePriceDTO mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.type = int32;
                    }
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.scatterTimeMills = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static RetrievePriceDTO parseFrom(byte[] bArr) {
            return (RetrievePriceDTO) MessageNano.mergeFrom(new RetrievePriceDTO(), bArr);
        }

        public static RetrievePriceDTO parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RetrievePriceDTO().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ScKwaishopLiveShopGrouponActivityNotice extends MessageNano {
        private static volatile ScKwaishopLiveShopGrouponActivityNotice[] _emptyArray;
        public int actionStatus;
        public long activityId;
        public String activityName;
        public String activityPrice;
        public int durationAfterEndInSec;
        public long endTime;
        public long itemId;
        public String itemTitle;
        public long startTime;

        public static ScKwaishopLiveShopGrouponActivityNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScKwaishopLiveShopGrouponActivityNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ScKwaishopLiveShopGrouponActivityNotice() {
            clear();
        }

        public final ScKwaishopLiveShopGrouponActivityNotice clear() {
            this.actionStatus = 0;
            this.activityId = 0L;
            this.activityName = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.durationAfterEndInSec = 0;
            this.activityPrice = "";
            this.itemId = 0L;
            this.itemTitle = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.actionStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.activityId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.activityName.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.activityName);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            long j3 = this.endTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j3);
            }
            int i2 = this.durationAfterEndInSec;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i2);
            }
            if (!this.activityPrice.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.activityPrice);
            }
            long j4 = this.itemId;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            if (!this.itemTitle.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.itemTitle);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.actionStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.activityId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.activityName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.activityName);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            long j3 = this.endTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
            }
            int i2 = this.durationAfterEndInSec;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
            }
            if (!this.activityPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.activityPrice);
            }
            long j4 = this.itemId;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
            }
            return !this.itemTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.itemTitle) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ScKwaishopLiveShopGrouponActivityNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.actionStatus = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.activityName = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.endTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    this.durationAfterEndInSec = codedInputByteBufferNano.readUInt32();
                } else if (tag == 58) {
                    this.activityPrice = codedInputByteBufferNano.readString();
                } else if (tag == 64) {
                    this.itemId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.itemTitle = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ScKwaishopLiveShopGrouponActivityNotice parseFrom(byte[] bArr) {
            return (ScKwaishopLiveShopGrouponActivityNotice) MessageNano.mergeFrom(new ScKwaishopLiveShopGrouponActivityNotice(), bArr);
        }

        public static ScKwaishopLiveShopGrouponActivityNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ScKwaishopLiveShopGrouponActivityNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ScKwaishopLiveShopGrouponSucGroup extends MessageNano {
        private static volatile ScKwaishopLiveShopGrouponSucGroup[] _emptyArray;
        public long activityId;
        public String activityName;
        public long groupId;
        public String liveStreamId;

        public static ScKwaishopLiveShopGrouponSucGroup[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScKwaishopLiveShopGrouponSucGroup[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ScKwaishopLiveShopGrouponSucGroup() {
            clear();
        }

        public final ScKwaishopLiveShopGrouponSucGroup clear() {
            this.liveStreamId = "";
            this.activityId = 0L;
            this.activityName = "";
            this.groupId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.activityId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.activityName.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.activityName);
            }
            long j2 = this.groupId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.activityId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.activityName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.activityName);
            }
            long j2 = this.groupId;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ScKwaishopLiveShopGrouponSucGroup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.activityId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.activityName = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.groupId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static ScKwaishopLiveShopGrouponSucGroup parseFrom(byte[] bArr) {
            return (ScKwaishopLiveShopGrouponSucGroup) MessageNano.mergeFrom(new ScKwaishopLiveShopGrouponSucGroup(), bArr);
        }

        public static ScKwaishopLiveShopGrouponSucGroup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ScKwaishopLiveShopGrouponSucGroup().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ScKwaishopLiveShopPendantBalanceStrategy extends MessageNano {
        private static volatile ScKwaishopLiveShopPendantBalanceStrategy[] _emptyArray;
        public int balanceType;
        public long randomRange;

        public static ScKwaishopLiveShopPendantBalanceStrategy[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ScKwaishopLiveShopPendantBalanceStrategy[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ScKwaishopLiveShopPendantBalanceStrategy() {
            clear();
        }

        public final ScKwaishopLiveShopPendantBalanceStrategy clear() {
            this.balanceType = 0;
            this.randomRange = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.balanceType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            long j = this.randomRange;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.balanceType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            long j = this.randomRange;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ScKwaishopLiveShopPendantBalanceStrategy mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.balanceType = int32;
                    }
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.randomRange = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static ScKwaishopLiveShopPendantBalanceStrategy parseFrom(byte[] bArr) {
            return (ScKwaishopLiveShopPendantBalanceStrategy) MessageNano.mergeFrom(new ScKwaishopLiveShopPendantBalanceStrategy(), bArr);
        }

        public static ScKwaishopLiveShopPendantBalanceStrategy parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ScKwaishopLiveShopPendantBalanceStrategy().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveActivityItemInfo extends MessageNano {
        private static volatile SCKwaishopLiveActivityItemInfo[] _emptyArray;
        public Map<String, String> extraMap;
        public String itemDesc;
        public String itemId;
        public String itemName;
        public UserInfos.PicUrl[] itemPic;
        public String itemPrice;

        public static SCKwaishopLiveActivityItemInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveActivityItemInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveActivityItemInfo() {
            clear();
        }

        public final SCKwaishopLiveActivityItemInfo clear() {
            this.itemId = "";
            this.itemName = "";
            this.itemDesc = "";
            this.itemPrice = "";
            this.itemPic = UserInfos.PicUrl.emptyArray();
            this.extraMap = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            if (!this.itemName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.itemName);
            }
            if (!this.itemDesc.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.itemDesc);
            }
            if (!this.itemPrice.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.itemPrice);
            }
            UserInfos.PicUrl[] picUrlArr = this.itemPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.itemPic;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl);
                    }
                    i++;
                }
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 10, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            if (!this.itemName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.itemName);
            }
            if (!this.itemDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.itemDesc);
            }
            if (!this.itemPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.itemPrice);
            }
            UserInfos.PicUrl[] picUrlArr = this.itemPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.itemPic;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                    }
                    i++;
                }
            }
            Map<String, String> map = this.extraMap;
            return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 10, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveActivityItemInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.itemName = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.itemDesc = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.itemPrice = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr = this.itemPic;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.itemPic, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.itemPic = picUrlArr2;
                } else if (tag != 82) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static SCKwaishopLiveActivityItemInfo parseFrom(byte[] bArr) {
            return (SCKwaishopLiveActivityItemInfo) MessageNano.mergeFrom(new SCKwaishopLiveActivityItemInfo(), bArr);
        }

        public static SCKwaishopLiveActivityItemInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveActivityItemInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLivePartnerInfo extends MessageNano {
        private static volatile SCKwaishopLivePartnerInfo[] _emptyArray;
        public Map<String, String> extraMap;
        public int order;
        public String userId;
        public String userName;
        public UserInfos.PicUrl userProfilePhoto;
        public int userStatus;
        public int userType;

        public static SCKwaishopLivePartnerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLivePartnerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLivePartnerInfo() {
            clear();
        }

        public final SCKwaishopLivePartnerInfo clear() {
            this.userId = "";
            this.userType = 0;
            this.userStatus = 0;
            this.userName = "";
            this.userProfilePhoto = null;
            this.order = 0;
            this.extraMap = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.userId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.userId);
            }
            int i = this.userType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.userStatus;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            if (!this.userName.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.userName);
            }
            UserInfos.PicUrl picUrl = this.userProfilePhoto;
            if (picUrl != null) {
                codedOutputByteBufferNano.writeMessage(5, picUrl);
            }
            int i3 = this.order;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i3);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 10, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.userId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.userId);
            }
            int i = this.userType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.userStatus;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            if (!this.userName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.userName);
            }
            UserInfos.PicUrl picUrl = this.userProfilePhoto;
            if (picUrl != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
            }
            int i3 = this.order;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
            }
            Map<String, String> map = this.extraMap;
            return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 10, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLivePartnerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.userId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.userType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.userStatus = codedInputByteBufferNano.readUInt32();
                } else if (tag == 34) {
                    this.userName = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    if (this.userProfilePhoto == null) {
                        this.userProfilePhoto = new UserInfos.PicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.userProfilePhoto);
                } else if (tag == 48) {
                    this.order = codedInputByteBufferNano.readUInt32();
                } else if (tag != 82) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static SCKwaishopLivePartnerInfo parseFrom(byte[] bArr) {
            return (SCKwaishopLivePartnerInfo) MessageNano.mergeFrom(new SCKwaishopLivePartnerInfo(), bArr);
        }

        public static SCKwaishopLivePartnerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLivePartnerInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveActivityInfo extends MessageNano {
        private static volatile SCKwaishopLiveActivityInfo[] _emptyArray;
        public String activityDesc;
        public long activityEndTimeMills;
        public String activityId;
        public SCKwaishopLiveActivityItemInfo[] activityItem;
        public String activityName;
        public SCKwaishopLivePartnerInfo[] activityPartner;
        public UserInfos.PicUrl[] activityPic;
        public long activityStartTimeMills;
        public int activityState;
        public int activityType;
        public Map<String, String> extraMap;

        public static SCKwaishopLiveActivityInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveActivityInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveActivityInfo() {
            clear();
        }

        public final SCKwaishopLiveActivityInfo clear() {
            this.activityId = "";
            this.activityName = "";
            this.activityDesc = "";
            this.activityType = 0;
            this.activityState = 0;
            this.activityStartTimeMills = 0L;
            this.activityEndTimeMills = 0L;
            this.extraMap = null;
            this.activityItem = SCKwaishopLiveActivityItemInfo.emptyArray();
            this.activityPartner = SCKwaishopLivePartnerInfo.emptyArray();
            this.activityPic = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.activityId);
            }
            if (!this.activityName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityName);
            }
            if (!this.activityDesc.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.activityDesc);
            }
            int i = this.activityType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            int i2 = this.activityState;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i2);
            }
            long j = this.activityStartTimeMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            long j2 = this.activityEndTimeMills;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j2);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 8, 9, 9);
            }
            SCKwaishopLiveActivityItemInfo[] sCKwaishopLiveActivityItemInfoArr = this.activityItem;
            int i3 = 0;
            if (sCKwaishopLiveActivityItemInfoArr != null && sCKwaishopLiveActivityItemInfoArr.length > 0) {
                int i4 = 0;
                while (true) {
                    SCKwaishopLiveActivityItemInfo[] sCKwaishopLiveActivityItemInfoArr2 = this.activityItem;
                    if (i4 >= sCKwaishopLiveActivityItemInfoArr2.length) {
                        break;
                    }
                    SCKwaishopLiveActivityItemInfo sCKwaishopLiveActivityItemInfo = sCKwaishopLiveActivityItemInfoArr2[i4];
                    if (sCKwaishopLiveActivityItemInfo != null) {
                        codedOutputByteBufferNano.writeMessage(9, sCKwaishopLiveActivityItemInfo);
                    }
                    i4++;
                }
            }
            SCKwaishopLivePartnerInfo[] sCKwaishopLivePartnerInfoArr = this.activityPartner;
            if (sCKwaishopLivePartnerInfoArr != null && sCKwaishopLivePartnerInfoArr.length > 0) {
                int i5 = 0;
                while (true) {
                    SCKwaishopLivePartnerInfo[] sCKwaishopLivePartnerInfoArr2 = this.activityPartner;
                    if (i5 >= sCKwaishopLivePartnerInfoArr2.length) {
                        break;
                    }
                    SCKwaishopLivePartnerInfo sCKwaishopLivePartnerInfo = sCKwaishopLivePartnerInfoArr2[i5];
                    if (sCKwaishopLivePartnerInfo != null) {
                        codedOutputByteBufferNano.writeMessage(10, sCKwaishopLivePartnerInfo);
                    }
                    i5++;
                }
            }
            UserInfos.PicUrl[] picUrlArr = this.activityPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.activityPic;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(11, picUrl);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activityId);
            }
            if (!this.activityName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityName);
            }
            if (!this.activityDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.activityDesc);
            }
            int i = this.activityType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            int i2 = this.activityState;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
            }
            long j = this.activityStartTimeMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            long j2 = this.activityEndTimeMills;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j2);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 8, 9, 9);
            }
            SCKwaishopLiveActivityItemInfo[] sCKwaishopLiveActivityItemInfoArr = this.activityItem;
            int i3 = 0;
            if (sCKwaishopLiveActivityItemInfoArr != null && sCKwaishopLiveActivityItemInfoArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    SCKwaishopLiveActivityItemInfo[] sCKwaishopLiveActivityItemInfoArr2 = this.activityItem;
                    if (i4 >= sCKwaishopLiveActivityItemInfoArr2.length) {
                        break;
                    }
                    SCKwaishopLiveActivityItemInfo sCKwaishopLiveActivityItemInfo = sCKwaishopLiveActivityItemInfoArr2[i4];
                    if (sCKwaishopLiveActivityItemInfo != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(9, sCKwaishopLiveActivityItemInfo);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            SCKwaishopLivePartnerInfo[] sCKwaishopLivePartnerInfoArr = this.activityPartner;
            if (sCKwaishopLivePartnerInfoArr != null && sCKwaishopLivePartnerInfoArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    SCKwaishopLivePartnerInfo[] sCKwaishopLivePartnerInfoArr2 = this.activityPartner;
                    if (i5 >= sCKwaishopLivePartnerInfoArr2.length) {
                        break;
                    }
                    SCKwaishopLivePartnerInfo sCKwaishopLivePartnerInfo = sCKwaishopLivePartnerInfoArr2[i5];
                    if (sCKwaishopLivePartnerInfo != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(10, sCKwaishopLivePartnerInfo);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr = this.activityPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.activityPic;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, picUrl);
                    }
                    i3++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveActivityInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.activityId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.activityName = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.activityDesc = codedInputByteBufferNano.readString();
                        break;
                    case 32:
                        this.activityType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 40:
                        this.activityState = codedInputByteBufferNano.readUInt32();
                        break;
                    case 48:
                        this.activityStartTimeMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.activityEndTimeMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 66:
                        this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                        break;
                    case 74:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        SCKwaishopLiveActivityItemInfo[] sCKwaishopLiveActivityItemInfoArr = this.activityItem;
                        int length = sCKwaishopLiveActivityItemInfoArr == null ? 0 : sCKwaishopLiveActivityItemInfoArr.length;
                        SCKwaishopLiveActivityItemInfo[] sCKwaishopLiveActivityItemInfoArr2 = new SCKwaishopLiveActivityItemInfo[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.activityItem, 0, sCKwaishopLiveActivityItemInfoArr2, 0, length);
                        }
                        while (length < sCKwaishopLiveActivityItemInfoArr2.length - 1) {
                            sCKwaishopLiveActivityItemInfoArr2[length] = new SCKwaishopLiveActivityItemInfo();
                            codedInputByteBufferNano.readMessage(sCKwaishopLiveActivityItemInfoArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        sCKwaishopLiveActivityItemInfoArr2[length] = new SCKwaishopLiveActivityItemInfo();
                        codedInputByteBufferNano.readMessage(sCKwaishopLiveActivityItemInfoArr2[length]);
                        this.activityItem = sCKwaishopLiveActivityItemInfoArr2;
                        break;
                    case 82:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                        SCKwaishopLivePartnerInfo[] sCKwaishopLivePartnerInfoArr = this.activityPartner;
                        int length2 = sCKwaishopLivePartnerInfoArr == null ? 0 : sCKwaishopLivePartnerInfoArr.length;
                        SCKwaishopLivePartnerInfo[] sCKwaishopLivePartnerInfoArr2 = new SCKwaishopLivePartnerInfo[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.activityPartner, 0, sCKwaishopLivePartnerInfoArr2, 0, length2);
                        }
                        while (length2 < sCKwaishopLivePartnerInfoArr2.length - 1) {
                            sCKwaishopLivePartnerInfoArr2[length2] = new SCKwaishopLivePartnerInfo();
                            codedInputByteBufferNano.readMessage(sCKwaishopLivePartnerInfoArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        sCKwaishopLivePartnerInfoArr2[length2] = new SCKwaishopLivePartnerInfo();
                        codedInputByteBufferNano.readMessage(sCKwaishopLivePartnerInfoArr2[length2]);
                        this.activityPartner = sCKwaishopLivePartnerInfoArr2;
                        break;
                    case 90:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UserInfos.PicUrl[] picUrlArr = this.activityPic;
                        int length3 = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.activityPic, 0, picUrlArr2, 0, length3);
                        }
                        while (length3 < picUrlArr2.length - 1) {
                            picUrlArr2[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr2[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                        this.activityPic = picUrlArr2;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCKwaishopLiveActivityInfo parseFrom(byte[] bArr) {
            return (SCKwaishopLiveActivityInfo) MessageNano.mergeFrom(new SCKwaishopLiveActivityInfo(), bArr);
        }

        public static SCKwaishopLiveActivityInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveActivityInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopAnimationInfo extends MessageNano {
        private static volatile SCKwaishopAnimationInfo[] _emptyArray;
        public Map<String, Boolean> animationShow;
        public Map<String, Integer> animationShowCounter;

        public static SCKwaishopAnimationInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopAnimationInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopAnimationInfo() {
            clear();
        }

        public final SCKwaishopAnimationInfo clear() {
            this.animationShowCounter = null;
            this.animationShow = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            Map<String, Integer> map = this.animationShowCounter;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 9, 13);
            }
            Map<String, Boolean> map2 = this.animationShow;
            if (map2 != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 2, 9, 8);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Map<String, Integer> map = this.animationShowCounter;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 9, 13);
            }
            Map<String, Boolean> map2 = this.animationShow;
            return map2 != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map2, 2, 9, 8) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopAnimationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.animationShowCounter = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.animationShowCounter, mapFactory, 9, 13, null, 10, 16);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.animationShow = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.animationShow, mapFactory, 9, 8, null, 10, 16);
                }
            }
        }

        public static SCKwaishopAnimationInfo parseFrom(byte[] bArr) {
            return (SCKwaishopAnimationInfo) MessageNano.mergeFrom(new SCKwaishopAnimationInfo(), bArr);
        }

        public static SCKwaishopAnimationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopAnimationInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveActivityPendant extends MessageNano {
        private static volatile SCKwaishopLiveActivityPendant[] _emptyArray;
        public SCKwaishopLiveActivityInfo activityInfo;
        public SCKwaishopAnimationInfo animation;
        public ScKwaishopLiveShopPendantBalanceStrategy balanceStrategy;
        public long destroyTimestamp;
        public Map<String, String> extraMap;
        public String jumpUrl;
        public long launchTimestamp;
        public long liveStreamId;
        public String liveStreamRoomId;
        public int pendantStatus;
        public int pendantType;

        public static SCKwaishopLiveActivityPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveActivityPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveActivityPendant() {
            clear();
        }

        public final SCKwaishopLiveActivityPendant clear() {
            this.liveStreamId = 0L;
            this.destroyTimestamp = 0L;
            this.activityInfo = null;
            this.pendantStatus = 0;
            this.balanceStrategy = null;
            this.extraMap = null;
            this.liveStreamRoomId = "";
            this.pendantType = 0;
            this.animation = null;
            this.jumpUrl = "";
            this.launchTimestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j = this.liveStreamId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.destroyTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            SCKwaishopLiveActivityInfo sCKwaishopLiveActivityInfo = this.activityInfo;
            if (sCKwaishopLiveActivityInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, sCKwaishopLiveActivityInfo);
            }
            int i = this.pendantStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            ScKwaishopLiveShopPendantBalanceStrategy scKwaishopLiveShopPendantBalanceStrategy = this.balanceStrategy;
            if (scKwaishopLiveShopPendantBalanceStrategy != null) {
                codedOutputByteBufferNano.writeMessage(5, scKwaishopLiveShopPendantBalanceStrategy);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 6, 9, 9);
            }
            if (!this.liveStreamRoomId.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.liveStreamRoomId);
            }
            int i2 = this.pendantType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i2);
            }
            SCKwaishopAnimationInfo sCKwaishopAnimationInfo = this.animation;
            if (sCKwaishopAnimationInfo != null) {
                codedOutputByteBufferNano.writeMessage(9, sCKwaishopAnimationInfo);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.jumpUrl);
            }
            long j3 = this.launchTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.liveStreamId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.destroyTimestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            SCKwaishopLiveActivityInfo sCKwaishopLiveActivityInfo = this.activityInfo;
            if (sCKwaishopLiveActivityInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, sCKwaishopLiveActivityInfo);
            }
            int i = this.pendantStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
            }
            ScKwaishopLiveShopPendantBalanceStrategy scKwaishopLiveShopPendantBalanceStrategy = this.balanceStrategy;
            if (scKwaishopLiveShopPendantBalanceStrategy != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, scKwaishopLiveShopPendantBalanceStrategy);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 6, 9, 9);
            }
            if (!this.liveStreamRoomId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.liveStreamRoomId);
            }
            int i2 = this.pendantType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i2);
            }
            SCKwaishopAnimationInfo sCKwaishopAnimationInfo = this.animation;
            if (sCKwaishopAnimationInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, sCKwaishopAnimationInfo);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.jumpUrl);
            }
            long j3 = this.launchTimestamp;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveActivityPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.liveStreamId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 16:
                        this.destroyTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 26:
                        if (this.activityInfo == null) {
                            this.activityInfo = new SCKwaishopLiveActivityInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.activityInfo);
                        break;
                    case 32:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                            break;
                        } else {
                            this.pendantStatus = int32;
                            break;
                        }
                    case 42:
                        if (this.balanceStrategy == null) {
                            this.balanceStrategy = new ScKwaishopLiveShopPendantBalanceStrategy();
                        }
                        codedInputByteBufferNano.readMessage(this.balanceStrategy);
                        break;
                    case 50:
                        this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                        break;
                    case 58:
                        this.liveStreamRoomId = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.pendantType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 74:
                        if (this.animation == null) {
                            this.animation = new SCKwaishopAnimationInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.animation);
                        break;
                    case 82:
                        this.jumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        this.launchTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCKwaishopLiveActivityPendant parseFrom(byte[] bArr) {
            return (SCKwaishopLiveActivityPendant) MessageNano.mergeFrom(new SCKwaishopLiveActivityPendant(), bArr);
        }

        public static SCKwaishopLiveActivityPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveActivityPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBuyingNoticeSignal extends MessageNano {
        private static volatile SCLiveBuyingNoticeSignal[] _emptyArray;
        public String bulletText;
        public String jumpUrl;

        public static SCLiveBuyingNoticeSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBuyingNoticeSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBuyingNoticeSignal() {
            clear();
        }

        public final SCLiveBuyingNoticeSignal clear() {
            this.bulletText = "";
            this.jumpUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bulletText.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bulletText);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.jumpUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bulletText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bulletText);
            }
            return !this.jumpUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.jumpUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBuyingNoticeSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bulletText = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBuyingNoticeSignal parseFrom(byte[] bArr) {
            return (SCLiveBuyingNoticeSignal) MessageNano.mergeFrom(new SCLiveBuyingNoticeSignal(), bArr);
        }

        public static SCLiveBuyingNoticeSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBuyingNoticeSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class KwaishopLiveAskOnItemSignal extends MessageNano {
        private static volatile KwaishopLiveAskOnItemSignal[] _emptyArray;
        public String askContent;
        public long askedCount;
        public ItemInfo itemInfo;
        public long latestAskedCount;

        public static KwaishopLiveAskOnItemSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new KwaishopLiveAskOnItemSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public KwaishopLiveAskOnItemSignal() {
            clear();
        }

        public final KwaishopLiveAskOnItemSignal clear() {
            this.itemInfo = null;
            this.askContent = "";
            this.askedCount = 0L;
            this.latestAskedCount = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            if (!this.askContent.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.askContent);
            }
            long j = this.askedCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.latestAskedCount;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            if (!this.askContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.askContent);
            }
            long j = this.askedCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.latestAskedCount;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final KwaishopLiveAskOnItemSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 18) {
                    this.askContent = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.askedCount = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.latestAskedCount = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static KwaishopLiveAskOnItemSignal parseFrom(byte[] bArr) {
            return (KwaishopLiveAskOnItemSignal) MessageNano.mergeFrom(new KwaishopLiveAskOnItemSignal(), bArr);
        }

        public static KwaishopLiveAskOnItemSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new KwaishopLiveAskOnItemSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveItemPendant extends MessageNano {
        private static volatile SCKwaishopLiveItemPendant[] _emptyArray;
        public String extraJson;
        public LivePendantItemInfo[] itemInfo;
        public String liveStreamId;
        public int pendSourceType;
        public int pendantType;
        public long randomMills;

        public static SCKwaishopLiveItemPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveItemPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveItemPendant() {
            clear();
        }

        public final SCKwaishopLiveItemPendant clear() {
            this.pendSourceType = 0;
            this.pendantType = 0;
            this.liveStreamId = "";
            this.itemInfo = LivePendantItemInfo.emptyArray();
            this.randomMills = 0L;
            this.extraJson = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.pendSourceType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.pendantType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liveStreamId);
            }
            LivePendantItemInfo[] livePendantItemInfoArr = this.itemInfo;
            if (livePendantItemInfoArr != null && livePendantItemInfoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LivePendantItemInfo[] livePendantItemInfoArr2 = this.itemInfo;
                    if (i3 >= livePendantItemInfoArr2.length) {
                        break;
                    }
                    LivePendantItemInfo livePendantItemInfo = livePendantItemInfoArr2[i3];
                    if (livePendantItemInfo != null) {
                        codedOutputByteBufferNano.writeMessage(4, livePendantItemInfo);
                    }
                    i3++;
                }
            }
            long j = this.randomMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            if (!this.extraJson.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.extraJson);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.pendSourceType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.pendantType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
            }
            LivePendantItemInfo[] livePendantItemInfoArr = this.itemInfo;
            if (livePendantItemInfoArr != null && livePendantItemInfoArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LivePendantItemInfo[] livePendantItemInfoArr2 = this.itemInfo;
                    if (i3 >= livePendantItemInfoArr2.length) {
                        break;
                    }
                    LivePendantItemInfo livePendantItemInfo = livePendantItemInfoArr2[i3];
                    if (livePendantItemInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, livePendantItemInfo);
                    }
                    i3++;
                }
            }
            long j = this.randomMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
            }
            return !this.extraJson.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.extraJson) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveItemPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.pendSourceType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.pendantType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    LivePendantItemInfo[] livePendantItemInfoArr = this.itemInfo;
                    int length = livePendantItemInfoArr == null ? 0 : livePendantItemInfoArr.length;
                    LivePendantItemInfo[] livePendantItemInfoArr2 = new LivePendantItemInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.itemInfo, 0, livePendantItemInfoArr2, 0, length);
                    }
                    while (length < livePendantItemInfoArr2.length - 1) {
                        livePendantItemInfoArr2[length] = new LivePendantItemInfo();
                        codedInputByteBufferNano.readMessage(livePendantItemInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    livePendantItemInfoArr2[length] = new LivePendantItemInfo();
                    codedInputByteBufferNano.readMessage(livePendantItemInfoArr2[length]);
                    this.itemInfo = livePendantItemInfoArr2;
                } else if (tag == 40) {
                    this.randomMills = codedInputByteBufferNano.readUInt64();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraJson = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCKwaishopLiveItemPendant parseFrom(byte[] bArr) {
            return (SCKwaishopLiveItemPendant) MessageNano.mergeFrom(new SCKwaishopLiveItemPendant(), bArr);
        }

        public static SCKwaishopLiveItemPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveItemPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LivePendantItemInfo extends MessageNano {
        private static volatile LivePendantItemInfo[] _emptyArray;
        public String buttonText;
        public ItemInfo itemInfo;
        public ItemReservationInfo reservationInfo;
        public Map<String, String> staticStyle;

        public static LivePendantItemInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePendantItemInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePendantItemInfo() {
            clear();
        }

        public final LivePendantItemInfo clear() {
            this.itemInfo = null;
            this.reservationInfo = null;
            this.buttonText = "";
            this.staticStyle = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, itemInfo);
            }
            ItemReservationInfo itemReservationInfo = this.reservationInfo;
            if (itemReservationInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, itemReservationInfo);
            }
            if (!this.buttonText.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.buttonText);
            }
            Map<String, String> map = this.staticStyle;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 4, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ItemInfo itemInfo = this.itemInfo;
            if (itemInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, itemInfo);
            }
            ItemReservationInfo itemReservationInfo = this.reservationInfo;
            if (itemReservationInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, itemReservationInfo);
            }
            if (!this.buttonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.buttonText);
            }
            Map<String, String> map = this.staticStyle;
            return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 4, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePendantItemInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.itemInfo == null) {
                        this.itemInfo = new ItemInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.itemInfo);
                } else if (tag == 18) {
                    if (this.reservationInfo == null) {
                        this.reservationInfo = new ItemReservationInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.reservationInfo);
                } else if (tag == 26) {
                    this.buttonText = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.staticStyle = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.staticStyle, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static LivePendantItemInfo parseFrom(byte[] bArr) {
            return (LivePendantItemInfo) MessageNano.mergeFrom(new LivePendantItemInfo(), bArr);
        }

        public static LivePendantItemInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePendantItemInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ItemReservationInfo extends MessageNano {
        private static volatile ItemReservationInfo[] _emptyArray;
        public String itemWantCount;
        public long reservationCloseSaleMills;
        public String reservationSaleDesc;
        public long reservationSaleMills;
        public int reservationSaleStatus;

        public static ItemReservationInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ItemReservationInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ItemReservationInfo() {
            clear();
        }

        public final ItemReservationInfo clear() {
            this.reservationSaleStatus = 0;
            this.reservationSaleDesc = "";
            this.reservationSaleMills = 0L;
            this.reservationCloseSaleMills = 0L;
            this.itemWantCount = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.reservationSaleStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.reservationSaleDesc.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.reservationSaleDesc);
            }
            long j = this.reservationSaleMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.reservationCloseSaleMills;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.itemWantCount.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.itemWantCount);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.reservationSaleStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.reservationSaleDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.reservationSaleDesc);
            }
            long j = this.reservationSaleMills;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.reservationCloseSaleMills;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            return !this.itemWantCount.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.itemWantCount) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ItemReservationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.reservationSaleStatus = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.reservationSaleDesc = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.reservationSaleMills = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.reservationCloseSaleMills = codedInputByteBufferNano.readUInt64();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.itemWantCount = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ItemReservationInfo parseFrom(byte[] bArr) {
            return (ItemReservationInfo) MessageNano.mergeFrom(new ItemReservationInfo(), bArr);
        }

        public static ItemReservationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ItemReservationInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveCommonDialog extends MessageNano {
        private static volatile SCKwaishopLiveCommonDialog[] _emptyArray;
        public MerchantLiveCommonDialog dialog;
        public Map<String, String> extraMap;
        public Map<String, String> logMap;

        public static SCKwaishopLiveCommonDialog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveCommonDialog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveCommonDialog() {
            clear();
        }

        public final SCKwaishopLiveCommonDialog clear() {
            this.dialog = null;
            this.extraMap = null;
            this.logMap = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            MerchantLiveCommonDialog merchantLiveCommonDialog = this.dialog;
            if (merchantLiveCommonDialog != null) {
                codedOutputByteBufferNano.writeMessage(1, merchantLiveCommonDialog);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 9, 9);
            }
            Map<String, String> map2 = this.logMap;
            if (map2 != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 3, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            MerchantLiveCommonDialog merchantLiveCommonDialog = this.dialog;
            if (merchantLiveCommonDialog != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, merchantLiveCommonDialog);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 2, 9, 9);
            }
            Map<String, String> map2 = this.logMap;
            return map2 != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map2, 3, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveCommonDialog mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.dialog == null) {
                        this.dialog = new MerchantLiveCommonDialog();
                    }
                    codedInputByteBufferNano.readMessage(this.dialog);
                } else if (tag == 18) {
                    this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.logMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.logMap, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static SCKwaishopLiveCommonDialog parseFrom(byte[] bArr) {
            return (SCKwaishopLiveCommonDialog) MessageNano.mergeFrom(new SCKwaishopLiveCommonDialog(), bArr);
        }

        public static SCKwaishopLiveCommonDialog parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveCommonDialog().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveCommonToast extends MessageNano {
        private static volatile SCKwaishopLiveCommonToast[] _emptyArray;
        public Map<String, String> extraMap;
        public Map<String, String> logMap;
        public MerchantLiveCommonToast toast;

        public static SCKwaishopLiveCommonToast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveCommonToast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveCommonToast() {
            clear();
        }

        public final SCKwaishopLiveCommonToast clear() {
            this.toast = null;
            this.extraMap = null;
            this.logMap = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            MerchantLiveCommonToast merchantLiveCommonToast = this.toast;
            if (merchantLiveCommonToast != null) {
                codedOutputByteBufferNano.writeMessage(1, merchantLiveCommonToast);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 9, 9);
            }
            Map<String, String> map2 = this.logMap;
            if (map2 != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 3, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            MerchantLiveCommonToast merchantLiveCommonToast = this.toast;
            if (merchantLiveCommonToast != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, merchantLiveCommonToast);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 2, 9, 9);
            }
            Map<String, String> map2 = this.logMap;
            return map2 != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map2, 3, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveCommonToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.toast == null) {
                        this.toast = new MerchantLiveCommonToast();
                    }
                    codedInputByteBufferNano.readMessage(this.toast);
                } else if (tag == 18) {
                    this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.logMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.logMap, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static SCKwaishopLiveCommonToast parseFrom(byte[] bArr) {
            return (SCKwaishopLiveCommonToast) MessageNano.mergeFrom(new SCKwaishopLiveCommonToast(), bArr);
        }

        public static SCKwaishopLiveCommonToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveCommonToast().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantLiveCommonDialog extends MessageNano {
        private static volatile MerchantLiveCommonDialog[] _emptyArray;
        public DialogButton cancelButton;
        public String checkboxText;
        public DialogButton confirmButton;
        public String desc;
        public long duration;
        public String title;

        public static MerchantLiveCommonDialog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantLiveCommonDialog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantLiveCommonDialog() {
            clear();
        }

        public final MerchantLiveCommonDialog clear() {
            this.title = "";
            this.desc = "";
            this.duration = 0L;
            this.checkboxText = "";
            this.cancelButton = null;
            this.confirmButton = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.title);
            }
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.desc);
            }
            long j = this.duration;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.checkboxText.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.checkboxText);
            }
            DialogButton dialogButton = this.cancelButton;
            if (dialogButton != null) {
                codedOutputByteBufferNano.writeMessage(5, dialogButton);
            }
            DialogButton dialogButton2 = this.confirmButton;
            if (dialogButton2 != null) {
                codedOutputByteBufferNano.writeMessage(6, dialogButton2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
            }
            if (!this.desc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.desc);
            }
            long j = this.duration;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.checkboxText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.checkboxText);
            }
            DialogButton dialogButton = this.cancelButton;
            if (dialogButton != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, dialogButton);
            }
            DialogButton dialogButton2 = this.confirmButton;
            return dialogButton2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, dialogButton2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantLiveCommonDialog mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.desc = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.duration = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    this.checkboxText = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    if (this.cancelButton == null) {
                        this.cancelButton = new DialogButton();
                    }
                    codedInputByteBufferNano.readMessage(this.cancelButton);
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.confirmButton == null) {
                        this.confirmButton = new DialogButton();
                    }
                    codedInputByteBufferNano.readMessage(this.confirmButton);
                }
            }
        }

        public static MerchantLiveCommonDialog parseFrom(byte[] bArr) {
            return (MerchantLiveCommonDialog) MessageNano.mergeFrom(new MerchantLiveCommonDialog(), bArr);
        }

        public static MerchantLiveCommonDialog parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantLiveCommonDialog().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DialogButton extends MessageNano {
        private static volatile DialogButton[] _emptyArray;
        public String buttonText;
        public String buttonUrl;

        public static DialogButton[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DialogButton[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DialogButton() {
            clear();
        }

        public final DialogButton clear() {
            this.buttonText = "";
            this.buttonUrl = "";
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
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.buttonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.buttonText);
            }
            return !this.buttonUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.buttonUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DialogButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.buttonText = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.buttonUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static DialogButton parseFrom(byte[] bArr) {
            return (DialogButton) MessageNano.mergeFrom(new DialogButton(), bArr);
        }

        public static DialogButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DialogButton().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantLiveCommonToast extends MessageNano {
        private static volatile MerchantLiveCommonToast[] _emptyArray;
        public String url;

        public static MerchantLiveCommonToast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantLiveCommonToast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantLiveCommonToast() {
            clear();
        }

        public final MerchantLiveCommonToast clear() {
            this.url = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.url);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.url) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantLiveCommonToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.url = codedInputByteBufferNano.readString();
                }
            }
        }

        public static MerchantLiveCommonToast parseFrom(byte[] bArr) {
            return (MerchantLiveCommonToast) MessageNano.mergeFrom(new MerchantLiveCommonToast(), bArr);
        }

        public static MerchantLiveCommonToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantLiveCommonToast().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLivePendantDestroy extends MessageNano {
        private static volatile SCKwaishopLivePendantDestroy[] _emptyArray;
        public int destroyPendantType;
        public long destroyTime;
        public String liveStreamId;
        public long recoverTime;

        public static SCKwaishopLivePendantDestroy[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLivePendantDestroy[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLivePendantDestroy() {
            clear();
        }

        public final SCKwaishopLivePendantDestroy clear() {
            this.destroyPendantType = 0;
            this.liveStreamId = "";
            this.destroyTime = 0L;
            this.recoverTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.destroyPendantType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.liveStreamId);
            }
            long j = this.destroyTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.recoverTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.destroyPendantType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
            }
            long j = this.destroyTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.recoverTime;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLivePendantDestroy mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.destroyPendantType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.destroyTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.recoverTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCKwaishopLivePendantDestroy parseFrom(byte[] bArr) {
            return (SCKwaishopLivePendantDestroy) MessageNano.mergeFrom(new SCKwaishopLivePendantDestroy(), bArr);
        }

        public static SCKwaishopLivePendantDestroy parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLivePendantDestroy().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopResourceLivePendantData extends MessageNano {
        private static volatile SCKwaishopResourceLivePendantData[] _emptyArray;
        public int action;
        public int durationShow;
        public String eventData;
        public String liveStreamId;
        public long materialId;
        public String resourceCode;
        public long showStartTime;
        public String throughInfo;

        public static SCKwaishopResourceLivePendantData[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopResourceLivePendantData[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopResourceLivePendantData() {
            clear();
        }

        public final SCKwaishopResourceLivePendantData clear() {
            this.materialId = 0L;
            this.resourceCode = "";
            this.liveStreamId = "";
            this.action = 0;
            this.eventData = "";
            this.throughInfo = "";
            this.showStartTime = 0L;
            this.durationShow = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.materialId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.resourceCode.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.resourceCode);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liveStreamId);
            }
            int i = this.action;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            if (!this.eventData.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.eventData);
            }
            if (!this.throughInfo.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.throughInfo);
            }
            long j2 = this.showStartTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j2);
            }
            int i2 = this.durationShow;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.materialId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.resourceCode.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.resourceCode);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
            }
            int i = this.action;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            if (!this.eventData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.eventData);
            }
            if (!this.throughInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.throughInfo);
            }
            long j2 = this.showStartTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j2);
            }
            int i2 = this.durationShow;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopResourceLivePendantData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.materialId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.resourceCode = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.action = codedInputByteBufferNano.readUInt32();
                } else if (tag == 42) {
                    this.eventData = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.throughInfo = codedInputByteBufferNano.readString();
                } else if (tag == 56) {
                    this.showStartTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.durationShow = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCKwaishopResourceLivePendantData parseFrom(byte[] bArr) {
            return (SCKwaishopResourceLivePendantData) MessageNano.mergeFrom(new SCKwaishopResourceLivePendantData(), bArr);
        }

        public static SCKwaishopResourceLivePendantData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopResourceLivePendantData().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CallbackTimeComponent extends MessageNano {
        private static volatile CallbackTimeComponent[] _emptyArray;
        public long timeMills;
        public int type;

        public static CallbackTimeComponent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CallbackTimeComponent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CallbackTimeComponent() {
            clear();
        }

        public final CallbackTimeComponent clear() {
            this.type = 0;
            this.timeMills = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.timeMills;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.timeMills;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CallbackTimeComponent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timeMills = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static CallbackTimeComponent parseFrom(byte[] bArr) {
            return (CallbackTimeComponent) MessageNano.mergeFrom(new CallbackTimeComponent(), bArr);
        }

        public static CallbackTimeComponent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CallbackTimeComponent().mergeFrom(codedInputByteBufferNano);
        }
    }
}
