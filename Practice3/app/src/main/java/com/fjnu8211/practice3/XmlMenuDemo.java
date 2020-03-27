package com.fjnu8211.practice3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class XmlMenuDemo extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        makeActionOverflowMenuShown();
        setContentView(R.layout.activity_xml_menu);
        textView = findViewById(R.id.xml_test);
    }

    /* 创建操作菜单 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    /* 设置选中操作项对应事件 */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_font_small:
                textView.setTextSize(10*2);
                break;
            case R.id.menu_font_middle:
                textView.setTextSize(16*2);
                break;
            case R.id.menu_font_big:
                textView.setTextSize(20*2);
                break;
            case R.id.menu_normal:
                Toast.makeText(XmlMenuDemo.this, "这是普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_color_red:
                textView.setTextColor(Color.RED);
                break;
            case R.id.menu_color_black:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return true;
    }
    /* 假如右上角的菜单栏不显示就调用这个方法 */
//    private void makeActionOverflowMenuShown() {
//        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
//        try {
//            ViewConfiguration config = ViewConfiguration.get(this);
//            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
//            if (menuKeyField != null) {
//                menuKeyField.setAccessible(true);
//                menuKeyField.setBoolean(config, false);
//            }
//        } catch (Exception e) {
//
//        }
//    }

}
