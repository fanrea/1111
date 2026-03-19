package androidx.camera.core.processing;

import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class SurfaceOutputImpl implements SurfaceOutput {
    private static final String TAG = "SurfaceOutputImpl";
    private final ListenableFuture<Void> mCloseFuture;
    private CallbackToFutureAdapter.Completer<Void> mCloseFutureCompleter;
    private Consumer<SurfaceOutput.Event> mEventListener;
    private Executor mExecutor;
    private final int mFormat;
    private final SurfaceOutput.GlTransformOptions mGlTransformOptions;
    private final Rect mInputCropRect;
    private final Size mInputSize;
    private final boolean mMirroring;
    private final int mRotationDegrees;
    private final Size mSize;
    private final Surface mSurface;
    private final int mTargets;
    private final Object mLock = new Object();
    private final float[] mGlTransform = new float[16];
    private boolean mHasPendingCloseRequest = false;
    private boolean mIsClosed = false;

    SurfaceOutputImpl(Surface surface, int i, int i2, Size size, SurfaceOutput.GlTransformOptions glTransformOptions, Size size2, Rect rect, int i3, boolean z) {
        this.mSurface = surface;
        this.mTargets = i;
        this.mFormat = i2;
        this.mSize = size;
        this.mGlTransformOptions = glTransformOptions;
        this.mInputSize = size2;
        this.mInputCropRect = new Rect(rect);
        this.mMirroring = z;
        if (glTransformOptions == SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING) {
            this.mRotationDegrees = i3;
            calculateGlTransform();
        } else {
            this.mRotationDegrees = 0;
        }
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.SurfaceOutputImpl$$ExternalSyntheticLambda0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f$0.m185lambda$new$0$androidxcameracoreprocessingSurfaceOutputImpl(completer);
            }
        });
    }

    /* renamed from: lambda$new$0$androidx-camera-core-processing-SurfaceOutputImpl, reason: not valid java name */
    /* synthetic */ Object m185lambda$new$0$androidxcameracoreprocessingSurfaceOutputImpl(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCloseFutureCompleter = completer;
        return "SurfaceOutputImpl close future complete";
    }

    @Override // androidx.camera.core.SurfaceOutput
    public Surface getSurface(Executor executor, Consumer<SurfaceOutput.Event> consumer) {
        boolean z;
        synchronized (this.mLock) {
            this.mExecutor = executor;
            this.mEventListener = consumer;
            z = this.mHasPendingCloseRequest;
        }
        if (z) {
            requestClose();
        }
        return this.mSurface;
    }

    public void requestClose() {
        Executor executor;
        Consumer<SurfaceOutput.Event> consumer;
        final AtomicReference atomicReference = new AtomicReference();
        synchronized (this.mLock) {
            if (this.mExecutor == null || (consumer = this.mEventListener) == null) {
                this.mHasPendingCloseRequest = true;
            } else if (!this.mIsClosed) {
                atomicReference.set(consumer);
                executor = this.mExecutor;
                this.mHasPendingCloseRequest = false;
            }
            executor = null;
        }
        if (executor != null) {
            try {
                executor.execute(new Runnable() { // from class: androidx.camera.core.processing.SurfaceOutputImpl$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m186x4fbd8e2d(atomicReference);
                    }
                });
            } catch (RejectedExecutionException e) {
                Logger.d(TAG, "Processor executor closed. Close request not posted.", e);
            }
        }
    }

    /* renamed from: lambda$requestClose$1$androidx-camera-core-processing-SurfaceOutputImpl, reason: not valid java name */
    /* synthetic */ void m186x4fbd8e2d(AtomicReference atomicReference) {
        ((Consumer) atomicReference.get()).accept(SurfaceOutput.Event.of(0, this));
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getTargets() {
        return this.mTargets;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public Size getSize() {
        return this.mSize;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getFormat() {
        return this.mFormat;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public void close() {
        synchronized (this.mLock) {
            if (!this.mIsClosed) {
                this.mIsClosed = true;
            }
        }
        this.mCloseFutureCompleter.set(null);
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mIsClosed;
        }
        return z;
    }

    public ListenableFuture<Void> getCloseFuture() {
        return this.mCloseFuture;
    }

    /* renamed from: androidx.camera.core.processing.SurfaceOutputImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions;

        static {
            int[] iArr = new int[SurfaceOutput.GlTransformOptions.values().length];
            $SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions = iArr;
            try {
                iArr[SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions[SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // androidx.camera.core.SurfaceOutput
    public void updateTransformMatrix(float[] fArr, float[] fArr2) {
        int i = AnonymousClass1.$SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions[this.mGlTransformOptions.ordinal()];
        if (i == 1) {
            System.arraycopy(fArr2, 0, fArr, 0, 16);
        } else {
            if (i == 2) {
                System.arraycopy(this.mGlTransform, 0, fArr, 0, 16);
                return;
            }
            throw new AssertionError("Unknown GlTransformOptions: " + this.mGlTransformOptions);
        }
    }

    private void calculateGlTransform() {
        Matrix.setIdentityM(this.mGlTransform, 0);
        Matrix.translateM(this.mGlTransform, 0, 0.0f, 1.0f, 0.0f);
        Matrix.scaleM(this.mGlTransform, 0, 1.0f, -1.0f, 1.0f);
        MatrixExt.preRotate(this.mGlTransform, this.mRotationDegrees, 0.5f, 0.5f);
        if (this.mMirroring) {
            Matrix.translateM(this.mGlTransform, 0, 1.0f, 0.0f, 0.0f);
            Matrix.scaleM(this.mGlTransform, 0, -1.0f, 1.0f, 1.0f);
        }
        android.graphics.Matrix rectToRect = TransformUtils.getRectToRect(TransformUtils.sizeToRectF(this.mInputSize), TransformUtils.sizeToRectF(TransformUtils.rotateSize(this.mInputSize, this.mRotationDegrees)), this.mRotationDegrees, this.mMirroring);
        RectF rectF = new RectF(this.mInputCropRect);
        rectToRect.mapRect(rectF);
        float width = rectF.left / r0.getWidth();
        float height = ((r0.getHeight() - rectF.height()) - rectF.top) / r0.getHeight();
        float fWidth = rectF.width() / r0.getWidth();
        float fHeight = rectF.height() / r0.getHeight();
        Matrix.translateM(this.mGlTransform, 0, width, height, 0.0f);
        Matrix.scaleM(this.mGlTransform, 0, fWidth, fHeight, 1.0f);
    }
}
