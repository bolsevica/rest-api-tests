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
}
post {
        success {
          // publish html
          publishHTML target: [
              allowMissing: false,
              alwaysLinkToLastBuild: false,
              keepAll: true,
              reportDir: 'reports/tests/test/',
              reportFiles: 'index.html',
              reportName: 'RCov Report'
            ]
        }
        always {
              echo "Send notifications for result: ${currentBuild.result}"
            }
      }
}