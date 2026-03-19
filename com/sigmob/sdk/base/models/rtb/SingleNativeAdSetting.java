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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SingleNativeAdSetting extends AndroidMessage<SingleNativeAdSetting, Builder> {
    public static final ProtoAdapter<SingleNativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<SingleNativeAdSetting> CREATOR;
    public static final Boolean DEFAULT_USE_NA_VIDEO_COMPONENT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean use_na_video_component;

    public static final class Builder extends Message.Builder<SingleNativeAdSetting, Builder> {
        public Boolean use_na_video_component = SingleNativeAdSetting.DEFAULT_USE_NA_VIDEO_COMPONENT;

        public SingleNativeAdSetting build() {
            return new SingleNativeAdSetting(this.use_na_video_component, super.buildUnknownFields());
        }

        public Builder use_na_video_component(Boolean use_na_video_component) {
            this.use_na_video_component = use_na_video_component;
            return this;
        }
    }

    private static final class ProtoAdapter_SingleNativeAdSetting extends ProtoAdapter<SingleNativeAdSetting> {
        public ProtoAdapter_SingleNativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SingleNativeAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SingleNativeAdSetting m1436decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag != 1) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.use_na_video_component((Boolean) ProtoAdapter.BOOL.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SingleNativeAdSetting value) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.use_na_video_component);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SingleNativeAdSetting value) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, value.use_na_video_component) + value.unknownFields().size();
        }

        public SingleNativeAdSetting redact(SingleNativeAdSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SingleNativeAdSetting protoAdapter_SingleNativeAdSetting = new ProtoAdapter_SingleNativeAdSetting();
        ADAPTER = protoAdapter_SingleNativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SingleNativeAdSetting);
        DEFAULT_USE_NA_VIDEO_COMPONENT = false;
    }

    public SingleNativeAdSetting(Boolean use_na_video_component) {
        this(use_na_video_component, ByteString.EMPTY);
    }

    public SingleNativeAdSetting(Boolean use_na_video_component, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.use_na_video_component = use_na_video_component;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SingleNativeAdSetting)) {
            return false;
        }
        SingleNativeAdSetting singleNativeAdSetting = (SingleNativeAdSetting) other;
        return unknownFields().equals(singleNativeAdSetting.unknownFields()) && Internal.equals(this.use_na_video_component, singleNativeAdSetting.use_na_video_component);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.use_na_video_component;
        int iHashCode2 = iHashCode + (bool != null ? bool.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode2;
        return iHashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.use_na_video_component = this.use_na_video_component;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.use_na_video_component != null) {
            sb.append(", use_na_video_component=").append(this.use_na_video_component);
        }
        return sb.replace(0, 2, "SingleNativeAdSetting{").append('}').toString();
    }
}
