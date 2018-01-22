package Sandbox_TeamcityBranchesTest.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2017_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2017_2.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.v2017_2.failureConditions.failOnText

object Sandbox_TeamcityBranchesTest_Build : BuildType({
    uuid = "45af33dd-61ca-4739-9430-e4a989f43f6b"
    id = "Sandbox_TeamcityBranchesTest_Build"
    name = "Build"

    artifactRules = "file.txt"

    buildNumberPattern = "my-feature-%build.counter%"

    steps {
        script {
            name = "Step 1"
            scriptContent = """echo "This is a first step""""
        }

        script {
            name = "Step 2"
            scriptContent = """
                    echo "This is a feature-1 branch"
                    echo ${'$'}MY_ENV_VAR
                    """.trimIndent()
        }

        script {
            name = "Create Artifact"
            scriptContent = """echo "some content" > file.txt"""
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

    failureConditions {
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.CONTAINS
            pattern = "This is a"
            failureMessage = "Error!"
            reverse = false
        }
    }
})
