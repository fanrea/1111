package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class AutoValue_CaptureNode_In extends CaptureNode.In {
    private final int format;
    private final Edge<ProcessingRequest> requestEdge;
    private final Size size;

    AutoValue_CaptureNode_In(Size size, int i, Edge<ProcessingRequest> edge) {
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.size = size;
        this.format = i;
        if (edge == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.requestEdge = edge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    Size getSize() {
        return this.size;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    int getFormat() {
        return this.format;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.In
    Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    public String toString() {
        return "In{size=" + this.size + ", format=" + this.format + ", requestEdge=" + this.requestEdge + i.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.In)) {
            return false;
        }
        CaptureNode.In in = (CaptureNode.In) obj;
        return this.size.equals(in.getSize()) && this.format == in.getFormat() && this.requestEdge.equals(in.getRequestEdge());
    }

    public int hashCode() {
        return ((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.format) * 1000003) ^ this.requestEdge.hashCode();
    }
}
