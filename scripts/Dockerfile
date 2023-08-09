# Use the official MySQL image as the base image
FROM mysql:latest

# Set environment variables for MySQL configuration
ENV MYSQL_ROOT_PASSWORD=mysecretpassword
ENV MYSQL_DATABASE=mydatabase
ENV MYSQL_USER=mydbuser
ENV MYSQL_PASSWORD=mydbpassword

# Copy SQL scripts into the container
COPY ./sql/ /docker-entrypoint-initdb.d/

# Expose the MySQL port
EXPOSE 3306

# This is optional, you can give your image a description
LABEL description="MySQL Container with custom configuration"

# The CMD instruction is used to specify the command that should be executed when the container starts
CMD ["mysqld"]