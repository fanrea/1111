package com.duoyou.task.sdk.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.duoyou.task.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CircleLoadingView extends LinearLayout {
    private final Handler handler;
    private ImageView lastImageView;
    private int position;

    public static /* synthetic */ int access$008(CircleLoadingView circleLoadingView) {
        int i = circleLoadingView.position;
        circleLoadingView.position = i + 1;
        return i;
    }

    public CircleLoadingView(Context context) {
        super(context);
        this.handler = new Handler(new Handler.Callback() { // from class: com.duoyou.task.sdk.view.CircleLoadingView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    if (CircleLoadingView.this.position > CircleLoadingView.this.getChildCount() - 1) {
                        CircleLoadingView.this.position = 0;
                    }
                    if (CircleLoadingView.this.lastImageView != null) {
                        CircleLoadingView.this.lastImageView.setImageResource(R.drawable.dy_loading_grey_circle_normal);
                    }
                    CircleLoadingView circleLoadingView = CircleLoadingView.this;
                    ImageView imageView = (ImageView) circleLoadingView.getChildAt(circleLoadingView.position);
                    imageView.setImageResource(R.drawable.dy_loading_yellow_circle_select);
                    CircleLoadingView.this.lastImageView = imageView;
                    CircleLoadingView.access$008(CircleLoadingView.this);
                    CircleLoadingView.this.handler.sendEmptyMessageDelayed(1, 350L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        initView();
    }

    public CircleLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler(new Handler.Callback() { // from class: com.duoyou.task.sdk.view.CircleLoadingView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    if (CircleLoadingView.this.position > CircleLoadingView.this.getChildCount() - 1) {
                        CircleLoadingView.this.position = 0;
                    }
                    if (CircleLoadingView.this.lastImageView != null) {
                        CircleLoadingView.this.lastImageView.setImageResource(R.drawable.dy_loading_grey_circle_normal);
                    }
                    CircleLoadingView circleLoadingView = CircleLoadingView.this;
                    ImageView imageView = (ImageView) circleLoadingView.getChildAt(circleLoadingView.position);
                    imageView.setImageResource(R.drawable.dy_loading_yellow_circle_select);
                    CircleLoadingView.this.lastImageView = imageView;
                    CircleLoadingView.access$008(CircleLoadingView.this);
                    CircleLoadingView.this.handler.sendEmptyMessageDelayed(1, 350L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
        initView();
    }

    private void initView() {
        setOrientation(0);
        removeAllViews();
        for (int i = 0; i < 5; i++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.width = dpToPx(7);
            layoutParams.height = dpToPx(7);
            layoutParams.leftMargin = dpToPx(5);
            layoutParams.rightMargin = dpToPx(5);
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.dy_loading_grey_circle_normal);
            addView(imageView);
        }
    }

    public void startLoading() {
        this.handler.sendEmptyMessage(1);
    }

    public void hideLoading() {
        this.handler.removeMessages(1);
    }

    public int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }
}
