package androidx.camera.core.internal;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifOutputStream;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YuvToJpegProcessor implements CaptureProcessor {
    private static final String TAG = "YuvToJpegProcessor";
    private static final Rect UNINITIALIZED_RECT = new Rect(0, 0, 0, 0);
    CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private ListenableFuture<Void> mCloseFuture;
    private ImageWriter mImageWriter;
    private final int mMaxImages;
    private int mQuality;
    private final Object mLock = new Object();
    private int mRotationDegrees = 0;
    private boolean mClosed = false;
    private int mProcessingImages = 0;
    private Rect mImageRect = UNINITIALIZED_RECT;

    public YuvToJpegProcessor(int i, int i2) {
        this.mQuality = i;
        this.mMaxImages = i2;
    }

    public void setJpegQuality(int i) {
        synchronized (this.mLock) {
            this.mQuality = i;
        }
    }

    public void setRotationDegrees(int i) {
        synchronized (this.mLock) {
            this.mRotationDegrees = i;
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onOutputSurface(Surface surface, int i) {
        Preconditions.checkState(i == 256, "YuvToJpegProcessor only supports JPEG output format.");
        synchronized (this.mLock) {
            if (!this.mClosed) {
                if (this.mImageWriter != null) {
                    throw new IllegalStateException("Output surface already set.");
                }
                this.mImageWriter = ImageWriterCompat.newInstance(surface, this.mMaxImages, i);
            } else {
                Logger.w(TAG, "Cannot set output surface. Processor is closed.");
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void process(ImageProxyBundle imageProxyBundle) throws Throwable {
        ImageWriter imageWriter;
        boolean z;
        Rect rect;
        int i;
        int i2;
        ImageProxy imageProxy;
        Image imageDequeueInputImage;
        CallbackToFutureAdapter.Completer<Void> completer;
        CallbackToFutureAdapter.Completer<Void> completer2;
        ByteBuffer buffer;
        int iPosition;
        CallbackToFutureAdapter.Completer<Void> completer3;
        List<Integer> captureIds = imageProxyBundle.getCaptureIds();
        boolean z2 = false;
        Preconditions.checkArgument(captureIds.size() == 1, "Processing image bundle have single capture id, but found " + captureIds.size());
        ListenableFuture<ImageProxy> imageProxy2 = imageProxyBundle.getImageProxy(captureIds.get(0).intValue());
        Preconditions.checkArgument(imageProxy2.isDone());
        synchronized (this.mLock) {
            imageWriter = this.mImageWriter;
            z = !this.mClosed;
            rect = this.mImageRect;
            if (z) {
                this.mProcessingImages++;
            }
            i = this.mQuality;
            i2 = this.mRotationDegrees;
        }
        try {
            try {
                imageProxy = imageProxy2.get();
                try {
                } catch (Exception e) {
                    e = e;
                    imageDequeueInputImage = null;
                } catch (Throwable th) {
                    th = th;
                    imageDequeueInputImage = null;
                }
            } catch (Exception e2) {
                e = e2;
                imageProxy = null;
                imageDequeueInputImage = null;
            } catch (Throwable th2) {
                th = th2;
                imageProxy = null;
                imageDequeueInputImage = null;
            }
            if (!z) {
                Logger.w(TAG, "Image enqueued for processing on closed processor.");
                imageProxy.close();
                synchronized (this.mLock) {
                    if (z) {
                        try {
                            int i3 = this.mProcessingImages;
                            this.mProcessingImages = i3 - 1;
                            if (i3 == 0 && this.mClosed) {
                                z2 = true;
                            }
                        } finally {
                        }
                    }
                    completer3 = this.mCloseCompleter;
                }
                if (z2) {
                    imageWriter.close();
                    Logger.d(TAG, "Closed after completion of last image processed.");
                    if (completer3 != null) {
                        completer3.set(null);
                        return;
                    }
                    return;
                }
                return;
            }
            imageDequeueInputImage = imageWriter.dequeueInputImage();
            try {
                ImageProxy imageProxy3 = imageProxy2.get();
                try {
                    Preconditions.checkState(imageProxy3.getFormat() == 35, "Input image is not expected YUV_420_888 image format");
                    YuvImage yuvImage = new YuvImage(ImageUtil.yuv_420_888toNv21(imageProxy3), 17, imageProxy3.getWidth(), imageProxy3.getHeight(), null);
                    buffer = imageDequeueInputImage.getPlanes()[0].getBuffer();
                    iPosition = buffer.position();
                    yuvImage.compressToJpeg(rect, i, new ExifOutputStream(new ByteBufferOutputStream(buffer), ExifData.create(imageProxy3, i2)));
                    imageProxy3.close();
                } catch (Exception e3) {
                    e = e3;
                    imageProxy = imageProxy3;
                } catch (Throwable th3) {
                    th = th3;
                    imageProxy = imageProxy3;
                }
                try {
                    buffer.limit(buffer.position());
                    buffer.position(iPosition);
                    imageWriter.queueInputImage(imageDequeueInputImage);
                    synchronized (this.mLock) {
                        if (z) {
                            try {
                                int i4 = this.mProcessingImages;
                                this.mProcessingImages = i4 - 1;
                                if (i4 == 0 && this.mClosed) {
                                    z2 = true;
                                }
                            } finally {
                            }
                        }
                        completer2 = this.mCloseCompleter;
                    }
                } catch (Exception e4) {
                    e = e4;
                    imageProxy = null;
                    if (z) {
                        Logger.e(TAG, "Failed to process YUV -> JPEG", e);
                        imageDequeueInputImage = imageWriter.dequeueInputImage();
                        ByteBuffer buffer2 = imageDequeueInputImage.getPlanes()[0].getBuffer();
                        buffer2.rewind();
                        buffer2.limit(0);
                        imageWriter.queueInputImage(imageDequeueInputImage);
                    }
                    synchronized (this.mLock) {
                        if (z) {
                            try {
                                int i5 = this.mProcessingImages;
                                this.mProcessingImages = i5 - 1;
                                if (i5 == 0 && this.mClosed) {
                                    z2 = true;
                                }
                            } finally {
                            }
                        }
                        completer2 = this.mCloseCompleter;
                    }
                    if (imageDequeueInputImage != null) {
                        imageDequeueInputImage.close();
                    }
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    if (z2) {
                        imageWriter.close();
                        Logger.d(TAG, "Closed after completion of last image processed.");
                        if (completer2 == null) {
                            return;
                        }
                        completer2.set(null);
                    }
                    return;
                } catch (Throwable th4) {
                    th = th4;
                    imageProxy = null;
                    synchronized (this.mLock) {
                        if (z) {
                            try {
                                int i6 = this.mProcessingImages;
                                this.mProcessingImages = i6 - 1;
                                if (i6 == 0 && this.mClosed) {
                                    z2 = true;
                                }
                            } finally {
                            }
                        }
                        completer = this.mCloseCompleter;
                    }
                    if (imageDequeueInputImage != null) {
                        imageDequeueInputImage.close();
                    }
                    if (imageProxy != null) {
                        imageProxy.close();
                    }
                    if (z2) {
                        imageWriter.close();
                        Logger.d(TAG, "Closed after completion of last image processed.");
                        if (completer != null) {
                            completer.set(null);
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            if (z2) {
                imageWriter.close();
                Logger.d(TAG, "Closed after completion of last image processed.");
                if (completer2 == null) {
                    return;
                }
                completer2.set(null);
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void close() {
        CallbackToFutureAdapter.Completer<Void> completer;
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            this.mClosed = true;
            if (this.mProcessingImages == 0 && this.mImageWriter != null) {
                Logger.d(TAG, "No processing in progress. Closing immediately.");
                this.mImageWriter.close();
                completer = this.mCloseCompleter;
            } else {
                Logger.d(TAG, "close() called while processing. Will close after completion.");
                completer = null;
            }
            if (completer != null) {
                completer.set(null);
            }
        }
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public ListenableFuture<Void> getCloseFuture() {
        ListenableFuture<Void> listenableFutureNonCancellationPropagating;
        synchronized (this.mLock) {
            if (this.mClosed && this.mProcessingImages == 0) {
                listenableFutureNonCancellationPropagating = Futures.immediateFuture(null);
            } else {
                if (this.mCloseFuture == null) {
                    this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.internal.YuvToJpegProcessor$$ExternalSyntheticLambda0
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                        public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                            return this.f$0.m172x89b5c91(completer);
                        }
                    });
                }
                listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(this.mCloseFuture);
            }
        }
        return listenableFutureNonCancellationPropagating;
    }

    /* renamed from: lambda$getCloseFuture$0$androidx-camera-core-internal-YuvToJpegProcessor, reason: not valid java name */
    /* synthetic */ Object m172x89b5c91(CallbackToFutureAdapter.Completer completer) throws Exception {
        synchronized (this.mLock) {
            this.mCloseCompleter = completer;
        }
        return "YuvToJpegProcessor-close";
    }

    @Override // androidx.camera.core.impl.CaptureProcessor
    public void onResolutionUpdate(Size size) {
        synchronized (this.mLock) {
            this.mImageRect = new Rect(0, 0, size.getWidth(), size.getHeight());
        }
    }
}
