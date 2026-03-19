package com.alliance.ssp.ad.q0;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;

/* compiled from: DownloadTipDialog.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b extends a {
    public TextView h;
    public String i;

    public b(Context context) {
        super(context);
        this.h = null;
        this.i = null;
    }

    @Override // com.alliance.ssp.ad.q0.a, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_nmssp_download_dialog, (ViewGroup) null, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_download_file_name);
        this.h = textView;
        if (textView != null && !TextUtils.isEmpty(this.i)) {
            this.h.setText(this.i);
        }
        FrameLayout frameLayout = this.a;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.a.addView(viewInflate);
        }
    }
}
