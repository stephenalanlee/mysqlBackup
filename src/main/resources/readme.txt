1 backUpReg.reg 为注册表文件，提供开机启动功能。需要将注册表的键值改为startup.vbs的地址
2 startup.vbs vb文件用来启动jar，如果环境变量没有设置JAVA_HOME则需要将java改为java.exe的绝对路径
  请修改启动jar文件的绝对路径
3 applicationContext.xml
  提供自定义备份时间，cronExpression的value值  0 0 3 * * ？ * 分别表示     秒 分 时 日 月 周天 年 具体请参照quartz cron表达式
4 backup.bat 备份批处理脚本
  第二行的 D:\Mysql_Backup 为备份存放地址，备份文件保存30天
  请指定mysqldump.exe的绝对路径
  >后为备份保存地址，请与第二行的保持一致，否则无法删除过期文件