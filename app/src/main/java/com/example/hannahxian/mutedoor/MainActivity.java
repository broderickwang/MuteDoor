package com.example.hannahxian.mutedoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.hannahxian.mutedoor.listner.MyTextWatcher;
import com.example.hannahxian.mutedoor.ui.EityFiveActivity;
import com.example.hannahxian.mutedoor.ui.EityThreeActivity;
import com.example.hannahxian.mutedoor.ui.NintyActivity;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String EMPTY_STRING = "";

    private boolean mJump = false;

    @BindView(R.id.door_height)
    EditText mDoorHeight;
    @BindView(R.id.door_width)
    EditText mDoorWidth;
    /*@BindView(R.id.glass_height)
    EditText mGlassHeight;
    @BindView (R.id.glass_width)
    EditText mGlassWidth;*/
    @BindView(R.id.ninty)
    FloatingActionButton mNinty;
    @BindView(R.id.eitythree)
    FloatingActionButton mEitythree;
    @BindView(R.id.eityfive)
    FloatingActionButton mEityfive;
    @BindView(R.id.multiple_actions)
    FloatingActionsMenu mMultipleActions;
    @BindView(R.id.door_height_wrap)
    TextInputLayout mDoorHeightWrap;
    @BindView(R.id.door_width_wrap)
    TextInputLayout mDoorWidthWrap;
    /*@BindView(R.id.glass_height_wrap)
    TextInputLayout mGlassHeightWrap;
    @BindView(R.id.glass_width_wrap)
    TextInputLayout mGlassWidthWrap;*/
//11222
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();

    }

    private void init() {
        mDoorHeight.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    mDoorHeightWrap.setError("请输入门洞高");
                }else {
                    mDoorHeightWrap.setError(EMPTY_STRING);
                    mJump = true;
                }
            }
        });
        mDoorWidth.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    mDoorWidthWrap.setError("请输入门洞宽");
                }else{
                    mDoorWidthWrap.setError(EMPTY_STRING);
                    mJump = true;
                }
            }
        });
        /*mGlassHeight.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    mDoorHeightWrap.setError("请输玻璃高");
                }else{
                    mGlassHeightWrap.setError(EMPTY_STRING);
                    mJump = true;
                }
            }
        });
        mGlassWidth.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(s)){
                    mDoorHeightWrap.setError("请输入玻璃宽");
                }else{
                    mGlassWidthWrap.setError(EMPTY_STRING);
                    mJump = true;
                }
            }
        });*/
    }

    @OnClick({R.id.ninty, R.id.eitythree, R.id.eityfive})
    public void onViewClicked(View view) {
        if(validateValue()) {
            switch (view.getId()) {
                case R.id.ninty:
                    jumpActivity(NintyActivity.class);
                    break;
                case R.id.eitythree:
                    jumpActivity(EityThreeActivity.class);
                    break;
                case R.id.eityfive:
                    jumpActivity(EityFiveActivity.class);
                    break;
            }
        }
        if(mJump) {

        }
    }

    private boolean validateValue(){
        boolean rst = true;
        if(TextUtils.isEmpty(mDoorHeight.getText().toString())){
            mDoorHeightWrap.setError("请输入门洞高");
            rst = false;
        }
        if(TextUtils.isEmpty(mDoorWidth.getText().toString())){
            mDoorWidthWrap.setError("请输入门洞宽");
            rst = false;
        }
        /*if(TextUtils.isEmpty(mGlassHeight.getText().toString())){
            mGlassHeightWrap.setError("请输玻璃高");
            rst = false;
        }
        if(TextUtils.isEmpty(mGlassWidth.getText().toString())){
            mGlassWidthWrap.setError("请输入玻璃宽");
            rst = false;
        }*/
        return rst;
    }

    private void jumpActivity(Class claz) {
        Intent intent = new Intent(MainActivity.this, claz);
        intent.putExtra("doorHeight",Integer.valueOf(mDoorHeight.getText().toString()));
        intent.putExtra("doorWidth",Integer.valueOf(mDoorWidth.getText().toString()));
        /*intent.putExtra("glassHeight",Integer.valueOf(mGlassHeight.getText().toString()));
        intent.putExtra("glassWidth",Integer.valueOf(mGlassWidth.getText().toString()));*/
        startActivity(intent);
    }


}
