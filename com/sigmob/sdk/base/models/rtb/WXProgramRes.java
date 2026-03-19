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
public final class WXProgramRes extends AndroidMessage<WXProgramRes, Builder> {
    public static final ProtoAdapter<WXProgramRes> ADAPTER;
    public static final Parcelable.Creator<WXProgramRes> CREATOR;
    public static final String DEFAULT_WX_APP_ID = "";
    public static final String DEFAULT_WX_APP_PATH = "";
    public static final String DEFAULT_WX_APP_USERNAME = "";
    public static final Integer DEFAULT_WX_BUSINESS_TYPE;
    public static final String DEFAULT_WX_EXT_MSG = "";
    public static final String DEFAULT_WX_UNIVERSAL_LINK = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String wx_app_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String wx_app_path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String wx_app_username;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 6)
    public final Integer wx_business_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String wx_ext_msg;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String wx_universal_link;

    public static final class Builder extends Message.Builder<WXProgramRes, Builder> {
        public String wx_app_id = "";
        public String wx_universal_link = "";
        public String wx_app_username = "";
        public String wx_app_path = "";
        public String wx_ext_msg = "";
        public Integer wx_business_type = WXProgramRes.DEFAULT_WX_BUSINESS_TYPE;

        public WXProgramRes build() {
            return new WXProgramRes(this.wx_app_id, this.wx_universal_link, this.wx_app_username, this.wx_app_path, this.wx_ext_msg, this.wx_business_type, super.buildUnknownFields());
        }

        public Builder wx_app_id(String wx_app_id) {
            this.wx_app_id = wx_app_id;
            return this;
        }

        public Builder wx_app_path(String wx_app_path) {
            this.wx_app_path = wx_app_path;
            return this;
        }

        public Builder wx_app_username(String wx_app_username) {
            this.wx_app_username = wx_app_username;
            return this;
        }

        public Builder wx_business_type(Integer wx_business_type) {
            this.wx_business_type = wx_business_type;
            return this;
        }

        public Builder wx_ext_msg(String wx_ext_msg) {
            this.wx_ext_msg = wx_ext_msg;
            return this;
        }

        public Builder wx_universal_link(String wx_universal_link) {
            this.wx_universal_link = wx_universal_link;
            return this;
        }
    }

    private static final class ProtoAdapter_WXProgramRes extends ProtoAdapter<WXProgramRes> {
        public ProtoAdapter_WXProgramRes() {
            super(FieldEncoding.LENGTH_DELIMITED, WXProgramRes.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public WXProgramRes m1451decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                switch (iNextTag) {
                    case 1:
                        builder.wx_app_id((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 2:
                        builder.wx_universal_link((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 3:
                        builder.wx_app_username((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 4:
                        builder.wx_app_path((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 5:
                        builder.wx_ext_msg((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 6:
                        builder.wx_business_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, WXProgramRes value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.wx_app_id);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.wx_universal_link);
            ProtoAdapter.STRING.encodeWithTag(writer, 3, value.wx_app_username);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.wx_app_path);
            ProtoAdapter.STRING.encodeWithTag(writer, 5, value.wx_ext_msg);
            ProtoAdapter.UINT32.encodeWithTag(writer, 6, value.wx_business_type);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(WXProgramRes value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.wx_app_id) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.wx_universal_link) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.wx_app_username) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.wx_app_path) + ProtoAdapter.STRING.encodedSizeWithTag(5, value.wx_ext_msg) + ProtoAdapter.UINT32.encodedSizeWithTag(6, value.wx_business_type) + value.unknownFields().size();
        }

        public WXProgramRes redact(WXProgramRes value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_WXProgramRes protoAdapter_WXProgramRes = new ProtoAdapter_WXProgramRes();
        ADAPTER = protoAdapter_WXProgramRes;
        CREATOR = AndroidMessage.newCreator(protoAdapter_WXProgramRes);
        DEFAULT_WX_BUSINESS_TYPE = 0;
    }

    public WXProgramRes(String wx_app_id, String wx_universal_link, String wx_app_username, String wx_app_path, String wx_ext_msg, Integer wx_business_type) {
        this(wx_app_id, wx_universal_link, wx_app_username, wx_app_path, wx_ext_msg, wx_business_type, ByteString.EMPTY);
    }

    public WXProgramRes(String wx_app_id, String wx_universal_link, String wx_app_username, String wx_app_path, String wx_ext_msg, Integer wx_business_type, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.wx_app_id = wx_app_id;
        this.wx_universal_link = wx_universal_link;
        this.wx_app_username = wx_app_username;
        this.wx_app_path = wx_app_path;
        this.wx_ext_msg = wx_ext_msg;
        this.wx_business_type = wx_business_type;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof WXProgramRes)) {
            return false;
        }
        WXProgramRes wXProgramRes = (WXProgramRes) other;
        return unknownFields().equals(wXProgramRes.unknownFields()) && Internal.equals(this.wx_app_id, wXProgramRes.wx_app_id) && Internal.equals(this.wx_universal_link, wXProgramRes.wx_universal_link) && Internal.equals(this.wx_app_username, wXProgramRes.wx_app_username) && Internal.equals(this.wx_app_path, wXProgramRes.wx_app_path) && Internal.equals(this.wx_ext_msg, wXProgramRes.wx_ext_msg) && Internal.equals(this.wx_business_type, wXProgramRes.wx_business_type);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.wx_app_id;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.wx_universal_link;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.wx_app_username;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.wx_app_path;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.wx_ext_msg;
        int iHashCode6 = (iHashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.wx_business_type;
        int iHashCode7 = iHashCode6 + (num != null ? num.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode7;
        return iHashCode7;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.wx_app_id = this.wx_app_id;
        builder.wx_universal_link = this.wx_universal_link;
        builder.wx_app_username = this.wx_app_username;
        builder.wx_app_path = this.wx_app_path;
        builder.wx_ext_msg = this.wx_ext_msg;
        builder.wx_business_type = this.wx_business_type;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.wx_app_id != null) {
            sb.append(", wx_app_id=").append(this.wx_app_id);
        }
        if (this.wx_universal_link != null) {
            sb.append(", wx_universal_link=").append(this.wx_universal_link);
        }
        if (this.wx_app_username != null) {
            sb.append(", wx_app_username=").append(this.wx_app_username);
        }
        if (this.wx_app_path != null) {
            sb.append(", wx_app_path=").append(this.wx_app_path);
        }
        if (this.wx_ext_msg != null) {
            sb.append(", wx_ext_msg=").append(this.wx_ext_msg);
        }
        if (this.wx_business_type != null) {
            sb.append(", wx_business_type=").append(this.wx_business_type);
        }
        return sb.replace(0, 2, "WXProgramRes{").append('}').toString();
    }
}
