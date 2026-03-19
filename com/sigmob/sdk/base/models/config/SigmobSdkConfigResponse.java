package com.sigmob.sdk.base.models.config;

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
public final class SigmobSdkConfigResponse extends AndroidMessage<SigmobSdkConfigResponse, Builder> {
    public static final ProtoAdapter<SigmobSdkConfigResponse> ADAPTER;
    public static final Parcelable.Creator<SigmobSdkConfigResponse> CREATOR;
    public static final Integer DEFAULT_CODE;
    public static final String DEFAULT_ERROR_MESSAGE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer code;

    @WireField(adapter = "com.sigmob.sdk.base.models.config.SigmobSdkConfig#ADAPTER", tag = 3)
    public final SigmobSdkConfig config;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String error_message;

    public static final class Builder extends Message.Builder<SigmobSdkConfigResponse, Builder> {
        public Integer code;
        public SigmobSdkConfig config;
        public String error_message;

        public SigmobSdkConfigResponse build() {
            return new SigmobSdkConfigResponse(this.code, this.error_message, this.config, super.buildUnknownFields());
        }

        public Builder code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder config(SigmobSdkConfig config) {
            this.config = config;
            return this;
        }

        public Builder error_message(String error_message) {
            this.error_message = error_message;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobSdkConfigResponse extends ProtoAdapter<SigmobSdkConfigResponse> {
        public ProtoAdapter_SigmobSdkConfigResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSdkConfigResponse.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobSdkConfigResponse m1370decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.code((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag == 2) {
                    builder.error_message((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.config((SigmobSdkConfig) SigmobSdkConfig.ADAPTER.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobSdkConfigResponse value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.code);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.error_message);
            SigmobSdkConfig.ADAPTER.encodeWithTag(writer, 3, value.config);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobSdkConfigResponse value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.code) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.error_message) + SigmobSdkConfig.ADAPTER.encodedSizeWithTag(3, value.config) + value.unknownFields().size();
        }

        public SigmobSdkConfigResponse redact(SigmobSdkConfigResponse value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.config != null) {
                builderNewBuilder.config = (SigmobSdkConfig) SigmobSdkConfig.ADAPTER.redact(builderNewBuilder.config);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobSdkConfigResponse protoAdapter_SigmobSdkConfigResponse = new ProtoAdapter_SigmobSdkConfigResponse();
        ADAPTER = protoAdapter_SigmobSdkConfigResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobSdkConfigResponse);
        DEFAULT_CODE = 0;
    }

    public SigmobSdkConfigResponse(Integer code, String error_message, SigmobSdkConfig config) {
        this(code, error_message, config, ByteString.EMPTY);
    }

    public SigmobSdkConfigResponse(Integer code, String error_message, SigmobSdkConfig config, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.code = code;
        this.error_message = error_message;
        this.config = config;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobSdkConfigResponse)) {
            return false;
        }
        SigmobSdkConfigResponse sigmobSdkConfigResponse = (SigmobSdkConfigResponse) other;
        return unknownFields().equals(sigmobSdkConfigResponse.unknownFields()) && Internal.equals(this.code, sigmobSdkConfigResponse.code) && Internal.equals(this.error_message, sigmobSdkConfigResponse.error_message) && Internal.equals(this.config, sigmobSdkConfigResponse.config);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.code;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.error_message;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        SigmobSdkConfig sigmobSdkConfig = this.config;
        int iHashCode4 = iHashCode3 + (sigmobSdkConfig != null ? sigmobSdkConfig.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode4;
        return iHashCode4;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.code = this.code;
        builder.error_message = this.error_message;
        builder.config = this.config;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.code != null) {
            sb.append(", code=").append(this.code);
        }
        if (this.error_message != null) {
            sb.append(", error_message=").append(this.error_message);
        }
        if (this.config != null) {
            sb.append(", config=").append(this.config);
        }
        return sb.replace(0, 2, "SigmobSdkConfigResponse{").append('}').toString();
    }
}
