pipeline {
  agent any
  stages {
    stage('Run On Dev') {
      parallel {
        stage('Run On Dev') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('run test on dev') {
          steps {
            bat 'mvn test -Denv=dev'
          }
        }

      }
    }

    stage('Run On QA') {
      parallel {
        stage('Run On QA') {
          steps {
            bat 'mvn clean install -DskipTests=true'
          }
        }

        stage('run test on qa') {
          steps {
            bat 'mvn test -Denv=qa'
          }
        }

      }
    }

    stage('Publish reports') {
      steps {
        script {
          allure([
            includeProperties:false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: '/allure-results']]
          ])
        }

      }
    }

  }
  tools {
    maven 'M3'
  }
}