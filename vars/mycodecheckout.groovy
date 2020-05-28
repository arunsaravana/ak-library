def call (Map scmparams) {
  git branch: scmparams.branch, url: scmparams.scmUrl
}
