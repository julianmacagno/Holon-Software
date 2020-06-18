import os
import sys
import time
import datetime

with open("stats/stats.txt", "a+") as f:
    f.truncate()
    output = ""
    format = "\"{{.Container}}\t{{.CPUPerc}}\t{{.MemUsage}}\t{{.MemPerc}}\""
    command = "docker stats " + sys.argv[1] + " --no-stream jmeter-orbeon --format "

    output = os.popen(command + format).read()

    while output != "":
        timestamp = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        stat = timestamp + "\t" + output
        print(stat.replace("\n", ""))
        f.write(stat)
        time.sleep(3)
        output = os.popen(command + format).read()
        
f.close()