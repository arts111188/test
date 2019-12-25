pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
        string(name: 'Test',defaultValue: 'test')
        choice(
        name: 'CHOOSE',
        choices: 'env1\nenv2\nenv3',
        withCredentials([usernamePassword(credentialsId: 'CREDENTIALS', passwordVariable: 'pass', usernameVariable: 'user')]) {
    // the code in here can access $pass and $user
},
        description: 'CHOOSE DESC' )
        text(name: 'mytextparam', 
                 defaultValue: 'This is a test text', 
                 description: 'nWill be used by pipeline')  
    }
    stages {
        stage("Executing")
         if (params.userFlag == 'true') {
            steps {
                echo "${params.userFlag}"
                echo "${params.CHOOSE}"
                echo "${params.mytextparam}"       
              
   
               }
               echo "test not checked"
              
            }
        }
}
