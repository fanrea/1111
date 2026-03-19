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
public final class ClickAreaSetting extends AndroidMessage<ClickAreaSetting, Builder> {
    public static final ProtoAdapter<ClickAreaSetting> ADAPTER;
    public static final Parcelable.Creator<ClickAreaSetting> CREATOR;
    public static final Float DEFAULT_BOTTOM;
    public static final Float DEFAULT_LEFT;
    public static final Float DEFAULT_RIGHT;
    public static final Float DEFAULT_TOP;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float bottom;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float left;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float right;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float top;

    public static final class Builder extends Message.Builder<ClickAreaSetting, Builder> {
        public Float top = ClickAreaSetting.DEFAULT_TOP;
        public Float left = ClickAreaSetting.DEFAULT_LEFT;
        public Float bottom = ClickAreaSetting.DEFAULT_BOTTOM;
        public Float right = ClickAreaSetting.DEFAULT_RIGHT;

        public Builder bottom(Float bottom) {
            this.bottom = bottom;
            return this;
        }

        public ClickAreaSetting build() {
            return new ClickAreaSetting(this.top, this.left, this.bottom, this.right, super.buildUnknownFields());
        }

        public Builder left(Float left) {
            this.left = left;
            return this;
        }

        public Builder right(Float right) {
            this.right = right;
            return this;
        }

        public Builder top(Float top) {
            this.top = top;
            return this;
        }
    }

    private static final class ProtoAdapter_ClickAreaSetting extends ProtoAdapter<ClickAreaSetting> {
        public ProtoAdapter_ClickAreaSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ClickAreaSetting.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public ClickAreaSetting m1394decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.top((Float) ProtoAdapter.FLOAT.decode(reader));
                } else if (iNextTag == 2) {
                    builder.left((Float) ProtoAdapter.FLOAT.decode(reader));
                } else if (iNextTag == 3) {
                    builder.bottom((Float) ProtoAdapter.FLOAT.decode(reader));
                } else if (iNextTag != 4) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.right((Float) ProtoAdapter.FLOAT.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, ClickAreaSetting value) throws IOException {
            ProtoAdapter.FLOAT.encodeWithTag(writer, 1, value.top);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 2, value.left);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 3, value.bottom);
            ProtoAdapter.FLOAT.encodeWithTag(writer, 4, value.right);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(ClickAreaSetting value) {
            return ProtoAdapter.FLOAT.encodedSizeWithTag(1, value.top) + ProtoAdapter.FLOAT.encodedSizeWithTag(2, value.left) + ProtoAdapter.FLOAT.encodedSizeWithTag(3, value.bottom) + ProtoAdapter.FLOAT.encodedSizeWithTag(4, value.right) + value.unknownFields().size();
        }

        public ClickAreaSetting redact(ClickAreaSetting value) {
            Builder builderNewBuilder = value.newBuilder();
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_ClickAreaSetting protoAdapter_ClickAreaSetting = new ProtoAdapter_ClickAreaSetting();
        ADAPTER = protoAdapter_ClickAreaSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_ClickAreaSetting);
        Float fValueOf = Float.valueOf(0.0f);
        DEFAULT_TOP = fValueOf;
        DEFAULT_LEFT = fValueOf;
        DEFAULT_BOTTOM = fValueOf;
        DEFAULT_RIGHT = fValueOf;
    }

    public ClickAreaSetting(Float top, Float left, Float bottom, Float right) {
        this(top, left, bottom, right, ByteString.EMPTY);
    }

    public ClickAreaSetting(Float top, Float left, Float bottom, Float right, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ClickAreaSetting)) {
            return false;
        }
        ClickAreaSetting clickAreaSetting = (ClickAreaSetting) other;
        return unknownFields().equals(clickAreaSetting.unknownFields()) && Internal.equals(this.top, clickAreaSetting.top) && Internal.equals(this.left, clickAreaSetting.left) && Internal.equals(this.bottom, clickAreaSetting.bottom) && Internal.equals(this.right, clickAreaSetting.right);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        Float f = this.top;
        int iHashCode2 = (iHashCode + (f != null ? f.hashCode() : 0)) * 37;
        Float f2 = this.left;
        int iHashCode3 = (iHashCode2 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Float f3 = this.bottom;
        int iHashCode4 = (iHashCode3 + (f3 != null ? f3.hashCode() : 0)) * 37;
        Float f4 = this.right;
        int iHashCode5 = iHashCode4 + (f4 != null ? f4.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode5;
        return iHashCode5;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.top = this.top;
        builder.left = this.left;
        builder.bottom = this.bottom;
        builder.right = this.right;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.top != null) {
            sb.append(", top=").append(this.top);
        }
        if (this.left != null) {
            sb.append(", left=").append(this.left);
        }
        if (this.bottom != null) {
            sb.append(", bottom=").append(this.bottom);
        }
        if (this.right != null) {
            sb.append(", right=").append(this.right);
        }
        return sb.replace(0, 2, "ClickAreaSetting{").append('}').toString();
    }
}
