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
public final class BiddingResponse extends AndroidMessage<BiddingResponse, Builder> {
    public static final ProtoAdapter<BiddingResponse> ADAPTER;
    public static final Parcelable.Creator<BiddingResponse> CREATOR;
    public static final Integer DEFAULT_ECPM;
    public static final String DEFAULT_LOSE_URL = "";
    public static final Integer DEFAULT_PRICE_FOR_SSP;
    public static final String DEFAULT_PRICE_FOR_SSP_ENC = "";
    public static final String DEFAULT_WIN_URL = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer ecpm;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String lose_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 4)
    public final Integer price_for_ssp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String price_for_ssp_enc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String win_url;

    public static final class Builder extends Message.Builder<BiddingResponse, Builder> {
        public Integer ecpm;
        public String lose_url;
        public Integer price_for_ssp;
        public String price_for_ssp_enc;
        public String win_url;

        public BiddingResponse build() {
            return new BiddingResponse(this.win_url, this.lose_url, this.ecpm, this.price_for_ssp, this.price_for_ssp_enc, super.buildUnknownFields());
        }

        public Builder ecpm(Integer ecpm) {
            this.ecpm = ecpm;
            return this;
        }

        public Builder lose_url(String lose_url) {
            this.lose_url = lose_url;
            return this;
        }

        public Builder price_for_ssp(Integer price_for_ssp) {
            this.price_for_ssp = price_for_ssp;
            return this;
        }

        public Builder price_for_ssp_enc(String price_for_ssp_enc) {
            this.price_for_ssp_enc = price_for_ssp_enc;
            return this;
        }

        public Builder win_url(String win_url) {
            this.win_url = win_url;
            return this;
        }
    }

    private static final class ProtoAdapter_BiddingResponse extends ProtoAdapter<BiddingResponse> {
        public ProtoAdapter_BiddingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BiddingResponse.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public BiddingResponse m1391decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.win_url((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.lose_url((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 3) {
                    builder.ecpm((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag == 4) {
                    builder.price_for_ssp((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 5) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.price_for_ssp_enc((String) ProtoAdapter.STRING.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, BiddingResponse value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.win_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.lose_url);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.ecpm);
            ProtoAdapter.UINT32.encodeWithTag(writer, 4, value.price_for_ssp);
            ProtoAdapter.STRING.encodeWithTag(writer, 5, value.price_for_ssp_enc);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(BiddingResponse value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.win_url) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.lose_url) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.ecpm) + ProtoAdapter.UINT32.encodedSizeWithTag(4, value.price_for_ssp) + ProtoAdapter.STRING.encodedSizeWithTag(5, value.price_for_ssp_enc) + value.unknownFields().size();
        }

        public BiddingResponse redact(BiddingResponse value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_BiddingResponse protoAdapter_BiddingResponse = new ProtoAdapter_BiddingResponse();
        ADAPTER = protoAdapter_BiddingResponse;
        CREATOR = AndroidMessage.newCreator(protoAdapter_BiddingResponse);
        DEFAULT_ECPM = 0;
        DEFAULT_PRICE_FOR_SSP = 0;
    }

    public BiddingResponse(String win_url, String lose_url, Integer ecpm, Integer price_for_ssp, String price_for_ssp_enc) {
        this(win_url, lose_url, ecpm, price_for_ssp, price_for_ssp_enc, ByteString.EMPTY);
    }

    public BiddingResponse(String win_url, String lose_url, Integer ecpm, Integer price_for_ssp, String price_for_ssp_enc, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.win_url = win_url;
        this.lose_url = lose_url;
        this.ecpm = ecpm;
        this.price_for_ssp = price_for_ssp;
        this.price_for_ssp_enc = price_for_ssp_enc;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof BiddingResponse)) {
            return false;
        }
        BiddingResponse biddingResponse = (BiddingResponse) other;
        return unknownFields().equals(biddingResponse.unknownFields()) && Internal.equals(this.win_url, biddingResponse.win_url) && Internal.equals(this.lose_url, biddingResponse.lose_url) && Internal.equals(this.ecpm, biddingResponse.ecpm) && Internal.equals(this.price_for_ssp, biddingResponse.price_for_ssp) && Internal.equals(this.price_for_ssp_enc, biddingResponse.price_for_ssp_enc);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.win_url;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.lose_url;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.ecpm;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.price_for_ssp;
        int iHashCode5 = (iHashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.price_for_ssp_enc;
        int iHashCode6 = iHashCode5 + (str3 != null ? str3.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode6;
        return iHashCode6;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.win_url = this.win_url;
        builder.lose_url = this.lose_url;
        builder.ecpm = this.ecpm;
        builder.price_for_ssp = this.price_for_ssp;
        builder.price_for_ssp_enc = this.price_for_ssp_enc;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.win_url != null) {
            sb.append(", win_url=").append(this.win_url);
        }
        if (this.lose_url != null) {
            sb.append(", lose_url=").append(this.lose_url);
        }
        if (this.ecpm != null) {
            sb.append(", ecpm=").append(this.ecpm);
        }
        if (this.price_for_ssp != null) {
            sb.append(", price_for_ssp=").append(this.price_for_ssp);
        }
        if (this.price_for_ssp_enc != null) {
            sb.append(", price_for_ssp_enc=").append(this.price_for_ssp_enc);
        }
        return sb.replace(0, 2, "BiddingResponse{").append('}').toString();
    }
}
