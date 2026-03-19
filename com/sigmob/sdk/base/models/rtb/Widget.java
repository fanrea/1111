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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Widget extends AndroidMessage<Widget, Builder> {
    public static final ProtoAdapter<Widget> ADAPTER;
    public static final Parcelable.Creator<Widget> CREATOR;
    public static final Boolean DEFAULT_ENABLE_DEVELOPER_RENDER;
    public static final Long DEFAULT_WIDGET_ID;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean enable_developer_render;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 1)
    public final Long widget_id;

    public static final class Builder extends Message.Builder<Widget, Builder> {
        public Long widget_id = Widget.DEFAULT_WIDGET_ID;
        public Boolean enable_developer_render = Widget.DEFAULT_ENABLE_DEVELOPER_RENDER;

        public Widget build() {
            return new Widget(this.widget_id, this.enable_developer_render, super.buildUnknownFields());
        }

        public Builder enable_developer_render(Boolean enable_developer_render) {
            this.enable_developer_render = enable_developer_render;
            return this;
        }

        public Builder widget_id(Long widget_id) {
            this.widget_id = widget_id;
            return this;
        }
    }

    private static final class ProtoAdapter_Widget extends ProtoAdapter<Widget> {
        public ProtoAdapter_Widget() {
            super(FieldEncoding.LENGTH_DELIMITED, Widget.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Widget m1454decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.widget_id((Long) ProtoAdapter.UINT64.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.enable_developer_render((Boolean) ProtoAdapter.BOOL.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, Widget value) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(writer, 1, value.widget_id);
            ProtoAdapter.BOOL.encodeWithTag(writer, 2, value.enable_developer_render);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(Widget value) {
            return ProtoAdapter.UINT64.encodedSizeWithTag(1, value.widget_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, value.enable_developer_render) + value.unknownFields().size();
        }

        public Widget redact(Widget value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Widget protoAdapter_Widget = new ProtoAdapter_Widget();
        ADAPTER = protoAdapter_Widget;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Widget);
        DEFAULT_WIDGET_ID = 0L;
        DEFAULT_ENABLE_DEVELOPER_RENDER = false;
    }

    public Widget(Long widget_id, Boolean enable_developer_render) {
        this(widget_id, enable_developer_render, ByteString.EMPTY);
    }

    public Widget(Long widget_id, Boolean enable_developer_render, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.widget_id = widget_id;
        this.enable_developer_render = enable_developer_render;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Widget)) {
            return false;
        }
        Widget widget = (Widget) other;
        return unknownFields().equals(widget.unknownFields()) && Internal.equals(this.widget_id, widget.widget_id) && Internal.equals(this.enable_developer_render, widget.enable_developer_render);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Long l = this.widget_id;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.enable_developer_render;
        int iHashCode3 = iHashCode2 + (bool != null ? bool.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode3;
        return iHashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.widget_id = this.widget_id;
        builder.enable_developer_render = this.enable_developer_render;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.widget_id != null) {
            sb.append(", widget_id=").append(this.widget_id);
        }
        if (this.enable_developer_render != null) {
            sb.append(", enable_developer_render=").append(this.enable_developer_render);
        }
        return sb.replace(0, 2, "Widget{").append('}').toString();
    }
}
