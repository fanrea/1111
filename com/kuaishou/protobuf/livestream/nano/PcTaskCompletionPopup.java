package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PcTaskCompletionPopup extends MessageNano {
    private static volatile PcTaskCompletionPopup[] _emptyArray;
    public CloseButton closeButton;
    public Map<String, String> extraInfo;
    public Reward reward;
    public String subTitle;
    public String subTitleColor;
    public String title;
    public String titleColor;

    public static PcTaskCompletionPopup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PcTaskCompletionPopup[0];
                }
            }
        }
        return _emptyArray;
    }

    public PcTaskCompletionPopup() {
        clear();
    }

    public final PcTaskCompletionPopup clear() {
        this.title = "";
        this.titleColor = "";
        this.subTitle = "";
        this.subTitleColor = "";
        this.closeButton = null;
        this.reward = null;
        this.extraInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.title);
        }
        if (!this.titleColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.titleColor);
        }
        if (!this.subTitle.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.subTitle);
        }
        if (!this.subTitleColor.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.subTitleColor);
        }
        CloseButton closeButton = this.closeButton;
        if (closeButton != null) {
            codedOutputByteBufferNano.writeMessage(6, closeButton);
        }
        Reward reward = this.reward;
        if (reward != null) {
            codedOutputByteBufferNano.writeMessage(7, reward);
        }
        Map<String, String> map = this.extraInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 8, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
        }
        if (!this.titleColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.titleColor);
        }
        if (!this.subTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.subTitle);
        }
        if (!this.subTitleColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.subTitleColor);
        }
        CloseButton closeButton = this.closeButton;
        if (closeButton != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, closeButton);
        }
        Reward reward = this.reward;
        if (reward != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, reward);
        }
        Map<String, String> map = this.extraInfo;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 8, 9, 9) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final PcTaskCompletionPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.titleColor = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.subTitle = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.subTitleColor = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                if (this.closeButton == null) {
                    this.closeButton = new CloseButton();
                }
                codedInputByteBufferNano.readMessage(this.closeButton);
            } else if (tag == 58) {
                if (this.reward == null) {
                    this.reward = new Reward();
                }
                codedInputByteBufferNano.readMessage(this.reward);
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.extraInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraInfo, mapFactory, 9, 9, null, 10, 18);
            }
        }
    }

    public static PcTaskCompletionPopup parseFrom(byte[] bArr) {
        return (PcTaskCompletionPopup) MessageNano.mergeFrom(new PcTaskCompletionPopup(), bArr);
    }

    public static PcTaskCompletionPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new PcTaskCompletionPopup().mergeFrom(codedInputByteBufferNano);
    }
}
