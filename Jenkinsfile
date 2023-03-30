pipeline {
environment {
testPassed = 'true'
}
agent{ label 'jenkins-slave' }
stages {

stage('Build') {
steps {
sh 'chmod +x gradlew'
sh './gradlew build -x test'
}
}
stage('Test') {
steps {
  script{
     try{
        sh './gradlew test'
    }catch (Exception e){
        testPassed = false
    }
  }
}
}
stage('Building Docker image') {
steps{
script {
   if(testPassed){
dockerImage = docker.build registry + ":$BUILD_NUMBER"
}
}
}
}
}
post {
        always {
            junit 'build/reports/**/*.xml'
        }
    }
}