package Sandbox_TeamcityBranchesTest.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead : GitVcsRoot({
    uuid = "3dbbe054-73be-4a9b-afc8-1b590bddd33d"
    id = "Sandbox_TeamcityBranchesTest_HttpsGithubComPavelsherTeamcityBranchesTestRefsHead"
    name = "https://github.com/pavelsher/teamcity-branches-test#refs/heads/master"
    url = "https://github.com/pavelsher/teamcity-branches-test"
    branchSpec = "+:refs/heads/(feature-*)"
    authMethod = password {
        userName = "pavelsher"
        password = "credentialsJSON:3274f877-6110-4bb6-9668-dfef8b301152"
    }
})
