package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.Metadata;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class AutoValue_Metadata extends Metadata {
    private final Location location;

    private AutoValue_Metadata(Location location) {
        this.location = location;
    }

    @Override // androidx.camera.view.video.Metadata
    public Location getLocation() {
        return this.location;
    }

    public String toString() {
        return "Metadata{location=" + this.location + i.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Metadata)) {
            return false;
        }
        Location location = this.location;
        Location location2 = ((Metadata) obj).getLocation();
        return location == null ? location2 == null : location.equals(location2);
    }

    public int hashCode() {
        Location location = this.location;
        return (location == null ? 0 : location.hashCode()) ^ 1000003;
    }

    static final class Builder extends Metadata.Builder {
        private Location location;

        Builder() {
        }

        @Override // androidx.camera.view.video.Metadata.Builder
        public Metadata.Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        @Override // androidx.camera.view.video.Metadata.Builder
        public Metadata build() {
            return new AutoValue_Metadata(this.location);
        }
    }
}
