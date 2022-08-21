pipeline {
    agent any
  //triggers {pollSCM('* * * * *')}
  stages {
    stage('Checkout') {
      steps {
        // Get some code from a GitHub repository
        git branch: "main", url: 'https://github.com/All-About-Me/All-About-Me-Back-End.git'
      }
    }
        stage('Build') {
      steps {
        sh 'chmod a+x mvnw'
        sh './mvnw clean package'
      }

          post {
        always {
          archiveArtifacts 'target/*.jar'
        }
          }
        }
        stage('DockerClean') {
      steps {
        sh 'docker image prune -a -f'
      }
        }
      stage('DockerBuild') {
      steps {
        sh 'docker build -t aam/socialmedia:latest .'
      }
        }
      stage('DockerRun') {
      steps {
        sh 'docker run -p 3600:3600 aam/socialmedia:latest'
      }
        }
         
  }
}
