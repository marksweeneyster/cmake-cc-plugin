package org.oedteq.cmakecc

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.Plugin

class CmakeccPlugin implements Plugin<Project> {
    static final String EXTENSION_NAME = 'cmakeConfig'

    void apply(Project project) {
        CmakeccExtension extension = project.getExtensions().create(EXTENSION_NAME, CmakeccExtension.class, project)

        project.getTasks().create("cmakeTask", CmakeTask.class, new Action<CmakeTask>() {
            public void execute(CmakeTask cmakeTask) {
                cmakeTask.setGenerator(extension.getGeneratorProvider())
                cmakeTask.setCmakeInstallPrefix(extension.getCmakeInstallPrefixProvider())
                cmakeTask.setCmakeListsDir(extension.getCmakeListsDirProvider())
                cmakeTask.setBuildingDir(extension.getBuildingDirProvider())
            }
        });

        project.getTasks().create("cmakeBuildTask", CmakeBuildTask.class, new Action<CmakeBuildTask>() {
            public void execute(CmakeBuildTask cmakeBuildTask) {
            }
        }).dependsOn((project.tasks.findByName('cmakeTask')))
    }
}


