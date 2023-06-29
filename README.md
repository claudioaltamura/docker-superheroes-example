![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/claudioaltamura/docker-superheroes-example/maven-build.yml?branch=main)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# docker-superheroes-example
Local Development on macOS with Docker, Minikube, Kubernetes

## Minikube
https://minikube.sigs.k8s.io/docs/handbook/registry/

    minikube start

    minikube addons enable registry

    docker run --rm -it --network=host alpine ash -c "apk add socat && socat TCP-LISTEN:5000,reuseaddr,fork TCP:$(minikube ip):5000"

    kubectl port-forward --namespace kube-system service/registry 5000:80

## Build and publish image
    ./mvnw package

    docker build -t localhost:5000/docker-superheroes-example .

    docker push localhost:5000/docker-superheroes-example

    curl http://localhost:5000/v2/_catalog

## Deployment
https://minikube.sigs.k8s.io/docs/handbook/deploying/

### Docker

    docker build -t docker-superheroes-example .

    docker run -d -i -t -p18080:8080 docker-superheroes-example

### Minikube & Kubernetes
    kubectl create deployment superheroes-example --image=localhost:5000/docker-superheroes-example

    kubectl expose deployment superheroes-example --type=LoadBalancer --port=18080

## Accessing the example

### Minikube
https://minikube.sigs.k8s.io/docs/handbook/accessing/

    kubectl get svc

    minikube service superheroes-example

### Port-forwarding
https://minikube.sigs.k8s.io/docs/start/

    kubectl port-forward service/superheroes-example 18080:8080


### example
    curl http://localhost:18000/