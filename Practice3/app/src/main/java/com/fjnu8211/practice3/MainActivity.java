package com.fjnu8211.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_SimpleAdapter;
    private Button btn_CustomDialog;
    private Button btn_XmlMenu;
    private Button btn_ActionContext;
    private Button btn_ProcessBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        int displayWidth = dm.widthPixels;
        int displayHeight = dm.heightPixels;

        System.out.println(displayWidth+":"+displayHeight);

        //设置简单适配器样例按钮
        btn_SimpleAdapter = findViewById(R.id.simple_adapter);
        btn_SimpleAdapter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SimpleAdapterDemo.class);
                startActivity(intent);
            }
        });

        //设置自定义对话框样例按钮
        btn_CustomDialog = findViewById(R.id.custom_dialog);
        btn_CustomDialog.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomDialogDemo.class);
                startActivity(intent);
            }
        });

        //设置Xml菜单样例按钮
        btn_XmlMenu = findViewById(R.id.xml_menu);
        btn_XmlMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XmlMenuDemo.class);
                startActivity(intent);
            }
        });

        //设置上下文菜单样例按钮
        btn_ActionContext = findViewById(R.id.action_context);
        btn_ActionContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActionContextDemo.class);
                startActivity(intent);
            }
        });

        //设置进度条样例按钮
        btn_ProcessBar = findViewById(R.id.process_bar);
        btn_ProcessBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProcessBarDemo.class);
                startActivity(intent);
            }
        });

    }
}
