pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }
  
  //Opciones espec�ficas de Pipeline dentro del Pipeline
  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una secci�n que define las herramientas �preinstaladas� en Jenkins
  tools {
    jdk 'JDK11_Centos' //Versi�n preinstalada en la Configuraci�n del Master
	gradle 'Gradle5.6_Centos' //Preinstalada en la Configuraci�n del Master
  }
/*	Versiones disponibles
      JDK8_Mac
      JDK6_Centos
      JDK7_Centos
      JDK8_Centos
      JDK10_Centos
      JDK11_Centos
      JDK13_Centos
      JDK14_Centos
*/

  //Aqu� comienzan los �items� del Pipeline
  stages{
    stage('Checkout'){
        steps{
            echo "------------>Checkout<------------"
            checkout([
                $class: 'GitSCM', 
                branches: [[name: '*/master']], 
                doGenerateSubmoduleConfigurations: false, 
                extensions: [], 
                gitTool: 'Default', 
                submoduleCfg: [], 
                userRemoteConfigs: [[
                    credentialsId: 'GitHub_josecortazar', 
                    url:'https://github.com/josecortazar/ceiba_salon-design-style.git'
            	]]
        	])
   		}
	}

	stage('Clean') {
         steps{
            sh 'gradle --b ./microservicio/build.gradle clean'
		}
	}

    stage('Compile & Unit Tests') {
		steps{
			echo "------------>Compile & Unit Tests<------------"
			sh 'gradle --b ./microservicio/build.gradle test'
		}
    }

    stage('Static Code Analysis') {
		steps{
			echo '------------>An�lisis de c�digo est�tico<------------'
			withSonarQubeEnv('Sonar') {
				sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
			}
		}
    }

	stage('Build') {
		steps{
			echo "------------>Build<------------"
			//Construir sin tarea test que se ejecut� previamente
			sh 'gradle --b ./microservicio/build.gradle build -x test'
		}
	}
 
  }


  post {
    always {
      echo 'This will always run'
    }
    success {
   	 	echo 'This will run only if successful'
		junit '**/test-results/test/*.xml'
		//junit './microservicio/build/test-results/test/*.xml' //RUTA DE TUS ARCHIVOS .XML

    }

	failure {
			echo 'This will run only if failed'
			//send notifications about a Pipeline to an email
			mail (to: 'jose.cortazar@ceiba.com.co',
			     subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
			     body: "Something is wrong with ${env.BUILD_URL}")
	}

    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}