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
public final class SigmobDialogSetting extends AndroidMessage<SigmobDialogSetting, Builder> {
    public static final ProtoAdapter<SigmobDialogSetting> ADAPTER;
    public static final Parcelable.Creator<SigmobDialogSetting> CREATOR;
    public static final String DEFAULT_BODY_TEXT = "";
    public static final String DEFAULT_CANCEL_BUTTON_TEXT = "";
    public static final String DEFAULT_CLOSE_BUTTON_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String cancel_button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String close_button_text;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String title;

    public static final class Builder extends Message.Builder<SigmobDialogSetting, Builder> {
        public String body_text;
        public String cancel_button_text;
        public String close_button_text;
        public String title;

        public Builder body_text(String body_text) {
            this.body_text = body_text;
            return this;
        }

        public SigmobDialogSetting build() {
            return new SigmobDialogSetting(this.title, this.body_text, this.cancel_button_text, this.close_button_text, super.buildUnknownFields());
        }

        public Builder cancel_button_text(String cancel_button_text) {
            this.cancel_button_text = cancel_button_text;
            return this;
        }

        public Builder close_button_text(String close_button_text) {
            this.close_button_text = close_button_text;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobDialogSetting extends ProtoAdapter<SigmobDialogSetting> {
        public ProtoAdapter_SigmobDialogSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobDialogSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobDialogSetting m1352decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.title((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 2) {
                    builder.body_text((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag == 3) {
                    builder.cancel_button_text((String) ProtoAdapter.STRING.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.close_button_text((String) ProtoAdapter.STRING.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobDialogSetting value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.title);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.body_text);
            ProtoAdapter.STRING.encodeWithTag(writer, 3, value.cancel_button_text);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.close_button_text);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobDialogSetting value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.title) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.body_text) + ProtoAdapter.STRING.encodedSizeWithTag(3, value.cancel_button_text) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.close_button_text) + value.unknownFields().size();
        }

        public SigmobDialogSetting redact(SigmobDialogSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobDialogSetting protoAdapter_SigmobDialogSetting = new ProtoAdapter_SigmobDialogSetting();
        ADAPTER = protoAdapter_SigmobDialogSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobDialogSetting);
    }

    public SigmobDialogSetting(String title, String body_text, String cancel_button_text, String close_button_text) {
        this(title, body_text, cancel_button_text, close_button_text, ByteString.EMPTY);
    }

    public SigmobDialogSetting(String title, String body_text, String cancel_button_text, String close_button_text, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.title = title;
        this.body_text = body_text;
        this.cancel_button_text = cancel_button_text;
        this.close_button_text = close_button_text;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobDialogSetting)) {
            return false;
        }
        SigmobDialogSetting sigmobDialogSetting = (SigmobDialogSetting) other;
        return unknownFields().equals(sigmobDialogSetting.unknownFields()) && Internal.equals(this.title, sigmobDialogSetting.title) && Internal.equals(this.body_text, sigmobDialogSetting.body_text) && Internal.equals(this.cancel_button_text, sigmobDialogSetting.cancel_button_text) && Internal.equals(this.close_button_text, sigmobDialogSetting.close_button_text);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.body_text;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.cancel_button_text;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.close_button_text;
        int iHashCode5 = iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode5;
        return iHashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.title = this.title;
        builder.body_text = this.body_text;
        builder.cancel_button_text = this.cancel_button_text;
        builder.close_button_text = this.close_button_text;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.title != null) {
            sb.append(", title=").append(this.title);
        }
        if (this.body_text != null) {
            sb.append(", body_text=").append(this.body_text);
        }
        if (this.cancel_button_text != null) {
            sb.append(", cancel_button_text=").append(this.cancel_button_text);
        }
        if (this.close_button_text != null) {
            sb.append(", close_button_text=").append(this.close_button_text);
        }
        return sb.replace(0, 2, "SigmobDialogSetting{").append('}').toString();
    }
}
