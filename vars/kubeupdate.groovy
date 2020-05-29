def call(String region, String ekscluster,String kubecred) {
   withCredentials([[
 $class: 'AmazonWebServicesCredentialsBinding', 
 accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
 credentialsId: "${kubecred}", 
secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) 
 {
              echo "Login Successfull"
              sh "aws eks --region '${region}'  update-kubeconfig --name '${ekscluster}'"
            //  sh 'sed -i s/"BUILD_NUMBER"/"v$BUILD_NUMBER"/g app-deployment.yaml'
              sh 'kubectl apply -f app-deployment.yaml'
              sh 'kubectl apply -f app-service.yaml'
              sh 'kubectl get svc'
 }
              }
