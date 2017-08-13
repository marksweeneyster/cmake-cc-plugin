package org.oedteq.cmakecc

import org.gradle.api.Project
import org.gradle.api.provider.PropertyState
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Exec

class CmakeccExtension {
    String[] platforms= []
    private final PropertyState<String> generator

    //private Project project


    public String getGenerator() {
        return generator.get()
    }

    public Provider<String> getGeneratorProvider() {
        return generator;
    }
    public void setGenerator(String generator) {
        this.generator.set(generator)
    }

    CmakeccExtension() {
    }

    CmakeccExtension(Project project) {
        //this.project = project
        generator = project.property(String.class);
        //println 'generator: ' + generator.get()

        //generator = "Ninja"
        /* project.configure(project) {
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
        }  */

    }
/*
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
    */
}
