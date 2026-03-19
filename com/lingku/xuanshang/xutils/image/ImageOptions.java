package com.lingku.xuanshang.xutils.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.mobstat.forbes.Config;
import com.lingku.xuanshang.xutils.common.util.DensityUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ImageOptions {
    public static final ImageOptions DEFAULT = new ImageOptions();
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public boolean e = false;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;
    public boolean j = true;
    public Bitmap.Config k = Bitmap.Config.RGB_565;
    public boolean l = true;
    public int m = 100;
    public int n = 0;
    public int o = 0;
    public Drawable p = null;
    public Drawable q = null;
    public boolean r = true;
    public ImageView.ScaleType s = ImageView.ScaleType.CENTER_INSIDE;
    public ImageView.ScaleType t = ImageView.ScaleType.CENTER_CROP;
    public boolean u = false;
    public Animation v = null;
    public boolean w = true;
    public ParamsBuilder x;

    public static class Builder {
        public ImageOptions options;

        public Builder() {
            newImageOptions();
        }

        public ImageOptions build() {
            return this.options;
        }

        public void newImageOptions() {
            this.options = new ImageOptions();
        }

        public Builder setAnimation(Animation animation) {
            this.options.v = animation;
            return this;
        }

        public Builder setAutoRotate(boolean z) {
            this.options.i = z;
            return this;
        }

        public Builder setCircular(boolean z) {
            this.options.h = z;
            return this;
        }

        public Builder setConfig(Bitmap.Config config) {
            this.options.k = config;
            return this;
        }

        public Builder setCrop(boolean z) {
            this.options.e = z;
            return this;
        }

        public Builder setFadeIn(boolean z) {
            this.options.u = z;
            return this;
        }

        public Builder setFailureDrawable(Drawable drawable) {
            this.options.q = drawable;
            return this;
        }

        public Builder setFailureDrawableId(int i) {
            this.options.o = i;
            return this;
        }

        public Builder setForceLoadingDrawable(boolean z) {
            this.options.r = z;
            return this;
        }

        public Builder setGifRate(int i) {
            this.options.m = i;
            return this;
        }

        public Builder setIgnoreGif(boolean z) {
            this.options.l = z;
            return this;
        }

        public Builder setImageScaleType(ImageView.ScaleType scaleType) {
            this.options.t = scaleType;
            return this;
        }

        public Builder setLoadingDrawable(Drawable drawable) {
            this.options.p = drawable;
            return this;
        }

        public Builder setLoadingDrawableId(int i) {
            this.options.n = i;
            return this;
        }

        public Builder setParamsBuilder(ParamsBuilder paramsBuilder) {
            this.options.x = paramsBuilder;
            return this;
        }

        public Builder setPlaceholderScaleType(ImageView.ScaleType scaleType) {
            this.options.s = scaleType;
            return this;
        }

        public Builder setRadius(int i) {
            this.options.f = i;
            return this;
        }

        public Builder setSize(int i, int i2) {
            ImageOptions imageOptions = this.options;
            imageOptions.c = i;
            imageOptions.d = i2;
            return this;
        }

        public Builder setSquare(boolean z) {
            this.options.g = z;
            return this;
        }

        public Builder setUseMemCache(boolean z) {
            this.options.w = z;
            return this;
        }
    }

    public interface ParamsBuilder {
        RequestParams buildParams(RequestParams requestParams, ImageOptions imageOptions);
    }

    public final void a(ImageView imageView) {
        int i;
        int i2 = this.c;
        if (i2 <= 0 || (i = this.d) <= 0) {
            int screenWidth = DensityUtil.getScreenWidth();
            int screenHeight = DensityUtil.getScreenHeight();
            if (this != DEFAULT) {
                if (this.c < 0) {
                    this.a = (screenWidth * 3) / 2;
                    this.j = false;
                }
                if (this.d < 0) {
                    this.b = (screenHeight * 3) / 2;
                    this.j = false;
                }
                if (imageView != null || this.a > 0 || this.b > 0) {
                    int maxWidth = this.a;
                    int maxHeight = this.b;
                    if (imageView != null) {
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        if (layoutParams != null) {
                            if (maxWidth <= 0) {
                                int i3 = layoutParams.width;
                                if (i3 > 0) {
                                    if (this.c <= 0) {
                                        this.c = i3;
                                    }
                                    maxWidth = i3;
                                } else if (i3 != -2) {
                                    maxWidth = imageView.getWidth();
                                }
                            }
                            if (maxHeight <= 0) {
                                int i4 = layoutParams.height;
                                if (i4 > 0) {
                                    if (this.d <= 0) {
                                        this.d = i4;
                                    }
                                    maxHeight = i4;
                                } else if (i4 != -2) {
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
                }
                this.a = screenWidth;
                this.b = screenHeight;
                return;
            }
            int i5 = (screenWidth * 3) / 2;
            this.c = i5;
            this.a = i5;
            i = (screenHeight * 3) / 2;
            this.d = i;
        } else {
            this.a = i2;
        }
        this.b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageOptions imageOptions = (ImageOptions) obj;
        return this.a == imageOptions.a && this.b == imageOptions.b && this.c == imageOptions.c && this.d == imageOptions.d && this.e == imageOptions.e && this.f == imageOptions.f && this.g == imageOptions.g && this.h == imageOptions.h && this.i == imageOptions.i && this.j == imageOptions.j && this.k == imageOptions.k;
    }

    public Animation getAnimation() {
        return this.v;
    }

    public Bitmap.Config getConfig() {
        return this.k;
    }

    public Drawable getFailureDrawable(ImageView imageView) {
        if (this.q == null && this.o > 0 && imageView != null) {
            try {
                this.q = imageView.getResources().getDrawable(this.o);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        return this.q;
    }

    public int getGifRate() {
        return this.m;
    }

    public int getHeight() {
        return this.d;
    }

    public ImageView.ScaleType getImageScaleType() {
        return this.t;
    }

    public Drawable getLoadingDrawable(ImageView imageView) {
        if (this.p == null && this.n > 0 && imageView != null) {
            try {
                this.p = imageView.getResources().getDrawable(this.n);
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        return this.p;
    }

    public int getMaxHeight() {
        return this.b;
    }

    public int getMaxWidth() {
        return this.a;
    }

    public ParamsBuilder getParamsBuilder() {
        return this.x;
    }

    public ImageView.ScaleType getPlaceholderScaleType() {
        return this.s;
    }

    public int getRadius() {
        return this.f;
    }

    public int getWidth() {
        return this.c;
    }

    public int hashCode() {
        int i = ((((((((((((((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + (this.e ? 1 : 0)) * 31) + this.f) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31;
        Bitmap.Config config = this.k;
        return i + (config != null ? config.hashCode() : 0);
    }

    public boolean isAutoRotate() {
        return this.i;
    }

    public boolean isCircular() {
        return this.h;
    }

    public boolean isCompress() {
        return this.j;
    }

    public boolean isCrop() {
        return this.e;
    }

    public boolean isFadeIn() {
        return this.u;
    }

    public boolean isForceLoadingDrawable() {
        return this.r;
    }

    public boolean isIgnoreGif() {
        return this.l;
    }

    public boolean isSquare() {
        return this.g;
    }

    public boolean isUseMemCache() {
        return this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Config.replace);
        sb.append(this.a).append(Config.replace);
        sb.append(this.b).append(Config.replace);
        sb.append(this.c).append(Config.replace);
        sb.append(this.d).append(Config.replace);
        sb.append(this.f).append(Config.replace);
        sb.append(this.k).append(Config.replace);
        sb.append(this.e ? 1 : 0).append(this.g ? 1 : 0).append(this.h ? 1 : 0);
        sb.append(this.i ? 1 : 0).append(this.j ? 1 : 0);
        return sb.toString();
    }
}
