package org.oedteq.cmakecc

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.Plugin

class CmakeccPlugin implements Plugin<Project> {
    static final String EXTENSION_NAME = 'cmakeConfig'

    void apply(Project project) {
        CmakeccExtension extension = project.getExtensions().create(EXTENSION_NAME, CmakePluginExtension.class, project)
/*
        project.task('cmake', type: CmakeTask) {
            def extension = project.extensions.findByName(EXTENSION_NAME)
            println extension.generator
            conventionMapping.generator = {extension.generator}
        }
        */

        project.getTasks().create("cmakeTask", CmakeTask.class, new Action<CmakeTask>() {
            public void execute(CmakeTask cmakeTask) {
                cmakeTask.setGenerator(extension.getGeneratorProvider());
            }
        });
    }
}

