package com.example.hannahxian.mutedoor.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hannahxian.mutedoor.R;
import com.example.hannahxian.mutedoor.util.Util;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwentyFiveJGWActivity extends AppCompatActivity {

    @BindView(R.id.wkg)
    TextView mWkg;
    @BindView(R.id.wkk)
    TextView mWkk;
    @BindView(R.id.sg)
    TextView mSg;
    @BindView(R.id.sk)
    TextView mSk;
    @BindView(R.id.wg)
    TextView mWg;
    @BindView(R.id.wk)
    TextView mWk;
    @BindView(R.id.org_door_height)
    TextView mOrgDoorHeight;
    @BindView(R.id.org_door_width)
    TextView mOrgDoorWidth;

    private Integer mDoorHeight, mDoorWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_five);
        ButterKnife.bind(this);

        getBundleData();

        setData();
    }

    private void setData() {

        Util.setText(mOrgDoorHeight,String.valueOf(mDoorHeight));
        Util.setText(mOrgDoorWidth,String.valueOf(mDoorWidth));

        mWkg.setText(String.valueOf(mDoorHeight + 40));
        mWkk.setText(String.valueOf(mDoorWidth + 40));
        mSg.setText(String.valueOf(mDoorHeight - 1));
        mSk.setText(String.valueOf(mDoorWidth - 14));
        mWg.setText(String.valueOf(mDoorHeight - 69));
        mWk.setText(String.valueOf(mDoorWidth - 82));
    }

    private void getBundleData() {
        mDoorHeight = getIntent().getIntExtra("doorHeight", 0);
        mDoorWidth = getIntent().getIntExtra("doorWidth", 0);
    }
}
