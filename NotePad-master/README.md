# 期中考试实验说明文档
该实验是在原有的Note Pad上添加两个功能：
1. NoteList中显示条目增加时间戳显示
2. 添加笔记查询功能（根据标题查询）
接下来对以上需要添加的两个功能进行说明与演示
## 添加时间戳
### 需求分析
1. 只需在notepadprovider类中修改insert方法，用时间戳来格式化时间格式，并添加到数据库中即可，关键代码如下：
```
        Long now = Long.valueOf(System.currentTimeMillis());
        Date date = new Date(now);
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String dateTime = format.format(date);
        if (values.containsKey(NotePad.Notes.COLUMN_NAME_CREATE_DATE) == false) {
            values.put(NotePad.Notes.COLUMN_NAME_CREATE_DATE, dateTime);
        }
```
2. 在进行笔记更新的时候，只需修改NoteEditor类中的updateNote方法，用时间戳来格式化时间格式，并添加到数据库中即可，关键代码如下：
```        ContentValues values = new ContentValues();
        //将格式化后的时间戳数据更新到数据库中
        Long now = Long.valueOf(System.currentTimeMillis());
        Date date = new Date(now);
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String dateTime = format.format(date);
        values.put(NotePad.Notes.COLUMN_NAME_MODIFICATION_DATE, dateTime);
```
### 运行结果
