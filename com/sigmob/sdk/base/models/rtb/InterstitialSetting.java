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
public final class InterstitialSetting extends AndroidMessage<InterstitialSetting, Builder> {
    public static final ProtoAdapter<InterstitialSetting> ADAPTER;
    public static final Parcelable.Creator<InterstitialSetting> CREATOR;
    public static final Integer DEFAULT_CHARGE_TIME;
    public static final Boolean DEFAULT_CLICK_CLOSE_AD;
    public static final Boolean DEFAULT_DISABLE_AUTO_LOAD;
    public static final Integer DEFAULT_ENDCARD_CLOSE_POSITION;
    public static final Integer DEFAULT_IF_MUTE;
    public static final Integer DEFAULT_MUTE_POSITION;
    public static final Integer DEFAULT_SECONDS_CLOSE_AD;
    public static final Integer DEFAULT_SHAKE_LEVEL;
    public static final Integer DEFAULT_SHOW_SKIP_SECONDS;
    public static final Boolean DEFAULT_SKIP_CLOSE_AD;
    public static final Integer DEFAULT_SKIP_POSITION;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer charge_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean click_close_ad;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean disable_auto_load;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer endcard_close_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer if_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer mute_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer seconds_close_ad;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer shake_level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer show_skip_seconds;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean skip_close_ad;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer skip_position;

    public static final class Builder extends Message.Builder<InterstitialSetting, Builder> {
        public Integer if_mute = InterstitialSetting.DEFAULT_IF_MUTE;
        public Integer show_skip_seconds = InterstitialSetting.DEFAULT_SHOW_SKIP_SECONDS;
        public Boolean skip_close_ad = InterstitialSetting.DEFAULT_SKIP_CLOSE_AD;
        public Integer skip_position = InterstitialSetting.DEFAULT_SKIP_POSITION;
        public Integer endcard_close_position = InterstitialSetting.DEFAULT_ENDCARD_CLOSE_POSITION;
        public Integer mute_position = InterstitialSetting.DEFAULT_MUTE_POSITION;
        public Integer shake_level = InterstitialSetting.DEFAULT_SHAKE_LEVEL;
        public Integer charge_time = InterstitialSetting.DEFAULT_CHARGE_TIME;
        public Boolean disable_auto_load = InterstitialSetting.DEFAULT_DISABLE_AUTO_LOAD;
        public Boolean click_close_ad = InterstitialSetting.DEFAULT_CLICK_CLOSE_AD;
        public Integer seconds_close_ad = InterstitialSetting.DEFAULT_SECONDS_CLOSE_AD;

        public InterstitialSetting build() {
            return new InterstitialSetting(this.if_mute, this.show_skip_seconds, this.skip_close_ad, this.skip_position, this.endcard_close_position, this.mute_position, this.shake_level, this.charge_time, this.disable_auto_load, this.click_close_ad, this.seconds_close_ad, super.buildUnknownFields());
        }

        public Builder charge_time(Integer charge_time) {
            this.charge_time = charge_time;
            return this;
        }

        public Builder click_close_ad(Boolean click_close_ad) {
            this.click_close_ad = click_close_ad;
            return this;
        }

        public Builder disable_auto_load(Boolean disable_auto_load) {
            this.disable_auto_load = disable_auto_load;
            return this;
        }

        public Builder endcard_close_position(Integer endcard_close_position) {
            this.endcard_close_position = endcard_close_position;
            return this;
        }

        public Builder if_mute(Integer if_mute) {
            this.if_mute = if_mute;
            return this;
        }

        public Builder mute_position(Integer mute_position) {
            this.mute_position = mute_position;
            return this;
        }

        public Builder seconds_close_ad(Integer seconds_close_ad) {
            this.seconds_close_ad = seconds_close_ad;
            return this;
        }

        public Builder shake_level(Integer shake_level) {
            this.shake_level = shake_level;
            return this;
        }

        public Builder show_skip_seconds(Integer show_skip_seconds) {
            this.show_skip_seconds = show_skip_seconds;
            return this;
        }

        public Builder skip_close_ad(Boolean skip_close_ad) {
            this.skip_close_ad = skip_close_ad;
            return this;
        }

        public Builder skip_position(Integer skip_position) {
            this.skip_position = skip_position;
            return this;
        }
    }

    private static final class ProtoAdapter_InterstitialSetting extends ProtoAdapter<InterstitialSetting> {
        public ProtoAdapter_InterstitialSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, InterstitialSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public InterstitialSetting m1406decode(ProtoReader reader) throws IOException {
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
                        builder.if_mute((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 2:
                        builder.show_skip_seconds((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 3:
                        builder.skip_close_ad((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 4:
                        builder.skip_position((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 5:
                        builder.endcard_close_position((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 6:
                        builder.mute_position((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 7:
                        builder.shake_level((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 8:
                        builder.charge_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 9:
                        builder.disable_auto_load((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 10:
                        builder.click_close_ad((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 11:
                        builder.seconds_close_ad((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, InterstitialSetting value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.if_mute);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.show_skip_seconds);
            ProtoAdapter.BOOL.encodeWithTag(writer, 3, value.skip_close_ad);
            ProtoAdapter.UINT32.encodeWithTag(writer, 4, value.skip_position);
            ProtoAdapter.UINT32.encodeWithTag(writer, 5, value.endcard_close_position);
            ProtoAdapter.UINT32.encodeWithTag(writer, 6, value.mute_position);
            ProtoAdapter.UINT32.encodeWithTag(writer, 7, value.shake_level);
            ProtoAdapter.UINT32.encodeWithTag(writer, 8, value.charge_time);
            ProtoAdapter.BOOL.encodeWithTag(writer, 9, value.disable_auto_load);
            ProtoAdapter.BOOL.encodeWithTag(writer, 10, value.click_close_ad);
            ProtoAdapter.UINT32.encodeWithTag(writer, 11, value.seconds_close_ad);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(InterstitialSetting value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.if_mute) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.show_skip_seconds) + ProtoAdapter.BOOL.encodedSizeWithTag(3, value.skip_close_ad) + ProtoAdapter.UINT32.encodedSizeWithTag(4, value.skip_position) + ProtoAdapter.UINT32.encodedSizeWithTag(5, value.endcard_close_position) + ProtoAdapter.UINT32.encodedSizeWithTag(6, value.mute_position) + ProtoAdapter.UINT32.encodedSizeWithTag(7, value.shake_level) + ProtoAdapter.UINT32.encodedSizeWithTag(8, value.charge_time) + ProtoAdapter.BOOL.encodedSizeWithTag(9, value.disable_auto_load) + ProtoAdapter.BOOL.encodedSizeWithTag(10, value.click_close_ad) + ProtoAdapter.UINT32.encodedSizeWithTag(11, value.seconds_close_ad) + value.unknownFields().size();
        }

        public InterstitialSetting redact(InterstitialSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_InterstitialSetting protoAdapter_InterstitialSetting = new ProtoAdapter_InterstitialSetting();
        ADAPTER = protoAdapter_InterstitialSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_InterstitialSetting);
        DEFAULT_IF_MUTE = 0;
        DEFAULT_SHOW_SKIP_SECONDS = 0;
        DEFAULT_SKIP_CLOSE_AD = false;
        DEFAULT_SKIP_POSITION = 3;
        DEFAULT_ENDCARD_CLOSE_POSITION = 3;
        DEFAULT_MUTE_POSITION = 1;
        DEFAULT_SHAKE_LEVEL = 0;
        DEFAULT_CHARGE_TIME = 5;
        DEFAULT_DISABLE_AUTO_LOAD = false;
        DEFAULT_CLICK_CLOSE_AD = false;
        DEFAULT_SECONDS_CLOSE_AD = 0;
    }

    public InterstitialSetting(Integer if_mute, Integer show_skip_seconds, Boolean skip_close_ad, Integer skip_position, Integer endcard_close_position, Integer mute_position, Integer shake_level, Integer charge_time, Boolean disable_auto_load, Boolean click_close_ad, Integer seconds_close_ad) {
        this(if_mute, show_skip_seconds, skip_close_ad, skip_position, endcard_close_position, mute_position, shake_level, charge_time, disable_auto_load, click_close_ad, seconds_close_ad, ByteString.EMPTY);
    }

    public InterstitialSetting(Integer if_mute, Integer show_skip_seconds, Boolean skip_close_ad, Integer skip_position, Integer endcard_close_position, Integer mute_position, Integer shake_level, Integer charge_time, Boolean disable_auto_load, Boolean click_close_ad, Integer seconds_close_ad, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.if_mute = if_mute;
        this.show_skip_seconds = show_skip_seconds;
        this.skip_close_ad = skip_close_ad;
        this.skip_position = skip_position;
        this.endcard_close_position = endcard_close_position;
        this.mute_position = mute_position;
        this.shake_level = shake_level;
        this.charge_time = charge_time;
        this.disable_auto_load = disable_auto_load;
        this.click_close_ad = click_close_ad;
        this.seconds_close_ad = seconds_close_ad;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof InterstitialSetting)) {
            return false;
        }
        InterstitialSetting interstitialSetting = (InterstitialSetting) other;
        return unknownFields().equals(interstitialSetting.unknownFields()) && Internal.equals(this.if_mute, interstitialSetting.if_mute) && Internal.equals(this.show_skip_seconds, interstitialSetting.show_skip_seconds) && Internal.equals(this.skip_close_ad, interstitialSetting.skip_close_ad) && Internal.equals(this.skip_position, interstitialSetting.skip_position) && Internal.equals(this.endcard_close_position, interstitialSetting.endcard_close_position) && Internal.equals(this.mute_position, interstitialSetting.mute_position) && Internal.equals(this.shake_level, interstitialSetting.shake_level) && Internal.equals(this.charge_time, interstitialSetting.charge_time) && Internal.equals(this.disable_auto_load, interstitialSetting.disable_auto_load) && Internal.equals(this.click_close_ad, interstitialSetting.click_close_ad) && Internal.equals(this.seconds_close_ad, interstitialSetting.seconds_close_ad);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.if_mute;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.show_skip_seconds;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.skip_close_ad;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num3 = this.skip_position;
        int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.endcard_close_position;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.mute_position;
        int iHashCode7 = (iHashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.shake_level;
        int iHashCode8 = (iHashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.charge_time;
        int iHashCode9 = (iHashCode8 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_auto_load;
        int iHashCode10 = (iHashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.click_close_ad;
        int iHashCode11 = (iHashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num8 = this.seconds_close_ad;
        int iHashCode12 = iHashCode11 + (num8 != null ? num8.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode12;
        return iHashCode12;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.if_mute = this.if_mute;
        builder.show_skip_seconds = this.show_skip_seconds;
        builder.skip_close_ad = this.skip_close_ad;
        builder.skip_position = this.skip_position;
        builder.endcard_close_position = this.endcard_close_position;
        builder.mute_position = this.mute_position;
        builder.shake_level = this.shake_level;
        builder.charge_time = this.charge_time;
        builder.disable_auto_load = this.disable_auto_load;
        builder.click_close_ad = this.click_close_ad;
        builder.seconds_close_ad = this.seconds_close_ad;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.if_mute != null) {
            sb.append(", if_mute=").append(this.if_mute);
        }
        if (this.show_skip_seconds != null) {
            sb.append(", show_skip_seconds=").append(this.show_skip_seconds);
        }
        if (this.skip_close_ad != null) {
            sb.append(", skip_close_ad=").append(this.skip_close_ad);
        }
        if (this.skip_position != null) {
            sb.append(", skip_position=").append(this.skip_position);
        }
        if (this.endcard_close_position != null) {
            sb.append(", endcard_close_position=").append(this.endcard_close_position);
        }
        if (this.mute_position != null) {
            sb.append(", mute_position=").append(this.mute_position);
        }
        if (this.shake_level != null) {
            sb.append(", shake_level=").append(this.shake_level);
        }
        if (this.charge_time != null) {
            sb.append(", charge_time=").append(this.charge_time);
        }
        if (this.disable_auto_load != null) {
            sb.append(", disable_auto_load=").append(this.disable_auto_load);
        }
        if (this.click_close_ad != null) {
            sb.append(", click_close_ad=").append(this.click_close_ad);
        }
        if (this.seconds_close_ad != null) {
            sb.append(", seconds_close_ad=").append(this.seconds_close_ad);
        }
        return sb.replace(0, 2, "InterstitialSetting{").append('}').toString();
    }
}
