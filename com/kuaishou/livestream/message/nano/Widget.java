package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Widget extends MessageNano {
    private static volatile Widget[] _emptyArray;
    public String airBubblesText;
    public String clickUrl;
    public String[] iconUrl;
    public LoopInfo[] loop;
    public String title;
    public String widgetType;

    public static final class LoopInfo extends MessageNano {
        private static volatile LoopInfo[] _emptyArray;
        public long endTime;
        public long startTime;
        public String title;

        public static LoopInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LoopInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LoopInfo() {
            clear();
        }

        public final LoopInfo clear() {
            this.title = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.title);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.title);
            }
            long j = this.startTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.endTime;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LoopInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.endTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LoopInfo parseFrom(byte[] bArr) {
            return (LoopInfo) MessageNano.mergeFrom(new LoopInfo(), bArr);
        }

        public static LoopInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LoopInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static Widget[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Widget[0];
                }
            }
        }
        return _emptyArray;
    }

    public Widget() {
        clear();
    }

    public final Widget clear() {
        this.iconUrl = WireFormatNano.EMPTY_STRING_ARRAY;
        this.clickUrl = "";
        this.title = "";
        this.loop = LoopInfo.emptyArray();
        this.widgetType = "";
        this.airBubblesText = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        String[] strArr = this.iconUrl;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.iconUrl;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i2++;
            }
        }
        if (!this.clickUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.clickUrl);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.title);
        }
        LoopInfo[] loopInfoArr = this.loop;
        if (loopInfoArr != null && loopInfoArr.length > 0) {
            while (true) {
                LoopInfo[] loopInfoArr2 = this.loop;
                if (i >= loopInfoArr2.length) {
                    break;
                }
                LoopInfo loopInfo = loopInfoArr2[i];
                if (loopInfo != null) {
                    codedOutputByteBufferNano.writeMessage(4, loopInfo);
                }
                i++;
            }
        }
        if (!this.widgetType.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.widgetType);
        }
        if (!this.airBubblesText.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.airBubblesText);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.iconUrl;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.iconUrl;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
        }
        if (!this.clickUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.clickUrl);
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.title);
        }
        LoopInfo[] loopInfoArr = this.loop;
        if (loopInfoArr != null && loopInfoArr.length > 0) {
            while (true) {
                LoopInfo[] loopInfoArr2 = this.loop;
                if (i >= loopInfoArr2.length) {
                    break;
                }
                LoopInfo loopInfo = loopInfoArr2[i];
                if (loopInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, loopInfo);
                }
                i++;
            }
        }
        if (!this.widgetType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.widgetType);
        }
        return !this.airBubblesText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.airBubblesText) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Widget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.iconUrl;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.iconUrl, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.iconUrl = strArr2;
            } else if (tag == 18) {
                this.clickUrl = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                LoopInfo[] loopInfoArr = this.loop;
                int length2 = loopInfoArr == null ? 0 : loopInfoArr.length;
                LoopInfo[] loopInfoArr2 = new LoopInfo[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.loop, 0, loopInfoArr2, 0, length2);
                }
                while (length2 < loopInfoArr2.length - 1) {
                    loopInfoArr2[length2] = new LoopInfo();
                    codedInputByteBufferNano.readMessage(loopInfoArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                loopInfoArr2[length2] = new LoopInfo();
                codedInputByteBufferNano.readMessage(loopInfoArr2[length2]);
                this.loop = loopInfoArr2;
            } else if (tag == 42) {
                this.widgetType = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.airBubblesText = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Widget parseFrom(byte[] bArr) {
        return (Widget) MessageNano.mergeFrom(new Widget(), bArr);
    }

    public static Widget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Widget().mergeFrom(codedInputByteBufferNano);
    }
}
