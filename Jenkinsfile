pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: true, description: '', name: 'userFlag')
        string(name: 'Test',defaultValue: 'test')
        choice(
        name: 'CHOOSE',
        choices: 'env1\nenv2\nenv3',
        description: 'CHOOSE DESC' )
        credentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'CREDENTIALS', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']])
        text(name: 'mytextparam', 
                 defaultValue: 'This is a test text', 
                 description: 'nWill be used by pipeline')  
    }
    
    

    stages {
        stage("Executing") {
            steps {
                echo "${params.userFlag}
               
               }
            }
        }
    }
}
