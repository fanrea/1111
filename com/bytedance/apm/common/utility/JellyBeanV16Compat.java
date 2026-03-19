package com.bytedance.apm.common.utility;

import android.app.ActivityManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class JellyBeanV16Compat {
    private static BaseImpl mImpl;

    private static class BaseImpl {
        public long getTotalMem(ActivityManager.MemoryInfo memoryInfo) {
            return 0L;
        }

        private BaseImpl() {
        }

        public void setViewBackground(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }
    }

    private static class V16Impl extends BaseImpl {
        private V16Impl() {
            super();
        }

        @Override // com.bytedance.apm.common.utility.JellyBeanV16Compat.BaseImpl
        public void setViewBackground(View view, Drawable drawable) {
            try {
                view.setBackground(drawable);
            } catch (Throwable unused) {
                view.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.bytedance.apm.common.utility.JellyBeanV16Compat.BaseImpl
        public long getTotalMem(ActivityManager.MemoryInfo memoryInfo) {
            return memoryInfo.totalMem;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            mImpl = new V16Impl();
        } else {
            mImpl = new BaseImpl();
        }
    }

    public static void setViewBackground(View view, Drawable drawable) {
        mImpl.setViewBackground(view, drawable);
    }

    public static long getTotalMem(ActivityManager.MemoryInfo memoryInfo) {
        return mImpl.getTotalMem(memoryInfo);
    }
}
