#!/bin/bash
GREEN='\033[0;32m'
NC='\033[00m'
timestamp() {
  date +"%T"
}

cd /orbeon/results
echo -e "${GREEN}$(timestamp)# #################### Ejecutando test complejidad baja #####################\n${NC}"
../apache-jmeter-5.2.1/bin/jmeter -JFIDURL=$FIDURL -JCIDIURL=$CIDIURL -n -t ../Orbeon-Complejidad-Baja-Docker.jmx -l Res-Complejidad-Baja-Docker.jtl
echo -e "\n"${GREEN}$(timestamp)" ##################### Test complejidad baja finalizado #####################\n${NC}"
echo -e "\n\n"
echo -e "\n"${GREEN}$(timestamp)" ##################### Ejecutando test complejidad media #####################\n${NC}"
../apache-jmeter-5.2.1/bin/jmeter -JFIDURL=$FIDURL -JCIDIURL=$CIDIURL -n -t ../Orbeon-Complejidad-Media-Docker.jmx -l Res-Complejidad-Media-Docker.jtl
echo -e "\n"${GREEN}$(timestamp)" ##################### Test complejidad media finalizado #####################\n${NC}"
echo -e "\n\n"
echo -e "\n"${GREEN}$(timestamp)" ##################### Ejecutando test complejidad alta #####################\n${NC}"
../apache-jmeter-5.2.1/bin/jmeter -JFIDURL=$FIDURL -JCIDIURL=$CIDIURL -n -t ../Orbeon-Complejidad-Alta-Docker.jmx -l Res-Complejidad-Alta-Docker.jtl
echo -e "\n"${GREEN}$(timestamp)" ##################### Test complejidad alta finalizado #####################${NC}"