# 用maven image作為基礎image，用於編譯java
FROM maven:3.6.3-openjdk-8 as builder

WORKDIR /home/app
# 將整個目錄複製到/home/app下

COPY . /home/app/

# 進入pom.xml所在目錄執行建構指令，指定m2/settings.xml文件作為配置文件，
# 請在settings.xml中配置好伺服，否則建構速度極慢
RUN cd function && mvn clean package -U -DskipTests --settings ./m2/settings.xml 

# of-watchdog裡面有二進制文件watchdog，製作image時要用到
FROM openfaas/of-watchdog:0.8.2 as watchdog

# openjdk image是容器的運行環境
FROM openjdk:8-jre-slim as ship

# 為了安全起見，在生產環境運行容器時不要用root帳號和群組
RUN addgroup --system app \
    && adduser --system --ingroup app app

# 從of-watchdog image中複製二進制文件fwatchdog，這是容器的啟動程序
COPY --from=watchdog /fwatchdog /usr/bin/fwatchdog

# 賦予可執行的權限
RUN chmod +x /usr/bin/fwatchdog

WORKDIR /home/app

# 前面用maven編譯構建完畢後，這裡將構建結果複製到image中
COPY --from=builder /home/app/function/target/java8maven-1.0-SNAPSHOT-jar-with-dependencies.jar ./java8maven-1.0-SNAPSHOT-jar-with-dependencies.jar
# 指定容器的運行帳號
user app

# 指定容器的工作目錄
WORKDIR /home/app/

# fwatchdog收到web請求後的轉發地址，java process 監聽的就是這個端口
ENV upstream_url="http://127.0.0.1:8082"

# 運行模式是http
ENV mode="http"

# pull prcess的命令，這裡是啟動java prcess
ENV fprocess="java -jar java8maven-1.0-SNAPSHOT-jar-with-dependencies.jar"

# 容器對外暴露的端口，也就是fwatchdog進程監聽的端口
EXPOSE 8080

# 健康檢查
HEALTHCHECK --interval=5s CMD [ -e /tmp/.lock ] || exit 1

# 容器啟動命令，這裡是執行二進制文件fwatchdog
CMD ["fwatchdog"]