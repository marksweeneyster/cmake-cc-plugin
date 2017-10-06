package org.oedteq.cmakecc

//import org.gradle.api.Project
import org.gradle.api.provider.PropertyState
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Exec
import org.gradle.api.provider.Provider

class CmakeTask extends Exec {

    private final PropertyState<String> generator
    private final PropertyState<String> cmakeInstallPrefix
    private final PropertyState<String> cmakeListsDir
    private final PropertyState<String> buildingDir

    private final String defaultGenerator = 'Ninja'

    // relative paths are referenced from the projects root directory
    private final String defaultBuildingDir = "build"
    // this will be relative to the task's buildingDir
    private final String defaultInstallDir = "./install"
    private final String defaultCmakeListsDir = "./.."

    public CmakeTask() {
        generator = getProject().property(String.class)
        cmakeInstallPrefix = getProject().property(String.class)
        cmakeListsDir = getProject().property(String.class)
        buildingDir = getProject().property(String.class)

        executable 'cmake'

        setWorkingDir(getBuildingDir())
    }

    @Override
    protected void exec() {
        args = ['-G'+getGenerator(), '-DCMAKE_INSTALL_PREFIX='+getCmakeInstallPrefix(), getCmakeListsDir()]
        super.exec()
    }

    @Input
    public String getGenerator() {
        return generator.getOrNull() ?: defaultGenerator;
    }
    public void setGenerator(String generator) {
        this.generator.set(generator)
    }
    public void setGenerator(Provider<String> generator) {
        this.generator.set(generator)
    }

    @Input
    public String getCmakeListsDir() {
        return cmakeListsDir.getOrNull() ?: defaultCmakeListsDir;
    }
    public void setCmakeListsDir(String cmakeListsDir) {
        this.cmakeListsDir.set(cmakeListsDir)
    }
    public void setCmakeListsDir(Provider<String> cmakeListsDir) {
        this.cmakeListsDir.set(cmakeListsDir)
    }

    @Input
    public String getCmakeInstallPrefix() {
        return cmakeInstallPrefix.getOrNull() ?: defaultInstallDir;
    }
    public void setCmakeInstallPrefix(String cmakeInstallPrefix) {
        this.cmakeInstallPrefix.set(cmakeInstallPrefix)
    }
    public void setCmakeInstallPrefix(Provider<String> cmakeInstallPrefix) {
        this.cmakeInstallPrefix.set(cmakeInstallPrefix)
    }

    @Input
    public String getBuildingDir() {
        return buildingDir.getOrNull() ?: defaultBuildingDir;
    }
    public void setBuildingDir(String buildingDir) {
        this.buildingDir.set(workingDir)
    }
    public void setBuildingDir(Provider<String> buildingDir) {
        this.buildingDir.set(buildingDir)
    }
}

