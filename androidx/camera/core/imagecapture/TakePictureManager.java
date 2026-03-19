package androidx.camera.core.imagecapture;

import android.util.Log;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class TakePictureManager implements ForwardingImageProxy.OnImageCloseListener {
    private static final String TAG = "TakePictureManager";
    final ImageCaptureControl mImageCaptureControl;
    final ImagePipeline mImagePipeline;
    RequestWithCallback mInFlightRequest;
    final Deque<TakePictureRequest> mNewRequests = new ArrayDeque();
    boolean mPaused = false;

    public TakePictureManager(ImageCaptureControl imageCaptureControl, ImagePipeline imagePipeline) {
        Threads.checkMainThread();
        this.mImageCaptureControl = imageCaptureControl;
        this.mImagePipeline = imagePipeline;
        imagePipeline.setOnImageCloseListener(this);
    }

    public void offerRequest(TakePictureRequest takePictureRequest) {
        Threads.checkMainThread();
        this.mNewRequests.offer(takePictureRequest);
        issueNextRequest();
    }

    public void pause() {
        Threads.checkMainThread();
        this.mPaused = true;
    }

    public void resume() {
        Threads.checkMainThread();
        this.mPaused = false;
        issueNextRequest();
    }

    public void abortRequests() {
        Threads.checkMainThread();
        ImageCaptureException imageCaptureException = new ImageCaptureException(3, "Camera is closed.", null);
        Iterator<TakePictureRequest> it = this.mNewRequests.iterator();
        while (it.hasNext()) {
            it.next().onError(imageCaptureException);
        }
        this.mNewRequests.clear();
        RequestWithCallback requestWithCallback = this.mInFlightRequest;
        if (requestWithCallback != null) {
            requestWithCallback.abort(imageCaptureException);
        }
    }

    void issueNextRequest() {
        Threads.checkMainThread();
        Log.d(TAG, "Issue the next TakePictureRequest.");
        if (hasInFlightRequest()) {
            Log.d(TAG, "There is already a request in-flight.");
            return;
        }
        if (this.mPaused) {
            Log.d(TAG, "The class is paused.");
            return;
        }
        if (this.mImagePipeline.getCapacity() == 0) {
            Log.d(TAG, "Too many acquire images. Close image to be able to process next.");
            return;
        }
        TakePictureRequest takePictureRequestPoll = this.mNewRequests.poll();
        if (takePictureRequestPoll == null) {
            Log.d(TAG, "No new request.");
            return;
        }
        RequestWithCallback requestWithCallback = new RequestWithCallback(takePictureRequestPoll);
        trackCurrentRequest(requestWithCallback);
        Pair<CameraRequest, ProcessingRequest> pairCreateRequests = this.mImagePipeline.createRequests(takePictureRequestPoll, requestWithCallback);
        CameraRequest cameraRequest = (CameraRequest) Objects.requireNonNull(pairCreateRequests.first);
        final ProcessingRequest processingRequest = (ProcessingRequest) Objects.requireNonNull(pairCreateRequests.second);
        submitCameraRequest(cameraRequest, new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m157xe103a0c6(processingRequest);
            }
        });
    }

    /* renamed from: lambda$issueNextRequest$0$androidx-camera-core-imagecapture-TakePictureManager, reason: not valid java name */
    /* synthetic */ void m157xe103a0c6(ProcessingRequest processingRequest) {
        this.mImagePipeline.postProcess(processingRequest);
    }

    private void trackCurrentRequest(RequestWithCallback requestWithCallback) {
        Preconditions.checkState(!hasInFlightRequest());
        this.mInFlightRequest = requestWithCallback;
        requestWithCallback.getCaptureFuture().addListener(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m158xf8164f01();
            }
        }, CameraXExecutors.directExecutor());
    }

    /* renamed from: lambda$trackCurrentRequest$1$androidx-camera-core-imagecapture-TakePictureManager, reason: not valid java name */
    /* synthetic */ void m158xf8164f01() {
        this.mInFlightRequest = null;
        issueNextRequest();
    }

    private void submitCameraRequest(final CameraRequest cameraRequest, final Runnable runnable) {
        Threads.checkMainThread();
        this.mImageCaptureControl.lockFlashMode();
        Futures.addCallback(this.mImageCaptureControl.submitStillCaptureRequests(cameraRequest.getCaptureConfigs()), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.TakePictureManager.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r1) {
                runnable.run();
                TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof ImageCaptureException) {
                    cameraRequest.onCaptureFailure((ImageCaptureException) th);
                } else {
                    cameraRequest.onCaptureFailure(new ImageCaptureException(2, "Failed to submit capture request", th));
                }
                TakePictureManager.this.mImageCaptureControl.unlockFlashMode();
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    boolean hasInFlightRequest() {
        return this.mInFlightRequest != null;
    }

    @Override // androidx.camera.core.ForwardingImageProxy.OnImageCloseListener
    public void onImageClose(ImageProxy imageProxy) {
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.imagecapture.TakePictureManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.issueNextRequest();
            }
        });
    }
}
