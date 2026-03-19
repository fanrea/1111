package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveConditionRedPackOpened extends MessageNano {
    private static volatile SCLiveConditionRedPackOpened[] _emptyArray;
    public String displayMaxWinnerCountMessage;
    public String displayWinnerCount;
    public DisplayWinnerUser[] displayWinnerUser;
    public String liveStreamId;
    public long maxDelayDuration;
    public int redPackBizType;
    public String redPackId;
    public int redPackType;

    public static SCLiveConditionRedPackOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveConditionRedPackOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveConditionRedPackOpened() {
        clear();
    }

    public final SCLiveConditionRedPackOpened clear() {
        this.liveStreamId = "";
        this.redPackType = 0;
        this.redPackId = "";
        this.maxDelayDuration = 0L;
        this.displayWinnerUser = DisplayWinnerUser.emptyArray();
        this.displayWinnerCount = "";
        this.displayMaxWinnerCountMessage = "";
        this.redPackBizType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.redPackId);
        }
        long j = this.maxDelayDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        DisplayWinnerUser[] displayWinnerUserArr = this.displayWinnerUser;
        if (displayWinnerUserArr != null && displayWinnerUserArr.length > 0) {
            int i2 = 0;
            while (true) {
                DisplayWinnerUser[] displayWinnerUserArr2 = this.displayWinnerUser;
                if (i2 >= displayWinnerUserArr2.length) {
                    break;
                }
                DisplayWinnerUser displayWinnerUser = displayWinnerUserArr2[i2];
                if (displayWinnerUser != null) {
                    codedOutputByteBufferNano.writeMessage(5, displayWinnerUser);
                }
                i2++;
            }
        }
        if (!this.displayWinnerCount.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.displayWinnerCount);
        }
        if (!this.displayMaxWinnerCountMessage.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.displayMaxWinnerCountMessage);
        }
        int i3 = this.redPackBizType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.redPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.redPackId);
        }
        long j = this.maxDelayDuration;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        DisplayWinnerUser[] displayWinnerUserArr = this.displayWinnerUser;
        if (displayWinnerUserArr != null && displayWinnerUserArr.length > 0) {
            int i2 = 0;
            while (true) {
                DisplayWinnerUser[] displayWinnerUserArr2 = this.displayWinnerUser;
                if (i2 >= displayWinnerUserArr2.length) {
                    break;
                }
                DisplayWinnerUser displayWinnerUser = displayWinnerUserArr2[i2];
                if (displayWinnerUser != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, displayWinnerUser);
                }
                i2++;
            }
        }
        if (!this.displayWinnerCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.displayWinnerCount);
        }
        if (!this.displayMaxWinnerCountMessage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.displayMaxWinnerCountMessage);
        }
        int i3 = this.redPackBizType;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveConditionRedPackOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 != 0 && int32 != 1 && int32 != 2) {
                    switch (int32) {
                    }
                }
                this.redPackType = int32;
            } else if (tag == 26) {
                this.redPackId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.maxDelayDuration = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                DisplayWinnerUser[] displayWinnerUserArr = this.displayWinnerUser;
                int length = displayWinnerUserArr == null ? 0 : displayWinnerUserArr.length;
                DisplayWinnerUser[] displayWinnerUserArr2 = new DisplayWinnerUser[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.displayWinnerUser, 0, displayWinnerUserArr2, 0, length);
                }
                while (length < displayWinnerUserArr2.length - 1) {
                    displayWinnerUserArr2[length] = new DisplayWinnerUser();
                    codedInputByteBufferNano.readMessage(displayWinnerUserArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                displayWinnerUserArr2[length] = new DisplayWinnerUser();
                codedInputByteBufferNano.readMessage(displayWinnerUserArr2[length]);
                this.displayWinnerUser = displayWinnerUserArr2;
            } else if (tag == 50) {
                this.displayWinnerCount = codedInputByteBufferNano.readString();
            } else if (tag == 58) {
                this.displayMaxWinnerCountMessage = codedInputByteBufferNano.readString();
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.redPackBizType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveConditionRedPackOpened parseFrom(byte[] bArr) {
        return (SCLiveConditionRedPackOpened) MessageNano.mergeFrom(new SCLiveConditionRedPackOpened(), bArr);
    }

    public static SCLiveConditionRedPackOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveConditionRedPackOpened().mergeFrom(codedInputByteBufferNano);
    }
}
