# Intent实验说明文档
该实验需要构造两个应用：</br>
**第一个应用：获取URL地址并启动隐式Intent的调用**</br>
**第二个应用：自定义WebView来加载URL**</br>
接下来对以上两个应用进行分开的讲解与说明
## ImplicitintentDemo应用
1. 该应用的构成很简单，主要由activity_main.xml与MainActivity.java这两部分构成
2. activity_main.xml该布局文件主要用线性布局来进行相应的布局，并添加一个EditText与一个Button组件，该页面的展示如下图：</br>
![ImplicitintentDemoScreen](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice4/Picture/ImplicitintentDemoScreen.png)
3. 输入**相应的网址**，最后点击**访问**，就会要求你选择相应的浏览器进行一个网址的访问，如下图所示：</br>
![ChooseBrowser](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice4/Picture/ChooseBrowser.png)
4. MainActivity.java该应用的主要代码为：
```
  Intent intent=new Intent();
  intent.setAction(Intent.ACTION_VIEW);
  intent.setData(Uri.parse(urlHead+urlText.getText().toString()));
  //Intent choose = Intent.createChooser(intent,"选择一个浏览器");
  startActivity(intent);
```
## MyBrowser应用
1. 主要由activity_main.xml与MainActivity.java这两部分构成
2. activity_main.xml该布局文件主要用相对布局来进行相应的布局，并添加WebView组件
3. 要对自定义的MyBrowser内置浏览器进行相应的配置，点击**app**下拉框，选择**Edit Configurations**，如图所示：</br>
![Warning1](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice4/Picture/Warning1.png)
4. 将Default Activity，改变为Nothing，最后点击应用即可，如图所示：</br>
![Warning2](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice4/Picture/Warning2.png)</br>
![Warning3](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice4/Picture/Warning3.png)
5. 根据上一步选择后打开网址的浏览器，即可跳转到如下的页面，如图所示：</br>
![JumpURL](https://github.com/ysw990312/AndroidPrograms/blob/master/Practice4/Picture/JumpURL.png)
6. MainActivity.java该应用的主要代码为：
```
    @Override
    protected void onCreate(    Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri uriData = intent.getData();
        URL url = null;
        try{
            url = new URL(uriData.getScheme(), uriData.getHost(), uriData.getPath());
        }catch (Exception e) {
            e.printStackTrace();
        }
        openBrowser(url);
    }

    private void openBrowser(URL url) {
        WebView webView = findViewById(R.id.webView);
        //加载Web资源
        webView.loadUrl(url.toString());
        //默认使用第三方或系统默认浏览器打开网页的行为
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //返回值是true打开WebView，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }
```
