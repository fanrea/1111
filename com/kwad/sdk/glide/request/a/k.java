package com.kwad.sdk.glide.request.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.kwad.sdk.utils.ax;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class k<T extends View, Z> extends com.kwad.sdk.glide.request.a.a<Z> {
    private static final String TAG = "ViewTarget";
    private static boolean isTagUsedAtLeastOnce;
    private static Integer tagId;
    private View.OnAttachStateChangeListener attachStateListener;
    private boolean isAttachStateListenerAdded;
    private boolean isClearedByUs;
    private final a sizeDeterminer;
    protected final T view;

    public k(T t) {
        this.view = (T) ax.checkNotNull(t);
        this.sizeDeterminer = new a(t);
    }

    @Deprecated
    public k(T t, boolean z) {
        this(t);
        if (z) {
            waitForLayout();
        }
    }

    public final k<T, Z> clearOnDetach() {
        if (this.attachStateListener != null) {
            return this;
        }
        this.attachStateListener = new View.OnAttachStateChangeListener() { // from class: com.kwad.sdk.glide.request.a.k.1
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View view) {
                k.this.resumeMyRequest();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View view) {
                k.this.pauseMyRequest();
            }
        };
        maybeAddAttachStateListener();
        return this;
    }

    void resumeMyRequest() {
        com.kwad.sdk.glide.request.e request = getRequest();
        if (request == null || !request.ajb()) {
            return;
        }
        request.begin();
    }

    void pauseMyRequest() {
        com.kwad.sdk.glide.request.e request = getRequest();
        if (request != null) {
            this.isClearedByUs = true;
            request.clear();
            this.isClearedByUs = false;
        }
    }

    public final k<T, Z> waitForLayout() {
        this.sizeDeterminer.bZX = true;
        return this;
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        maybeAddAttachStateListener();
    }

    private void maybeAddAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || this.isAttachStateListenerAdded) {
            return;
        }
        this.view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = true;
    }

    private void maybeRemoveAttachStateListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.attachStateListener;
        if (onAttachStateChangeListener == null || !this.isAttachStateListenerAdded) {
            return;
        }
        this.view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.isAttachStateListenerAdded = false;
    }

    public T getView() {
        return this.view;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void getSize(i iVar) {
        this.sizeDeterminer.getSize(iVar);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void removeCallback(i iVar) {
        this.sizeDeterminer.removeCallback(iVar);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.sizeDeterminer.ajr();
        if (this.isClearedByUs) {
            return;
        }
        maybeRemoveAttachStateListener();
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public void setRequest(com.kwad.sdk.glide.request.e eVar) {
        setTag(eVar);
    }

    @Override // com.kwad.sdk.glide.request.a.a, com.kwad.sdk.glide.request.a.j
    public com.kwad.sdk.glide.request.e getRequest() {
        Object tag = getTag();
        if (tag == null) {
            return null;
        }
        if (tag instanceof com.kwad.sdk.glide.request.e) {
            return (com.kwad.sdk.glide.request.e) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        return "Target for: " + this.view;
    }

    private void setTag(Object obj) {
        Integer num = tagId;
        if (num == null) {
            isTagUsedAtLeastOnce = true;
            this.view.setTag(obj);
        } else {
            this.view.setTag(num.intValue(), obj);
        }
    }

    private Object getTag() {
        Integer num = tagId;
        if (num == null) {
            return this.view.getTag();
        }
        return this.view.getTag(num.intValue());
    }

    public static void setTagId(int i) {
        if (tagId != null || isTagUsedAtLeastOnce) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        tagId = Integer.valueOf(i);
    }

    static final class a {
        static Integer bZV;
        private final List<i> bZW = new ArrayList();
        boolean bZX;
        private ViewTreeObserverOnPreDrawListenerC0614a bZY;
        private final View view;

        private static boolean gq(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        a(View view) {
            this.view = view;
        }

        private static int cD(Context context) {
            if (bZV == null) {
                Display defaultDisplay = ((WindowManager) ax.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                bZV = Integer.valueOf(Math.max(point.x, point.y));
            }
            return bZV.intValue();
        }

        private void W(int i, int i2) {
            Iterator it = new ArrayList(this.bZW).iterator();
            while (it.hasNext()) {
                ((i) it.next()).V(i, i2);
            }
        }

        final void ajq() {
            if (this.bZW.isEmpty()) {
                return;
            }
            int iAjt = ajt();
            int iAjs = ajs();
            if (X(iAjt, iAjs)) {
                W(iAjt, iAjs);
                ajr();
            }
        }

        final void getSize(i iVar) {
            int iAjt = ajt();
            int iAjs = ajs();
            if (X(iAjt, iAjs)) {
                iVar.V(iAjt, iAjs);
                return;
            }
            if (!this.bZW.contains(iVar)) {
                this.bZW.add(iVar);
            }
            if (this.bZY == null) {
                ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0614a viewTreeObserverOnPreDrawListenerC0614a = new ViewTreeObserverOnPreDrawListenerC0614a(this);
                this.bZY = viewTreeObserverOnPreDrawListenerC0614a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0614a);
            }
        }

        final void removeCallback(i iVar) {
            this.bZW.remove(iVar);
        }

        final void ajr() {
            ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.bZY);
            }
            this.bZY = null;
            this.bZW.clear();
        }

        private boolean X(int i, int i2) {
            return gq(i) && gq(i2);
        }

        private int ajs() {
            int paddingTop = this.view.getPaddingTop() + this.view.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return d(this.view.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int ajt() {
            int paddingLeft = this.view.getPaddingLeft() + this.view.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
            return d(this.view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private int d(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.bZX && this.view.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.view.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable(k.TAG, 4)) {
                Log.i(k.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return cD(this.view.getContext());
        }

        /* renamed from: com.kwad.sdk.glide.request.a.k$a$a, reason: collision with other inner class name */
        static final class ViewTreeObserverOnPreDrawListenerC0614a implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<a> bZZ;

            ViewTreeObserverOnPreDrawListenerC0614a(a aVar) {
                this.bZZ = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                if (Log.isLoggable(k.TAG, 2)) {
                    Log.v(k.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.bZZ.get();
                if (aVar == null) {
                    return true;
                }
                aVar.ajq();
                return true;
            }
        }
    }
}
