package com.example.hannahxian.mutedoor.listner;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Broderick
 * User: hannahxian
 * Date: 2018/5/17
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
 **/
public abstract class MyTextWatcher implements TextWatcher{

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public abstract void onTextChanged(CharSequence s, int start, int before, int count);

    @Override
    public void afterTextChanged(Editable s) {

    }

}
