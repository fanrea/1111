package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.djx.utils.ToolUtils;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.bytedance.sdk.djx.utils.WeakHandler;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawSeekLayout extends FrameLayout implements WeakHandler.IHandler {
    private static final String TAG = "DJXDrawSeekLayout";
    private static final int WHAT_SHOW_DRAG_FALSE = 141;
    private int mBarStyle;
    private int mDragHeight;
    private final WeakHandler mHandler;
    private boolean mIsDragged;
    private ImageView mIvThumb;
    private final int mNormalHeight;
    private SeekBar.OnSeekBarChangeListener mOutSeekBarChangeListener;
    private SeekBar mSeekBar;
    private final SeekBar.OnSeekBarChangeListener mSeekBarChangeListener;
    private View mSeekView;
    private LinearLayout mTipLayout;
    private TextView mTvCurrent;
    private TextView mTvTotal;

    public DJXDrawSeekLayout(Context context) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context);
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mIsDragged = false;
        this.mBarStyle = 1;
        this.mDragHeight = 60;
        this.mNormalHeight = 24;
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawSeekLayout.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    DJXDrawSeekLayout.this.updateSeekTip(i);
                    DJXDrawSeekLayout.this.mHandler.removeMessages(141);
                }
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onProgressChanged(seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                DJXDrawSeekLayout.this.mHandler.removeMessages(141);
                DJXDrawSeekLayout.this.mIsDragged = true;
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
                DJXDrawSeekLayout.this.updateSeekTip(seekBar.getProgress());
                DJXDrawSeekLayout.this.mTipLayout.setVisibility(0);
                DJXDrawSeekLayout.this.mIvThumb.setVisibility(8);
                DJXDrawSeekLayout.this.showDragState(true);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DJXDrawSeekLayout.this.mIsDragged = false;
                DJXDrawSeekLayout.this.mTipLayout.setVisibility(8);
                DJXDrawSeekLayout.this.mIvThumb.setImageDrawable(new ColorDrawable(0));
                DJXDrawSeekLayout.this.mIvThumb.setVisibility(8);
                DJXDrawSeekLayout.this.mHandler.sendEmptyMessageDelayed(141, 1000L);
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public DJXDrawSeekLayout(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context, attributeSet);
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mIsDragged = false;
        this.mBarStyle = 1;
        this.mDragHeight = 60;
        this.mNormalHeight = 24;
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawSeekLayout.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    DJXDrawSeekLayout.this.updateSeekTip(i);
                    DJXDrawSeekLayout.this.mHandler.removeMessages(141);
                }
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onProgressChanged(seekBar, i, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                DJXDrawSeekLayout.this.mHandler.removeMessages(141);
                DJXDrawSeekLayout.this.mIsDragged = true;
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
                DJXDrawSeekLayout.this.updateSeekTip(seekBar.getProgress());
                DJXDrawSeekLayout.this.mTipLayout.setVisibility(0);
                DJXDrawSeekLayout.this.mIvThumb.setVisibility(8);
                DJXDrawSeekLayout.this.showDragState(true);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DJXDrawSeekLayout.this.mIsDragged = false;
                DJXDrawSeekLayout.this.mTipLayout.setVisibility(8);
                DJXDrawSeekLayout.this.mIvThumb.setImageDrawable(new ColorDrawable(0));
                DJXDrawSeekLayout.this.mIvThumb.setVisibility(8);
                DJXDrawSeekLayout.this.mHandler.sendEmptyMessageDelayed(141, 1000L);
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    public DJXDrawSeekLayout(Context context, AttributeSet attributeSet, int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context, attributeSet, i);
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mIsDragged = false;
        this.mBarStyle = 1;
        this.mDragHeight = 60;
        this.mNormalHeight = 24;
        this.mSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawSeekLayout.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    DJXDrawSeekLayout.this.updateSeekTip(i2);
                    DJXDrawSeekLayout.this.mHandler.removeMessages(141);
                }
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onProgressChanged(seekBar, i2, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                DJXDrawSeekLayout.this.mHandler.removeMessages(141);
                DJXDrawSeekLayout.this.mIsDragged = true;
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onStartTrackingTouch(seekBar);
                }
                DJXDrawSeekLayout.this.updateSeekTip(seekBar.getProgress());
                DJXDrawSeekLayout.this.mTipLayout.setVisibility(0);
                DJXDrawSeekLayout.this.mIvThumb.setVisibility(8);
                DJXDrawSeekLayout.this.showDragState(true);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DJXDrawSeekLayout.this.mIsDragged = false;
                DJXDrawSeekLayout.this.mTipLayout.setVisibility(8);
                DJXDrawSeekLayout.this.mIvThumb.setImageDrawable(new ColorDrawable(0));
                DJXDrawSeekLayout.this.mIvThumb.setVisibility(8);
                DJXDrawSeekLayout.this.mHandler.sendEmptyMessageDelayed(141, 1000L);
                if (DJXDrawSeekLayout.this.mOutSeekBarChangeListener != null) {
                    DJXDrawSeekLayout.this.mOutSeekBarChangeListener.onStopTrackingTouch(seekBar);
                }
            }
        };
        init(context);
    }

    private void init(Context context) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.djx_view_draw_seek, (ViewGroup) this, true);
        this.mSeekBar = (SeekBar) viewInflate.findViewById(R.id.djx_draw_seekview_seekbar);
        this.mTipLayout = (LinearLayout) viewInflate.findViewById(R.id.djx_draw_seekview_tip_layout);
        this.mTvCurrent = (TextView) viewInflate.findViewById(R.id.djx_draw_seekview_tip_current);
        this.mTvTotal = (TextView) viewInflate.findViewById(R.id.djx_draw_seekview_tip_total);
        this.mIvThumb = (ImageView) viewInflate.findViewById(R.id.djx_draw_seekview_thumb);
        View viewFindViewById = viewInflate.findViewById(R.id.djx_draw_seekview_seekcontainer);
        this.mSeekView = viewFindViewById;
        viewFindViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXDrawSeekLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return DJXDrawSeekLayout.this.mSeekBar.onTouchEvent(motionEvent);
            }
        });
        this.mSeekBar.setOnSeekBarChangeListener(this.mSeekBarChangeListener);
        setSplitTrack(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void setSplitTrack(boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mSeekBar.setSplitTrack(z);
            return;
        }
        try {
            Field declaredField = this.mSeekBar.getClass().getSuperclass().getDeclaredField("mSplitTrack");
            declaredField.setAccessible(true);
            declaredField.set(this.mSeekBar, Boolean.valueOf(z));
            this.mSeekBar.invalidate();
        } catch (Exception unused) {
        }
    }

    public void setThumb(Bitmap bitmap) {
        if (this.mIvThumb == null || bitmap == null) {
            return;
        }
        boolean z = bitmap.getHeight() >= bitmap.getWidth();
        int iDp2px = UIUtil.dp2px(86.0f);
        int iDp2px2 = UIUtil.dp2px(154.0f);
        if (z) {
            iDp2px2 = (bitmap.getHeight() * iDp2px) / (bitmap.getWidth() != 0 ? bitmap.getWidth() : 1);
        } else {
            iDp2px = (bitmap.getHeight() * iDp2px2) / (bitmap.getWidth() != 0 ? bitmap.getWidth() : 1);
        }
        ViewGroup.LayoutParams layoutParams = this.mIvThumb.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.width = iDp2px;
                layoutParams.height = iDp2px2;
            } else {
                layoutParams.width = iDp2px2;
                layoutParams.height = iDp2px;
            }
            this.mIvThumb.setLayoutParams(layoutParams);
        }
        this.mIvThumb.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
        this.mIvThumb.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSeekTip(long j) {
        long[] jArrSecond2MS = ToolUtils.second2MS(this.mSeekBar.getMax() / 1000);
        StringBuilder sb = new StringBuilder();
        long j2 = jArrSecond2MS[0];
        if (j2 > 9) {
            sb.append(j2).append(":");
        } else {
            sb.append(0).append(jArrSecond2MS[0]).append(":");
        }
        long j3 = jArrSecond2MS[1];
        if (j3 > 9) {
            sb.append(j3);
        } else {
            sb.append(0).append(jArrSecond2MS[1]);
        }
        this.mTvTotal.setText(sb.toString());
        long[] jArrSecond2MS2 = ToolUtils.second2MS(j / 1000);
        StringBuilder sb2 = new StringBuilder();
        long j4 = jArrSecond2MS2[0];
        if (j4 > 9) {
            sb2.append(j4).append(":");
        } else {
            sb2.append(0).append(jArrSecond2MS2[0]).append(":");
        }
        long j5 = jArrSecond2MS2[1];
        if (j5 > 9) {
            sb2.append(j5);
        } else {
            sb2.append(0).append(jArrSecond2MS2[1]);
        }
        this.mTvCurrent.setText(sb2.toString());
    }

    public long getProgress() {
        if (this.mSeekBar != null) {
            return r0.getProgress();
        }
        return 0L;
    }

    public void setSeekBarStyle(int i) {
        if (i == 2 || i == 1) {
            this.mBarStyle = i;
            this.mSeekBar.setProgressDrawable(getPBDrawable4Style(false));
        }
    }

    public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.mOutSeekBarChangeListener = onSeekBarChangeListener;
    }

    public void setMax(int i) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setMax(i);
        }
    }

    public void setProgress(int i) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null || this.mIsDragged) {
            return;
        }
        seekBar.setProgress(i);
    }

    public void setSeekEnabled(boolean z) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setEnabled(z);
        }
    }

    public void showDragState(boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            return;
        }
        seekBar.setProgressDrawable(getPBDrawable4Style(z));
        if (z) {
            setSeekBarHeight(UIUtil.dp2px(4.0f));
            setSeekViewHeight(UIUtil.dp2px(this.mDragHeight));
            this.mSeekBar.setThumb(getResources().getDrawable(R.drawable.djx_draw_thumb_dragged));
        } else {
            setSeekBarHeight(UIUtil.dp2px(2.0f));
            setSeekViewHeight(UIUtil.dp2px(24.0f));
            this.mSeekBar.setThumb(getResources().getDrawable(R.drawable.djx_draw_thumb_normal));
        }
    }

    private void setSeekBarHeight(int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mSeekBar.setMaxHeight(i);
            this.mSeekBar.setMinHeight(i);
            return;
        }
        try {
            Class<? super Object> superclass = this.mSeekBar.getClass().getSuperclass().getSuperclass();
            Field declaredField = superclass.getDeclaredField("mMaxHeight");
            declaredField.setAccessible(true);
            declaredField.set(this.mSeekBar, Integer.valueOf(i));
            Field declaredField2 = superclass.getDeclaredField("mMinHeight");
            declaredField2.setAccessible(true);
            declaredField2.set(this.mSeekBar, Integer.valueOf(i));
            this.mSeekBar.requestLayout();
        } catch (Exception unused) {
        }
    }

    private void setSeekViewHeight(int i) {
        if (this.mSeekView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i);
        layoutParams.gravity = 80;
        this.mSeekView.setLayoutParams(layoutParams);
    }

    private Drawable getPBDrawable4Style(boolean z) {
        int i;
        if (z) {
            i = this.mBarStyle == 2 ? R.drawable.djx_draw_progress_drag_blue : R.drawable.djx_draw_progress_drag;
        } else {
            i = this.mBarStyle == 2 ? R.drawable.djx_draw_progress_blue : R.drawable.djx_draw_progress;
        }
        return getResources().getDrawable(i);
    }

    public void handleMsg(Message message) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (message.what == 141) {
            showDragState(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsDragged = false;
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void setDragHeight(int i) {
        this.mDragHeight = i;
    }
}
