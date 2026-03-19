package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.sdk.djx.core.business.view.RecyclePagerAdapter.Holder;
import com.bytedance.sdk.djx.utils.LG;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class RecyclePagerAdapter<VH extends Holder> extends PagerAdapter {
    public static final int INVALID_TYPE = -1;
    public static final int NO_POSITION = -1;
    private static final String TAG = "RecyclePagerAdapter";
    private final Context mContext;
    private final LayoutInflater mInflater;
    private VH mPrimaryItem;
    private final ArrayList<Holder> mItemsInLayout = new ArrayList<>();
    private final SparseArray<ArrayList<VH>> mRecycledItems = new SparseArray<>();
    protected final List<Object> mList = new CopyOnWriteArrayList();

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
    }

    protected int getItemViewType(int i) {
        return -1;
    }

    protected abstract void onBindViewHolder(VH vh, Object obj, int i, boolean z);

    protected abstract VH onCreateViewHolder(ViewGroup viewGroup, int i, int i2);

    protected void onPrimaryItemChanged(VH vh, VH vh2) {
    }

    protected void onViewRecycled(VH vh) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }

    public RecyclePagerAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public List<Object> getList() {
        return this.mList;
    }

    public void append(Object obj) {
        if (obj != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            append((List<Object>) arrayList);
        }
    }

    public void append(List<Object> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean zIsEmpty = this.mList.isEmpty();
        int size = this.mList.size();
        this.mList.addAll(list);
        if (zIsEmpty) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(size, list.size());
        }
    }

    public void append(int i, List<Object> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean zIsEmpty = this.mList.isEmpty();
        this.mList.addAll(i, list);
        if (zIsEmpty) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(i, list.size());
        }
    }

    public void refresh(List<Object> list) {
        this.mList.clear();
        if (list != null) {
            this.mList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void removeAll() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    public Object remove(int i) {
        if (i < 0 || i >= this.mList.size()) {
            return null;
        }
        Object objRemove = this.mList.remove(i);
        notifyItemRemoved(i);
        return objRemove;
    }

    public Object getItemData(int i) {
        if (this.mList.isEmpty() || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        VH vhCreateViewHolder;
        int itemViewType = getItemViewType(i);
        ArrayList<VH> arrayList = this.mRecycledItems.get(itemViewType);
        boolean z = true;
        if (arrayList == null || arrayList.isEmpty()) {
            vhCreateViewHolder = createViewHolder(viewGroup, itemViewType, i);
            Object layoutId = vhCreateViewHolder.getLayoutId();
            if (layoutId instanceof View) {
                vhCreateViewHolder.mItemView = (View) layoutId;
            } else {
                vhCreateViewHolder.mItemView = this.mInflater.inflate(((Integer) layoutId).intValue(), viewGroup, false);
            }
            vhCreateViewHolder.createHolder(this.mList.get(i), i, vhCreateViewHolder.mItemView);
            z = false;
        } else {
            vhCreateViewHolder = arrayList.remove(arrayList.size() - 1);
        }
        vhCreateViewHolder.mItemView.setTag(vhCreateViewHolder);
        bindViewHolder(vhCreateViewHolder, i, z);
        if (vhCreateViewHolder.mItemView.getParent() != null) {
            ((ViewGroup) vhCreateViewHolder.mItemView.getParent()).removeView(vhCreateViewHolder.mItemView);
        }
        viewGroup.addView(vhCreateViewHolder.mItemView);
        this.mItemsInLayout.add(vhCreateViewHolder);
        return vhCreateViewHolder;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof Holder) {
            Holder holder = (Holder) obj;
            viewGroup.removeView(holder.mItemView);
            this.mItemsInLayout.remove(holder);
            recycleViewHolder(holder);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        VH vh;
        if ((obj instanceof Holder) && (vh = this.mPrimaryItem) != obj) {
            VH vh2 = (VH) obj;
            this.mPrimaryItem = vh2;
            onPrimaryItemChanged(vh, vh2);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void startUpdate(View view) {
        startUpdate((ViewGroup) view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(View view, int i) {
        return instantiateItem((ViewGroup) view, i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(View view, int i, Object obj) {
        destroyItem((ViewGroup) view, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(View view, int i, Object obj) {
        setPrimaryItem((ViewGroup) view, i, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void finishUpdate(View view) {
        finishUpdate((ViewGroup) view);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof Holder) && view == ((Holder) obj).mItemView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        if (!(obj instanceof Holder)) {
            return -2;
        }
        Holder holder = (Holder) obj;
        if (holder.mNeedRebind) {
            return -2;
        }
        if (holder.mPositionChanged) {
            return holder.mPosition;
        }
        return -1;
    }

    public final VH createViewHolder(ViewGroup viewGroup, int i, int i2) {
        VH vh = (VH) onCreateViewHolder(viewGroup, i, i2);
        vh.mPosition = i2;
        vh.mItemViewType = i;
        return vh;
    }

    public final void bindViewHolder(VH vh, int i, boolean z) {
        vh.mPosition = i;
        vh.mNeedRebind = false;
        vh.mPositionChanged = false;
        try {
            vh.bindHolder(z, this.mList.get(i), i, vh.mItemView);
            onBindViewHolder(vh, this.mList.get(i), i, z);
        } catch (Throwable th) {
            LG.e(TAG, "bind holder error", th);
        }
    }

    private void recycleViewHolder(VH vh) {
        int i = vh.mItemViewType;
        vh.mItemViewType = -1;
        vh.mPosition = -1;
        vh.mNeedRebind = false;
        vh.mPositionChanged = false;
        if (vh.mItemView != null) {
            vh.mItemView.setTag(null);
        }
        ArrayList<VH> arrayList = this.mRecycledItems.get(i, new ArrayList<>());
        arrayList.add(vh);
        this.mRecycledItems.put(i, arrayList);
        vh.destroy();
        onViewRecycled(vh);
    }

    public VH getPrimaryItem() {
        return this.mPrimaryItem;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void notifyDataSetChanged() {
        Iterator<Holder> it = this.mItemsInLayout.iterator();
        while (it.hasNext()) {
            Holder next = it.next();
            if (next != null) {
                next.mNeedRebind = true;
            }
        }
        super.notifyDataSetChanged();
    }

    public final void notifyItemChanged(int i) {
        notifyItemRangeChanged(i, 1);
    }

    public final void notifyItemRangeChanged(int i, int i2) {
        int i3;
        if (i2 <= 0 || this.mItemsInLayout.isEmpty()) {
            return;
        }
        boolean z = false;
        int i4 = i2 + i;
        Iterator<Holder> it = this.mItemsInLayout.iterator();
        while (it.hasNext()) {
            Holder next = it.next();
            if (next != null && (i3 = next.mPosition) >= i && i3 < i4) {
                next.mNeedRebind = true;
                z = true;
            }
        }
        if (z) {
            super.notifyDataSetChanged();
        }
    }

    public final void notifyItemInserted(int i) {
        notifyItemRangeInserted(i, 1);
    }

    public final void notifyItemRangeInserted(int i, int i2) {
        int i3;
        if (i2 <= 0 || this.mItemsInLayout.isEmpty()) {
            return;
        }
        Iterator<Holder> it = this.mItemsInLayout.iterator();
        while (it.hasNext()) {
            Holder next = it.next();
            if (next != null && (i3 = next.mPosition) >= i) {
                next.mPosition = i3 + i2;
                next.mPositionChanged = true;
            }
        }
        super.notifyDataSetChanged();
    }

    public final void notifyItemRemoved(int i) {
        notifyItemRangeRemoved(i, 1);
    }

    public final void notifyItemRangeRemoved(int i, int i2) {
        if (i2 <= 0 || this.mItemsInLayout.isEmpty()) {
            super.notifyDataSetChanged();
            return;
        }
        int i3 = i + i2;
        Iterator<Holder> it = this.mItemsInLayout.iterator();
        while (it.hasNext()) {
            Holder next = it.next();
            if (next != null) {
                int i4 = next.mPosition;
                if (i4 >= i && i4 < i3) {
                    next.mNeedRebind = true;
                } else if (i4 >= i3) {
                    next.mPosition = i4 - i2;
                    next.mPositionChanged = true;
                }
            }
        }
        super.notifyDataSetChanged();
    }

    public final void notifyItemMoved(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        if (i == i2) {
            return;
        }
        boolean z2 = false;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            z = false;
        } else {
            i3 = i;
            i4 = i2;
            z = true;
        }
        Iterator<Holder> it = this.mItemsInLayout.iterator();
        while (it.hasNext()) {
            Holder next = it.next();
            if (next != null && (i5 = next.mPosition) >= i4 && i5 <= i3) {
                if (i5 == i) {
                    next.mPosition = i2;
                    next.mPositionChanged = true;
                } else {
                    if (z) {
                        next.mPosition++;
                    } else {
                        next.mPosition--;
                    }
                    next.mPositionChanged = true;
                }
                z2 = true;
            }
        }
        if (z2) {
            super.notifyDataSetChanged();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        int size = this.mRecycledItems.size();
        if (size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            ArrayList<VH> arrayListValueAt = this.mRecycledItems.valueAt(i);
            if (arrayListValueAt != null && !arrayListValueAt.isEmpty()) {
                Iterator<VH> it = arrayListValueAt.iterator();
                while (it.hasNext()) {
                    VH next = it.next();
                    if (next != null && next.mItemView != null) {
                        next.mItemView.dispatchConfigurationChanged(configuration);
                    }
                }
            }
        }
    }

    public void onDestroy(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                try {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        childAt.setTag(null);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        try {
            if (this.mItemsInLayout.isEmpty()) {
                return;
            }
            Iterator<Holder> it = this.mItemsInLayout.iterator();
            while (it.hasNext()) {
                Holder next = it.next();
                if (next != null) {
                    next.destroy();
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public void updateItem(int i, Object obj) {
        this.mList.set(i, obj);
        Iterator<Holder> it = this.mItemsInLayout.iterator();
        while (it.hasNext()) {
            Holder next = it.next();
            if (next != null && next.mPosition == i) {
                next.updateHolder(getItemData(i), i);
                return;
            }
        }
    }

    public static abstract class Holder<DT> {
        View mItemView;
        int mItemViewType = -1;
        int mPosition = -1;
        boolean mNeedRebind = false;
        boolean mPositionChanged = false;

        protected abstract void bindHolder(boolean z, DT dt, int i, View view);

        protected abstract void createHolder(DT dt, int i, View view);

        protected abstract void destroy();

        protected abstract Object getLayoutId();

        protected void updateHolder(DT dt, int i) {
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getAdapterPosition() {
            return this.mPosition;
        }

        public final View getItemView() {
            return this.mItemView;
        }

        public final <T extends View> T findById(int i) {
            View view = this.mItemView;
            if (view == null) {
                return null;
            }
            return (T) view.findViewById(i);
        }
    }
}
