package com.example.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariantOutput;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.File;


public class JiaguPlugin implements Plugin<Project> {
    private static final String TAG = "JiaguPlugin: ";

    @Override
    public void apply(Project project) {
        System.out.println(TAG+"apply");
        //获取自定义的扩展信息
        final JiaguEntity entity = project.getExtensions().create("jiagu",JiaguEntity.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(final Project project) {
                AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
                //获取系统的的扩展信息
                appExtension.getApplicationVariants().all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(final ApplicationVariant applicationVariant) {
                        final String buildType = applicationVariant.getBuildType().getName();
                        final String flavorName = applicationVariant.getFlavorName();

                        System.out.println(TAG+"jiagu: "+entity.toString());

                        System.out.println(TAG+"buildType: "+buildType);
                        System.out.println(TAG+"applicationVariant: "+ applicationVariant.getName());
                        System.out.println(TAG+"getFlavorName: "+ applicationVariant.getFlavorName());

                        applicationVariant.getOutputs().all(new Action<BaseVariantOutput>() {
                            @Override
                            public void execute(BaseVariantOutput baseVariantOutput) {
                               File outputFile = baseVariantOutput.getOutputFile();
                               System.out.println(TAG+"outputFile: "+outputFile.getAbsolutePath());
                               //创建加固任务
                               project.getTasks().create("jiagu_"+buildType+"_"+flavorName,JiaguTask.class,outputFile,entity);
                            }
                        });
                    }
                });
            }
        });
    }
}
