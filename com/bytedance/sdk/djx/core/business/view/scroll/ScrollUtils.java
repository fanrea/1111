package com.bytedance.sdk.djx.core.business.view.scroll;

import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.view.scroll.DJXScrollerLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ScrollUtils {
    private static final Rect mBounds = new Rect();

    ScrollUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int computeVerticalScrollOffset(View view) {
        View scrolledView = getScrolledView(view);
        if (scrolledView instanceof ScrollingView) {
            return ((ScrollingView) scrolledView).computeVerticalScrollOffset();
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(scrolledView, new Object[0]);
            if (objInvoke != null) {
                return ((Integer) objInvoke).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrolledView.getScrollY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int computeVerticalScrollRange(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View scrolledView = getScrolledView(view);
        if (scrolledView instanceof ScrollingView) {
            return ((ScrollingView) scrolledView).computeVerticalScrollRange();
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(scrolledView, new Object[0]);
            if (objInvoke != null) {
                return ((Integer) objInvoke).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrolledView.getHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int computeVerticalScrollExtent(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        View scrolledView = getScrolledView(view);
        if (scrolledView instanceof ScrollingView) {
            return ((ScrollingView) scrolledView).computeVerticalScrollExtent();
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(scrolledView, new Object[0]);
            if (objInvoke != null) {
                return ((Integer) objInvoke).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrolledView.getHeight();
    }

    static int getScrollTopOffset(View view) {
        if (isConsecutiveScrollerChild(view) && canScrollVertically(view, -1)) {
            return Math.min(-computeVerticalScrollOffset(view), -1);
        }
        return 0;
    }

    static int getScrollBottomOffset(View view) {
        if (isConsecutiveScrollerChild(view) && canScrollVertically(view, 1)) {
            return Math.max((computeVerticalScrollRange(view) - computeVerticalScrollOffset(view)) - computeVerticalScrollExtent(view), 1);
        }
        return 0;
    }

    static boolean canScrollVertically(View view) {
        return isConsecutiveScrollerChild(view) && (canScrollVertically(view, 1) || canScrollVertically(view, -1));
    }

    static boolean canScrollVertically(View view, int i) {
        View scrolledView = getScrolledView(view);
        if (scrolledView.getVisibility() == 8) {
            return false;
        }
        if (scrolledView instanceof AbsListView) {
            AbsListView absListView = (AbsListView) scrolledView;
            if (Build.VERSION.SDK_INT >= 19) {
                return absListView.canScrollList(i);
            }
            return false;
        }
        if (scrolledView instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) scrolledView;
            if ((recyclerView.canScrollHorizontally(1) || recyclerView.canScrollVertically(-1)) && !recyclerView.canScrollVertically(i)) {
                return false;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (layoutManager != null && adapter != null && adapter.getItemCount() > 0) {
                if (layoutManager.findViewByPosition(i > 0 ? adapter.getItemCount() - 1 : 0) == null) {
                    return true;
                }
                int childCount = recyclerView.getChildCount();
                if (i > 0) {
                    for (int i2 = childCount - 1; i2 >= 0; i2--) {
                        View childAt = recyclerView.getChildAt(i2);
                        Rect rect = mBounds;
                        recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                        if (rect.bottom > recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                            return true;
                        }
                    }
                    return false;
                }
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = recyclerView.getChildAt(i3);
                    Rect rect2 = mBounds;
                    recyclerView.getDecoratedBoundsWithMargins(childAt2, rect2);
                    if (rect2.top < recyclerView.getPaddingTop()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return scrolledView.canScrollVertically(i);
    }

    static List<View> getTouchViews(View view, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        addTouchViews(arrayList, view, i, i2);
        return arrayList;
    }

    private static void addTouchViews(List<View> list, View view, int i, int i2) {
        if (isConsecutiveScrollerChild(view) && isTouchPointInView(view, i, i2)) {
            list.add(view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    addTouchViews(list, viewGroup.getChildAt(i3), i, i2);
                }
            }
        }
    }

    static boolean isTouchPointInView(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i >= i3 && i <= view.getMeasuredWidth() + i3 && i2 >= i4 && i2 <= view.getMeasuredHeight() + i4;
    }

    static int getRawX(View view, MotionEvent motionEvent, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return (int) motionEvent.getRawX(i);
            }
            view.getLocationOnScreen(new int[2]);
            return (int) (r1[0] + motionEvent.getX(i));
        } catch (Throwable unused) {
            return 0;
        }
    }

    static int getRawY(View view, MotionEvent motionEvent, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return (int) motionEvent.getRawY(i);
            }
            view.getLocationOnScreen(new int[2]);
            return (int) (r0[1] + motionEvent.getY(i));
        } catch (Throwable unused) {
            return 0;
        }
    }

    static List<Integer> getScrollOffsetForViews(List<View> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(computeVerticalScrollOffset(it.next())));
        }
        return arrayList;
    }

    static boolean equalsOffsets(List<Integer> list, List<Integer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!list.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isConsecutiveScrollerChild(View view) {
        if (view == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof DJXScrollerLayout.LayoutParams) {
            return ((DJXScrollerLayout.LayoutParams) layoutParams).isConsecutive;
        }
        return true;
    }

    static View getScrolledView(View view) {
        View scrollChild = getScrollChild(view);
        while (scrollChild instanceof IScroller) {
            View currentScrollerView = ((IScroller) scrollChild).getCurrentScrollerView();
            if (scrollChild == currentScrollerView) {
                return currentScrollerView;
            }
            scrollChild = currentScrollerView;
        }
        return scrollChild;
    }

    static View getScrollChild(View view) {
        View viewFindViewById;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if ((layoutParams instanceof DJXScrollerLayout.LayoutParams) && (viewFindViewById = view.findViewById(((DJXScrollerLayout.LayoutParams) layoutParams).scrollChild)) != null) {
                return viewFindViewById;
            }
        }
        return view;
    }

    static boolean startInterceptRequestLayout(RecyclerView recyclerView) {
        if ("InterceptRequestLayout".equals(recyclerView.getTag())) {
            try {
                Method declaredMethod = RecyclerView.class.getDeclaredMethod("startInterceptRequestLayout", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, new Object[0]);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    static void stopInterceptRequestLayout(RecyclerView recyclerView) {
        if ("InterceptRequestLayout".equals(recyclerView.getTag())) {
            try {
                Method declaredMethod = RecyclerView.class.getDeclaredMethod("stopInterceptRequestLayout", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(recyclerView, false);
            } catch (Throwable unused) {
            }
        }
    }

    static boolean isConsecutiveScrollParent(View view) {
        while ((view.getParent() instanceof ViewGroup) && !(view.getParent() instanceof DJXScrollerLayout)) {
            view = (View) view.getParent();
        }
        if (view.getParent() instanceof DJXScrollerLayout) {
            return isConsecutiveScrollerChild(view);
        }
        return false;
    }

    static boolean isHorizontalScroll(View view, int i, int i2) {
        for (View view2 : getTouchViews(view, i, i2)) {
            if (view2.canScrollHorizontally(1) || view2.canScrollHorizontally(-1)) {
                return true;
            }
        }
        return false;
    }

    static boolean isTouchNotTriggerScrollStick(View view, int i, int i2) {
        List<DJXScrollerLayout> inTouchCSLayout = getInTouchCSLayout(view, i, i2);
        for (int size = inTouchCSLayout.size() - 1; size >= 0; size--) {
            DJXScrollerLayout dJXScrollerLayout = inTouchCSLayout.get(size);
            View topViewInTouch = getTopViewInTouch(dJXScrollerLayout, i, i2);
            if (topViewInTouch != null && dJXScrollerLayout.isStickyView(topViewInTouch) && dJXScrollerLayout.theChildIsStick(topViewInTouch) && !((DJXScrollerLayout.LayoutParams) topViewInTouch.getLayoutParams()).isTriggerScroll) {
                return true;
            }
        }
        return false;
    }

    static List<DJXScrollerLayout> getInTouchCSLayout(View view, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        List<View> touchViews = getTouchViews(view, i, i2);
        if (touchViews != null) {
            for (View view2 : touchViews) {
                if (view2 instanceof DJXScrollerLayout) {
                    arrayList.add((DJXScrollerLayout) view2);
                }
            }
        }
        return arrayList;
    }

    static View getTopViewInTouch(DJXScrollerLayout dJXScrollerLayout, int i, int i2) {
        int childCount = dJXScrollerLayout.getChildCount();
        View view = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = dJXScrollerLayout.getChildAt(i3);
            if (childAt.getVisibility() == 0 && isTouchPointInView(childAt, i, i2) && (view == null || ViewCompat.getZ(childAt) > ViewCompat.getZ(view) || (ViewCompat.getZ(childAt) == ViewCompat.getZ(view) && dJXScrollerLayout.getDrawingPosition(childAt) > dJXScrollerLayout.getDrawingPosition(view)))) {
                view = childAt;
            }
        }
        return view;
    }
}
