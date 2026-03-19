package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.processing.Edge;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class AutoValue_CaptureNode_Out extends CaptureNode.Out {
    private final int format;
    private final Edge<ImageProxy> imageEdge;
    private final Edge<ProcessingRequest> requestEdge;

    AutoValue_CaptureNode_Out(Edge<ImageProxy> edge, Edge<ProcessingRequest> edge2, int i) {
        if (edge == null) {
            throw new NullPointerException("Null imageEdge");
        }
        this.imageEdge = edge;
        if (edge2 == null) {
            throw new NullPointerException("Null requestEdge");
        }
        this.requestEdge = edge2;
        this.format = i;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    Edge<ImageProxy> getImageEdge() {
        return this.imageEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    Edge<ProcessingRequest> getRequestEdge() {
        return this.requestEdge;
    }

    @Override // androidx.camera.core.imagecapture.CaptureNode.Out
    int getFormat() {
        return this.format;
    }

    public String toString() {
        return "Out{imageEdge=" + this.imageEdge + ", requestEdge=" + this.requestEdge + ", format=" + this.format + i.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CaptureNode.Out)) {
            return false;
        }
        CaptureNode.Out out = (CaptureNode.Out) obj;
        return this.imageEdge.equals(out.getImageEdge()) && this.requestEdge.equals(out.getRequestEdge()) && this.format == out.getFormat();
    }

    public int hashCode() {
        return ((((this.imageEdge.hashCode() ^ 1000003) * 1000003) ^ this.requestEdge.hashCode()) * 1000003) ^ this.format;
    }
}
