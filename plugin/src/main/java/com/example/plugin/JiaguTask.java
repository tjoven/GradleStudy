package com.example.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;

import javax.inject.Inject;


public class JiaguTask extends DefaultTask {

    private static final String TAG = "JiaguTask: " ;

    private File apkFile ;
    private JiaguEntity entity;

    @Inject
    public JiaguTask(File apkFile, JiaguEntity entity) {
        System.out.println(TAG+"JiaguTask");
        this.apkFile = apkFile;
        this.entity = entity;
        setGroup("jiagu");
    }

    @TaskAction
    public void execute(){
        System.out.println(TAG+"execute");
        System.out.println(TAG+"apkFile: "+apkFile);
        System.out.println(TAG+"entity: "+entity.toString());
    }
}
