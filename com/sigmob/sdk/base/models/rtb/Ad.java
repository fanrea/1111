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
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Ad extends AndroidMessage<Ad, Builder> {
    public static final ProtoAdapter<Ad> ADAPTER;
    public static final Parcelable.Creator<Ad> CREATOR;
    public static final String DEFAULT_ADSLOT_ID = "";
    public static final String DEFAULT_AD_SOURCE_CHANNEL = "";
    public static final String DEFAULT_AD_SOURCE_LOGO = "";
    public static final Integer DEFAULT_AD_TYPE;
    public static final String DEFAULT_ATTRIBUTION_ID = "";
    public static final Integer DEFAULT_BID_PRICE;
    public static final Integer DEFAULT_BID_TYPE;
    public static final String DEFAULT_CAMP_ID = "";
    public static final String DEFAULT_CRID = "";
    public static final String DEFAULT_CUST_ID = "";
    public static final Integer DEFAULT_DISPLAY_ORIENTATION;
    public static final Boolean DEFAULT_ENABLE_SMALL_WINDOW;
    public static final Integer DEFAULT_EXPIRED_TIME;
    public static final Boolean DEFAULT_FORBIDEN_PARSE_LANDINGPAGE;
    public static final Integer DEFAULT_IS_OVERRIDE;
    public static final String DEFAULT_PRODUCT_ID = "";
    public static final String DEFAULT_SETTLEMENT_PRICE_ENC = "";
    public static final String DEFAULT_VID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.AdSetting#ADAPTER", tag = 19)
    public final AdSetting ad_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String ad_source_channel;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String ad_source_logo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final Map<String, String> ad_track_macro;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Tracking#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<Tracking> ad_tracking;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 14)
    public final Integer ad_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String adslot_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    public final String attribution_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 8)
    public final Integer bid_price;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer bid_type;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.BiddingResponse#ADAPTER", tag = 29)
    public final BiddingResponse bidding_response;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String camp_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String crid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String cust_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 18)
    public final Integer display_orientation;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 32)
    public final Boolean enable_small_window;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer expired_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean forbiden_parse_landingpage;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.FrequencyControl#ADAPTER", label = WireField.Label.REPEATED, tag = 31)
    public final List<FrequencyControl> frequency_control;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer is_override;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.MaterialMeta#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<MaterialMeta> materials;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 15)
    public final Map<String, String> options;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String product_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String settlement_price_enc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String vid;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.WXProgramRes#ADAPTER", tag = 27)
    public final WXProgramRes wx_program_res;

    public static final class Builder extends Message.Builder<Ad, Builder> {
        public AdSetting ad_setting;
        public BiddingResponse bidding_response;
        public WXProgramRes wx_program_res;
        public String adslot_id = "";
        public String vid = "";
        public String cust_id = "";
        public String camp_id = "";
        public String crid = "";
        public Integer bid_price = Ad.DEFAULT_BID_PRICE;
        public String product_id = "";
        public String settlement_price_enc = "";
        public Integer is_override = Ad.DEFAULT_IS_OVERRIDE;
        public String ad_source_logo = "";
        public String ad_source_channel = "";
        public Integer ad_type = Ad.DEFAULT_AD_TYPE;
        public Integer expired_time = Ad.DEFAULT_EXPIRED_TIME;
        public Boolean forbiden_parse_landingpage = Ad.DEFAULT_FORBIDEN_PARSE_LANDINGPAGE;
        public Integer display_orientation = Ad.DEFAULT_DISPLAY_ORIENTATION;
        public Integer bid_type = Ad.DEFAULT_BID_TYPE;
        public String attribution_id = "";
        public Boolean enable_small_window = Ad.DEFAULT_ENABLE_SMALL_WINDOW;
        public List<MaterialMeta> materials = Internal.newMutableList();
        public List<Tracking> ad_tracking = Internal.newMutableList();
        public Map<String, String> options = Internal.newMutableMap();
        public Map<String, String> ad_track_macro = Internal.newMutableMap();
        public List<FrequencyControl> frequency_control = Internal.newMutableList();

        public Builder ad_setting(AdSetting ad_setting) {
            this.ad_setting = ad_setting;
            return this;
        }

        public Builder ad_source_channel(String ad_source_channel) {
            this.ad_source_channel = ad_source_channel;
            return this;
        }

        public Builder ad_source_logo(String ad_source_logo) {
            this.ad_source_logo = ad_source_logo;
            return this;
        }

        public Builder ad_track_macro(Map<String, String> ad_track_macro) {
            Internal.checkElementsNotNull(ad_track_macro);
            this.ad_track_macro = ad_track_macro;
            return this;
        }

        public Builder ad_tracking(List<Tracking> ad_tracking) {
            Internal.checkElementsNotNull(ad_tracking);
            this.ad_tracking = ad_tracking;
            return this;
        }

        public Builder ad_type(Integer ad_type) {
            this.ad_type = ad_type;
            return this;
        }

        public Builder adslot_id(String adslot_id) {
            this.adslot_id = adslot_id;
            return this;
        }

        public Builder attribution_id(String attribution_id) {
            this.attribution_id = attribution_id;
            return this;
        }

        public Builder bid_price(Integer bid_price) {
            this.bid_price = bid_price;
            return this;
        }

        public Builder bid_type(Integer bid_type) {
            this.bid_type = bid_type;
            return this;
        }

        public Builder bidding_response(BiddingResponse bidding_response) {
            this.bidding_response = bidding_response;
            return this;
        }

        public Ad build() {
            return new Ad(this.adslot_id, this.vid, this.cust_id, this.camp_id, this.crid, this.materials, this.ad_tracking, this.bid_price, this.product_id, this.settlement_price_enc, this.is_override, this.ad_source_logo, this.ad_source_channel, this.ad_type, this.options, this.expired_time, this.forbiden_parse_landingpage, this.display_orientation, this.ad_setting, this.bid_type, this.attribution_id, this.ad_track_macro, this.wx_program_res, this.bidding_response, this.frequency_control, this.enable_small_window, super.buildUnknownFields());
        }

        public Builder camp_id(String camp_id) {
            this.camp_id = camp_id;
            return this;
        }

        public Builder crid(String crid) {
            this.crid = crid;
            return this;
        }

        public Builder cust_id(String cust_id) {
            this.cust_id = cust_id;
            return this;
        }

        public Builder display_orientation(Integer display_orientation) {
            this.display_orientation = display_orientation;
            return this;
        }

        public Builder enable_small_window(Boolean enable_small_window) {
            this.enable_small_window = enable_small_window;
            return this;
        }

        public Builder expired_time(Integer expired_time) {
            this.expired_time = expired_time;
            return this;
        }

        public Builder forbiden_parse_landingpage(Boolean forbiden_parse_landingpage) {
            this.forbiden_parse_landingpage = forbiden_parse_landingpage;
            return this;
        }

        public Builder frequency_control(List<FrequencyControl> frequency_control) {
            Internal.checkElementsNotNull(frequency_control);
            this.frequency_control = frequency_control;
            return this;
        }

        public Builder is_override(Integer is_override) {
            this.is_override = is_override;
            return this;
        }

        public Builder materials(List<MaterialMeta> materials) {
            Internal.checkElementsNotNull(materials);
            this.materials = materials;
            return this;
        }

        public Builder options(Map<String, String> options) {
            Internal.checkElementsNotNull(options);
            this.options = options;
            return this;
        }

        public Builder product_id(String product_id) {
            this.product_id = product_id;
            return this;
        }

        public Builder settlement_price_enc(String settlement_price_enc) {
            this.settlement_price_enc = settlement_price_enc;
            return this;
        }

        public Builder vid(String vid) {
            this.vid = vid;
            return this;
        }

        public Builder wx_program_res(WXProgramRes wx_program_res) {
            this.wx_program_res = wx_program_res;
            return this;
        }
    }

    private static final class ProtoAdapter_Ad extends ProtoAdapter<Ad> {
        private final ProtoAdapter<Map<String, String>> ad_track_macro;
        private final ProtoAdapter<Map<String, String>> options;

        public ProtoAdapter_Ad() {
            super(FieldEncoding.LENGTH_DELIMITED, Ad.class);
            this.options = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
            this.ad_track_macro = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Ad m1376decode(ProtoReader reader) throws IOException {
            Map<String, String> map;
            ProtoAdapter<Map<String, String>> protoAdapter;
            List list;
            AndroidMessage androidMessage;
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 24) {
                    map = builder.ad_track_macro;
                    protoAdapter = this.ad_track_macro;
                } else if (iNextTag == 27) {
                    builder.wx_program_res((WXProgramRes) WXProgramRes.ADAPTER.decode(reader));
                } else if (iNextTag != 29) {
                    if (iNextTag == 31) {
                        list = builder.frequency_control;
                        androidMessage = (FrequencyControl) FrequencyControl.ADAPTER.decode(reader);
                    } else if (iNextTag != 32) {
                        switch (iNextTag) {
                            case 1:
                                builder.adslot_id((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 2:
                                builder.vid((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 3:
                                builder.cust_id((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 4:
                                builder.camp_id((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 5:
                                builder.crid((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 6:
                                list = builder.materials;
                                androidMessage = (MaterialMeta) MaterialMeta.ADAPTER.decode(reader);
                                break;
                            case 7:
                                list = builder.ad_tracking;
                                androidMessage = (Tracking) Tracking.ADAPTER.decode(reader);
                                break;
                            case 8:
                                builder.bid_price((Integer) ProtoAdapter.UINT32.decode(reader));
                                break;
                            case 9:
                                builder.product_id((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 10:
                                builder.settlement_price_enc((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 11:
                                builder.is_override((Integer) ProtoAdapter.UINT32.decode(reader));
                                break;
                            case 12:
                                builder.ad_source_logo((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 13:
                                builder.ad_source_channel((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            case 14:
                                builder.ad_type((Integer) ProtoAdapter.UINT32.decode(reader));
                                break;
                            case 15:
                                map = builder.options;
                                protoAdapter = this.options;
                                break;
                            case 16:
                                builder.expired_time((Integer) ProtoAdapter.UINT32.decode(reader));
                                break;
                            case 17:
                                builder.forbiden_parse_landingpage((Boolean) ProtoAdapter.BOOL.decode(reader));
                                break;
                            case 18:
                                builder.display_orientation((Integer) ProtoAdapter.UINT32.decode(reader));
                                break;
                            case 19:
                                builder.ad_setting((AdSetting) AdSetting.ADAPTER.decode(reader));
                                break;
                            case 20:
                                builder.bid_type((Integer) ProtoAdapter.UINT32.decode(reader));
                                break;
                            case 21:
                                builder.attribution_id((String) ProtoAdapter.STRING.decode(reader));
                                break;
                            default:
                                FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                                builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                                break;
                        }
                    } else {
                        builder.enable_small_window((Boolean) ProtoAdapter.BOOL.decode(reader));
                    }
                    list.add(androidMessage);
                } else {
                    builder.bidding_response((BiddingResponse) BiddingResponse.ADAPTER.decode(reader));
                }
                map.putAll((Map) protoAdapter.decode(reader));
            }
        }

        public void encode(ProtoWriter writer, Ad value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.adslot_id);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.vid);
            ProtoAdapter.STRING.encodeWithTag(writer, 3, value.cust_id);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.camp_id);
            ProtoAdapter.STRING.encodeWithTag(writer, 5, value.crid);
            MaterialMeta.ADAPTER.asRepeated().encodeWithTag(writer, 6, value.materials);
            Tracking.ADAPTER.asRepeated().encodeWithTag(writer, 7, value.ad_tracking);
            ProtoAdapter.UINT32.encodeWithTag(writer, 8, value.bid_price);
            ProtoAdapter.STRING.encodeWithTag(writer, 9, value.product_id);
            ProtoAdapter.STRING.encodeWithTag(writer, 10, value.settlement_price_enc);
            ProtoAdapter.UINT32.encodeWithTag(writer, 11, value.is_override);
            ProtoAdapter.STRING.encodeWithTag(writer, 12, value.ad_source_logo);
            ProtoAdapter.STRING.encodeWithTag(writer, 13, value.ad_source_channel);
            ProtoAdapter.UINT32.encodeWithTag(writer, 14, value.ad_type);
            this.options.encodeWithTag(writer, 15, value.options);
            ProtoAdapter.UINT32.encodeWithTag(writer, 16, value.expired_time);
            ProtoAdapter.BOOL.encodeWithTag(writer, 17, value.forbiden_parse_landingpage);
            ProtoAdapter.UINT32.encodeWithTag(writer, 18, value.display_orientation);
            AdSetting.ADAPTER.encodeWithTag(writer, 19, value.ad_setting);
            ProtoAdapter.UINT32.encodeWithTag(writer, 20, value.bid_type);
            ProtoAdapter.STRING.encodeWithTag(writer, 21, value.attribution_id);
            this.ad_track_macro.encodeWithTag(writer, 24, value.ad_track_macro);
            WXProgramRes.ADAPTER.encodeWithTag(writer, 27, value.wx_program_res);
            BiddingResponse.ADAPTER.encodeWithTag(writer, 29, value.bidding_response);
            FrequencyControl.ADAPTER.asRepeated().encodeWithTag(writer, 31, value.frequency_control);
            ProtoAdapter.BOOL.encodeWithTag(writer, 32, value.enable_small_window);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(Ad value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.adslot_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.vid) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.cust_id) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.camp_id) + ProtoAdapter.STRING.encodedSizeWithTag(5, value.crid) + MaterialMeta.ADAPTER.asRepeated().encodedSizeWithTag(6, value.materials) + Tracking.ADAPTER.asRepeated().encodedSizeWithTag(7, value.ad_tracking) + ProtoAdapter.UINT32.encodedSizeWithTag(8, value.bid_price) + ProtoAdapter.STRING.encodedSizeWithTag(9, value.product_id) + ProtoAdapter.STRING.encodedSizeWithTag(10, value.settlement_price_enc) + ProtoAdapter.UINT32.encodedSizeWithTag(11, value.is_override) + ProtoAdapter.STRING.encodedSizeWithTag(12, value.ad_source_logo) + ProtoAdapter.STRING.encodedSizeWithTag(13, value.ad_source_channel) + ProtoAdapter.UINT32.encodedSizeWithTag(14, value.ad_type) + this.options.encodedSizeWithTag(15, value.options) + ProtoAdapter.UINT32.encodedSizeWithTag(16, value.expired_time) + ProtoAdapter.BOOL.encodedSizeWithTag(17, value.forbiden_parse_landingpage) + ProtoAdapter.UINT32.encodedSizeWithTag(18, value.display_orientation) + AdSetting.ADAPTER.encodedSizeWithTag(19, value.ad_setting) + ProtoAdapter.UINT32.encodedSizeWithTag(20, value.bid_type) + ProtoAdapter.STRING.encodedSizeWithTag(21, value.attribution_id) + this.ad_track_macro.encodedSizeWithTag(24, value.ad_track_macro) + WXProgramRes.ADAPTER.encodedSizeWithTag(27, value.wx_program_res) + BiddingResponse.ADAPTER.encodedSizeWithTag(29, value.bidding_response) + FrequencyControl.ADAPTER.asRepeated().encodedSizeWithTag(31, value.frequency_control) + ProtoAdapter.BOOL.encodedSizeWithTag(32, value.enable_small_window) + value.unknownFields().size();
        }

        public Ad redact(Ad value) {
            Builder builderNewBuilder = value.newBuilder();
            Internal.redactElements(builderNewBuilder.materials, MaterialMeta.ADAPTER);
            Internal.redactElements(builderNewBuilder.ad_tracking, Tracking.ADAPTER);
            if (builderNewBuilder.ad_setting != null) {
                builderNewBuilder.ad_setting = (AdSetting) AdSetting.ADAPTER.redact(builderNewBuilder.ad_setting);
            }
            if (builderNewBuilder.wx_program_res != null) {
                builderNewBuilder.wx_program_res = (WXProgramRes) WXProgramRes.ADAPTER.redact(builderNewBuilder.wx_program_res);
            }
            if (builderNewBuilder.bidding_response != null) {
                builderNewBuilder.bidding_response = (BiddingResponse) BiddingResponse.ADAPTER.redact(builderNewBuilder.bidding_response);
            }
            Internal.redactElements(builderNewBuilder.frequency_control, FrequencyControl.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Ad protoAdapter_Ad = new ProtoAdapter_Ad();
        ADAPTER = protoAdapter_Ad;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Ad);
        DEFAULT_BID_PRICE = 0;
        DEFAULT_IS_OVERRIDE = 0;
        DEFAULT_AD_TYPE = 0;
        DEFAULT_EXPIRED_TIME = 0;
        DEFAULT_FORBIDEN_PARSE_LANDINGPAGE = false;
        DEFAULT_DISPLAY_ORIENTATION = 0;
        DEFAULT_BID_TYPE = 0;
        DEFAULT_ENABLE_SMALL_WINDOW = false;
    }

    public Ad(String adslot_id, String vid, String cust_id, String camp_id, String crid, List<MaterialMeta> materials, List<Tracking> ad_tracking, Integer bid_price, String product_id, String settlement_price_enc, Integer is_override, String ad_source_logo, String ad_source_channel, Integer ad_type, Map<String, String> options, Integer expired_time, Boolean forbiden_parse_landingpage, Integer display_orientation, AdSetting ad_setting, Integer bid_type, String attribution_id, Map<String, String> ad_track_macro, WXProgramRes wx_program_res, BiddingResponse bidding_response, List<FrequencyControl> frequency_control, Boolean enable_small_window) {
        this(adslot_id, vid, cust_id, camp_id, crid, materials, ad_tracking, bid_price, product_id, settlement_price_enc, is_override, ad_source_logo, ad_source_channel, ad_type, options, expired_time, forbiden_parse_landingpage, display_orientation, ad_setting, bid_type, attribution_id, ad_track_macro, wx_program_res, bidding_response, frequency_control, enable_small_window, ByteString.EMPTY);
    }

    public Ad(String adslot_id, String vid, String cust_id, String camp_id, String crid, List<MaterialMeta> materials, List<Tracking> ad_tracking, Integer bid_price, String product_id, String settlement_price_enc, Integer is_override, String ad_source_logo, String ad_source_channel, Integer ad_type, Map<String, String> options, Integer expired_time, Boolean forbiden_parse_landingpage, Integer display_orientation, AdSetting ad_setting, Integer bid_type, String attribution_id, Map<String, String> ad_track_macro, WXProgramRes wx_program_res, BiddingResponse bidding_response, List<FrequencyControl> frequency_control, Boolean enable_small_window, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.adslot_id = adslot_id;
        this.vid = vid;
        this.cust_id = cust_id;
        this.camp_id = camp_id;
        this.crid = crid;
        this.materials = Internal.immutableCopyOf("materials", materials);
        this.ad_tracking = Internal.immutableCopyOf("ad_tracking", ad_tracking);
        this.bid_price = bid_price;
        this.product_id = product_id;
        this.settlement_price_enc = settlement_price_enc;
        this.is_override = is_override;
        this.ad_source_logo = ad_source_logo;
        this.ad_source_channel = ad_source_channel;
        this.ad_type = ad_type;
        this.options = Internal.immutableCopyOf("options", options);
        this.expired_time = expired_time;
        this.forbiden_parse_landingpage = forbiden_parse_landingpage;
        this.display_orientation = display_orientation;
        this.ad_setting = ad_setting;
        this.bid_type = bid_type;
        this.attribution_id = attribution_id;
        this.ad_track_macro = Internal.immutableCopyOf("ad_track_macro", ad_track_macro);
        this.wx_program_res = wx_program_res;
        this.bidding_response = bidding_response;
        this.frequency_control = Internal.immutableCopyOf("frequency_control", frequency_control);
        this.enable_small_window = enable_small_window;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Ad)) {
            return false;
        }
        Ad ad = (Ad) other;
        return unknownFields().equals(ad.unknownFields()) && Internal.equals(this.adslot_id, ad.adslot_id) && Internal.equals(this.vid, ad.vid) && Internal.equals(this.cust_id, ad.cust_id) && Internal.equals(this.camp_id, ad.camp_id) && Internal.equals(this.crid, ad.crid) && this.materials.equals(ad.materials) && this.ad_tracking.equals(ad.ad_tracking) && Internal.equals(this.bid_price, ad.bid_price) && Internal.equals(this.product_id, ad.product_id) && Internal.equals(this.settlement_price_enc, ad.settlement_price_enc) && Internal.equals(this.is_override, ad.is_override) && Internal.equals(this.ad_source_logo, ad.ad_source_logo) && Internal.equals(this.ad_source_channel, ad.ad_source_channel) && Internal.equals(this.ad_type, ad.ad_type) && this.options.equals(ad.options) && Internal.equals(this.expired_time, ad.expired_time) && Internal.equals(this.forbiden_parse_landingpage, ad.forbiden_parse_landingpage) && Internal.equals(this.display_orientation, ad.display_orientation) && Internal.equals(this.ad_setting, ad.ad_setting) && Internal.equals(this.bid_type, ad.bid_type) && Internal.equals(this.attribution_id, ad.attribution_id) && this.ad_track_macro.equals(ad.ad_track_macro) && Internal.equals(this.wx_program_res, ad.wx_program_res) && Internal.equals(this.bidding_response, ad.bidding_response) && this.frequency_control.equals(ad.frequency_control) && Internal.equals(this.enable_small_window, ad.enable_small_window);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.adslot_id;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.vid;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cust_id;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.camp_id;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.crid;
        int iHashCode6 = (((((iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37) + this.materials.hashCode()) * 37) + this.ad_tracking.hashCode()) * 37;
        Integer num = this.bid_price;
        int iHashCode7 = (iHashCode6 + (num != null ? num.hashCode() : 0)) * 37;
        String str6 = this.product_id;
        int iHashCode8 = (iHashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.settlement_price_enc;
        int iHashCode9 = (iHashCode8 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num2 = this.is_override;
        int iHashCode10 = (iHashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str8 = this.ad_source_logo;
        int iHashCode11 = (iHashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.ad_source_channel;
        int iHashCode12 = (iHashCode11 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Integer num3 = this.ad_type;
        int iHashCode13 = (((iHashCode12 + (num3 != null ? num3.hashCode() : 0)) * 37) + this.options.hashCode()) * 37;
        Integer num4 = this.expired_time;
        int iHashCode14 = (iHashCode13 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool = this.forbiden_parse_landingpage;
        int iHashCode15 = (iHashCode14 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num5 = this.display_orientation;
        int iHashCode16 = (iHashCode15 + (num5 != null ? num5.hashCode() : 0)) * 37;
        AdSetting adSetting = this.ad_setting;
        int iHashCode17 = (iHashCode16 + (adSetting != null ? adSetting.hashCode() : 0)) * 37;
        Integer num6 = this.bid_type;
        int iHashCode18 = (iHashCode17 + (num6 != null ? num6.hashCode() : 0)) * 37;
        String str10 = this.attribution_id;
        int iHashCode19 = (((iHashCode18 + (str10 != null ? str10.hashCode() : 0)) * 37) + this.ad_track_macro.hashCode()) * 37;
        WXProgramRes wXProgramRes = this.wx_program_res;
        int iHashCode20 = (iHashCode19 + (wXProgramRes != null ? wXProgramRes.hashCode() : 0)) * 37;
        BiddingResponse biddingResponse = this.bidding_response;
        int iHashCode21 = (((iHashCode20 + (biddingResponse != null ? biddingResponse.hashCode() : 0)) * 37) + this.frequency_control.hashCode()) * 37;
        Boolean bool2 = this.enable_small_window;
        int iHashCode22 = iHashCode21 + (bool2 != null ? bool2.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode22;
        return iHashCode22;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.adslot_id = this.adslot_id;
        builder.vid = this.vid;
        builder.cust_id = this.cust_id;
        builder.camp_id = this.camp_id;
        builder.crid = this.crid;
        builder.materials = Internal.copyOf("materials", this.materials);
        builder.ad_tracking = Internal.copyOf("ad_tracking", this.ad_tracking);
        builder.bid_price = this.bid_price;
        builder.product_id = this.product_id;
        builder.settlement_price_enc = this.settlement_price_enc;
        builder.is_override = this.is_override;
        builder.ad_source_logo = this.ad_source_logo;
        builder.ad_source_channel = this.ad_source_channel;
        builder.ad_type = this.ad_type;
        builder.options = Internal.copyOf("options", this.options);
        builder.expired_time = this.expired_time;
        builder.forbiden_parse_landingpage = this.forbiden_parse_landingpage;
        builder.display_orientation = this.display_orientation;
        builder.ad_setting = this.ad_setting;
        builder.bid_type = this.bid_type;
        builder.attribution_id = this.attribution_id;
        builder.ad_track_macro = Internal.copyOf("ad_track_macro", this.ad_track_macro);
        builder.wx_program_res = this.wx_program_res;
        builder.bidding_response = this.bidding_response;
        builder.frequency_control = Internal.copyOf("frequency_control", this.frequency_control);
        builder.enable_small_window = this.enable_small_window;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.adslot_id != null) {
            sb.append(", adslot_id=").append(this.adslot_id);
        }
        if (this.vid != null) {
            sb.append(", vid=").append(this.vid);
        }
        if (this.cust_id != null) {
            sb.append(", cust_id=").append(this.cust_id);
        }
        if (this.camp_id != null) {
            sb.append(", camp_id=").append(this.camp_id);
        }
        if (this.crid != null) {
            sb.append(", crid=").append(this.crid);
        }
        if (!this.materials.isEmpty()) {
            sb.append(", materials=").append(this.materials);
        }
        if (!this.ad_tracking.isEmpty()) {
            sb.append(", ad_tracking=").append(this.ad_tracking);
        }
        if (this.bid_price != null) {
            sb.append(", bid_price=").append(this.bid_price);
        }
        if (this.product_id != null) {
            sb.append(", product_id=").append(this.product_id);
        }
        if (this.settlement_price_enc != null) {
            sb.append(", settlement_price_enc=").append(this.settlement_price_enc);
        }
        if (this.is_override != null) {
            sb.append(", is_override=").append(this.is_override);
        }
        if (this.ad_source_logo != null) {
            sb.append(", ad_source_logo=").append(this.ad_source_logo);
        }
        if (this.ad_source_channel != null) {
            sb.append(", ad_source_channel=").append(this.ad_source_channel);
        }
        if (this.ad_type != null) {
            sb.append(", ad_type=").append(this.ad_type);
        }
        if (!this.options.isEmpty()) {
            sb.append(", options=").append(this.options);
        }
        if (this.expired_time != null) {
            sb.append(", expired_time=").append(this.expired_time);
        }
        if (this.forbiden_parse_landingpage != null) {
            sb.append(", forbiden_parse_landingpage=").append(this.forbiden_parse_landingpage);
        }
        if (this.display_orientation != null) {
            sb.append(", display_orientation=").append(this.display_orientation);
        }
        if (this.ad_setting != null) {
            sb.append(", ad_setting=").append(this.ad_setting);
        }
        if (this.bid_type != null) {
            sb.append(", bid_type=").append(this.bid_type);
        }
        if (this.attribution_id != null) {
            sb.append(", attribution_id=").append(this.attribution_id);
        }
        if (!this.ad_track_macro.isEmpty()) {
            sb.append(", ad_track_macro=").append(this.ad_track_macro);
        }
        if (this.wx_program_res != null) {
            sb.append(", wx_program_res=").append(this.wx_program_res);
        }
        if (this.bidding_response != null) {
            sb.append(", bidding_response=").append(this.bidding_response);
        }
        if (!this.frequency_control.isEmpty()) {
            sb.append(", frequency_control=").append(this.frequency_control);
        }
        if (this.enable_small_window != null) {
            sb.append(", enable_small_window=").append(this.enable_small_window);
        }
        return sb.replace(0, 2, "Ad{").append('}').toString();
    }
}
