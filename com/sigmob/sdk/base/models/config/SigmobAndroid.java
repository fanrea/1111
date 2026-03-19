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
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SigmobAndroid extends AndroidMessage<SigmobAndroid, Builder> {
    public static final ProtoAdapter<SigmobAndroid> ADAPTER;
    public static final Parcelable.Creator<SigmobAndroid> CREATOR;
    public static final Integer DEFAULT_APK_EXPIRED_TIME;
    public static final Boolean DEFAULT_DISABLEUPAPPINFO;
    public static final Boolean DEFAULT_DISABLE_BOOT_MARK;
    public static final Boolean DEFAULT_DISABLE_INSTALL_MONITOR;
    public static final Integer DEFAULT_DISABLE_UP_OAID;
    public static final Integer DEFAULT_ENABLE_APP_LIST;
    public static final Boolean DEFAULT_ENABLE_OKHTTP3;
    public static final Boolean DEFAULT_ENABLE_OPEN_PKG_DIR_LIST;
    public static final Boolean DEFAULT_ENABLE_OPEN_PKG_LIST;
    public static final Boolean DEFAULT_ENABLE_PERMISSION;
    public static final Boolean DEFAULT_ENABLE_REPORT_CRASH;
    public static final Boolean DEFAULT_LOCK_PLAY;
    public static final Boolean DEFAULT_OAID_API_IS_DISABLE;
    public static final Integer DEFAULT_REPORT_LOG;
    public static final Boolean DEFAULT_SCREEN_KEEP;
    public static final Integer DEFAULT_UP_WIFI_LIST_INTERVAL;
    public static final Boolean DEFAULT_USE_WEB_SOURCE_CACHE;
    public static final Integer DEFAULT_WEB_SOURCE_CACHE_EXPIRATION_TIME;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer apk_expired_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean disableUpAppInfo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean disable_boot_mark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean disable_install_monitor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer disable_up_oaid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer enable_app_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean enable_okhttp3;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 19)
    public final Boolean enable_open_pkg_dir_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    public final Boolean enable_open_pkg_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean enable_permission;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean enable_report_crash;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    public final Boolean lock_play;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean oaid_api_is_disable;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 14)
    public final List<String> open_pkg_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer report_log;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    public final Boolean screen_keep;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer up_wifi_list_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean use_web_source_cache;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 16)
    public final Integer web_source_cache_expiration_time;

    public static final class Builder extends Message.Builder<SigmobAndroid, Builder> {
        public Integer apk_expired_time;
        public Boolean disableUpAppInfo;
        public Boolean disable_boot_mark;
        public Boolean disable_install_monitor;
        public Integer disable_up_oaid;
        public Integer enable_app_list;
        public Boolean enable_okhttp3;
        public Boolean enable_open_pkg_dir_list;
        public Boolean enable_open_pkg_list;
        public Boolean enable_permission;
        public Boolean enable_report_crash;
        public Boolean lock_play;
        public Boolean oaid_api_is_disable;
        public List<String> open_pkg_list = Internal.newMutableList();
        public Integer report_log;
        public Boolean screen_keep;
        public Integer up_wifi_list_interval;
        public Boolean use_web_source_cache;
        public Integer web_source_cache_expiration_time;

        public Builder apk_expired_time(Integer apk_expired_time) {
            this.apk_expired_time = apk_expired_time;
            return this;
        }

        public SigmobAndroid build() {
            return new SigmobAndroid(this.disableUpAppInfo, this.report_log, this.up_wifi_list_interval, this.disable_up_oaid, this.enable_permission, this.apk_expired_time, this.enable_report_crash, this.oaid_api_is_disable, this.disable_boot_mark, this.enable_okhttp3, this.enable_app_list, this.lock_play, this.screen_keep, this.open_pkg_list, this.use_web_source_cache, this.web_source_cache_expiration_time, this.disable_install_monitor, this.enable_open_pkg_list, this.enable_open_pkg_dir_list, super.buildUnknownFields());
        }

        public Builder disableUpAppInfo(Boolean disableUpAppInfo) {
            this.disableUpAppInfo = disableUpAppInfo;
            return this;
        }

        public Builder disable_boot_mark(Boolean disable_boot_mark) {
            this.disable_boot_mark = disable_boot_mark;
            return this;
        }

        public Builder disable_install_monitor(Boolean disable_install_monitor) {
            this.disable_install_monitor = disable_install_monitor;
            return this;
        }

        public Builder disable_up_oaid(Integer disable_up_oaid) {
            this.disable_up_oaid = disable_up_oaid;
            return this;
        }

        public Builder enable_app_list(Integer enable_app_list) {
            this.enable_app_list = enable_app_list;
            return this;
        }

        public Builder enable_okhttp3(Boolean enable_okhttp3) {
            this.enable_okhttp3 = enable_okhttp3;
            return this;
        }

        public Builder enable_open_pkg_dir_list(Boolean enable_open_pkg_dir_list) {
            this.enable_open_pkg_dir_list = enable_open_pkg_dir_list;
            return this;
        }

        public Builder enable_open_pkg_list(Boolean enable_open_pkg_list) {
            this.enable_open_pkg_list = enable_open_pkg_list;
            return this;
        }

        public Builder enable_permission(Boolean enable_permission) {
            this.enable_permission = enable_permission;
            return this;
        }

        public Builder enable_report_crash(Boolean enable_report_crash) {
            this.enable_report_crash = enable_report_crash;
            return this;
        }

        public Builder lock_play(Boolean lock_play) {
            this.lock_play = lock_play;
            return this;
        }

        public Builder oaid_api_is_disable(Boolean oaid_api_is_disable) {
            this.oaid_api_is_disable = oaid_api_is_disable;
            return this;
        }

        public Builder open_pkg_list(List<String> open_pkg_list) {
            Internal.checkElementsNotNull(open_pkg_list);
            this.open_pkg_list = open_pkg_list;
            return this;
        }

        public Builder report_log(Integer report_log) {
            this.report_log = report_log;
            return this;
        }

        public Builder screen_keep(Boolean screen_keep) {
            this.screen_keep = screen_keep;
            return this;
        }

        public Builder up_wifi_list_interval(Integer up_wifi_list_interval) {
            this.up_wifi_list_interval = up_wifi_list_interval;
            return this;
        }

        public Builder use_web_source_cache(Boolean use_web_source_cache) {
            this.use_web_source_cache = use_web_source_cache;
            return this;
        }

        public Builder web_source_cache_expiration_time(Integer web_source_cache_expiration_time) {
            this.web_source_cache_expiration_time = web_source_cache_expiration_time;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobAndroid extends ProtoAdapter<SigmobAndroid> {
        public ProtoAdapter_SigmobAndroid() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobAndroid.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobAndroid m1340decode(ProtoReader reader) throws IOException {
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
                        builder.disableUpAppInfo((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 2:
                        builder.report_log((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 3:
                        builder.up_wifi_list_interval((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 4:
                        builder.disable_up_oaid((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 5:
                        builder.enable_permission((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 6:
                        builder.apk_expired_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 7:
                        builder.enable_report_crash((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 8:
                        builder.oaid_api_is_disable((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 9:
                        builder.disable_boot_mark((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 10:
                        builder.enable_okhttp3((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 11:
                        builder.enable_app_list((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 12:
                        builder.lock_play((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 13:
                        builder.screen_keep((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 14:
                        builder.open_pkg_list.add((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 15:
                        builder.use_web_source_cache((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 16:
                        builder.web_source_cache_expiration_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 17:
                        builder.disable_install_monitor((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 18:
                        builder.enable_open_pkg_list((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 19:
                        builder.enable_open_pkg_dir_list((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobAndroid value) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(writer, 1, value.disableUpAppInfo);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.report_log);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.up_wifi_list_interval);
            ProtoAdapter.UINT32.encodeWithTag(writer, 4, value.disable_up_oaid);
            ProtoAdapter.BOOL.encodeWithTag(writer, 5, value.enable_permission);
            ProtoAdapter.UINT32.encodeWithTag(writer, 6, value.apk_expired_time);
            ProtoAdapter.BOOL.encodeWithTag(writer, 7, value.enable_report_crash);
            ProtoAdapter.BOOL.encodeWithTag(writer, 8, value.oaid_api_is_disable);
            ProtoAdapter.BOOL.encodeWithTag(writer, 9, value.disable_boot_mark);
            ProtoAdapter.BOOL.encodeWithTag(writer, 10, value.enable_okhttp3);
            ProtoAdapter.UINT32.encodeWithTag(writer, 11, value.enable_app_list);
            ProtoAdapter.BOOL.encodeWithTag(writer, 12, value.lock_play);
            ProtoAdapter.BOOL.encodeWithTag(writer, 13, value.screen_keep);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 14, value.open_pkg_list);
            ProtoAdapter.BOOL.encodeWithTag(writer, 15, value.use_web_source_cache);
            ProtoAdapter.UINT32.encodeWithTag(writer, 16, value.web_source_cache_expiration_time);
            ProtoAdapter.BOOL.encodeWithTag(writer, 17, value.disable_install_monitor);
            ProtoAdapter.BOOL.encodeWithTag(writer, 18, value.enable_open_pkg_list);
            ProtoAdapter.BOOL.encodeWithTag(writer, 19, value.enable_open_pkg_dir_list);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobAndroid value) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, value.disableUpAppInfo) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.report_log) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.up_wifi_list_interval) + ProtoAdapter.UINT32.encodedSizeWithTag(4, value.disable_up_oaid) + ProtoAdapter.BOOL.encodedSizeWithTag(5, value.enable_permission) + ProtoAdapter.UINT32.encodedSizeWithTag(6, value.apk_expired_time) + ProtoAdapter.BOOL.encodedSizeWithTag(7, value.enable_report_crash) + ProtoAdapter.BOOL.encodedSizeWithTag(8, value.oaid_api_is_disable) + ProtoAdapter.BOOL.encodedSizeWithTag(9, value.disable_boot_mark) + ProtoAdapter.BOOL.encodedSizeWithTag(10, value.enable_okhttp3) + ProtoAdapter.UINT32.encodedSizeWithTag(11, value.enable_app_list) + ProtoAdapter.BOOL.encodedSizeWithTag(12, value.lock_play) + ProtoAdapter.BOOL.encodedSizeWithTag(13, value.screen_keep) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(14, value.open_pkg_list) + ProtoAdapter.BOOL.encodedSizeWithTag(15, value.use_web_source_cache) + ProtoAdapter.UINT32.encodedSizeWithTag(16, value.web_source_cache_expiration_time) + ProtoAdapter.BOOL.encodedSizeWithTag(17, value.disable_install_monitor) + ProtoAdapter.BOOL.encodedSizeWithTag(18, value.enable_open_pkg_list) + ProtoAdapter.BOOL.encodedSizeWithTag(19, value.enable_open_pkg_dir_list) + value.unknownFields().size();
        }

        public SigmobAndroid redact(SigmobAndroid value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobAndroid protoAdapter_SigmobAndroid = new ProtoAdapter_SigmobAndroid();
        ADAPTER = protoAdapter_SigmobAndroid;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobAndroid);
        DEFAULT_DISABLEUPAPPINFO = false;
        DEFAULT_REPORT_LOG = 0;
        DEFAULT_UP_WIFI_LIST_INTERVAL = 0;
        DEFAULT_DISABLE_UP_OAID = 0;
        DEFAULT_ENABLE_PERMISSION = false;
        DEFAULT_APK_EXPIRED_TIME = 0;
        DEFAULT_ENABLE_REPORT_CRASH = false;
        DEFAULT_OAID_API_IS_DISABLE = false;
        DEFAULT_DISABLE_BOOT_MARK = false;
        DEFAULT_ENABLE_OKHTTP3 = false;
        DEFAULT_ENABLE_APP_LIST = 0;
        DEFAULT_LOCK_PLAY = false;
        DEFAULT_SCREEN_KEEP = false;
        DEFAULT_USE_WEB_SOURCE_CACHE = false;
        DEFAULT_WEB_SOURCE_CACHE_EXPIRATION_TIME = 0;
        DEFAULT_DISABLE_INSTALL_MONITOR = false;
        DEFAULT_ENABLE_OPEN_PKG_LIST = false;
        DEFAULT_ENABLE_OPEN_PKG_DIR_LIST = false;
    }

    public SigmobAndroid(Boolean disableUpAppInfo, Integer report_log, Integer up_wifi_list_interval, Integer disable_up_oaid, Boolean enable_permission, Integer apk_expired_time, Boolean enable_report_crash, Boolean oaid_api_is_disable, Boolean disable_boot_mark, Boolean enable_okhttp3, Integer enable_app_list, Boolean lock_play, Boolean screen_keep, List<String> open_pkg_list, Boolean use_web_source_cache, Integer web_source_cache_expiration_time, Boolean disable_install_monitor, Boolean enable_open_pkg_list, Boolean enable_open_pkg_dir_list) {
        this(disableUpAppInfo, report_log, up_wifi_list_interval, disable_up_oaid, enable_permission, apk_expired_time, enable_report_crash, oaid_api_is_disable, disable_boot_mark, enable_okhttp3, enable_app_list, lock_play, screen_keep, open_pkg_list, use_web_source_cache, web_source_cache_expiration_time, disable_install_monitor, enable_open_pkg_list, enable_open_pkg_dir_list, ByteString.EMPTY);
    }

    public SigmobAndroid(Boolean disableUpAppInfo, Integer report_log, Integer up_wifi_list_interval, Integer disable_up_oaid, Boolean enable_permission, Integer apk_expired_time, Boolean enable_report_crash, Boolean oaid_api_is_disable, Boolean disable_boot_mark, Boolean enable_okhttp3, Integer enable_app_list, Boolean lock_play, Boolean screen_keep, List<String> open_pkg_list, Boolean use_web_source_cache, Integer web_source_cache_expiration_time, Boolean disable_install_monitor, Boolean enable_open_pkg_list, Boolean enable_open_pkg_dir_list, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.disableUpAppInfo = disableUpAppInfo;
        this.report_log = report_log;
        this.up_wifi_list_interval = up_wifi_list_interval;
        this.disable_up_oaid = disable_up_oaid;
        this.enable_permission = enable_permission;
        this.apk_expired_time = apk_expired_time;
        this.enable_report_crash = enable_report_crash;
        this.oaid_api_is_disable = oaid_api_is_disable;
        this.disable_boot_mark = disable_boot_mark;
        this.enable_okhttp3 = enable_okhttp3;
        this.enable_app_list = enable_app_list;
        this.lock_play = lock_play;
        this.screen_keep = screen_keep;
        this.open_pkg_list = Internal.immutableCopyOf("open_pkg_list", open_pkg_list);
        this.use_web_source_cache = use_web_source_cache;
        this.web_source_cache_expiration_time = web_source_cache_expiration_time;
        this.disable_install_monitor = disable_install_monitor;
        this.enable_open_pkg_list = enable_open_pkg_list;
        this.enable_open_pkg_dir_list = enable_open_pkg_dir_list;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobAndroid)) {
            return false;
        }
        SigmobAndroid sigmobAndroid = (SigmobAndroid) other;
        return unknownFields().equals(sigmobAndroid.unknownFields()) && Internal.equals(this.disableUpAppInfo, sigmobAndroid.disableUpAppInfo) && Internal.equals(this.report_log, sigmobAndroid.report_log) && Internal.equals(this.up_wifi_list_interval, sigmobAndroid.up_wifi_list_interval) && Internal.equals(this.disable_up_oaid, sigmobAndroid.disable_up_oaid) && Internal.equals(this.enable_permission, sigmobAndroid.enable_permission) && Internal.equals(this.apk_expired_time, sigmobAndroid.apk_expired_time) && Internal.equals(this.enable_report_crash, sigmobAndroid.enable_report_crash) && Internal.equals(this.oaid_api_is_disable, sigmobAndroid.oaid_api_is_disable) && Internal.equals(this.disable_boot_mark, sigmobAndroid.disable_boot_mark) && Internal.equals(this.enable_okhttp3, sigmobAndroid.enable_okhttp3) && Internal.equals(this.enable_app_list, sigmobAndroid.enable_app_list) && Internal.equals(this.lock_play, sigmobAndroid.lock_play) && Internal.equals(this.screen_keep, sigmobAndroid.screen_keep) && this.open_pkg_list.equals(sigmobAndroid.open_pkg_list) && Internal.equals(this.use_web_source_cache, sigmobAndroid.use_web_source_cache) && Internal.equals(this.web_source_cache_expiration_time, sigmobAndroid.web_source_cache_expiration_time) && Internal.equals(this.disable_install_monitor, sigmobAndroid.disable_install_monitor) && Internal.equals(this.enable_open_pkg_list, sigmobAndroid.enable_open_pkg_list) && Internal.equals(this.enable_open_pkg_dir_list, sigmobAndroid.enable_open_pkg_dir_list);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.disableUpAppInfo;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.report_log;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.up_wifi_list_interval;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.disable_up_oaid;
        int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool2 = this.enable_permission;
        int iHashCode6 = (iHashCode5 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num4 = this.apk_expired_time;
        int iHashCode7 = (iHashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool3 = this.enable_report_crash;
        int iHashCode8 = (iHashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.oaid_api_is_disable;
        int iHashCode9 = (iHashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.disable_boot_mark;
        int iHashCode10 = (iHashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.enable_okhttp3;
        int iHashCode11 = (iHashCode10 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num5 = this.enable_app_list;
        int iHashCode12 = (iHashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool7 = this.lock_play;
        int iHashCode13 = (iHashCode12 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.screen_keep;
        int iHashCode14 = (((iHashCode13 + (bool8 != null ? bool8.hashCode() : 0)) * 37) + this.open_pkg_list.hashCode()) * 37;
        Boolean bool9 = this.use_web_source_cache;
        int iHashCode15 = (iHashCode14 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        Integer num6 = this.web_source_cache_expiration_time;
        int iHashCode16 = (iHashCode15 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool10 = this.disable_install_monitor;
        int iHashCode17 = (iHashCode16 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        Boolean bool11 = this.enable_open_pkg_list;
        int iHashCode18 = (iHashCode17 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
        Boolean bool12 = this.enable_open_pkg_dir_list;
        int iHashCode19 = iHashCode18 + (bool12 != null ? bool12.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode19;
        return iHashCode19;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.disableUpAppInfo = this.disableUpAppInfo;
        builder.report_log = this.report_log;
        builder.up_wifi_list_interval = this.up_wifi_list_interval;
        builder.disable_up_oaid = this.disable_up_oaid;
        builder.enable_permission = this.enable_permission;
        builder.apk_expired_time = this.apk_expired_time;
        builder.enable_report_crash = this.enable_report_crash;
        builder.oaid_api_is_disable = this.oaid_api_is_disable;
        builder.disable_boot_mark = this.disable_boot_mark;
        builder.enable_okhttp3 = this.enable_okhttp3;
        builder.enable_app_list = this.enable_app_list;
        builder.lock_play = this.lock_play;
        builder.screen_keep = this.screen_keep;
        builder.open_pkg_list = Internal.copyOf("open_pkg_list", this.open_pkg_list);
        builder.use_web_source_cache = this.use_web_source_cache;
        builder.web_source_cache_expiration_time = this.web_source_cache_expiration_time;
        builder.disable_install_monitor = this.disable_install_monitor;
        builder.enable_open_pkg_list = this.enable_open_pkg_list;
        builder.enable_open_pkg_dir_list = this.enable_open_pkg_dir_list;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.disableUpAppInfo != null) {
            sb.append(", disableUpAppInfo=").append(this.disableUpAppInfo);
        }
        if (this.report_log != null) {
            sb.append(", report_log=").append(this.report_log);
        }
        if (this.up_wifi_list_interval != null) {
            sb.append(", up_wifi_list_interval=").append(this.up_wifi_list_interval);
        }
        if (this.disable_up_oaid != null) {
            sb.append(", disable_up_oaid=").append(this.disable_up_oaid);
        }
        if (this.enable_permission != null) {
            sb.append(", enable_permission=").append(this.enable_permission);
        }
        if (this.apk_expired_time != null) {
            sb.append(", apk_expired_time=").append(this.apk_expired_time);
        }
        if (this.enable_report_crash != null) {
            sb.append(", enable_report_crash=").append(this.enable_report_crash);
        }
        if (this.oaid_api_is_disable != null) {
            sb.append(", oaid_api_is_disable=").append(this.oaid_api_is_disable);
        }
        if (this.disable_boot_mark != null) {
            sb.append(", disable_boot_mark=").append(this.disable_boot_mark);
        }
        if (this.enable_okhttp3 != null) {
            sb.append(", enable_okhttp3=").append(this.enable_okhttp3);
        }
        if (this.enable_app_list != null) {
            sb.append(", enable_app_list=").append(this.enable_app_list);
        }
        if (this.lock_play != null) {
            sb.append(", lock_play=").append(this.lock_play);
        }
        if (this.screen_keep != null) {
            sb.append(", screen_keep=").append(this.screen_keep);
        }
        if (!this.open_pkg_list.isEmpty()) {
            sb.append(", open_pkg_list=").append(this.open_pkg_list);
        }
        if (this.use_web_source_cache != null) {
            sb.append(", use_web_source_cache=").append(this.use_web_source_cache);
        }
        if (this.web_source_cache_expiration_time != null) {
            sb.append(", web_source_cache_expiration_time=").append(this.web_source_cache_expiration_time);
        }
        if (this.disable_install_monitor != null) {
            sb.append(", disable_install_monitor=").append(this.disable_install_monitor);
        }
        if (this.enable_open_pkg_list != null) {
            sb.append(", enable_open_pkg_list=").append(this.enable_open_pkg_list);
        }
        if (this.enable_open_pkg_dir_list != null) {
            sb.append(", enable_open_pkg_dir_list=").append(this.enable_open_pkg_dir_list);
        }
        return sb.replace(0, 2, "SigmobAndroid{").append('}').toString();
    }
}
