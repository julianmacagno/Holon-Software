import os 
import subprocess
import sys

# parameters are: scriptName jobName directory 

avgIOPS = 0.0
avgBandwith = 0.0
avgMinSlat = 0.0
avgMaxSlat = 0.0
avgAvgSlat = 0.0
avgMinClat = 0.0
avgMaxClat = 0.0
avgAvgClat = 0.0

print "executed: fio " + sys.argv[1] + " --directory=" + sys.argv[2]

for _ in range (0,3):    
    p = subprocess.Popen("fio " + sys.argv[1] + " --directory=" + sys.argv[2], stdout=subprocess.PIPE, shell=True)
    (output, err) = p.communicate()
    lista = map(str.lower, str.splitlines(output))
    

    elem = "job1: laying out io file (1 file / 6mib)"
    while elem in lista:
        lista.remove(elem)

    print output + "\n\n"

    line = lista[6] #read line
    avgIOPS += float(line[line.find("iops=")+5:line.find(',')]) #extract IOPS
    avgBandwith += float(line[line.find("(", line.find("bw"))+1:line.find(')', line.find("bw"))-4]) #extract bandwidth MB/s

    line = lista[7] #slat line
    avgMinSlat += float(line[line.find("min=")+4:line.find(",", line.find("min="))]) # extract min time (from "min="" to "," after "min="")
    avgMaxSlat += float(line[line.find("max=")+4:line.find(",", line.find("max="))]) # extract max time (from "max="" to "," after "min="")
    avgAvgSlat += float(line[line.find("avg=")+4:line.find(",", line.find("avg="))]) # extract avg time (from "avg="" to "," after "min="")

    line = lista[8] #clat line
    avgMinClat += float(line[line.find("min=")+4:line.find(",", line.find("min="))]) # extract min time (from "min="" to "," after "min="")
    avgMaxClat += float(line[line.find("max=")+4:line.find(",", line.find("max="))]) # extract max time (from "max="" to "," after "min="")
    avgAvgClat += float(line[line.find("avg=")+4:line.find(",", line.find("avg="))]) # extract avg time (from "avg="" to "," after "min="")

avgIOPS = str(avgIOPS / 3).replace(".", ",")
avgBandwith = str(avgBandwith / 3).replace(".", ",")
avgMinSlat = str(avgMinSlat / 3).replace(".", ",")
avgMaxSlat = str(avgMaxSlat / 3).replace(".", ",")
avgAvgSlat = str(avgAvgSlat / 3).replace(".", ",")
avgMinClat = str(avgMinClat / 3).replace(".", ",")
avgMaxClat = str(avgMaxClat / 3).replace(".", ",")
avgAvgClat = str(avgAvgClat / 3).replace(".", ",")

print "avgIOPS: " + str(avgIOPS[:avgIOPS.find(",") + 3])
print "avgBandwith: " + str(avgBandwith[:avgBandwith.find(",") + 3])
print "avgMinSlat: " + str(avgMinSlat[:avgMinSlat.find(",") + 3])
print "avgMaxSlat: " + str(avgMaxSlat[:avgMaxSlat.find(",") + 3])
print "avgAvgSlat: " + str(avgAvgSlat[:avgAvgSlat.find(",") + 3])
print "avgMinClat: " + str(avgMinClat[:avgMinClat.find(",") + 3])
print "avgMaxClat: " + str(avgMaxClat[:avgMaxClat.find(",") + 3])
print "avgAvgClat: " + str(avgAvgClat[:avgAvgClat.find(",") + 3])

print "\n\n"
print avgIOPS[:avgIOPS.find(",") + 3]
print avgBandwith[:avgBandwith.find(",") + 3]
print avgMinSlat[:avgMinSlat.find(",") + 3]
print avgMaxSlat[:avgMaxSlat.find(",") + 3]
print avgAvgSlat[:avgAvgSlat.find(",") + 3]
print avgMinClat[:avgMinClat.find(",") + 3]
print avgMaxClat[:avgMaxClat.find(",") + 3]
print avgAvgClat[:avgAvgClat.find(",") + 3]

os.system("rm job*")