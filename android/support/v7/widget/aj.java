package android.support.v7.widget;

import aegon.chrome.net.NetError;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.e.a.b;
import android.support.v7.d.a;
import android.support.v7.widget.aa;
import android.support.v7.widget.bb;
import android.support.v7.widget.bc;
import android.support.v7.widget.e;
import android.support.v7.widget.s;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class aj extends ViewGroup implements android.support.v4.e.i {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    ak mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    private m mActiveOnItemTouchListener;
    a mAdapter;
    android.support.v7.widget.e mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private d mChildDrawingOrderCallback;
    android.support.v7.widget.s mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    aa mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    boolean mIsAttached;
    f mItemAnimator;
    private f.a mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    i mLayout;
    boolean mLayoutFrozen;
    private int mLayoutOrScrollCounter;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final r mObserver;
    private List<k> mOnChildAttachStateListeners;
    private l mOnFlingListener;
    private final ArrayList<m> mOnItemTouchListeners;
    final List<x> mPendingAccessibilityImportanceChange;
    private s mPendingSavedState;
    boolean mPostedAnimatorRunner;
    aa.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final p mRecycler;
    q mRecyclerListener;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    final int[] mScrollConsumed;
    private n mScrollListener;
    private List<n> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    final int[] mScrollStepConsumed;
    private android.support.v4.e.j mScrollingChildHelper;
    final u mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final w mViewFlinger;
    private final bc.b mViewInfoProcessCallback;
    final bc mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    private static final int[] CLIP_TO_PADDING_ATTR = {R.attr.clipToPadding};

    public static abstract class c {
        public void I(int i, int i2) {
        }

        public void J(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
        }

        public void e(int i, int i2, int i3) {
        }

        public void onChanged() {
        }
    }

    public interface d {
        int dI();
    }

    public interface k {
    }

    public static abstract class l {
        public abstract boolean dV();
    }

    public interface m {
        boolean b(MotionEvent motionEvent);

        void c(MotionEvent motionEvent);
    }

    public static abstract class n {
        public void onScrollStateChanged(aj ajVar, int i) {
        }

        public void onScrolled(aj ajVar, int i, int i2) {
        }
    }

    public interface q {
    }

    public static abstract class v {
        public abstract View ej();
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    static {
        FORCE_INVALIDATE_DISPLAY_LIST = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new Interpolator() { // from class: android.support.v7.widget.aj.3
            @Override // android.animation.TimeInterpolator
            public final float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };
    }

    public aj(Context context) {
        this(context, null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aj(Context context, AttributeSet attributeSet, int i2) throws NoSuchMethodException, SecurityException {
        super(context, attributeSet, i2);
        this.mObserver = new r();
        this.mRecycler = new p();
        this.mViewInfoStore = new bc();
        this.mUpdateChildViewsRunnable = new Runnable() { // from class: android.support.v7.widget.aj.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!aj.this.mFirstLayoutComplete || aj.this.isLayoutRequested()) {
                    return;
                }
                if (!aj.this.mIsAttached) {
                    aj.this.requestLayout();
                } else if (aj.this.mLayoutFrozen) {
                    aj.this.mLayoutWasDefered = true;
                } else {
                    aj.this.consumePendingUpdateOperations();
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new e();
        this.mItemAnimator = new android.support.v7.widget.u();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new w();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new aa.a() : null;
        this.mState = new u();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mScrollStepConsumed = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: android.support.v7.widget.aj.2
            @Override // java.lang.Runnable
            public final void run() {
                if (aj.this.mItemAnimator != null) {
                    aj.this.mItemAnimator.cX();
                }
                aj.this.mPostedAnimatorRunner = false;
            }
        };
        this.mViewInfoProcessCallback = new bc.b() { // from class: android.support.v7.widget.aj.4
            @Override // android.support.v7.widget.bc.b
            public final void a(x xVar, f.b bVar, f.b bVar2) {
                aj.this.mRecycler.t(xVar);
                aj.this.animateDisappearance(xVar, bVar, bVar2);
            }

            @Override // android.support.v7.widget.bc.b
            public final void b(x xVar, f.b bVar, f.b bVar2) {
                aj.this.animateAppearance(xVar, bVar, bVar2);
            }

            @Override // android.support.v7.widget.bc.b
            public final void c(x xVar, f.b bVar, f.b bVar2) {
                xVar.setIsRecyclable(false);
                if (aj.this.mDataSetHasChangedAfterLayout) {
                    if (aj.this.mItemAnimator.a(xVar, xVar, bVar, bVar2)) {
                        aj.this.postAnimationRunner();
                    }
                } else if (aj.this.mItemAnimator.f(xVar, bVar, bVar2)) {
                    aj.this.postAnimationRunner();
                }
            }

            @Override // android.support.v7.widget.bc.b
            public final void g(x xVar) {
                aj.this.mLayout.removeAndRecycleView(xVar.itemView, aj.this.mRecycler);
            }
        };
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CLIP_TO_PADDING_ATTR, i2, 0);
            this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.mClipToPadding = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = android.support.v4.e.p.a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = android.support.v4.e.p.b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (android.support.v4.e.o.f(this) == 0) {
            android.support.v4.e.o.c(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new ak(this));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i2, 0);
            String string = typedArrayObtainStyledAttributes2.getString(a.b.RecyclerView_layoutManager);
            if (typedArrayObtainStyledAttributes2.getInt(a.b.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.mEnableFastScroller = typedArrayObtainStyledAttributes2.getBoolean(a.b.RecyclerView_fastScrollEnabled, false);
            if (this.mEnableFastScroller) {
                initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes2.getDrawable(a.b.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            typedArrayObtainStyledAttributes2.recycle();
            createLayoutManager(context, string, attributeSet, i2, 0);
            if (Build.VERSION.SDK_INT >= 21) {
                TypedArray typedArrayObtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
                boolean z2 = typedArrayObtainStyledAttributes3.getBoolean(0, true);
                typedArrayObtainStyledAttributes3.recycle();
                z = z2;
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    private void initAutofill() {
        if (android.support.v4.e.o.b(this) == 0) {
            android.support.v4.e.o.b(this, 8);
        }
    }

    public ak getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(ak akVar) {
        this.mAccessibilityDelegate = akVar;
        android.support.v4.e.o.a(this, this.mAccessibilityDelegate);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) throws NoSuchMethodException, SecurityException {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> clsAsSubclass = classLoader.loadClass(fullClassName).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return aj.class.getPackage().getName() + '.' + str;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new android.support.v7.widget.s(new s.b() { // from class: android.support.v7.widget.aj.5
            @Override // android.support.v7.widget.s.b
            public final int getChildCount() {
                return aj.this.getChildCount();
            }

            @Override // android.support.v7.widget.s.b
            public final void addView(View view, int i2) {
                aj.this.addView(view, i2);
                aj.this.dispatchChildAttached(view);
            }

            @Override // android.support.v7.widget.s.b
            public final int indexOfChild(View view) {
                return aj.this.indexOfChild(view);
            }

            @Override // android.support.v7.widget.s.b
            public final void removeViewAt(int i2) {
                View childAt = aj.this.getChildAt(i2);
                if (childAt != null) {
                    aj.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                aj.this.removeViewAt(i2);
            }

            @Override // android.support.v7.widget.s.b
            public final View getChildAt(int i2) {
                return aj.this.getChildAt(i2);
            }

            @Override // android.support.v7.widget.s.b
            public final void removeAllViews() {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    aj.this.dispatchChildDetached(childAt);
                    childAt.clearAnimation();
                }
                aj.this.removeAllViews();
            }

            @Override // android.support.v7.widget.s.b
            public final x getChildViewHolder(View view) {
                return aj.getChildViewHolderInt(view);
            }

            @Override // android.support.v7.widget.s.b
            public final void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                x childViewHolderInt = aj.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + aj.this.exceptionLabel());
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                }
                aj.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // android.support.v7.widget.s.b
            public final void detachViewFromParent(int i2) {
                x childViewHolderInt;
                View childAt = getChildAt(i2);
                if (childAt != null && (childViewHolderInt = aj.getChildViewHolderInt(childAt)) != null) {
                    if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + aj.this.exceptionLabel());
                    }
                    childViewHolderInt.addFlags(256);
                }
                aj.this.detachViewFromParent(i2);
            }

            @Override // android.support.v7.widget.s.b
            public final void I(View view) {
                x childViewHolderInt = aj.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onEnteredHiddenState(aj.this);
                }
            }

            @Override // android.support.v7.widget.s.b
            public final void J(View view) {
                x childViewHolderInt = aj.getChildViewHolderInt(view);
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(aj.this);
                }
            }
        });
    }

    void initAdapterManager() {
        this.mAdapterHelper = new android.support.v7.widget.e(new e.a() { // from class: android.support.v7.widget.aj.6
            @Override // android.support.v7.widget.e.a
            public final x Z(int i2) {
                x xVarFindViewHolderForPosition = aj.this.findViewHolderForPosition(i2, true);
                if (xVarFindViewHolderForPosition == null || aj.this.mChildHelper.E(xVarFindViewHolderForPosition.itemView)) {
                    return null;
                }
                return xVarFindViewHolderForPosition;
            }

            @Override // android.support.v7.widget.e.a
            public final void s(int i2, int i3) {
                aj.this.offsetPositionRecordsForRemove(i2, i3, true);
                aj ajVar = aj.this;
                ajVar.mItemsAddedOrRemoved = true;
                ajVar.mState.rZ += i3;
            }

            @Override // android.support.v7.widget.e.a
            public final void t(int i2, int i3) {
                aj.this.offsetPositionRecordsForRemove(i2, i3, false);
                aj.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.e.a
            public final void b(int i2, int i3, Object obj) {
                aj.this.viewRangeUpdate(i2, i3, obj);
                aj.this.mItemsChanged = true;
            }

            @Override // android.support.v7.widget.e.a
            public final void h(e.b bVar) {
                j(bVar);
            }

            private void j(e.b bVar) {
                int i2 = bVar.mb;
                if (i2 == 1) {
                    aj.this.mLayout.onItemsAdded(aj.this, bVar.mc, bVar.me);
                    return;
                }
                if (i2 == 2) {
                    aj.this.mLayout.onItemsRemoved(aj.this, bVar.mc, bVar.me);
                } else if (i2 == 4) {
                    aj.this.mLayout.onItemsUpdated(aj.this, bVar.mc, bVar.me, bVar.md);
                } else {
                    if (i2 != 8) {
                        return;
                    }
                    aj.this.mLayout.onItemsMoved(aj.this, bVar.mc, bVar.me, 1);
                }
            }

            @Override // android.support.v7.widget.e.a
            public final void i(e.b bVar) {
                j(bVar);
            }

            @Override // android.support.v7.widget.e.a
            public final void u(int i2, int i3) {
                aj.this.offsetPositionRecordsForInsert(i2, i3);
                aj.this.mItemsAddedOrRemoved = true;
            }

            @Override // android.support.v7.widget.e.a
            public final void v(int i2, int i3) {
                aj.this.offsetPositionRecordsForMove(i2, i3);
                aj.this.mItemsAddedOrRemoved = true;
            }
        });
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void swapAdapter(a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.cZ();
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.clear();
    }

    private void setAdapterInternal(a aVar, boolean z, boolean z2) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.reset();
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onAdapterChanged(aVar3, this.mAdapter);
        }
        this.mRecycler.a(aVar3, this.mAdapter, z);
        this.mState.sf = true;
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    public void setRecyclerListener(q qVar) {
        this.mRecyclerListener = qVar;
    }

    @Override // android.view.View
    public int getBaseline() {
        i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.getBaseline();
        }
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(k kVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(kVar);
    }

    public void removeOnChildAttachStateChangeListener(k kVar) {
        List<k> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(kVar);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            f fVar = this.mItemAnimator;
            if (fVar != null) {
                fVar.cZ();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.clear();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.clear();
        }
        this.mChildHelper.cU();
        this.mLayout = iVar;
        if (iVar != null) {
            if (iVar.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.mRecyclerView.exceptionLabel());
            }
            this.mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.dX();
        requestLayout();
    }

    public void setOnFlingListener(l lVar) {
        this.mOnFlingListener = lVar;
    }

    public l getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        s sVar = new s(super.onSaveInstanceState());
        s sVar2 = this.mPendingSavedState;
        if (sVar2 != null) {
            sVar.a(sVar2);
        } else {
            i iVar = this.mLayout;
            if (iVar != null) {
                sVar.rQ = iVar.onSaveInstanceState();
            } else {
                sVar.rQ = null;
            }
        }
        return sVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof s)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (s) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        if (this.mLayout == null || this.mPendingSavedState.rQ == null) {
            return;
        }
        this.mLayout.onRestoreInstanceState(this.mPendingSavedState.rQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void addAnimatingView(x xVar) {
        View view = xVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.t(getChildViewHolder(view));
        if (xVar.isTmpDetached()) {
            this.mChildHelper.a(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.a(view, true);
        } else {
            this.mChildHelper.F(view);
        }
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zH = this.mChildHelper.H(view);
        if (zH) {
            x childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.t(childViewHolderInt);
            this.mRecycler.s(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zH);
        return zH;
    }

    public i getLayoutManager() {
        return this.mLayout;
    }

    public o getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public void setRecycledViewPool(o oVar) {
        this.mRecycler.setRecycledViewPool(oVar);
    }

    public void setViewCacheExtension(v vVar) {
        this.mRecycler.setViewCacheExtension(vVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.as(i2);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void addItemDecoration(h hVar, int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i2, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addItemDecoration(h hVar) {
        addItemDecoration(hVar, -1);
    }

    public h getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        return this.mItemDecorations.get(i2);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeItemDecoration(h hVar) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = dVar;
        setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }

    @Deprecated
    public void setOnScrollListener(n nVar) {
        this.mScrollListener = nVar;
    }

    public void addOnScrollListener(n nVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(nVar);
    }

    public void removeOnScrollListener(n nVar) {
        List<n> list = this.mScrollListeners;
        if (list != null) {
            list.remove(nVar);
        }
    }

    public void clearOnScrollListeners() {
        List<n> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutFrozen) {
            return;
        }
        stopScroll();
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    void jumpToPositionForSmoothScroller(int i2) {
        i iVar = this.mLayout;
        if (iVar == null) {
            return;
        }
        iVar.scrollToPosition(i2);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutFrozen) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.smoothScrollToPosition(this, this.mState, i2);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutFrozen) {
            return;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i2 = 0;
            }
            if (!zCanScrollVertically) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        android.support.v4.os.a.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        android.support.v4.os.a.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            android.support.v4.os.a.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            android.support.v4.os.a.endSection();
            return;
        }
        if (this.mAdapterHelper.cA()) {
            if (this.mAdapterHelper.W(4) && !this.mAdapterHelper.W(11)) {
                android.support.v4.os.a.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.cy();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.cz();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                android.support.v4.os.a.endSection();
                return;
            }
            if (this.mAdapterHelper.cA()) {
                android.support.v4.os.a.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                android.support.v4.os.a.endSection();
            }
        }
    }

    private boolean hasUpdatedView() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            scrollStep(i2, i3, this.mScrollStepConsumed);
            int[] iArr = this.mScrollStepConsumed;
            int i8 = iArr[0];
            int i9 = iArr[1];
            i4 = i9;
            i7 = i8;
            i5 = i2 - i8;
            i6 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (dispatchNestedScroll(i7, i4, i5, i6, this.mScrollOffset, 0)) {
            int i11 = this.mLastTouchX;
            int[] iArr2 = this.mScrollOffset;
            this.mLastTouchX = i11 - iArr2[0];
            this.mLastTouchY -= iArr2[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation(iArr2[0], iArr2[1]);
            }
            int[] iArr3 = this.mNestedOffsets;
            int i12 = iArr3[0];
            int[] iArr4 = this.mScrollOffset;
            iArr3[0] = i12 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !android.support.v4.e.g.a(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i5, motionEvent.getY(), i6);
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i7 != 0 || i10 != 0) {
            dispatchOnScrolled(i7, i10);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i7 == 0 && i10 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth != 1 || this.mLayoutFrozen) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth <= 0) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutFrozen) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutFrozen && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutFrozen) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.mLayoutFrozen) {
            assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
            if (!z) {
                this.mLayoutFrozen = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutFrozen = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public boolean isLayoutFrozen() {
        return this.mLayoutFrozen;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutFrozen) {
            return;
        }
        if (!iVar.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.mViewFlinger.smoothScrollBy(i2, i3, interpolator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutFrozen) {
            return false;
        }
        int iCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (iCanScrollHorizontally == 0 || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = iCanScrollHorizontally != 0 || zCanScrollVertically;
            dispatchNestedFling(f2, f3, z);
            l lVar = this.mOnFlingListener;
            if (lVar != null && lVar.dV()) {
                return true;
            }
            if (z) {
                if (zCanScrollVertically) {
                    iCanScrollHorizontally = (iCanScrollHorizontally == true ? 1 : 0) | 2;
                }
                startNestedScroll(iCanScrollHorizontally, 1);
                int i4 = this.mMaxFlingVelocity;
                int iMax = Math.max(-i4, Math.min(i2, i4));
                int i5 = this.mMaxFlingVelocity;
                this.mViewFlinger.L(iMax, Math.max(-i5, Math.min(i3, i5)));
                return true;
            }
        }
        return false;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.stopSmoothScroller();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            android.support.v4.widget.e.a(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            android.support.v4.widget.e.a(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            android.support.v4.widget.e.a(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            android.support.v4.widget.e.a(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            android.support.v4.e.o.e(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.pullGlows(float, float, float, float):void");
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            android.support.v4.e.o.e(this);
        }
    }

    void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            android.support.v4.e.o.e(this);
        }
    }

    void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            this.mLeftGlow.onAbsorb(-i2);
        } else if (i2 > 0) {
            ensureRightGlow();
            this.mRightGlow.onAbsorb(i2);
        }
        if (i3 < 0) {
            ensureTopGlow();
            this.mTopGlow.onAbsorb(-i3);
        } else if (i3 > 0) {
            ensureBottomGlow();
            this.mBottomGlow.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        android.support.v4.e.o.e(this);
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = e.d(this);
        if (this.mClipToPadding) {
            this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mRightGlow = e.d(this);
        if (this.mClipToPadding) {
            this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mTopGlow = e.d(this);
        if (this.mClipToPadding) {
            this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mBottomGlow = e.d(this);
        if (this.mClipToPadding) {
            this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(e eVar) {
        android.support.v4.d.j.checkNotNull(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewOnFocusSearchFailed;
        boolean z;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutFrozen) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i2) ? viewOnFocusSearchFailed : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        if ((this.mTempRect.left < this.mTempRect2.left || this.mTempRect.right <= this.mTempRect2.left) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            i3 = ((this.mTempRect.right > this.mTempRect2.right || this.mTempRect.left >= this.mTempRect2.right) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        if ((this.mTempRect.top < this.mTempRect2.top || this.mTempRect.bottom <= this.mTempRect2.top) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            c2 = 1;
        } else if ((this.mTempRect.bottom <= this.mTempRect2.bottom && this.mTempRect.top < this.mTempRect2.bottom) || this.mTempRect.top <= this.mTempRect2.top) {
            c2 = 0;
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof j) {
            j jVar = (j) layoutParams;
            if (!jVar.rA) {
                Rect rect = jVar.pN;
                this.mTempRect.left -= rect.left;
                this.mTempRect.right += rect.right;
                this.mTempRect.top -= rect.top;
                this.mTempRect.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null || !iVar.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.mFirstLayoutComplete = r1
            android.support.v7.widget.aj$i r1 = r4.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r4)
        L1e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = android.support.v7.widget.aj.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L69
            java.lang.ThreadLocal<android.support.v7.widget.aa> r0 = android.support.v7.widget.aa.pt
            java.lang.Object r0 = r0.get()
            android.support.v7.widget.aa r0 = (android.support.v7.widget.aa) r0
            r4.mGapWorker = r0
            android.support.v7.widget.aa r0 = r4.mGapWorker
            if (r0 != 0) goto L64
            android.support.v7.widget.aa r0 = new android.support.v7.widget.aa
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = android.support.v4.e.o.r(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            android.support.v7.widget.aa r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.pw = r2
            java.lang.ThreadLocal<android.support.v7.widget.aa> r0 = android.support.v7.widget.aa.pt
            android.support.v7.widget.aa r1 = r4.mGapWorker
            r0.set(r1)
        L64:
            android.support.v7.widget.aa r0 = r4.mGapWorker
            r0.b(r4)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        aa aaVar;
        super.onDetachedFromWindow();
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.cZ();
        }
        stopScroll();
        this.mIsAttached = false;
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        bc.onDetach();
        if (!ALLOW_THREAD_GAP_WORK || (aaVar = this.mGapWorker) == null) {
            return;
        }
        aaVar.c(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(exceptionLabel()));
        }
    }

    public void addOnItemTouchListener(m mVar) {
        this.mOnItemTouchListeners.add(mVar);
    }

    public void removeOnItemTouchListener(m mVar) {
        this.mOnItemTouchListeners.remove(mVar);
        if (this.mActiveOnItemTouchListener == mVar) {
            this.mActiveOnItemTouchListener = null;
        }
    }

    private boolean dispatchOnItemTouchIntercept(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.mActiveOnItemTouchListener = null;
        }
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.mOnItemTouchListeners.get(i2);
            if (mVar.b(motionEvent) && action != 3) {
                this.mActiveOnItemTouchListener = mVar;
                return true;
            }
        }
        return false;
    }

    private boolean dispatchOnItemTouch(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        m mVar = this.mActiveOnItemTouchListener;
        if (mVar != null) {
            if (action == 0) {
                this.mActiveOnItemTouchListener = null;
            } else {
                mVar.c(motionEvent);
                if (action == 3 || action == 1) {
                    this.mActiveOnItemTouchListener = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.mOnItemTouchListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                m mVar2 = this.mOnItemTouchListeners.get(i2);
                if (mVar2.b(motionEvent)) {
                    this.mActiveOnItemTouchListener = mVar2;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutFrozen) {
            return false;
        }
        if (dispatchOnItemTouchIntercept(motionEvent)) {
            cancelTouch();
            return true;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zCanScrollHorizontally;
            if (zCanScrollVertically) {
                i2 = (zCanScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x3 - this.mInitialTouchX;
                int i4 = y2 - this.mInitialTouchY;
                if (zCanScrollHorizontally == 0 || Math.abs(i3) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x3;
                    z = true;
                }
                if (zCanScrollVertically && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelTouch();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0106  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void resetTouch() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelTouch() {
        resetTouch();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.support.v7.widget.aj$i r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutFrozen
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            android.support.v7.widget.aj$i r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            android.support.v7.widget.aj$i r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            android.support.v7.widget.aj$i r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            android.support.v7.widget.aj$i r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z = false;
        if (iVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.sb == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i2, i3);
            this.mState.sj = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.sj = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            if (this.mState.sl) {
                this.mState.sg = true;
            } else {
                this.mAdapterHelper.cB();
                this.mState.sg = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.sl) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        a aVar = this.mAdapter;
        if (aVar != null) {
            this.mState.se = aVar.getItemCount();
        } else {
            this.mState.se = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        stopInterceptRequestLayout(false);
        this.mState.sg = false;
    }

    void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(i.chooseSize(i2, getPaddingLeft() + getPaddingRight(), android.support.v4.e.o.j(this)), i.chooseSize(i3, getPaddingTop() + getPaddingBottom(), android.support.v4.e.o.k(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.cZ();
            this.mItemAnimator.a(null);
        }
        this.mItemAnimator = fVar;
        f fVar3 = this.mItemAnimator;
        if (fVar3 != null) {
            fVar3.a(this.mItemAnimatorListener);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter <= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(2048);
        android.support.v4.e.a.a.a(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iA = accessibilityEvent != null ? android.support.v4.e.a.a.a(accessibilityEvent) : 0;
        if (iA == 0) {
            iA = 0;
        }
        this.mEatenAccessibilityChangeFlags = iA | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public f getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        android.support.v4.e.o.a(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.reset();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.cy();
        } else {
            this.mAdapterHelper.cB();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.sk = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        u uVar = this.mState;
        if (uVar.sk && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        uVar.sl = z;
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        u uVar = this.mState;
        uVar.sj = false;
        if (uVar.sb == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (this.mAdapterHelper.cC() || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
        }
        dispatchLayoutStep3();
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        x xVarFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (xVarFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.sn = this.mAdapter.hasStableIds() ? xVarFindContainingViewHolder.getItemId() : -1L;
        u uVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = xVarFindContainingViewHolder.isRemoved() ? xVarFindContainingViewHolder.mOldPosition : xVarFindContainingViewHolder.getAdapterPosition();
        }
        uVar.sm = adapterPosition;
        this.mState.so = getDeepestFocusedViewWithId(xVarFindContainingViewHolder.itemView);
    }

    private void resetFocusInfo() {
        u uVar = this.mState;
        uVar.sn = -1L;
        uVar.sm = -1;
        uVar.so = -1;
    }

    private View findNextViewToFocus() {
        x xVarFindViewHolderForAdapterPosition;
        int i2 = this.mState.sm != -1 ? this.mState.sm : 0;
        int itemCount = this.mState.getItemCount();
        for (int i3 = i2; i3 < itemCount; i3++) {
            x xVarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (xVarFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (xVarFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return xVarFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(itemCount, i2);
        do {
            iMin--;
            if (iMin < 0 || (xVarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!xVarFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return xVarFindViewHolderForAdapterPosition.itemView;
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.getChildCount() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.E(focusedChild)) {
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        x xVarFindViewHolderForItemId = (this.mState.sn == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.sn);
        if (xVarFindViewHolderForItemId == null || this.mChildHelper.E(xVarFindViewHolderForItemId.itemView) || !xVarFindViewHolderForItemId.itemView.hasFocusable()) {
            if (this.mChildHelper.getChildCount() > 0) {
                viewFindNextViewToFocus = findNextViewToFocus();
            }
        } else {
            viewFindNextViewToFocus = xVarFindViewHolderForItemId.itemView;
        }
        if (viewFindNextViewToFocus != null) {
            if (this.mState.so == -1 || (viewFindViewById = viewFindNextViewToFocus.findViewById(this.mState.so)) == null || !viewFindViewById.isFocusable()) {
                viewFindViewById = viewFindNextViewToFocus;
            }
            viewFindViewById.requestFocus();
        }
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    final void fillRemainingScrollValues(u uVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.dH;
            uVar.sp = overScroller.getFinalX() - overScroller.getCurrX();
            uVar.sq = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            uVar.sp = 0;
            uVar.sq = 0;
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.aA(1);
        fillRemainingScrollValues(this.mState);
        this.mState.sj = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        u uVar = this.mState;
        uVar.sh = uVar.sk && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        u uVar2 = this.mState;
        uVar2.sg = uVar2.sl;
        this.mState.se = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.sk) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    f fVar = this.mItemAnimator;
                    f.j(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.a(childViewHolderInt, fVar.h(childViewHolderInt));
                    if (this.mState.sh && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.sl) {
            saveOldPositions();
            boolean z = this.mState.sf;
            u uVar3 = this.mState;
            uVar3.sf = false;
            this.mLayout.onLayoutChildren(this.mRecycler, uVar3);
            this.mState.sf = z;
            for (int i3 = 0; i3 < this.mChildHelper.getChildCount(); i3++) {
                x childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.B(childViewHolderInt2)) {
                    f.j(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    f fVar2 = this.mItemAnimator;
                    childViewHolderInt2.getUnmodifiedPayloads();
                    f.b bVarH = fVar2.h(childViewHolderInt2);
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, bVarH);
                    } else {
                        this.mViewInfoStore.b(childViewHolderInt2, bVarH);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.sb = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.aA(6);
        this.mAdapterHelper.cB();
        this.mState.se = this.mAdapter.getItemCount();
        u uVar = this.mState;
        uVar.rZ = 0;
        uVar.sg = false;
        this.mLayout.onLayoutChildren(this.mRecycler, uVar);
        u uVar2 = this.mState;
        uVar2.sf = false;
        this.mPendingSavedState = null;
        uVar2.sk = uVar2.sk && this.mItemAnimator != null;
        this.mState.sb = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.aA(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        u uVar = this.mState;
        uVar.sb = 1;
        if (uVar.sk) {
            for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
                x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(childCount));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    f.b bVarI = this.mItemAnimator.i(childViewHolderInt);
                    x xVarI = this.mViewInfoStore.i(changedHolderKey);
                    if (xVarI != null && !xVarI.shouldIgnore()) {
                        boolean zY = this.mViewInfoStore.y(xVarI);
                        boolean zY2 = this.mViewInfoStore.y(childViewHolderInt);
                        if (zY && xVarI == childViewHolderInt) {
                            this.mViewInfoStore.c(childViewHolderInt, bVarI);
                        } else {
                            f.b bVarZ = this.mViewInfoStore.z(xVarI);
                            this.mViewInfoStore.c(childViewHolderInt, bVarI);
                            f.b bVarA = this.mViewInfoStore.A(childViewHolderInt);
                            if (bVarZ == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, xVarI);
                            } else {
                                animateChange(xVarI, childViewHolderInt, bVarZ, bVarA, zY, zY2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.c(childViewHolderInt, bVarI);
                    }
                }
            }
            this.mViewInfoStore.a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        u uVar2 = this.mState;
        uVar2.rY = uVar2.se;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        u uVar3 = this.mState;
        uVar3.sk = false;
        uVar3.sl = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.rJ != null) {
            this.mRecycler.rJ.clear();
        }
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch) {
            i iVar = this.mLayout;
            iVar.mPrefetchMaxCountObserved = 0;
            iVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.dX();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long j2, x xVar, x xVar2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
            if (childViewHolderInt != xVar && getChangedHolderKey(childViewHolderInt) == j2) {
                a aVar = this.mAdapter;
                if (aVar != null && aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + xVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + xVar + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + xVar2 + " cannot be found but it is necessary for " + xVar + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(x xVar, f.b bVar) {
        xVar.setFlags(0, 8192);
        if (this.mState.sh && xVar.isUpdated() && !xVar.isRemoved() && !xVar.shouldIgnore()) {
            this.mViewInfoStore.a(getChangedHolderKey(xVar), xVar);
        }
        this.mViewInfoStore.a(xVar, bVar);
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    long getChangedHolderKey(x xVar) {
        return this.mAdapter.hasStableIds() ? xVar.getItemId() : xVar.mPosition;
    }

    void animateAppearance(x xVar, f.b bVar, f.b bVar2) {
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.e(xVar, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(x xVar, f.b bVar, f.b bVar2) {
        addAnimatingView(xVar);
        xVar.setIsRecyclable(false);
        if (this.mItemAnimator.d(xVar, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    private void animateChange(x xVar, x xVar2, f.b bVar, f.b bVar2, boolean z, boolean z2) {
        xVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(xVar);
        }
        if (xVar != xVar2) {
            if (z2) {
                addAnimatingView(xVar2);
            }
            xVar.mShadowedHolder = xVar2;
            addAnimatingView(xVar);
            this.mRecycler.t(xVar);
            xVar2.setIsRecyclable(false);
            xVar2.mShadowingHolder = xVar;
        }
        if (this.mItemAnimator.a(xVar, xVar2, bVar, bVar2)) {
            postAnimationRunner();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        android.support.v4.os.a.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        android.support.v4.os.a.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutFrozen) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    void markItemDecorInsetsDirty() {
        int iCV = this.mChildHelper.cV();
        for (int i2 = 0; i2 < iCV; i2++) {
            ((j) this.mChildHelper.af(i2).getLayoutParams()).rA = true;
        }
        this.mRecycler.markItemDecorInsetsDirty();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(iSave4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.isRunning()) {
            z2 = true;
        }
        if (z2) {
            android.support.v4.e.o.e(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof j) && this.mLayout.checkLayoutParams((j) layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.mLayout;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
        }
        return iVar.generateLayoutParams(layoutParams);
    }

    public boolean isAnimating() {
        f fVar = this.mItemAnimator;
        return fVar != null && fVar.isRunning();
    }

    void saveOldPositions() {
        int iCV = this.mChildHelper.cV();
        for (int i2 = 0; i2 < iCV; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    void clearOldPositions() {
        int iCV = this.mChildHelper.cV();
        for (int i2 = 0; i2 < iCV; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.clearOldPositions();
    }

    void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iCV = this.mChildHelper.cV();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < iCV; i7++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i7));
            if (childViewHolderInt != null && childViewHolderInt.mPosition >= i5 && childViewHolderInt.mPosition <= i4) {
                if (childViewHolderInt.mPosition == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.sf = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForMove(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForInsert(int i2, int i3) {
        int iCV = this.mChildHelper.cV();
        for (int i4 = 0; i4 < iCV; i4++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.sf = true;
            }
        }
        this.mRecycler.offsetPositionRecordsForInsert(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int iCV = this.mChildHelper.cV();
        for (int i5 = 0; i5 < iCV; i5++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                if (childViewHolderInt.mPosition >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z);
                    this.mState.sf = true;
                } else if (childViewHolderInt.mPosition >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z);
                    this.mState.sf = true;
                }
            }
        }
        this.mRecycler.offsetPositionRecordsForRemove(i2, i3, z);
        requestLayout();
    }

    void viewRangeUpdate(int i2, int i3, Object obj) {
        int iCV = this.mChildHelper.cV();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < iCV; i5++) {
            View viewAf = this.mChildHelper.af(i5);
            x childViewHolderInt = getChildViewHolderInt(viewAf);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2 && childViewHolderInt.mPosition < i4) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((j) viewAf.getLayoutParams()).rA = true;
            }
        }
        this.mRecycler.K(i2, i3);
    }

    boolean canReuseUpdatedViewHolder(x xVar) {
        f fVar = this.mItemAnimator;
        return fVar == null || fVar.a(xVar, xVar.getUnmodifiedPayloads());
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int iCV = this.mChildHelper.cV();
        for (int i2 = 0; i2 < iCV; i2++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public x getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public x findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    static x getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((j) view.getLayoutParams()).rz;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public int getChildAdapterPosition(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    public int getChildLayoutPosition(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    public long getChildItemId(View view) {
        x childViewHolderInt;
        a aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    @Deprecated
    public x findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public x findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public x findViewHolderForAdapterPosition(int i2) {
        x xVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iCV = this.mChildHelper.cV();
        for (int i3 = 0; i3 < iCV; i3++) {
            x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.E(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                xVar = childViewHolderInt;
            }
        }
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    android.support.v7.widget.aj.x findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            android.support.v7.widget.s r0 = r5.mChildHelper
            int r0 = r0.cV()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L39
            android.support.v7.widget.s r3 = r5.mChildHelper
            android.view.View r3 = r3.af(r2)
            android.support.v7.widget.aj$x r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L36
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L36
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L29
            goto L36
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 != r6) goto L36
        L29:
            android.support.v7.widget.s r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.E(r4)
            if (r1 == 0) goto L35
            r1 = r3
            goto L36
        L35:
            return r3
        L36:
            int r2 = r2 + 1
            goto L8
        L39:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.findViewHolderForPosition(int, boolean):android.support.v7.widget.aj$x");
    }

    public x findViewHolderForItemId(long j2) {
        a aVar = this.mAdapter;
        x xVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int iCV = this.mChildHelper.cV();
            for (int i2 = 0; i2 < iCV; i2++) {
                x childViewHolderInt = getChildViewHolderInt(this.mChildHelper.af(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.E(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    xVar = childViewHolderInt;
                }
            }
        }
        return xVar;
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getLeft() + translationX && f2 <= childAt.getRight() + translationX && f3 >= childAt.getTop() + translationY && f3 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void offsetChildrenVertical(int i2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.mChildHelper.getChildAt(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetChildrenHorizontal(int i2) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            this.mChildHelper.getChildAt(i3).offsetLeftAndRight(i2);
        }
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        j jVar = (j) view.getLayoutParams();
        Rect rect2 = jVar.pN;
        rect.set((view.getLeft() - rect2.left) - jVar.leftMargin, (view.getTop() - rect2.top) - jVar.topMargin, view.getRight() + rect2.right + jVar.rightMargin, view.getBottom() + rect2.bottom + jVar.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View view) {
        j jVar = (j) view.getLayoutParams();
        if (!jVar.rA) {
            return jVar.pN;
        }
        if (this.mState.ef() && (jVar.dT() || jVar.dR())) {
            return jVar.pN;
        }
        Rect rect = jVar.pN;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            rect.left += this.mTempRect.left;
            rect.top += this.mTempRect.top;
            rect.right += this.mTempRect.right;
            rect.bottom += this.mTempRect.bottom;
        }
        jVar.rA = false;
        return rect;
    }

    void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        onScrolled(i2, i3);
        n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrolled(this, i2, i3);
        }
        List<n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        n nVar = this.mScrollListener;
        if (nVar != null) {
            nVar.onScrollStateChanged(this, i2);
        }
        List<n> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.cA();
    }

    class w implements Runnable {
        OverScroller dH;
        private int sr;
        private int ss;
        Interpolator mInterpolator = aj.sQuinticInterpolator;
        private boolean st = false;
        private boolean su = false;

        w() {
            this.dH = new OverScroller(aj.this.getContext(), aj.sQuinticInterpolator);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e5  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ec  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00f5  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 422
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.w.run():void");
        }

        private void ek() {
            this.su = false;
            this.st = true;
        }

        private void el() {
            this.st = false;
            if (this.su) {
                em();
            }
        }

        final void em() {
            if (this.st) {
                this.su = true;
            } else {
                aj.this.removeCallbacks(this);
                android.support.v4.e.o.a(aj.this, this);
            }
        }

        public final void L(int i, int i2) {
            aj.this.setScrollState(2);
            this.ss = 0;
            this.sr = 0;
            this.dH.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            em();
        }

        public final void smoothScrollBy(int i, int i2) {
            c(i, i2, 0, 0);
        }

        private void c(int i, int i2, int i3, int i4) {
            f(i, i2, d(i, i2, 0, 0));
        }

        private static float f(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int d(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            aj ajVar = aj.this;
            int width = z ? ajVar.getWidth() : ajVar.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float f3 = f2 + (f(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(f3 / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public final void f(int i, int i2, int i3) {
            b(i, i2, i3, aj.sQuinticInterpolator);
        }

        public final void smoothScrollBy(int i, int i2, Interpolator interpolator) {
            int iD = d(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = aj.sQuinticInterpolator;
            }
            b(i, i2, iD, interpolator);
        }

        public final void b(int i, int i2, int i3, Interpolator interpolator) {
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.dH = new OverScroller(aj.this.getContext(), interpolator);
            }
            aj.this.setScrollState(2);
            this.ss = 0;
            this.sr = 0;
            this.dH.startScroll(0, 0, i, i2, i3);
            if (Build.VERSION.SDK_INT < 23) {
                this.dH.computeScrollOffset();
            }
            em();
        }

        public final void stop() {
            aj.this.removeCallbacks(this);
            this.dH.abortAnimation();
        }
    }

    void repositionShadowingViews() {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.mChildHelper.getChildAt(i2);
            x childViewHolder = getChildViewHolder(childAt);
            if (childViewHolder != null && childViewHolder.mShadowingHolder != null) {
                View view = childViewHolder.mShadowingHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    class r extends c {
        r() {
        }

        @Override // android.support.v7.widget.aj.c
        public final void onChanged() {
            aj.this.assertNotInLayoutOrScroll(null);
            aj.this.mState.sf = true;
            aj.this.processDataSetCompletelyChanged(true);
            if (aj.this.mAdapterHelper.cA()) {
                return;
            }
            aj.this.requestLayout();
        }

        @Override // android.support.v7.widget.aj.c
        public final void c(int i, int i2, Object obj) {
            aj.this.assertNotInLayoutOrScroll(null);
            if (aj.this.mAdapterHelper.a(i, i2, obj)) {
                ec();
            }
        }

        @Override // android.support.v7.widget.aj.c
        public final void I(int i, int i2) {
            aj.this.assertNotInLayoutOrScroll(null);
            if (aj.this.mAdapterHelper.q(i, i2)) {
                ec();
            }
        }

        @Override // android.support.v7.widget.aj.c
        public final void J(int i, int i2) {
            aj.this.assertNotInLayoutOrScroll(null);
            if (aj.this.mAdapterHelper.r(i, i2)) {
                ec();
            }
        }

        @Override // android.support.v7.widget.aj.c
        public final void e(int i, int i2, int i3) {
            aj.this.assertNotInLayoutOrScroll(null);
            if (aj.this.mAdapterHelper.d(i, i2, 1)) {
                ec();
            }
        }

        private void ec() {
            if (aj.POST_UPDATES_ON_ANIMATION && aj.this.mHasFixedSize && aj.this.mIsAttached) {
                aj ajVar = aj.this;
                android.support.v4.e.o.a(ajVar, ajVar.mUpdateChildViewsRunnable);
            } else {
                aj ajVar2 = aj.this;
                ajVar2.mAdapterUpdateDuringMeasure = true;
                ajVar2.requestLayout();
            }
        }
    }

    public static class e {
        protected static EdgeEffect d(aj ajVar) {
            return new EdgeEffect(ajVar.getContext());
        }
    }

    public static class o {
        SparseArray<a> rC = new SparseArray<>();
        private int rD = 0;

        static class a {
            final ArrayList<x> rE = new ArrayList<>();
            int rF = 5;
            long rG = 0;
            long rH = 0;

            a() {
            }
        }

        private void clear() {
            for (int i = 0; i < this.rC.size(); i++) {
                this.rC.valueAt(i).rE.clear();
            }
        }

        public final x aq(int i) {
            a aVar = this.rC.get(i);
            if (aVar == null || aVar.rE.isEmpty()) {
                return null;
            }
            return aVar.rE.remove(r2.size() - 1);
        }

        public final void o(x xVar) {
            int itemViewType = xVar.getItemViewType();
            ArrayList<x> arrayList = ar(itemViewType).rE;
            if (this.rC.get(itemViewType).rF <= arrayList.size()) {
                return;
            }
            xVar.resetInternal();
            arrayList.add(xVar);
        }

        private static long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        final void a(int i, long j) {
            a aVarAr = ar(i);
            aVarAr.rG = a(aVarAr.rG, j);
        }

        final void b(int i, long j) {
            a aVarAr = ar(i);
            aVarAr.rH = a(aVarAr.rH, j);
        }

        final boolean a(int i, long j, long j2) {
            long j3 = ar(i).rG;
            return j3 == 0 || j + j3 < j2;
        }

        final boolean b(int i, long j, long j2) {
            long j3 = ar(i).rH;
            return j3 == 0 || j + j3 < j2;
        }

        final void dW() {
            this.rD++;
        }

        final void detach() {
            this.rD--;
        }

        final void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                detach();
            }
            if (!z && this.rD == 0) {
                clear();
            }
            if (aVar2 != null) {
                dW();
            }
        }

        private a ar(int i) {
            a aVar = this.rC.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.rC.put(i, aVar2);
            return aVar2;
        }
    }

    static aj findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof aj) {
            return (aj) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            aj ajVarFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (ajVarFindNestedRecyclerView != null) {
                return ajVarFindNestedRecyclerView;
            }
        }
        return null;
    }

    static void clearNestedRecyclerViewIfNotNested(x xVar) {
        if (xVar.mNestedRecyclerView != null) {
            aj ajVar = xVar.mNestedRecyclerView.get();
            while (ajVar != null) {
                if (ajVar == xVar.itemView) {
                    return;
                }
                Object parent = ajVar.getParent();
                ajVar = parent instanceof View ? (View) parent : null;
            }
            xVar.mNestedRecyclerView = null;
        }
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public final class p {
        final ArrayList<x> rI = new ArrayList<>();
        ArrayList<x> rJ = null;
        final ArrayList<x> rK = new ArrayList<>();
        private final List<x> rL = Collections.unmodifiableList(this.rI);
        private int rM = 2;
        int rN = 2;
        o rO;
        private v rP;

        public p() {
        }

        public final void clear() {
            this.rI.clear();
            dZ();
        }

        public final void as(int i) {
            this.rM = i;
            dX();
        }

        final void dX() {
            this.rN = this.rM + (aj.this.mLayout != null ? aj.this.mLayout.mPrefetchMaxCountObserved : 0);
            for (int size = this.rK.size() - 1; size >= 0 && this.rK.size() > this.rN; size--) {
                av(size);
            }
        }

        public final List<x> dY() {
            return this.rL;
        }

        private boolean p(x xVar) {
            if (xVar.isRemoved()) {
                return aj.this.mState.ef();
            }
            if (xVar.mPosition < 0 || xVar.mPosition >= aj.this.mAdapter.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + xVar + aj.this.exceptionLabel());
            }
            if (aj.this.mState.ef() || aj.this.mAdapter.getItemViewType(xVar.mPosition) == xVar.getItemViewType()) {
                return !aj.this.mAdapter.hasStableIds() || xVar.getItemId() == aj.this.mAdapter.getItemId(xVar.mPosition);
            }
            return false;
        }

        private boolean a(x xVar, int i, int i2, long j) {
            xVar.mOwnerRecyclerView = aj.this;
            int itemViewType = xVar.getItemViewType();
            long nanoTime = aj.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.rO.b(itemViewType, nanoTime, j)) {
                return false;
            }
            aj.this.mAdapter.bindViewHolder(xVar, i);
            this.rO.b(xVar.getItemViewType(), aj.this.getNanoTime() - nanoTime);
            q(xVar);
            if (!aj.this.mState.ef()) {
                return true;
            }
            xVar.mPreLayoutPosition = i2;
            return true;
        }

        public final int at(int i) {
            if (i >= 0 && i < aj.this.mState.getItemCount()) {
                return !aj.this.mState.ef() ? i : aj.this.mAdapterHelper.X(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + aj.this.mState.getItemCount() + aj.this.exceptionLabel());
        }

        public final View au(int i) {
            return c(i, false);
        }

        private View c(int i, boolean z) {
            return a(i, false, Long.MAX_VALUE).itemView;
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x021a A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x021d  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0179 A[PHI: r1 r4
  0x0179: PHI (r1v12 android.support.v7.widget.aj$x) = (r1v11 android.support.v7.widget.aj$x), (r1v29 android.support.v7.widget.aj$x) binds: [B:28:0x005d, B:58:0x00fb] A[DONT_GENERATE, DONT_INLINE]
  0x0179: PHI (r4v3 boolean) = (r4v2 boolean), (r4v6 boolean) binds: [B:28:0x005d, B:58:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01f0  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x01fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        final android.support.v7.widget.aj.x a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 598
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.p.a(int, boolean, long):android.support.v7.widget.aj$x");
        }

        private void q(x xVar) {
            if (aj.this.isAccessibilityEnabled()) {
                View view = xVar.itemView;
                if (android.support.v4.e.o.f(view) == 0) {
                    android.support.v4.e.o.c(view, 1);
                }
                if (android.support.v4.e.o.c(view)) {
                    return;
                }
                xVar.addFlags(16384);
                android.support.v4.e.o.a(view, aj.this.mAccessibilityDelegate.en());
            }
        }

        private void r(x xVar) {
            if (xVar.itemView instanceof ViewGroup) {
                a((ViewGroup) xVar.itemView, false);
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public final void U(View view) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                aj.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            s(childViewHolderInt);
        }

        private void dZ() {
            for (int size = this.rK.size() - 1; size >= 0; size--) {
                av(size);
            }
            this.rK.clear();
            if (aj.ALLOW_THREAD_GAP_WORK) {
                aj.this.mPrefetchRegistry.dn();
            }
        }

        private void av(int i) {
            a(this.rK.get(i), true);
            this.rK.remove(i);
        }

        final void s(x xVar) {
            boolean z;
            if (xVar.isScrap() || xVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(xVar.isScrap());
                sb.append(" isAttached:");
                sb.append(xVar.itemView.getParent() != null);
                sb.append(aj.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (xVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + xVar + aj.this.exceptionLabel());
            }
            if (xVar.shouldIgnore()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + aj.this.exceptionLabel());
            }
            boolean zDoesTransientStatePreventRecycling = xVar.doesTransientStatePreventRecycling();
            if ((aj.this.mAdapter != null && zDoesTransientStatePreventRecycling && aj.this.mAdapter.onFailedToRecycleView(xVar)) || xVar.isRecyclable()) {
                if (this.rN <= 0 || xVar.hasAnyOfTheFlags(MediaPlayer.MEDIA_PLAYER_OPTION_AVOUTSYNC_MAX_DIFF)) {
                    z = false;
                } else {
                    int size = this.rK.size();
                    if (size >= this.rN && size > 0) {
                        av(0);
                        size--;
                    }
                    if (aj.ALLOW_THREAD_GAP_WORK && size > 0 && !aj.this.mPrefetchRegistry.aj(xVar.mPosition)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!aj.this.mPrefetchRegistry.aj(this.rK.get(i).mPosition)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.rK.add(size, xVar);
                    z = true;
                }
                if (!z) {
                    a(xVar, true);
                    z = true;
                }
            } else {
                z = false;
            }
            aj.this.mViewInfoStore.E(xVar);
            if (z || z || !zDoesTransientStatePreventRecycling) {
                return;
            }
            xVar.mOwnerRecyclerView = null;
        }

        final void a(x xVar, boolean z) {
            aj.clearNestedRecyclerViewIfNotNested(xVar);
            if (xVar.hasAnyOfTheFlags(16384)) {
                xVar.setFlags(0, 16384);
                android.support.v4.e.o.a(xVar.itemView, (android.support.v4.e.b) null);
            }
            if (z) {
                u(xVar);
            }
            xVar.mOwnerRecyclerView = null;
            getRecycledViewPool().o(xVar);
        }

        final void V(View view) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            s(childViewHolderInt);
        }

        final void W(View view) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            if (childViewHolderInt.hasAnyOfTheFlags(12) || !childViewHolderInt.isUpdated() || aj.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !aj.this.mAdapter.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + aj.this.exceptionLabel());
                }
                childViewHolderInt.setScrapContainer(this, false);
                this.rI.add(childViewHolderInt);
                return;
            }
            if (this.rJ == null) {
                this.rJ = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.rJ.add(childViewHolderInt);
        }

        final void t(x xVar) {
            if (xVar.mInChangeScrap) {
                this.rJ.remove(xVar);
            } else {
                this.rI.remove(xVar);
            }
            xVar.mScrapContainer = null;
            xVar.mInChangeScrap = false;
            xVar.clearReturnedFromScrapFlag();
        }

        final int ea() {
            return this.rI.size();
        }

        final View aw(int i) {
            return this.rI.get(i).itemView;
        }

        final void eb() {
            this.rI.clear();
            ArrayList<x> arrayList = this.rJ;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        private x ax(int i) {
            int size;
            int iX;
            ArrayList<x> arrayList = this.rJ;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    x xVar = this.rJ.get(i2);
                    if (!xVar.wasReturnedFromScrap() && xVar.getLayoutPosition() == i) {
                        xVar.addFlags(32);
                        return xVar;
                    }
                }
                if (aj.this.mAdapter.hasStableIds() && (iX = aj.this.mAdapterHelper.X(i)) > 0 && iX < aj.this.mAdapter.getItemCount()) {
                    long itemId = aj.this.mAdapter.getItemId(iX);
                    for (int i3 = 0; i3 < size; i3++) {
                        x xVar2 = this.rJ.get(i3);
                        if (!xVar2.wasReturnedFromScrap() && xVar2.getItemId() == itemId) {
                            xVar2.addFlags(32);
                            return xVar2;
                        }
                    }
                }
            }
            return null;
        }

        private x d(int i, boolean z) {
            View viewAe;
            int size = this.rI.size();
            for (int i2 = 0; i2 < size; i2++) {
                x xVar = this.rI.get(i2);
                if (!xVar.wasReturnedFromScrap() && xVar.getLayoutPosition() == i && !xVar.isInvalid() && (aj.this.mState.sg || !xVar.isRemoved())) {
                    xVar.addFlags(32);
                    return xVar;
                }
            }
            if (!z && (viewAe = aj.this.mChildHelper.ae(i)) != null) {
                x childViewHolderInt = aj.getChildViewHolderInt(viewAe);
                aj.this.mChildHelper.G(viewAe);
                int iIndexOfChild = aj.this.mChildHelper.indexOfChild(viewAe);
                if (iIndexOfChild == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + aj.this.exceptionLabel());
                }
                aj.this.mChildHelper.detachViewFromParent(iIndexOfChild);
                W(viewAe);
                childViewHolderInt.addFlags(AVMDLDataLoader.KeyIsEnableSpeedEngine);
                return childViewHolderInt;
            }
            int size2 = this.rK.size();
            for (int i3 = 0; i3 < size2; i3++) {
                x xVar2 = this.rK.get(i3);
                if (!xVar2.isInvalid() && xVar2.getLayoutPosition() == i) {
                    if (!z) {
                        this.rK.remove(i3);
                    }
                    return xVar2;
                }
            }
            return null;
        }

        private x a(long j, int i, boolean z) {
            for (int size = this.rI.size() - 1; size >= 0; size--) {
                x xVar = this.rI.get(size);
                if (xVar.getItemId() == j && !xVar.wasReturnedFromScrap()) {
                    if (i == xVar.getItemViewType()) {
                        xVar.addFlags(32);
                        if (xVar.isRemoved() && !aj.this.mState.ef()) {
                            xVar.setFlags(2, 14);
                        }
                        return xVar;
                    }
                    if (!z) {
                        this.rI.remove(size);
                        aj.this.removeDetachedView(xVar.itemView, false);
                        V(xVar.itemView);
                    }
                }
            }
            int size2 = this.rK.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                x xVar2 = this.rK.get(size2);
                if (xVar2.getItemId() == j) {
                    if (i == xVar2.getItemViewType()) {
                        if (!z) {
                            this.rK.remove(size2);
                        }
                        return xVar2;
                    }
                    if (!z) {
                        av(size2);
                        return null;
                    }
                }
            }
        }

        private void u(x xVar) {
            if (aj.this.mAdapter != null) {
                aj.this.mAdapter.onViewRecycled(xVar);
            }
            if (aj.this.mState != null) {
                aj.this.mViewInfoStore.E(xVar);
            }
        }

        final void a(a aVar, a aVar2, boolean z) {
            clear();
            getRecycledViewPool().a(aVar, aVar2, z);
        }

        final void offsetPositionRecordsForMove(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.rK.size();
            for (int i6 = 0; i6 < size; i6++) {
                x xVar = this.rK.get(i6);
                if (xVar != null && xVar.mPosition >= i4 && xVar.mPosition <= i3) {
                    if (xVar.mPosition == i) {
                        xVar.offsetPosition(i2 - i, false);
                    } else {
                        xVar.offsetPosition(i5, false);
                    }
                }
            }
        }

        final void offsetPositionRecordsForInsert(int i, int i2) {
            int size = this.rK.size();
            for (int i3 = 0; i3 < size; i3++) {
                x xVar = this.rK.get(i3);
                if (xVar != null && xVar.mPosition >= i) {
                    xVar.offsetPosition(i2, true);
                }
            }
        }

        final void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.rK.size() - 1; size >= 0; size--) {
                x xVar = this.rK.get(size);
                if (xVar != null) {
                    if (xVar.mPosition >= i3) {
                        xVar.offsetPosition(-i2, z);
                    } else if (xVar.mPosition >= i) {
                        xVar.addFlags(8);
                        av(size);
                    }
                }
            }
        }

        final void setViewCacheExtension(v vVar) {
            this.rP = vVar;
        }

        final void setRecycledViewPool(o oVar) {
            o oVar2 = this.rO;
            if (oVar2 != null) {
                oVar2.detach();
            }
            this.rO = oVar;
            if (this.rO == null || aj.this.getAdapter() == null) {
                return;
            }
            this.rO.dW();
        }

        final o getRecycledViewPool() {
            if (this.rO == null) {
                this.rO = new o();
            }
            return this.rO;
        }

        final void K(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.rK.size() - 1; size >= 0; size--) {
                x xVar = this.rK.get(size);
                if (xVar != null && (i3 = xVar.mPosition) >= i && i3 < i4) {
                    xVar.addFlags(2);
                    av(size);
                }
            }
        }

        final void markKnownViewsInvalid() {
            int size = this.rK.size();
            for (int i = 0; i < size; i++) {
                x xVar = this.rK.get(i);
                if (xVar != null) {
                    xVar.addFlags(6);
                    xVar.addChangePayload(null);
                }
            }
            if (aj.this.mAdapter == null || !aj.this.mAdapter.hasStableIds()) {
                dZ();
            }
        }

        final void clearOldPositions() {
            int size = this.rK.size();
            for (int i = 0; i < size; i++) {
                this.rK.get(i).clearOldPosition();
            }
            int size2 = this.rI.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.rI.get(i2).clearOldPosition();
            }
            ArrayList<x> arrayList = this.rJ;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.rJ.get(i3).clearOldPosition();
                }
            }
        }

        final void markItemDecorInsetsDirty() {
            int size = this.rK.size();
            for (int i = 0; i < size; i++) {
                j jVar = (j) this.rK.get(i).itemView.getLayoutParams();
                if (jVar != null) {
                    jVar.rA = true;
                }
            }
        }
    }

    public static abstract class a<VH extends x> {
        private final b mObservable = new b();
        private boolean mHasStableIds = false;

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public void onAttachedToRecyclerView(aj ajVar) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(aj ajVar) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                android.support.v4.os.a.beginSection(aj.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, i);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i;
                return vh;
            } finally {
                android.support.v4.os.a.endSection();
            }
        }

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            android.support.v4.os.a.beginSection(aj.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof j) {
                ((j) layoutParams).rA = true;
            }
            android.support.v4.os.a.endSection();
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }
    }

    void dispatchChildDetached(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size);
            }
        }
    }

    void dispatchChildAttached(View view) {
        x childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<k> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size);
            }
        }
    }

    public static abstract class i {
        android.support.v7.widget.s mChildHelper;
        private int mHeight;
        private int mHeightMode;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        aj mRecyclerView;
        t mSmoothScroller;
        private int mWidth;
        private int mWidthMode;
        private final bb.b mHorizontalBoundCheckCallback = new bb.b() { // from class: android.support.v7.widget.aj.i.1
            @Override // android.support.v7.widget.bb.b
            public final View getChildAt(int i) {
                return i.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.bb.b
            public final int dP() {
                return i.this.getPaddingLeft();
            }

            @Override // android.support.v7.widget.bb.b
            public final int dQ() {
                return i.this.getWidth() - i.this.getPaddingRight();
            }

            @Override // android.support.v7.widget.bb.b
            public final int S(View view) {
                return i.this.getDecoratedLeft(view) - ((j) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.bb.b
            public final int T(View view) {
                return i.this.getDecoratedRight(view) + ((j) view.getLayoutParams()).rightMargin;
            }
        };
        private final bb.b mVerticalBoundCheckCallback = new bb.b() { // from class: android.support.v7.widget.aj.i.2
            @Override // android.support.v7.widget.bb.b
            public final View getChildAt(int i) {
                return i.this.getChildAt(i);
            }

            @Override // android.support.v7.widget.bb.b
            public final int dP() {
                return i.this.getPaddingTop();
            }

            @Override // android.support.v7.widget.bb.b
            public final int dQ() {
                return i.this.getHeight() - i.this.getPaddingBottom();
            }

            @Override // android.support.v7.widget.bb.b
            public final int S(View view) {
                return i.this.getDecoratedTop(view) - ((j) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.bb.b
            public final int T(View view) {
                return i.this.getDecoratedBottom(view) + ((j) view.getLayoutParams()).bottomMargin;
            }
        };
        bb mHorizontalBoundCheck = new bb(this.mHorizontalBoundCheckCallback);
        bb mVerticalBoundCheck = new bb(this.mVerticalBoundCheckCallback);
        boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        public interface a {
            void A(int i, int i2);
        }

        public static class b {
            public int orientation;
            public boolean rx;
            public boolean ry;
            public int spanCount;
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(j jVar) {
            return jVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, u uVar, a aVar) {
        }

        public void collectInitialPrefetchPositions(int i, a aVar) {
        }

        public int computeHorizontalScrollExtent(u uVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(u uVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(u uVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(u uVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(u uVar) {
            return 0;
        }

        public int computeVerticalScrollRange(u uVar) {
            return 0;
        }

        public abstract j generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getSelectionModeForAccessibility(p pVar, u uVar) {
            return 0;
        }

        public boolean isLayoutHierarchical(p pVar, u uVar) {
            return false;
        }

        public void onAdapterChanged(a aVar, a aVar2) {
        }

        public boolean onAddFocusables(aj ajVar, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(aj ajVar) {
        }

        @Deprecated
        public void onDetachedFromWindow(aj ajVar) {
        }

        public View onFocusSearchFailed(View view, int i, p pVar, u uVar) {
            return null;
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(aj ajVar, int i, int i2) {
        }

        public void onItemsChanged(aj ajVar) {
        }

        public void onItemsMoved(aj ajVar, int i, int i2, int i3) {
        }

        public void onItemsRemoved(aj ajVar, int i, int i2) {
        }

        public void onItemsUpdated(aj ajVar, int i, int i2) {
        }

        public void onLayoutCompleted(u uVar) {
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityActionForItem(p pVar, u uVar, View view, int i, Bundle bundle) {
            return false;
        }

        public int scrollHorizontallyBy(int i, p pVar, u uVar) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, p pVar, u uVar) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        void setRecyclerView(aj ajVar) {
            if (ajVar == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = ajVar;
                this.mChildHelper = ajVar.mChildHelper;
                this.mWidth = ajVar.getWidth();
                this.mHeight = ajVar.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.mWidthMode = View.MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && !aj.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.mHeightMode = View.MeasureSpec.getMode(i2);
            if (this.mHeightMode != 0 || aj.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                if (rect.left < i3) {
                    i3 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i6) {
                    i6 = rect.bottom;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i4, i5, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void requestLayout() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                ajVar.requestLayout();
            }
        }

        public void assertInLayoutOrScroll(String str) {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                ajVar.assertInLayoutOrScroll(str);
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void assertNotInLayoutOrScroll(String str) {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                ajVar.assertNotInLayoutOrScroll(str);
            }
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                aj ajVar = this.mRecyclerView;
                if (ajVar != null) {
                    ajVar.mRecycler.dX();
                }
            }
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(aj ajVar) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(ajVar);
        }

        void dispatchDetachedFromWindow(aj ajVar, p pVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(ajVar, pVar);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable runnable) {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                android.support.v4.e.o.a(ajVar, runnable);
            }
        }

        public boolean removeCallbacks(Runnable runnable) {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return ajVar.removeCallbacks(runnable);
            }
            return false;
        }

        public void onDetachedFromWindow(aj ajVar, p pVar) {
            onDetachedFromWindow(ajVar);
        }

        public boolean getClipToPadding() {
            aj ajVar = this.mRecyclerView;
            return ajVar != null && ajVar.mClipToPadding;
        }

        public void onLayoutChildren(p pVar, u uVar) {
            Log.e(aj.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof j) {
                return new j((j) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new j((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new j(layoutParams);
        }

        public j generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new j(context, attributeSet);
        }

        public void smoothScrollToPosition(aj ajVar, u uVar, int i) {
            Log.e(aj.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(t tVar) {
            t tVar2 = this.mSmoothScroller;
            if (tVar2 != null && tVar != tVar2 && tVar2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = tVar;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            t tVar = this.mSmoothScroller;
            return tVar != null && tVar.isRunning();
        }

        public int getLayoutDirection() {
            return android.support.v4.e.o.g(this.mRecyclerView);
        }

        public void endAnimation(View view) {
            if (this.mRecyclerView.mItemAnimator != null) {
                this.mRecyclerView.mItemAnimator.e(aj.getChildViewHolderInt(view));
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        private void addViewInt(View view, int i, boolean z) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.C(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.D(childViewHolderInt);
            }
            j jVar = (j) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iIndexOfChild = this.mChildHelper.indexOfChild(view);
                if (i == -1) {
                    i = this.mChildHelper.getChildCount();
                }
                if (iIndexOfChild == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iIndexOfChild != i) {
                    this.mRecyclerView.mLayout.moveView(iIndexOfChild, i);
                }
            } else {
                this.mChildHelper.a(view, i, false);
                jVar.rA = true;
                t tVar = this.mSmoothScroller;
                if (tVar != null && tVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (jVar.rB) {
                childViewHolderInt.itemView.invalidate();
                jVar.rB = false;
            }
        }

        public void removeView(View view) {
            this.mChildHelper.removeView(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.removeViewAt(i);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public int getPosition(View view) {
            return ((j) view.getLayoutParams()).dU();
        }

        public int getItemViewType(View view) {
            return aj.getChildViewHolderInt(view).getItemViewType();
        }

        public View findContainingItemView(View view) {
            View viewFindContainingItemView;
            aj ajVar = this.mRecyclerView;
            if (ajVar == null || (viewFindContainingItemView = ajVar.findContainingItemView(view)) == null || this.mChildHelper.E(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                x childViewHolderInt = aj.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.ef() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public void detachView(View view) {
            int iIndexOfChild = this.mChildHelper.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                detachViewInternal(iIndexOfChild, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.detachViewFromParent(i);
        }

        public void attachView(View view, int i, j jVar) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.C(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.D(childViewHolderInt);
            }
            this.mChildHelper.a(view, i, jVar, childViewHolderInt.isRemoved());
        }

        public void attachView(View view, int i) {
            attachView(view, i, (j) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
            }
            detachViewAt(i);
            attachView(childAt, i2);
        }

        public void detachAndScrapView(View view, p pVar) {
            scrapOrRecycleView(pVar, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, p pVar) {
            scrapOrRecycleView(pVar, i, getChildAt(i));
        }

        public void removeAndRecycleView(View view, p pVar) {
            removeView(view);
            pVar.U(view);
        }

        public void removeAndRecycleViewAt(int i, p pVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            pVar.U(childAt);
        }

        public int getChildCount() {
            android.support.v7.widget.s sVar = this.mChildHelper;
            if (sVar != null) {
                return sVar.getChildCount();
            }
            return 0;
        }

        public View getChildAt(int i) {
            android.support.v7.widget.s sVar = this.mChildHelper;
            if (sVar != null) {
                return sVar.getChildAt(i);
            }
            return null;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return ajVar.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingTop() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return ajVar.getPaddingTop();
            }
            return 0;
        }

        public int getPaddingRight() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return ajVar.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingBottom() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return ajVar.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingStart() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return android.support.v4.e.o.h(ajVar);
            }
            return 0;
        }

        public int getPaddingEnd() {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                return android.support.v4.e.o.i(ajVar);
            }
            return 0;
        }

        public boolean isFocused() {
            aj ajVar = this.mRecyclerView;
            return ajVar != null && ajVar.isFocused();
        }

        public boolean hasFocus() {
            aj ajVar = this.mRecyclerView;
            return ajVar != null && ajVar.hasFocus();
        }

        public View getFocusedChild() {
            View focusedChild;
            aj ajVar = this.mRecyclerView;
            if (ajVar == null || (focusedChild = ajVar.getFocusedChild()) == null || this.mChildHelper.E(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getItemCount() {
            aj ajVar = this.mRecyclerView;
            a adapter = ajVar != null ? ajVar.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public void offsetChildrenHorizontal(int i) {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                ajVar.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            aj ajVar = this.mRecyclerView;
            if (ajVar != null) {
                ajVar.offsetChildrenVertical(i);
            }
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            aj ajVar = this.mRecyclerView;
            if (parent != ajVar || ajVar.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.E(childViewHolderInt);
        }

        public void stopIgnoringView(View view) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void detachAndScrapAttachedViews(p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(pVar, childCount, getChildAt(childCount));
            }
        }

        private void scrapOrRecycleView(p pVar, int i, View view) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                pVar.s(childViewHolderInt);
            } else {
                detachViewAt(i);
                pVar.W(view);
                this.mRecyclerView.mViewInfoStore.F(childViewHolderInt);
            }
        }

        void removeAndRecycleScrapInt(p pVar) {
            int iEa = pVar.ea();
            for (int i = iEa - 1; i >= 0; i--) {
                View viewAw = pVar.aw(i);
                x childViewHolderInt = aj.getChildViewHolderInt(viewAw);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(viewAw, false);
                    }
                    if (this.mRecyclerView.mItemAnimator != null) {
                        this.mRecyclerView.mItemAnimator.e(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    pVar.V(viewAw);
                }
            }
            pVar.eb();
            if (iEa > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void measureChild(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        boolean shouldReMeasureChild(View view, int i, int i2, j jVar) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, jVar.width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, jVar.height)) ? false : true;
        }

        boolean shouldMeasureChild(View view, int i, int i2, j jVar) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, jVar.width) && isMeasurementUpToDate(view.getHeight(), i2, jVar.height)) ? false : true;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            j jVar = (j) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + jVar.leftMargin + jVar.rightMargin + i3, jVar.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + jVar.topMargin + jVar.bottomMargin + i4, jVar.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, jVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        
            if (r3 >= 0) goto L8;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r1 = 0
                goto L1e
            Lf:
                if (r3 < 0) goto L15
            L11:
                r1 = r3
            L12:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L1e
            L15:
                r4 = -1
                if (r3 != r4) goto L19
                goto L12
            L19:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.i.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x002e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2e
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2e
                if (r5 == r3) goto L21
                goto L2e
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r6 = 1073741824(0x40000000, float:2.0)
                goto L2f
            L1f:
                if (r7 != r1) goto L24
            L21:
                r7 = r4
                r6 = r5
                goto L2f
            L24:
                if (r7 != r0) goto L2e
                if (r5 == r2) goto L2a
                if (r5 != r3) goto L2c
            L2a:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
            L2c:
                r7 = r4
                goto L2f
            L2e:
                r7 = 0
            L2f:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.aj.i.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((j) view.getLayoutParams()).pN;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((j) view.getLayoutParams()).pN;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((j) view.getLayoutParams()).pN;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            j jVar = (j) view.getLayoutParams();
            Rect rect = jVar.pN;
            view.layout(i + rect.left + jVar.leftMargin, i2 + rect.top + jVar.topMargin, (i3 - rect.right) - jVar.rightMargin, (i4 - rect.bottom) - jVar.bottomMargin);
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((j) view.getLayoutParams()).pN;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            aj.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            aj ajVar = this.mRecyclerView;
            if (ajVar == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(ajVar.getItemDecorInsetsForChild(view));
            }
        }

        public int getTopDecorationHeight(View view) {
            return ((j) view.getLayoutParams()).pN.top;
        }

        public int getBottomDecorationHeight(View view) {
            return ((j) view.getLayoutParams()).pN.bottom;
        }

        public int getLeftDecorationWidth(View view) {
            return ((j) view.getLayoutParams()).pN.left;
        }

        public int getRightDecorationWidth(View view) {
            return ((j) view.getLayoutParams()).pN.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(aj ajVar, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - width;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean requestChildRectangleOnScreen(aj ajVar, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(ajVar, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(aj ajVar, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(ajVar, view, rect, z);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(ajVar, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                ajVar.scrollBy(i, i2);
            } else {
                ajVar.smoothScrollBy(i, i2);
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.j(view, 24579) && this.mVerticalBoundCheck.j(view, 24579);
            return z ? z3 : !z3;
        }

        private boolean isFocusedChildVisibleAfterScrolling(aj ajVar, int i, int i2) {
            View focusedChild = ajVar.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        @Deprecated
        public boolean onRequestChildFocus(aj ajVar, View view, View view2) {
            return isSmoothScrolling() || ajVar.isComputingLayout();
        }

        public boolean onRequestChildFocus(aj ajVar, u uVar, View view, View view2) {
            return onRequestChildFocus(ajVar, view, view2);
        }

        public void onItemsUpdated(aj ajVar, int i, int i2, Object obj) {
            onItemsUpdated(ajVar, i, i2);
        }

        public void onMeasure(p pVar, u uVar, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public int getMinimumWidth() {
            return android.support.v4.e.o.j(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return android.support.v4.e.o.k(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            t tVar = this.mSmoothScroller;
            if (tVar != null) {
                tVar.stop();
            }
        }

        void onSmoothScrollerStopped(t tVar) {
            if (this.mSmoothScroller == tVar) {
                this.mSmoothScroller = null;
            }
        }

        public void removeAndRecycleAllViews(p pVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!aj.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, pVar);
                }
            }
        }

        void onInitializeAccessibilityNodeInfo(android.support.v4.e.a.b bVar) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, bVar);
        }

        public void onInitializeAccessibilityNodeInfo(p pVar, u uVar, android.support.v4.e.a.b bVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                bVar.addAction(8192);
                bVar.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                bVar.addAction(4096);
                bVar.setScrollable(true);
            }
            bVar.l(b.a.a(getRowCountForAccessibility(pVar, uVar), getColumnCountForAccessibility(pVar, uVar), isLayoutHierarchical(pVar, uVar), getSelectionModeForAccessibility(pVar, uVar)));
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(p pVar, u uVar, AccessibilityEvent accessibilityEvent) {
            aj ajVar = this.mRecyclerView;
            if (ajVar == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!ajVar.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            if (this.mRecyclerView.mAdapter != null) {
                accessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            }
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, android.support.v4.e.a.b bVar) {
            x childViewHolderInt = aj.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.E(childViewHolderInt.itemView)) {
                return;
            }
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, bVar);
        }

        public void onInitializeAccessibilityNodeInfoForItem(p pVar, u uVar, View view, android.support.v4.e.a.b bVar) {
            bVar.m(b.C0008b.a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int getRowCountForAccessibility(p pVar, u uVar) {
            aj ajVar = this.mRecyclerView;
            if (ajVar == null || ajVar.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getColumnCountForAccessibility(p pVar, u uVar) {
            aj ajVar = this.mRecyclerView;
            if (ajVar == null || ajVar.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        boolean performAccessibilityAction(int i, Bundle bundle) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityAction(p pVar, u uVar, int i, Bundle bundle) {
            int height;
            int width;
            aj ajVar = this.mRecyclerView;
            if (ajVar == null) {
                return false;
            }
            if (i != 4096) {
                if (i != 8192) {
                    height = 0;
                } else {
                    height = ajVar.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                    if (this.mRecyclerView.canScrollHorizontally(-1)) {
                        width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    }
                }
            } else {
                height = ajVar.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                width = this.mRecyclerView.canScrollHorizontally(1) ? (getWidth() - getPaddingLeft()) - getPaddingRight() : 0;
            }
            if (height == 0 && width == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(width, height);
            return true;
        }

        boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, view, i, bundle);
        }

        public static b getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.b.RecyclerView, i, i2);
            bVar.orientation = typedArrayObtainStyledAttributes.getInt(a.b.RecyclerView_android_orientation, 1);
            bVar.spanCount = typedArrayObtainStyledAttributes.getInt(a.b.RecyclerView_spanCount, 1);
            bVar.rx = typedArrayObtainStyledAttributes.getBoolean(a.b.RecyclerView_reverseLayout, false);
            bVar.ry = typedArrayObtainStyledAttributes.getBoolean(a.b.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        void setExactMeasureSpecsFrom(aj ajVar) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(ajVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ajVar.getHeight(), 1073741824));
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public static abstract class h {
        @Deprecated
        public void onDraw(Canvas canvas, aj ajVar) {
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, aj ajVar) {
        }

        public void onDraw(Canvas canvas, aj ajVar, u uVar) {
            onDraw(canvas, ajVar);
        }

        public void onDrawOver(Canvas canvas, aj ajVar, u uVar) {
            onDrawOver(canvas, ajVar);
        }

        @Deprecated
        public void getItemOffsets(Rect rect, int i, aj ajVar) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, aj ajVar, u uVar) {
            getItemOffsets(rect, ((j) view.getLayoutParams()).dU(), ajVar);
        }
    }

    public static abstract class x {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        WeakReference<aj> mNestedRecyclerView;
        aj mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        x mShadowedHolder = null;
        x mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        p mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public x(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((j) this.itemView.getLayoutParams()).rA = true;
            }
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getAdapterPosition() {
            aj ajVar = this.mOwnerRecyclerView;
            if (ajVar == null) {
                return -1;
            }
            return ajVar.getAdapterPositionFor(this);
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        void unScrap() {
            this.mScrapContainer.t(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        }

        void setScrapContainer(p pVar, boolean z) {
            this.mScrapContainer = pVar;
            this.mInChangeScrap = z;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ (-1)));
        }

        void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list == null || list.size() == 0) {
                    return FULLUPDATE_PAYLOADS;
                }
                return this.mUnmodifiedPayloads;
            }
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            aj.clearNestedRecyclerViewIfNotNested(this);
        }

        void onEnteredHiddenState(aj ajVar) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = android.support.v4.e.o.f(this.itemView);
            }
            ajVar.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(aj ajVar) {
            ajVar.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            this.mIsRecyclableCount = z ? i - 1 : i + 1;
            int i2 = this.mIsRecyclableCount;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !android.support.v4.e.o.d(this.itemView);
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && android.support.v4.e.o.d(this.itemView);
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }
    }

    boolean setChildImportantForAccessibilityInternal(x xVar, int i2) {
        if (isComputingLayout()) {
            xVar.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(xVar);
            return false;
        }
        android.support.v4.e.o.c(xVar.itemView, i2);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            x xVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (xVar.itemView.getParent() == this && !xVar.shouldIgnore() && (i2 = xVar.mPendingAccessibilityState) != -1) {
                android.support.v4.e.o.c(xVar.itemView, i2);
                xVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionFor(x xVar) {
        if (xVar.hasAnyOfTheFlags(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_STREAM_DURATION) || !xVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.Y(xVar.mPosition);
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new android.support.v7.widget.x(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(a.C0015a.fastscroll_default_thickness), resources.getDimensionPixelSize(a.C0015a.fastscroll_minimum_range), resources.getDimensionPixelOffset(a.C0015a.fastscroll_margin));
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().startNestedScroll(i2);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().startNestedScroll(i2, i3);
    }

    @Override // android.view.View, android.support.v4.e.h
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().stopNestedScroll(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().hasNestedScrollingParent(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().dispatchNestedScroll(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().dispatchNestedPreFling(f2, f3);
    }

    public static class j extends ViewGroup.MarginLayoutParams {
        final Rect pN;
        boolean rA;
        boolean rB;
        x rz;

        public j(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.pN = new Rect();
            this.rA = true;
            this.rB = false;
        }

        public j(int i, int i2) {
            super(i, i2);
            this.pN = new Rect();
            this.rA = true;
            this.rB = false;
        }

        public j(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.pN = new Rect();
            this.rA = true;
            this.rB = false;
        }

        public j(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.pN = new Rect();
            this.rA = true;
            this.rB = false;
        }

        public j(j jVar) {
            super((ViewGroup.LayoutParams) jVar);
            this.pN = new Rect();
            this.rA = true;
            this.rB = false;
        }

        public final boolean dR() {
            return this.rz.isInvalid();
        }

        public final boolean dS() {
            return this.rz.isRemoved();
        }

        public final boolean dT() {
            return this.rz.isUpdated();
        }

        public final int dU() {
            return this.rz.getLayoutPosition();
        }
    }

    public static abstract class t {
        private i mLayoutManager;
        private boolean mPendingInitialRun;
        private aj mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final a mRecyclingAction = new a(0, 0);

        public interface b {
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void onSeekTargetStep(int i, int i2, u uVar, a aVar);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, u uVar, a aVar);

        void start(aj ajVar, i iVar) {
            if (this.mStarted) {
                Log.w(aj.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = ajVar;
            this.mLayoutManager = iVar;
            if (this.mTargetPosition == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.em();
            this.mStarted = true;
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(aj.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public i getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        void onAnimation(int i, int i2) {
            PointF pointFComputeScrollVectorForPosition;
            aj ajVar = this.mRecyclerView;
            if (!this.mRunning || this.mTargetPosition == -1 || ajVar == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (pointFComputeScrollVectorForPosition.x != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f)) {
                ajVar.scrollStep((int) Math.signum(pointFComputeScrollVectorForPosition.x), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, ajVar.mState, this.mRecyclingAction);
                    this.mRecyclingAction.e(ajVar);
                    stop();
                } else {
                    Log.e(aj.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, ajVar.mState, this.mRecyclingAction);
                boolean zEd = this.mRecyclingAction.ed();
                this.mRecyclingAction.e(ajVar);
                if (zEd) {
                    if (this.mRunning) {
                        this.mPendingInitialRun = true;
                        ajVar.mViewFlinger.em();
                    } else {
                        stop();
                    }
                }
            }
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected void normalize(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        public static class a {
            private Interpolator mInterpolator;
            private int rR;
            private int rS;
            private int rT;
            private int rU;
            private boolean rV;
            private int rW;

            public a(int i, int i2) {
                this(0, 0, Integer.MIN_VALUE, null);
            }

            private a(int i, int i2, int i3, Interpolator interpolator) {
                this.rU = -1;
                this.rV = false;
                this.rW = 0;
                this.rR = i;
                this.rS = i2;
                this.rT = Integer.MIN_VALUE;
                this.mInterpolator = null;
            }

            public final void az(int i) {
                this.rU = i;
            }

            final boolean ed() {
                return this.rU >= 0;
            }

            final void e(aj ajVar) {
                int i = this.rU;
                if (i >= 0) {
                    this.rU = -1;
                    ajVar.jumpToPositionForSmoothScroller(i);
                    this.rV = false;
                } else {
                    if (this.rV) {
                        ee();
                        if (this.mInterpolator == null) {
                            if (this.rT == Integer.MIN_VALUE) {
                                ajVar.mViewFlinger.smoothScrollBy(this.rR, this.rS);
                            } else {
                                ajVar.mViewFlinger.f(this.rR, this.rS, this.rT);
                            }
                        } else {
                            ajVar.mViewFlinger.b(this.rR, this.rS, this.rT, this.mInterpolator);
                        }
                        this.rW++;
                        if (this.rW > 10) {
                            Log.e(aj.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.rV = false;
                        return;
                    }
                    this.rW = 0;
                }
            }

            private void ee() {
                if (this.mInterpolator != null && this.rT <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.rT <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public final void a(int i, int i2, int i3, Interpolator interpolator) {
                this.rR = i;
                this.rS = i2;
                this.rT = i3;
                this.mInterpolator = interpolator;
                this.rV = true;
            }
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public final boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).onChanged();
            }
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, null);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).c(i, i2, obj);
            }
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).I(i, i2);
            }
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).J(i, i2);
            }
        }

        public final void notifyItemMoved(int i, int i2) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((c) this.mObservers.get(size)).e(i, i2, 1);
            }
        }
    }

    public static class s extends android.support.v4.e.a {
        public static final Parcelable.Creator<s> CREATOR = new Parcelable.ClassLoaderCreator<s>() { // from class: android.support.v7.widget.aj.s.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return d(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ s createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return ay(i);
            }

            private static s b(Parcel parcel, ClassLoader classLoader) {
                return new s(parcel, classLoader);
            }

            private static s d(Parcel parcel) {
                return new s(parcel, null);
            }

            private static s[] ay(int i) {
                return new s[i];
            }
        };
        Parcelable rQ;

        s(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.rQ = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        s(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.e.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.rQ, 0);
        }

        final void a(s sVar) {
            this.rQ = sVar.rQ;
        }
    }

    public static class u {
        private SparseArray<Object> rX;
        int sm;
        long sn;
        int so;
        int sp;
        int sq;
        int mTargetPosition = -1;
        int rY = 0;
        int rZ = 0;
        int sb = 1;
        int se = 0;
        boolean sf = false;
        boolean sg = false;
        boolean sh = false;
        boolean sj = false;
        boolean sk = false;
        boolean sl = false;

        final void aA(int i) {
            if ((this.sb & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.sb));
        }

        final void a(a aVar) {
            this.sb = 1;
            this.se = aVar.getItemCount();
            this.sg = false;
            this.sh = false;
            this.sj = false;
        }

        public final boolean ef() {
            return this.sg;
        }

        public final boolean eg() {
            return this.sl;
        }

        public final int eh() {
            return this.mTargetPosition;
        }

        public final boolean ei() {
            return this.mTargetPosition != -1;
        }

        public final int getItemCount() {
            return this.sg ? this.rY - this.rZ : this.se;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.rX + ", mItemCount=" + this.se + ", mIsMeasuring=" + this.sj + ", mPreviousLayoutItemCount=" + this.rY + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.rZ + ", mStructureChanged=" + this.sf + ", mInPreLayout=" + this.sg + ", mRunSimpleAnimations=" + this.sk + ", mRunPredictiveAnimations=" + this.sl + '}';
        }
    }

    class g implements f.a {
        g() {
        }

        @Override // android.support.v7.widget.aj.f.a
        public final void l(x xVar) {
            xVar.setIsRecyclable(true);
            if (xVar.mShadowedHolder != null && xVar.mShadowingHolder == null) {
                xVar.mShadowedHolder = null;
            }
            xVar.mShadowingHolder = null;
            if (xVar.shouldBeKeptAsChild() || aj.this.removeAnimatingView(xVar.itemView) || !xVar.isTmpDetached()) {
                return;
            }
            aj.this.removeDetachedView(xVar.itemView, false);
        }
    }

    public static abstract class f {
        private a rq = null;
        private ArrayList<Object> rr = new ArrayList<>();
        private long rs = 120;
        private long rt = 120;
        private long ru = 250;
        private long rv = 250;

        interface a {
            void l(x xVar);
        }

        public abstract boolean a(x xVar, x xVar2, b bVar, b bVar2);

        public abstract void cX();

        public abstract void cZ();

        public boolean canReuseUpdatedViewHolder(x xVar) {
            return true;
        }

        public abstract boolean d(x xVar, b bVar, b bVar2);

        public abstract void e(x xVar);

        public abstract boolean e(x xVar, b bVar, b bVar2);

        public abstract boolean f(x xVar, b bVar, b bVar2);

        public abstract boolean isRunning();

        public final long dJ() {
            return this.ru;
        }

        public final long dK() {
            return this.rs;
        }

        public final long dL() {
            return this.rt;
        }

        public final long dM() {
            return this.rv;
        }

        final void a(a aVar) {
            this.rq = aVar;
        }

        public final b h(x xVar) {
            return dO().m(xVar);
        }

        public final b i(x xVar) {
            return dO().m(xVar);
        }

        static int j(x xVar) {
            int i = xVar.mFlags & 14;
            if (xVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = xVar.getOldPosition();
            int adapterPosition = xVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        public final void k(x xVar) {
            a aVar = this.rq;
            if (aVar != null) {
                aVar.l(xVar);
            }
        }

        public boolean a(x xVar, List<Object> list) {
            return canReuseUpdatedViewHolder(xVar);
        }

        public final void dN() {
            int size = this.rr.size();
            for (int i = 0; i < size; i++) {
                this.rr.get(i);
            }
            this.rr.clear();
        }

        private static b dO() {
            return new b();
        }

        public static class b {
            public int bottom;
            public int left;
            public int right;
            public int top;

            public final b m(x xVar) {
                return n(xVar);
            }

            private b n(x xVar) {
                View view = xVar.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.mChildDrawingOrderCallback;
        if (dVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return dVar.dI();
    }

    private android.support.v4.e.j getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new android.support.v4.e.j(this);
        }
        return this.mScrollingChildHelper;
    }
}
