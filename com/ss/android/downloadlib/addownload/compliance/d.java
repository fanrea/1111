package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.addownload.compliance.c;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.h.uo;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends Dialog {
    private TextView an;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout gb;
    private ClipImageView h;
    private TextView hc;
    private long mk;
    private final com.ss.android.downloadlib.addownload.hc.hc mq;
    private final long tc;
    private Activity tt;
    private TextView u;

    public d(Activity activity, long j) {
        super(activity);
        this.tt = activity;
        this.tc = j;
        this.mq = (com.ss.android.downloadlib.addownload.hc.hc) b.d().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mq == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.mk = this.mq.hc;
        d();
        h.hc("lp_app_dialog_show", this.mk);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.d.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                h.d("lp_app_dialog_cancel", d.this.mk);
            }
        });
    }

    private void d() {
        this.d = (TextView) findViewById(R.id.tv_app_name);
        this.hc = (TextView) findViewById(R.id.tv_app_version);
        this.b = (TextView) findViewById(R.id.tv_app_developer);
        this.c = (TextView) findViewById(R.id.tv_app_detail);
        this.u = (TextView) findViewById(R.id.tv_app_privacy);
        this.an = (TextView) findViewById(R.id.tv_give_up);
        this.h = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.gb = (LinearLayout) findViewById(R.id.ll_download);
        this.d.setText(uo.d(this.mq.u, "--"));
        this.hc.setText("版本号：" + uo.d(this.mq.an, "--"));
        this.b.setText("开发者：" + uo.d(this.mq.h, "应用信息正在完善中"));
        this.h.setRoundRadius(uo.d(mq.getContext(), 8.0f));
        this.h.setBackgroundColor(Color.parseColor("#EBEBEB"));
        c.d().d(this.tc, new c.d() { // from class: com.ss.android.downloadlib.addownload.compliance.d.2
            @Override // com.ss.android.downloadlib.addownload.compliance.c.d
            public void d(Bitmap bitmap) throws JSONException {
                if (bitmap != null) {
                    d.this.h.setImageBitmap(bitmap);
                } else {
                    h.d(8, d.this.mk);
                }
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hc.d().d(d.this.tt);
                AppDetailInfoActivity.d(d.this.tt, d.this.tc);
                h.d("lp_app_dialog_click_detail", d.this.mk);
            }
        });
        this.u.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hc.d().d(d.this.tt);
                AppPrivacyPolicyActivity.d(d.this.tt, d.this.tc);
                h.d("lp_app_dialog_click_privacy", d.this.mk);
            }
        });
        this.an.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.d.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dismiss();
                h.d("lp_app_dialog_click_giveup", d.this.mk);
            }
        });
        this.gb.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.d("lp_app_dialog_click_download", d.this.mk);
                hc.d().hc(d.this.mk);
                d.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.b.d(this.tt);
    }
}
