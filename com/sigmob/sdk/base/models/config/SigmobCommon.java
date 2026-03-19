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
public final class SigmobCommon extends AndroidMessage<SigmobCommon, Builder> {
    public static final ProtoAdapter<SigmobCommon> ADAPTER;
    public static final Parcelable.Creator<SigmobCommon> CREATOR;
    public static final Integer DEFAULT_CONFIGREFRESH;
    public static final Boolean DEFAULT_DISABLE_UP_LOCATION;
    public static final Boolean DEFAULT_ENABLE_ACTIVE_EXPIRE;
    public static final Boolean DEFAULT_ENABLE_DEBUG_LEVEL;
    public static final Boolean DEFAULT_ENABLE_EXTRA_DCLOG;
    public static final Integer DEFAULT_EXPIRE_MONITOR_INTERVAL;
    public static final Boolean DEFAULT_FEEDBACK_DEBUG;
    public static final Boolean DEFAULT_IS_GDPR_REGION;
    public static final Integer DEFAULT_LOAD_INTERVAL;
    public static final Boolean DEFAULT_LOG_ENC;
    public static final Integer DEFAULT_MAX_SEND_LOG_RECORDS;
    public static final Integer DEFAULT_NETWORK_TIMEOUT;
    public static final Boolean DEFAULT_NONCOMPLIANCE_MARK;
    public static final Integer DEFAULT_SEND_LOG_INTERVAL;
    public static final Integer DEFAULT_SNIFFING_TYPE;
    public static final Integer DEFAULT_TRACKING_EXPIRATION_TIME;
    public static final Integer DEFAULT_TRACKING_RETRY_INTERVAL;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobAntiFraudLogConfig#ADAPTER", tag = 7)
    public final SigmobAntiFraudLogConfig anti_fraud_log;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer configRefresh;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 13)
    public final List<Integer> dclog_blacklist;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    public final Boolean disable_up_location;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 23)
    public final Boolean enable_active_expire;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 14)
    public final Boolean enable_debug_level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 19)
    public final Boolean enable_extra_dclog;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobCommonEndpointsConfig#ADAPTER", tag = 1)
    public final SigmobCommonEndpointsConfig endpoints;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 22)
    public final Integer expire_monitor_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    public final Boolean feedback_debug;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean is_gdpr_region;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 15)
    public final Integer load_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean log_enc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer max_send_log_records;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobNativeConfig#ADAPTER", tag = 4)
    public final SigmobNativeConfig native_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 20)
    public final Integer network_timeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 21)
    public final Boolean noncompliance_mark;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobRvConfig#ADAPTER", tag = 2)
    public final SigmobRvConfig rv_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 12)
    public final Integer send_log_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 24)
    public final Integer sniffing_type;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobSplashConfig#ADAPTER", tag = 3)
    public final SigmobSplashConfig splash_config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer tracking_expiration_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer tracking_retry_interval;

    public static final class Builder extends Message.Builder<SigmobCommon, Builder> {
        public SigmobAntiFraudLogConfig anti_fraud_log;
        public SigmobCommonEndpointsConfig endpoints;
        public SigmobNativeConfig native_config;
        public SigmobRvConfig rv_config;
        public SigmobSplashConfig splash_config;
        public Integer configRefresh = SigmobCommon.DEFAULT_CONFIGREFRESH;
        public Boolean is_gdpr_region = SigmobCommon.DEFAULT_IS_GDPR_REGION;
        public Integer tracking_expiration_time = SigmobCommon.DEFAULT_TRACKING_EXPIRATION_TIME;
        public Integer tracking_retry_interval = SigmobCommon.DEFAULT_TRACKING_RETRY_INTERVAL;
        public Integer max_send_log_records = SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS;
        public Integer send_log_interval = SigmobCommon.DEFAULT_SEND_LOG_INTERVAL;
        public Boolean enable_debug_level = SigmobCommon.DEFAULT_ENABLE_DEBUG_LEVEL;
        public Integer load_interval = SigmobCommon.DEFAULT_LOAD_INTERVAL;
        public Boolean disable_up_location = SigmobCommon.DEFAULT_DISABLE_UP_LOCATION;
        public Boolean log_enc = SigmobCommon.DEFAULT_LOG_ENC;
        public Boolean feedback_debug = SigmobCommon.DEFAULT_FEEDBACK_DEBUG;
        public Boolean enable_extra_dclog = SigmobCommon.DEFAULT_ENABLE_EXTRA_DCLOG;
        public Integer network_timeout = SigmobCommon.DEFAULT_NETWORK_TIMEOUT;
        public Boolean noncompliance_mark = SigmobCommon.DEFAULT_NONCOMPLIANCE_MARK;
        public Integer expire_monitor_interval = SigmobCommon.DEFAULT_EXPIRE_MONITOR_INTERVAL;
        public Boolean enable_active_expire = SigmobCommon.DEFAULT_ENABLE_ACTIVE_EXPIRE;
        public Integer sniffing_type = SigmobCommon.DEFAULT_SNIFFING_TYPE;
        public List<Integer> dclog_blacklist = Internal.newMutableList();

        public Builder anti_fraud_log(SigmobAntiFraudLogConfig anti_fraud_log) {
            this.anti_fraud_log = anti_fraud_log;
            return this;
        }

        public SigmobCommon build() {
            return new SigmobCommon(this.endpoints, this.rv_config, this.splash_config, this.native_config, this.configRefresh, this.anti_fraud_log, this.is_gdpr_region, this.tracking_expiration_time, this.tracking_retry_interval, this.max_send_log_records, this.send_log_interval, this.dclog_blacklist, this.enable_debug_level, this.load_interval, this.disable_up_location, this.log_enc, this.feedback_debug, this.enable_extra_dclog, this.network_timeout, this.noncompliance_mark, this.expire_monitor_interval, this.enable_active_expire, this.sniffing_type, super.buildUnknownFields());
        }

        public Builder configRefresh(Integer configRefresh) {
            this.configRefresh = configRefresh;
            return this;
        }

        public Builder dclog_blacklist(List<Integer> dclog_blacklist) {
            Internal.checkElementsNotNull(dclog_blacklist);
            this.dclog_blacklist = dclog_blacklist;
            return this;
        }

        public Builder disable_up_location(Boolean disable_up_location) {
            this.disable_up_location = disable_up_location;
            return this;
        }

        public Builder enable_active_expire(Boolean enable_active_expire) {
            this.enable_active_expire = enable_active_expire;
            return this;
        }

        public Builder enable_debug_level(Boolean enable_debug_level) {
            this.enable_debug_level = enable_debug_level;
            return this;
        }

        public Builder enable_extra_dclog(Boolean enable_extra_dclog) {
            this.enable_extra_dclog = enable_extra_dclog;
            return this;
        }

        public Builder endpoints(SigmobCommonEndpointsConfig endpoints) {
            this.endpoints = endpoints;
            return this;
        }

        public Builder expire_monitor_interval(Integer expire_monitor_interval) {
            this.expire_monitor_interval = expire_monitor_interval;
            return this;
        }

        public Builder feedback_debug(Boolean feedback_debug) {
            this.feedback_debug = feedback_debug;
            return this;
        }

        public Builder is_gdpr_region(Boolean is_gdpr_region) {
            this.is_gdpr_region = is_gdpr_region;
            return this;
        }

        public Builder load_interval(Integer load_interval) {
            this.load_interval = load_interval;
            return this;
        }

        public Builder log_enc(Boolean log_enc) {
            this.log_enc = log_enc;
            return this;
        }

        public Builder max_send_log_records(Integer max_send_log_records) {
            this.max_send_log_records = max_send_log_records;
            return this;
        }

        public Builder native_config(SigmobNativeConfig native_config) {
            this.native_config = native_config;
            return this;
        }

        public Builder network_timeout(Integer network_timeout) {
            this.network_timeout = network_timeout;
            return this;
        }

        public Builder noncompliance_mark(Boolean noncompliance_mark) {
            this.noncompliance_mark = noncompliance_mark;
            return this;
        }

        public Builder rv_config(SigmobRvConfig rv_config) {
            this.rv_config = rv_config;
            return this;
        }

        public Builder send_log_interval(Integer send_log_interval) {
            this.send_log_interval = send_log_interval;
            return this;
        }

        public Builder sniffing_type(Integer sniffing_type) {
            this.sniffing_type = sniffing_type;
            return this;
        }

        public Builder splash_config(SigmobSplashConfig splash_config) {
            this.splash_config = splash_config;
            return this;
        }

        public Builder tracking_expiration_time(Integer tracking_expiration_time) {
            this.tracking_expiration_time = tracking_expiration_time;
            return this;
        }

        public Builder tracking_retry_interval(Integer tracking_retry_interval) {
            this.tracking_retry_interval = tracking_retry_interval;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobCommon extends ProtoAdapter<SigmobCommon> {
        public ProtoAdapter_SigmobCommon() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobCommon.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobCommon m1346decode(ProtoReader reader) throws IOException {
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
                        builder.endpoints((SigmobCommonEndpointsConfig) SigmobCommonEndpointsConfig.ADAPTER.decode(reader));
                        break;
                    case 2:
                        builder.rv_config((SigmobRvConfig) SigmobRvConfig.ADAPTER.decode(reader));
                        break;
                    case 3:
                        builder.splash_config((SigmobSplashConfig) SigmobSplashConfig.ADAPTER.decode(reader));
                        break;
                    case 4:
                        builder.native_config((SigmobNativeConfig) SigmobNativeConfig.ADAPTER.decode(reader));
                        break;
                    case 5:
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                    case 6:
                        builder.configRefresh((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 7:
                        builder.anti_fraud_log((SigmobAntiFraudLogConfig) SigmobAntiFraudLogConfig.ADAPTER.decode(reader));
                        break;
                    case 8:
                        builder.is_gdpr_region((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 9:
                        builder.tracking_expiration_time((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 10:
                        builder.tracking_retry_interval((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 11:
                        builder.max_send_log_records((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 12:
                        builder.send_log_interval((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 13:
                        builder.dclog_blacklist.add((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 14:
                        builder.enable_debug_level((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 15:
                        builder.load_interval((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 16:
                        builder.disable_up_location((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 17:
                        builder.log_enc((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 18:
                        builder.feedback_debug((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 19:
                        builder.enable_extra_dclog((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 20:
                        builder.network_timeout((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 21:
                        builder.noncompliance_mark((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 22:
                        builder.expire_monitor_interval((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 23:
                        builder.enable_active_expire((Boolean) ProtoAdapter.BOOL.decode(reader));
                        break;
                    case 24:
                        builder.sniffing_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobCommon value) throws IOException {
            SigmobCommonEndpointsConfig.ADAPTER.encodeWithTag(writer, 1, value.endpoints);
            SigmobRvConfig.ADAPTER.encodeWithTag(writer, 2, value.rv_config);
            SigmobSplashConfig.ADAPTER.encodeWithTag(writer, 3, value.splash_config);
            SigmobNativeConfig.ADAPTER.encodeWithTag(writer, 4, value.native_config);
            ProtoAdapter.UINT32.encodeWithTag(writer, 6, value.configRefresh);
            SigmobAntiFraudLogConfig.ADAPTER.encodeWithTag(writer, 7, value.anti_fraud_log);
            ProtoAdapter.BOOL.encodeWithTag(writer, 8, value.is_gdpr_region);
            ProtoAdapter.UINT32.encodeWithTag(writer, 9, value.tracking_expiration_time);
            ProtoAdapter.UINT32.encodeWithTag(writer, 10, value.tracking_retry_interval);
            ProtoAdapter.UINT32.encodeWithTag(writer, 11, value.max_send_log_records);
            ProtoAdapter.UINT32.encodeWithTag(writer, 12, value.send_log_interval);
            ProtoAdapter.UINT32.asRepeated().encodeWithTag(writer, 13, value.dclog_blacklist);
            ProtoAdapter.BOOL.encodeWithTag(writer, 14, value.enable_debug_level);
            ProtoAdapter.UINT32.encodeWithTag(writer, 15, value.load_interval);
            ProtoAdapter.BOOL.encodeWithTag(writer, 16, value.disable_up_location);
            ProtoAdapter.BOOL.encodeWithTag(writer, 17, value.log_enc);
            ProtoAdapter.BOOL.encodeWithTag(writer, 18, value.feedback_debug);
            ProtoAdapter.BOOL.encodeWithTag(writer, 19, value.enable_extra_dclog);
            ProtoAdapter.UINT32.encodeWithTag(writer, 20, value.network_timeout);
            ProtoAdapter.BOOL.encodeWithTag(writer, 21, value.noncompliance_mark);
            ProtoAdapter.UINT32.encodeWithTag(writer, 22, value.expire_monitor_interval);
            ProtoAdapter.BOOL.encodeWithTag(writer, 23, value.enable_active_expire);
            ProtoAdapter.UINT32.encodeWithTag(writer, 24, value.sniffing_type);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobCommon value) {
            return SigmobCommonEndpointsConfig.ADAPTER.encodedSizeWithTag(1, value.endpoints) + SigmobRvConfig.ADAPTER.encodedSizeWithTag(2, value.rv_config) + SigmobSplashConfig.ADAPTER.encodedSizeWithTag(3, value.splash_config) + SigmobNativeConfig.ADAPTER.encodedSizeWithTag(4, value.native_config) + ProtoAdapter.UINT32.encodedSizeWithTag(6, value.configRefresh) + SigmobAntiFraudLogConfig.ADAPTER.encodedSizeWithTag(7, value.anti_fraud_log) + ProtoAdapter.BOOL.encodedSizeWithTag(8, value.is_gdpr_region) + ProtoAdapter.UINT32.encodedSizeWithTag(9, value.tracking_expiration_time) + ProtoAdapter.UINT32.encodedSizeWithTag(10, value.tracking_retry_interval) + ProtoAdapter.UINT32.encodedSizeWithTag(11, value.max_send_log_records) + ProtoAdapter.UINT32.encodedSizeWithTag(12, value.send_log_interval) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(13, value.dclog_blacklist) + ProtoAdapter.BOOL.encodedSizeWithTag(14, value.enable_debug_level) + ProtoAdapter.UINT32.encodedSizeWithTag(15, value.load_interval) + ProtoAdapter.BOOL.encodedSizeWithTag(16, value.disable_up_location) + ProtoAdapter.BOOL.encodedSizeWithTag(17, value.log_enc) + ProtoAdapter.BOOL.encodedSizeWithTag(18, value.feedback_debug) + ProtoAdapter.BOOL.encodedSizeWithTag(19, value.enable_extra_dclog) + ProtoAdapter.UINT32.encodedSizeWithTag(20, value.network_timeout) + ProtoAdapter.BOOL.encodedSizeWithTag(21, value.noncompliance_mark) + ProtoAdapter.UINT32.encodedSizeWithTag(22, value.expire_monitor_interval) + ProtoAdapter.BOOL.encodedSizeWithTag(23, value.enable_active_expire) + ProtoAdapter.UINT32.encodedSizeWithTag(24, value.sniffing_type) + value.unknownFields().size();
        }

        public SigmobCommon redact(SigmobCommon value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.endpoints != null) {
                builderNewBuilder.endpoints = (SigmobCommonEndpointsConfig) SigmobCommonEndpointsConfig.ADAPTER.redact(builderNewBuilder.endpoints);
            }
            if (builderNewBuilder.rv_config != null) {
                builderNewBuilder.rv_config = (SigmobRvConfig) SigmobRvConfig.ADAPTER.redact(builderNewBuilder.rv_config);
            }
            if (builderNewBuilder.splash_config != null) {
                builderNewBuilder.splash_config = (SigmobSplashConfig) SigmobSplashConfig.ADAPTER.redact(builderNewBuilder.splash_config);
            }
            if (builderNewBuilder.native_config != null) {
                builderNewBuilder.native_config = (SigmobNativeConfig) SigmobNativeConfig.ADAPTER.redact(builderNewBuilder.native_config);
            }
            if (builderNewBuilder.anti_fraud_log != null) {
                builderNewBuilder.anti_fraud_log = (SigmobAntiFraudLogConfig) SigmobAntiFraudLogConfig.ADAPTER.redact(builderNewBuilder.anti_fraud_log);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobCommon protoAdapter_SigmobCommon = new ProtoAdapter_SigmobCommon();
        ADAPTER = protoAdapter_SigmobCommon;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobCommon);
        DEFAULT_CONFIGREFRESH = 0;
        DEFAULT_IS_GDPR_REGION = false;
        DEFAULT_TRACKING_EXPIRATION_TIME = 0;
        DEFAULT_TRACKING_RETRY_INTERVAL = 0;
        DEFAULT_MAX_SEND_LOG_RECORDS = 0;
        DEFAULT_SEND_LOG_INTERVAL = 0;
        DEFAULT_ENABLE_DEBUG_LEVEL = false;
        DEFAULT_LOAD_INTERVAL = 0;
        DEFAULT_DISABLE_UP_LOCATION = false;
        DEFAULT_LOG_ENC = false;
        DEFAULT_FEEDBACK_DEBUG = false;
        DEFAULT_ENABLE_EXTRA_DCLOG = false;
        DEFAULT_NETWORK_TIMEOUT = 0;
        DEFAULT_NONCOMPLIANCE_MARK = false;
        DEFAULT_EXPIRE_MONITOR_INTERVAL = 0;
        DEFAULT_ENABLE_ACTIVE_EXPIRE = false;
        DEFAULT_SNIFFING_TYPE = 0;
    }

    public SigmobCommon(SigmobCommonEndpointsConfig endpoints, SigmobRvConfig rv_config, SigmobSplashConfig splash_config, SigmobNativeConfig native_config, Integer configRefresh, SigmobAntiFraudLogConfig anti_fraud_log, Boolean is_gdpr_region, Integer tracking_expiration_time, Integer tracking_retry_interval, Integer max_send_log_records, Integer send_log_interval, List<Integer> dclog_blacklist, Boolean enable_debug_level, Integer load_interval, Boolean disable_up_location, Boolean log_enc, Boolean feedback_debug, Boolean enable_extra_dclog, Integer network_timeout, Boolean noncompliance_mark, Integer expire_monitor_interval, Boolean enable_active_expire, Integer sniffing_type) {
        this(endpoints, rv_config, splash_config, native_config, configRefresh, anti_fraud_log, is_gdpr_region, tracking_expiration_time, tracking_retry_interval, max_send_log_records, send_log_interval, dclog_blacklist, enable_debug_level, load_interval, disable_up_location, log_enc, feedback_debug, enable_extra_dclog, network_timeout, noncompliance_mark, expire_monitor_interval, enable_active_expire, sniffing_type, ByteString.EMPTY);
    }

    public SigmobCommon(SigmobCommonEndpointsConfig endpoints, SigmobRvConfig rv_config, SigmobSplashConfig splash_config, SigmobNativeConfig native_config, Integer configRefresh, SigmobAntiFraudLogConfig anti_fraud_log, Boolean is_gdpr_region, Integer tracking_expiration_time, Integer tracking_retry_interval, Integer max_send_log_records, Integer send_log_interval, List<Integer> dclog_blacklist, Boolean enable_debug_level, Integer load_interval, Boolean disable_up_location, Boolean log_enc, Boolean feedback_debug, Boolean enable_extra_dclog, Integer network_timeout, Boolean noncompliance_mark, Integer expire_monitor_interval, Boolean enable_active_expire, Integer sniffing_type, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.endpoints = endpoints;
        this.rv_config = rv_config;
        this.splash_config = splash_config;
        this.native_config = native_config;
        this.configRefresh = configRefresh;
        this.anti_fraud_log = anti_fraud_log;
        this.is_gdpr_region = is_gdpr_region;
        this.tracking_expiration_time = tracking_expiration_time;
        this.tracking_retry_interval = tracking_retry_interval;
        this.max_send_log_records = max_send_log_records;
        this.send_log_interval = send_log_interval;
        this.dclog_blacklist = Internal.immutableCopyOf("dclog_blacklist", dclog_blacklist);
        this.enable_debug_level = enable_debug_level;
        this.load_interval = load_interval;
        this.disable_up_location = disable_up_location;
        this.log_enc = log_enc;
        this.feedback_debug = feedback_debug;
        this.enable_extra_dclog = enable_extra_dclog;
        this.network_timeout = network_timeout;
        this.noncompliance_mark = noncompliance_mark;
        this.expire_monitor_interval = expire_monitor_interval;
        this.enable_active_expire = enable_active_expire;
        this.sniffing_type = sniffing_type;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobCommon)) {
            return false;
        }
        SigmobCommon sigmobCommon = (SigmobCommon) other;
        return unknownFields().equals(sigmobCommon.unknownFields()) && Internal.equals(this.endpoints, sigmobCommon.endpoints) && Internal.equals(this.rv_config, sigmobCommon.rv_config) && Internal.equals(this.splash_config, sigmobCommon.splash_config) && Internal.equals(this.native_config, sigmobCommon.native_config) && Internal.equals(this.configRefresh, sigmobCommon.configRefresh) && Internal.equals(this.anti_fraud_log, sigmobCommon.anti_fraud_log) && Internal.equals(this.is_gdpr_region, sigmobCommon.is_gdpr_region) && Internal.equals(this.tracking_expiration_time, sigmobCommon.tracking_expiration_time) && Internal.equals(this.tracking_retry_interval, sigmobCommon.tracking_retry_interval) && Internal.equals(this.max_send_log_records, sigmobCommon.max_send_log_records) && Internal.equals(this.send_log_interval, sigmobCommon.send_log_interval) && this.dclog_blacklist.equals(sigmobCommon.dclog_blacklist) && Internal.equals(this.enable_debug_level, sigmobCommon.enable_debug_level) && Internal.equals(this.load_interval, sigmobCommon.load_interval) && Internal.equals(this.disable_up_location, sigmobCommon.disable_up_location) && Internal.equals(this.log_enc, sigmobCommon.log_enc) && Internal.equals(this.feedback_debug, sigmobCommon.feedback_debug) && Internal.equals(this.enable_extra_dclog, sigmobCommon.enable_extra_dclog) && Internal.equals(this.network_timeout, sigmobCommon.network_timeout) && Internal.equals(this.noncompliance_mark, sigmobCommon.noncompliance_mark) && Internal.equals(this.expire_monitor_interval, sigmobCommon.expire_monitor_interval) && Internal.equals(this.enable_active_expire, sigmobCommon.enable_active_expire) && Internal.equals(this.sniffing_type, sigmobCommon.sniffing_type);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        SigmobCommonEndpointsConfig sigmobCommonEndpointsConfig = this.endpoints;
        int iHashCode2 = (iHashCode + (sigmobCommonEndpointsConfig != null ? sigmobCommonEndpointsConfig.hashCode() : 0)) * 37;
        SigmobRvConfig sigmobRvConfig = this.rv_config;
        int iHashCode3 = (iHashCode2 + (sigmobRvConfig != null ? sigmobRvConfig.hashCode() : 0)) * 37;
        SigmobSplashConfig sigmobSplashConfig = this.splash_config;
        int iHashCode4 = (iHashCode3 + (sigmobSplashConfig != null ? sigmobSplashConfig.hashCode() : 0)) * 37;
        SigmobNativeConfig sigmobNativeConfig = this.native_config;
        int iHashCode5 = (iHashCode4 + (sigmobNativeConfig != null ? sigmobNativeConfig.hashCode() : 0)) * 37;
        Integer num = this.configRefresh;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = this.anti_fraud_log;
        int iHashCode7 = (iHashCode6 + (sigmobAntiFraudLogConfig != null ? sigmobAntiFraudLogConfig.hashCode() : 0)) * 37;
        Boolean bool = this.is_gdpr_region;
        int iHashCode8 = (iHashCode7 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.tracking_expiration_time;
        int iHashCode9 = (iHashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.tracking_retry_interval;
        int iHashCode10 = (iHashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.max_send_log_records;
        int iHashCode11 = (iHashCode10 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.send_log_interval;
        int iHashCode12 = (((iHashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37) + this.dclog_blacklist.hashCode()) * 37;
        Boolean bool2 = this.enable_debug_level;
        int iHashCode13 = (iHashCode12 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num6 = this.load_interval;
        int iHashCode14 = (iHashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool3 = this.disable_up_location;
        int iHashCode15 = (iHashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.log_enc;
        int iHashCode16 = (iHashCode15 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.feedback_debug;
        int iHashCode17 = (iHashCode16 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.enable_extra_dclog;
        int iHashCode18 = (iHashCode17 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Integer num7 = this.network_timeout;
        int iHashCode19 = (iHashCode18 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Boolean bool7 = this.noncompliance_mark;
        int iHashCode20 = (iHashCode19 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Integer num8 = this.expire_monitor_interval;
        int iHashCode21 = (iHashCode20 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Boolean bool8 = this.enable_active_expire;
        int iHashCode22 = (iHashCode21 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        Integer num9 = this.sniffing_type;
        int iHashCode23 = iHashCode22 + (num9 != null ? num9.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode23;
        return iHashCode23;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.endpoints = this.endpoints;
        builder.rv_config = this.rv_config;
        builder.splash_config = this.splash_config;
        builder.native_config = this.native_config;
        builder.configRefresh = this.configRefresh;
        builder.anti_fraud_log = this.anti_fraud_log;
        builder.is_gdpr_region = this.is_gdpr_region;
        builder.tracking_expiration_time = this.tracking_expiration_time;
        builder.tracking_retry_interval = this.tracking_retry_interval;
        builder.max_send_log_records = this.max_send_log_records;
        builder.send_log_interval = this.send_log_interval;
        builder.dclog_blacklist = Internal.copyOf("dclog_blacklist", this.dclog_blacklist);
        builder.enable_debug_level = this.enable_debug_level;
        builder.load_interval = this.load_interval;
        builder.disable_up_location = this.disable_up_location;
        builder.log_enc = this.log_enc;
        builder.feedback_debug = this.feedback_debug;
        builder.enable_extra_dclog = this.enable_extra_dclog;
        builder.network_timeout = this.network_timeout;
        builder.noncompliance_mark = this.noncompliance_mark;
        builder.expire_monitor_interval = this.expire_monitor_interval;
        builder.enable_active_expire = this.enable_active_expire;
        builder.sniffing_type = this.sniffing_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.endpoints != null) {
            sb.append(", endpoints=").append(this.endpoints);
        }
        if (this.rv_config != null) {
            sb.append(", rv_config=").append(this.rv_config);
        }
        if (this.splash_config != null) {
            sb.append(", splash_config=").append(this.splash_config);
        }
        if (this.native_config != null) {
            sb.append(", native_config=").append(this.native_config);
        }
        if (this.configRefresh != null) {
            sb.append(", configRefresh=").append(this.configRefresh);
        }
        if (this.anti_fraud_log != null) {
            sb.append(", anti_fraud_log=").append(this.anti_fraud_log);
        }
        if (this.is_gdpr_region != null) {
            sb.append(", is_gdpr_region=").append(this.is_gdpr_region);
        }
        if (this.tracking_expiration_time != null) {
            sb.append(", tracking_expiration_time=").append(this.tracking_expiration_time);
        }
        if (this.tracking_retry_interval != null) {
            sb.append(", tracking_retry_interval=").append(this.tracking_retry_interval);
        }
        if (this.max_send_log_records != null) {
            sb.append(", max_send_log_records=").append(this.max_send_log_records);
        }
        if (this.send_log_interval != null) {
            sb.append(", send_log_interval=").append(this.send_log_interval);
        }
        if (!this.dclog_blacklist.isEmpty()) {
            sb.append(", dclog_blacklist=").append(this.dclog_blacklist);
        }
        if (this.enable_debug_level != null) {
            sb.append(", enable_debug_level=").append(this.enable_debug_level);
        }
        if (this.load_interval != null) {
            sb.append(", load_interval=").append(this.load_interval);
        }
        if (this.disable_up_location != null) {
            sb.append(", disable_up_location=").append(this.disable_up_location);
        }
        if (this.log_enc != null) {
            sb.append(", log_enc=").append(this.log_enc);
        }
        if (this.feedback_debug != null) {
            sb.append(", feedback_debug=").append(this.feedback_debug);
        }
        if (this.enable_extra_dclog != null) {
            sb.append(", enable_extra_dclog=").append(this.enable_extra_dclog);
        }
        if (this.network_timeout != null) {
            sb.append(", network_timeout=").append(this.network_timeout);
        }
        if (this.noncompliance_mark != null) {
            sb.append(", noncompliance_mark=").append(this.noncompliance_mark);
        }
        if (this.expire_monitor_interval != null) {
            sb.append(", expire_monitor_interval=").append(this.expire_monitor_interval);
        }
        if (this.enable_active_expire != null) {
            sb.append(", enable_active_expire=").append(this.enable_active_expire);
        }
        if (this.sniffing_type != null) {
            sb.append(", sniffing_type=").append(this.sniffing_type);
        }
        return sb.replace(0, 2, "SigmobCommon{").append('}').toString();
    }
}
