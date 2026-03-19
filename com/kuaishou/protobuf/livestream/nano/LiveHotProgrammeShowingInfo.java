package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHotProgrammeShowingInfo extends MessageNano {
    private static volatile LiveHotProgrammeShowingInfo[] _emptyArray;
    public String hotValueText;
    public LiveHotProgrammeInfo showingProgrammeItem;
    public String showingProgrammeItemName;
    public String title;
    public UserInfos.UserInfo userInfo;

    public static LiveHotProgrammeShowingInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHotProgrammeShowingInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHotProgrammeShowingInfo() {
        clear();
    }

    public final LiveHotProgrammeShowingInfo clear() {
        this.title = "";
        this.showingProgrammeItem = null;
        this.hotValueText = "";
        this.userInfo = null;
        this.showingProgrammeItemName = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        LiveHotProgrammeInfo liveHotProgrammeInfo = this.showingProgrammeItem;
        if (liveHotProgrammeInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, liveHotProgrammeInfo);
        }
        if (!this.hotValueText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.hotValueText);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo);
        }
        if (!this.showingProgrammeItemName.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.showingProgrammeItemName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        LiveHotProgrammeInfo liveHotProgrammeInfo = this.showingProgrammeItem;
        if (liveHotProgrammeInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveHotProgrammeInfo);
        }
        if (!this.hotValueText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.hotValueText);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
        }
        return !this.showingProgrammeItemName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.showingProgrammeItemName) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHotProgrammeShowingInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                if (this.showingProgrammeItem == null) {
                    this.showingProgrammeItem = new LiveHotProgrammeInfo();
                }
                codedInputByteBufferNano.readMessage(this.showingProgrammeItem);
            } else if (tag == 26) {
                this.hotValueText = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                if (this.userInfo == null) {
                    this.userInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.userInfo);
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.showingProgrammeItemName = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveHotProgrammeShowingInfo parseFrom(byte[] bArr) {
        return (LiveHotProgrammeShowingInfo) MessageNano.mergeFrom(new LiveHotProgrammeShowingInfo(), bArr);
    }

    public static LiveHotProgrammeShowingInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHotProgrammeShowingInfo().mergeFrom(codedInputByteBufferNano);
    }
}
