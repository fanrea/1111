package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GridChatSoloPKStatisticInfo extends MessageNano {
    private static volatile GridChatSoloPKStatisticInfo[] _emptyArray;
    public GridChatSoloPkBangsInfo bangsInfo;
    public LiveCdnNodeView[] drawAnimationUrls;
    public long penaltyDeadline;
    public LiveCdnNodeView[] pkStartAnimationUrls;
    public int soloPkStatus;
    public long startTime;
    public long timestamp;
    public GridChatSoloPkUserStatisticInfo[] userStatisticInfo;
    public long voteDeadline;
    public long voteDeadlineWithBuffer;
    public boolean voteEnd;
    public LiveCdnNodeView[] voteEndAnimationUrls;

    public static GridChatSoloPKStatisticInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GridChatSoloPKStatisticInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public GridChatSoloPKStatisticInfo() {
        clear();
    }

    public final GridChatSoloPKStatisticInfo clear() {
        this.startTime = 0L;
        this.voteDeadline = 0L;
        this.voteEnd = false;
        this.penaltyDeadline = 0L;
        this.userStatisticInfo = GridChatSoloPkUserStatisticInfo.emptyArray();
        this.timestamp = 0L;
        this.soloPkStatus = 0;
        this.voteDeadlineWithBuffer = 0L;
        this.bangsInfo = null;
        this.pkStartAnimationUrls = LiveCdnNodeView.emptyArray();
        this.voteEndAnimationUrls = LiveCdnNodeView.emptyArray();
        this.drawAnimationUrls = LiveCdnNodeView.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.startTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.voteDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        boolean z = this.voteEnd;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        long j3 = this.penaltyDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        GridChatSoloPkUserStatisticInfo[] gridChatSoloPkUserStatisticInfoArr = this.userStatisticInfo;
        int i = 0;
        if (gridChatSoloPkUserStatisticInfoArr != null && gridChatSoloPkUserStatisticInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                GridChatSoloPkUserStatisticInfo[] gridChatSoloPkUserStatisticInfoArr2 = this.userStatisticInfo;
                if (i2 >= gridChatSoloPkUserStatisticInfoArr2.length) {
                    break;
                }
                GridChatSoloPkUserStatisticInfo gridChatSoloPkUserStatisticInfo = gridChatSoloPkUserStatisticInfoArr2[i2];
                if (gridChatSoloPkUserStatisticInfo != null) {
                    codedOutputByteBufferNano.writeMessage(5, gridChatSoloPkUserStatisticInfo);
                }
                i2++;
            }
        }
        long j4 = this.timestamp;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j4);
        }
        int i3 = this.soloPkStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i3);
        }
        long j5 = this.voteDeadlineWithBuffer;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j5);
        }
        GridChatSoloPkBangsInfo gridChatSoloPkBangsInfo = this.bangsInfo;
        if (gridChatSoloPkBangsInfo != null) {
            codedOutputByteBufferNano.writeMessage(9, gridChatSoloPkBangsInfo);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.pkStartAnimationUrls;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i4 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.pkStartAnimationUrls;
                if (i4 >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i4];
                if (liveCdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(10, liveCdnNodeView);
                }
                i4++;
            }
        }
        LiveCdnNodeView[] liveCdnNodeViewArr3 = this.voteEndAnimationUrls;
        if (liveCdnNodeViewArr3 != null && liveCdnNodeViewArr3.length > 0) {
            int i5 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr4 = this.voteEndAnimationUrls;
                if (i5 >= liveCdnNodeViewArr4.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView2 = liveCdnNodeViewArr4[i5];
                if (liveCdnNodeView2 != null) {
                    codedOutputByteBufferNano.writeMessage(11, liveCdnNodeView2);
                }
                i5++;
            }
        }
        LiveCdnNodeView[] liveCdnNodeViewArr5 = this.drawAnimationUrls;
        if (liveCdnNodeViewArr5 != null && liveCdnNodeViewArr5.length > 0) {
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr6 = this.drawAnimationUrls;
                if (i >= liveCdnNodeViewArr6.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView3 = liveCdnNodeViewArr6[i];
                if (liveCdnNodeView3 != null) {
                    codedOutputByteBufferNano.writeMessage(12, liveCdnNodeView3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.startTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.voteDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        boolean z = this.voteEnd;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        long j3 = this.penaltyDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        GridChatSoloPkUserStatisticInfo[] gridChatSoloPkUserStatisticInfoArr = this.userStatisticInfo;
        int i = 0;
        if (gridChatSoloPkUserStatisticInfoArr != null && gridChatSoloPkUserStatisticInfoArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                GridChatSoloPkUserStatisticInfo[] gridChatSoloPkUserStatisticInfoArr2 = this.userStatisticInfo;
                if (i2 >= gridChatSoloPkUserStatisticInfoArr2.length) {
                    break;
                }
                GridChatSoloPkUserStatisticInfo gridChatSoloPkUserStatisticInfo = gridChatSoloPkUserStatisticInfoArr2[i2];
                if (gridChatSoloPkUserStatisticInfo != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, gridChatSoloPkUserStatisticInfo);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        long j4 = this.timestamp;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j4);
        }
        int i3 = this.soloPkStatus;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i3);
        }
        long j5 = this.voteDeadlineWithBuffer;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j5);
        }
        GridChatSoloPkBangsInfo gridChatSoloPkBangsInfo = this.bangsInfo;
        if (gridChatSoloPkBangsInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, gridChatSoloPkBangsInfo);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.pkStartAnimationUrls;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.pkStartAnimationUrls;
                if (i4 >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i4];
                if (liveCdnNodeView != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(10, liveCdnNodeView);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        LiveCdnNodeView[] liveCdnNodeViewArr3 = this.voteEndAnimationUrls;
        if (liveCdnNodeViewArr3 != null && liveCdnNodeViewArr3.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i5 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr4 = this.voteEndAnimationUrls;
                if (i5 >= liveCdnNodeViewArr4.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView2 = liveCdnNodeViewArr4[i5];
                if (liveCdnNodeView2 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(11, liveCdnNodeView2);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        LiveCdnNodeView[] liveCdnNodeViewArr5 = this.drawAnimationUrls;
        if (liveCdnNodeViewArr5 != null && liveCdnNodeViewArr5.length > 0) {
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr6 = this.drawAnimationUrls;
                if (i >= liveCdnNodeViewArr6.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView3 = liveCdnNodeViewArr6[i];
                if (liveCdnNodeView3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, liveCdnNodeView3);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GridChatSoloPKStatisticInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.startTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.voteDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.voteEnd = codedInputByteBufferNano.readBool();
                    break;
                case 32:
                    this.penaltyDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    GridChatSoloPkUserStatisticInfo[] gridChatSoloPkUserStatisticInfoArr = this.userStatisticInfo;
                    int length = gridChatSoloPkUserStatisticInfoArr == null ? 0 : gridChatSoloPkUserStatisticInfoArr.length;
                    GridChatSoloPkUserStatisticInfo[] gridChatSoloPkUserStatisticInfoArr2 = new GridChatSoloPkUserStatisticInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.userStatisticInfo, 0, gridChatSoloPkUserStatisticInfoArr2, 0, length);
                    }
                    while (length < gridChatSoloPkUserStatisticInfoArr2.length - 1) {
                        gridChatSoloPkUserStatisticInfoArr2[length] = new GridChatSoloPkUserStatisticInfo();
                        codedInputByteBufferNano.readMessage(gridChatSoloPkUserStatisticInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    gridChatSoloPkUserStatisticInfoArr2[length] = new GridChatSoloPkUserStatisticInfo();
                    codedInputByteBufferNano.readMessage(gridChatSoloPkUserStatisticInfoArr2[length]);
                    this.userStatisticInfo = gridChatSoloPkUserStatisticInfoArr2;
                    break;
                case 48:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 56:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.soloPkStatus = int32;
                        break;
                    }
                case 64:
                    this.voteDeadlineWithBuffer = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    if (this.bangsInfo == null) {
                        this.bangsInfo = new GridChatSoloPkBangsInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.bangsInfo);
                    break;
                case 82:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.pkStartAnimationUrls;
                    int length2 = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.pkStartAnimationUrls, 0, liveCdnNodeViewArr2, 0, length2);
                    }
                    while (length2 < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length2] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    liveCdnNodeViewArr2[length2] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length2]);
                    this.pkStartAnimationUrls = liveCdnNodeViewArr2;
                    break;
                case 90:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    LiveCdnNodeView[] liveCdnNodeViewArr3 = this.voteEndAnimationUrls;
                    int length3 = liveCdnNodeViewArr3 == null ? 0 : liveCdnNodeViewArr3.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr4 = new LiveCdnNodeView[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.voteEndAnimationUrls, 0, liveCdnNodeViewArr4, 0, length3);
                    }
                    while (length3 < liveCdnNodeViewArr4.length - 1) {
                        liveCdnNodeViewArr4[length3] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    liveCdnNodeViewArr4[length3] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr4[length3]);
                    this.voteEndAnimationUrls = liveCdnNodeViewArr4;
                    break;
                case 98:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    LiveCdnNodeView[] liveCdnNodeViewArr5 = this.drawAnimationUrls;
                    int length4 = liveCdnNodeViewArr5 == null ? 0 : liveCdnNodeViewArr5.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr6 = new LiveCdnNodeView[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.drawAnimationUrls, 0, liveCdnNodeViewArr6, 0, length4);
                    }
                    while (length4 < liveCdnNodeViewArr6.length - 1) {
                        liveCdnNodeViewArr6[length4] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr6[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    liveCdnNodeViewArr6[length4] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr6[length4]);
                    this.drawAnimationUrls = liveCdnNodeViewArr6;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static GridChatSoloPKStatisticInfo parseFrom(byte[] bArr) {
        return (GridChatSoloPKStatisticInfo) MessageNano.mergeFrom(new GridChatSoloPKStatisticInfo(), bArr);
    }

    public static GridChatSoloPKStatisticInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GridChatSoloPKStatisticInfo().mergeFrom(codedInputByteBufferNano);
    }
}
