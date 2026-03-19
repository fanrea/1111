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
public final class AdSetting extends AndroidMessage<AdSetting, Builder> {
    public static final ProtoAdapter<AdSetting> ADAPTER;
    public static final Parcelable.Creator<AdSetting> CREATOR;
    public static final Boolean DEFAULT_CAN_EXPIRE_RELOAD;
    public static final Boolean DEFAULT_DISABLE_DOWNLOAD_LISTENER;
    public static final Integer DEFAULT_EXPIRE_RELOAD_COUNT;
    public static final Boolean DEFAULT_IN_APP;
    public static final Integer DEFAULT_RETRY_COUNT;
    public static final Integer DEFAULT_SENSITIVITY;
    public static final Integer DEFAULT_SHAKE_COUNT;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean can_expire_reload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean disable_download_listener;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 12)
    public final Integer expire_reload_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean in_app;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.LinkAction#ADAPTER", label = WireField.Label.REPEATED, tag = 10)
    public final List<LinkAction> link_actions;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer retry_count;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.RvAdSetting#ADAPTER", tag = 1)
    public final RvAdSetting rv_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 8)
    public final List<String> scheme_white_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer sensitivity;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer shake_count;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting#ADAPTER", tag = 4)
    public final SingleNativeAdSetting single_native_setting;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SplashAdSetting#ADAPTER", tag = 2)
    public final SplashAdSetting splash_setting;

    public static final class Builder extends Message.Builder<AdSetting, Builder> {
        public RvAdSetting rv_setting;
        public SingleNativeAdSetting single_native_setting;
        public SplashAdSetting splash_setting;
        public Integer retry_count = AdSetting.DEFAULT_RETRY_COUNT;
        public Boolean in_app = AdSetting.DEFAULT_IN_APP;
        public Boolean disable_download_listener = AdSetting.DEFAULT_DISABLE_DOWNLOAD_LISTENER;
        public Integer sensitivity = AdSetting.DEFAULT_SENSITIVITY;
        public Boolean can_expire_reload = AdSetting.DEFAULT_CAN_EXPIRE_RELOAD;
        public Integer expire_reload_count = AdSetting.DEFAULT_EXPIRE_RELOAD_COUNT;
        public Integer shake_count = AdSetting.DEFAULT_SHAKE_COUNT;
        public List<String> scheme_white_list = Internal.newMutableList();
        public List<LinkAction> link_actions = Internal.newMutableList();

        public AdSetting build() {
            return new AdSetting(this.rv_setting, this.splash_setting, this.retry_count, this.single_native_setting, this.in_app, this.disable_download_listener, this.scheme_white_list, this.sensitivity, this.link_actions, this.can_expire_reload, this.expire_reload_count, this.shake_count, super.buildUnknownFields());
        }

        public Builder can_expire_reload(Boolean can_expire_reload) {
            this.can_expire_reload = can_expire_reload;
            return this;
        }

        public Builder disable_download_listener(Boolean disable_download_listener) {
            this.disable_download_listener = disable_download_listener;
            return this;
        }

        public Builder expire_reload_count(Integer expire_reload_count) {
            this.expire_reload_count = expire_reload_count;
            return this;
        }

        public Builder in_app(Boolean in_app) {
            this.in_app = in_app;
            return this;
        }

        public Builder link_actions(List<LinkAction> link_actions) {
            Internal.checkElementsNotNull(link_actions);
            this.link_actions = link_actions;
            return this;
        }

        public Builder retry_count(Integer retry_count) {
            this.retry_count = retry_count;
            return this;
        }

        public Builder rv_setting(RvAdSetting rv_setting) {
            this.rv_setting = rv_setting;
            return this;
        }

        public Builder scheme_white_list(List<String> scheme_white_list) {
            Internal.checkElementsNotNull(scheme_white_list);
            this.scheme_white_list = scheme_white_list;
            return this;
        }

        public Builder sensitivity(Integer sensitivity) {
            this.sensitivity = sensitivity;
            return this;
        }

        public Builder shake_count(Integer shake_count) {
            this.shake_count = shake_count;
            return this;
        }

        public Builder single_native_setting(SingleNativeAdSetting single_native_setting) {
            this.single_native_setting = single_native_setting;
            return this;
        }

        public Builder splash_setting(SplashAdSetting splash_setting) {
            this.splash_setting = splash_setting;
            return this;
        }
    }

    private static final class ProtoAdapter_AdSetting extends ProtoAdapter<AdSetting> {
        public ProtoAdapter_AdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, AdSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public AdSetting m1382decode(ProtoReader reader) throws IOException {
            List list;
            Object obj;
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
                        builder.rv_setting((RvAdSetting) RvAdSetting.ADAPTER.decode(reader));
                        continue;
                    case 2:
                        builder.splash_setting((SplashAdSetting) SplashAdSetting.ADAPTER.decode(reader));
                        continue;
                    case 3:
                        builder.retry_count((Integer) ProtoAdapter.INT32.decode(reader));
                        continue;
                    case 4:
                        builder.single_native_setting((SingleNativeAdSetting) SingleNativeAdSetting.ADAPTER.decode(reader));
                        continue;
                    case 5:
                        builder.in_app((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 6:
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        continue;
                    case 7:
                        builder.disable_download_listener((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 8:
                        list = builder.scheme_white_list;
                        obj = (String) ProtoAdapter.STRING.decode(reader);
                        break;
                    case 9:
                        builder.sensitivity((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 10:
                        list = builder.link_actions;
                        obj = (LinkAction) LinkAction.ADAPTER.decode(reader);
                        break;
                    case 11:
                        builder.can_expire_reload((Boolean) ProtoAdapter.BOOL.decode(reader));
                        continue;
                    case 12:
                        builder.expire_reload_count((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                    case 13:
                        builder.shake_count((Integer) ProtoAdapter.UINT32.decode(reader));
                        continue;
                }
                list.add(obj);
            }
        }

        public void encode(ProtoWriter writer, AdSetting value) throws IOException {
            RvAdSetting.ADAPTER.encodeWithTag(writer, 1, value.rv_setting);
            SplashAdSetting.ADAPTER.encodeWithTag(writer, 2, value.splash_setting);
            ProtoAdapter.INT32.encodeWithTag(writer, 3, value.retry_count);
            SingleNativeAdSetting.ADAPTER.encodeWithTag(writer, 4, value.single_native_setting);
            ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.in_app);
            ProtoAdapter.BOOL.encodeWithTag(writer, 7, value.disable_download_listener);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 8, value.scheme_white_list);
            ProtoAdapter.UINT32.encodeWithTag(writer, 9, value.sensitivity);
            LinkAction.ADAPTER.asRepeated().encodeWithTag(writer, 10, value.link_actions);
            ProtoAdapter.BOOL.encodeWithTag(writer, 11, value.can_expire_reload);
            ProtoAdapter.UINT32.encodeWithTag(writer, 12, value.expire_reload_count);
            ProtoAdapter.UINT32.encodeWithTag(writer, 13, value.shake_count);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(AdSetting value) {
            return RvAdSetting.ADAPTER.encodedSizeWithTag(1, value.rv_setting) + SplashAdSetting.ADAPTER.encodedSizeWithTag(2, value.splash_setting) + ProtoAdapter.INT32.encodedSizeWithTag(3, value.retry_count) + SingleNativeAdSetting.ADAPTER.encodedSizeWithTag(4, value.single_native_setting) + ProtoAdapter.BOOL.encodedSizeWithTag(5, value.in_app) + ProtoAdapter.BOOL.encodedSizeWithTag(7, value.disable_download_listener) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(8, value.scheme_white_list) + ProtoAdapter.UINT32.encodedSizeWithTag(9, value.sensitivity) + LinkAction.ADAPTER.asRepeated().encodedSizeWithTag(10, value.link_actions) + ProtoAdapter.BOOL.encodedSizeWithTag(11, value.can_expire_reload) + ProtoAdapter.UINT32.encodedSizeWithTag(12, value.expire_reload_count) + ProtoAdapter.UINT32.encodedSizeWithTag(13, value.shake_count) + value.unknownFields().size();
        }

        public AdSetting redact(AdSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.rv_setting != null) {
                builderNewBuilder.rv_setting = (RvAdSetting) RvAdSetting.ADAPTER.redact(builderNewBuilder.rv_setting);
            }
            if (builderNewBuilder.splash_setting != null) {
                builderNewBuilder.splash_setting = (SplashAdSetting) SplashAdSetting.ADAPTER.redact(builderNewBuilder.splash_setting);
            }
            if (builderNewBuilder.single_native_setting != null) {
                builderNewBuilder.single_native_setting = (SingleNativeAdSetting) SingleNativeAdSetting.ADAPTER.redact(builderNewBuilder.single_native_setting);
            }
            Internal.redactElements(builderNewBuilder.link_actions, LinkAction.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdSetting protoAdapter_AdSetting = new ProtoAdapter_AdSetting();
        ADAPTER = protoAdapter_AdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdSetting);
        DEFAULT_RETRY_COUNT = 0;
        DEFAULT_IN_APP = false;
        DEFAULT_DISABLE_DOWNLOAD_LISTENER = false;
        DEFAULT_SENSITIVITY = 0;
        DEFAULT_CAN_EXPIRE_RELOAD = false;
        DEFAULT_EXPIRE_RELOAD_COUNT = 0;
        DEFAULT_SHAKE_COUNT = 0;
    }

    public AdSetting(RvAdSetting rv_setting, SplashAdSetting splash_setting, Integer retry_count, SingleNativeAdSetting single_native_setting, Boolean in_app, Boolean disable_download_listener, List<String> scheme_white_list, Integer sensitivity, List<LinkAction> link_actions, Boolean can_expire_reload, Integer expire_reload_count, Integer shake_count) {
        this(rv_setting, splash_setting, retry_count, single_native_setting, in_app, disable_download_listener, scheme_white_list, sensitivity, link_actions, can_expire_reload, expire_reload_count, shake_count, ByteString.EMPTY);
    }

    public AdSetting(RvAdSetting rv_setting, SplashAdSetting splash_setting, Integer retry_count, SingleNativeAdSetting single_native_setting, Boolean in_app, Boolean disable_download_listener, List<String> scheme_white_list, Integer sensitivity, List<LinkAction> link_actions, Boolean can_expire_reload, Integer expire_reload_count, Integer shake_count, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.rv_setting = rv_setting;
        this.splash_setting = splash_setting;
        this.retry_count = retry_count;
        this.single_native_setting = single_native_setting;
        this.in_app = in_app;
        this.disable_download_listener = disable_download_listener;
        this.scheme_white_list = Internal.immutableCopyOf("scheme_white_list", scheme_white_list);
        this.sensitivity = sensitivity;
        this.link_actions = Internal.immutableCopyOf("link_actions", link_actions);
        this.can_expire_reload = can_expire_reload;
        this.expire_reload_count = expire_reload_count;
        this.shake_count = shake_count;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AdSetting)) {
            return false;
        }
        AdSetting adSetting = (AdSetting) other;
        return unknownFields().equals(adSetting.unknownFields()) && Internal.equals(this.rv_setting, adSetting.rv_setting) && Internal.equals(this.splash_setting, adSetting.splash_setting) && Internal.equals(this.retry_count, adSetting.retry_count) && Internal.equals(this.single_native_setting, adSetting.single_native_setting) && Internal.equals(this.in_app, adSetting.in_app) && Internal.equals(this.disable_download_listener, adSetting.disable_download_listener) && this.scheme_white_list.equals(adSetting.scheme_white_list) && Internal.equals(this.sensitivity, adSetting.sensitivity) && this.link_actions.equals(adSetting.link_actions) && Internal.equals(this.can_expire_reload, adSetting.can_expire_reload) && Internal.equals(this.expire_reload_count, adSetting.expire_reload_count) && Internal.equals(this.shake_count, adSetting.shake_count);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        RvAdSetting rvAdSetting = this.rv_setting;
        int iHashCode2 = (iHashCode + (rvAdSetting != null ? rvAdSetting.hashCode() : 0)) * 37;
        SplashAdSetting splashAdSetting = this.splash_setting;
        int iHashCode3 = (iHashCode2 + (splashAdSetting != null ? splashAdSetting.hashCode() : 0)) * 37;
        Integer num = this.retry_count;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        SingleNativeAdSetting singleNativeAdSetting = this.single_native_setting;
        int iHashCode5 = (iHashCode4 + (singleNativeAdSetting != null ? singleNativeAdSetting.hashCode() : 0)) * 37;
        Boolean bool = this.in_app;
        int iHashCode6 = (iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.disable_download_listener;
        int iHashCode7 = (((iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37) + this.scheme_white_list.hashCode()) * 37;
        Integer num2 = this.sensitivity;
        int iHashCode8 = (((iHashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37) + this.link_actions.hashCode()) * 37;
        Boolean bool3 = this.can_expire_reload;
        int iHashCode9 = (iHashCode8 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num3 = this.expire_reload_count;
        int iHashCode10 = (iHashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.shake_count;
        int iHashCode11 = iHashCode10 + (num4 != null ? num4.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode11;
        return iHashCode11;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.rv_setting = this.rv_setting;
        builder.splash_setting = this.splash_setting;
        builder.retry_count = this.retry_count;
        builder.single_native_setting = this.single_native_setting;
        builder.in_app = this.in_app;
        builder.disable_download_listener = this.disable_download_listener;
        builder.scheme_white_list = Internal.copyOf("scheme_white_list", this.scheme_white_list);
        builder.sensitivity = this.sensitivity;
        builder.link_actions = Internal.copyOf("link_actions", this.link_actions);
        builder.can_expire_reload = this.can_expire_reload;
        builder.expire_reload_count = this.expire_reload_count;
        builder.shake_count = this.shake_count;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.rv_setting != null) {
            sb.append(", rv_setting=").append(this.rv_setting);
        }
        if (this.splash_setting != null) {
            sb.append(", splash_setting=").append(this.splash_setting);
        }
        if (this.retry_count != null) {
            sb.append(", retry_count=").append(this.retry_count);
        }
        if (this.single_native_setting != null) {
            sb.append(", single_native_setting=").append(this.single_native_setting);
        }
        if (this.in_app != null) {
            sb.append(", in_app=").append(this.in_app);
        }
        if (this.disable_download_listener != null) {
            sb.append(", disable_download_listener=").append(this.disable_download_listener);
        }
        if (!this.scheme_white_list.isEmpty()) {
            sb.append(", scheme_white_list=").append(this.scheme_white_list);
        }
        if (this.sensitivity != null) {
            sb.append(", sensitivity=").append(this.sensitivity);
        }
        if (!this.link_actions.isEmpty()) {
            sb.append(", link_actions=").append(this.link_actions);
        }
        if (this.can_expire_reload != null) {
            sb.append(", can_expire_reload=").append(this.can_expire_reload);
        }
        if (this.expire_reload_count != null) {
            sb.append(", expire_reload_count=").append(this.expire_reload_count);
        }
        if (this.shake_count != null) {
            sb.append(", shake_count=").append(this.shake_count);
        }
        return sb.replace(0, 2, "AdSetting{").append('}').toString();
    }
}
