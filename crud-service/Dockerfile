# 使用阿里云提供的完整 JDK 镜像
FROM crpi-xxrtggj57h8kwbz2.cn-hangzhou.personal.cr.aliyuncs.com/cloud-native-practice/zulu-jdk:17

LABEL maintainer="me"

ENV JAVA_ARGS="-Dfile.encoding=UTF-8 -Duser.timezone=GMT+08"
ENV JAR_FILE="crud-service.jar"

# 复制 jar 包
COPY ./target/${JAR_FILE} /app/${JAR_FILE}

WORKDIR /app

# 容器暴露的端口，和 spring boot 配置的端口保持一致
EXPOSE 8010

# 运行命令，支持从外部传入 spring.profiles.active
CMD ["sh", "-c", "java $JAVA_ARGS -jar ${JAR_FILE}"]
