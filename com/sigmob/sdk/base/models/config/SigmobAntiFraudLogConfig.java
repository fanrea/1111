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
public final class SigmobAntiFraudLogConfig extends AndroidMessage<SigmobAntiFraudLogConfig, Builder> {
    public static final ProtoAdapter<SigmobAntiFraudLogConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobAntiFraudLogConfig> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> events;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobMotionConfig#ADAPTER", tag = 1)
    public final SigmobMotionConfig motion_config;

    public static final class Builder extends Message.Builder<SigmobAntiFraudLogConfig, Builder> {
        public List<String> events = Internal.newMutableList();
        public SigmobMotionConfig motion_config;

        public SigmobAntiFraudLogConfig build() {
            return new SigmobAntiFraudLogConfig(this.motion_config, this.events, super.buildUnknownFields());
        }

        public Builder events(List<String> events) {
            Internal.checkElementsNotNull(events);
            this.events = events;
            return this;
        }

        public Builder motion_config(SigmobMotionConfig motion_config) {
            this.motion_config = motion_config;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobAntiFraudLogConfig extends ProtoAdapter<SigmobAntiFraudLogConfig> {
        public ProtoAdapter_SigmobAntiFraudLogConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobAntiFraudLogConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobAntiFraudLogConfig m1343decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.motion_config((SigmobMotionConfig) SigmobMotionConfig.ADAPTER.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.events.add((String) ProtoAdapter.STRING.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobAntiFraudLogConfig value) throws IOException {
            SigmobMotionConfig.ADAPTER.encodeWithTag(writer, 1, value.motion_config);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.events);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobAntiFraudLogConfig value) {
            return SigmobMotionConfig.ADAPTER.encodedSizeWithTag(1, value.motion_config) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, value.events) + value.unknownFields().size();
        }

        public SigmobAntiFraudLogConfig redact(SigmobAntiFraudLogConfig value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.motion_config != null) {
                builderNewBuilder.motion_config = (SigmobMotionConfig) SigmobMotionConfig.ADAPTER.redact(builderNewBuilder.motion_config);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobAntiFraudLogConfig protoAdapter_SigmobAntiFraudLogConfig = new ProtoAdapter_SigmobAntiFraudLogConfig();
        ADAPTER = protoAdapter_SigmobAntiFraudLogConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobAntiFraudLogConfig);
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig motion_config, List<String> events) {
        this(motion_config, events, ByteString.EMPTY);
    }

    public SigmobAntiFraudLogConfig(SigmobMotionConfig motion_config, List<String> events, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.motion_config = motion_config;
        this.events = Internal.immutableCopyOf("events", events);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobAntiFraudLogConfig)) {
            return false;
        }
        SigmobAntiFraudLogConfig sigmobAntiFraudLogConfig = (SigmobAntiFraudLogConfig) other;
        return unknownFields().equals(sigmobAntiFraudLogConfig.unknownFields()) && Internal.equals(this.motion_config, sigmobAntiFraudLogConfig.motion_config) && this.events.equals(sigmobAntiFraudLogConfig.events);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        SigmobMotionConfig sigmobMotionConfig = this.motion_config;
        int iHashCode2 = ((iHashCode + (sigmobMotionConfig != null ? sigmobMotionConfig.hashCode() : 0)) * 37) + this.events.hashCode();
        ((AndroidMessage) this).hashCode = iHashCode2;
        return iHashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.motion_config = this.motion_config;
        builder.events = Internal.copyOf("events", this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.motion_config != null) {
            sb.append(", motion_config=").append(this.motion_config);
        }
        if (!this.events.isEmpty()) {
            sb.append(", events=").append(this.events);
        }
        return sb.replace(0, 2, "SigmobAntiFraudLogConfig{").append('}').toString();
    }
}
