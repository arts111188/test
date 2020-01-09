def call(int buildNumber) {
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
                    b: {
                      script {
                        def fileName = "testfile.txt"
                        writeFile file: "${fileName}.txt", text: "${params.userFlag}\n${params.CHOOSE}\n"
                        newVar = sh(script: 'ls -lah', returnStdout: true).trim()
                        echo "Git committer email: ${newVar}"
                        sh "mv ${fileName}.txt ${fileName}_new.txt"
                        if ("fileExists(${fileName}_new.txt)") {
                          read_file = readFile("${fileName}_new.txt").readLines()
                          println read_file
                          sh 'pwd'
                          def firstLine = ''
                          def closure = ''
                          read_file.each { String env ->
                            println env
                          }
                        }
                        else {
                          echo "Done"
                        }
                      }
                    }
            )
          }
        }
      }
    }
  }

