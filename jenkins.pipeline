pipeline {
    agent any
    tools {
        maven 'maven-installation'
    }
    environment {
        DOCKER_REGISTRY = "crpi-xxrtggj57h8kwbz2.cn-hangzhou.personal.cr.aliyuncs.com"
        NAMESPACE = "cloud-native-practice"
        SERVICES = "crud-client crud-service gateway-service eureka-service"
        VERSION = "latest"
        KUBECONFIG = "/var/lib/jenkins/.kube/config"  // 🔧 指定 kubeconfig 路径
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://gitee.com/Wkndnite/cloud-native-practice.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests -s /var/jenkins_home/.m2/settings.xml'
            }
        }
        stage('BuildImages') {
            steps {
                script {
                    def wd = pwd()
                    for (svc in SERVICES.split()) {
                        dir("${wd}/${svc}") {
                            def imageName = "${DOCKER_REGISTRY}/${NAMESPACE}/${svc}:${VERSION}"
                            sh "nerdctl build -t ${imageName} ."
                        }
                    }
                }
            }
        }
        stage('PushImages') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'aliyun-personal-cr', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh "nerdctl login -u $DOCKER_USER -p $DOCKER_PASS ${DOCKER_REGISTRY}"
                    script {
                        for (svc in SERVICES.split()) {
                            def imageName = "${DOCKER_REGISTRY}/${NAMESPACE}/${svc}:${VERSION}"
                            sh "nerdctl push ${imageName}"
                        }
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    def wd = pwd()
                    dir("${wd}/k8s") {
                        for (svc in SERVICES.split()) {
                            echo "Deploying ${svc}"
                            sh "kubectl apply -f ${svc}.yaml"
                        }
                    }
                }
            }
        }
    }
}
