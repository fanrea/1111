package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ResponseNativeAd extends AndroidMessage<ResponseNativeAd, Builder> {
    public static final ProtoAdapter<ResponseNativeAd> ADAPTER;
    public static final Parcelable.Creator<ResponseNativeAd> CREATOR;
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "ResponseAsset#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<ResponseAsset> assets;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer type;

    public static final class Builder extends Message.Builder<ResponseNativeAd, Builder> {
        public Integer type = ResponseNativeAd.DEFAULT_TYPE;
        public List<ResponseAsset> assets = Internal.newMutableList();

        public Builder assets(List<ResponseAsset> assets) {
            Internal.checkElementsNotNull(assets);
            this.assets = assets;
            return this;
        }

        public ResponseNativeAd build() {
            return new ResponseNativeAd(this.assets, this.type, super.buildUnknownFields());
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }
    }

    private static final class ProtoAdapter_ResponseNativeAd extends ProtoAdapter<ResponseNativeAd> {
        public ProtoAdapter_ResponseNativeAd() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseNativeAd.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseNativeAd m1430decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.assets.add((ResponseAsset) ResponseAsset.ADAPTER.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.type((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, ResponseNativeAd value) throws IOException {
            ResponseAsset.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.assets);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.type);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(ResponseNativeAd value) {
            return ResponseAsset.ADAPTER.asRepeated().encodedSizeWithTag(1, value.assets) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.type) + value.unknownFields().size();
        }

        public ResponseNativeAd redact(ResponseNativeAd value) {
            Builder builderNewBuilder = value.newBuilder();
            Internal.redactElements(builderNewBuilder.assets, ResponseAsset.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseNativeAd protoAdapter_ResponseNativeAd = new ProtoAdapter_ResponseNativeAd();
        ADAPTER = protoAdapter_ResponseNativeAd;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseNativeAd);
        DEFAULT_TYPE = 0;
    }

    public ResponseNativeAd(List<ResponseAsset> assets, Integer type) {
        this(assets, type, ByteString.EMPTY);
    }

    public ResponseNativeAd(List<ResponseAsset> assets, Integer type, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.assets = Internal.immutableCopyOf("assets", assets);
        this.type = type;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ResponseNativeAd)) {
            return false;
        }
        ResponseNativeAd responseNativeAd = (ResponseNativeAd) other;
        return unknownFields().equals(responseNativeAd.unknownFields()) && this.assets.equals(responseNativeAd.assets) && Internal.equals(this.type, responseNativeAd.type);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((unknownFields().hashCode() * 37) + this.assets.hashCode()) * 37;
        Integer num = this.type;
        int iHashCode2 = iHashCode + (num != null ? num.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode2;
        return iHashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.assets = Internal.copyOf("assets", this.assets);
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.assets.isEmpty()) {
            sb.append(", assets=").append(this.assets);
        }
        if (this.type != null) {
            sb.append(", type=").append(this.type);
        }
        return sb.replace(0, 2, "ResponseNativeAd{").append('}').toString();
    }
}
