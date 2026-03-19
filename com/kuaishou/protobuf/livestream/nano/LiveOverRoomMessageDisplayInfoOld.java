package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveOverRoomMessageDisplayInfoOld extends MessageNano {
    private static volatile LiveOverRoomMessageDisplayInfoOld[] _emptyArray;
    public int batchSize;
    public String broadcastInfo;
    public boolean containsRedPack;
    public boolean displayBanner;
    public boolean displayGif;
    public String exptag;
    public String fromLiveStreamId;
    public UserInfos.UserInfo fromUser;
    public int gifFramePerSencond;
    public String[] gifUrlNew;
    public int giftId;
    public String serverExpTag;
    public long slotDisplayDuration;
    public String titleV2;
    public UserInfos.UserInfo toUser;
    public String token;
    public boolean useStyleV2;

    public static LiveOverRoomMessageDisplayInfoOld[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveOverRoomMessageDisplayInfoOld[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveOverRoomMessageDisplayInfoOld() {
        clear();
    }

    public final LiveOverRoomMessageDisplayInfoOld clear() {
        this.fromUser = null;
        this.toUser = null;
        this.giftId = 0;
        this.batchSize = 0;
        this.fromLiveStreamId = "";
        this.slotDisplayDuration = 0L;
        this.exptag = "";
        this.broadcastInfo = "";
        this.displayBanner = false;
        this.displayGif = false;
        this.gifUrlNew = WireFormatNano.EMPTY_STRING_ARRAY;
        this.useStyleV2 = false;
        this.titleV2 = "";
        this.token = "";
        this.containsRedPack = false;
        this.gifFramePerSencond = 0;
        this.serverExpTag = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.fromUser;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.toUser;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo2);
        }
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        int i2 = this.batchSize;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        if (!this.fromLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.fromLiveStreamId);
        }
        long j = this.slotDisplayDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        if (!this.exptag.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.exptag);
        }
        if (!this.broadcastInfo.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.broadcastInfo);
        }
        boolean z = this.displayBanner;
        if (z) {
            codedOutputByteBufferNano.writeBool(9, z);
        }
        boolean z2 = this.displayGif;
        if (z2) {
            codedOutputByteBufferNano.writeBool(10, z2);
        }
        String[] strArr = this.gifUrlNew;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.gifUrlNew;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i3++;
            }
        }
        boolean z3 = this.useStyleV2;
        if (z3) {
            codedOutputByteBufferNano.writeBool(12, z3);
        }
        if (!this.titleV2.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.titleV2);
        }
        if (!this.token.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.token);
        }
        boolean z4 = this.containsRedPack;
        if (z4) {
            codedOutputByteBufferNano.writeBool(15, z4);
        }
        int i4 = this.gifFramePerSencond;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i4);
        }
        if (!this.serverExpTag.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.serverExpTag);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.fromUser;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.toUser;
        if (userInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo2);
        }
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        int i2 = this.batchSize;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        if (!this.fromLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.fromLiveStreamId);
        }
        long j = this.slotDisplayDuration;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        if (!this.exptag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.exptag);
        }
        if (!this.broadcastInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.broadcastInfo);
        }
        boolean z = this.displayBanner;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
        }
        boolean z2 = this.displayGif;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z2);
        }
        String[] strArr = this.gifUrlNew;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.gifUrlNew;
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
        boolean z3 = this.useStyleV2;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z3);
        }
        if (!this.titleV2.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.titleV2);
        }
        if (!this.token.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.token);
        }
        boolean z4 = this.containsRedPack;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(15, z4);
        }
        int i5 = this.gifFramePerSencond;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i5);
        }
        return !this.serverExpTag.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.serverExpTag) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveOverRoomMessageDisplayInfoOld mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.fromUser == null) {
                        this.fromUser = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.fromUser);
                    break;
                case 18:
                    if (this.toUser == null) {
                        this.toUser = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.toUser);
                    break;
                case 24:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.batchSize = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.fromLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.slotDisplayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    this.exptag = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.broadcastInfo = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.displayBanner = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.displayGif = codedInputByteBufferNano.readBool();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    String[] strArr = this.gifUrlNew;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.gifUrlNew, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.gifUrlNew = strArr2;
                    break;
                case 96:
                    this.useStyleV2 = codedInputByteBufferNano.readBool();
                    break;
                case 106:
                    this.titleV2 = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.token = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.containsRedPack = codedInputByteBufferNano.readBool();
                    break;
                case 128:
                    this.gifFramePerSencond = codedInputByteBufferNano.readUInt32();
                    break;
                case 138:
                    this.serverExpTag = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveOverRoomMessageDisplayInfoOld parseFrom(byte[] bArr) {
        return (LiveOverRoomMessageDisplayInfoOld) MessageNano.mergeFrom(new LiveOverRoomMessageDisplayInfoOld(), bArr);
    }

    public static LiveOverRoomMessageDisplayInfoOld parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveOverRoomMessageDisplayInfoOld().mergeFrom(codedInputByteBufferNano);
    }
}
