package com.fjnu8211.implicitintentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText urlText;
    private Button btn_browser;
    private String urlHead="http://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        urlText = findViewById(R.id.input_url);
        btn_browser = findViewById(R.id.btn_browser);
        btn_browser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_browser:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(urlHead+urlText.getText().toString()));
//                Intent choose = Intent.createChooser(intent,"选择一个浏览器");
                startActivity(intent);
                break;
        }
    }

}
