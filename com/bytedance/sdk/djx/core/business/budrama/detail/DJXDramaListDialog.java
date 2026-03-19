package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.budrama.detail.DramaDialogItemView;
import com.bytedance.sdk.djx.core.business.view.DJXInterceptLinearLayout;
import com.bytedance.sdk.djx.core.business.view.refresh.DJXRefreshLayout;
import com.bytedance.sdk.djx.core.business.view.rv.decoration.GridItemDecoration;
import com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter;
import com.bytedance.sdk.djx.core.business.view.rv2.base.CommonViewHolder;
import com.bytedance.sdk.djx.core.business.view.rv2.base.ItemView;
import com.bytedance.sdk.djx.core.business.view.rv2.base.ItemViewFactory;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaListDialog extends Dialog {
    private static final String TAG = "DJXDramaListDialog";
    private final List<TextView> labels;
    private BaseAdapter mAdapter;
    private DJXInterceptLinearLayout mContentLayout;
    private final List<Object> mDataList;
    private View mDialogLayout;
    private Drama mDrama;
    private OnDramaListDialogListener mDramaListDialogListener;
    private int mInitIndex;
    private LinearLayout mLabelLayout;
    private float mLastY;
    private RecyclerView mRecyclerView;
    private DJXRefreshLayout mRefreshLayout;
    private TextView selectedLabel;

    public static class DramaItem {
        public String coverImage;
        public int index;
    }

    public interface OnDramaListDialogListener {
        boolean isCurrentIndex(int i);

        boolean isNeedLock(DramaItem dramaItem);

        void onItemClick(int i);
    }

    public DJXDramaListDialog(Context context) {
        super(context, R.style.djx_draw_share_dialog_style);
        this.mDataList = new ArrayList();
        this.mInitIndex = -1;
        this.labels = new ArrayList();
        this.selectedLabel = null;
    }

    public void setDrama(Drama drama) {
        this.mDrama = drama;
    }

    public void setInitIndex(int i) {
        this.mInitIndex = i;
    }

    public void setDramaListDialogListener(OnDramaListDialogListener onDramaListDialogListener) {
        this.mDramaListDialogListener = onDramaListDialogListener;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.djx_drama_list_dialog_layout);
        if (getWindow() != null) {
            try {
                getWindow().setWindowAnimations(R.style.djx_animation_share_style);
            } catch (Throwable unused) {
            }
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        initView();
    }

    public void initView() {
        this.mDialogLayout = findViewById(R.id.djx_dialog_layout);
        DJXInterceptLinearLayout dJXInterceptLinearLayout = (DJXInterceptLinearLayout) findViewById(R.id.djx_content_layout);
        this.mContentLayout = dJXInterceptLinearLayout;
        dJXInterceptLinearLayout.setOnInterceptListener(new DJXInterceptLinearLayout.OnInterceptListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.1
            @Override // com.bytedance.sdk.djx.core.business.view.DJXInterceptLinearLayout.OnInterceptListener
            public boolean needIntercept() {
                return DJXDramaListDialog.this.canPullDialog();
            }
        });
        findViewById(R.id.djx_view_cancel1).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXDramaListDialog.this.dismiss();
            }
        });
        findViewById(R.id.djx_close).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXDramaListDialog.this.dismiss();
            }
        });
        ((TextView) findViewById(R.id.djx_drama_title)).setText(this.mDrama.title);
        ((TextView) findViewById(R.id.djx_drama_total_num)).setText(String.format("共%s集", Integer.valueOf(this.mDrama.total)));
        initDramaLabelLayout();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.djx_recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        this.mAdapter = new BaseAdapter(new ItemViewFactory() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.4
            @Override // com.bytedance.sdk.djx.core.business.view.rv2.base.ItemViewFactory
            public ItemView create(Object obj) {
                if (obj instanceof DramaItem) {
                    return new DramaDialogItemView(DJXDramaListDialog.this.mRecyclerView, (DramaItem) obj, new DramaDialogItemView.OnDramaDialogItemListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.4.1
                        @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDialogItemView.OnDramaDialogItemListener
                        public boolean isNeedLock(DramaItem dramaItem) {
                            return DJXDramaListDialog.this.mDramaListDialogListener != null && DJXDramaListDialog.this.mDramaListDialogListener.isNeedLock(dramaItem);
                        }

                        @Override // com.bytedance.sdk.djx.core.business.budrama.detail.DramaDialogItemView.OnDramaDialogItemListener
                        public boolean isCurrentIndex(int i) {
                            return DJXDramaListDialog.this.mDramaListDialogListener.isCurrentIndex(i);
                        }
                    });
                }
                return null;
            }
        });
        this.mRecyclerView.addItemDecoration(new GridItemDecoration(getContext(), 0, UIUtil.dp2px(6.0f)));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.5
            @Override // com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter.OnItemClickListener
            public boolean onItemLongClick(View view, Object obj, CommonViewHolder commonViewHolder, int i) {
                return false;
            }

            @Override // com.bytedance.sdk.djx.core.business.view.rv2.adapter.BaseAdapter.OnItemClickListener
            public void onItemClick(View view, Object obj, CommonViewHolder commonViewHolder, int i) {
                if (obj instanceof DramaItem) {
                    if (DJXDramaListDialog.this.mDramaListDialogListener != null) {
                        DJXDramaListDialog.this.mDramaListDialogListener.onItemClick(((DramaItem) obj).index);
                    }
                    DJXDramaListDialog.this.dismiss();
                }
            }
        });
        int i = this.mInitIndex;
        int i2 = i - ((i - 1) % 30);
        this.mAdapter.addAll(createDataList(i2, Math.min(i2 + 29, this.mDrama.total) + 1));
        int i3 = this.mInitIndex - i2;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.scrollToPosition(i3);
        }
    }

    private void initDramaLabelLayout() {
        this.labels.clear();
        this.mLabelLayout = (LinearLayout) findViewById(R.id.djx_drama_label_layout);
        int i = this.mDrama.total;
        for (final int i2 = 1; i2 <= i; i2 += 30) {
            final int iMin = Math.min(i2 + 29, i);
            final TextView textView = new TextView(getContext());
            textView.setTextSize(14.0f);
            textView.setText(String.format("%d-%d", Integer.valueOf(i2), Integer.valueOf(iMin)));
            textView.setTextColor(Color.parseColor("#090909"));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaListDialog.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DJXDramaListDialog.this.selectedLabel != null) {
                        DJXDramaListDialog.this.selectedLabel.setTextColor(Color.parseColor("#090909"));
                    }
                    DJXDramaListDialog.this.selectedLabel = textView;
                    DJXDramaListDialog.this.selectedLabel.setTextColor(Color.parseColor("#E7601F"));
                    DJXDramaListDialog.this.mAdapter.removeAll();
                    DJXDramaListDialog.this.mAdapter.addAll(DJXDramaListDialog.this.createDataList(i2, iMin + 1));
                }
            });
            int i3 = this.mInitIndex;
            if (i3 >= i2 && i3 <= iMin) {
                this.selectedLabel = textView;
                textView.setTextColor(Color.parseColor("#E7601F"));
            }
            this.labels.add(textView);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = UIUtil.dp2px(12.0f);
            this.mLabelLayout.addView(textView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Object> createDataList(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i < i2) {
            DramaItem dramaItem = new DramaItem();
            dramaItem.index = i;
            dramaItem.coverImage = this.mDrama.coverImage;
            arrayList.add(dramaItem);
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canPullDialog() {
        return this.mRecyclerView.getScrollY() <= 0 && !this.mRecyclerView.canScrollVertically(-1);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (canPullDialog()) {
            int action = motionEvent.getAction();
            if (action == 1) {
                if (this.mDialogLayout.getScrollY() < (-this.mContentLayout.getHeight()) / 4) {
                    dismiss();
                }
                this.mDialogLayout.scrollTo(0, 0);
            } else if (action == 2) {
                if (this.mLastY > 0.0f) {
                    this.mDialogLayout.scrollBy(0, -((int) (motionEvent.getY() - this.mLastY)));
                    if (this.mDialogLayout.getScrollY() > 0) {
                        this.mDialogLayout.scrollTo(0, 0);
                    }
                }
                this.mLastY = motionEvent.getY();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (getWindow() != null) {
            try {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.gravity = 80;
                attributes.width = -1;
                attributes.height = -1;
                getWindow().getDecorView().setPadding(0, 0, 0, 0);
                getWindow().setAttributes(attributes);
            } catch (Throwable unused) {
            }
        }
    }
}
