## 自定義OpenFaaS-java8-maven模板自定義OpenFaaS-java8-maven模板
### 資料結構:

[template
&emsp;&emsp;├─java8-maven
&emsp;&emsp;&emsp;&emsp;├── Dockerfile
&emsp;&emsp;&emsp;&emsp;├── function
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;├── m2
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;└── settings.xml
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;├── pom.xml
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;└── src
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── main
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── java
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── com
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── openfaas
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── function
&emsp;&emsp;&emsp;&emsp;│&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;└── Handler.java
&emsp;&emsp;&emsp;&emsp;└── template.yml


##### Handler.java的功能：透過請求，回應'Hello World'訊息Handler.java的功能：透過請求，回應'Hello World'訊息
### 安裝 faas-cli
<code>curl -sSL https://cli.openfaas.com | sudo -E sh</code>>
### 透過faas下載template
<code>faas template pull  https://github.com/sighfor1314/java8-marven></code>