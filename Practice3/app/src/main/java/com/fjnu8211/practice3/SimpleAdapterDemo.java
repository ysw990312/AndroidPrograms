package com.fjnu8211.practice3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterDemo extends AppCompatActivity {

    private ListView simpleListView;                                                    //定义集合视图

    private String[] aName = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};     //定义动物名称数组
    private int[] aImage = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};                       //定义动物图片数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        simpleListView = findViewById(R.id.simpleListView);

        //将所有动物的数据添加到集合当中
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();               //定义存储所有动物名称与图片的集合
        for(int i=0; i<aName.length; i++) {
            HashMap<String, String> hashMap = new HashMap<>();                          //定义一个用于临时存储动物名称与图片的哈希集合
            hashMap.put("name", aName[i]);
            hashMap.put("image", String.valueOf(aImage[i]));
            arrayList.add(hashMap);                                                     //将临时存储的数据添加到arrayList集合中
        }

        //构造简单适配器
        String[] from = {"name", "image"};
        int[] to = {R.id.textView, R.id.imageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.listview_items, from, to);
        simpleListView.setAdapter(simpleAdapter);

        //listView_items点击事件——消息弹窗
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), aName[position], Toast.LENGTH_LONG).show();     //Toast.LENGTH_LONG（3.5秒）
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
