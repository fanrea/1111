package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import com.czhj.sdk.common.models.Size;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.models.WebEventHandle;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class MaterialMeta extends AndroidMessage<MaterialMeta, Builder> {
    public static final ProtoAdapter<MaterialMeta> ADAPTER;
    public static final Parcelable.Creator<MaterialMeta> CREATOR;
    public static final String DEFAULT_APK_MD5 = "";
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_BUTTON_TEXT = "";
    public static final Integer DEFAULT_CLICK_TYPE;
    public static final ByteString DEFAULT_CLOSECARD_HTML_SNIPPET;
    public static final String DEFAULT_CREATIVE_TITLE = "";
    public static final Integer DEFAULT_CREATIVE_TYPE;
    public static final String DEFAULT_DEEPLINK_URL = "";
    public static final String DEFAULT_DESC = "";
    public static final Boolean DEFAULT_DISABLE_AUTO_DEEPLINK;
    public static final Boolean DEFAULT_DOWNLOAD_DIALOG;
    public static final Boolean DEFAULT_ENABLE_COLLAPSE_TOOL_BAR;
    public static final String DEFAULT_ENDCARD_IMAGE_SRC = "";
    public static final String DEFAULT_ENDCARD_MD5 = "";
    public static final String DEFAULT_ENDCARD_URL = "";
    public static final Boolean DEFAULT_HAS_COMPANION_ENDCARD;
    public static final Boolean DEFAULT_HAS_ENDCARD;
    public static final ByteString DEFAULT_HTML_SNIPPET;
    public static final String DEFAULT_HTML_SRC = "";
    public static final String DEFAULT_HTML_URL = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_IMAGE_MD5 = "";
    public static final String DEFAULT_IMAGE_SRC = "";
    public static final Integer DEFAULT_IMAGE_TYPE;
    public static final Integer DEFAULT_INTERACTION_TYPE;
    public static final Boolean DEFAULT_IN_APP;
    public static final String DEFAULT_LANDING_PAGE = "";
    public static final Integer DEFAULT_OPEN_MARKET_MODE;
    public static final Integer DEFAULT_PLAY_MODE;
    public static final Float DEFAULT_SCORE;
    public static final Integer DEFAULT_SUB_INTERACTION_TYPE;
    public static final Integer DEFAULT_TEMPLATE_ID;
    public static final Integer DEFAULT_TEMPLATE_TYPE;
    public static final Integer DEFAULT_THEME_DATA;
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_VIDEO_BYTE_SIZE;
    public static final Integer DEFAULT_VIDEO_DURATION;
    public static final String DEFAULT_VIDEO_MD5 = "";
    public static final Integer DEFAULT_VIDEO_RECIPROCAL_MILLISECOND;
    public static final String DEFAULT_VIDEO_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Widget#ADAPTER", label = WireField.Label.REPEATED, tag = 51)
    public final List<Widget> Widget_list;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.AdPrivacy#ADAPTER", tag = 36)
    public final AdPrivacy ad_privacy;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.AndroidMarket#ADAPTER", tag = 41)
    public AndroidMarket android_market;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 52)
    public final String apk_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 34)
    public final String app_name;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.ResponseAsset#ADAPTER", label = WireField.Label.REPEATED, tag = 44)
    public final List<ResponseAsset> asset;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Color#ADAPTER", tag = 50)
    public final Color button_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 35)
    public final String button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer click_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 33)
    public final ByteString closecard_html_snippet;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.CompanionEndcard#ADAPTER", tag = 18)
    public final CompanionEndcard companion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 48)
    public final String creative_title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer creative_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String deeplink_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 28)
    public final String desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 32)
    public final Boolean disable_auto_deeplink;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 40)
    public final Boolean download_dialog;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 23)
    public final Boolean enable_collapse_tool_bar;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 47)
    public final String endcard_image_src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String endcard_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String endcard_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean has_companion_endcard;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 49)
    public final Boolean has_endcard;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 7)
    public final ByteString html_snippet;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 38)
    public final String html_src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 22)
    public final String html_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 29)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String image_md5;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 13)
    public final Size image_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String image_src;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer image_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 46)
    public final Boolean in_app;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer interaction_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String landing_page;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Template#ADAPTER", tag = 42)
    public final Template main_template;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.ResponseNativeAd#ADAPTER", tag = 39)
    public final ResponseNativeAd native_ad;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 24)
    public final Integer open_market_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 25)
    public final Integer play_mode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 30)
    public final Float score;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 26)
    public final Integer sub_interaction_type;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.Template#ADAPTER", tag = 43)
    public final Template sub_template;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 31)
    public final Integer template_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer template_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 45)
    public final Integer theme_data;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    public final String title;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 37)
    public final Integer video_byte_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 5)
    public final Integer video_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String video_md5;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 21)
    public final Integer video_reciprocal_millisecond;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 6)
    public final Size video_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String video_url;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.WebEventHandle#ADAPTER", tag = 19)
    public final WebEventHandle web_event_handle;

    public static final class Builder extends Message.Builder<MaterialMeta, Builder> {
        public AdPrivacy ad_privacy;
        public AndroidMarket android_market;
        public String apk_md5;
        public Color button_color;
        public CompanionEndcard companion;
        public Size image_size;
        public Template main_template;
        public ResponseNativeAd native_ad;
        public Template sub_template;
        public Size video_size;
        public WebEventHandle web_event_handle;
        public Integer creative_type = MaterialMeta.DEFAULT_CREATIVE_TYPE;
        public Integer interaction_type = MaterialMeta.DEFAULT_INTERACTION_TYPE;
        public String landing_page = "";
        public String video_url = "";
        public Integer video_duration = MaterialMeta.DEFAULT_VIDEO_DURATION;
        public ByteString html_snippet = MaterialMeta.DEFAULT_HTML_SNIPPET;
        public String endcard_url = "";
        public String video_md5 = "";
        public String endcard_md5 = "";
        public String deeplink_url = "";
        public String image_src = "";
        public String image_md5 = "";
        public Integer image_type = MaterialMeta.DEFAULT_IMAGE_TYPE;
        public Integer click_type = MaterialMeta.DEFAULT_CLICK_TYPE;
        public Boolean has_companion_endcard = MaterialMeta.DEFAULT_HAS_COMPANION_ENDCARD;
        public Integer template_type = MaterialMeta.DEFAULT_TEMPLATE_TYPE;
        public Integer video_reciprocal_millisecond = MaterialMeta.DEFAULT_VIDEO_RECIPROCAL_MILLISECOND;
        public String html_url = "";
        public Boolean enable_collapse_tool_bar = MaterialMeta.DEFAULT_ENABLE_COLLAPSE_TOOL_BAR;
        public Integer open_market_mode = MaterialMeta.DEFAULT_OPEN_MARKET_MODE;
        public Integer play_mode = MaterialMeta.DEFAULT_PLAY_MODE;
        public Integer sub_interaction_type = MaterialMeta.DEFAULT_SUB_INTERACTION_TYPE;
        public String title = "";
        public String desc = "";
        public String icon_url = "";
        public Float score = MaterialMeta.DEFAULT_SCORE;
        public Integer template_id = MaterialMeta.DEFAULT_TEMPLATE_ID;
        public Boolean disable_auto_deeplink = MaterialMeta.DEFAULT_DISABLE_AUTO_DEEPLINK;
        public ByteString closecard_html_snippet = MaterialMeta.DEFAULT_CLOSECARD_HTML_SNIPPET;
        public String app_name = "";
        public String button_text = "";
        public Integer video_byte_size = MaterialMeta.DEFAULT_VIDEO_BYTE_SIZE;
        public String html_src = "";
        public Boolean download_dialog = MaterialMeta.DEFAULT_DOWNLOAD_DIALOG;
        public Integer theme_data = MaterialMeta.DEFAULT_THEME_DATA;
        public Boolean in_app = MaterialMeta.DEFAULT_IN_APP;
        public String endcard_image_src = "";
        public String creative_title = "";
        public Boolean has_endcard = MaterialMeta.DEFAULT_HAS_ENDCARD;
        public List<ResponseAsset> asset = Internal.newMutableList();
        public List<Widget> Widget_list = Internal.newMutableList();

        public Builder Widget_list(List<Widget> Widget_list) {
            Internal.checkElementsNotNull(Widget_list);
            this.Widget_list = Widget_list;
            return this;
        }

        public Builder ad_privacy(AdPrivacy ad_privacy) {
            this.ad_privacy = ad_privacy;
            return this;
        }

        public Builder android_market(AndroidMarket android_market) {
            this.android_market = android_market;
            return this;
        }

        public Builder apk_md5(String apk_md5) {
            this.apk_md5 = apk_md5;
            return this;
        }

        public Builder app_name(String app_name) {
            this.app_name = app_name;
            return this;
        }

        public Builder asset(List<ResponseAsset> asset) {
            Internal.checkElementsNotNull(asset);
            this.asset = asset;
            return this;
        }

        public MaterialMeta build() {
            return new MaterialMeta(this.creative_type, this.interaction_type, this.landing_page, this.video_url, this.video_duration, this.video_size, this.html_snippet, this.endcard_url, this.video_md5, this.endcard_md5, this.deeplink_url, this.image_src, this.image_size, this.image_md5, this.image_type, this.click_type, this.has_companion_endcard, this.companion, this.web_event_handle, this.template_type, this.video_reciprocal_millisecond, this.html_url, this.enable_collapse_tool_bar, this.open_market_mode, this.play_mode, this.sub_interaction_type, this.title, this.desc, this.icon_url, this.score, this.template_id, this.disable_auto_deeplink, this.closecard_html_snippet, this.app_name, this.button_text, this.ad_privacy, this.video_byte_size, this.html_src, this.native_ad, this.download_dialog, this.android_market, this.main_template, this.sub_template, this.asset, this.theme_data, this.in_app, this.endcard_image_src, this.creative_title, this.has_endcard, this.button_color, this.Widget_list, this.apk_md5, super.buildUnknownFields());
        }

        public Builder button_color(Color button_color) {
            this.button_color = button_color;
            return this;
        }

        public Builder button_text(String button_text) {
            this.button_text = button_text;
            return this;
        }

        public Builder click_type(Integer click_type) {
            this.click_type = click_type;
            return this;
        }

        public Builder closecard_html_snippet(ByteString closecard_html_snippet) {
            this.closecard_html_snippet = closecard_html_snippet;
            return this;
        }

        public Builder companion(CompanionEndcard companion) {
            this.companion = companion;
            return this;
        }

        public Builder creative_title(String creative_title) {
            this.creative_title = creative_title;
            return this;
        }

        public Builder creative_type(Integer creative_type) {
            this.creative_type = creative_type;
            return this;
        }

        public Builder deeplink_url(String deeplink_url) {
            this.deeplink_url = deeplink_url;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder disable_auto_deeplink(Boolean disable_auto_deeplink) {
            this.disable_auto_deeplink = disable_auto_deeplink;
            return this;
        }

        public Builder download_dialog(Boolean download_dialog) {
            this.download_dialog = download_dialog;
            return this;
        }

        public Builder enable_collapse_tool_bar(Boolean enable_collapse_tool_bar) {
            this.enable_collapse_tool_bar = enable_collapse_tool_bar;
            return this;
        }

        public Builder endcard_image_src(String endcard_image_src) {
            this.endcard_image_src = endcard_image_src;
            return this;
        }

        public Builder endcard_md5(String endcard_md5) {
            this.endcard_md5 = endcard_md5;
            return this;
        }

        public Builder endcard_url(String endcard_url) {
            this.endcard_url = endcard_url;
            return this;
        }

        public Builder has_companion_endcard(Boolean has_companion_endcard) {
            this.has_companion_endcard = has_companion_endcard;
            return this;
        }

        public Builder has_endcard(Boolean has_endcard) {
            this.has_endcard = has_endcard;
            return this;
        }

        public Builder html_snippet(ByteString html_snippet) {
            this.html_snippet = html_snippet;
            return this;
        }

        public Builder html_src(String html_src) {
            this.html_src = html_src;
            return this;
        }

        public Builder html_url(String html_url) {
            this.html_url = html_url;
            return this;
        }

        public Builder icon_url(String icon_url) {
            this.icon_url = icon_url;
            return this;
        }

        public Builder image_md5(String image_md5) {
            this.image_md5 = image_md5;
            return this;
        }

        public Builder image_size(Size image_size) {
            this.image_size = image_size;
            return this;
        }

        public Builder image_src(String image_src) {
            this.image_src = image_src;
            return this;
        }

        public Builder image_type(Integer image_type) {
            this.image_type = image_type;
            return this;
        }

        public Builder in_app(Boolean in_app) {
            this.in_app = in_app;
            return this;
        }

        public Builder interaction_type(Integer interaction_type) {
            this.interaction_type = interaction_type;
            return this;
        }

        public Builder landing_page(String landing_page) {
            this.landing_page = landing_page;
            return this;
        }

        public Builder main_template(Template main_template) {
            this.main_template = main_template;
            return this;
        }

        public Builder native_ad(ResponseNativeAd native_ad) {
            this.native_ad = native_ad;
            return this;
        }

        public Builder open_market_mode(Integer open_market_mode) {
            this.open_market_mode = open_market_mode;
            return this;
        }

        public Builder play_mode(Integer play_mode) {
            this.play_mode = play_mode;
            return this;
        }

        public Builder score(Float score) {
            this.score = score;
            return this;
        }

        public Builder sub_interaction_type(Integer sub_interaction_type) {
            this.sub_interaction_type = sub_interaction_type;
            return this;
        }

        public Builder sub_template(Template sub_template) {
            this.sub_template = sub_template;
            return this;
        }

        public Builder template_id(Integer template_id) {
            this.template_id = template_id;
            return this;
        }

        public Builder template_type(Integer template_type) {
            this.template_type = template_type;
            return this;
        }

        public Builder theme_data(Integer theme_data) {
            this.theme_data = theme_data;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder video_byte_size(Integer video_byte_size) {
            this.video_byte_size = video_byte_size;
            return this;
        }

        public Builder video_duration(Integer video_duration) {
            this.video_duration = video_duration;
            return this;
        }

        public Builder video_md5(String video_md5) {
            this.video_md5 = video_md5;
            return this;
        }

        public Builder video_reciprocal_millisecond(Integer video_reciprocal_millisecond) {
            this.video_reciprocal_millisecond = video_reciprocal_millisecond;
            return this;
        }

        public Builder video_size(Size video_size) {
            this.video_size = video_size;
            return this;
        }

        public Builder video_url(String video_url) {
            this.video_url = video_url;
            return this;
        }

        public Builder web_event_handle(WebEventHandle web_event_handle) {
            this.web_event_handle = web_event_handle;
            return this;
        }
    }

    private static final class ProtoAdapter_MaterialMeta extends ProtoAdapter<MaterialMeta> {
        public ProtoAdapter_MaterialMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MaterialMeta.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public MaterialMeta m1412decode(ProtoReader reader) throws IOException {
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
                switch (iNextTag) {
                    case 1:
                        builder.creative_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 2:
                        builder.interaction_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 3:
                        builder.landing_page((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 4:
                        builder.video_url((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 5:
                        builder.video_duration((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 6:
                        builder.video_size((Size) Size.ADAPTER.decode(reader));
                        continue;
                    case 7:
                        builder.html_snippet((ByteString) ProtoAdapter.BYTES.decode(reader));
                        continue;
                    case 8:
                        builder.endcard_url((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 9:
                        builder.video_md5((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 10:
                        builder.endcard_md5((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 11:
                        builder.deeplink_url((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 12:
                        builder.image_src((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 13:
                        builder.image_size((Size) Size.ADAPTER.decode(reader));
                        continue;
                    case 14:
                        builder.image_md5((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 15:
                        builder.image_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 16:
                        builder.click_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 17:
                        builder.has_companion_endcard((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 18:
                        builder.companion((CompanionEndcard) CompanionEndcard.ADAPTER.decode(reader));
                        continue;
                    case 19:
                        builder.web_event_handle((WebEventHandle) WebEventHandle.ADAPTER.decode(reader));
                        continue;
                    case 20:
                        builder.template_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 21:
                        builder.video_reciprocal_millisecond((Integer) ProtoAdapter.INT32.decode(reader));
                        continue;
                    case 22:
                        builder.html_url((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 23:
                        builder.enable_collapse_tool_bar((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 24:
                        builder.open_market_mode((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 25:
                        builder.play_mode((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 26:
                        builder.sub_interaction_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 27:
                        builder.title((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 28:
                        builder.desc((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 29:
                        builder.icon_url((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 30:
                        builder.score((Float) ProtoAdapter.FLOAT.decode(reader));
                        continue;
                    case 31:
                        builder.template_id((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 32:
                        builder.disable_auto_deeplink((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 33:
                        builder.closecard_html_snippet((ByteString) ProtoAdapter.BYTES.decode(reader));
                        continue;
                    case 34:
                        builder.app_name((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 35:
                        builder.button_text((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 36:
                        builder.ad_privacy((AdPrivacy) AdPrivacy.ADAPTER.decode(reader));
                        continue;
                    case 37:
                        builder.video_byte_size((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 38:
                        builder.html_src((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 39:
                        builder.native_ad((ResponseNativeAd) ResponseNativeAd.ADAPTER.decode(reader));
                        continue;
                    case 40:
                        builder.download_dialog((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 41:
                        builder.android_market((AndroidMarket) AndroidMarket.ADAPTER.decode(reader));
                        continue;
                    case 42:
                        builder.main_template((Template) Template.ADAPTER.decode(reader));
                        continue;
                    case 43:
                        builder.sub_template((Template) Template.ADAPTER.decode(reader));
                        continue;
                    case 44:
                        list = builder.asset;
                        androidMessage = (ResponseAsset) ResponseAsset.ADAPTER.decode(reader);
                        break;
                    case 45:
                        builder.theme_data((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 46:
                        builder.in_app((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 47:
                        builder.endcard_image_src((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 48:
                        builder.creative_title((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    case 49:
                        builder.has_endcard((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 50:
                        builder.button_color((Color) Color.ADAPTER.decode(reader));
                        continue;
                    case 51:
                        list = builder.Widget_list;
                        androidMessage = (Widget) Widget.ADAPTER.decode(reader);
                        break;
                    case 52:
                        builder.apk_md5((String) ProtoAdapter.STRING.decode(reader));
                        continue;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        continue;
                }
                list.add(androidMessage);
            }
        }

        public void encode(ProtoWriter writer, MaterialMeta value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.creative_type);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.interaction_type);
            ProtoAdapter.STRING.encodeWithTag(writer, 3, value.landing_page);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.video_url);
            ProtoAdapter.UINT32.encodeWithTag(writer, 5, value.video_duration);
            Size.ADAPTER.encodeWithTag(writer, 6, value.video_size);
            ProtoAdapter.BYTES.encodeWithTag(writer, 7, value.html_snippet);
            ProtoAdapter.STRING.encodeWithTag(writer, 8, value.endcard_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 9, value.video_md5);
            ProtoAdapter.STRING.encodeWithTag(writer, 10, value.endcard_md5);
            ProtoAdapter.STRING.encodeWithTag(writer, 11, value.deeplink_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 12, value.image_src);
            Size.ADAPTER.encodeWithTag(writer, 13, value.image_size);
            ProtoAdapter.STRING.encodeWithTag(writer, 14, value.image_md5);
            ProtoAdapter.UINT32.encodeWithTag(writer, 15, value.image_type);
            ProtoAdapter.UINT32.encodeWithTag(writer, 16, value.click_type);
            ProtoAdapter.BOOL.encodeWithTag(writer, 17, value.has_companion_endcard);
            CompanionEndcard.ADAPTER.encodeWithTag(writer, 18, value.companion);
            WebEventHandle.ADAPTER.encodeWithTag(writer, 19, value.web_event_handle);
            ProtoAdapter.UINT32.encodeWithTag(writer, 20, value.template_type);
            ProtoAdapter.INT32.encodeWithTag(writer, 21, value.video_reciprocal_millisecond);
            ProtoAdapter.STRING.encodeWithTag(writer, 22, value.html_url);
            ProtoAdapter.BOOL.encodeWithTag(writer, 23, value.enable_collapse_tool_bar);
            ProtoAdapter.UINT32.encodeWithTag(writer, 24, value.open_market_mode);
            ProtoAdapter.UINT32.encodeWithTag(writer, 25, value.play_mode);
            ProtoAdapter.UINT32.encodeWithTag(writer, 26, value.sub_interaction_type);
            ProtoAdapter.STRING.encodeWithTag(writer, 27, value.title);
            ProtoAdapter.STRING.encodeWithTag(writer, 28, value.desc);
            ProtoAdapter.STRING.encodeWithTag(writer, 29, value.icon_url);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 30, value.score);
            ProtoAdapter.UINT32.encodeWithTag(writer, 31, value.template_id);
            ProtoAdapter.BOOL.encodeWithTag(writer, 32, value.disable_auto_deeplink);
            ProtoAdapter.BYTES.encodeWithTag(writer, 33, value.closecard_html_snippet);
            ProtoAdapter.STRING.encodeWithTag(writer, 34, value.app_name);
            ProtoAdapter.STRING.encodeWithTag(writer, 35, value.button_text);
            AdPrivacy.ADAPTER.encodeWithTag(writer, 36, value.ad_privacy);
            ProtoAdapter.UINT32.encodeWithTag(writer, 37, value.video_byte_size);
            ProtoAdapter.STRING.encodeWithTag(writer, 38, value.html_src);
            ResponseNativeAd.ADAPTER.encodeWithTag(writer, 39, value.native_ad);
            ProtoAdapter.BOOL.encodeWithTag(writer, 40, value.download_dialog);
            AndroidMarket.ADAPTER.encodeWithTag(writer, 41, value.android_market);
            Template.ADAPTER.encodeWithTag(writer, 42, value.main_template);
            Template.ADAPTER.encodeWithTag(writer, 43, value.sub_template);
            ResponseAsset.ADAPTER.asRepeated().encodeWithTag(writer, 44, value.asset);
            ProtoAdapter.UINT32.encodeWithTag(writer, 45, value.theme_data);
            ProtoAdapter.BOOL.encodeWithTag(writer, 46, value.in_app);
            ProtoAdapter.STRING.encodeWithTag(writer, 47, value.endcard_image_src);
            ProtoAdapter.STRING.encodeWithTag(writer, 48, value.creative_title);
            ProtoAdapter.BOOL.encodeWithTag(writer, 49, value.has_endcard);
            Color.ADAPTER.encodeWithTag(writer, 50, value.button_color);
            Widget.ADAPTER.asRepeated().encodeWithTag(writer, 51, value.Widget_list);
            ProtoAdapter.STRING.encodeWithTag(writer, 52, value.apk_md5);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(MaterialMeta value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.creative_type) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.interaction_type) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.landing_page) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.video_url) + ProtoAdapter.UINT32.encodedSizeWithTag(5, value.video_duration) + Size.ADAPTER.encodedSizeWithTag(6, value.video_size) + ProtoAdapter.BYTES.encodedSizeWithTag(7, value.html_snippet) + ProtoAdapter.STRING.encodedSizeWithTag(8, value.endcard_url) + ProtoAdapter.STRING.encodedSizeWithTag(9, value.video_md5) + ProtoAdapter.STRING.encodedSizeWithTag(10, value.endcard_md5) + ProtoAdapter.STRING.encodedSizeWithTag(11, value.deeplink_url) + ProtoAdapter.STRING.encodedSizeWithTag(12, value.image_src) + Size.ADAPTER.encodedSizeWithTag(13, value.image_size) + ProtoAdapter.STRING.encodedSizeWithTag(14, value.image_md5) + ProtoAdapter.UINT32.encodedSizeWithTag(15, value.image_type) + ProtoAdapter.UINT32.encodedSizeWithTag(16, value.click_type) + ProtoAdapter.BOOL.encodedSizeWithTag(17, value.has_companion_endcard) + CompanionEndcard.ADAPTER.encodedSizeWithTag(18, value.companion) + WebEventHandle.ADAPTER.encodedSizeWithTag(19, value.web_event_handle) + ProtoAdapter.UINT32.encodedSizeWithTag(20, value.template_type) + ProtoAdapter.INT32.encodedSizeWithTag(21, value.video_reciprocal_millisecond) + ProtoAdapter.STRING.encodedSizeWithTag(22, value.html_url) + ProtoAdapter.BOOL.encodedSizeWithTag(23, value.enable_collapse_tool_bar) + ProtoAdapter.UINT32.encodedSizeWithTag(24, value.open_market_mode) + ProtoAdapter.UINT32.encodedSizeWithTag(25, value.play_mode) + ProtoAdapter.UINT32.encodedSizeWithTag(26, value.sub_interaction_type) + ProtoAdapter.STRING.encodedSizeWithTag(27, value.title) + ProtoAdapter.STRING.encodedSizeWithTag(28, value.desc) + ProtoAdapter.STRING.encodedSizeWithTag(29, value.icon_url) + ProtoAdapter.FLOAT.encodedSizeWithTag(30, value.score) + ProtoAdapter.UINT32.encodedSizeWithTag(31, value.template_id) + ProtoAdapter.BOOL.encodedSizeWithTag(32, value.disable_auto_deeplink) + ProtoAdapter.BYTES.encodedSizeWithTag(33, value.closecard_html_snippet) + ProtoAdapter.STRING.encodedSizeWithTag(34, value.app_name) + ProtoAdapter.STRING.encodedSizeWithTag(35, value.button_text) + AdPrivacy.ADAPTER.encodedSizeWithTag(36, value.ad_privacy) + ProtoAdapter.UINT32.encodedSizeWithTag(37, value.video_byte_size) + ProtoAdapter.STRING.encodedSizeWithTag(38, value.html_src) + ResponseNativeAd.ADAPTER.encodedSizeWithTag(39, value.native_ad) + ProtoAdapter.BOOL.encodedSizeWithTag(40, value.download_dialog) + AndroidMarket.ADAPTER.encodedSizeWithTag(41, value.android_market) + Template.ADAPTER.encodedSizeWithTag(42, value.main_template) + Template.ADAPTER.encodedSizeWithTag(43, value.sub_template) + ResponseAsset.ADAPTER.asRepeated().encodedSizeWithTag(44, value.asset) + ProtoAdapter.UINT32.encodedSizeWithTag(45, value.theme_data) + ProtoAdapter.BOOL.encodedSizeWithTag(46, value.in_app) + ProtoAdapter.STRING.encodedSizeWithTag(47, value.endcard_image_src) + ProtoAdapter.STRING.encodedSizeWithTag(48, value.creative_title) + ProtoAdapter.BOOL.encodedSizeWithTag(49, value.has_endcard) + Color.ADAPTER.encodedSizeWithTag(50, value.button_color) + Widget.ADAPTER.asRepeated().encodedSizeWithTag(51, value.Widget_list) + ProtoAdapter.STRING.encodedSizeWithTag(52, value.apk_md5) + value.unknownFields().size();
        }

        public MaterialMeta redact(MaterialMeta value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.video_size != null) {
                builderNewBuilder.video_size = (Size) Size.ADAPTER.redact(builderNewBuilder.video_size);
            }
            if (builderNewBuilder.image_size != null) {
                builderNewBuilder.image_size = (Size) Size.ADAPTER.redact(builderNewBuilder.image_size);
            }
            if (builderNewBuilder.companion != null) {
                builderNewBuilder.companion = (CompanionEndcard) CompanionEndcard.ADAPTER.redact(builderNewBuilder.companion);
            }
            if (builderNewBuilder.web_event_handle != null) {
                builderNewBuilder.web_event_handle = (WebEventHandle) WebEventHandle.ADAPTER.redact(builderNewBuilder.web_event_handle);
            }
            if (builderNewBuilder.ad_privacy != null) {
                builderNewBuilder.ad_privacy = (AdPrivacy) AdPrivacy.ADAPTER.redact(builderNewBuilder.ad_privacy);
            }
            if (builderNewBuilder.native_ad != null) {
                builderNewBuilder.native_ad = (ResponseNativeAd) ResponseNativeAd.ADAPTER.redact(builderNewBuilder.native_ad);
            }
            if (builderNewBuilder.android_market != null) {
                builderNewBuilder.android_market = (AndroidMarket) AndroidMarket.ADAPTER.redact(builderNewBuilder.android_market);
            }
            if (builderNewBuilder.main_template != null) {
                builderNewBuilder.main_template = (Template) Template.ADAPTER.redact(builderNewBuilder.main_template);
            }
            if (builderNewBuilder.sub_template != null) {
                builderNewBuilder.sub_template = (Template) Template.ADAPTER.redact(builderNewBuilder.sub_template);
            }
            Internal.redactElements(builderNewBuilder.asset, ResponseAsset.ADAPTER);
            if (builderNewBuilder.button_color != null) {
                builderNewBuilder.button_color = (Color) Color.ADAPTER.redact(builderNewBuilder.button_color);
            }
            Internal.redactElements(builderNewBuilder.Widget_list, Widget.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_MaterialMeta protoAdapter_MaterialMeta = new ProtoAdapter_MaterialMeta();
        ADAPTER = protoAdapter_MaterialMeta;
        CREATOR = AndroidMessage.newCreator(protoAdapter_MaterialMeta);
        DEFAULT_CREATIVE_TYPE = 0;
        DEFAULT_INTERACTION_TYPE = 0;
        DEFAULT_VIDEO_DURATION = 0;
        DEFAULT_HTML_SNIPPET = ByteString.EMPTY;
        DEFAULT_IMAGE_TYPE = 0;
        DEFAULT_CLICK_TYPE = 1;
        DEFAULT_HAS_COMPANION_ENDCARD = false;
        DEFAULT_TEMPLATE_TYPE = 0;
        DEFAULT_VIDEO_RECIPROCAL_MILLISECOND = 0;
        DEFAULT_ENABLE_COLLAPSE_TOOL_BAR = false;
        DEFAULT_OPEN_MARKET_MODE = 0;
        DEFAULT_PLAY_MODE = 0;
        DEFAULT_SUB_INTERACTION_TYPE = 0;
        DEFAULT_SCORE = Float.valueOf(0.0f);
        DEFAULT_TEMPLATE_ID = 0;
        DEFAULT_DISABLE_AUTO_DEEPLINK = false;
        DEFAULT_CLOSECARD_HTML_SNIPPET = ByteString.EMPTY;
        DEFAULT_VIDEO_BYTE_SIZE = 0;
        DEFAULT_DOWNLOAD_DIALOG = false;
        DEFAULT_THEME_DATA = 0;
        DEFAULT_IN_APP = false;
        DEFAULT_HAS_ENDCARD = false;
    }

    public MaterialMeta(Integer creative_type, Integer interaction_type, String landing_page, String video_url, Integer video_duration, Size video_size, ByteString html_snippet, String endcard_url, String video_md5, String endcard_md5, String deeplink_url, String image_src, Size image_size, String image_md5, Integer image_type, Integer click_type, Boolean has_companion_endcard, CompanionEndcard companion, WebEventHandle web_event_handle, Integer template_type, Integer video_reciprocal_millisecond, String html_url, Boolean enable_collapse_tool_bar, Integer open_market_mode, Integer play_mode, Integer sub_interaction_type, String title, String desc, String icon_url, Float score, Integer template_id, Boolean disable_auto_deeplink, ByteString closecard_html_snippet, String app_name, String button_text, AdPrivacy ad_privacy, Integer video_byte_size, String html_src, ResponseNativeAd native_ad, Boolean download_dialog, AndroidMarket android_market, Template main_template, Template sub_template, List<ResponseAsset> asset, Integer theme_data, Boolean in_app, String endcard_image_src, String creative_title, Boolean has_endcard, Color button_color, List<Widget> Widget_list, String apk_md5) {
        this(creative_type, interaction_type, landing_page, video_url, video_duration, video_size, html_snippet, endcard_url, video_md5, endcard_md5, deeplink_url, image_src, image_size, image_md5, image_type, click_type, has_companion_endcard, companion, web_event_handle, template_type, video_reciprocal_millisecond, html_url, enable_collapse_tool_bar, open_market_mode, play_mode, sub_interaction_type, title, desc, icon_url, score, template_id, disable_auto_deeplink, closecard_html_snippet, app_name, button_text, ad_privacy, video_byte_size, html_src, native_ad, download_dialog, android_market, main_template, sub_template, asset, theme_data, in_app, endcard_image_src, creative_title, has_endcard, button_color, Widget_list, apk_md5, ByteString.EMPTY);
    }

    public MaterialMeta(Integer creative_type, Integer interaction_type, String landing_page, String video_url, Integer video_duration, Size video_size, ByteString html_snippet, String endcard_url, String video_md5, String endcard_md5, String deeplink_url, String image_src, Size image_size, String image_md5, Integer image_type, Integer click_type, Boolean has_companion_endcard, CompanionEndcard companion, WebEventHandle web_event_handle, Integer template_type, Integer video_reciprocal_millisecond, String html_url, Boolean enable_collapse_tool_bar, Integer open_market_mode, Integer play_mode, Integer sub_interaction_type, String title, String desc, String icon_url, Float score, Integer template_id, Boolean disable_auto_deeplink, ByteString closecard_html_snippet, String app_name, String button_text, AdPrivacy ad_privacy, Integer video_byte_size, String html_src, ResponseNativeAd native_ad, Boolean download_dialog, AndroidMarket android_market, Template main_template, Template sub_template, List<ResponseAsset> asset, Integer theme_data, Boolean in_app, String endcard_image_src, String creative_title, Boolean has_endcard, Color button_color, List<Widget> Widget_list, String apk_md5, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.creative_type = creative_type;
        this.interaction_type = interaction_type;
        this.landing_page = landing_page;
        this.video_url = video_url;
        this.video_duration = video_duration;
        this.video_size = video_size;
        this.html_snippet = html_snippet;
        this.endcard_url = endcard_url;
        this.video_md5 = video_md5;
        this.endcard_md5 = endcard_md5;
        this.deeplink_url = deeplink_url;
        this.image_src = image_src;
        this.image_size = image_size;
        this.image_md5 = image_md5;
        this.image_type = image_type;
        this.click_type = click_type;
        this.has_companion_endcard = has_companion_endcard;
        this.companion = companion;
        this.web_event_handle = web_event_handle;
        this.template_type = template_type;
        this.video_reciprocal_millisecond = video_reciprocal_millisecond;
        this.html_url = html_url;
        this.enable_collapse_tool_bar = enable_collapse_tool_bar;
        this.open_market_mode = open_market_mode;
        this.play_mode = play_mode;
        this.sub_interaction_type = sub_interaction_type;
        this.title = title;
        this.desc = desc;
        this.icon_url = icon_url;
        this.score = score;
        this.template_id = template_id;
        this.disable_auto_deeplink = disable_auto_deeplink;
        this.closecard_html_snippet = closecard_html_snippet;
        this.app_name = app_name;
        this.button_text = button_text;
        this.ad_privacy = ad_privacy;
        this.video_byte_size = video_byte_size;
        this.html_src = html_src;
        this.native_ad = native_ad;
        this.download_dialog = download_dialog;
        this.android_market = android_market;
        this.main_template = main_template;
        this.sub_template = sub_template;
        this.asset = Internal.immutableCopyOf("asset", asset);
        this.theme_data = theme_data;
        this.in_app = in_app;
        this.endcard_image_src = endcard_image_src;
        this.creative_title = creative_title;
        this.has_endcard = has_endcard;
        this.button_color = button_color;
        this.Widget_list = Internal.immutableCopyOf("Widget_list", Widget_list);
        this.apk_md5 = apk_md5;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MaterialMeta)) {
            return false;
        }
        MaterialMeta materialMeta = (MaterialMeta) other;
        return unknownFields().equals(materialMeta.unknownFields()) && Internal.equals(this.creative_type, materialMeta.creative_type) && Internal.equals(this.interaction_type, materialMeta.interaction_type) && Internal.equals(this.landing_page, materialMeta.landing_page) && Internal.equals(this.video_url, materialMeta.video_url) && Internal.equals(this.video_duration, materialMeta.video_duration) && Internal.equals(this.video_size, materialMeta.video_size) && Internal.equals(this.html_snippet, materialMeta.html_snippet) && Internal.equals(this.endcard_url, materialMeta.endcard_url) && Internal.equals(this.video_md5, materialMeta.video_md5) && Internal.equals(this.endcard_md5, materialMeta.endcard_md5) && Internal.equals(this.deeplink_url, materialMeta.deeplink_url) && Internal.equals(this.image_src, materialMeta.image_src) && Internal.equals(this.image_size, materialMeta.image_size) && Internal.equals(this.image_md5, materialMeta.image_md5) && Internal.equals(this.image_type, materialMeta.image_type) && Internal.equals(this.click_type, materialMeta.click_type) && Internal.equals(this.has_companion_endcard, materialMeta.has_companion_endcard) && Internal.equals(this.companion, materialMeta.companion) && Internal.equals(this.web_event_handle, materialMeta.web_event_handle) && Internal.equals(this.template_type, materialMeta.template_type) && Internal.equals(this.video_reciprocal_millisecond, materialMeta.video_reciprocal_millisecond) && Internal.equals(this.html_url, materialMeta.html_url) && Internal.equals(this.enable_collapse_tool_bar, materialMeta.enable_collapse_tool_bar) && Internal.equals(this.open_market_mode, materialMeta.open_market_mode) && Internal.equals(this.play_mode, materialMeta.play_mode) && Internal.equals(this.sub_interaction_type, materialMeta.sub_interaction_type) && Internal.equals(this.title, materialMeta.title) && Internal.equals(this.desc, materialMeta.desc) && Internal.equals(this.icon_url, materialMeta.icon_url) && Internal.equals(this.score, materialMeta.score) && Internal.equals(this.template_id, materialMeta.template_id) && Internal.equals(this.disable_auto_deeplink, materialMeta.disable_auto_deeplink) && Internal.equals(this.closecard_html_snippet, materialMeta.closecard_html_snippet) && Internal.equals(this.app_name, materialMeta.app_name) && Internal.equals(this.button_text, materialMeta.button_text) && Internal.equals(this.ad_privacy, materialMeta.ad_privacy) && Internal.equals(this.video_byte_size, materialMeta.video_byte_size) && Internal.equals(this.html_src, materialMeta.html_src) && Internal.equals(this.native_ad, materialMeta.native_ad) && Internal.equals(this.download_dialog, materialMeta.download_dialog) && Internal.equals(this.android_market, materialMeta.android_market) && Internal.equals(this.main_template, materialMeta.main_template) && Internal.equals(this.sub_template, materialMeta.sub_template) && this.asset.equals(materialMeta.asset) && Internal.equals(this.theme_data, materialMeta.theme_data) && Internal.equals(this.in_app, materialMeta.in_app) && Internal.equals(this.endcard_image_src, materialMeta.endcard_image_src) && Internal.equals(this.creative_title, materialMeta.creative_title) && Internal.equals(this.has_endcard, materialMeta.has_endcard) && Internal.equals(this.button_color, materialMeta.button_color) && this.Widget_list.equals(materialMeta.Widget_list) && Internal.equals(this.apk_md5, materialMeta.apk_md5);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.creative_type;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.interaction_type;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.landing_page;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.video_url;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num3 = this.video_duration;
        int iHashCode6 = (iHashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Size size = this.video_size;
        int iHashCode7 = (iHashCode6 + (size != null ? size.hashCode() : 0)) * 37;
        ByteString byteString = this.html_snippet;
        int iHashCode8 = (iHashCode7 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        String str3 = this.endcard_url;
        int iHashCode9 = (iHashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.video_md5;
        int iHashCode10 = (iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.endcard_md5;
        int iHashCode11 = (iHashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.deeplink_url;
        int iHashCode12 = (iHashCode11 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.image_src;
        int iHashCode13 = (iHashCode12 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Size size2 = this.image_size;
        int iHashCode14 = (iHashCode13 + (size2 != null ? size2.hashCode() : 0)) * 37;
        String str8 = this.image_md5;
        int iHashCode15 = (iHashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num4 = this.image_type;
        int iHashCode16 = (iHashCode15 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.click_type;
        int iHashCode17 = (iHashCode16 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.has_companion_endcard;
        int iHashCode18 = (iHashCode17 + (bool != null ? bool.hashCode() : 0)) * 37;
        CompanionEndcard companionEndcard = this.companion;
        int iHashCode19 = (iHashCode18 + (companionEndcard != null ? companionEndcard.hashCode() : 0)) * 37;
        WebEventHandle webEventHandle = this.web_event_handle;
        int iHashCode20 = (iHashCode19 + (webEventHandle != null ? webEventHandle.hashCode() : 0)) * 37;
        Integer num6 = this.template_type;
        int iHashCode21 = (iHashCode20 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.video_reciprocal_millisecond;
        int iHashCode22 = (iHashCode21 + (num7 != null ? num7.hashCode() : 0)) * 37;
        String str9 = this.html_url;
        int iHashCode23 = (iHashCode22 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_collapse_tool_bar;
        int iHashCode24 = (iHashCode23 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num8 = this.open_market_mode;
        int iHashCode25 = (iHashCode24 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.play_mode;
        int iHashCode26 = (iHashCode25 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.sub_interaction_type;
        int iHashCode27 = (iHashCode26 + (num10 != null ? num10.hashCode() : 0)) * 37;
        String str10 = this.title;
        int iHashCode28 = (iHashCode27 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.desc;
        int iHashCode29 = (iHashCode28 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.icon_url;
        int iHashCode30 = (iHashCode29 + (str12 != null ? str12.hashCode() : 0)) * 37;
        Float f = this.score;
        int iHashCode31 = (iHashCode30 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num11 = this.template_id;
        int iHashCode32 = (iHashCode31 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Boolean bool3 = this.disable_auto_deeplink;
        int iHashCode33 = (iHashCode32 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        ByteString byteString2 = this.closecard_html_snippet;
        int iHashCode34 = (iHashCode33 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        String str13 = this.app_name;
        int iHashCode35 = (iHashCode34 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.button_text;
        int iHashCode36 = (iHashCode35 + (str14 != null ? str14.hashCode() : 0)) * 37;
        AdPrivacy adPrivacy = this.ad_privacy;
        int iHashCode37 = (iHashCode36 + (adPrivacy != null ? adPrivacy.hashCode() : 0)) * 37;
        Integer num12 = this.video_byte_size;
        int iHashCode38 = (iHashCode37 + (num12 != null ? num12.hashCode() : 0)) * 37;
        String str15 = this.html_src;
        int iHashCode39 = (iHashCode38 + (str15 != null ? str15.hashCode() : 0)) * 37;
        ResponseNativeAd responseNativeAd = this.native_ad;
        int iHashCode40 = (iHashCode39 + (responseNativeAd != null ? responseNativeAd.hashCode() : 0)) * 37;
        Boolean bool4 = this.download_dialog;
        int iHashCode41 = (iHashCode40 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        AndroidMarket androidMarket = this.android_market;
        int iHashCode42 = (iHashCode41 + (androidMarket != null ? androidMarket.hashCode() : 0)) * 37;
        Template template = this.main_template;
        int iHashCode43 = (iHashCode42 + (template != null ? template.hashCode() : 0)) * 37;
        Template template2 = this.sub_template;
        int iHashCode44 = (((iHashCode43 + (template2 != null ? template2.hashCode() : 0)) * 37) + this.asset.hashCode()) * 37;
        Integer num13 = this.theme_data;
        int iHashCode45 = (iHashCode44 + (num13 != null ? num13.hashCode() : 0)) * 37;
        Boolean bool5 = this.in_app;
        int iHashCode46 = (iHashCode45 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        String str16 = this.endcard_image_src;
        int iHashCode47 = (iHashCode46 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.creative_title;
        int iHashCode48 = (iHashCode47 + (str17 != null ? str17.hashCode() : 0)) * 37;
        Boolean bool6 = this.has_endcard;
        int iHashCode49 = (iHashCode48 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Color color = this.button_color;
        int iHashCode50 = (((iHashCode49 + (color != null ? color.hashCode() : 0)) * 37) + this.Widget_list.hashCode()) * 37;
        String str18 = this.apk_md5;
        int iHashCode51 = iHashCode50 + (str18 != null ? str18.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode51;
        return iHashCode51;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.creative_type = this.creative_type;
        builder.interaction_type = this.interaction_type;
        builder.landing_page = this.landing_page;
        builder.video_url = this.video_url;
        builder.video_duration = this.video_duration;
        builder.video_size = this.video_size;
        builder.html_snippet = this.html_snippet;
        builder.endcard_url = this.endcard_url;
        builder.video_md5 = this.video_md5;
        builder.endcard_md5 = this.endcard_md5;
        builder.deeplink_url = this.deeplink_url;
        builder.image_src = this.image_src;
        builder.image_size = this.image_size;
        builder.image_md5 = this.image_md5;
        builder.image_type = this.image_type;
        builder.click_type = this.click_type;
        builder.has_companion_endcard = this.has_companion_endcard;
        builder.companion = this.companion;
        builder.web_event_handle = this.web_event_handle;
        builder.template_type = this.template_type;
        builder.video_reciprocal_millisecond = this.video_reciprocal_millisecond;
        builder.html_url = this.html_url;
        builder.enable_collapse_tool_bar = this.enable_collapse_tool_bar;
        builder.open_market_mode = this.open_market_mode;
        builder.play_mode = this.play_mode;
        builder.sub_interaction_type = this.sub_interaction_type;
        builder.title = this.title;
        builder.desc = this.desc;
        builder.icon_url = this.icon_url;
        builder.score = this.score;
        builder.template_id = this.template_id;
        builder.disable_auto_deeplink = this.disable_auto_deeplink;
        builder.closecard_html_snippet = this.closecard_html_snippet;
        builder.app_name = this.app_name;
        builder.button_text = this.button_text;
        builder.ad_privacy = this.ad_privacy;
        builder.video_byte_size = this.video_byte_size;
        builder.html_src = this.html_src;
        builder.native_ad = this.native_ad;
        builder.download_dialog = this.download_dialog;
        builder.android_market = this.android_market;
        builder.main_template = this.main_template;
        builder.sub_template = this.sub_template;
        builder.asset = Internal.copyOf("asset", this.asset);
        builder.theme_data = this.theme_data;
        builder.in_app = this.in_app;
        builder.endcard_image_src = this.endcard_image_src;
        builder.creative_title = this.creative_title;
        builder.has_endcard = this.has_endcard;
        builder.button_color = this.button_color;
        builder.Widget_list = Internal.copyOf("Widget_list", this.Widget_list);
        builder.apk_md5 = this.apk_md5;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.creative_type != null) {
            sb.append(", creative_type=").append(this.creative_type);
        }
        if (this.interaction_type != null) {
            sb.append(", interaction_type=").append(this.interaction_type);
        }
        if (this.landing_page != null) {
            sb.append(", landing_page=").append(this.landing_page);
        }
        if (this.video_url != null) {
            sb.append(", video_url=").append(this.video_url);
        }
        if (this.video_duration != null) {
            sb.append(", video_duration=").append(this.video_duration);
        }
        if (this.video_size != null) {
            sb.append(", video_size=").append(this.video_size);
        }
        if (this.html_snippet != null) {
            sb.append(", html_snippet=").append(this.html_snippet);
        }
        if (this.endcard_url != null) {
            sb.append(", endcard_url=").append(this.endcard_url);
        }
        if (this.video_md5 != null) {
            sb.append(", video_md5=").append(this.video_md5);
        }
        if (this.endcard_md5 != null) {
            sb.append(", endcard_md5=").append(this.endcard_md5);
        }
        if (this.deeplink_url != null) {
            sb.append(", deeplink_url=").append(this.deeplink_url);
        }
        if (this.image_src != null) {
            sb.append(", image_src=").append(this.image_src);
        }
        if (this.image_size != null) {
            sb.append(", image_size=").append(this.image_size);
        }
        if (this.image_md5 != null) {
            sb.append(", image_md5=").append(this.image_md5);
        }
        if (this.image_type != null) {
            sb.append(", image_type=").append(this.image_type);
        }
        if (this.click_type != null) {
            sb.append(", click_type=").append(this.click_type);
        }
        if (this.has_companion_endcard != null) {
            sb.append(", has_companion_endcard=").append(this.has_companion_endcard);
        }
        if (this.companion != null) {
            sb.append(", companion=").append(this.companion);
        }
        if (this.web_event_handle != null) {
            sb.append(", web_event_handle=").append(this.web_event_handle);
        }
        if (this.template_type != null) {
            sb.append(", template_type=").append(this.template_type);
        }
        if (this.video_reciprocal_millisecond != null) {
            sb.append(", video_reciprocal_millisecond=").append(this.video_reciprocal_millisecond);
        }
        if (this.html_url != null) {
            sb.append(", html_url=").append(this.html_url);
        }
        if (this.enable_collapse_tool_bar != null) {
            sb.append(", enable_collapse_tool_bar=").append(this.enable_collapse_tool_bar);
        }
        if (this.open_market_mode != null) {
            sb.append(", open_market_mode=").append(this.open_market_mode);
        }
        if (this.play_mode != null) {
            sb.append(", play_mode=").append(this.play_mode);
        }
        if (this.sub_interaction_type != null) {
            sb.append(", sub_interaction_type=").append(this.sub_interaction_type);
        }
        if (this.title != null) {
            sb.append(", title=").append(this.title);
        }
        if (this.desc != null) {
            sb.append(", desc=").append(this.desc);
        }
        if (this.icon_url != null) {
            sb.append(", icon_url=").append(this.icon_url);
        }
        if (this.score != null) {
            sb.append(", score=").append(this.score);
        }
        if (this.template_id != null) {
            sb.append(", template_id=").append(this.template_id);
        }
        if (this.disable_auto_deeplink != null) {
            sb.append(", disable_auto_deeplink=").append(this.disable_auto_deeplink);
        }
        if (this.closecard_html_snippet != null) {
            sb.append(", closecard_html_snippet=").append(this.closecard_html_snippet);
        }
        if (this.app_name != null) {
            sb.append(", app_name=").append(this.app_name);
        }
        if (this.button_text != null) {
            sb.append(", button_text=").append(this.button_text);
        }
        if (this.ad_privacy != null) {
            sb.append(", ad_privacy=").append(this.ad_privacy);
        }
        if (this.video_byte_size != null) {
            sb.append(", video_byte_size=").append(this.video_byte_size);
        }
        if (this.html_src != null) {
            sb.append(", html_src=").append(this.html_src);
        }
        if (this.native_ad != null) {
            sb.append(", native_ad=").append(this.native_ad);
        }
        if (this.download_dialog != null) {
            sb.append(", download_dialog=").append(this.download_dialog);
        }
        if (this.android_market != null) {
            sb.append(", android_market=").append(this.android_market);
        }
        if (this.main_template != null) {
            sb.append(", main_template=").append(this.main_template);
        }
        if (this.sub_template != null) {
            sb.append(", sub_template=").append(this.sub_template);
        }
        if (!this.asset.isEmpty()) {
            sb.append(", asset=").append(this.asset);
        }
        if (this.theme_data != null) {
            sb.append(", theme_data=").append(this.theme_data);
        }
        if (this.in_app != null) {
            sb.append(", in_app=").append(this.in_app);
        }
        if (this.endcard_image_src != null) {
            sb.append(", endcard_image_src=").append(this.endcard_image_src);
        }
        if (this.creative_title != null) {
            sb.append(", creative_title=").append(this.creative_title);
        }
        if (this.has_endcard != null) {
            sb.append(", has_endcard=").append(this.has_endcard);
        }
        if (this.button_color != null) {
            sb.append(", button_color=").append(this.button_color);
        }
        if (!this.Widget_list.isEmpty()) {
            sb.append(", Widget_list=").append(this.Widget_list);
        }
        if (this.apk_md5 != null) {
            sb.append(", apk_md5=").append(this.apk_md5);
        }
        return sb.replace(0, 2, "MaterialMeta{").append('}').toString();
    }
}
