package com.example.hannahxian.mutedoor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hannahxian.mutedoor.R;
import com.example.hannahxian.mutedoor.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NintyActivity extends AppCompatActivity {

    @BindView(R.id.guangqi)
    TextView mGuangqi;
    @BindView(R.id.shangxiafang)
    TextView mShangxiafang;
    @BindView(R.id.boligao)
    TextView mBoligao;
    @BindView(R.id.bolikuan)
    TextView mBolikuan;
    @BindView(R.id.biankuanggao)
    TextView mBiankuanggao;
    @BindView(R.id.shangxiahua)
    TextView mShangxiahua;
    @BindView(R.id.zhongkongtiaokuan)
    TextView mZhongkongtiaokuan;
    @BindView(R.id.zhongkongtiaogao)
    TextView mZhongkongtiaogao;
    @BindView(R.id.org_door_height)
    TextView mOrgDoorHeight;
    @BindView(R.id.org_door_width)
    TextView mOrgDoorWidth;

    private Integer mDoorHeight, mDoorWidth;
    private float mGlassHeight, mGlassWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninty);
        ButterKnife.bind(this);

        getData();

        setData();
    }

    private void setData() {
        Util.setText(mOrgDoorHeight,String.valueOf(mDoorHeight));
        Util.setText(mOrgDoorWidth,String.valueOf(mDoorWidth));

        Util.setText(mGuangqi, String.valueOf(mDoorHeight - 55));
        Util.setText(mShangxiafang, String.valueOf((float) (mDoorWidth + 50) / 2));
        Util.setText(mBoligao, String.valueOf(mGlassHeight));
        Util.setText(mBolikuan, String.valueOf(mGlassWidth));
        Util.setText(mBiankuanggao, String.valueOf(mDoorHeight));
        Util.setText(mShangxiahua, String.valueOf(mDoorWidth - 54));
        Util.setText(mZhongkongtiaokuan, String.valueOf(mGlassWidth));
        Util.setText(mZhongkongtiaogao, String.valueOf(mGlassHeight - 16));
    }

    private void getData() {
        mDoorHeight = getIntent().getIntExtra("doorHeight", 0);
        mDoorWidth = getIntent().getIntExtra("doorWidth", 0);
        mGlassHeight = mDoorHeight - 213;
        mGlassWidth = ((float) (mDoorWidth + 50) / 2) - 158;
    }

}
