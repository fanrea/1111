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
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class WebEventHandle extends AndroidMessage<WebEventHandle, Builder> {
    public static final ProtoAdapter<WebEventHandle> ADAPTER;
    public static final Parcelable.Creator<WebEventHandle> CREATOR;
    public static final Integer DEFAULT_HANDLE_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "WebEvent#ADAPTER", label = WireField.Label.REPEATED, tag = 3)
    public final List<WebEvent> events;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 2)
    public final List<String> handle_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer handle_type;

    public static final class Builder extends Message.Builder<WebEventHandle, Builder> {
        public Integer handle_type = WebEventHandle.DEFAULT_HANDLE_TYPE;
        public List<String> handle_name = Internal.newMutableList();
        public List<WebEvent> events = Internal.newMutableList();

        public WebEventHandle build() {
            return new WebEventHandle(this.handle_type, this.handle_name, this.events, super.buildUnknownFields());
        }

        public Builder events(List<WebEvent> events) {
            Internal.checkElementsNotNull(events);
            this.events = events;
            return this;
        }

        public Builder handle_name(List<String> handle_name) {
            Internal.checkElementsNotNull(handle_name);
            this.handle_name = handle_name;
            return this;
        }

        public Builder handle_type(Integer handle_type) {
            this.handle_type = handle_type;
            return this;
        }
    }

    private static final class ProtoAdapter_WebEventHandle extends ProtoAdapter<WebEventHandle> {
        public ProtoAdapter_WebEventHandle() {
            super(FieldEncoding.LENGTH_DELIMITED, WebEventHandle.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public WebEventHandle m1337decode(ProtoReader reader) throws IOException {
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
                if (iNextTag != 1) {
                    if (iNextTag == 2) {
                        list = builder.handle_name;
                        obj = (String) ProtoAdapter.STRING.decode(reader);
                    } else if (iNextTag != 3) {
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                    } else {
                        list = builder.events;
                        obj = (WebEvent) WebEvent.ADAPTER.decode(reader);
                    }
                    list.add(obj);
                } else {
                    builder.handle_type((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, WebEventHandle value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.handle_type);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 2, value.handle_name);
            WebEvent.ADAPTER.asRepeated().encodeWithTag(writer, 3, value.events);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(WebEventHandle value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.handle_type) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, value.handle_name) + WebEvent.ADAPTER.asRepeated().encodedSizeWithTag(3, value.events) + value.unknownFields().size();
        }

        public WebEventHandle redact(WebEventHandle value) {
            Builder builderNewBuilder = value.newBuilder();
            Internal.redactElements(builderNewBuilder.events, WebEvent.ADAPTER);
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_WebEventHandle protoAdapter_WebEventHandle = new ProtoAdapter_WebEventHandle();
        ADAPTER = protoAdapter_WebEventHandle;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WebEventHandle);
        DEFAULT_HANDLE_TYPE = 0;
    }

    public WebEventHandle(Integer handle_type, List<String> handle_name, List<WebEvent> events) {
        this(handle_type, handle_name, events, ByteString.EMPTY);
    }

    public WebEventHandle(Integer handle_type, List<String> handle_name, List<WebEvent> events, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.handle_type = handle_type;
        this.handle_name = Internal.immutableCopyOf("handle_name", handle_name);
        this.events = Internal.immutableCopyOf("events", events);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WebEventHandle)) {
            return false;
        }
        WebEventHandle webEventHandle = (WebEventHandle) other;
        return unknownFields().equals(webEventHandle.unknownFields()) && Internal.equals(this.handle_type, webEventHandle.handle_type) && this.handle_name.equals(webEventHandle.handle_name) && this.events.equals(webEventHandle.events);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.handle_type;
        int iHashCode2 = ((((iHashCode + (num != null ? num.hashCode() : 0)) * 37) + this.handle_name.hashCode()) * 37) + this.events.hashCode();
        ((AndroidMessage) this).hashCode = iHashCode2;
        return iHashCode2;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.handle_type = this.handle_type;
        builder.handle_name = Internal.copyOf("handle_name", this.handle_name);
        builder.events = Internal.copyOf("events", this.events);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.handle_type != null) {
            sb.append(", handle_type=").append(this.handle_type);
        }
        if (!this.handle_name.isEmpty()) {
            sb.append(", handle_name=").append(this.handle_name);
        }
        if (!this.events.isEmpty()) {
            sb.append(", events=").append(this.events);
        }
        return sb.replace(0, 2, "WebEventHandle{").append('}').toString();
    }
}
