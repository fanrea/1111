package com.kwad.sdk.widget.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HorizontalSwipeLayout extends FrameLayout {
    private int cqi;
    private d cqj;
    private List<a> cqk;
    private float jn;
    private float jo;
    private int mTouchSlop;

    public interface a {
        void yo();

        void yp();
    }

    public HorizontalSwipeLayout(Context context) {
        super(context);
        this.cqi = 0;
        this.cqk = new CopyOnWriteArrayList();
        init(context);
    }

    public HorizontalSwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqi = 0;
        this.cqk = new CopyOnWriteArrayList();
        init(context);
    }

    public HorizontalSwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqi = 0;
        this.cqk = new CopyOnWriteArrayList();
        init(context);
    }

    private void init(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledPagingTouchSlop();
    }

    public void setTouchDetector(d dVar) {
        this.cqj = dVar;
    }

    public final synchronized void a(a aVar) {
        this.cqk.add(aVar);
    }

    public synchronized List<a> getOnSwipedListeners() {
        return this.cqk;
    }

    public final synchronized boolean b(a aVar) {
        return this.cqk.contains(aVar);
    }

    public final synchronized void c(a aVar) {
        this.cqk.remove(aVar);
    }

    public final synchronized void aqV() {
        this.cqk.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        d dVar = this.cqj;
        if (dVar != null) {
            dVar.d(this, motionEvent);
        }
        List<a> list = this.cqk;
        if (list != null && !list.isEmpty()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (action == 1 || action == 3) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        d dVar = this.cqj;
        if (dVar != null && dVar.e(this, motionEvent)) {
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onInterceptTouchEvent true");
            return true;
        }
        List<a> list = this.cqk;
        if (list == null || list.isEmpty() || !l(motionEvent)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        d dVar = this.cqj;
        if (dVar != null && dVar.f(this, motionEvent)) {
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "handlerTouchEvent true");
            return true;
        }
        List<a> list = this.cqk;
        if (list == null || list.isEmpty() || !m(motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    private boolean l(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jn = motionEvent.getX();
            this.jo = motionEvent.getY();
            this.cqi = 0;
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onInterceptTouchEvent ACTION_DOWN mInitialMotionX=" + this.jn);
        } else if (action == 1) {
            this.cqi = 0;
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onInterceptTouchEvent ACTION_UP");
        } else if (action == 2) {
            float x = motionEvent.getX() - this.jn;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(motionEvent.getY() - this.jo);
            if (fAbs > this.mTouchSlop && fAbs > fAbs2) {
                if (x > 0.0f) {
                    this.cqi = 1;
                } else {
                    this.cqi = 2;
                }
            }
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onInterceptTouchEvent ACTION_MOVE mDragState=" + this.cqi + "--dx=" + x);
        } else if (action == 3) {
            this.cqi = 0;
        }
        return this.cqi != 0;
    }

    private boolean m(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (action == 0) {
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onTouchEvent ACTION_DOWN mInitialMotionX=" + this.jn);
        } else if (action == 1) {
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onTouchEvent ACTION_UP mDragState=" + this.cqi);
            List<a> list = this.cqk;
            if (list != null && !list.isEmpty() && (i = this.cqi) != 0) {
                if (i == 1) {
                    aqX();
                } else if (i == 2) {
                    aqW();
                }
            }
            this.cqi = 0;
        } else if (action == 2) {
            float x = motionEvent.getX() - this.jn;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(motionEvent.getY() - this.jo);
            if (this.cqi == 0 && fAbs > this.mTouchSlop && fAbs > fAbs2) {
                if (x > 0.0f) {
                    this.cqi = 1;
                } else {
                    this.cqi = 2;
                }
            }
            com.kwad.sdk.core.d.c.d("HorizontalSwipeLayout", "onTouchEvent ACTION_MOVE mDragState=" + this.cqi + "--dx=" + x);
        } else if (action == 3) {
            this.cqi = 0;
        }
        return this.cqi != 0;
    }

    private synchronized void aqW() {
        Iterator<a> it = this.cqk.iterator();
        while (it.hasNext()) {
            it.next().yp();
        }
    }

    private synchronized void aqX() {
        Iterator<a> it = this.cqk.iterator();
        while (it.hasNext()) {
            it.next().yo();
        }
    }
}
