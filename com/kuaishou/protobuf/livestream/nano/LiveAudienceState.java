package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveFansGroupMessages;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveAudienceState extends MessageNano {
    private static volatile LiveAudienceState[] _emptyArray;
    public int assistantType;
    public int audienceRank;
    public String badgeKey;
    public int fansGroupIntimacyLevel;
    public LiveFeedBackground feedBackground;
    public String hometown;
    public boolean isAnonymousIdentity;
    public boolean isFromFansTop;
    public boolean isJewelAndJadeCollector;
    public boolean isKoi;
    public boolean isSenderVisible;
    public UserStateRichTextSegment[] liteUserStateSegment;
    public LiveFansGroupMessages.LiveFansGroupState liveFansGroupState;
    public LivePrivilegeState livePrivilegeState;
    public LiveUserInfo liveUserInfo;
    public GzoneNameplate nameplate;
    public Map<String, String> userConditionStateExtraInfo;
    public int[] userFeature;
    public UserStateRichTextSegment[] userStateConditionSegment;
    public UserStateRichTextSegment[] userStateSegment;
    public UserStateRichTextSegment[] userStateSegmentExtra;
    public UserStateRichTextSegment[] userStateSegmentForAuthor;
    public int wealthGrade;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AssistantType {
        public static final int JUNIOR = 2;
        public static final int SUPER = 1;
        public static final int UNKNOWN_ASSISTANT_TYPE = 0;
    }

    public static LiveAudienceState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveAudienceState[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveAudienceState() {
        clear();
    }

    public final LiveAudienceState clear() {
        this.isFromFansTop = false;
        this.isKoi = false;
        this.assistantType = 0;
        this.fansGroupIntimacyLevel = 0;
        this.nameplate = null;
        this.liveFansGroupState = null;
        this.wealthGrade = 0;
        this.badgeKey = "";
        this.livePrivilegeState = null;
        this.audienceRank = 0;
        this.userStateSegment = UserStateRichTextSegment.emptyArray();
        this.feedBackground = null;
        this.userFeature = WireFormatNano.EMPTY_INT_ARRAY;
        this.liveUserInfo = null;
        this.userStateSegmentForAuthor = UserStateRichTextSegment.emptyArray();
        this.isSenderVisible = false;
        this.hometown = "";
        this.userStateConditionSegment = UserStateRichTextSegment.emptyArray();
        this.isJewelAndJadeCollector = false;
        this.isAnonymousIdentity = false;
        this.liteUserStateSegment = UserStateRichTextSegment.emptyArray();
        this.userStateSegmentExtra = UserStateRichTextSegment.emptyArray();
        this.userConditionStateExtraInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.isFromFansTop;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.isKoi;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        int i = this.assistantType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        int i2 = this.fansGroupIntimacyLevel;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        GzoneNameplate gzoneNameplate = this.nameplate;
        if (gzoneNameplate != null) {
            codedOutputByteBufferNano.writeMessage(5, gzoneNameplate);
        }
        LiveFansGroupMessages.LiveFansGroupState liveFansGroupState = this.liveFansGroupState;
        if (liveFansGroupState != null) {
            codedOutputByteBufferNano.writeMessage(6, liveFansGroupState);
        }
        int i3 = this.wealthGrade;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        if (!this.badgeKey.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.badgeKey);
        }
        LivePrivilegeState livePrivilegeState = this.livePrivilegeState;
        if (livePrivilegeState != null) {
            codedOutputByteBufferNano.writeMessage(9, livePrivilegeState);
        }
        int i4 = this.audienceRank;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i4);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr = this.userStateSegment;
        int i5 = 0;
        if (userStateRichTextSegmentArr != null && userStateRichTextSegmentArr.length > 0) {
            int i6 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr2 = this.userStateSegment;
                if (i6 >= userStateRichTextSegmentArr2.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment = userStateRichTextSegmentArr2[i6];
                if (userStateRichTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(11, userStateRichTextSegment);
                }
                i6++;
            }
        }
        LiveFeedBackground liveFeedBackground = this.feedBackground;
        if (liveFeedBackground != null) {
            codedOutputByteBufferNano.writeMessage(12, liveFeedBackground);
        }
        int[] iArr = this.userFeature;
        if (iArr != null && iArr.length > 0) {
            int i7 = 0;
            while (true) {
                int[] iArr2 = this.userFeature;
                if (i7 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(13, iArr2[i7]);
                i7++;
            }
        }
        LiveUserInfo liveUserInfo = this.liveUserInfo;
        if (liveUserInfo != null) {
            codedOutputByteBufferNano.writeMessage(14, liveUserInfo);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr3 = this.userStateSegmentForAuthor;
        if (userStateRichTextSegmentArr3 != null && userStateRichTextSegmentArr3.length > 0) {
            int i8 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr4 = this.userStateSegmentForAuthor;
                if (i8 >= userStateRichTextSegmentArr4.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment2 = userStateRichTextSegmentArr4[i8];
                if (userStateRichTextSegment2 != null) {
                    codedOutputByteBufferNano.writeMessage(15, userStateRichTextSegment2);
                }
                i8++;
            }
        }
        boolean z3 = this.isSenderVisible;
        if (z3) {
            codedOutputByteBufferNano.writeBool(16, z3);
        }
        if (!this.hometown.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.hometown);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr5 = this.userStateConditionSegment;
        if (userStateRichTextSegmentArr5 != null && userStateRichTextSegmentArr5.length > 0) {
            int i9 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr6 = this.userStateConditionSegment;
                if (i9 >= userStateRichTextSegmentArr6.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment3 = userStateRichTextSegmentArr6[i9];
                if (userStateRichTextSegment3 != null) {
                    codedOutputByteBufferNano.writeMessage(18, userStateRichTextSegment3);
                }
                i9++;
            }
        }
        boolean z4 = this.isJewelAndJadeCollector;
        if (z4) {
            codedOutputByteBufferNano.writeBool(19, z4);
        }
        boolean z5 = this.isAnonymousIdentity;
        if (z5) {
            codedOutputByteBufferNano.writeBool(20, z5);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr7 = this.liteUserStateSegment;
        if (userStateRichTextSegmentArr7 != null && userStateRichTextSegmentArr7.length > 0) {
            int i10 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr8 = this.liteUserStateSegment;
                if (i10 >= userStateRichTextSegmentArr8.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment4 = userStateRichTextSegmentArr8[i10];
                if (userStateRichTextSegment4 != null) {
                    codedOutputByteBufferNano.writeMessage(21, userStateRichTextSegment4);
                }
                i10++;
            }
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr9 = this.userStateSegmentExtra;
        if (userStateRichTextSegmentArr9 != null && userStateRichTextSegmentArr9.length > 0) {
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr10 = this.userStateSegmentExtra;
                if (i5 >= userStateRichTextSegmentArr10.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment5 = userStateRichTextSegmentArr10[i5];
                if (userStateRichTextSegment5 != null) {
                    codedOutputByteBufferNano.writeMessage(22, userStateRichTextSegment5);
                }
                i5++;
            }
        }
        Map<String, String> map = this.userConditionStateExtraInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 23, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int[] iArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isFromFansTop;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        boolean z2 = this.isKoi;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
        }
        int i = this.assistantType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        int i2 = this.fansGroupIntimacyLevel;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        GzoneNameplate gzoneNameplate = this.nameplate;
        if (gzoneNameplate != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, gzoneNameplate);
        }
        LiveFansGroupMessages.LiveFansGroupState liveFansGroupState = this.liveFansGroupState;
        if (liveFansGroupState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveFansGroupState);
        }
        int i3 = this.wealthGrade;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i3);
        }
        if (!this.badgeKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.badgeKey);
        }
        LivePrivilegeState livePrivilegeState = this.livePrivilegeState;
        if (livePrivilegeState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, livePrivilegeState);
        }
        int i4 = this.audienceRank;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i4);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr = this.userStateSegment;
        int i5 = 0;
        if (userStateRichTextSegmentArr != null && userStateRichTextSegmentArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i6 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr2 = this.userStateSegment;
                if (i6 >= userStateRichTextSegmentArr2.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment = userStateRichTextSegmentArr2[i6];
                if (userStateRichTextSegment != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(11, userStateRichTextSegment);
                }
                i6++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveFeedBackground liveFeedBackground = this.feedBackground;
        if (liveFeedBackground != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, liveFeedBackground);
        }
        int[] iArr2 = this.userFeature;
        if (iArr2 != null && iArr2.length > 0) {
            int i7 = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                iArr = this.userFeature;
                if (i7 >= iArr.length) {
                    break;
                }
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i7]);
                i7++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr.length * 1);
        }
        LiveUserInfo liveUserInfo = this.liveUserInfo;
        if (liveUserInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, liveUserInfo);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr3 = this.userStateSegmentForAuthor;
        if (userStateRichTextSegmentArr3 != null && userStateRichTextSegmentArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i8 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr4 = this.userStateSegmentForAuthor;
                if (i8 >= userStateRichTextSegmentArr4.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment2 = userStateRichTextSegmentArr4[i8];
                if (userStateRichTextSegment2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(15, userStateRichTextSegment2);
                }
                i8++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        boolean z3 = this.isSenderVisible;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, z3);
        }
        if (!this.hometown.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.hometown);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr5 = this.userStateConditionSegment;
        if (userStateRichTextSegmentArr5 != null && userStateRichTextSegmentArr5.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i9 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr6 = this.userStateConditionSegment;
                if (i9 >= userStateRichTextSegmentArr6.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment3 = userStateRichTextSegmentArr6[i9];
                if (userStateRichTextSegment3 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(18, userStateRichTextSegment3);
                }
                i9++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        boolean z4 = this.isJewelAndJadeCollector;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(19, z4);
        }
        boolean z5 = this.isAnonymousIdentity;
        if (z5) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z5);
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr7 = this.liteUserStateSegment;
        if (userStateRichTextSegmentArr7 != null && userStateRichTextSegmentArr7.length > 0) {
            int iComputeMessageSize4 = iComputeSerializedSize;
            int i10 = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr8 = this.liteUserStateSegment;
                if (i10 >= userStateRichTextSegmentArr8.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment4 = userStateRichTextSegmentArr8[i10];
                if (userStateRichTextSegment4 != null) {
                    iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(21, userStateRichTextSegment4);
                }
                i10++;
            }
            iComputeSerializedSize = iComputeMessageSize4;
        }
        UserStateRichTextSegment[] userStateRichTextSegmentArr9 = this.userStateSegmentExtra;
        if (userStateRichTextSegmentArr9 != null && userStateRichTextSegmentArr9.length > 0) {
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr10 = this.userStateSegmentExtra;
                if (i5 >= userStateRichTextSegmentArr10.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment5 = userStateRichTextSegmentArr10[i5];
                if (userStateRichTextSegment5 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, userStateRichTextSegment5);
                }
                i5++;
            }
        }
        Map<String, String> map = this.userConditionStateExtraInfo;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 23, 9, 9) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveAudienceState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.isFromFansTop = codedInputByteBufferNano.readBool();
                    break;
                case 16:
                    this.isKoi = codedInputByteBufferNano.readBool();
                    break;
                case 24:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.assistantType = int32;
                        break;
                    }
                case 32:
                    this.fansGroupIntimacyLevel = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    if (this.nameplate == null) {
                        this.nameplate = new GzoneNameplate();
                    }
                    codedInputByteBufferNano.readMessage(this.nameplate);
                    break;
                case 50:
                    if (this.liveFansGroupState == null) {
                        this.liveFansGroupState = new LiveFansGroupMessages.LiveFansGroupState();
                    }
                    codedInputByteBufferNano.readMessage(this.liveFansGroupState);
                    break;
                case 56:
                    this.wealthGrade = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.badgeKey = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    if (this.livePrivilegeState == null) {
                        this.livePrivilegeState = new LivePrivilegeState();
                    }
                    codedInputByteBufferNano.readMessage(this.livePrivilegeState);
                    break;
                case 80:
                    this.audienceRank = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    UserStateRichTextSegment[] userStateRichTextSegmentArr = this.userStateSegment;
                    int length = userStateRichTextSegmentArr == null ? 0 : userStateRichTextSegmentArr.length;
                    UserStateRichTextSegment[] userStateRichTextSegmentArr2 = new UserStateRichTextSegment[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.userStateSegment, 0, userStateRichTextSegmentArr2, 0, length);
                    }
                    while (length < userStateRichTextSegmentArr2.length - 1) {
                        userStateRichTextSegmentArr2[length] = new UserStateRichTextSegment();
                        codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    userStateRichTextSegmentArr2[length] = new UserStateRichTextSegment();
                    codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr2[length]);
                    this.userStateSegment = userStateRichTextSegmentArr2;
                    break;
                case 98:
                    if (this.feedBackground == null) {
                        this.feedBackground = new LiveFeedBackground();
                    }
                    codedInputByteBufferNano.readMessage(this.feedBackground);
                    break;
                case 104:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 104);
                    int[] iArr = this.userFeature;
                    int length2 = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.userFeature, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    this.userFeature = iArr2;
                    break;
                case 106:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.userFeature;
                    int length3 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.userFeature, 0, iArr4, 0, length3);
                    }
                    while (length3 < iArr4.length) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        length3++;
                    }
                    this.userFeature = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                case 114:
                    if (this.liveUserInfo == null) {
                        this.liveUserInfo = new LiveUserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.liveUserInfo);
                    break;
                case 122:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    UserStateRichTextSegment[] userStateRichTextSegmentArr3 = this.userStateSegmentForAuthor;
                    int length4 = userStateRichTextSegmentArr3 == null ? 0 : userStateRichTextSegmentArr3.length;
                    UserStateRichTextSegment[] userStateRichTextSegmentArr4 = new UserStateRichTextSegment[repeatedFieldArrayLength3 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.userStateSegmentForAuthor, 0, userStateRichTextSegmentArr4, 0, length4);
                    }
                    while (length4 < userStateRichTextSegmentArr4.length - 1) {
                        userStateRichTextSegmentArr4[length4] = new UserStateRichTextSegment();
                        codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr4[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    userStateRichTextSegmentArr4[length4] = new UserStateRichTextSegment();
                    codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr4[length4]);
                    this.userStateSegmentForAuthor = userStateRichTextSegmentArr4;
                    break;
                case 128:
                    this.isSenderVisible = codedInputByteBufferNano.readBool();
                    break;
                case 138:
                    this.hometown = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                    UserStateRichTextSegment[] userStateRichTextSegmentArr5 = this.userStateConditionSegment;
                    int length5 = userStateRichTextSegmentArr5 == null ? 0 : userStateRichTextSegmentArr5.length;
                    UserStateRichTextSegment[] userStateRichTextSegmentArr6 = new UserStateRichTextSegment[repeatedFieldArrayLength4 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.userStateConditionSegment, 0, userStateRichTextSegmentArr6, 0, length5);
                    }
                    while (length5 < userStateRichTextSegmentArr6.length - 1) {
                        userStateRichTextSegmentArr6[length5] = new UserStateRichTextSegment();
                        codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr6[length5]);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    userStateRichTextSegmentArr6[length5] = new UserStateRichTextSegment();
                    codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr6[length5]);
                    this.userStateConditionSegment = userStateRichTextSegmentArr6;
                    break;
                case 152:
                    this.isJewelAndJadeCollector = codedInputByteBufferNano.readBool();
                    break;
                case 160:
                    this.isAnonymousIdentity = codedInputByteBufferNano.readBool();
                    break;
                case 170:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    UserStateRichTextSegment[] userStateRichTextSegmentArr7 = this.liteUserStateSegment;
                    int length6 = userStateRichTextSegmentArr7 == null ? 0 : userStateRichTextSegmentArr7.length;
                    UserStateRichTextSegment[] userStateRichTextSegmentArr8 = new UserStateRichTextSegment[repeatedFieldArrayLength5 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.liteUserStateSegment, 0, userStateRichTextSegmentArr8, 0, length6);
                    }
                    while (length6 < userStateRichTextSegmentArr8.length - 1) {
                        userStateRichTextSegmentArr8[length6] = new UserStateRichTextSegment();
                        codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr8[length6]);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    userStateRichTextSegmentArr8[length6] = new UserStateRichTextSegment();
                    codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr8[length6]);
                    this.liteUserStateSegment = userStateRichTextSegmentArr8;
                    break;
                case 178:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                    UserStateRichTextSegment[] userStateRichTextSegmentArr9 = this.userStateSegmentExtra;
                    int length7 = userStateRichTextSegmentArr9 == null ? 0 : userStateRichTextSegmentArr9.length;
                    UserStateRichTextSegment[] userStateRichTextSegmentArr10 = new UserStateRichTextSegment[repeatedFieldArrayLength6 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.userStateSegmentExtra, 0, userStateRichTextSegmentArr10, 0, length7);
                    }
                    while (length7 < userStateRichTextSegmentArr10.length - 1) {
                        userStateRichTextSegmentArr10[length7] = new UserStateRichTextSegment();
                        codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr10[length7]);
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    userStateRichTextSegmentArr10[length7] = new UserStateRichTextSegment();
                    codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr10[length7]);
                    this.userStateSegmentExtra = userStateRichTextSegmentArr10;
                    break;
                case 186:
                    this.userConditionStateExtraInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.userConditionStateExtraInfo, mapFactory, 9, 9, null, 10, 18);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveAudienceState parseFrom(byte[] bArr) {
        return (LiveAudienceState) MessageNano.mergeFrom(new LiveAudienceState(), bArr);
    }

    public static LiveAudienceState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveAudienceState().mergeFrom(codedInputByteBufferNano);
    }
}
