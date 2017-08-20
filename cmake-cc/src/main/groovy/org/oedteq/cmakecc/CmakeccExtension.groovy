package org.oedteq.cmakecc

import org.gradle.api.Project
import org.gradle.api.provider.PropertyState
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Exec

class CmakeccExtension {
    String[] platforms= []
    private final PropertyState<String> generator
    private final PropertyState<String> cmakeInstallPrefix

    CmakeccExtension() {
    }

    CmakeccExtension(Project project) {
        //this.project = project
        generator = project.property(String.class);
        cmakeInstallPrefix = project.property(String.class);
    }

    public String getGenerator() {
        return generator.get()
    }
    public Provider<String> getGeneratorProvider() {
        return generator;
    }
    public void setGenerator(String generator) {
        this.generator.set(generator)
    }

    public String getCmakeInstallPrefix() {
        return cmakeInstallPrefix.get()
    }
    public Provider<String> getCmakeInstallPrefixProvider() {
        return cmakeInstallPrefix;
    }
    public void setCmakeInstallPrefix(String cmakeInstallPrefix) {
        this.cmakeInstallPrefix.set(cmakeInstallPrefix)
    }


}
