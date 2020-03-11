package com.zhf.mvpdaggerdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zhf.mvpdaggerdemo.base.v.BaseMvpActivity;
import com.zhf.mvpdaggerdemo.test.DaggerLogin1Component;
import com.zhf.mvpdaggerdemo.test.Login1Contract;
import com.zhf.mvpdaggerdemo.test.Login1Module;
import com.zhf.mvpdaggerdemo.test.Login1Presenter;

public class Login1Activity extends BaseMvpActivity<Login1Presenter> implements Login1Contract.ILoginView {

    private Button loginBtn, clearBtn;
    private ProgressDialog progressDialog;

    private Context mContext;

    private static final String TAG = "Login1Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        initView();
        mContext = this;
        DaggerLogin1Component.builder().login1Module(new Login1Module(this)).build().inject(this);
    }

    private void initView() {
        loginBtn = findViewById(R.id.login_btn);
        clearBtn = findViewById(R.id.clear_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.clear();
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("加载中");
    }

    @Override
    public String getUserName() {
        return "用户名";
    }

    @Override
    public String getPassword() {
        return "密码";
    }

    @Override
    public void clearUserName() {
        Log.e(TAG, "clearUserName: 清除用户名" );
//        usernameEt.setText("");
    }

    @Override
    public void clearPassword() {
        Log.e(TAG, "clearPassword: 清除密码" );
//        passwordEt.setText("");
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void toMainActivity(UserInfoModel userInfoModel) {
        Log.e(TAG, "toMainActivity: 用户登录成功，并跳转到 MainActivity");
        MainActivity.startAction(this, userInfoModel.getUsername());
        finish();
    }

    @Override
    public void showFailedError() {
        Log.e(TAG, "showFailedError: 登陆失败");
        Toast.makeText(mContext, "登陆失败，请重新尝试", Toast.LENGTH_SHORT).show();
    }
}