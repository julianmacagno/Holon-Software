echo "##################### Building image for ContainerMon #####################"
docker build . -t containermon
echo "##################### Building finished #####################"

echo "##################### Starting container #####################"
docker run --rm --name containermon -v ~/stats:/monitor/stats -v /var/run/docker.sock:/var/run/docker.sock containermon python monitor.py jmeter-orbeon
echo "##################### Container finished #####################"