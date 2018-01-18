package Sandbox_TeamcityBranchesTest.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object Sandbox_TeamcityBranchesTest_Build : BuildType({
    uuid = "45af33dd-61ca-4739-9430-e4a989f43f6b"
    id = "Sandbox_TeamcityBranchesTest_Build"
    name = "Build"

    vcs {
        root(Sandbox_TeamcityBranchesTest.vcsRoots.Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead)

    }

    steps {
        script {
            scriptContent = """echo "This is a default branch""""
        }
    }

    triggers {
        vcs {
        }
    }
})
