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
public final class MultiPkSkinTheme extends MessageNano {
    private static volatile MultiPkSkinTheme[] _emptyArray;
    public Map<String, String> activitySkinBgConfig;
    public String activitySkinThemeId;
    public Map<String, String> honorSkinBgConfig;
    public String honorSkinThemeId;

    public static MultiPkSkinTheme[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MultiPkSkinTheme[0];
                }
            }
        }
        return _emptyArray;
    }

    public MultiPkSkinTheme() {
        clear();
    }

    public final MultiPkSkinTheme clear() {
        this.activitySkinThemeId = "";
        this.honorSkinThemeId = "";
        this.activitySkinBgConfig = null;
        this.honorSkinBgConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.activitySkinThemeId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.activitySkinThemeId);
        }
        if (!this.honorSkinThemeId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.honorSkinThemeId);
        }
        Map<String, String> map = this.activitySkinBgConfig;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 9, 9);
        }
        Map<String, String> map2 = this.honorSkinBgConfig;
        if (map2 != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 4, 9, 9);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.activitySkinThemeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activitySkinThemeId);
        }
        if (!this.honorSkinThemeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.honorSkinThemeId);
        }
        Map<String, String> map = this.activitySkinBgConfig;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 3, 9, 9);
        }
        Map<String, String> map2 = this.honorSkinBgConfig;
        return map2 != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map2, 4, 9, 9) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MultiPkSkinTheme mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.activitySkinThemeId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.honorSkinThemeId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.activitySkinBgConfig = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.activitySkinBgConfig, mapFactory, 9, 9, null, 10, 18);
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.honorSkinBgConfig = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.honorSkinBgConfig, mapFactory, 9, 9, null, 10, 18);
            }
        }
    }

    public static MultiPkSkinTheme parseFrom(byte[] bArr) {
        return (MultiPkSkinTheme) MessageNano.mergeFrom(new MultiPkSkinTheme(), bArr);
    }

    public static MultiPkSkinTheme parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MultiPkSkinTheme().mergeFrom(codedInputByteBufferNano);
    }
}
