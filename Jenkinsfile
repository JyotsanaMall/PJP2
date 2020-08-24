  
pipeline {
    agent any
    stages {
	stage ('Maven Clean') {
            steps {
                echo 'Project clean stage'
		bat label : 'Clean running', script: '''cd DateTimeCalculator & mvn clean'''
            }
        }

        stage ('Maven Compile') {
            steps {
                echo 'Project compile stage'
		bat label : 'Compilation running', script: '''cd DateTimeCalculator & mvn compile'''
            }
        }

        stage ('Unit Test') {
            steps {
                echo 'Project Testiong stage'
		bat label:'Testing running', script: '''cd DateTimeCalculator & mvn test''' 
            }
	}
	stage ('Maven Package'){
            steps {
                echo 'Project packaging stage'
		bat label:'Project packaging', script: '''cd DateTimeCalculator & mvn package''' 
            }
            
        }
    }
}
