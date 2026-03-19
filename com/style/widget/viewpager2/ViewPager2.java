package com.style.widget.viewpager2;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.container.adrequest.i;
import com.component.interfaces.RemoteDelegator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ViewPager2 extends RemoteDelegator<ViewGroup> {
    private static final String METHOD_GET_CURRENT_ITEM = "getCurrentItem";
    private static final String METHOD_GET_SCROLL_STATE = "getScrollState";
    private static final String METHOD_SET_ADAPTER = "setAdapter";
    private static final String METHOD_SET_CURRENT_ITEM = "setCurrentItem";
    private static final String METHOD_SET_OFF_PAGE_LIMIT = "setOffscreenPageLimit";
    private static final String METHOD_SET_ORIENTATION = "setOrientation";
    private static final String METHOD_SET_USER_INPUT_ENABLED = "setUserInputEnabled";
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private RVAdapter<?> mAdapter;
    private OnOverScrollListener mOverScrollListener;
    private final List<OnPageChangeCallback> mPageChangeCallbacks;

    interface DataSetChangeObserver {
        void onChanged();
    }

    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    public @interface Orientation {
    }

    public @interface ScrollState {
    }

    public ViewPager2(i iVar, Context context) {
        super("ViewPager2", iVar, context);
        this.mPageChangeCallbacks = new ArrayList();
        super.addEvent(METHOD_GET_SCROLL_STATE, new Class[0]);
        super.addEvent(METHOD_GET_CURRENT_ITEM, new Class[0]);
        super.addEvent(METHOD_SET_CURRENT_ITEM, Integer.class);
        super.addEvent(METHOD_SET_ORIENTATION, Integer.class);
        super.addEvent(METHOD_SET_ADAPTER, Object.class);
        super.addEvent(METHOD_SET_OFF_PAGE_LIMIT, Integer.class);
        super.addEvent(METHOD_SET_USER_INPUT_ENABLED, Boolean.class);
        super.setCallback(new RemoteDelegator.Callback() { // from class: com.style.widget.viewpager2.ViewPager2.1
            @Override // com.component.interfaces.RemoteDelegator.Callback
            public Object onResult(String str, Object[] objArr) {
                if (TextUtils.equals("onOverScrollStart", str)) {
                    if (ViewPager2.this.mOverScrollListener != null) {
                        ViewPager2.this.mOverScrollListener.onOverScrollStart();
                        return null;
                    }
                    return null;
                }
                if (TextUtils.equals("onOverScrollEnd", str)) {
                    if (ViewPager2.this.mOverScrollListener != null) {
                        ViewPager2.this.mOverScrollListener.onOverScrollEnd();
                        return null;
                    }
                    return null;
                }
                if (TextUtils.equals("onPageScrolled", str)) {
                    if (RemoteDelegator.validateArgs(objArr, Integer.class, Float.class, Integer.class)) {
                        Iterator it = ViewPager2.this.mPageChangeCallbacks.iterator();
                        while (it.hasNext()) {
                            ((OnPageChangeCallback) it.next()).onPageScrolled(((Integer) objArr[0]).intValue(), ((Float) objArr[1]).floatValue(), ((Integer) objArr[2]).intValue());
                        }
                        return null;
                    }
                    return null;
                }
                if (TextUtils.equals("onPageSelected", str)) {
                    if (RemoteDelegator.validateArgs(objArr, Integer.class)) {
                        Iterator it2 = ViewPager2.this.mPageChangeCallbacks.iterator();
                        while (it2.hasNext()) {
                            ((OnPageChangeCallback) it2.next()).onPageSelected(((Integer) objArr[0]).intValue());
                        }
                        return null;
                    }
                    return null;
                }
                if (TextUtils.equals("onPageScrollStateChanged", str) && RemoteDelegator.validateArgs(objArr, Integer.class)) {
                    Iterator it3 = ViewPager2.this.mPageChangeCallbacks.iterator();
                    while (it3.hasNext()) {
                        ((OnPageChangeCallback) it3.next()).onPageScrollStateChanged(((Integer) objArr[0]).intValue());
                    }
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.component.interfaces.RemoteDelegator
    public ViewGroup transformInstance(Object obj) {
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    public int getCurrentItem() {
        Object objDispatch = dispatch(METHOD_GET_CURRENT_ITEM, new Object[0]);
        if (!(objDispatch instanceof Integer)) {
            return 0;
        }
        return ((Integer) objDispatch).intValue();
    }

    public int getScrollState() {
        Object objDispatch = dispatch(METHOD_GET_SCROLL_STATE, new Object[0]);
        if (!(objDispatch instanceof Integer)) {
            return 0;
        }
        return ((Integer) objDispatch).intValue();
    }

    public void setId(int i) {
        ViewGroup viewPager2 = getInstance();
        if (viewPager2 != null) {
            viewPager2.setId(i);
        }
    }

    public void setUserInputEnabled(boolean z) {
        dispatch(METHOD_SET_USER_INPUT_ENABLED, Boolean.valueOf(z));
    }

    public void setOrientation(int i) {
        dispatch(METHOD_SET_ORIENTATION, Integer.valueOf(i));
    }

    public void setCurrentItem(int i) {
        dispatch(METHOD_SET_CURRENT_ITEM, Integer.valueOf(i));
    }

    public void setAdapter(RVAdapter<?> rVAdapter) {
        Object rVAdapter2;
        this.mAdapter = rVAdapter;
        if (this.mAdapter == null) {
            rVAdapter2 = null;
        } else {
            rVAdapter2 = this.mAdapter.getInstance();
        }
        dispatch(METHOD_SET_ADAPTER, rVAdapter2);
    }

    public RVAdapter<?> getAdapter() {
        return this.mAdapter;
    }

    public void setOffscreenPageLimit(int i) {
        dispatch(METHOD_SET_OFF_PAGE_LIMIT, Integer.valueOf(i));
    }

    public void setOnOverScrollListener(OnOverScrollListener onOverScrollListener) {
        this.mOverScrollListener = onOverScrollListener;
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.mPageChangeCallbacks.add(onPageChangeCallback);
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.mPageChangeCallbacks.remove(onPageChangeCallback);
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }

        public void onPageScrollStateChanged(int i) {
        }
    }
}
