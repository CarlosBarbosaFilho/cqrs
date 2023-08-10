# Run this commands to create : prometheus and grafana

## Prometheus: 
    docker run -d --name prometheus -p 9090:9090 -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
## Grafana:
    docker run -d --name grafana -p 3000:3000 grafana/grafana

## IP Container : this command will return the address ip to container prometheus
    docker inspect <container ID>