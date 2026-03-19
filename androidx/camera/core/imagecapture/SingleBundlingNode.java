package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.utils.Threads;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class SingleBundlingNode implements BundlingNode {
    private ProcessingNode.In mOutputEdge;
    private ProcessingRequest mPendingRequest;

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }

    SingleBundlingNode() {
    }

    @Override // androidx.camera.core.processing.Node
    public ProcessingNode.In transform(CaptureNode.Out out) {
        out.getImageEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.SingleBundlingNode$$ExternalSyntheticLambda0
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.matchImageWithRequest((ImageProxy) obj);
            }
        });
        out.getRequestEdge().setListener(new Consumer() { // from class: androidx.camera.core.imagecapture.SingleBundlingNode$$ExternalSyntheticLambda1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                this.f$0.trackIncomingRequest((ProcessingRequest) obj);
            }
        });
        ProcessingNode.In inOf = ProcessingNode.In.of(out.getFormat());
        this.mOutputEdge = inOf;
        return inOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackIncomingRequest(ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        Preconditions.checkState(processingRequest.getStageIds().size() == 1, "Cannot handle multi-image capture.");
        Preconditions.checkState(this.mPendingRequest == null, "Already has an existing request.");
        this.mPendingRequest = processingRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void matchImageWithRequest(ImageProxy imageProxy) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mPendingRequest != null);
        Preconditions.checkState(((Integer) Objects.requireNonNull(imageProxy.getImageInfo().getTagBundle().getTag(this.mPendingRequest.getTagBundleKey()))).intValue() == this.mPendingRequest.getStageIds().get(0).intValue());
        this.mOutputEdge.getEdge().accept(ProcessingNode.InputPacket.of(this.mPendingRequest, imageProxy));
        this.mPendingRequest = null;
    }
}
