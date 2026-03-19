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
public final class AndroidMarket extends AndroidMessage<AndroidMarket, Builder> {
    public static final ProtoAdapter<AndroidMarket> ADAPTER;
    public static final Parcelable.Creator<AndroidMarket> CREATOR;
    public static final String DEFAULT_APPSTORE_PACKAGE_NAME = "";
    public static final String DEFAULT_APP_PACKAGE_NAME = "";
    public static final String DEFAULT_MARKET_URL = "";
    public static final Integer DEFAULT_TYPE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String app_package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String appstore_package_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String market_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer type;

    public static final class Builder extends Message.Builder<AndroidMarket, Builder> {
        public String app_package_name;
        public String appstore_package_name;
        public String market_url;
        public Integer type;

        public Builder app_package_name(String app_package_name) {
            this.app_package_name = app_package_name;
            return this;
        }

        public Builder appstore_package_name(String appstore_package_name) {
            this.appstore_package_name = appstore_package_name;
            return this;
        }

        public AndroidMarket build() {
            return new AndroidMarket(this.market_url, this.app_package_name, this.appstore_package_name, this.type, super.buildUnknownFields());
        }

        public Builder market_url(String market_url) {
            this.market_url = market_url;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }
    }

    private static final class ProtoAdapter_AndroidMarket extends ProtoAdapter<AndroidMarket> {
        public ProtoAdapter_AndroidMarket() {
            super(FieldEncoding.LENGTH_DELIMITED, AndroidMarket.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public AndroidMarket m1385decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.market_url((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.app_package_name((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 3) {
                    builder.appstore_package_name((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.type((Integer) ProtoAdapter.UINT32.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, AndroidMarket value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.market_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.app_package_name);
            ProtoAdapter.STRING.encodeWithTag(writer, 3, value.appstore_package_name);
            ProtoAdapter.UINT32.encodeWithTag(writer, 4, value.type);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(AndroidMarket value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.market_url) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.app_package_name) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.appstore_package_name) + ProtoAdapter.UINT32.encodedSizeWithTag(4, value.type) + value.unknownFields().size();
        }

        public AndroidMarket redact(AndroidMarket value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_AndroidMarket protoAdapter_AndroidMarket = new ProtoAdapter_AndroidMarket();
        ADAPTER = protoAdapter_AndroidMarket;
        CREATOR = AndroidMessage.newCreator(protoAdapter_AndroidMarket);
        DEFAULT_TYPE = 0;
    }

    public AndroidMarket(String market_url, String app_package_name, String appstore_package_name, Integer type) {
        this(market_url, app_package_name, appstore_package_name, type, ByteString.EMPTY);
    }

    public AndroidMarket(String market_url, String app_package_name, String appstore_package_name, Integer type, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.market_url = market_url;
        this.app_package_name = app_package_name;
        this.appstore_package_name = appstore_package_name;
        this.type = type;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AndroidMarket)) {
            return false;
        }
        AndroidMarket androidMarket = (AndroidMarket) other;
        return unknownFields().equals(androidMarket.unknownFields()) && Internal.equals(this.market_url, androidMarket.market_url) && Internal.equals(this.app_package_name, androidMarket.app_package_name) && Internal.equals(this.appstore_package_name, androidMarket.appstore_package_name) && Internal.equals(this.type, androidMarket.type);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.market_url;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.app_package_name;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.appstore_package_name;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.type;
        int iHashCode5 = iHashCode4 + (num != null ? num.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode5;
        return iHashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.market_url = this.market_url;
        builder.app_package_name = this.app_package_name;
        builder.appstore_package_name = this.appstore_package_name;
        builder.type = this.type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.market_url != null) {
            sb.append(", market_url=").append(this.market_url);
        }
        if (this.app_package_name != null) {
            sb.append(", app_package_name=").append(this.app_package_name);
        }
        if (this.appstore_package_name != null) {
            sb.append(", appstore_package_name=").append(this.appstore_package_name);
        }
        if (this.type != null) {
            sb.append(", type=").append(this.type);
        }
        return sb.replace(0, 2, "AndroidMarket{").append('}').toString();
    }
}
