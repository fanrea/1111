package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkScoreRuleInfo extends MessageNano {
    private static volatile LiveMultiPkScoreRuleInfo[] _emptyArray;
    public String scoreRuleRoute;
    public String scoreRuleRouteForApp;
    public boolean showRuleEntrance;

    public static LiveMultiPkScoreRuleInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkScoreRuleInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkScoreRuleInfo() {
        clear();
    }

    public final LiveMultiPkScoreRuleInfo clear() {
        this.scoreRuleRoute = "";
        this.showRuleEntrance = false;
        this.scoreRuleRouteForApp = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.scoreRuleRoute.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.scoreRuleRoute);
        }
        boolean z = this.showRuleEntrance;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        if (!this.scoreRuleRouteForApp.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.scoreRuleRouteForApp);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.scoreRuleRoute.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.scoreRuleRoute);
        }
        boolean z = this.showRuleEntrance;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        return !this.scoreRuleRouteForApp.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.scoreRuleRouteForApp) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkScoreRuleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.scoreRuleRoute = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.showRuleEntrance = codedInputByteBufferNano.readBool();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.scoreRuleRouteForApp = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveMultiPkScoreRuleInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkScoreRuleInfo) MessageNano.mergeFrom(new LiveMultiPkScoreRuleInfo(), bArr);
    }

    public static LiveMultiPkScoreRuleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkScoreRuleInfo().mergeFrom(codedInputByteBufferNano);
    }
}
