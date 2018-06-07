### add_cluster


#### Description (接口描述)

添加集群.

| | |
|-|-|
| Request Method | Get |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| ip | query | 集群的ip | Yes | String |
| port | query | 集群的端口 | Yes | String |
| name | query | 集群名字 | Yes | String |
| description | query | 集群描述 | Yes | String |
| username | query | 集群账号 | Yes | String |
| password | query | 集群密码 | Yes | String |

#### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 
| 404 | Not Found | *name* : string | 

#### Request Sample (示例请求)


```
http://localhost:8080/add_cluster?ip=10.60.38.181&port=5678&name=admin&description=test&username=root&password=12345678

```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
no content

```

### add_host


#### Description (接口描述)

添加主机

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |

#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| id | query | 主机所在集群的路径 | Yes | String |
| port | query | 主机所在集群的端口 | Yes | String |
| host | query | 主机名字 | Yes | String |
| hostip | query | 自定义的主机ip | Yes | String |
| groupid | query | 主机所在的groupid | Yes | String |
| templateid | query | 主机所在的模板名字 | Yes | String |
| description | query | 主机描述 | Yes | String |


#### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 
| 404 | Not Found | *name* : string | 

#### Request Sample (示例请求)

```
http://localhost:8080/add_host?ip=10.60.38.181&port=12000&host=ubuntu40&hostip=172.17.0.8&groupid=2&template=10050&description=test
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
no content

```

###  delete_cluster


#### Description (接口描述)


删除指定集群

| | |
|-|-|
| Request Method | Get |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| id | query | 删除的集群的ip | Yes | String |
| port | query | 删除的集群的端口 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 
| 404 | Not Found | *name* : string | 

#### Request Sample (示例请求)

```
http://localhost:8080/delete_cluster?ip=10.60.38.182&port=12000
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
no content

```

###  delete_host


#### Description (接口描述)


删除指定主机

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| id | query | 删除的主机所在集群的ip | Yes | String |
| port | query | 删除的主机所在集群的端口 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 
| 404 | Not Found | *name* : string | 

#### Request Sample (示例请求)

```
http://localhost:8080/delete_host?ip=10.60.38.181&port=12000&hostid=172.17.0.8
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
no content

```

###  file_download

#### Description (接口描述)


监控数据下载

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| hostId| query | 所需下载监控数据的主机Id| Yes | String |
| timeFrom | query | 监控项数据开始的时间 | Yes | String |
| timeTill| query | 监控线数据停止的时间 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 
| 404 | Not Found | *name* : string | 

#### Request Sample (示例请求)

```
http://localhost:8080/filedownload?hostId=10259&timeFrom=1526354710&timeTill=1527163189
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
no content

```

###  get_cluster


#### Description (接口描述)

获得集群信息

| | |
|-|-|
| Request Method | Get |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| ip | query | 所获得集群的ip | Yes | String |
| port | query | 所获得集群的端口 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 


#### Request Sample (示例请求)

```
http://localhost:8080/filedownload?hostId=10259&timeFrom=1526354710&timeTill=1527163189
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
[
  "10.60.38.183",
  "12000",
  "Third",
  "third"
]

```

###  get_group


#### Description (接口描述)

获取集群所有主机组信息

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| ip | query | 集群的ip | Yes | String |
| port | query | 集群的端口 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 


#### Request Sample (示例请求)

```
http://localhost:8080/get_group?ip=10.60.38.181&port=12000
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
[
  {
    "groupid": "1",
    "name": "Templates"
  },
  {
    "groupid": "2",
    "name": "Linux servers"
  },
  {
    "groupid": "4",
    "name": "Zabbix servers"
  },
  {
    "groupid": "5",
    "name": "Discovered hosts"
  },
  {
    "groupid": "6",
    "name": "Virtual machines"
  },
  {
    "groupid": "7",
    "name": "Hypervisors"
  },
  {
    "groupid": "8",
    "name": "Templates/Modules"
  },
  {
    "groupid": "9",
    "name": "Templates/Network Devices"
  },
  {
    "groupid": "10",
    "name": "Templates/Operating Systems"
  },
  {
    "groupid": "11",
    "name": "Templates/Servers Hardware"
  },
  {
    "groupid": "12",
    "name": "Templates/Applications"
  },
  {
    "groupid": "13",
    "name": "Templates/Databases"
  },
  {
    "groupid": "14",
    "name": "Templates/Virtualization"
  }
]
```

###  get_host


#### Description (接口描述)

获取集群所有主机信息

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| ip | query | 集群的ip | Yes | String |
| port | query | 集群的端口 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 


#### Request Sample (示例请求)

```
http://localhost:8080/get_host?ip=10.60.38.181&port=12000
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
[
  {
    "hostId": "10254",
    "host": "host02",
    "description": ""
  },
  {
    "hostId": "10255",
    "host": "host01",
    "description": ""
  },
  {
    "hostId": "10259",
    "host": "ubuntu40",
    "description": ""
  },
  {
    "hostId": "10084",
    "host": "Zabbix server",
    "description": ""
  }
]
```

###  get_monitordata


#### Description (接口描述)

获取监控项数据

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| ip | query | 集群的ip | Yes | String |
| port | query | 集群的端口 | Yes | String |
| hostid | query | 所需获取的主机id | Yes | String |
| key | query | 监控项名字 | Yes | String |
| time_from | query | 开始时间 | Yes | String |
| time_till | query | 终止时间 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 


#### Request Sample (示例请求)

```
http://localhost:8080/get_monitordata?ip=10.60.38.181&port=12000&hostid=10255&key=vm.memory.size%5Bavailable%5D&timeFrom=1515175981&timeTill=1527966524
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
[
  {
    "clock": "1527597610",
    "value": "2815864832"
  },
  {
    "clock": "1527597670",
    "value": "2815799296"
  },
  {
    "clock": "1527597730",
    "value": "2815926272"
  },
  {
    "clock": "1527597790",
    "value": "2815606784"
  },
  {
    "clock": "1527597850",
    "value": "2815795200"
  },
  {
    "clock": "1527597910",
    "value": "2815602688"
  },
  {
    "clock": "1527597970",
    "value": "2815762432"
  },
  {
    "clock": "1527598030",
    "value": "2815696896"
  },
  {
    "clock": "1527598090",
    "value": "2815410176"
  },
  {
    "clock": "1527598150",
    "value": "2815283200"
  },
  {
    "clock": "1527598210",
    "value": "2815410176"
  },
  {
    "clock": "1527598270",
    "value": "2815410176"
  },
  {
    "clock": "1527598330",
    "value": "2815426560"
  },
  {
    "clock": "1527598390",
    "value": "2815950848"
  },
  {
    "clock": "1527598450",
    "value": "2816180224"
  },
  {
    "clock": "1527598510",
    "value": "2816401408"
  },
  {
    "clock": "1527598570",
    "value": "2816569344"
  },
  {
    "clock": "1527598630",
    "value": "2816442368"
  },
  {
    "clock": "1527598690",
    "value": "2816540672"
  },
  {
    "clock": "1527598750",
    "value": "2816479232"
  },
  {
    "clock": "1527598810",
    "value": "2816544768"
  },
  {
    "clock": "1527598870",
    "value": "2816454656"
  },
  {
    "clock": "1527598930",
    "value": "2816892928"
  },
  {
    "clock": "1527598990",
    "value": "2816892928"
  },
  {
    "clock": "1527599050",
    "value": "2816831488"
  },
  {
    "clock": "1527599110",
    "value": "2817212416"
  },
  {
    "clock": "1527599170",
    "value": "2817118208"
  },
  {
    "clock": "1527599230",
    "value": "2817118208"
  },
  {
    "clock": "1527599290",
    "value": "2816991232"
  },
  {
    "clock": "1527599350",
    "value": "2816262144"
  },
  {
    "clock": "1527599410",
    "value": "2816331776"
  },
  {
    "clock": "1527599470",
    "value": "2816364544"
  },
  {
    "clock": "1527599530",
    "value": "2816782336"
  },
  {
    "clock": "1527599590",
    "value": "2816692224"
  },
  {
    "clock": "1527599650",
    "value": "2816978944"
  },
  {
    "clock": "1527599710",
    "value": "2817282048"
  },
  {
    "clock": "1527599770",
    "value": "2817155072"
  },
  {
    "clock": "1527599830",
    "value": "2816745472"
  },
  {
    "clock": "1527599890",
    "value": "2817130496"
  },
  {
    "clock": "1527599950",
    "value": "2817257472"
  },
  {
    "clock": "1527600010",
    "value": "2817290240"
  },
  {
    "clock": "1527600070",
    "value": "2817257472"
  },
  {
    "clock": "1527600130",
    "value": "2817064960"
  },
  {
    "clock": "1527600190",
    "value": "2817347584"
  },
  {
    "clock": "1527600250",
    "value": "2817380352"
  },
  {
    "clock": "1527600310",
    "value": "2817253376"
  },
  {
    "clock": "1527600370",
    "value": "2817191936"
  },
  {
    "clock": "1527600430",
    "value": "2817191936"
  },
  {
    "clock": "1527600490",
    "value": "2817511424"
  },
  {
    "clock": "1527600550",
    "value": "2817290240"
  },
  {
    "clock": "1527600610",
    "value": "2817290240"
  },
  {
    "clock": "1527600670",
    "value": "2817130496"
  },
  {
    "clock": "1527600730",
    "value": "2817433600"
  },
  {
    "clock": "1527600790",
    "value": "2817179648"
  },
  {
    "clock": "1527600850",
    "value": "2817110016"
  },
  {
    "clock": "1527600910",
    "value": "2817134592"
  },
  {
    "clock": "1527600970",
    "value": "2816782336"
  },
  {
    "clock": "1527601030",
    "value": "2817036288"
  },
  {
    "clock": "1527601090",
    "value": "2816573440"
  },
  {
    "clock": "1527601150",
    "value": "2816577536"
  },
  {
    "clock": "1527601210",
    "value": "2816704512"
  },
  {
    "clock": "1527601270",
    "value": "2816352256"
  },
  {
    "clock": "1527601330",
    "value": "2816446464"
  },
  {
    "clock": "1527601390",
    "value": "2816921600"
  },
  {
    "clock": "1527601450",
    "value": "2816540672"
  },
  {
    "clock": "1527601510",
    "value": "2816409600"
  },
  {
    "clock": "1527601570",
    "value": "2816471040"
  },
  {
    "clock": "1527601630",
    "value": "2816151552"
  },
  {
    "clock": "1527601690",
    "value": "2816151552"
  },
  {
    "clock": "1527601750",
    "value": "2816438272"
  },
  {
    "clock": "1527601810",
    "value": "2816311296"
  },
  {
    "clock": "1527601870",
    "value": "2816245760"
  },
  {
    "clock": "1527601930",
    "value": "2816282624"
  },
  {
    "clock": "1527601990",
    "value": "2815967232"
  },
  {
    "clock": "1527602050",
    "value": "2815672320"
  },
  {
    "clock": "1527602110",
    "value": "2816053248"
  },
  {
    "clock": "1527602170",
    "value": "2815954944"
  },
  {
    "clock": "1527602230",
    "value": "2815696896"
  },
  {
    "clock": "1527602290",
    "value": "2815471616"
  },
  {
    "clock": "1527602350",
    "value": "2815565824"
  },
  {
    "clock": "1527602410",
    "value": "2815533056"
  },
  {
    "clock": "1527602470",
    "value": "2815467520"
  },
  {
    "clock": "1527602530",
    "value": "2815369216"
  },
  {
    "clock": "1527602590",
    "value": "2815340544"
  },
  {
    "clock": "1527602650",
    "value": "2815246336"
  },
  {
    "clock": "1527602710",
    "value": "2815467520"
  },
  {
    "clock": "1527602770",
    "value": "2814988288"
  },
  {
    "clock": "1527602830",
    "value": "2815496192"
  },
  {
    "clock": "1527602890",
    "value": "2814627840"
  },
  {
    "clock": "1527602950",
    "value": "2814722048"
  },
  {
    "clock": "1527603010",
    "value": "2815008768"
  },
  {
    "clock": "1527603070",
    "value": "2814627840"
  },
  {
    "clock": "1527603130",
    "value": "2814627840"
  },
  {
    "clock": "1527603190",
    "value": "2814787584"
  },
  {
    "clock": "1527603250",
    "value": "2814787584"
  },
  {
    "clock": "1527603310",
    "value": "2814754816"
  },
  {
    "clock": "1527603370",
    "value": "2814881792"
  },
  {
    "clock": "1527603430",
    "value": "2814787584"
  },
  {
    "clock": "1527603490",
    "value": "2814787584"
  },
  {
    "clock": "1527603550",
    "value": "2814914560"
  },
  {
    "clock": "1527603610",
    "value": "2814881792"
  },
  {
    "clock": "1527603670",
    "value": "2814750720"
  },
  {
    "clock": "1527603730",
    "value": "2814177280"
  },
  {
    "clock": "1527603790",
    "value": "2814689280"
  },
  {
    "clock": "1527603850",
    "value": "2814722048"
  },
  {
    "clock": "1527603910",
    "value": "2814529536"
  },
  {
    "clock": "1527603970",
    "value": "2814369792"
  },
  {
    "clock": "1527604030",
    "value": "2814177280"
  },
  {
    "clock": "1527604090",
    "value": "2814492672"
  },
  {
    "clock": "1527604150",
    "value": "2814558208"
  },
  {
    "clock": "1527604210",
    "value": "2814398464"
  },
  {
    "clock": "1527604270",
    "value": "2814468096"
  },
  {
    "clock": "1527604330",
    "value": "2814570496"
  },
  {
    "clock": "1527604390",
    "value": "2814763008"
  },
  {
    "clock": "1527604450",
    "value": "2814734336"
  },
  {
    "clock": "1527604510",
    "value": "2814894080"
  },
  {
    "clock": "1527604570",
    "value": "2814672896"
  },
  {
    "clock": "1527604630",
    "value": "2815086592"
  },
  {
    "clock": "1527604690",
    "value": "2814992384"
  },
  {
    "clock": "1527604750",
    "value": "2816659456"
  },
  {
    "clock": "1527604810",
    "value": "2816962560"
  },
  {
    "clock": "1527604870",
    "value": "2816868352"
  },
  {
    "clock": "1527604930",
    "value": "2816868352"
  },
  {
    "clock": "1527604990",
    "value": "2816978944"
  },
  {
    "clock": "1527605050",
    "value": "2816995328"
  },
  {
    "clock": "1527605110",
    "value": "2816905216"
  },
  {
    "clock": "1527605170",
    "value": "2816811008"
  },
  {
    "clock": "1527605230",
    "value": "2816933888"
  },
  {
    "clock": "1527605290",
    "value": "2817019904"
  },
  {
    "clock": "1527605350",
    "value": "2817224704"
  },
  {
    "clock": "1527605410",
    "value": "2816860160"
  },
  {
    "clock": "1527605470",
    "value": "2816987136"
  },
  {
    "clock": "1527605530",
    "value": "2817400832"
  },
  {
    "clock": "1527605590",
    "value": "2817019904"
  },
  {
    "clock": "1527605650",
    "value": "2817437696"
  },
  {
    "clock": "1527605710",
    "value": "2817183744"
  },
  {
    "clock": "1527605770",
    "value": "2817089536"
  },
  {
    "clock": "1527605830",
    "value": "2817343488"
  },
  {
    "clock": "1527605890",
    "value": "2817327104"
  },
  {
    "clock": "1527605950",
    "value": "2816876544"
  },
  {
    "clock": "1527606010",
    "value": "2816684032"
  },
  {
    "clock": "1527606070",
    "value": "2816921600"
  },
  {
    "clock": "1527606130",
    "value": "2817081344"
  },
  {
    "clock": "1527606190",
    "value": "2816413696"
  },
  {
    "clock": "1527606250",
    "value": "2816794624"
  },
  {
    "clock": "1527606310",
    "value": "2816974848"
  },
  {
    "clock": "1527606370",
    "value": "2816974848"
  },
  {
    "clock": "1527606430",
    "value": "2816847872"
  },
  {
    "clock": "1527606490",
    "value": "2816847872"
  },
  {
    "clock": "1527606550",
    "value": "2816815104"
  },
  {
    "clock": "1527606610",
    "value": "2816815104"
  },
  {
    "clock": "1527606670",
    "value": "2816729088"
  },
  {
    "clock": "1527606730",
    "value": "2816475136"
  },
  {
    "clock": "1527606790",
    "value": "2816884736"
  },
  {
    "clock": "1527606850",
    "value": "2816978944"
  },
  {
    "clock": "1527606910",
    "value": "2817015808"
  },
  {
    "clock": "1527606970",
    "value": "2817011712"
  },
  {
    "clock": "1527607030",
    "value": "2816634880"
  },
  {
    "clock": "1527607090",
    "value": "2816761856"
  },
  {
    "clock": "1527607150",
    "value": "2816827392"
  },
  {
    "clock": "1527607210",
    "value": "2816860160"
  },
  {
    "clock": "1527607270",
    "value": "2816987136"
  },
  {
    "clock": "1527607330",
    "value": "2816860160"
  },
  {
    "clock": "1527607390",
    "value": "2817200128"
  },
  {
    "clock": "1527607451",
    "value": "2816892928"
  },
  {
    "clock": "1527607510",
    "value": "2816892928"
  },
  {
    "clock": "1527607570",
    "value": "2817179648"
  },
  {
    "clock": "1527607630",
    "value": "2816974848"
  },
  {
    "clock": "1527607690",
    "value": "2816122880"
  },
  {
    "clock": "1527607750",
    "value": "2816221184"
  },
  {
    "clock": "1527607810",
    "value": "2816159744"
  },
  {
    "clock": "1527607870",
    "value": "2816253952"
  },
  {
    "clock": "1527607930",
    "value": "2816126976"
  },
  {
    "clock": "1527607990",
    "value": "2816253952"
  },
  {
    "clock": "1527608050",
    "value": "2816237568"
  },
  {
    "clock": "1527608110",
    "value": "2815983616"
  },
  {
    "clock": "1527608170",
    "value": "2816110592"
  },
  {
    "clock": "1527608230",
    "value": "2816237568"
  },
  {
    "clock": "1527608290",
    "value": "2815950848"
  },
  {
    "clock": "1527608350",
    "value": "2816126976"
  },
  {
    "clock": "1527608410",
    "value": "2814156800"
  },
  {
    "clock": "1527608471",
    "value": "2814029824"
  },
  {
    "clock": "1527608530",
    "value": "2813775872"
  },
  {
    "clock": "1527608590",
    "value": "2814156800"
  },
  {
    "clock": "1527608650",
    "value": "2814029824"
  },
  {
    "clock": "1527608710",
    "value": "2814029824"
  },
  {
    "clock": "1527608770",
    "value": "2813902848"
  },
  {
    "clock": "1527608830",
    "value": "2813775872"
  },
  {
    "clock": "1527608890",
    "value": "2814156800"
  },
  {
    "clock": "1527608950",
    "value": "2813911040"
  },
  {
    "clock": "1527609010",
    "value": "2814038016"
  },
  {
    "clock": "1527609070",
    "value": "2814169088"
  },
  {
    "clock": "1527609130",
    "value": "2820296704"
  },
  {
    "clock": "1527609190",
    "value": "2818265088"
  },
  {
    "clock": "1527609250",
    "value": "2816057344"
  },
  {
    "clock": "1527609310",
    "value": "2815901696"
  },
  {
    "clock": "1527609370",
    "value": "2816188416"
  },
  {
    "clock": "1527609430",
    "value": "2816065536"
  },
  {
    "clock": "1527609490",
    "value": "2816294912"
  },
  {
    "clock": "1527609550",
    "value": "2816454656"
  },
  {
    "clock": "1527609610",
    "value": "2816180224"
  },
  {
    "clock": "1527609670",
    "value": "2816217088"
  },
  {
    "clock": "1527609730",
    "value": "2815930368"
  },
  {
    "clock": "1527609790",
    "value": "2816188416"
  },
  {
    "clock": "1527609850",
    "value": "2816061440"
  },
  {
    "clock": "1527609910",
    "value": "2816000000"
  },
  {
    "clock": "1527609970",
    "value": "2815873024"
  },
  {
    "clock": "1527610030",
    "value": "2819825664"
  },
  {
    "clock": "1527610090",
    "value": "2817413120"
  },
  {
    "clock": "1527610150",
    "value": "2819612672"
  },
  {
    "clock": "1527610210",
    "value": "2819584000"
  },
  {
    "clock": "1527610270",
    "value": "2821525504"
  },
  {
    "clock": "1527610330",
    "value": "2821525504"
  },
  {
    "clock": "1527610390",
    "value": "2821767168"
  },
  {
    "clock": "1527610450",
    "value": "2819448832"
  },
  {
    "clock": "1527610510",
    "value": "2817355776"
  },
  {
    "clock": "1527610570",
    "value": "2821681152"
  },
  {
    "clock": "1527610630",
    "value": "2821812224"
  },
  {
    "clock": "1527610690",
    "value": "2819555328"
  },
  {
    "clock": "1527610750",
    "value": "2819244032"
  },
  {
    "clock": "1527610810",
    "value": "2819469312"
  },
  {
    "clock": "1527610870",
    "value": "2819440640"
  },
  {
    "clock": "1527610930",
    "value": "2821382144"
  },
  {
    "clock": "1527610990",
    "value": "2821607424"
  },
  {
    "clock": "1527611050",
    "value": "2819354624"
  },
  {
    "clock": "1527611110",
    "value": "2821419008"
  },
  {
    "clock": "1527611170",
    "value": "2819272704"
  },
  {
    "clock": "1527611230",
    "value": "2819137536"
  },
  {
    "clock": "1527611290",
    "value": "2819059712"
  },
  {
    "clock": "1527611350",
    "value": "2821226496"
  },
  {
    "clock": "1527611410",
    "value": "2819100672"
  },
  {
    "clock": "1527611470",
    "value": "2821177344"
  },
  {
    "clock": "1527611530",
    "value": "2818859008"
  },
  {
    "clock": "1527611590",
    "value": "2814316544"
  },
  {
    "clock": "1527611650",
    "value": "2816155648"
  },
  {
    "clock": "1527611710",
    "value": "2812190720"
  },
  {
    "clock": "1527611770",
    "value": "2821124096"
  },
  {
    "clock": "1527611830",
    "value": "2817372160"
  },
  {
    "clock": "1527611890",
    "value": "2815246336"
  },
  {
    "clock": "1527611950",
    "value": "2821275648"
  },
  {
    "clock": "1527612010",
    "value": "2814955520"
  },
  {
    "clock": "1527612070",
    "value": "2811994112"
  },
  {
    "clock": "1527612130",
    "value": "2813681664"
  },
  {
    "clock": "1527612190",
    "value": "2811334656"
  }
]
```

###  get_template



#### Description (接口描述)

得到集群下所有模板

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| ip | query | 集群的ip | Yes | String |
| port | query | 集群的端口 | Yes | String |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 


#### Request Sample (示例请求)

```
http://localhost:8080/get_template?ip=10.60.38.181&port=12000
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
[
  {
    "templateid": "10001",
    "host": "Template OS Linux"
  },
  {
    "templateid": "10047",
    "host": "Template App Zabbix Server"
  },
  {
    "templateid": "10048",
    "host": "Template App Zabbix Proxy"
  },
  {
    "templateid": "10050",
    "host": "Template App Zabbix Agent"
  },
  {
    "templateid": "10074",
    "host": "Template OS OpenBSD"
  },
  {
    "templateid": "10075",
    "host": "Template OS FreeBSD"
  },
  {
    "templateid": "10076",
    "host": "Template OS AIX"
  },
  {
    "templateid": "10077",
    "host": "Template OS HP-UX"
  },
  {
    "templateid": "10078",
    "host": "Template OS Solaris"
  },
  {
    "templateid": "10079",
    "host": "Template OS Mac OS X"
  },
  {
    "templateid": "10081",
    "host": "Template OS Windows"
  },
  {
    "templateid": "10093",
    "host": "Template App FTP Service"
  },
  {
    "templateid": "10094",
    "host": "Template App HTTP Service"
  },
  {
    "templateid": "10095",
    "host": "Template App HTTPS Service"
  },
  {
    "templateid": "10096",
    "host": "Template App IMAP Service"
  },
  {
    "templateid": "10097",
    "host": "Template App LDAP Service"
  },
  {
    "templateid": "10098",
    "host": "Template App NNTP Service"
  },
  {
    "templateid": "10099",
    "host": "Template App NTP Service"
  },
  {
    "templateid": "10100",
    "host": "Template App POP Service"
  },
  {
    "templateid": "10101",
    "host": "Template App SMTP Service"
  },
  {
    "templateid": "10102",
    "host": "Template App SSH Service"
  },
  {
    "templateid": "10103",
    "host": "Template App Telnet Service"
  },
  {
    "templateid": "10168",
    "host": "Template App Apache Tomcat JMX"
  },
  {
    "templateid": "10169",
    "host": "Template App Generic Java JMX"
  },
  {
    "templateid": "10170",
    "host": "Template DB MySQL"
  },
  {
    "templateid": "10171",
    "host": "Template Server Intel SR1530 IPMI"
  },
  {
    "templateid": "10172",
    "host": "Template Server Intel SR1630 IPMI"
  },
  {
    "templateid": "10173",
    "host": "Template VM VMware"
  },
  {
    "templateid": "10174",
    "host": "Template VM VMware Guest"
  },
  {
    "templateid": "10175",
    "host": "Template VM VMware Hypervisor"
  },
  {
    "templateid": "10182",
    "host": "Template Module EtherLike-MIB SNMPv1"
  },
  {
    "templateid": "10183",
    "host": "Template Module EtherLike-MIB SNMPv2"
  },
  {
    "templateid": "10184",
    "host": "Template Module HOST-RESOURCES-MIB SNMPv1"
  },
  {
    "templateid": "10185",
    "host": "Template Module HOST-RESOURCES-MIB SNMPv2"
  },
  {
    "templateid": "10186",
    "host": "Template Module ICMP Ping"
  },
  {
    "templateid": "10187",
    "host": "Template Module Interfaces Simple SNMPv1"
  },
  {
    "templateid": "10188",
    "host": "Template Module Interfaces Simple SNMPv2"
  },
  {
    "templateid": "10189",
    "host": "Template Module Interfaces SNMPv1"
  },
  {
    "templateid": "10190",
    "host": "Template Module Interfaces SNMPv2"
  },
  {
    "templateid": "10192",
    "host": "Template Module Interfaces Windows SNMPv2"
  },
  {
    "templateid": "10203",
    "host": "Template Module Generic SNMPv1"
  },
  {
    "templateid": "10204",
    "host": "Template Module Generic SNMPv2"
  },
  {
    "templateid": "10207",
    "host": "Template Net Alcatel Timetra TiMOS SNMPv2"
  },
  {
    "templateid": "10208",
    "host": "Template Net Brocade FC SNMPv2"
  },
  {
    "templateid": "10209",
    "host": "Template Module Brocade_Foundry Performance SNMPv2"
  },
  {
    "templateid": "10210",
    "host": "Template Net Brocade_Foundry Nonstackable SNMPv2"
  },
  {
    "templateid": "10211",
    "host": "Template Net Brocade_Foundry Stackable SNMPv2"
  },
  {
    "templateid": "10212",
    "host": "Template Module Cisco CISCO-MEMORY-POOL-MIB SNMPv2"
  },
  {
    "templateid": "10213",
    "host": "Template Module Cisco CISCO-PROCESS-MIB SNMPv2"
  },
  {
    "templateid": "10215",
    "host": "Template Module Cisco OLD-CISCO-CPU-MIB SNMPv2"
  },
  {
    "templateid": "10216",
    "host": "Template Module Cisco Inventory SNMPv2"
  },
  {
    "templateid": "10217",
    "host": "Template Module Cisco CISCO-ENVMON-MIB SNMPv2"
  },
  {
    "templateid": "10218",
    "host": "Template Net Cisco IOS SNMPv2"
  },
  {
    "templateid": "10220",
    "host": "Template Net Cisco IOS prior to 12.0_3_T SNMPv2"
  },
  {
    "templateid": "10221",
    "host": "Template Net Dell Force S-Series SNMPv2"
  },
  {
    "templateid": "10222",
    "host": "Template Net D-Link DES 7200 SNMPv2"
  },
  {
    "templateid": "10223",
    "host": "Template Net D-Link DES_DGS Switch SNMPv2"
  },
  {
    "templateid": "10224",
    "host": "Template Net Extreme EXOS SNMPv2"
  },
  {
    "templateid": "10225",
    "host": "Template Net Network Generic Device SNMPv1"
  },
  {
    "templateid": "10226",
    "host": "Template Net Network Generic Device SNMPv2"
  },
  {
    "templateid": "10227",
    "host": "Template Net HP Comware HH3C SNMPv2"
  },
  {
    "templateid": "10229",
    "host": "Template Net Huawei VRP SNMPv2"
  },
  {
    "templateid": "10230",
    "host": "Template Net Intel_Qlogic Infiniband SNMPv2"
  },
  {
    "templateid": "10231",
    "host": "Template Net Juniper SNMPv2"
  },
  {
    "templateid": "10233",
    "host": "Template Net Mikrotik SNMPv2"
  },
  {
    "templateid": "10234",
    "host": "Template Net Netgear Fastpath SNMPv2"
  },
  {
    "templateid": "10235",
    "host": "Template Net QTech QSW SNMPv2"
  },
  {
    "templateid": "10236",
    "host": "Template Net TP-LINK SNMPv2"
  },
  {
    "templateid": "10237",
    "host": "Template Net Ubiquiti AirOS SNMPv1"
  },
  {
    "templateid": "10248",
    "host": "Template OS Linux SNMPv2"
  },
  {
    "templateid": "10249",
    "host": "Template OS Windows SNMPv2"
  },
  {
    "templateid": "10250",
    "host": "Template Net HP Enterprise Switch SNMPv2"
  },
  {
    "templateid": "10251",
    "host": "Template Net Mellanox SNMPv2"
  },
  {
    "templateid": "10252",
    "host": "Template Module Cisco CISCO-PROCESS-MIB IOS versions 12.0_3_T-12.2_3.5 SNMPv2"
  },
  {
    "templateid": "10253",
    "host": "Template Net Cisco IOS versions 12.0_3_T-12.2_3.5 SNMPv2"
  }
]
```

###  hostData


#### Description (接口描述)

获取监控数据

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


#### Parameters (参数)

| Name | Located in | Description | Required | Schema |
|:-:|:-:|:-|:-:|:-|
| hostId | query | 主机的Id | Yes | String |
| timeFrom | query | 开始的时间 | Yes | String |
| timeTill | query | 终止的时间 | Yes | String |

### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 200 | Successful response | *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 
| 404 | Not Found | *name* : string | 

#### Request Sample (示例请求)

```
http://localhost:8080/hostData?hostId=10255&timeFrom=1525175989&timeTill=1527139324
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body

```
no content
```

###  host


#### Description (接口描述)

获取监控主机

| | |
|-|-|
| Request Method | Get |
| Authorization | Required |


### Responses (返回结果)

| Code | Description | Schema |
|:----:|:--------|:--|
| 404 | Not Found| *name* : string | 
| 401 | Unauthorized | *name* : string | 
| 403 | Forbidden | *name* : string | 

#### Request Sample (示例请求)

```
http://localhost:8080/hosts
```

#### Response Sample (示例结果)

##### Request Headers

```

{
  "Accept": "*/*"
}

```
##### Request Body


```
[
  {
    "hostId": "10254",
    "host": "host02",
    "description": ""
  },
  {
    "hostId": "10255",
    "host": "host01",
    "description": ""
  },
  {
    "hostId": "10259",
    "host": "ubuntu40",
    "description": ""
  },
  {
    "hostId": "10084",
    "host": "Zabbix server",
    "description": ""
  }
]
```
