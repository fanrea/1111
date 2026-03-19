package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024BulletPlayEntranceInfo extends MessageNano {
    private static volatile SCLiveCny2024BulletPlayEntranceInfo[] _emptyArray;
    public long endShowTime;
    public boolean isShow;
    public LiveBulletPlayPendantInfo sidebarPendant;
    public LiveBulletPlayPendantInfo tempPendant;

    public static SCLiveCny2024BulletPlayEntranceInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024BulletPlayEntranceInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024BulletPlayEntranceInfo() {
        clear();
    }

    public final SCLiveCny2024BulletPlayEntranceInfo clear() {
        this.isShow = false;
        this.endShowTime = 0L;
        this.tempPendant = null;
        this.sidebarPendant = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isShow;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.endShowTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        LiveBulletPlayPendantInfo liveBulletPlayPendantInfo = this.tempPendant;
        if (liveBulletPlayPendantInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, liveBulletPlayPendantInfo);
        }
        LiveBulletPlayPendantInfo liveBulletPlayPendantInfo2 = this.sidebarPendant;
        if (liveBulletPlayPendantInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(4, liveBulletPlayPendantInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isShow;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.endShowTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        LiveBulletPlayPendantInfo liveBulletPlayPendantInfo = this.tempPendant;
        if (liveBulletPlayPendantInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveBulletPlayPendantInfo);
        }
        LiveBulletPlayPendantInfo liveBulletPlayPendantInfo2 = this.sidebarPendant;
        return liveBulletPlayPendantInfo2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, liveBulletPlayPendantInfo2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024BulletPlayEntranceInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isShow = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.endShowTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                if (this.tempPendant == null) {
                    this.tempPendant = new LiveBulletPlayPendantInfo();
                }
                codedInputByteBufferNano.readMessage(this.tempPendant);
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.sidebarPendant == null) {
                    this.sidebarPendant = new LiveBulletPlayPendantInfo();
                }
                codedInputByteBufferNano.readMessage(this.sidebarPendant);
            }
        }
    }

    public static SCLiveCny2024BulletPlayEntranceInfo parseFrom(byte[] bArr) {
        return (SCLiveCny2024BulletPlayEntranceInfo) MessageNano.mergeFrom(new SCLiveCny2024BulletPlayEntranceInfo(), bArr);
    }

    public static SCLiveCny2024BulletPlayEntranceInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024BulletPlayEntranceInfo().mergeFrom(codedInputByteBufferNano);
    }
}
