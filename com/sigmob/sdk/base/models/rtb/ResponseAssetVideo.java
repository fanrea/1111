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
public final class ResponseAssetVideo extends AndroidMessage<ResponseAssetVideo, Builder> {
    public static final ProtoAdapter<ResponseAssetVideo> ADAPTER;
    public static final Parcelable.Creator<ResponseAssetVideo> CREATOR;
    public static final Integer DEFAULT_DURATION;
    public static final Integer DEFAULT_H;
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_W;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer h;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer w;

    public static final class Builder extends Message.Builder<ResponseAssetVideo, Builder> {
        public String url = "";
        public Integer w = ResponseAssetVideo.DEFAULT_W;
        public Integer h = ResponseAssetVideo.DEFAULT_H;
        public Integer duration = ResponseAssetVideo.DEFAULT_DURATION;

        public ResponseAssetVideo build() {
            return new ResponseAssetVideo(this.url, this.w, this.h, this.duration, super.buildUnknownFields());
        }

        public Builder duration(Integer duration) {
            this.duration = duration;
            return this;
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

    private static final class ProtoAdapter_ResponseAssetVideo extends ProtoAdapter<ResponseAssetVideo> {
        public ProtoAdapter_ResponseAssetVideo() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAssetVideo.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseAssetVideo m1427decode(ProtoReader reader) throws IOException {
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
                } else if (iNextTag == 3) {
                    builder.h((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.duration((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, ResponseAssetVideo value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.url);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.w);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.h);
            ProtoAdapter.UINT32.encodeWithTag(writer, 4, value.duration);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(ResponseAssetVideo value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.url) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.w) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.h) + ProtoAdapter.UINT32.encodedSizeWithTag(4, value.duration) + value.unknownFields().size();
        }

        public ResponseAssetVideo redact(ResponseAssetVideo value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAssetVideo protoAdapter_ResponseAssetVideo = new ProtoAdapter_ResponseAssetVideo();
        ADAPTER = protoAdapter_ResponseAssetVideo;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAssetVideo);
        DEFAULT_W = 0;
        DEFAULT_H = 0;
        DEFAULT_DURATION = 0;
    }

    public ResponseAssetVideo(String url, Integer w, Integer h, Integer duration) {
        this(url, w, h, duration, ByteString.EMPTY);
    }

    public ResponseAssetVideo(String url, Integer w, Integer h, Integer duration, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.url = url;
        this.w = w;
        this.h = h;
        this.duration = duration;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ResponseAssetVideo)) {
            return false;
        }
        ResponseAssetVideo responseAssetVideo = (ResponseAssetVideo) other;
        return unknownFields().equals(responseAssetVideo.unknownFields()) && Internal.equals(this.url, responseAssetVideo.url) && Internal.equals(this.w, responseAssetVideo.w) && Internal.equals(this.h, responseAssetVideo.h) && Internal.equals(this.duration, responseAssetVideo.duration);
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
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.duration;
        int iHashCode5 = iHashCode4 + (num3 != null ? num3.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode5;
        return iHashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.w = this.w;
        builder.h = this.h;
        builder.duration = this.duration;
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
        if (this.duration != null) {
            sb.append(", duration=").append(this.duration);
        }
        return sb.replace(0, 2, "ResponseAssetVideo{").append('}').toString();
    }
}
