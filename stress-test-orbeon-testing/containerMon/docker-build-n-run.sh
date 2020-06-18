echo "##################### Building image for ContainerMon #####################"
docker build . -t containermon
echo "##################### Building finished #####################"

echo "##################### Starting container #####################"
docker run --rm --name containermon --network=host -v /var/run/docker.sock:/var/run/docker.sock containermon go run main.go -container jmeter-orbeon
echo "##################### Container finished #####################"