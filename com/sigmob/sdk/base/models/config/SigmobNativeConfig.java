package com.sigmob.sdk.base.models.config;

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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SigmobNativeConfig extends AndroidMessage<SigmobNativeConfig, Builder> {
    public static final ProtoAdapter<SigmobNativeConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobNativeConfig> CREATOR;
    public static final Integer DEFAULT_AD_LOAD_TIMEOUT;
    public static final Integer DEFAULT_CACHETOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer ad_load_timeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cacheTop;

    public static final class Builder extends Message.Builder<SigmobNativeConfig, Builder> {
        public Integer ad_load_timeout;
        public Integer cacheTop;

        public Builder ad_load_timeout(Integer ad_load_timeout) {
            this.ad_load_timeout = ad_load_timeout;
            return this;
        }

        public SigmobNativeConfig build() {
            return new SigmobNativeConfig(this.cacheTop, this.ad_load_timeout, super.buildUnknownFields());
        }

        public Builder cacheTop(Integer cacheTop) {
            this.cacheTop = cacheTop;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobNativeConfig extends ProtoAdapter<SigmobNativeConfig> {
        public ProtoAdapter_SigmobNativeConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobNativeConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobNativeConfig m1358decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.cacheTop((Integer) ProtoAdapter.INT32.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.ad_load_timeout((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobNativeConfig value) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(writer, 1, value.cacheTop);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.ad_load_timeout);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobNativeConfig value) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, value.cacheTop) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.ad_load_timeout) + value.unknownFields().size();
        }

        public SigmobNativeConfig redact(SigmobNativeConfig value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobNativeConfig protoAdapter_SigmobNativeConfig = new ProtoAdapter_SigmobNativeConfig();
        ADAPTER = protoAdapter_SigmobNativeConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobNativeConfig);
        DEFAULT_CACHETOP = 0;
        DEFAULT_AD_LOAD_TIMEOUT = 0;
    }

    public SigmobNativeConfig(Integer cacheTop, Integer ad_load_timeout) {
        this(cacheTop, ad_load_timeout, ByteString.EMPTY);
    }

    public SigmobNativeConfig(Integer cacheTop, Integer ad_load_timeout, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.cacheTop = cacheTop;
        this.ad_load_timeout = ad_load_timeout;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobNativeConfig)) {
            return false;
        }
        SigmobNativeConfig sigmobNativeConfig = (SigmobNativeConfig) other;
        return unknownFields().equals(sigmobNativeConfig.unknownFields()) && Internal.equals(this.cacheTop, sigmobNativeConfig.cacheTop) && Internal.equals(this.ad_load_timeout, sigmobNativeConfig.ad_load_timeout);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.cacheTop;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.ad_load_timeout;
        int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode3;
        return iHashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.cacheTop = this.cacheTop;
        builder.ad_load_timeout = this.ad_load_timeout;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.cacheTop != null) {
            sb.append(", cacheTop=").append(this.cacheTop);
        }
        if (this.ad_load_timeout != null) {
            sb.append(", ad_load_timeout=").append(this.ad_load_timeout);
        }
        return sb.replace(0, 2, "SigmobNativeConfig{").append('}').toString();
    }
}
