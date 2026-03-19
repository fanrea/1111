package com.fendasz.moku.planet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LoadingDialog {
    public static final String TAG = "LoadingDialog";
    private static Dialog mDialog;

    public static void show(Context context) {
        show(context, context.getString(R.string.moku_loading_tips));
    }

    public static void show(Context context, boolean z) {
        show(context, context.getString(R.string.moku_loading_tips), true, z);
    }

    public static boolean isShowing() {
        Dialog dialog = mDialog;
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }

    public static void show(Context context, String str) {
        show(context, str, false, false);
    }

    public static void show(Context context, String str, boolean z, boolean z2) {
        String str2 = TAG;
        Log.d(str2, "invoke show dialog");
        dismiss();
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.moku_anysc_http_loading, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_loading_desc);
        textView.setText(str);
        textView.setTextSize(PhoneScreenUtils.getInstance().getNormalTextSize(context));
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.pb_image);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        Log.d(str2, "start animation");
        imageView.startAnimation(rotateAnimation);
        Dialog dialog = new Dialog(context, R.style.MokuCustomProgressDialog);
        mDialog = dialog;
        dialog.setContentView(viewInflate);
        mDialog.show();
        WindowManager.LayoutParams attributes = ((Window) Objects.requireNonNull(mDialog.getWindow())).getAttributes();
        attributes.width = PhoneScreenUtils.getInstance().getWidthPixels(context);
        attributes.height = PhoneScreenUtils.getInstance().getHeightPixels(context);
        mDialog.getWindow().setAttributes(attributes);
        mDialog.setCancelable(z);
        if (z2) {
            viewInflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.dialog.LoadingDialog.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    LoadingDialog.dismiss();
                    return false;
                }
            });
        }
    }

    public static void dismiss() {
        Log.d(TAG, "dismiss loading first");
        try {
            Dialog dialog = mDialog;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            ((ImageView) mDialog.findViewById(R.id.pb_image)).clearAnimation();
            mDialog.dismiss();
            mDialog = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
