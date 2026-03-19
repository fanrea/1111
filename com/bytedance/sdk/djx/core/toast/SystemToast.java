package com.bytedance.sdk.djx.core.toast;

import android.R;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class SystemToast implements IToast, Cloneable {
    private static Object iNotificationManagerProxy;
    private View contentView;
    private Context mContext;
    private Toast mToast;
    private int priority;
    private int xOffset;
    private int yOffset;
    private int animation = R.style.Animation.Toast;
    private int gravity = 81;
    private int duration = 2000;

    SystemToast(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void show() {
        assertContentViewNotNull();
        SystemTN.instance().add(this);
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void showLong() {
        setDuration(3500).show();
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void cancel() {
        SystemTN.instance().cancelAll();
    }

    public static void cancelAll() {
        SystemTN.instance().cancelAll();
    }

    void showInternal() {
        if (this.mContext == null || this.contentView == null) {
            return;
        }
        Toast toast = new Toast(this.mContext);
        this.mToast = toast;
        toast.setView(this.contentView);
        this.mToast.setGravity(this.gravity, this.xOffset, this.yOffset);
        if (this.duration == 3500) {
            this.mToast.setDuration(1);
        } else {
            this.mToast.setDuration(0);
        }
        hookHandler(this.mToast);
        hookINotificationManager(this.mToast, this.mContext);
        setupToastAnim(this.mToast, this.animation);
        this.mToast.show();
    }

    void cancelInternal() {
        Toast toast = this.mToast;
        if (toast != null) {
            toast.cancel();
            this.mToast = null;
        }
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public SystemToast setView(View view) {
        if (view == null) {
            return this;
        }
        this.contentView = view;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public View getView() {
        return assertContentViewNotNull();
    }

    private View assertContentViewNotNull() {
        if (this.contentView == null) {
            this.contentView = View.inflate(this.mContext, com.pangle.cn.pangrowth.base.R.layout.djx_view_toast, null);
        }
        return this.contentView;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public SystemToast setDuration(int i) {
        this.duration = i;
        return this;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public SystemToast setAnimation(int i) {
        this.animation = i;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public SystemToast setGravity(int i, int i2, int i3) {
        this.gravity = i;
        this.xOffset = i2;
        this.yOffset = i3;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public SystemToast setGravity(int i) {
        setGravity(i, 0, 0);
        return this;
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getXOffset() {
        return this.xOffset;
    }

    public int getYOffset() {
        return this.yOffset;
    }

    public int getPriority() {
        return this.priority;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public SystemToast setPriority(int i) {
        this.priority = i;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setText(int i, String str) {
        TextView textView = (TextView) assertContentViewNotNull().findViewById(i);
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setText(int i, String str, float f) {
        TextView textView = (TextView) assertContentViewNotNull().findViewById(i);
        if (textView != null) {
            textView.setText(str);
            textView.setTextSize(0, f);
        }
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SystemToast m363clone() {
        SystemToast systemToast;
        CloneNotSupportedException e;
        try {
            systemToast = (SystemToast) super.clone();
            try {
                systemToast.mContext = this.mContext;
                systemToast.contentView = this.contentView;
                systemToast.duration = this.duration;
                systemToast.animation = this.animation;
                systemToast.gravity = this.gravity;
                systemToast.xOffset = this.xOffset;
                systemToast.yOffset = this.yOffset;
                systemToast.priority = this.priority;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return systemToast;
            }
        } catch (CloneNotSupportedException e3) {
            systemToast = null;
            e = e3;
        }
        return systemToast;
    }

    private static void hookHandler(Toast toast) {
        if (toast == null || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            Object obj = declaredField.get(toast);
            declaredField2.set(obj, new SafelyHandlerWrapper((Handler) declaredField2.get(obj)));
        } catch (Throwable unused) {
        }
    }

    private static void setupToastAnim(Toast toast, int i) {
        try {
            Object field = getField(toast, "mTN");
            if (field != null) {
                Object field2 = getField(field, "mParams");
                if (field2 instanceof WindowManager.LayoutParams) {
                    ((WindowManager.LayoutParams) field2).windowAnimations = i;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static Object getField(Object obj, String str) throws Exception {
        Field declaredField = obj.getClass().getDeclaredField(str);
        if (declaredField == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    private static void hookINotificationManager(Toast toast, Context context) {
        if (toast == null || NotificationManagerCompat.from(context).areNotificationsEnabled() || ToastWhite.isWhiteList() || !isValid4HookINotificationManager() || iNotificationManagerProxy != null) {
            return;
        }
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            final Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            iNotificationManagerProxy = Proxy.newProxyInstance(toast.getClass().getClassLoader(), new Class[]{Class.forName("android.app.INotificationManager")}, new InvocationHandler() { // from class: com.bytedance.sdk.djx.core.toast.SystemToast.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    if ("enqueueToast".equals(method.getName()) || "enqueueToastEx".equals(method.getName()) || "cancelToast".equals(method.getName())) {
                        objArr[0] = "android";
                    }
                    return method.invoke(objInvoke, objArr);
                }
            });
            Field declaredField = Toast.class.getDeclaredField("sService");
            declaredField.setAccessible(true);
            declaredField.set(toast, iNotificationManagerProxy);
        } catch (Throwable unused) {
            iNotificationManagerProxy = null;
        }
    }

    static boolean isValid4HookINotificationManager() {
        return Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27;
    }

    static class SafelyHandlerWrapper extends Handler {
        private Handler mHandler;

        SafelyHandlerWrapper(Handler handler) {
            this.mHandler = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                this.mHandler.dispatchMessage(message);
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                this.mHandler.handleMessage(message);
            } catch (Throwable unused) {
            }
        }
    }
}
