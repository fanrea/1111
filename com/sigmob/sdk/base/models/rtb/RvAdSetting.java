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
public final class RvAdSetting extends AndroidMessage<RvAdSetting, Builder> {
    public static final ProtoAdapter<RvAdSetting> ADAPTER;
    public static final Parcelable.Creator<RvAdSetting> CREATOR;
    public static final Integer DEFAULT_CHARGE_PERCENT;
    public static final Integer DEFAULT_CHARGE_SECONDS;
    public static final Integer DEFAULT_CONFIRM_DIALOG;
    public static final Boolean DEFAULT_DISABLE_AUTO_LOAD;
    public static final Boolean DEFAULT_ENABLE_EXIT_ON_VIDEO_CLOSE;
    public static final Integer DEFAULT_ENDCARD_CLOSE_IMAGE;
    public static final Integer DEFAULT_ENDCARD_CLOSE_POSITION;
    public static final Integer DEFAULT_END_IMPRESSION_TIME;
    public static final Integer DEFAULT_END_TIME;
    public static final Float DEFAULT_FINISHED;
    public static final Boolean DEFAULT_FULL_CLICK_ON_VIDEO;
    public static final Integer DEFAULT_IF_MUTE;
    public static final Boolean DEFAULT_INVISIBLE_AD_LABEL;
    public static final Integer DEFAULT_MUTE_POSTION;
    public static final Integer DEFAULT_REWARD_PERCENT;
    public static final Integer DEFAULT_REWARD_SECONDS;
    public static final Integer DEFAULT_REWARD_STYLE;
    public static final Integer DEFAULT_SKIP_PERCENT;
    public static final Integer DEFAULT_SKIP_SECONDS;
    public static final Integer DEFAULT_VIDEO_CLOSE_POSITION;
    public static final Boolean DEFAULT_VIDEO_ERROR_REWARD;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 17)
    public final Integer charge_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 16)
    public final Integer charge_seconds;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.ClickAreaSetting#ADAPTER", tag = 10)
    public final ClickAreaSetting click_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 20)
    public final Integer confirm_dialog;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean disable_auto_load;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean enable_exit_on_video_close;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 14)
    public final Integer end_impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer end_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer endcard_close_image;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer endcard_close_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float finished;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean full_click_on_video;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer if_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean invisible_ad_label;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer mute_postion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 19)
    public final Integer reward_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 18)
    public final Integer reward_seconds;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    public final Integer reward_style;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer skip_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer skip_seconds;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer video_close_position;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 22)
    public final Boolean video_error_reward;

    public static final class Builder extends Message.Builder<RvAdSetting, Builder> {
        public ClickAreaSetting click_setting;
        public Integer skip_seconds;
        public Integer if_mute = RvAdSetting.DEFAULT_IF_MUTE;
        public Float finished = RvAdSetting.DEFAULT_FINISHED;
        public Integer video_close_position = RvAdSetting.DEFAULT_VIDEO_CLOSE_POSITION;
        public Integer endcard_close_position = RvAdSetting.DEFAULT_ENDCARD_CLOSE_POSITION;
        public Integer mute_postion = RvAdSetting.DEFAULT_MUTE_POSTION;
        public Integer skip_percent = RvAdSetting.DEFAULT_SKIP_PERCENT;
        public Boolean enable_exit_on_video_close = RvAdSetting.DEFAULT_ENABLE_EXIT_ON_VIDEO_CLOSE;
        public Boolean full_click_on_video = RvAdSetting.DEFAULT_FULL_CLICK_ON_VIDEO;
        public Boolean invisible_ad_label = RvAdSetting.DEFAULT_INVISIBLE_AD_LABEL;
        public Integer end_time = RvAdSetting.DEFAULT_END_TIME;
        public Integer endcard_close_image = RvAdSetting.DEFAULT_ENDCARD_CLOSE_IMAGE;
        public Integer end_impression_time = RvAdSetting.DEFAULT_END_IMPRESSION_TIME;
        public Boolean disable_auto_load = RvAdSetting.DEFAULT_DISABLE_AUTO_LOAD;
        public Integer charge_seconds = RvAdSetting.DEFAULT_CHARGE_SECONDS;
        public Integer charge_percent = RvAdSetting.DEFAULT_CHARGE_PERCENT;
        public Integer reward_seconds = RvAdSetting.DEFAULT_REWARD_SECONDS;
        public Integer reward_percent = RvAdSetting.DEFAULT_REWARD_PERCENT;
        public Integer confirm_dialog = RvAdSetting.DEFAULT_CONFIRM_DIALOG;
        public Integer reward_style = RvAdSetting.DEFAULT_REWARD_STYLE;
        public Boolean video_error_reward = RvAdSetting.DEFAULT_VIDEO_ERROR_REWARD;

        public RvAdSetting build() {
            return new RvAdSetting(this.if_mute, this.finished, this.video_close_position, this.endcard_close_position, this.mute_postion, this.skip_percent, this.skip_seconds, this.enable_exit_on_video_close, this.full_click_on_video, this.click_setting, this.invisible_ad_label, this.end_time, this.endcard_close_image, this.end_impression_time, this.disable_auto_load, this.charge_seconds, this.charge_percent, this.reward_seconds, this.reward_percent, this.confirm_dialog, this.reward_style, this.video_error_reward, super.buildUnknownFields());
        }

        public Builder charge_percent(Integer charge_percent) {
            this.charge_percent = charge_percent;
            return this;
        }

        public Builder charge_seconds(Integer charge_seconds) {
            this.charge_seconds = charge_seconds;
            return this;
        }

        public Builder click_setting(ClickAreaSetting click_setting) {
            this.click_setting = click_setting;
            return this;
        }

        public Builder confirm_dialog(Integer confirm_dialog) {
            this.confirm_dialog = confirm_dialog;
            return this;
        }

        public Builder disable_auto_load(Boolean disable_auto_load) {
            this.disable_auto_load = disable_auto_load;
            return this;
        }

        public Builder enable_exit_on_video_close(Boolean enable_exit_on_video_close) {
            this.enable_exit_on_video_close = enable_exit_on_video_close;
            return this;
        }

        public Builder end_impression_time(Integer end_impression_time) {
            this.end_impression_time = end_impression_time;
            return this;
        }

        public Builder end_time(Integer end_time) {
            this.end_time = end_time;
            return this;
        }

        public Builder endcard_close_image(Integer endcard_close_image) {
            this.endcard_close_image = endcard_close_image;
            return this;
        }

        public Builder endcard_close_position(Integer endcard_close_position) {
            this.endcard_close_position = endcard_close_position;
            return this;
        }

        public Builder finished(Float finished) {
            this.finished = finished;
            return this;
        }

        public Builder full_click_on_video(Boolean full_click_on_video) {
            this.full_click_on_video = full_click_on_video;
            return this;
        }

        public Builder if_mute(Integer if_mute) {
            this.if_mute = if_mute;
            return this;
        }

        public Builder invisible_ad_label(Boolean invisible_ad_label) {
            this.invisible_ad_label = invisible_ad_label;
            return this;
        }

        public Builder mute_postion(Integer mute_postion) {
            this.mute_postion = mute_postion;
            return this;
        }

        public Builder reward_percent(Integer reward_percent) {
            this.reward_percent = reward_percent;
            return this;
        }

        public Builder reward_seconds(Integer reward_seconds) {
            this.reward_seconds = reward_seconds;
            return this;
        }

        public Builder reward_style(Integer reward_style) {
            this.reward_style = reward_style;
            return this;
        }

        public Builder skip_percent(Integer skip_percent) {
            this.skip_percent = skip_percent;
            return this;
        }

        public Builder skip_seconds(Integer skip_seconds) {
            this.skip_seconds = skip_seconds;
            return this;
        }

        public Builder video_close_position(Integer video_close_position) {
            this.video_close_position = video_close_position;
            return this;
        }

        public Builder video_error_reward(Boolean video_error_reward) {
            this.video_error_reward = video_error_reward;
            return this;
        }
    }

    private static final class ProtoAdapter_RvAdSetting extends ProtoAdapter<RvAdSetting> {
        public ProtoAdapter_RvAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, RvAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public RvAdSetting m1433decode(ProtoReader reader) throws IOException {
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
                        builder.if_mute((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 2:
                        builder.finished((Float) ProtoAdapter.FLOAT.decode(reader));
                        break;
                    case 3:
                        builder.video_close_position((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 4:
                        builder.endcard_close_position((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 5:
                        builder.mute_postion((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 6:
                        builder.skip_percent((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 7:
                        builder.skip_seconds((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 8:
                        builder.enable_exit_on_video_close((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 9:
                        builder.full_click_on_video((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 10:
                        builder.click_setting((ClickAreaSetting) ClickAreaSetting.ADAPTER.decode(reader));
                        break;
                    case 11:
                        builder.invisible_ad_label((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 12:
                        builder.end_time((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 13:
                        builder.endcard_close_image((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 14:
                        builder.end_impression_time((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 15:
                        builder.disable_auto_load((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 16:
                        builder.charge_seconds((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 17:
                        builder.charge_percent((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 18:
                        builder.reward_seconds((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 19:
                        builder.reward_percent((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 20:
                        builder.confirm_dialog((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 21:
                        builder.reward_style((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 22:
                        builder.video_error_reward((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, RvAdSetting value) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(writer, 1, value.if_mute);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 2, value.finished);
            ProtoAdapter.INT32.encodeWithTag(writer, 3, value.video_close_position);
            ProtoAdapter.INT32.encodeWithTag(writer, 4, value.endcard_close_position);
            ProtoAdapter.INT32.encodeWithTag(writer, 5, value.mute_postion);
            ProtoAdapter.INT32.encodeWithTag(writer, 6, value.skip_percent);
            ProtoAdapter.INT32.encodeWithTag(writer, 7, value.skip_seconds);
            ProtoAdapter.BOOL.encodeWithTag(writer, 8, value.enable_exit_on_video_close);
            ProtoAdapter.BOOL.encodeWithTag(writer, 9, value.full_click_on_video);
            ClickAreaSetting.ADAPTER.encodeWithTag(writer, 10, value.click_setting);
            ProtoAdapter.BOOL.encodeWithTag(writer, 11, value.invisible_ad_label);
            ProtoAdapter.INT32.encodeWithTag(writer, 12, value.end_time);
            ProtoAdapter.INT32.encodeWithTag(writer, 13, value.endcard_close_image);
            ProtoAdapter.INT32.encodeWithTag(writer, 14, value.end_impression_time);
            ProtoAdapter.BOOL.encodeWithTag(writer, 15, value.disable_auto_load);
            ProtoAdapter.INT32.encodeWithTag(writer, 16, value.charge_seconds);
            ProtoAdapter.INT32.encodeWithTag(writer, 17, value.charge_percent);
            ProtoAdapter.INT32.encodeWithTag(writer, 18, value.reward_seconds);
            ProtoAdapter.INT32.encodeWithTag(writer, 19, value.reward_percent);
            ProtoAdapter.INT32.encodeWithTag(writer, 20, value.confirm_dialog);
            ProtoAdapter.INT32.encodeWithTag(writer, 21, value.reward_style);
            ProtoAdapter.BOOL.encodeWithTag(writer, 22, value.video_error_reward);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(RvAdSetting value) {
            return ProtoAdapter.INT32.encodedSizeWithTag(1, value.if_mute) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, value.finished) + ProtoAdapter.INT32.encodedSizeWithTag(3, value.video_close_position) + ProtoAdapter.INT32.encodedSizeWithTag(4, value.endcard_close_position) + ProtoAdapter.INT32.encodedSizeWithTag(5, value.mute_postion) + ProtoAdapter.INT32.encodedSizeWithTag(6, value.skip_percent) + ProtoAdapter.INT32.encodedSizeWithTag(7, value.skip_seconds) + ProtoAdapter.BOOL.encodedSizeWithTag(8, value.enable_exit_on_video_close) + ProtoAdapter.BOOL.encodedSizeWithTag(9, value.full_click_on_video) + ClickAreaSetting.ADAPTER.encodedSizeWithTag(10, value.click_setting) + ProtoAdapter.BOOL.encodedSizeWithTag(11, value.invisible_ad_label) + ProtoAdapter.INT32.encodedSizeWithTag(12, value.end_time) + ProtoAdapter.INT32.encodedSizeWithTag(13, value.endcard_close_image) + ProtoAdapter.INT32.encodedSizeWithTag(14, value.end_impression_time) + ProtoAdapter.BOOL.encodedSizeWithTag(15, value.disable_auto_load) + ProtoAdapter.INT32.encodedSizeWithTag(16, value.charge_seconds) + ProtoAdapter.INT32.encodedSizeWithTag(17, value.charge_percent) + ProtoAdapter.INT32.encodedSizeWithTag(18, value.reward_seconds) + ProtoAdapter.INT32.encodedSizeWithTag(19, value.reward_percent) + ProtoAdapter.INT32.encodedSizeWithTag(20, value.confirm_dialog) + ProtoAdapter.INT32.encodedSizeWithTag(21, value.reward_style) + ProtoAdapter.BOOL.encodedSizeWithTag(22, value.video_error_reward) + value.unknownFields().size();
        }

        public RvAdSetting redact(RvAdSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.click_setting != null) {
                builderNewBuilder.click_setting = (ClickAreaSetting) ClickAreaSetting.ADAPTER.redact(builderNewBuilder.click_setting);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_RvAdSetting protoAdapter_RvAdSetting = new ProtoAdapter_RvAdSetting();
        ADAPTER = protoAdapter_RvAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_RvAdSetting);
        DEFAULT_IF_MUTE = 0;
        DEFAULT_FINISHED = Float.valueOf(0.0f);
        DEFAULT_VIDEO_CLOSE_POSITION = 0;
        DEFAULT_ENDCARD_CLOSE_POSITION = 0;
        DEFAULT_MUTE_POSTION = 0;
        DEFAULT_SKIP_PERCENT = 0;
        DEFAULT_SKIP_SECONDS = 0;
        DEFAULT_ENABLE_EXIT_ON_VIDEO_CLOSE = false;
        DEFAULT_FULL_CLICK_ON_VIDEO = false;
        DEFAULT_INVISIBLE_AD_LABEL = false;
        DEFAULT_END_TIME = 0;
        DEFAULT_ENDCARD_CLOSE_IMAGE = 0;
        DEFAULT_END_IMPRESSION_TIME = 0;
        DEFAULT_DISABLE_AUTO_LOAD = false;
        DEFAULT_CHARGE_SECONDS = 0;
        DEFAULT_CHARGE_PERCENT = 0;
        DEFAULT_REWARD_SECONDS = 0;
        DEFAULT_REWARD_PERCENT = 0;
        DEFAULT_CONFIRM_DIALOG = 0;
        DEFAULT_REWARD_STYLE = 0;
        DEFAULT_VIDEO_ERROR_REWARD = false;
    }

    public RvAdSetting(Integer if_mute, Float finished, Integer video_close_position, Integer endcard_close_position, Integer mute_postion, Integer skip_percent, Integer skip_seconds, Boolean enable_exit_on_video_close, Boolean full_click_on_video, ClickAreaSetting click_setting, Boolean invisible_ad_label, Integer end_time, Integer endcard_close_image, Integer end_impression_time, Boolean disable_auto_load, Integer charge_seconds, Integer charge_percent, Integer reward_seconds, Integer reward_percent, Integer confirm_dialog, Integer reward_style, Boolean video_error_reward) {
        this(if_mute, finished, video_close_position, endcard_close_position, mute_postion, skip_percent, skip_seconds, enable_exit_on_video_close, full_click_on_video, click_setting, invisible_ad_label, end_time, endcard_close_image, end_impression_time, disable_auto_load, charge_seconds, charge_percent, reward_seconds, reward_percent, confirm_dialog, reward_style, video_error_reward, ByteString.EMPTY);
    }

    public RvAdSetting(Integer if_mute, Float finished, Integer video_close_position, Integer endcard_close_position, Integer mute_postion, Integer skip_percent, Integer skip_seconds, Boolean enable_exit_on_video_close, Boolean full_click_on_video, ClickAreaSetting click_setting, Boolean invisible_ad_label, Integer end_time, Integer endcard_close_image, Integer end_impression_time, Boolean disable_auto_load, Integer charge_seconds, Integer charge_percent, Integer reward_seconds, Integer reward_percent, Integer confirm_dialog, Integer reward_style, Boolean video_error_reward, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.if_mute = if_mute;
        this.finished = finished;
        this.video_close_position = video_close_position;
        this.endcard_close_position = endcard_close_position;
        this.mute_postion = mute_postion;
        this.skip_percent = skip_percent;
        this.skip_seconds = skip_seconds;
        this.enable_exit_on_video_close = enable_exit_on_video_close;
        this.full_click_on_video = full_click_on_video;
        this.click_setting = click_setting;
        this.invisible_ad_label = invisible_ad_label;
        this.end_time = end_time;
        this.endcard_close_image = endcard_close_image;
        this.end_impression_time = end_impression_time;
        this.disable_auto_load = disable_auto_load;
        this.charge_seconds = charge_seconds;
        this.charge_percent = charge_percent;
        this.reward_seconds = reward_seconds;
        this.reward_percent = reward_percent;
        this.confirm_dialog = confirm_dialog;
        this.reward_style = reward_style;
        this.video_error_reward = video_error_reward;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof RvAdSetting)) {
            return false;
        }
        RvAdSetting rvAdSetting = (RvAdSetting) other;
        return unknownFields().equals(rvAdSetting.unknownFields()) && Internal.equals(this.if_mute, rvAdSetting.if_mute) && Internal.equals(this.finished, rvAdSetting.finished) && Internal.equals(this.video_close_position, rvAdSetting.video_close_position) && Internal.equals(this.endcard_close_position, rvAdSetting.endcard_close_position) && Internal.equals(this.mute_postion, rvAdSetting.mute_postion) && Internal.equals(this.skip_percent, rvAdSetting.skip_percent) && Internal.equals(this.skip_seconds, rvAdSetting.skip_seconds) && Internal.equals(this.enable_exit_on_video_close, rvAdSetting.enable_exit_on_video_close) && Internal.equals(this.full_click_on_video, rvAdSetting.full_click_on_video) && Internal.equals(this.click_setting, rvAdSetting.click_setting) && Internal.equals(this.invisible_ad_label, rvAdSetting.invisible_ad_label) && Internal.equals(this.end_time, rvAdSetting.end_time) && Internal.equals(this.endcard_close_image, rvAdSetting.endcard_close_image) && Internal.equals(this.end_impression_time, rvAdSetting.end_impression_time) && Internal.equals(this.disable_auto_load, rvAdSetting.disable_auto_load) && Internal.equals(this.charge_seconds, rvAdSetting.charge_seconds) && Internal.equals(this.charge_percent, rvAdSetting.charge_percent) && Internal.equals(this.reward_seconds, rvAdSetting.reward_seconds) && Internal.equals(this.reward_percent, rvAdSetting.reward_percent) && Internal.equals(this.confirm_dialog, rvAdSetting.confirm_dialog) && Internal.equals(this.reward_style, rvAdSetting.reward_style) && Internal.equals(this.video_error_reward, rvAdSetting.video_error_reward);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.if_mute;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Float f = this.finished;
        int iHashCode3 = (iHashCode2 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num2 = this.video_close_position;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.endcard_close_position;
        int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.mute_postion;
        int iHashCode6 = (iHashCode5 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.skip_percent;
        int iHashCode7 = (iHashCode6 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.skip_seconds;
        int iHashCode8 = (iHashCode7 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool = this.enable_exit_on_video_close;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.full_click_on_video;
        int iHashCode10 = (iHashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        ClickAreaSetting clickAreaSetting = this.click_setting;
        int iHashCode11 = (iHashCode10 + (clickAreaSetting != null ? clickAreaSetting.hashCode() : 0)) * 37;
        Boolean bool3 = this.invisible_ad_label;
        int iHashCode12 = (iHashCode11 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num7 = this.end_time;
        int iHashCode13 = (iHashCode12 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.endcard_close_image;
        int iHashCode14 = (iHashCode13 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.end_impression_time;
        int iHashCode15 = (iHashCode14 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Boolean bool4 = this.disable_auto_load;
        int iHashCode16 = (iHashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Integer num10 = this.charge_seconds;
        int iHashCode17 = (iHashCode16 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.charge_percent;
        int iHashCode18 = (iHashCode17 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.reward_seconds;
        int iHashCode19 = (iHashCode18 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.reward_percent;
        int iHashCode20 = (iHashCode19 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Integer num14 = this.confirm_dialog;
        int iHashCode21 = (iHashCode20 + (num14 != null ? num14.hashCode() : 0)) * 37;
        Integer num15 = this.reward_style;
        int iHashCode22 = (iHashCode21 + (num15 != null ? num15.hashCode() : 0)) * 37;
        Boolean bool5 = this.video_error_reward;
        int iHashCode23 = iHashCode22 + (bool5 != null ? bool5.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode23;
        return iHashCode23;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.if_mute = this.if_mute;
        builder.finished = this.finished;
        builder.video_close_position = this.video_close_position;
        builder.endcard_close_position = this.endcard_close_position;
        builder.mute_postion = this.mute_postion;
        builder.skip_percent = this.skip_percent;
        builder.skip_seconds = this.skip_seconds;
        builder.enable_exit_on_video_close = this.enable_exit_on_video_close;
        builder.full_click_on_video = this.full_click_on_video;
        builder.click_setting = this.click_setting;
        builder.invisible_ad_label = this.invisible_ad_label;
        builder.end_time = this.end_time;
        builder.endcard_close_image = this.endcard_close_image;
        builder.end_impression_time = this.end_impression_time;
        builder.disable_auto_load = this.disable_auto_load;
        builder.charge_seconds = this.charge_seconds;
        builder.charge_percent = this.charge_percent;
        builder.reward_seconds = this.reward_seconds;
        builder.reward_percent = this.reward_percent;
        builder.confirm_dialog = this.confirm_dialog;
        builder.reward_style = this.reward_style;
        builder.video_error_reward = this.video_error_reward;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.if_mute != null) {
            sb.append(", if_mute=").append(this.if_mute);
        }
        if (this.finished != null) {
            sb.append(", finished=").append(this.finished);
        }
        if (this.video_close_position != null) {
            sb.append(", video_close_position=").append(this.video_close_position);
        }
        if (this.endcard_close_position != null) {
            sb.append(", endcard_close_position=").append(this.endcard_close_position);
        }
        if (this.mute_postion != null) {
            sb.append(", mute_postion=").append(this.mute_postion);
        }
        if (this.skip_percent != null) {
            sb.append(", skip_percent=").append(this.skip_percent);
        }
        if (this.skip_seconds != null) {
            sb.append(", skip_seconds=").append(this.skip_seconds);
        }
        if (this.enable_exit_on_video_close != null) {
            sb.append(", enable_exit_on_video_close=").append(this.enable_exit_on_video_close);
        }
        if (this.full_click_on_video != null) {
            sb.append(", full_click_on_video=").append(this.full_click_on_video);
        }
        if (this.click_setting != null) {
            sb.append(", click_setting=").append(this.click_setting);
        }
        if (this.invisible_ad_label != null) {
            sb.append(", invisible_ad_label=").append(this.invisible_ad_label);
        }
        if (this.end_time != null) {
            sb.append(", end_time=").append(this.end_time);
        }
        if (this.endcard_close_image != null) {
            sb.append(", endcard_close_image=").append(this.endcard_close_image);
        }
        if (this.end_impression_time != null) {
            sb.append(", end_impression_time=").append(this.end_impression_time);
        }
        if (this.disable_auto_load != null) {
            sb.append(", disable_auto_load=").append(this.disable_auto_load);
        }
        if (this.charge_seconds != null) {
            sb.append(", charge_seconds=").append(this.charge_seconds);
        }
        if (this.charge_percent != null) {
            sb.append(", charge_percent=").append(this.charge_percent);
        }
        if (this.reward_seconds != null) {
            sb.append(", reward_seconds=").append(this.reward_seconds);
        }
        if (this.reward_percent != null) {
            sb.append(", reward_percent=").append(this.reward_percent);
        }
        if (this.confirm_dialog != null) {
            sb.append(", confirm_dialog=").append(this.confirm_dialog);
        }
        if (this.reward_style != null) {
            sb.append(", reward_style=").append(this.reward_style);
        }
        if (this.video_error_reward != null) {
            sb.append(", video_error_reward=").append(this.video_error_reward);
        }
        return sb.replace(0, 2, "RvAdSetting{").append('}').toString();
    }
}
