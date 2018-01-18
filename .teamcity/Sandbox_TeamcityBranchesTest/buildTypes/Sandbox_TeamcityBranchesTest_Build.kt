package Sandbox_TeamcityBranchesTest.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.buildFeatures.commitStatusPublisher
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

    features {
        commitStatusPublisher {
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:3274f877-6110-4bb6-9668-dfef8b301152"
                }
            }
        }
        feature {
            type = "perfmon"
        }
    }
})
