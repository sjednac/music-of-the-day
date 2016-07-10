# music-of-the-day

A simple web service written in **Clojure**.

## Docker Deployment

Prepare the Docker image using the [uberimage](lein-uberimage) plugin:

    lein uberimage

Run the container:

    docker run --rm --name=motd -p 8080:8080 sbilinski/music-of-the-day
