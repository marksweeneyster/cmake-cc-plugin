package org.oedteq.cmakecc

import org.gradle.api.Project
import org.gradle.api.provider.PropertyState
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Exec

class CmakeccExtension {
    String[] platforms= []
    private final PropertyState<String> generator
    private final PropertyState<String> cmakeInstallPrefix
    private final PropertyState<String> cmakeListsDir
    // workingDir is already defined for exec tasks so I use buildingDir
    private final PropertyState<String> buildingDir

    CmakeccExtension() {
    }

    CmakeccExtension(Project project) {
        //this.project = project
        generator          = project.property(String.class);
        cmakeInstallPrefix = project.property(String.class);
        cmakeListsDir      = project.property(String.class);
        buildingDir        = project.property(String.class);
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

    public String getCmakeListsDir() {
        return cmakeListsDir.get()
    }
    public Provider<String> getCmakeListsDirProvider() {
        return cmakeListsDir;
    }
    public void setCmakeListsDir(String cmakeListsDir) {
        this.cmakeListsDir.set(cmakeListsDir)
    }

    public String getBuildingDir() {
        return buildingDir.get()
    }
    public Provider<String> getBuildingDirProvider() {
        return buildingDir;
    }
    public void setBuildingDir(String buildingDir) {
        this.buildingDir.set(buildingDir)
    }


}
