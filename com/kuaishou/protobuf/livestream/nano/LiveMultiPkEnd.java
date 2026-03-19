package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveStreamMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkEnd extends MessageNano {
    private static volatile LiveMultiPkEnd[] _emptyArray;
    public long endUserId;
    public int pkEndType;
    public long[] rematchUserIds;
    public LiveStreamMessages.SCLiveCommonNotice userLeaveToast;

    public static LiveMultiPkEnd[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkEnd[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkEnd() {
        clear();
    }

    public final LiveMultiPkEnd clear() {
        this.endUserId = 0L;
        this.userLeaveToast = null;
        this.pkEndType = 0;
        this.rematchUserIds = WireFormatNano.EMPTY_LONG_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.endUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        LiveStreamMessages.SCLiveCommonNotice sCLiveCommonNotice = this.userLeaveToast;
        if (sCLiveCommonNotice != null) {
            codedOutputByteBufferNano.writeMessage(2, sCLiveCommonNotice);
        }
        int i = this.pkEndType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        long[] jArr = this.rematchUserIds;
        if (jArr != null && jArr.length > 0) {
            int i2 = 0;
            while (true) {
                long[] jArr2 = this.rematchUserIds;
                if (i2 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(4, jArr2[i2]);
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.endUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        LiveStreamMessages.SCLiveCommonNotice sCLiveCommonNotice = this.userLeaveToast;
        if (sCLiveCommonNotice != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, sCLiveCommonNotice);
        }
        int i = this.pkEndType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        long[] jArr = this.rematchUserIds;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int i2 = 0;
        int iComputeUInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.rematchUserIds;
            if (i2 < jArr2.length) {
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i2]);
                i2++;
            } else {
                return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.endUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                if (this.userLeaveToast == null) {
                    this.userLeaveToast = new LiveStreamMessages.SCLiveCommonNotice();
                }
                codedInputByteBufferNano.readMessage(this.userLeaveToast);
            } else if (tag == 24) {
                this.pkEndType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                long[] jArr = this.rematchUserIds;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.rematchUserIds, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.rematchUserIds = jArr2;
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.rematchUserIds;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.rematchUserIds, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.rematchUserIds = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            }
        }
    }

    public static LiveMultiPkEnd parseFrom(byte[] bArr) {
        return (LiveMultiPkEnd) MessageNano.mergeFrom(new LiveMultiPkEnd(), bArr);
    }

    public static LiveMultiPkEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkEnd().mergeFrom(codedInputByteBufferNano);
    }
}
