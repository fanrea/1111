package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.cny2023.message.nano.CnyCdnDegradeProto;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class DegradableLiveLikeImg extends MessageNano {
    private static volatile DegradableLiveLikeImg[] _emptyArray;
    public CnyCdnDegradeProto.DegradablePicUrl[] img;

    public static DegradableLiveLikeImg[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DegradableLiveLikeImg[0];
                }
            }
        }
        return _emptyArray;
    }

    public DegradableLiveLikeImg() {
        clear();
    }

    public final DegradableLiveLikeImg clear() {
        this.img = CnyCdnDegradeProto.DegradablePicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        CnyCdnDegradeProto.DegradablePicUrl[] degradablePicUrlArr = this.img;
        if (degradablePicUrlArr != null && degradablePicUrlArr.length > 0) {
            int i = 0;
            while (true) {
                CnyCdnDegradeProto.DegradablePicUrl[] degradablePicUrlArr2 = this.img;
                if (i >= degradablePicUrlArr2.length) {
                    break;
                }
                CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = degradablePicUrlArr2[i];
                if (degradablePicUrl != null) {
                    codedOutputByteBufferNano.writeMessage(1, degradablePicUrl);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        CnyCdnDegradeProto.DegradablePicUrl[] degradablePicUrlArr = this.img;
        if (degradablePicUrlArr != null && degradablePicUrlArr.length > 0) {
            int i = 0;
            while (true) {
                CnyCdnDegradeProto.DegradablePicUrl[] degradablePicUrlArr2 = this.img;
                if (i >= degradablePicUrlArr2.length) {
                    break;
                }
                CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = degradablePicUrlArr2[i];
                if (degradablePicUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, degradablePicUrl);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final DegradableLiveLikeImg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                CnyCdnDegradeProto.DegradablePicUrl[] degradablePicUrlArr = this.img;
                int length = degradablePicUrlArr == null ? 0 : degradablePicUrlArr.length;
                CnyCdnDegradeProto.DegradablePicUrl[] degradablePicUrlArr2 = new CnyCdnDegradeProto.DegradablePicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.img, 0, degradablePicUrlArr2, 0, length);
                }
                while (length < degradablePicUrlArr2.length - 1) {
                    degradablePicUrlArr2[length] = new CnyCdnDegradeProto.DegradablePicUrl();
                    codedInputByteBufferNano.readMessage(degradablePicUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                degradablePicUrlArr2[length] = new CnyCdnDegradeProto.DegradablePicUrl();
                codedInputByteBufferNano.readMessage(degradablePicUrlArr2[length]);
                this.img = degradablePicUrlArr2;
            }
        }
    }

    public static DegradableLiveLikeImg parseFrom(byte[] bArr) {
        return (DegradableLiveLikeImg) MessageNano.mergeFrom(new DegradableLiveLikeImg(), bArr);
    }

    public static DegradableLiveLikeImg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new DegradableLiveLikeImg().mergeFrom(codedInputByteBufferNano);
    }
}
