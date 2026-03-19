package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import android.text.TextUtils;
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
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Template extends AndroidMessage<Template, Builder> {
    public static final ProtoAdapter<Template> ADAPTER;
    public static final Parcelable.Creator<Template> CREATOR;
    public static final ByteString DEFAULT_CONTEXT;
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString context;
    public String templateId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer type;

    public static final class Builder extends Message.Builder<Template, Builder> {
        public ByteString context;
        public Integer type = Template.DEFAULT_TYPE;

        public Template build() {
            return new Template(this.type, this.context, super.buildUnknownFields());
        }

        public Builder context(ByteString context) {
            this.context = context;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }
    }

    private static final class ProtoAdapter_Template extends ProtoAdapter<Template> {
        public ProtoAdapter_Template() {
            super(FieldEncoding.LENGTH_DELIMITED, Template.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Template m1445decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.type((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 2) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.context((ByteString) ProtoAdapter.BYTES.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, Template value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.type);
            ProtoAdapter.BYTES.encodeWithTag(writer, 2, value.context);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(Template value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.type) + ProtoAdapter.BYTES.encodedSizeWithTag(2, value.context) + value.unknownFields().size();
        }

        public Template redact(Template value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Template protoAdapter_Template = new ProtoAdapter_Template();
        ADAPTER = protoAdapter_Template;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Template);
        DEFAULT_TYPE = 0;
        DEFAULT_CONTEXT = ByteString.EMPTY;
    }

    public Template(Integer type, ByteString context) {
        this(type, context, ByteString.EMPTY);
    }

    public Template(Integer type, ByteString context, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.type = type;
        this.context = context;
        if (type.intValue() == 2 && TextUtils.isEmpty(this.templateId)) {
            this.templateId = UUID.randomUUID().toString();
        }
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Template)) {
            return false;
        }
        Template template = (Template) other;
        return unknownFields().equals(template.unknownFields()) && Internal.equals(this.type, template.type) && Internal.equals(this.context, template.context);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.type;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        ByteString byteString = this.context;
        int iHashCode3 = iHashCode2 + (byteString != null ? byteString.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode3;
        return iHashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.context = this.context;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=").append(this.type);
        }
        if (this.context != null) {
            sb.append(", context=").append(this.context);
        }
        return sb.replace(0, 2, "Template{").append('}').toString();
    }
}
