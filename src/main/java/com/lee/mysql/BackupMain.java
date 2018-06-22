package com.lee.mysql;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackupMain {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static String path = BackupMain.class.getResource("").getPath();

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        String regEx = "(file:/.*/.*\\.jar)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(path);
        boolean matched = matcher.find();
        if(matched) {
            String group = matcher.group();
            path = group.substring("file:/".length(),group.lastIndexOf("/"))+"/config/";
        }else{
            path = (BackupMain.class.getResource("/").getPath()+"/config/").replaceAll("/classes/","");
        }
        if(path.startsWith("/"))
            path = path.substring(1);
        String rootPath = path;
        logger.info(rootPath);
        String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(rootPath+"log4j2.xml");
        Configurator.initialize("Log4j2",resolvedLocation);
        ApplicationContext ctx = new FileSystemXmlApplicationContext(rootPath+"applicationContext.xml");
    }
}
