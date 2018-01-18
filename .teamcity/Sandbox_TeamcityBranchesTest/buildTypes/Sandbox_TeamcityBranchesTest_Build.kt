package Sandbox_TeamcityBranchesTest.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script

object Sandbox_TeamcityBranchesTest_Build : BuildType({
    uuid = "45af33dd-61ca-4739-9430-e4a989f43f6b"
    id = "Sandbox_TeamcityBranchesTest_Build"
    name = "Build"

    vcs {
        root(Sandbox_TeamcityBranchesTest.vcsRoots.Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead)
    }

    steps {
        script {
            scriptContent = """
                    echo "This is a feature-1 branch"
                    echo ${'$'}MY_ENV_VAR
                    """.trimIndent()
        }
    }

    params {
        param(name = "env.MY_ENV_VAR", value = "some value")
    }

    requirements {
        contains(param = "teamcity.agent.jvm.os.name", value = "Linux")
    }

    features {
        feature {
            type = "perfmon"
        }
    }
})
