# zabbix-data-api

docker build -t zabbix-data-api ./

docker save zabbix-data-api > zabbix-data-api.tar

rsync -axv --progress -e 'ssh -p 9000' zabbix-data-api.tar root@lab205.jios.org:/root/

ssh -p 9000 root@lab205.jios.org 'docker load < zabbix-data-api.tar'

ssh -p 9000 root@lab205.jios.org 'docker run -d -p 8080:8080 --name zabbix-data-api zabbix-data-api'

rm zabbix-data-api.tar

http://lab205.jios.org:12002/filedownload?hostId=aa&timeFrom=bb&timeTill=cc