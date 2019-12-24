pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
        string(name: 'Test',defaultValue: 'test')
        choice(
        name: 'CHOOSE',
        choices: "env1\env2\env3",
        description: 'CHOOSE DESC' )
        withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'CREDENTIALS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']])
        text(name: 'mytextparam', 
                 defaultValue: 'This is a test text', 
                 description: 'nWill be used by pipeline')  
    }
    
    

    stages {
        stage("Executing") {
            steps {
               if (params.userFlag == true){
               
               }
            }
        }
    }
}
