package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePopularityTicketEncourageBattleInfo extends MessageNano {
    private static volatile SCLivePopularityTicketEncourageBattleInfo[] _emptyArray;
    public long authorId;
    public long autoCloseDelayMs;
    public long autoFoldDelayMs;
    public String buttonJumpUrl;
    public String buttonText;
    public String description;
    public String extraInfo;
    public String foldTitle;
    public int giftId;
    public String giftToken;
    public RichText[] hint;
    public String liveStreamId;
    public String unfoldTitle;
    public long userId;

    public static SCLivePopularityTicketEncourageBattleInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePopularityTicketEncourageBattleInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePopularityTicketEncourageBattleInfo() {
        clear();
    }

    public final SCLivePopularityTicketEncourageBattleInfo clear() {
        this.userId = 0L;
        this.authorId = 0L;
        this.liveStreamId = "";
        this.giftId = 0;
        this.giftToken = "";
        this.foldTitle = "";
        this.unfoldTitle = "";
        this.description = "";
        this.hint = RichText.emptyArray();
        this.buttonText = "";
        this.buttonJumpUrl = "";
        this.autoFoldDelayMs = 0L;
        this.autoCloseDelayMs = 0L;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveStreamId);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.giftToken);
        }
        if (!this.foldTitle.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.foldTitle);
        }
        if (!this.unfoldTitle.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.unfoldTitle);
        }
        if (!this.description.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.description);
        }
        RichText[] richTextArr = this.hint;
        if (richTextArr != null && richTextArr.length > 0) {
            int i2 = 0;
            while (true) {
                RichText[] richTextArr2 = this.hint;
                if (i2 >= richTextArr2.length) {
                    break;
                }
                RichText richText = richTextArr2[i2];
                if (richText != null) {
                    codedOutputByteBufferNano.writeMessage(9, richText);
                }
                i2++;
            }
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.buttonText);
        }
        if (!this.buttonJumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.buttonJumpUrl);
        }
        long j3 = this.autoFoldDelayMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j3);
        }
        long j4 = this.autoCloseDelayMs;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j4);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.extraInfo);
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
        long j2 = this.authorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
        }
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
        }
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.giftToken);
        }
        if (!this.foldTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.foldTitle);
        }
        if (!this.unfoldTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.unfoldTitle);
        }
        if (!this.description.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.description);
        }
        RichText[] richTextArr = this.hint;
        if (richTextArr != null && richTextArr.length > 0) {
            int i2 = 0;
            while (true) {
                RichText[] richTextArr2 = this.hint;
                if (i2 >= richTextArr2.length) {
                    break;
                }
                RichText richText = richTextArr2[i2];
                if (richText != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, richText);
                }
                i2++;
            }
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.buttonText);
        }
        if (!this.buttonJumpUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.buttonJumpUrl);
        }
        long j3 = this.autoFoldDelayMs;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(12, j3);
        }
        long j4 = this.autoCloseDelayMs;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j4);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePopularityTicketEncourageBattleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.userId = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.authorId = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.giftToken = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.foldTitle = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.unfoldTitle = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.description = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    RichText[] richTextArr = this.hint;
                    int length = richTextArr == null ? 0 : richTextArr.length;
                    RichText[] richTextArr2 = new RichText[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.hint, 0, richTextArr2, 0, length);
                    }
                    while (length < richTextArr2.length - 1) {
                        richTextArr2[length] = new RichText();
                        codedInputByteBufferNano.readMessage(richTextArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    richTextArr2[length] = new RichText();
                    codedInputByteBufferNano.readMessage(richTextArr2[length]);
                    this.hint = richTextArr2;
                    break;
                case 82:
                    this.buttonText = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.buttonJumpUrl = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.autoFoldDelayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 104:
                    this.autoCloseDelayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 114:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLivePopularityTicketEncourageBattleInfo parseFrom(byte[] bArr) {
        return (SCLivePopularityTicketEncourageBattleInfo) MessageNano.mergeFrom(new SCLivePopularityTicketEncourageBattleInfo(), bArr);
    }

    public static SCLivePopularityTicketEncourageBattleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePopularityTicketEncourageBattleInfo().mergeFrom(codedInputByteBufferNano);
    }
}
