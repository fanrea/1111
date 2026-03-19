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
public final class CompanionEndcard extends AndroidMessage<CompanionEndcard, Builder> {
    public static final ProtoAdapter<CompanionEndcard> ADAPTER;
    public static final Parcelable.Creator<CompanionEndcard> CREATOR;
    public static final Integer DEFAULT_ANIMATE_TYPE;
    public static final String DEFAULT_BUTTON_TEXT = "";
    public static final Integer DEFAULT_CLICK_TYPE;
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final Float DEFAULT_SCORE;
    public static final Integer DEFAULT_SHOW_DELAY_SECS;
    public static final String DEFAULT_TITLE = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 10)
    public final Integer animate_type;

    @WireField(adapter = "Color#ADAPTER", tag = 8)
    public final Color bar_color;

    @WireField(adapter = "Color#ADAPTER", tag = 5)
    public final Color button_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String button_text;

    @WireField(adapter = "Color#ADAPTER", tag = 6)
    public final Color button_text_color;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer click_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String desc;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String icon_url;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float score;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 11)
    public final Integer show_delay_secs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String title;

    public static final class Builder extends Message.Builder<CompanionEndcard, Builder> {
        public Color bar_color;
        public Color button_color;
        public Color button_text_color;
        public String icon_url = "";
        public String title = "";
        public Float score = CompanionEndcard.DEFAULT_SCORE;
        public String button_text = "";
        public Integer click_type = CompanionEndcard.DEFAULT_CLICK_TYPE;
        public String desc = "";
        public Integer animate_type = CompanionEndcard.DEFAULT_ANIMATE_TYPE;
        public Integer show_delay_secs = CompanionEndcard.DEFAULT_SHOW_DELAY_SECS;

        public Builder animate_type(Integer animate_type) {
            this.animate_type = animate_type;
            return this;
        }

        public Builder bar_color(Color bar_color) {
            this.bar_color = bar_color;
            return this;
        }

        public CompanionEndcard build() {
            return new CompanionEndcard(this.icon_url, this.title, this.score, this.button_text, this.button_color, this.button_text_color, this.click_type, this.bar_color, this.desc, this.animate_type, this.show_delay_secs, super.buildUnknownFields());
        }

        public Builder button_color(Color button_color) {
            this.button_color = button_color;
            return this;
        }

        public Builder button_text(String button_text) {
            this.button_text = button_text;
            return this;
        }

        public Builder button_text_color(Color button_text_color) {
            this.button_text_color = button_text_color;
            return this;
        }

        public Builder click_type(Integer click_type) {
            this.click_type = click_type;
            return this;
        }

        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }

        public Builder icon_url(String icon_url) {
            this.icon_url = icon_url;
            return this;
        }

        public Builder score(Float score) {
            this.score = score;
            return this;
        }

        public Builder show_delay_secs(Integer show_delay_secs) {
            this.show_delay_secs = show_delay_secs;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }
    }

    private static final class ProtoAdapter_CompanionEndcard extends ProtoAdapter<CompanionEndcard> {
        public ProtoAdapter_CompanionEndcard() {
            super(FieldEncoding.LENGTH_DELIMITED, CompanionEndcard.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public CompanionEndcard m1400decode(ProtoReader reader) throws IOException {
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
                        builder.icon_url((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 2:
                        builder.title((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 3:
                        builder.score((Float) ProtoAdapter.FLOAT.decode(reader));
                        break;
                    case 4:
                        builder.button_text((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 5:
                        builder.button_color((Color) Color.ADAPTER.decode(reader));
                        break;
                    case 6:
                        builder.button_text_color((Color) Color.ADAPTER.decode(reader));
                        break;
                    case 7:
                        builder.click_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 8:
                        builder.bar_color((Color) Color.ADAPTER.decode(reader));
                        break;
                    case 9:
                        builder.desc((String) ProtoAdapter.STRING.decode(reader));
                        break;
                    case 10:
                        builder.animate_type((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    case 11:
                        builder.show_delay_secs((Integer) ProtoAdapter.UINT32.decode(reader));
                        break;
                    default:
                        FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                        builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                        break;
                }
            }
        }

        public void encode(ProtoWriter writer, CompanionEndcard value) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(writer, 1, value.icon_url);
            ProtoAdapter.STRING.encodeWithTag(writer, 2, value.title);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 3, value.score);
            ProtoAdapter.STRING.encodeWithTag(writer, 4, value.button_text);
            Color.ADAPTER.encodeWithTag(writer, 5, value.button_color);
            Color.ADAPTER.encodeWithTag(writer, 6, value.button_text_color);
            ProtoAdapter.UINT32.encodeWithTag(writer, 7, value.click_type);
            Color.ADAPTER.encodeWithTag(writer, 8, value.bar_color);
            ProtoAdapter.STRING.encodeWithTag(writer, 9, value.desc);
            ProtoAdapter.UINT32.encodeWithTag(writer, 10, value.animate_type);
            ProtoAdapter.UINT32.encodeWithTag(writer, 11, value.show_delay_secs);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(CompanionEndcard value) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, value.icon_url) + ProtoAdapter.STRING.encodedSizeWithTag(2, value.title) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, value.score) + ProtoAdapter.STRING.encodedSizeWithTag(4, value.button_text) + Color.ADAPTER.encodedSizeWithTag(5, value.button_color) + Color.ADAPTER.encodedSizeWithTag(6, value.button_text_color) + ProtoAdapter.UINT32.encodedSizeWithTag(7, value.click_type) + Color.ADAPTER.encodedSizeWithTag(8, value.bar_color) + ProtoAdapter.STRING.encodedSizeWithTag(9, value.desc) + ProtoAdapter.UINT32.encodedSizeWithTag(10, value.animate_type) + ProtoAdapter.UINT32.encodedSizeWithTag(11, value.show_delay_secs) + value.unknownFields().size();
        }

        public CompanionEndcard redact(CompanionEndcard value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.button_color != null) {
                builderNewBuilder.button_color = (Color) Color.ADAPTER.redact(builderNewBuilder.button_color);
            }
            if (builderNewBuilder.button_text_color != null) {
                builderNewBuilder.button_text_color = (Color) Color.ADAPTER.redact(builderNewBuilder.button_text_color);
            }
            if (builderNewBuilder.bar_color != null) {
                builderNewBuilder.bar_color = (Color) Color.ADAPTER.redact(builderNewBuilder.bar_color);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_CompanionEndcard protoAdapter_CompanionEndcard = new ProtoAdapter_CompanionEndcard();
        ADAPTER = protoAdapter_CompanionEndcard;
        CREATOR = AndroidMessage.newCreator(protoAdapter_CompanionEndcard);
        DEFAULT_SCORE = Float.valueOf(0.0f);
        DEFAULT_CLICK_TYPE = 0;
        DEFAULT_ANIMATE_TYPE = 0;
        DEFAULT_SHOW_DELAY_SECS = 0;
    }

    public CompanionEndcard(String icon_url, String title, Float score, String button_text, Color button_color, Color button_text_color, Integer click_type, Color bar_color, String desc, Integer animate_type, Integer show_delay_secs) {
        this(icon_url, title, score, button_text, button_color, button_text_color, click_type, bar_color, desc, animate_type, show_delay_secs, ByteString.EMPTY);
    }

    public CompanionEndcard(String icon_url, String title, Float score, String button_text, Color button_color, Color button_text_color, Integer click_type, Color bar_color, String desc, Integer animate_type, Integer show_delay_secs, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.icon_url = icon_url;
        this.title = title;
        this.score = score;
        this.button_text = button_text;
        this.button_color = button_color;
        this.button_text_color = button_text_color;
        this.click_type = click_type;
        this.bar_color = bar_color;
        this.desc = desc;
        this.animate_type = animate_type;
        this.show_delay_secs = show_delay_secs;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CompanionEndcard)) {
            return false;
        }
        CompanionEndcard companionEndcard = (CompanionEndcard) other;
        return unknownFields().equals(companionEndcard.unknownFields()) && Internal.equals(this.icon_url, companionEndcard.icon_url) && Internal.equals(this.title, companionEndcard.title) && Internal.equals(this.score, companionEndcard.score) && Internal.equals(this.button_text, companionEndcard.button_text) && Internal.equals(this.button_color, companionEndcard.button_color) && Internal.equals(this.button_text_color, companionEndcard.button_text_color) && Internal.equals(this.click_type, companionEndcard.click_type) && Internal.equals(this.bar_color, companionEndcard.bar_color) && Internal.equals(this.desc, companionEndcard.desc) && Internal.equals(this.animate_type, companionEndcard.animate_type) && Internal.equals(this.show_delay_secs, companionEndcard.show_delay_secs);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        String str = this.icon_url;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Float f = this.score;
        int iHashCode4 = (iHashCode3 + (f != null ? f.hashCode() : 0)) * 37;
        String str3 = this.button_text;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Color color = this.button_color;
        int iHashCode6 = (iHashCode5 + (color != null ? color.hashCode() : 0)) * 37;
        Color color2 = this.button_text_color;
        int iHashCode7 = (iHashCode6 + (color2 != null ? color2.hashCode() : 0)) * 37;
        Integer num = this.click_type;
        int iHashCode8 = (iHashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Color color3 = this.bar_color;
        int iHashCode9 = (iHashCode8 + (color3 != null ? color3.hashCode() : 0)) * 37;
        String str4 = this.desc;
        int iHashCode10 = (iHashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num2 = this.animate_type;
        int iHashCode11 = (iHashCode10 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.show_delay_secs;
        int iHashCode12 = iHashCode11 + (num3 != null ? num3.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode12;
        return iHashCode12;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.icon_url = this.icon_url;
        builder.title = this.title;
        builder.score = this.score;
        builder.button_text = this.button_text;
        builder.button_color = this.button_color;
        builder.button_text_color = this.button_text_color;
        builder.click_type = this.click_type;
        builder.bar_color = this.bar_color;
        builder.desc = this.desc;
        builder.animate_type = this.animate_type;
        builder.show_delay_secs = this.show_delay_secs;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.icon_url != null) {
            sb.append(", icon_url=").append(this.icon_url);
        }
        if (this.title != null) {
            sb.append(", title=").append(this.title);
        }
        if (this.score != null) {
            sb.append(", score=").append(this.score);
        }
        if (this.button_text != null) {
            sb.append(", button_text=").append(this.button_text);
        }
        if (this.button_color != null) {
            sb.append(", button_color=").append(this.button_color);
        }
        if (this.button_text_color != null) {
            sb.append(", button_text_color=").append(this.button_text_color);
        }
        if (this.click_type != null) {
            sb.append(", click_type=").append(this.click_type);
        }
        if (this.bar_color != null) {
            sb.append(", bar_color=").append(this.bar_color);
        }
        if (this.desc != null) {
            sb.append(", desc=").append(this.desc);
        }
        if (this.animate_type != null) {
            sb.append(", animate_type=").append(this.animate_type);
        }
        if (this.show_delay_secs != null) {
            sb.append(", show_delay_secs=").append(this.show_delay_secs);
        }
        return sb.replace(0, 2, "CompanionEndcard{").append('}').toString();
    }
}
