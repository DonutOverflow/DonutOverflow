stage('Tag image') {
      steps {
        script {
            GIT_TAG = sh([script: 'git fetch --tag && git tag', returnStdout: true]).trim()
            MAJOR_VERSION = sh([script: 'git tag | cut -d . -f 1', returnStdout: true]).trim()
            MINOR_VERSION = sh([script: 'git tag | cut -d . -f 2', returnStdout: true]).trim()
            PATCH_VERSION = sh([script: 'git tag | cut -d . -f 3', returnStdout: true]).trim()
        }
        sh "docker build -t donutguys/hello-img:${MAJOR_VERSION}.\$((${MINOR_VERSION} + 1)).${PATCH_VERSION} ."
      }
}
