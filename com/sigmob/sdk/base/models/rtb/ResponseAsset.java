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
public final class ResponseAsset extends AndroidMessage<ResponseAsset, Builder> {
    public static final ProtoAdapter<ResponseAsset> ADAPTER;
    public static final Parcelable.Creator<ResponseAsset> CREATOR;
    public static final Integer DEFAULT_INDEX;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "ResponseAssetImage#ADAPTER", tag = 3)
    public final ResponseAssetImage image;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer index;

    @WireField(adapter = "ResponseAssetText#ADAPTER", tag = 4)
    public final ResponseAssetText text;

    @WireField(adapter = "ResponseAssetVideo#ADAPTER", tag = 2)
    public final ResponseAssetVideo video;

    public static final class Builder extends Message.Builder<ResponseAsset, Builder> {
        public ResponseAssetImage image;
        public Integer index = ResponseAsset.DEFAULT_INDEX;
        public ResponseAssetText text;
        public ResponseAssetVideo video;

        public ResponseAsset build() {
            return new ResponseAsset(this.index, this.video, this.image, this.text, super.buildUnknownFields());
        }

        public Builder image(ResponseAssetImage image) {
            this.image = image;
            return this;
        }

        public Builder index(Integer index) {
            this.index = index;
            return this;
        }

        public Builder text(ResponseAssetText text) {
            this.text = text;
            return this;
        }

        public Builder video(ResponseAssetVideo video) {
            this.video = video;
            return this;
        }
    }

    private static final class ProtoAdapter_ResponseAsset extends ProtoAdapter<ResponseAsset> {
        public ProtoAdapter_ResponseAsset() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseAsset.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ResponseAsset m1418decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.index((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag == 2) {
                    builder.video((ResponseAssetVideo) ResponseAssetVideo.ADAPTER.decode(reader));
                } else if (iNextTag == 3) {
                    builder.image((ResponseAssetImage) ResponseAssetImage.ADAPTER.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.text((ResponseAssetText) ResponseAssetText.ADAPTER.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, ResponseAsset value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.index);
            ResponseAssetVideo.ADAPTER.encodeWithTag(writer, 2, value.video);
            ResponseAssetImage.ADAPTER.encodeWithTag(writer, 3, value.image);
            ResponseAssetText.ADAPTER.encodeWithTag(writer, 4, value.text);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(ResponseAsset value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.index) + ResponseAssetVideo.ADAPTER.encodedSizeWithTag(2, value.video) + ResponseAssetImage.ADAPTER.encodedSizeWithTag(3, value.image) + ResponseAssetText.ADAPTER.encodedSizeWithTag(4, value.text) + value.unknownFields().size();
        }

        public ResponseAsset redact(ResponseAsset value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.video != null) {
                builderNewBuilder.video = (ResponseAssetVideo) ResponseAssetVideo.ADAPTER.redact(builderNewBuilder.video);
            }
            if (builderNewBuilder.image != null) {
                builderNewBuilder.image = (ResponseAssetImage) ResponseAssetImage.ADAPTER.redact(builderNewBuilder.image);
            }
            if (builderNewBuilder.text != null) {
                builderNewBuilder.text = (ResponseAssetText) ResponseAssetText.ADAPTER.redact(builderNewBuilder.text);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_ResponseAsset protoAdapter_ResponseAsset = new ProtoAdapter_ResponseAsset();
        ADAPTER = protoAdapter_ResponseAsset;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ResponseAsset);
        DEFAULT_INDEX = 0;
    }

    public ResponseAsset(Integer index, ResponseAssetVideo video, ResponseAssetImage image, ResponseAssetText text) {
        this(index, video, image, text, ByteString.EMPTY);
    }

    public ResponseAsset(Integer index, ResponseAssetVideo video, ResponseAssetImage image, ResponseAssetText text, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.index = index;
        this.video = video;
        this.image = image;
        this.text = text;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ResponseAsset)) {
            return false;
        }
        ResponseAsset responseAsset = (ResponseAsset) other;
        return unknownFields().equals(responseAsset.unknownFields()) && Internal.equals(this.index, responseAsset.index) && Internal.equals(this.video, responseAsset.video) && Internal.equals(this.image, responseAsset.image) && Internal.equals(this.text, responseAsset.text);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.index;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        ResponseAssetVideo responseAssetVideo = this.video;
        int iHashCode3 = (iHashCode2 + (responseAssetVideo != null ? responseAssetVideo.hashCode() : 0)) * 37;
        ResponseAssetImage responseAssetImage = this.image;
        int iHashCode4 = (iHashCode3 + (responseAssetImage != null ? responseAssetImage.hashCode() : 0)) * 37;
        ResponseAssetText responseAssetText = this.text;
        int iHashCode5 = iHashCode4 + (responseAssetText != null ? responseAssetText.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode5;
        return iHashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.index = this.index;
        builder.video = this.video;
        builder.image = this.image;
        builder.text = this.text;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.index != null) {
            sb.append(", index=").append(this.index);
        }
        if (this.video != null) {
            sb.append(", video=").append(this.video);
        }
        if (this.image != null) {
            sb.append(", image=").append(this.image);
        }
        if (this.text != null) {
            sb.append(", text=").append(this.text);
        }
        return sb.replace(0, 2, "ResponseAsset{").append('}').toString();
    }
}
