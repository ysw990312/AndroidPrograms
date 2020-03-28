# UI组件实验说明文档
该实验一共包括五个样例——**简单适配器样例**、**自定义对话框样例**、**XML菜单样例**、**上下文菜单样例**、**进度条样例**</br>
接下来对以上五个样例进行演示与说明
## 导航页面
导航页面主要由五个对应于不同UI组件用法的按钮组成</br>
![导航页面](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/StartScreen.png)
## 简单适配器样例
本界面演示了SimpleAdapter用来装配ListView的用法。ListView每个Item的布局采用相对布局，包含一个ImageView和一个TextView，并且指定ImageView对齐父类布局的右侧。接下来说说该样例主要的代码与步骤：
1. 在activity_simple_adapter.xml下，定义该界面的布局为相对布局，并在里面定义相应的ListView组件，并且通过以下代码设置相应的分界线与选中颜色
```
        android:divider="#000"
        android:dividerHeight="1dp"
        android:listSelector="#a9d8f3"
```
2. 在listview_items.xml下，引用相对布局来进行每一行的规划，每一行都由ImageView与TextView两个组件构成，**单机ListView条目显示颜色并指定其listSelector属性**。
3. 在SimpleAdapterDemo.java类下，进行相关xml文件（activity_simple_adapter.xml、listview_items.xml）的调用，并定义动物名称与图片数组，最后进行简单适配器的调用，简单适配器的主要代码如下：
```
        String[] from = {"name", "image"};
        int[] to = {R.id.textView, R.id.imageView};
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, arrayList, R.layout.listview_items, from, to);
        simpleListView.setAdapter(simpleAdapter);
```
4. listView_items点击事件——消息弹窗，代码如下：
```
        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), aName[position], Toast.LENGTH_LONG).show();     //Toast.LENGTH_LONG（3.5秒）
            }
        });
```
5. 效果图如下：</br>
![简单适配器1](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Simple1.png)</br>
![简单适配器2](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Simple2.png)
## 自定义对话框样例
该样例的设计步骤如下：
1. 在activity_custom_dialog.xml下，定义该页面的布局为相对布局，并为此添加一个按钮来调出对话框
2. 在custom_dialog.xml下，使用线性布局来构造对话框，并定义弹框图片、账号输入框以及密码输入框，这里面关键的部分代码如下：</br>
账号输入框的输入类型：`android:inputType="text"`</br>
密码输入框的输入类型：`android:inputType="textPassword"`
3. 在CustomDialogDemo.java下，**通过调用getLayoutInflater()获取LayoutInflater实例，并利用LayoutInflater的inflate()方法从自定义布局文件中加载对话框的布局**，从而实现自定义对话框，其关键代码如下：
```
        builder.setView(inflater.inflate(R.layout.custom_dialog, null))
                //添加操作项目
                .setPositiveButton(R.string.sign_in, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //实现登录账户功能（不去实现），设为空
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create();
        builder.show();
```
5. 效果图如下：</br>
![自定义对话框1](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Dialog1.png)</br>
![自定义对话框2](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Dialog2.png)
## XML菜单样例
该样例的设计步骤如下：
1. 在activity_xml_menu.xml下，定义页面的布局为相对布局，并定义一个测试文本框
2. 在menu/menu_setting.xml下，定义菜单栏，包括字号、颜色等，该配置文件的代码如下：
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:title="@string/menu_Font">
        <menu>
            <item
                android:id="@+id/menu_font_small"
                android:title="@string/menu_font_small"/>
            <item
                android:id="@+id/menu_font_middle"
                android:title="@string/menu_font_middle"/>
            <item
                android:id="@+id/menu_font_big"
                android:title="@string/menu_font_big"/>
        </menu>
    </item>

    <item
        android:id="@+id/menu_normal"
        android:title="@string/menu_Normal"
        />

    <item android:title="@string/menu_Color">
        <menu>
            <item
                android:id="@+id/menu_color_black"
                android:title="@string/menu_color_black"/>
            <item
                android:id="@+id/menu_color_red"
                android:title="@string/menu_color_red"/>
        </menu>
    </item>

</menu>
```
3. 在XmlMenuDemo.java下，一定要去**继承AppCompatActivity**，要不然右上角的菜单栏显示不出来；接下来就是创建菜单，并对菜单中的操作项定义相关的操作事件，其代码如下：
```
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
```
4. **PS：假如继承了AppCompatActivity，还显示不出来菜单栏则调用如下的代码即可：**
```
    /* 假如右上角的菜单栏不显示就调用这个方法 */
    private void makeActionOverflowMenuShown() {
        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {

        }
    }
```
5. 效果图如下：</br>
![xml菜单1](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Xml1.png)</br>
![xml菜单1](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Xml2.png)</br>
![xml菜单1](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Xml3.png)</br>
![xml菜单1](https://github.com/ysw990312/AndroidPrograms/blob/96cfd7a54102a20fa090b22a36afa0d534c1c795/Practice3/Picture/Xml4.png)
## 上下文菜单样例
## 进度条样例
