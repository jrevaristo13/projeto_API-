# Usa uma imagem do Java 17 (leve e rápida)
FROM eclipse-temurin:17-jdk-alpine

# Define a pasta de trabalho dentro do servidor
WORKDIR /app

# Copia todos os arquivos do seu computador para o servidor
COPY . .

# Dá permissão para o Maven rodar e compila o projeto
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Expõe a porta que o Spring usa
EXPOSE 8080

# Comando para ligar a API
CMD ["java", "-jar", "target/user-management-api-0.0.1-SNAPSHOT.jar"]