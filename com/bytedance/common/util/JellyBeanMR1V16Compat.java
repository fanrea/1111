package com.bytedance.common.util;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class JellyBeanMR1V16Compat {
    private static BaseImpl mImpl;

    private static class BaseImpl {
        private BaseImpl() {
        }

        public void setBackground(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }
    }

    private static class V16Impl extends BaseImpl {
        private V16Impl() {
            super();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V16Compat.BaseImpl
        public void setBackground(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    public static void setBackgroundForView(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        if (mImpl == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                mImpl = new V16Impl();
            } else {
                mImpl = new BaseImpl();
            }
        }
        mImpl.setBackground(view, drawable);
    }
}
