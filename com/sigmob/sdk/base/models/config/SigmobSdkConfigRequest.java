package com.sigmob.sdk.base.models.config;

import android.os.Parcelable;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.Device;
import com.czhj.sdk.common.models.Network;
import com.czhj.sdk.common.models.Privacy;
import com.czhj.sdk.common.models.User;
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
public final class SigmobSdkConfigRequest extends AndroidMessage<SigmobSdkConfigRequest, Builder> {
    public static final ProtoAdapter<SigmobSdkConfigRequest> ADAPTER;
    public static final Parcelable.Creator<SigmobSdkConfigRequest> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.common.models.App#ADAPTER", tag = 1)
    public final App app;

    @WireField(adapter = "com.sigmob.sdk.common.models.Device#ADAPTER", tag = 2)
    public final Device device;

    @WireField(adapter = "com.sigmob.sdk.common.models.Network#ADAPTER", tag = 3)
    public final Network network;

    @WireField(adapter = "com.sigmob.sdk.common.models.Privacy#ADAPTER", tag = 4)
    public final Privacy privacy;

    @WireField(adapter = "com.sigmob.sdk.common.models.User#ADAPTER", tag = 5)
    public final User user;

    public static final class Builder extends Message.Builder<SigmobSdkConfigRequest, Builder> {
        public App app;
        public Device device;
        public Network network;
        public Privacy privacy;
        public User user;

        public Builder app(App app) {
            this.app = app;
            return this;
        }

        public SigmobSdkConfigRequest build() {
            return new SigmobSdkConfigRequest(this.app, this.device, this.network, this.privacy, this.user, super.buildUnknownFields());
        }

        public Builder device(Device device) {
            this.device = device;
            return this;
        }

        public Builder network(Network network) {
            this.network = network;
            return this;
        }

        public Builder privacy(Privacy privacy) {
            this.privacy = privacy;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }
    }

    private static final class ProtoAdapter_SigmobSdkConfigRequest extends ProtoAdapter<SigmobSdkConfigRequest> {
        public ProtoAdapter_SigmobSdkConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSdkConfigRequest.class);
        }

        /* renamed from: decode, reason: merged with bridge method [inline-methods] */
        public SigmobSdkConfigRequest m1367decode(ProtoReader reader) throws IOException {
            Builder builder = new Builder();
            long jBeginMessage = reader.beginMessage();
            while (true) {
                int iNextTag = reader.nextTag();
                if (iNextTag == -1) {
                    reader.endMessage(jBeginMessage);
                    return builder.build();
                }
                if (iNextTag == 1) {
                    builder.app((App) App.ADAPTER.decode(reader));
                } else if (iNextTag == 2) {
                    builder.device((Device) Device.ADAPTER.decode(reader));
                } else if (iNextTag == 3) {
                    builder.network((Network) Network.ADAPTER.decode(reader));
                } else if (iNextTag == 4) {
                    builder.privacy((Privacy) Privacy.ADAPTER.decode(reader));
                } else if (iNextTag != 5) {
                    FieldEncoding fieldEncodingPeekFieldEncoding = reader.peekFieldEncoding();
                    builder.addUnknownField(iNextTag, fieldEncodingPeekFieldEncoding, fieldEncodingPeekFieldEncoding.rawProtoAdapter().decode(reader));
                } else {
                    builder.user((User) User.ADAPTER.decode(reader));
                }
            }
        }

        public void encode(ProtoWriter writer, SigmobSdkConfigRequest value) throws IOException {
            App.ADAPTER.encodeWithTag(writer, 1, value.app);
            Device.ADAPTER.encodeWithTag(writer, 2, value.device);
            Network.ADAPTER.encodeWithTag(writer, 3, value.network);
            Privacy.ADAPTER.encodeWithTag(writer, 4, value.privacy);
            User.ADAPTER.encodeWithTag(writer, 5, value.user);
            writer.writeBytes(value.unknownFields());
        }

        public int encodedSize(SigmobSdkConfigRequest value) {
            return App.ADAPTER.encodedSizeWithTag(1, value.app) + Device.ADAPTER.encodedSizeWithTag(2, value.device) + Network.ADAPTER.encodedSizeWithTag(3, value.network) + Privacy.ADAPTER.encodedSizeWithTag(4, value.privacy) + User.ADAPTER.encodedSizeWithTag(5, value.user) + value.unknownFields().size();
        }

        public SigmobSdkConfigRequest redact(SigmobSdkConfigRequest value) {
            Builder builderNewBuilder = value.newBuilder();
            if (builderNewBuilder.app != null) {
                builderNewBuilder.app = (App) App.ADAPTER.redact(builderNewBuilder.app);
            }
            if (builderNewBuilder.device != null) {
                builderNewBuilder.device = (Device) Device.ADAPTER.redact(builderNewBuilder.device);
            }
            if (builderNewBuilder.network != null) {
                builderNewBuilder.network = (Network) Network.ADAPTER.redact(builderNewBuilder.network);
            }
            if (builderNewBuilder.privacy != null) {
                builderNewBuilder.privacy = (Privacy) Privacy.ADAPTER.redact(builderNewBuilder.privacy);
            }
            if (builderNewBuilder.user != null) {
                builderNewBuilder.user = (User) User.ADAPTER.redact(builderNewBuilder.user);
            }
            builderNewBuilder.clearUnknownFields();
            return builderNewBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobSdkConfigRequest protoAdapter_SigmobSdkConfigRequest = new ProtoAdapter_SigmobSdkConfigRequest();
        ADAPTER = protoAdapter_SigmobSdkConfigRequest;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobSdkConfigRequest);
    }

    public SigmobSdkConfigRequest(App app, Device device, Network network, Privacy privacy, User user) {
        this(app, device, network, privacy, user, ByteString.EMPTY);
    }

    public SigmobSdkConfigRequest(App app, Device device, Network network, Privacy privacy, User user, ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        this.app = app;
        this.device = device;
        this.network = network;
        this.privacy = privacy;
        this.user = user;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SigmobSdkConfigRequest)) {
            return false;
        }
        SigmobSdkConfigRequest sigmobSdkConfigRequest = (SigmobSdkConfigRequest) other;
        return unknownFields().equals(sigmobSdkConfigRequest.unknownFields()) && Internal.equals(this.app, sigmobSdkConfigRequest.app) && Internal.equals(this.device, sigmobSdkConfigRequest.device) && Internal.equals(this.network, sigmobSdkConfigRequest.network) && Internal.equals(this.privacy, sigmobSdkConfigRequest.privacy) && Internal.equals(this.user, sigmobSdkConfigRequest.user);
    }

    public int hashCode() {
        int i = ((AndroidMessage) this).hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = unknownFields().hashCode() * 37;
        App app = this.app;
        int iHashCode2 = (iHashCode + (app != null ? app.hashCode() : 0)) * 37;
        Device device = this.device;
        int iHashCode3 = (iHashCode2 + (device != null ? device.hashCode() : 0)) * 37;
        Network network = this.network;
        int iHashCode4 = (iHashCode3 + (network != null ? network.hashCode() : 0)) * 37;
        Privacy privacy = this.privacy;
        int iHashCode5 = (iHashCode4 + (privacy != null ? privacy.hashCode() : 0)) * 37;
        User user = this.user;
        int iHashCode6 = iHashCode5 + (user != null ? user.hashCode() : 0);
        ((AndroidMessage) this).hashCode = iHashCode6;
        return iHashCode6;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.app = this.app;
        builder.device = this.device;
        builder.network = this.network;
        builder.privacy = this.privacy;
        builder.user = this.user;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.app != null) {
            sb.append(", app=").append(this.app);
        }
        if (this.device != null) {
            sb.append(", device=").append(this.device);
        }
        if (this.network != null) {
            sb.append(", network=").append(this.network);
        }
        if (this.privacy != null) {
            sb.append(", privacy=").append(this.privacy);
        }
        if (this.user != null) {
            sb.append(", user=").append(this.user);
        }
        return sb.replace(0, 2, "SigmobSdkConfigRequest{").append('}').toString();
    }
}
