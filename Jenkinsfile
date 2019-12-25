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
               
                   writeFile file: "${fileName}.txt", text: "${params.userFlag}\n${params.CHOOSE}\n"
                   newVar = sh (script: 'ls -lah',returnStdout: true).trim()
                   echo "Git committer email: ${newVar}"                   
                   sh "mv ${fileName}.txt ${fileName}_new.txt"
                   if ("fileExists(${fileName}_new.txt)") {  
                   read_file = readFile("${fileName}_new.txt").readLines()
                   while (read_file){
                     println 
                   }
                   
                   
                   
                   println read_file
                   result = read_file.findAll { it.contains("env") }
                   println result
                  //  new File("${fileName}_new.txt")eachLine { line ->
                  //  println line
                  //    }
                  //  println greppedFile       
                  // // lines = new File('testfile_new.txt').readLines()
                  //  def line = greppedFile.readLines()
                  //  println line
                  //  def result = line.findAll { it.contains("env") }
                  //  println lines
                  //  println result
                  //  println result.toString()

                   
                   
                   
                   
                   
                     
                   newFile = readFile("${fileName}_new.txt")               
                   echo "${newFile}"
                   echo "${read_file}"
                 
                   //lines.each { String line ->
                   //println line}
                   }
                   echo "HOpa"
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


