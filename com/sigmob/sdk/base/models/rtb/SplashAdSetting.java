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
public final class SplashAdSetting extends AndroidMessage<SplashAdSetting, Builder> {
    public static final ProtoAdapter<SplashAdSetting> ADAPTER;
    public static final Parcelable.Creator<SplashAdSetting> CREATOR;
    public static final Boolean DEFAULT_ENABLE_CLOSE_ON_CLICK;
    public static final Boolean DEFAULT_ENABLE_FULL_CLICK;
    public static final Boolean DEFAULT_INVISIBLE_AD_LABEL;
    public static final Integer DEFAULT_SHOW_DURATION;
    public static final Boolean DEFAULT_USE_FLOATING_BTN;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean enable_close_on_click;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean enable_full_click;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean invisible_ad_label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer show_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean use_floating_btn;

    public static final class Builder extends Message.Builder<SplashAdSetting, Builder> {
        public Integer show_duration = SplashAdSetting.DEFAULT_SHOW_DURATION;
        public Boolean enable_close_on_click = SplashAdSetting.DEFAULT_ENABLE_CLOSE_ON_CLICK;
        public Boolean enable_full_click = SplashAdSetting.DEFAULT_ENABLE_FULL_CLICK;
        public Boolean invisible_ad_label = SplashAdSetting.DEFAULT_INVISIBLE_AD_LABEL;
        public Boolean use_floating_btn = SplashAdSetting.DEFAULT_USE_FLOATING_BTN;

        public SplashAdSetting build() {
            return new SplashAdSetting(this.show_duration, this.enable_close_on_click, this.enable_full_click, this.invisible_ad_label, this.use_floating_btn, super.buildUnknownFields());
        }

        public Builder enable_close_on_click(Boolean enable_close_on_click) {
            this.enable_close_on_click = enable_close_on_click;
            return this;
        }

        public Builder enable_full_click(Boolean enable_full_click) {
            this.enable_full_click = enable_full_click;
            return this;
        }

        public Builder invisible_ad_label(Boolean invisible_ad_label) {
            this.invisible_ad_label = invisible_ad_label;
            return this;
        }

        public Builder show_duration(Integer show_duration) {
            this.show_duration = show_duration;
            return this;
        }

        public Builder use_floating_btn(Boolean use_floating_btn) {
            this.use_floating_btn = use_floating_btn;
            return this;
        }
    }

    private static final class ProtoAdapter_SplashAdSetting extends ProtoAdapter<SplashAdSetting> {
        public ProtoAdapter_SplashAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SplashAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SplashAdSetting m1442decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.show_duration((Integer) ProtoAdapter.INT32.decode(reader));
                } else if (iNextTag == 2) {
                    builder.enable_close_on_click((Boolean) ProtoAdapter.BOOL.decode(reader));
                } else if (iNextTag == 5) {
                    builder.enable_full_click((Boolean) ProtoAdapter.BOOL.decode(reader));
                } else if (iNextTag == 6) {
                    builder.invisible_ad_label((Boolean) ProtoAdapter.BOOL.decode(reader));
                } else if (iNextTag != 7) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.use_floating_btn((Boolean) ProtoAdapter.BOOL.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SplashAdSetting value) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(writer, 1, value.show_duration);
            ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enable_close_on_click);
            ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.enable_full_click);
            ProtoAdapter.BOOL.encodeWithTag(writer, 6, value.invisible_ad_label);
            ProtoAdapter.BOOL.encodeWithTag(writer, 7, value.use_floating_btn);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SplashAdSetting value) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, value.show_duration) + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enable_close_on_click) + ProtoAdapter.BOOL.encodedSizeWithTag(5, value.enable_full_click) + ProtoAdapter.BOOL.encodedSizeWithTag(6, value.invisible_ad_label) + ProtoAdapter.BOOL.encodedSizeWithTag(7, value.use_floating_btn) + value.unknownFields().size();
        }

        public SplashAdSetting redact(SplashAdSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SplashAdSetting protoAdapter_SplashAdSetting = new ProtoAdapter_SplashAdSetting();
        ADAPTER = protoAdapter_SplashAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SplashAdSetting);
        DEFAULT_SHOW_DURATION = 0;
        DEFAULT_ENABLE_CLOSE_ON_CLICK = false;
        DEFAULT_ENABLE_FULL_CLICK = false;
        DEFAULT_INVISIBLE_AD_LABEL = false;
        DEFAULT_USE_FLOATING_BTN = false;
    }

    public SplashAdSetting(Integer show_duration, Boolean enable_close_on_click, Boolean enable_full_click, Boolean invisible_ad_label, Boolean use_floating_btn) {
        this(show_duration, enable_close_on_click, enable_full_click, invisible_ad_label, use_floating_btn, ByteString.EMPTY);
    }

    public SplashAdSetting(Integer show_duration, Boolean enable_close_on_click, Boolean enable_full_click, Boolean invisible_ad_label, Boolean use_floating_btn, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.show_duration = show_duration;
        this.enable_close_on_click = enable_close_on_click;
        this.enable_full_click = enable_full_click;
        this.invisible_ad_label = invisible_ad_label;
        this.use_floating_btn = use_floating_btn;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SplashAdSetting)) {
            return false;
        }
        SplashAdSetting splashAdSetting = (SplashAdSetting) other;
        return unknownFields().equals(splashAdSetting.unknownFields()) && Internal.equals(this.show_duration, splashAdSetting.show_duration) && Internal.equals(this.enable_close_on_click, splashAdSetting.enable_close_on_click) && Internal.equals(this.enable_full_click, splashAdSetting.enable_full_click) && Internal.equals(this.invisible_ad_label, splashAdSetting.invisible_ad_label) && Internal.equals(this.use_floating_btn, splashAdSetting.use_floating_btn);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.show_duration;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.enable_close_on_click;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_full_click;
        int iHashCode4 = (iHashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.invisible_ad_label;
        int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.use_floating_btn;
        int iHashCode6 = iHashCode5 + (bool4 != null ? bool4.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode6;
        return iHashCode6;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.show_duration = this.show_duration;
        builder.enable_close_on_click = this.enable_close_on_click;
        builder.enable_full_click = this.enable_full_click;
        builder.invisible_ad_label = this.invisible_ad_label;
        builder.use_floating_btn = this.use_floating_btn;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.show_duration != null) {
            sb.append(", show_duration=").append(this.show_duration);
        }
        if (this.enable_close_on_click != null) {
            sb.append(", enable_close_on_click=").append(this.enable_close_on_click);
        }
        if (this.enable_full_click != null) {
            sb.append(", enable_full_click=").append(this.enable_full_click);
        }
        if (this.invisible_ad_label != null) {
            sb.append(", invisible_ad_label=").append(this.invisible_ad_label);
        }
        if (this.use_floating_btn != null) {
            sb.append(", use_floating_btn=").append(this.use_floating_btn);
        }
        return sb.replace(0, 2, "SplashAdSetting{").append('}').toString();
    }
}
