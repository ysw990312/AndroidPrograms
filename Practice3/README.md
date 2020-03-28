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
## XML菜单样例
## 上下文菜单样例
## 进度条样例
