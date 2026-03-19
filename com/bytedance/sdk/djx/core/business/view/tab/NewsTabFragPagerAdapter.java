package com.bytedance.sdk.djx.core.business.view.tab;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.sdk.djx.core.business.base.FragProxy;
import com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab;
import com.bytedance.sdk.djx.utils.LG;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NewsTabFragPagerAdapter extends PagerAdapter implements NewsPagerSlidingTab.Tab.Provider {
    private static final String KEY_PREFIX_FRAGMENT = "f";
    private static final String KEY_STATE = "state";
    public static final String TAB_NONE = "";
    private static final String TAG = "TabFragmentPagerAdapter";
    private final Context mContext;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final List<NewsTabFragDelegate> mDelegates;
    private final FragFactory mFactory;
    private final SparseArray<Bundle> mFragmentArgs;
    private FragmentManager mFragmentManager;
    private final SparseArray<Fragment> mFragments;
    private final boolean mIsSupportV4;
    private final SparseArray<FragProxy> mNewsFragments;
    private OnFragmentFinishListener mPageFinishListener;
    private FragProxy mParent;
    private SparseArray<Fragment.SavedState> mSavedStates;
    private androidx.fragment.app.FragmentTransaction mV4CurTransaction;
    private androidx.fragment.app.Fragment mV4CurrentPrimaryItem;
    private androidx.fragment.app.FragmentManager mV4FragmentManager;
    private final SparseArray<androidx.fragment.app.Fragment> mV4Fragments;
    private SparseArray<Fragment.SavedState> mV4SavedStates;

    public interface FragFactory {
        FragProxy newItemFragment(boolean z, int i);
    }

    public interface MessageReceiver {
        void onMessageReceived(Bundle bundle);
    }

    public interface OnFragmentChangeListener {
        void onSetAsPrimaryPage();

        void onUnsetAsPrimaryPage();
    }

    public interface OnFragmentFinishListener {
        void onFragmentFinished();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }

    public NewsTabFragPagerAdapter(Context context, androidx.fragment.app.FragmentManager fragmentManager, FragFactory fragFactory) {
        this.mV4FragmentManager = null;
        this.mFragmentManager = null;
        this.mDelegates = new ArrayList();
        this.mV4CurTransaction = null;
        this.mCurTransaction = null;
        this.mV4Fragments = new SparseArray<>();
        this.mFragments = new SparseArray<>();
        this.mV4SavedStates = new SparseArray<>();
        this.mSavedStates = new SparseArray<>();
        this.mFragmentArgs = new SparseArray<>();
        this.mNewsFragments = new SparseArray<>();
        this.mV4CurrentPrimaryItem = null;
        this.mCurrentPrimaryItem = null;
        this.mContext = context;
        this.mV4FragmentManager = fragmentManager;
        this.mIsSupportV4 = true;
        this.mFactory = fragFactory;
    }

    public NewsTabFragPagerAdapter(Context context, FragmentManager fragmentManager, FragFactory fragFactory) {
        this.mV4FragmentManager = null;
        this.mFragmentManager = null;
        this.mDelegates = new ArrayList();
        this.mV4CurTransaction = null;
        this.mCurTransaction = null;
        this.mV4Fragments = new SparseArray<>();
        this.mFragments = new SparseArray<>();
        this.mV4SavedStates = new SparseArray<>();
        this.mSavedStates = new SparseArray<>();
        this.mFragmentArgs = new SparseArray<>();
        this.mNewsFragments = new SparseArray<>();
        this.mV4CurrentPrimaryItem = null;
        this.mCurrentPrimaryItem = null;
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mIsSupportV4 = false;
        this.mFactory = fragFactory;
    }

    public androidx.fragment.app.Fragment getV4Fragment(int i) {
        return this.mV4Fragments.get(i);
    }

    public FragProxy getNewsFragment(int i) {
        return this.mNewsFragments.get(i);
    }

    public android.app.Fragment getFragment(int i) {
        return this.mFragments.get(i);
    }

    public void setFragments(List<NewsTabFragDelegate> list) {
        this.mDelegates.clear();
        appendFragments(list);
    }

    public void appendFragments(List<NewsTabFragDelegate> list) {
        if (list == null) {
            throw new RuntimeException("delegates should not be null for setFragments()");
        }
        this.mDelegates.addAll(list);
        notifyDataSetChanged();
    }

    public void appendFragment(NewsTabFragDelegate newsTabFragDelegate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(newsTabFragDelegate);
        appendFragments(arrayList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mDelegates.size();
    }

    public androidx.fragment.app.Fragment newV4Item(int i) {
        FragProxy fragProxyNewItemFragment;
        FragFactory fragFactory = this.mFactory;
        if (fragFactory == null || (fragProxyNewItemFragment = fragFactory.newItemFragment(this.mIsSupportV4, i)) == null) {
            return null;
        }
        this.mNewsFragments.append(i, fragProxyNewItemFragment);
        return fragProxyNewItemFragment.getFragment();
    }

    private android.app.Fragment newItem(int i) {
        FragProxy fragProxyNewItemFragment;
        FragFactory fragFactory = this.mFactory;
        if (fragFactory == null || (fragProxyNewItemFragment = fragFactory.newItemFragment(this.mIsSupportV4, i)) == null) {
            return null;
        }
        this.mNewsFragments.append(i, fragProxyNewItemFragment);
        return fragProxyNewItemFragment.getFragment2();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mIsSupportV4) {
            androidx.fragment.app.Fragment fragment = this.mV4Fragments.get(i);
            if (fragment != null) {
                return fragment;
            }
            if (this.mV4CurTransaction == null) {
                this.mV4CurTransaction = this.mV4FragmentManager.beginTransaction();
            }
            androidx.fragment.app.Fragment fragmentNewV4Item = newV4Item(i);
            Fragment.SavedState savedState = this.mV4SavedStates.get(i);
            if (savedState != null) {
                fragmentNewV4Item.setInitialSavedState(savedState);
            }
            fragmentNewV4Item.setMenuVisibility(false);
            fragmentNewV4Item.setUserVisibleHint(false);
            this.mV4Fragments.put(i, fragmentNewV4Item);
            this.mV4CurTransaction.add(viewGroup.getId(), fragmentNewV4Item);
            return fragmentNewV4Item;
        }
        android.app.Fragment fragment2 = this.mFragments.get(i);
        if (fragment2 != null) {
            return fragment2;
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        android.app.Fragment fragmentNewItem = newItem(i);
        Fragment.SavedState savedState2 = this.mSavedStates.get(i);
        if (savedState2 != null) {
            fragmentNewItem.setInitialSavedState(savedState2);
        }
        fragmentNewItem.setMenuVisibility(false);
        fragmentNewItem.setUserVisibleHint(false);
        this.mFragments.put(i, fragmentNewItem);
        this.mCurTransaction.add(viewGroup.getId(), fragmentNewItem);
        return fragmentNewItem;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mIsSupportV4) {
            if (this.mV4CurTransaction == null) {
                this.mV4CurTransaction = this.mV4FragmentManager.beginTransaction();
            }
            androidx.fragment.app.Fragment fragment = (androidx.fragment.app.Fragment) obj;
            this.mV4SavedStates.put(i, this.mV4FragmentManager.saveFragmentInstanceState(fragment));
            this.mV4Fragments.remove(i);
            this.mV4CurTransaction.remove(fragment);
            this.mNewsFragments.remove(i);
            return;
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        android.app.Fragment fragment2 = (android.app.Fragment) obj;
        this.mSavedStates.put(i, this.mFragmentManager.saveFragmentInstanceState(fragment2));
        this.mFragments.remove(i);
        this.mCurTransaction.remove(fragment2);
        this.mNewsFragments.remove(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mIsSupportV4) {
            androidx.fragment.app.Fragment fragment = (androidx.fragment.app.Fragment) obj;
            androidx.fragment.app.Fragment fragment2 = this.mV4CurrentPrimaryItem;
            if (fragment != fragment2) {
                if (fragment2 != null) {
                    fragment2.setMenuVisibility(false);
                    this.mV4CurrentPrimaryItem.setUserVisibleHint(false);
                    ActivityResultCaller activityResultCaller = this.mV4CurrentPrimaryItem;
                    if (activityResultCaller instanceof OnFragmentChangeListener) {
                        ((OnFragmentChangeListener) activityResultCaller).onUnsetAsPrimaryPage();
                    }
                }
                if (fragment != 0) {
                    FragProxy fragProxy = this.mParent;
                    if (fragProxy != null) {
                        fragment.setMenuVisibility(fragProxy.getFragment().getUserVisibleHint());
                        fragment.setUserVisibleHint(this.mParent.getFragment().getUserVisibleHint());
                        LG.i(TAG, "v4 parent path-> setUserVisibleHint = " + this.mParent.getFragment().getUserVisibleHint());
                    } else {
                        fragment.setMenuVisibility(true);
                        fragment.setUserVisibleHint(true);
                    }
                    if (fragment instanceof OnFragmentChangeListener) {
                        ((OnFragmentChangeListener) fragment).onSetAsPrimaryPage();
                    }
                }
                this.mV4CurrentPrimaryItem = fragment;
                return;
            }
            return;
        }
        android.app.Fragment fragment3 = (android.app.Fragment) obj;
        android.app.Fragment fragment4 = this.mCurrentPrimaryItem;
        if (fragment3 != fragment4) {
            if (fragment4 != null) {
                fragment4.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
                ComponentCallbacks2 componentCallbacks2 = this.mCurrentPrimaryItem;
                if (componentCallbacks2 instanceof OnFragmentChangeListener) {
                    ((OnFragmentChangeListener) componentCallbacks2).onUnsetAsPrimaryPage();
                }
            }
            if (fragment3 != 0) {
                FragProxy fragProxy2 = this.mParent;
                if (fragProxy2 != null) {
                    fragment3.setMenuVisibility(fragProxy2.getFragment2().getUserVisibleHint());
                    fragment3.setUserVisibleHint(this.mParent.getFragment2().getUserVisibleHint());
                    LG.i(TAG, "parent path-> setUserVisibleHint = " + this.mParent.getFragment().getUserVisibleHint());
                } else {
                    fragment3.setMenuVisibility(true);
                    fragment3.setUserVisibleHint(true);
                }
                if (fragment3 instanceof OnFragmentChangeListener) {
                    ((OnFragmentChangeListener) fragment3).onSetAsPrimaryPage();
                }
            }
            this.mCurrentPrimaryItem = fragment3;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            if (this.mIsSupportV4) {
                androidx.fragment.app.FragmentTransaction fragmentTransaction = this.mV4CurTransaction;
                if (fragmentTransaction != null) {
                    try {
                        fragmentTransaction.commitAllowingStateLoss();
                        this.mV4CurTransaction = null;
                        this.mV4FragmentManager.executePendingTransactions();
                    } catch (Exception unused) {
                        Field declaredField = this.mV4FragmentManager.getClass().getDeclaredField("mExecutingActions");
                        declaredField.setAccessible(true);
                        if (declaredField.getBoolean(this.mV4FragmentManager)) {
                            declaredField.setBoolean(this.mV4FragmentManager, false);
                        }
                    }
                }
            } else {
                FragmentTransaction fragmentTransaction2 = this.mCurTransaction;
                if (fragmentTransaction2 != null) {
                    try {
                        fragmentTransaction2.commitAllowingStateLoss();
                        this.mCurTransaction = null;
                        this.mFragmentManager.executePendingTransactions();
                    } catch (Exception unused2) {
                        Field declaredField2 = this.mFragmentManager.getClass().getDeclaredField("mExecutingActions");
                        declaredField2.setAccessible(true);
                        if (declaredField2.getBoolean(this.mFragmentManager)) {
                            declaredField2.setBoolean(this.mFragmentManager, false);
                        }
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException unused3) {
        }
        OnFragmentFinishListener onFragmentFinishListener = this.mPageFinishListener;
        if (onFragmentFinishListener != null) {
            onFragmentFinishListener.onFragmentFinished();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.mIsSupportV4 ? ((androidx.fragment.app.Fragment) obj).getView() == view : ((android.app.Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) throws NumberFormatException {
        android.app.Fragment fragment;
        androidx.fragment.app.Fragment fragment2;
        if (this.mIsSupportV4) {
            if (parcelable != null) {
                Bundle bundle = (Bundle) parcelable;
                bundle.setClassLoader(classLoader);
                SparseArray<Fragment.SavedState> sparseParcelableArray = bundle.getSparseParcelableArray("states");
                this.mV4SavedStates.clear();
                this.mV4Fragments.clear();
                if (sparseParcelableArray != null) {
                    this.mV4SavedStates = sparseParcelableArray;
                }
                for (String str : bundle.keySet()) {
                    if (str.startsWith(KEY_PREFIX_FRAGMENT)) {
                        int i = Integer.parseInt(str.substring(1));
                        try {
                            fragment2 = this.mV4FragmentManager.getFragment(bundle, str);
                        } catch (Exception e) {
                            e.printStackTrace();
                            fragment2 = null;
                        }
                        if (fragment2 != null) {
                            fragment2.setMenuVisibility(false);
                            this.mV4Fragments.put(i, fragment2);
                        }
                    }
                }
                return;
            }
            return;
        }
        if (parcelable != null) {
            Bundle bundle2 = (Bundle) parcelable;
            bundle2.setClassLoader(classLoader);
            SparseArray<Fragment.SavedState> sparseParcelableArray2 = bundle2.getSparseParcelableArray("states");
            this.mSavedStates.clear();
            this.mFragments.clear();
            if (sparseParcelableArray2 != null) {
                this.mSavedStates = sparseParcelableArray2;
            }
            for (String str2 : bundle2.keySet()) {
                if (str2.startsWith(KEY_PREFIX_FRAGMENT)) {
                    int i2 = Integer.parseInt(str2.substring(1));
                    try {
                        fragment = this.mFragmentManager.getFragment(bundle2, str2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        fragment = null;
                    }
                    if (fragment != null) {
                        fragment.setMenuVisibility(false);
                        this.mFragments.put(i2, fragment);
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.Tab.Provider
    public NewsPagerSlidingTab.Tab getTab(int i) {
        List<NewsTabFragDelegate> list = this.mDelegates;
        if (list == null || list.isEmpty() || i < 0 || i >= this.mDelegates.size()) {
            return null;
        }
        return this.mDelegates.get(i).getTab();
    }

    @Override // com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.Tab.Provider
    public NewsPagerSlidingTab.Tab getTab(String str) {
        if (this.mDelegates != null && !TextUtils.isEmpty(str)) {
            for (NewsTabFragDelegate newsTabFragDelegate : this.mDelegates) {
                if (newsTabFragDelegate != null && newsTabFragDelegate.getTab() != null && str.equals(newsTabFragDelegate.getTab().getId())) {
                    return newsTabFragDelegate.getTab();
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.Tab.Provider
    public int getTabPositionById(String str) {
        if (this.mDelegates != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.mDelegates.size(); i++) {
                NewsTabFragDelegate newsTabFragDelegate = this.mDelegates.get(i);
                if (newsTabFragDelegate != null && newsTabFragDelegate.getTab() != null && str.equals(newsTabFragDelegate.getTab().getId())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.Tab.Provider
    public String getTabIdByPosition(int i) {
        NewsPagerSlidingTab.Tab tab = getTab(i);
        return (tab == null || tab.getId() == null) ? "" : tab.getId();
    }

    public void setOnFragmentFinishListener(OnFragmentFinishListener onFragmentFinishListener) {
        this.mPageFinishListener = onFragmentFinishListener;
    }

    public void refresh(int i) {
        FragProxy newsFragment = getNewsFragment(i);
        if (newsFragment != null) {
            newsFragment.refresh();
        }
    }

    public void scrollToTop(int i) {
        FragProxy newsFragment = getNewsFragment(i);
        if (newsFragment != null) {
            newsFragment.scrollToTop();
        }
    }

    public void setParent(FragProxy fragProxy) {
        this.mParent = fragProxy;
    }

    public int getNewsFragmentsSize() {
        return this.mNewsFragments.size();
    }
}
