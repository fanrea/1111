package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveInteractiveGuideReportInfo extends MessageNano {
    private static volatile LiveInteractiveGuideReportInfo[] _emptyArray;
    public long authorId;
    public String encryptLiveStreamId;
    public int infoType;
    public int interactiveGuideBiz;
    public String interactiveGuideBizStr;
    public long liveStreamId;
    public String[] logExtra;
    public long reportTime;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReportInfoType {
        public static final int CARD_CLICK = 5;
        public static final int CARD_CLICK_CANCEL = 6;
        public static final int CARD_SHOW = 4;
        public static final int GUIDE_CLOSE = 2;
        public static final int GUIDE_SHOW = 1;
        public static final int GUIDE_TIMEOUT = 3;
        public static final int UNKNOWN = 0;
    }

    public static LiveInteractiveGuideReportInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveInteractiveGuideReportInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveInteractiveGuideReportInfo() {
        clear();
    }

    public final LiveInteractiveGuideReportInfo clear() {
        this.infoType = 0;
        this.authorId = 0L;
        this.encryptLiveStreamId = "";
        this.liveStreamId = 0L;
        this.logExtra = WireFormatNano.EMPTY_STRING_ARRAY;
        this.interactiveGuideBiz = 0;
        this.interactiveGuideBizStr = "";
        this.reportTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.infoType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.encryptLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.encryptLiveStreamId);
        }
        long j2 = this.liveStreamId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        String[] strArr = this.logExtra;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.logExtra;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(5, str);
                }
                i2++;
            }
        }
        int i3 = this.interactiveGuideBiz;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        if (!this.interactiveGuideBizStr.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.interactiveGuideBizStr);
        }
        long j3 = this.reportTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.infoType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.encryptLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.encryptLiveStreamId);
        }
        long j2 = this.liveStreamId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        String[] strArr = this.logExtra;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.logExtra;
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
        int i4 = this.interactiveGuideBiz;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i4);
        }
        if (!this.interactiveGuideBizStr.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.interactiveGuideBizStr);
        }
        long j3 = this.reportTime;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveInteractiveGuideReportInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.infoType = int32;
                        break;
                }
            } else if (tag == 16) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.encryptLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.liveStreamId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                String[] strArr = this.logExtra;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.logExtra, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.logExtra = strArr2;
            } else if (tag == 48) {
                this.interactiveGuideBiz = codedInputByteBufferNano.readUInt32();
            } else if (tag == 58) {
                this.interactiveGuideBizStr = codedInputByteBufferNano.readString();
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.reportTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveInteractiveGuideReportInfo parseFrom(byte[] bArr) {
        return (LiveInteractiveGuideReportInfo) MessageNano.mergeFrom(new LiveInteractiveGuideReportInfo(), bArr);
    }

    public static LiveInteractiveGuideReportInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveInteractiveGuideReportInfo().mergeFrom(codedInputByteBufferNano);
    }
}
