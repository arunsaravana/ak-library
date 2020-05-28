def call(String region, String ekscluster) {
              echo "Login Successfull"
              sh "aws eks --region '${region}'  update-kubeconfig --name '${ekscluster}'"
              sh 'sed -i s/"BUILD_NUMBER"/"v$BUILD_NUMBER"/g app-deployment.yaml'
              sh 'kubectl apply -f app-deployment.yaml'
              sh 'kubectl apply -f app-service.yaml'
              sh 'kubectl get svc'
              }
