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
public final class SigmobCommonEndpointsConfig extends AndroidMessage<SigmobCommonEndpointsConfig, Builder> {
    public static final ProtoAdapter<SigmobCommonEndpointsConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobCommonEndpointsConfig> CREATOR;
    public static final String DEFAULT_ADS = "";
    public static final String DEFAULT_CONFIG = "";
    public static final String DEFAULT_FEEDBACK = "";
    public static final String DEFAULT_HB_ADS = "";
    public static final String DEFAULT_LOG = "";
    public static final String DEFAULT_NATIVE_AD = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String feedback;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String hb_ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String log;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String native_ad;

    public static final class Builder extends Message.Builder<SigmobCommonEndpointsConfig, Builder> {
        public String ads;
        public String config;
        public String feedback;
        public String hb_ads;
        public String log;
        public String native_ad;

        public Builder ads(String ads) {
            this.ads = ads;
            return this;
        }

        public SigmobCommonEndpointsConfig build() {
            return new SigmobCommonEndpointsConfig(this.log, this.ads, this.hb_ads, this.feedback, this.config, this.native_ad, super.buildUnknownFields());
        }

        public Builder config(String config) {
            this.config = config;
            return this;
        }

        public Builder feedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public Builder hb_ads(String hb_ads) {
            this.hb_ads = hb_ads;
            return this;
        }

        public Builder log(String log) {
            this.log = log;
            return this;
        }

        public Builder native_ad(String native_ad) {
            this.native_ad = native_ad;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobCommonEndpointsConfig extends ProtoAdapter<SigmobCommonEndpointsConfig> {
        public ProtoAdapter_SigmobCommonEndpointsConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobCommonEndpointsConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobCommonEndpointsConfig m1349decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                switch (iNextTag) {
                    case 1:
                        builder.log((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 2:
                        builder.ads((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 3:
                        builder.hb_ads((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 4:
                        builder.feedback((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 5:
                        builder.config((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 6:
                        builder.native_ad((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobCommonEndpointsConfig value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.log);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.ads);
            ProtoAdapter.STRING.encodeWithTag(writer, 3, value.hb_ads);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.feedback);
            ProtoAdapter.STRING.encodeWithTag(writer, 5, value.config);
            ProtoAdapter.STRING.encodeWithTag(writer, 6, value.native_ad);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobCommonEndpointsConfig value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.log) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.ads) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.hb_ads) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.feedback) + ProtoAdapter.STRING.encodedSizeWithTag(5, value.config) + ProtoAdapter.STRING.encodedSizeWithTag(6, value.native_ad) + value.unknownFields().size();
        }

        public SigmobCommonEndpointsConfig redact(SigmobCommonEndpointsConfig value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobCommonEndpointsConfig protoAdapter_SigmobCommonEndpointsConfig = new ProtoAdapter_SigmobCommonEndpointsConfig();
        ADAPTER = protoAdapter_SigmobCommonEndpointsConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobCommonEndpointsConfig);
    }

    public SigmobCommonEndpointsConfig(String log, String ads, String hb_ads, String feedback, String config, String native_ad) {
        this(log, ads, hb_ads, feedback, config, native_ad, ByteString.EMPTY);
    }

    public SigmobCommonEndpointsConfig(String log, String ads, String hb_ads, String feedback, String config, String native_ad, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.log = log;
        this.ads = ads;
        this.hb_ads = hb_ads;
        this.feedback = feedback;
        this.config = config;
        this.native_ad = native_ad;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobCommonEndpointsConfig)) {
            return false;
        }
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig = (SigmobCommonEndpointsConfig) other;
        return unknownFields().equals(sigmobCommonEndpointsConfig.unknownFields()) && Internal.equals(this.log, sigmobCommonEndpointsConfig.log) && Internal.equals(this.ads, sigmobCommonEndpointsConfig.ads) && Internal.equals(this.hb_ads, sigmobCommonEndpointsConfig.hb_ads) && Internal.equals(this.feedback, sigmobCommonEndpointsConfig.feedback) && Internal.equals(this.config, sigmobCommonEndpointsConfig.config) && Internal.equals(this.native_ad, sigmobCommonEndpointsConfig.native_ad);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.log;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.ads;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.hb_ads;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.feedback;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.config;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.native_ad;
        int iHashCode7 = iHashCode6 + (str6 != null ? str6.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode7;
        return iHashCode7;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.log = this.log;
        builder.ads = this.ads;
        builder.hb_ads = this.hb_ads;
        builder.feedback = this.feedback;
        builder.config = this.config;
        builder.native_ad = this.native_ad;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.log != null) {
            sb.append(", log=").append(this.log);
        }
        if (this.ads != null) {
            sb.append(", ads=").append(this.ads);
        }
        if (this.hb_ads != null) {
            sb.append(", hb_ads=").append(this.hb_ads);
        }
        if (this.feedback != null) {
            sb.append(", feedback=").append(this.feedback);
        }
        if (this.config != null) {
            sb.append(", config=").append(this.config);
        }
        if (this.native_ad != null) {
            sb.append(", native_ad=").append(this.native_ad);
        }
        return sb.replace(0, 2, "SigmobCommonEndpointsConfig{").append('}').toString();
    }
}
