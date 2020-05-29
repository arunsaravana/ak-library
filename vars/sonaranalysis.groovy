def call(String scannerproperties) {
   //def scannerHome = tool '${scanner}';
      sh "/opt/sonar-scanner/bin/sonar-scanner -Dproject.settings=${scannerproperties}"    
}
