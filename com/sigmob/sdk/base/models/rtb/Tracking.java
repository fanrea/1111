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
public final class Tracking extends AndroidMessage<Tracking, Builder> {
    public static final ProtoAdapter<Tracking> ADAPTER;
    public static final Parcelable.Creator<Tracking> CREATOR;
    public static final String DEFAULT_TRACKING_EVENT_TYPE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String tracking_event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> tracking_url;

    public static final class Builder extends Message.Builder<Tracking, Builder> {
        public String tracking_event_type = "";
        public List<String> tracking_url = Internal.newMutableList();

        public Tracking build() {
            return new Tracking(this.tracking_event_type, this.tracking_url, super.buildUnknownFields());
        }

        public Builder tracking_event_type(String tracking_event_type) {
            this.tracking_event_type = tracking_event_type;
            return this;
        }

        public Builder tracking_url(List<String> tracking_url) {
            Internal.checkElementsNotNull(tracking_url);
            this.tracking_url = tracking_url;
            return this;
        }
    }

    private static final class ProtoAdapter_Tracking extends ProtoAdapter<Tracking> {
        public ProtoAdapter_Tracking() {
            super(FieldEncoding.LENGTH_DELIMITED, Tracking.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Tracking m1448decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.tracking_event_type((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.tracking_url.add((String) ProtoAdapter.STRING.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, Tracking value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.tracking_event_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.tracking_url);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(Tracking value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.tracking_event_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, value.tracking_url) + value.unknownFields().size();
        }

        public Tracking redact(Tracking value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Tracking protoAdapter_Tracking = new ProtoAdapter_Tracking();
        ADAPTER = protoAdapter_Tracking;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Tracking);
    }

    public Tracking(String tracking_event_type, List<String> tracking_url) {
        this(tracking_event_type, tracking_url, ByteString.EMPTY);
    }

    public Tracking(String tracking_event_type, List<String> tracking_url, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.tracking_event_type = tracking_event_type;
        this.tracking_url = Internal.immutableCopyOf("tracking_url", tracking_url);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Tracking)) {
            return false;
        }
        Tracking tracking = (Tracking) other;
        return unknownFields().equals(tracking.unknownFields()) && Internal.equals(this.tracking_event_type, tracking.tracking_event_type) && this.tracking_url.equals(tracking.tracking_url);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.tracking_event_type;
        int iHashCode2 = ((iHashCode + (str != null ? str.hashCode() : 0)) * 37) + this.tracking_url.hashCode();
        ((AndroidMessage) this).hashCode = iHashCode2;
        return iHashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.tracking_event_type = this.tracking_event_type;
        builder.tracking_url = Internal.copyOf("tracking_url", this.tracking_url);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.tracking_event_type != null) {
            sb.append(", tracking_event_type=").append(this.tracking_event_type);
        }
        if (!this.tracking_url.isEmpty()) {
            sb.append(", tracking_url=").append(this.tracking_url);
        }
        return sb.replace(0, 2, "Tracking{").append('}').toString();
    }
}
