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
public final class FrequencyControl extends AndroidMessage<FrequencyControl, Builder> {
    public static final ProtoAdapter<FrequencyControl> ADAPTER;
    public static final Parcelable.Creator<FrequencyControl> CREATOR;
    public static final Integer DEFAULT_FREQUENCY_CONTROL_COUNT;
    public static final String DEFAULT_FREQUENCY_CONTROL_EVENT = "";
    public static final String DEFAULT_STRATEGY_ID = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", label = WireField.Label.REPEATED, tag = 4)
    public final List<Integer> ad_expire_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer frequency_control_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String frequency_control_event;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String strategy_id;

    public static final class Builder extends Message.Builder<FrequencyControl, Builder> {
        public String strategy_id = "";
        public String frequency_control_event = "";
        public Integer frequency_control_count = FrequencyControl.DEFAULT_FREQUENCY_CONTROL_COUNT;
        public List<Integer> ad_expire_type = Internal.newMutableList();

        public Builder ad_expire_type(List<Integer> ad_expire_type) {
            Internal.checkElementsNotNull(ad_expire_type);
            this.ad_expire_type = ad_expire_type;
            return this;
        }

        public FrequencyControl build() {
            return new FrequencyControl(this.strategy_id, this.frequency_control_event, this.frequency_control_count, this.ad_expire_type, super.buildUnknownFields());
        }

        public Builder frequency_control_count(Integer frequency_control_count) {
            this.frequency_control_count = frequency_control_count;
            return this;
        }

        public Builder frequency_control_event(String frequency_control_event) {
            this.frequency_control_event = frequency_control_event;
            return this;
        }

        public Builder strategy_id(String strategy_id) {
            this.strategy_id = strategy_id;
            return this;
        }
    }

    private static final class ProtoAdapter_FrequencyControl extends ProtoAdapter<FrequencyControl> {
        public ProtoAdapter_FrequencyControl() {
            super(FieldEncoding.LENGTH_DELIMITED, FrequencyControl.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public FrequencyControl m1403decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.strategy_id((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.frequency_control_event((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 3) {
                    builder.frequency_control_count((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.ad_expire_type.add((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, FrequencyControl value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.strategy_id);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.frequency_control_event);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.frequency_control_count);
            ProtoAdapter.UINT32.asRepeated().encodeWithTag(writer, 4, value.ad_expire_type);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(FrequencyControl value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.strategy_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.frequency_control_event) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.frequency_control_count) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(4, value.ad_expire_type) + value.unknownFields().size();
        }

        public FrequencyControl redact(FrequencyControl value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_FrequencyControl protoAdapter_FrequencyControl = new ProtoAdapter_FrequencyControl();
        ADAPTER = protoAdapter_FrequencyControl;
        CREATOR = AndroidMessage.newCreator(protoAdapter_FrequencyControl);
        DEFAULT_FREQUENCY_CONTROL_COUNT = 0;
    }

    public FrequencyControl(String strategy_id, String frequency_control_event, Integer frequency_control_count, List<Integer> ad_expire_type) {
        this(strategy_id, frequency_control_event, frequency_control_count, ad_expire_type, ByteString.EMPTY);
    }

    public FrequencyControl(String strategy_id, String frequency_control_event, Integer frequency_control_count, List<Integer> ad_expire_type, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.strategy_id = strategy_id;
        this.frequency_control_event = frequency_control_event;
        this.frequency_control_count = frequency_control_count;
        this.ad_expire_type = Internal.immutableCopyOf("ad_expire_type", ad_expire_type);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof FrequencyControl)) {
            return false;
        }
        FrequencyControl frequencyControl = (FrequencyControl) other;
        return unknownFields().equals(frequencyControl.unknownFields()) && Internal.equals(this.strategy_id, frequencyControl.strategy_id) && Internal.equals(this.frequency_control_event, frequencyControl.frequency_control_event) && Internal.equals(this.frequency_control_count, frequencyControl.frequency_control_count) && this.ad_expire_type.equals(frequencyControl.ad_expire_type);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.strategy_id;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.frequency_control_event;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.frequency_control_count;
        int iHashCode4 = ((iHashCode3 + (num != null ? num.hashCode() : 0)) * 37) + this.ad_expire_type.hashCode();
        ((AndroidMessage) this).hashCode = iHashCode4;
        return iHashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.strategy_id = this.strategy_id;
        builder.frequency_control_event = this.frequency_control_event;
        builder.frequency_control_count = this.frequency_control_count;
        builder.ad_expire_type = Internal.copyOf("ad_expire_type", this.ad_expire_type);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.strategy_id != null) {
            sb.append(", strategy_id=").append(this.strategy_id);
        }
        if (this.frequency_control_event != null) {
            sb.append(", frequency_control_event=").append(this.frequency_control_event);
        }
        if (this.frequency_control_count != null) {
            sb.append(", frequency_control_count=").append(this.frequency_control_count);
        }
        if (!this.ad_expire_type.isEmpty()) {
            sb.append(", ad_expire_type=").append(this.ad_expire_type);
        }
        return sb.replace(0, 2, "FrequencyControl{").append('}').toString();
    }
}
