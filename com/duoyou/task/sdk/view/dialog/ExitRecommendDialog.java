package com.duoyou.task.sdk.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.duoyou.task.pro.b.a;
import com.duoyou.task.pro.e.d;
import com.duoyou.task.pro.g.f;
import com.duoyou.task.pro.g.h;
import com.duoyou.task.sdk.R;
import com.duoyou.task.sdk.xutils.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ExitRecommendDialog extends Dialog {
    private Builder builder;
    private TextView cancelTv;
    private Activity context;
    private TextView exitTv;
    private GridView gridView;
    private TextView messageTv;
    private RecommendAdapter recommendAdapter;
    private List<d> taskInfoList;
    private TextView tipsTv;

    public ExitRecommendDialog(Activity activity, Builder builder) {
        super(activity, R.style.dyDialogStyle);
        this.taskInfoList = new ArrayList();
        this.builder = builder;
        this.context = activity;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dy_dialog_exit_recommend_layout);
        initView();
        initData();
        initListener();
        getRecommendList();
    }

    private void initView() {
        this.tipsTv = (TextView) findViewById(R.id.dy_tips_tv);
        this.messageTv = (TextView) findViewById(R.id.dy_message_tv);
        this.gridView = (GridView) findViewById(R.id.dy_grid_view);
        this.exitTv = (TextView) findViewById(R.id.dy_exit_tv);
        this.cancelTv = (TextView) findViewById(R.id.dy_cancel_tv);
    }

    private void initData() {
        RecommendAdapter recommendAdapter = new RecommendAdapter();
        this.recommendAdapter = recommendAdapter;
        this.gridView.setAdapter((ListAdapter) recommendAdapter);
        this.exitTv.setText(this.builder.okStr);
        this.cancelTv.setText(this.builder.cancelStr);
        this.messageTv.setText(this.builder.messageStr);
        this.tipsTv.setText(Html.fromHtml("<font color='#ff0000'>" + (new Random().nextInt(10) + 89) + "%</font>的玩家还会玩："));
    }

    private void initListener() {
        this.exitTv.setOnClickListener(new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.ExitRecommendDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExitRecommendDialog.this.dismiss();
                if (ExitRecommendDialog.this.builder.onPositiveListener != null) {
                    ExitRecommendDialog.this.builder.onPositiveListener.onClick(view);
                }
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.ExitRecommendDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ExitRecommendDialog.this.dismiss();
                if (ExitRecommendDialog.this.builder.onNegativeListener != null) {
                    ExitRecommendDialog.this.builder.onNegativeListener.onClick(view);
                }
            }
        });
    }

    private void getRecommendList() {
        if (h.i().o().size() > 0) {
            this.taskInfoList.clear();
            this.taskInfoList.addAll(subListByScreenOrientation(h.i().o()));
            this.recommendAdapter.notifyDataSetChanged();
            return;
        }
        a.a(this.context, 6, new com.duoyou.task.pro.f.a() { // from class: com.duoyou.task.sdk.view.dialog.ExitRecommendDialog.3
            public void onFailure(String str, String str2) {
                if (ExitRecommendDialog.this.isShowing()) {
                    ExitRecommendDialog.this.gridView.setVisibility(8);
                }
            }

            public void onSuccess(String str) {
                Log.i("json", "result = " + str);
                if (ExitRecommendDialog.this.isShowing()) {
                    if (f.c(str)) {
                        JSONArray jSONArrayA = f.a(str);
                        ExitRecommendDialog.this.taskInfoList.clear();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < jSONArrayA.length(); i++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayA.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null) {
                                d dVar = new d();
                                dVar.f(jSONObjectOptJSONObject.optString("advert_id"));
                                dVar.a(jSONObjectOptJSONObject.optString("product_icon"));
                                dVar.g(jSONObjectOptJSONObject.optString("title"));
                                dVar.b(jSONObjectOptJSONObject.optString("product_introduction"));
                                dVar.a(jSONObjectOptJSONObject.optInt("account_count"));
                                dVar.d(jSONObjectOptJSONObject.optString("price"));
                                dVar.b(jSONObjectOptJSONObject.optInt(TypedValues.CycleType.S_WAVE_PERIOD));
                                dVar.a(jSONObjectOptJSONObject.optLong("serve_end"));
                                dVar.e(jSONObjectOptJSONObject.optString("price_desc"));
                                dVar.c(jSONObjectOptJSONObject.optString("fast_earn_price_desc"));
                                arrayList.add(dVar);
                            }
                        }
                        ExitRecommendDialog.this.taskInfoList.addAll(ExitRecommendDialog.this.subListByScreenOrientation(arrayList));
                        h.i().a(arrayList);
                    }
                    if (ExitRecommendDialog.this.taskInfoList.size() > 0) {
                        ExitRecommendDialog.this.gridView.setVisibility(0);
                        ExitRecommendDialog.this.recommendAdapter.notifyDataSetChanged();
                    } else {
                        ExitRecommendDialog.this.gridView.setVisibility(8);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> subListByScreenOrientation(List<d> list) {
        return (this.builder.screenOrientation != 1 || list == null || list.size() < 3) ? list : list.subList(0, 3);
    }

    public class RecommendAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public RecommendAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ExitRecommendDialog.this.taskInfoList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ExitRecommendDialog.this.taskInfoList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ExitRecommendDialog.this.getContext()).inflate(R.layout.dy_dialog_exit_gridview_item, viewGroup, false);
            }
            final d dVar = (d) ExitRecommendDialog.this.taskInfoList.get(i);
            ImageView imageView = (ImageView) view.findViewById(R.id.dy_recommend_bg);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.dy_game_icon_iv);
            TextView textView = (TextView) view.findViewById(R.id.dy_price_desc);
            TextView textView2 = (TextView) view.findViewById(R.id.dy_game_tv);
            TextView textView3 = (TextView) view.findViewById(R.id.dy_join_num_tv);
            x.image().bind(imageView2, dVar.b());
            textView2.setText(dVar.e());
            textView.setText("+" + dVar.c());
            if (dVar.a() >= 10000) {
                textView3.setText(String.format("%.1f", Double.valueOf((dVar.a() * 1.0d) / 10000.0d)) + "万人参与");
            } else {
                textView3.setText(dVar.a() + "人参与");
            }
            if (i == 0) {
                imageView.setBackgroundResource(R.drawable.dy_recommend_item_bg_1);
            } else if (i == 1) {
                imageView.setBackgroundResource(R.drawable.dy_recommend_item_bg_2);
            } else if (i == 2) {
                imageView.setBackgroundResource(R.drawable.dy_recommend_item_bg_3);
            } else if (i == 3) {
                imageView.setBackgroundResource(R.drawable.dy_recommend_item_bg_2);
            } else if (i == 4) {
                imageView.setBackgroundResource(R.drawable.dy_recommend_item_bg_3);
            } else if (i == 5) {
                imageView.setBackgroundResource(R.drawable.dy_recommend_item_bg_1);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.ExitRecommendDialog.RecommendAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        ExitRecommendDialog.this.dismiss();
                        ExitRecommendDialog.this.context.finish();
                        h.i().jumpAdDetail(ExitRecommendDialog.this.context, h.i().y(), dVar.d());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return view;
        }
    }

    public static final class Builder {
        private String cancelStr;
        private Activity context;
        private String messageStr;
        private String okStr;
        private View.OnClickListener onNegativeListener;
        private View.OnClickListener onPositiveListener;
        private String positiveColor;
        private int screenOrientation;

        public Builder(Activity activity) {
            this.context = activity;
        }

        public Builder setMessage(String str) {
            this.messageStr = str;
            return this;
        }

        public Builder setOnPositiveListener(String str, View.OnClickListener onClickListener) {
            this.okStr = str;
            this.onPositiveListener = onClickListener;
            return this;
        }

        public Builder setOnNegativeListener(String str, View.OnClickListener onClickListener) {
            this.cancelStr = str;
            this.onNegativeListener = onClickListener;
            return this;
        }

        public Builder setScreenOrientation(int i) {
            this.screenOrientation = i;
            return this;
        }

        public ExitRecommendDialog create() {
            return new ExitRecommendDialog(this.context, this);
        }

        public ExitRecommendDialog show() {
            ExitRecommendDialog exitRecommendDialog = new ExitRecommendDialog(this.context, this);
            exitRecommendDialog.show();
            return exitRecommendDialog;
        }
    }
}
