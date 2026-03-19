package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletCloudPlayControl extends MessageNano {
    private static volatile SCLiveBulletCloudPlayControl[] _emptyArray;
    public String roomCode;
    public String routeUrl;

    public static SCLiveBulletCloudPlayControl[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletCloudPlayControl[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletCloudPlayControl() {
        clear();
    }

    public final SCLiveBulletCloudPlayControl clear() {
        this.routeUrl = "";
        this.roomCode = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.routeUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.routeUrl);
        }
        if (!this.roomCode.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomCode);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.routeUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.routeUrl);
        }
        return !this.roomCode.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.roomCode) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletCloudPlayControl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.routeUrl = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.roomCode = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveBulletCloudPlayControl parseFrom(byte[] bArr) {
        return (SCLiveBulletCloudPlayControl) MessageNano.mergeFrom(new SCLiveBulletCloudPlayControl(), bArr);
    }

    public static SCLiveBulletCloudPlayControl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletCloudPlayControl().mergeFrom(codedInputByteBufferNano);
    }
}
