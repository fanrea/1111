package com.fendasz.moku.planet.ui.base.activity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.common.network.interceptor.CompanyInterceptor;
import com.fendasz.moku.planet.entity.MokuCellInfoCallback;
import com.fendasz.moku.planet.entity.MokuOptions;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.ui.customview.MokuIconTextView;
import com.fendasz.moku.planet.ui.customview.TitleView;
import com.fendasz.moku.planet.utils.LogUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.StatusBarUtils;
import com.github.gzuliyujiang.oaid.DeviceID;
import com.github.gzuliyujiang.oaid.IGetter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class BaseActivity extends AppCompatActivity implements MokuCellInfoCallback.CellInfoCallBack {
    private static final String TAG = "MoKuBaseActivity=>";
    private boolean isSensorMamagerRegister;
    private SensorEventListener listener;
    private RelativeLayout mRlContent;
    private RelativeLayout mRlContentBottom;
    private RelativeLayout mRlRoot;
    public TitleView mTvTitle;
    public PhoneScreenUtils phoneScreenUtils;
    private Sensor sensor;
    private SensorManager sensorMamager;

    public void acceptLightData(float f) {
    }

    public abstract View initContentView(ViewGroup viewGroup);

    public abstract void initLeftView(TextView textView);

    public abstract void initRightView(MokuIconTextView mokuIconTextView);

    public void initRightView(MokuIconTextView mokuIconTextView, ImageView imageView) {
    }

    public abstract void initTitle(TextView textView);

    public abstract void initTitleCenterLayout(RelativeLayout relativeLayout);

    public boolean needLightSensor() {
        return false;
    }

    protected abstract void onLoad();

    public abstract void onSuperCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int color;
        int color2;
        int color3;
        super.onCreate(bundle);
        onSuperCreate(bundle);
        this.mRlRoot = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.moku_activity_base, (ViewGroup) null, false);
        this.mRlRoot.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRlRoot.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Log.d("mRlRoot==>", "mRlRoot click");
            }
        });
        setContentView(this.mRlRoot);
        if (needLightSensor()) {
            initLightSensor();
        }
        this.phoneScreenUtils = PhoneScreenUtils.getInstance();
        MokuOptions mokuOptions = MokuConfigure.getInstance().getMokuOptions(this);
        this.mTvTitle = (TitleView) findViewById(R.id.tvTitle);
        int color4 = Color.parseColor(mokuOptions.getString("titleColor", "#ffffff"));
        TitleView titleView = this.mTvTitle;
        if (titleView != null) {
            titleView.setBackgroundColor(color4);
            TitleView titleView2 = this.mTvTitle;
            titleView2.initViewHeight(titleView2.getLayoutParams());
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_content);
        this.mRlContent = relativeLayout;
        this.mRlContent.addView(initContentView(relativeLayout), new RelativeLayout.LayoutParams(-1, -1));
        this.mRlContentBottom = (RelativeLayout) findViewById(R.id.rl_content_bottom);
        TextView centerTextView = this.mTvTitle.getCenterTextView();
        if (centerTextView != null && (color3 = Color.parseColor(mokuOptions.getString("titleTextColor", "#000000"))) != 0) {
            centerTextView.setTextColor(color3);
        }
        initTitle(centerTextView);
        TextView leftTextView = this.mTvTitle.getLeftTextView();
        if (leftTextView != null && (color2 = Color.parseColor(mokuOptions.getString("titleBackColor", "#000000"))) != 0) {
            leftTextView.setTextColor(color2);
        }
        initLeftView(leftTextView);
        MokuIconTextView rightTextView = this.mTvTitle.getRightTextView();
        if (rightTextView != null && (color = Color.parseColor(mokuOptions.getString("titleTextColor", "#000000"))) != 0) {
            rightTextView.setTextColor(color);
        }
        initRightView(rightTextView);
        initRightView(rightTextView, this.mTvTitle.getRighTagImage());
        initTitleCenterLayout(this.mTvTitle.getTitleCenterRelativeLayout());
        initView();
        initStatusBarColor();
        onLoad();
    }

    @Override // com.fendasz.moku.planet.entity.MokuCellInfoCallback.CellInfoCallBack
    public void cellSuccess(int i, String str) throws NoSuchMethodException, SecurityException {
        LogUtils.logD(TAG, "getSimCardInfo success,set user device baseStationInfo");
        MokuConfigure.getInstance().setBaseStationInfo(this, str);
    }

    @Override // com.fendasz.moku.planet.entity.MokuCellInfoCallback.CellInfoCallBack
    public void cellError(int i, String str) throws NoSuchMethodException, SecurityException {
        LogUtils.logD(TAG, "getSimCardInfo error");
        MokuConfigure.getInstance().setBaseStationInfo(this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        SensorManager sensorManager = this.sensorMamager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.listener);
        }
    }

    public void initStatusBarColor() {
        StatusBarUtils.setStatusBarColor(this, Color.parseColor(MokuConfigure.getInstance().getMokuOptions(this).getString("statusBarColor", "#cdcdcd")));
    }

    public RelativeLayout getRlContentBottom() {
        return this.mRlContentBottom;
    }

    public TitleView getTvTitle() {
        return this.mTvTitle;
    }

    public RelativeLayout getRootView() {
        return this.mRlRoot;
    }

    public void initView() {
        LogUtils.logD(TAG, "initView invoke");
    }

    public void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    private void initLightSensor() {
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.sensorMamager = sensorManager;
        this.sensor = sensorManager.getDefaultSensor(5);
        SensorEventListener sensorEventListener = new SensorEventListener() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseActivity.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                BaseActivity.this.acceptLightData(sensorEvent.values[0]);
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
                Log.d(BaseActivity.TAG, "onAccuracyChanged");
            }
        };
        this.listener = sensorEventListener;
        this.isSensorMamagerRegister = true;
        this.sensorMamager.registerListener(sensorEventListener, this.sensor, 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        SensorEventListener sensorEventListener;
        super.onDestroy();
        Log.w(TAG, "onDestroy,sensorMamager unregisterListener");
        SensorManager sensorManager = this.sensorMamager;
        if (sensorManager != null && (sensorEventListener = this.listener) != null && this.isSensorMamagerRegister) {
            this.isSensorMamagerRegister = false;
            sensorManager.unregisterListener(sensorEventListener);
            this.sensorMamager = null;
            this.listener = null;
        }
        CompanyInterceptor.removeContent();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!needLightSensor() || this.isSensorMamagerRegister) {
            return;
        }
        initLightSensor();
    }

    public void updateOaid() {
        DeviceID.getOAID(this, new IGetter() { // from class: com.fendasz.moku.planet.ui.base.activity.BaseActivity.3
            @Override // com.github.gzuliyujiang.oaid.IGetter
            public void onOAIDGetComplete(String str) throws NoSuchMethodException, SecurityException {
                LogUtils.logD(BaseActivity.TAG, "moku_oaid_api invoke,oaid get success");
                MokuConfigure.getInstance().updateOaid(BaseActivity.this, str);
            }

            @Override // com.github.gzuliyujiang.oaid.IGetter
            public void onOAIDGetError(Exception exc) {
                LogUtils.logE(BaseActivity.TAG, "moku_oaid_api invoke,oaid get error" + exc.getMessage());
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        LogUtils.logD(TAG, "finish_ApiCreateObservable.getInstance().closeDisposable()");
        super.finish();
    }
}
