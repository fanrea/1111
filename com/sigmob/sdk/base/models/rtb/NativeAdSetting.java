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
public final class NativeAdSetting extends AndroidMessage<NativeAdSetting, Builder> {
    public static final ProtoAdapter<NativeAdSetting> ADAPTER;
    public static final Parcelable.Creator<NativeAdSetting> CREATOR;
    public static final Integer DEFAULT_AD_POOL_SIZE;
    public static final Integer DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
    public static final Boolean DEFAULT_ENABLE_ADVANCED_INTERACTION;
    public static final Integer DEFAULT_END_IMPRESSION_TIME;
    public static final Integer DEFAULT_IMPRESSION_PERCENT;
    public static final Integer DEFAULT_IMPRESSION_TIME;
    public static final Integer DEFAULT_LOG_INTERVAL_TIME;
    public static final Integer DEFAULT_MEDIA_EXPECTED_FLOOR;
    public static final Integer DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
    public static final Integer DEFAULT_REQ_INTERVAL_TIME;
    public static final Integer DEFAULT_VIDEO_AUTO_PLAY;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer ad_pool_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer detail_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean enable_advanced_interaction;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer end_impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer impression_percent;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer impression_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer log_interval_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer media_expected_floor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer preview_page_video_mute;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer req_interval_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer video_auto_play;

    public static final class Builder extends Message.Builder<NativeAdSetting, Builder> {
        public Integer video_auto_play = NativeAdSetting.DEFAULT_VIDEO_AUTO_PLAY;
        public Integer preview_page_video_mute = NativeAdSetting.DEFAULT_PREVIEW_PAGE_VIDEO_MUTE;
        public Integer detail_page_video_mute = NativeAdSetting.DEFAULT_DETAIL_PAGE_VIDEO_MUTE;
        public Integer impression_percent = NativeAdSetting.DEFAULT_IMPRESSION_PERCENT;
        public Integer impression_time = NativeAdSetting.DEFAULT_IMPRESSION_TIME;
        public Integer end_impression_time = NativeAdSetting.DEFAULT_END_IMPRESSION_TIME;
        public Integer req_interval_time = NativeAdSetting.DEFAULT_REQ_INTERVAL_TIME;
        public Integer ad_pool_size = NativeAdSetting.DEFAULT_AD_POOL_SIZE;
        public Integer media_expected_floor = NativeAdSetting.DEFAULT_MEDIA_EXPECTED_FLOOR;
        public Integer log_interval_time = NativeAdSetting.DEFAULT_LOG_INTERVAL_TIME;
        public Boolean enable_advanced_interaction = NativeAdSetting.DEFAULT_ENABLE_ADVANCED_INTERACTION;

        public Builder ad_pool_size(Integer ad_pool_size) {
            this.ad_pool_size = ad_pool_size;
            return this;
        }

        public NativeAdSetting build() {
            return new NativeAdSetting(this.video_auto_play, this.preview_page_video_mute, this.detail_page_video_mute, this.impression_percent, this.impression_time, this.end_impression_time, this.req_interval_time, this.ad_pool_size, this.media_expected_floor, this.log_interval_time, this.enable_advanced_interaction, super.buildUnknownFields());
        }

        public Builder detail_page_video_mute(Integer detail_page_video_mute) {
            this.detail_page_video_mute = detail_page_video_mute;
            return this;
        }

        public Builder enable_advanced_interaction(Boolean enable_advanced_interaction) {
            this.enable_advanced_interaction = enable_advanced_interaction;
            return this;
        }

        public Builder end_impression_time(Integer end_impression_time) {
            this.end_impression_time = end_impression_time;
            return this;
        }

        public Builder impression_percent(Integer impression_percent) {
            this.impression_percent = impression_percent;
            return this;
        }

        public Builder impression_time(Integer impression_time) {
            this.impression_time = impression_time;
            return this;
        }

        public Builder log_interval_time(Integer log_interval_time) {
            this.log_interval_time = log_interval_time;
            return this;
        }

        public Builder media_expected_floor(Integer media_expected_floor) {
            this.media_expected_floor = media_expected_floor;
            return this;
        }

        public Builder preview_page_video_mute(Integer preview_page_video_mute) {
            this.preview_page_video_mute = preview_page_video_mute;
            return this;
        }

        public Builder req_interval_time(Integer req_interval_time) {
            this.req_interval_time = req_interval_time;
            return this;
        }

        public Builder video_auto_play(Integer video_auto_play) {
            this.video_auto_play = video_auto_play;
            return this;
        }
    }

    private static final class ProtoAdapter_NativeAdSetting extends ProtoAdapter<NativeAdSetting> {
        public ProtoAdapter_NativeAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, NativeAdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public NativeAdSetting m1415decode(ProtoReader reader) throws IOException {
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
                        builder.video_auto_play((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 2:
                        builder.preview_page_video_mute((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 3:
                        builder.detail_page_video_mute((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 4:
                        builder.impression_percent((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 5:
                        builder.impression_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 6:
                        builder.end_impression_time((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 7:
                        builder.req_interval_time((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 8:
                        builder.ad_pool_size((Integer) ProtoAdapter.INT32.decode(reader));
                        break;
                    case 9:
                        builder.media_expected_floor((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 10:
                        builder.log_interval_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 11:
                        builder.enable_advanced_interaction((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, NativeAdSetting value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.video_auto_play);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.preview_page_video_mute);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.detail_page_video_mute);
            ProtoAdapter.UINT32.encodeWithTag(writer, 4, value.impression_percent);
            ProtoAdapter.UINT32.encodeWithTag(writer, 5, value.impression_time);
            ProtoAdapter.INT32.encodeWithTag(writer, 6, value.end_impression_time);
            ProtoAdapter.INT32.encodeWithTag(writer, 7, value.req_interval_time);
            ProtoAdapter.INT32.encodeWithTag(writer, 8, value.ad_pool_size);
            ProtoAdapter.UINT32.encodeWithTag(writer, 9, value.media_expected_floor);
            ProtoAdapter.UINT32.encodeWithTag(writer, 10, value.log_interval_time);
            ProtoAdapter.BOOL.encodeWithTag(writer, 11, value.enable_advanced_interaction);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(NativeAdSetting value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.video_auto_play) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.preview_page_video_mute) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.detail_page_video_mute) + ProtoAdapter.UINT32.encodedSizeWithTag(4, value.impression_percent) + ProtoAdapter.UINT32.encodedSizeWithTag(5, value.impression_time) + ProtoAdapter.INT32.encodedSizeWithTag(6, value.end_impression_time) + ProtoAdapter.INT32.encodedSizeWithTag(7, value.req_interval_time) + ProtoAdapter.INT32.encodedSizeWithTag(8, value.ad_pool_size) + ProtoAdapter.UINT32.encodedSizeWithTag(9, value.media_expected_floor) + ProtoAdapter.UINT32.encodedSizeWithTag(10, value.log_interval_time) + ProtoAdapter.BOOL.encodedSizeWithTag(11, value.enable_advanced_interaction) + value.unknownFields().size();
        }

        public NativeAdSetting redact(NativeAdSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_NativeAdSetting protoAdapter_NativeAdSetting = new ProtoAdapter_NativeAdSetting();
        ADAPTER = protoAdapter_NativeAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_NativeAdSetting);
        DEFAULT_VIDEO_AUTO_PLAY = 0;
        DEFAULT_PREVIEW_PAGE_VIDEO_MUTE = 0;
        DEFAULT_DETAIL_PAGE_VIDEO_MUTE = 0;
        DEFAULT_IMPRESSION_PERCENT = 0;
        DEFAULT_IMPRESSION_TIME = 0;
        DEFAULT_END_IMPRESSION_TIME = 0;
        DEFAULT_REQ_INTERVAL_TIME = 0;
        DEFAULT_AD_POOL_SIZE = 0;
        DEFAULT_MEDIA_EXPECTED_FLOOR = 0;
        DEFAULT_LOG_INTERVAL_TIME = 0;
        DEFAULT_ENABLE_ADVANCED_INTERACTION = false;
    }

    public NativeAdSetting(Integer video_auto_play, Integer preview_page_video_mute, Integer detail_page_video_mute, Integer impression_percent, Integer impression_time, Integer end_impression_time, Integer req_interval_time, Integer ad_pool_size, Integer media_expected_floor, Integer log_interval_time, Boolean enable_advanced_interaction) {
        this(video_auto_play, preview_page_video_mute, detail_page_video_mute, impression_percent, impression_time, end_impression_time, req_interval_time, ad_pool_size, media_expected_floor, log_interval_time, enable_advanced_interaction, ByteString.EMPTY);
    }

    public NativeAdSetting(Integer video_auto_play, Integer preview_page_video_mute, Integer detail_page_video_mute, Integer impression_percent, Integer impression_time, Integer end_impression_time, Integer req_interval_time, Integer ad_pool_size, Integer media_expected_floor, Integer log_interval_time, Boolean enable_advanced_interaction, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.video_auto_play = video_auto_play;
        this.preview_page_video_mute = preview_page_video_mute;
        this.detail_page_video_mute = detail_page_video_mute;
        this.impression_percent = impression_percent;
        this.impression_time = impression_time;
        this.end_impression_time = end_impression_time;
        this.req_interval_time = req_interval_time;
        this.ad_pool_size = ad_pool_size;
        this.media_expected_floor = media_expected_floor;
        this.log_interval_time = log_interval_time;
        this.enable_advanced_interaction = enable_advanced_interaction;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof NativeAdSetting)) {
            return false;
        }
        NativeAdSetting nativeAdSetting = (NativeAdSetting) other;
        return unknownFields().equals(nativeAdSetting.unknownFields()) && Internal.equals(this.video_auto_play, nativeAdSetting.video_auto_play) && Internal.equals(this.preview_page_video_mute, nativeAdSetting.preview_page_video_mute) && Internal.equals(this.detail_page_video_mute, nativeAdSetting.detail_page_video_mute) && Internal.equals(this.impression_percent, nativeAdSetting.impression_percent) && Internal.equals(this.impression_time, nativeAdSetting.impression_time) && Internal.equals(this.end_impression_time, nativeAdSetting.end_impression_time) && Internal.equals(this.req_interval_time, nativeAdSetting.req_interval_time) && Internal.equals(this.ad_pool_size, nativeAdSetting.ad_pool_size) && Internal.equals(this.media_expected_floor, nativeAdSetting.media_expected_floor) && Internal.equals(this.log_interval_time, nativeAdSetting.log_interval_time) && Internal.equals(this.enable_advanced_interaction, nativeAdSetting.enable_advanced_interaction);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.video_auto_play;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.preview_page_video_mute;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.detail_page_video_mute;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.impression_percent;
        int iHashCode5 = (iHashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.impression_time;
        int iHashCode6 = (iHashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.end_impression_time;
        int iHashCode7 = (iHashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.req_interval_time;
        int iHashCode8 = (iHashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.ad_pool_size;
        int iHashCode9 = (iHashCode8 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.media_expected_floor;
        int iHashCode10 = (iHashCode9 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.log_interval_time;
        int iHashCode11 = (iHashCode10 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Boolean bool = this.enable_advanced_interaction;
        int iHashCode12 = iHashCode11 + (bool != null ? bool.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode12;
        return iHashCode12;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.video_auto_play = this.video_auto_play;
        builder.preview_page_video_mute = this.preview_page_video_mute;
        builder.detail_page_video_mute = this.detail_page_video_mute;
        builder.impression_percent = this.impression_percent;
        builder.impression_time = this.impression_time;
        builder.end_impression_time = this.end_impression_time;
        builder.req_interval_time = this.req_interval_time;
        builder.ad_pool_size = this.ad_pool_size;
        builder.media_expected_floor = this.media_expected_floor;
        builder.log_interval_time = this.log_interval_time;
        builder.enable_advanced_interaction = this.enable_advanced_interaction;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.video_auto_play != null) {
            sb.append(", video_auto_play=").append(this.video_auto_play);
        }
        if (this.preview_page_video_mute != null) {
            sb.append(", preview_page_video_mute=").append(this.preview_page_video_mute);
        }
        if (this.detail_page_video_mute != null) {
            sb.append(", detail_page_video_mute=").append(this.detail_page_video_mute);
        }
        if (this.impression_percent != null) {
            sb.append(", impression_percent=").append(this.impression_percent);
        }
        if (this.impression_time != null) {
            sb.append(", impression_time=").append(this.impression_time);
        }
        if (this.end_impression_time != null) {
            sb.append(", end_impression_time=").append(this.end_impression_time);
        }
        if (this.req_interval_time != null) {
            sb.append(", req_interval_time=").append(this.req_interval_time);
        }
        if (this.ad_pool_size != null) {
            sb.append(", ad_pool_size=").append(this.ad_pool_size);
        }
        if (this.media_expected_floor != null) {
            sb.append(", media_expected_floor=").append(this.media_expected_floor);
        }
        if (this.log_interval_time != null) {
            sb.append(", log_interval_time=").append(this.log_interval_time);
        }
        if (this.enable_advanced_interaction != null) {
            sb.append(", enable_advanced_interaction=").append(this.enable_advanced_interaction);
        }
        return sb.replace(0, 2, "NativeAdSetting{").append('}').toString();
    }
}
