package com.duoyou.task.sdk.xutils.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.mobstat.forbes.Config;
import com.duoyou.task.sdk.xutils.common.util.DensityUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ImageOptions {
    public static final ImageOptions DEFAULT = new ImageOptions();
    private ParamsBuilder paramsBuilder;
    private int maxWidth = 0;
    private int maxHeight = 0;
    private int width = 0;
    private int height = 0;
    private boolean crop = false;
    private int radius = 0;
    private boolean square = false;
    private boolean circular = false;
    private boolean autoRotate = false;
    private boolean compress = true;
    private Bitmap.Config config = Bitmap.Config.RGB_565;
    private boolean ignoreGif = true;
    private int gifRate = 100;
    private int loadingDrawableId = 0;
    private int failureDrawableId = 0;
    private Drawable loadingDrawable = null;
    private Drawable failureDrawable = null;
    private boolean forceLoadingDrawable = true;
    private ImageView.ScaleType placeholderScaleType = ImageView.ScaleType.CENTER_INSIDE;
    private ImageView.ScaleType imageScaleType = ImageView.ScaleType.CENTER_CROP;
    private boolean fadeIn = false;
    private Animation animation = null;
    private boolean useMemCache = true;

    public interface ParamsBuilder {
        RequestParams buildParams(RequestParams requestParams, ImageOptions imageOptions);
    }

    public final void optimizeMaxSize(ImageView imageView) {
        int i;
        int i2 = this.width;
        if (i2 > 0 && (i = this.height) > 0) {
            this.maxWidth = i2;
            this.maxHeight = i;
            return;
        }
        int screenWidth = DensityUtil.getScreenWidth();
        int screenHeight = DensityUtil.getScreenHeight();
        if (this == DEFAULT) {
            int i3 = (screenWidth * 3) / 2;
            this.width = i3;
            this.maxWidth = i3;
            int i4 = (screenHeight * 3) / 2;
            this.height = i4;
            this.maxHeight = i4;
            return;
        }
        if (this.width < 0) {
            this.maxWidth = (screenWidth * 3) / 2;
            this.compress = false;
        }
        if (this.height < 0) {
            this.maxHeight = (screenHeight * 3) / 2;
            this.compress = false;
        }
        if (imageView == null && this.maxWidth <= 0 && this.maxHeight <= 0) {
            this.maxWidth = screenWidth;
            this.maxHeight = screenHeight;
            return;
        }
        int maxWidth = this.maxWidth;
        int maxHeight = this.maxHeight;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null) {
                if (maxWidth <= 0) {
                    int i5 = layoutParams.width;
                    if (i5 > 0) {
                        maxWidth = layoutParams.width;
                        if (this.width <= 0) {
                            this.width = maxWidth;
                        }
                    } else if (i5 != -2) {
                        maxWidth = imageView.getWidth();
                    }
                }
                if (maxHeight <= 0) {
                    int i6 = layoutParams.height;
                    if (i6 > 0) {
                        maxHeight = layoutParams.height;
                        if (this.height <= 0) {
                            this.height = maxHeight;
                        }
                    } else if (i6 != -2) {
                        maxHeight = imageView.getHeight();
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (maxWidth <= 0) {
                    maxWidth = imageView.getMaxWidth();
                }
                if (maxHeight <= 0) {
                    maxHeight = imageView.getMaxHeight();
                }
            }
        }
        if (maxWidth > 0) {
            screenWidth = maxWidth;
        }
        if (maxHeight > 0) {
            screenHeight = maxHeight;
        }
        this.maxWidth = screenWidth;
        this.maxHeight = screenHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isCrop() {
        return this.crop;
    }

    public int getRadius() {
        return this.radius;
    }

    public boolean isSquare() {
        return this.square;
    }

    public boolean isCircular() {
        return this.circular;
    }

    public boolean isIgnoreGif() {
        return this.ignoreGif;
    }

    public int getGifRate() {
        return this.gifRate;
    }

    public boolean isAutoRotate() {
        return this.autoRotate;
    }

    public boolean isCompress() {
        return this.compress;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public Drawable getLoadingDrawable(ImageView imageView) {
        if (this.loadingDrawable == null && this.loadingDrawableId > 0 && imageView != null) {
            try {
                this.loadingDrawable = imageView.getResources().getDrawable(this.loadingDrawableId);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        return this.loadingDrawable;
    }

    public Drawable getFailureDrawable(ImageView imageView) {
        if (this.failureDrawable == null && this.failureDrawableId > 0 && imageView != null) {
            try {
                this.failureDrawable = imageView.getResources().getDrawable(this.failureDrawableId);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        return this.failureDrawable;
    }

    public boolean isFadeIn() {
        return this.fadeIn;
    }

    public Animation getAnimation() {
        return this.animation;
    }

    public ImageView.ScaleType getPlaceholderScaleType() {
        return this.placeholderScaleType;
    }

    public ImageView.ScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public boolean isForceLoadingDrawable() {
        return this.forceLoadingDrawable;
    }

    public boolean isUseMemCache() {
        return this.useMemCache;
    }

    public ParamsBuilder getParamsBuilder() {
        return this.paramsBuilder;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageOptions imageOptions = (ImageOptions) obj;
        return this.maxWidth == imageOptions.maxWidth && this.maxHeight == imageOptions.maxHeight && this.width == imageOptions.width && this.height == imageOptions.height && this.crop == imageOptions.crop && this.radius == imageOptions.radius && this.square == imageOptions.square && this.circular == imageOptions.circular && this.autoRotate == imageOptions.autoRotate && this.compress == imageOptions.compress && this.config == imageOptions.config;
    }

    public int hashCode() {
        int i = ((((((((((((((((((this.maxWidth * 31) + this.maxHeight) * 31) + this.width) * 31) + this.height) * 31) + (this.crop ? 1 : 0)) * 31) + this.radius) * 31) + (this.square ? 1 : 0)) * 31) + (this.circular ? 1 : 0)) * 31) + (this.autoRotate ? 1 : 0)) * 31) + (this.compress ? 1 : 0)) * 31;
        Bitmap.Config config = this.config;
        return i + (config != null ? config.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Config.replace);
        sb.append(this.maxWidth).append(Config.replace);
        sb.append(this.maxHeight).append(Config.replace);
        sb.append(this.width).append(Config.replace);
        sb.append(this.height).append(Config.replace);
        sb.append(this.radius).append(Config.replace);
        sb.append(this.config).append(Config.replace);
        sb.append(this.crop ? 1 : 0).append(this.square ? 1 : 0).append(this.circular ? 1 : 0);
        sb.append(this.autoRotate ? 1 : 0).append(this.compress ? 1 : 0);
        return sb.toString();
    }

    public static class Builder {
        public ImageOptions options;

        public Builder() {
            newImageOptions();
        }

        public void newImageOptions() {
            this.options = new ImageOptions();
        }

        public ImageOptions build() {
            return this.options;
        }

        public Builder setSize(int i, int i2) {
            this.options.width = i;
            this.options.height = i2;
            return this;
        }

        public Builder setCrop(boolean z) {
            this.options.crop = z;
            return this;
        }

        public Builder setRadius(int i) {
            this.options.radius = i;
            return this;
        }

        public Builder setSquare(boolean z) {
            this.options.square = z;
            return this;
        }

        public Builder setCircular(boolean z) {
            this.options.circular = z;
            return this;
        }

        public Builder setAutoRotate(boolean z) {
            this.options.autoRotate = z;
            return this;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.options.config = config;
            return this;
        }

        public Builder setIgnoreGif(boolean z) {
            this.options.ignoreGif = z;
            return this;
        }

        public Builder setGifRate(int i) {
            this.options.gifRate = i;
            return this;
        }

        public Builder setLoadingDrawableId(int i) {
            this.options.loadingDrawableId = i;
            return this;
        }

        public Builder setLoadingDrawable(Drawable drawable) {
            this.options.loadingDrawable = drawable;
            return this;
        }

        public Builder setFailureDrawableId(int i) {
            this.options.failureDrawableId = i;
            return this;
        }

        public Builder setFailureDrawable(Drawable drawable) {
            this.options.failureDrawable = drawable;
            return this;
        }

        public Builder setFadeIn(boolean z) {
            this.options.fadeIn = z;
            return this;
        }

        public Builder setAnimation(Animation animation) {
            this.options.animation = animation;
            return this;
        }

        public Builder setPlaceholderScaleType(ImageView.ScaleType scaleType) {
            this.options.placeholderScaleType = scaleType;
            return this;
        }

        public Builder setImageScaleType(ImageView.ScaleType scaleType) {
            this.options.imageScaleType = scaleType;
            return this;
        }

        public Builder setForceLoadingDrawable(boolean z) {
            this.options.forceLoadingDrawable = z;
            return this;
        }

        public Builder setUseMemCache(boolean z) {
            this.options.useMemCache = z;
            return this;
        }

        public Builder setParamsBuilder(ParamsBuilder paramsBuilder) {
            this.options.paramsBuilder = paramsBuilder;
            return this;
        }
    }
}
