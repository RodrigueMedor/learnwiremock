pipeline {
  agent any
  stages {
    stage('Run Tests') {
      steps {
        sh './gradlew cucumber'
      }
      post {
        always {
          junit 'target/cucumber.xml'
          cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: 'target/cucumber.json','html:out/htmlReport.html', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
        }
      }
    }
  }
}
