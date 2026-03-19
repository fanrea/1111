package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Participant extends MessageNano {
    private static volatile Participant[] _emptyArray;
    public AryaCapabilities aryaCapabilities;
    public int aspectRatio;
    public boolean audioOnly;
    public boolean edgeAudioRoom;
    public String edgeIpPort;
    public long edgeRoomId;
    public boolean enableVideoRx;
    public boolean enableVideoTx;
    public boolean hidden;
    public boolean isOwner;
    public String mediaConfig;
    public String mediaConfig4G;
    public MediaContext mediaContext;
    public MultiHoming multiHoming;
    public String pid;
    public String platformSource;
    public boolean reconnFlag;
    public int[] sid;
    public String smuxFor;
    public long timestamp;
    public long version;
    public boolean withoutSignaling;

    public static Participant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Participant[0];
                }
            }
        }
        return _emptyArray;
    }

    public Participant() {
        clear();
    }

    public final Participant clear() {
        this.pid = "";
        this.sid = WireFormatNano.EMPTY_INT_ARRAY;
        this.isOwner = false;
        this.audioOnly = false;
        this.aspectRatio = 0;
        this.enableVideoTx = false;
        this.enableVideoRx = false;
        this.multiHoming = null;
        this.mediaContext = null;
        this.mediaConfig = "";
        this.hidden = false;
        this.mediaConfig4G = "";
        this.platformSource = "";
        this.edgeIpPort = "";
        this.edgeRoomId = 0L;
        this.edgeAudioRoom = false;
        this.aryaCapabilities = null;
        this.version = 0L;
        this.reconnFlag = false;
        this.withoutSignaling = false;
        this.timestamp = 0L;
        this.smuxFor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pid.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pid);
        }
        int[] iArr = this.sid;
        if (iArr != null && iArr.length > 0) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.sid;
                if (i >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(2, iArr2[i]);
                i++;
            }
        }
        boolean z = this.isOwner;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        boolean z2 = this.audioOnly;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        int i2 = this.aspectRatio;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i2);
        }
        boolean z3 = this.enableVideoTx;
        if (z3) {
            codedOutputByteBufferNano.writeBool(6, z3);
        }
        boolean z4 = this.enableVideoRx;
        if (z4) {
            codedOutputByteBufferNano.writeBool(7, z4);
        }
        MultiHoming multiHoming = this.multiHoming;
        if (multiHoming != null) {
            codedOutputByteBufferNano.writeMessage(8, multiHoming);
        }
        MediaContext mediaContext = this.mediaContext;
        if (mediaContext != null) {
            codedOutputByteBufferNano.writeMessage(9, mediaContext);
        }
        if (!this.mediaConfig.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.mediaConfig);
        }
        boolean z5 = this.hidden;
        if (z5) {
            codedOutputByteBufferNano.writeBool(11, z5);
        }
        if (!this.mediaConfig4G.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.mediaConfig4G);
        }
        if (!this.platformSource.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.platformSource);
        }
        if (!this.edgeIpPort.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.edgeIpPort);
        }
        long j = this.edgeRoomId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j);
        }
        boolean z6 = this.edgeAudioRoom;
        if (z6) {
            codedOutputByteBufferNano.writeBool(16, z6);
        }
        AryaCapabilities aryaCapabilities = this.aryaCapabilities;
        if (aryaCapabilities != null) {
            codedOutputByteBufferNano.writeMessage(17, aryaCapabilities);
        }
        long j2 = this.version;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(18, j2);
        }
        boolean z7 = this.reconnFlag;
        if (z7) {
            codedOutputByteBufferNano.writeBool(19, z7);
        }
        boolean z8 = this.withoutSignaling;
        if (z8) {
            codedOutputByteBufferNano.writeBool(20, z8);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(21, j3);
        }
        if (!this.smuxFor.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.smuxFor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int[] iArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pid.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pid);
        }
        int[] iArr2 = this.sid;
        if (iArr2 != null && iArr2.length > 0) {
            int i = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                iArr = this.sid;
                if (i >= iArr.length) {
                    break;
                }
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr.length * 1);
        }
        boolean z = this.isOwner;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        boolean z2 = this.audioOnly;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        int i2 = this.aspectRatio;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
        }
        boolean z3 = this.enableVideoTx;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z3);
        }
        boolean z4 = this.enableVideoRx;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z4);
        }
        MultiHoming multiHoming = this.multiHoming;
        if (multiHoming != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, multiHoming);
        }
        MediaContext mediaContext = this.mediaContext;
        if (mediaContext != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, mediaContext);
        }
        if (!this.mediaConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.mediaConfig);
        }
        boolean z5 = this.hidden;
        if (z5) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z5);
        }
        if (!this.mediaConfig4G.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.mediaConfig4G);
        }
        if (!this.platformSource.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.platformSource);
        }
        if (!this.edgeIpPort.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.edgeIpPort);
        }
        long j = this.edgeRoomId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j);
        }
        boolean z6 = this.edgeAudioRoom;
        if (z6) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, z6);
        }
        AryaCapabilities aryaCapabilities = this.aryaCapabilities;
        if (aryaCapabilities != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, aryaCapabilities);
        }
        long j2 = this.version;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(18, j2);
        }
        boolean z7 = this.reconnFlag;
        if (z7) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(19, z7);
        }
        boolean z8 = this.withoutSignaling;
        if (z8) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z8);
        }
        long j3 = this.timestamp;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(21, j3);
        }
        return !this.smuxFor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(22, this.smuxFor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Participant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.pid = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                    int[] iArr = this.sid;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.sid, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.sid = iArr2;
                    break;
                case 18:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.sid;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.sid, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.sid = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                case 24:
                    this.isOwner = codedInputByteBufferNano.readBool();
                    break;
                case 32:
                    this.audioOnly = codedInputByteBufferNano.readBool();
                    break;
                case 40:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.aspectRatio = int32;
                        break;
                    }
                    break;
                case 48:
                    this.enableVideoTx = codedInputByteBufferNano.readBool();
                    break;
                case 56:
                    this.enableVideoRx = codedInputByteBufferNano.readBool();
                    break;
                case 66:
                    if (this.multiHoming == null) {
                        this.multiHoming = new MultiHoming();
                    }
                    codedInputByteBufferNano.readMessage(this.multiHoming);
                    break;
                case 74:
                    if (this.mediaContext == null) {
                        this.mediaContext = new MediaContext();
                    }
                    codedInputByteBufferNano.readMessage(this.mediaContext);
                    break;
                case 82:
                    this.mediaConfig = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.hidden = codedInputByteBufferNano.readBool();
                    break;
                case 98:
                    this.mediaConfig4G = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.platformSource = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.edgeIpPort = codedInputByteBufferNano.readString();
                    break;
                case 120:
                    this.edgeRoomId = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.edgeAudioRoom = codedInputByteBufferNano.readBool();
                    break;
                case 138:
                    if (this.aryaCapabilities == null) {
                        this.aryaCapabilities = new AryaCapabilities();
                    }
                    codedInputByteBufferNano.readMessage(this.aryaCapabilities);
                    break;
                case 144:
                    this.version = codedInputByteBufferNano.readUInt64();
                    break;
                case 152:
                    this.reconnFlag = codedInputByteBufferNano.readBool();
                    break;
                case 160:
                    this.withoutSignaling = codedInputByteBufferNano.readBool();
                    break;
                case 168:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 178:
                    this.smuxFor = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static Participant parseFrom(byte[] bArr) {
        return (Participant) MessageNano.mergeFrom(new Participant(), bArr);
    }

    public static Participant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Participant().mergeFrom(codedInputByteBufferNano);
    }
}
