package org.oedteq.cmakecc

import org.gradle.api.provider.PropertyState
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.TaskAction
import org.gradle.api.provider.Provider

class CmakeTask extends Exec {

    private final PropertyState<String> generator

    public CmakeTask() {
        generator = getProject().property(String.class)

        executable 'cmake'

        setWorkingDir("build")

        //args = ['-G'+generator, ".."];
    }

    @Override
    protected void exec() {
        super.exec()
    }
/*
    @TaskAction
    def cmake() {
        println greeting
        args = ['-G'+generator, ".."];
        executable 'cmake'
    }
*/
    @Input
    public String getGenerator() {
        return generator.get()
    }
    
    public void setGenerator(String generator) {
        this.generator.set(generator)
    }

    public void setGenerator(Provider<String> generator) {
        this.generator.set(generator)
    }

    @TaskAction
    public void cmake() {
        // Access the raw value during the execution phase of the build lifecycle
        System.out.println("Retrieving generator " + getGenerator())

        executable 'cmake'

        setWorkingDir("build")

        args = ['-G'+generator, ".."];

        // do additional work
    }
}

