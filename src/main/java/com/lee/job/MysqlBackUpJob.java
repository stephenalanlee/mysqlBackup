package com.lee.job;

import com.lee.mysql.BackupMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MysqlBackUpJob {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private String batCmdFileName;
    private String winShow;

    public String getWinShow() {
        return winShow;
    }

    public void setWinShow(String winShow) {
        this.winShow = winShow;
    }

    public String getBatCmdFileName() {
        return batCmdFileName;
    }

    public void setBatCmdFileName(String batCmdFileName) {
        this.batCmdFileName = batCmdFileName;
    }

    public void backUp(){
        try {
            logger.info("begin to backup");
            String filePath = BackupMain.path+batCmdFileName;
            String cmd = winShow+" "+filePath;
            logger.info(cmd);
            Process ps = Runtime.getRuntime().exec(cmd);
            InputStream in = ps.getInputStream();
            in.close();
            ps.waitFor();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("backup success");
    }
}
