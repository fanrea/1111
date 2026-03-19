package com.lingku.xuanshang.xutils.image;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ImageAnimationHelper {
    public static final Method a;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Animation.class.getDeclaredMethod("clone", new Class[0]);
            declaredMethod.setAccessible(true);
        } catch (Throwable th) {
            LogUtil.w(th.getMessage(), th);
            declaredMethod = null;
        }
        a = declaredMethod;
    }

    public static void animationDisplay(ImageView imageView, Drawable drawable, Animation animation) {
        imageView.setImageDrawable(drawable);
        Method method = a;
        if (method != null && animation != null) {
            try {
                imageView.startAnimation((Animation) method.invoke(animation, new Object[0]));
                return;
            } catch (Throwable unused) {
            }
        }
        imageView.startAnimation(animation);
    }

    public static void fadeInDisplay(ImageView imageView, Drawable drawable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        imageView.setImageDrawable(drawable);
        imageView.startAnimation(alphaAnimation);
    }
}
