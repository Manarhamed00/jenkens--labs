pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                 checkout([$class: 'GitSCM', branches: [[name: 'develop1']], userRemoteConfigs: [[url: 'https://github.com/Manarhamed00/jenkens--labs']]])
            }
        }
        stage('Install Dependencies') {
            steps {
                sh 'pip install -r requirements.txt'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'python manage.py test'
            }
        }
    }
}