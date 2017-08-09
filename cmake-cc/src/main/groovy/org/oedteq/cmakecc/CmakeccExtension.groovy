package org.oedteq.cmakecc

import org.gradle.api.Project
import org.gradle.api.tasks.Exec

class CmakeccExtension {
    String[] platforms= []

    CmakeccExtension(Project project) {
        this.project = project

        project.configure(project) {
            apply plugin: 'maven-publish'
            publishing {
                repositories {
                    maven {
                        name "buildDir"
                        url "$buildDir/m2repository"
                    }
                }

                // convenience targets for each repo
                platforms.each { platform ->
                    makeCmakeTask(platform)
                }
            }
        }

    }

    String makeTaskSuffix(platform) {
        return 'Platform' + platform.name.capitalize()
    }

    Exec makeCmakeTask(platform) {
        def taskName= "cmake${makeTaskSuffix(platform)}"
        def task= project.tasks.findByPath(taskName)
        if (task == null) {
            task= project.task(taskName)
        }
        return task
    }
}
