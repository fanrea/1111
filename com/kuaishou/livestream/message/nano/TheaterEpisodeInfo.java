package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TheaterEpisodeInfo extends MessageNano {
    private static volatile TheaterEpisodeInfo[] _emptyArray;
    public TheaterEpisodePhotoCdnProto[] coverThumbnailUrl;
    public String extParams;
    public boolean isSyntheticStream;
    public String liveRelayStream;
    public TheaterEpisodePhotoCdnProto[] mainMvUrl;
    public String manifest;
    public String name;
    public String photoId;
    public int rank;
    public String tubeId;
    public String tubeName;
    public int type;
    public String watermark;

    public static TheaterEpisodeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TheaterEpisodeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public TheaterEpisodeInfo() {
        clear();
    }

    public final TheaterEpisodeInfo clear() {
        this.photoId = "";
        this.mainMvUrl = TheaterEpisodePhotoCdnProto.emptyArray();
        this.extParams = "";
        this.coverThumbnailUrl = TheaterEpisodePhotoCdnProto.emptyArray();
        this.tubeName = "";
        this.rank = 0;
        this.name = "";
        this.manifest = "";
        this.type = 0;
        this.watermark = "";
        this.liveRelayStream = "";
        this.tubeId = "";
        this.isSyntheticStream = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.photoId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.photoId);
        }
        TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr = this.mainMvUrl;
        int i = 0;
        if (theaterEpisodePhotoCdnProtoArr != null && theaterEpisodePhotoCdnProtoArr.length > 0) {
            int i2 = 0;
            while (true) {
                TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr2 = this.mainMvUrl;
                if (i2 >= theaterEpisodePhotoCdnProtoArr2.length) {
                    break;
                }
                TheaterEpisodePhotoCdnProto theaterEpisodePhotoCdnProto = theaterEpisodePhotoCdnProtoArr2[i2];
                if (theaterEpisodePhotoCdnProto != null) {
                    codedOutputByteBufferNano.writeMessage(2, theaterEpisodePhotoCdnProto);
                }
                i2++;
            }
        }
        if (!this.extParams.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.extParams);
        }
        TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr3 = this.coverThumbnailUrl;
        if (theaterEpisodePhotoCdnProtoArr3 != null && theaterEpisodePhotoCdnProtoArr3.length > 0) {
            while (true) {
                TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr4 = this.coverThumbnailUrl;
                if (i >= theaterEpisodePhotoCdnProtoArr4.length) {
                    break;
                }
                TheaterEpisodePhotoCdnProto theaterEpisodePhotoCdnProto2 = theaterEpisodePhotoCdnProtoArr4[i];
                if (theaterEpisodePhotoCdnProto2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, theaterEpisodePhotoCdnProto2);
                }
                i++;
            }
        }
        if (!this.tubeName.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.tubeName);
        }
        int i3 = this.rank;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.name);
        }
        if (!this.manifest.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.manifest);
        }
        int i4 = this.type;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i4);
        }
        if (!this.watermark.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.watermark);
        }
        if (!this.liveRelayStream.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.liveRelayStream);
        }
        if (!this.tubeId.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.tubeId);
        }
        boolean z = this.isSyntheticStream;
        if (z) {
            codedOutputByteBufferNano.writeBool(13, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.photoId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.photoId);
        }
        TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr = this.mainMvUrl;
        int i = 0;
        if (theaterEpisodePhotoCdnProtoArr != null && theaterEpisodePhotoCdnProtoArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr2 = this.mainMvUrl;
                if (i2 >= theaterEpisodePhotoCdnProtoArr2.length) {
                    break;
                }
                TheaterEpisodePhotoCdnProto theaterEpisodePhotoCdnProto = theaterEpisodePhotoCdnProtoArr2[i2];
                if (theaterEpisodePhotoCdnProto != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, theaterEpisodePhotoCdnProto);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.extParams.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.extParams);
        }
        TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr3 = this.coverThumbnailUrl;
        if (theaterEpisodePhotoCdnProtoArr3 != null && theaterEpisodePhotoCdnProtoArr3.length > 0) {
            while (true) {
                TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr4 = this.coverThumbnailUrl;
                if (i >= theaterEpisodePhotoCdnProtoArr4.length) {
                    break;
                }
                TheaterEpisodePhotoCdnProto theaterEpisodePhotoCdnProto2 = theaterEpisodePhotoCdnProtoArr4[i];
                if (theaterEpisodePhotoCdnProto2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, theaterEpisodePhotoCdnProto2);
                }
                i++;
            }
        }
        if (!this.tubeName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.tubeName);
        }
        int i3 = this.rank;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        if (!this.name.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.name);
        }
        if (!this.manifest.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.manifest);
        }
        int i4 = this.type;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i4);
        }
        if (!this.watermark.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.watermark);
        }
        if (!this.liveRelayStream.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.liveRelayStream);
        }
        if (!this.tubeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.tubeId);
        }
        boolean z = this.isSyntheticStream;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(13, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TheaterEpisodeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.photoId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr = this.mainMvUrl;
                    int length = theaterEpisodePhotoCdnProtoArr == null ? 0 : theaterEpisodePhotoCdnProtoArr.length;
                    TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr2 = new TheaterEpisodePhotoCdnProto[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.mainMvUrl, 0, theaterEpisodePhotoCdnProtoArr2, 0, length);
                    }
                    while (length < theaterEpisodePhotoCdnProtoArr2.length - 1) {
                        theaterEpisodePhotoCdnProtoArr2[length] = new TheaterEpisodePhotoCdnProto();
                        codedInputByteBufferNano.readMessage(theaterEpisodePhotoCdnProtoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    theaterEpisodePhotoCdnProtoArr2[length] = new TheaterEpisodePhotoCdnProto();
                    codedInputByteBufferNano.readMessage(theaterEpisodePhotoCdnProtoArr2[length]);
                    this.mainMvUrl = theaterEpisodePhotoCdnProtoArr2;
                    break;
                case 26:
                    this.extParams = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr3 = this.coverThumbnailUrl;
                    int length2 = theaterEpisodePhotoCdnProtoArr3 == null ? 0 : theaterEpisodePhotoCdnProtoArr3.length;
                    TheaterEpisodePhotoCdnProto[] theaterEpisodePhotoCdnProtoArr4 = new TheaterEpisodePhotoCdnProto[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.coverThumbnailUrl, 0, theaterEpisodePhotoCdnProtoArr4, 0, length2);
                    }
                    while (length2 < theaterEpisodePhotoCdnProtoArr4.length - 1) {
                        theaterEpisodePhotoCdnProtoArr4[length2] = new TheaterEpisodePhotoCdnProto();
                        codedInputByteBufferNano.readMessage(theaterEpisodePhotoCdnProtoArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    theaterEpisodePhotoCdnProtoArr4[length2] = new TheaterEpisodePhotoCdnProto();
                    codedInputByteBufferNano.readMessage(theaterEpisodePhotoCdnProtoArr4[length2]);
                    this.coverThumbnailUrl = theaterEpisodePhotoCdnProtoArr4;
                    break;
                case 42:
                    this.tubeName = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.name = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.manifest = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                        break;
                    } else {
                        this.type = int32;
                        break;
                    }
                    break;
                case 82:
                    this.watermark = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.liveRelayStream = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.tubeId = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.isSyntheticStream = codedInputByteBufferNano.readBool();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static TheaterEpisodeInfo parseFrom(byte[] bArr) {
        return (TheaterEpisodeInfo) MessageNano.mergeFrom(new TheaterEpisodeInfo(), bArr);
    }

    public static TheaterEpisodeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TheaterEpisodeInfo().mergeFrom(codedInputByteBufferNano);
    }
}
