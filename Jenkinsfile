def fileName = "testfile"

pipeline {
    agent any
   
    parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
        string(name: 'Test',defaultValue: 'test')  
        choice(name: 'CHOOSE',choices: 'env1\nenv2\nenv3',description: 'CHOOSE DESC' )
        text(name: 'mytextparam', defaultValue: 'This is a test text', description: 'nWill be used by pipeline')       
    }
    stages {
      stage ("Executing") {  

          steps { 
            parallel(
               a: {
                   git branch: 'master',
                   credentialsId: 'CREDENTIALS',
                   url: 'https://github.com/arts111188/devops_training.git'
                  },
               b: {
                script {
               
                   writeFile file: "${fileName}.txt", text: "${params.userFlag},${params.CHOOSE}"
                   newVar = sh (script: 'ls -lah',returnStdout: true).trim()
                   echo "Git committer email: ${newVar}"                   
                   sh "mv ${fileName}.txt ${fileName}_new.txt"
                   if ("fileExists(${fileName}_new.txt)") {                
                   read_file = readFile("${fileName}_new.txt")
                   echo 'lines'
                   lines.each { String line ->
                   println line}
                   }
                }
               }
               

     )
      }
          }
     
     stage("Next"){
       steps{
          script {
            withCredentials([
            usernamePassword(credentialsId: 'CREDENTIALS',
              usernameVariable: 'username',
              passwordVariable: 'password')
          ]) {
            print 'username=' + username + 'password=' + password
          }
          echo "${params.userFlag}"
            if (params.userFlag) {
                echo "${params.userFlag}"
                echo "${params.CHOOSE}"
                echo "${params.mytextparam}"       
               }
               else{
                 echo "BOMBOM"
               }
            } 
     }
     }
    

            }
        }


