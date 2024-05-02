pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout from Git
                    checkout([$class: 'GitSCM', branches: [[name: 'develop1']], userRemoteConfigs: [[url: 'https://github.com/Manarhamed00/jenkens--labs']]])
                }
            }
        }
        stage('Install Dependencies') {
            steps {
                // Use conditional execution based on the operating system
                script {
                    if (isUnix()) {
                        sh 'pip install -r myproject/requirements.txt'
                    } else {
                        bat 'pip install -r myproject/requirements.txt'
                    }
                }
            }
        }
        stage('Run Tests') {
            steps {
                // Use conditional execution based on the operating system
                script {
                    if (isUnix()) {
                        sh 'python myproject/manage.py test'
                    } else {
                        bat 'python myproject/manage.py test'
                    }
                }
            }
        }
        stage('Deploy to EC2') {
            steps {
                // Use SSH to connect to your EC2 instance and execute Docker commands
                script {
                     if (isUnix()) {
                sh 'ssh -i home/newkey.pem ec2-user@3.87.252.140 "docker pull manarhamed00/my-django-app:latest && docker run -d manarhamed00/my-django-app:latest"'
            } else {
                bat 'ssh -i C:\downloads\newkey.pem ec2-user@3.87.252.140 "docker pull manarhamed00/my-django-app:latest && docker run -d manarhamed00/my-django-app:latest"
'
                    }
                }
            }
        }
    }
}
