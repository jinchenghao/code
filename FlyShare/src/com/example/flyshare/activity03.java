package com.example.flyshare;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class activity03 extends Activity{
	private TextView tv_name,tv_password,tv_sex;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity03);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String password=intent.getStringExtra("password");
        String sex=intent.getStringExtra("sex");
        tv_name=(TextView) findViewById(R.id.tv_name);
        tv_password=(TextView) findViewById(R.id.tv_password);
        tv_sex=(TextView) findViewById(R.id.tv_sex);
        tv_name.setText("用户名"+name);
        tv_password.setText("密码"+password);
        tv_sex.setText("性别"+sex);
	
		}

}

