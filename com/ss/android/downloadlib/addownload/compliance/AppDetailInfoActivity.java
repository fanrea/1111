package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bytedance.gromore.R;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppDetailInfoActivity extends Activity {
    private long an;
    private LinearLayout b;
    private ListView c;
    private ImageView d;
    private List<Pair<String, String>> h;
    private TextView hc;
    private long u;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (d()) {
            hc();
        } else {
            com.ss.android.socialbase.appdownloader.b.d((Activity) this);
        }
    }

    public static void d(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean d() {
        this.u = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.hc.hc hcVarD = b.d().d(this.u);
        if (hcVarD == null) {
            return false;
        }
        this.an = hcVarD.hc;
        this.h = hcVarD.gb;
        return true;
    }

    private void hc() {
        this.d = (ImageView) findViewById(R.id.iv_detail_back);
        this.hc = (TextView) findViewById(R.id.tv_empty);
        this.c = (ListView) findViewById(R.id.permission_list);
        this.b = (LinearLayout) findViewById(R.id.ll_download);
        if (this.h.isEmpty()) {
            this.c.setVisibility(8);
            this.hc.setVisibility(0);
        } else {
            this.c.setAdapter((ListAdapter) new d());
        }
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.d("lp_app_detail_click_close", AppDetailInfoActivity.this.an);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.d("lp_app_detail_click_download", AppDetailInfoActivity.this.an);
                com.ss.android.downloadlib.addownload.compliance.hc.d().hc(AppDetailInfoActivity.this.an);
                com.ss.android.socialbase.appdownloader.b.d((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.b.d(com.ss.android.downloadlib.addownload.compliance.hc.d().hc());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.d("lp_app_detail_click_close", this.an);
        super.onBackPressed();
    }

    private class d extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private d() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return AppDetailInfoActivity.this.h.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return AppDetailInfoActivity.this.h.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            hc hcVar;
            if (view == null) {
                view = View.inflate(AppDetailInfoActivity.this, R.layout.ttdownloader_item_permission, null);
                hcVar = new hc();
                hcVar.d = (TextView) view.findViewById(R.id.tv_permission_title);
                hcVar.hc = (TextView) view.findViewById(R.id.tv_permission_description);
                hcVar.b = view.findViewById(R.id.dash_line);
                view.setTag(hcVar);
            } else {
                hcVar = (hc) view.getTag();
            }
            hcVar.d.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.h.get(i)).first);
            hcVar.hc.setText((CharSequence) ((Pair) AppDetailInfoActivity.this.h.get(i)).second);
            if (i == getCount() - 1) {
                hcVar.b.setVisibility(8);
            }
            return view;
        }
    }

    private static class hc {
        public View b;
        public TextView d;
        public TextView hc;

        private hc() {
        }
    }
}
