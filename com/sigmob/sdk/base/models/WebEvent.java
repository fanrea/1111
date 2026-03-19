package com.sigmob.sdk.base.models;

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
public final class WebEvent extends AndroidMessage<WebEvent, Builder> {
    public static final ProtoAdapter<WebEvent> ADAPTER;
    public static final Parcelable.Creator<WebEvent> CREATOR;
    public static final String DEFAULT_EVENT_NAME = "";
    public static final String DEFAULT_EVENT_TYPE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String event_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String event_type;

    public static final class Builder extends Message.Builder<WebEvent, Builder> {
        public String event_type = "";
        public String event_name = "";

        public WebEvent build() {
            return new WebEvent(this.event_type, this.event_name, super.buildUnknownFields());
        }

        public Builder event_name(String event_name) {
            this.event_name = event_name;
            return this;
        }

        public Builder event_type(String event_type) {
            this.event_type = event_type;
            return this;
        }
    }

    private static final class ProtoAdapter_WebEvent extends ProtoAdapter<WebEvent> {
        public ProtoAdapter_WebEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, WebEvent.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public WebEvent m1334decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.event_type((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.event_name((String) ProtoAdapter.STRING.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, WebEvent value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.event_type);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.event_name);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(WebEvent value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.event_type) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.event_name) + value.unknownFields().size();
        }

        public WebEvent redact(WebEvent value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_WebEvent protoAdapter_WebEvent = new ProtoAdapter_WebEvent();
        ADAPTER = protoAdapter_WebEvent;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WebEvent);
    }

    public WebEvent(String event_type, String event_name) {
        this(event_type, event_name, ByteString.EMPTY);
    }

    public WebEvent(String event_type, String event_name, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.event_type = event_type;
        this.event_name = event_name;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebEvent)) {
            return false;
        }
        WebEvent webEvent = (WebEvent) other;
        return unknownFields().equals(webEvent.unknownFields()) && Internal.equals(this.event_type, webEvent.event_type) && Internal.equals(this.event_name, webEvent.event_name);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.event_type;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.event_name;
        int iHashCode3 = iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode3;
        return iHashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.event_type = this.event_type;
        builder.event_name = this.event_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.event_type != null) {
            sb.append(", event_type=").append(this.event_type);
        }
        if (this.event_name != null) {
            sb.append(", event_name=").append(this.event_name);
        }
        return sb.replace(0, 2, "WebEvent{").append('}').toString();
    }
}
