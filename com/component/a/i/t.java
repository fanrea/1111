package com.component.a.i;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class t extends GestureDetector {
    private final a a;

    public static void a(View view, boolean z, b bVar) {
        if (view != null) {
            a aVar = new a(view, z);
            t tVar = new t(view.getContext(), aVar);
            tVar.a(bVar);
            if (z) {
                tVar.setOnDoubleTapListener(aVar);
            }
            view.setOnTouchListener(new u(tVar));
        }
    }

    public void a(b bVar) {
        this.a.c = bVar;
    }

    public static abstract class b {
        public void a(View view, MotionEvent motionEvent) {
        }

        public void c(View view, MotionEvent motionEvent) {
        }

        public void d(View view, MotionEvent motionEvent) {
        }

        public void b(View view, MotionEvent motionEvent) {
        }

        public void e(View view, MotionEvent motionEvent) {
        }
    }

    private t(Context context, a aVar) {
        super(context, aVar);
        this.a = aVar;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.a != null) {
            switch (action) {
                case 1:
                    this.a.a(motionEvent);
                    break;
                case 3:
                    this.a.b(motionEvent);
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private static class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        private final View a;
        private final boolean b;
        private b c;

        public a(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            if (this.c != null) {
                this.c.b(this.a, motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (this.c != null) {
                this.c.e(this.a, motionEvent);
            }
            this.a.performLongClick();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (!this.b) {
                if (this.c != null) {
                    this.c.c(this.a, motionEvent);
                }
                t.a(this.a);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        public void a(MotionEvent motionEvent) {
            if (this.c != null) {
                this.c.a(this.a, motionEvent);
            }
        }

        public void b(MotionEvent motionEvent) {
            if (this.c != null) {
                this.c.a(this.a, motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (this.b) {
                if (this.c != null) {
                    this.c.c(this.a, motionEvent);
                }
                t.a(this.a);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (this.b && this.c != null) {
                this.c.d(this.a, motionEvent);
            }
            return this.b;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return this.b;
        }
    }

    public static void a(View view) {
        boolean z = false;
        while (!z) {
            try {
                if (view.isClickable()) {
                    view.performClick();
                    z = true;
                } else {
                    Object parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th) {
                bq.a().a(th);
                return;
            }
        }
    }
}
