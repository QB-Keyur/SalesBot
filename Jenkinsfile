pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
