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
public final class BidResponse extends AndroidMessage<BidResponse, Builder> {
    public static final ProtoAdapter<BidResponse> ADAPTER;
    public static final Parcelable.Creator<BidResponse> CREATOR;
    public static final String DEFAULT_ADX_ID = "";
    public static final String DEFAULT_AD_UA = "";
    public static final Long DEFAULT_ERROR_CODE;
    public static final String DEFAULT_ERROR_MESSAGE = "";
    public static final Integer DEFAULT_EXPIRATION_TIME;
    public static final Boolean DEFAULT_NONCOMPLIANCE_MARK;
    public static final Integer DEFAULT_PCTR_VALID_CHECK;
    public static final String DEFAULT_PCTR_VERSION = "";
    public static final Long DEFAULT_PROCESS_TIME_MS_DSP;
    public static final Long DEFAULT_PROCESS_TIME_MS_SSP;
    public static final String DEFAULT_REQUEST_ID = "";
    public static final String DEFAULT_RV_CALLBACK_URL = "";
    public static final String DEFAULT_UID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String ad_ua;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Ad#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<Ad> ads;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String adx_id;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.BiddingResponse#ADAPTER", tag = 14)
    public final BiddingResponse bidding_response;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 3)
    public final Long error_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String error_message;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer expiration_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean noncompliance_mark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer pctr_valid_check;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String pctr_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 4)
    public final Long process_time_ms_dsp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 5)
    public final Long process_time_ms_ssp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String request_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final String rv_callback_url;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Template#ADAPTER", tag = 13)
    public final Template scene;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SlotAdSetting#ADAPTER", tag = 11)
    public final SlotAdSetting slot_ad_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String uid;

    public static final class Builder extends Message.Builder<BidResponse, Builder> {
        public String ad_ua;
        public List<Ad> ads = Internal.newMutableList();
        public String adx_id;
        public BiddingResponse bidding_response;
        public Long error_code;
        public String error_message;
        public Integer expiration_time;
        public Boolean noncompliance_mark;
        public Integer pctr_valid_check;
        public String pctr_version;
        public Long process_time_ms_dsp;
        public Long process_time_ms_ssp;
        public String request_id;
        public String rv_callback_url;
        public Template scene;
        public SlotAdSetting slot_ad_setting;
        public String uid;

        public Builder ad_ua(String ad_ua) {
            this.ad_ua = ad_ua;
            return this;
        }

        public Builder ads(List<Ad> ads) {
            Internal.checkElementsNotNull(ads);
            this.ads = ads;
            return this;
        }

        public Builder adx_id(String adx_id) {
            this.adx_id = adx_id;
            return this;
        }

        public Builder bidding_response(BiddingResponse bidding_response) {
            this.bidding_response = bidding_response;
            return this;
        }

        public BidResponse build() {
            return new BidResponse(this.request_id, this.ads, this.error_code, this.process_time_ms_dsp, this.process_time_ms_ssp, this.pctr_valid_check, this.pctr_version, this.uid, this.expiration_time, this.ad_ua, this.slot_ad_setting, this.error_message, this.scene, this.bidding_response, this.rv_callback_url, this.adx_id, this.noncompliance_mark, super.buildUnknownFields());
        }

        public Builder error_code(Long error_code) {
            this.error_code = error_code;
            return this;
        }

        public Builder error_message(String error_message) {
            this.error_message = error_message;
            return this;
        }

        public Builder expiration_time(Integer expiration_time) {
            this.expiration_time = expiration_time;
            return this;
        }

        public Builder noncompliance_mark(Boolean noncompliance_mark) {
            this.noncompliance_mark = noncompliance_mark;
            return this;
        }

        public Builder pctr_valid_check(Integer pctr_valid_check) {
            this.pctr_valid_check = pctr_valid_check;
            return this;
        }

        public Builder pctr_version(String pctr_version) {
            this.pctr_version = pctr_version;
            return this;
        }

        public Builder process_time_ms_dsp(Long process_time_ms_dsp) {
            this.process_time_ms_dsp = process_time_ms_dsp;
            return this;
        }

        public Builder process_time_ms_ssp(Long process_time_ms_ssp) {
            this.process_time_ms_ssp = process_time_ms_ssp;
            return this;
        }

        public Builder request_id(String request_id) {
            this.request_id = request_id;
            return this;
        }

        public Builder rv_callback_url(String rv_callback_url) {
            this.rv_callback_url = rv_callback_url;
            return this;
        }

        public Builder scene(Template scene) {
            this.scene = scene;
            return this;
        }

        public Builder slot_ad_setting(SlotAdSetting slot_ad_setting) {
            this.slot_ad_setting = slot_ad_setting;
            return this;
        }

        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
    }

    private static final class ProtoAdapter_BidResponse extends ProtoAdapter<BidResponse> {
        public ProtoAdapter_BidResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BidResponse.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BidResponse m1388decode(ProtoReader reader) throws IOException {
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
                        builder.request_id((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 2:
                        builder.ads.add((Ad) Ad.ADAPTER.decode(reader));
                        break;
                    case 3:
                        builder.error_code((Long) ProtoAdapter.UINT64.decode(reader));
                        break;
                    case 4:
                        builder.process_time_ms_dsp((Long) ProtoAdapter.UINT64.decode(reader));
                        break;
                    case 5:
                        builder.process_time_ms_ssp((Long) ProtoAdapter.UINT64.decode(reader));
                        break;
                    case 6:
                        builder.pctr_valid_check((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 7:
                        builder.pctr_version((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 8:
                        builder.uid((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 9:
                        builder.expiration_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 10:
                        builder.ad_ua((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 11:
                        builder.slot_ad_setting((SlotAdSetting) SlotAdSetting.ADAPTER.decode(reader));
                        break;
                    case 12:
                        builder.error_message((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 13:
                        builder.scene((Template) Template.ADAPTER.decode(reader));
                        break;
                    case 14:
                        builder.bidding_response((BiddingResponse) BiddingResponse.ADAPTER.decode(reader));
                        break;
                    case 15:
                        builder.rv_callback_url((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 16:
                        builder.adx_id((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 17:
                        builder.noncompliance_mark((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, BidResponse value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.request_id);
            Ad.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.ads);
            ProtoAdapter.UINT64.encodeWithTag(writer, 3, value.error_code);
            ProtoAdapter.UINT64.encodeWithTag(writer, 4, value.process_time_ms_dsp);
            ProtoAdapter.UINT64.encodeWithTag(writer, 5, value.process_time_ms_ssp);
            ProtoAdapter.UINT32.encodeWithTag(writer, 6, value.pctr_valid_check);
            ProtoAdapter.STRING.encodeWithTag(writer, 7, value.pctr_version);
            ProtoAdapter.STRING.encodeWithTag(writer, 8, value.uid);
            ProtoAdapter.UINT32.encodeWithTag(writer, 9, value.expiration_time);
            ProtoAdapter.STRING.encodeWithTag(writer, 10, value.ad_ua);
            SlotAdSetting.ADAPTER.encodeWithTag(writer, 11, value.slot_ad_setting);
            ProtoAdapter.STRING.encodeWithTag(writer, 12, value.error_message);
            Template.ADAPTER.encodeWithTag(writer, 13, value.scene);
            BiddingResponse.ADAPTER.encodeWithTag(writer, 14, value.bidding_response);
            ProtoAdapter.STRING.encodeWithTag(writer, 15, value.rv_callback_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 16, value.adx_id);
            ProtoAdapter.BOOL.encodeWithTag(writer, 17, value.noncompliance_mark);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(BidResponse value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.request_id) + Ad.ADAPTER.asRepeated().encodedSizeWithTag(2, value.ads) + ProtoAdapter.UINT64.encodedSizeWithTag(3, value.error_code) + ProtoAdapter.UINT64.encodedSizeWithTag(4, value.process_time_ms_dsp) + ProtoAdapter.UINT64.encodedSizeWithTag(5, value.process_time_ms_ssp) + ProtoAdapter.UINT32.encodedSizeWithTag(6, value.pctr_valid_check) + ProtoAdapter.STRING.encodedSizeWithTag(7, value.pctr_version) + ProtoAdapter.STRING.encodedSizeWithTag(8, value.uid) + ProtoAdapter.UINT32.encodedSizeWithTag(9, value.expiration_time) + ProtoAdapter.STRING.encodedSizeWithTag(10, value.ad_ua) + SlotAdSetting.ADAPTER.encodedSizeWithTag(11, value.slot_ad_setting) + ProtoAdapter.STRING.encodedSizeWithTag(12, value.error_message) + Template.ADAPTER.encodedSizeWithTag(13, value.scene) + BiddingResponse.ADAPTER.encodedSizeWithTag(14, value.bidding_response) + ProtoAdapter.STRING.encodedSizeWithTag(15, value.rv_callback_url) + ProtoAdapter.STRING.encodedSizeWithTag(16, value.adx_id) + ProtoAdapter.BOOL.encodedSizeWithTag(17, value.noncompliance_mark) + value.unknownFields().size();
        }

        public BidResponse redact(BidResponse value) {
            Builder builderNewBuilder = value.newBuilder();
            Internal.redactElements(builderNewBuilder.ads, Ad.ADAPTER);
            if (builderNewBuilder.slot_ad_setting != null) {
                builderNewBuilder.slot_ad_setting = (SlotAdSetting) SlotAdSetting.ADAPTER.redact(builderNewBuilder.slot_ad_setting);
            }
            if (builderNewBuilder.scene != null) {
                builderNewBuilder.scene = (Template) Template.ADAPTER.redact(builderNewBuilder.scene);
            }
            if (builderNewBuilder.bidding_response != null) {
                builderNewBuilder.bidding_response = (BiddingResponse) BiddingResponse.ADAPTER.redact(builderNewBuilder.bidding_response);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_BidResponse protoAdapter_BidResponse = new ProtoAdapter_BidResponse();
        ADAPTER = protoAdapter_BidResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BidResponse);
        DEFAULT_ERROR_CODE = 0L;
        DEFAULT_PROCESS_TIME_MS_DSP = 0L;
        DEFAULT_PROCESS_TIME_MS_SSP = 0L;
        DEFAULT_PCTR_VALID_CHECK = 0;
        DEFAULT_EXPIRATION_TIME = 0;
        DEFAULT_NONCOMPLIANCE_MARK = false;
    }

    public BidResponse(String request_id, List<Ad> ads, Long error_code, Long process_time_ms_dsp, Long process_time_ms_ssp, Integer pctr_valid_check, String pctr_version, String uid, Integer expiration_time, String ad_ua, SlotAdSetting slot_ad_setting, String error_message, Template scene, BiddingResponse bidding_response, String rv_callback_url, String adx_id, Boolean noncompliance_mark) {
        this(request_id, ads, error_code, process_time_ms_dsp, process_time_ms_ssp, pctr_valid_check, pctr_version, uid, expiration_time, ad_ua, slot_ad_setting, error_message, scene, bidding_response, rv_callback_url, adx_id, noncompliance_mark, ByteString.EMPTY);
    }

    public BidResponse(String request_id, List<Ad> ads, Long error_code, Long process_time_ms_dsp, Long process_time_ms_ssp, Integer pctr_valid_check, String pctr_version, String uid, Integer expiration_time, String ad_ua, SlotAdSetting slot_ad_setting, String error_message, Template scene, BiddingResponse bidding_response, String rv_callback_url, String adx_id, Boolean noncompliance_mark, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.request_id = request_id;
        this.ads = Internal.immutableCopyOf("ads", ads);
        this.error_code = error_code;
        this.process_time_ms_dsp = process_time_ms_dsp;
        this.process_time_ms_ssp = process_time_ms_ssp;
        this.pctr_valid_check = pctr_valid_check;
        this.pctr_version = pctr_version;
        this.uid = uid;
        this.expiration_time = expiration_time;
        this.ad_ua = ad_ua;
        this.slot_ad_setting = slot_ad_setting;
        this.error_message = error_message;
        this.scene = scene;
        this.bidding_response = bidding_response;
        this.rv_callback_url = rv_callback_url;
        this.adx_id = adx_id;
        this.noncompliance_mark = noncompliance_mark;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof BidResponse)) {
            return false;
        }
        BidResponse bidResponse = (BidResponse) other;
        return unknownFields().equals(bidResponse.unknownFields()) && Internal.equals(this.request_id, bidResponse.request_id) && this.ads.equals(bidResponse.ads) && Internal.equals(this.error_code, bidResponse.error_code) && Internal.equals(this.process_time_ms_dsp, bidResponse.process_time_ms_dsp) && Internal.equals(this.process_time_ms_ssp, bidResponse.process_time_ms_ssp) && Internal.equals(this.pctr_valid_check, bidResponse.pctr_valid_check) && Internal.equals(this.pctr_version, bidResponse.pctr_version) && Internal.equals(this.uid, bidResponse.uid) && Internal.equals(this.expiration_time, bidResponse.expiration_time) && Internal.equals(this.ad_ua, bidResponse.ad_ua) && Internal.equals(this.slot_ad_setting, bidResponse.slot_ad_setting) && Internal.equals(this.error_message, bidResponse.error_message) && Internal.equals(this.scene, bidResponse.scene) && Internal.equals(this.bidding_response, bidResponse.bidding_response) && Internal.equals(this.rv_callback_url, bidResponse.rv_callback_url) && Internal.equals(this.adx_id, bidResponse.adx_id) && Internal.equals(this.noncompliance_mark, bidResponse.noncompliance_mark);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.request_id;
        int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 37) + this.ads.hashCode()) * 37;
        Long l = this.error_code;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.process_time_ms_dsp;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.process_time_ms_ssp;
        int iHashCode5 = (iHashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num = this.pctr_valid_check;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.pctr_version;
        int iHashCode7 = (iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.uid;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.expiration_time;
        int iHashCode9 = (iHashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.ad_ua;
        int iHashCode10 = (iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        SlotAdSetting slotAdSetting = this.slot_ad_setting;
        int iHashCode11 = (iHashCode10 + (slotAdSetting != null ? slotAdSetting.hashCode() : 0)) * 37;
        String str5 = this.error_message;
        int iHashCode12 = (iHashCode11 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Template template = this.scene;
        int iHashCode13 = (iHashCode12 + (template != null ? template.hashCode() : 0)) * 37;
        BiddingResponse biddingResponse = this.bidding_response;
        int iHashCode14 = (iHashCode13 + (biddingResponse != null ? biddingResponse.hashCode() : 0)) * 37;
        String str6 = this.rv_callback_url;
        int iHashCode15 = (iHashCode14 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.adx_id;
        int iHashCode16 = (iHashCode15 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool = this.noncompliance_mark;
        int iHashCode17 = iHashCode16 + (bool != null ? bool.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode17;
        return iHashCode17;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.request_id = this.request_id;
        builder.ads = Internal.copyOf("ads", this.ads);
        builder.error_code = this.error_code;
        builder.process_time_ms_dsp = this.process_time_ms_dsp;
        builder.process_time_ms_ssp = this.process_time_ms_ssp;
        builder.pctr_valid_check = this.pctr_valid_check;
        builder.pctr_version = this.pctr_version;
        builder.uid = this.uid;
        builder.expiration_time = this.expiration_time;
        builder.ad_ua = this.ad_ua;
        builder.slot_ad_setting = this.slot_ad_setting;
        builder.error_message = this.error_message;
        builder.scene = this.scene;
        builder.bidding_response = this.bidding_response;
        builder.rv_callback_url = this.rv_callback_url;
        builder.adx_id = this.adx_id;
        builder.noncompliance_mark = this.noncompliance_mark;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.request_id != null) {
            sb.append(", request_id=").append(this.request_id);
        }
        if (!this.ads.isEmpty()) {
            sb.append(", ads=").append(this.ads);
        }
        if (this.error_code != null) {
            sb.append(", error_code=").append(this.error_code);
        }
        if (this.process_time_ms_dsp != null) {
            sb.append(", process_time_ms_dsp=").append(this.process_time_ms_dsp);
        }
        if (this.process_time_ms_ssp != null) {
            sb.append(", process_time_ms_ssp=").append(this.process_time_ms_ssp);
        }
        if (this.pctr_valid_check != null) {
            sb.append(", pctr_valid_check=").append(this.pctr_valid_check);
        }
        if (this.pctr_version != null) {
            sb.append(", pctr_version=").append(this.pctr_version);
        }
        if (this.uid != null) {
            sb.append(", uid=").append(this.uid);
        }
        if (this.expiration_time != null) {
            sb.append(", expiration_time=").append(this.expiration_time);
        }
        if (this.ad_ua != null) {
            sb.append(", ad_ua=").append(this.ad_ua);
        }
        if (this.slot_ad_setting != null) {
            sb.append(", slot_ad_setting=").append(this.slot_ad_setting);
        }
        if (this.error_message != null) {
            sb.append(", error_message=").append(this.error_message);
        }
        if (this.scene != null) {
            sb.append(", scene=").append(this.scene);
        }
        if (this.bidding_response != null) {
            sb.append(", bidding_response=").append(this.bidding_response);
        }
        if (this.rv_callback_url != null) {
            sb.append(", rv_callback_url=").append(this.rv_callback_url);
        }
        if (this.adx_id != null) {
            sb.append(", adx_id=").append(this.adx_id);
        }
        if (this.noncompliance_mark != null) {
            sb.append(", noncompliance_mark=").append(this.noncompliance_mark);
        }
        return sb.replace(0, 2, "BidResponse{").append('}').toString();
    }
}
