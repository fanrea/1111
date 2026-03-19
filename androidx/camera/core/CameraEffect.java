package androidx.camera.core;

import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;
    public static final int PREVIEW = 1;
    public static final int VIDEO_CAPTURE = 2;
    private final ImageProcessor mImageProcessor;
    private final Executor mProcessorExecutor;
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Targets {
    }

    protected CameraEffect(int i, Executor executor, ImageProcessor imageProcessor) {
        this.mTargets = i;
        this.mProcessorExecutor = executor;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = imageProcessor;
    }

    protected CameraEffect(int i, Executor executor, SurfaceProcessor surfaceProcessor) {
        this.mTargets = i;
        this.mProcessorExecutor = executor;
        this.mSurfaceProcessor = surfaceProcessor;
        this.mImageProcessor = null;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public Executor getProcessorExecutor() {
        return this.mProcessorExecutor;
    }

    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    public static class Builder {
        private ImageProcessor mImageProcessor;
        private Executor mProcessorExecutor;
        private SurfaceProcessor mSurfaceProcessor;
        private final int mTargets;

        public Builder(int i) {
            this.mTargets = i;
        }

        public Builder setSurfaceProcessor(Executor executor, SurfaceProcessor surfaceProcessor) {
            this.mProcessorExecutor = executor;
            this.mSurfaceProcessor = surfaceProcessor;
            return this;
        }

        public Builder setImageProcessor(Executor executor, ImageProcessor imageProcessor) {
            this.mProcessorExecutor = executor;
            this.mImageProcessor = imageProcessor;
            return this;
        }

        public CameraEffect build() {
            Preconditions.checkState(this.mProcessorExecutor != null, "Must have a executor");
            Preconditions.checkState((this.mImageProcessor != null) ^ (this.mSurfaceProcessor != null), "Must have one and only one processor");
            if (this.mSurfaceProcessor != null) {
                return new CameraEffect(this.mTargets, this.mProcessorExecutor, this.mSurfaceProcessor);
            }
            return new CameraEffect(this.mTargets, this.mProcessorExecutor, this.mImageProcessor);
        }
    }
}
