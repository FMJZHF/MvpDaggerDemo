package com.zhf.mvpdaggerdemo;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.zhf.base.view.BaseMvpActivity;


public class MainActivity extends BaseMvpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void startAction(Context context, String username) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

}
