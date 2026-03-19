package com.bytedance.sdk.djx.core.business.budrama.detail;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDramaRewardDialog extends Dialog {
    private final boolean mHasTips;
    private final int mLockSet;
    private OnDramaRewardDialogListener mOnDramaRewardDialogListener;

    public interface OnDramaRewardDialogListener {
        void onCancel();

        void onConfirm();
    }

    public DJXDramaRewardDialog(Context context, int i, boolean z) {
        super(context, R.style.djx_draw_share_dialog_style);
        this.mLockSet = i;
        this.mHasTips = z;
    }

    public void setOnDramaRewardDialogListener(OnDramaRewardDialogListener onDramaRewardDialogListener) {
        this.mOnDramaRewardDialogListener = onDramaRewardDialogListener;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.djx_drama_reward_dialog_layout);
        if (getWindow() != null) {
            try {
                getWindow().setWindowAnimations(R.style.djx_animation_share_style);
            } catch (Throwable unused) {
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        initView();
    }

    public void initView() {
        TextView textView = (TextView) findViewById(R.id.djx_drama_unlock_desc);
        String str = String.format(Locale.getDefault(), "看激励视频解锁%d集剧情", Integer.valueOf(this.mLockSet));
        if (this.mHasTips) {
            str = str + "\n请按照顺序解锁";
        }
        textView.setText(str);
        findViewById(R.id.djx_drama_show_reward).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaRewardDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDramaRewardDialog.this.mOnDramaRewardDialogListener != null) {
                    DJXDramaRewardDialog.this.mOnDramaRewardDialogListener.onConfirm();
                }
            }
        });
        findViewById(R.id.djx_drama_leave_reward).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.budrama.detail.DJXDramaRewardDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXDramaRewardDialog.this.mOnDramaRewardDialogListener != null) {
                    DJXDramaRewardDialog.this.mOnDramaRewardDialogListener.onCancel();
                }
            }
        });
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
