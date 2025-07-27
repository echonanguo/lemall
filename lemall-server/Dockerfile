# 官方 OpenJDK 17 基础镜像
FROM eclipse-temurin:17-jdk-jammy
# 设置工作目录
WORKDIR /app
# 将构建的 JAR 文件复制到容器中
COPY lemall-app-main/target/*.jar app.jar
# 暴露应用运行的端口
EXPOSE 8080
# JVM 参数
ENV JAVA_OPTS=""
# 启动应用
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -Dspring.profiles.active=prod -jar app.jar"]