package org.oedteq.cmakecc

import org.gradle.api.tasks.Exec

class CmakeBuildTask extends Exec {

    public CmakeBuildTask() {
        executable 'cmake'

        //File workingDir = new File(getProjectDir(),'build')

        setWorkingDir('build')
    }

    @Override
    protected void exec() {
        args = ['--build', '.']
        super.exec()
    }
}
