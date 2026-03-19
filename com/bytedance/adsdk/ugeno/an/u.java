package com.bytedance.adsdk.ugeno.an;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import com.bytedance.sdk.component.utils.mq;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static Field d;
    private static boolean hc;

    public static Drawable d(CompoundButton compoundButton) throws NoSuchFieldException {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!hc) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                mq.d("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            hc = true;
        }
        Field field = d;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                mq.d("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                d = null;
            }
        }
        return null;
    }
}
