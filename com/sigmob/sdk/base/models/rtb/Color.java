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
public final class Color extends AndroidMessage<Color, Builder> {
    public static final ProtoAdapter<Color> ADAPTER;
    public static final Parcelable.Creator<Color> CREATOR;
    public static final Float DEFAULT_ALPHA;
    public static final Integer DEFAULT_BLUE;
    public static final Integer DEFAULT_GREEN;
    public static final Integer DEFAULT_RED;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float alpha;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 3)
    public final Integer blue;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer green;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer red;

    public static final class Builder extends Message.Builder<Color, Builder> {
        public Integer red = Color.DEFAULT_RED;
        public Integer green = Color.DEFAULT_GREEN;
        public Integer blue = Color.DEFAULT_BLUE;
        public Float alpha = Color.DEFAULT_ALPHA;

        public Builder alpha(Float alpha) {
            this.alpha = alpha;
            return this;
        }

        public Builder blue(Integer blue) {
            this.blue = blue;
            return this;
        }

        public Color build() {
            return new Color(this.red, this.green, this.blue, this.alpha, super.buildUnknownFields());
        }

        public Builder green(Integer green) {
            this.green = green;
            return this;
        }

        public Builder red(Integer red) {
            this.red = red;
            return this;
        }
    }

    private static final class ProtoAdapter_Color extends ProtoAdapter<Color> {
        public ProtoAdapter_Color() {
            super(FieldEncoding.LENGTH_DELIMITED, Color.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public Color m1397decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.red((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag == 2) {
                    builder.green((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag == 3) {
                    builder.blue((Integer) ProtoAdapter.UINT32.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.alpha((Float) ProtoAdapter.FLOAT.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, Color value) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(writer, 1, value.red);
            ProtoAdapter.UINT32.encodeWithTag(writer, 2, value.green);
            ProtoAdapter.UINT32.encodeWithTag(writer, 3, value.blue);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 4, value.alpha);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(Color value) {
            return ProtoAdapter.UINT32.encodedSizeWithTag(1, value.red) + ProtoAdapter.UINT32.encodedSizeWithTag(2, value.green) + ProtoAdapter.UINT32.encodedSizeWithTag(3, value.blue) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, value.alpha) + value.unknownFields().size();
        }

        public Color redact(Color value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_Color protoAdapter_Color = new ProtoAdapter_Color();
        ADAPTER = protoAdapter_Color;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Color);
        DEFAULT_RED = 0;
        DEFAULT_GREEN = 0;
        DEFAULT_BLUE = 0;
        DEFAULT_ALPHA = Float.valueOf(0.0f);
    }

    public Color(Integer red, Integer green, Integer blue, Float alpha) {
        this(red, green, blue, alpha, ByteString.EMPTY);
    }

    public Color(Integer red, Integer green, Integer blue, Float alpha, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Color)) {
            return false;
        }
        Color color = (Color) other;
        return unknownFields().equals(color.unknownFields()) && Internal.equals(this.red, color.red) && Internal.equals(this.green, color.green) && Internal.equals(this.blue, color.blue) && Internal.equals(this.alpha, color.alpha);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Integer num = this.red;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.green;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.blue;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Float f = this.alpha;
        int iHashCode5 = iHashCode4 + (f != null ? f.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode5;
        return iHashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.red = this.red;
        builder.green = this.green;
        builder.blue = this.blue;
        builder.alpha = this.alpha;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.red != null) {
            sb.append(", red=").append(this.red);
        }
        if (this.green != null) {
            sb.append(", green=").append(this.green);
        }
        if (this.blue != null) {
            sb.append(", blue=").append(this.blue);
        }
        if (this.alpha != null) {
            sb.append(", alpha=").append(this.alpha);
        }
        return sb.replace(0, 2, "Color{").append('}').toString();
    }
}
