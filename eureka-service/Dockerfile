# 使用阿里云提供的完整JDK镜像
FROM azul/zulu-openjdk-alpine:17-jre

LABEL maintainer="me"

# 这里用 ENV 定义变量，引用时用 $ 但最好不要在 CMD 里直接展开变量，避免 shell 解析问题
ENV JAVA_ARGS="-Dfile.encoding=UTF-8 -Duser.timezone=GMT+08"
ENV JAR_FILE="eureka-service.jar"

# 拷贝 jar 文件到 /app 目录，确保 target 目录下有这个文件
COPY ./target/${JAR_FILE} /app/${JAR_FILE}

WORKDIR /app

EXPOSE 8888

# CMD 最好用数组格式，避免 shell 解析问题，同时把环境变量改成具体值，或用 ENTRYPOINT 配合参数
CMD ["java", "-Dfile.encoding=UTF-8", "-Duser.timezone=GMT+08", "-jar", "eureka-service.jar"]
