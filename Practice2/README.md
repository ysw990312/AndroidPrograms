# 布局样例
该程序主要用**线性布局**、**约束布局**、**表格布局**这三种布局来展示这三个布局的用法与相应的实例</br>
## 开始界面
这是整个项目的开始界面，采用线性布局、一个文本视图（标题）、三个按钮（**线性布局**、**约束布局**、**表格布局**），通过这三个按钮分别跳转到使用这三种布局构建的界面</br>
![StartScreen](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice2/picture/StartScreen.png)
## 线性布局
按下“线性布局”按钮，跳转到线性布局构建的界面中。构建实例的注意点：</br>
1. 文本视图的边框：调用Practice2\app\src\main\res\drawable下的textview_border.xml文件
2. 实例中一共有四行内容，那么分别用四个**LinearLayout**来包装这四行内容
3. 看起来看长的那段文本视图，可以采用权重的方式实现——**android:layout_weight="1"**
4. 第三行内容的文本视图的大小，那么采用分权的方式实现——第三行中的每个文本视图都设置**android:layout_weight="1"**</br>
![LinearLayoutScreen](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice2/picture/LinearLayout.png)
## 约束（相对）布局
按下“约束布局”按钮，跳转到约束布局构建的界面中。构建实例的注意点：</br>
