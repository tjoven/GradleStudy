package com.example.plugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.process.ExecSpec;

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
        //登录
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java","-jar",entity.getJiaguToolPath()
                        ,"-login",entity.getUserName(),entity.getPassword());
            }
        });

        System.out.println(TAG+"签名: ");
        //签名
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java","-jar",entity.getJiaguToolPath()
                        ,"-importsign",entity.getKeyStorePath()
                        ,entity.getKeyStorePass()
                        ,entity.getKeyStoreKeyAlias()
                        ,entity.getKeyStoreKeyAliasPwd());
            }
        });

        System.out.println(TAG+"加固: ");
        System.out.println(TAG+"加固: "+apkFile.getParentFile().getAbsolutePath());
        //加固
        getProject().exec(new Action<ExecSpec>() {
            @Override
            public void execute(ExecSpec execSpec) {
                execSpec.commandLine("java","-jar",entity.getJiaguToolPath()
                        ,"-jiagu",apkFile.getAbsolutePath()
                        ,apkFile.getParentFile().getAbsolutePath()
                        ,"-autosign");
            }
        });
    }
}
