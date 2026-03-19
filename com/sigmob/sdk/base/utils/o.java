package com.sigmob.sdk.base.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class o {

    public interface a {
        boolean a(View view, MotionEvent down, MotionEvent up);
    }

    public class b implements View.OnTouchListener {
        private final a b;
        private MotionEvent c;

        b(a onViewTouchListener) {
            this.b = onViewTouchListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent event) {
            a aVar;
            int action = event.getAction();
            if (action == 0) {
                this.c = event;
                return false;
            }
            if (action != 1 || (aVar = this.b) == null) {
                return false;
            }
            aVar.a(view, this.c, event);
            return false;
        }
    }

    private static int a(View view, ViewGroup parent) {
        int i = 0;
        while (i < parent.getChildCount() && parent.getChildAt(i) != view) {
            i++;
        }
        return i;
    }

    private static View a(final Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(R.id.content);
        }
        return null;
    }

    public static View a(final Context context, final View view) {
        View viewA = a(context);
        return viewA == null ? e(view) : viewA;
    }

    public static <T extends View> T a(ViewGroup viewGroup, Class<T> cls) {
        T t;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                return cls.cast(childAt);
            }
            if ((childAt instanceof ViewGroup) && (t = (T) a((ViewGroup) childAt, cls)) != null) {
                return t;
            }
        }
        return null;
    }

    public static void a(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static void a(final View view, final Runnable runnable) {
        if (view == null || runnable == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.utils.o.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                runnable.run();
            }
        });
    }

    public static boolean a(final View view, MotionEvent ev) {
        if (view == null) {
            return false;
        }
        int rawX = (int) ev.getRawX();
        int rawY = (int) ev.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return rawY >= i2 && rawY <= view.getMeasuredHeight() + i2 && rawX >= i && rawX <= view.getMeasuredWidth() + i;
    }

    public static boolean a(final View view, boolean isTotal, float percent) {
        Rect rect = new Rect();
        if (!(view.getGlobalVisibleRect(rect) && (rect.bottom - rect.top >= view.getMeasuredHeight()) && (rect.right - rect.left >= view.getMeasuredWidth())) && isTotal) {
            return true;
        }
        View view2 = view;
        while (view2.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            if (viewGroup.getVisibility() != 0) {
                return true;
            }
            for (int iA = a(view2, viewGroup) + 1; iA < viewGroup.getChildCount(); iA++) {
                Rect rect2 = new Rect();
                view.getGlobalVisibleRect(rect2);
                View childAt = viewGroup.getChildAt(iA);
                Rect rect3 = new Rect();
                childAt.getGlobalVisibleRect(rect3);
                rect3.height();
                rect2.height();
                int iHeight = (int) ((rect3.height() * 100.0f) / rect2.height());
                if (Rect.intersects(rect2, rect3) && iHeight >= percent) {
                    return true;
                }
            }
            view2 = viewGroup;
        }
        return false;
    }

    public static boolean b(View view) {
        return view.getParent() != null && view.getVisibility() == 0 && view.isShown();
    }

    public static Activity c(View view) {
        View viewE = e(view);
        if (viewE == null) {
            return null;
        }
        return d(viewE);
    }

    public static Activity d(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static View e(final View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View viewFindViewById = rootView.findViewById(R.id.content);
        return viewFindViewById == null ? rootView : viewFindViewById;
    }
}
