package com.bytedance.sdk.component.panglearmor;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.sdk.component.utils.mq;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends View.AccessibilityDelegate {
    public static Field hc;
    public View.AccessibilityDelegate an;
    public View h;
    public static d d = new d(null, null);
    public static int b = 0;
    public static String c = "";
    public static Set<Integer> u = new HashSet();

    static {
        hc = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                hc = declaredField;
            } catch (Throwable th) {
                mq.d(th);
            }
        }
    }

    public d(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.an = accessibilityDelegate;
        this.h = view;
        SoftDecTool.h = true;
    }

    public static void d(View view) {
        Field field;
        if (u.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        View.AccessibilityDelegate accessibilityDelegate = null;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                field = hc;
            } catch (Throwable th) {
                mq.d(th);
            }
            if (field != null) {
                accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
            } else {
                z = false;
            }
        }
        if (!(accessibilityDelegate instanceof d) && z) {
            view.setAccessibilityDelegate(new d(accessibilityDelegate, view));
            u.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        b = hashCode();
        c = String.valueOf(this.an);
        view.setAccessibilityDelegate(this.an);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.an;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean zPerformAccessibilityAction;
        b = hashCode();
        c = String.valueOf(this.an);
        SoftDecTool.a = true;
        view.setAccessibilityDelegate(this.an);
        View.AccessibilityDelegate accessibilityDelegate = this.an;
        if (accessibilityDelegate != null) {
            zPerformAccessibilityAction = accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        } else {
            zPerformAccessibilityAction = super.performAccessibilityAction(view, i, bundle);
        }
        view.setAccessibilityDelegate(this);
        return zPerformAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        b = hashCode();
        c = String.valueOf(this.an);
        view.setAccessibilityDelegate(this.an);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.an;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        boolean zDispatchPopulateAccessibilityEvent;
        b = hashCode();
        c = String.valueOf(this.an);
        view.setAccessibilityDelegate(this.an);
        view.setAccessibilityDelegate(this.an);
        View.AccessibilityDelegate accessibilityDelegate = this.an;
        if (accessibilityDelegate != null) {
            zDispatchPopulateAccessibilityEvent = accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        } else {
            zDispatchPopulateAccessibilityEvent = super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }
        view.setAccessibilityDelegate(this);
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        b = hashCode();
        c = String.valueOf(this.an);
        if (d()) {
            return;
        }
        view.setAccessibilityDelegate(this.an);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.an;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        b = hashCode();
        c = String.valueOf(this.an);
        view.setAccessibilityDelegate(this.an);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.an;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        b = hashCode();
        c = String.valueOf(this.an);
        view.setAccessibilityDelegate(this.an);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.an;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        b = hashCode();
        c = String.valueOf(this.an);
        view.setAccessibilityDelegate(this.an);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                View.AccessibilityDelegate accessibilityDelegate = this.an;
                if (accessibilityDelegate != null) {
                    accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                } else {
                    super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
                }
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        boolean zOnRequestSendAccessibilityEvent;
        b = hashCode();
        c = String.valueOf(this.an);
        viewGroup.setAccessibilityDelegate(this.an);
        View.AccessibilityDelegate accessibilityDelegate = this.an;
        if (accessibilityDelegate != null) {
            zOnRequestSendAccessibilityEvent = accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        } else {
            zOnRequestSendAccessibilityEvent = super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    public boolean d() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            if (stackTrace[i] != null && stackTraceElement.getMethodName().equals(stackTrace[i].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
