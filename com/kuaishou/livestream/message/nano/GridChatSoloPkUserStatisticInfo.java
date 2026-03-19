package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GridChatSoloPkUserStatisticInfo extends MessageNano {
    private static volatile GridChatSoloPkUserStatisticInfo[] _emptyArray;
    public String displayScore;
    public LiveCdnNodeView[] giftIconUrls;
    public boolean isBehind;
    public boolean isJoined;
    public boolean isTheFirst;
    public long score;
    public String scoreBackgroundColor;
    public UserInfos.UserInfo user;

    public static GridChatSoloPkUserStatisticInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GridChatSoloPkUserStatisticInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public GridChatSoloPkUserStatisticInfo() {
        clear();
    }

    public final GridChatSoloPkUserStatisticInfo clear() {
        this.user = null;
        this.score = 0L;
        this.isTheFirst = false;
        this.isBehind = false;
        this.isJoined = false;
        this.giftIconUrls = LiveCdnNodeView.emptyArray();
        this.displayScore = "";
        this.scoreBackgroundColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        long j = this.score;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        boolean z = this.isTheFirst;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        boolean z2 = this.isBehind;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        boolean z3 = this.isJoined;
        if (z3) {
            codedOutputByteBufferNano.writeBool(5, z3);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.giftIconUrls;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.giftIconUrls;
                if (i >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                if (liveCdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(6, liveCdnNodeView);
                }
                i++;
            }
        }
        if (!this.displayScore.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.displayScore);
        }
        if (!this.scoreBackgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.scoreBackgroundColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        long j = this.score;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        boolean z = this.isTheFirst;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        boolean z2 = this.isBehind;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        boolean z3 = this.isJoined;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z3);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.giftIconUrls;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.giftIconUrls;
                if (i >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                if (liveCdnNodeView != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveCdnNodeView);
                }
                i++;
            }
        }
        if (!this.displayScore.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.displayScore);
        }
        return !this.scoreBackgroundColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.scoreBackgroundColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GridChatSoloPkUserStatisticInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 16) {
                this.score = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.isTheFirst = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.isBehind = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.isJoined = codedInputByteBufferNano.readBool();
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                LiveCdnNodeView[] liveCdnNodeViewArr = this.giftIconUrls;
                int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.giftIconUrls, 0, liveCdnNodeViewArr2, 0, length);
                }
                while (length < liveCdnNodeViewArr2.length - 1) {
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                this.giftIconUrls = liveCdnNodeViewArr2;
            } else if (tag == 58) {
                this.displayScore = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.scoreBackgroundColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static GridChatSoloPkUserStatisticInfo parseFrom(byte[] bArr) {
        return (GridChatSoloPkUserStatisticInfo) MessageNano.mergeFrom(new GridChatSoloPkUserStatisticInfo(), bArr);
    }

    public static GridChatSoloPkUserStatisticInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GridChatSoloPkUserStatisticInfo().mergeFrom(codedInputByteBufferNano);
    }
}
