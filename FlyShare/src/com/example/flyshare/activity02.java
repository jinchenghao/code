package com.example.flyshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.DialogInterface;

public class activity02 extends Activity {
	private RadioButton manRadio;
	private RadioButton womanRadio;
    private EditText et_password;
    private Button btn_send;
    private EditText et_name;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02);
        et_name=(EditText) findViewById(R.id.et_name);
        et_password=(EditText) findViewById(R.id.et_password);
        manRadio=(RadioButton) findViewById(R.id.radioMale);
        womanRadio=(RadioButton) findViewById(R.id.radioFemale);
    }
	  public void click1(View view){
		   Intent intent=new Intent(this,activity03.class);
			intent.putExtra("name", et_name.getText().toString().trim());
			intent.putExtra("password", et_password.getText().toString().trim());
			String str=" ";
			if(manRadio.isChecked()){
				str="ÄÐ";
			}
			else if(womanRadio.isChecked()){
				str="Å®";
			}
			intent.putExtra("sex",str);
			startActivity(intent);	
		}
}
