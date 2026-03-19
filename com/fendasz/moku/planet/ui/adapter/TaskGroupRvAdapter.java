package com.fendasz.moku.planet.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.TaskGroupRvInterface;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskData;
import com.fendasz.moku.planet.source.bean.taskdatagroup.ClientGroupTaskDataStatusEnum;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.StringUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TaskGroupRvAdapter extends RecyclerView.Adapter<TaskGroupRvViewHolder> {
    private static final String TAG = "TaskGroupRvAdapter";
    private List<ClientGroupTaskData> clientGroupTaskDataList;
    private Bitmap mBitMapEnabledAndSelected;
    private Bitmap mBitMapEnabledAndUnSelected;
    private Bitmap mBitMapUnabled;
    private final Context mContext;
    private PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
    private TaskGroupRvInterface taskGroupRvInterface;

    public TaskGroupRvAdapter(Context context) {
        this.mContext = context;
    }

    public void setClientGroupTaskDataList(List<ClientGroupTaskData> list) {
        this.clientGroupTaskDataList = list;
    }

    public List<ClientGroupTaskData> getClientGroupTaskDataList() {
        return this.clientGroupTaskDataList;
    }

    public void setOnItemClickListener(TaskGroupRvInterface taskGroupRvInterface) {
        this.taskGroupRvInterface = taskGroupRvInterface;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TaskGroupRvViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TaskGroupRvViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.moku_task_cpa_group_rv_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TaskGroupRvViewHolder taskGroupRvViewHolder, final int i) {
        ClientGroupTaskData clientGroupTaskData = this.clientGroupTaskDataList.get(i);
        ScreenAdaptationUtils.setWidth(this.mContext, taskGroupRvViewHolder.llTaskGroupRvItem, 320);
        ScreenAdaptationUtils.setHeight(this.mContext, taskGroupRvViewHolder.llTaskGroupRvItem, 190);
        ScreenAdaptationUtils.setMarginRight(this.mContext, taskGroupRvViewHolder.llTaskGroupRvItem, 25);
        ScreenAdaptationUtils.setMarginBottom(this.mContext, taskGroupRvViewHolder.llTaskGroupRvItem, 25);
        int scale = this.phoneScreenUtils.getScale(this.mContext, 190);
        int scale2 = this.phoneScreenUtils.getScale(this.mContext, 320);
        int i2 = scale / 6;
        ScreenAdaptationUtils.setPaddingBottom(this.mContext, taskGroupRvViewHolder.llTaskGroupRvItem, 31);
        taskGroupRvViewHolder.llTaskGroupRvItem.setBackground(createDrawableSelector(scale2, scale, i2, i2));
        taskGroupRvViewHolder.tvTaskGroupRvItem.setText((i + 1) + "");
        taskGroupRvViewHolder.tvTaskGroupRvItem.setTextSize(this.phoneScreenUtils.getSmall35TextSize(this.mContext));
        ScreenAdaptationUtils.setWidth(this.mContext, taskGroupRvViewHolder.tvTaskGroupRvItem, 45);
        ScreenAdaptationUtils.setHeight(this.mContext, taskGroupRvViewHolder.tvTaskGroupRvItem, 45);
        ScreenAdaptationUtils.setMarginLeftAndRight(this.mContext, taskGroupRvViewHolder.tvTaskGroupRvItem, 5);
        taskGroupRvViewHolder.tvTaskGroupRvItemTitle.setText(String.format("%s", clientGroupTaskData.getShowName()));
        taskGroupRvViewHolder.tvTaskGroupRvItemTitle.setTextSize(this.phoneScreenUtils.getSmallTextSize(this.mContext));
        taskGroupRvViewHolder.tvTaskGroupRvItemMoney.setTextSize(this.phoneScreenUtils.getTipsTextSize(this.mContext));
        if (clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_OPENING)) {
            clientGroupTaskData.setOpen(true);
            taskGroupRvViewHolder.tvTaskGroupRvItemMoney.setText(StringUtils.formatMoney(clientGroupTaskData.getShowMoney().toString()) + clientGroupTaskData.getCybermoneyName());
            taskGroupRvViewHolder.llTaskGroupRvItem.setEnabled(true);
            taskGroupRvViewHolder.tvTaskGroupRvItem.setEnabled(true);
            taskGroupRvViewHolder.tvTaskGroupRvItemTitle.setEnabled(true);
            taskGroupRvViewHolder.tvTaskGroupRvItemMoney.setEnabled(true);
            if (clientGroupTaskData.isSelected()) {
                taskGroupRvViewHolder.llTaskGroupRvItem.setSelected(true);
            } else {
                taskGroupRvViewHolder.llTaskGroupRvItem.setSelected(false);
            }
        } else {
            clientGroupTaskData.setOpen(false);
            if (clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_WAITING_OPENED) || clientGroupTaskData.getStatus().equals(ClientGroupTaskDataStatusEnum.STATUS_OF_SUBSEQUENT_OPENING)) {
                taskGroupRvViewHolder.tvTaskGroupRvItemMoney.setText(StringUtils.formatMoney(clientGroupTaskData.getShowMoney().toString()) + clientGroupTaskData.getCybermoneyName());
            } else {
                taskGroupRvViewHolder.tvTaskGroupRvItemMoney.setText(clientGroupTaskData.getStatus().getStatusExplain());
            }
            taskGroupRvViewHolder.llTaskGroupRvItem.setEnabled(false);
            taskGroupRvViewHolder.tvTaskGroupRvItem.setEnabled(false);
            taskGroupRvViewHolder.tvTaskGroupRvItemTitle.setEnabled(false);
            taskGroupRvViewHolder.tvTaskGroupRvItemMoney.setEnabled(false);
        }
        taskGroupRvViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.adapter.TaskGroupRvAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m437x7e6379c0(i, view);
            }
        });
    }

    /* renamed from: lambda$onBindViewHolder$0$com-fendasz-moku-planet-ui-adapter-TaskGroupRvAdapter, reason: not valid java name */
    /* synthetic */ void m437x7e6379c0(int i, View view) {
        TaskGroupRvInterface taskGroupRvInterface = this.taskGroupRvInterface;
        if (taskGroupRvInterface != null) {
            taskGroupRvInterface.onItemClickListener(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.clientGroupTaskDataList.size();
    }

    private StateListDrawable createDrawableSelector(int i, int i2, int i3, int i4) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.mBitMapEnabledAndSelected == null) {
            this.mBitMapEnabledAndSelected = getBitMap(android.R.attr.state_enabled, android.R.attr.state_selected, i, i2, i3, i4);
        }
        if (this.mBitMapEnabledAndUnSelected == null) {
            this.mBitMapEnabledAndUnSelected = getBitMap(android.R.attr.state_enabled, -16842913, i, i2, i3, i4);
        }
        if (this.mBitMapUnabled == null) {
            this.mBitMapUnabled = getBitMap(-16842910, -16842913, i, i2, i3, i4);
        }
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_selected}, new BitmapDrawable((Resources) null, this.mBitMapEnabledAndSelected));
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, -16842913}, new BitmapDrawable((Resources) null, this.mBitMapEnabledAndUnSelected));
        stateListDrawable.addState(new int[]{-16842910}, new BitmapDrawable((Resources) null, this.mBitMapUnabled));
        return stateListDrawable;
    }

    private Bitmap getBitMap(int i, int i2, int i3, int i4, int i5, int i6) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4 + i6, Bitmap.Config.ARGB_8888);
        draw(new Canvas(bitmapCreateBitmap), i, i2, i3, i4, i5, i6);
        return bitmapCreateBitmap;
    }

    private void draw(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i3 / 2;
        Paint paint = new Paint(1);
        paint.setStrokeWidth(2);
        if (i == 16842910) {
            paint.setColor(this.mContext.getResources().getColor(R.color.moku_primary_color));
            paint.setStyle(Paint.Style.STROKE);
            Path path = new Path();
            float f = 1;
            int i9 = i5 * 2;
            float f2 = 1 + i9;
            path.addArc(new RectF(f, f, f2, f2), 180.0f, 90.0f);
            int i10 = i3 - 1;
            path.lineTo(i10 - i5, f);
            float f3 = i10 - i9;
            float f4 = i10;
            path.addArc(new RectF(f3, f, f4, f2), 270.0f, 90.0f);
            path.lineTo(f4, i4 - i5);
            float f5 = i4 - i9;
            float f6 = i4;
            path.addArc(new RectF(f3, f5, f4, f6), 0.0f, 90.0f);
            if (i2 == 16842913) {
                int i11 = (i6 / 3) * 2;
                path.lineTo(i8 + i11, f6);
                i7 = 1;
                path.lineTo(i8, (i4 + i6) - 1);
                path.lineTo(i8 - i11, f6);
            } else {
                i7 = 1;
            }
            float f7 = i7 + i5;
            path.lineTo(f7, f6);
            path.addArc(new RectF(f, f5, f2, f6), 90.0f, 90.0f);
            path.lineTo(f, f7);
            canvas.drawPath(path, paint);
            return;
        }
        paint.setColor(this.mContext.getResources().getColor(R.color.moku_gray_very_light));
        paint.setStyle(Paint.Style.FILL);
        float f8 = i5;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, i3, i4), f8, f8, paint);
    }

    static class TaskGroupRvViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llTaskGroupRvItem;
        TextView tvTaskGroupRvItem;
        TextView tvTaskGroupRvItemMoney;
        TextView tvTaskGroupRvItemTitle;

        public TaskGroupRvViewHolder(View view) {
            super(view);
            this.llTaskGroupRvItem = (LinearLayout) view.findViewById(R.id.ll_task_group_rv_item);
            this.tvTaskGroupRvItem = (TextView) view.findViewById(R.id.tv_task_group_rv_item_index);
            this.tvTaskGroupRvItemTitle = (TextView) view.findViewById(R.id.tv_task_group_rv_item_title);
            this.tvTaskGroupRvItemMoney = (TextView) view.findViewById(R.id.tv_task_group_rv_item_money);
        }
    }
}
