@echo on
forfiles /p "D:\Mysql_Backup" /m backup_*.sql -d -30 /c "cmd /c del /f @path"
set "Ymd=%date:~0,4%%date:~5,2%%date:~8,2%0%time:~1,1%%time:~3,2%%time:~6,2%"
"C:\Program Files\MySQL\MySQL Server 5.5\bin\mysqldump.exe" --opt --single-transaction=TRUE --user=root --password=vislecaina --host=127.0.0.1 --protocol=tcp --port=3306 --default-character-set=utf8 --routines --events "cpn" > D:\Mysql_Backup\backup_%Ymd%.sql