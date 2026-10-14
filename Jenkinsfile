pipeline {
    agent { docker { image 'maven:3.9-eclipse-temurin-21' } }
    stages {
        stage('Build') { steps { sh 'mvn -B -DskipTests package' } }
        stage('Test') {
            steps { sh 'mvn -B test' }
            post { always { junit 'target/surefire-reports/*.xml' } }
        }
        stage('Archive') { steps { archiveArtifacts artifacts: 'target/*.jar', fingerprint: true } }
    }
}
