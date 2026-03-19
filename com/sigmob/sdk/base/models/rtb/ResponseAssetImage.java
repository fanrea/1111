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
public final class ResponseAssetImage extends AndroidMessage<ResponseAssetImage, Builder> {
    public static final ProtoAdapter<ResponseAssetImage> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetImage> CREATOR;
    public static final Integer DEFAULT_H;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_W;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer h;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer w;

    public static final class Builder extends Message.Builder<ResponseAssetImage, Builder> {
        public String url = "";
        public Integer w = ResponseAssetImage.DEFAULT_W;
        public Integer h = ResponseAssetImage.DEFAULT_H;

        public ResponseAssetImage build() {
            return new ResponseAssetImage(this.url, this.w, this.h, super.buildUnknownFields());
        }

        public Builder h(Integer h) {
            this.h = h;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder w(Integer w) {
            this.w = w;
            return this;
        }
    }

    private static final class ProtoAdapter_ResponseAssetImage extends ProtoAdapter<ResponseAssetImage> {
        public ProtoAdapter_ResponseAssetImage() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetImage.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseAssetImage m1421decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.url((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.w((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.h((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, ResponseAssetImage value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.url);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.w);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.h);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(ResponseAssetImage value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.url) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.w) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.h) + value.unknownFields().size();
        }

        public ResponseAssetImage redact(ResponseAssetImage value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetImage protoAdapter_ResponseAssetImage = new ProtoAdapter_ResponseAssetImage();
        ADAPTER = protoAdapter_ResponseAssetImage;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetImage);
        DEFAULT_W = 0;
        DEFAULT_H = 0;
    }

    public ResponseAssetImage(String url, Integer w, Integer h) {
        this(url, w, h, ByteString.EMPTY);
    }

    public ResponseAssetImage(String url, Integer w, Integer h, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.url = url;
        this.w = w;
        this.h = h;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ResponseAssetImage)) {
            return false;
        }
        ResponseAssetImage responseAssetImage = (ResponseAssetImage) other;
        return unknownFields().equals(responseAssetImage.unknownFields()) && Internal.equals(this.url, responseAssetImage.url) && Internal.equals(this.w, responseAssetImage.w) && Internal.equals(this.h, responseAssetImage.h);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.w;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.h;
        int iHashCode4 = iHashCode3 + (num2 != null ? num2.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode4;
        return iHashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.w = this.w;
        builder.h = this.h;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.url != null) {
            sb.append(", url=").append(this.url);
        }
        if (this.w != null) {
            sb.append(", w=").append(this.w);
        }
        if (this.h != null) {
            sb.append(", h=").append(this.h);
        }
        return sb.replace(0, 2, "ResponseAssetImage{").append('}').toString();
    }
}
