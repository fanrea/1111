package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.sdk.djx.core.business.view.MultiTypePagerAdapter.Holder;
import com.bytedance.sdk.djx.utils.LG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class MultiTypePagerAdapter<VH extends Holder> extends PagerAdapter {
    private static final String TAG = "MultiTypePagerAdapter";
    protected final Context mContext;
    protected final LayoutInflater mInflater;
    protected final HashMap<Integer, LinkedList<View>> mScrapViews = new LinkedHashMap();
    private final List<Object> mList = new ArrayList();

    public static abstract class Holder<DT> {
        protected abstract void bindHolder(boolean z, DT dt, int i, View view);

        protected abstract void createHolder(DT dt, int i, View view);

        protected abstract void destroy();

        protected abstract Object getLayoutId();
    }

    protected abstract VH createHolder(int i, int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    protected abstract int getItemViewType(int i);

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public MultiTypePagerAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void append(Object obj) {
        if (obj != null) {
            this.mList.add(obj);
            notifyDataSetChanged();
        }
    }

    public void append(List<Object> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    public void refresh(List<Object> list) {
        this.mList.clear();
        notifyDataSetChanged();
        if (list != null) {
            this.mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LinkedList<View> linkedList = this.mScrapViews.get(Integer.valueOf(getItemViewType(i)));
        View view = getView(i, (linkedList == null || linkedList.isEmpty()) ? null : linkedList.removeFirst(), viewGroup);
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            View view = (View) obj;
            try {
                viewGroup.removeView(view);
            } catch (Throwable th) {
                LG.d(TAG, "destroyItem error1: ", th);
            }
            int itemViewType = getItemViewType(i);
            LinkedList<View> linkedList = this.mScrapViews.get(Integer.valueOf(itemViewType));
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.mScrapViews.put(Integer.valueOf(itemViewType), linkedList);
            }
            linkedList.add(view);
            unbindView(view);
        } catch (Throwable th2) {
            LG.d(TAG, "destroyItem error2: ", th2);
        }
    }

    protected void unbindView(View view) {
        if (view.getTag() instanceof Holder) {
            ((Holder) view.getTag()).destroy();
        }
    }

    public void onDestroy(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                try {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null && (childAt.getTag() instanceof Holder)) {
                        ((Holder) childAt.getTag()).destroy();
                    }
                } catch (Throwable unused) {
                }
            }
        }
        try {
            Iterator<Map.Entry<Integer, LinkedList<View>>> it = this.mScrapViews.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Iterator<View> it2 = it.next().getValue().iterator();
                    while (it2.hasNext()) {
                        try {
                            unbindView(it2.next());
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mList.size();
    }

    protected View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Holder holder;
        View viewInflate;
        int itemViewType = getItemViewType(i);
        Object itemData = getItemData(i);
        boolean z = false;
        if (view == null) {
            Holder holderCreateHolder = createHolder(itemViewType, i);
            Object layoutId = holderCreateHolder.getLayoutId();
            if (layoutId instanceof View) {
                viewInflate = (View) layoutId;
            } else {
                viewInflate = this.mInflater.inflate(((Integer) layoutId).intValue(), viewGroup, false);
            }
            holderCreateHolder.createHolder(itemData, i, viewInflate);
            viewInflate.setTag(holderCreateHolder);
            view2 = viewInflate;
            holder = holderCreateHolder;
        } else {
            z = true;
            view2 = view;
            holder = (Holder) view.getTag();
        }
        try {
            holder.bindHolder(z, itemData, i, view2);
            return view2;
        } catch (Throwable unused) {
            return getView(i, null, viewGroup);
        }
    }

    protected Object getItemData(int i) {
        if (this.mList.isEmpty()) {
            return null;
        }
        return this.mList.get(i);
    }
}
