package org.oedteq.cmakecc

import org.gradle.api.provider.PropertyState
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Exec
import org.gradle.api.provider.Provider

class CmakeTask extends Exec {

    private final PropertyState<String> generator
    private final PropertyState<String> cmakeInstallPrefix

    public CmakeTask() {
        generator = getProject().property(String.class)
        cmakeInstallPrefix = getProject().property(String.class)

        executable 'cmake'

        setWorkingDir("build")
    }

    @Override
    protected void exec() {
        args = ['-G'+getGenerator(), '-DCMAKE_INSTALL_PREFIX='+getCmakeInstallPrefix(), ".."]
        super.exec()
    }

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

    @Input
    public String getCmakeInstallPrefix() {
        return cmakeInstallPrefix.get()
    }
    public void setCmakeInstallPrefix(String cmakeInstallPrefix) {
        this.cmakeInstallPrefix.set(cmakeInstallPrefix)
    }
    public void setCmakeInstallPrefix(Provider<String> cmakeInstallPrefix) {
        this.cmakeInstallPrefix.set(cmakeInstallPrefix)
    }
}

