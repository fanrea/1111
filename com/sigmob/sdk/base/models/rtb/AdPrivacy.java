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
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class AdPrivacy extends AndroidMessage<AdPrivacy, Builder> {
    public static final ProtoAdapter<AdPrivacy> ADAPTER;
    public static final Parcelable.Creator<AdPrivacy> CREATOR;
    public static final String DEFAULT_PRIVACY_INFO_URL = "";
    public static final String DEFAULT_PRIVACY_TEMPLATE_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String privacy_info_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> privacy_template_info;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String privacy_template_url;

    public static final class Builder extends Message.Builder<AdPrivacy, Builder> {
        public String privacy_info_url = "";
        public String privacy_template_url = "";
        public Map<String, String> privacy_template_info = Internal.newMutableMap();

        public AdPrivacy build() {
            return new AdPrivacy(this.privacy_info_url, this.privacy_template_url, this.privacy_template_info, super.buildUnknownFields());
        }

        public Builder privacy_info_url(String privacy_info_url) {
            this.privacy_info_url = privacy_info_url;
            return this;
        }

        public Builder privacy_template_info(Map<String, String> privacy_template_info) {
            Internal.checkElementsNotNull(privacy_template_info);
            this.privacy_template_info = privacy_template_info;
            return this;
        }

        public Builder privacy_template_url(String privacy_template_url) {
            this.privacy_template_url = privacy_template_url;
            return this;
        }
    }

    private static final class ProtoAdapter_AdPrivacy extends ProtoAdapter<AdPrivacy> {
        private final ProtoAdapter<Map<String, String>> privacy_template_info;

        public ProtoAdapter_AdPrivacy() {
            super(FieldEncoding.LENGTH_DELIMITED, AdPrivacy.class);
            this.privacy_template_info = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public AdPrivacy m1379decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.privacy_info_url((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.privacy_template_url((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 3) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.privacy_template_info.putAll((Map) this.privacy_template_info.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, AdPrivacy value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.privacy_info_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.privacy_template_url);
            this.privacy_template_info.encodeWithTag(writer, 3, value.privacy_template_info);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(AdPrivacy value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.privacy_info_url) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.privacy_template_url) + this.privacy_template_info.encodedSizeWithTag(3, value.privacy_template_info) + value.unknownFields().size();
        }

        public AdPrivacy redact(AdPrivacy value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_AdPrivacy protoAdapter_AdPrivacy = new ProtoAdapter_AdPrivacy();
        ADAPTER = protoAdapter_AdPrivacy;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AdPrivacy);
    }

    public AdPrivacy(String privacy_info_url, String privacy_template_url, Map<String, String> privacy_template_info) {
        this(privacy_info_url, privacy_template_url, privacy_template_info, ByteString.EMPTY);
    }

    public AdPrivacy(String privacy_info_url, String privacy_template_url, Map<String, String> privacy_template_info, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.privacy_info_url = privacy_info_url;
        this.privacy_template_url = privacy_template_url;
        this.privacy_template_info = Internal.immutableCopyOf("privacy_template_info", privacy_template_info);
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AdPrivacy)) {
            return false;
        }
        AdPrivacy adPrivacy = (AdPrivacy) other;
        return unknownFields().equals(adPrivacy.unknownFields()) && Internal.equals(this.privacy_info_url, adPrivacy.privacy_info_url) && Internal.equals(this.privacy_template_url, adPrivacy.privacy_template_url) && this.privacy_template_info.equals(adPrivacy.privacy_template_info);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.privacy_info_url;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.privacy_template_url;
        int iHashCode3 = ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.privacy_template_info.hashCode();
        ((AndroidMessage) this).hashCode = iHashCode3;
        return iHashCode3;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.privacy_info_url = this.privacy_info_url;
        builder.privacy_template_url = this.privacy_template_url;
        builder.privacy_template_info = Internal.copyOf("privacy_template_info", this.privacy_template_info);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.privacy_info_url != null) {
            sb.append(", privacy_info_url=").append(this.privacy_info_url);
        }
        if (this.privacy_template_url != null) {
            sb.append(", privacy_template_url=").append(this.privacy_template_url);
        }
        if (!this.privacy_template_info.isEmpty()) {
            sb.append(", privacy_template_info=").append(this.privacy_template_info);
        }
        return sb.replace(0, 2, "AdPrivacy{").append('}').toString();
    }
}
