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
          environment {
       fileName = "testfile"
   }       
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
                   sh 'cat fileName.txt'
                   sh 'mv ${fileName}.txt ${fileName}_new.txt'
                   
                   if (fileExists('${fileName}_new.txt')) {
                   sh 'cat ${fileName}_new.txt'
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

            print 'username.collect { it }=' + username.collect { it }
            print 'password.collect { it }=' + password.collect { it }
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


