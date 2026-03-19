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
public final class LinkAction extends AndroidMessage<LinkAction, Builder> {
    public static final ProtoAdapter<LinkAction> ADAPTER;
    public static final Parcelable.Creator<LinkAction> CREATOR;
    public static final String DEFAULT_HOST = "";
    public static final Integer DEFAULT_REDIRECT_COUNT;
    public static final String DEFAULT_scheme = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String host;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer redirect_count;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String scheme;

    public static final class Builder extends Message.Builder<LinkAction, Builder> {
        public String host;
        public Integer redirect_count = LinkAction.DEFAULT_REDIRECT_COUNT;
        public String scheme;

        public LinkAction build() {
            return new LinkAction(this.scheme, this.host, this.redirect_count, super.buildUnknownFields());
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder redirect_count(Integer redirect_count) {
            this.redirect_count = redirect_count;
            return this;
        }

        public Builder scheme(String scheme) {
            this.scheme = scheme;
            return this;
        }
    }

    private static final class ProtoAdapter_LinkAction extends ProtoAdapter<LinkAction> {
        public ProtoAdapter_LinkAction() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkAction.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public LinkAction m1409decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.scheme((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.host((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.redirect_count((Integer) ProtoAdapter.INT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, LinkAction value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.scheme);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.host);
            ProtoAdapter.INT32.encodeWithTag(writer, 3, value.redirect_count);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(LinkAction value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.scheme) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.host) + ProtoAdapter.INT32.encodedSizeWithTag(3, value.redirect_count) + value.unknownFields().size();
        }

        public LinkAction redact(LinkAction value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_LinkAction protoAdapter_LinkAction = new ProtoAdapter_LinkAction();
        ADAPTER = protoAdapter_LinkAction;
        CREATOR = AndroidMessage.newCreator(protoAdapter_LinkAction);
        DEFAULT_REDIRECT_COUNT = 0;
    }

    public LinkAction(String scheme, String host, Integer redirect_count) {
        this(scheme, host, redirect_count, ByteString.EMPTY);
    }

    public LinkAction(String scheme, String host, Integer redirect_count, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.scheme = scheme;
        this.host = host;
        this.redirect_count = redirect_count;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LinkAction)) {
            return false;
        }
        LinkAction linkAction = (LinkAction) other;
        return unknownFields().equals(linkAction.unknownFields()) && Internal.equals(this.scheme, linkAction.scheme) && Internal.equals(this.host, linkAction.host) && Internal.equals(this.redirect_count, linkAction.redirect_count);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.scheme;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.host;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.redirect_count;
        int iHashCode4 = iHashCode3 + (num != null ? num.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode4;
        return iHashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.host = this.host;
        builder.redirect_count = this.redirect_count;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.scheme != null) {
            sb.append(", scheme=").append(this.scheme);
        }
        if (this.host != null) {
            sb.append(", host=").append(this.host);
        }
        if (this.redirect_count != null) {
            sb.append(", redirect_count=").append(this.redirect_count);
        }
        return sb.replace(0, 2, "LinkAction{").append('}').toString();
    }
}
