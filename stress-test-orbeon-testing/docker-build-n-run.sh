echo "##################### Building image for Jmeter tests #####################"
docker build . -t jmeter-test
echo "##################### Building finished #####################"

echo "##################### Starting container #####################"
docker run --rm --name jmeter-orbeon -v ~/:/orbeon/results --network="host" --env FIDURL=$FIDURL --env CIDIURL=$CIDIURL jmeter-test ./runTest.sh
echo "##################### Container finished #####################"
