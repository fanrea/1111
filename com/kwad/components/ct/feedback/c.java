package com.kwad.components.ct.feedback;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.kwad.components.core.proxy.i;
import com.kwad.components.ct.feedback.b;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.proxy.app.BaseFragmentActivity;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bq;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends i {
    private ImageView Pd;
    private FeedbackParams aGo;
    private View aGp;
    private EditText aGq;
    private EditText aGr;
    private TextView aGs;
    private LottieAnimationView aGt;
    private FrameLayout aGu;

    @Override // com.kwad.components.core.proxy.i
    public String getPageName() {
        return "KsFeedbackActivityImpl";
    }

    public static void a(Context context, FeedbackParams feedbackParams) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.c.g(BaseFragmentActivity.FragmentActivity6.class, c.class);
        Intent intent = new Intent(context, (Class<?>) BaseFragmentActivity.FragmentActivity6.class);
        intent.setFlags(268435456);
        intent.putExtra("KEY_FEEDBACK_PARAMS", feedbackParams);
        context.startActivity(intent);
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (xn()) {
                getActivity().setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
                setContentView(R.layout.ksad_activity_feedback);
                xm();
                com.kwad.components.ct.e.b.JK().JN();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }

    private void xm() {
        rC();
        this.aGu = (FrameLayout) findViewById(R.id.ksad_feekback_loading_container);
        this.aGt = (LottieAnimationView) findViewById(R.id.ksad_feekback_center_loading_anim);
        EditText editText = (EditText) findViewById(R.id.ksad_feedback_content_edit);
        this.aGq = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200)});
        TextView textView = (TextView) findViewById(R.id.ksad_feedback_content_edit_counter);
        this.aGs = textView;
        textView.setText("0/200");
        this.aGs.setTextColor(-6710887);
        this.aGq.addTextChangedListener(new TextWatcher() { // from class: com.kwad.components.ct.feedback.c.1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
                int length = editable.length();
                c.this.aGs.setText(length + "/200");
                if (length < 200) {
                    c.this.aGs.setTextColor(-6710887);
                } else {
                    c.this.aGs.setTextColor(SupportMenu.CATEGORY_MASK);
                }
            }
        });
        EditText editText2 = (EditText) findViewById(R.id.ksad_feedback_phone_num_edit);
        this.aGr = editText2;
        editText2.setInputType(3);
        View viewFindViewById = findViewById(R.id.ksad_feedback_submit_btn);
        this.aGp = viewFindViewById;
        viewFindViewById.setClickable(true);
        this.aGp.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.feedback.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.a aVar = new b.a();
                aVar.amZ = c.this.aGo.mFromPageName;
                aVar.content = bq.iK(c.this.aGq.getText().toString());
                aVar.aGn = bq.iJ(c.this.aGr.getText().toString());
                if (c.this.a(aVar)) {
                    b.a(aVar, new b.InterfaceC0518b() { // from class: com.kwad.components.ct.feedback.c.2.1
                        @Override // com.kwad.components.ct.feedback.b.InterfaceC0518b
                        public final void xK() {
                            c.this.Fi();
                            c.this.aGp.setClickable(false);
                        }

                        @Override // com.kwad.components.ct.feedback.b.InterfaceC0518b
                        public final void zH() {
                            ac.ae(c.this.getActivity(), "网络错误 反馈失败");
                            c.this.Fj();
                            c.this.aGp.setClickable(true);
                        }

                        @Override // com.kwad.components.ct.feedback.b.InterfaceC0518b
                        public final void Fh() {
                            ac.ae(c.this.getActivity(), "感谢您的反馈！");
                            c.this.Fj();
                            c.this.aGp.setClickable(true);
                            c.this.finish();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(b.a aVar) {
        if (TextUtils.isEmpty(aVar.content) || TextUtils.isEmpty(aVar.content.trim())) {
            ac.ae(getActivity(), "请输入反馈内容");
            return false;
        }
        if (aVar.content.trim().length() > 6) {
            return true;
        }
        ac.ae(getActivity(), "请输入6个字以上的反馈内容");
        return false;
    }

    public final void Fi() {
        this.aGt.setRepeatMode(1);
        this.aGt.setRepeatCount(-1);
        com.kwad.components.ct.d.a.Jd().b(this.aGt, true);
        if (!this.aGt.isAnimating()) {
            this.aGt.PZ();
        }
        this.aGu.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        if (this.aGt.isAnimating()) {
            this.aGt.Qa();
        }
        this.aGu.setVisibility(8);
    }

    private void rC() {
        ImageView imageView = (ImageView) findViewById(R.id.ksad_titlebar_back_btn);
        this.Pd = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.feedback.c.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.onBackPressed();
            }
        });
    }

    private boolean xn() {
        Serializable serializableExtra = getIntent().getSerializableExtra("KEY_FEEDBACK_PARAMS");
        if (serializableExtra instanceof FeedbackParams) {
            this.aGo = (FeedbackParams) serializableExtra;
        }
        return this.aGo != null;
    }

    @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        super.onBackPressed();
    }
}
