package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletPlayBottomEntrance extends MessageNano {
    private static volatile SCLiveBulletPlayBottomEntrance[] _emptyArray;
    public String appId;
    public String appSchemaUrl;
    public boolean openPlay;
    public String preloadAppSchemaUrl;
    public long timestamp;

    public static SCLiveBulletPlayBottomEntrance[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletPlayBottomEntrance[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletPlayBottomEntrance() {
        clear();
    }

    public final SCLiveBulletPlayBottomEntrance clear() {
        this.appSchemaUrl = "";
        this.preloadAppSchemaUrl = "";
        this.appId = "";
        this.openPlay = false;
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.appSchemaUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.appSchemaUrl);
        }
        if (!this.preloadAppSchemaUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.preloadAppSchemaUrl);
        }
        if (!this.appId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.appId);
        }
        boolean z = this.openPlay;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(5, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.appSchemaUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.appSchemaUrl);
        }
        if (!this.preloadAppSchemaUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.preloadAppSchemaUrl);
        }
        if (!this.appId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.appId);
        }
        boolean z = this.openPlay;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(5, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletPlayBottomEntrance mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.appSchemaUrl = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.preloadAppSchemaUrl = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.appId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.openPlay = codedInputByteBufferNano.readBool();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static SCLiveBulletPlayBottomEntrance parseFrom(byte[] bArr) {
        return (SCLiveBulletPlayBottomEntrance) MessageNano.mergeFrom(new SCLiveBulletPlayBottomEntrance(), bArr);
    }

    public static SCLiveBulletPlayBottomEntrance parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletPlayBottomEntrance().mergeFrom(codedInputByteBufferNano);
    }
}
