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
public interface LiveFansGroupMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FansGroupCommandType {
        public static final int TOAST = 1;
        public static final int UNKNOWN_FANS_GROUP_COMMAND_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FansGroupToastSceneType {
        public static final int KS_COIN_REWARD = 1;
        public static final int SHARE_PHOTO_REWARD = 2;
        public static final int UNKNOWN_FANS_GROUP_TOAST_SCENE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveFansGroupEnterRoomSpecialEffectType {
        public static final int FANS_GROUP_ENTER_ROOM_SPECAIL_EFFECT16 = 3;
        public static final int ORANGE_LIGHT = 1;
        public static final int SUPER_FANS_GROUP_ENTER_ROOM_SPECAIL_EFFECT = 2;
        public static final int SUPER_FANS_GROUP_ENTER_ROOM_SPECAIL_EFFECT16 = 4;
        public static final int UNKNOWN_SPECIAL_EFFECT_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveFansGroupMedalType {
        public static final int HONORABLE = 3;
        public static final int NONE = 0;
        public static final int POPULAR = 2;
        public static final int POTENTIAL = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveFansGroupStatusChangedType {
        public static final int ACTIVE_STATUS_CHANGED = 2;
        public static final int INTIMACY_INCREASE = 3;
        public static final int INTIMACY_LEVEL_UPDATED = 1;
        public static final int JOIN_STATUS_CHANGED = 5;
        public static final int MEDAL_UPDATED = 4;
        public static final int UNKNOWN_STATUS_CHANGED_TYPE = 0;
    }

    public static final class SCLiveFansGroupStatusChanged extends MessageNano {
        private static volatile SCLiveFansGroupStatusChanged[] _emptyArray;
        public int activeStatus;
        public long audienceId;
        public long authorId;
        public int intimacyLevel;
        public UserInfos.PicUrl[] medalIconUrls;
        public int medalType;
        public String noticeText;
        public int statusChangedType;

        public static SCLiveFansGroupStatusChanged[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveFansGroupStatusChanged[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveFansGroupStatusChanged() {
            clear();
        }

        public final SCLiveFansGroupStatusChanged clear() {
            this.audienceId = 0L;
            this.statusChangedType = 0;
            this.intimacyLevel = 0;
            this.activeStatus = 0;
            this.noticeText = "";
            this.medalType = 0;
            this.medalIconUrls = UserInfos.PicUrl.emptyArray();
            this.authorId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.audienceId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.statusChangedType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.intimacyLevel;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            int i3 = this.activeStatus;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i3);
            }
            if (!this.noticeText.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.noticeText);
            }
            int i4 = this.medalType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i4);
            }
            UserInfos.PicUrl[] picUrlArr = this.medalIconUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.medalIconUrls;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(7, picUrl);
                    }
                    i5++;
                }
            }
            long j2 = this.authorId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.audienceId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.statusChangedType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.intimacyLevel;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            int i3 = this.activeStatus;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
            }
            if (!this.noticeText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.noticeText);
            }
            int i4 = this.medalType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i4);
            }
            UserInfos.PicUrl[] picUrlArr = this.medalIconUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.medalIconUrls;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, picUrl);
                    }
                    i5++;
                }
            }
            long j2 = this.authorId;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveFansGroupStatusChanged mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.audienceId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.statusChangedType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.intimacyLevel = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.activeStatus = codedInputByteBufferNano.readUInt32();
                } else if (tag == 42) {
                    this.noticeText = codedInputByteBufferNano.readString();
                } else if (tag == 48) {
                    this.medalType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 58) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr = this.medalIconUrls;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.medalIconUrls, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.medalIconUrls = picUrlArr2;
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.authorId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveFansGroupStatusChanged parseFrom(byte[] bArr) {
            return (SCLiveFansGroupStatusChanged) MessageNano.mergeFrom(new SCLiveFansGroupStatusChanged(), bArr);
        }

        public static SCLiveFansGroupStatusChanged parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveFansGroupStatusChanged().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFansGroupState extends MessageNano {
        private static volatile LiveFansGroupState[] _emptyArray;
        public int enterRoomSpecialEffect;
        public int intimacyLevel;

        public static LiveFansGroupState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFansGroupState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFansGroupState() {
            clear();
        }

        public final LiveFansGroupState clear() {
            this.intimacyLevel = 0;
            this.enterRoomSpecialEffect = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.intimacyLevel;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.enterRoomSpecialEffect;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.intimacyLevel;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.enterRoomSpecialEffect;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFansGroupState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.intimacyLevel = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enterRoomSpecialEffect = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveFansGroupState parseFrom(byte[] bArr) {
            return (LiveFansGroupState) MessageNano.mergeFrom(new LiveFansGroupState(), bArr);
        }

        public static LiveFansGroupState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFansGroupState().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FansGroupPush extends MessageNano {
        public static final int TOAST_FIELD_NUMBER = 2;
        private static volatile FansGroupPush[] _emptyArray;
        private int dataOneOfCase_ = 0;
        private Object dataOneOf_;
        public int type;

        public final int getDataOneOfCase() {
            return this.dataOneOfCase_;
        }

        public final FansGroupPush clearDataOneOf() {
            this.dataOneOfCase_ = 0;
            this.dataOneOf_ = null;
            return this;
        }

        public static FansGroupPush[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FansGroupPush[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasToast() {
            return this.dataOneOfCase_ == 2;
        }

        public final FansGroupToastProto getToast() {
            if (this.dataOneOfCase_ == 2) {
                return (FansGroupToastProto) this.dataOneOf_;
            }
            return null;
        }

        public final FansGroupPush setToast(FansGroupToastProto fansGroupToastProto) {
            if (fansGroupToastProto == null) {
                throw new NullPointerException();
            }
            this.dataOneOfCase_ = 2;
            this.dataOneOf_ = fansGroupToastProto;
            return this;
        }

        public FansGroupPush() {
            clear();
        }

        public final FansGroupPush clear() {
            this.type = 0;
            clearDataOneOf();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (this.dataOneOfCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.dataOneOf_);
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
            return this.dataOneOfCase_ == 2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.dataOneOf_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FansGroupPush mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.type = int32;
                    }
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.dataOneOfCase_ != 2) {
                        this.dataOneOf_ = new FansGroupToastProto();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.dataOneOf_);
                    this.dataOneOfCase_ = 2;
                }
            }
        }

        public static FansGroupPush parseFrom(byte[] bArr) {
            return (FansGroupPush) MessageNano.mergeFrom(new FansGroupPush(), bArr);
        }

        public static FansGroupPush parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FansGroupPush().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FansGroupToastProto extends MessageNano {
        private static volatile FansGroupToastProto[] _emptyArray;
        public String content;
        public int scene;

        public static FansGroupToastProto[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FansGroupToastProto[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FansGroupToastProto() {
            clear();
        }

        public final FansGroupToastProto clear() {
            this.scene = 0;
            this.content = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.scene;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.content);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.scene;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            return !this.content.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.content) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FansGroupToastProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.scene = int32;
                    }
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.content = codedInputByteBufferNano.readString();
                }
            }
        }

        public static FansGroupToastProto parseFrom(byte[] bArr) {
            return (FansGroupToastProto) MessageNano.mergeFrom(new FansGroupToastProto(), bArr);
        }

        public static FansGroupToastProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FansGroupToastProto().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveFansGroupSpecialEffectsSignal extends MessageNano {
        private static volatile SCLiveFansGroupSpecialEffectsSignal[] _emptyArray;
        public LiveFloatingScreenBackgroundData backgroundData;
        public LiveFloatingScreenBaseItemData[] baseItemData;
        public int priority;
        public int runwayType;
        public int type;
        public long userId;

        public static final class LiveFloatingScreenBaseItemData extends MessageNano {
            private static volatile LiveFloatingScreenBaseItemData[] _emptyArray;
            public int itemType;
            public String text;
            public String textColor;
            public long textSize;

            public static LiveFloatingScreenBaseItemData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new LiveFloatingScreenBaseItemData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public LiveFloatingScreenBaseItemData() {
                clear();
            }

            public final LiveFloatingScreenBaseItemData clear() {
                this.itemType = 0;
                this.text = "";
                this.textColor = "";
                this.textSize = 0L;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                int i = this.itemType;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(1, i);
                }
                if (!this.text.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.text);
                }
                if (!this.textColor.equals("")) {
                    codedOutputByteBufferNano.writeString(3, this.textColor);
                }
                long j = this.textSize;
                if (j != 0) {
                    codedOutputByteBufferNano.writeUInt64(4, j);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int i = this.itemType;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
                }
                if (!this.text.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
                }
                if (!this.textColor.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.textColor);
                }
                long j = this.textSize;
                return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final LiveFloatingScreenBaseItemData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.itemType = codedInputByteBufferNano.readUInt32();
                    } else if (tag == 18) {
                        this.text = codedInputByteBufferNano.readString();
                    } else if (tag == 26) {
                        this.textColor = codedInputByteBufferNano.readString();
                    } else if (tag != 32) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.textSize = codedInputByteBufferNano.readUInt64();
                    }
                }
            }

            public static LiveFloatingScreenBaseItemData parseFrom(byte[] bArr) {
                return (LiveFloatingScreenBaseItemData) MessageNano.mergeFrom(new LiveFloatingScreenBaseItemData(), bArr);
            }

            public static LiveFloatingScreenBaseItemData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new LiveFloatingScreenBaseItemData().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static final class LiveFloatingScreenBackgroundData extends MessageNano {
            private static volatile LiveFloatingScreenBackgroundData[] _emptyArray;
            public String[] backgroundGradientColors;
            public int backgroundType;

            public static LiveFloatingScreenBackgroundData[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new LiveFloatingScreenBackgroundData[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public LiveFloatingScreenBackgroundData() {
                clear();
            }

            public final LiveFloatingScreenBackgroundData clear() {
                this.backgroundType = 0;
                this.backgroundGradientColors = WireFormatNano.EMPTY_STRING_ARRAY;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                int i = this.backgroundType;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(1, i);
                }
                String[] strArr = this.backgroundGradientColors;
                if (strArr != null && strArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr2 = this.backgroundGradientColors;
                        if (i2 >= strArr2.length) {
                            break;
                        }
                        String str = strArr2[i2];
                        if (str != null) {
                            codedOutputByteBufferNano.writeString(2, str);
                        }
                        i2++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int i = this.backgroundType;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
                }
                String[] strArr = this.backgroundGradientColors;
                if (strArr == null || strArr.length <= 0) {
                    return iComputeSerializedSize;
                }
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.backgroundGradientColors;
                    if (i2 >= strArr2.length) {
                        return iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final LiveFloatingScreenBackgroundData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.backgroundType = codedInputByteBufferNano.readUInt32();
                    } else if (tag != 18) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        String[] strArr = this.backgroundGradientColors;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.backgroundGradientColors, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.backgroundGradientColors = strArr2;
                    }
                }
            }

            public static LiveFloatingScreenBackgroundData parseFrom(byte[] bArr) {
                return (LiveFloatingScreenBackgroundData) MessageNano.mergeFrom(new LiveFloatingScreenBackgroundData(), bArr);
            }

            public static LiveFloatingScreenBackgroundData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new LiveFloatingScreenBackgroundData().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static SCLiveFansGroupSpecialEffectsSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveFansGroupSpecialEffectsSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveFansGroupSpecialEffectsSignal() {
            clear();
        }

        public final SCLiveFansGroupSpecialEffectsSignal clear() {
            this.type = 0;
            this.priority = 0;
            this.runwayType = 0;
            this.userId = 0L;
            this.baseItemData = LiveFloatingScreenBaseItemData.emptyArray();
            this.backgroundData = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.priority;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.runwayType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            LiveFloatingScreenBaseItemData[] liveFloatingScreenBaseItemDataArr = this.baseItemData;
            if (liveFloatingScreenBaseItemDataArr != null && liveFloatingScreenBaseItemDataArr.length > 0) {
                int i4 = 0;
                while (true) {
                    LiveFloatingScreenBaseItemData[] liveFloatingScreenBaseItemDataArr2 = this.baseItemData;
                    if (i4 >= liveFloatingScreenBaseItemDataArr2.length) {
                        break;
                    }
                    LiveFloatingScreenBaseItemData liveFloatingScreenBaseItemData = liveFloatingScreenBaseItemDataArr2[i4];
                    if (liveFloatingScreenBaseItemData != null) {
                        codedOutputByteBufferNano.writeMessage(5, liveFloatingScreenBaseItemData);
                    }
                    i4++;
                }
            }
            LiveFloatingScreenBackgroundData liveFloatingScreenBackgroundData = this.backgroundData;
            if (liveFloatingScreenBackgroundData != null) {
                codedOutputByteBufferNano.writeMessage(6, liveFloatingScreenBackgroundData);
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
            int i2 = this.priority;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.runwayType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            LiveFloatingScreenBaseItemData[] liveFloatingScreenBaseItemDataArr = this.baseItemData;
            if (liveFloatingScreenBaseItemDataArr != null && liveFloatingScreenBaseItemDataArr.length > 0) {
                int i4 = 0;
                while (true) {
                    LiveFloatingScreenBaseItemData[] liveFloatingScreenBaseItemDataArr2 = this.baseItemData;
                    if (i4 >= liveFloatingScreenBaseItemDataArr2.length) {
                        break;
                    }
                    LiveFloatingScreenBaseItemData liveFloatingScreenBaseItemData = liveFloatingScreenBaseItemDataArr2[i4];
                    if (liveFloatingScreenBaseItemData != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveFloatingScreenBaseItemData);
                    }
                    i4++;
                }
            }
            LiveFloatingScreenBackgroundData liveFloatingScreenBackgroundData = this.backgroundData;
            return liveFloatingScreenBackgroundData != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, liveFloatingScreenBackgroundData) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveFansGroupSpecialEffectsSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.priority = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.runwayType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LiveFloatingScreenBaseItemData[] liveFloatingScreenBaseItemDataArr = this.baseItemData;
                    int length = liveFloatingScreenBaseItemDataArr == null ? 0 : liveFloatingScreenBaseItemDataArr.length;
                    LiveFloatingScreenBaseItemData[] liveFloatingScreenBaseItemDataArr2 = new LiveFloatingScreenBaseItemData[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.baseItemData, 0, liveFloatingScreenBaseItemDataArr2, 0, length);
                    }
                    while (length < liveFloatingScreenBaseItemDataArr2.length - 1) {
                        liveFloatingScreenBaseItemDataArr2[length] = new LiveFloatingScreenBaseItemData();
                        codedInputByteBufferNano.readMessage(liveFloatingScreenBaseItemDataArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveFloatingScreenBaseItemDataArr2[length] = new LiveFloatingScreenBaseItemData();
                    codedInputByteBufferNano.readMessage(liveFloatingScreenBaseItemDataArr2[length]);
                    this.baseItemData = liveFloatingScreenBaseItemDataArr2;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.backgroundData == null) {
                        this.backgroundData = new LiveFloatingScreenBackgroundData();
                    }
                    codedInputByteBufferNano.readMessage(this.backgroundData);
                }
            }
        }

        public static SCLiveFansGroupSpecialEffectsSignal parseFrom(byte[] bArr) {
            return (SCLiveFansGroupSpecialEffectsSignal) MessageNano.mergeFrom(new SCLiveFansGroupSpecialEffectsSignal(), bArr);
        }

        public static SCLiveFansGroupSpecialEffectsSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveFansGroupSpecialEffectsSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveFansGroupSlotFeedSignal extends MessageNano {
        private static volatile SCLiveFansGroupSlotFeedSignal[] _emptyArray;
        public String backgroundColor;
        public String desc;
        public long durationMs;
        public long expireTs;
        public UserInfos.PicUrl[] icon;
        public int slotPos;
        public String tailBgFileName;
        public UserInfos.UserInfo user;

        public static SCLiveFansGroupSlotFeedSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveFansGroupSlotFeedSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveFansGroupSlotFeedSignal() {
            clear();
        }

        public final SCLiveFansGroupSlotFeedSignal clear() {
            this.slotPos = 0;
            this.durationMs = 0L;
            this.expireTs = 0L;
            this.user = null;
            this.icon = UserInfos.PicUrl.emptyArray();
            this.tailBgFileName = "";
            this.backgroundColor = "";
            this.desc = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.slotPos;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.durationMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.expireTs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            UserInfos.UserInfo userInfo = this.user;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(4, userInfo);
            }
            UserInfos.PicUrl[] picUrlArr = this.icon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
            if (!this.tailBgFileName.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.tailBgFileName);
            }
            if (!this.backgroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.backgroundColor);
            }
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.desc);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.slotPos;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.durationMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.expireTs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            UserInfos.UserInfo userInfo = this.user;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
            }
            UserInfos.PicUrl[] picUrlArr = this.icon;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
            if (!this.tailBgFileName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.tailBgFileName);
            }
            if (!this.backgroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.backgroundColor);
            }
            return !this.desc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.desc) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveFansGroupSlotFeedSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.slotPos = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.durationMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.expireTs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    if (this.user == null) {
                        this.user = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
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
                } else if (tag == 50) {
                    this.tailBgFileName = codedInputByteBufferNano.readString();
                } else if (tag == 58) {
                    this.backgroundColor = codedInputByteBufferNano.readString();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.desc = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveFansGroupSlotFeedSignal parseFrom(byte[] bArr) {
            return (SCLiveFansGroupSlotFeedSignal) MessageNano.mergeFrom(new SCLiveFansGroupSlotFeedSignal(), bArr);
        }

        public static SCLiveFansGroupSlotFeedSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveFansGroupSlotFeedSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSuperFansQixiTaskInfo extends MessageNano {
        private static volatile LiveSuperFansQixiTaskInfo[] _emptyArray;
        public String advancedDesc;
        public int advancedScore;
        public int advancedTarget;
        public String elementaryDesc;
        public int elementaryScore;
        public int elementaryTarget;

        public static LiveSuperFansQixiTaskInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSuperFansQixiTaskInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSuperFansQixiTaskInfo() {
            clear();
        }

        public final LiveSuperFansQixiTaskInfo clear() {
            this.elementaryDesc = "";
            this.elementaryScore = 0;
            this.elementaryTarget = 0;
            this.advancedDesc = "";
            this.advancedScore = 0;
            this.advancedTarget = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.elementaryDesc.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.elementaryDesc);
            }
            int i = this.elementaryScore;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.elementaryTarget;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            if (!this.advancedDesc.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.advancedDesc);
            }
            int i3 = this.advancedScore;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i3);
            }
            int i4 = this.advancedTarget;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.elementaryDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.elementaryDesc);
            }
            int i = this.elementaryScore;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.elementaryTarget;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            if (!this.advancedDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.advancedDesc);
            }
            int i3 = this.advancedScore;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
            }
            int i4 = this.advancedTarget;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSuperFansQixiTaskInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.elementaryDesc = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.elementaryScore = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.elementaryTarget = codedInputByteBufferNano.readUInt32();
                } else if (tag == 34) {
                    this.advancedDesc = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    this.advancedScore = codedInputByteBufferNano.readUInt32();
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.advancedTarget = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveSuperFansQixiTaskInfo parseFrom(byte[] bArr) {
            return (LiveSuperFansQixiTaskInfo) MessageNano.mergeFrom(new LiveSuperFansQixiTaskInfo(), bArr);
        }

        public static LiveSuperFansQixiTaskInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSuperFansQixiTaskInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSuperFansQixiSuccInfo extends MessageNano {
        private static volatile LiveSuperFansQixiSuccInfo[] _emptyArray;
        public String taskCompleteDesc;

        public static LiveSuperFansQixiSuccInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSuperFansQixiSuccInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSuperFansQixiSuccInfo() {
            clear();
        }

        public final LiveSuperFansQixiSuccInfo clear() {
            this.taskCompleteDesc = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.taskCompleteDesc.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.taskCompleteDesc);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.taskCompleteDesc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.taskCompleteDesc) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSuperFansQixiSuccInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.taskCompleteDesc = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSuperFansQixiSuccInfo parseFrom(byte[] bArr) {
            return (LiveSuperFansQixiSuccInfo) MessageNano.mergeFrom(new LiveSuperFansQixiSuccInfo(), bArr);
        }

        public static LiveSuperFansQixiSuccInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSuperFansQixiSuccInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveSuperFansQixiWidgetInfo extends MessageNano {
        public static final int SUCC_INFO_FIELD_NUMBER = 8;
        public static final int TASK_INFO_FIELD_NUMBER = 7;
        private static volatile SCLiveSuperFansQixiWidgetInfo[] _emptyArray;
        public String bottomDesc;
        public String bottomJumpUrl;
        private int contentCase_ = 0;
        private Object content_;
        public long expireTime;
        public String subTitle;
        public String title;
        public int widgetStatus;

        @Retention(RetentionPolicy.SOURCE)
        public @interface WidgetStatus {
            public static final int CLOSE = 1;
            public static final int OPEN = 0;
        }

        public final int getContentCase() {
            return this.contentCase_;
        }

        public final SCLiveSuperFansQixiWidgetInfo clearContent() {
            this.contentCase_ = 0;
            this.content_ = null;
            return this;
        }

        public static SCLiveSuperFansQixiWidgetInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveSuperFansQixiWidgetInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasTaskInfo() {
            return this.contentCase_ == 7;
        }

        public final LiveSuperFansQixiTaskInfo getTaskInfo() {
            if (this.contentCase_ == 7) {
                return (LiveSuperFansQixiTaskInfo) this.content_;
            }
            return null;
        }

        public final SCLiveSuperFansQixiWidgetInfo setTaskInfo(LiveSuperFansQixiTaskInfo liveSuperFansQixiTaskInfo) {
            if (liveSuperFansQixiTaskInfo == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 7;
            this.content_ = liveSuperFansQixiTaskInfo;
            return this;
        }

        public final boolean hasSuccInfo() {
            return this.contentCase_ == 8;
        }

        public final LiveSuperFansQixiSuccInfo getSuccInfo() {
            if (this.contentCase_ == 8) {
                return (LiveSuperFansQixiSuccInfo) this.content_;
            }
            return null;
        }

        public final SCLiveSuperFansQixiWidgetInfo setSuccInfo(LiveSuperFansQixiSuccInfo liveSuperFansQixiSuccInfo) {
            if (liveSuperFansQixiSuccInfo == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 8;
            this.content_ = liveSuperFansQixiSuccInfo;
            return this;
        }

        public SCLiveSuperFansQixiWidgetInfo() {
            clear();
        }

        public final SCLiveSuperFansQixiWidgetInfo clear() {
            this.widgetStatus = 0;
            this.title = "";
            this.subTitle = "";
            this.bottomDesc = "";
            this.bottomJumpUrl = "";
            this.expireTime = 0L;
            clearContent();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.widgetStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.subTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.subTitle);
            }
            if (!this.bottomDesc.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bottomDesc);
            }
            if (!this.bottomJumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bottomJumpUrl);
            }
            long j = this.expireTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            if (this.contentCase_ == 7) {
                codedOutputByteBufferNano.writeMessage(7, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 8) {
                codedOutputByteBufferNano.writeMessage(8, (MessageNano) this.content_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.widgetStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.subTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.subTitle);
            }
            if (!this.bottomDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bottomDesc);
            }
            if (!this.bottomJumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.bottomJumpUrl);
            }
            long j = this.expireTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            if (this.contentCase_ == 7) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, (MessageNano) this.content_);
            }
            return this.contentCase_ == 8 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, (MessageNano) this.content_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveSuperFansQixiWidgetInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.widgetStatus = int32;
                    }
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.subTitle = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.bottomDesc = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.bottomJumpUrl = codedInputByteBufferNano.readString();
                } else if (tag == 48) {
                    this.expireTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 58) {
                    if (this.contentCase_ != 7) {
                        this.content_ = new LiveSuperFansQixiTaskInfo();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 7;
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.contentCase_ != 8) {
                        this.content_ = new LiveSuperFansQixiSuccInfo();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 8;
                }
            }
        }

        public static SCLiveSuperFansQixiWidgetInfo parseFrom(byte[] bArr) {
            return (SCLiveSuperFansQixiWidgetInfo) MessageNano.mergeFrom(new SCLiveSuperFansQixiWidgetInfo(), bArr);
        }

        public static SCLiveSuperFansQixiWidgetInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveSuperFansQixiWidgetInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
