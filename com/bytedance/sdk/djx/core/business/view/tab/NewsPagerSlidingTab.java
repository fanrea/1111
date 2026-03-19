package com.bytedance.sdk.djx.core.business.view.tab;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.djx.utils.UIUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class NewsPagerSlidingTab extends HorizontalScrollView {
    public static final int ANIMATION_DURATION = 240;
    private static final int[] ATTRS = {R.attr.textSize, R.attr.textColor, R.attr.gravity};
    public static final int EXTEND_THRESHOLD_COUNT = 4;
    public static final int TEXT_STROKE_WIDTH = 1;
    private final Paint mBottomLinePaint;
    private int mCurrentPosition;
    private float mCurrentPositionOffset;
    private int mCurrentSelectedPosition;
    protected LinearLayout.LayoutParams mDefaultTabLayoutParams;
    public ViewPager.OnPageChangeListener mDelegatePageListener;
    private boolean mEnableScroll;
    public boolean mEnableTabAnimation;
    public boolean mEnableTextStroke;
    protected LinearLayout.LayoutParams mExpandedTabLayoutParams;
    public boolean mInScrollAnimate;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    public RectF mIndicatorRect;
    private float mIndicatorWidth;
    private boolean mInnerEnableScroll;
    public Interpolator mInterpolator;
    boolean mIsTabScrollToCenter;
    private int mLastScrollX;
    private final PageListener mPageListener;
    protected ViewPager mPager;
    private final Paint mRectPaint;
    private boolean mRoundCorner;
    private final int mScreenWidth;
    private int mScrollOffset;
    public int mScrollOrentaion;
    protected boolean mShouldExpand;
    private TabClickListener mTabClickListener;
    private int mTabContainerGravity;
    private int mTabCount;
    private int mTabMargin;
    private int mTabPadding;
    private int mTabTextColorNormal;
    private int mTabTextColorSelected;
    private int mTabTextSize;
    private int mTabTextSizeSelected;
    private final Typeface mTabTypeface;
    private final int mTabTypefaceStyle;
    private int mTabWidth;
    protected LinearLayout mTabsContainer;
    private int mThreShold;

    public interface TabClickListener {
        void onTabClick(int i);
    }

    public NewsPagerSlidingTab(Context context) {
        this(context, null);
    }

    public NewsPagerSlidingTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewsPagerSlidingTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPageListener = new PageListener();
        this.mCurrentPosition = 0;
        this.mCurrentPositionOffset = 0.0f;
        this.mCurrentSelectedPosition = -1;
        this.mIndicatorColor = -1031870;
        this.mRoundCorner = false;
        this.mShouldExpand = false;
        this.mIndicatorHeight = 3;
        this.mTabMargin = 10;
        this.mTabWidth = -2;
        this.mEnableTabAnimation = true;
        this.mEnableTextStroke = true;
        this.mIsTabScrollToCenter = true;
        this.mScrollOffset = 400;
        this.mTabTypeface = null;
        this.mTabTypefaceStyle = 0;
        this.mLastScrollX = 0;
        this.mTabContainerGravity = -1;
        this.mIndicatorRect = new RectF();
        this.mInterpolator = new NewsInterpolator(0.445d, 0.05d, 0.55d, 0.95d);
        Paint paint = new Paint();
        this.mBottomLinePaint = paint;
        this.mEnableScroll = true;
        this.mInnerEnableScroll = true;
        this.mThreShold = 4;
        this.mInScrollAnimate = false;
        setFillViewport(true);
        setWillNotDraw(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mScrollOffset = (int) TypedValue.applyDimension(1, this.mScrollOffset, displayMetrics);
        this.mIndicatorHeight = (int) TypedValue.applyDimension(1, this.mIndicatorHeight, displayMetrics);
        int dimension = (int) getResources().getDimension(com.pangle.cn.pangrowth.djx.sdk.lite.R.dimen.djx_news_channel_text_size);
        this.mTabTextSize = dimension;
        this.mTabTextSizeSelected = dimension;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.mIndicatorWidth = UIUtil.dp2px(32.0f);
        typedArrayObtainStyledAttributes.getColorStateList(1);
        this.mTabContainerGravity = typedArrayObtainStyledAttributes.getInt(2, this.mTabContainerGravity);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.pangle.cn.pangrowth.djx.sdk.lite.R.styleable.DJXNewsPagerSlidingTab);
        this.mIndicatorColor = typedArrayObtainStyledAttributes2.getColor(com.pangle.cn.pangrowth.djx.sdk.lite.R.styleable.DJXNewsPagerSlidingTab_djx_pst_indicator_color, this.mIndicatorColor);
        this.mIndicatorHeight = typedArrayObtainStyledAttributes2.getDimensionPixelSize(com.pangle.cn.pangrowth.djx.sdk.lite.R.styleable.DJXNewsPagerSlidingTab_djx_pst_indicator_height, this.mIndicatorHeight);
        this.mTabPadding = (int) (UIUtil.dp2px(20.0f) + 0.5f);
        this.mTabPadding = typedArrayObtainStyledAttributes2.getDimensionPixelSize(com.pangle.cn.pangrowth.djx.sdk.lite.R.styleable.DJXNewsPagerSlidingTab_djx_pst_tab_padding_left_right, this.mTabPadding);
        this.mShouldExpand = typedArrayObtainStyledAttributes2.getBoolean(com.pangle.cn.pangrowth.djx.sdk.lite.R.styleable.DJXNewsPagerSlidingTab_djx_pst_should_expand, this.mShouldExpand);
        typedArrayObtainStyledAttributes2.recycle();
        Paint paint2 = new Paint();
        this.mRectPaint = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(this.mIndicatorColor);
        paint.setColor(-1513240);
        this.mDefaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mExpandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mTabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = this.mTabContainerGravity;
        this.mTabsContainer.setLayoutParams(layoutParams);
        this.mTabsContainer.setGravity(GravityCompat.START);
        addView(this.mTabsContainer, layoutParams);
        this.mScreenWidth = UIUtil.getScreenWidth(getContext());
    }

    public void setTabTextColorNormal(int i) {
        this.mTabTextColorNormal = i;
    }

    public void setTabTextColorSelected(int i) {
        this.mTabTextColorSelected = i;
    }

    public void setIndicatorWidth(float f) {
        this.mIndicatorWidth = f;
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.mIndicatorHeight = i;
        invalidate();
    }

    public void setRoundCorner(boolean z) {
        this.mRoundCorner = z;
        invalidate();
    }

    public void setTextSize(int i) {
        this.mTabTextSize = i;
        invalidate();
    }

    public void setTextSizeSelected(int i) {
        this.mTabTextSizeSelected = i;
        invalidate();
    }

    public void setEnableIndicatorAnim(boolean z) {
        this.mEnableTabAnimation = z;
    }

    public void setViewPager(ViewPager viewPager) {
        this.mPager = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.mPageListener);
        notifyDataSetChanged();
    }

    public void setTabContainerGravity(int i) {
        this.mTabContainerGravity = i;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mTabsContainer.getLayoutParams();
        layoutParams.gravity = i;
        this.mTabsContainer.setLayoutParams(layoutParams);
        this.mTabsContainer.setGravity(i);
    }

    public void setTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        this.mExpandedTabLayoutParams = layoutParams;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mDelegatePageListener = onPageChangeListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.sdk.djx.core.business.view.tab.NewsPagerTabView] */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v20, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab] */
    public void notifyDataSetChanged() {
        ?? newsPagerTabView;
        this.mTabsContainer.removeAllViews();
        int count = this.mPager.getAdapter().getCount();
        this.mTabCount = count;
        if (count > this.mThreShold) {
            this.mTabsContainer.getLayoutParams().width = -2;
            this.mTabsContainer.setGravity(0);
        } else if (this.mShouldExpand) {
            this.mTabsContainer.getLayoutParams().width = -1;
        }
        for (int i = 0; i < this.mTabCount; i++) {
            if (this.mPager.getAdapter() instanceof Tab.Provider) {
                newsPagerTabView = ((Tab.Provider) this.mPager.getAdapter()).getTab(i).buildTabView(getContext(), i, this.mPager);
                if (newsPagerTabView instanceof NewsPagerTabView) {
                    NewsPagerTabView newsPagerTabView2 = (NewsPagerTabView) newsPagerTabView;
                    newsPagerTabView2.setTextColor(this.mTabTextColorNormal);
                    newsPagerTabView2.setTextSize(this.mTabTextSize);
                }
            } else {
                newsPagerTabView = new NewsPagerTabView(getContext(), this.mTabMargin, this.mTabWidth);
                newsPagerTabView.setText(this.mPager.getAdapter().getPageTitle(i));
                newsPagerTabView.setTextColor(this.mTabTextColorNormal);
                newsPagerTabView.setTextSize(this.mTabTextSize);
            }
            addTab(i, newsPagerTabView);
        }
        selectTab(this.mPager.getCurrentItem());
        post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.1
            @Override // java.lang.Runnable
            public void run() {
                NewsPagerSlidingTab.this.updateIndicatorRect();
                NewsPagerSlidingTab.this.invalidate();
            }
        });
    }

    private void addTab(final int i, View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) throws Resources.NotFoundException {
                if (i != NewsPagerSlidingTab.this.mCurrentSelectedPosition) {
                    if (NewsPagerSlidingTab.this.mTabClickListener != null) {
                        NewsPagerSlidingTab.this.mTabClickListener.onTabClick(i);
                    }
                    if (NewsPagerSlidingTab.this.mEnableTabAnimation) {
                        IndicatorAnim indicatorAnim = NewsPagerSlidingTab.this.new IndicatorAnim();
                        indicatorAnim.setFloatValues(0.0f, 1.0f);
                        indicatorAnim.setDuration(240L);
                        indicatorAnim.startAnim(NewsPagerSlidingTab.this.mCurrentSelectedPosition, i);
                        NewsPagerSlidingTab.this.updateTextWidth(i);
                    }
                }
                NewsPagerSlidingTab.this.mPager.setCurrentItem(i, false);
            }
        });
        this.mTabsContainer.addView(view, i, getTabLayoutParams());
    }

    public LinearLayout getTabsContainer() {
        return this.mTabsContainer;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        updateTabStyles();
        post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.3
            @Override // java.lang.Runnable
            public void run() {
                NewsPagerSlidingTab newsPagerSlidingTab = NewsPagerSlidingTab.this;
                newsPagerSlidingTab.scrollToChild(newsPagerSlidingTab.mCurrentSelectedPosition, 0);
            }
        });
    }

    private ViewGroup.LayoutParams getTabLayoutParams() {
        return this.mShouldExpand ? this.mExpandedTabLayoutParams : this.mDefaultTabLayoutParams;
    }

    private void updateTabStyles() {
        int i = 0;
        while (i < this.mTabCount) {
            View childAt = this.mTabsContainer.getChildAt(i);
            childAt.setLayoutParams(getTabLayoutParams());
            TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
            if (textView != null) {
                textView.setTextSize(0, this.mTabTextSize);
                textView.setTypeface(this.mTabTypeface, 0);
                textView.setTextColor(this.mCurrentSelectedPosition == i ? this.mTabTextColorSelected : this.mTabTextColorNormal);
            }
            i++;
        }
    }

    public View getTabView(int i) {
        LinearLayout linearLayout = this.mTabsContainer;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.getChildAt(i);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.mTabCount == 0) {
            return;
        }
        float height = getHeight() - 1;
        canvas.drawLine(0.0f, height, this.mTabsContainer.getWidth(), height, this.mBottomLinePaint);
        canvas.drawRect(this.mIndicatorRect, this.mRectPaint);
        if (this.mRoundCorner) {
            float fHeight = this.mIndicatorRect.height() * 0.5f;
            canvas.drawCircle(this.mIndicatorRect.left, this.mIndicatorRect.top + fHeight, fHeight, this.mRectPaint);
            canvas.drawCircle(this.mIndicatorRect.right, this.mIndicatorRect.top + fHeight, fHeight, this.mRectPaint);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = this.mEnableScroll;
        this.mInnerEnableScroll = z2;
        if (!z2 || this.mTabsContainer.getWidth() - this.mScreenWidth > UIUtil.dp2px(this.mTabMargin)) {
            return;
        }
        this.mInnerEnableScroll = false;
        scrollTo((int) (((this.mTabsContainer.getWidth() - this.mScreenWidth) * 0.5f) + 0.5f), 0);
        requestLayout();
    }

    public void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        this.mRectPaint.setColor(i);
        invalidate();
    }

    public void setBottomDividerColor(int i) {
        Paint paint = this.mBottomLinePaint;
        if (paint != null) {
            paint.setColor(i);
            invalidate();
        }
    }

    protected void selectTab(int i) {
        int i2 = this.mCurrentSelectedPosition;
        if (i2 != i && i < this.mTabCount && i >= 0) {
            NewsPagerTabView newsPagerTabView = (NewsPagerTabView) this.mTabsContainer.getChildAt(i2);
            if (newsPagerTabView != null) {
                newsPagerTabView.setSelected(false);
                newsPagerTabView.setTextColor(this.mTabTextColorNormal);
                newsPagerTabView.setTextSize(this.mTabTextSize);
                if (this.mEnableTextStroke) {
                    newsPagerTabView.setStrokeWidth(0.0f);
                }
            }
            this.mCurrentSelectedPosition = i;
            NewsPagerTabView newsPagerTabView2 = (NewsPagerTabView) this.mTabsContainer.getChildAt(i);
            if (newsPagerTabView2 != null) {
                newsPagerTabView2.setSelected(true);
                newsPagerTabView2.setTextColor(this.mTabTextColorSelected);
                newsPagerTabView2.setTextSize(this.mTabTextSizeSelected);
                if (this.mEnableTextStroke) {
                    newsPagerTabView2.setStrokeWidth(1.0f);
                }
            }
        }
    }

    public void scrollToCurrent() {
        int centerAlignScroll = getCenterAlignScroll(this.mCurrentSelectedPosition);
        int scrollX = getScrollX();
        if (this.mInScrollAnimate || centerAlignScroll == scrollX) {
            return;
        }
        new ScrollAnim().startAnim(scrollX, centerAlignScroll);
    }

    public int getCenterAlignScroll(int i) {
        if (i < 0 || i >= this.mTabsContainer.getChildCount()) {
            return 0;
        }
        View childAt = this.mTabsContainer.getChildAt(i);
        return (childAt.getLeft() + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    public void getIndicatorPosition(int i, float[] fArr) {
        if (i < 0 || i >= this.mTabsContainer.getChildCount()) {
            return;
        }
        View childAt = this.mTabsContainer.getChildAt(i);
        int left = childAt.getLeft();
        int right = childAt.getRight();
        float f = right - left;
        float f2 = this.mIndicatorWidth;
        if (f >= f2) {
            float f3 = (f - f2) * 0.5f;
            fArr[0] = left + f3;
            fArr[1] = right - f3;
        } else {
            fArr[0] = left;
            fArr[1] = right;
        }
    }

    class ScrollAnim extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private int mEndScroll;
        private int mStartScroll;

        ScrollAnim() {
        }

        public void startAnim(int i, int i2) {
            this.mStartScroll = i;
            this.mEndScroll = i2;
            removeAllUpdateListeners();
            addUpdateListener(this);
            setFloatValues(0.0f, 1.0f);
            setDuration(240L);
            setInterpolator(NewsPagerSlidingTab.this.mInterpolator);
            NewsPagerSlidingTab.this.mInScrollAnimate = true;
            start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i = (int) (this.mStartScroll + ((this.mEndScroll - r0) * fFloatValue) + 0.5f);
            if (NewsPagerSlidingTab.this.mInnerEnableScroll) {
                NewsPagerSlidingTab.this.scrollTo(i, 0);
            }
            NewsPagerSlidingTab.this.invalidate();
            if (fFloatValue == 1.0f) {
                NewsPagerSlidingTab.this.mInScrollAnimate = false;
            }
        }
    }

    class IndicatorAnim extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {
        private float endLeft;
        private float endRight;
        private int endScroll;
        private float startLeft;
        private float startRight;
        private int startScroll;

        IndicatorAnim() {
        }

        public void startAnim(int i, int i2) {
            int childCount = NewsPagerSlidingTab.this.mTabsContainer.getChildCount();
            if (i < 0 || i >= childCount || i2 < 0 || i2 >= childCount) {
                return;
            }
            float[] fArr = new float[2];
            NewsPagerSlidingTab.this.getIndicatorPosition(i, fArr);
            this.startLeft = fArr[0];
            this.startRight = fArr[1];
            NewsPagerSlidingTab.this.getIndicatorPosition(i2, fArr);
            this.endLeft = fArr[0];
            this.endRight = fArr[1];
            this.startScroll = NewsPagerSlidingTab.this.getScrollX();
            this.endScroll = NewsPagerSlidingTab.this.getCenterAlignScroll(i2);
            removeAllUpdateListeners();
            addUpdateListener(this);
            setInterpolator(NewsPagerSlidingTab.this.mInterpolator);
            start();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f = this.startLeft;
            float f2 = f + ((this.endLeft - f) * fFloatValue);
            float f3 = this.startRight;
            float f4 = f3 + ((this.endRight - f3) * fFloatValue);
            float f5 = fFloatValue <= 0.5f ? NewsPagerSlidingTab.this.mIndicatorWidth * fFloatValue : NewsPagerSlidingTab.this.mIndicatorWidth * (1.0f - fFloatValue);
            if (this.endLeft > this.startLeft) {
                f4 += f5;
            } else {
                f2 -= f5;
            }
            NewsPagerSlidingTab.this.mIndicatorRect.set(f2, r3 - NewsPagerSlidingTab.this.mIndicatorHeight, f4, NewsPagerSlidingTab.this.getHeight());
            int i = (int) (this.startScroll + ((this.endScroll - r0) * fFloatValue) + 0.5f);
            if (NewsPagerSlidingTab.this.mInnerEnableScroll) {
                NewsPagerSlidingTab.this.scrollTo(i, 0);
            }
            NewsPagerSlidingTab.this.invalidate();
        }
    }

    public void setThreShold(int i) {
        this.mThreShold = i;
    }

    public void setEnableScroll(boolean z) {
        this.mEnableScroll = z;
    }

    public void setTabMargin(int i) {
        this.mTabMargin = i;
    }

    public void setTabWidth(int i) {
        this.mTabWidth = i;
    }

    public void shouldExpand(boolean z) {
        this.mShouldExpand = z;
    }

    private class PageListener implements ViewPager.OnPageChangeListener {
        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (i >= NewsPagerSlidingTab.this.mTabsContainer.getChildCount()) {
                return;
            }
            int currentItem = NewsPagerSlidingTab.this.mPager.getCurrentItem();
            NewsPagerSlidingTab.this.mCurrentPosition = i;
            NewsPagerSlidingTab.this.mCurrentPositionOffset = f;
            if (f == 0.0f) {
                NewsPagerSlidingTab.this.mScrollOrentaion = 0;
            } else if (NewsPagerSlidingTab.this.mScrollOrentaion == 0) {
                if (currentItem == i) {
                    NewsPagerSlidingTab.this.mScrollOrentaion = 1;
                } else {
                    NewsPagerSlidingTab.this.mScrollOrentaion = 2;
                }
            }
            NewsPagerSlidingTab.this.updateTextWidth(i);
            NewsPagerSlidingTab.this.scrollToChild(i, (int) (r0.mTabsContainer.getChildAt(i).getWidth() * f));
            NewsPagerSlidingTab.this.updateIndicatorRect();
            NewsPagerSlidingTab.this.invalidate();
            if (NewsPagerSlidingTab.this.mDelegatePageListener != null) {
                NewsPagerSlidingTab.this.mDelegatePageListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                NewsPagerSlidingTab newsPagerSlidingTab = NewsPagerSlidingTab.this;
                newsPagerSlidingTab.scrollToChild(newsPagerSlidingTab.mPager.getCurrentItem(), 0);
            }
            if (NewsPagerSlidingTab.this.mDelegatePageListener != null) {
                NewsPagerSlidingTab.this.mDelegatePageListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            NewsPagerSlidingTab.this.selectTab(i);
            if (NewsPagerSlidingTab.this.mDelegatePageListener != null) {
                NewsPagerSlidingTab.this.mDelegatePageListener.onPageSelected(i);
            }
        }
    }

    protected void scrollToChild(int i, int i2) {
        if (this.mTabCount != 0 && i >= 0 && i < this.mTabsContainer.getChildCount()) {
            if (!this.mIsTabScrollToCenter) {
                int left = this.mTabsContainer.getChildAt(i).getLeft() + i2;
                if (i > 0 || i2 > 0) {
                    left -= this.mScrollOffset;
                }
                if (left != this.mLastScrollX) {
                    this.mLastScrollX = left;
                    if (this.mInnerEnableScroll) {
                        scrollTo(left, 0);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i2 == 0) {
                View childAt = this.mTabsContainer.getChildAt(i);
                int left2 = (childAt.getLeft() + (childAt.getWidth() / 2)) - (getWidth() / 2);
                if (this.mInnerEnableScroll) {
                    scrollTo(left2, 0);
                    return;
                }
                return;
            }
            if (this.mScrollOrentaion == 1) {
                View childAt2 = this.mTabsContainer.getChildAt(i + 1);
                View childAt3 = this.mTabsContainer.getChildAt(i);
                int left3 = (childAt3.getLeft() + (childAt3.getWidth() / 2)) - (getWidth() / 2);
                if (childAt2 != null) {
                    int left4 = (int) (left3 + ((((childAt2.getLeft() + (childAt2.getWidth() / 2)) - (getWidth() / 2)) - left3) * this.mCurrentPositionOffset) + 0.5f);
                    if (this.mInnerEnableScroll) {
                        scrollTo(left4, 0);
                        return;
                    }
                    return;
                }
                return;
            }
            View childAt4 = this.mTabsContainer.getChildAt(i + 1);
            View childAt5 = this.mTabsContainer.getChildAt(i);
            if (childAt4 != null) {
                int left5 = (int) (((childAt4.getLeft() + (childAt4.getWidth() / 2)) - (getWidth() / 2)) + ((((childAt5.getLeft() + (childAt5.getWidth() / 2)) - (getWidth() / 2)) - r2) * (1.0f - this.mCurrentPositionOffset)) + 0.5f);
                if (this.mInnerEnableScroll) {
                    scrollTo(left5, 0);
                }
            }
        }
    }

    public void updateTextWidth(int i) {
        if (!this.mEnableTextStroke || i < 0 || i >= this.mTabsContainer.getChildCount()) {
            return;
        }
        int i2 = this.mScrollOrentaion;
        if (i2 == 0 || this.mCurrentPositionOffset == 0.0f) {
            NewsPagerTabView newsPagerTabView = (NewsPagerTabView) this.mTabsContainer.getChildAt(this.mCurrentSelectedPosition);
            if (newsPagerTabView != null) {
                newsPagerTabView.setStrokeWidth(0.0f);
            }
            ((NewsPagerTabView) this.mTabsContainer.getChildAt(i)).setStrokeWidth(1.0f);
            return;
        }
        if (i2 == 1) {
            NewsPagerTabView newsPagerTabView2 = (NewsPagerTabView) this.mTabsContainer.getChildAt(i);
            NewsPagerTabView newsPagerTabView3 = (NewsPagerTabView) this.mTabsContainer.getChildAt(i + 1);
            if (newsPagerTabView3 != null) {
                newsPagerTabView2.setStrokeWidth((1.0f - this.mCurrentPositionOffset) * 1.0f);
                newsPagerTabView2.invalidate();
                newsPagerTabView3.setStrokeWidth(this.mCurrentPositionOffset * 1.0f);
                newsPagerTabView3.invalidate();
                return;
            }
            return;
        }
        NewsPagerTabView newsPagerTabView4 = (NewsPagerTabView) this.mTabsContainer.getChildAt(i + 1);
        NewsPagerTabView newsPagerTabView5 = (NewsPagerTabView) this.mTabsContainer.getChildAt(i);
        if (newsPagerTabView4 != null) {
            newsPagerTabView4.setStrokeWidth(this.mCurrentPositionOffset * 1.0f);
        }
        newsPagerTabView5.setStrokeWidth((1.0f - this.mCurrentPositionOffset) * 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIndicatorRect() {
        int i;
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentPosition);
        if (childAt == null) {
            return;
        }
        float left = childAt.getLeft();
        float right = childAt.getRight();
        float f = right - left;
        float f2 = this.mIndicatorWidth;
        if (f >= f2) {
            float f3 = (f - f2) * 0.5f;
            left += f3;
            right -= f3;
            f = f2;
        }
        if (this.mCurrentPositionOffset > 0.0f && (i = this.mCurrentPosition) < this.mTabCount - 1) {
            View childAt2 = this.mTabsContainer.getChildAt(i + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f4 = right2 - left2;
            if (f4 > f) {
                float f5 = (f4 - f) * 0.5f;
                left2 += f5;
                right2 -= f5;
            }
            float f6 = this.mCurrentPositionOffset;
            left = (left2 * f6) + ((1.0f - f6) * left);
            right = (right2 * f6) + ((1.0f - f6) * right);
            if (f6 > 0.5f) {
                f6 = 1.0f - f6;
            }
            float f7 = (f6 / 0.5f) * f;
            if (this.mScrollOrentaion == 1) {
                right += f7;
            } else {
                left -= f7;
            }
        }
        this.mIndicatorRect.set(left, r2 - this.mIndicatorHeight, right, getHeight());
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int currentPosition;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }

    public void setTabClickListener(TabClickListener tabClickListener) {
        this.mTabClickListener = tabClickListener;
    }

    public static class Tab {
        public static final String NONE = "";
        private View customView;
        private final String id;
        private int position;
        private int tabMargin;
        private View tabView;
        private int tabWidth;
        private CharSequence text;

        public interface Provider {
            Tab getTab(int i);

            Tab getTab(String str);

            String getTabIdByPosition(int i);

            int getTabPositionById(String str);
        }

        public Tab(String str) {
            this.tabMargin = 10;
            this.tabWidth = -2;
            this.id = str;
        }

        public void setTabView(int i) {
            this.tabMargin = i;
        }

        public void setTabWidth(int i) {
            this.tabWidth = i;
        }

        public Tab(String str, CharSequence charSequence) {
            this(str);
            this.text = charSequence;
        }

        public Tab(String str, View view) {
            this(str);
            this.customView = view;
        }

        public CharSequence getText() {
            return this.text;
        }

        public void setText(CharSequence charSequence) {
            this.text = charSequence;
            View view = this.tabView;
            if (view instanceof TextView) {
                ((TextView) view).setText(charSequence);
            } else if (view instanceof NewsPagerTabView) {
                ((NewsPagerTabView) view).setText(charSequence);
            }
        }

        public View getCustomView() {
            return this.customView;
        }

        public View getTabView() {
            return this.tabView;
        }

        public int getPosition() {
            return this.position;
        }

        public View buildTabView(Context context, final int i, final ViewPager viewPager) {
            this.position = i;
            View view = this.customView;
            if (view != null) {
                this.tabView = view;
            } else {
                NewsPagerTabView newsPagerTabView = new NewsPagerTabView(context, this.tabMargin, this.tabWidth);
                this.tabView = newsPagerTabView;
                newsPagerTabView.setText(this.text);
                this.tabView.setFocusable(true);
                ((NewsPagerTabView) this.tabView).setGravity(17);
            }
            this.tabView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.tab.NewsPagerSlidingTab.Tab.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) throws Resources.NotFoundException {
                    viewPager.setCurrentItem(i);
                }
            });
            return this.tabView;
        }

        public String getId() {
            return this.id;
        }
    }
}
