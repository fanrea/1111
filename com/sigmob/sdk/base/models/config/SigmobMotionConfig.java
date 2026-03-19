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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class SigmobMotionConfig extends AndroidMessage<SigmobMotionConfig, Builder> {
    public static final ProtoAdapter<SigmobMotionConfig> ADAPTER;
    public static final Parcelable.Creator<SigmobMotionConfig> CREATOR;
    public static final Integer DEFAULT_COUNT;
    public static final Integer DEFAULT_INTERVAL;
    public static final Integer DEFAULT_QUEUE_MAX;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer queue_max;

    public static final class Builder extends Message.Builder<SigmobMotionConfig, Builder> {
        public Integer count;
        public Integer interval;
        public Integer queue_max;

        public SigmobMotionConfig build() {
            return new SigmobMotionConfig(this.interval, this.queue_max, this.count, super.buildUnknownFields());
        }

        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public Builder interval(Integer interval) {
            this.interval = interval;
            return this;
        }

        public Builder queue_max(Integer queue_max) {
            this.queue_max = queue_max;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobMotionConfig extends ProtoAdapter<SigmobMotionConfig> {
        public ProtoAdapter_SigmobMotionConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobMotionConfig.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobMotionConfig m1355decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.interval((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag == 2) {
                    builder.queue_max((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.count((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobMotionConfig value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.interval);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.queue_max);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.count);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobMotionConfig value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.interval) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.queue_max) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.count) + value.unknownFields().size();
        }

        public SigmobMotionConfig redact(SigmobMotionConfig value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobMotionConfig protoAdapter_SigmobMotionConfig = new ProtoAdapter_SigmobMotionConfig();
        ADAPTER = protoAdapter_SigmobMotionConfig;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobMotionConfig);
        DEFAULT_INTERVAL = 0;
        DEFAULT_QUEUE_MAX = 0;
        DEFAULT_COUNT = 0;
    }

    public SigmobMotionConfig(Integer interval, Integer queue_max, Integer count) {
        this(interval, queue_max, count, ByteString.EMPTY);
    }

    public SigmobMotionConfig(Integer interval, Integer queue_max, Integer count, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.interval = interval;
        this.queue_max = queue_max;
        this.count = count;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobMotionConfig)) {
            return false;
        }
        SigmobMotionConfig sigmobMotionConfig = (SigmobMotionConfig) other;
        return unknownFields().equals(sigmobMotionConfig.unknownFields()) && Internal.equals(this.interval, sigmobMotionConfig.interval) && Internal.equals(this.queue_max, sigmobMotionConfig.queue_max) && Internal.equals(this.count, sigmobMotionConfig.count);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.interval;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.queue_max;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.count;
        int iHashCode4 = iHashCode3 + (num3 != null ? num3.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode4;
        return iHashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.interval = this.interval;
        builder.queue_max = this.queue_max;
        builder.count = this.count;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.interval != null) {
            sb.append(", interval=").append(this.interval);
        }
        if (this.queue_max != null) {
            sb.append(", queue_max=").append(this.queue_max);
        }
        if (this.count != null) {
            sb.append(", count=").append(this.count);
        }
        return sb.replace(0, 2, "SigmobMotionConfig{").append('}').toString();
    }
}
