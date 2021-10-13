package com.example.plugin;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.util.logging.Logger;

import groovy.util.logging.Log;

public class JiaguPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        final JiaguEntity entity = project.getExtensions().create("jiagu",JiaguEntity.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                String userName = entity.getUserName();
                AppExtension appExtension = project.getExtensions().getByType(AppExtension.class);
                appExtension.getApplicationVariants().all(new Action<ApplicationVariant>() {
                    @Override
                    public void execute(ApplicationVariant applicationVariant) {
                        String buildType = applicationVariant.getBuildType().getName();
                    }
                });
            }
        });
    }
}
