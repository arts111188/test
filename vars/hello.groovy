def call(int buildNumber) {
  if (buildNumber % 2 == 0) {
    pipeline {
      agent any
      parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
        string(name: 'Test', defaultValue: 'test')
        choice(name: 'CHOOSE', choices: 'env1\nenv2\nenv3', description: 'CHOOSE DESC')
        text(name: 'mytextparam', defaultValue: 'This is a test text', description: 'nWill be used by pipeline')
      }
      stages {
        stage('Even Stage') {
          steps {
            echo "The build number is even"
          }
        }
        stage("Executing") {
          steps {
            parallel(
                    a: {
                      git branch: 'master',
                              credentialsId: 'CREDENTIALS',
                              url: 'https://github.com/arts111188/devops_training.git'
                    },

            )
          }
        }
      }
    }
  } else {
    pipeline {
        agent any
        stages {
           stage('Odd Stage') {
              steps {
                echo "The build number is odd"
          }
        }
      }

    }
  }
}

