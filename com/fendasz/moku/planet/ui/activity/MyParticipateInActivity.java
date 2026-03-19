package com.fendasz.moku.planet.ui.activity;

import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.ApiDataCallBack;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.helper.ApiDataHelper;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.interf.Error;
import com.fendasz.moku.planet.interf.Finish;
import com.fendasz.moku.planet.interf.Success;
import com.fendasz.moku.planet.source.bean.CustomerServiceConfig;
import com.fendasz.moku.planet.ui.adapter.MyFragmentPagerAdapter;
import com.fendasz.moku.planet.ui.base.activity.BaseBackActivity;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.customview.StatusEmptyView;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.ui.dialog.LoadingDialog;
import com.fendasz.moku.planet.ui.fragment.ArbitramentFragment;
import com.fendasz.moku.planet.ui.fragment.MyParticipateInFragment;
import com.fendasz.moku.planet.ui.fragment.TaskCompletedFragment;
import com.fendasz.moku.planet.ui.fragment.TaskFailFragment;
import com.fendasz.moku.planet.ui.fragment.UnderReviewFragment;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.QqUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.canvas.CanvasUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MyParticipateInActivity extends BaseBackActivity {
    public static final int REQUEST_CODE_FOR_TASKDETAIL_ACTIVITY = 0;
    private static final String TAG = "MyParticipateInActivity";
    private String failTabName;
    private RelativeLayout llRoot;
    private MyParticipateInActivity mContext;
    private List<Fragment> mFragments;
    private MokuOptions mMokuOptions;
    private View.OnClickListener mNoDataClickListener;
    private StatusEmptyView mStatusEmptyView;
    private ArrayList<String> mTitles;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private Integer reSubmittedStatus = 0;
    private Integer readState;
    private Integer remaining;

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public View initContentView(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_activity_my_participate_in, viewGroup, false);
        this.llRoot = relativeLayout;
        return relativeLayout;
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void initTitle(TextView textView) {
        if (textView != null) {
            textView.setText(getResources().getString(R.string.moku_my_participate_in));
            textView.getPaint().setTextSize(CanvasUtils.getTextSize(this.phoneScreenUtils.getScale(this.mContext, 70.0f)));
        }
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseBackActivity, com.fendasz.moku.planet.ui.base.activity.BaseActivity
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
            mokuIconTextView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    LoadingDialog.show(MyParticipateInActivity.this.mContext);
                    MyParticipateInActivity.this.getCustomerServiceConfig(new Success<CustomerServiceConfig>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.1.1
                        @Override // com.fendasz.moku.planet.interf.Success
                        public void success(Integer num, CustomerServiceConfig customerServiceConfig) {
                            if (customerServiceConfig != null) {
                                String config = customerServiceConfig.getConfig();
                                if (TextUtils.isEmpty(config)) {
                                    return;
                                }
                                if (QqUtils.checkQqApkInstalled(MyParticipateInActivity.this.mContext)) {
                                    if (QqUtils.joinQqGroup(MyParticipateInActivity.this.mContext, config)) {
                                        return;
                                    }
                                    Toast.makeText(MyParticipateInActivity.this.mContext, "打开QQ群聊失败", 1).show();
                                    return;
                                }
                                Toast.makeText(MyParticipateInActivity.this.mContext, "请先安装QQ", 1).show();
                            }
                        }
                    }, new Error() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.1.2
                        @Override // com.fendasz.moku.planet.interf.Error
                        public void error(Integer num, String str) {
                            Toast.makeText(MyParticipateInActivity.this.mContext, "获取客服数据失败:" + str, 0).show();
                        }
                    }, new Finish() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.1.3
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getCustomerServiceConfig(final Success<CustomerServiceConfig> success, final Error error, final Finish finish) {
        ApiDataHelper.getApiDataHelper().getCustomerServiceConfig(this.mContext, new ApiDataCallBack<CustomerServiceConfig>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.2
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

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    protected void onLoad() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        initStaticView();
        getReSubmittedStatus();
        getSurplusCreditScore();
    }

    private void initStaticView() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i;
        ViewPager viewPager = (ViewPager) this.llRoot.findViewById(R.id.viewpager);
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.3
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (MyParticipateInActivity.this.mFragments.get(i2) instanceof TaskFailFragment) {
                    if (MyParticipateInActivity.this.reSubmittedStatus.intValue() > 0) {
                        MyParticipateInActivity.this.confirmReSubmitted();
                    }
                    if (MyParticipateInActivity.this.readState == null || 1 != MyParticipateInActivity.this.readState.intValue()) {
                        return;
                    }
                    MyParticipateInActivity.this.showComplaintDialog();
                }
            }
        });
        this.mStatusEmptyView = (StatusEmptyView) this.llRoot.findViewById(R.id.status_empty_view);
        this.mNoDataClickListener = new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyParticipateInActivity.this.initData();
            }
        };
        LinearLayout linearLayout = (LinearLayout) this.llRoot.findViewById(R.id.ll_container);
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
            String str = TAG;
            LogUtils.log(str, "got TabLayout Class");
            LogUtils.log(str, "TabLayout Constructor size >> " + cls.getConstructors().length);
            for (int i2 = 0; i2 < cls.getConstructors().length; i2++) {
                LogUtils.log(TAG, cls.getConstructors()[i2].getName());
                for (int i3 = 0; i3 < cls.getConstructors()[i2].getParameterTypes().length; i3++) {
                    LogUtils.log(TAG, cls.getConstructors()[i2].getParameterTypes()[i3].getName());
                }
            }
            try {
                Constructor<?> constructor = cls.getConstructor(Context.class);
                String str2 = TAG;
                LogUtils.log(str2, "found constructor >> " + constructor.getName());
                try {
                    View view = (View) constructor.newInstance(this.mContext);
                    LogUtils.log(str2, "got TabLayout instance");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        this.mStatusEmptyView.hide();
        LoadingDialog.show(this);
        LogUtils.log(TAG, "getAppInfoList");
        ApiDataHelper.getApiDataHelper().getAppInfoList(this.mContext, MokuConfigure.getInstance().getPhoneInfo(this.mContext).getAppId(), new ApiDataCallBack<List<String>>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.5
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, List<String> list) throws Exception {
                LoadingDialog.dismiss();
                if (list == null || i != 0) {
                    MyParticipateInActivity.this.mStatusEmptyView.show(Status.NO_APP_INFO, MyParticipateInActivity.this.mNoDataClickListener, null);
                } else {
                    list.add("官方裁决记录");
                    MyParticipateInActivity.this.createTab(list);
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                MyParticipateInActivity.this.mStatusEmptyView.show(Status.NO_APP_INFO, MyParticipateInActivity.this.mNoDataClickListener, null);
                Toast.makeText(MyParticipateInActivity.this.mContext, str + i, 0).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTab(List<String> list) throws Resources.NotFoundException {
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                this.mTitles.add("待开始");
                this.mFragments.add(new MyParticipateInFragment());
            } else if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.mTitles.add(list.get(i));
                            this.mFragments.add(new ArbitramentFragment());
                        }
                    } else if (!list.get(i).equals("0")) {
                        this.failTabName = list.get(i);
                        if (this.reSubmittedStatus.intValue() > 0) {
                            this.mTitles.add(list.get(i) + "\n(" + this.reSubmittedStatus + ")");
                        } else {
                            this.mTitles.add(list.get(i));
                        }
                        this.mFragments.add(new TaskFailFragment());
                    }
                } else if (!list.get(i).equals("0")) {
                    this.mTitles.add(list.get(i));
                    this.mFragments.add(new TaskCompletedFragment());
                }
            } else if (!list.get(i).equals("0")) {
                this.mTitles.add(list.get(i));
                this.mFragments.add(new UnderReviewFragment());
            }
        }
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this.mFragments, this.mTitles);
        this.myFragmentPagerAdapter = myFragmentPagerAdapter;
        this.mViewPager.setAdapter(myFragmentPagerAdapter);
        this.mViewPager.setOffscreenPageLimit(4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.fendasz.moku.planet.ui.base.activity.BaseActivity
    public void onSuperCreate(Bundle bundle) {
        this.mContext = this;
        if (bundle != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            List<Fragment> fragments = supportFragmentManager.getFragments();
            try {
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                for (int i = 0; i < fragments.size(); i++) {
                    fragmentTransactionBeginTransaction.remove(fragments.get(i));
                }
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mMokuOptions = MokuConfigure.getInstance().getMokuOptions(this.mContext);
        this.mTitles = new ArrayList<>();
        this.mFragments = new ArrayList();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i, i2, intent);
        if (i == 0) {
            if (i2 == 2) {
                finish();
            }
        } else {
            if (i2 == 600) {
                this.mViewPager.setCurrentItem(this.mFragments.size() - 1);
                return;
            }
            if (i2 == 602) {
                for (Fragment fragment : this.mFragments) {
                    if (fragment instanceof UnderReviewFragment) {
                        this.mViewPager.setCurrentItem(this.mFragments.indexOf(fragment));
                        return;
                    }
                }
            }
        }
    }

    private void getReSubmittedStatus() {
        ApiDataHelper.getApiDataHelper().getReSubmittedStatus(this.mContext, new ApiDataCallBack<Integer>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.6
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Integer num) throws Exception {
                if (num != null) {
                    MyParticipateInActivity.this.reSubmittedStatus = num;
                } else {
                    MyParticipateInActivity.this.reSubmittedStatus = 0;
                }
                MyParticipateInActivity.this.initData();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                MyParticipateInActivity.this.reSubmittedStatus = 0;
                MyParticipateInActivity.this.initData();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmReSubmitted() {
        ApiDataHelper.getApiDataHelper().confirmReSubmitted(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.7
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                if (MyParticipateInActivity.this.mTitles != null && !MyParticipateInActivity.this.mTitles.isEmpty() && MyParticipateInActivity.this.reSubmittedStatus.intValue() > 0) {
                    for (int i2 = 0; i2 < MyParticipateInActivity.this.mTitles.size(); i2++) {
                        if (MyParticipateInActivity.this.failTabName != null && MyParticipateInActivity.this.failTabName.equals(MyParticipateInActivity.this.mTitles.get(i2))) {
                            MyParticipateInActivity.this.mTitles.set(i2, MyParticipateInActivity.this.failTabName + "\n(" + MyParticipateInActivity.this.reSubmittedStatus + ")");
                        }
                    }
                }
                if (MyParticipateInActivity.this.myFragmentPagerAdapter != null) {
                    MyParticipateInActivity.this.myFragmentPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                MyParticipateInActivity.this.showToast(str);
            }
        });
    }

    private void getSurplusCreditScore() {
        ApiDataHelper.getApiDataHelper().getSurplusCreditScore(this.mContext, new ApiDataCallBack<Map<String, Object>>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.8
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Map<String, Object> map) throws Exception {
                if (map != null) {
                    Object obj = map.get("readState");
                    try {
                        if (obj == null) {
                            MyParticipateInActivity.this.readState = -1;
                        } else {
                            MyParticipateInActivity.this.readState = Integer.valueOf(new BigDecimal(obj.toString()).intValue());
                        }
                    } catch (Exception unused) {
                        LogUtils.logE(MyParticipateInActivity.TAG, "getSurplusCreditScore readSate not integer");
                        MyParticipateInActivity.this.readState = -1;
                    }
                    Object obj2 = map.get("remaining");
                    if (obj2 != null) {
                        MyParticipateInActivity.this.remaining = Integer.valueOf(new BigDecimal(obj2.toString()).intValue());
                        if (MyParticipateInActivity.this.remaining.intValue() <= 0) {
                            MyParticipateInActivity.this.remaining = 0;
                        }
                    }
                }
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                MyParticipateInActivity.this.showToast(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showComplaintDialog() {
        String string;
        CustomBuildDialog.DialogBuilder dialogBuilder = new CustomBuildDialog.DialogBuilder(this.mContext);
        if (this.remaining.intValue() <= 2) {
            string = this.mContext.getString(R.string.moku_myparticipationin_account_remaining_chance, new Object[]{this.remaining.toString()});
        } else {
            string = this.mContext.getString(R.string.moku_myparticipationin_account_remaining);
        }
        dialogBuilder.setCancelable(false).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(string).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.9
            @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
            public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                customBuildDialog.dismiss();
                MyParticipateInActivity.this.readUserReported();
            }
        }).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readUserReported() {
        LoadingDialog.show(this);
        ApiDataHelper.getApiDataHelper().readUserReported(this.mContext, new ApiDataCallBack<Object>() { // from class: com.fendasz.moku.planet.ui.activity.MyParticipateInActivity.10
            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void success(int i, Object obj) throws Exception {
                LoadingDialog.dismiss();
            }

            @Override // com.fendasz.moku.planet.entity.ApiDataCallBack
            public void error(int i, String str) throws Exception {
                LoadingDialog.dismiss();
                MyParticipateInActivity.this.showToast(str);
            }
        });
    }
}
