pipeline {
    agent any
    parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
        string(name: 'Test',defaultValue: 'test')  
        choice(name: 'CHOOSE',choices: 'env1\nenv2\nenv3',description: 'CHOOSE DESC' )
        text(name: 'mytextparam', defaultValue: 'This is a test text', description: 'nWill be used by pipeline')
       withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'CREDENTIALS',usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) 
    }
    stages {
      stage ("Executing") {         
          steps {
            script{
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
