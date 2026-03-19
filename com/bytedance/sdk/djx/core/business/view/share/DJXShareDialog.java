package com.bytedance.sdk.djx.core.business.view.share;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareAdapter;
import com.bytedance.sdk.djx.core.business.view.share.DJXShareConfig;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXShareDialog extends Dialog {
    private final View.OnClickListener mClickCancel;
    private OnShareDialogListener mListener;
    protected List<String> mShareConfig;

    public interface OnShareDialogListener {
        void onClick(String str);
    }

    public static DJXShareDialog build(Context context) {
        return new DJXShareDialog(context);
    }

    public DJXShareDialog(Context context) {
        super(context, R.style.djx_draw_share_dialog_style);
        this.mClickCancel = new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.share.DJXShareDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DJXShareDialog.this.dismiss();
            }
        };
        initShareConfig();
    }

    public void setListener(OnShareDialogListener onShareDialogListener) {
        this.mListener = onShareDialogListener;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.djx_draw_share_layout);
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

    private void initShareConfig() {
        ArrayList arrayList = new ArrayList(settingsShareChannels());
        this.mShareConfig = arrayList;
        if (!arrayList.isEmpty()) {
            filterShareChannels(this.mShareConfig);
        } else {
            this.mShareConfig = generateDefaultConfig();
        }
    }

    protected List<String> settingsShareChannels() {
        return SettingData.getInstance().getSharePanelConfig();
    }

    private void filterShareChannels(List<String> list) {
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        List<String> listLimitConfigs = limitConfigs();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (listLimitConfigs.contains(str) && !list.contains(str)) {
                list.add(str);
            }
        }
    }

    protected List<String> generateDefaultConfig() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("report");
        arrayList.add(DJXShareConfig.CHANNEL_NAME.PRIVACY_SETTING);
        return arrayList;
    }

    protected List<String> limitConfigs() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("report");
        arrayList.add(DJXShareConfig.CHANNEL_NAME.PRIVACY_SETTING);
        return arrayList;
    }

    private void initView() {
        View viewFindViewById = findViewById(R.id.djx_share_layout_cancel1);
        TextView textView = (TextView) findViewById(R.id.djx_share_layout_cancel2);
        viewFindViewById.setOnClickListener(this.mClickCancel);
        textView.setOnClickListener(this.mClickCancel);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.djx_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        DJXShareAdapter dJXShareAdapter = new DJXShareAdapter(getContext(), new DJXShareAdapter.OnShareClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.share.DJXShareDialog.1
            @Override // com.bytedance.sdk.djx.core.business.view.share.DJXShareAdapter.OnShareClickListener
            public void onShareClick(String str) {
                if (DJXShareDialog.this.mListener != null) {
                    DJXShareDialog.this.mListener.onClick(str);
                }
                DJXShareDialog.this.dismiss();
            }
        });
        dJXShareAdapter.addAll(new ArrayList(this.mShareConfig));
        recyclerView.setAdapter(dJXShareAdapter);
    }

    public void setShowReport(boolean z) {
        List<String> list;
        if (z || (list = this.mShareConfig) == null) {
            return;
        }
        list.remove("report");
    }

    public void setShowPrivacySetting(boolean z) {
        List<String> list;
        if (z || (list = this.mShareConfig) == null) {
            return;
        }
        list.remove(DJXShareConfig.CHANNEL_NAME.PRIVACY_SETTING);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (getWindow() != null) {
            try {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.gravity = 80;
                attributes.width = -1;
                attributes.height = -2;
                getWindow().getDecorView().setPadding(0, 0, 0, 0);
                getWindow().setAttributes(attributes);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.mListener = null;
    }
}
