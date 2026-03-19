package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.utility.DeviceUtils;
import com.kuaishou.socket.nano.SocketMessages;
import com.qq.e.ads.ADActivity;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ua {
    private static final g a = g.b.a();

    private static int b() {
        return a().heightPixels;
    }

    private static int c() {
        return a().widthPixels;
    }

    public static int e() {
        return c();
    }

    public static int f() {
        return a.a();
    }

    public static void b(Activity activity, boolean z) {
        a.b(activity, z, true);
    }

    public static void c(Activity activity, boolean z) {
        a.a(activity, z, true);
    }

    public static void b(Activity activity, boolean z, boolean z2) {
        a.a(activity, z, z2);
    }

    public static void b(View view, int i2) {
        a.a(view, i2, true);
    }

    public static void d(Activity activity, boolean z) {
        Window window;
        if (z && (window = activity.getWindow()) != null) {
            window.setFlags(8, 8);
        }
    }

    public static int d() {
        return b();
    }

    public static void a(Activity activity, boolean z) {
        Window window;
        if (z && (window = activity.getWindow()) != null) {
            window.clearFlags(8);
        }
    }

    /* compiled from: A */
    public interface g {
        public static final a a = a.b();

        /* compiled from: A */
        public static class b {
            public static g a() {
                a aVar = a.HUAWEI;
                a aVar2 = g.a;
                return aVar == aVar2 ? new b() : a.XIAOMI == aVar2 ? new j() : a.VIVO == aVar2 ? new i() : a.OPPO == aVar2 ? new d() : a.MEIZU == aVar2 ? new c() : a.SAMSUNG == aVar2 ? new f() : a.SMARTISAN == aVar2 ? new h() : new e();
            }
        }

        int a();

        void a(Activity activity, boolean z, boolean z2);

        void a(View view, int i, boolean z);

        void b(Activity activity, boolean z, boolean z2);

        void b(View view, int i, boolean z);

        /* compiled from: A */
        public enum a {
            HUAWEI("Huawei"),
            XIAOMI("Xiaomi"),
            VIVO("vivo"),
            OPPO(DeviceUtils.ROM_OPPO),
            MEIZU("Meizu"),
            SAMSUNG(DeviceUtils.ROM_SAMSUNG),
            SMARTISAN("Smartisan");

            private final String a;

            public static a b() {
                for (a aVar : values()) {
                    if (aVar.a.equalsIgnoreCase(Build.MANUFACTURER) || aVar.a.equalsIgnoreCase(Build.BRAND)) {
                        return aVar;
                    }
                }
                return null;
            }

            a(String str) {
                this.a = str;
            }
        }
    }

    /* compiled from: A */
    public static abstract class a implements g {
        private int b = 0;

        protected int a(Context context) {
            return 0;
        }

        protected void a(Activity activity) {
        }

        protected boolean b() {
            return true;
        }

        protected boolean b(Context context) {
            return false;
        }

        public boolean d(Activity activity) {
            return Build.VERSION.SDK_INT >= 28 ? a(activity, b(activity)) > 0 : b((Context) activity);
        }

        public int c(Activity activity) {
            int iA;
            if (!d(activity) || !b()) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                iA = a(activity, b(activity));
            } else {
                iA = a((Context) activity);
            }
            this.b = iA;
            return iA;
        }

        public boolean c(View view) {
            if (Build.VERSION.SDK_INT >= 28) {
                return a(view.getContext(), a(view)) > 0;
            }
            return b(view.getContext());
        }

        @Override // com.qq.e.comm.plugin.ua.g
        public void b(Activity activity, boolean z, boolean z2) {
            a(activity, false, z, true, z2);
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.ua$a$a, reason: collision with other inner class name */
        class ViewOnAttachStateChangeListenerC0724a implements View.OnAttachStateChangeListener {
            final /* synthetic */ Activity a;
            final /* synthetic */ boolean b;
            final /* synthetic */ boolean c;
            final /* synthetic */ boolean d;
            final /* synthetic */ Window e;

            ViewOnAttachStateChangeListenerC0724a(Activity activity, boolean z, boolean z2, boolean z3, Window window) {
                this.a = activity;
                this.b = z;
                this.c = z2;
                this.d = z3;
                this.e = window;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.a(this.a, this.b, this.c, this.d, false);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.e.getDecorView().removeOnAttachStateChangeListener(this);
            }
        }

        /* compiled from: A */
        class b implements View.OnSystemUiVisibilityChangeListener {
            final /* synthetic */ Activity a;
            final /* synthetic */ boolean b;
            final /* synthetic */ boolean c;

            b(Activity activity, boolean z, boolean z2) {
                this.a = activity;
                this.b = z;
                this.c = z2;
            }

            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                a.this.a(this.a, this.b, this.c, false, false);
            }
        }

        /* compiled from: A */
        class c implements View.OnAttachStateChangeListener {
            final /* synthetic */ View a;
            final /* synthetic */ int b;

            c(View view, int i) {
                this.a = view;
                this.b = i;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.b(this.a, this.b, false);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.a.removeOnAttachStateChangeListener(this);
            }
        }

        /* compiled from: A */
        class d implements View.OnAttachStateChangeListener {
            final /* synthetic */ View a;
            final /* synthetic */ int b;

            d(View view, int i) {
                this.a = view;
                this.b = i;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.this.a(this.a, this.b, false);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.a.removeOnAttachStateChangeListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Activity activity, boolean z, boolean z2, boolean z3, boolean z4) {
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            if (z4) {
                window.getDecorView().addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0724a(activity, z, z2, z3, window));
                return;
            }
            a(activity, z);
            int i = Build.VERSION.SDK_INT;
            int i2 = i >= 16 ? z2 ? 1798 : SocketMessages.PayloadType.SC_LIVE_PARTY_PLAY_STATUS : 0;
            window.getDecorView().setSystemUiVisibility(i >= 19 ? i2 | 4096 : i2 | 1);
            if (i >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            a(activity);
            if (z3) {
                window.getDecorView().setOnSystemUiVisibilityChangeListener(new b(activity, z, z2));
            }
        }

        public int b(View view) {
            int iA;
            Context context = view.getContext();
            if (!c(view)) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                iA = a(context, a(view));
            } else {
                iA = a(context);
            }
            this.b = iA;
            if (b()) {
                return iA;
            }
            return 0;
        }

        @Override // com.qq.e.comm.plugin.ua.g
        public void a(Activity activity, boolean z, boolean z2) {
            a(activity, true, z, true, z2);
        }

        @Override // com.qq.e.comm.plugin.ua.g
        public void b(View view, int i, boolean z) {
            if (z) {
                view.addOnAttachStateChangeListener(new c(view, i));
                return;
            }
            if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                int rotation = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                Rect rect = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                a(rotation, i, rect, b(view));
                marginLayoutParams.setMargins(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        protected DisplayCutout b(Activity activity) {
            Window window;
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 28 || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        }

        protected int a(Context context, String str) throws Resources.NotFoundException {
            try {
                int identifier = context.getResources().getIdentifier(str, "dimen", "android");
                if (identifier <= 0) {
                    return 0;
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            } catch (Exception unused) {
                return 0;
            }
        }

        public int a(Context context, DisplayCutout displayCutout) {
            if (Build.VERSION.SDK_INT < 28 || displayCutout == null) {
                return 0;
            }
            if (context.getResources().getConfiguration().orientation == 1) {
                return displayCutout.getSafeInsetTop();
            }
            if (displayCutout.getSafeInsetLeft() == 0) {
                return displayCutout.getSafeInsetRight();
            }
            return displayCutout.getSafeInsetLeft();
        }

        @Override // com.qq.e.comm.plugin.ua.g
        public int a() {
            return a(r1.d().a(), "status_bar_height");
        }

        @Override // com.qq.e.comm.plugin.ua.g
        public void a(View view, int i, boolean z) {
            if (z) {
                view.addOnAttachStateChangeListener(new d(view, i));
                return;
            }
            int rotation = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            Rect rect = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            a(rotation, i, rect, b(view));
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }

        private void a(Activity activity, boolean z) {
            ViewGroup viewGroup;
            Window window = activity.getWindow();
            if (window == null || (viewGroup = (ViewGroup) window.getDecorView().findViewWithTag(ADActivity.NOTCH_CONTAINER_TAG)) == null) {
                return;
            }
            if (viewGroup.getChildCount() == 0) {
                View view = new View(activity);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, c(activity)));
                viewGroup.addView(view);
            }
            if (z) {
                viewGroup.setVisibility(8);
            } else {
                viewGroup.setVisibility(0);
            }
        }

        private void a(int i, int i2, Rect rect, int i3) {
            if (i == 0) {
                if ((i2 & 2) == 2 || i2 == 0) {
                    rect.top += i3;
                    return;
                }
                return;
            }
            if (i == 1 || i == 3) {
                if ((i2 & 1) == 1) {
                    rect.left += i3;
                }
                if ((i2 & 4) == 4) {
                    rect.right += i3;
                }
                if (i2 == 0) {
                    rect.left += i3;
                    rect.right += i3;
                }
            }
        }

        protected DisplayCutout a(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 28 || (rootWindowInsets = view.getRootWindowInsets()) == null) {
                return null;
            }
            return rootWindowInsets.getDisplayCutout();
        }
    }

    public static boolean a(Context context) {
        Window window;
        try {
        } catch (Throwable th) {
            th.toString();
        }
        if (!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null) {
            return false;
        }
        boolean z = (window.getAttributes().flags & 1024) != 0;
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        return (Build.VERSION.SDK_INT < 16 || ((systemUiVisibility & 4) == 0 && (systemUiVisibility & 1024) == 0)) && !z;
    }

    private static DisplayMetrics a() {
        Context contextA = r1.d().a();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) contextA.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static void a(Activity activity, boolean z, boolean z2) {
        a.b(activity, z, z2);
    }

    public static void a(View view, int i2) {
        a.b(view, i2, true);
    }

    public static boolean a(h4 h4Var) {
        int iA = r1.d().f().a("fshng", h4Var.y0(), 1);
        if (iA == 0) {
            return false;
        }
        return iA == 1 || com.qq.e.comm.plugin.b.c().a(h4Var.x0(), String.valueOf(iA), 1) == 1;
    }

    /* compiled from: A */
    public static class b extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) throws ClassNotFoundException {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 17 && Settings.Secure.getInt(r1.d().a().getContentResolver(), "display_notch_status", 0) == 1;
        }

        @Override // com.qq.e.comm.plugin.ua.a
        public void a(Activity activity) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Window window = activity.getWindow();
            if (window == null) {
                return;
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
            } catch (Exception unused) {
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b() {
            int rotation = ((WindowManager) r1.d().a().getSystemService("window")).getDefaultDisplay().getRotation();
            if (c()) {
                return (rotation == 1 || rotation == 3) ? false : true;
            }
            return true;
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) throws ClassNotFoundException {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return ((int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]))[0];
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* compiled from: A */
    public static class c extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) {
            try {
                return ((Boolean) Class.forName("flyme.config.FlymeFeature").getDeclaredField("IS_FRINGE_DEVICE").get(null)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) {
            if (c()) {
                return a();
            }
            return a(context, "fringe_height");
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(r1.d().a().getContentResolver(), "mz_fringe_hide", 0) == 1;
        }
    }

    /* compiled from: A */
    public static class d extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) {
            try {
                return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) {
            int iA = a();
            if (80 < iA) {
                return iA;
            }
            return 80;
        }
    }

    /* compiled from: A */
    public static class e extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        public boolean d(Activity activity) {
            return super.a(activity, b(activity)) > 0;
        }

        @Override // com.qq.e.comm.plugin.ua.a
        public boolean c(View view) {
            return super.a(view.getContext(), a(view)) > 0;
        }
    }

    /* compiled from: A */
    public static class f extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) {
            try {
                return context.getResources().getIdentifier("config_mainBuiltInDisplayCutout", TypedValues.Custom.S_STRING, "android") > 0;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) {
            return a();
        }
    }

    /* compiled from: A */
    public static class h extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) throws ClassNotFoundException {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("smartisanos.api.DisplayUtilsSmt");
                return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 1)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) {
            int iA = a();
            if (82 < iA) {
                return iA;
            }
            return 82;
        }
    }

    /* compiled from: A */
    public static class i extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) throws ClassNotFoundException {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) {
            int iA = a();
            int iA2 = yu.a(context, 27);
            return iA2 < iA ? iA : iA2;
        }
    }

    /* compiled from: A */
    public static class j extends a {
        @Override // com.qq.e.comm.plugin.ua.a
        protected boolean b(Context context) throws ClassNotFoundException {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
            } catch (Exception unused) {
                return false;
            }
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected int a(Context context) {
            if (c()) {
                return a();
            }
            return a(context, "notch_height");
        }

        @Override // com.qq.e.comm.plugin.ua.a
        protected void a(Activity activity) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT < 26 || !d(activity)) {
                return;
            }
            try {
                Method method = Window.class.getMethod("addExtraFlags", Integer.TYPE);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(activity.getWindow(), 1792);
            } catch (Exception e) {
                e.getMessage();
            }
        }

        public boolean c() {
            return Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(r1.d().a().getContentResolver(), "force_black", 0) == 1;
        }
    }
}
