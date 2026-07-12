pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/Prashant-Kamble1010/employee-management-system.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t employee-app .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop employee-app || true
                docker rm employee-app || true

                docker run -d \
                --name employee-app \
                -p 8081:8080 \
                employee-app
                '''
            }
        }
    }
}