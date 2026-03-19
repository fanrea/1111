package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SettableSurface extends DeferrableSurface {
    CallbackToFutureAdapter.Completer<Surface> mCompleter;
    private SurfaceOutputImpl mConsumerToNotify;
    private final Rect mCropRect;
    private boolean mHasConsumer;
    private final boolean mHasEmbeddedTransform;
    private boolean mHasProvider;
    private final boolean mMirroring;
    private SurfaceRequest mProviderSurfaceRequest;
    private int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private final ListenableFuture<Surface> mSurfaceFuture;
    private final int mTargets;

    public SettableSurface(int i, final Size size, int i2, Matrix matrix, boolean z, Rect rect, int i3, boolean z2) {
        super(size, i2);
        this.mHasProvider = false;
        this.mHasConsumer = false;
        this.mTargets = i;
        this.mSensorToBufferTransform = matrix;
        this.mHasEmbeddedTransform = z;
        this.mCropRect = rect;
        this.mRotationDegrees = i3;
        this.mMirroring = z2;
        this.mSurfaceFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.SettableSurface$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m184lambda$new$0$androidxcameracoreprocessingSettableSurface(size, completer);
            }
        });
    }

    /* renamed from: lambda$new$0$androidx-camera-core-processing-SettableSurface, reason: not valid java name */
    /* synthetic */ Object m184lambda$new$0$androidxcameracoreprocessingSettableSurface(Size size, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCompleter = completer;
        return "SettableFuture size: " + size + " hashCode: " + hashCode();
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    protected ListenableFuture<Surface> provideSurface() {
        return this.mSurfaceFuture;
    }

    public void setProvider(ListenableFuture<Surface> listenableFuture) {
        Threads.checkMainThread();
        Preconditions.checkState(!this.mHasProvider, "Provider can only be linked once.");
        this.mHasProvider = true;
        Futures.propagate(listenableFuture, this.mCompleter);
    }

    public void setProvider(final DeferrableSurface deferrableSurface) throws DeferrableSurface.SurfaceClosedException {
        Threads.checkMainThread();
        setProvider(deferrableSurface.getSurface());
        deferrableSurface.incrementUseCount();
        getTerminationFuture().addListener(new Runnable() { // from class: androidx.camera.core.processing.SettableSurface$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                SettableSurface.lambda$setProvider$1(deferrableSurface);
            }
        }, CameraXExecutors.directExecutor());
    }

    static /* synthetic */ void lambda$setProvider$1(DeferrableSurface deferrableSurface) {
        deferrableSurface.decrementUseCount();
        deferrableSurface.close();
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal cameraInternal) {
        return createSurfaceRequest(cameraInternal, null);
    }

    public SurfaceRequest createSurfaceRequest(CameraInternal cameraInternal, Range<Integer> range) {
        Threads.checkMainThread();
        SurfaceRequest surfaceRequest = new SurfaceRequest(getSize(), cameraInternal, true, range);
        try {
            setProvider(surfaceRequest.getDeferrableSurface());
            this.mProviderSurfaceRequest = surfaceRequest;
            notifyTransformationInfoUpdate();
            return surfaceRequest;
        } catch (DeferrableSurface.SurfaceClosedException e) {
            throw new AssertionError("Surface is somehow already closed", e);
        }
    }

    public ListenableFuture<SurfaceOutput> createSurfaceOutputFuture(final SurfaceOutput.GlTransformOptions glTransformOptions, final Size size, final Rect rect, final int i, final boolean z) {
        Threads.checkMainThread();
        Preconditions.checkState(!this.mHasConsumer, "Consumer can only be linked once.");
        this.mHasConsumer = true;
        return Futures.transformAsync(getSurface(), new AsyncFunction() { // from class: androidx.camera.core.processing.SettableSurface$$ExternalSyntheticLambda4
            @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$0.m183x3866da53(glTransformOptions, size, rect, i, z, (Surface) obj);
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* renamed from: lambda$createSurfaceOutputFuture$2$androidx-camera-core-processing-SettableSurface, reason: not valid java name */
    /* synthetic */ ListenableFuture m183x3866da53(SurfaceOutput.GlTransformOptions glTransformOptions, Size size, Rect rect, int i, boolean z, Surface surface) throws Exception {
        Preconditions.checkNotNull(surface);
        try {
            incrementUseCount();
            SurfaceOutputImpl surfaceOutputImpl = new SurfaceOutputImpl(surface, getTargets(), getFormat(), getSize(), glTransformOptions, size, rect, i, z);
            surfaceOutputImpl.getCloseFuture().addListener(new Runnable() { // from class: androidx.camera.core.processing.SettableSurface$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.decrementUseCount();
                }
            }, CameraXExecutors.directExecutor());
            this.mConsumerToNotify = surfaceOutputImpl;
            return Futures.immediateFuture(surfaceOutputImpl);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            return Futures.immediateFailedFuture(e);
        }
    }

    @Override // androidx.camera.core.impl.DeferrableSurface
    public final void close() {
        super.close();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.processing.SettableSurface$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m182lambda$close$3$androidxcameracoreprocessingSettableSurface();
            }
        });
    }

    /* renamed from: lambda$close$3$androidx-camera-core-processing-SettableSurface, reason: not valid java name */
    /* synthetic */ void m182lambda$close$3$androidxcameracoreprocessingSettableSurface() {
        SurfaceOutputImpl surfaceOutputImpl = this.mConsumerToNotify;
        if (surfaceOutputImpl != null) {
            surfaceOutputImpl.requestClose();
            this.mConsumerToNotify = null;
        }
    }

    public int getTargets() {
        return this.mTargets;
    }

    public Size getSize() {
        return getPrescribedSize();
    }

    public int getFormat() {
        return getPrescribedStreamFormat();
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public boolean hasEmbeddedTransform() {
        return this.mHasEmbeddedTransform;
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public void setRotationDegrees(int i) {
        Threads.checkMainThread();
        if (this.mRotationDegrees == i) {
            return;
        }
        this.mRotationDegrees = i;
        notifyTransformationInfoUpdate();
    }

    private void notifyTransformationInfoUpdate() {
        SurfaceRequest surfaceRequest = this.mProviderSurfaceRequest;
        if (surfaceRequest != null) {
            surfaceRequest.updateTransformationInfo(SurfaceRequest.TransformationInfo.of(this.mCropRect, this.mRotationDegrees, -1));
        }
    }

    public boolean getMirroring() {
        return this.mMirroring;
    }
}
