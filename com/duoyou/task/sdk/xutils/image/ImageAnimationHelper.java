package com.duoyou.task.sdk.xutils.image;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class ImageAnimationHelper {
    private static final Method cloneMethod;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Animation.class.getDeclaredMethod("clone", new Class[0]);
            declaredMethod.setAccessible(true);
        } catch (Throwable th) {
            LogUtil.w(th.getMessage(), th);
            declaredMethod = null;
        }
        cloneMethod = declaredMethod;
    }

    private ImageAnimationHelper() {
    }

    public static void fadeInDisplay(ImageView imageView, Drawable drawable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        imageView.setImageDrawable(drawable);
        imageView.startAnimation(alphaAnimation);
    }

    public static void animationDisplay(ImageView imageView, Drawable drawable, Animation animation) {
        imageView.setImageDrawable(drawable);
        Method method = cloneMethod;
        if (method != null && animation != null) {
            try {
                imageView.startAnimation((Animation) method.invoke(animation, new Object[0]));
                return;
            } catch (Throwable unused) {
                imageView.startAnimation(animation);
                return;
            }
        }
        imageView.startAnimation(animation);
    }
}
