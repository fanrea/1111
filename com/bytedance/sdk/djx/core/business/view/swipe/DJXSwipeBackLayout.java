package com.bytedance.sdk.djx.core.business.view.swipe;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXSwipeBackLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final float DEFAULT_SCROLL_THRESHOLD = 0.3f;
    public static final int EDGE_ALL = 11;
    public static final int EDGE_BOTTOM = 8;
    private static final int[] EDGE_FLAGS = {1, 2, 8, 11};
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int FULL_ALPHA = 255;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int OVERSCROLL_DISTANCE = 10;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private int mContentLeft;
    private int mContentTop;
    private View mContentView;
    private final DJXViewDragHelper mDragHelper;
    private int mEdgeFlag;
    private boolean mEnable;
    private boolean mInLayout;
    private boolean mIsEnableShadow;
    private List<SwipeListener> mListeners;
    private int mScrimColor;
    private float mScrimOpacity;
    private float mScrollPercent;
    private float mScrollThreshold;
    private Drawable mShadowBottom;
    private Drawable mShadowLeft;
    private Drawable mShadowRight;
    private final Rect mTmpRect;
    private int mTrackingEdge;

    public interface SwipeListener {
        void onEdgeTouch(int i);

        void onScrollOverThreshold();

        void onScrollStateChange(int i, float f);
    }

    public interface SwipeListenerEx extends SwipeListener {
        void onContentViewSwipedBack();
    }

    public DJXSwipeBackLayout(Context context) {
        this(context, null);
    }

    public DJXSwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXSwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mScrollThreshold = DEFAULT_SCROLL_THRESHOLD;
        this.mEnable = true;
        this.mIsEnableShadow = true;
        this.mScrimColor = -1728053248;
        this.mTmpRect = new Rect();
        DJXViewDragHelper dJXViewDragHelperCreate = DJXViewDragHelper.create(this, new ViewDragCallback());
        this.mDragHelper = dJXViewDragHelperCreate;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXSwipeBackLayout);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXSwipeBackLayout_djx_edge_size, UIUtil.dp2px(50.0f));
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(EDGE_FLAGS[typedArrayObtainStyledAttributes.getInt(R.styleable.DJXSwipeBackLayout_djx_edge_flag, 0)]);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DJXSwipeBackLayout_djx_shadow_left, R.drawable.djx_swipe_shadow_left);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DJXSwipeBackLayout_djx_shadow_right, R.drawable.djx_swipe_shadow_right);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.DJXSwipeBackLayout_djx_shadow_bottom, R.drawable.djx_swipe_shadow_bottom);
        setShadow(resourceId, 1);
        setShadow(resourceId2, 2);
        setShadow(resourceId3, 8);
        typedArrayObtainStyledAttributes.recycle();
        float f = getResources().getDisplayMetrics().density * 400.0f;
        dJXViewDragHelperCreate.setMinVelocity(f);
        dJXViewDragHelperCreate.setMaxVelocity(f * 2.0f);
    }

    public void setSensitivity(Context context, float f) {
        this.mDragHelper.setSensitivity(context, f);
    }

    public void setContentView(View view) {
        this.mContentView = view;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mEdgeFlag = i;
        this.mDragHelper.setEdgeTrackingEnabled(i);
    }

    public void setScrimColor(int i) {
        this.mScrimColor = i;
        invalidate();
    }

    public void setEnableShadow(boolean z) {
        this.mIsEnableShadow = z;
    }

    public void setEdgeSize(int i) {
        this.mDragHelper.setEdgeSize(i);
    }

    @Deprecated
    public void setSwipeListener(SwipeListener swipeListener) {
        addSwipeListener(swipeListener);
    }

    public void addSwipeListener(SwipeListener swipeListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(swipeListener);
    }

    public void removeSwipeListener(SwipeListener swipeListener) {
        List<SwipeListener> list = this.mListeners;
        if (list == null) {
            return;
        }
        list.remove(swipeListener);
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.mScrollThreshold = f;
    }

    public void setShadow(Drawable drawable, int i) {
        if ((i & 1) != 0) {
            this.mShadowLeft = drawable;
        } else if ((i & 2) != 0) {
            this.mShadowRight = drawable;
        } else if ((i & 8) != 0) {
            this.mShadowBottom = drawable;
        }
        invalidate();
    }

    public void setShadow(int i, int i2) {
        setShadow(getResources().getDrawable(i), i2);
    }

    public void scrollToFinishActivity() {
        int intrinsicHeight;
        int intrinsicWidth;
        int width = this.mContentView.getWidth();
        int height = this.mContentView.getHeight();
        int i = this.mEdgeFlag;
        int i2 = 0;
        if ((i & 1) != 0) {
            intrinsicWidth = width + this.mShadowLeft.getIntrinsicWidth() + 10;
            this.mTrackingEdge = 1;
        } else if ((i & 2) != 0) {
            intrinsicWidth = ((-width) - this.mShadowRight.getIntrinsicWidth()) - 10;
            this.mTrackingEdge = 2;
        } else {
            if ((i & 8) != 0) {
                intrinsicHeight = ((-height) - this.mShadowBottom.getIntrinsicHeight()) - 10;
                this.mTrackingEdge = 8;
            } else {
                intrinsicHeight = 0;
            }
            this.mDragHelper.smoothSlideViewTo(this.mContentView, i2, intrinsicHeight);
            invalidate();
        }
        intrinsicHeight = 0;
        i2 = intrinsicWidth;
        this.mDragHelper.smoothSlideViewTo(this.mContentView, i2, intrinsicHeight);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return false;
        }
        try {
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return false;
        }
        try {
            this.mDragHelper.processTouchEvent(motionEvent);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        View view = this.mContentView;
        if (view != null) {
            int i5 = this.mContentLeft;
            view.layout(i5, this.mContentTop, view.getMeasuredWidth() + i5, this.mContentTop + this.mContentView.getMeasuredHeight());
        }
        this.mInLayout = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view == this.mContentView;
        boolean zDrawChild = super.drawChild(canvas, view, j);
        if (this.mIsEnableShadow && this.mScrimOpacity > 0.0f && z && this.mDragHelper.getViewDragState() != 0) {
            drawShadow(canvas, view);
            drawScrim(canvas, view);
        }
        return zDrawChild;
    }

    private void drawScrim(Canvas canvas, View view) {
        int i = (this.mScrimColor & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * this.mScrimOpacity)) << 24);
        int i2 = this.mTrackingEdge;
        if ((i2 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i2 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i2 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i);
    }

    private void drawShadow(Canvas canvas, View view) {
        Rect rect = this.mTmpRect;
        view.getHitRect(rect);
        if ((this.mEdgeFlag & 1) != 0) {
            this.mShadowLeft.setBounds(rect.left - this.mShadowLeft.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.mShadowLeft.setAlpha((int) (this.mScrimOpacity * 255.0f));
            this.mShadowLeft.draw(canvas);
        }
        if ((this.mEdgeFlag & 2) != 0) {
            this.mShadowRight.setBounds(rect.right, rect.top, rect.right + this.mShadowRight.getIntrinsicWidth(), rect.bottom);
            this.mShadowRight.setAlpha((int) (this.mScrimOpacity * 255.0f));
            this.mShadowRight.draw(canvas);
        }
        if ((this.mEdgeFlag & 8) != 0) {
            this.mShadowBottom.setBounds(rect.left, rect.bottom, rect.right, rect.bottom + this.mShadowBottom.getIntrinsicHeight());
            this.mShadowBottom.setAlpha((int) (this.mScrimOpacity * 255.0f));
            this.mShadowBottom.draw(canvas);
        }
    }

    public void attachToActivity(Activity activity) {
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        addSwipeListener(new SwipeBackListenerActivityAdapter(activity));
        viewGroup.addView(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mScrimOpacity = 1.0f - this.mScrollPercent;
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private class ViewDragCallback extends DJXViewDragHelper.Callback {
        private boolean mIsScrollOverValid;

        private ViewDragCallback() {
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            boolean zCheckTouchSlop;
            boolean zIsEdgeTouched = DJXSwipeBackLayout.this.mDragHelper.isEdgeTouched(DJXSwipeBackLayout.this.mEdgeFlag, i);
            boolean z = true;
            if (zIsEdgeTouched) {
                if (DJXSwipeBackLayout.this.mDragHelper.isEdgeTouched(1, i)) {
                    DJXSwipeBackLayout.this.mTrackingEdge = 1;
                } else if (DJXSwipeBackLayout.this.mDragHelper.isEdgeTouched(2, i)) {
                    DJXSwipeBackLayout.this.mTrackingEdge = 2;
                } else if (DJXSwipeBackLayout.this.mDragHelper.isEdgeTouched(8, i)) {
                    DJXSwipeBackLayout.this.mTrackingEdge = 8;
                }
                if (DJXSwipeBackLayout.this.mListeners != null && !DJXSwipeBackLayout.this.mListeners.isEmpty()) {
                    Iterator it = DJXSwipeBackLayout.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((SwipeListener) it.next()).onEdgeTouch(DJXSwipeBackLayout.this.mTrackingEdge);
                    }
                }
                this.mIsScrollOverValid = true;
            }
            if (DJXSwipeBackLayout.this.mEdgeFlag == 1 || DJXSwipeBackLayout.this.mEdgeFlag == 2) {
                zCheckTouchSlop = DJXSwipeBackLayout.this.mDragHelper.checkTouchSlop(2, i);
            } else {
                if (DJXSwipeBackLayout.this.mEdgeFlag != 8) {
                    if (DJXSwipeBackLayout.this.mEdgeFlag != 11) {
                        z = false;
                    }
                    return zIsEdgeTouched & z;
                }
                zCheckTouchSlop = DJXSwipeBackLayout.this.mDragHelper.checkTouchSlop(1, i);
            }
            z = true ^ zCheckTouchSlop;
            return zIsEdgeTouched & z;
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return DJXSwipeBackLayout.this.mEdgeFlag & 3;
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return DJXSwipeBackLayout.this.mEdgeFlag & 8;
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            if ((DJXSwipeBackLayout.this.mTrackingEdge & 1) == 0) {
                if ((DJXSwipeBackLayout.this.mTrackingEdge & 2) == 0) {
                    if ((DJXSwipeBackLayout.this.mTrackingEdge & 8) != 0) {
                        DJXSwipeBackLayout.this.mScrollPercent = Math.abs(i2 / (r3.mContentView.getHeight() + DJXSwipeBackLayout.this.mShadowBottom.getIntrinsicHeight()));
                    }
                } else {
                    DJXSwipeBackLayout.this.mScrollPercent = Math.abs(i / (r3.mContentView.getWidth() + DJXSwipeBackLayout.this.mShadowRight.getIntrinsicWidth()));
                }
            } else {
                DJXSwipeBackLayout.this.mScrollPercent = Math.abs(i / (r3.mContentView.getWidth() + DJXSwipeBackLayout.this.mShadowLeft.getIntrinsicWidth()));
            }
            DJXSwipeBackLayout.this.mContentLeft = i;
            DJXSwipeBackLayout.this.mContentTop = i2;
            DJXSwipeBackLayout.this.invalidate();
            if (DJXSwipeBackLayout.this.mScrollPercent < DJXSwipeBackLayout.this.mScrollThreshold && !this.mIsScrollOverValid) {
                this.mIsScrollOverValid = true;
            }
            if (DJXSwipeBackLayout.this.mListeners != null && !DJXSwipeBackLayout.this.mListeners.isEmpty()) {
                Iterator it = DJXSwipeBackLayout.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((SwipeListener) it.next()).onScrollStateChange(DJXSwipeBackLayout.this.mDragHelper.getViewDragState(), DJXSwipeBackLayout.this.mScrollPercent);
                }
            }
            if (DJXSwipeBackLayout.this.mListeners != null && !DJXSwipeBackLayout.this.mListeners.isEmpty() && DJXSwipeBackLayout.this.mDragHelper.getViewDragState() == 1 && DJXSwipeBackLayout.this.mScrollPercent >= DJXSwipeBackLayout.this.mScrollThreshold && this.mIsScrollOverValid) {
                this.mIsScrollOverValid = false;
                Iterator it2 = DJXSwipeBackLayout.this.mListeners.iterator();
                while (it2.hasNext()) {
                    ((SwipeListener) it2.next()).onScrollOverThreshold();
                }
            }
            if (DJXSwipeBackLayout.this.mScrollPercent < 1.0f || DJXSwipeBackLayout.this.mListeners == null || DJXSwipeBackLayout.this.mListeners.isEmpty()) {
                return;
            }
            for (SwipeListener swipeListener : DJXSwipeBackLayout.this.mListeners) {
                if (swipeListener instanceof SwipeListenerEx) {
                    ((SwipeListenerEx) swipeListener).onContentViewSwipedBack();
                }
            }
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            int width = view.getWidth();
            int height = view.getHeight();
            int intrinsicWidth = 0;
            if ((DJXSwipeBackLayout.this.mTrackingEdge & 1) != 0) {
                i = 0;
                intrinsicWidth = (f > 0.0f || (f == 0.0f && DJXSwipeBackLayout.this.mScrollPercent > DJXSwipeBackLayout.this.mScrollThreshold)) ? width + DJXSwipeBackLayout.this.mShadowLeft.getIntrinsicWidth() + 10 : 0;
            } else if ((DJXSwipeBackLayout.this.mTrackingEdge & 2) != 0) {
                intrinsicWidth = (f < 0.0f || (f == 0.0f && DJXSwipeBackLayout.this.mScrollPercent > DJXSwipeBackLayout.this.mScrollThreshold)) ? -(width + DJXSwipeBackLayout.this.mShadowLeft.getIntrinsicWidth() + 10) : 0;
                i = 0;
            } else {
                i = ((DJXSwipeBackLayout.this.mTrackingEdge & 8) == 0 || (f2 >= 0.0f && (f2 != 0.0f || DJXSwipeBackLayout.this.mScrollPercent <= DJXSwipeBackLayout.this.mScrollThreshold))) ? 0 : -(height + DJXSwipeBackLayout.this.mShadowBottom.getIntrinsicHeight() + 10);
            }
            DJXSwipeBackLayout.this.mDragHelper.settleCapturedViewAt(intrinsicWidth, i);
            DJXSwipeBackLayout.this.invalidate();
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if ((DJXSwipeBackLayout.this.mTrackingEdge & 1) == 0) {
                if ((DJXSwipeBackLayout.this.mTrackingEdge & 2) != 0) {
                    return Math.min(0, Math.max(i, -view.getWidth()));
                }
                return 0;
            }
            return Math.min(view.getWidth(), Math.max(i, 0));
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            if ((DJXSwipeBackLayout.this.mTrackingEdge & 8) != 0) {
                return Math.min(0, Math.max(i, -view.getHeight()));
            }
            return 0;
        }

        @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            if (DJXSwipeBackLayout.this.mListeners == null || DJXSwipeBackLayout.this.mListeners.isEmpty()) {
                return;
            }
            Iterator it = DJXSwipeBackLayout.this.mListeners.iterator();
            while (it.hasNext()) {
                ((SwipeListener) it.next()).onScrollStateChange(i, DJXSwipeBackLayout.this.mScrollPercent);
            }
        }
    }
}
