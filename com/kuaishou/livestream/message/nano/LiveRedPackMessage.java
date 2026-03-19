package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCustomRedPackSkinMessage;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRedPackMessage {

    public static final class AudienceRedPackGift extends MessageNano {
        private static volatile AudienceRedPackGift[] _emptyArray;
        public int count;
        public int giftId;

        public static AudienceRedPackGift[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AudienceRedPackGift[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AudienceRedPackGift() {
            clear();
        }

        public final AudienceRedPackGift clear() {
            this.giftId = 0;
            this.count = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.count;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.count;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AudienceRedPackGift mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.count = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static AudienceRedPackGift parseFrom(byte[] bArr) {
            return (AudienceRedPackGift) MessageNano.mergeFrom(new AudienceRedPackGift(), bArr);
        }

        public static AudienceRedPackGift parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AudienceRedPackGift().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AudienceRedPack extends MessageNano {
        private static volatile AudienceRedPack[] _emptyArray;
        public LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme customRedPackSkinTheme;
        public AudienceRedPackGift[] gift;
        public String globalRedPackIdentity;
        public long grabTime;
        public String redPackId;
        public UserInfos.UserInfo sendUser;
        public long showDeadline;
        public long showTime;
        public long totalKsCoin;
        public int type;

        public static AudienceRedPack[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AudienceRedPack[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AudienceRedPack() {
            clear();
        }

        public final AudienceRedPack clear() {
            this.redPackId = "";
            this.sendUser = null;
            this.grabTime = 0L;
            this.type = 0;
            this.gift = AudienceRedPackGift.emptyArray();
            this.showTime = 0L;
            this.totalKsCoin = 0L;
            this.showDeadline = 0L;
            this.globalRedPackIdentity = "";
            this.customRedPackSkinTheme = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.redPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.redPackId);
            }
            UserInfos.UserInfo userInfo = this.sendUser;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, userInfo);
            }
            long j = this.grabTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            AudienceRedPackGift[] audienceRedPackGiftArr = this.gift;
            if (audienceRedPackGiftArr != null && audienceRedPackGiftArr.length > 0) {
                int i2 = 0;
                while (true) {
                    AudienceRedPackGift[] audienceRedPackGiftArr2 = this.gift;
                    if (i2 >= audienceRedPackGiftArr2.length) {
                        break;
                    }
                    AudienceRedPackGift audienceRedPackGift = audienceRedPackGiftArr2[i2];
                    if (audienceRedPackGift != null) {
                        codedOutputByteBufferNano.writeMessage(5, audienceRedPackGift);
                    }
                    i2++;
                }
            }
            long j2 = this.showTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            long j3 = this.totalKsCoin;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            long j4 = this.showDeadline;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j4);
            }
            if (!this.globalRedPackIdentity.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.globalRedPackIdentity);
            }
            LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme customRedPackSkinTheme = this.customRedPackSkinTheme;
            if (customRedPackSkinTheme != null) {
                codedOutputByteBufferNano.writeMessage(10, customRedPackSkinTheme);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.redPackId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.redPackId);
            }
            UserInfos.UserInfo userInfo = this.sendUser;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
            }
            long j = this.grabTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
            }
            AudienceRedPackGift[] audienceRedPackGiftArr = this.gift;
            if (audienceRedPackGiftArr != null && audienceRedPackGiftArr.length > 0) {
                int i2 = 0;
                while (true) {
                    AudienceRedPackGift[] audienceRedPackGiftArr2 = this.gift;
                    if (i2 >= audienceRedPackGiftArr2.length) {
                        break;
                    }
                    AudienceRedPackGift audienceRedPackGift = audienceRedPackGiftArr2[i2];
                    if (audienceRedPackGift != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, audienceRedPackGift);
                    }
                    i2++;
                }
            }
            long j2 = this.showTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            long j3 = this.totalKsCoin;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            long j4 = this.showDeadline;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
            }
            if (!this.globalRedPackIdentity.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.globalRedPackIdentity);
            }
            LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme customRedPackSkinTheme = this.customRedPackSkinTheme;
            return customRedPackSkinTheme != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, customRedPackSkinTheme) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AudienceRedPack mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.redPackId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        if (this.sendUser == null) {
                            this.sendUser = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.sendUser);
                        break;
                    case 24:
                        this.grabTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 32:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            switch (int32) {
                            }
                        }
                        this.type = int32;
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        AudienceRedPackGift[] audienceRedPackGiftArr = this.gift;
                        int length = audienceRedPackGiftArr == null ? 0 : audienceRedPackGiftArr.length;
                        AudienceRedPackGift[] audienceRedPackGiftArr2 = new AudienceRedPackGift[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.gift, 0, audienceRedPackGiftArr2, 0, length);
                        }
                        while (length < audienceRedPackGiftArr2.length - 1) {
                            audienceRedPackGiftArr2[length] = new AudienceRedPackGift();
                            codedInputByteBufferNano.readMessage(audienceRedPackGiftArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        audienceRedPackGiftArr2[length] = new AudienceRedPackGift();
                        codedInputByteBufferNano.readMessage(audienceRedPackGiftArr2[length]);
                        this.gift = audienceRedPackGiftArr2;
                        break;
                    case 48:
                        this.showTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.totalKsCoin = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.showDeadline = codedInputByteBufferNano.readUInt64();
                        break;
                    case 74:
                        this.globalRedPackIdentity = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        if (this.customRedPackSkinTheme == null) {
                            this.customRedPackSkinTheme = new LiveCustomRedPackSkinMessage.CustomRedPackSkinTheme();
                        }
                        codedInputByteBufferNano.readMessage(this.customRedPackSkinTheme);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static AudienceRedPack parseFrom(byte[] bArr) {
            return (AudienceRedPack) MessageNano.mergeFrom(new AudienceRedPack(), bArr);
        }

        public static AudienceRedPack parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AudienceRedPack().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCAudienceRedPackShow extends MessageNano {
        private static volatile SCAudienceRedPackShow[] _emptyArray;
        public boolean enableQueryFollowStatus;
        public AudienceRedPack[] redPack;
        public int totalRedPackCount;
        public String totalRedPackDisplayCount;
        public long totalRedPackMaxDisplayCount;

        public static SCAudienceRedPackShow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCAudienceRedPackShow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCAudienceRedPackShow() {
            clear();
        }

        public final SCAudienceRedPackShow clear() {
            this.redPack = AudienceRedPack.emptyArray();
            this.totalRedPackCount = 0;
            this.totalRedPackDisplayCount = "";
            this.totalRedPackMaxDisplayCount = 0L;
            this.enableQueryFollowStatus = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            AudienceRedPack[] audienceRedPackArr = this.redPack;
            if (audienceRedPackArr != null && audienceRedPackArr.length > 0) {
                int i = 0;
                while (true) {
                    AudienceRedPack[] audienceRedPackArr2 = this.redPack;
                    if (i >= audienceRedPackArr2.length) {
                        break;
                    }
                    AudienceRedPack audienceRedPack = audienceRedPackArr2[i];
                    if (audienceRedPack != null) {
                        codedOutputByteBufferNano.writeMessage(1, audienceRedPack);
                    }
                    i++;
                }
            }
            int i2 = this.totalRedPackCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            if (!this.totalRedPackDisplayCount.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.totalRedPackDisplayCount);
            }
            long j = this.totalRedPackMaxDisplayCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            boolean z = this.enableQueryFollowStatus;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            AudienceRedPack[] audienceRedPackArr = this.redPack;
            if (audienceRedPackArr != null && audienceRedPackArr.length > 0) {
                int i = 0;
                while (true) {
                    AudienceRedPack[] audienceRedPackArr2 = this.redPack;
                    if (i >= audienceRedPackArr2.length) {
                        break;
                    }
                    AudienceRedPack audienceRedPack = audienceRedPackArr2[i];
                    if (audienceRedPack != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, audienceRedPack);
                    }
                    i++;
                }
            }
            int i2 = this.totalRedPackCount;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            if (!this.totalRedPackDisplayCount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.totalRedPackDisplayCount);
            }
            long j = this.totalRedPackMaxDisplayCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            boolean z = this.enableQueryFollowStatus;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCAudienceRedPackShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    AudienceRedPack[] audienceRedPackArr = this.redPack;
                    int length = audienceRedPackArr == null ? 0 : audienceRedPackArr.length;
                    AudienceRedPack[] audienceRedPackArr2 = new AudienceRedPack[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.redPack, 0, audienceRedPackArr2, 0, length);
                    }
                    while (length < audienceRedPackArr2.length - 1) {
                        audienceRedPackArr2[length] = new AudienceRedPack();
                        codedInputByteBufferNano.readMessage(audienceRedPackArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    audienceRedPackArr2[length] = new AudienceRedPack();
                    codedInputByteBufferNano.readMessage(audienceRedPackArr2[length]);
                    this.redPack = audienceRedPackArr2;
                } else if (tag == 16) {
                    this.totalRedPackCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.totalRedPackDisplayCount = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.totalRedPackMaxDisplayCount = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enableQueryFollowStatus = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static SCAudienceRedPackShow parseFrom(byte[] bArr) {
            return (SCAudienceRedPackShow) MessageNano.mergeFrom(new SCAudienceRedPackShow(), bArr);
        }

        public static SCAudienceRedPackShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCAudienceRedPackShow().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AudienceRedPackToken extends MessageNano {
        private static volatile AudienceRedPackToken[] _emptyArray;
        public long deadline;
        public String redPackId;

        public static AudienceRedPackToken[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AudienceRedPackToken[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AudienceRedPackToken() {
            clear();
        }

        public final AudienceRedPackToken clear() {
            this.redPackId = "";
            this.deadline = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.redPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.redPackId);
            }
            long j = this.deadline;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.redPackId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.redPackId);
            }
            long j = this.deadline;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AudienceRedPackToken mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.redPackId = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.deadline = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static AudienceRedPackToken parseFrom(byte[] bArr) {
            return (AudienceRedPackToken) MessageNano.mergeFrom(new AudienceRedPackToken(), bArr);
        }

        public static AudienceRedPackToken parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AudienceRedPackToken().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCAudienceRedPackToken extends MessageNano {
        private static volatile SCAudienceRedPackToken[] _emptyArray;
        public AudienceRedPackToken[] token;

        public static SCAudienceRedPackToken[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCAudienceRedPackToken[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCAudienceRedPackToken() {
            clear();
        }

        public final SCAudienceRedPackToken clear() {
            this.token = AudienceRedPackToken.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            AudienceRedPackToken[] audienceRedPackTokenArr = this.token;
            if (audienceRedPackTokenArr != null && audienceRedPackTokenArr.length > 0) {
                int i = 0;
                while (true) {
                    AudienceRedPackToken[] audienceRedPackTokenArr2 = this.token;
                    if (i >= audienceRedPackTokenArr2.length) {
                        break;
                    }
                    AudienceRedPackToken audienceRedPackToken = audienceRedPackTokenArr2[i];
                    if (audienceRedPackToken != null) {
                        codedOutputByteBufferNano.writeMessage(1, audienceRedPackToken);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            AudienceRedPackToken[] audienceRedPackTokenArr = this.token;
            if (audienceRedPackTokenArr != null && audienceRedPackTokenArr.length > 0) {
                int i = 0;
                while (true) {
                    AudienceRedPackToken[] audienceRedPackTokenArr2 = this.token;
                    if (i >= audienceRedPackTokenArr2.length) {
                        break;
                    }
                    AudienceRedPackToken audienceRedPackToken = audienceRedPackTokenArr2[i];
                    if (audienceRedPackToken != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, audienceRedPackToken);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCAudienceRedPackToken mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    AudienceRedPackToken[] audienceRedPackTokenArr = this.token;
                    int length = audienceRedPackTokenArr == null ? 0 : audienceRedPackTokenArr.length;
                    AudienceRedPackToken[] audienceRedPackTokenArr2 = new AudienceRedPackToken[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.token, 0, audienceRedPackTokenArr2, 0, length);
                    }
                    while (length < audienceRedPackTokenArr2.length - 1) {
                        audienceRedPackTokenArr2[length] = new AudienceRedPackToken();
                        codedInputByteBufferNano.readMessage(audienceRedPackTokenArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    audienceRedPackTokenArr2[length] = new AudienceRedPackToken();
                    codedInputByteBufferNano.readMessage(audienceRedPackTokenArr2[length]);
                    this.token = audienceRedPackTokenArr2;
                }
            }
        }

        public static SCAudienceRedPackToken parseFrom(byte[] bArr) {
            return (SCAudienceRedPackToken) MessageNano.mergeFrom(new SCAudienceRedPackToken(), bArr);
        }

        public static SCAudienceRedPackToken parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCAudienceRedPackToken().mergeFrom(codedInputByteBufferNano);
        }
    }
}
