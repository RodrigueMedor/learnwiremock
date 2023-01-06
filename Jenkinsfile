stages {
    stage('Gradle tasks') {
        steps {
            sh 'bash ./gradlew ivtTest'
            sh 'bash ./gradlew cucumber'
        }
    }
    stage('Generate HTML report') {
        cucumber buildStatus: 'UNSTABLE',
                fileIncludePattern: '**/*.json',
                trendsLimit: 10,
                classifications: [
                    [
                        'key': 'Browser',
                        'value': 'Firefox'
                    ]
                ]
    }
}
