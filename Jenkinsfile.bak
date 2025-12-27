pipeline {
    agent any

    environment {
        // Image names (optional but recommended)
        EUREKA_IMAGE = "eureka-service"
        USER_IMAGE   = "user-service"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/omkarupa/micro-services.git'
            }
        }

        stage('Build Eureka Server') {
            steps {
                dir('eureka-service') {
                    bat 'mvn clean package -DskipTests '
                }
            }
        }

        stage('Build User Service') {
            steps {
                dir('users-service') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Compose Build') {
            steps {
                bat 'docker-compose build'
            }
        }

        stage('Deploy Containers') {
            steps {
                bat 'docker-compose down'
                bat 'docker-compose up -d --scale user-service=3'
            }
        }
    }

    post {
        success {
            echo '✅ Deployment Successful!'
        }
        failure {
            echo '❌ Deployment Failed!'
        }
    }
}
