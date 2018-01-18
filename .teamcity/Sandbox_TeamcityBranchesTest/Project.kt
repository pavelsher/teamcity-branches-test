package Sandbox_TeamcityBranchesTest

import Sandbox_TeamcityBranchesTest.buildTypes.*
import Sandbox_TeamcityBranchesTest.vcsRoots.*
import Sandbox_TeamcityBranchesTest.vcsRoots.Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "b74713b9-071d-42ae-b330-5fc421752f3f"
    id = "Sandbox_TeamcityBranchesTest"
    parentId = "Sandbox"
    name = "Teamcity Branches Test"

    vcsRoot(Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead)

    buildType(Sandbox_TeamcityBranchesTest_Build)

    features {
        versionedSettings {
            id = "PROJECT_EXT_389"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead.id
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
})
