pipeline {
    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yml'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Manarhamed00/jenkens--labs.git'
            }
        }

        stage('Build and Run Containers') {
            steps {
                sh "docker-compose -f ${COMPOSE_FILE} up -d --build"
            }
        }

        stage('Clean Up') {
            steps {
                sh "docker-compose down"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
