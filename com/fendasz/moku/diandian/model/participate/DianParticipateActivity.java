package com.fendasz.moku.diandian.model.participate;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import com.fendasz.moku.adapter.DianParticipatePagerAdapter;
import com.fendasz.moku.diandian.commons.MokuDianActivity;
import com.fendasz.moku.diandian.model.participate.fragment.DianCompletedFragment;
import com.fendasz.moku.diandian.model.participate.fragment.DianParticipateInFragment;
import com.fendasz.moku.diandian.model.participate.fragment.DianTaskFailFragment;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Error;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.source.bean.CustomerServiceConfig;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.customview.StatusEmptyView;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.QqUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DianParticipateActivity extends MokuDianActivity {
    public static final int REQUEST_CODE_FOR_TASKDETAIL_ACTIVITY = 0;
    private static final String TAG = "Moku_dian_Participate=>";
    private String failTabName;
    private Context mContext;
    private List<DianParticipateFragment> mFragments;
    private MokuOptions mMokuOptions;
    private View.OnClickListener mNoDataClickListener;
    private StatusEmptyView mStatusEmptyView;
    private ArrayList<String> mTitles;
    private ViewPager mViewPager;
    private DianParticipatePagerAdapter myFragmentPagerAdapter;
    private Integer reSubmittedStatus = 0;
    private RelativeLayout rootView;

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_dian_participate, viewGroup, false);
        this.rootView = relativeLayout;
        return relativeLayout;
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText(getResources().getString(R.string.moku_my_participate_in));
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initRightView(MokuIconTextView mokuIconTextView) {
        if (MokuConfigure.getInstance().getMokuOptions(this.mContext).getBoolean(this.mContext.getString(R.string.moku_option_is_show_customer_service), false)) {
            mokuIconTextView.setText("");
            if (Build.VERSION.SDK_INT >= 21) {
                mokuIconTextView.setBackground(this.mContext.getDrawable(R.drawable.customer));
            } else {
                mokuIconTextView.setBackground(this.mContext.getResources().getDrawable(R.drawable.customer));
            }
            ScreenAdaptationUtils.setSize(this.mContext, mokuIconTextView, 80, 80);
            ScreenAdaptationUtils.setMarginRight(this.mContext, mokuIconTextView, 20);
            mokuIconTextView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LoadingDialog.show(DianParticipateActivity.this.mContext);
                    DianParticipateActivity.this.getCustomerServiceConfig(new Success<CustomerServiceConfig>() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.1.1
                        @Override // com.fendasz.moku.planet.interf.Success
                        public void success(Integer num, CustomerServiceConfig customerServiceConfig) {
                            if (customerServiceConfig != null) {
                                String config = customerServiceConfig.getConfig();
                                if (TextUtils.isEmpty(config)) {
                                    return;
                                }
                                if (QqUtils.checkQqApkInstalled(DianParticipateActivity.this.mContext)) {
                                    if (QqUtils.joinQqGroup(DianParticipateActivity.this.mContext, config)) {
                                        return;
                                    }
                                    Toast.makeText(DianParticipateActivity.this.mContext, "打开QQ群聊失败", 1).show();
                                    return;
                                }
                                Toast.makeText(DianParticipateActivity.this.mContext, "请先安装QQ", 1).show();
                            }
                        }
                    }, new Error() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.1.2
                        @Override // com.fendasz.moku.planet.interf.Error
                        public void error(Integer num, String str) {
                            Toast.makeText(DianParticipateActivity.this.mContext, "获取客服数据失败:" + str, 0).show();
                        }
                    }, new Finish() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.1.3
                        @Override // com.fendasz.moku.planet.interf.Finish
                        public void finish() {
                            LoadingDialog.dismiss();
                        }
                    });
                }
            });
            return;
        }
        mokuIconTextView.setVisibility(8);
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        super.onSuperCreate(bundle);
        this.mContext = this;
        this.mMokuOptions = MokuConfigure.getInstance().getMokuOptions(this.mContext);
        this.mTitles = new ArrayList<>();
        this.mFragments = new ArrayList();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initView() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.initView();
        initStaticView();
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initLeftView(TextView textView) {
        textView.setVisibility(0);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DianParticipateActivity.this.finish();
            }
        });
    }

    @Override // com.fendasz.moku.diandian.commons.MokuDianActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() throws Resources.NotFoundException {
        super.onLoad();
        initData();
    }

    private void initStaticView() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i;
        ViewPager viewPager = (ViewPager) this.rootView.findViewById(R.id.viewpager);
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
            }
        });
        this.mStatusEmptyView = (StatusEmptyView) this.rootView.findViewById(R.id.status_empty_view);
        this.mNoDataClickListener = new View.OnClickListener() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        };
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.ll_container);
        Class<?> cls = null;
        try {
            cls = Class.forName("com.google.android.material.tabs.TabLayout");
            LogUtils.log(TAG, "isAndroidX >> false");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.google.android.material.tabs.TabLayout");
                LogUtils.log(TAG, "isAndroidX >> true");
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        if (cls != null) {
            LogUtils.log(TAG, "got TabLayout Class");
            LogUtils.log(TAG, "TabLayout Constructor size >> " + cls.getConstructors().length);
            for (int i2 = 0; i2 < cls.getConstructors().length; i2++) {
                LogUtils.log(TAG, cls.getConstructors()[i2].getName());
                for (int i3 = 0; i3 < cls.getConstructors()[i2].getParameterTypes().length; i3++) {
                    LogUtils.log(TAG, cls.getConstructors()[i2].getParameterTypes()[i3].getName());
                }
            }
            try {
                Constructor<?> constructor = cls.getConstructor(Context.class);
                LogUtils.log(TAG, "found constructor >> " + constructor.getName());
                try {
                    View view = (View) constructor.newInstance(this.mContext);
                    LogUtils.log(TAG, "got TabLayout instance");
                    linearLayout.addView(view, 0);
                    ScreenAdaptationUtils.setSize(this.mContext, view, -1, 120);
                    ScreenAdaptationUtils.setPaddingBottom(this.mContext, view, 6);
                    try {
                        cls.getMethod("setSelectedTabIndicatorHeight", Integer.TYPE).invoke(view, Integer.valueOf(this.phoneScreenUtils.getScale(this.mContext, 6.0f)));
                    } catch (NoSuchMethodException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        Method method = cls.getMethod("setTabMode", Integer.TYPE);
                        try {
                            i = cls.getDeclaredField("MODE_FIXED").getInt(view);
                        } catch (NoSuchFieldException e4) {
                            e4.printStackTrace();
                            i = 1;
                        }
                        method.invoke(view, Integer.valueOf(i));
                    } catch (NoSuchMethodException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        cls.getMethod("setBackgroundColor", Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabBackgroundColor", "#efefef"))));
                    } catch (NoSuchMethodException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        cls.getMethod("setSelectedTabIndicatorColor", Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabIndicatorColor", "#FB823B"))));
                    } catch (NoSuchMethodException e7) {
                        e7.printStackTrace();
                    }
                    try {
                        cls.getMethod("setTabTextColors", Integer.TYPE, Integer.TYPE).invoke(view, Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabTextColor", "#6E6E6E"))), Integer.valueOf(Color.parseColor(this.mMokuOptions.getString("tabSelectedTextColor", "#000000"))));
                    } catch (NoSuchMethodException e8) {
                        e8.printStackTrace();
                    }
                    try {
                        cls.getMethod("setupWithViewPager", this.mViewPager.getClass()).invoke(view, this.mViewPager);
                    } catch (NoSuchMethodException e9) {
                        e9.printStackTrace();
                    }
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                } catch (InstantiationException e11) {
                    e11.printStackTrace();
                } catch (InvocationTargetException e12) {
                    e12.printStackTrace();
                }
            } catch (NoSuchMethodException e13) {
                e13.printStackTrace();
            }
        }
    }

    private void initData() throws Resources.NotFoundException {
        this.mStatusEmptyView.hide();
        ArrayList arrayList = new ArrayList();
        arrayList.add("待开始");
        arrayList.add("0");
        arrayList.add("已完成");
        arrayList.add("未通过");
        createTab(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCustomerServiceConfig(final Success<CustomerServiceConfig> success, final Error error, final Finish finish) {
        ApiDataHelper.getApiDataHelper().getCustomerServiceConfig(this.mContext, new ApiDataCallBack<CustomerServiceConfig>() { // from class: com.fendasz.moku.diandian.model.participate.DianParticipateActivity.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, CustomerServiceConfig customerServiceConfig) throws Exception {
                Success success2 = success;
                if (success2 != null) {
                    success2.success(Integer.valueOf(i), customerServiceConfig);
                }
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                Error error2 = error;
                if (error2 != null) {
                    error2.error(Integer.valueOf(i), str);
                }
                Finish finish2 = finish;
                if (finish2 != null) {
                    finish2.finish();
                }
            }
        });
    }

    private void createTab(List<String> list) throws Resources.NotFoundException {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                this.mTitles.add("待开始");
                this.mFragments.add(new DianParticipateInFragment());
            } else if (i == 2) {
                if (!list.get(i).equals("0")) {
                    this.mTitles.add(list.get(i));
                    this.mFragments.add(new DianCompletedFragment());
                }
            } else if (i == 3 && !list.get(i).equals("0")) {
                this.failTabName = list.get(i);
                if (this.reSubmittedStatus.intValue() > 0) {
                    this.mTitles.add(list.get(i) + "\n(" + this.reSubmittedStatus + ")");
                } else {
                    this.mTitles.add(list.get(i));
                }
                this.mFragments.add(new DianTaskFailFragment());
            }
        }
        DianParticipatePagerAdapter dianParticipatePagerAdapter = new DianParticipatePagerAdapter(getSupportFragmentManager(), this.mFragments, this.mTitles);
        this.myFragmentPagerAdapter = dianParticipatePagerAdapter;
        this.mViewPager.setAdapter(dianParticipatePagerAdapter);
        this.mViewPager.setOffscreenPageLimit(4);
    }
}
