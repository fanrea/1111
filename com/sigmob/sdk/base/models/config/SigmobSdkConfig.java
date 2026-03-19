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
public final class SigmobSdkConfig extends AndroidMessage<SigmobSdkConfig, Builder> {
    public static final ProtoAdapter<SigmobSdkConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobSdkConfig> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.SigmobAndroid#ADAPTER", tag = 3)
    public final SigmobAndroid sigmobAndroid_config;

    @WireField(adapter = "com.sigmob.sdk.base.models.SigmobCommon#ADAPTER", tag = 1)
    public final SigmobCommon sigmobCommon_config;

    public static final class Builder extends Message.Builder<SigmobSdkConfig, Builder> {
        public SigmobAndroid sigmobAndroid_config;
        public SigmobCommon sigmobCommon_config;

        public Builder android_config(SigmobAndroid sigmobAndroid_config) {
            this.sigmobAndroid_config = sigmobAndroid_config;
            return this;
        }

        public SigmobSdkConfig build() {
            return new SigmobSdkConfig(this.sigmobCommon_config, this.sigmobAndroid_config, super.buildUnknownFields());
        }

        public Builder common_config(SigmobCommon sigmobCommon_config) {
            this.sigmobCommon_config = sigmobCommon_config;
            return this;
        }
    }

    private static final class ProtoAdapter_SdkConfig extends ProtoAdapter<SigmobSdkConfig> {
        public ProtoAdapter_SdkConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSdkConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobSdkConfig m1364decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.common_config((SigmobCommon) SigmobCommon.ADAPTER.decode(reader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.android_config((SigmobAndroid) SigmobAndroid.ADAPTER.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobSdkConfig value) throws IOException {
            SigmobCommon.ADAPTER.encodeWithTag(writer, 1, value.sigmobCommon_config);
            SigmobAndroid.ADAPTER.encodeWithTag(writer, 3, value.sigmobAndroid_config);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobSdkConfig value) {
            return SigmobCommon.ADAPTER.encodedSizeWithTag(1, value.sigmobCommon_config) + SigmobAndroid.ADAPTER.encodedSizeWithTag(3, value.sigmobAndroid_config) + value.unknownFields().size();
        }

        public SigmobSdkConfig redact(SigmobSdkConfig value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.sigmobCommon_config != null) {
                builderNewBuilder.sigmobCommon_config = (SigmobCommon) SigmobCommon.ADAPTER.redact(builderNewBuilder.sigmobCommon_config);
            }
            if (builderNewBuilder.sigmobAndroid_config != null) {
                builderNewBuilder.sigmobAndroid_config = (SigmobAndroid) SigmobAndroid.ADAPTER.redact(builderNewBuilder.sigmobAndroid_config);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SdkConfig protoAdapter_SdkConfig = new ProtoAdapter_SdkConfig();
        ADAPTER = protoAdapter_SdkConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SdkConfig);
    }

    public SigmobSdkConfig(SigmobCommon sigmobCommon_config, SigmobAndroid sigmobAndroid_config) {
        this(sigmobCommon_config, sigmobAndroid_config, ByteString.EMPTY);
    }

    public SigmobSdkConfig(SigmobCommon sigmobCommon_config, SigmobAndroid sigmobAndroid_config, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.sigmobCommon_config = sigmobCommon_config;
        this.sigmobAndroid_config = sigmobAndroid_config;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobSdkConfig)) {
            return false;
        }
        SigmobSdkConfig sigmobSdkConfig = (SigmobSdkConfig) other;
        return unknownFields().equals(sigmobSdkConfig.unknownFields()) && Internal.equals(this.sigmobCommon_config, sigmobSdkConfig.sigmobCommon_config) && Internal.equals(this.sigmobAndroid_config, sigmobSdkConfig.sigmobAndroid_config);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        SigmobCommon sigmobCommon = this.sigmobCommon_config;
        int iHashCode2 = (iHashCode + (sigmobCommon != null ? sigmobCommon.hashCode() : 0)) * 37;
        SigmobAndroid sigmobAndroid = this.sigmobAndroid_config;
        int iHashCode3 = iHashCode2 + (sigmobAndroid != null ? sigmobAndroid.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode3;
        return iHashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.sigmobCommon_config = this.sigmobCommon_config;
        builder.sigmobAndroid_config = this.sigmobAndroid_config;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.sigmobCommon_config != null) {
            sb.append(", sigmobCommon_config=").append(this.sigmobCommon_config);
        }
        if (this.sigmobAndroid_config != null) {
            sb.append(", sigmobAndroid_config=").append(this.sigmobAndroid_config);
        }
        return sb.replace(0, 2, "SigmobSdkConfig{").append('}').toString();
    }
}
